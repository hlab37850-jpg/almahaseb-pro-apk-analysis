package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: mY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3398mY implements Closeable {
    public final boolean a;
    public final L8 b;
    public final a c;
    public final boolean d;
    public final boolean e;
    public boolean f;
    public int g;
    public long h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final H8 l;
    public final H8 n;
    public TB p;
    public final byte[] q;
    public final H8.a t;

    /* JADX INFO: renamed from: mY$a */
    public interface a {
        void b(W8 w8);

        void c(String str);

        void e(W8 w8);

        void g(int i, String str);

        void h(W8 w8);
    }

    public C3398mY(boolean z, L8 l8, a aVar, boolean z2, boolean z3) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(aVar, "frameCallback");
        this.a = z;
        this.b = l8;
        this.c = aVar;
        this.d = z2;
        this.e = z3;
        this.l = new H8();
        this.n = new H8();
        this.q = z ? null : new byte[4];
        this.t = z ? null : new H8.a();
    }

    public final void c() {
        g();
        if (this.j) {
            d();
        } else {
            r();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        TB tb = this.p;
        if (tb != null) {
            tb.close();
        }
    }

    public final void d() throws ProtocolException, EOFException {
        short s;
        String strO;
        long j = this.h;
        if (j > 0) {
            this.b.m(this.l, j);
            if (!this.a) {
                H8 h8 = this.l;
                H8.a aVar = this.t;
                AbstractC4492zt.e(aVar);
                h8.H(aVar);
                this.t.i(0L);
                C3316lY c3316lY = C3316lY.a;
                H8.a aVar2 = this.t;
                byte[] bArr = this.q;
                AbstractC4492zt.e(bArr);
                c3316lY.b(aVar2, bArr);
                this.t.close();
            }
        }
        switch (this.g) {
            case 8:
                long jR = this.l.R();
                if (jR == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jR != 0) {
                    s = this.l.readShort();
                    strO = this.l.O();
                    String strA = C3316lY.a.a(s);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    s = 1005;
                    strO = "";
                }
                this.c.g(s, strO);
                this.f = true;
                return;
            case 9:
                this.c.e(this.l.K());
                return;
            case 10:
                this.c.b(this.l.K());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + AbstractC3724qX.Q(this.g));
        }
    }

    public final void g() throws IOException {
        boolean z;
        if (this.f) {
            throw new IOException("closed");
        }
        long jH = this.b.b().h();
        this.b.b().b();
        try {
            int iD = AbstractC3724qX.d(this.b.readByte(), 255);
            this.b.b().g(jH, TimeUnit.NANOSECONDS);
            int i = iD & 15;
            this.g = i;
            boolean z2 = (iD & 128) != 0;
            this.i = z2;
            boolean z3 = (iD & 8) != 0;
            this.j = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (iD & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.d) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.k = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iD & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iD & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iD2 = AbstractC3724qX.d(this.b.readByte(), 255);
            boolean z5 = (iD2 & 128) != 0;
            if (z5 == this.a) {
                throw new ProtocolException(this.a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iD2 & ShapeTypes.VERTICAL_SCROLL;
            this.h = j;
            if (j == 126) {
                this.h = AbstractC3724qX.e(this.b.readShort(), 65535);
            } else if (j == 127) {
                long j2 = this.b.readLong();
                this.h = j2;
                if (j2 < 0) {
                    throw new ProtocolException("Frame length 0x" + AbstractC3724qX.R(this.h) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.j && this.h > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                L8 l8 = this.b;
                byte[] bArr = this.q;
                AbstractC4492zt.e(bArr);
                l8.readFully(bArr);
            }
        } catch (Throwable th) {
            this.b.b().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    public final void i() throws IOException {
        while (!this.f) {
            long j = this.h;
            if (j > 0) {
                this.b.m(this.n, j);
                if (!this.a) {
                    H8 h8 = this.n;
                    H8.a aVar = this.t;
                    AbstractC4492zt.e(aVar);
                    h8.H(aVar);
                    this.t.i(this.n.R() - this.h);
                    C3316lY c3316lY = C3316lY.a;
                    H8.a aVar2 = this.t;
                    byte[] bArr = this.q;
                    AbstractC4492zt.e(bArr);
                    c3316lY.b(aVar2, bArr);
                    this.t.close();
                }
            }
            if (this.i) {
                return;
            }
            t();
            if (this.g != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + AbstractC3724qX.Q(this.g));
            }
        }
        throw new IOException("closed");
    }

    public final void r() throws IOException {
        int i = this.g;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + AbstractC3724qX.Q(i));
        }
        i();
        if (this.k) {
            TB tb = this.p;
            if (tb == null) {
                tb = new TB(this.e);
                this.p = tb;
            }
            tb.c(this.n);
        }
        if (i == 1) {
            this.c.c(this.n.O());
        } else {
            this.c.h(this.n.K());
        }
    }

    public final void t() throws IOException {
        while (!this.f) {
            g();
            if (!this.j) {
                return;
            } else {
                d();
            }
        }
    }
}
