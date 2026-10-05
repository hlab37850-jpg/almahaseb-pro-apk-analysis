package com.zebra.sdk.printer.discovery.internal;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterInterface {
    UNKNOWN(0, "Unknown"),
    INTERNAL_WIRED(1, "Internal Wired"),
    EXTERNAL_WIRED(2, "External Wired"),
    WIRELESS(4, "Wireless"),
    BLUETOOTH(8, "Bluetooth"),
    PARALLEL(16, "Parallel"),
    SERIAL(32, "Serial"),
    USB(64, "USB"),
    SD_CARD(128, "SD Card"),
    BATTERY(256, "Battery");

    private final int bitFieldValue;
    private final String printerInterfaceString;

    PrinterInterface(int i, String str) {
        this.bitFieldValue = i;
        this.printerInterfaceString = str;
    }

    public static Set<PrinterInterface> getEnumSetFromBitmask(int i) {
        PrinterInterface[] printerInterfaceArrValues = values();
        EnumSet enumSetNoneOf = EnumSet.noneOf(PrinterInterface.class);
        for (PrinterInterface printerInterface : printerInterfaceArrValues) {
            if ((printerInterface.bitFieldValue() & i) != 0) {
                enumSetNoneOf.add(printerInterface);
            }
        }
        return enumSetNoneOf;
    }

    public static PrinterInterface intToEnum(int i) {
        PrinterInterface printerInterface = UNKNOWN;
        for (PrinterInterface printerInterface2 : values()) {
            if (printerInterface2.bitFieldValue() == i) {
                return printerInterface2;
            }
        }
        return printerInterface;
    }

    public int bitFieldValue() {
        return this.bitFieldValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printerInterfaceString;
    }
}
