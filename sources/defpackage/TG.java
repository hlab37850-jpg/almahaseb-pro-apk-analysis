package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TG extends AbstractC4207wV {
    public static final Logger q = Logger.getLogger(TG.class.getName());
    public boolean p;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        /* JADX INFO: renamed from: TG$a$a, reason: collision with other inner class name */
        public class RunnableC0017a implements Runnable {
            public final /* synthetic */ TG a;

            public RunnableC0017a(TG tg) {
                this.a = tg;
            }

            @Override // java.lang.Runnable
            public void run() {
                TG.q.fine("paused");
                this.a.l = AbstractC4207wV.e.PAUSED;
                a.this.a.run();
            }
        }

        public class b implements AbstractC0963Uk.a {
            public final /* synthetic */ int[] a;
            public final /* synthetic */ Runnable b;

            public b(int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                TG.q.fine("pre-pause polling complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        public class c implements AbstractC0963Uk.a {
            public final /* synthetic */ int[] a;
            public final /* synthetic */ Runnable b;

            public c(int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                TG.q.fine("pre-pause writing complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            TG tg = TG.this;
            tg.l = AbstractC4207wV.e.PAUSED;
            RunnableC0017a runnableC0017a = new RunnableC0017a(tg);
            if (!TG.this.p && TG.this.b) {
                runnableC0017a.run();
                return;
            }
            int[] iArr = {0};
            if (TG.this.p) {
                TG.q.fine("we are currently polling - waiting to pause");
                iArr[0] = iArr[0] + 1;
                TG.this.f("pollComplete", new b(iArr, runnableC0017a));
            }
            if (TG.this.b) {
                return;
            }
            TG.q.fine("we are currently writing - waiting to pause");
            iArr[0] = iArr[0] + 1;
            TG.this.f("drain", new c(iArr, runnableC0017a));
        }
    }

    public class b implements AbstractC3462nG.c {
        public final /* synthetic */ TG a;

        public b(TG tg) {
            this.a = tg;
        }

        @Override // defpackage.AbstractC3462nG.c
        public boolean a(WF wf, int i, int i2) {
            if (this.a.l == AbstractC4207wV.e.OPENING && "open".equals(wf.a)) {
                this.a.o();
            }
            if ("close".equals(wf.a)) {
                this.a.k();
                return false;
            }
            this.a.p(wf);
            return true;
        }
    }

    public class c implements AbstractC0963Uk.a {
        public final /* synthetic */ TG a;

        public c(TG tg) {
            this.a = tg;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            TG.q.fine("writing close packet");
            this.a.s(new WF[]{new WF("close")});
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ TG a;

        public d(TG tg) {
            this.a = tg;
        }

        @Override // java.lang.Runnable
        public void run() {
            TG tg = this.a;
            tg.b = true;
            tg.a("drain", new Object[0]);
        }
    }

    public class e implements AbstractC3462nG.d {
        public final /* synthetic */ TG a;
        public final /* synthetic */ Runnable b;

        public e(TG tg, Runnable runnable) {
            this.a = tg;
            this.b = runnable;
        }

        @Override // defpackage.AbstractC3462nG.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            this.a.D(str, this.b);
        }
    }

    public TG(AbstractC4207wV.d dVar) {
        super(dVar);
        this.c = "polling";
    }

    public abstract void C();

    public abstract void D(String str, Runnable runnable);

    public void E(Runnable runnable) {
        C0626Jl.h(new a(runnable));
    }

    public final void F() {
        q.fine("polling");
        this.p = true;
        C();
        a("poll", new Object[0]);
    }

    public String G() {
        String str;
        String str2;
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str3 = this.e ? "https" : "http";
        if (this.f) {
            map.put(this.j, XZ.b());
        }
        String strB = AbstractC3298lG.b(map);
        if (this.g <= 0 || ((!"https".equals(str3) || this.g == 443) && (!"http".equals(str3) || this.g == 80))) {
            str = "";
        } else {
            str = ":" + this.g;
        }
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
        c cVar = new c(this);
        if (this.l == AbstractC4207wV.e.OPEN) {
            q.fine("transport open - closing");
            cVar.call(new Object[0]);
        } else {
            q.fine("transport not open - deferring close");
            f("open", cVar);
        }
    }

    @Override // defpackage.AbstractC4207wV
    public void j() {
        F();
    }

    @Override // defpackage.AbstractC4207wV
    public void l(String str) {
        t(str);
    }

    @Override // defpackage.AbstractC4207wV
    public void s(WF[] wfArr) {
        this.b = false;
        AbstractC3462nG.g(wfArr, new e(this, new d(this)));
    }

    public final void t(Object obj) {
        Logger logger = q;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("polling got data %s", obj));
        }
        AbstractC3462nG.d((String) obj, new b(this));
        if (this.l != AbstractC4207wV.e.CLOSED) {
            this.p = false;
            a("pollComplete", new Object[0]);
            if (this.l == AbstractC4207wV.e.OPEN) {
                F();
            } else if (logger.isLoggable(level)) {
                logger.fine(String.format("ignoring poll - transport state '%s'", this.l));
            }
        }
    }
}
