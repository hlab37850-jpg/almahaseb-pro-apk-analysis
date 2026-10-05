package defpackage;

import java.lang.ref.SoftReference;

/* JADX INFO: renamed from: Cu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0405Cu {
    public static final char[] c = AbstractC3484nb.d();
    public static final byte[] d = AbstractC3484nb.c();
    public static final ThreadLocal e = new ThreadLocal();
    public R8 a;
    public final char[] b = {'\\', 0, '0', '0', 0, 0};

    public static C0405Cu d() {
        ThreadLocal threadLocal = e;
        SoftReference softReference = (SoftReference) threadLocal.get();
        C0405Cu c0405Cu = softReference == null ? null : (C0405Cu) softReference.get();
        if (c0405Cu != null) {
            return c0405Cu;
        }
        C0405Cu c0405Cu2 = new C0405Cu();
        threadLocal.set(new SoftReference(c0405Cu2));
        return c0405Cu2;
    }

    public final int a(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    public final void b(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < 55296) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i <= 56319) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dc A[SYNTHETIC] */
    public byte[] c(String str) {
        int i;
        int i2;
        R8 r8 = this.a;
        if (r8 == null) {
            r8 = new R8(null);
            this.a = r8;
        }
        int length = str.length();
        byte[] bArrT = r8.t();
        int length2 = bArrT.length;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i3 < length) {
            int i5 = i3 + 1;
            char cCharAt = str.charAt(i3);
            while (cCharAt <= 127) {
                if (i4 >= length2) {
                    bArrT = r8.i();
                    length2 = bArrT.length;
                    i4 = 0;
                }
                int i6 = i4 + 1;
                bArrT[i4] = (byte) cCharAt;
                if (i5 >= length) {
                    i4 = i6;
                    break loop0;
                }
                char cCharAt2 = str.charAt(i5);
                i5++;
                cCharAt = cCharAt2;
                i4 = i6;
            }
            if (i4 >= length2) {
                bArrT = r8.i();
                length2 = bArrT.length;
                i4 = 0;
            }
            if (cCharAt < 2048) {
                i = i4 + 1;
                bArrT[i4] = (byte) ((cCharAt >> 6) | 192);
            } else {
                if (cCharAt < 55296 || cCharAt > 57343) {
                    int i7 = i4 + 1;
                    bArrT[i4] = (byte) ((cCharAt >> '\f') | 224);
                    if (i7 >= length2) {
                        bArrT = r8.i();
                        length2 = bArrT.length;
                        i7 = 0;
                    }
                    bArrT[i7] = (byte) (((cCharAt >> 6) & 63) | 128);
                    i = i7 + 1;
                } else {
                    if (cCharAt > 56319) {
                        b(cCharAt);
                    }
                    if (i5 >= length) {
                        b(cCharAt);
                    }
                    int i8 = i5 + 1;
                    int iA = a(cCharAt, str.charAt(i5));
                    if (iA > 1114111) {
                        b(iA);
                    }
                    int i9 = i4 + 1;
                    bArrT[i4] = (byte) ((iA >> 18) | 240);
                    if (i9 >= length2) {
                        bArrT = r8.i();
                        length2 = bArrT.length;
                        i9 = 0;
                    }
                    int i10 = i9 + 1;
                    bArrT[i9] = (byte) (((iA >> 12) & 63) | 128);
                    if (i10 >= length2) {
                        bArrT = r8.i();
                        length2 = bArrT.length;
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    bArrT[i10] = (byte) (((iA >> 6) & 63) | 128);
                    i2 = iA;
                    i3 = i8;
                    i = i11;
                }
                if (i >= length2) {
                    bArrT = r8.i();
                    length2 = bArrT.length;
                    i = 0;
                }
                bArrT[i] = (byte) ((i2 & 63) | 128);
                i4 = i + 1;
            }
            i2 = cCharAt;
            i3 = i5;
            if (i >= length2) {
                bArrT = r8.i();
                length2 = bArrT.length;
                i = 0;
            }
            bArrT[i] = (byte) ((i2 & 63) | 128);
            i4 = i + 1;
        }
        return this.a.g(i4);
    }
}
