package defpackage;

/* JADX INFO: renamed from: ie, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2457ie {
    public static final Object a(Object obj, InterfaceC0793Of interfaceC0793Of) {
        if (!(obj instanceof C2129ee)) {
            return KL.a(obj);
        }
        KL.a aVar = KL.a;
        return KL.a(LL.a(((C2129ee) obj).a));
    }

    public static final Object b(Object obj, InterfaceC4293xa interfaceC4293xa) {
        Throwable thB = KL.b(obj);
        return thB == null ? obj : new C2129ee(thB, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC3750qp interfaceC3750qp) {
        Throwable thB = KL.b(obj);
        if (thB == null) {
            return interfaceC3750qp != null ? new C2211fe(obj, interfaceC3750qp) : obj;
        }
        return new C2129ee(thB, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, InterfaceC3750qp interfaceC3750qp, int i, Object obj2) {
        if ((i & 1) != 0) {
            interfaceC3750qp = null;
        }
        return c(obj, interfaceC3750qp);
    }
}
