package com.zebra.android.printer.internal;

import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.MagCardReader;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.internal.MagCardReaderImpl;

/* JADX INFO: loaded from: classes3.dex */
public class MagCardReaderLegacy implements MagCardReader {
    private com.zebra.sdk.device.MagCardReader newTypeMagCardReader;

    public MagCardReaderLegacy(ZebraPrinter zebraPrinter) {
        if (zebraPrinter.getPrinterControlLanguage() == PrinterLanguage.CPCL) {
            this.newTypeMagCardReader = new MagCardReaderImpl(zebraPrinter);
        }
    }

    @Override // com.zebra.android.printer.MagCardReader
    public String[] read(int i) throws ZebraPrinterConnectionException {
        try {
            return this.newTypeMagCardReader.read(i);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
