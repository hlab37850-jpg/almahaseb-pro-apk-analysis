package defpackage;

/* JADX INFO: renamed from: yW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4370yW extends ON {
    public ThreadLocal d;

    /* JADX WARN: Illegal instructions before constructor call */
    public C4370yW(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0793Of interfaceC0793Of) {
        AW aw = AW.a;
        super(interfaceC0988Vf.get(aw) == null ? interfaceC0988Vf.plus(aw) : interfaceC0988Vf, interfaceC0793Of);
        this.d = new ThreadLocal();
        if (interfaceC0793Of.getContext().get(InterfaceC0854Qf.o) instanceof AbstractC1040Xf) {
            return;
        }
        Object objC = AbstractC4368yU.c(interfaceC0988Vf, null);
        AbstractC4368yU.a(interfaceC0988Vf, objC);
        J0(interfaceC0988Vf, objC);
    }

    @Override // defpackage.ON, defpackage.G
    public void D0(Object obj) {
        C2020dG c2020dG = (C2020dG) this.d.get();
        if (c2020dG != null) {
            AbstractC4368yU.a((InterfaceC0988Vf) c2020dG.a(), c2020dG.b());
            this.d.set(null);
        }
        Object objA = AbstractC2457ie.a(obj, this.c);
        InterfaceC0793Of interfaceC0793Of = this.c;
        InterfaceC0988Vf context = interfaceC0793Of.getContext();
        Object objC = AbstractC4368yU.c(context, null);
        C4370yW c4370yWG = objC != AbstractC4368yU.a ? AbstractC1014Wf.g(interfaceC0793Of, context, objC) : null;
        try {
            this.c.resumeWith(objA);
            FW fw = FW.a;
        } finally {
            if (c4370yWG == null || c4370yWG.I0()) {
                AbstractC4368yU.a(context, objC);
            }
        }
    }

    public final boolean I0() {
        if (this.d.get() == null) {
            return false;
        }
        this.d.set(null);
        return true;
    }

    public final void J0(InterfaceC0988Vf interfaceC0988Vf, Object obj) {
        this.d.set(HV.a(interfaceC0988Vf, obj));
    }
}
