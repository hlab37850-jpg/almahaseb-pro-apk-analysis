package com.zebra.sdk.comm.internal;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothHelper {
    public static String formatMacAddress(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder();
        if (strTrim.length() == 12) {
            sb.append(strTrim.substring(0, 2));
            sb.append(":");
            sb.append(strTrim.substring(2, 4));
            sb.append(":");
            sb.append(strTrim.substring(4, 6));
            sb.append(":");
            sb.append(strTrim.substring(6, 8));
            sb.append(":");
            sb.append(strTrim.substring(8, 10));
            sb.append(":");
            strTrim = strTrim.substring(10, 12);
        }
        sb.append(strTrim);
        return sb.toString().toUpperCase();
    }
}
