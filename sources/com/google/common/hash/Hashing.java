package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import defpackage.C2153ex;
import defpackage.C2469im;
import defpackage.C3166jg;
import defpackage.C3971tb;
import defpackage.C4394ym;
import defpackage.F;
import defpackage.InterfaceC4238ws;
import defpackage.MQ;
import defpackage.SB;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class Hashing {
    static final int GOOD_FAST_HASH_SEED = (int) System.currentTimeMillis();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b implements InterfaceC4238ws {
        public static final b b = new a("CRC_32", 0, "Hashing.crc32()");
        public static final b c = new C0252b("ADLER_32", 1, "Hashing.adler32()");
        public static final /* synthetic */ b[] d = a();
        public final HashFunction a;

        public final enum a extends b {
            public a(String str, int i, String str2) {
                super(str, i, str2);
            }

            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Checksum get() {
                return new CRC32();
            }
        }

        /* JADX INFO: renamed from: com.google.common.hash.Hashing$b$b, reason: collision with other inner class name */
        public final enum C0252b extends b {
            public C0252b(String str, int i, String str2) {
                super(str, i, str2);
            }

            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Checksum get() {
                return new Adler32();
            }
        }

        public static /* synthetic */ b[] a() {
            return new b[]{b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        public b(String str, int i, String str2) {
            super(str, i);
            this.a = new C3971tb(this, 32, str2);
        }
    }

    public static final class c extends F {
        @Override // defpackage.F
        public HashCode b(Hasher[] hasherArr) {
            byte[] bArr = new byte[bits() / 8];
            int iWriteBytesTo = 0;
            for (Hasher hasher : hasherArr) {
                HashCode hashCodeHash = hasher.hash();
                iWriteBytesTo += hashCodeHash.writeBytesTo(bArr, iWriteBytesTo, hashCodeHash.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(bArr);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            int iBits = 0;
            for (HashFunction hashFunction : this.a) {
                iBits += hashFunction.bits();
            }
            return iBits;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(this.a, ((c) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public c(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (Object) hashFunction);
            }
        }
    }

    public static final class d {
        public long a;

        public d(long j) {
            this.a = j;
        }

        public double a() {
            long j = (this.a * 2862933555777941757L) + 1;
            this.a = j;
            return ((double) (((int) (j >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    public static class e {
        public static final HashFunction a = new SB("MD5", "Hashing.md5()");
    }

    public static class f {
        public static final HashFunction a = new SB(DigestAlgorithms.SHA1, "Hashing.sha1()");
    }

    public static class g {
        public static final HashFunction a = new SB("SHA-256", "Hashing.sha256()");
    }

    public static class h {
        public static final HashFunction a = new SB(DigestAlgorithms.SHA384, "Hashing.sha384()");
    }

    public static class i {
        public static final HashFunction a = new SB(DigestAlgorithms.SHA512, "Hashing.sha512()");
    }

    private Hashing() {
    }

    public static HashFunction adler32() {
        return b.c.a;
    }

    public static int checkPositiveAndMakeMultipleOf32(int i2) {
        Preconditions.checkArgument(i2 > 0, "Number of bits must be positive");
        return (i2 + 31) & (-32);
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iBits = it.next().bits() / 8;
        byte[] bArr = new byte[iBits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] bArrAsBytes = it2.next().asBytes();
            Preconditions.checkArgument(bArrAsBytes.length == iBits, "All hashcodes must have the same bit length.");
            for (int i2 = 0; i2 < bArrAsBytes.length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] * 37) ^ bArrAsBytes[i2]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iBits = it.next().bits() / 8;
        byte[] bArr = new byte[iBits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] bArrAsBytes = it2.next().asBytes();
            Preconditions.checkArgument(bArrAsBytes.length == iBits, "All hashcodes must have the same bit length.");
            for (int i2 = 0; i2 < bArrAsBytes.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] + bArrAsBytes[i2]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        Collections.addAll(arrayList, hashFunctionArr);
        return new c((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static int consistentHash(HashCode hashCode, int i2) {
        return consistentHash(hashCode.padToLong(), i2);
    }

    public static HashFunction crc32() {
        return b.b.a;
    }

    public static HashFunction crc32c() {
        return C3166jg.a;
    }

    public static HashFunction farmHashFingerprint64() {
        return C2469im.a;
    }

    public static HashFunction fingerprint2011() {
        return C4394ym.a;
    }

    public static HashFunction goodFastHash(int i2) {
        int iCheckPositiveAndMakeMultipleOf32 = checkPositiveAndMakeMultipleOf32(i2);
        if (iCheckPositiveAndMakeMultipleOf32 == 32) {
            return com.google.common.hash.c.e;
        }
        if (iCheckPositiveAndMakeMultipleOf32 <= 128) {
            return com.google.common.hash.b.c;
        }
        int i3 = (iCheckPositiveAndMakeMultipleOf32 + ShapeTypes.VERTICAL_SCROLL) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i3];
        hashFunctionArr[0] = com.google.common.hash.b.c;
        int i4 = GOOD_FAST_HASH_SEED;
        for (int i5 = 1; i5 < i3; i5++) {
            i4 += 1500450271;
            hashFunctionArr[i5] = murmur3_128(i4);
        }
        return new c(hashFunctionArr);
    }

    public static HashFunction hmacMd5(Key key) {
        return new C2153ex("HmacMD5", key, hmacToString("hmacMd5", key));
    }

    public static HashFunction hmacSha1(Key key) {
        return new C2153ex("HmacSHA1", key, hmacToString("hmacSha1", key));
    }

    public static HashFunction hmacSha256(Key key) {
        return new C2153ex("HmacSHA256", key, hmacToString("hmacSha256", key));
    }

    public static HashFunction hmacSha512(Key key) {
        return new C2153ex("HmacSHA512", key, hmacToString("hmacSha512", key));
    }

    private static String hmacToString(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    @Deprecated
    public static HashFunction md5() {
        return e.a;
    }

    public static HashFunction murmur3_128(int i2) {
        return new com.google.common.hash.b(i2);
    }

    @Deprecated
    public static HashFunction murmur3_32(int i2) {
        return new com.google.common.hash.c(i2, false);
    }

    public static HashFunction murmur3_32_fixed(int i2) {
        return new com.google.common.hash.c(i2, true);
    }

    @Deprecated
    public static HashFunction sha1() {
        return f.a;
    }

    public static HashFunction sha256() {
        return g.a;
    }

    public static HashFunction sha384() {
        return h.a;
    }

    public static HashFunction sha512() {
        return i.a;
    }

    public static HashFunction sipHash24() {
        return MQ.e;
    }

    public static int consistentHash(long j, int i2) {
        int i3 = 0;
        Preconditions.checkArgument(i2 > 0, "buckets must be positive: %s", i2);
        d dVar = new d(j);
        while (true) {
            int iA = (int) (((double) (i3 + 1)) / dVar.a());
            if (iA < 0 || iA >= i2) {
                break;
            }
            i3 = iA;
        }
        return i3;
    }

    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    public static HashFunction murmur3_128() {
        return com.google.common.hash.b.b;
    }

    @Deprecated
    public static HashFunction murmur3_32() {
        return com.google.common.hash.c.c;
    }

    public static HashFunction murmur3_32_fixed() {
        return com.google.common.hash.c.d;
    }

    public static HashFunction sipHash24(long j, long j2) {
        return new MQ(2, 4, j, j2);
    }

    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        Iterator<HashFunction> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Preconditions.checkArgument(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new c((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }
}
