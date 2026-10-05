package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IL extends AbstractC2171f7 {
    public IL(InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
        if (interfaceC0793Of != null && interfaceC0793Of.getContext() != C1172Zk.a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        return C1172Zk.a;
    }
}
