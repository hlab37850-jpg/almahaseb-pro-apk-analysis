package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;

/* JADX INFO: renamed from: ym, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4394ym extends AbstractC2075e0 {
    public static final HashFunction a = new C4394ym();

    public static long a(byte[] bArr, int i, int i2) {
        long jE;
        if (i2 <= 32) {
            jE = f(bArr, i, i2, -1397348546323613475L);
        } else {
            jE = i2 <= 64 ? e(bArr, i, i2) : b(bArr, i, i2);
        }
        long jC = c(jE + (i2 >= 9 ? AbstractC1989cw.b(bArr, (i + i2) - 8) : -6505348102511208375L), i2 >= 8 ? AbstractC1989cw.b(bArr, i) : -6505348102511208375L);
        return (jC == 0 || jC == 1) ? jC - 2 : jC;
    }

    public static long b(byte[] bArr, int i, int i2) {
        long jB = AbstractC1989cw.b(bArr, i);
        int i3 = i + i2;
        long jB2 = AbstractC1989cw.b(bArr, i3 - 16) ^ (-8261664234251669945L);
        long jB3 = AbstractC1989cw.b(bArr, i3 - 56) ^ (-6505348102511208375L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j = i2;
        i(bArr, i3 - 64, j, jB2, jArr);
        i(bArr, i3 - 32, j * (-8261664234251669945L), -6505348102511208375L, jArr2);
        long jH = jB3 + (h(jArr[1]) * (-8261664234251669945L));
        long jRotateRight = Long.rotateRight(jH + jB, 39) * (-8261664234251669945L);
        long jRotateRight2 = Long.rotateRight(jB2, 33) * (-8261664234251669945L);
        int i4 = i;
        int i5 = (i2 - 1) & (-64);
        while (true) {
            long jRotateRight3 = Long.rotateRight(jRotateRight + jRotateRight2 + jArr[0] + AbstractC1989cw.b(bArr, i4 + 16), 37) * (-8261664234251669945L);
            long jRotateRight4 = Long.rotateRight(jRotateRight2 + jArr[1] + AbstractC1989cw.b(bArr, i4 + 48), 42) * (-8261664234251669945L);
            long j2 = jRotateRight3 ^ jArr2[1];
            long j3 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(jH ^ jArr2[0], 33);
            i(bArr, i4, jArr[1] * (-8261664234251669945L), j2 + jArr2[0], jArr);
            i(bArr, i4 + 32, jArr2[1] + jRotateRight5, j3, jArr2);
            i4 += 64;
            i5 -= 64;
            if (i5 == 0) {
                return c(c(jArr[0], jArr2[0]) + (h(j3) * (-8261664234251669945L)) + j2, c(jArr[1], jArr2[1]) + jRotateRight5);
            }
            jRotateRight = jRotateRight5;
            jH = j2;
            jRotateRight2 = j3;
        }
    }

    public static long c(long j, long j2) {
        long j3 = (j2 ^ j) * (-4132994306676758123L);
        long j4 = (j ^ (j3 ^ (j3 >>> 47))) * (-4132994306676758123L);
        return (j4 ^ (j4 >>> 47)) * (-4132994306676758123L);
    }

    private static long e(byte[] bArr, int i, int i2) {
        long jB = AbstractC1989cw.b(bArr, i + 24);
        int i3 = i + i2;
        int i4 = i3 - 16;
        long jB2 = AbstractC1989cw.b(bArr, i) + ((((long) i2) + AbstractC1989cw.b(bArr, i4)) * (-6505348102511208375L));
        long jRotateRight = Long.rotateRight(jB2 + jB, 52);
        long jRotateRight2 = Long.rotateRight(jB2, 37);
        long jB3 = jB2 + AbstractC1989cw.b(bArr, i + 8);
        long jRotateRight3 = jRotateRight2 + Long.rotateRight(jB3, 7);
        int i5 = i + 16;
        long jB4 = jB3 + AbstractC1989cw.b(bArr, i5);
        long j = jB + jB4;
        long jRotateRight4 = jRotateRight + Long.rotateRight(jB4, 31) + jRotateRight3;
        long jB5 = AbstractC1989cw.b(bArr, i5) + AbstractC1989cw.b(bArr, i3 - 32);
        long jB6 = AbstractC1989cw.b(bArr, i3 - 8);
        long jRotateRight5 = Long.rotateRight(jB5 + jB6, 52);
        long jRotateRight6 = Long.rotateRight(jB5, 37);
        long jB7 = jB5 + AbstractC1989cw.b(bArr, i3 - 24);
        long jRotateRight7 = jRotateRight6 + Long.rotateRight(jB7, 7);
        long jB8 = jB7 + AbstractC1989cw.b(bArr, i4);
        return h((h(((j + jRotateRight5 + Long.rotateRight(jB8, 31) + jRotateRight7) * (-4288712594273399085L)) + ((jB6 + jB8 + jRotateRight4) * (-6505348102511208375L))) * (-6505348102511208375L)) + jRotateRight4) * (-4288712594273399085L);
    }

    public static long f(byte[] bArr, int i, int i2, long j) {
        int i3 = i2 & (-8);
        int i4 = i2 & 7;
        long jC = j ^ (((long) i2) * (-4132994306676758123L));
        for (int i5 = 0; i5 < i3; i5 += 8) {
            jC = (jC ^ (h(AbstractC1989cw.b(bArr, i + i5) * (-4132994306676758123L)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        if (i4 != 0) {
            jC = (AbstractC1989cw.c(bArr, i + i3, i4) ^ jC) * (-4132994306676758123L);
        }
        return h(h(jC) * (-4132994306676758123L));
    }

    private static long h(long j) {
        return j ^ (j >>> 47);
    }

    private static void i(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jB = AbstractC1989cw.b(bArr, i);
        long jB2 = AbstractC1989cw.b(bArr, i + 8);
        long jB3 = AbstractC1989cw.b(bArr, i + 16);
        long jB4 = AbstractC1989cw.b(bArr, i + 24);
        long j3 = j + jB;
        long j4 = jB2 + j3 + jB3;
        long jRotateRight = Long.rotateRight(j2 + j3 + jB4, 51) + Long.rotateRight(j4, 23);
        jArr[0] = j4 + jB4;
        jArr[1] = jRotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // defpackage.AbstractC2075e0, defpackage.O, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(a(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
