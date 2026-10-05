package defpackage;

/* JADX INFO: renamed from: ni, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3498ni {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(InterfaceC0793Of interfaceC0793Of) {
        Object objA;
        if (interfaceC0793Of instanceof C3986tj) {
            return interfaceC0793Of.toString();
        }
        try {
            KL.a aVar = KL.a;
            objA = KL.a(interfaceC0793Of + '@' + b(interfaceC0793Of));
        } catch (Throwable th) {
            KL.a aVar2 = KL.a;
            objA = KL.a(LL.a(th));
        }
        if (KL.b(objA) != null) {
            objA = interfaceC0793Of.getClass().getName() + '@' + b(interfaceC0793Of);
        }
        return (String) objA;
    }
}
