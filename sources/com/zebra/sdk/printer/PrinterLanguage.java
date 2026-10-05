package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterLanguage {
    ZPL("ZPL"),
    CPCL("CPCL"),
    LINE_PRINT("LINE_PRINT");

    private final String name;

    PrinterLanguage(String str) {
        this.name = str;
    }

    public static PrinterLanguage getLanguage(String str) throws ZebraPrinterLanguageUnknownException {
        String str2 = "ZPL";
        if (str == null) {
            str = "<null>";
        }
        try {
            String upperCase = str.toUpperCase();
            if (!upperCase.contains("ZPL")) {
                str2 = upperCase;
            }
            return valueOf(str2);
        } catch (Exception unused) {
            throw new ZebraPrinterLanguageUnknownException(str + " is not a valid Zebra printer language");
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
