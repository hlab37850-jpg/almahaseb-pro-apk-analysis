package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.SGDUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterCalibrator extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = 1167328077849083227L;

    public PrinterCalibrator(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    private void calibrate() {
        if (isPrintingChannelInLineMode()) {
            SGD.SET(SGDUtilities.CALIBRATE_PRINTER, "", this.connection);
        } else {
            new PrinterCommandImpl(SGDUtilities.CALIBRATE_PRINTER_JSON).sendAndWaitForValidJsonResponse(this.connection);
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() {
        selectStatusChannelIfOpen();
        calibrate();
        return null;
    }
}
