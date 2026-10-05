package com.zebra.sdk.printer.discovery.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum IPAquisitionProtocol {
    ALL(0, "All"),
    GLEAN(1, "Glean"),
    RARP(2, "RARP"),
    BOOTP(3, "Bootp"),
    DHCP(4, "DHCP"),
    DHCP_AND_BOOTP(5, "DHCP and Bootp"),
    STATIC(6, "Static");

    private final String ipProtocolString;
    private final int value;

    IPAquisitionProtocol(int i, String str) {
        this.value = i;
        this.ipProtocolString = str;
    }

    public static IPAquisitionProtocol intToEnum(int i) {
        IPAquisitionProtocol iPAquisitionProtocol = ALL;
        for (IPAquisitionProtocol iPAquisitionProtocol2 : values()) {
            if (iPAquisitionProtocol2.bitFieldValue() == i) {
                return iPAquisitionProtocol2;
            }
        }
        return iPAquisitionProtocol;
    }

    public int bitFieldValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ipProtocolString;
    }
}
