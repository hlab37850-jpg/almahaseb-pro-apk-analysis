package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2133eg {
    public static final InterfaceC2052dg a(InterfaceC0988Vf interfaceC0988Vf) {
        if (interfaceC0988Vf.get(InterfaceC1830bu.s) == null) {
            interfaceC0988Vf = interfaceC0988Vf.plus(AbstractC3511nu.b(null, 1, null));
        }
        return new C0767Nf(interfaceC0988Vf);
    }

    public static final InterfaceC2052dg b() {
        return new C0767Nf(TS.b(null, 1, null).plus(C0368Bj.c()));
    }

    public static final void c(InterfaceC2052dg interfaceC2052dg, CancellationException cancellationException) {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) interfaceC2052dg.getCoroutineContext().get(InterfaceC1830bu.s);
        if (interfaceC1830bu != null) {
            interfaceC1830bu.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + interfaceC2052dg).toString());
    }

    public static final Object d(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        ON on = new ON(interfaceC0793Of.getContext(), interfaceC0793Of);
        Object objB = AbstractC4461zW.b(on, on, interfaceC0526Fp);
        if (objB == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objB;
    }

    public static final boolean e(InterfaceC2052dg interfaceC2052dg) {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) interfaceC2052dg.getCoroutineContext().get(InterfaceC1830bu.s);
        if (interfaceC1830bu != null) {
            return interfaceC1830bu.isActive();
        }
        return true;
    }

    public static final InterfaceC2052dg f(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf) {
        return new C0767Nf(interfaceC2052dg.getCoroutineContext().plus(interfaceC0988Vf));
    }
}
