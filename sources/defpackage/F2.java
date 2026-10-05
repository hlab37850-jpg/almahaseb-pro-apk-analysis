package defpackage;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public final class F2 extends EG {
    public static final a e = new a(null);
    public static final boolean f;
    public final List d;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final EG a() {
            if (b()) {
                return new F2();
            }
            return null;
        }

        public final boolean b() {
            return F2.f;
        }

        public a() {
        }
    }

    static {
        f = EG.a.h() && Build.VERSION.SDK_INT >= 29;
    }

    public F2() {
        List listR = AbstractC1886cc.r(I2.a.a(), new C0961Ui(C1763b4.f.d()), new C0961Ui(C1166Ze.a.a()), new C0961Ui(C8.a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((WQ) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
    }

    @Override // defpackage.EG
    public AbstractC0927Ta c(X509TrustManager x509TrustManager) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        C3929t3 c3929t3A = C3929t3.d.a(x509TrustManager);
        return c3929t3A != null ? c3929t3A : super.c(x509TrustManager);
    }

    @Override // defpackage.EG
    public void e(SSLSocket sSLSocket, String str, List list) {
        Object next;
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        Iterator it = this.d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((WQ) next).a(sSLSocket));
        WQ wq = (WQ) next;
        if (wq != null) {
            wq.c(sSLSocket, str, list);
        }
    }

    @Override // defpackage.EG
    public String g(SSLSocket sSLSocket) {
        Object next;
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        Iterator it = this.d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((WQ) next).a(sSLSocket));
        WQ wq = (WQ) next;
        if (wq != null) {
            return wq.b(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.EG
    public boolean i(String str) {
        AbstractC4492zt.h(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
