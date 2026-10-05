package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public class EG {
    public static final a a;
    public static volatile EG b;
    public static final Logger c;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final List b(List list) {
            AbstractC4492zt.h(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((EnumC4356yI) obj) != EnumC4356yI.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((EnumC4356yI) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] c(List list) {
            AbstractC4492zt.h(list, "protocols");
            H8 h8 = new H8();
            for (String str : b(list)) {
                h8.writeByte(str.length());
                h8.l(str);
            }
            return h8.J();
        }

        public final EG d() {
            S3.a.b();
            EG egA = F2.e.a();
            if (egA != null) {
                return egA;
            }
            EG egA2 = W3.f.a();
            AbstractC4492zt.e(egA2);
            return egA2;
        }

        public final EG e() {
            SE seA;
            B8 b8A;
            C1081Ye c1081YeB;
            if (j() && (c1081YeB = C1081Ye.e.b()) != null) {
                return c1081YeB;
            }
            if (i() && (b8A = B8.e.a()) != null) {
                return b8A;
            }
            if (k() && (seA = SE.e.a()) != null) {
                return seA;
            }
            C1096Yt c1096YtA = C1096Yt.d.a();
            if (c1096YtA != null) {
                return c1096YtA;
            }
            EG egA = C1002Vt.i.a();
            return egA != null ? egA : new EG();
        }

        public final EG f() {
            return h() ? d() : e();
        }

        public final EG g() {
            return EG.b;
        }

        public final boolean h() {
            return AbstractC4492zt.d("Dalvik", System.getProperty("java.vm.name"));
        }

        public final boolean i() {
            return AbstractC4492zt.d("BC", Security.getProviders()[0].getName());
        }

        public final boolean j() {
            return AbstractC4492zt.d("Conscrypt", Security.getProviders()[0].getName());
        }

        public final boolean k() {
            return AbstractC4492zt.d("OpenJSSE", Security.getProviders()[0].getName());
        }

        public a() {
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        b = aVar.f();
        c = Logger.getLogger(C4271xE.class.getName());
    }

    public static /* synthetic */ void k(EG eg, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        eg.j(str, i, th);
    }

    public void b(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
    }

    public AbstractC0927Ta c(X509TrustManager x509TrustManager) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        return new C3532o7(d(x509TrustManager));
    }

    public GV d(X509TrustManager x509TrustManager) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        AbstractC4492zt.g(acceptedIssuers, "trustManager.acceptedIssuers");
        return new C4018u7((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        AbstractC4492zt.h(socket, "socket");
        AbstractC4492zt.h(inetSocketAddress, HTML.Tag.ADDRESS);
        socket.connect(inetSocketAddress, i);
    }

    public String g(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return null;
    }

    public Object h(String str) {
        AbstractC4492zt.h(str, "closer");
        if (c.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean i(String str) {
        AbstractC4492zt.h(str, "hostname");
        return true;
    }

    public void j(String str, int i, Throwable th) {
        AbstractC4492zt.h(str, "message");
        c.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void l(String str, Object obj) {
        AbstractC4492zt.h(str, "message");
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        j(str, 5, (Throwable) obj);
    }

    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        AbstractC4492zt.g(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextM = m();
            sSLContextM.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextM.getSocketFactory();
            AbstractC4492zt.g(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        AbstractC4492zt.e(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                AbstractC4492zt.f(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        AbstractC4492zt.g(string, "toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        AbstractC4492zt.g(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
