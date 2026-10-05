package defpackage;

import java.util.List;

/* JADX INFO: renamed from: kx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3268kx {
    public static final WB a(Throwable th, String str) throws Throwable {
        if (th != null) {
            throw th;
        }
        d();
        throw new C1182Zu();
    }

    public static /* synthetic */ WB b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(AbstractC2399hx abstractC2399hx) {
        return abstractC2399hx.G() instanceof WB;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final AbstractC2399hx e(InterfaceC3104ix interfaceC3104ix, List list) {
        try {
            return interfaceC3104ix.b(list);
        } catch (Throwable th) {
            return a(th, interfaceC3104ix.a());
        }
    }
}
