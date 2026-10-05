package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum Wired8021xSecuritySetting {
    NONE(0, "None"),
    PEAP(1, "PEAP"),
    EAP_TLS(2, "EAP-TLS"),
    EAP_TTLS(3, "EAP-TTLS");

    private final int value;
    private final String wiredSecuritySetting;

    Wired8021xSecuritySetting(int i, String str) {
        this.value = i;
        this.wiredSecuritySetting = str;
    }

    public static Wired8021xSecuritySetting intToEnum(int i) {
        Wired8021xSecuritySetting wired8021xSecuritySetting = NONE;
        for (Wired8021xSecuritySetting wired8021xSecuritySetting2 : values()) {
            if (wired8021xSecuritySetting2.bitFieldValue() == i) {
                return wired8021xSecuritySetting2;
            }
        }
        return wired8021xSecuritySetting;
    }

    public int bitFieldValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.wiredSecuritySetting;
    }
}
