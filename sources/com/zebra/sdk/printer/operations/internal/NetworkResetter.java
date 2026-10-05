package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.SGDUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkResetter extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = 528595430131941491L;

    public NetworkResetter(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    private void resetPrinter() {
        if (isPrintingChannelInLineMode()) {
            SGD.SET(SGDUtilities.NETWORK_RESET, "y", this.connection);
        } else {
            new PrinterCommandImpl(SGDUtilities.NETWORK_RESET_JSON).sendAndWaitForValidJsonResponse(this.connection);
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() {
        selectStatusChannelIfOpen();
        resetPrinter();
        return null;
    }
}
