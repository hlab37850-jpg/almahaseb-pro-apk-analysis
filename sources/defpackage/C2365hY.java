package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/* JADX INFO: renamed from: hY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2365hY extends AbstractC4207wV {
    public static final Logger q = Logger.getLogger(UG.class.getName());
    public InterfaceC2447iY p;

    /* JADX INFO: renamed from: hY$a */
    public class a extends AbstractC3234kY {
        public final /* synthetic */ C2365hY a;

        /* JADX INFO: renamed from: hY$a$a, reason: collision with other inner class name */
        public class RunnableC0286a implements Runnable {
            public final /* synthetic */ Map a;

            public RunnableC0286a(Map map) {
                this.a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("responseHeaders", this.a);
                a.this.a.o();
            }
        }

        /* JADX INFO: renamed from: hY$a$b */
        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.l(this.a);
            }
        }

        /* JADX INFO: renamed from: hY$a$c */
        public class c implements Runnable {
            public final /* synthetic */ W8 a;

            public c(W8 w8) {
                this.a = w8;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.m(this.a.x());
            }
        }

        /* JADX INFO: renamed from: hY$a$d */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.k();
            }
        }

        /* JADX INFO: renamed from: hY$a$e */
        public class e implements Runnable {
            public final /* synthetic */ Throwable a;

            public e(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.n("websocket error", (Exception) this.a);
            }
        }

        public a(C2365hY c2365hY) {
            this.a = c2365hY;
        }

        @Override // defpackage.AbstractC3234kY
        public void a(InterfaceC2447iY interfaceC2447iY, int i, String str) {
            C0626Jl.h(new d());
        }

        @Override // defpackage.AbstractC3234kY
        public void c(InterfaceC2447iY interfaceC2447iY, Throwable th, EL el) {
            if (th instanceof Exception) {
                C0626Jl.h(new e(th));
            }
        }

        @Override // defpackage.AbstractC3234kY
        public void d(InterfaceC2447iY interfaceC2447iY, W8 w8) {
            if (w8 == null) {
                return;
            }
            C0626Jl.h(new c(w8));
        }

        @Override // defpackage.AbstractC3234kY
        public void e(InterfaceC2447iY interfaceC2447iY, String str) {
            if (str == null) {
                return;
            }
            C0626Jl.h(new b(str));
        }

        @Override // defpackage.AbstractC3234kY
        public void f(InterfaceC2447iY interfaceC2447iY, EL el) {
            C0626Jl.h(new RunnableC0286a(el.z().d()));
        }
    }

    /* JADX INFO: renamed from: hY$b */
    public class b implements Runnable {
        public final /* synthetic */ C2365hY a;

        /* JADX INFO: renamed from: hY$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2365hY c2365hY = b.this.a;
                c2365hY.b = true;
                c2365hY.a("drain", new Object[0]);
            }
        }

        public b(C2365hY c2365hY) {
            this.a = c2365hY;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0626Jl.j(new a());
        }
    }

    /* JADX INFO: renamed from: hY$c */
    public class c implements AbstractC3462nG.d {
        public final /* synthetic */ C2365hY a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ Runnable c;

        public c(C2365hY c2365hY, int[] iArr, Runnable runnable) {
            this.a = c2365hY;
            this.b = iArr;
            this.c = runnable;
        }

        @Override // defpackage.AbstractC3462nG.d
        public void a(Object obj) {
            try {
                if (obj instanceof String) {
                    this.a.p.a((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.p.f(W8.n((byte[]) obj));
                }
            } catch (IllegalStateException unused) {
                C2365hY.q.fine("websocket closed before we could write");
            }
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.c.run();
            }
        }
    }

    public C2365hY(AbstractC4207wV.d dVar) {
        super(dVar);
        this.c = "websocket";
    }

    public String A() {
        String str;
        String str2;
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str3 = this.e ? "wss" : "ws";
        if (this.g <= 0 || ((!"wss".equals(str3) || this.g == 443) && (!"ws".equals(str3) || this.g == 80))) {
            str = "";
        } else {
            str = ":" + this.g;
        }
        if (this.f) {
            map.put(this.j, XZ.b());
        }
        String strB = AbstractC3298lG.b(map);
        if (strB.length() > 0) {
            strB = "?" + strB;
        }
        boolean zContains = this.i.contains(":");
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append("://");
        if (zContains) {
            str2 = "[" + this.i + "]";
        } else {
            str2 = this.i;
        }
        sb.append(str2);
        sb.append(str);
        sb.append(this.h);
        sb.append(strB);
        return sb.toString();
    }

    @Override // defpackage.AbstractC4207wV
    public void i() {
        InterfaceC2447iY interfaceC2447iY = this.p;
        if (interfaceC2447iY != null) {
            interfaceC2447iY.d(1000, "");
            this.p = null;
        }
    }

    @Override // defpackage.AbstractC4207wV
    public void j() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Map map = this.o;
        if (map != null) {
            treeMap.putAll(map);
        }
        a("requestHeaders", treeMap);
        C3873sL.a aVarH = new C3873sL.a().h(A());
        for (Map.Entry entry : treeMap.entrySet()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                aVarH.a((String) entry.getKey(), (String) it.next());
            }
        }
        this.p = this.m.a(aVarH.b(), new a(this));
    }

    @Override // defpackage.AbstractC4207wV
    public void s(WF[] wfArr) {
        this.b = false;
        b bVar = new b(this);
        int[] iArr = {wfArr.length};
        for (WF wf : wfArr) {
            AbstractC4207wV.e eVar = this.l;
            if (eVar != AbstractC4207wV.e.OPENING && eVar != AbstractC4207wV.e.OPEN) {
                return;
            }
            AbstractC3462nG.e(wf, new c(this, iArr, bVar));
        }
    }
}
