package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public interface GC {

    public static final class a {
        public static /* synthetic */ Object a(GC gc, Object obj, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            return gc.c(obj, interfaceC0793Of);
        }

        public static /* synthetic */ boolean b(GC gc, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            return gc.a(obj);
        }

        public static /* synthetic */ void c(GC gc, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            gc.b(obj);
        }
    }

    boolean a(Object obj);

    void b(Object obj);

    Object c(Object obj, InterfaceC0793Of interfaceC0793Of);
}
