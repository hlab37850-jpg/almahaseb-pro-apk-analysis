package com.zebra.sdk.printer.discovery.internal;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterWarning {
    NONE(0, 0, "None"),
    HEAD_UNDER_TEMP(2, 4096, "Head Cold"),
    RIBBON_IN(2, 8192, "Ribbon In"),
    BATTERY_LOW(2, 16384, "Battery Low"),
    RFID_ERROR(2, 32768, "RFID Error");

    private final int bitFieldValue;
    private final String printerWarningString;
    private final int segment;

    PrinterWarning(int i, int i2, String str) {
        this.bitFieldValue = i2;
        this.segment = i;
        this.printerWarningString = str;
    }

    public static Set<PrinterWarning> getEnumSetFromBitmask(int i, int i2) {
        PrinterWarning[] printerWarningArrValues = values();
        EnumSet enumSetNoneOf = EnumSet.noneOf(PrinterWarning.class);
        for (PrinterWarning printerWarning : printerWarningArrValues) {
            if ((printerWarning.bitFieldValue() & i2) != 0 && printerWarning.segment() == i) {
                enumSetNoneOf.add(printerWarning);
            }
        }
        return enumSetNoneOf;
    }

    public static PrinterWarning intToEnum(int i, int i2) {
        PrinterWarning printerWarning = NONE;
        for (PrinterWarning printerWarning2 : values()) {
            if (printerWarning2.bitFieldValue() == i2 && printerWarning2.segment() == i) {
                return printerWarning2;
            }
        }
        return printerWarning;
    }

    public int bitFieldValue() {
        return this.bitFieldValue;
    }

    public int segment() {
        return this.segment;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printerWarningString;
    }
}
