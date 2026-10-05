package defpackage;

/* JADX INFO: renamed from: e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2074e {
    public static final H8.a a = new H8.a();
    public static final int b = -1234567890;

    public static final boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        AbstractC4492zt.h(bArr, "a");
        AbstractC4492zt.h(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final int c() {
        return b;
    }

    public static final H8.a d() {
        return a;
    }

    public static final int e(W8 w8, int i) {
        AbstractC4492zt.h(w8, "<this>");
        return i == b ? w8.u() : i;
    }

    public static final int f(byte[] bArr, int i) {
        AbstractC4492zt.h(bArr, "<this>");
        return i == b ? bArr.length : i;
    }

    public static final H8.a g(H8.a aVar) {
        AbstractC4492zt.h(aVar, "unsafeCursor");
        return aVar == a ? new H8.a() : aVar;
    }

    public static final int h(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final short i(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final String j(byte b2) {
        return AbstractC3880sS.m(new char[]{AbstractC1835c.f()[(b2 >> 4) & 15], AbstractC1835c.f()[b2 & 15]});
    }

    public static final String k(int i) {
        int i2 = 0;
        if (i == 0) {
            return "0";
        }
        char[] cArr = {AbstractC1835c.f()[(i >> 28) & 15], AbstractC1835c.f()[(i >> 24) & 15], AbstractC1835c.f()[(i >> 20) & 15], AbstractC1835c.f()[(i >> 16) & 15], AbstractC1835c.f()[(i >> 12) & 15], AbstractC1835c.f()[(i >> 8) & 15], AbstractC1835c.f()[(i >> 4) & 15], AbstractC1835c.f()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return AbstractC3880sS.n(cArr, i2, 8);
    }
}
