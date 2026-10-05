package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;

/* JADX INFO: renamed from: b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1754b {
    public static final byte[] a = D00.a("0123456789abcdef");

    public static final H8.a a(H8 h8, H8.a aVar) {
        AbstractC4492zt.h(h8, "<this>");
        AbstractC4492zt.h(aVar, "unsafeCursor");
        H8.a aVarG = AbstractC2074e.g(aVar);
        if (aVarG.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVarG.a = h8;
        aVarG.b = true;
        return aVarG;
    }

    public static final byte[] b() {
        return a;
    }

    public static final String c(H8 h8, long j) throws EOFException {
        AbstractC4492zt.h(h8, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (h8.x(j2) == 13) {
                String strP = h8.P(j2);
                h8.skip(2L);
                return strP;
            }
        }
        String strP2 = h8.P(j);
        h8.skip(1L);
        return strP2;
    }

    public static final int d(H8 h8, XE xe, boolean z) {
        int i;
        int i2;
        C3306lO c3306lO;
        int i3;
        int i4;
        AbstractC4492zt.h(h8, "<this>");
        AbstractC4492zt.h(xe, "options");
        C3306lO c3306lO2 = h8.a;
        if (c3306lO2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = c3306lO2.a;
        int i5 = c3306lO2.b;
        int i6 = c3306lO2.c;
        int[] iArrE = xe.e();
        C3306lO c3306lO3 = c3306lO2;
        int i7 = 0;
        int i8 = -1;
        loop0: while (true) {
            int i9 = i7 + 1;
            int i10 = iArrE[i7];
            int i11 = i7 + 2;
            int i12 = iArrE[i9];
            if (i12 != -1) {
                i8 = i12;
            }
            if (c3306lO3 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & UnsignedBytes.MAX_VALUE;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == iArrE[i11]) {
                        i2 = iArrE[i11 + i10];
                        if (i == i6) {
                            c3306lO3 = c3306lO3.f;
                            AbstractC4492zt.e(c3306lO3);
                            i = c3306lO3.b;
                            bArr = c3306lO3.a;
                            i6 = c3306lO3.c;
                            if (c3306lO3 == c3306lO2) {
                                c3306lO3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i8;
            }
            int i15 = i11 + (i10 * (-1));
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & UnsignedBytes.MAX_VALUE) != iArrE[i11]) {
                    return i8;
                }
                boolean z2 = i17 == i15;
                if (i16 == i6) {
                    AbstractC4492zt.e(c3306lO3);
                    C3306lO c3306lO4 = c3306lO3.f;
                    AbstractC4492zt.e(c3306lO4);
                    i4 = c3306lO4.b;
                    byte[] bArr2 = c3306lO4.a;
                    i3 = c3306lO4.c;
                    if (c3306lO4 != c3306lO2) {
                        c3306lO = c3306lO4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        c3306lO = null;
                    }
                } else {
                    c3306lO = c3306lO3;
                    i3 = i6;
                    i4 = i16;
                }
                if (z2) {
                    i2 = iArrE[i17];
                    i = i4;
                    i6 = i3;
                    c3306lO3 = c3306lO;
                    break;
                }
                i5 = i4;
                i6 = i3;
                c3306lO3 = c3306lO;
                i11 = i17;
            }
            if (i2 >= 0) {
                return i2;
            }
            i7 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i8;
    }

    public static /* synthetic */ int e(H8 h8, XE xe, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return d(h8, xe, z);
    }
}
