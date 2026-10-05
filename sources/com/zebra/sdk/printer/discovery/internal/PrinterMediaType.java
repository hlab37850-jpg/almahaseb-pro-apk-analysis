package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterMediaType {
    CONTINUOUS(0, "Continuous"),
    BLACK_MARK(1, "Black Mark"),
    GAP(2, "Gap");

    private final String printerMediaTypeString;
    private final int value;

    PrinterMediaType(int i, String str) {
        this.value = i;
        this.printerMediaTypeString = str;
    }

    public static PrinterMediaType intToEnum(int i) {
        PrinterMediaType printerMediaType = GAP;
        for (PrinterMediaType printerMediaType2 : values()) {
            if (printerMediaType2.value() == i) {
                return printerMediaType2;
            }
        }
        return printerMediaType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printerMediaTypeString;
    }

    public int value() {
        return this.value;
    }
}
