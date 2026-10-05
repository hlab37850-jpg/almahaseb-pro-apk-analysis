package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.printer.FirmwareUpdateHandlerBase;
import com.zebra.sdk.printer.ZebraPrinterFactory;

/* JADX INFO: loaded from: classes3.dex */
public class FirmwareDownloadRunnable implements Runnable {
    private Exception exceptionCaughtDuringRun = null;
    private String firmwareFilePath;
    private FirmwareUpdateHandlerBase handler;
    private Connection zebraPrinterConnection;

    public FirmwareDownloadRunnable(Connection connection, String str, FirmwareUpdateHandlerBase firmwareUpdateHandlerBase) {
        this.zebraPrinterConnection = connection;
        this.firmwareFilePath = str;
        this.handler = firmwareUpdateHandlerBase;
    }

    public boolean exceptionOccured() {
        return this.exceptionCaughtDuringRun != null;
    }

    public String getExceptionMessage() {
        return this.exceptionCaughtDuringRun.getMessage();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ZebraPrinterFactory.getInstance(this.zebraPrinterConnection).sendFileContents(this.firmwareFilePath, new ProgressMonitor() { // from class: com.zebra.sdk.printer.internal.FirmwareDownloadRunnable.1
                @Override // com.zebra.sdk.device.ProgressMonitor
                public void updateProgress(int i, int i2) {
                    FirmwareDownloadRunnable.this.handler.progressUpdate(i, i2);
                }
            });
        } catch (Exception e) {
            this.exceptionCaughtDuringRun = e;
            if (this.zebraPrinterConnection.isConnected()) {
                try {
                    this.zebraPrinterConnection.close();
                } catch (ConnectionException unused) {
                }
            }
        }
    }
}
