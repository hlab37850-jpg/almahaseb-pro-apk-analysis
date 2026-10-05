package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class SB extends O implements Serializable {
    public final MessageDigest a;
    public final int b;
    public final boolean c;
    public final String d;

    public static final class b extends A {
        public final MessageDigest b;
        public final int c;
        public boolean d;

        private void f() {
            Preconditions.checkState(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // defpackage.A
        public void b(byte b) {
            f();
            this.b.update(b);
        }

        @Override // defpackage.A
        public void c(ByteBuffer byteBuffer) {
            f();
            this.b.update(byteBuffer);
        }

        @Override // defpackage.A
        public void e(byte[] bArr, int i, int i2) {
            f();
            this.b.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.d = true;
            return this.c == this.b.getDigestLength() ? HashCode.fromBytesNoCopy(this.b.digest()) : HashCode.fromBytesNoCopy(Arrays.copyOf(this.b.digest(), this.c));
        }

        public b(MessageDigest messageDigest, int i) {
            this.b = messageDigest;
            this.c = i;
        }
    }

    public SB(String str, String str2) {
        MessageDigest messageDigestA = a(str);
        this.a = messageDigestA;
        this.b = messageDigestA.getDigestLength();
        this.d = (String) Preconditions.checkNotNull(str2);
        this.c = b(messageDigestA);
    }

    public static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static boolean b(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.b * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.c) {
            try {
                return new b((MessageDigest) this.a.clone(), this.b);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.a.getAlgorithm()), this.b);
    }

    public String toString() {
        return this.d;
    }
}
