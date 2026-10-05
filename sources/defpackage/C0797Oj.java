package defpackage;

/* JADX INFO: renamed from: Oj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0797Oj extends AbstractC4050ua {
    public final InterfaceC0745Mj a;

    public C0797Oj(InterfaceC0745Mj interfaceC0745Mj) {
        this.a = interfaceC0745Mj;
    }

    @Override // defpackage.AbstractC4131va
    public void a(Throwable th) {
        this.a.dispose();
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return FW.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
