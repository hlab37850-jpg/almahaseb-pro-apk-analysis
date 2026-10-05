package com.zebra.sdk.printer.internal;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.MultichannelTcpConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.FirmwareUpdateHandler;
import com.zebra.sdk.printer.FirmwareUpdateHandlerBase;
import com.zebra.sdk.printer.FirmwareUpdaterLinkOs;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import com.zebra.sdk.util.internal.ReflectionUtil;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.Sleeper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class FirmwareUpdaterLinkOsBase implements FirmwareUpdaterLinkOs {
    private static final int MIN_TIMEOUT_MS = 600000;
    private String firmwareFilePath;
    protected Connection zebraPrinterConnection;

    public final class SinglePrinterDiscoveryHandler implements DiscoveryHandler {
        public boolean isFinished = false;
        public DiscoveredPrinter printer;

        private SinglePrinterDiscoveryHandler() {
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void discoveryError(String str) {
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void discoveryFinished() {
            this.isFinished = true;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
            this.printer = discoveredPrinter;
            this.isFinished = true;
        }
    }

    public FirmwareUpdaterLinkOsBase(ZebraPrinterLinkOs zebraPrinterLinkOs) {
        this.zebraPrinterConnection = zebraPrinterLinkOs.getConnection();
    }

    private void downloadFwViaThreadAndWaitForFailure(long j, FirmwareUpdateHandlerBase firmwareUpdateHandlerBase) throws ZebraIllegalArgumentException, ConnectionException {
        Connection connectionBuild = ConnectionBuilderInternal.build(getConnectionString());
        FirmwareDownloadRunnable firmwareDownloadRunnable = new FirmwareDownloadRunnable(this.zebraPrinterConnection, this.firmwareFilePath, firmwareUpdateHandlerBase);
        Thread thread = new Thread(firmwareDownloadRunnable);
        thread.start();
        connectionBuild.open();
        while (System.currentTimeMillis() < j && thread.isAlive()) {
            Sleeper.sleep(2500L);
            connectionBuild.write(SGDUtilities.decorateWithGetCommand(SGDUtilities.HOST_STATUS).getBytes());
            if (connectionBuild.read() != null) {
                connectionBuild.write(SGDUtilities.decorateWithGetCommand(SGDUtilities.DEVICE_RESET).getBytes());
                connectionBuild.close();
                throw new ZebraIllegalArgumentException("Firmware not accepted by printer, rebooting printer.  Please verify firmware is valid.");
            }
        }
        connectionBuild.close();
        if (firmwareDownloadRunnable.exceptionOccured()) {
            throw new ConnectionException(firmwareDownloadRunnable.getExceptionMessage());
        }
    }

    private boolean firmwareVersionsDontMatch(String str) throws ConnectionException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            boolean zFirmwareVersionsDontMatch = FirmwareUtil.firmwareVersionsDontMatch(fileInputStream, this.zebraPrinterConnection);
            try {
                fileInputStream.close();
                return zFirmwareVersionsDontMatch;
            } catch (IOException e) {
                throw new ConnectionException(e.getLocalizedMessage());
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                throw th;
            } catch (IOException e2) {
                throw new ConnectionException(e2.getLocalizedMessage());
            }
        }
    }

    private boolean isOnlySettingsChannelOpen(MultichannelConnection multichannelConnection) {
        return multichannelConnection.getStatusChannel().isConnected() && !multichannelConnection.getPrintingChannel().isConnected();
    }

    private void throwExceptionStatusOnly() throws ConnectionException {
        Connection connection = this.zebraPrinterConnection;
        if (connection instanceof MultichannelConnection) {
            if (isOnlySettingsChannelOpen((MultichannelConnection) connection)) {
                throw new ConnectionException("Cannot upgrade firmware with only the status channel open");
            }
        } else if (connection instanceof StatusConnection) {
            throw new ConnectionException("Cannot upgrade firmware on the status channel");
        }
    }

    private void timeoutCheck(long j) throws TimeoutException {
        if (System.currentTimeMillis() <= j) {
            return;
        }
        throw new TimeoutException("Firmware downloader timed out waiting for '" + this.zebraPrinterConnection + "' to come back online");
    }

    public void doFwDownload(String str, long j, final FirmwareUpdateHandler firmwareUpdateHandler) throws ZebraIllegalArgumentException, TimeoutException, ConnectionException {
        ZebraPrinter zebraPrinterFactory;
        ProgressMonitor progressMonitor;
        ConnectionReestablisher connectionReestablisher = this.zebraPrinterConnection.getConnectionReestablisher(180000L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j < 600000) {
            j = 600000;
        }
        long j2 = jCurrentTimeMillis + j;
        boolean zIsDriverConnection = ReflectionUtil.isDriverConnection(this.zebraPrinterConnection);
        boolean zIsUsbConnection = ReflectionUtil.isUsbConnection(this.zebraPrinterConnection);
        this.firmwareFilePath = str;
        if (isTcpConnection()) {
            downloadFwViaThreadAndWaitForFailure(j2, firmwareUpdateHandler);
        } else {
            Connection connection = this.zebraPrinterConnection;
            if (connection instanceof MultichannelTcpConnection) {
                zebraPrinterFactory = ZebraPrinterFactory.getInstance(connection);
                progressMonitor = new ProgressMonitor() { // from class: com.zebra.sdk.printer.internal.FirmwareUpdaterLinkOsBase.1
                    @Override // com.zebra.sdk.device.ProgressMonitor
                    public void updateProgress(int i, int i2) {
                        firmwareUpdateHandler.progressUpdate(i, i2);
                    }
                };
            } else {
                boolean z = connection instanceof MultichannelConnection;
                zebraPrinterFactory = ZebraPrinterFactory.getInstance(connection);
                progressMonitor = z ? new ProgressMonitor() { // from class: com.zebra.sdk.printer.internal.FirmwareUpdaterLinkOsBase.2
                    @Override // com.zebra.sdk.device.ProgressMonitor
                    public void updateProgress(int i, int i2) {
                        firmwareUpdateHandler.progressUpdate(i, i2);
                    }
                } : new ProgressMonitor() { // from class: com.zebra.sdk.printer.internal.FirmwareUpdaterLinkOsBase.3
                    @Override // com.zebra.sdk.device.ProgressMonitor
                    public void updateProgress(int i, int i2) {
                        firmwareUpdateHandler.progressUpdate(i, i2);
                    }
                };
            }
            zebraPrinterFactory.sendFileContents(str, progressMonitor);
        }
        firmwareUpdateHandler.firmwareDownloadComplete();
        if (zIsDriverConnection || zIsUsbConnection) {
            this.zebraPrinterConnection.close();
            Sleeper.sleep(90000L);
        } else {
            Sleeper.sleep(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            waitForPrinterToGoOffline(j2);
            this.zebraPrinterConnection.close();
        }
        connectionReestablisher.reestablishConnection(firmwareUpdateHandler);
    }

    public String getConnectionAddress() {
        Connection printingChannel = this.zebraPrinterConnection;
        if (!(printingChannel instanceof TcpConnection)) {
            if (!(printingChannel instanceof MultichannelTcpConnection)) {
                return "";
            }
            printingChannel = ((MultichannelTcpConnection) printingChannel).getPrintingChannel();
        }
        return ((TcpConnection) printingChannel).getAddress();
    }

    public String getConnectionPortNumber() {
        return ((TcpConnection) this.zebraPrinterConnection).getPortNumber();
    }

    public String getConnectionString() {
        return "TCP:" + getConnectionAddress() + ":" + getConnectionPortNumber();
    }

    public boolean isTcpConnection() {
        return this.zebraPrinterConnection instanceof TcpConnection;
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmware(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler) throws ZebraIllegalArgumentException, TimeoutException, ConnectionException, FileNotFoundException {
        updateFirmware(str, j, firmwareUpdateHandler, false);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmwareUnconditionally(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler) throws ZebraIllegalArgumentException, TimeoutException, ConnectionException, FileNotFoundException {
        updateFirmware(str, j, firmwareUpdateHandler, true);
    }

    public void waitForPrinterToGoOffline(long j) throws TimeoutException {
        while (true) {
            Sleeper.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            try {
                byte[] bArrSendAndWaitForResponse = this.zebraPrinterConnection.sendAndWaitForResponse(SGDUtilities.decorateWithGetCommand(SGDUtilities.APPL_NAME).getBytes(), 5000, 5000, null);
                if (bArrSendAndWaitForResponse == null || bArrSendAndWaitForResponse.length == 0) {
                    return;
                } else {
                    timeoutCheck(j);
                }
            } catch (ConnectionException unused) {
                return;
            }
        }
    }

    private void updateFirmware(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler, boolean z) throws ZebraIllegalArgumentException, TimeoutException, ConnectionException, FileNotFoundException {
        if (!new File(str).exists()) {
            throw new FileNotFoundException(str + " does not exist.");
        }
        throwExceptionStatusOnly();
        if (z || firmwareVersionsDontMatch(str)) {
            doFwDownload(str, j, firmwareUpdateHandler);
        } else {
            firmwareUpdateHandler.firmwareDownloadComplete();
            firmwareUpdateHandler.printerOnline(ZebraPrinterFactory.getLinkOsPrinter(this.zebraPrinterConnection), FirmwareUtil.getFWVersionFromPrinterConnection(this.zebraPrinterConnection).trim());
        }
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmwareUnconditionally(String str, FirmwareUpdateHandler firmwareUpdateHandler) throws ZebraIllegalArgumentException, TimeoutException, ConnectionException, FileNotFoundException {
        updateFirmware(str, 600000L, firmwareUpdateHandler, true);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmware(String str, FirmwareUpdateHandler firmwareUpdateHandler) throws ZebraIllegalArgumentException, TimeoutException, ConnectionException, FileNotFoundException {
        updateFirmware(str, 600000L, firmwareUpdateHandler, false);
    }
}
