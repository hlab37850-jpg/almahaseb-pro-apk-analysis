package defpackage;

/* JADX INFO: renamed from: pI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3628pI extends AbstractC3951tI implements InterfaceC1003Vu {
    public AbstractC3628pI(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0609Iu computeReflected() {
        return QJ.f(this);
    }

    @Override // defpackage.InterfaceC1003Vu
    public Object getDelegate() {
        return ((InterfaceC1003Vu) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ InterfaceC0977Uu.a getGetter() {
        mo5460getGetter();
        return null;
    }

    @Override // defpackage.InterfaceC3588op
    public Object invoke() {
        return get();
    }

    @Override // defpackage.InterfaceC1003Vu
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public InterfaceC1003Vu.a mo5460getGetter() {
        ((InterfaceC1003Vu) getReflected()).mo5460getGetter();
        return null;
    }
}
