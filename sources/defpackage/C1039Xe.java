package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: Xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1039Xe {
    public final List a;
    public int b;
    public boolean c;
    public boolean d;

    public C1039Xe(List list) {
        AbstractC4492zt.h(list, "connectionSpecs");
        this.a = list;
    }

    public final C1013We a(SSLSocket sSLSocket) throws UnknownServiceException {
        C1013We c1013We;
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                c1013We = null;
                break;
            }
            c1013We = (C1013We) this.a.get(i);
            if (c1013We.e(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (c1013We != null) {
            this.c = c(sSLSocket);
            c1013We.c(sSLSocket, this.d);
            return c1013We;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.d);
        sb.append(", modes=");
        sb.append(this.a);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        AbstractC4492zt.e(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        AbstractC4492zt.g(string, "toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean b(IOException iOException) {
        AbstractC4492zt.h(iOException, "e");
        this.d = true;
        return (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }

    public final boolean c(SSLSocket sSLSocket) {
        int size = this.a.size();
        for (int i = this.b; i < size; i++) {
            if (((C1013We) this.a.get(i)).e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
