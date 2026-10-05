package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.C3327le0;
import defpackage.C4142vf0;
import defpackage.InterfaceC3167jg0;
import defpackage.Lg0;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public static int a(int i, byte[] bArr, int i2, int i3, zzjl zzjlVar, C3327le0 c3327le0) {
        C4142vf0 c4142vf0 = (C4142vf0) zzjlVar;
        int iJ = j(bArr, i2, c3327le0);
        c4142vf0.b(c3327le0.a);
        while (iJ < i3) {
            int iJ2 = j(bArr, iJ, c3327le0);
            if (i != c3327le0.a) {
                break;
            }
            iJ = j(bArr, iJ2, c3327le0);
            c4142vf0.b(c3327le0.a);
        }
        return iJ;
    }

    public static int b(int i, byte[] bArr, int i2, int i3, zzlx zzlxVar, C3327le0 c3327le0) {
        if ((i >>> 3) == 0) {
            throw zzjk.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iK = k(bArr, i2, c3327le0);
            zzlxVar.zza(i, Long.valueOf(c3327le0.b));
            return iK;
        }
        if (i4 == 1) {
            zzlxVar.zza(i, Long.valueOf(l(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iJ = j(bArr, i2, c3327le0);
            int i5 = c3327le0.a;
            if (i5 < 0) {
                throw zzjk.zzb();
            }
            if (i5 > bArr.length - iJ) {
                throw zzjk.zza();
            }
            if (i5 == 0) {
                zzlxVar.zza(i, zzht.zza);
            } else {
                zzlxVar.zza(i, zzht.zza(bArr, iJ, i5));
            }
            return iJ + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzjk.zzd();
            }
            zzlxVar.zza(i, Integer.valueOf(h(bArr, i2)));
            return i2 + 4;
        }
        zzlx zzlxVarZzb = zzlx.zzb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iJ2 = j(bArr, i2, c3327le0);
            int i8 = c3327le0.a;
            i7 = i8;
            if (i8 == i6) {
                i2 = iJ2;
                break;
            }
            int iB = b(i7, bArr, iJ2, i3, zzlxVarZzb, c3327le0);
            i7 = i8;
            i2 = iB;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzjk.zzg();
        }
        zzlxVar.zza(i, zzlxVarZzb);
        return i2;
    }

    public static int c(int i, byte[] bArr, int i2, int i3, C3327le0 c3327le0) {
        if ((i >>> 3) == 0) {
            throw zzjk.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return k(bArr, i2, c3327le0);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return j(bArr, i2, c3327le0) + c3327le0.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzjk.zzd();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = j(bArr, i2, c3327le0);
            i6 = c3327le0.a;
            if (i6 == i5) {
                break;
            }
            i2 = c(i6, bArr, i2, i3, c3327le0);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzjk.zzg();
        }
        return i2;
    }

    public static int d(int i, byte[] bArr, int i2, C3327le0 c3327le0) {
        int i3 = i & ShapeTypes.VERTICAL_SCROLL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            c3327le0.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Ascii.DEL) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            c3327le0.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c3327le0.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c3327le0.a = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c3327le0.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int e(InterfaceC3167jg0 interfaceC3167jg0, int i, byte[] bArr, int i2, int i3, zzjl zzjlVar, C3327le0 c3327le0) {
        int iG = g(interfaceC3167jg0, bArr, i2, i3, c3327le0);
        zzjlVar.add(c3327le0.c);
        while (iG < i3) {
            int iJ = j(bArr, iG, c3327le0);
            if (i != c3327le0.a) {
                break;
            }
            iG = g(interfaceC3167jg0, bArr, iJ, i3, c3327le0);
            zzjlVar.add(c3327le0.c);
        }
        return iG;
    }

    public static int f(InterfaceC3167jg0 interfaceC3167jg0, byte[] bArr, int i, int i2, int i3, C3327le0 c3327le0) {
        x xVar = (x) interfaceC3167jg0;
        Object objZza = xVar.zza();
        int iL = xVar.l(objZza, bArr, i, i2, i3, c3327le0);
        xVar.a(objZza);
        c3327le0.c = objZza;
        return iL;
    }

    public static int g(InterfaceC3167jg0 interfaceC3167jg0, byte[] bArr, int i, int i2, C3327le0 c3327le0) {
        int iD = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iD = d(i3, bArr, iD, c3327le0);
            i3 = c3327le0.a;
        }
        int i4 = iD;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzjk.zza();
        }
        Object objZza = interfaceC3167jg0.zza();
        int i5 = i3 + i4;
        interfaceC3167jg0.b(objZza, bArr, i4, i5, c3327le0);
        interfaceC3167jg0.a(objZza);
        c3327le0.c = objZza;
        return i5;
    }

    public static int h(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static int i(byte[] bArr, int i, zzjl zzjlVar, C3327le0 c3327le0) {
        C4142vf0 c4142vf0 = (C4142vf0) zzjlVar;
        int iJ = j(bArr, i, c3327le0);
        int i2 = c3327le0.a + iJ;
        while (iJ < i2) {
            iJ = j(bArr, iJ, c3327le0);
            c4142vf0.b(c3327le0.a);
        }
        if (iJ == i2) {
            return iJ;
        }
        throw zzjk.zza();
    }

    public static int j(byte[] bArr, int i, C3327le0 c3327le0) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return d(b, bArr, i2, c3327le0);
        }
        c3327le0.a = b;
        return i2;
    }

    public static int k(byte[] bArr, int i, C3327le0 c3327le0) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c3327le0.b = j;
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
        c3327le0.b = j2;
        return i3;
    }

    public static long l(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static double m(byte[] bArr, int i) {
        return Double.longBitsToDouble(l(bArr, i));
    }

    public static int n(byte[] bArr, int i, C3327le0 c3327le0) {
        int iJ = j(bArr, i, c3327le0);
        int i2 = c3327le0.a;
        if (i2 < 0) {
            throw zzjk.zzb();
        }
        if (i2 == 0) {
            c3327le0.c = "";
            return iJ;
        }
        c3327le0.c = new String(bArr, iJ, i2, zzjf.zza);
        return iJ + i2;
    }

    public static float o(byte[] bArr, int i) {
        return Float.intBitsToFloat(h(bArr, i));
    }

    public static int p(byte[] bArr, int i, C3327le0 c3327le0) {
        int iJ = j(bArr, i, c3327le0);
        int i2 = c3327le0.a;
        if (i2 < 0) {
            throw zzjk.zzb();
        }
        if (i2 == 0) {
            c3327le0.c = "";
            return iJ;
        }
        c3327le0.c = Lg0.k(bArr, iJ, i2);
        return iJ + i2;
    }

    public static int q(byte[] bArr, int i, C3327le0 c3327le0) {
        int iJ = j(bArr, i, c3327le0);
        int i2 = c3327le0.a;
        if (i2 < 0) {
            throw zzjk.zzb();
        }
        if (i2 > bArr.length - iJ) {
            throw zzjk.zza();
        }
        if (i2 == 0) {
            c3327le0.c = zzht.zza;
            return iJ;
        }
        c3327le0.c = zzht.zza(bArr, iJ, i2);
        return iJ + i2;
    }
}
