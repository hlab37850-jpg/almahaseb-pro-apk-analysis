package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final int a;
    public final byte[] b;

    public a(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public static a[] b(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int count = 0;
        for (Version.ECB ecb : eCBlocks) {
            count += ecb.getCount();
        }
        a[] aVarArr = new a[count];
        int i = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i2 = 0;
            while (i2 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                aVarArr[i] = new a(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i2++;
                i++;
            }
        }
        int length = aVarArr[0].b.length;
        int i3 = count - 1;
        while (i3 >= 0 && aVarArr[i3].b.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i5 = 0;
        for (int i6 = 0; i6 < eCCodewordsPerBlock; i6++) {
            int i7 = 0;
            while (i7 < i) {
                aVarArr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            aVarArr[i8].b[eCCodewordsPerBlock] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = aVarArr[0].b.length;
        while (eCCodewordsPerBlock < length2) {
            int i9 = 0;
            while (i9 < i) {
                aVarArr[i9].b[i9 < i4 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i5];
                i9++;
                i5++;
            }
            eCCodewordsPerBlock++;
        }
        return aVarArr;
    }

    public byte[] a() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}
