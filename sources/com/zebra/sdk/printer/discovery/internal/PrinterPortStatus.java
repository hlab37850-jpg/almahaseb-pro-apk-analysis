package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterPortStatus {
    NONE(0, "None"),
    ONLINE(1, "Online"),
    OFFLINE(2, "Offline"),
    TONER_LOW(3, "Toner Low"),
    PAPER_OUT(4, "Paper Out"),
    PAPER_JAMMED(5, "Paper Jammed"),
    DOOR_OPEN(6, "Door Open"),
    PRINTER_ERROR(7, "Printer Error"),
    UNKNOWN(8, "Unknown");

    private final String errorString;
    private final int value;

    PrinterPortStatus(int i, String str) {
        this.value = i;
        this.errorString = str;
    }

    public static PrinterPortStatus intToEnum(int i) {
        PrinterPortStatus printerPortStatus = UNKNOWN;
        for (PrinterPortStatus printerPortStatus2 : values()) {
            if (printerPortStatus2.value() == i) {
                return printerPortStatus2;
            }
        }
        return printerPortStatus;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.errorString;
    }

    public int value() {
        return this.value;
    }
}
