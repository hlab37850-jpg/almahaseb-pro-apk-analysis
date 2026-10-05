package defpackage;

/* JADX INFO: renamed from: Rf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0880Rf {
    public static final InterfaceC0793Of a(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of) {
        AbstractC4492zt.h(interfaceC0526Fp, "<this>");
        AbstractC4492zt.h(interfaceC0793Of, "completion");
        return new C3633pN(AbstractC0352At.c(AbstractC0352At.b(interfaceC0526Fp, obj, interfaceC0793Of)), AbstractC0378Bt.d());
    }

    public static final void b(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of) {
        AbstractC4492zt.h(interfaceC0526Fp, "<this>");
        AbstractC4492zt.h(interfaceC0793Of, "completion");
        InterfaceC0793Of interfaceC0793OfC = AbstractC0352At.c(AbstractC0352At.b(interfaceC0526Fp, obj, interfaceC0793Of));
        KL.a aVar = KL.a;
        interfaceC0793OfC.resumeWith(KL.a(FW.a));
    }
}
