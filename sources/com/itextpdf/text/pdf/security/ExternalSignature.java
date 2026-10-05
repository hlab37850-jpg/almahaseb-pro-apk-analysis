package com.itextpdf.text.pdf.security;

/* JADX INFO: loaded from: classes3.dex */
public interface ExternalSignature {
    String getEncryptionAlgorithm();

    String getHashAlgorithm();

    byte[] sign(byte[] bArr);
}
