package defpackage;

/* JADX INFO: renamed from: Ft, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0530Ft extends AbstractC4050ua {
    public final InterfaceC3750qp a;

    public C0530Ft(InterfaceC3750qp interfaceC3750qp) {
        this.a = interfaceC3750qp;
    }

    @Override // defpackage.AbstractC4131va
    public void a(Throwable th) {
        this.a.invoke(th);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return FW.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + AbstractC3498ni.a(this.a) + '@' + AbstractC3498ni.b(this) + ']';
    }
}
