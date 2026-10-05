package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: Gr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0554Gr implements Closeable {
    public static final a g = new a(null);
    public static final Logger h = Logger.getLogger(C0376Br.class.getName());
    public final K8 a;
    public final boolean b;
    public final H8 c;
    public int d;
    public boolean e;
    public final C4490zr.b f;

    /* JADX INFO: renamed from: Gr$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public C0554Gr(K8 k8, boolean z) {
        AbstractC4492zt.h(k8, "sink");
        this.a = k8;
        this.b = z;
        H8 h8 = new H8();
        this.c = h8;
        this.d = 16384;
        this.f = new C4490zr.b(0, false, h8, 3, null);
    }

    public final synchronized void A(int i, EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "errorCode");
        if (this.e) {
            throw new IOException("closed");
        }
        if (enumC4069ul.b() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        r(i, 4, 3, 0);
        this.a.writeInt(enumC4069ul.b());
        this.a.flush();
    }

    public final synchronized void C(SO so) {
        int i;
        try {
            AbstractC4492zt.h(so, "settings");
            if (this.e) {
                throw new IOException("closed");
            }
            int i2 = 0;
            r(0, so.i() * 6, 4, 0);
            while (i2 < 10) {
                if (so.f(i2)) {
                    if (i2 != 4) {
                        i = i2 != 7 ? i2 : 4;
                    } else {
                        i = 3;
                    }
                    this.a.writeShort(i);
                    this.a.writeInt(so.a(i2));
                }
                i2++;
            }
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void F(int i, long j) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        r(i, 4, 8, 0);
        this.a.writeInt((int) j);
        this.a.flush();
    }

    public final void G(int i, long j) {
        while (j > 0) {
            long jMin = Math.min(this.d, j);
            j -= jMin;
            r(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.a.p(this.c, jMin);
        }
    }

    public final synchronized void c(SO so) {
        try {
            AbstractC4492zt.h(so, "peerSettings");
            if (this.e) {
                throw new IOException("closed");
            }
            this.d = so.e(this.d);
            if (so.b() != -1) {
                this.f.e(so.b());
            }
            r(0, 0, 4, 1);
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.e = true;
        this.a.close();
    }

    public final synchronized void d() {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            if (this.b) {
                Logger logger = h;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(AbstractC3724qX.t(">> CONNECTION " + C0376Br.b.k(), new Object[0]));
                }
                this.a.n(C0376Br.b);
                this.a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void flush() {
        if (this.e) {
            throw new IOException("closed");
        }
        this.a.flush();
    }

    public final synchronized void g(boolean z, int i, H8 h8, int i2) {
        if (this.e) {
            throw new IOException("closed");
        }
        i(i, z ? 1 : 0, h8, i2);
    }

    public final void i(int i, int i2, H8 h8, int i3) {
        r(i, i3, 0, i2);
        if (i3 > 0) {
            K8 k8 = this.a;
            AbstractC4492zt.e(h8);
            k8.p(h8, i3);
        }
    }

    public final void r(int i, int i2, int i3, int i4) {
        Logger logger = h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C0376Br.a.c(false, i, i2, i3, i4));
        }
        if (i2 > this.d) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.d + ": " + i2).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        AbstractC3724qX.b0(this.a, i2);
        this.a.writeByte(i3 & 255);
        this.a.writeByte(i4 & 255);
        this.a.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void t(int i, EnumC4069ul enumC4069ul, byte[] bArr) {
        try {
            AbstractC4492zt.h(enumC4069ul, "errorCode");
            AbstractC4492zt.h(bArr, "debugData");
            if (this.e) {
                throw new IOException("closed");
            }
            if (enumC4069ul.b() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            r(0, bArr.length + 8, 7, 0);
            this.a.writeInt(i);
            this.a.writeInt(enumC4069ul.b());
            if (!(bArr.length == 0)) {
                this.a.write(bArr);
            }
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void u(boolean z, int i, List list) {
        AbstractC4492zt.h(list, "headerBlock");
        if (this.e) {
            throw new IOException("closed");
        }
        this.f.g(list);
        long jR = this.c.R();
        long jMin = Math.min(this.d, jR);
        int i2 = jR == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        r(i, (int) jMin, 1, i2);
        this.a.p(this.c, jMin);
        if (jR > jMin) {
            G(i, jR - jMin);
        }
    }

    public final int v() {
        return this.d;
    }

    public final synchronized void x(boolean z, int i, int i2) {
        if (this.e) {
            throw new IOException("closed");
        }
        r(0, 8, 6, z ? 1 : 0);
        this.a.writeInt(i);
        this.a.writeInt(i2);
        this.a.flush();
    }

    public final synchronized void z(int i, int i2, List list) {
        AbstractC4492zt.h(list, "requestHeaders");
        if (this.e) {
            throw new IOException("closed");
        }
        this.f.g(list);
        long jR = this.c.R();
        int iMin = (int) Math.min(((long) this.d) - 4, jR);
        long j = iMin;
        r(i, iMin + 4, 5, jR == j ? 4 : 0);
        this.a.writeInt(i2 & Integer.MAX_VALUE);
        this.a.p(this.c, j);
        if (jR > j) {
            G(i, jR - j);
        }
    }
}
