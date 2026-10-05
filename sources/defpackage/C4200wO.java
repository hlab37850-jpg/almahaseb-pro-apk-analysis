package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: wO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4200wO extends C4119vO {
    public final InterfaceC3750qp f;

    public C4200wO(Object obj, InterfaceC4293xa interfaceC4293xa, InterfaceC3750qp interfaceC3750qp) {
        super(obj, interfaceC4293xa);
        this.f = interfaceC3750qp;
    }

    @Override // defpackage.AbstractC3957tO
    public void B() throws IllegalAccessException, InvocationTargetException {
        OE.b(this.f, y(), this.e.getContext());
    }

    @Override // defpackage.C0533Fw
    public boolean s() throws IllegalAccessException, InvocationTargetException {
        if (!super.s()) {
            return false;
        }
        B();
        return true;
    }
}
