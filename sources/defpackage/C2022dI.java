package defpackage;

/* JADX INFO: renamed from: dI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2022dI extends AbstractC1077Ya implements InterfaceC2103eI {
    public C2022dI(InterfaceC0988Vf interfaceC0988Vf, InterfaceC1009Wa interfaceC1009Wa) {
        super(interfaceC0988Vf, interfaceC1009Wa, true, true);
    }

    @Override // defpackage.G
    public void E0(Throwable th, boolean z) {
        if (I0().close(th) || z) {
            return;
        }
        AbstractC1247ag.a(getContext(), th);
    }

    @Override // defpackage.G
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void F0(FW fw) {
        InterfaceC4038uO.a.a(I0(), null, 1, null);
    }

    @Override // defpackage.InterfaceC2103eI
    public /* bridge */ /* synthetic */ InterfaceC4038uO getChannel() {
        return H0();
    }

    @Override // defpackage.G, defpackage.C3674pu, defpackage.InterfaceC1830bu
    public boolean isActive() {
        return super.isActive();
    }
}
