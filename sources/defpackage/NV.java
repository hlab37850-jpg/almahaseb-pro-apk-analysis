package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NV {
    public static Collection a(Object obj) {
        if ((obj instanceof InterfaceC0756Mu) && !(obj instanceof InterfaceC0782Nu)) {
            n(obj, "kotlin.collections.MutableCollection");
        }
        return e(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof InterfaceC0756Mu) && !(obj instanceof InterfaceC0808Ou)) {
            n(obj, "kotlin.collections.MutableIterable");
        }
        return f(obj);
    }

    public static Map c(Object obj) {
        if ((obj instanceof InterfaceC0756Mu) && !(obj instanceof InterfaceC0834Pu)) {
            n(obj, "kotlin.collections.MutableMap");
        }
        return g(obj);
    }

    public static Object d(Object obj, int i) {
        if (obj != null && !i(obj, i)) {
            n(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Collection e(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static Iterable f(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static Map g(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static int h(Object obj) {
        if (obj instanceof InterfaceC0829Pp) {
            return ((InterfaceC0829Pp) obj).getArity();
        }
        if (obj instanceof InterfaceC3588op) {
            return 0;
        }
        if (obj instanceof InterfaceC3750qp) {
            return 1;
        }
        if (obj instanceof InterfaceC0526Fp) {
            return 2;
        }
        if (obj instanceof InterfaceC0552Gp) {
            return 3;
        }
        if (obj instanceof InterfaceC0578Hp) {
            return 4;
        }
        if (obj instanceof InterfaceC0604Ip) {
            return 5;
        }
        if (obj instanceof InterfaceC0630Jp) {
            return 6;
        }
        if (obj instanceof InterfaceC0700Kp) {
            return 7;
        }
        if (obj instanceof InterfaceC0726Lp) {
            return 8;
        }
        if (obj instanceof InterfaceC0751Mp) {
            return 9;
        }
        if (obj instanceof InterfaceC3669pp) {
            return 10;
        }
        if (obj instanceof InterfaceC3830rp) {
            return 11;
        }
        if (obj instanceof InterfaceC3992tp) {
            return 13;
        }
        if (obj instanceof InterfaceC4073up) {
            return 14;
        }
        if (obj instanceof InterfaceC4154vp) {
            return 15;
        }
        if (obj instanceof InterfaceC4235wp) {
            return 16;
        }
        if (obj instanceof InterfaceC4316xp) {
            return 17;
        }
        if (obj instanceof InterfaceC4407yp) {
            return 18;
        }
        if (obj instanceof InterfaceC4488zp) {
            return 19;
        }
        if (obj instanceof InterfaceC0374Bp) {
            return 20;
        }
        return obj instanceof InterfaceC0400Cp ? 21 : -1;
    }

    public static boolean i(Object obj, int i) {
        return (obj instanceof InterfaceC0348Ap) && h(obj) == i;
    }

    public static boolean j(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof InterfaceC0756Mu) || (obj instanceof InterfaceC0834Pu.a));
    }

    public static boolean k(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof InterfaceC0756Mu) || (obj instanceof InterfaceC0947Tu));
    }

    public static Throwable l(Throwable th) {
        return AbstractC4492zt.o(th, NV.class.getName());
    }

    public static ClassCastException m(ClassCastException classCastException) {
        throw ((ClassCastException) l(classCastException));
    }

    public static void n(Object obj, String str) {
        o((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void o(String str) {
        throw m(new ClassCastException(str));
    }
}
