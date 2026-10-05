package com.zebra.android.printer.internal;

import com.zebra.android.printer.FileUtil;
import com.zebra.android.printer.FormatUtil;
import com.zebra.android.printer.GraphicsUtil;
import com.zebra.android.printer.MagCardReader;
import com.zebra.android.printer.PrinterLanguage;
import com.zebra.android.printer.PrinterStatus;
import com.zebra.android.printer.SmartcardReader;
import com.zebra.android.printer.ToolsUtil;
import com.zebra.android.printer.ZebraPrinter;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterLegacyDelegator implements ZebraPrinter {
    private FileUtil fileUtilLegacy;
    private FormatUtil formatUtilLegacy;
    private GraphicsUtil graphicsUtilLegacy;
    private MagCardReader magCardReader;
    private com.zebra.sdk.printer.ZebraPrinter newPrinter;
    private PrinterLanguage printerControlLanguage;
    private SmartcardReader smartcardReader;
    private ToolsUtil toolsUtil;

    public ZebraPrinterLegacyDelegator(com.zebra.sdk.printer.ZebraPrinter zebraPrinter) {
        PrinterLanguage printerLanguage;
        this.newPrinter = zebraPrinter;
        this.fileUtilLegacy = new FileUtilLegacy(zebraPrinter);
        this.formatUtilLegacy = new FormatUtilLegacy(this.newPrinter);
        this.graphicsUtilLegacy = new GraphicsUtilLegacy(this.newPrinter);
        this.toolsUtil = new ToolsUtilLegacy(this.newPrinter);
        if (this.newPrinter.getPrinterControlLanguage() == com.zebra.sdk.printer.PrinterLanguage.ZPL) {
            this.magCardReader = null;
            this.smartcardReader = null;
            printerLanguage = PrinterLanguage.ZPL;
        } else {
            this.magCardReader = new MagCardReaderLegacy(this.newPrinter);
            this.smartcardReader = new SmartcardReaderLegacy(this.newPrinter);
            printerLanguage = PrinterLanguage.CPCL;
        }
        this.printerControlLanguage = printerLanguage;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public com.zebra.sdk.printer.ZebraPrinter getConvertedNewPrinter() {
        return null;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public PrinterStatus getCurrentStatus() {
        return new PrinterStatusLegacy().getOldStatus(this.newPrinter);
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public FileUtil getFileUtil() {
        return this.fileUtilLegacy;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public FormatUtil getFormatUtil() {
        return this.formatUtilLegacy;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public GraphicsUtil getGraphicsUtil() {
        return this.graphicsUtilLegacy;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public MagCardReader getMagCardReader() {
        return this.magCardReader;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public PrinterLanguage getPrinterControlLanguage() {
        return this.printerControlLanguage;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public SmartcardReader getSmartcardReader() {
        return this.smartcardReader;
    }

    @Override // com.zebra.android.printer.ZebraPrinter
    public ToolsUtil getToolsUtil() {
        return this.toolsUtil;
    }
}
