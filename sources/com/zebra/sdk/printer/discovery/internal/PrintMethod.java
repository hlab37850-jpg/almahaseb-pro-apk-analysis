package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum PrintMethod {
    DIRECT_THERMAL(0, "Direct Thermal"),
    THERMAL_TRANSFER(1, "Thermal Transfer");

    private final String printMethodString;
    private final int value;

    PrintMethod(int i, String str) {
        this.value = i;
        this.printMethodString = str;
    }

    public static PrintMethod intToEnum(int i) {
        PrintMethod printMethod = DIRECT_THERMAL;
        for (PrintMethod printMethod2 : values()) {
            if (printMethod2.value() == i) {
                return printMethod2;
            }
        }
        return printMethod;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printMethodString;
    }

    public int value() {
        return this.value;
    }
}
