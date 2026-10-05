package com.google.zxing.qrcode.decoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import defpackage.AbstractC3985ti;
import defpackage.C1852c8;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Decoder {
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

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
        return decode(zArr, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) {
        return decode(BitMatrix.parse(zArr), map);
    }

    public DecoderResult decode(BitMatrix bitMatrix) {
        return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException e;
        C1852c8 c1852c8 = new C1852c8(bitMatrix);
        FormatException formatException = null;
        try {
            return decode(c1852c8, map);
        } catch (ChecksumException e2) {
            e = e2;
            try {
                c1852c8.f();
                c1852c8.g(true);
                c1852c8.e();
                c1852c8.d();
                c1852c8.b();
                DecoderResult decoderResultDecode = decode(c1852c8, map);
                decoderResultDecode.setOther(new QRCodeDecoderMetaData(true));
                return decoderResultDecode;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e;
            }
        } catch (FormatException e3) {
            e = null;
            formatException = e3;
            c1852c8.f();
            c1852c8.g(true);
            c1852c8.e();
            c1852c8.d();
            c1852c8.b();
            DecoderResult decoderResultDecode2 = decode(c1852c8, map);
            decoderResultDecode2.setOther(new QRCodeDecoderMetaData(true));
            return decoderResultDecode2;
        }
    }

    private DecoderResult decode(C1852c8 c1852c8, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        Version versionE = c1852c8.e();
        ErrorCorrectionLevel errorCorrectionLevelD = c1852c8.d().d();
        a[] aVarArrB = a.b(c1852c8.c(), versionE, errorCorrectionLevelD);
        int iC = 0;
        for (a aVar : aVarArrB) {
            iC += aVar.c();
        }
        byte[] bArr = new byte[iC];
        int i = 0;
        for (a aVar2 : aVarArrB) {
            byte[] bArrA = aVar2.a();
            int iC2 = aVar2.c();
            correctErrors(bArrA, iC2);
            int i2 = 0;
            while (i2 < iC2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return AbstractC3985ti.a(bArr, versionE, errorCorrectionLevelD, map);
    }
}
