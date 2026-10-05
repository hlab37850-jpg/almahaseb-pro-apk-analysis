package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum PrintMode {
    REWIND(0, "Rewind"),
    TEAR_OFF(1, "Tear Off"),
    PEEL_OFF(2, "Peel Off"),
    PACE(3, "Pace"),
    CUTTER(4, "Cutter"),
    DELAYED_CUT(5, "Delayed Cuts"),
    APPLICATOR(6, "Applicator"),
    LINERLESS_PEEL(7, "Linerless Peel"),
    LINERLESS_REWIND(8, "Linerless Rewind"),
    PARTIAL_CUTTER(9, "Partial Cutter"),
    RFID(10, "RFID"),
    LINERLESS_TEAR(11, "Linerless Tear");

    private final String printModeString;
    private final int value;

    PrintMode(int i, String str) {
        this.value = i;
        this.printModeString = str;
    }

    public static PrintMode intToEnum(int i) {
        PrintMode printMode = REWIND;
        for (PrintMode printMode2 : values()) {
            if (printMode2.value() == i) {
                return printMode2;
            }
        }
        return printMode;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printModeString;
    }

    public int value() {
        return this.value;
    }
}
