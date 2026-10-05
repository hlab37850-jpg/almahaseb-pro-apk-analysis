package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public class VerificationException extends GeneralSecurityException {
    private static final long serialVersionUID = 2978604513926438256L;

    public VerificationException(Certificate certificate, String str) {
        super(String.format("Certificate %s failed: %s", certificate == null ? "Unknown" : ((X509Certificate) certificate).getSubjectDN().getName(), str));
    }
}
