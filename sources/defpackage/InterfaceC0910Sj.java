package defpackage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: renamed from: Sj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0910Sj {
    public static final a a = a.a;
    public static final InterfaceC0910Sj b = new a.C0016a();

    /* JADX INFO: renamed from: Sj$a */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: Sj$a$a, reason: collision with other inner class name */
        public static final class C0016a implements InterfaceC0910Sj {
            @Override // defpackage.InterfaceC0910Sj
            public List a(String str) throws UnknownHostException {
                AbstractC4492zt.h(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    AbstractC4492zt.g(allByName, "getAllByName(hostname)");
                    return R5.l0(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }
    }

    List a(String str);
}
