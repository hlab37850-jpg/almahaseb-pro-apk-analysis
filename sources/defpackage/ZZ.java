package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZZ {
    public static final Object a(InterfaceC0793Of interfaceC0793Of) {
        Object objD;
        InterfaceC0988Vf context = interfaceC0793Of.getContext();
        AbstractC3347lu.j(context);
        InterfaceC0793Of interfaceC0793OfC = AbstractC0352At.c(interfaceC0793Of);
        C3986tj c3986tj = interfaceC0793OfC instanceof C3986tj ? (C3986tj) interfaceC0793OfC : null;
        if (c3986tj == null) {
            objD = FW.a;
        } else {
            if (c3986tj.d.isDispatchNeeded(context)) {
                c3986tj.q(context, FW.a);
            } else {
                YZ yz = new YZ();
                InterfaceC0988Vf interfaceC0988VfPlus = context.plus(yz);
                FW fw = FW.a;
                c3986tj.q(interfaceC0988VfPlus, fw);
                objD = (!yz.a || AbstractC4067uj.d(c3986tj)) ? AbstractC0378Bt.d() : fw;
            }
            objD = AbstractC0378Bt.d();
        }
        if (objD == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }
}
