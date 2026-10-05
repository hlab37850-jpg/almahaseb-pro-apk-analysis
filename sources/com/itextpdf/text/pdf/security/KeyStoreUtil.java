package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes3.dex */
public class KeyStoreUtil {
    public static KeyStore loadCacertsKeyStore(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(new File(new File(System.getProperty("java.home"), "lib"), "security"), "cacerts"));
                try {
                    KeyStore keyStore = str == null ? KeyStore.getInstance("JKS") : KeyStore.getInstance("JKS", str);
                    keyStore.load(fileInputStream2, null);
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return keyStore;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    throw new ExceptionConverter(e);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static KeyStore loadCacertsKeyStore() {
        return loadCacertsKeyStore(null);
    }
}
