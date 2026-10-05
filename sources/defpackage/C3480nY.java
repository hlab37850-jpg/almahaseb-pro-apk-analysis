package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: nY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3480nY implements Closeable {
    public final boolean a;
    public final K8 b;
    public final Random c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final H8 g;
    public final H8 h;
    public boolean i;
    public QB j;
    public final byte[] k;
    public final H8.a l;

    public C3480nY(boolean z, K8 k8, Random random, boolean z2, boolean z3, long j) {
        AbstractC4492zt.h(k8, "sink");
        AbstractC4492zt.h(random, "random");
        this.a = z;
        this.b = k8;
        this.c = random;
        this.d = z2;
        this.e = z3;
        this.f = j;
        this.g = new H8();
        this.h = k8.a();
        this.k = z ? new byte[4] : null;
        this.l = z ? new H8.a() : null;
    }

    public final void c(int i, W8 w8) {
        W8 w8K = W8.e;
        if (i != 0 || w8 != null) {
            if (i != 0) {
                C3316lY.a.c(i);
            }
            H8 h8 = new H8();
            h8.writeShort(i);
            if (w8 != null) {
                h8.n(w8);
            }
            w8K = h8.K();
        }
        try {
            d(8, w8K);
        } finally {
            this.i = true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        QB qb = this.j;
        if (qb != null) {
            qb.close();
        }
    }

    public final void d(int i, W8 w8) throws IOException {
        if (this.i) {
            throw new IOException("closed");
        }
        int iU = w8.u();
        if (iU > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.h.writeByte(i | 128);
        if (this.a) {
            this.h.writeByte(iU | 128);
            Random random = this.c;
            byte[] bArr = this.k;
            AbstractC4492zt.e(bArr);
            random.nextBytes(bArr);
            this.h.write(this.k);
            if (iU > 0) {
                long jR = this.h.R();
                this.h.n(w8);
                H8 h8 = this.h;
                H8.a aVar = this.l;
                AbstractC4492zt.e(aVar);
                h8.H(aVar);
                this.l.i(jR);
                C3316lY.a.b(this.l, this.k);
                this.l.close();
            }
        } else {
            this.h.writeByte(iU);
            this.h.n(w8);
        }
        this.b.flush();
    }

    public final void g(int i, W8 w8) throws IllegalAccessException, IOException, InvocationTargetException {
        AbstractC4492zt.h(w8, "data");
        if (this.i) {
            throw new IOException("closed");
        }
        this.g.n(w8);
        int i2 = i | 128;
        if (this.d && w8.u() >= this.f) {
            QB qb = this.j;
            if (qb == null) {
                qb = new QB(this.e);
                this.j = qb;
            }
            qb.c(this.g);
            i2 = i | 192;
        }
        long jR = this.g.R();
        this.h.writeByte(i2);
        int i3 = this.a ? 128 : 0;
        if (jR <= 125) {
            this.h.writeByte(i3 | ((int) jR));
        } else if (jR <= 65535) {
            this.h.writeByte(i3 | 126);
            this.h.writeShort((int) jR);
        } else {
            this.h.writeByte(i3 | ShapeTypes.VERTICAL_SCROLL);
            this.h.c0(jR);
        }
        if (this.a) {
            Random random = this.c;
            byte[] bArr = this.k;
            AbstractC4492zt.e(bArr);
            random.nextBytes(bArr);
            this.h.write(this.k);
            if (jR > 0) {
                H8 h8 = this.g;
                H8.a aVar = this.l;
                AbstractC4492zt.e(aVar);
                h8.H(aVar);
                this.l.i(0L);
                C3316lY.a.b(this.l, this.k);
                this.l.close();
            }
        }
        this.h.p(this.g, jR);
        this.b.f();
    }

    public final void i(W8 w8) throws IOException {
        AbstractC4492zt.h(w8, "payload");
        d(9, w8);
    }

    public final void r(W8 w8) throws IOException {
        AbstractC4492zt.h(w8, "payload");
        d(10, w8);
    }
}
