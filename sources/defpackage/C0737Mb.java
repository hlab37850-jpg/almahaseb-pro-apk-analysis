package defpackage;

/* JADX INFO: renamed from: Mb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0737Mb extends AbstractC3957tO implements JJ {
    public final Throwable d;

    public C0737Mb(Throwable th) {
        this.d = th;
    }

    @Override // defpackage.AbstractC3957tO
    public YS A(C0533Fw.b bVar) {
        return AbstractC4465za.a;
    }

    public final Throwable E() {
        Throwable th = this.d;
        return th == null ? new C0850Qb("Channel was closed") : th;
    }

    public final Throwable F() {
        Throwable th = this.d;
        return th == null ? new C0876Rb("Channel was closed") : th;
    }

    @Override // defpackage.JJ
    public YS e(Object obj, C0533Fw.b bVar) {
        return AbstractC4465za.a;
    }

    @Override // defpackage.C0533Fw
    public String toString() {
        return "Closed@" + AbstractC3498ni.b(this) + '[' + this.d + ']';
    }

    @Override // defpackage.JJ
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public C0737Mb a() {
        return this;
    }

    @Override // defpackage.AbstractC3957tO
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public C0737Mb y() {
        return this;
    }

    @Override // defpackage.JJ
    public void d(Object obj) {
    }

    @Override // defpackage.AbstractC3957tO
    public void x() {
    }

    @Override // defpackage.AbstractC3957tO
    public void z(C0737Mb c0737Mb) {
    }
}
