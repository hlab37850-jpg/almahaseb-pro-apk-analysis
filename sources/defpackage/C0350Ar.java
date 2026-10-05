package defpackage;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0350Ar implements InterfaceC0825Pl {
    public static final d h = new d(null);
    public final C4271xE a;
    public final CJ b;
    public final L8 c;
    public final K8 d;
    public int e;
    public final C4075ur f;
    public C3994tr g;

    /* JADX INFO: renamed from: Ar$a */
    public abstract class a implements InterfaceC3309lR {
        public final C0966Un a;
        public boolean b;

        public a() {
            this.a = new C0966Un(C0350Ar.this.c.b());
        }

        @Override // defpackage.InterfaceC3309lR
        public JU b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }

        public final void d() {
            if (C0350Ar.this.e == 6) {
                return;
            }
            if (C0350Ar.this.e == 5) {
                C0350Ar.this.q(this.a);
                C0350Ar.this.e = 6;
            } else {
                throw new IllegalStateException("state: " + C0350Ar.this.e);
            }
        }

        public final void g(boolean z) {
            this.b = z;
        }

        @Override // defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            try {
                return C0350Ar.this.c.y(h8, j);
            } catch (IOException e) {
                C0350Ar.this.getConnection().z();
                d();
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: Ar$b */
    public final class b implements LQ {
        public final C0966Un a;
        public boolean b;

        public b() {
            this.a = new C0966Un(C0350Ar.this.d.b());
        }

        @Override // defpackage.LQ
        public JU b() {
            return this.a;
        }

        @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            C0350Ar.this.d.l("0\r\n\r\n");
            C0350Ar.this.q(this.a);
            C0350Ar.this.e = 3;
        }

        @Override // defpackage.LQ, java.io.Flushable
        public synchronized void flush() {
            if (this.b) {
                return;
            }
            C0350Ar.this.d.flush();
        }

        @Override // defpackage.LQ
        public void p(H8 h8, long j) {
            AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            C0350Ar.this.d.q(j);
            C0350Ar.this.d.l(StringUtilities.CRLF);
            C0350Ar.this.d.p(h8, j);
            C0350Ar.this.d.l(StringUtilities.CRLF);
        }
    }

    /* JADX INFO: renamed from: Ar$c */
    public final class c extends a {
        public final C0779Nr d;
        public long e;
        public boolean f;
        public final /* synthetic */ C0350Ar g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C0350Ar c0350Ar, C0779Nr c0779Nr) {
            super();
            AbstractC4492zt.h(c0779Nr, "url");
            this.g = c0350Ar;
            this.d = c0779Nr;
            this.e = -1L;
            this.f = true;
        }

        @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (c()) {
                return;
            }
            if (this.f && !AbstractC3724qX.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.g.getConnection().z();
                d();
            }
            g(true);
        }

        public final void i() throws ProtocolException {
            if (this.e != -1) {
                this.g.c.s();
            }
            try {
                this.e = this.g.c.E();
                String string = AbstractC3961tS.D0(this.g.c.s()).toString();
                if (this.e < 0 || (string.length() > 0 && !AbstractC3880sS.B(string, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + string + '\"');
                }
                if (this.e == 0) {
                    this.f = false;
                    C0350Ar c0350Ar = this.g;
                    c0350Ar.g = c0350Ar.f.a();
                    C4271xE c4271xE = this.g.a;
                    AbstractC4492zt.e(c4271xE);
                    InterfaceC0932Tf interfaceC0932TfO = c4271xE.o();
                    C0779Nr c0779Nr = this.d;
                    C3994tr c3994tr = this.g.g;
                    AbstractC4492zt.e(c3994tr);
                    AbstractC0632Jr.f(interfaceC0932TfO, c0779Nr, c3994tr);
                    d();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // defpackage.C0350Ar.a, defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (c()) {
                throw new IllegalStateException("closed");
            }
            if (!this.f) {
                return -1L;
            }
            long j2 = this.e;
            if (j2 == 0 || j2 == -1) {
                i();
                if (!this.f) {
                    return -1L;
                }
            }
            long jY = super.y(h8, Math.min(j, this.e));
            if (jY != -1) {
                this.e -= jY;
                return jY;
            }
            this.g.getConnection().z();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            d();
            throw protocolException;
        }
    }

    /* JADX INFO: renamed from: Ar$d */
    public static final class d {
        public /* synthetic */ d(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public d() {
        }
    }

    /* JADX INFO: renamed from: Ar$e */
    public final class e extends a {
        public long d;

        public e(long j) {
            super();
            this.d = j;
            if (j == 0) {
                d();
            }
        }

        @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (c()) {
                return;
            }
            if (this.d != 0 && !AbstractC3724qX.s(this, 100, TimeUnit.MILLISECONDS)) {
                C0350Ar.this.getConnection().z();
                d();
            }
            g(true);
        }

        @Override // defpackage.C0350Ar.a, defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (c()) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.d;
            if (j2 == 0) {
                return -1L;
            }
            long jY = super.y(h8, Math.min(j2, j));
            if (jY == -1) {
                C0350Ar.this.getConnection().z();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d();
                throw protocolException;
            }
            long j3 = this.d - jY;
            this.d = j3;
            if (j3 == 0) {
                d();
            }
            return jY;
        }
    }

    /* JADX INFO: renamed from: Ar$f */
    public final class f implements LQ {
        public final C0966Un a;
        public boolean b;

        public f() {
            this.a = new C0966Un(C0350Ar.this.d.b());
        }

        @Override // defpackage.LQ
        public JU b() {
            return this.a;
        }

        @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            C0350Ar.this.q(this.a);
            C0350Ar.this.e = 3;
        }

        @Override // defpackage.LQ, java.io.Flushable
        public void flush() {
            if (this.b) {
                return;
            }
            C0350Ar.this.d.flush();
        }

        @Override // defpackage.LQ
        public void p(H8 h8, long j) {
            AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            AbstractC3724qX.l(h8.R(), 0L, j);
            C0350Ar.this.d.p(h8, j);
        }
    }

    /* JADX INFO: renamed from: Ar$g */
    public final class g extends a {
        public boolean d;

        public g() {
            super();
        }

        @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (c()) {
                return;
            }
            if (!this.d) {
                d();
            }
            g(true);
        }

        @Override // defpackage.C0350Ar.a, defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (c()) {
                throw new IllegalStateException("closed");
            }
            if (this.d) {
                return -1L;
            }
            long jY = super.y(h8, j);
            if (jY != -1) {
                return jY;
            }
            this.d = true;
            d();
            return -1L;
        }
    }

    public C0350Ar(C4271xE c4271xE, CJ cj, L8 l8, K8 k8) {
        AbstractC4492zt.h(cj, "connection");
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(k8, "sink");
        this.a = c4271xE;
        this.b = cj;
        this.c = l8;
        this.d = k8;
        this.f = new C4075ur(l8);
    }

    @Override // defpackage.InterfaceC0825Pl
    public InterfaceC3309lR a(EL el) {
        AbstractC4492zt.h(el, "response");
        if (!AbstractC0632Jr.b(el)) {
            return v(0L);
        }
        if (s(el)) {
            return u(el.K().i());
        }
        long jV = AbstractC3724qX.v(el);
        return jV != -1 ? v(jV) : x();
    }

    @Override // defpackage.InterfaceC0825Pl
    public void b() {
        this.d.flush();
    }

    @Override // defpackage.InterfaceC0825Pl
    public EL.a c(boolean z) {
        int i = this.e;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.e).toString());
        }
        try {
            C2113eS c2113eSA = C2113eS.d.a(this.f.b());
            EL.a aVarK = new EL.a().p(c2113eSA.a).g(c2113eSA.b).m(c2113eSA.c).k(this.f.a());
            if (z && c2113eSA.b == 100) {
                return null;
            }
            int i2 = c2113eSA.b;
            if (i2 == 100) {
                this.e = 3;
                return aVarK;
            }
            if (102 > i2 || i2 >= 200) {
                this.e = 4;
                return aVarK;
            }
            this.e = 3;
            return aVarK;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + getConnection().A().a().l().o(), e2);
        }
    }

    @Override // defpackage.InterfaceC0825Pl
    public void cancel() {
        getConnection().d();
    }

    @Override // defpackage.InterfaceC0825Pl
    public long d(EL el) {
        AbstractC4492zt.h(el, "response");
        if (!AbstractC0632Jr.b(el)) {
            return 0L;
        }
        if (s(el)) {
            return -1L;
        }
        return AbstractC3724qX.v(el);
    }

    @Override // defpackage.InterfaceC0825Pl
    public void e() {
        this.d.flush();
    }

    @Override // defpackage.InterfaceC0825Pl
    public LQ f(C3873sL c3873sL, long j) throws ProtocolException {
        AbstractC4492zt.h(c3873sL, "request");
        if (c3873sL.a() != null && c3873sL.a().d()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (r(c3873sL)) {
            return t();
        }
        if (j != -1) {
            return w();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // defpackage.InterfaceC0825Pl
    public void g(C3873sL c3873sL) {
        AbstractC4492zt.h(c3873sL, "request");
        C4197wL c4197wL = C4197wL.a;
        Proxy.Type type = getConnection().A().b().type();
        AbstractC4492zt.g(type, "connection.route().proxy.type()");
        z(c3873sL.e(), c4197wL.a(c3873sL, type));
    }

    @Override // defpackage.InterfaceC0825Pl
    public CJ getConnection() {
        return this.b;
    }

    public final void q(C0966Un c0966Un) {
        JU juI = c0966Un.i();
        c0966Un.j(JU.e);
        juI.a();
        juI.b();
    }

    public final boolean r(C3873sL c3873sL) {
        return AbstractC3880sS.q("chunked", c3873sL.d(HttpHeaders.TRANSFER_ENCODING), true);
    }

    public final boolean s(EL el) {
        return AbstractC3880sS.q("chunked", EL.x(el, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true);
    }

    public final LQ t() {
        if (this.e == 1) {
            this.e = 2;
            return new b();
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    public final InterfaceC3309lR u(C0779Nr c0779Nr) {
        if (this.e == 4) {
            this.e = 5;
            return new c(this, c0779Nr);
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    public final InterfaceC3309lR v(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new e(j);
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    public final LQ w() {
        if (this.e == 1) {
            this.e = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    public final InterfaceC3309lR x() {
        if (this.e == 4) {
            this.e = 5;
            getConnection().z();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    public final void y(EL el) {
        AbstractC4492zt.h(el, "response");
        long jV = AbstractC3724qX.v(el);
        if (jV == -1) {
            return;
        }
        InterfaceC3309lR interfaceC3309lRV = v(jV);
        AbstractC3724qX.L(interfaceC3309lRV, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        interfaceC3309lRV.close();
    }

    public final void z(C3994tr c3994tr, String str) {
        AbstractC4492zt.h(c3994tr, "headers");
        AbstractC4492zt.h(str, "requestLine");
        if (this.e != 0) {
            throw new IllegalStateException(("state: " + this.e).toString());
        }
        this.d.l(str).l(StringUtilities.CRLF);
        int size = c3994tr.size();
        for (int i = 0; i < size; i++) {
            this.d.l(c3994tr.b(i)).l(": ").l(c3994tr.e(i)).l(StringUtilities.CRLF);
        }
        this.d.l(StringUtilities.CRLF);
        this.e = 1;
    }
}
