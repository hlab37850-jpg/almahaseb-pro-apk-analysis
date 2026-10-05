package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3600p0 extends P {
    public final ByteBuffer a;
    public final int b;
    public final int c;

    public AbstractC3600p0(int i) {
        this(i, i);
    }

    public abstract HashCode a();

    public final void b() {
        AbstractC0946Tt.b(this.a);
        while (this.a.remaining() >= this.c) {
            d(this.a);
        }
        this.a.compact();
    }

    public final void c() {
        if (this.a.remaining() < 8) {
            b();
        }
    }

    public abstract void d(ByteBuffer byteBuffer);

    public abstract void e(ByteBuffer byteBuffer);

    public final Hasher f(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            c();
            return this;
        }
        int iPosition = this.b - this.a.position();
        for (int i = 0; i < iPosition; i++) {
            this.a.put(byteBuffer.get());
        }
        b();
        while (byteBuffer.remaining() >= this.c) {
            d(byteBuffer);
        }
        this.a.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        b();
        AbstractC0946Tt.b(this.a);
        if (this.a.remaining() > 0) {
            e(this.a);
            ByteBuffer byteBuffer = this.a;
            AbstractC0946Tt.c(byteBuffer, byteBuffer.limit());
        }
        return a();
    }

    public AbstractC3600p0(int i, int i2) {
        Preconditions.checkArgument(i2 % i == 0);
        this.a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        this.a.put(b);
        c();
        return this;
    }

    @Override // defpackage.P, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        this.a.putChar(c);
        c();
        return this;
    }

    @Override // defpackage.P, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    @Override // defpackage.P, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        this.a.putLong(j);
        c();
        return this;
    }

    @Override // defpackage.P, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s) {
        this.a.putShort(s);
        c();
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        return f(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return f(byteBuffer);
        } finally {
            byteBuffer.order(byteOrderOrder);
        }
    }
}
