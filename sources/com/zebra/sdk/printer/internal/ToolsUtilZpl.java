package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.ToolsUtil;
import com.zebra.sdk.util.internal.ZPLUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class ToolsUtilZpl implements ToolsUtil {
    protected Connection connection;

    public ToolsUtilZpl(Connection connection) {
        this.connection = connection;
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void calibrate() {
        this.connection.write(ZPLUtilities.PRINTER_CALIBRATE.getBytes());
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void printConfigurationLabel() {
        this.connection.write(ZPLUtilities.PRINTER_CONFIG_LABEL.getBytes());
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void reset() {
        this.connection.write(ZPLUtilities.PRINTER_RESET.getBytes());
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void restoreDefaults() {
        this.connection.write(ZPLUtilities.PRINTER_RESTORE_DEFAULTS.getBytes());
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str) {
        if (str != null) {
            this.connection.write(str.getBytes());
        }
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str, String str2) {
        if (str != null) {
            this.connection.write(str.getBytes(str2));
        }
    }
}
