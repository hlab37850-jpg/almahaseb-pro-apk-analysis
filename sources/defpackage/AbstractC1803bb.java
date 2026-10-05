package defpackage;

/* JADX INFO: renamed from: bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1803bb {
    public static final Object b(InterfaceC0988Vf interfaceC0988Vf, Object obj, Object obj2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objC = AbstractC4368yU.c(interfaceC0988Vf, obj2);
        try {
            Object objMo13invoke = ((InterfaceC0526Fp) NV.d(interfaceC0526Fp, 2)).mo13invoke(obj, new C3960tR(interfaceC0793Of, interfaceC0988Vf));
            AbstractC4368yU.a(interfaceC0988Vf, objC);
            if (objMo13invoke == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
            return objMo13invoke;
        } catch (Throwable th) {
            AbstractC4368yU.a(interfaceC0988Vf, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object c(InterfaceC0988Vf interfaceC0988Vf, Object obj, Object obj2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = AbstractC4368yU.b(interfaceC0988Vf);
        }
        return b(interfaceC0988Vf, obj, obj2, interfaceC0526Fp, interfaceC0793Of);
    }

    public static final InterfaceC0995Vm d(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0988Vf interfaceC0988Vf) {
        return interfaceC0995Vm instanceof C4281xO ? true : interfaceC0995Vm instanceof ED ? interfaceC0995Vm : new C4289xW(interfaceC0995Vm, interfaceC0988Vf);
    }
}
