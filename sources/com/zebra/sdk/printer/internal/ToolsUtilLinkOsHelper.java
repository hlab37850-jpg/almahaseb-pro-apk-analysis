package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.operations.internal.ClockSetter;
import com.zebra.sdk.util.internal.ZPLUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class ToolsUtilLinkOsHelper {
    Connection connection;
    PrinterLanguage printerLanguage;

    public ToolsUtilLinkOsHelper(Connection connection, PrinterLanguage printerLanguage) {
        this.connection = connection;
        this.printerLanguage = printerLanguage;
    }

    public void printDirectoryLabel() {
        this.connection.write(ZPLUtilities.PRINTER_DIRECTORY_LABEL.getBytes());
    }

    public void printNetworkConfigurationLabel() {
        this.connection.write(ZPLUtilities.PRINTER_NETWORK_CONFIG_LABEL.getBytes());
    }

    public void setClock(String str) {
        new ClockSetter(str, this.connection, this.printerLanguage).execute();
    }
}
