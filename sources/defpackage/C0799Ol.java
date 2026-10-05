package defpackage;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: renamed from: Ol, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0799Ol {
    public final BJ a;
    public final AbstractC0396Cl b;
    public final C0860Ql c;
    public final InterfaceC0825Pl d;
    public boolean e;
    public boolean f;
    public final CJ g;

    /* JADX INFO: renamed from: Ol$a */
    public final class a extends AbstractC0914Sn {
        public final long b;
        public boolean c;
        public long d;
        public boolean e;
        public final /* synthetic */ C0799Ol f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C0799Ol c0799Ol, LQ lq, long j) {
            super(lq);
            AbstractC4492zt.h(lq, "delegate");
            this.f = c0799Ol;
            this.b = j;
        }

        private final IOException c(IOException iOException) {
            if (this.c) {
                return iOException;
            }
            this.c = true;
            return this.f.a(this.d, false, true, iOException);
        }

        @Override // defpackage.AbstractC0914Sn, defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.e) {
                return;
            }
            this.e = true;
            long j = this.b;
            if (j != -1 && this.d != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                c(null);
            } catch (IOException e) {
                throw c(e);
            }
        }

        @Override // defpackage.AbstractC0914Sn, defpackage.LQ, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw c(e);
            }
        }

        @Override // defpackage.AbstractC0914Sn, defpackage.LQ
        public void p(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
            if (this.e) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.b;
            if (j2 == -1 || this.d + j <= j2) {
                try {
                    super.p(h8, j);
                    this.d += j;
                    return;
                } catch (IOException e) {
                    throw c(e);
                }
            }
            throw new ProtocolException("expected " + this.b + " bytes but received " + (this.d + j));
        }
    }

    /* JADX INFO: renamed from: Ol$b */
    public final class b extends AbstractC0940Tn {
        public final long b;
        public long c;
        public boolean d;
        public boolean e;
        public boolean f;
        public final /* synthetic */ C0799Ol g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C0799Ol c0799Ol, InterfaceC3309lR interfaceC3309lR, long j) {
            super(interfaceC3309lR);
            AbstractC4492zt.h(interfaceC3309lR, "delegate");
            this.g = c0799Ol;
            this.b = j;
            this.d = true;
            if (j == 0) {
                d(null);
            }
        }

        @Override // defpackage.AbstractC0940Tn, defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.f) {
                return;
            }
            this.f = true;
            try {
                super.close();
                d(null);
            } catch (IOException e) {
                throw d(e);
            }
        }

        public final IOException d(IOException iOException) {
            if (this.e) {
                return iOException;
            }
            this.e = true;
            if (iOException == null && this.d) {
                this.d = false;
                this.g.i().v(this.g.g());
            }
            return this.g.a(this.c, true, false, iOException);
        }

        @Override // defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            if (this.f) {
                throw new IllegalStateException("closed");
            }
            try {
                long jY = c().y(h8, j);
                if (this.d) {
                    this.d = false;
                    this.g.i().v(this.g.g());
                }
                if (jY == -1) {
                    d(null);
                    return -1L;
                }
                long j2 = this.c + jY;
                long j3 = this.b;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.b + " bytes but received " + j2);
                }
                this.c = j2;
                if (j2 == j3) {
                    d(null);
                }
                return jY;
            } catch (IOException e) {
                throw d(e);
            }
        }
    }

    public C0799Ol(BJ bj, AbstractC0396Cl abstractC0396Cl, C0860Ql c0860Ql, InterfaceC0825Pl interfaceC0825Pl) {
        AbstractC4492zt.h(bj, NotificationCompat.CATEGORY_CALL);
        AbstractC4492zt.h(abstractC0396Cl, "eventListener");
        AbstractC4492zt.h(c0860Ql, "finder");
        AbstractC4492zt.h(interfaceC0825Pl, "codec");
        this.a = bj;
        this.b = abstractC0396Cl;
        this.c = c0860Ql;
        this.d = interfaceC0825Pl;
        this.g = interfaceC0825Pl.getConnection();
    }

    public final IOException a(long j, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            u(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.b.r(this.a, iOException);
            } else {
                this.b.p(this.a, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.b.w(this.a, iOException);
            } else {
                this.b.u(this.a, j);
            }
        }
        return this.a.t(this, z2, z, iOException);
    }

    public final void b() {
        this.d.cancel();
    }

    public final LQ c(C3873sL c3873sL, boolean z) {
        AbstractC4492zt.h(c3873sL, "request");
        this.e = z;
        AbstractC3954tL abstractC3954tLA = c3873sL.a();
        AbstractC4492zt.e(abstractC3954tLA);
        long jA = abstractC3954tLA.a();
        this.b.q(this.a);
        return new a(this, this.d.f(c3873sL, jA), jA);
    }

    public final void d() {
        this.d.cancel();
        this.a.t(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.d.b();
        } catch (IOException e) {
            this.b.r(this.a, e);
            u(e);
            throw e;
        }
    }

    public final void f() throws IOException {
        try {
            this.d.e();
        } catch (IOException e) {
            this.b.r(this.a, e);
            u(e);
            throw e;
        }
    }

    public final BJ g() {
        return this.a;
    }

    public final CJ h() {
        return this.g;
    }

    public final AbstractC0396Cl i() {
        return this.b;
    }

    public final C0860Ql j() {
        return this.c;
    }

    public final boolean k() {
        return this.f;
    }

    public final boolean l() {
        return !AbstractC4492zt.d(this.c.d().l().h(), this.g.A().a().l().h());
    }

    public final boolean m() {
        return this.e;
    }

    public final GJ.d n() {
        this.a.z();
        return this.d.getConnection().x(this);
    }

    public final void o() {
        this.d.getConnection().z();
    }

    public final void p() {
        this.a.t(this, true, false, null);
    }

    public final FL q(EL el) throws IOException {
        AbstractC4492zt.h(el, "response");
        try {
            String strX = EL.x(el, HttpHeaders.CONTENT_TYPE, null, 2, null);
            long jD = this.d.d(el);
            return new FJ(strX, jD, AbstractC4443zE.b(new b(this, this.d.a(el), jD)));
        } catch (IOException e) {
            this.b.w(this.a, e);
            u(e);
            throw e;
        }
    }

    public final EL.a r(boolean z) throws IOException {
        try {
            EL.a aVarC = this.d.c(z);
            if (aVarC != null) {
                aVarC.l(this);
            }
            return aVarC;
        } catch (IOException e) {
            this.b.w(this.a, e);
            u(e);
            throw e;
        }
    }

    public final void s(EL el) {
        AbstractC4492zt.h(el, "response");
        this.b.x(this.a, el);
    }

    public final void t() {
        this.b.y(this.a);
    }

    public final void u(IOException iOException) {
        this.f = true;
        this.c.h(iOException);
        this.d.getConnection().H(this.a, iOException);
    }

    public final void v() {
        a(-1L, true, true, null);
    }

    public final void w(C3873sL c3873sL) throws IOException {
        AbstractC4492zt.h(c3873sL, "request");
        try {
            this.b.t(this.a);
            this.d.g(c3873sL);
            this.b.s(this.a, c3873sL);
        } catch (IOException e) {
            this.b.r(this.a, e);
            u(e);
            throw e;
        }
    }
}
