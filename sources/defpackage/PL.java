package defpackage;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes3.dex */
public final class PL implements InterfaceC3996tt {
    public static final a b = new a(null);
    public final C4271xE a;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public PL(C4271xE c4271xE) {
        AbstractC4492zt.h(c4271xE, "client");
        this.a = c4271xE;
    }

    @Override // defpackage.InterfaceC3996tt
    public EL a(InterfaceC3996tt.a aVar) {
        AbstractC4492zt.h(aVar, "chain");
        EJ ej = (EJ) aVar;
        C3873sL c3873sLI = ej.i();
        BJ bjE = ej.e();
        List listM = AbstractC1886cc.m();
        EL el = null;
        boolean z = true;
        int i = 0;
        while (true) {
            bjE.i(c3873sLI, z);
            try {
                if (bjE.s()) {
                    throw new IOException("Canceled");
                }
                try {
                    EL elA = ej.a(c3873sLI);
                    if (el != null) {
                        elA = elA.G().o(el.G().b(null).c()).c();
                    }
                    el = elA;
                    C0799Ol c0799OlO = bjE.o();
                    C3873sL c3873sLC = c(el, c0799OlO);
                    if (c3873sLC == null) {
                        if (c0799OlO != null && c0799OlO.m()) {
                            bjE.z();
                        }
                        bjE.j(false);
                        return el;
                    }
                    AbstractC3954tL abstractC3954tLA = c3873sLC.a();
                    if (abstractC3954tLA != null && abstractC3954tLA.e()) {
                        bjE.j(false);
                        return el;
                    }
                    FL flC = el.c();
                    if (flC != null) {
                        AbstractC3724qX.m(flC);
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                    bjE.j(true);
                    c3873sLI = c3873sLC;
                    z = true;
                } catch (IOException e) {
                    if (!e(e, bjE, c3873sLI, !(e instanceof C0987Ve))) {
                        throw AbstractC3724qX.a0(e, listM);
                    }
                    listM = AbstractC3240kc.q0(listM, e);
                    bjE.j(true);
                    z = false;
                } catch (C3713qM e2) {
                    if (!e(e2.c(), bjE, c3873sLI, false)) {
                        throw AbstractC3724qX.a0(e2.b(), listM);
                    }
                    listM = AbstractC3240kc.q0(listM, e2.b());
                    bjE.j(true);
                    z = false;
                }
            } catch (Throwable th) {
                bjE.j(true);
                throw th;
            }
        }
    }

    public final C3873sL b(EL el, String str) {
        String strX;
        C0779Nr c0779NrP;
        if (!this.a.s() || (strX = EL.x(el, HttpHeaders.LOCATION, null, 2, null)) == null || (c0779NrP = el.K().i().p(strX)) == null) {
            return null;
        }
        if (!AbstractC4492zt.d(c0779NrP.q(), el.K().i().q()) && !this.a.t()) {
            return null;
        }
        C3873sL.a aVarH = el.K().h();
        if (C0702Kr.a(str)) {
            int iR = el.r();
            C0702Kr c0702Kr = C0702Kr.a;
            boolean z = c0702Kr.c(str) || iR == 308 || iR == 307;
            if (!c0702Kr.b(str) || iR == 308 || iR == 307) {
                aVarH.e(str, z ? el.K().a() : null);
            } else {
                aVarH.e(HttpMethods.GET, null);
            }
            if (!z) {
                aVarH.f(HttpHeaders.TRANSFER_ENCODING);
                aVarH.f(HttpHeaders.CONTENT_LENGTH);
                aVarH.f(HttpHeaders.CONTENT_TYPE);
            }
        }
        if (!AbstractC3724qX.j(el.K().i(), c0779NrP)) {
            aVarH.f(HttpHeaders.AUTHORIZATION);
        }
        return aVarH.g(c0779NrP).b();
    }

    public final C3873sL c(EL el, C0799Ol c0799Ol) throws ProtocolException {
        CJ cjH;
        C3550oM c3550oMA = (c0799Ol == null || (cjH = c0799Ol.h()) == null) ? null : cjH.A();
        int iR = el.r();
        String strG = el.K().g();
        if (iR != 307 && iR != 308) {
            if (iR == 401) {
                return this.a.g().a(c3550oMA, el);
            }
            if (iR == 421) {
                AbstractC3954tL abstractC3954tLA = el.K().a();
                if ((abstractC3954tLA != null && abstractC3954tLA.e()) || c0799Ol == null || !c0799Ol.l()) {
                    return null;
                }
                c0799Ol.h().y();
                return el.K();
            }
            if (iR == 503) {
                EL elH = el.H();
                if ((elH == null || elH.r() != 503) && g(el, Integer.MAX_VALUE) == 0) {
                    return el.K();
                }
                return null;
            }
            if (iR == 407) {
                AbstractC4492zt.e(c3550oMA);
                if (c3550oMA.b().type() == Proxy.Type.HTTP) {
                    return this.a.D().a(c3550oMA, el);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iR == 408) {
                if (!this.a.G()) {
                    return null;
                }
                AbstractC3954tL abstractC3954tLA2 = el.K().a();
                if (abstractC3954tLA2 != null && abstractC3954tLA2.e()) {
                    return null;
                }
                EL elH2 = el.H();
                if ((elH2 == null || elH2.r() != 408) && g(el, 0) <= 0) {
                    return el.K();
                }
                return null;
            }
            switch (iR) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return b(el, strG);
    }

    public final boolean d(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean e(IOException iOException, BJ bj, C3873sL c3873sL, boolean z) {
        if (this.a.G()) {
            return !(z && f(iOException, c3873sL)) && d(iOException, z) && bj.x();
        }
        return false;
    }

    public final boolean f(IOException iOException, C3873sL c3873sL) {
        AbstractC3954tL abstractC3954tLA = c3873sL.a();
        return (abstractC3954tLA != null && abstractC3954tLA.e()) || (iOException instanceof FileNotFoundException);
    }

    public final int g(EL el, int i) {
        String strX = EL.x(el, HttpHeaders.RETRY_AFTER, null, 2, null);
        if (strX == null) {
            return i;
        }
        if (!new SJ("\\d+").c(strX)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strX);
        AbstractC4492zt.g(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }
}
