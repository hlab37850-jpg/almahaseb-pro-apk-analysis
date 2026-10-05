package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.internal.PrinterStatusLinkOs;
import com.zebra.sdk.util.internal.SGDUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class HostStatusOperation extends PrinterOperationBase<PrinterStatus> {
    private static final long serialVersionUID = -2144445242818129134L;

    public HostStatusOperation(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public PrinterStatus execute() {
        selectStatusChannelIfOpen();
        return isPrintingChannelInLineMode() ? new PrinterStatusLinkOs(this.connection) { // from class: com.zebra.sdk.printer.operations.internal.HostStatusOperation.1
            @Override // com.zebra.sdk.printer.internal.PrinterStatusLinkOs, com.zebra.sdk.printer.internal.PrinterStatusZpl
            public byte[] getStatusInfoFromPrinter() {
                return HostStatusOperation.this.connection.sendAndWaitForResponse(SGDUtilities.decorateWithGetCommand(SGDUtilities.HOST_STATUS).getBytes(), HostStatusOperation.this.connection.getMaxTimeoutForRead(), HostStatusOperation.this.connection.getTimeToWaitForMoreData(), null);
            }
        } : new PrinterStatusLinkOs(this.connection);
    }
}
