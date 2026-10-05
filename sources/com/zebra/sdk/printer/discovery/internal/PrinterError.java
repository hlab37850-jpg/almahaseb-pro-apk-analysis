package com.zebra.sdk.printer.discovery.internal;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterError {
    NONE(0, 0, "None"),
    MEDIA_OUT(2, 1, "Paper Out"),
    RIBBON_OUT(2, 2, "Ribbon Out"),
    HEAD_OPEN(2, 4, "Head Open"),
    PRINTHEAD_SHUTDOWN(2, 16, "Printhead Shutdown"),
    MOTOR_OVERTEMP(2, 32, "Motor Overtemp"),
    INVALID_HEAD(2, 128, "Invalid Head"),
    THERMISTOR_FAULT(2, 512, "Thermistor Fault"),
    PAPER_FEED_ERROR(2, 16384, "Paper Feed"),
    PAUSED(2, 65536, "Paused"),
    BASIC_RUNTIME_ERROR(2, 1048576, "Basic Runtime Error"),
    BASIC_FORCED(2, 2097152, "Basic Forced");

    private final int bitFieldValue;
    private final String printErrorString;
    private final int segment;

    PrinterError(int i, int i2, String str) {
        this.bitFieldValue = i2;
        this.segment = i;
        this.printErrorString = str;
    }

    public static Set<PrinterError> getEnumSetFromBitmask(int i, int i2) {
        PrinterError[] printerErrorArrValues = values();
        EnumSet enumSetNoneOf = EnumSet.noneOf(PrinterError.class);
        for (PrinterError printerError : printerErrorArrValues) {
            if ((printerError.bitFieldValue() & i2) != 0 && printerError.segment() == i) {
                enumSetNoneOf.add(printerError);
            }
        }
        return enumSetNoneOf;
    }

    public static PrinterError intToEnum(int i, int i2) {
        PrinterError printerError = NONE;
        for (PrinterError printerError2 : values()) {
            if (printerError2.bitFieldValue() == i2 && printerError2.segment() == i) {
                return printerError2;
            }
        }
        return printerError;
    }

    public int bitFieldValue() {
        return this.bitFieldValue;
    }

    public int segment() {
        return this.segment;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printErrorString;
    }
}
