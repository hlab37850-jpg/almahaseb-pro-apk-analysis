package com.google.common.hash;

import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import defpackage.AbstractC1073Xw;
import defpackage.InterfaceC0979Uw;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements BloomFilter.c {
    public static final a a = new C0253a("MURMUR128_MITZ_32", 0);
    public static final a b = new a("MURMUR128_MITZ_64", 1) { // from class: com.google.common.hash.a.b
        {
            C0253a c0253a = null;
        }

        public final long b(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        public final long c(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.c
        public boolean d(Object obj, Funnel funnel, int i, c cVar) {
            long jB = cVar.b();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(obj, funnel).getBytesInternal();
            long jB2 = b(bytesInternal);
            long jC = c(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!cVar.d((LocationRequestCompat.PASSIVE_INTERVAL & jB2) % jB)) {
                    return false;
                }
                jB2 += jC;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.c
        public boolean g(Object obj, Funnel funnel, int i, c cVar) {
            long jB = cVar.b();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(obj, funnel).getBytesInternal();
            long jB2 = b(bytesInternal);
            long jC = c(bytesInternal);
            boolean zG = false;
            for (int i2 = 0; i2 < i; i2++) {
                zG |= cVar.g((LocationRequestCompat.PASSIVE_INTERVAL & jB2) % jB);
                jB2 += jC;
            }
            return zG;
        }
    };
    public static final /* synthetic */ a[] c = a();

    /* JADX INFO: renamed from: com.google.common.hash.a$a, reason: collision with other inner class name */
    public final enum C0253a extends a {
        public C0253a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.hash.BloomFilter.c
        public boolean d(Object obj, Funnel funnel, int i, c cVar) {
            long jB = cVar.b();
            long jAsLong = Hashing.murmur3_128().hashObject(obj, funnel).asLong();
            int i2 = (int) jAsLong;
            int i3 = (int) (jAsLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!cVar.d(((long) i5) % jB)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.c
        public boolean g(Object obj, Funnel funnel, int i, c cVar) {
            long jB = cVar.b();
            long jAsLong = Hashing.murmur3_128().hashObject(obj, funnel).asLong();
            int i2 = (int) jAsLong;
            int i3 = (int) (jAsLong >>> 32);
            boolean zG = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                zG |= cVar.g(((long) i5) % jB);
            }
            return zG;
        }
    }

    public a(String str, int i) {
        super(str, i);
    }

    public static /* synthetic */ a[] a() {
        return new a[]{a, b};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) c.clone();
    }

    public /* synthetic */ a(String str, int i, C0253a c0253a) {
        this(str, i);
    }

    public static final class c {
        public final AtomicLongArray a;
        public final InterfaceC0979Uw b;

        public c(long j) {
            Preconditions.checkArgument(j > 0, "data length is zero!");
            this.a = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j, 64L, RoundingMode.CEILING)));
            this.b = AbstractC1073Xw.a();
        }

        public static long[] h(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public long a() {
            return this.b.b();
        }

        public long b() {
            return ((long) this.a.length()) * 64;
        }

        public c c() {
            return new c(h(this.a));
        }

        public boolean d(long j) {
            return ((1 << ((int) j)) & this.a.get((int) (j >>> 6))) != 0;
        }

        public void e(c cVar) {
            Preconditions.checkArgument(this.a.length() == cVar.a.length(), "BitArrays must be of equal length (%s != %s)", this.a.length(), cVar.a.length());
            for (int i = 0; i < this.a.length(); i++) {
                f(i, cVar.a.get(i));
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(h(this.a), h(((c) obj).a));
            }
            return false;
        }

        public void f(int i, long j) {
            long j2;
            long j3;
            do {
                j2 = this.a.get(i);
                j3 = j2 | j;
                if (j2 == j3) {
                    return;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.b.add(Long.bitCount(j3) - Long.bitCount(j2));
        }

        public boolean g(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.b.a();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(h(this.a));
        }

        public c(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.a = new AtomicLongArray(jArr);
            this.b = AbstractC1073Xw.a();
            long jBitCount = 0;
            for (long j : jArr) {
                jBitCount += (long) Long.bitCount(j);
            }
            this.b.add(jBitCount);
        }
    }
}
