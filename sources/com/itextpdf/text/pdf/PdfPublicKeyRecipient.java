package com.itextpdf.text.pdf;

import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPublicKeyRecipient {
    private Certificate certificate;
    protected byte[] cms = null;
    private int permission;

    public PdfPublicKeyRecipient(Certificate certificate, int i) {
        this.certificate = certificate;
        this.permission = i;
    }

    public Certificate getCertificate() {
        return this.certificate;
    }

    public byte[] getCms() {
        return this.cms;
    }

    public int getPermission() {
        return this.permission;
    }

    public void setCms(byte[] bArr) {
        this.cms = bArr;
    }
}
