package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.C3859s80;
import defpackage.S50;
import defpackage.Xb0;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1912g {
    public static int a(int i, byte[] bArr, int i2, int i3, zzcn zzcnVar, S50 s50) {
        C3859s80 c3859s80 = (C3859s80) zzcnVar;
        int iF = f(bArr, i2, s50);
        while (true) {
            c3859s80.b(s50.a);
            if (iF >= i3) {
                break;
            }
            int iF2 = f(bArr, iF, s50);
            if (i != s50.a) {
                break;
            }
            iF = f(bArr, iF2, s50);
        }
        return iF;
    }

    public static int b(int i, byte[] bArr, int i2, int i3, zzey zzeyVar, S50 s50) throws zzco {
        if ((i >>> 3) == 0) {
            throw zzco.zzbm();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iG = g(bArr, i2, s50);
            zzeyVar.zzb(i, Long.valueOf(s50.b));
            return iG;
        }
        if (i4 == 1) {
            zzeyVar.zzb(i, Long.valueOf(k(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iF = f(bArr, i2, s50);
            int i5 = s50.a;
            zzeyVar.zzb(i, i5 == 0 ? zzbb.zzfi : zzbb.zzb(bArr, iF, i5));
            return iF + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzco.zzbm();
            }
            zzeyVar.zzb(i, Integer.valueOf(h(bArr, i2)));
            return i2 + 4;
        }
        zzey zzeyVarZzeb = zzey.zzeb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iF2 = f(bArr, i2, s50);
            int i8 = s50.a;
            i7 = i8;
            if (i8 == i6) {
                i2 = iF2;
                break;
            }
            int iB = b(i7, bArr, iF2, i3, zzeyVarZzeb, s50);
            i7 = i8;
            i2 = iB;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzco.zzbo();
        }
        zzeyVar.zzb(i, zzeyVarZzeb);
        return i2;
    }

    public static int c(int i, byte[] bArr, int i2, int i3, S50 s50) {
        if ((i >>> 3) == 0) {
            throw zzco.zzbm();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return g(bArr, i2, s50);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return f(bArr, i2, s50) + s50.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzco.zzbm();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = f(bArr, i2, s50);
            i6 = s50.a;
            if (i6 == i5) {
                break;
            }
            i2 = c(i6, bArr, i2, i3, s50);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzco.zzbo();
        }
        return i2;
    }

    public static int d(int i, byte[] bArr, int i2, S50 s50) {
        int i3;
        int i4 = i & ShapeTypes.VERTICAL_SCROLL;
        int i5 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            i3 = b << 7;
        } else {
            int i6 = i4 | ((b & Ascii.DEL) << 7);
            int i7 = i2 + 2;
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                s50.a = i6 | (b2 << 14);
                return i7;
            }
            i4 = i6 | ((b2 & Ascii.DEL) << 14);
            i5 = i2 + 3;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i3 = b3 << 21;
            } else {
                int i8 = i4 | ((b3 & Ascii.DEL) << 21);
                int i9 = i2 + 4;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    s50.a = i8 | (b4 << Ascii.FS);
                    return i9;
                }
                int i10 = i8 | ((b4 & Ascii.DEL) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        s50.a = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        s50.a = i4 | i3;
        return i5;
    }

    public static int e(byte[] bArr, int i, zzcn zzcnVar, S50 s50) {
        C3859s80 c3859s80 = (C3859s80) zzcnVar;
        int iF = f(bArr, i, s50);
        int i2 = s50.a + iF;
        while (iF < i2) {
            iF = f(bArr, iF, s50);
            c3859s80.b(s50.a);
        }
        if (iF == i2) {
            return iF;
        }
        throw zzco.zzbl();
    }

    public static int f(byte[] bArr, int i, S50 s50) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return d(b, bArr, i2, s50);
        }
        s50.a = b;
        return i2;
    }

    public static int g(byte[] bArr, int i, S50 s50) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            s50.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Ascii.DEL)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Ascii.DEL)) << i4;
            b = b2;
            i3 = i5;
        }
        s50.b = j2;
        return i3;
    }

    public static int h(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static int i(byte[] bArr, int i, S50 s50) {
        int iF = f(bArr, i, s50);
        int i2 = s50.a;
        if (i2 == 0) {
            s50.c = "";
            return iF;
        }
        s50.c = new String(bArr, iF, i2, zzci.UTF_8);
        return iF + i2;
    }

    public static int j(byte[] bArr, int i, S50 s50) throws zzco {
        int iF = f(bArr, i, s50);
        int i2 = s50.a;
        if (i2 == 0) {
            s50.c = "";
            return iF;
        }
        int i3 = iF + i2;
        if (!Xb0.i(bArr, iF, i3)) {
            throw zzco.zzbp();
        }
        s50.c = new String(bArr, iF, i2, zzci.UTF_8);
        return i3;
    }

    public static long k(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static double l(byte[] bArr, int i) {
        return Double.longBitsToDouble(k(bArr, i));
    }

    public static int m(byte[] bArr, int i, S50 s50) {
        int iF = f(bArr, i, s50);
        int i2 = s50.a;
        if (i2 == 0) {
            s50.c = zzbb.zzfi;
            return iF;
        }
        s50.c = zzbb.zzb(bArr, iF, i2);
        return iF + i2;
    }

    public static float n(byte[] bArr, int i) {
        return Float.intBitsToFloat(h(bArr, i));
    }
}
