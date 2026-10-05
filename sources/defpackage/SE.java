package defpackage;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes3.dex */
public final class SE extends EG {
    public static final a e;
    public static final boolean f;
    public final Provider d;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final SE a() {
            AbstractC0419Di abstractC0419Di = null;
            if (b()) {
                return new SE(abstractC0419Di);
            }
            return null;
        }

        public final boolean b() {
            return SE.f;
        }

        public a() {
        }
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f = z;
    }

    public /* synthetic */ SE(AbstractC0419Di abstractC0419Di) {
        this();
    }

    @Override // defpackage.EG
    public void e(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        super.e(sSLSocket, str, list);
    }

    @Override // defpackage.EG
    public String g(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return super.g(sSLSocket);
    }

    @Override // defpackage.EG
    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.d);
        AbstractC4492zt.g(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // defpackage.EG
    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.d);
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

    public SE() {
        this.d = new OpenJSSE();
    }
}
