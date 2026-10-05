package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: renamed from: Hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0584Hv extends B {
    public C0584Hv(InterfaceC3750qp interfaceC3750qp) {
        super(interfaceC3750qp);
    }

    @Override // defpackage.B
    public final boolean E() {
        return true;
    }

    @Override // defpackage.B
    public final boolean F() {
        return true;
    }

    @Override // defpackage.B
    public void I(Object obj, C0737Mb c0737Mb) throws IllegalAccessException, InvocationTargetException {
        C3965tW c3965tWC = null;
        if (obj != null) {
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                C3965tW c3965tWC2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    AbstractC3957tO abstractC3957tO = (AbstractC3957tO) arrayList.get(size);
                    if (abstractC3957tO instanceof AbstractC3108j0.a) {
                        InterfaceC3750qp interfaceC3750qp = this.a;
                        c3965tWC2 = interfaceC3750qp != null ? OE.c(interfaceC3750qp, ((AbstractC3108j0.a) abstractC3957tO).d, c3965tWC2) : null;
                    } else {
                        abstractC3957tO.z(c0737Mb);
                    }
                }
                c3965tWC = c3965tWC2;
            } else {
                AbstractC3957tO abstractC3957tO2 = (AbstractC3957tO) obj;
                if (abstractC3957tO2 instanceof AbstractC3108j0.a) {
                    InterfaceC3750qp interfaceC3750qp2 = this.a;
                    if (interfaceC3750qp2 != null) {
                        c3965tWC = OE.c(interfaceC3750qp2, ((AbstractC3108j0.a) abstractC3957tO2).d, null);
                    }
                } else {
                    abstractC3957tO2.z(c0737Mb);
                }
            }
        }
        if (c3965tWC != null) {
            throw c3965tWC;
        }
    }

    @Override // defpackage.AbstractC3108j0
    public final boolean q() {
        return false;
    }

    @Override // defpackage.AbstractC3108j0
    public final boolean r() {
        return false;
    }

    @Override // defpackage.AbstractC3108j0
    public Object t(Object obj) {
        JJ jjV;
        do {
            Object objT = super.t(obj);
            YS ys = C.b;
            if (objT == ys) {
                return ys;
            }
            if (objT != C.c) {
                if (objT instanceof C0737Mb) {
                    return objT;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + objT).toString());
            }
            jjV = v(obj);
            if (jjV == null) {
                return ys;
            }
        } while (!(jjV instanceof C0737Mb));
        return jjV;
    }
}
