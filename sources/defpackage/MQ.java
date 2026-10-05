package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class MQ extends O implements Serializable {
    public static final HashFunction e = new MQ(2, 4, 506097522914230528L, 1084818905618843912L);
    public final int a;
    public final int b;
    public final long c;
    public final long d;

    public static final class a extends AbstractC3600p0 {
        public final int d;
        public final int e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;

        public a(int i, int i2, long j, long j2) {
            super(8);
            this.j = 0L;
            this.k = 0L;
            this.d = i;
            this.e = i2;
            this.f = 8317987319222330741L ^ j;
            this.g = 7237128888997146477L ^ j2;
            this.h = 7816392313619706465L ^ j;
            this.i = 8387220255154660723L ^ j2;
        }

        @Override // defpackage.AbstractC3600p0
        public HashCode a() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            g(j);
            this.h ^= 255;
            h(this.e);
            return HashCode.fromLong(((this.f ^ this.g) ^ this.h) ^ this.i);
        }

        @Override // defpackage.AbstractC3600p0
        public void d(ByteBuffer byteBuffer) {
            this.j += 8;
            g(byteBuffer.getLong());
        }

        @Override // defpackage.AbstractC3600p0
        public void e(ByteBuffer byteBuffer) {
            this.j += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }

        public final void g(long j) {
            this.i ^= j;
            h(this.d);
            this.f = j ^ this.f;
        }

        public final void h(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f;
                long j2 = this.g;
                this.f = j + j2;
                this.h += this.i;
                this.g = Long.rotateLeft(j2, 13);
                long jRotateLeft = Long.rotateLeft(this.i, 16);
                long j3 = this.g;
                long j4 = this.f;
                this.g = j3 ^ j4;
                this.i = jRotateLeft ^ this.h;
                long jRotateLeft2 = Long.rotateLeft(j4, 32);
                long j5 = this.h;
                long j6 = this.g;
                this.h = j5 + j6;
                this.f = jRotateLeft2 + this.i;
                this.g = Long.rotateLeft(j6, 17);
                long jRotateLeft3 = Long.rotateLeft(this.i, 21);
                long j7 = this.g;
                long j8 = this.h;
                this.g = j7 ^ j8;
                this.i = jRotateLeft3 ^ this.f;
                this.h = Long.rotateLeft(j8, 32);
            }
        }
    }

    public MQ(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MQ)) {
            return false;
        }
        MQ mq = (MQ) obj;
        return this.a == mq.a && this.b == mq.b && this.c == mq.c && this.d == mq.d;
    }

    public int hashCode() {
        return (int) ((((long) ((MQ.class.hashCode() ^ this.a) ^ this.b)) ^ this.c) ^ this.d);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.a, this.b, this.c, this.d);
    }

    public String toString() {
        int i = this.a;
        int i2 = this.b;
        long j = this.c;
        long j2 = this.d;
        StringBuilder sb = new StringBuilder(81);
        sb.append("Hashing.sipHash");
        sb.append(i);
        sb.append(i2);
        sb.append("(");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(")");
        return sb.toString();
    }
}
