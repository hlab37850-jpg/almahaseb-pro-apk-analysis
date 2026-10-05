package defpackage;

import java.util.Map;

/* JADX INFO: renamed from: wV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4207wV extends AbstractC0963Uk {
    public boolean b;
    public String c;
    public Map d;
    public boolean e;
    public boolean f;
    public int g;
    public String h;
    public String i;
    public String j;
    public UQ k;
    public e l;
    public InterfaceC2447iY.a m;
    public InterfaceC2121ea.a n;
    public Map o;

    /* JADX INFO: renamed from: wV$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4207wV abstractC4207wV = AbstractC4207wV.this;
            e eVar = abstractC4207wV.l;
            if (eVar == e.CLOSED || eVar == null) {
                abstractC4207wV.l = e.OPENING;
                abstractC4207wV.j();
            }
        }
    }

    /* JADX INFO: renamed from: wV$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4207wV abstractC4207wV = AbstractC4207wV.this;
            e eVar = abstractC4207wV.l;
            if (eVar == e.OPENING || eVar == e.OPEN) {
                abstractC4207wV.i();
                AbstractC4207wV.this.k();
            }
        }
    }

    /* JADX INFO: renamed from: wV$c */
    public class c implements Runnable {
        public final /* synthetic */ WF[] a;

        public c(WF[] wfArr) {
            this.a = wfArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4207wV abstractC4207wV = AbstractC4207wV.this;
            if (abstractC4207wV.l != e.OPEN) {
                throw new RuntimeException("Transport not open");
            }
            abstractC4207wV.s(this.a);
        }
    }

    /* JADX INFO: renamed from: wV$d */
    public static class d {
        public String a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public int f = -1;
        public int g = -1;
        public Map h;
        public UQ i;
        public InterfaceC2447iY.a j;
        public InterfaceC2121ea.a k;
        public Map l;
    }

    /* JADX INFO: renamed from: wV$e */
    public enum e {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public AbstractC4207wV(d dVar) {
        this.h = dVar.b;
        this.i = dVar.a;
        this.g = dVar.f;
        this.e = dVar.d;
        this.d = dVar.h;
        this.j = dVar.c;
        this.f = dVar.e;
        this.k = dVar.i;
        this.m = dVar.j;
        this.n = dVar.k;
        this.o = dVar.l;
    }

    public AbstractC4207wV h() {
        C0626Jl.h(new b());
        return this;
    }

    public abstract void i();

    public abstract void j();

    public void k() {
        this.l = e.CLOSED;
        a("close", new Object[0]);
    }

    public void l(String str) {
        p(AbstractC3462nG.b(str));
    }

    public void m(byte[] bArr) {
        p(AbstractC3462nG.c(bArr));
    }

    public AbstractC4207wV n(String str, Exception exc) {
        a("error", new C3584ol(str, exc));
        return this;
    }

    public void o() {
        this.l = e.OPEN;
        this.b = true;
        a("open", new Object[0]);
    }

    public void p(WF wf) {
        a("packet", wf);
    }

    public AbstractC4207wV q() {
        C0626Jl.h(new a());
        return this;
    }

    public void r(WF[] wfArr) {
        C0626Jl.h(new c(wfArr));
    }

    public abstract void s(WF[] wfArr);
}
