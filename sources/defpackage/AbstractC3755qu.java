package defpackage;

/* JADX INFO: renamed from: qu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3755qu {
    public static final YS a = new YS("COMPLETING_ALREADY");
    public static final YS b = new YS("COMPLETING_WAITING_CHILDREN");
    public static final YS c = new YS("COMPLETING_RETRY");
    public static final YS d = new YS("TOO_LATE_TO_CANCEL");
    public static final YS e = new YS("SEALED");
    public static final C1045Xk f = new C1045Xk(false);
    public static final C1045Xk g = new C1045Xk(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC0377Bs ? new C0403Cs((InterfaceC0377Bs) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC0377Bs interfaceC0377Bs;
        C0403Cs c0403Cs = obj instanceof C0403Cs ? (C0403Cs) obj : null;
        return (c0403Cs == null || (interfaceC0377Bs = c0403Cs.a) == null) ? obj : interfaceC0377Bs;
    }
}
