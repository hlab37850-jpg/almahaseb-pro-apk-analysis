package defpackage;

import com.itextpdf.text.pdf.PdfWriter;

/* JADX INFO: renamed from: cE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1860cE {
    public static int a = 1000000;
    public static int b = 1000000000;
    public static long c = 10000000000L;
    public static long d = 1000;
    public static long e = -2147483648L;
    public static long f = 2147483647L;
    public static final String g = String.valueOf(Long.MIN_VALUE);
    public static final char[] h = new char[4000];
    public static final char[] i = new char[4000];
    public static final byte[] j;
    public static final String[] k;
    public static final String[] l;

    static {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 10) {
            char c2 = (char) (i2 + 48);
            char c3 = i2 == 0 ? (char) 0 : c2;
            int i4 = 0;
            while (i4 < 10) {
                char c4 = (char) (i4 + 48);
                char c5 = (i2 == 0 && i4 == 0) ? (char) 0 : c4;
                for (int i5 = 0; i5 < 10; i5++) {
                    char c6 = (char) (i5 + 48);
                    char[] cArr = h;
                    cArr[i3] = c3;
                    int i6 = i3 + 1;
                    cArr[i6] = c5;
                    int i7 = i3 + 2;
                    cArr[i7] = c6;
                    char[] cArr2 = i;
                    cArr2[i3] = c2;
                    cArr2[i6] = c4;
                    cArr2[i7] = c6;
                    i3 += 4;
                }
                i4++;
            }
            i2++;
        }
        j = new byte[4000];
        for (int i8 = 0; i8 < 4000; i8++) {
            j[i8] = (byte) i[i8];
        }
        k = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        l = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int a(long j2) {
        int i2 = 10;
        for (long j3 = c; j2 >= j3 && i2 != 19; j3 = (j3 << 1) + (j3 << 3)) {
            i2++;
        }
        return i2;
    }

    public static int b(int i2, byte[] bArr, int i3) {
        int i4 = i2 << 2;
        byte[] bArr2 = j;
        bArr[i3] = bArr2[i4];
        int i5 = i3 + 2;
        bArr[i3 + 1] = bArr2[i4 + 1];
        int i6 = i3 + 3;
        bArr[i5] = bArr2[i4 + 2];
        return i6;
    }

    public static int c(int i2, char[] cArr, int i3) {
        int i4 = i2 << 2;
        char[] cArr2 = i;
        cArr[i3] = cArr2[i4];
        int i5 = i3 + 2;
        cArr[i3 + 1] = cArr2[i4 + 1];
        int i6 = i3 + 3;
        cArr[i5] = cArr2[i4 + 2];
        return i6;
    }

    public static int d(int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return h(i2, bArr, i3);
            }
            bArr[i3] = 45;
            i2 = -i2;
            i3++;
        }
        if (i2 < a) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return b(i2 - (i5 * 1000), bArr, f(i5, bArr, i3));
            }
            if (i2 >= 10) {
                return f(i2, bArr, i3);
            }
            int i6 = i3 + 1;
            bArr[i3] = (byte) (i2 + 48);
            return i6;
        }
        int i7 = b;
        boolean z = i2 >= i7;
        if (z) {
            i2 -= i7;
            if (i2 >= i7) {
                i2 -= i7;
                i4 = i3 + 1;
                bArr[i3] = 50;
            } else {
                i4 = i3 + 1;
                bArr[i3] = 49;
            }
            i3 = i4;
        }
        int i8 = i2 / 1000;
        int i9 = i8 / 1000;
        return b(i2 - (i8 * 1000), bArr, b(i8 - (i9 * 1000), bArr, z ? b(i9, bArr, i3) : f(i9, bArr, i3)));
    }

    public static int e(int i2, char[] cArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return i(i2, cArr, i3);
            }
            cArr[i3] = '-';
            i2 = -i2;
            i3++;
        }
        if (i2 < a) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return c(i2 - (i5 * 1000), cArr, g(i5, cArr, i3));
            }
            if (i2 >= 10) {
                return g(i2, cArr, i3);
            }
            int i6 = i3 + 1;
            cArr[i3] = (char) (i2 + 48);
            return i6;
        }
        int i7 = b;
        boolean z = i2 >= i7;
        if (z) {
            i2 -= i7;
            if (i2 >= i7) {
                i2 -= i7;
                i4 = i3 + 1;
                cArr[i3] = PdfWriter.VERSION_1_2;
            } else {
                i4 = i3 + 1;
                cArr[i3] = '1';
            }
            i3 = i4;
        }
        int i8 = i2 / 1000;
        int i9 = i8 / 1000;
        return c(i2 - (i8 * 1000), cArr, c(i8 - (i9 * 1000), cArr, z ? c(i9, cArr, i3) : g(i9, cArr, i3)));
    }

    public static int f(int i2, byte[] bArr, int i3) {
        int i4 = i2 << 2;
        char[] cArr = h;
        int i5 = i4 + 1;
        char c2 = cArr[i4];
        if (c2 != 0) {
            bArr[i3] = (byte) c2;
            i3++;
        }
        int i6 = i4 + 2;
        char c3 = cArr[i5];
        if (c3 != 0) {
            bArr[i3] = (byte) c3;
            i3++;
        }
        int i7 = i3 + 1;
        bArr[i3] = (byte) cArr[i6];
        return i7;
    }

    public static int g(int i2, char[] cArr, int i3) {
        int i4 = i2 << 2;
        char[] cArr2 = h;
        int i5 = i4 + 1;
        char c2 = cArr2[i4];
        if (c2 != 0) {
            cArr[i3] = c2;
            i3++;
        }
        int i6 = i4 + 2;
        char c3 = cArr2[i5];
        if (c3 != 0) {
            cArr[i3] = c3;
            i3++;
        }
        int i7 = i3 + 1;
        cArr[i3] = cArr2[i6];
        return i7;
    }

    public static int h(long j2, byte[] bArr, int i2) {
        if (j2 < 0) {
            if (j2 > e) {
                return d((int) j2, bArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                int length = g.length();
                int i3 = 0;
                while (i3 < length) {
                    bArr[i2] = (byte) g.charAt(i3);
                    i3++;
                    i2++;
                }
                return i2;
            }
            bArr[i2] = 45;
            j2 = -j2;
            i2++;
        } else if (j2 <= f) {
            return d((int) j2, bArr, i2);
        }
        int iA = a(j2) + i2;
        int i4 = iA;
        while (j2 > f) {
            i4 -= 3;
            long j3 = d;
            long j4 = j2 / j3;
            b((int) (j2 - (j3 * j4)), bArr, i4);
            j2 = j4;
        }
        int i5 = (int) j2;
        while (i5 >= 1000) {
            i4 -= 3;
            int i6 = i5 / 1000;
            b(i5 - (i6 * 1000), bArr, i4);
            i5 = i6;
        }
        f(i5, bArr, i2);
        return iA;
    }

    public static int i(long j2, char[] cArr, int i2) {
        if (j2 < 0) {
            if (j2 > e) {
                return e((int) j2, cArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                String str = g;
                int length = str.length();
                str.getChars(0, length, cArr, i2);
                return i2 + length;
            }
            cArr[i2] = '-';
            j2 = -j2;
            i2++;
        } else if (j2 <= f) {
            return e((int) j2, cArr, i2);
        }
        int iA = a(j2) + i2;
        int i3 = iA;
        while (j2 > f) {
            i3 -= 3;
            long j3 = d;
            long j4 = j2 / j3;
            c((int) (j2 - (j3 * j4)), cArr, i3);
            j2 = j4;
        }
        int i4 = (int) j2;
        while (i4 >= 1000) {
            i3 -= 3;
            int i5 = i4 / 1000;
            c(i4 - (i5 * 1000), cArr, i3);
            i4 = i5;
        }
        g(i4, cArr, i2);
        return iA;
    }
}
