package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Lg0 {
    public static final Mg0 a;

    static {
        a = (Ig0.m() && Ig0.r() && !Zd0.b()) ? new Rg0() : new Pg0();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 2048) {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new Og0(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                break;
            }
            i3 += (127 - cCharAt) >>> 31;
            i2++;
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int e(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return a.b(charSequence, bArr, i, i2);
    }

    public static boolean f(byte[] bArr) {
        return a.c(bArr, 0, bArr.length);
    }

    public static boolean g(byte[] bArr, int i, int i2) {
        return a.c(bArr, i, i2);
    }

    public static int h(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int i(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int j(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static String k(byte[] bArr, int i, int i2) {
        return a.d(bArr, i, i2);
    }

    public static int m(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return h(b);
        }
        if (i3 == 1) {
            return i(b, bArr[i]);
        }
        if (i3 == 2) {
            return j(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }
}
