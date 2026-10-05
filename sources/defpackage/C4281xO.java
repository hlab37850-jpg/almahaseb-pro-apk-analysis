package defpackage;

/* JADX INFO: renamed from: xO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4281xO implements InterfaceC0995Vm {
    public final InterfaceC4038uO a;

    public C4281xO(InterfaceC4038uO interfaceC4038uO) {
        this.a = interfaceC4038uO;
    }

    @Override // defpackage.InterfaceC0995Vm
    public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
        Object objSend = this.a.send(obj, interfaceC0793Of);
        return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
    }
}
