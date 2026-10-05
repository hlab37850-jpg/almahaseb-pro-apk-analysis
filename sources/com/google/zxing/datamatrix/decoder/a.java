package com.google.zxing.datamatrix.decoder;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final int a;
    public final byte[] b;

    public a(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public static a[] b(byte[] bArr, Version version) {
        Version.c eCBlocks = version.getECBlocks();
        Version.b[] bVarArrA = eCBlocks.a();
        int iA = 0;
        for (Version.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        a[] aVarArr = new a[iA];
        int i = 0;
        for (Version.b bVar2 : bVarArrA) {
            int i2 = 0;
            while (i2 < bVar2.a()) {
                int iB = bVar2.b();
                aVarArr[i] = new a(iB, new byte[eCBlocks.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = aVarArr[0].b.length - eCBlocks.b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                aVarArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = version.getVersionNumber() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            aVarArr[i8].b[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = aVarArr[0].b.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                aVarArr[i10].b[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return aVarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}
