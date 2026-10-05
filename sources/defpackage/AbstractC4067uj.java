package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: uj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4067uj {
    public static final YS a = new YS("UNDEFINED");
    public static final YS b = new YS("REUSABLE_CLAIMED");

    public static final void b(InterfaceC0793Of interfaceC0793Of, Object obj, InterfaceC3750qp interfaceC3750qp) {
        if (!(interfaceC0793Of instanceof C3986tj)) {
            interfaceC0793Of.resumeWith(obj);
            return;
        }
        C3986tj c3986tj = (C3986tj) interfaceC0793Of;
        Object objC = AbstractC2457ie.c(obj, interfaceC3750qp);
        if (c3986tj.d.isDispatchNeeded(c3986tj.getContext())) {
            c3986tj.f = objC;
            c3986tj.c = 1;
            c3986tj.d.dispatch(c3986tj.getContext(), c3986tj);
            return;
        }
        AbstractC0422Dl abstractC0422DlB = C4459zU.a.b();
        if (abstractC0422DlB.N()) {
            c3986tj.f = objC;
            c3986tj.c = 1;
            abstractC0422DlB.J(c3986tj);
            return;
        }
        abstractC0422DlB.L(true);
        try {
            InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) c3986tj.getContext().get(InterfaceC1830bu.s);
            if (interfaceC1830bu == null || interfaceC1830bu.isActive()) {
                InterfaceC0793Of interfaceC0793Of2 = c3986tj.e;
                Object obj2 = c3986tj.g;
                InterfaceC0988Vf context = interfaceC0793Of2.getContext();
                Object objC2 = AbstractC4368yU.c(context, obj2);
                C4370yW c4370yWG = objC2 != AbstractC4368yU.a ? AbstractC1014Wf.g(interfaceC0793Of2, context, objC2) : null;
                try {
                    c3986tj.e.resumeWith(obj);
                    FW fw = FW.a;
                    if (c4370yWG == null || c4370yWG.I0()) {
                        AbstractC4368yU.a(context, objC2);
                    }
                } catch (Throwable th) {
                    if (c4370yWG == null || c4370yWG.I0()) {
                        AbstractC4368yU.a(context, objC2);
                    }
                    throw th;
                }
            } else {
                CancellationException cancellationExceptionI = interfaceC1830bu.i();
                c3986tj.b(objC, cancellationExceptionI);
                KL.a aVar = KL.a;
                c3986tj.resumeWith(KL.a(LL.a(cancellationExceptionI)));
            }
            while (abstractC0422DlB.Q()) {
            }
        } catch (Throwable th2) {
            try {
                c3986tj.g(th2, null);
            } finally {
                abstractC0422DlB.G(true);
            }
        }
    }

    public static /* synthetic */ void c(InterfaceC0793Of interfaceC0793Of, Object obj, InterfaceC3750qp interfaceC3750qp, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        b(interfaceC0793Of, obj, interfaceC3750qp);
    }

    public static final boolean d(C3986tj c3986tj) {
        FW fw = FW.a;
        AbstractC0422Dl abstractC0422DlB = C4459zU.a.b();
        if (abstractC0422DlB.O()) {
            return false;
        }
        if (abstractC0422DlB.N()) {
            c3986tj.f = fw;
            c3986tj.c = 1;
            abstractC0422DlB.J(c3986tj);
            return true;
        }
        abstractC0422DlB.L(true);
        try {
            c3986tj.run();
            do {
            } while (abstractC0422DlB.Q());
        } catch (Throwable th) {
            try {
                c3986tj.g(th, null);
            } finally {
                abstractC0422DlB.G(true);
            }
        }
        return false;
    }
}
