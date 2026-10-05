package com.zebra.sdk.comm.snmp.internal;

/* JADX INFO: loaded from: classes3.dex */
public class OidNotFoundException extends Exception {
    private static final long serialVersionUID = 6105355644794801060L;

    public OidNotFoundException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "OidNotFoundException";
    }

    public OidNotFoundException(String str) {
        super(str);
    }
}
