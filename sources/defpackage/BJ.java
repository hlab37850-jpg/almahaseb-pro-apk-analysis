package defpackage;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class BJ implements InterfaceC2121ea {
    public final C4271xE a;
    public final C3873sL b;
    public final boolean c;
    public final DJ d;
    public final AbstractC0396Cl e;
    public final c f;
    public final AtomicBoolean g;
    public Object h;
    public C0860Ql i;
    public CJ j;
    public boolean k;
    public C0799Ol l;
    public boolean n;
    public boolean p;
    public boolean q;
    public volatile boolean t;
    public volatile C0799Ol u;
    public volatile CJ v;

    public final class a implements Runnable {
        public final InterfaceC3318la a;
        public volatile AtomicInteger b;
        public final /* synthetic */ BJ c;

        public a(BJ bj, InterfaceC3318la interfaceC3318la) {
            AbstractC4492zt.h(interfaceC3318la, "responseCallback");
            this.c = bj;
            this.a = interfaceC3318la;
            this.b = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            AbstractC4492zt.h(executorService, "executorService");
            C0342Aj c0342AjP = this.c.k().p();
            if (AbstractC3724qX.h && Thread.holdsLock(c0342AjP)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c0342AjP);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.c.u(interruptedIOException);
                    this.a.b(this.c, interruptedIOException);
                    this.c.k().p().e(this);
                }
            } catch (Throwable th) {
                this.c.k().p().e(this);
                throw th;
            }
        }

        public final BJ b() {
            return this.c;
        }

        public final AtomicInteger c() {
            return this.b;
        }

        public final String d() {
            return this.c.p().i().h();
        }

        public final void e(a aVar) {
            AbstractC4492zt.h(aVar, "other");
            this.b = aVar.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            boolean z;
            IOException e;
            C0342Aj c0342AjP;
            String str = "OkHttp " + this.c.v();
            BJ bj = this.c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                bj.f.v();
                try {
                    try {
                        z = true;
                        try {
                            this.a.a(bj, bj.q());
                            c0342AjP = bj.k().p();
                        } catch (IOException e2) {
                            e = e2;
                            if (z) {
                                EG.a.g().j("Callback failure for " + bj.B(), 4, e);
                            } else {
                                this.a.b(bj, e);
                            }
                            c0342AjP = bj.k().p();
                        } catch (Throwable th2) {
                            th = th2;
                            bj.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                AbstractC0773Nl.a(iOException, th);
                                this.a.b(bj, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        bj.k().p().e(this);
                        throw th3;
                    }
                } catch (IOException e3) {
                    e = e3;
                    z = false;
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
                c0342AjP.e(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th5) {
                threadCurrentThread.setName(name);
                throw th5;
            }
        }
    }

    public static final class b extends WeakReference {
        public final Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BJ bj, Object obj) {
            super(bj);
            AbstractC4492zt.h(bj, "referent");
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }
    }

    public static final class c extends W5 {
        public c() {
        }

        @Override // defpackage.W5
        public void B() {
            BJ.this.cancel();
        }
    }

    public BJ(C4271xE c4271xE, C3873sL c3873sL, boolean z) {
        AbstractC4492zt.h(c4271xE, "client");
        AbstractC4492zt.h(c3873sL, "originalRequest");
        this.a = c4271xE;
        this.b = c3873sL;
        this.c = z;
        this.d = c4271xE.m().a();
        this.e = c4271xE.r().a(this);
        c cVar = new c();
        cVar.g(c4271xE.i(), TimeUnit.MILLISECONDS);
        this.f = cVar;
        this.g = new AtomicBoolean();
        this.q = true;
    }

    public final IOException A(IOException iOException) {
        if (this.k || !this.f.w()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final String B() {
        StringBuilder sb = new StringBuilder();
        sb.append(s() ? "canceled " : "");
        sb.append(this.c ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(v());
        return sb.toString();
    }

    @Override // defpackage.InterfaceC2121ea
    public void c(InterfaceC3318la interfaceC3318la) {
        AbstractC4492zt.h(interfaceC3318la, "responseCallback");
        if (!this.g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        f();
        this.a.p().a(new a(this, interfaceC3318la));
    }

    @Override // defpackage.InterfaceC2121ea
    public void cancel() {
        if (this.t) {
            return;
        }
        this.t = true;
        C0799Ol c0799Ol = this.u;
        if (c0799Ol != null) {
            c0799Ol.b();
        }
        CJ cj = this.v;
        if (cj != null) {
            cj.d();
        }
        this.e.f(this);
    }

    public final void d(CJ cj) {
        AbstractC4492zt.h(cj, "connection");
        if (!AbstractC3724qX.h || Thread.holdsLock(cj)) {
            if (this.j != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.j = cj;
            cj.n().add(new b(this, this.h));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + cj);
    }

    public final IOException e(IOException iOException) {
        Socket socketW;
        boolean z = AbstractC3724qX.h;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        CJ cj = this.j;
        if (cj != null) {
            if (z && Thread.holdsLock(cj)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + cj);
            }
            synchronized (cj) {
                socketW = w();
            }
            if (this.j == null) {
                if (socketW != null) {
                    AbstractC3724qX.n(socketW);
                }
                this.e.k(this, cj);
            } else if (socketW != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException iOExceptionA = A(iOException);
        if (iOException != null) {
            AbstractC0396Cl abstractC0396Cl = this.e;
            AbstractC4492zt.e(iOExceptionA);
            abstractC0396Cl.d(this, iOExceptionA);
        } else {
            this.e.c(this);
        }
        return iOExceptionA;
    }

    public final void f() {
        this.h = EG.a.g().h("response.body().close()");
        this.e.e(this);
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public BJ clone() {
        return new BJ(this.a, this.b, this.c);
    }

    public final C3846s2 h(C0779Nr c0779Nr) {
        SSLSocketFactory sSLSocketFactoryI;
        HostnameVerifier hostnameVerifierV;
        C0953Ua c0953UaK;
        if (c0779Nr.i()) {
            sSLSocketFactoryI = this.a.I();
            hostnameVerifierV = this.a.v();
            c0953UaK = this.a.k();
        } else {
            sSLSocketFactoryI = null;
            hostnameVerifierV = null;
            c0953UaK = null;
        }
        return new C3846s2(c0779Nr.h(), c0779Nr.m(), this.a.q(), this.a.H(), sSLSocketFactoryI, hostnameVerifierV, c0953UaK, this.a.D(), this.a.C(), this.a.B(), this.a.n(), this.a.E());
    }

    public final void i(C3873sL c3873sL, boolean z) {
        AbstractC4492zt.h(c3873sL, "request");
        if (this.l != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.p) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.n) {
                throw new IllegalStateException("Check failed.");
            }
            FW fw = FW.a;
        }
        if (z) {
            this.i = new C0860Ql(this.d, h(c3873sL.i()), this, this.e);
        }
    }

    public final void j(boolean z) {
        C0799Ol c0799Ol;
        synchronized (this) {
            if (!this.q) {
                throw new IllegalStateException("released");
            }
            FW fw = FW.a;
        }
        if (z && (c0799Ol = this.u) != null) {
            c0799Ol.d();
        }
        this.l = null;
    }

    public final C4271xE k() {
        return this.a;
    }

    public final CJ l() {
        return this.j;
    }

    public final AbstractC0396Cl m() {
        return this.e;
    }

    public final boolean n() {
        return this.c;
    }

    public final C0799Ol o() {
        return this.l;
    }

    public final C3873sL p() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00a0  */
    public final EL q() throws Throwable {
        ArrayList arrayList = new ArrayList();
        AbstractC2371hc.D(arrayList, this.a.w());
        arrayList.add(new PL(this.a));
        arrayList.add(new F8(this.a.o()));
        this.a.h();
        arrayList.add(new C3454n9(null));
        arrayList.add(C0905Se.a);
        if (!this.c) {
            AbstractC2371hc.D(arrayList, this.a.y());
        }
        arrayList.add(new C2203fa(this.c));
        boolean z = false;
        try {
            EL elA = new EJ(this, arrayList, 0, null, this.b, this.a.l(), this.a.F(), this.a.K()).a(this.b);
            if (s()) {
                AbstractC3724qX.m(elA);
                throw new IOException("Canceled");
            }
            u(null);
            return elA;
        } catch (IOException e) {
            try {
                IOException iOExceptionU = u(e);
                AbstractC4492zt.f(iOExceptionU, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionU;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    u(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                u(null);
            }
            throw th;
        }
    }

    public final C0799Ol r(EJ ej) throws IOException {
        AbstractC4492zt.h(ej, "chain");
        synchronized (this) {
            if (!this.q) {
                throw new IllegalStateException("released");
            }
            if (this.p) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.n) {
                throw new IllegalStateException("Check failed.");
            }
            FW fw = FW.a;
        }
        C0860Ql c0860Ql = this.i;
        AbstractC4492zt.e(c0860Ql);
        C0799Ol c0799Ol = new C0799Ol(this, this.e, c0860Ql, c0860Ql.a(this.a, ej));
        this.l = c0799Ol;
        this.u = c0799Ol;
        synchronized (this) {
            this.n = true;
            this.p = true;
        }
        if (this.t) {
            throw new IOException("Canceled");
        }
        return c0799Ol;
    }

    public boolean s() {
        return this.t;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final IOException t(C0799Ol c0799Ol, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AbstractC4492zt.h(c0799Ol, "exchange");
        if (!AbstractC4492zt.d(c0799Ol, this.u)) {
            return iOException;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (this.n) {
                        if (z) {
                            this.n = false;
                        }
                        if (z2) {
                            this.p = false;
                        }
                        z5 = this.n;
                        if (z5) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        if (!z5) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    } else if (z2 || !this.p) {
                        z4 = false;
                    } else {
                        if (z) {
                            this.n = false;
                        }
                        if (z2) {
                            this.p = false;
                        }
                        z5 = this.n;
                        if (z5 || this.p) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (!z5 && !this.p && !this.q) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
            FW fw = FW.a;
        }
        if (z3) {
            this.u = null;
            CJ cj = this.j;
            if (cj != null) {
                cj.s();
            }
        }
        return z4 ? e(iOException) : iOException;
    }

    public final IOException u(IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.q) {
                    this.q = false;
                    if (!this.n && !this.p) {
                        z = true;
                    }
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? e(iOException) : iOException;
    }

    public final String v() {
        return this.b.i().o();
    }

    public final Socket w() {
        CJ cj = this.j;
        AbstractC4492zt.e(cj);
        if (AbstractC3724qX.h && !Thread.holdsLock(cj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + cj);
        }
        List listN = cj.n();
        Iterator it = listN.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (AbstractC4492zt.d(((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        listN.remove(i);
        this.j = null;
        if (listN.isEmpty()) {
            cj.C(System.nanoTime());
            if (this.d.c(cj)) {
                return cj.E();
            }
        }
        return null;
    }

    public final boolean x() {
        C0860Ql c0860Ql = this.i;
        AbstractC4492zt.e(c0860Ql);
        return c0860Ql.e();
    }

    public final void y(CJ cj) {
        this.v = cj;
    }

    public final void z() {
        if (this.k) {
            throw new IllegalStateException("Check failed.");
        }
        this.k = true;
        this.f.w();
    }
}
