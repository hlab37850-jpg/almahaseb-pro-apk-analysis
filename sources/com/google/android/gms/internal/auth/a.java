package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.AbstractC3245ke0;
import defpackage.AbstractC3574of;
import defpackage.C1883ca0;
import defpackage.Zc0;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static int a(byte[] bArr, int i, C1883ca0 c1883ca0) {
        int iJ = j(bArr, i, c1883ca0);
        int i2 = c1883ca0.a;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 > bArr.length - iJ) {
            throw zzfa.zzf();
        }
        if (i2 == 0) {
            c1883ca0.c = zzee.zzb;
            return iJ;
        }
        c1883ca0.c = zzee.zzk(bArr, iJ, i2);
        return iJ + i2;
    }

    public static int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static int c(Zc0 zc0, byte[] bArr, int i, int i2, int i3, C1883ca0 c1883ca0) {
        d dVar = (d) zc0;
        Object objZzd = dVar.zzd();
        int iP = dVar.p(objZzd, bArr, i, i2, i3, c1883ca0);
        dVar.c(objZzd);
        c1883ca0.c = objZzd;
        return iP;
    }

    public static int d(Zc0 zc0, byte[] bArr, int i, int i2, C1883ca0 c1883ca0) {
        int iK = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iK = k(i3, bArr, iK, c1883ca0);
            i3 = c1883ca0.a;
        }
        int i4 = iK;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzfa.zzf();
        }
        Object objZzd = zc0.zzd();
        int i5 = i3 + i4;
        zc0.e(objZzd, bArr, i4, i5, c1883ca0);
        zc0.c(objZzd);
        c1883ca0.c = objZzd;
        return i5;
    }

    public static int e(Zc0 zc0, int i, byte[] bArr, int i2, int i3, zzey zzeyVar, C1883ca0 c1883ca0) {
        int iD = d(zc0, bArr, i2, i3, c1883ca0);
        zzeyVar.add(c1883ca0.c);
        while (iD < i3) {
            int iJ = j(bArr, iD, c1883ca0);
            if (i != c1883ca0.a) {
                break;
            }
            iD = d(zc0, bArr, iJ, i3, c1883ca0);
            zzeyVar.add(c1883ca0.c);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i, zzey zzeyVar, C1883ca0 c1883ca0) {
        AbstractC3574of.a(zzeyVar);
        int iJ = j(bArr, i, c1883ca0);
        int i2 = c1883ca0.a + iJ;
        if (iJ < i2) {
            j(bArr, iJ, c1883ca0);
            throw null;
        }
        if (iJ == i2) {
            return iJ;
        }
        throw zzfa.zzf();
    }

    public static int g(byte[] bArr, int i, C1883ca0 c1883ca0) throws zzfa {
        int iJ = j(bArr, i, c1883ca0);
        int i2 = c1883ca0.a;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 == 0) {
            c1883ca0.c = "";
            return iJ;
        }
        c1883ca0.c = new String(bArr, iJ, i2, zzez.zzb);
        return iJ + i2;
    }

    public static int h(byte[] bArr, int i, C1883ca0 c1883ca0) throws zzfa {
        int iJ = j(bArr, i, c1883ca0);
        int i2 = c1883ca0.a;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 == 0) {
            c1883ca0.c = "";
            return iJ;
        }
        c1883ca0.c = AbstractC3245ke0.b(bArr, iJ, i2);
        return iJ + i2;
    }

    public static int i(int i, byte[] bArr, int i2, int i3, zzgz zzgzVar, C1883ca0 c1883ca0) {
        if ((i >>> 3) == 0) {
            throw zzfa.zza();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM = m(bArr, i2, c1883ca0);
            zzgzVar.zzf(i, Long.valueOf(c1883ca0.b));
            return iM;
        }
        if (i4 == 1) {
            zzgzVar.zzf(i, Long.valueOf(n(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iJ = j(bArr, i2, c1883ca0);
            int i5 = c1883ca0.a;
            if (i5 < 0) {
                throw zzfa.zzc();
            }
            if (i5 > bArr.length - iJ) {
                throw zzfa.zzf();
            }
            if (i5 == 0) {
                zzgzVar.zzf(i, zzee.zzb);
            } else {
                zzgzVar.zzf(i, zzee.zzk(bArr, iJ, i5));
            }
            return iJ + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzfa.zza();
            }
            zzgzVar.zzf(i, Integer.valueOf(b(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzgz zzgzVarZzc = zzgz.zzc();
        int i7 = 0;
        while (i2 < i3) {
            int iJ2 = j(bArr, i2, c1883ca0);
            int i8 = c1883ca0.a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iJ2;
                break;
            }
            i7 = i8;
            i2 = i(i8, bArr, iJ2, i3, zzgzVarZzc, c1883ca0);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzfa.zzd();
        }
        zzgzVar.zzf(i, zzgzVarZzc);
        return i2;
    }

    public static int j(byte[] bArr, int i, C1883ca0 c1883ca0) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return k(b, bArr, i2, c1883ca0);
        }
        c1883ca0.a = b;
        return i2;
    }

    public static int k(int i, byte[] bArr, int i2, C1883ca0 c1883ca0) {
        int i3 = i & ShapeTypes.VERTICAL_SCROLL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            c1883ca0.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Ascii.DEL) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            c1883ca0.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c1883ca0.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c1883ca0.a = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c1883ca0.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int l(int i, byte[] bArr, int i2, int i3, zzey zzeyVar, C1883ca0 c1883ca0) {
        AbstractC3574of.a(zzeyVar);
        j(bArr, i2, c1883ca0);
        int i4 = c1883ca0.a;
        throw null;
    }

    public static int m(byte[] bArr, int i, C1883ca0 c1883ca0) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c1883ca0.b = j;
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
        c1883ca0.b = j2;
        return i3;
    }

    public static long n(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
