package com.zebra.sdk.printer.discovery.internal;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum DiscoveredPrinterLanguage {
    UNKNOWN(0, "Unknown"),
    ZPL(1, "ZPL"),
    CPCL(2, "CPCL"),
    EPL(4, "EPL");

    private final String printerLanguageString;
    private final int value;

    DiscoveredPrinterLanguage(int i, String str) {
        this.value = i;
        this.printerLanguageString = str;
    }

    public static Set<DiscoveredPrinterLanguage> getEnumSetFromBitmask(int i) {
        DiscoveredPrinterLanguage[] discoveredPrinterLanguageArrValues = values();
        EnumSet enumSetNoneOf = EnumSet.noneOf(DiscoveredPrinterLanguage.class);
        for (DiscoveredPrinterLanguage discoveredPrinterLanguage : discoveredPrinterLanguageArrValues) {
            if ((discoveredPrinterLanguage.bitFieldValue() & i) != 0) {
                enumSetNoneOf.add(discoveredPrinterLanguage);
            }
        }
        return enumSetNoneOf;
    }

    public static DiscoveredPrinterLanguage intToEnum(int i) {
        DiscoveredPrinterLanguage discoveredPrinterLanguage = UNKNOWN;
        for (DiscoveredPrinterLanguage discoveredPrinterLanguage2 : values()) {
            if (discoveredPrinterLanguage2.bitFieldValue() == i) {
                return discoveredPrinterLanguage2;
            }
        }
        return discoveredPrinterLanguage;
    }

    public int bitFieldValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.printerLanguageString;
    }
}
