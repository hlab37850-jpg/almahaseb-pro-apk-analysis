package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: jx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3186jx {
    public static final C3186jx a;
    public static final AbstractC2399hx b;

    static {
        C3186jx c3186jx = new C3186jx();
        a = c3186jx;
        AbstractC3557oT.e("kotlinx.coroutines.fast.service.loader", true);
        b = c3186jx.a();
    }

    public final AbstractC2399hx a() {
        Object next;
        AbstractC2399hx abstractC2399hxE;
        try {
            List listV = FO.v(DO.c(ServiceLoader.load(InterfaceC3104ix.class, InterfaceC3104ix.class.getClassLoader()).iterator()));
            Iterator it = listV.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((InterfaceC3104ix) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((InterfaceC3104ix) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            InterfaceC3104ix interfaceC3104ix = (InterfaceC3104ix) next;
            if (interfaceC3104ix != null && (abstractC2399hxE = AbstractC3268kx.e(interfaceC3104ix, listV)) != null) {
                return abstractC2399hxE;
            }
            return AbstractC3268kx.b(null, null, 3, null);
        } catch (Throwable th) {
            return AbstractC3268kx.b(th, null, 2, null);
        }
    }
}
