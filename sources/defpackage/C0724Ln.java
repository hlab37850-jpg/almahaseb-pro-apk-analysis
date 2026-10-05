package defpackage;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: renamed from: Ln, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0724Ln {
    public static final int[][] c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    public final ErrorCorrectionLevel a;
    public final byte b;

    public C0724Ln(int i) {
        this.a = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.b = (byte) (i & 7);
    }

    public static C0724Ln a(int i, int i2) {
        C0724Ln c0724LnB = b(i, i2);
        return c0724LnB != null ? c0724LnB : b(i ^ 21522, i2 ^ 21522);
    }

    public static C0724Ln b(int i, int i2) {
        int iE;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : c) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new C0724Ln(iArr[1]);
            }
            int iE2 = e(i, i5);
            if (iE2 < i3) {
                i4 = iArr[1];
                i3 = iE2;
            }
            if (i != i2 && (iE = e(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iE;
            }
        }
        if (i3 <= 3) {
            return new C0724Ln(i4);
        }
        return null;
    }

    public static int e(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public byte c() {
        return this.b;
    }

    public ErrorCorrectionLevel d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0724Ln)) {
            return false;
        }
        C0724Ln c0724Ln = (C0724Ln) obj;
        return this.a == c0724Ln.a && this.b == c0724Ln.b;
    }

    public int hashCode() {
        return (this.a.ordinal() << 3) | this.b;
    }
}
