package defpackage;

/* JADX INFO: renamed from: vO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4119vO extends AbstractC3957tO {
    public final Object d;
    public final InterfaceC4293xa e;

    public C4119vO(Object obj, InterfaceC4293xa interfaceC4293xa) {
        this.d = obj;
        this.e = interfaceC4293xa;
    }

    @Override // defpackage.AbstractC3957tO
    public YS A(C0533Fw.b bVar) {
        if (this.e.a(FW.a, null) == null) {
            return null;
        }
        return AbstractC4465za.a;
    }

    @Override // defpackage.C0533Fw
    public String toString() {
        return AbstractC3498ni.a(this) + '@' + AbstractC3498ni.b(this) + '(' + y() + ')';
    }

    @Override // defpackage.AbstractC3957tO
    public void x() {
        this.e.o(AbstractC4465za.a);
    }

    @Override // defpackage.AbstractC3957tO
    public Object y() {
        return this.d;
    }

    @Override // defpackage.AbstractC3957tO
    public void z(C0737Mb c0737Mb) {
        InterfaceC4293xa interfaceC4293xa = this.e;
        KL.a aVar = KL.a;
        interfaceC4293xa.resumeWith(KL.a(LL.a(c0737Mb.F())));
    }
}
