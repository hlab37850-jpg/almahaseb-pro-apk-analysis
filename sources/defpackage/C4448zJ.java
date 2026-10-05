package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: zJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4448zJ implements K8 {
    public final LQ a;
    public final H8 b;
    public boolean c;

    public C4448zJ(LQ lq) {
        AbstractC4492zt.h(lq, "sink");
        this.a = lq;
        this.b = new H8();
    }

    @Override // defpackage.K8
    public H8 a() {
        return this.b;
    }

    @Override // defpackage.LQ
    public JU b() {
        return this.a.b();
    }

    @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        if (this.b.R() > 0) {
            LQ lq = this.a;
            H8 h8 = this.b;
            lq.p(h8, h8.R());
        }
        th = null;
        try {
            this.a.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.K8
    public K8 f() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jR = this.b.R();
        if (jR > 0) {
            this.a.p(this.b, jR);
        }
        return this;
    }

    @Override // defpackage.K8, defpackage.LQ, java.io.Flushable
    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.b.R() > 0) {
            LQ lq = this.a;
            H8 h8 = this.b;
            lq.p(h8, h8.R());
        }
        this.a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // defpackage.K8
    public K8 j() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jI = this.b.i();
        if (jI > 0) {
            this.a.p(this.b, jI);
        }
        return this;
    }

    @Override // defpackage.K8
    public K8 l(String str) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.l(str);
        return j();
    }

    @Override // defpackage.K8
    public K8 n(W8 w8) {
        AbstractC4492zt.h(w8, "byteString");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.n(w8);
        return j();
    }

    @Override // defpackage.LQ
    public void p(H8 h8, long j) {
        AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.p(h8, j);
        j();
    }

    @Override // defpackage.K8
    public K8 q(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.q(j);
        return j();
    }

    public String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        AbstractC4492zt.h(byteBuffer, DublinCoreProperties.SOURCE);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.b.write(byteBuffer);
        j();
        return iWrite;
    }

    @Override // defpackage.K8
    public K8 writeByte(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.writeByte(i);
        return j();
    }

    @Override // defpackage.K8
    public K8 writeInt(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.writeInt(i);
        return j();
    }

    @Override // defpackage.K8
    public K8 writeShort(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.writeShort(i);
        return j();
    }

    @Override // defpackage.K8
    public K8 write(byte[] bArr) {
        AbstractC4492zt.h(bArr, DublinCoreProperties.SOURCE);
        if (!this.c) {
            this.b.write(bArr);
            return j();
        }
        throw new IllegalStateException("closed");
    }

    @Override // defpackage.K8
    public K8 write(byte[] bArr, int i, int i2) {
        AbstractC4492zt.h(bArr, DublinCoreProperties.SOURCE);
        if (!this.c) {
            this.b.write(bArr, i, i2);
            return j();
        }
        throw new IllegalStateException("closed");
    }
}
