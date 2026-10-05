package defpackage;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public final class W3 extends EG {
    public static final a f = new a(null);
    public static final boolean g;
    public final List d;
    public final C0616Jb e;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final EG a() {
            if (b()) {
                return new W3();
            }
            return null;
        }

        public final boolean b() {
            return W3.g;
        }

        public a() {
        }
    }

    public static final class b implements GV {
        public final X509TrustManager a;
        public final Method b;

        public b(X509TrustManager x509TrustManager, Method method) {
            AbstractC4492zt.h(x509TrustManager, "trustManager");
            AbstractC4492zt.h(method, "findByIssuerAndSignatureMethod");
            this.a = x509TrustManager;
            this.b = method;
        }

        @Override // defpackage.GV
        public X509Certificate a(X509Certificate x509Certificate) {
            AbstractC4492zt.h(x509Certificate, "cert");
            try {
                Object objInvoke = this.b.invoke(this.a, x509Certificate);
                AbstractC4492zt.f(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC4492zt.d(this.a, bVar.a) && AbstractC4492zt.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.a + ", findByIssuerAndSignatureMethod=" + this.b + ')';
        }
    }

    static {
        boolean z = false;
        if (EG.a.h() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        g = z;
    }

    public W3() {
        List listR = AbstractC1886cc.r(C4203wR.a.b(C4203wR.j, null, 1, null), new C0961Ui(C1763b4.f.d()), new C0961Ui(C1166Ze.a.a()), new C0961Ui(C8.a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((WQ) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
        this.e = C0616Jb.d.a();
    }

    @Override // defpackage.EG
    public AbstractC0927Ta c(X509TrustManager x509TrustManager) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        C3929t3 c3929t3A = C3929t3.d.a(x509TrustManager);
        return c3929t3A != null ? c3929t3A : super.c(x509TrustManager);
    }

    @Override // defpackage.EG
    public GV d(X509TrustManager x509TrustManager) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            AbstractC4492zt.g(declaredMethod, "method");
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
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
    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        AbstractC4492zt.h(socket, "socket");
        AbstractC4492zt.h(inetSocketAddress, HTML.Tag.ADDRESS);
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
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
    public Object h(String str) {
        AbstractC4492zt.h(str, "closer");
        return this.e.a(str);
    }

    @Override // defpackage.EG
    public boolean i(String str) {
        AbstractC4492zt.h(str, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i >= 23) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        return true;
    }

    @Override // defpackage.EG
    public void l(String str, Object obj) {
        AbstractC4492zt.h(str, "message");
        if (this.e.b(obj)) {
            return;
        }
        EG.k(this, str, 5, null, 4, null);
    }
}
