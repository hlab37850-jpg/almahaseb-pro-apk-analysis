package defpackage;

/* JADX INFO: renamed from: Qj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0858Qj extends AbstractC3593ou {
    public final InterfaceC0745Mj e;

    public C0858Qj(InterfaceC0745Mj interfaceC0745Mj) {
        this.e = interfaceC0745Mj;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        x((Throwable) obj);
        return FW.a;
    }

    @Override // defpackage.AbstractC2293ge
    public void x(Throwable th) {
        this.e.dispose();
    }
}
