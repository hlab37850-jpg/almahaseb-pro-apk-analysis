package defpackage;

import com.google.common.net.HttpHeaders;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Z8 {
    public static T8 a(BF bf, T8 t8, BF bf2) {
        int iF = t8.F();
        byte[] bArr = new byte[iF];
        t8.k(bArr, 0, iF);
        return T8.K(b(bf, bArr));
    }

    public static byte[] b(BF bf, byte[] bArr) {
        BF bfJ = bf.j(HttpHeaders.WIDTH);
        if (bfJ == null) {
            bfJ = bf.j("W");
        }
        int iN = bfJ != null ? bfJ.n() : 1728;
        BF bfJ2 = bf.j("Height");
        if (bfJ2 == null) {
            bfJ2 = bf.j("H");
        }
        int iN2 = bfJ2 != null ? bfJ2.n() : 0;
        int iD = d(bf, "Columns", iN);
        int iD2 = d(bf, "Rows", iN2);
        int iD3 = d(bf, "K", 0);
        int i = ((iD + 7) >> 3) * iD2;
        byte[] bArr2 = new byte[i];
        boolean zC = c(bf, "EncodedByteAlign", false);
        C1207a9 c1207a9 = new C1207a9(1, iD, iD2);
        c1207a9.n(zC);
        if (iD3 == 0) {
            c1207a9.e(bArr2, bArr, 0, iD2);
        } else if (iD3 > 0) {
            c1207a9.f(bArr2, bArr, 0, iD2);
        } else if (iD3 < 0) {
            c1207a9.g(bArr2, bArr, 0, iD2);
        }
        if (!c(bf, "BlackIs1", false)) {
            for (int i2 = 0; i2 < i; i2++) {
                bArr2[i2] = (byte) (~bArr2[i2]);
            }
        }
        return bArr2;
    }

    public static boolean c(BF bf, String str, boolean z) {
        BF bfJ;
        BF bfJ2 = bf.j("DecodeParms");
        return (bfJ2 == null || (bfJ = bfJ2.j(str)) == null) ? z : bfJ.f();
    }

    public static int d(BF bf, String str, int i) {
        BF bfJ;
        BF bfJ2 = bf.j("DecodeParms");
        return (bfJ2 == null || (bfJ = bfJ2.j(str)) == null) ? i : bfJ.n();
    }
}
