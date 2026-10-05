package com.zebra.android.printer.internal;

import com.zebra.android.printer.PrinterStatus;
import com.zebra.sdk.printer.ZebraPrinter;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterStatusLegacy extends PrinterStatus {
    public PrinterStatusLegacy() {
        super(null);
    }

    public PrinterStatus getOldStatus(ZebraPrinter zebraPrinter) {
        return super.convertStatuses(zebraPrinter);
    }
}
