package defpackage;

/* JADX INFO: renamed from: tR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3960tR implements InterfaceC0793Of, InterfaceC2297gg {
    public final InterfaceC0793Of a;
    public final InterfaceC0988Vf b;

    public C3960tR(InterfaceC0793Of interfaceC0793Of, InterfaceC0988Vf interfaceC0988Vf) {
        this.a = interfaceC0793Of;
        this.b = interfaceC0988Vf;
    }

    @Override // defpackage.InterfaceC2297gg
    public InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.a;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        return this.b;
    }

    @Override // defpackage.InterfaceC0793Of
    public void resumeWith(Object obj) {
        this.a.resumeWith(obj);
    }
}
