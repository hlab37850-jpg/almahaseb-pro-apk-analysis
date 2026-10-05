package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: renamed from: im, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2469im extends AbstractC2075e0 {
    public static final HashFunction a = new C2469im();

    public static long a(byte[] bArr, int i, int i2) {
        if (i2 <= 32) {
            return i2 <= 16 ? b(bArr, i, i2) : e(bArr, i, i2);
        }
        return i2 <= 64 ? f(bArr, i, i2) : h(bArr, i, i2);
    }

    public static long b(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = ((long) (i2 * 2)) - 7286425919675154353L;
            long jB = AbstractC1989cw.b(bArr, i) - 7286425919675154353L;
            long jB2 = AbstractC1989cw.b(bArr, (i + i2) - 8);
            return c((Long.rotateRight(jB2, 37) * j) + jB, (Long.rotateRight(jB, 25) + jB2) * j, j);
        }
        if (i2 >= 4) {
            return c(((long) i2) + ((((long) AbstractC1989cw.a(bArr, i)) & 4294967295L) << 3), ((long) AbstractC1989cw.a(bArr, (i + i2) - 4)) & 4294967295L, ((long) (i2 * 2)) - 7286425919675154353L);
        }
        if (i2 <= 0) {
            return -7286425919675154353L;
        }
        return i((((long) ((bArr[i] & UnsignedBytes.MAX_VALUE) + ((bArr[(i2 >> 1) + i] & UnsignedBytes.MAX_VALUE) << 8))) * (-7286425919675154353L)) ^ (((long) (i2 + ((bArr[i + (i2 - 1)] & 255) << 2))) * (-4348849565147123417L))) * (-7286425919675154353L);
    }

    public static long c(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long e(byte[] bArr, int i, int i2) {
        long j = ((long) (i2 * 2)) - 7286425919675154353L;
        long jB = AbstractC1989cw.b(bArr, i) * (-5435081209227447693L);
        long jB2 = AbstractC1989cw.b(bArr, i + 8);
        int i3 = i + i2;
        long jB3 = AbstractC1989cw.b(bArr, i3 - 8) * j;
        return c((AbstractC1989cw.b(bArr, i3 - 16) * (-7286425919675154353L)) + Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30), jB + Long.rotateRight(jB2 - 7286425919675154353L, 18) + jB3, j);
    }

    public static long f(byte[] bArr, int i, int i2) {
        long j = ((long) (i2 * 2)) - 7286425919675154353L;
        long jB = AbstractC1989cw.b(bArr, i) * (-7286425919675154353L);
        long jB2 = AbstractC1989cw.b(bArr, i + 8);
        int i3 = i + i2;
        long jB3 = AbstractC1989cw.b(bArr, i3 - 8) * j;
        long jRotateRight = Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30) + (AbstractC1989cw.b(bArr, i3 - 16) * (-7286425919675154353L));
        long jC = c(jRotateRight, jB3 + Long.rotateRight(jB2 - 7286425919675154353L, 18) + jB, j);
        long jB4 = AbstractC1989cw.b(bArr, i + 16) * j;
        long jB5 = AbstractC1989cw.b(bArr, i + 24);
        long jB6 = (jRotateRight + AbstractC1989cw.b(bArr, i3 - 32)) * j;
        return c(((jC + AbstractC1989cw.b(bArr, i3 - 24)) * j) + Long.rotateRight(jB4 + jB5, 43) + Long.rotateRight(jB6, 30), jB4 + Long.rotateRight(jB5 + jB, 18) + jB6, j);
    }

    public static long h(byte[] bArr, int i, int i2) {
        long j = 81;
        long j2 = (j * (-5435081209227447693L)) + 113;
        long jI = i((j2 * (-7286425919675154353L)) + 113) * (-7286425919675154353L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jB = (j * (-7286425919675154353L)) + AbstractC1989cw.b(bArr, i);
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = i4 + i5;
        int i7 = i6 - 63;
        int i8 = i;
        while (true) {
            long jRotateRight = Long.rotateRight(jB + j2 + jArr[0] + AbstractC1989cw.b(bArr, i8 + 8), 37) * (-5435081209227447693L);
            long jRotateRight2 = Long.rotateRight(j2 + jArr[1] + AbstractC1989cw.b(bArr, i8 + 48), 42) * (-5435081209227447693L);
            long j3 = jRotateRight ^ jArr2[1];
            long jB2 = jRotateRight2 + jArr[0] + AbstractC1989cw.b(bArr, i8 + 40);
            long jRotateRight3 = Long.rotateRight(jI + jArr2[0], 33) * (-5435081209227447693L);
            j(bArr, i8, jArr[1] * (-5435081209227447693L), j3 + jArr2[0], jArr);
            j(bArr, i8 + 32, jRotateRight3 + jArr2[1], jB2 + AbstractC1989cw.b(bArr, i8 + 16), jArr2);
            int i9 = i8 + 64;
            if (i9 == i4) {
                long j4 = (-5435081209227447693L) + ((j3 & 255) << 1);
                long j5 = jArr2[0] + ((long) i5);
                jArr2[0] = j5;
                long j6 = jArr[0] + j5;
                jArr[0] = j6;
                jArr2[0] = jArr2[0] + j6;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jB2 + jArr[0] + AbstractC1989cw.b(bArr, i6 - 55), 37) * j4;
                long jRotateRight5 = Long.rotateRight(jB2 + jArr[1] + AbstractC1989cw.b(bArr, i6 - 15), 42) * j4;
                long j7 = jRotateRight4 ^ (jArr2[1] * 9);
                long jB3 = jRotateRight5 + (jArr[0] * 9) + AbstractC1989cw.b(bArr, i6 - 23);
                long jRotateRight6 = Long.rotateRight(j3 + jArr2[0], 33) * j4;
                j(bArr, i7, jArr[1] * j4, j7 + jArr2[0], jArr);
                j(bArr, i6 - 31, jRotateRight6 + jArr2[1], jB3 + AbstractC1989cw.b(bArr, i6 - 47), jArr2);
                return c(c(jArr[0], jArr2[0], j4) + (i(jB3) * (-4348849565147123417L)) + j7, c(jArr[1], jArr2[1], j4) + jRotateRight6, j4);
            }
            i8 = i9;
            jI = j3;
            j2 = jB2;
            jB = jRotateRight3;
        }
    }

    public static long i(long j) {
        return j ^ (j >>> 47);
    }

    public static void j(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jB = AbstractC1989cw.b(bArr, i);
        long jB2 = AbstractC1989cw.b(bArr, i + 8);
        long jB3 = AbstractC1989cw.b(bArr, i + 16);
        long jB4 = AbstractC1989cw.b(bArr, i + 24);
        long j3 = j + jB;
        long j4 = jB2 + j3 + jB3;
        long jRotateRight = Long.rotateRight(j2 + j3 + jB4, 21) + Long.rotateRight(j4, 44);
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
        return "Hashing.farmHashFingerprint64()";
    }
}
