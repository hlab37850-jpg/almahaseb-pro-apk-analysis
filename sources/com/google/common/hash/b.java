package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import defpackage.AbstractC3600p0;
import defpackage.O;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends O implements Serializable {
    public static final HashFunction b = new b(0);
    public static final HashFunction c = new b(Hashing.GOOD_FAST_HASH_SEED);
    public final int a;

    public static final class a extends AbstractC3600p0 {
        public long d;
        public long e;
        public int f;

        public a(int i) {
            super(16);
            long j = i;
            this.d = j;
            this.e = j;
            this.f = 0;
        }

        public static long h(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        public static long i(long j) {
            return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        public static long j(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // defpackage.AbstractC3600p0
        public HashCode a() {
            long j = this.d;
            int i = this.f;
            long j2 = j ^ ((long) i);
            long j3 = this.e ^ ((long) i);
            long j4 = j2 + j3;
            this.d = j4;
            this.e = j3 + j4;
            this.d = h(j4);
            long jH = h(this.e);
            long j5 = this.d + jH;
            this.d = j5;
            this.e = jH + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
        }

        @Override // defpackage.AbstractC3600p0
        public void d(ByteBuffer byteBuffer) {
            g(byteBuffer.getLong(), byteBuffer.getLong());
            this.f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // defpackage.AbstractC3600p0
        public void e(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            this.f += byteBuffer.remaining();
            long j8 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 3:
                    j3 = 0;
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 6:
                    j6 = 0;
                    j5 = (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40) ^ j6;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 7:
                    j6 = ((long) UnsignedBytes.toInt(byteBuffer.get(6))) << 48;
                    j5 = (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40) ^ j6;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 8:
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 9:
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 10:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 11:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 12:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 13:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 14:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                case 15:
                    j8 = ((long) UnsignedBytes.toInt(byteBuffer.get(14))) << 48;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.d = i(j7) ^ this.d;
                    this.e ^= j(j8);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        public final void g(long j, long j2) {
            long jI = i(j) ^ this.d;
            this.d = jI;
            long jRotateLeft = Long.rotateLeft(jI, 27);
            long j3 = this.e;
            this.d = ((jRotateLeft + j3) * 5) + 1390208809;
            long j4 = j(j2) ^ j3;
            this.e = j4;
            this.e = ((Long.rotateLeft(j4, 31) + this.d) * 5) + 944331445;
        }
    }

    public b(int i) {
        this.a = i;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && this.a == ((b) obj).a;
    }

    public int hashCode() {
        return b.class.hashCode() ^ this.a;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.a);
    }

    public String toString() {
        int i = this.a;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }
}
