package defpackage;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: Yt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1096Yt extends EG {
    public static final a d = new a(0 == true ? 1 : 0);
    public static final boolean e;

    /* JADX INFO: renamed from: Yt$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C1096Yt a() {
            if (b()) {
                return new C1096Yt();
            }
            return null;
        }

        public final boolean b() {
            return C1096Yt.e;
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String property = System.getProperty("java.specification.version");
        Integer numI = property != null ? AbstractC3799rS.i(property) : null;
        boolean z = true;
        if (numI == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
                z = false;
            }
        } else if (numI.intValue() < 9) {
            z = false;
        }
        e = z;
    }

    @Override // defpackage.EG
    public void e(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        sSLParameters.setApplicationProtocols((String[]) EG.a.b(list).toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // defpackage.EG
    public String g(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : AbstractC4492zt.d(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
