package defpackage;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: renamed from: Ye, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1081Ye extends EG {
    public static final a e;
    public static final boolean f;
    public final Provider d;

    /* JADX INFO: renamed from: Ye$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final boolean a(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i) {
                return version.major() > i;
            }
            if (version.minor() != i2) {
                return version.minor() > i2;
            }
            return version.patch() >= i3;
        }

        public final C1081Ye b() {
            AbstractC0419Di abstractC0419Di = null;
            if (c()) {
                return new C1081Ye(abstractC0419Di);
            }
            return null;
        }

        public final boolean c() {
            return C1081Ye.f;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: Ye$b */
    public static final class b implements ConscryptHostnameVerifier {
        public static final b a = new b();
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && aVar.a(2, 1, 0)) {
                z = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f = z;
    }

    public /* synthetic */ C1081Ye(AbstractC0419Di abstractC0419Di) {
        this();
    }

    @Override // defpackage.EG
    public void e(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.e(sSLSocket, str, list);
        } else {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) EG.a.b(list).toArray(new String[0]));
        }
    }

    @Override // defpackage.EG
    public String g(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.g(sSLSocket);
    }

    @Override // defpackage.EG
    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.d);
        AbstractC4492zt.g(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // defpackage.EG
    public SSLSocketFactory n(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        SSLContext sSLContextM = m();
        sSLContextM.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContextM.getSocketFactory();
        AbstractC4492zt.g(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // defpackage.EG
    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        AbstractC4492zt.e(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                AbstractC4492zt.f(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, b.a);
                return x509TrustManager;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        AbstractC4492zt.g(string, "toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public C1081Ye() {
        Provider providerNewProvider = Conscrypt.newProvider();
        AbstractC4492zt.g(providerNewProvider, "newProvider()");
        this.d = providerNewProvider;
    }
}
