package com.zebra.android.printer;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraPrinter {
    com.zebra.sdk.printer.ZebraPrinter getConvertedNewPrinter();

    PrinterStatus getCurrentStatus();

    FileUtil getFileUtil();

    FormatUtil getFormatUtil();

    GraphicsUtil getGraphicsUtil();

    MagCardReader getMagCardReader();

    PrinterLanguage getPrinterControlLanguage();

    SmartcardReader getSmartcardReader();

    ToolsUtil getToolsUtil();
}
