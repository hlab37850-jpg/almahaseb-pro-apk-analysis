package defpackage;

import android.net.http.X509TrustManagerExtensions;
import com.itextpdf.text.pdf.security.SecurityConstants;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: renamed from: t3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3929t3 extends AbstractC0927Ta {
    public static final a d = new a(null);
    public final X509TrustManager b;
    public final X509TrustManagerExtensions c;

    /* JADX INFO: renamed from: t3$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C3929t3 a(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            AbstractC4492zt.h(x509TrustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new C3929t3(x509TrustManager, x509TrustManagerExtensions);
            }
            return null;
        }

        public a() {
        }
    }

    public C3929t3(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        AbstractC4492zt.h(x509TrustManager, "trustManager");
        AbstractC4492zt.h(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.b = x509TrustManager;
        this.c = x509TrustManagerExtensions;
    }

    @Override // defpackage.AbstractC0927Ta
    public List a(List list, String str) throws SSLPeerUnverifiedException {
        AbstractC4492zt.h(list, "chain");
        AbstractC4492zt.h(str, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.c.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), SecurityConstants.RSA, str);
            AbstractC4492zt.g(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3929t3) && ((C3929t3) obj).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }
}
