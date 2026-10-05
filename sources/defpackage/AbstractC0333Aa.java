package defpackage;

/* JADX INFO: renamed from: Aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0333Aa {
    public static final void a(InterfaceC4293xa interfaceC4293xa, InterfaceC0745Mj interfaceC0745Mj) {
        interfaceC4293xa.e(new C0797Oj(interfaceC0745Mj));
    }

    public static final C4374ya b(InterfaceC0793Of interfaceC0793Of) {
        if (!(interfaceC0793Of instanceof C3986tj)) {
            return new C4374ya(interfaceC0793Of, 1);
        }
        C4374ya c4374yaP = ((C3986tj) interfaceC0793Of).p();
        if (c4374yaP != null) {
            if (!c4374yaP.J()) {
                c4374yaP = null;
            }
            if (c4374yaP != null) {
                return c4374yaP;
            }
        }
        return new C4374ya(interfaceC0793Of, 2);
    }

    public static final void c(InterfaceC4293xa interfaceC4293xa, C0533Fw c0533Fw) {
        interfaceC4293xa.e(new C1219aK(c0533Fw));
    }
}
