package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: renamed from: ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2153ex extends O {
    public final Mac a;
    public final Key b;
    public final String c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: ex$b */
    public static final class b extends A {
        public final Mac b;
        public boolean c;

        @Override // defpackage.A
        public void b(byte b) {
            f();
            this.b.update(b);
        }

        @Override // defpackage.A
        public void c(ByteBuffer byteBuffer) {
            f();
            Preconditions.checkNotNull(byteBuffer);
            this.b.update(byteBuffer);
        }

        @Override // defpackage.A
        public void d(byte[] bArr) {
            f();
            this.b.update(bArr);
        }

        @Override // defpackage.A
        public void e(byte[] bArr, int i, int i2) {
            f();
            this.b.update(bArr, i, i2);
        }

        public final void f() {
            Preconditions.checkState(!this.c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.c = true;
            return HashCode.fromBytesNoCopy(this.b.doFinal());
        }

        public b(Mac mac) {
            this.b = mac;
        }
    }

    public C2153ex(String str, Key key, String str2) {
        Mac macA = a(str, key);
        this.a = macA;
        this.b = (Key) Preconditions.checkNotNull(key);
        this.c = (String) Preconditions.checkNotNull(str2);
        this.d = macA.getMacLength() * 8;
        this.e = b(macA);
    }

    public static Mac a(String str, Key key) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static boolean b(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.d;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.e) {
            try {
                return new b((Mac) this.a.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.a.getAlgorithm(), this.b));
    }

    public String toString() {
        return this.c;
    }
}
