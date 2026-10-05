package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class C8 implements WQ {
    public static final b a = new b(null);
    public static final C0961Ui.a b = new a();

    public static final class a implements C0961Ui.a {
        @Override // defpackage.C0961Ui.a
        public boolean a(SSLSocket sSLSocket) {
            AbstractC4492zt.h(sSLSocket, "sslSocket");
            B8.e.b();
            return false;
        }

        @Override // defpackage.C0961Ui.a
        public WQ b(SSLSocket sSLSocket) {
            AbstractC4492zt.h(sSLSocket, "sslSocket");
            return new C8();
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C0961Ui.a a() {
            return C8.b;
        }

        public b() {
        }
    }

    @Override // defpackage.WQ
    public boolean a(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return false;
    }

    @Override // defpackage.WQ
    public String b(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : AbstractC4492zt.d(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.WQ
    public void c(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) EG.a.b(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }

    @Override // defpackage.WQ
    public boolean isSupported() {
        return B8.e.b();
    }
}
