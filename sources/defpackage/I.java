package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class I implements InterfaceC0988Vf.c {
    public final InterfaceC3750qp a;
    public final InterfaceC0988Vf.c b;

    public I(InterfaceC0988Vf.c cVar, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(cVar, "baseKey");
        AbstractC4492zt.h(interfaceC3750qp, "safeCast");
        this.a = interfaceC3750qp;
        this.b = cVar instanceof I ? ((I) cVar).b : cVar;
    }

    public final boolean a(InterfaceC0988Vf.c cVar) {
        AbstractC4492zt.h(cVar, "key");
        return cVar == this || this.b == cVar;
    }

    public final InterfaceC0988Vf.b b(InterfaceC0988Vf.b bVar) {
        AbstractC4492zt.h(bVar, "element");
        return (InterfaceC0988Vf.b) this.a.invoke(bVar);
    }
}
