package com.zebra.android.sgd;

import com.zebra.android.comm.ZebraPrinterConnection;
import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.sdk.comm.ConnectionException;

/* JADX INFO: loaded from: classes3.dex */
public class SGD {
    private SGD() {
    }

    public static String DO(String str, String str2, ZebraPrinterConnection zebraPrinterConnection) throws ZebraPrinterConnectionException {
        try {
            return com.zebra.sdk.printer.SGD.DO(str, str2, zebraPrinterConnection.getConvertedNewStyleConnection());
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    public static String GET(String str, ZebraPrinterConnection zebraPrinterConnection) throws ZebraPrinterConnectionException {
        try {
            return com.zebra.sdk.printer.SGD.GET(str, zebraPrinterConnection.getConvertedNewStyleConnection());
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    public static void SET(String str, int i, ZebraPrinterConnection zebraPrinterConnection) throws ZebraPrinterConnectionException {
        try {
            com.zebra.sdk.printer.SGD.SET(str, i, zebraPrinterConnection.getConvertedNewStyleConnection());
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    public static String DO(String str, String str2, ZebraPrinterConnection zebraPrinterConnection, int i, int i2) throws ZebraPrinterConnectionException {
        try {
            return com.zebra.sdk.printer.SGD.DO(str, str2, zebraPrinterConnection.getConvertedNewStyleConnection(), i, i2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    public static String GET(String str, ZebraPrinterConnection zebraPrinterConnection, int i, int i2) throws ZebraPrinterConnectionException {
        try {
            return com.zebra.sdk.printer.SGD.GET(str, zebraPrinterConnection.getConvertedNewStyleConnection(), i, i2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    public static void SET(String str, String str2, ZebraPrinterConnection zebraPrinterConnection) throws ZebraPrinterConnectionException {
        try {
            com.zebra.sdk.printer.SGD.SET(str, str2, zebraPrinterConnection.getConvertedNewStyleConnection());
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
