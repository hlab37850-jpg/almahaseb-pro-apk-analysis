package defpackage;

/* JADX INFO: renamed from: aK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1219aK extends AbstractC4099v7 {
    public final C0533Fw a;

    public C1219aK(C0533Fw c0533Fw) {
        this.a = c0533Fw;
    }

    @Override // defpackage.AbstractC4131va
    public void a(Throwable th) {
        this.a.s();
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return FW.a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.a + ']';
    }
}
