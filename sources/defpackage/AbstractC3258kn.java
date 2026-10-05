package defpackage;

import java.util.Objects;

/* JADX INFO: renamed from: kn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3258kn implements BI {
    public static final int a = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    public static int d() {
        return a;
    }

    public static AbstractC3258kn e(BI bi) {
        if (bi instanceof AbstractC3258kn) {
            return FM.j((AbstractC3258kn) bi);
        }
        Objects.requireNonNull(bi, "publisher is null");
        return FM.j(new C3422mn(bi));
    }

    @Override // defpackage.BI
    public final void c(NS ns) {
        if (ns instanceof InterfaceC4071un) {
            m((InterfaceC4071un) ns);
        } else {
            Objects.requireNonNull(ns, "subscriber is null");
            m(new C2277gS(ns));
        }
    }

    public final AbstractC3258kn f(InterfaceC0777Np interfaceC0777Np) {
        Objects.requireNonNull(interfaceC0777Np, "mapper is null");
        return FM.j(new C3586on(this, interfaceC0777Np));
    }

    public final AbstractC3258kn g() {
        return h(d(), false, true);
    }

    public final AbstractC3258kn h(int i, boolean z, boolean z2) {
        AbstractC2427iE.a(i, "capacity");
        return FM.j(new C3667pn(this, i, z2, z, AbstractC1177Zp.c));
    }

    public final AbstractC3258kn i() {
        return FM.j(new C3748qn(this));
    }

    public final AbstractC3258kn j() {
        return FM.j(new C3909sn(this));
    }

    public final InterfaceC0624Jj k(InterfaceC2295gf interfaceC2295gf) {
        return l(interfaceC2295gf, AbstractC1177Zp.f, AbstractC1177Zp.c);
    }

    public final InterfaceC0624Jj l(InterfaceC2295gf interfaceC2295gf, InterfaceC2295gf interfaceC2295gf2, Y1 y1) {
        Objects.requireNonNull(interfaceC2295gf, "onNext is null");
        Objects.requireNonNull(interfaceC2295gf2, "onError is null");
        Objects.requireNonNull(y1, "onComplete is null");
        C2397hv c2397hv = new C2397hv(interfaceC2295gf, interfaceC2295gf2, y1, EnumC3504nn.INSTANCE);
        m(c2397hv);
        return c2397hv;
    }

    public final void m(InterfaceC4071un interfaceC4071un) {
        Objects.requireNonNull(interfaceC4071un, "subscriber is null");
        try {
            NS nsT = FM.t(this, interfaceC4071un);
            Objects.requireNonNull(nsT, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            n(nsT);
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

    public abstract void n(NS ns);
}
