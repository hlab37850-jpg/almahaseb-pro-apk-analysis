package com.zebra.sdk.printer.internal;

import com.itextpdf.tool.xml.css.CSS;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ToolsUtil;
import com.zebra.sdk.util.internal.CPCLUtilities;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class ToolsUtilCpcl implements ToolsUtil {
    protected Connection connection;

    public ToolsUtilCpcl(Connection connection) {
        this.connection = connection;
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void calibrate() {
        this.connection.write(CPCLUtilities.PRINTER_FORM_FEED.getBytes());
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void printConfigurationLabel() {
        this.connection.write(CPCLUtilities.PRINTER_CONFIG_LABEL.getBytes());
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void reset() {
        SGD.SET(SGDUtilities.DEVICE_RESET, "", this.connection);
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void restoreDefaults() {
        SGD.SET("device.restore_defaults", CSS.Property.DISPLAY, this.connection);
        reset();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str) {
        if (str != null) {
            this.connection.write((str + StringUtilities.CRLF).getBytes());
        }
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str, String str2) {
        if (str != null) {
            this.connection.write((str + StringUtilities.CRLF).getBytes(str2));
        }
    }
}
