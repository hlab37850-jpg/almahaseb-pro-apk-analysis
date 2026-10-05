package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC3511nu {
    public static final InterfaceC1243ae a(InterfaceC1830bu interfaceC1830bu) {
        return new C2150eu(interfaceC1830bu);
    }

    public static /* synthetic */ InterfaceC1243ae b(InterfaceC1830bu interfaceC1830bu, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC1830bu = null;
        }
        return AbstractC3347lu.a(interfaceC1830bu);
    }

    public static final void c(InterfaceC0988Vf interfaceC0988Vf, CancellationException cancellationException) {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s);
        if (interfaceC1830bu != null) {
            interfaceC1830bu.cancel(cancellationException);
        }
    }

    public static final void d(InterfaceC1830bu interfaceC1830bu, String str, Throwable th) {
        interfaceC1830bu.cancel(AbstractC0747Ml.a(str, th));
    }

    public static /* synthetic */ void e(InterfaceC0988Vf interfaceC0988Vf, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        AbstractC3347lu.c(interfaceC0988Vf, cancellationException);
    }

    public static /* synthetic */ void f(InterfaceC1830bu interfaceC1830bu, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        AbstractC3347lu.d(interfaceC1830bu, str, th);
    }

    public static final Object g(InterfaceC1830bu interfaceC1830bu, InterfaceC0793Of interfaceC0793Of) {
        InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
        Object objF = interfaceC1830bu.F(interfaceC0793Of);
        return objF == AbstractC0378Bt.d() ? objF : FW.a;
    }

    public static final InterfaceC0745Mj h(InterfaceC1830bu interfaceC1830bu, InterfaceC0745Mj interfaceC0745Mj) {
        return interfaceC1830bu.C(new C0858Qj(interfaceC0745Mj));
    }

    public static final void i(InterfaceC0988Vf interfaceC0988Vf) {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s);
        if (interfaceC1830bu != null) {
            AbstractC3347lu.k(interfaceC1830bu);
        }
    }

    public static final void j(InterfaceC1830bu interfaceC1830bu) {
        if (!interfaceC1830bu.isActive()) {
            throw interfaceC1830bu.i();
        }
    }

    public static final InterfaceC1830bu k(InterfaceC0988Vf interfaceC0988Vf) {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s);
        if (interfaceC1830bu != null) {
            return interfaceC1830bu;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + interfaceC0988Vf).toString());
    }

    public static final boolean l(InterfaceC0988Vf interfaceC0988Vf) {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s);
        return interfaceC1830bu != null && interfaceC1830bu.isActive();
    }
}
