package com.itextpdf.text.pdf.security;

import java.security.cert.X509Certificate;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface CrlClient {
    Collection<byte[]> getEncoded(X509Certificate x509Certificate, String str);
}
