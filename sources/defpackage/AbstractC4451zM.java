package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: zM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4451zM {
    public static volatile InterfaceC0777Np a;
    public static volatile InterfaceC0777Np b;

    public static Object a(InterfaceC0777Np interfaceC0777Np, Object obj) {
        try {
            return interfaceC0777Np.apply(obj);
        } catch (Throwable th) {
            throw AbstractC0722Ll.a(th);
        }
    }

    public static AN b(InterfaceC0777Np interfaceC0777Np, Callable callable) {
        AN an = (AN) a(interfaceC0777Np, callable);
        if (an != null) {
            return an;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static AN c(Callable callable) {
        try {
            AN an = (AN) callable.call();
            if (an != null) {
                return an;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw AbstractC0722Ll.a(th);
        }
    }

    public static AN d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC0777Np interfaceC0777Np = a;
        return interfaceC0777Np == null ? c(callable) : b(interfaceC0777Np, callable);
    }

    public static AN e(AN an) {
        if (an == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC0777Np interfaceC0777Np = b;
        return interfaceC0777Np == null ? an : (AN) a(interfaceC0777Np, an);
    }
}
