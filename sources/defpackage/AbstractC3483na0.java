package defpackage;

import com.google.android.gms.internal.play_billing.u;
import com.google.android.gms.internal.play_billing.zzei;
import com.google.android.gms.internal.play_billing.zzfn;
import com.google.android.gms.internal.play_billing.zzfq;
import com.google.android.gms.internal.play_billing.zzhi;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: na0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3483na0 {
    public static volatile int a = 100;

    public static int a(byte[] bArr, int i, C3237ka0 c3237ka0) throws zzfq {
        int i2 = i(bArr, i, c3237ka0);
        int i3 = c3237ka0.a;
        if (i3 < 0) {
            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 > bArr.length - i2) {
            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i3 == 0) {
            c3237ka0.c = zzei.zzb;
            return i2;
        }
        c3237ka0.c = zzei.zzj(bArr, i2, i3);
        return i2 + i3;
    }

    public static int b(byte[] bArr, int i) {
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        int i4 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int c(InterfaceC3814rd0 interfaceC3814rd0, byte[] bArr, int i, int i2, int i3, C3237ka0 c3237ka0) throws zzfq {
        Object objZze = interfaceC3814rd0.zze();
        int iM = m(objZze, interfaceC3814rd0, bArr, i, i2, i3, c3237ka0);
        interfaceC3814rd0.b(objZze);
        c3237ka0.c = objZze;
        return iM;
    }

    public static int d(InterfaceC3814rd0 interfaceC3814rd0, byte[] bArr, int i, int i2, C3237ka0 c3237ka0) throws zzfq {
        Object objZze = interfaceC3814rd0.zze();
        int iN = n(objZze, interfaceC3814rd0, bArr, i, i2, c3237ka0);
        interfaceC3814rd0.b(objZze);
        c3237ka0.c = objZze;
        return iN;
    }

    public static int e(InterfaceC3814rd0 interfaceC3814rd0, int i, byte[] bArr, int i2, int i3, zzfn zzfnVar, C3237ka0 c3237ka0) throws zzfq {
        int iD = d(interfaceC3814rd0, bArr, i2, i3, c3237ka0);
        zzfnVar.add(c3237ka0.c);
        while (iD < i3) {
            int i4 = i(bArr, iD, c3237ka0);
            if (i != c3237ka0.a) {
                break;
            }
            iD = d(interfaceC3814rd0, bArr, i4, i3, c3237ka0);
            zzfnVar.add(c3237ka0.c);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i, zzfn zzfnVar, C3237ka0 c3237ka0) throws zzfq {
        C2208fc0 c2208fc0 = (C2208fc0) zzfnVar;
        int i2 = i(bArr, i, c3237ka0);
        int i3 = c3237ka0.a + i2;
        while (i2 < i3) {
            i2 = i(bArr, i2, c3237ka0);
            c2208fc0.d(c3237ka0.a);
        }
        if (i2 == i3) {
            return i2;
        }
        throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int g(byte[] bArr, int i, C3237ka0 c3237ka0) throws zzfq {
        int i2;
        int i3 = i(bArr, i, c3237ka0);
        int i4 = c3237ka0.a;
        if (i4 < 0) {
            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            c3237ka0.c = "";
            return i3;
        }
        int i5 = AbstractC3978te0.a;
        int length = bArr.length;
        if ((((length - i3) - i4) | i3 | i4) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        int i6 = i3 + i4;
        char[] cArr = new char[i4];
        int i7 = 0;
        while (i3 < i6) {
            byte b = bArr[i3];
            if (!AbstractC3573oe0.d(b)) {
                break;
            }
            i3++;
            cArr[i7] = (char) b;
            i7++;
        }
        int i8 = i7;
        while (i3 < i6) {
            int i9 = i3 + 1;
            byte b2 = bArr[i3];
            if (AbstractC3573oe0.d(b2)) {
                cArr[i8] = (char) b2;
                i8++;
                i3 = i9;
                while (i3 < i6) {
                    byte b3 = bArr[i3];
                    if (!AbstractC3573oe0.d(b3)) {
                        break;
                    }
                    i3++;
                    cArr[i8] = (char) b3;
                    i8++;
                }
            } else {
                if (b2 < -32) {
                    if (i9 >= i6) {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                    i2 = i8 + 1;
                    i3 += 2;
                    AbstractC3573oe0.c(b2, bArr[i9], cArr, i8);
                } else if (b2 < -16) {
                    if (i9 >= i6 - 1) {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                    i2 = i8 + 1;
                    int i10 = i3 + 2;
                    i3 += 3;
                    AbstractC3573oe0.b(b2, bArr[i9], bArr[i10], cArr, i8);
                } else {
                    if (i9 >= i6 - 2) {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                    byte b4 = bArr[i9];
                    int i11 = i3 + 3;
                    byte b5 = bArr[i3 + 2];
                    i3 += 4;
                    AbstractC3573oe0.a(b2, b4, b5, bArr[i11], cArr, i8);
                    i8 += 2;
                }
                i8 = i2;
            }
        }
        c3237ka0.c = new String(cArr, 0, i8);
        return i6;
    }

    public static int h(int i, byte[] bArr, int i2, int i3, zzhi zzhiVar, C3237ka0 c3237ka0) throws zzfq {
        if ((i >>> 3) == 0) {
            throw new zzfq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iL = l(bArr, i2, c3237ka0);
            zzhiVar.zzj(i, Long.valueOf(c3237ka0.b));
            return iL;
        }
        if (i4 == 1) {
            zzhiVar.zzj(i, Long.valueOf(o(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int i5 = i(bArr, i2, c3237ka0);
            int i6 = c3237ka0.a;
            if (i6 < 0) {
                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i6 > bArr.length - i5) {
                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i6 == 0) {
                zzhiVar.zzj(i, zzei.zzb);
            } else {
                zzhiVar.zzj(i, zzei.zzj(bArr, i5, i6));
            }
            return i5 + i6;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzfq("Protocol message contained an invalid tag (zero).");
            }
            zzhiVar.zzj(i, Integer.valueOf(b(bArr, i2)));
            return i2 + 4;
        }
        int i7 = (i & (-8)) | 4;
        zzhi zzhiVarZzf = zzhi.zzf();
        int i8 = c3237ka0.e + 1;
        c3237ka0.e = i8;
        p(i8);
        int i9 = 0;
        while (i2 < i3) {
            int i10 = i(bArr, i2, c3237ka0);
            i9 = c3237ka0.a;
            if (i9 == i7) {
                i2 = i10;
                break;
            }
            i2 = h(i9, bArr, i10, i3, zzhiVarZzf, c3237ka0);
        }
        c3237ka0.e--;
        if (i2 > i3 || i9 != i7) {
            throw new zzfq("Failed to parse the message.");
        }
        zzhiVar.zzj(i, zzhiVarZzf);
        return i2;
    }

    public static int i(byte[] bArr, int i, C3237ka0 c3237ka0) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return j(b, bArr, i2, c3237ka0);
        }
        c3237ka0.a = b;
        return i2;
    }

    public static int j(int i, byte[] bArr, int i2, C3237ka0 c3237ka0) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & ShapeTypes.VERTICAL_SCROLL;
        if (b >= 0) {
            c3237ka0.a = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Ascii.DEL) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            c3237ka0.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c3237ka0.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c3237ka0.a = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c3237ka0.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int k(int i, byte[] bArr, int i2, int i3, zzfn zzfnVar, C3237ka0 c3237ka0) {
        C2208fc0 c2208fc0 = (C2208fc0) zzfnVar;
        int i4 = i(bArr, i2, c3237ka0);
        c2208fc0.d(c3237ka0.a);
        while (i4 < i3) {
            int i5 = i(bArr, i4, c3237ka0);
            if (i != c3237ka0.a) {
                break;
            }
            i4 = i(bArr, i5, c3237ka0);
            c2208fc0.d(c3237ka0.a);
        }
        return i4;
    }

    public static int l(byte[] bArr, int i, C3237ka0 c3237ka0) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            c3237ka0.b = j;
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
        c3237ka0.b = j2;
        return i3;
    }

    public static int m(Object obj, InterfaceC3814rd0 interfaceC3814rd0, byte[] bArr, int i, int i2, int i3, C3237ka0 c3237ka0) throws zzfq {
        u uVar = (u) interfaceC3814rd0;
        int i4 = c3237ka0.e + 1;
        c3237ka0.e = i4;
        p(i4);
        int iV = uVar.v(obj, bArr, i, i2, i3, c3237ka0);
        c3237ka0.e--;
        c3237ka0.c = obj;
        return iV;
    }

    public static int n(Object obj, InterfaceC3814rd0 interfaceC3814rd0, byte[] bArr, int i, int i2, C3237ka0 c3237ka0) throws zzfq {
        int iJ = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iJ = j(i3, bArr, iJ, c3237ka0);
            i3 = c3237ka0.a;
        }
        int i4 = iJ;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = c3237ka0.e + 1;
        c3237ka0.e = i5;
        p(i5);
        int i6 = i3 + i4;
        interfaceC3814rd0.f(obj, bArr, i4, i6, c3237ka0);
        c3237ka0.e--;
        c3237ka0.c = obj;
        return i6;
    }

    public static long o(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public static void p(int i) throws zzfq {
        if (i >= a) {
            throw new zzfq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
