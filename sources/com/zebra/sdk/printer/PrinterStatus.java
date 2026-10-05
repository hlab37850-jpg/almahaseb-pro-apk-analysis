package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrinterStatus {
    public boolean isHeadOpen;
    public boolean isHeadTooHot;
    public boolean isPaperOut;
    public boolean isPaused;
    public boolean isReadyToPrint;
    public boolean isReceiveBufferFull;
    public boolean isRibbonOut;
    protected Connection printerConnection;
    private boolean statusHasBeenRetrievedFromPrinter = false;
    public int numberOfFormatsInReceiveBuffer = 0;
    public int labelsRemainingInBatch = 0;
    public boolean isPartialFormatInProgress = false;
    public boolean isHeadCold = false;
    public ZplPrintMode printMode = ZplPrintMode.UNKNOWN;
    public int labelLengthInDots = 0;

    public PrinterStatus(Connection connection) {
        this.printerConnection = connection;
        getStatusFromPrinter();
    }

    private void getStatusFromPrinter() {
        if (this.statusHasBeenRetrievedFromPrinter) {
            return;
        }
        updateStatus();
        this.statusHasBeenRetrievedFromPrinter = true;
        this.isReadyToPrint = (true ^ this.isRibbonOut) & (!this.isPaperOut) & (!this.isPaused) & (!this.isReceiveBufferFull) & (!this.isHeadTooHot) & (!this.isHeadOpen);
    }

    public abstract void updateStatus();
}
