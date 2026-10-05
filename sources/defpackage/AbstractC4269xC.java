package defpackage;

/* JADX INFO: renamed from: xC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4269xC extends BC implements InterfaceC0895Ru {
    public AbstractC4269xC(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0609Iu computeReflected() {
        return QJ.d(this);
    }

    @Override // defpackage.InterfaceC1003Vu
    public Object getDelegate() {
        return ((InterfaceC0895Ru) getReflected()).getDelegate();
    }

    @Override // defpackage.InterfaceC1003Vu
    /* JADX INFO: renamed from: getGetter */
    public InterfaceC1003Vu.a mo5460getGetter() {
        ((InterfaceC0895Ru) getReflected()).mo5460getGetter();
        return null;
    }

    @Override // defpackage.InterfaceC3588op
    public Object invoke() {
        return get();
    }
}
