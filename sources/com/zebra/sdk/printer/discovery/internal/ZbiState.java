package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum ZbiState {
    DISABLED(0, "Disabled"),
    STOPPED(1, "Stopped"),
    RUNNING(2, "Running");

    private final int value;
    private final String zbiStateString;

    ZbiState(int i, String str) {
        this.value = i;
        this.zbiStateString = str;
    }

    public static ZbiState intToEnum(int i) {
        ZbiState zbiState = STOPPED;
        for (ZbiState zbiState2 : values()) {
            if (zbiState2.value() == i) {
                return zbiState2;
            }
        }
        return zbiState;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.zbiStateString;
    }

    public int value() {
        return this.value;
    }
}
