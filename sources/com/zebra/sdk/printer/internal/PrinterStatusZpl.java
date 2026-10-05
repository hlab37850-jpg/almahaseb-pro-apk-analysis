package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.ZplPrintMode;
import com.zebra.sdk.util.internal.StringUtilities;
import com.zebra.sdk.util.internal.ZPLUtilities;
import org.apache.poi.hssf.record.formula.RefNPtg;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterStatusZpl extends PrinterStatus {
    public PrinterStatusZpl(Connection connection) {
        super(connection);
    }

    private static ZplPrintMode getPrintModeFromHs(char c) {
        char cCharAt = String.valueOf(c).toUpperCase().charAt(0);
        if (cCharAt == 'K') {
            return ZplPrintMode.KIOSK;
        }
        switch (cCharAt) {
            case '0':
                return ZplPrintMode.REWIND;
            case '1':
                return ZplPrintMode.PEEL_OFF;
            case '2':
                return ZplPrintMode.TEAR_OFF;
            case '3':
                return ZplPrintMode.CUTTER;
            case '4':
                return ZplPrintMode.APPLICATOR;
            case '5':
                return ZplPrintMode.DELAYED_CUT;
            case '6':
                return ZplPrintMode.LINERLESS_PEEL;
            case '7':
                return ZplPrintMode.LINERLESS_REWIND;
            case '8':
                return ZplPrintMode.PARTIAL_CUTTER;
            case '9':
                return ZplPrintMode.RFID;
            default:
                return ZplPrintMode.UNKNOWN;
        }
    }

    public int findStartOfHsResponse(byte[] bArr) {
        int i = 0;
        while (i < bArr.length && bArr[i] != 2) {
            i++;
        }
        return i;
    }

    public byte getLineSeparatorChar() {
        return (byte) 3;
    }

    public String[] getPrinterStatus() throws ConnectionException {
        byte[] statusInfoFromPrinter = getStatusInfoFromPrinter();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArrSplit = new String[0];
        if (statusInfoFromPrinter != null) {
            if (findStartOfHsResponse(statusInfoFromPrinter) == statusInfoFromPrinter.length) {
                throw new ConnectionException("Malformed status response - unable to determine printer status");
            }
            byte lineSeparatorChar = getLineSeparatorChar();
            for (int i = 0; i < statusInfoFromPrinter.length; i++) {
                if (statusInfoFromPrinter[i] == lineSeparatorChar) {
                    statusInfoFromPrinter[i] = RefNPtg.sid;
                }
                byte b = statusInfoFromPrinter[i];
                if (b > 31 && b < 127) {
                    stringBuffer.append(String.valueOf((char) b));
                }
            }
        }
        if (stringBuffer.length() >= 1) {
            strArrSplit = StringUtilities.split(stringBuffer.toString(), ",");
            if (strArrSplit.length < 25) {
                throw new ConnectionException("Malformed status response - unable to determine printer status");
            }
        }
        return strArrSplit;
    }

    public byte[] getStatusInfoFromPrinter() {
        return new PrinterCommandImpl(ZPLUtilities.PRINTER_STATUS).sendAndWaitForResponse(this.printerConnection);
    }

    @Override // com.zebra.sdk.printer.PrinterStatus
    public void updateStatus() throws ConnectionException {
        String[] printerStatus = getPrinterStatus();
        this.labelsRemainingInBatch = Integer.parseInt(printerStatus[20]);
        this.numberOfFormatsInReceiveBuffer = Integer.parseInt(printerStatus[4]);
        this.isPartialFormatInProgress = printerStatus[7].equals("1");
        this.isHeadCold = printerStatus[10].equals("1");
        this.isHeadOpen = printerStatus[14].equals("1");
        this.isHeadTooHot = printerStatus[11].equals("1");
        this.isPaperOut = printerStatus[1].equals("1");
        this.isRibbonOut = printerStatus[15].equals("1");
        this.isReceiveBufferFull = printerStatus[5].equals("1");
        this.isPaused = printerStatus[2].equals("1");
        this.labelLengthInDots = Integer.parseInt(printerStatus[3]);
        this.printMode = getPrintModeFromHs(printerStatus[17].charAt(0));
    }
}
