package com.itextpdf.text.pdf.security;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class EncryptionAlgorithms {
    static final HashMap<String, String> algorithmNames;

    static {
        HashMap<String, String> map = new HashMap<>();
        algorithmNames = map;
        map.put(SecurityIDs.ID_RSA, SecurityConstants.RSA);
        map.put(SecurityIDs.ID_DSA, SecurityConstants.DSA);
        map.put("1.2.840.113549.1.1.2", SecurityConstants.RSA);
        map.put("1.2.840.113549.1.1.4", SecurityConstants.RSA);
        map.put("1.2.840.113549.1.1.5", SecurityConstants.RSA);
        map.put("1.2.840.113549.1.1.14", SecurityConstants.RSA);
        map.put("1.2.840.113549.1.1.11", SecurityConstants.RSA);
        map.put("1.2.840.113549.1.1.12", SecurityConstants.RSA);
        map.put("1.2.840.113549.1.1.13", SecurityConstants.RSA);
        map.put("1.2.840.10040.4.3", SecurityConstants.DSA);
        map.put("2.16.840.1.101.3.4.3.1", SecurityConstants.DSA);
        map.put("2.16.840.1.101.3.4.3.2", SecurityConstants.DSA);
        map.put("1.3.14.3.2.29", SecurityConstants.RSA);
        map.put("1.3.36.3.3.1.2", SecurityConstants.RSA);
        map.put("1.3.36.3.3.1.3", SecurityConstants.RSA);
        map.put("1.3.36.3.3.1.4", SecurityConstants.RSA);
        map.put("1.2.643.2.2.19", "ECGOST3410");
    }

    public static String getAlgorithm(String str) {
        String str2 = algorithmNames.get(str);
        return str2 == null ? str : str2;
    }
}
