package defpackage;

/* JADX INFO: renamed from: zC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4441zC extends BC implements InterfaceC0921Su {
    public AbstractC4441zC(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0609Iu computeReflected() {
        return QJ.e(this);
    }

    @Override // defpackage.InterfaceC1029Wu
    public Object getDelegate(Object obj) {
        return ((InterfaceC0921Su) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ InterfaceC0977Uu.a getGetter() {
        mo5461getGetter();
        return null;
    }

    public /* bridge */ /* synthetic */ InterfaceC0869Qu getSetter() {
        mo5462getSetter();
        return null;
    }

    @Override // defpackage.InterfaceC3750qp
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // defpackage.InterfaceC1029Wu
    /* JADX INFO: renamed from: getGetter */
    public InterfaceC1029Wu.a mo5461getGetter() {
        ((InterfaceC0921Su) getReflected()).mo5461getGetter();
        return null;
    }

    @Override // defpackage.InterfaceC0921Su
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public InterfaceC0921Su.a mo5462getSetter() {
        ((InterfaceC0921Su) getReflected()).mo5462getSetter();
        return null;
    }
}
