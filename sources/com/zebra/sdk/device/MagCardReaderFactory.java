package com.zebra.sdk.device;

import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.internal.MagCardReaderImpl;
import com.zebra.sdk.printer.internal.ZebraPrinterCpcl;

/* JADX INFO: loaded from: classes3.dex */
public class MagCardReaderFactory {
    private MagCardReaderFactory() {
    }

    public static MagCardReader create(ZebraPrinter zebraPrinter) {
        if (zebraPrinter instanceof ZebraPrinterCpcl) {
            return new MagCardReaderImpl(zebraPrinter);
        }
        return null;
    }
}
