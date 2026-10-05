package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: Ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0961Ui implements WQ {
    public final a a;
    public WQ b;

    /* JADX INFO: renamed from: Ui$a */
    public interface a {
        boolean a(SSLSocket sSLSocket);

        WQ b(SSLSocket sSLSocket);
    }

    public C0961Ui(a aVar) {
        AbstractC4492zt.h(aVar, "socketAdapterFactory");
        this.a = aVar;
    }

    @Override // defpackage.WQ
    public boolean a(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return this.a.a(sSLSocket);
    }

    @Override // defpackage.WQ
    public String b(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        WQ wqD = d(sSLSocket);
        if (wqD != null) {
            return wqD.b(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.WQ
    public void c(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        WQ wqD = d(sSLSocket);
        if (wqD != null) {
            wqD.c(sSLSocket, str, list);
        }
    }

    public final synchronized WQ d(SSLSocket sSLSocket) {
        try {
            if (this.b == null && this.a.a(sSLSocket)) {
                this.b = this.a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // defpackage.WQ
    public boolean isSupported() {
        return true;
    }
}
