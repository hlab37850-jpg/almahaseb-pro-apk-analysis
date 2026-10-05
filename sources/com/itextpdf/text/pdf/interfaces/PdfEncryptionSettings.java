package com.itextpdf.text.pdf.interfaces;

import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfEncryptionSettings {
    void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2);

    void setEncryption(Certificate[] certificateArr, int[] iArr, int i);
}
