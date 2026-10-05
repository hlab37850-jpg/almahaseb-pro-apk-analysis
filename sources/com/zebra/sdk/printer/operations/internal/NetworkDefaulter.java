package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.SGDUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkDefaulter extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = -3553465374920412924L;

    public NetworkDefaulter(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    private void resetPrinter() {
        if (isPrintingChannelInLineMode()) {
            SGD.SET(SGDUtilities.NETWORK_DEFAULT, "y", this.connection);
        } else {
            new PrinterCommandImpl(SGDUtilities.NETWORK_DEFAULT_JSON).sendAndWaitForValidJsonResponse(this.connection);
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() {
        selectStatusChannelIfOpen();
        resetPrinter();
        return null;
    }
}
