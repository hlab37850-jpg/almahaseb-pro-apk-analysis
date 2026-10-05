package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public enum ZplPrintMode {
    REWIND("Rewind"),
    PEEL_OFF("Peel-Off"),
    TEAR_OFF("Tear-Off"),
    CUTTER("Cutter"),
    APPLICATOR("Applicator"),
    DELAYED_CUT("Delayed Cut"),
    LINERLESS_PEEL("Linerless Peel"),
    LINERLESS_REWIND("Linerless Rewind"),
    PARTIAL_CUTTER("Partial Cutter"),
    RFID("RFID"),
    KIOSK("Kiosk"),
    UNKNOWN("Unknown");

    private final String name;

    ZplPrintMode(String str) {
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
