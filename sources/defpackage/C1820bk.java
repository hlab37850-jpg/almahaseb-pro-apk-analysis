package defpackage;

/* JADX INFO: renamed from: bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1820bk implements InterfaceC0988Vf {
    public final Throwable a;
    public final /* synthetic */ InterfaceC0988Vf b;

    public C1820bk(Throwable th, InterfaceC0988Vf interfaceC0988Vf) {
        this.a = th;
        this.b = interfaceC0988Vf;
    }

    @Override // defpackage.InterfaceC0988Vf
    public Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return this.b.fold(obj, interfaceC0526Fp);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf.b get(InterfaceC0988Vf.c cVar) {
        return this.b.get(cVar);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return this.b.minusKey(cVar);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return this.b.plus(interfaceC0988Vf);
    }
}
