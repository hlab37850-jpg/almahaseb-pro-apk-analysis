package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: renamed from: Ze, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1166Ze implements WQ {
    public static final b a = new b(null);
    public static final C0961Ui.a b = new a();

    /* JADX INFO: renamed from: Ze$a */
    public static final class a implements C0961Ui.a {
        @Override // defpackage.C0961Ui.a
        public boolean a(SSLSocket sSLSocket) {
            AbstractC4492zt.h(sSLSocket, "sslSocket");
            return C1081Ye.e.c() && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // defpackage.C0961Ui.a
        public WQ b(SSLSocket sSLSocket) {
            AbstractC4492zt.h(sSLSocket, "sslSocket");
            return new C1166Ze();
        }
    }

    /* JADX INFO: renamed from: Ze$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C0961Ui.a a() {
            return C1166Ze.b;
        }

        public b() {
        }
    }

    @Override // defpackage.WQ
    public boolean a(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.WQ
    public String b(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.WQ
    public void c(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) EG.a.b(list).toArray(new String[0]));
        }
    }

    @Override // defpackage.WQ
    public boolean isSupported() {
        return C1081Ye.e.c();
    }
}
