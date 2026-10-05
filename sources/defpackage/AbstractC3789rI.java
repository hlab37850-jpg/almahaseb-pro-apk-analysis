package defpackage;

/* JADX INFO: renamed from: rI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3789rI extends AbstractC3951tI implements InterfaceC1029Wu {
    public AbstractC3789rI(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0609Iu computeReflected() {
        return QJ.g(this);
    }

    @Override // defpackage.InterfaceC1029Wu
    public Object getDelegate(Object obj) {
        return ((InterfaceC1029Wu) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ InterfaceC0977Uu.a getGetter() {
        mo5461getGetter();
        return null;
    }

    @Override // defpackage.InterfaceC3750qp
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // defpackage.InterfaceC1029Wu
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public InterfaceC1029Wu.a mo5461getGetter() {
        ((InterfaceC1029Wu) getReflected()).mo5461getGetter();
        return null;
    }
}
