package defpackage;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class UG extends TG {
    public static final Logger r;
    public static boolean s;

    public class a implements AbstractC0963Uk.a {
        public final /* synthetic */ UG a;

        /* JADX INFO: renamed from: UG$a$a, reason: collision with other inner class name */
        public class RunnableC0019a implements Runnable {
            public final /* synthetic */ Object[] a;

            public RunnableC0019a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("responseHeaders", this.a[0]);
            }
        }

        public a(UG ug) {
            this.a = ug;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C0626Jl.h(new RunnableC0019a(objArr));
        }
    }

    public class b implements AbstractC0963Uk.a {
        public final /* synthetic */ UG a;

        public b(UG ug) {
            this.a = ug;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            this.a.a("requestHeaders", objArr[0]);
        }
    }

    public class c implements AbstractC0963Uk.a {
        public final /* synthetic */ Runnable a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a.run();
            }
        }

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C0626Jl.h(new a());
        }
    }

    public class d implements AbstractC0963Uk.a {
        public final /* synthetic */ UG a;

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x000f  */
            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.a;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                    } else {
                        exc = null;
                    }
                } else {
                    exc = null;
                }
                d.this.a.n("xhr post error", exc);
            }
        }

        public d(UG ug) {
            this.a = ug;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C0626Jl.h(new a(objArr));
        }
    }

    public class e implements AbstractC0963Uk.a {
        public final /* synthetic */ UG a;

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = this.a;
                e.this.a.l((String) (objArr.length > 0 ? objArr[0] : null));
            }
        }

        public e(UG ug) {
            this.a = ug;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C0626Jl.h(new a(objArr));
        }
    }

    public class f implements AbstractC0963Uk.a {
        public final /* synthetic */ UG a;

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x000f  */
            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.a;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                    } else {
                        exc = null;
                    }
                } else {
                    exc = null;
                }
                f.this.a.n("xhr poll error", exc);
            }
        }

        public f(UG ug) {
            this.a = ug;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C0626Jl.h(new a(objArr));
        }
    }

    public static class g extends AbstractC0963Uk {
        public static final IB i = IB.f("text/plain;charset=UTF-8");
        public String b;
        public String c;
        public String d;
        public InterfaceC2121ea.a e;
        public Map f;
        public EL g;
        public InterfaceC2121ea h;

        public class a implements InterfaceC3318la {
            public final /* synthetic */ g a;

            public a(g gVar) {
                this.a = gVar;
            }

            @Override // defpackage.InterfaceC3318la
            public void a(InterfaceC2121ea interfaceC2121ea, EL el) {
                this.a.g = el;
                this.a.q(el.z().d());
                try {
                    if (el.A()) {
                        this.a.o();
                    } else {
                        this.a.n(new IOException(Integer.toString(el.r())));
                    }
                } finally {
                    el.close();
                }
            }

            @Override // defpackage.InterfaceC3318la
            public void b(InterfaceC2121ea interfaceC2121ea, IOException iOException) {
                this.a.n(iOException);
            }
        }

        public static class b {
            public String a;
            public String b;
            public String c;
            public InterfaceC2121ea.a d;
            public Map e;
        }

        public g(b bVar) {
            String str = bVar.b;
            this.b = str == null ? HttpMethods.GET : str;
            this.c = bVar.a;
            this.d = bVar.c;
            this.e = bVar.d;
            this.f = bVar.e;
        }

        private void m(String str) {
            a("data", str);
            r();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(Exception exc) {
            a("error", exc);
        }

        public void l() {
            if (UG.s) {
                UG.r.fine(String.format("xhr open %s: %s", this.b, this.c));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Map map = this.f;
            if (map != null) {
                treeMap.putAll(map);
            }
            if (HttpMethods.POST.equals(this.b)) {
                treeMap.put("Content-type", new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
            }
            treeMap.put(HttpHeaders.ACCEPT, new LinkedList(Collections.singletonList("*/*")));
            p(treeMap);
            if (UG.s) {
                UG.r.fine(String.format("sending xhr with url %s | data %s", this.c, this.d));
            }
            C3873sL.a aVar = new C3873sL.a();
            for (Map.Entry entry : treeMap.entrySet()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    aVar.a((String) entry.getKey(), (String) it.next());
                }
            }
            String str = this.d;
            InterfaceC2121ea interfaceC2121eaB = this.e.b(aVar.g(C0779Nr.l(this.c)).e(this.b, str != null ? AbstractC3954tL.c(i, str) : null).b());
            this.h = interfaceC2121eaB;
            interfaceC2121eaB.c(new a(this));
        }

        public final void o() {
            try {
                m(this.g.c().r());
            } catch (IOException e) {
                n(e);
            }
        }

        public final void p(Map map) {
            a("requestHeaders", map);
        }

        public final void q(Map map) {
            a("responseHeaders", map);
        }

        public final void r() {
            a("success", new Object[0]);
        }
    }

    static {
        Logger logger = Logger.getLogger(UG.class.getName());
        r = logger;
        s = logger.isLoggable(Level.FINE);
    }

    public UG(AbstractC4207wV.d dVar) {
        super(dVar);
    }

    @Override // defpackage.TG
    public void C() {
        r.fine("xhr poll");
        g gVarL = L();
        gVarL.e("data", new e(this));
        gVarL.e("error", new f(this));
        gVarL.l();
    }

    @Override // defpackage.TG
    public void D(String str, Runnable runnable) {
        g.b bVar = new g.b();
        bVar.b = HttpMethods.POST;
        bVar.c = str;
        bVar.e = this.o;
        g gVarM = M(bVar);
        gVarM.e("success", new c(runnable));
        gVarM.e("error", new d(this));
        gVarM.l();
    }

    public g L() {
        return M(null);
    }

    public g M(g.b bVar) {
        if (bVar == null) {
            bVar = new g.b();
        }
        bVar.a = G();
        bVar.d = this.n;
        bVar.e = this.o;
        g gVar = new g(bVar);
        gVar.e("requestHeaders", new b(this)).e("responseHeaders", new a(this));
        return gVar;
    }
}
