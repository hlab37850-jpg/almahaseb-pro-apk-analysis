package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.crypto.AESCipher;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;

/* JADX INFO: loaded from: classes3.dex */
public class StandardDecryption {
    private static final int AES_128 = 4;
    private static final int AES_256 = 5;
    private boolean aes;
    protected ARCFOUREncryption arcfour;
    protected AESCipher cipher;
    private boolean initiated;
    private byte[] iv = new byte[16];
    private int ivptr;
    private byte[] key;

    public StandardDecryption(byte[] bArr, int i, int i2, int i3) {
        boolean z = i3 == 4 || i3 == 5;
        this.aes = z;
        if (z) {
            byte[] bArr2 = new byte[i2];
            this.key = bArr2;
            System.arraycopy(bArr, i, bArr2, 0, i2);
        } else {
            ARCFOUREncryption aRCFOUREncryption = new ARCFOUREncryption();
            this.arcfour = aRCFOUREncryption;
            aRCFOUREncryption.prepareARCFOURKey(bArr, i, i2);
        }
    }

    public byte[] finish() {
        AESCipher aESCipher = this.cipher;
        if (aESCipher == null || !this.aes) {
            return null;
        }
        return aESCipher.doFinal();
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        if (!this.aes) {
            byte[] bArr2 = new byte[i2];
            this.arcfour.encryptARCFOUR(bArr, i, i2, bArr2, 0);
            return bArr2;
        }
        if (this.initiated) {
            return this.cipher.update(bArr, i, i2);
        }
        int iMin = Math.min(this.iv.length - this.ivptr, i2);
        System.arraycopy(bArr, i, this.iv, this.ivptr, iMin);
        int i3 = i + iMin;
        int i4 = i2 - iMin;
        int i5 = this.ivptr + iMin;
        this.ivptr = i5;
        byte[] bArr3 = this.iv;
        if (i5 != bArr3.length) {
            return null;
        }
        AESCipher aESCipher = new AESCipher(false, this.key, bArr3);
        this.cipher = aESCipher;
        this.initiated = true;
        if (i4 > 0) {
            return aESCipher.update(bArr, i3, i4);
        }
        return null;
    }
}
