package defpackage;

/* JADX INFO: renamed from: uO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC4038uO {

    /* JADX INFO: renamed from: uO$a */
    public static final class a {
        public static /* synthetic */ boolean a(InterfaceC4038uO interfaceC4038uO, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return interfaceC4038uO.close(th);
        }

        public static boolean b(InterfaceC4038uO interfaceC4038uO, Object obj) throws Throwable {
            Object objMo0trySendJP2dKIU = interfaceC4038uO.mo0trySendJP2dKIU(obj);
            if (C2451ib.j(objMo0trySendJP2dKIU)) {
                return true;
            }
            Throwable thE = C2451ib.e(objMo0trySendJP2dKIU);
            if (thE == null) {
                return false;
            }
            throw AbstractC4041uR.a(thE);
        }
    }

    boolean close(Throwable th);

    InterfaceC3552oO getOnSend();

    void invokeOnClose(InterfaceC3750qp interfaceC3750qp);

    boolean isClosedForSend();

    boolean offer(Object obj);

    Object send(Object obj, InterfaceC0793Of interfaceC0793Of);

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    Object mo0trySendJP2dKIU(Object obj);
}
