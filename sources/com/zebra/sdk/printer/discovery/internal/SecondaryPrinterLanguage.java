package com.zebra.sdk.printer.discovery.internal;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum SecondaryPrinterLanguage {
    UNKNOWN(0, "Unknown"),
    SGD(1, "SGD"),
    SNMP(2, "SNMP");

    private final String secondaryPrinterLanguageString;
    private final int value;

    SecondaryPrinterLanguage(int i, String str) {
        this.value = i;
        this.secondaryPrinterLanguageString = str;
    }

    public static Set<SecondaryPrinterLanguage> getEnumSetFromBitmask(int i) {
        SecondaryPrinterLanguage[] secondaryPrinterLanguageArrValues = values();
        EnumSet enumSetNoneOf = EnumSet.noneOf(SecondaryPrinterLanguage.class);
        for (SecondaryPrinterLanguage secondaryPrinterLanguage : secondaryPrinterLanguageArrValues) {
            if ((secondaryPrinterLanguage.bitFieldValue() & i) != 0) {
                enumSetNoneOf.add(secondaryPrinterLanguage);
            }
        }
        return enumSetNoneOf;
    }

    public static SecondaryPrinterLanguage intToEnum(int i) {
        SecondaryPrinterLanguage secondaryPrinterLanguage = UNKNOWN;
        for (SecondaryPrinterLanguage secondaryPrinterLanguage2 : values()) {
            if (secondaryPrinterLanguage2.bitFieldValue() == i) {
                return secondaryPrinterLanguage2;
            }
        }
        return secondaryPrinterLanguage;
    }

    public int bitFieldValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.secondaryPrinterLanguageString;
    }
}
