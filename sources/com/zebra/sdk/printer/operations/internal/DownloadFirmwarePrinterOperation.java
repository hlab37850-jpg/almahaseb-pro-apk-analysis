package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.printer.FirmwareUpdateHandlerBase;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.util.internal.FileUtilities;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFirmwarePrinterOperation extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = -856246879624951690L;
    private int fileSize;
    private InputStream firmwareInputStream;
    private FirmwareUpdateHandlerBase handler;

    public DownloadFirmwarePrinterOperation(Connection connection, InputStream inputStream, int i, PrinterLanguage printerLanguage, FirmwareUpdateHandlerBase firmwareUpdateHandlerBase) {
        super(connection, printerLanguage);
        this.firmwareInputStream = inputStream;
        this.fileSize = i;
        this.handler = firmwareUpdateHandlerBase;
    }

    private void isOkToProceed() throws ConnectionException {
        Connection connection = this.connection;
        if (connection instanceof StatusConnection) {
            throw new ConnectionException("Cannot download firmware over status channel");
        }
        if (!connection.isConnected()) {
            throw new ConnectionException("The connection is not an open printing channel");
        }
    }

    private void updateFirmwareUnconditionallyNoReconnect() throws ConnectionException {
        FileUtilities.sendFileContentsInChunks(this.connection, new ProgressMonitor() { // from class: com.zebra.sdk.printer.operations.internal.DownloadFirmwarePrinterOperation.1
            @Override // com.zebra.sdk.device.ProgressMonitor
            public void updateProgress(int i, int i2) {
                DownloadFirmwarePrinterOperation.this.handler.progressUpdate(i, i2);
            }
        }, this.firmwareInputStream, this.fileSize);
        this.handler.firmwareDownloadComplete();
        this.connection.close();
    }

    public void selectProperChannel() {
        Connection connection = this.connection;
        if (connection instanceof MultichannelConnection) {
            this.connection = ((MultichannelConnection) connection).getPrintingChannel();
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        updateFirmwareUnconditionallyNoReconnect();
        return null;
    }
}
