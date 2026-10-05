package com.zebra.sdk.weblink;

/* JADX INFO: loaded from: classes3.dex */
public enum WeblinkAddressStrategy {
    AUTO_SELECT,
    FORCE_CONNECTION_1,
    FORCE_CONNECTION_2;

    public static WeblinkAddressStrategy lookupInt(int i) {
        if (i != 1) {
            return i != 2 ? AUTO_SELECT : FORCE_CONNECTION_2;
        }
        return FORCE_CONNECTION_1;
    }
}
