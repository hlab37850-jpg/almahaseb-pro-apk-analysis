package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterStatus;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterCpcl extends ZebraPrinterA {
    private PrinterLanguage language;

    public ZebraPrinterCpcl(Connection connection, PrinterLanguage printerLanguage) {
        super(connection);
        this.language = printerLanguage;
        this.fileUtil = new FileUtilCpcl(connection);
        this.formatUtil = new FormatUtilCpcl(connection);
        this.graphicsUtil = new GraphicsUtilCpcl(connection);
        this.toolsUtil = new ToolsUtilCpcl(connection);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public PrinterStatus getCurrentStatus() {
        return new PrinterStatusCpcl(this.connection);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public PrinterLanguage getPrinterControlLanguage() {
        return this.language;
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public void setConnection(Connection connection) {
        this.connection = connection;
        this.fileUtil = new FileUtilCpcl(connection);
        this.formatUtil = new FormatUtilCpcl(this.connection);
        this.graphicsUtil = new GraphicsUtilCpcl(this.connection);
        this.toolsUtil = new ToolsUtilCpcl(this.connection);
    }
}
