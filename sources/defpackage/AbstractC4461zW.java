package defpackage;

/* JADX INFO: renamed from: zW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4461zW {
    public static final void a(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of) {
        InterfaceC0793Of interfaceC0793OfA = AbstractC3416mi.a(interfaceC0793Of);
        try {
            InterfaceC0988Vf context = interfaceC0793Of.getContext();
            Object objC = AbstractC4368yU.c(context, null);
            try {
                Object objMo13invoke = ((InterfaceC0526Fp) NV.d(interfaceC0526Fp, 2)).mo13invoke(obj, interfaceC0793OfA);
                AbstractC4368yU.a(context, objC);
                if (objMo13invoke != AbstractC0378Bt.d()) {
                    interfaceC0793OfA.resumeWith(KL.a(objMo13invoke));
                }
            } catch (Throwable th) {
                AbstractC4368yU.a(context, objC);
                throw th;
            }
        } catch (Throwable th2) {
            KL.a aVar = KL.a;
            interfaceC0793OfA.resumeWith(KL.a(LL.a(th2)));
        }
    }

    public static final Object b(ON on, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        Object c2129ee;
        try {
            c2129ee = ((InterfaceC0526Fp) NV.d(interfaceC0526Fp, 2)).mo13invoke(obj, on);
        } catch (Throwable th) {
            c2129ee = new C2129ee(th, false, 2, null);
        }
        if (c2129ee == AbstractC0378Bt.d()) {
            return AbstractC0378Bt.d();
        }
        Object objG0 = on.g0(c2129ee);
        if (objG0 == AbstractC3755qu.b) {
            return AbstractC0378Bt.d();
        }
        if (objG0 instanceof C2129ee) {
            throw ((C2129ee) objG0).a;
        }
        return AbstractC3755qu.h(objG0);
    }

    public static final Object c(ON on, Object obj, InterfaceC0526Fp interfaceC0526Fp) throws Throwable {
        Object c2129ee;
        try {
            c2129ee = ((InterfaceC0526Fp) NV.d(interfaceC0526Fp, 2)).mo13invoke(obj, on);
        } catch (Throwable th) {
            c2129ee = new C2129ee(th, false, 2, null);
        }
        if (c2129ee == AbstractC0378Bt.d()) {
            return AbstractC0378Bt.d();
        }
        Object objG0 = on.g0(c2129ee);
        if (objG0 == AbstractC3755qu.b) {
            return AbstractC0378Bt.d();
        }
        if (objG0 instanceof C2129ee) {
            Throwable th2 = ((C2129ee) objG0).a;
            if (!(th2 instanceof KU) || ((KU) th2).a != on) {
                throw th2;
            }
            if (c2129ee instanceof C2129ee) {
                throw ((C2129ee) c2129ee).a;
            }
        } else {
            c2129ee = AbstractC3755qu.h(objG0);
        }
        return c2129ee;
    }
}
