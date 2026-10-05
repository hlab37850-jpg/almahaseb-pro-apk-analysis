package defpackage;

/* JADX INFO: renamed from: Nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0767Nf implements InterfaceC2052dg {
    public final InterfaceC0988Vf a;

    public C0767Nf(InterfaceC0988Vf interfaceC0988Vf) {
        this.a = interfaceC0988Vf;
    }

    @Override // defpackage.InterfaceC2052dg
    public InterfaceC0988Vf getCoroutineContext() {
        return this.a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
