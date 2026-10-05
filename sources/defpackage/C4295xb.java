package defpackage;

/* JADX INFO: renamed from: xb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4295xb extends AbstractC2068du implements InterfaceC4214wb {
    public final InterfaceC4376yb e;

    public C4295xb(InterfaceC4376yb interfaceC4376yb) {
        this.e = interfaceC4376yb;
    }

    @Override // defpackage.InterfaceC4214wb
    public boolean b(Throwable th) {
        return y().K(th);
    }

    @Override // defpackage.InterfaceC4214wb
    public InterfaceC1830bu getParent() {
        return y();
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        x((Throwable) obj);
        return FW.a;
    }

    @Override // defpackage.AbstractC2293ge
    public void x(Throwable th) {
        this.e.r(y());
    }
}
