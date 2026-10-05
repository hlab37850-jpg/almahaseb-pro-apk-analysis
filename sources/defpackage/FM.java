package defpackage;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FM {
    public static volatile InterfaceC2295gf a;
    public static volatile InterfaceC0777Np b;
    public static volatile InterfaceC0777Np c;
    public static volatile InterfaceC0777Np d;
    public static volatile InterfaceC0777Np e;
    public static volatile InterfaceC0777Np f;
    public static volatile InterfaceC0777Np g;
    public static volatile InterfaceC0777Np h;
    public static volatile InterfaceC0777Np i;
    public static volatile InterfaceC0777Np j;
    public static volatile InterfaceC0777Np k;

    public static Object a(InterfaceC0777Np interfaceC0777Np, Object obj) {
        try {
            return interfaceC0777Np.apply(obj);
        } catch (Throwable th) {
            throw AbstractC0696Kl.f(th);
        }
    }

    public static AN b(InterfaceC0777Np interfaceC0777Np, US us) {
        Object objA = a(interfaceC0777Np, us);
        Objects.requireNonNull(objA, "Scheduler Supplier result can't be null");
        return (AN) objA;
    }

    public static AN c(US us) {
        try {
            Object obj = us.get();
            Objects.requireNonNull(obj, "Scheduler Supplier result can't be null");
            return (AN) obj;
        } catch (Throwable th) {
            throw AbstractC0696Kl.f(th);
        }
    }

    public static AN d(Executor executor, boolean z, boolean z2) {
        return new C1088Yl(executor, z, z2);
    }

    public static AN e(US us) {
        Objects.requireNonNull(us, "Scheduler Supplier can't be null");
        InterfaceC0777Np interfaceC0777Np = c;
        return interfaceC0777Np == null ? c(us) : b(interfaceC0777Np, us);
    }

    public static AN f(US us) {
        Objects.requireNonNull(us, "Scheduler Supplier can't be null");
        InterfaceC0777Np interfaceC0777Np = e;
        return interfaceC0777Np == null ? c(us) : b(interfaceC0777Np, us);
    }

    public static AN g(US us) {
        Objects.requireNonNull(us, "Scheduler Supplier can't be null");
        InterfaceC0777Np interfaceC0777Np = f;
        return interfaceC0777Np == null ? c(us) : b(interfaceC0777Np, us);
    }

    public static AN h(US us) {
        Objects.requireNonNull(us, "Scheduler Supplier can't be null");
        InterfaceC0777Np interfaceC0777Np = d;
        return interfaceC0777Np == null ? c(us) : b(interfaceC0777Np, us);
    }

    public static boolean i(Throwable th) {
        return (th instanceof JE) || (th instanceof VB) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof C0441Ee);
    }

    public static AbstractC3258kn j(AbstractC3258kn abstractC3258kn) {
        InterfaceC0777Np interfaceC0777Np = i;
        return interfaceC0777Np != null ? (AbstractC3258kn) a(interfaceC0777Np, abstractC3258kn) : abstractC3258kn;
    }

    public static AbstractC3132jE k(AbstractC3132jE abstractC3132jE) {
        InterfaceC0777Np interfaceC0777Np = j;
        return interfaceC0777Np != null ? (AbstractC3132jE) a(interfaceC0777Np, abstractC3132jE) : abstractC3132jE;
    }

    public static BQ l(BQ bq) {
        InterfaceC0777Np interfaceC0777Np = k;
        return interfaceC0777Np != null ? (BQ) a(interfaceC0777Np, bq) : bq;
    }

    public static void m(Throwable th) {
        InterfaceC2295gf interfaceC2295gf = a;
        if (th == null) {
            th = AbstractC0696Kl.b("onError called with a null Throwable.");
        } else if (!i(th)) {
            th = new C3884sW(th);
        }
        if (interfaceC2295gf != null) {
            try {
                interfaceC2295gf.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                u(th2);
            }
        }
        th.printStackTrace();
        u(th);
    }

    public static AN n(AN an) {
        InterfaceC0777Np interfaceC0777Np = h;
        return interfaceC0777Np == null ? an : (AN) a(interfaceC0777Np, an);
    }

    public static Runnable o(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        InterfaceC0777Np interfaceC0777Np = b;
        return interfaceC0777Np == null ? runnable : (Runnable) a(interfaceC0777Np, runnable);
    }

    public static AN p(AN an) {
        InterfaceC0777Np interfaceC0777Np = g;
        return interfaceC0777Np == null ? an : (AN) a(interfaceC0777Np, an);
    }

    public static void u(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static InterfaceC1809be q(AbstractC1012Wd abstractC1012Wd, InterfaceC1809be interfaceC1809be) {
        return interfaceC1809be;
    }

    public static InterfaceC3866sE r(AbstractC3132jE abstractC3132jE, InterfaceC3866sE interfaceC3866sE) {
        return interfaceC3866sE;
    }

    public static FQ s(BQ bq, FQ fq) {
        return fq;
    }

    public static NS t(AbstractC3258kn abstractC3258kn, NS ns) {
        return ns;
    }
}
