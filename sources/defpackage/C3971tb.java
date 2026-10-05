package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: renamed from: tb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3971tb extends O implements Serializable {
    public final InterfaceC4238ws a;
    public final int b;
    public final String c;

    /* JADX INFO: renamed from: tb$b */
    public final class b extends A {
        public final Checksum b;

        @Override // defpackage.A
        public void b(byte b) {
            this.b.update(b);
        }

        @Override // defpackage.A
        public void e(byte[] bArr, int i, int i2) {
            this.b.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long value = this.b.getValue();
            return C3971tb.this.b == 32 ? HashCode.fromInt((int) value) : HashCode.fromLong(value);
        }

        public b(Checksum checksum) {
            this.b = (Checksum) Preconditions.checkNotNull(checksum);
        }
    }

    public C3971tb(InterfaceC4238ws interfaceC4238ws, int i, String str) {
        this.a = (InterfaceC4238ws) Preconditions.checkNotNull(interfaceC4238ws);
        Preconditions.checkArgument(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
        this.b = i;
        this.c = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.b;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new b((Checksum) this.a.get());
    }

    public String toString() {
        return this.c;
    }
}
