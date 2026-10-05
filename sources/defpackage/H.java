package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class H implements InterfaceC0988Vf.b {
    private final InterfaceC0988Vf.c key;

    public H(InterfaceC0988Vf.c cVar) {
        AbstractC4492zt.h(cVar, "key");
        this.key = cVar;
    }

    @Override // defpackage.InterfaceC0988Vf
    public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
        return (R) InterfaceC0988Vf.b.a.a(this, r, interfaceC0526Fp);
    }

    @Override // defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) InterfaceC0988Vf.b.a.b(this, cVar);
    }

    @Override // defpackage.InterfaceC0988Vf.b
    public InterfaceC0988Vf.c getKey() {
        return this.key;
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return InterfaceC0988Vf.b.a.c(this, cVar);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return InterfaceC0988Vf.b.a.d(this, interfaceC0988Vf);
    }
}
