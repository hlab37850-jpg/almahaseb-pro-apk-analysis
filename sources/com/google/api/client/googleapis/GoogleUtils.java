package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes2.dex */
public final class GoogleUtils {
    static KeyStore certTrustStore;
    public static final Integer MAJOR_VERSION = 1;
    public static final Integer MINOR_VERSION = 22;
    public static final Integer BUGFIX_VERSION = 0;
    public static final String VERSION = (((Object) 1) + "." + ((Object) 22) + "." + ((Object) 0) + "").toString();

    private GoogleUtils() {
    }

    public static synchronized KeyStore getCertificateTrustStore() {
        try {
            if (certTrustStore == null) {
                certTrustStore = SecurityUtils.getJavaKeyStore();
                SecurityUtils.loadKeyStore(certTrustStore, GoogleUtils.class.getResourceAsStream("google.jks"), "notasecret");
            }
        } catch (Throwable th) {
            throw th;
        }
        return certTrustStore;
    }
}
