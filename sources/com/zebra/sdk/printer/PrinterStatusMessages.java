package com.zebra.sdk.printer;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterStatusMessages {
    public static final String HEAD_OPEN_MSG = "HEAD OPEN";
    public static final String HEAD_TOO_HOT_MSG = "HEAD TOO HOT";
    public static final String NULL_MSG = "INVALID STATUS";
    public static final String PAPER_OUT_MSG = "PAPER OUT";
    public static final String PAUSE_MSG = "PAUSE";
    public static final String RECEIVE_BUFFER_FULL_MSG = "RECEIVE BUFFER FULL";
    public static final String RIBBON_OUT_MSG = "RIBBON OUT";
    private PrinterStatus printerStatus;

    public PrinterStatusMessages(PrinterStatus printerStatus) {
        this.printerStatus = printerStatus;
    }

    public String[] getStatusMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        PrinterStatus printerStatus = this.printerStatus;
        if (printerStatus == null) {
            stringBuffer.append("INVALID STATUS");
            stringBuffer.append(";");
            return new String[]{stringBuffer.toString()};
        }
        if (printerStatus.isHeadOpen) {
            stringBuffer.append("HEAD OPEN");
            stringBuffer.append(";");
        }
        if (this.printerStatus.isHeadTooHot) {
            stringBuffer.append("HEAD TOO HOT");
            stringBuffer.append(";");
        }
        if (this.printerStatus.isPaperOut) {
            stringBuffer.append("PAPER OUT");
            stringBuffer.append(";");
        }
        if (this.printerStatus.isRibbonOut) {
            stringBuffer.append("RIBBON OUT");
            stringBuffer.append(";");
        }
        if (this.printerStatus.isReceiveBufferFull) {
            stringBuffer.append("RECEIVE BUFFER FULL");
            stringBuffer.append(";");
        }
        if (this.printerStatus.isPaused) {
            stringBuffer.append("PAUSE");
            stringBuffer.append(";");
        }
        if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ';') {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return StringUtilities.split(stringBuffer.toString(), ";");
    }
}
