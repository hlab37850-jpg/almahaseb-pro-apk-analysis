package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.ZplPrintMode;
import com.zebra.sdk.util.internal.CPCLUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterStatusCpcl extends PrinterStatus {
    public PrinterStatusCpcl(Connection connection) {
        super(connection);
    }

    @Override // com.zebra.sdk.printer.PrinterStatus
    public void updateStatus() throws ConnectionException {
        byte[] bArrSendAndWaitForResponse = new PrinterCommandImpl(CPCLUtilities.PRINTER_STATUS).sendAndWaitForResponse(this.printerConnection);
        if (bArrSendAndWaitForResponse.length != 1) {
            throw new ConnectionException("Malformed status response - unable to determine printer status (received " + bArrSendAndWaitForResponse.length + " bytes)");
        }
        this.labelsRemainingInBatch = 0;
        this.numberOfFormatsInReceiveBuffer = 0;
        this.isPartialFormatInProgress = false;
        this.isHeadCold = false;
        byte b = bArrSendAndWaitForResponse[0];
        this.isHeadOpen = (b & 4) == 4;
        this.isHeadTooHot = false;
        this.isPaperOut = (b & 2) == 2;
        this.isRibbonOut = false;
        this.isReceiveBufferFull = false;
        this.isPaused = false;
        this.labelLengthInDots = 0;
        this.printMode = ZplPrintMode.UNKNOWN;
    }
}
