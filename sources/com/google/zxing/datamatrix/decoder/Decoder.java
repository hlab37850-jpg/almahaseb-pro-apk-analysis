package com.google.zxing.datamatrix.decoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import defpackage.AbstractC3743qi;
import defpackage.C2010d8;

/* JADX INFO: loaded from: classes3.dex */
public final class Decoder {
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

    private void correctErrors(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & UnsignedBytes.MAX_VALUE;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(boolean[][] zArr) {
        return decode(BitMatrix.parse(zArr));
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException {
        C2010d8 c2010d8 = new C2010d8(bitMatrix);
        a[] aVarArrB = a.b(c2010d8.c(), c2010d8.b());
        int iC = 0;
        for (a aVar : aVarArrB) {
            iC += aVar.c();
        }
        byte[] bArr = new byte[iC];
        int length = aVarArrB.length;
        for (int i = 0; i < length; i++) {
            a aVar2 = aVarArrB[i];
            byte[] bArrA = aVar2.a();
            int iC2 = aVar2.c();
            correctErrors(bArrA, iC2);
            for (int i2 = 0; i2 < iC2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return AbstractC3743qi.a(bArr);
    }
}
