package com.zebra.sdk.device;

import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.internal.SmartcardReaderImpl;
import com.zebra.sdk.printer.internal.ZebraPrinterCpcl;

/* JADX INFO: loaded from: classes3.dex */
public class SmartcardReaderFactory {
    private SmartcardReaderFactory() {
    }

    public static SmartcardReader create(ZebraPrinter zebraPrinter) {
        if (zebraPrinter instanceof ZebraPrinterCpcl) {
            return new SmartcardReaderImpl(zebraPrinter);
        }
        return null;
    }
}
