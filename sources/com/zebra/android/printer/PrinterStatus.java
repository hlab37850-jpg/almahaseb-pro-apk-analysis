package com.zebra.android.printer;

import com.zebra.android.comm.ZebraPrinterConnection;
import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.sdk.comm.ConnectionException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrinterStatus {
    public boolean isHeadOpen;
    public boolean isHeadTooHot;
    public boolean isPaperOut;
    public boolean isPaused;
    public boolean isReadyToPrint;
    public boolean isReceiveBufferFull;
    public boolean isRibbonOut;
    public int numberOfFormatsInReceiveBuffer = 0;
    public int labelsRemainingInBatch = 0;
    public boolean isPartialFormatInProgress = false;
    public boolean isHeadCold = false;
    public ZplPrintMode printMode = ZplPrintMode.UNKNOWN;
    public int labelLengthInDots = 0;

    /* JADX INFO: renamed from: com.zebra.android.printer.PrinterStatus$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$zebra$sdk$printer$ZplPrintMode;

        static {
            int[] iArr = new int[com.zebra.sdk.printer.ZplPrintMode.values().length];
            $SwitchMap$com$zebra$sdk$printer$ZplPrintMode = iArr;
            try {
                iArr[com.zebra.sdk.printer.ZplPrintMode.REWIND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.PEEL_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.TEAR_OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.CUTTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.APPLICATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.DELAYED_CUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.LINERLESS_PEEL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.LINERLESS_REWIND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.PARTIAL_CUTTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.RFID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$ZplPrintMode[com.zebra.sdk.printer.ZplPrintMode.KIOSK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public PrinterStatus(ZebraPrinterConnection zebraPrinterConnection) {
    }

    private ZplPrintMode convertToOldPrintMode(com.zebra.sdk.printer.ZplPrintMode zplPrintMode) {
        ZplPrintMode zplPrintMode2 = ZplPrintMode.REWIND;
        switch (AnonymousClass1.$SwitchMap$com$zebra$sdk$printer$ZplPrintMode[zplPrintMode.ordinal()]) {
            case 1:
                return ZplPrintMode.REWIND;
            case 2:
                return ZplPrintMode.PEEL_OFF;
            case 3:
                return ZplPrintMode.TEAR_OFF;
            case 4:
                return ZplPrintMode.CUTTER;
            case 5:
                return ZplPrintMode.APPLICATOR;
            case 6:
                return ZplPrintMode.DELAYED_CUT;
            case 7:
                return ZplPrintMode.LINERLESS_PEEL;
            case 8:
                return ZplPrintMode.LINERLESS_REWIND;
            case 9:
                return ZplPrintMode.PARTIAL_CUTTER;
            case 10:
                return ZplPrintMode.RFID;
            case 11:
                return ZplPrintMode.KIOSK;
            default:
                return ZplPrintMode.UNKNOWN;
        }
    }

    public PrinterStatus convertStatuses(com.zebra.sdk.printer.ZebraPrinter zebraPrinter) throws ZebraPrinterConnectionException {
        try {
            com.zebra.sdk.printer.PrinterStatus currentStatus = zebraPrinter.getCurrentStatus();
            this.printMode = convertToOldPrintMode(currentStatus.printMode);
            this.labelLengthInDots = currentStatus.labelLengthInDots;
            this.numberOfFormatsInReceiveBuffer = currentStatus.numberOfFormatsInReceiveBuffer;
            this.labelsRemainingInBatch = currentStatus.labelsRemainingInBatch;
            this.isPartialFormatInProgress = currentStatus.isPartialFormatInProgress;
            this.isHeadCold = currentStatus.isHeadCold;
            this.isHeadOpen = currentStatus.isHeadOpen;
            this.isHeadTooHot = currentStatus.isHeadTooHot;
            this.isPaperOut = currentStatus.isPaperOut;
            this.isRibbonOut = currentStatus.isRibbonOut;
            this.isReceiveBufferFull = currentStatus.isReceiveBufferFull;
            this.isPaused = currentStatus.isPaused;
            this.isReadyToPrint = currentStatus.isReadyToPrint;
            return this;
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
