package defpackage;

/* JADX INFO: renamed from: Ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0385Ca {
    public static final void a(InterfaceC0793Of interfaceC0793Of, Throwable th) throws Throwable {
        KL.a aVar = KL.a;
        interfaceC0793Of.resumeWith(KL.a(LL.a(th)));
        throw th;
    }

    public static final void b(InterfaceC0793Of interfaceC0793Of, InterfaceC0793Of interfaceC0793Of2) throws Throwable {
        try {
            InterfaceC0793Of interfaceC0793OfC = AbstractC0352At.c(interfaceC0793Of);
            KL.a aVar = KL.a;
            AbstractC4067uj.c(interfaceC0793OfC, KL.a(FW.a), null, 2, null);
        } catch (Throwable th) {
            a(interfaceC0793Of2, th);
        }
    }

    public static final void c(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        try {
            InterfaceC0793Of interfaceC0793OfC = AbstractC0352At.c(AbstractC0352At.a(interfaceC3750qp, interfaceC0793Of));
            KL.a aVar = KL.a;
            AbstractC4067uj.c(interfaceC0793OfC, KL.a(FW.a), null, 2, null);
        } catch (Throwable th) {
            a(interfaceC0793Of, th);
        }
    }

    public static final void d(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of, InterfaceC3750qp interfaceC3750qp) throws Throwable {
        try {
            InterfaceC0793Of interfaceC0793OfC = AbstractC0352At.c(AbstractC0352At.b(interfaceC0526Fp, obj, interfaceC0793Of));
            KL.a aVar = KL.a;
            AbstractC4067uj.b(interfaceC0793OfC, KL.a(FW.a), interfaceC3750qp);
        } catch (Throwable th) {
            a(interfaceC0793Of, th);
        }
    }

    public static /* synthetic */ void e(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of, InterfaceC3750qp interfaceC3750qp, int i, Object obj2) throws Throwable {
        if ((i & 4) != 0) {
            interfaceC3750qp = null;
        }
        d(interfaceC0526Fp, obj, interfaceC0793Of, interfaceC3750qp);
    }
}
