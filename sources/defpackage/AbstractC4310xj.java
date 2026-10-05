package defpackage;

/* JADX INFO: renamed from: xj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4310xj {
    public static final void a(AbstractC4229wj abstractC4229wj, int i) {
        InterfaceC0793Of interfaceC0793OfC = abstractC4229wj.c();
        boolean z = i == 4;
        if (z || !(interfaceC0793OfC instanceof C3986tj) || b(i) != b(abstractC4229wj.c)) {
            d(abstractC4229wj, interfaceC0793OfC, z);
            return;
        }
        AbstractC1040Xf abstractC1040Xf = ((C3986tj) interfaceC0793OfC).d;
        InterfaceC0988Vf context = interfaceC0793OfC.getContext();
        if (abstractC1040Xf.isDispatchNeeded(context)) {
            abstractC1040Xf.dispatch(context, abstractC4229wj);
        } else {
            e(abstractC4229wj);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final void d(AbstractC4229wj abstractC4229wj, InterfaceC0793Of interfaceC0793Of, boolean z) {
        Object objF;
        Object objI = abstractC4229wj.i();
        Throwable thD = abstractC4229wj.d(objI);
        if (thD != null) {
            KL.a aVar = KL.a;
            objF = LL.a(thD);
        } else {
            KL.a aVar2 = KL.a;
            objF = abstractC4229wj.f(objI);
        }
        Object objA = KL.a(objF);
        if (!z) {
            interfaceC0793Of.resumeWith(objA);
            return;
        }
        C3986tj c3986tj = (C3986tj) interfaceC0793Of;
        InterfaceC0793Of interfaceC0793Of2 = c3986tj.e;
        Object obj = c3986tj.g;
        InterfaceC0988Vf context = interfaceC0793Of2.getContext();
        Object objC = AbstractC4368yU.c(context, obj);
        C4370yW c4370yWG = objC != AbstractC4368yU.a ? AbstractC1014Wf.g(interfaceC0793Of2, context, objC) : null;
        try {
            c3986tj.e.resumeWith(objA);
            FW fw = FW.a;
        } finally {
            if (c4370yWG == null || c4370yWG.I0()) {
                AbstractC4368yU.a(context, objC);
            }
        }
    }

    public static final void e(AbstractC4229wj abstractC4229wj) {
        AbstractC0422Dl abstractC0422DlB = C4459zU.a.b();
        if (abstractC0422DlB.N()) {
            abstractC0422DlB.J(abstractC4229wj);
            return;
        }
        abstractC0422DlB.L(true);
        try {
            d(abstractC4229wj, abstractC4229wj.c(), true);
            do {
            } while (abstractC0422DlB.Q());
        } catch (Throwable th) {
            try {
                abstractC4229wj.g(th, null);
            } finally {
                abstractC0422DlB.G(true);
            }
        }
    }
}
