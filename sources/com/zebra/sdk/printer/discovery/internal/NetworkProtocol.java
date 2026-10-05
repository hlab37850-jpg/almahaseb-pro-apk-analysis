package com.zebra.sdk.printer.discovery.internal;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum NetworkProtocol {
    NONE(0, "None"),
    FTP(1, "FTP"),
    LPD(2, "LPD"),
    TCP_RAW(4, "TCP"),
    UDP_RAW(8, "UDP"),
    HTTP(16, "HTTP"),
    SMTP(32, "SMTP"),
    POP3(64, "POP3"),
    SNMP(128, "SNMP"),
    TELNET(256, "Telnet"),
    WEBLINK(512, "Weblink"),
    TLS(1024, "TLS"),
    HTTPS(2048, "HTTPS");

    private final int bitFieldValue;
    private final String networkProtocolString;

    NetworkProtocol(int i, String str) {
        this.bitFieldValue = i;
        this.networkProtocolString = str;
    }

    public static Set<NetworkProtocol> getEnumSetFromBitmask(int i) {
        NetworkProtocol[] networkProtocolArrValues = values();
        EnumSet enumSetNoneOf = EnumSet.noneOf(NetworkProtocol.class);
        for (NetworkProtocol networkProtocol : networkProtocolArrValues) {
            if ((networkProtocol.bitFieldValue() & i) != 0) {
                enumSetNoneOf.add(networkProtocol);
            }
        }
        return enumSetNoneOf;
    }

    public static NetworkProtocol intToEnum(int i) {
        NetworkProtocol networkProtocol = NONE;
        for (NetworkProtocol networkProtocol2 : values()) {
            if (networkProtocol2.bitFieldValue() == i) {
                return networkProtocol2;
            }
        }
        return networkProtocol;
    }

    public int bitFieldValue() {
        return this.bitFieldValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.networkProtocolString;
    }
}
