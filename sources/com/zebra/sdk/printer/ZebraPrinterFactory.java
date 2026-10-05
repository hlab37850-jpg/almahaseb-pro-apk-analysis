package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.internal.ZebraPrinterFactoryHelper;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterFactory {
    private ZebraPrinterFactory() {
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter) {
        return ZebraPrinterFactoryHelper.createLinkOsPrinter(zebraPrinter);
    }

    public static ZebraPrinter getInstance(Connection connection) {
        return ZebraPrinterFactoryHelper.getInstance(connection);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection) {
        return ZebraPrinterFactoryHelper.getLinkOsPrinter(connection);
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter, LinkOsInformation linkOsInformation) {
        return ZebraPrinterFactoryHelper.createLinkOsPrinter(zebraPrinter, linkOsInformation);
    }

    public static ZebraPrinter getInstance(PrinterLanguage printerLanguage, Connection connection) {
        return ZebraPrinterFactoryHelper.getInstance(printerLanguage, connection);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection, LinkOsInformation linkOsInformation) {
        return ZebraPrinterFactoryHelper.getLinkOsPrinter(connection, linkOsInformation);
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter, LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        return ZebraPrinterFactoryHelper.createLinkOsPrinter(zebraPrinter, linkOsInformation, printerLanguage);
    }

    public static ZebraPrinter getInstance(String[] strArr, Connection connection) {
        return ZebraPrinterFactoryHelper.getInstance(strArr, connection);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection, LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        return ZebraPrinterFactoryHelper.getLinkOsPrinter(connection, linkOsInformation, printerLanguage);
    }

    public static ZebraPrinterLinkOs createLinkOsPrinter(ZebraPrinter zebraPrinter, PrinterLanguage printerLanguage) {
        return ZebraPrinterFactoryHelper.createLinkOsPrinter(zebraPrinter, printerLanguage);
    }

    public static ZebraPrinterLinkOs getLinkOsPrinter(Connection connection, PrinterLanguage printerLanguage) {
        return ZebraPrinterFactoryHelper.getLinkOsPrinter(connection, printerLanguage);
    }
}
