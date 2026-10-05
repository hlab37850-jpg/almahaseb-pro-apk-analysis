package com.itextpdf.text.pdf.crypto;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes3.dex */
public class AESCipherCBCnoPad {
    private BlockCipher cbc = new CBCBlockCipher(new AESFastEngine());

    public AESCipherCBCnoPad(boolean z, byte[] bArr) {
        this.cbc.init(z, new KeyParameter(bArr));
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) {
        if (i2 % this.cbc.getBlockSize() != 0) {
            throw new IllegalArgumentException("Not multiple of block: " + i2);
        }
        byte[] bArr2 = new byte[i2];
        int blockSize = 0;
        while (i2 > 0) {
            this.cbc.processBlock(bArr, i, bArr2, blockSize);
            i2 -= this.cbc.getBlockSize();
            blockSize += this.cbc.getBlockSize();
            i += this.cbc.getBlockSize();
        }
        return bArr2;
    }
}
