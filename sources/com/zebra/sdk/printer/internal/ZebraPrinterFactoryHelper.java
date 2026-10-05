package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.settings.internal.ConnectionUtil;
import com.zebra.sdk.util.internal.CPCLUtilities;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterFactoryHelper {
    private ZebraPrinterFactoryHelper() {
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter) {
        if (zebraPrinter instanceof ZebraPrinterCpcl) {
            return null;
        }
        return new LinkOsPrinterCreatorSgdOrJson(zebraPrinter.getPrinterControlLanguage()).create(zebraPrinter);
    }

    private static String getApplNameHocusPocus(Connection connection) {
        int i = 0;
        String strGET = "";
        while (strGET.length() == 0) {
            int i2 = i + 1;
            if (i >= 10) {
                break;
            }
            strGET = SGD.GET(SGDUtilities.APPL_NAME, connection);
            i = i2;
        }
        String strGET2 = SGD.GET(SGDUtilities.APPL_NAME, connection);
        return strGET2.length() > 0 ? strGET2 : strGET;
    }

    public static ZebraPrinter getInstance(Connection connection) {
        return getInstance(CPCLUtilities.VERSION_PREFIXES, connection);
    }

    private static PrinterLanguage getLanguage(Connection connection, String[] strArr) throws ZebraPrinterLanguageUnknownException, ConnectionException {
        PrinterLanguage printerLanguage = PrinterLanguage.ZPL;
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        if (!connectionSelectConnection.isConnected()) {
            throw new ConnectionException("Connection is not open.");
        }
        String applNameHocusPocus = getApplNameHocusPocus(connectionSelectConnection);
        if (applNameHocusPocus.length() != 0) {
            return StringUtilities.doesPrefixExistInArray(strArr, applNameHocusPocus) ? PrinterLanguage.CPCL : printerLanguage;
        }
        throw new ZebraPrinterLanguageUnknownException("");
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection) {
        return new LinkOsPrinterCreatorSgdOrJson((PrinterLanguage) null).create(connection);
    }

    private static ZebraPrinter getPrinterInstance(Connection connection, PrinterLanguage printerLanguage) {
        return (printerLanguage == PrinterLanguage.CPCL || printerLanguage == PrinterLanguage.LINE_PRINT) ? new ZebraPrinterCpcl(connection, printerLanguage) : new ZebraPrinterZpl(connection);
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter, LinkOsInformation linkOsInformation) {
        return new LinkOsPrinterCreatorSgdOrJson(linkOsInformation).create(zebraPrinter);
    }

    public static ZebraPrinter getInstance(PrinterLanguage printerLanguage, Connection connection) {
        return getPrinterInstance(connection, printerLanguage);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection, LinkOsInformation linkOsInformation) {
        return new LinkOsPrinterCreatorSgdOrJson(linkOsInformation).create(connection);
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter, LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        if ((zebraPrinter instanceof ZebraPrinterCpcl) && zebraPrinter.getPrinterControlLanguage() == PrinterLanguage.CPCL) {
            return null;
        }
        return new LinkOsPrinterCreatorSgdOrJson(linkOsInformation, printerLanguage).create(zebraPrinter);
    }

    public static ZebraPrinter getInstance(String[] strArr, Connection connection) {
        return getInstance(getLanguage(connection, strArr), connection);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection, LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        return new LinkOsPrinterCreatorSgdOrJson(linkOsInformation, printerLanguage).create(connection);
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter, PrinterLanguage printerLanguage) {
        return new LinkOsPrinterCreatorSgdOrJson(printerLanguage).create(zebraPrinter);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection, PrinterLanguage printerLanguage) {
        return new LinkOsPrinterCreatorSgdOrJson(printerLanguage).create(connection);
    }
}
