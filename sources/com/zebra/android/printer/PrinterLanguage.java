package com.zebra.android.printer;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterLanguage {
    ZPL("ZPL"),
    CPCL("CPCL");

    private final String name;

    PrinterLanguage(String str) {
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
