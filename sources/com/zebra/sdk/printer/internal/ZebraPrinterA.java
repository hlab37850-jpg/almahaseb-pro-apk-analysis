package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.device.FileUtil;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.printer.FieldDescriptionData;
import com.zebra.sdk.printer.FormatUtil;
import com.zebra.sdk.printer.GraphicsUtil;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.ToolsUtil;
import com.zebra.sdk.printer.ZebraPrinter;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZebraPrinterA implements ZebraPrinter {
    protected Connection connection;
    protected FileUtil fileUtil = null;
    protected FormatUtil formatUtil = null;
    protected GraphicsUtil graphicsUtil = null;
    protected ToolsUtil toolsUtil = null;

    public ZebraPrinterA(Connection connection) {
        this.connection = connection;
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void calibrate() {
        this.toolsUtil.calibrate();
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public Connection getConnection() {
        return this.connection;
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public FieldDescriptionData[] getVariableFields(String str) {
        return this.formatUtil.getVariableFields(str);
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void printConfigurationLabel() {
        this.toolsUtil.printConfigurationLabel();
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(ZebraImageI zebraImageI, int i, int i2, int i3, int i4, boolean z) {
        this.graphicsUtil.printImage(zebraImageI, i, i2, i3, i4, z);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map) {
        this.formatUtil.printStoredFormat(str, map);
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void reset() {
        this.toolsUtil.reset();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void restoreDefaults() {
        this.toolsUtil.restoreDefaults();
    }

    @Override // com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames() {
        return this.fileUtil.retrieveFileNames();
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void retrieveFormatFromPrinter(OutputStream outputStream, String str) {
        this.formatUtil.retrieveFormatFromPrinter(outputStream, str);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public List<PrinterObjectProperties> retrieveObjectsProperties() {
        return this.fileUtil.retrieveObjectsProperties();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str) {
        this.toolsUtil.sendCommand(str);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str) {
        this.fileUtil.sendFileContents(str);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, ZebraImageI zebraImageI, int i, int i2) {
        this.graphicsUtil.storeImage(str, zebraImageI, i, i2);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2) {
        this.graphicsUtil.printImage(str, i, i2);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map, String str2) {
        this.formatUtil.printStoredFormat(str, map, str2);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames(String[] strArr) {
        return this.fileUtil.retrieveFileNames(strArr);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public byte[] retrieveFormatFromPrinter(String str) {
        return this.formatUtil.retrieveFormatFromPrinter(str);
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str, String str2) {
        this.toolsUtil.sendCommand(str, str2);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str, ProgressMonitor progressMonitor) {
        this.fileUtil.sendFileContents(str, progressMonitor);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, String str2, int i, int i2) {
        this.graphicsUtil.storeImage(str, str2, i, i2);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2, int i3, int i4, boolean z) {
        this.graphicsUtil.printImage(str, i, i2, i3, i4, z);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr) {
        this.formatUtil.printStoredFormat(str, strArr);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr, String str2) {
        this.formatUtil.printStoredFormat(str, strArr, str2);
    }
}
