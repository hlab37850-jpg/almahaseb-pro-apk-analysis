package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class ML extends AbstractC3593ou {
    public final C4374ya e;

    public ML(C4374ya c4374ya) {
        this.e = c4374ya;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        x((Throwable) obj);
        return FW.a;
    }

    @Override // defpackage.AbstractC2293ge
    public void x(Throwable th) {
        Object objW = y().W();
        if (objW instanceof C2129ee) {
            C4374ya c4374ya = this.e;
            KL.a aVar = KL.a;
            c4374ya.resumeWith(KL.a(LL.a(((C2129ee) objW).a)));
        } else {
            C4374ya c4374ya2 = this.e;
            KL.a aVar2 = KL.a;
            c4374ya2.resumeWith(KL.a(AbstractC3755qu.h(objW)));
        }
    }
}
