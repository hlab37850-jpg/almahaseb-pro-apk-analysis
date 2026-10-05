package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.SGDUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterDefaulter extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = -1651137607285743834L;

    public PrinterDefaulter(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    private void defaultPrinter() {
        if (isPrintingChannelInLineMode()) {
            SGD.SET(SGDUtilities.PRINTER_DEFAULT, "reload printer", this.connection);
        } else {
            new PrinterCommandImpl(SGDUtilities.PRINTER_DEFAULT_JSON).sendAndWaitForValidJsonResponse(this.connection);
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() {
        selectStatusChannelIfOpen();
        defaultPrinter();
        return null;
    }
}
