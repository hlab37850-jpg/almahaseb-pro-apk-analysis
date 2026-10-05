package com.itextpdf.text.pdf.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DigestAlgorithms {
    public static final String RIPEMD160 = "RIPEMD160";
    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    private static final HashMap<String, String> allowedDigests;
    private static final HashMap<String, String> digestNames;
    private static final HashMap<String, String> fixNames;

    static {
        HashMap<String, String> map = new HashMap<>();
        digestNames = map;
        HashMap<String, String> map2 = new HashMap<>();
        fixNames = map2;
        HashMap<String, String> map3 = new HashMap<>();
        allowedDigests = map3;
        map.put("1.2.840.113549.2.5", "MD5");
        map.put("1.2.840.113549.2.2", "MD2");
        map.put("1.3.14.3.2.26", SecurityConstants.SHA1);
        map.put("2.16.840.1.101.3.4.2.4", "SHA224");
        map.put("2.16.840.1.101.3.4.2.1", "SHA256");
        map.put("2.16.840.1.101.3.4.2.2", "SHA384");
        map.put("2.16.840.1.101.3.4.2.3", "SHA512");
        map.put("1.3.36.3.2.2", "RIPEMD128");
        map.put("1.3.36.3.2.1", RIPEMD160);
        map.put("1.3.36.3.2.3", "RIPEMD256");
        map.put("1.2.840.113549.1.1.4", "MD5");
        map.put("1.2.840.113549.1.1.2", "MD2");
        map.put("1.2.840.113549.1.1.5", SecurityConstants.SHA1);
        map.put("1.2.840.113549.1.1.14", "SHA224");
        map.put("1.2.840.113549.1.1.11", "SHA256");
        map.put("1.2.840.113549.1.1.12", "SHA384");
        map.put("1.2.840.113549.1.1.13", "SHA512");
        map.put("1.2.840.113549.2.5", "MD5");
        map.put("1.2.840.113549.2.2", "MD2");
        map.put("1.2.840.10040.4.3", SecurityConstants.SHA1);
        map.put("2.16.840.1.101.3.4.3.1", "SHA224");
        map.put("2.16.840.1.101.3.4.3.2", "SHA256");
        map.put("2.16.840.1.101.3.4.3.3", "SHA384");
        map.put("2.16.840.1.101.3.4.3.4", "SHA512");
        map.put("1.3.36.3.3.1.3", "RIPEMD128");
        map.put("1.3.36.3.3.1.2", RIPEMD160);
        map.put("1.3.36.3.3.1.4", "RIPEMD256");
        map.put("1.2.643.2.2.9", "GOST3411");
        map2.put("SHA256", "SHA-256");
        map2.put("SHA384", SHA384);
        map2.put("SHA512", SHA512);
        map3.put("MD2", "1.2.840.113549.2.2");
        map3.put("MD-2", "1.2.840.113549.2.2");
        map3.put("MD5", "1.2.840.113549.2.5");
        map3.put("MD-5", "1.2.840.113549.2.5");
        map3.put(SecurityConstants.SHA1, "1.3.14.3.2.26");
        map3.put(SHA1, "1.3.14.3.2.26");
        map3.put("SHA224", "2.16.840.1.101.3.4.2.4");
        map3.put("SHA-224", "2.16.840.1.101.3.4.2.4");
        map3.put("SHA256", "2.16.840.1.101.3.4.2.1");
        map3.put("SHA-256", "2.16.840.1.101.3.4.2.1");
        map3.put("SHA384", "2.16.840.1.101.3.4.2.2");
        map3.put(SHA384, "2.16.840.1.101.3.4.2.2");
        map3.put("SHA512", "2.16.840.1.101.3.4.2.3");
        map3.put(SHA512, "2.16.840.1.101.3.4.2.3");
        map3.put("RIPEMD128", "1.3.36.3.2.2");
        map3.put("RIPEMD-128", "1.3.36.3.2.2");
        map3.put(RIPEMD160, "1.3.36.3.2.1");
        map3.put("RIPEMD-160", "1.3.36.3.2.1");
        map3.put("RIPEMD256", "1.3.36.3.2.3");
        map3.put("RIPEMD-256", "1.3.36.3.2.3");
        map3.put("GOST3411", "1.2.643.2.2.9");
    }

    public static byte[] digest(InputStream inputStream, String str, String str2) {
        return digest(inputStream, getMessageDigest(str, str2));
    }

    public static String getAllowedDigests(String str) {
        return allowedDigests.get(str.toUpperCase());
    }

    public static String getDigest(String str) {
        String str2 = digestNames.get(str);
        return str2 == null ? str : str2;
    }

    public static MessageDigest getMessageDigest(String str, String str2) {
        return (str2 == null || str2.startsWith("SunPKCS11") || str2.startsWith("SunMSCAPI")) ? MessageDigest.getInstance(normalizeDigestName(str)) : MessageDigest.getInstance(str, str2);
    }

    public static MessageDigest getMessageDigestFromOid(String str, String str2) {
        return getMessageDigest(getDigest(str), str2);
    }

    public static String normalizeDigestName(String str) {
        HashMap<String, String> map = fixNames;
        return map.containsKey(str) ? map.get(str) : str;
    }

    public static byte[] digest(InputStream inputStream, MessageDigest messageDigest) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                messageDigest.update(bArr, 0, i);
            } else {
                return messageDigest.digest();
            }
        }
    }
}
