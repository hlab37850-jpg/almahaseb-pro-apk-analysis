package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;

/* JADX INFO: renamed from: Fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0528Fr {
    public static final a o = new a(null);
    public final int a;
    public final C0402Cr b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final ArrayDeque g;
    public boolean h;
    public final c i;
    public final b j;
    public final d k;
    public final d l;
    public EnumC4069ul m;
    public IOException n;

    /* JADX INFO: renamed from: Fr$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: Fr$b */
    public final class b implements LQ {
        public boolean a;
        public final H8 b = new H8();
        public C3994tr c;
        public boolean d;

        public b(boolean z) {
            this.a = z;
        }

        @Override // defpackage.LQ
        public JU b() {
            return C0528Fr.this.s();
        }

        public final void c(boolean z) throws IOException {
            long jMin;
            boolean z2;
            C0528Fr c0528Fr = C0528Fr.this;
            synchronized (c0528Fr) {
                try {
                    c0528Fr.s().v();
                    while (c0528Fr.r() >= c0528Fr.q() && !this.a && !this.d && c0528Fr.h() == null) {
                        try {
                            c0528Fr.D();
                        } catch (Throwable th) {
                            c0528Fr.s().C();
                            throw th;
                        }
                    }
                    c0528Fr.s().C();
                    c0528Fr.c();
                    jMin = Math.min(c0528Fr.q() - c0528Fr.r(), this.b.R());
                    c0528Fr.B(c0528Fr.r() + jMin);
                    z2 = z && jMin == this.b.R();
                    FW fw = FW.a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            C0528Fr.this.s().v();
            try {
                C0528Fr.this.g().o0(C0528Fr.this.j(), z2, this.b, jMin);
            } finally {
                C0528Fr.this.s().C();
            }
        }

        @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C0528Fr c0528Fr = C0528Fr.this;
            if (AbstractC3724qX.h && Thread.holdsLock(c0528Fr)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c0528Fr);
            }
            C0528Fr c0528Fr2 = C0528Fr.this;
            synchronized (c0528Fr2) {
                if (this.d) {
                    return;
                }
                boolean z = c0528Fr2.h() == null;
                FW fw = FW.a;
                if (!C0528Fr.this.o().a) {
                    boolean z2 = this.b.R() > 0;
                    if (this.c != null) {
                        while (this.b.R() > 0) {
                            c(false);
                        }
                        C0402Cr c0402CrG = C0528Fr.this.g();
                        int iJ = C0528Fr.this.j();
                        C3994tr c3994tr = this.c;
                        AbstractC4492zt.e(c3994tr);
                        c0402CrG.p0(iJ, z, AbstractC3724qX.O(c3994tr));
                    } else if (z2) {
                        while (this.b.R() > 0) {
                            c(true);
                        }
                    } else if (z) {
                        C0528Fr.this.g().o0(C0528Fr.this.j(), true, null, 0L);
                    }
                }
                synchronized (C0528Fr.this) {
                    this.d = true;
                    FW fw2 = FW.a;
                }
                C0528Fr.this.g().flush();
                C0528Fr.this.b();
            }
        }

        public final boolean d() {
            return this.d;
        }

        @Override // defpackage.LQ, java.io.Flushable
        public void flush() throws IOException {
            C0528Fr c0528Fr = C0528Fr.this;
            if (AbstractC3724qX.h && Thread.holdsLock(c0528Fr)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c0528Fr);
            }
            C0528Fr c0528Fr2 = C0528Fr.this;
            synchronized (c0528Fr2) {
                c0528Fr2.c();
                FW fw = FW.a;
            }
            while (this.b.R() > 0) {
                c(false);
                C0528Fr.this.g().flush();
            }
        }

        public final boolean g() {
            return this.a;
        }

        @Override // defpackage.LQ
        public void p(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
            C0528Fr c0528Fr = C0528Fr.this;
            if (!AbstractC3724qX.h || !Thread.holdsLock(c0528Fr)) {
                this.b.p(h8, j);
                while (this.b.R() >= PlaybackStateCompat.ACTION_PREPARE) {
                    c(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c0528Fr);
            }
        }
    }

    /* JADX INFO: renamed from: Fr$c */
    public final class c implements InterfaceC3309lR {
        public final long a;
        public boolean b;
        public final H8 c = new H8();
        public final H8 d = new H8();
        public C3994tr e;
        public boolean f;

        public c(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        @Override // defpackage.InterfaceC3309lR
        public JU b() {
            return C0528Fr.this.m();
        }

        public final boolean c() {
            return this.f;
        }

        @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            long jR;
            C0528Fr c0528Fr = C0528Fr.this;
            synchronized (c0528Fr) {
                this.f = true;
                jR = this.d.R();
                this.d.d();
                AbstractC4492zt.f(c0528Fr, "null cannot be cast to non-null type java.lang.Object");
                c0528Fr.notifyAll();
                FW fw = FW.a;
            }
            if (jR > 0) {
                t(jR);
            }
            C0528Fr.this.b();
        }

        public final boolean d() {
            return this.b;
        }

        public final void g(L8 l8, long j) throws EOFException {
            boolean z;
            boolean z2;
            AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
            C0528Fr c0528Fr = C0528Fr.this;
            if (AbstractC3724qX.h && Thread.holdsLock(c0528Fr)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c0528Fr);
            }
            long j2 = j;
            while (j2 > 0) {
                synchronized (C0528Fr.this) {
                    z = this.b;
                    z2 = this.d.R() + j2 > this.a;
                    FW fw = FW.a;
                }
                if (z2) {
                    l8.skip(j2);
                    C0528Fr.this.f(EnumC4069ul.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    l8.skip(j2);
                    return;
                }
                long jY = l8.y(this.c, j2);
                if (jY == -1) {
                    throw new EOFException();
                }
                j2 -= jY;
                C0528Fr c0528Fr2 = C0528Fr.this;
                synchronized (c0528Fr2) {
                    try {
                        if (this.f) {
                            this.c.d();
                        } else {
                            boolean z3 = this.d.R() == 0;
                            this.d.Y(this.c);
                            if (z3) {
                                AbstractC4492zt.f(c0528Fr2, "null cannot be cast to non-null type java.lang.Object");
                                c0528Fr2.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            t(j);
        }

        public final void i(boolean z) {
            this.b = z;
        }

        public final void r(C3994tr c3994tr) {
            this.e = c3994tr;
        }

        public final void t(long j) {
            C0528Fr c0528Fr = C0528Fr.this;
            if (!AbstractC3724qX.h || !Thread.holdsLock(c0528Fr)) {
                C0528Fr.this.g().n0(j);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c0528Fr);
        }

        @Override // defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            IOException iOExceptionI;
            boolean z;
            long jY;
            AbstractC4492zt.h(h8, "sink");
            long j2 = 0;
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            while (true) {
                C0528Fr c0528Fr = C0528Fr.this;
                synchronized (c0528Fr) {
                    c0528Fr.m().v();
                    try {
                        if (c0528Fr.h() == null || this.b) {
                            iOExceptionI = null;
                        } else {
                            iOExceptionI = c0528Fr.i();
                            if (iOExceptionI == null) {
                                EnumC4069ul enumC4069ulH = c0528Fr.h();
                                AbstractC4492zt.e(enumC4069ulH);
                                iOExceptionI = new C2195fS(enumC4069ulH);
                            }
                        }
                        if (this.f) {
                            throw new IOException("stream closed");
                        }
                        z = false;
                        if (this.d.R() > j2) {
                            H8 h9 = this.d;
                            jY = h9.y(h8, Math.min(j, h9.R()));
                            c0528Fr.A(c0528Fr.l() + jY);
                            long jL = c0528Fr.l() - c0528Fr.k();
                            if (iOExceptionI == null && jL >= c0528Fr.g().S().c() / 2) {
                                c0528Fr.g().t0(c0528Fr.j(), jL);
                                c0528Fr.z(c0528Fr.l());
                            }
                        } else {
                            if (!this.b && iOExceptionI == null) {
                                c0528Fr.D();
                                z = true;
                            }
                            jY = -1;
                        }
                        c0528Fr.m().C();
                        FW fw = FW.a;
                    } catch (Throwable th) {
                        c0528Fr.m().C();
                        throw th;
                    }
                    throw th;
                }
                if (!z) {
                    if (jY != -1) {
                        return jY;
                    }
                    if (iOExceptionI == null) {
                        return -1L;
                    }
                    throw iOExceptionI;
                }
                j2 = 0;
            }
        }
    }

    /* JADX INFO: renamed from: Fr$d */
    public final class d extends W5 {
        public d() {
        }

        @Override // defpackage.W5
        public void B() {
            C0528Fr.this.f(EnumC4069ul.CANCEL);
            C0528Fr.this.g().h0();
        }

        public final void C() throws IOException {
            if (w()) {
                throw x(null);
            }
        }

        @Override // defpackage.W5
        public IOException x(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public C0528Fr(int i, C0402Cr c0402Cr, boolean z, boolean z2, C3994tr c3994tr) {
        AbstractC4492zt.h(c0402Cr, "connection");
        this.a = i;
        this.b = c0402Cr;
        this.f = c0402Cr.T().c();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.g = arrayDeque;
        this.i = new c(c0402Cr.S().c(), z2);
        this.j = new b(z);
        this.k = new d();
        this.l = new d();
        if (c3994tr == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (t()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(c3994tr);
        }
    }

    public final void A(long j) {
        this.c = j;
    }

    public final void B(long j) {
        this.e = j;
    }

    public final synchronized C3994tr C() {
        Object objRemoveFirst;
        this.k.v();
        while (this.g.isEmpty() && this.m == null) {
            try {
                D();
            } catch (Throwable th) {
                this.k.C();
                throw th;
            }
        }
        this.k.C();
        if (this.g.isEmpty()) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            EnumC4069ul enumC4069ul = this.m;
            AbstractC4492zt.e(enumC4069ul);
            throw new C2195fS(enumC4069ul);
        }
        objRemoveFirst = this.g.removeFirst();
        AbstractC4492zt.g(objRemoveFirst, "headersQueue.removeFirst()");
        return (C3994tr) objRemoveFirst;
    }

    public final void D() throws InterruptedIOException {
        try {
            AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final JU E() {
        return this.l;
    }

    public final void a(long j) {
        this.f += j;
        if (j > 0) {
            AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void b() {
        boolean z;
        boolean zU;
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                z = !this.i.d() && this.i.c() && (this.j.g() || this.j.d());
                zU = u();
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            d(EnumC4069ul.CANCEL, null);
        } else {
            if (zU) {
                return;
            }
            this.b.g0(this.a);
        }
    }

    public final void c() throws IOException {
        if (this.j.d()) {
            throw new IOException("stream closed");
        }
        if (this.j.g()) {
            throw new IOException("stream finished");
        }
        if (this.m != null) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            EnumC4069ul enumC4069ul = this.m;
            AbstractC4492zt.e(enumC4069ul);
            throw new C2195fS(enumC4069ul);
        }
    }

    public final void d(EnumC4069ul enumC4069ul, IOException iOException) {
        AbstractC4492zt.h(enumC4069ul, "rstStatusCode");
        if (e(enumC4069ul, iOException)) {
            this.b.r0(this.a, enumC4069ul);
        }
    }

    public final boolean e(EnumC4069ul enumC4069ul, IOException iOException) {
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.m != null) {
                return false;
            }
            this.m = enumC4069ul;
            this.n = iOException;
            AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.i.d() && this.j.g()) {
                return false;
            }
            FW fw = FW.a;
            this.b.g0(this.a);
            return true;
        }
    }

    public final void f(EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "errorCode");
        if (e(enumC4069ul, null)) {
            this.b.s0(this.a, enumC4069ul);
        }
    }

    public final C0402Cr g() {
        return this.b;
    }

    public final synchronized EnumC4069ul h() {
        return this.m;
    }

    public final IOException i() {
        return this.n;
    }

    public final int j() {
        return this.a;
    }

    public final long k() {
        return this.d;
    }

    public final long l() {
        return this.c;
    }

    public final d m() {
        return this.k;
    }

    public final LQ n() {
        synchronized (this) {
            try {
                if (!this.h && !t()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.j;
    }

    public final b o() {
        return this.j;
    }

    public final c p() {
        return this.i;
    }

    public final long q() {
        return this.f;
    }

    public final long r() {
        return this.e;
    }

    public final d s() {
        return this.l;
    }

    public final boolean t() {
        return this.b.N() == ((this.a & 1) == 1);
    }

    public final synchronized boolean u() {
        try {
            if (this.m != null) {
                return false;
            }
            if (this.i.d() || this.i.c()) {
                if ((this.j.g() || this.j.d()) && this.h) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final JU v() {
        return this.k;
    }

    public final void w(L8 l8, int i) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        if (!AbstractC3724qX.h || !Thread.holdsLock(this)) {
            this.i.g(l8, i);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void x(C3994tr c3994tr, boolean z) {
        boolean zU;
        AbstractC4492zt.h(c3994tr, "headers");
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.h && z) {
                    this.i.r(c3994tr);
                } else {
                    this.h = true;
                    this.g.add(c3994tr);
                }
                if (z) {
                    this.i.i(true);
                }
                zU = u();
                AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zU) {
            return;
        }
        this.b.g0(this.a);
    }

    public final synchronized void y(EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "errorCode");
        if (this.m == null) {
            this.m = enumC4069ul;
            AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void z(long j) {
        this.d = j;
    }
}
