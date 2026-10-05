package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class N8 {
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public static final Object a(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC0422Dl abstractC0422DlA;
        InterfaceC0988Vf interfaceC0988VfE;
        Thread threadCurrentThread = Thread.currentThread();
        InterfaceC0854Qf interfaceC0854Qf = (InterfaceC0854Qf) interfaceC0988Vf.get(InterfaceC0854Qf.o);
        if (interfaceC0854Qf == null) {
            abstractC0422DlA = C4459zU.a.b();
            interfaceC0988VfE = AbstractC1014Wf.e(C3343lq.a, interfaceC0988Vf.plus(abstractC0422DlA));
        } else {
            AbstractC0422Dl abstractC0422Dl = interfaceC0854Qf instanceof AbstractC0422Dl ? (AbstractC0422Dl) interfaceC0854Qf : null;
            if (abstractC0422Dl == null) {
                abstractC0422DlA = C4459zU.a.a();
            } else {
                AbstractC0422Dl abstractC0422Dl2 = abstractC0422Dl.R() ? abstractC0422Dl : null;
                if (abstractC0422Dl2 == null) {
                    abstractC0422DlA = C4459zU.a.a();
                } else {
                    abstractC0422DlA = abstractC0422Dl2;
                }
            }
            interfaceC0988VfE = AbstractC1014Wf.e(C3343lq.a, interfaceC0988Vf);
        }
        C3452n8 c3452n8 = new C3452n8(interfaceC0988VfE, threadCurrentThread, abstractC0422DlA);
        c3452n8.G0(EnumC2379hg.DEFAULT, c3452n8, interfaceC0526Fp);
        return c3452n8.H0();
    }

    public static /* synthetic */ Object b(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        return M8.e(interfaceC0988Vf, interfaceC0526Fp);
    }
}
