package defpackage;

/* JADX INFO: renamed from: xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC4293xa extends InterfaceC0793Of {

    /* JADX INFO: renamed from: xa$a */
    public static final class a {
        public static /* synthetic */ boolean a(InterfaceC4293xa interfaceC4293xa, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return interfaceC4293xa.m(th);
        }

        public static /* synthetic */ Object b(InterfaceC4293xa interfaceC4293xa, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i & 2) != 0) {
                obj2 = null;
            }
            return interfaceC4293xa.a(obj, obj2);
        }
    }

    Object a(Object obj, Object obj2);

    void e(InterfaceC3750qp interfaceC3750qp);

    void h(AbstractC1040Xf abstractC1040Xf, Object obj);

    boolean isActive();

    Object j(Throwable th);

    void k(Object obj, InterfaceC3750qp interfaceC3750qp);

    boolean m(Throwable th);

    Object n(Object obj, Object obj2, InterfaceC3750qp interfaceC3750qp);

    void o(Object obj);
}
