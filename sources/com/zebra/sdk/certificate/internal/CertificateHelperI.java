package com.zebra.sdk.certificate.internal;

import java.io.StringWriter;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public interface CertificateHelperI {
    Provider getCertificateProvider();

    String getCommonNameHelper(X509Certificate x509Certificate);

    void pemWriterHelper(PrivateKey privateKey, StringWriter stringWriter);

    void pemWriterHelper(Certificate certificate, StringWriter stringWriter);
}
