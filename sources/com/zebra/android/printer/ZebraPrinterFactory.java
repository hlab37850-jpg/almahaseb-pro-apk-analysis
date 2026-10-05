package com.zebra.android.printer;

import com.zebra.android.comm.ZebraPrinterConnection;
import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.internal.ZebraPrinterLegacyDelegator;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.internal.ZebraPrinterCpcl;
import com.zebra.sdk.printer.internal.ZebraPrinterZpl;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterFactory {
    private ZebraPrinterFactory() {
    }

    public static ZebraPrinter getInstance(ZebraPrinterConnection zebraPrinterConnection) throws ZebraPrinterConnectionException, ZebraPrinterLanguageUnknownException {
        try {
            return new ZebraPrinterLegacyDelegator(com.zebra.sdk.printer.ZebraPrinterFactory.getInstance(zebraPrinterConnection.getConvertedNewStyleConnection()));
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        } catch (com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException e2) {
            throw new ZebraPrinterLanguageUnknownException(e2.getLocalizedMessage());
        }
    }

    public static ZebraPrinter getInstance(PrinterLanguage printerLanguage, ZebraPrinterConnection zebraPrinterConnection) {
        return printerLanguage == PrinterLanguage.CPCL ? new ZebraPrinterLegacyDelegator(new ZebraPrinterCpcl(zebraPrinterConnection.getConvertedNewStyleConnection(), com.zebra.sdk.printer.PrinterLanguage.CPCL)) : new ZebraPrinterLegacyDelegator(new ZebraPrinterZpl(zebraPrinterConnection.getConvertedNewStyleConnection()));
    }

    public static ZebraPrinter getInstance(String[] strArr, ZebraPrinterConnection zebraPrinterConnection) throws ZebraPrinterConnectionException, ZebraPrinterLanguageUnknownException {
        try {
            return new ZebraPrinterLegacyDelegator(com.zebra.sdk.printer.ZebraPrinterFactory.getInstance(strArr, zebraPrinterConnection.getConvertedNewStyleConnection()));
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        } catch (com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException e2) {
            throw new ZebraPrinterLanguageUnknownException(e2.getLocalizedMessage());
        }
    }
}
