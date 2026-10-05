package com.itextpdf.text.pdf.security;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class ProviderDigest implements ExternalDigest {
    private String provider;

    public ProviderDigest(String str) {
        this.provider = str;
    }

    @Override // com.itextpdf.text.pdf.security.ExternalDigest
    public MessageDigest getMessageDigest(String str) {
        return DigestAlgorithms.getMessageDigest(str, this.provider);
    }
}
