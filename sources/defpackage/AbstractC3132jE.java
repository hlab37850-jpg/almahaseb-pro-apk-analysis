package defpackage;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: jE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3132jE implements InterfaceC3705qE {

    /* JADX INFO: renamed from: jE$a */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[M6.values().length];
            a = iArr;
            try {
                iArr[M6.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[M6.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[M6.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[M6.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int b() {
        return AbstractC3258kn.d();
    }

    public static AbstractC3132jE c(InterfaceC3624pE interfaceC3624pE) {
        Objects.requireNonNull(interfaceC3624pE, "source is null");
        return FM.k(new C3214kE(interfaceC3624pE));
    }

    public static AbstractC3132jE d(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return FM.k(new C3378mE(callable));
    }

    @Override // defpackage.InterfaceC3705qE
    public final void a(InterfaceC3866sE interfaceC3866sE) {
        Objects.requireNonNull(interfaceC3866sE, "observer is null");
        try {
            InterfaceC3866sE interfaceC3866sER = FM.r(this, interfaceC3866sE);
            Objects.requireNonNull(interfaceC3866sER, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            l(interfaceC3866sER);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            FM.m(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final AbstractC3132jE e(AN an) {
        return f(an, false, b());
    }

    public final AbstractC3132jE f(AN an, boolean z, int i) {
        Objects.requireNonNull(an, "scheduler is null");
        AbstractC2427iE.a(i, "bufferSize");
        return FM.k(new C3460nE(this, an, z, i));
    }

    public final AbstractC3132jE g() {
        return h(AbstractC1177Zp.a());
    }

    public final AbstractC3132jE h(CH ch) {
        Objects.requireNonNull(ch, "predicate is null");
        return FM.k(new C3542oE(this, ch));
    }

    public final InterfaceC0624Jj i(InterfaceC2295gf interfaceC2295gf) {
        return k(interfaceC2295gf, AbstractC1177Zp.f, AbstractC1177Zp.c);
    }

    public final InterfaceC0624Jj j(InterfaceC2295gf interfaceC2295gf, InterfaceC2295gf interfaceC2295gf2) {
        return k(interfaceC2295gf, interfaceC2295gf2, AbstractC1177Zp.c);
    }

    public final InterfaceC0624Jj k(InterfaceC2295gf interfaceC2295gf, InterfaceC2295gf interfaceC2295gf2, Y1 y1) {
        Objects.requireNonNull(interfaceC2295gf, "onNext is null");
        Objects.requireNonNull(interfaceC2295gf2, "onError is null");
        Objects.requireNonNull(y1, "onComplete is null");
        C2315gv c2315gv = new C2315gv(interfaceC2295gf, interfaceC2295gf2, y1, AbstractC1177Zp.b());
        a(c2315gv);
        return c2315gv;
    }

    public abstract void l(InterfaceC3866sE interfaceC3866sE);

    public final AbstractC3132jE m(AN an) {
        Objects.requireNonNull(an, "scheduler is null");
        return FM.k(new C3785rE(this, an));
    }

    public final AbstractC3258kn n(M6 m6) {
        Objects.requireNonNull(m6, "strategy is null");
        C3340ln c3340ln = new C3340ln(this);
        int i = a.a[m6.ordinal()];
        if (i == 1) {
            return c3340ln.i();
        }
        if (i == 2) {
            return c3340ln.j();
        }
        if (i != 3) {
            return i != 4 ? c3340ln.g() : FM.j(new C3828rn(c3340ln));
        }
        return c3340ln;
    }
}
