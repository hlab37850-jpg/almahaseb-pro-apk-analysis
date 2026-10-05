package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.device.FileUtil;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraPrinter extends FileUtil, GraphicsUtil, FormatUtil, ToolsUtil {
    Connection getConnection();

    PrinterStatus getCurrentStatus();

    PrinterLanguage getPrinterControlLanguage();

    void setConnection(Connection connection);
}
