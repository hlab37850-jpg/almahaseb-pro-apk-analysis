package defpackage;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: renamed from: wE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4190wE implements HostnameVerifier {
    public static final C4190wE a = new C4190wE();

    public final List a(X509Certificate x509Certificate) {
        AbstractC4492zt.h(x509Certificate, "certificate");
        return AbstractC3240kc.p0(c(x509Certificate, 7), c(x509Certificate, 2));
    }

    public final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale locale = Locale.US;
        AbstractC4492zt.g(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final List c(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return AbstractC1886cc.m();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && AbstractC4492zt.d(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return AbstractC1886cc.m();
        }
    }

    public final boolean d(String str) {
        return str.length() == ((int) AbstractC3315lX.b(str, 0, 0, 3, null));
    }

    public final boolean e(String str, X509Certificate x509Certificate) {
        AbstractC4492zt.h(str, "host");
        AbstractC4492zt.h(x509Certificate, "certificate");
        return AbstractC3724qX.i(str) ? h(str, x509Certificate) : g(str, x509Certificate);
    }

    public final boolean f(String str, String str2) {
        if (str != null && str.length() != 0 && !AbstractC3880sS.B(str, ".", false, 2, null) && !AbstractC3880sS.p(str, "..", false, 2, null) && str2 != null && str2.length() != 0 && !AbstractC3880sS.B(str2, ".", false, 2, null) && !AbstractC3880sS.p(str2, "..", false, 2, null)) {
            if (!AbstractC3880sS.p(str, ".", false, 2, null)) {
                str = str + '.';
            }
            String str3 = str;
            if (!AbstractC3880sS.p(str2, ".", false, 2, null)) {
                str2 = str2 + '.';
            }
            String strB = b(str2);
            if (!AbstractC3961tS.G(strB, "*", false, 2, null)) {
                return AbstractC4492zt.d(str3, strB);
            }
            if (!AbstractC3880sS.B(strB, "*.", false, 2, null) || AbstractC3961tS.Q(strB, '*', 1, false, 4, null) != -1 || str3.length() < strB.length() || AbstractC4492zt.d("*.", strB)) {
                return false;
            }
            String strSubstring = strB.substring(1);
            AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!AbstractC3880sS.p(str3, strSubstring, false, 2, null)) {
                return false;
            }
            int length = str3.length() - strSubstring.length();
            return length <= 0 || AbstractC3961tS.W(str3, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }

    public final boolean g(String str, X509Certificate x509Certificate) {
        String strB = b(str);
        List listC = c(x509Certificate, 2);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (a.f(strB, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(String str, X509Certificate x509Certificate) {
        String strE = AbstractC4409yr.e(str);
        List listC = c(x509Certificate, 7);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (AbstractC4492zt.d(strE, AbstractC4409yr.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        AbstractC4492zt.h(str, "host");
        AbstractC4492zt.h(sSLSession, "session");
        if (!d(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            AbstractC4492zt.f(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return e(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }
}
