package com.zebra.sdk.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public class IPAddressUtil {
    public static boolean ipAddressIsValid(String str) {
        boolean z = RegexUtil.getMatches("^\\s*([\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3})\\s*$", str).size() > 0;
        if (z) {
            return z;
        }
        return RegexUtil.getMatches("^(([a-zA-Z]|[a-zA-Z][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z]|[A-Za-z][A-Za-z0-9\\-]*[A-Za-z0-9])$", str).size() > 0;
    }
}
