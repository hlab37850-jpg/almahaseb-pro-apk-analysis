package defpackage;

import androidx.core.app.NotificationCompat;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UQ extends AbstractC0963Uk {
    public static final Logger C = Logger.getLogger(UQ.class.getName());
    public static final AtomicInteger D = new AtomicInteger();
    public static boolean E = false;
    public static InterfaceC2447iY.a F;
    public static InterfaceC2121ea.a G;
    public static C4271xE H;
    public ScheduledExecutorService A;
    public final AbstractC0963Uk.a B;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public long j;
    public long k;
    public String l;
    public String m;
    public String n;
    public String o;
    public List p;
    public Map q;
    public List r;
    public Map s;
    public LinkedList t;
    public AbstractC4207wV u;
    public Future v;
    public InterfaceC2447iY.a w;
    public InterfaceC2121ea.a x;
    public final Map y;
    public v z;

    public class a implements AbstractC0963Uk.a {
        public final /* synthetic */ AbstractC0963Uk.a a;

        public a(AbstractC0963Uk.a aVar) {
            this.a = aVar;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.call("transport closed");
        }
    }

    public class b implements AbstractC0963Uk.a {
        public final /* synthetic */ AbstractC0963Uk.a a;

        public b(AbstractC0963Uk.a aVar) {
            this.a = aVar;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.call("socket closed");
        }
    }

    public class c implements AbstractC0963Uk.a {
        public final /* synthetic */ AbstractC4207wV[] a;
        public final /* synthetic */ AbstractC0963Uk.a b;

        public c(AbstractC4207wV[] abstractC4207wVArr, AbstractC0963Uk.a aVar) {
            this.a = abstractC4207wVArr;
            this.b = aVar;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            AbstractC4207wV abstractC4207wV = (AbstractC4207wV) objArr[0];
            AbstractC4207wV abstractC4207wV2 = this.a[0];
            if (abstractC4207wV2 == null || abstractC4207wV.c.equals(abstractC4207wV2.c)) {
                return;
            }
            if (UQ.C.isLoggable(Level.FINE)) {
                UQ.C.fine(String.format("'%s' works - aborting '%s'", abstractC4207wV.c, this.a[0].c));
            }
            this.b.call(new Object[0]);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ AbstractC4207wV[] a;
        public final /* synthetic */ AbstractC0963Uk.a b;
        public final /* synthetic */ AbstractC0963Uk.a c;
        public final /* synthetic */ AbstractC0963Uk.a d;
        public final /* synthetic */ UQ e;
        public final /* synthetic */ AbstractC0963Uk.a f;
        public final /* synthetic */ AbstractC0963Uk.a g;

        public d(AbstractC4207wV[] abstractC4207wVArr, AbstractC0963Uk.a aVar, AbstractC0963Uk.a aVar2, AbstractC0963Uk.a aVar3, UQ uq, AbstractC0963Uk.a aVar4, AbstractC0963Uk.a aVar5) {
            this.a = abstractC4207wVArr;
            this.b = aVar;
            this.c = aVar2;
            this.d = aVar3;
            this.e = uq;
            this.f = aVar4;
            this.g = aVar5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a[0].d("open", this.b);
            this.a[0].d("error", this.c);
            this.a[0].d("close", this.d);
            this.e.d("close", this.f);
            this.e.d("upgrading", this.g);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UQ.this.W("pong", null);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ UQ a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a.z == v.CLOSED) {
                    return;
                }
                f.this.a.J("ping timeout");
            }
        }

        public f(UQ uq) {
            this.a = uq;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0626Jl.h(new a());
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Runnable b;

        public g(String str, Runnable runnable) {
            this.a = str;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            UQ.this.X("message", this.a, this.b);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ Runnable b;

        public h(byte[] bArr, Runnable runnable) {
            this.a = bArr;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            UQ.this.Y("message", this.a, this.b);
        }
    }

    public class i implements AbstractC0963Uk.a {
        public final /* synthetic */ Runnable a;

        public i(Runnable runnable) {
            this.a = runnable;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.run();
        }
    }

    public class j implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ UQ a;

            public a(UQ uq) {
                this.a = uq;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.J("forced close");
                UQ.C.fine("socket closing - telling transport to close");
                this.a.u.h();
            }
        }

        public class b implements AbstractC0963Uk.a {
            public final /* synthetic */ UQ a;
            public final /* synthetic */ AbstractC0963Uk.a[] b;
            public final /* synthetic */ Runnable c;

            public b(UQ uq, AbstractC0963Uk.a[] aVarArr, Runnable runnable) {
                this.a = uq;
                this.b = aVarArr;
                this.c = runnable;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                this.a.d("upgrade", this.b[0]);
                this.a.d("upgradeError", this.b[0]);
                this.c.run();
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ UQ a;
            public final /* synthetic */ AbstractC0963Uk.a[] b;

            public c(UQ uq, AbstractC0963Uk.a[] aVarArr) {
                this.a = uq;
                this.b = aVarArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.f("upgrade", this.b[0]);
                this.a.f("upgradeError", this.b[0]);
            }
        }

        public class d implements AbstractC0963Uk.a {
            public final /* synthetic */ Runnable a;
            public final /* synthetic */ Runnable b;

            public d(Runnable runnable, Runnable runnable2) {
                this.a = runnable;
                this.b = runnable2;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                if (UQ.this.e) {
                    this.a.run();
                } else {
                    this.b.run();
                }
            }
        }

        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UQ.this.z == v.OPENING || UQ.this.z == v.OPEN) {
                UQ.this.z = v.CLOSING;
                UQ uq = UQ.this;
                a aVar = new a(uq);
                AbstractC0963Uk.a[] aVarArr = new AbstractC0963Uk.a[1];
                aVarArr[0] = new b(uq, aVarArr, aVar);
                c cVar = new c(uq, aVarArr);
                if (UQ.this.t.size() > 0) {
                    UQ.this.f("drain", new d(cVar, aVar));
                } else if (UQ.this.e) {
                    cVar.run();
                } else {
                    aVar.run();
                }
            }
        }
    }

    public class k implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ UQ a;

            public a(UQ uq) {
                this.a = uq;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.a("error", new C3584ol("No transports available"));
            }
        }

        public k() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0029  */
        /* JADX WARN: Code duplicated, block: B:13:0x0034  */
        /* JADX WARN: Code duplicated, block: B:9:0x001d  */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (UQ.this.f && UQ.E) {
                str = "websocket";
                if (!UQ.this.p.contains("websocket")) {
                    if (UQ.this.p.size() == 0) {
                        C0626Jl.j(new a(UQ.this));
                        return;
                    }
                    str = (String) UQ.this.p.get(0);
                }
            } else {
                if (UQ.this.p.size() == 0) {
                    C0626Jl.j(new a(UQ.this));
                    return;
                }
                str = (String) UQ.this.p.get(0);
            }
            UQ.this.z = v.OPENING;
            AbstractC4207wV abstractC4207wVE = UQ.this.E(str);
            UQ.this.Z(abstractC4207wVE);
            abstractC4207wVE.q();
        }
    }

    public class l implements ThreadFactory {
        public l() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "engine.io-client.heartbeat-" + UQ.D.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        }
    }

    public class m implements AbstractC0963Uk.a {
        public final /* synthetic */ UQ a;

        public m(UQ uq) {
            this.a = uq;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.J("transport close");
        }
    }

    public class n implements AbstractC0963Uk.a {
        public final /* synthetic */ UQ a;

        public n(UQ uq) {
            this.a = uq;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.M(objArr.length > 0 ? (Exception) objArr[0] : null);
        }
    }

    public class o implements AbstractC0963Uk.a {
        public final /* synthetic */ UQ a;

        public o(UQ uq) {
            this.a = uq;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.Q(objArr.length > 0 ? (WF) objArr[0] : null);
        }
    }

    public class p implements AbstractC0963Uk.a {
        public final /* synthetic */ UQ a;

        public p(UQ uq) {
            this.a = uq;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.L();
        }
    }

    public class q implements AbstractC0963Uk.a {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbstractC4207wV[] c;
        public final /* synthetic */ UQ d;
        public final /* synthetic */ Runnable[] e;

        public class a implements AbstractC0963Uk.a {

            /* JADX INFO: renamed from: UQ$q$a$a, reason: collision with other inner class name */
            public class RunnableC0020a implements Runnable {
                public RunnableC0020a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    q qVar = q.this;
                    if (qVar.a[0] || v.CLOSED == qVar.d.z) {
                        return;
                    }
                    UQ.C.fine("changing transport and sending upgrade packet");
                    q.this.e[0].run();
                    q qVar2 = q.this;
                    qVar2.d.Z(qVar2.c[0]);
                    q.this.c[0].r(new WF[]{new WF("upgrade")});
                    q qVar3 = q.this;
                    qVar3.d.a("upgrade", qVar3.c[0]);
                    q qVar4 = q.this;
                    qVar4.c[0] = null;
                    qVar4.d.e = false;
                    q.this.d.G();
                }
            }

            public a() {
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                if (q.this.a[0]) {
                    return;
                }
                WF wf = (WF) objArr[0];
                if (!"pong".equals(wf.a) || !"probe".equals(wf.b)) {
                    if (UQ.C.isLoggable(Level.FINE)) {
                        UQ.C.fine(String.format("probe transport '%s' failed", q.this.b));
                    }
                    C3584ol c3584ol = new C3584ol("probe error");
                    q qVar = q.this;
                    c3584ol.a = qVar.c[0].c;
                    qVar.d.a("upgradeError", c3584ol);
                    return;
                }
                Logger logger = UQ.C;
                Level level = Level.FINE;
                if (logger.isLoggable(level)) {
                    UQ.C.fine(String.format("probe transport '%s' pong", q.this.b));
                }
                q.this.d.e = true;
                q qVar2 = q.this;
                qVar2.d.a("upgrading", qVar2.c[0]);
                AbstractC4207wV abstractC4207wV = q.this.c[0];
                if (abstractC4207wV == null) {
                    return;
                }
                boolean unused = UQ.E = "websocket".equals(abstractC4207wV.c);
                if (UQ.C.isLoggable(level)) {
                    UQ.C.fine(String.format("pausing current transport '%s'", q.this.d.u.c));
                }
                ((TG) q.this.d.u).E(new RunnableC0020a());
            }
        }

        public q(boolean[] zArr, String str, AbstractC4207wV[] abstractC4207wVArr, UQ uq, Runnable[] runnableArr) {
            this.a = zArr;
            this.b = str;
            this.c = abstractC4207wVArr;
            this.d = uq;
            this.e = runnableArr;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            if (this.a[0]) {
                return;
            }
            if (UQ.C.isLoggable(Level.FINE)) {
                UQ.C.fine(String.format("probe transport '%s' opened", this.b));
            }
            this.c[0].r(new WF[]{new WF("ping", "probe")});
            this.c[0].f("packet", new a());
        }
    }

    public class r implements AbstractC0963Uk.a {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ Runnable[] b;
        public final /* synthetic */ AbstractC4207wV[] c;

        public r(boolean[] zArr, Runnable[] runnableArr, AbstractC4207wV[] abstractC4207wVArr) {
            this.a = zArr;
            this.b = runnableArr;
            this.c = abstractC4207wVArr;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b[0].run();
            this.c[0].h();
            this.c[0] = null;
        }
    }

    public class s implements AbstractC0963Uk.a {
        public final /* synthetic */ AbstractC4207wV[] a;
        public final /* synthetic */ AbstractC0963Uk.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ UQ d;

        public s(AbstractC4207wV[] abstractC4207wVArr, AbstractC0963Uk.a aVar, String str, UQ uq) {
            this.a = abstractC4207wVArr;
            this.b = aVar;
            this.c = str;
            this.d = uq;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C3584ol c3584ol;
            Object obj = objArr[0];
            if (obj instanceof Exception) {
                c3584ol = new C3584ol("probe error", (Exception) obj);
            } else if (obj instanceof String) {
                c3584ol = new C3584ol("probe error: " + ((String) obj));
            } else {
                c3584ol = new C3584ol("probe error");
            }
            c3584ol.a = this.a[0].c;
            this.b.call(new Object[0]);
            if (UQ.C.isLoggable(Level.FINE)) {
                UQ.C.fine(String.format("probe transport \"%s\" failed because of error: %s", this.c, obj));
            }
            this.d.a("upgradeError", c3584ol);
        }
    }

    public class t implements AbstractC0963Uk.a {
        public t() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            UQ.this.O();
        }
    }

    public static class u extends AbstractC4207wV.d {
        public String[] m;
        public boolean n = true;
        public boolean o;
        public String p;
        public String q;
        public Map r;

        public static u b(URI uri, u uVar) {
            if (uVar == null) {
                uVar = new u();
            }
            uVar.p = uri.getHost();
            uVar.d = "https".equals(uri.getScheme()) || "wss".equals(uri.getScheme());
            uVar.f = uri.getPort();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                uVar.q = rawQuery;
            }
            return uVar;
        }
    }

    public enum v {
        OPENING,
        OPEN,
        CLOSING,
        CLOSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public UQ(URI uri, u uVar) {
        this(uri != null ? u.b(uri, uVar) : uVar);
    }

    public static C4271xE H() {
        if (H == null) {
            H = new C4271xE.a().H(1L, TimeUnit.MINUTES).a();
        }
        return H;
    }

    private void P() {
        Logger logger = C;
        logger.fine("socket open");
        v vVar = v.OPEN;
        this.z = vVar;
        E = "websocket".equals(this.u.c);
        a("open", new Object[0]);
        G();
        if (this.z == vVar && this.c && (this.u instanceof TG)) {
            logger.fine("starting upgrade probes");
            Iterator it = this.r.iterator();
            while (it.hasNext()) {
                S((String) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(WF wf) {
        v vVar = this.z;
        if (vVar != v.OPENING && vVar != v.OPEN && vVar != v.CLOSING) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("packet received with socket readyState '%s'", this.z));
                return;
            }
            return;
        }
        Logger logger2 = C;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("socket received: type '%s', data '%s'", wf.a, wf.b));
        }
        a("packet", wf);
        a("heartbeat", new Object[0]);
        if ("open".equals(wf.a)) {
            try {
                N(new C2393hr((String) wf.b));
                return;
            } catch (JSONException e2) {
                a("error", new C3584ol(e2));
                return;
            }
        }
        if ("ping".equals(wf.a)) {
            a("ping", new Object[0]);
            C0626Jl.h(new e());
        } else if ("error".equals(wf.a)) {
            C3584ol c3584ol = new C3584ol("server error");
            c3584ol.b = wf.b;
            M(c3584ol);
        } else if ("message".equals(wf.a)) {
            a("data", wf.b);
            a("message", wf.b);
        }
    }

    public UQ C() {
        C0626Jl.h(new j());
        return this;
    }

    public final ScheduledExecutorService D() {
        return Executors.newSingleThreadScheduledExecutor(new l());
    }

    public final AbstractC4207wV E(String str) {
        AbstractC4207wV ug;
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("creating transport '%s'", str));
        }
        HashMap map = new HashMap(this.s);
        map.put("EIO", String.valueOf(4));
        map.put(NotificationCompat.CATEGORY_TRANSPORT, str);
        String str2 = this.l;
        if (str2 != null) {
            map.put("sid", str2);
        }
        AbstractC4207wV.d dVar = (AbstractC4207wV.d) this.q.get(str);
        AbstractC4207wV.d dVar2 = new AbstractC4207wV.d();
        dVar2.h = map;
        dVar2.i = this;
        dVar2.a = dVar != null ? dVar.a : this.m;
        dVar2.f = dVar != null ? dVar.f : this.g;
        dVar2.d = dVar != null ? dVar.d : this.b;
        dVar2.b = dVar != null ? dVar.b : this.n;
        dVar2.e = dVar != null ? dVar.e : this.d;
        dVar2.c = dVar != null ? dVar.c : this.o;
        dVar2.g = dVar != null ? dVar.g : this.h;
        dVar2.k = dVar != null ? dVar.k : this.x;
        dVar2.j = dVar != null ? dVar.j : this.w;
        dVar2.l = this.y;
        if ("websocket".equals(str)) {
            ug = new C2365hY(dVar2);
        } else {
            if (!"polling".equals(str)) {
                throw new RuntimeException();
            }
            ug = new UG(dVar2);
        }
        a(NotificationCompat.CATEGORY_TRANSPORT, ug);
        return ug;
    }

    public List F(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.p.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final void G() {
        if (this.z == v.CLOSED || !this.u.b || this.e || this.t.size() == 0) {
            return;
        }
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("flushing %d packets in socket", Integer.valueOf(this.t.size())));
        }
        this.i = this.t.size();
        AbstractC4207wV abstractC4207wV = this.u;
        LinkedList linkedList = this.t;
        abstractC4207wV.r((WF[]) linkedList.toArray(new WF[linkedList.size()]));
        a("flush", new Object[0]);
    }

    public final ScheduledExecutorService I() {
        ScheduledExecutorService scheduledExecutorService = this.A;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.A = D();
        }
        return this.A;
    }

    public final void J(String str) {
        K(str, null);
    }

    public final void K(String str, Exception exc) {
        v vVar = v.OPENING;
        v vVar2 = this.z;
        if (vVar == vVar2 || v.OPEN == vVar2 || v.CLOSING == vVar2) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("socket close with reason: %s", str));
            }
            Future future = this.v;
            if (future != null) {
                future.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.A;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.u.c("close");
            this.u.h();
            this.u.b();
            this.z = v.CLOSED;
            this.l = null;
            a("close", str, exc);
            this.t.clear();
            this.i = 0;
        }
    }

    public final void L() {
        for (int i2 = 0; i2 < this.i; i2++) {
            this.t.poll();
        }
        this.i = 0;
        if (this.t.size() == 0) {
            a("drain", new Object[0]);
        } else {
            G();
        }
    }

    public final void M(Exception exc) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("socket error %s", exc));
        }
        E = false;
        a("error", exc);
        K("transport error", exc);
    }

    public final void N(C2393hr c2393hr) {
        a("handshake", c2393hr);
        String str = c2393hr.a;
        this.l = str;
        this.u.d.put("sid", str);
        this.r = F(Arrays.asList(c2393hr.b));
        this.j = c2393hr.c;
        this.k = c2393hr.d;
        P();
        if (v.CLOSED == this.z) {
            return;
        }
        O();
        d("heartbeat", this.B);
        e("heartbeat", this.B);
    }

    public final void O() {
        Future future = this.v;
        if (future != null) {
            future.cancel(false);
        }
        this.v = I().schedule(new f(this), this.j + this.k, TimeUnit.MILLISECONDS);
    }

    public UQ R() {
        C0626Jl.h(new k());
        return this;
    }

    public final void S(String str) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("probing transport '%s'", str));
        }
        AbstractC4207wV[] abstractC4207wVArr = {E(str)};
        boolean[] zArr = {false};
        E = false;
        Runnable[] runnableArr = {new d(abstractC4207wVArr, qVar, sVar, aVar, this, bVar, cVar)};
        q qVar = new q(zArr, str, abstractC4207wVArr, this, runnableArr);
        r rVar = new r(zArr, runnableArr, abstractC4207wVArr);
        s sVar = new s(abstractC4207wVArr, rVar, str, this);
        a aVar = new a(sVar);
        b bVar = new b(sVar);
        c cVar = new c(abstractC4207wVArr, rVar);
        abstractC4207wVArr[0].f("open", qVar);
        abstractC4207wVArr[0].f("error", sVar);
        abstractC4207wVArr[0].f("close", aVar);
        f("close", bVar);
        f("upgrading", cVar);
        abstractC4207wVArr[0].q();
    }

    public void T(String str, Runnable runnable) {
        C0626Jl.h(new g(str, runnable));
    }

    public void U(byte[] bArr, Runnable runnable) {
        C0626Jl.h(new h(bArr, runnable));
    }

    public final void V(WF wf, Runnable runnable) {
        v vVar = v.CLOSING;
        v vVar2 = this.z;
        if (vVar == vVar2 || v.CLOSED == vVar2) {
            return;
        }
        a("packetCreate", wf);
        this.t.offer(wf);
        if (runnable != null) {
            f("flush", new i(runnable));
        }
        G();
    }

    public final void W(String str, Runnable runnable) {
        V(new WF(str), runnable);
    }

    public final void X(String str, String str2, Runnable runnable) {
        V(new WF(str, str2), runnable);
    }

    public final void Y(String str, byte[] bArr, Runnable runnable) {
        V(new WF(str, bArr), runnable);
    }

    public final void Z(AbstractC4207wV abstractC4207wV) {
        Logger logger = C;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("setting transport %s", abstractC4207wV.c));
        }
        if (this.u != null) {
            if (logger.isLoggable(level)) {
                logger.fine(String.format("clearing existing transport %s", this.u.c));
            }
            this.u.b();
        }
        this.u = abstractC4207wV;
        abstractC4207wV.e("drain", new p(this)).e("packet", new o(this)).e("error", new n(this)).e("close", new m(this));
    }

    public void a0(String str) {
        b0(str, null);
    }

    public void b0(String str, Runnable runnable) {
        T(str, runnable);
    }

    public void c0(byte[] bArr) {
        d0(bArr, null);
    }

    public void d0(byte[] bArr, Runnable runnable) {
        U(bArr, runnable);
    }

    public UQ(u uVar) {
        this.t = new LinkedList();
        this.B = new t();
        String strSubstring = uVar.p;
        if (strSubstring != null) {
            if (strSubstring.split(":").length > 2) {
                int iIndexOf = strSubstring.indexOf(91);
                strSubstring = iIndexOf != -1 ? strSubstring.substring(iIndexOf + 1) : strSubstring;
                int iLastIndexOf = strSubstring.lastIndexOf(93);
                if (iLastIndexOf != -1) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
            }
            uVar.a = strSubstring;
        }
        boolean z = uVar.d;
        this.b = z;
        if (uVar.f == -1) {
            uVar.f = z ? 443 : 80;
        }
        String str = uVar.a;
        this.m = str == null ? "localhost" : str;
        this.g = uVar.f;
        String str2 = uVar.q;
        this.s = str2 != null ? AbstractC3298lG.a(str2) : new HashMap();
        this.c = uVar.n;
        StringBuilder sb = new StringBuilder();
        String str3 = uVar.b;
        sb.append((str3 == null ? "/engine.io" : str3).replaceAll("/$", ""));
        sb.append("/");
        this.n = sb.toString();
        String str4 = uVar.c;
        this.o = str4 == null ? "t" : str4;
        this.d = uVar.e;
        String[] strArr = uVar.m;
        this.p = new ArrayList(Arrays.asList(strArr == null ? new String[]{"polling", "websocket"} : strArr));
        Map map = uVar.r;
        this.q = map == null ? new HashMap() : map;
        int i2 = uVar.g;
        this.h = i2 == 0 ? 843 : i2;
        this.f = uVar.o;
        InterfaceC2121ea.a aVar = uVar.k;
        aVar = aVar == null ? G : aVar;
        this.x = aVar;
        InterfaceC2447iY.a aVar2 = uVar.j;
        this.w = aVar2 == null ? F : aVar2;
        if (aVar == null) {
            this.x = H();
        }
        if (this.w == null) {
            this.w = H();
        }
        this.y = uVar.l;
    }
}
