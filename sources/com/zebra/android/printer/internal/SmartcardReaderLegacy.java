package com.zebra.android.printer.internal;

import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.SmartcardReader;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.internal.SmartcardReaderImpl;

/* JADX INFO: loaded from: classes3.dex */
public class SmartcardReaderLegacy implements SmartcardReader {
    private com.zebra.sdk.device.SmartcardReader newTypeSmartcardReader;

    public SmartcardReaderLegacy(ZebraPrinter zebraPrinter) {
        if (zebraPrinter.getPrinterControlLanguage() == PrinterLanguage.CPCL) {
            this.newTypeSmartcardReader = new SmartcardReaderImpl(zebraPrinter);
        }
    }

    @Override // com.zebra.android.printer.SmartcardReader
    public void close() throws ZebraPrinterConnectionException {
        try {
            this.newTypeSmartcardReader.close();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.SmartcardReader
    public byte[] doCommand(String str) throws ZebraPrinterConnectionException {
        try {
            return this.newTypeSmartcardReader.doCommand(str);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.SmartcardReader
    public byte[] getATR() throws ZebraPrinterConnectionException {
        try {
            return this.newTypeSmartcardReader.getATR();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
