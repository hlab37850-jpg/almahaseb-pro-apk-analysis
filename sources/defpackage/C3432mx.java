package defpackage;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: mx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3432mx extends AbstractC0963Uk {
    public static final Logger u = Logger.getLogger(C3432mx.class.getName());
    public static InterfaceC2447iY.a v;
    public static InterfaceC2121ea.a w;
    public l b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public long h;
    public long i;
    public double j;
    public K6 k;
    public long l;
    public URI m;
    public List n;
    public Queue o;
    public k p;
    public UQ q;
    public InterfaceC3544oG.b r;
    public InterfaceC3544oG.a s;
    public ConcurrentHashMap t;

    /* JADX INFO: renamed from: mx$a */
    public class a implements Runnable {
        public final /* synthetic */ j a;

        /* JADX INFO: renamed from: mx$a$a, reason: collision with other inner class name */
        public class C0325a implements AbstractC0963Uk.a {
            public final /* synthetic */ C3432mx a;

            public C0325a(C3432mx c3432mx) {
                this.a = c3432mx;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                this.a.a(NotificationCompat.CATEGORY_TRANSPORT, objArr);
            }
        }

        /* JADX INFO: renamed from: mx$a$b */
        public class b implements AbstractC0963Uk.a {
            public final /* synthetic */ C3432mx a;

            public b(C3432mx c3432mx) {
                this.a = c3432mx;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                this.a.J();
                j jVar = a.this.a;
                if (jVar != null) {
                    jVar.a(null);
                }
            }
        }

        /* JADX INFO: renamed from: mx$a$c */
        public class c implements AbstractC0963Uk.a {
            public final /* synthetic */ C3432mx a;

            public c(C3432mx c3432mx) {
                this.a = c3432mx;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                Object obj = objArr.length > 0 ? objArr[0] : null;
                C3432mx.u.fine("connect_error");
                this.a.B();
                C3432mx c3432mx = this.a;
                c3432mx.b = l.CLOSED;
                c3432mx.a("error", obj);
                if (a.this.a != null) {
                    a.this.a.a(new YQ("Connection error", obj instanceof Exception ? (Exception) obj : null));
                } else {
                    this.a.F();
                }
            }
        }

        /* JADX INFO: renamed from: mx$a$d */
        public class d implements Runnable {
            public final /* synthetic */ long a;
            public final /* synthetic */ CE.b b;
            public final /* synthetic */ UQ c;

            public d(long j, CE.b bVar, UQ uq) {
                this.a = j;
                this.b = bVar;
                this.c = uq;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3432mx.u.fine(String.format("connect attempt timed out after %d", Long.valueOf(this.a)));
                this.b.destroy();
                this.c.C();
                this.c.a("error", new YQ("timeout"));
            }
        }

        /* JADX INFO: renamed from: mx$a$e */
        public class e extends TimerTask {
            public final /* synthetic */ Runnable a;

            public e(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                C0626Jl.h(this.a);
            }
        }

        /* JADX INFO: renamed from: mx$a$f */
        public class f implements CE.b {
            public final /* synthetic */ Timer a;

            public f(Timer timer) {
                this.a = timer;
            }

            @Override // CE.b
            public void destroy() {
                this.a.cancel();
            }
        }

        public a(j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar;
            Logger logger = C3432mx.u;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                C3432mx.u.fine(String.format("readyState %s", C3432mx.this.b));
            }
            l lVar2 = C3432mx.this.b;
            if (lVar2 == l.OPEN || lVar2 == (lVar = l.OPENING)) {
                return;
            }
            if (C3432mx.u.isLoggable(level)) {
                C3432mx.u.fine(String.format("opening %s", C3432mx.this.m));
            }
            C3432mx.this.q = new i(C3432mx.this.m, C3432mx.this.p);
            C3432mx c3432mx = C3432mx.this;
            UQ uq = c3432mx.q;
            c3432mx.b = lVar;
            c3432mx.d = false;
            uq.e(NotificationCompat.CATEGORY_TRANSPORT, new C0325a(c3432mx));
            CE.b bVarA = CE.a(uq, "open", new b(c3432mx));
            CE.b bVarA2 = CE.a(uq, "error", new c(c3432mx));
            long j = C3432mx.this.l;
            d dVar = new d(j, bVarA, uq);
            if (j == 0) {
                C0626Jl.h(dVar);
                return;
            }
            if (C3432mx.this.l > 0) {
                C3432mx.u.fine(String.format("connection attempt will timeout after %d", Long.valueOf(j)));
                Timer timer = new Timer();
                timer.schedule(new e(dVar), j);
                C3432mx.this.o.add(new f(timer));
            }
            C3432mx.this.o.add(bVarA);
            C3432mx.this.o.add(bVarA2);
            C3432mx.this.q.R();
        }
    }

    /* JADX INFO: renamed from: mx$b */
    public class b implements AbstractC0963Uk.a {
        public b() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Object obj = objArr[0];
            try {
                if (obj instanceof String) {
                    C3432mx.this.s.add((String) obj);
                } else if (obj instanceof byte[]) {
                    C3432mx.this.s.add((byte[]) obj);
                }
            } catch (C0393Ci e) {
                C3432mx.u.fine("error while decoding the packet: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: mx$c */
    public class c implements AbstractC0963Uk.a {
        public c() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C3432mx.this.I((Exception) objArr[0]);
        }
    }

    /* JADX INFO: renamed from: mx$d */
    public class d implements AbstractC0963Uk.a {
        public d() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C3432mx.this.G((String) objArr[0]);
        }
    }

    /* JADX INFO: renamed from: mx$e */
    public class e implements InterfaceC3544oG.a.InterfaceC0327a {
        public e() {
        }

        @Override // defpackage.InterfaceC3544oG.a.InterfaceC0327a
        public void a(VF vf) {
            C3432mx.this.H(vf);
        }
    }

    /* JADX INFO: renamed from: mx$f */
    public class f implements InterfaceC3544oG.b.a {
        public final /* synthetic */ C3432mx a;

        public f(C3432mx c3432mx) {
            this.a = c3432mx;
        }

        @Override // defpackage.InterfaceC3544oG.b.a
        public void call(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    this.a.q.a0((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.q.c0((byte[]) obj);
                }
            }
            this.a.f = false;
            this.a.O();
        }
    }

    /* JADX INFO: renamed from: mx$g */
    public class g extends TimerTask {
        public final /* synthetic */ C3432mx a;

        /* JADX INFO: renamed from: mx$g$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: mx$g$a$a, reason: collision with other inner class name */
            public class C0326a implements j {
                public C0326a() {
                }

                @Override // defpackage.C3432mx.j
                public void a(Exception exc) {
                    if (exc == null) {
                        C3432mx.u.fine("reconnect success");
                        g.this.a.K();
                    } else {
                        C3432mx.u.fine("reconnect attempt error");
                        g.this.a.e = false;
                        g.this.a.R();
                        g.this.a.a("reconnect_error", exc);
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.a.d) {
                    return;
                }
                C3432mx.u.fine("attempting reconnect");
                g.this.a.a("reconnect_attempt", Integer.valueOf(g.this.a.k.b()));
                if (g.this.a.d) {
                    return;
                }
                g.this.a.M(new C0326a());
            }
        }

        public g(C3432mx c3432mx) {
            this.a = c3432mx;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C0626Jl.h(new a());
        }
    }

    /* JADX INFO: renamed from: mx$h */
    public class h implements CE.b {
        public final /* synthetic */ Timer a;

        public h(Timer timer) {
            this.a = timer;
        }

        @Override // CE.b
        public void destroy() {
            this.a.cancel();
        }
    }

    /* JADX INFO: renamed from: mx$i */
    public static class i extends UQ {
        public i(URI uri, UQ.u uVar) {
            super(uri, uVar);
        }
    }

    /* JADX INFO: renamed from: mx$j */
    public interface j {
        void a(Exception exc);
    }

    /* JADX INFO: renamed from: mx$k */
    public static class k extends UQ.u {
        public int t;
        public long u;
        public long v;
        public double w;
        public InterfaceC3544oG.b x;
        public InterfaceC3544oG.a y;
        public Map z;
        public boolean s = true;
        public long A = 20000;
    }

    /* JADX INFO: renamed from: mx$l */
    public enum l {
        CLOSED,
        OPENING,
        OPEN
    }

    public C3432mx(URI uri, k kVar) {
        kVar = kVar == null ? new k() : kVar;
        if (kVar.b == null) {
            kVar.b = "/socket.io";
        }
        if (kVar.j == null) {
            kVar.j = v;
        }
        if (kVar.k == null) {
            kVar.k = w;
        }
        this.p = kVar;
        this.t = new ConcurrentHashMap();
        this.o = new LinkedList();
        S(kVar.s);
        int i2 = kVar.t;
        T(i2 == 0 ? Integer.MAX_VALUE : i2);
        long j2 = kVar.u;
        V(j2 == 0 ? 1000L : j2);
        long j3 = kVar.v;
        X(j3 == 0 ? CoroutineLiveDataKt.DEFAULT_TIMEOUT : j3);
        double d2 = kVar.w;
        Q(d2 == 0.0d ? 0.5d : d2);
        this.k = new K6().f(U()).e(W()).d(P());
        Z(kVar.A);
        this.b = l.CLOSED;
        this.m = uri;
        this.f = false;
        this.n = new ArrayList();
        InterfaceC3544oG.b bVar = kVar.x;
        this.r = bVar == null ? new AbstractC0944Tr.c() : bVar;
        InterfaceC3544oG.a aVar = kVar.y;
        this.s = aVar == null ? new AbstractC0944Tr.b() : aVar;
    }

    public final void B() {
        u.fine("cleanup");
        while (true) {
            CE.b bVar = (CE.b) this.o.poll();
            if (bVar == null) {
                this.s.a(null);
                this.n.clear();
                this.f = false;
                this.s.destroy();
                return;
            }
            bVar.destroy();
        }
    }

    public void C() {
        u.fine("disconnect");
        this.d = true;
        this.e = false;
        if (this.b != l.OPEN) {
            B();
        }
        this.k.c();
        this.b = l.CLOSED;
        UQ uq = this.q;
        if (uq != null) {
            uq.C();
        }
    }

    public void D() {
        synchronized (this.t) {
            try {
                Iterator it = this.t.values().iterator();
                while (it.hasNext()) {
                    if (((VQ) it.next()).F()) {
                        u.fine("socket is still active, skipping close");
                        return;
                    }
                }
                C();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean E() {
        return this.e;
    }

    public final void F() {
        if (!this.e && this.c && this.k.b() == 0) {
            R();
        }
    }

    public final void G(String str) {
        u.fine("onclose");
        B();
        this.k.c();
        this.b = l.CLOSED;
        a("close", str);
        if (!this.c || this.d) {
            return;
        }
        R();
    }

    public final void H(VF vf) {
        a("packet", vf);
    }

    public final void I(Exception exc) {
        u.log(Level.FINE, "error", (Throwable) exc);
        a("error", exc);
    }

    public final void J() {
        u.fine("open");
        B();
        this.b = l.OPEN;
        a("open", new Object[0]);
        UQ uq = this.q;
        this.o.add(CE.a(uq, "data", new b()));
        this.o.add(CE.a(uq, "error", new c()));
        this.o.add(CE.a(uq, "close", new d()));
        this.s.a(new e());
    }

    public final void K() {
        int iB = this.k.b();
        this.e = false;
        this.k.c();
        a("reconnect", Integer.valueOf(iB));
    }

    public C3432mx L() {
        return M(null);
    }

    public C3432mx M(j jVar) {
        C0626Jl.h(new a(jVar));
        return this;
    }

    public void N(VF vf) {
        Logger logger = u;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("writing packet %s", vf));
        }
        if (this.f) {
            this.n.add(vf);
        } else {
            this.f = true;
            this.r.a(vf, new f(this));
        }
    }

    public final void O() {
        if (this.n.isEmpty() || this.f) {
            return;
        }
        N((VF) this.n.remove(0));
    }

    public final double P() {
        return this.j;
    }

    public C3432mx Q(double d2) {
        this.j = d2;
        K6 k6 = this.k;
        if (k6 != null) {
            k6.d(d2);
        }
        return this;
    }

    public final void R() {
        if (this.e || this.d) {
            return;
        }
        if (this.k.b() >= this.g) {
            u.fine("reconnect failed");
            this.k.c();
            a("reconnect_failed", new Object[0]);
            this.e = false;
            return;
        }
        long jA = this.k.a();
        u.fine(String.format("will wait %dms before reconnect attempt", Long.valueOf(jA)));
        this.e = true;
        Timer timer = new Timer();
        timer.schedule(new g(this), jA);
        this.o.add(new h(timer));
    }

    public C3432mx S(boolean z) {
        this.c = z;
        return this;
    }

    public C3432mx T(int i2) {
        this.g = i2;
        return this;
    }

    public final long U() {
        return this.h;
    }

    public C3432mx V(long j2) {
        this.h = j2;
        K6 k6 = this.k;
        if (k6 != null) {
            k6.f(j2);
        }
        return this;
    }

    public final long W() {
        return this.i;
    }

    public C3432mx X(long j2) {
        this.i = j2;
        K6 k6 = this.k;
        if (k6 != null) {
            k6.e(j2);
        }
        return this;
    }

    public VQ Y(String str, k kVar) {
        VQ vq;
        synchronized (this.t) {
            try {
                vq = (VQ) this.t.get(str);
                if (vq == null) {
                    vq = new VQ(this, str, kVar);
                    this.t.put(str, vq);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return vq;
    }

    public C3432mx Z(long j2) {
        this.l = j2;
        return this;
    }
}
