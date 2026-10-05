package defpackage;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: renamed from: Ua, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0953Ua {
    public static final b c = new b(null);
    public static final C0953Ua d = new a().a();
    public final Set a;
    public final AbstractC0927Ta b;

    /* JADX INFO: renamed from: Ua$a */
    public static final class a {
        public final List a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final C0953Ua a() {
            return new C0953Ua(AbstractC3240kc.H0(this.a), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: Ua$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final String a(Certificate certificate) {
            AbstractC4492zt.h(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + b((X509Certificate) certificate).a();
        }

        public final W8 b(X509Certificate x509Certificate) {
            AbstractC4492zt.h(x509Certificate, "<this>");
            W8.a aVar = W8.d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            AbstractC4492zt.g(encoded, "publicKey.encoded");
            return W8.a.f(aVar, encoded, 0, 0, 3, null).t();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: Ua$c */
    public static final class c extends AbstractC2233fv implements InterfaceC3588op {
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, String str) {
            super(0);
            this.b = list;
            this.c = str;
        }

        @Override // defpackage.InterfaceC3588op
        public final List invoke() {
            List listA;
            AbstractC0927Ta abstractC0927TaD = C0953Ua.this.d();
            if (abstractC0927TaD == null || (listA = abstractC0927TaD.a(this.b, this.c)) == null) {
                listA = this.b;
            }
            List<Certificate> list = listA;
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list, 10));
            for (Certificate certificate : list) {
                AbstractC4492zt.f(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public C0953Ua(Set set, AbstractC0927Ta abstractC0927Ta) {
        AbstractC4492zt.h(set, "pins");
        this.a = set;
        this.b = abstractC0927Ta;
    }

    public final void a(String str, List list) {
        AbstractC4492zt.h(str, "hostname");
        AbstractC4492zt.h(list, "peerCertificates");
        b(str, new c(list, str));
    }

    public final void b(String str, InterfaceC3588op interfaceC3588op) throws SSLPeerUnverifiedException {
        AbstractC4492zt.h(str, "hostname");
        AbstractC4492zt.h(interfaceC3588op, "cleanedPeerCertificatesFn");
        List listC = c(str);
        if (listC.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) interfaceC3588op.invoke();
        for (X509Certificate x509Certificate : list) {
            Iterator it = listC.iterator();
            if (it.hasNext()) {
                AbstractC3574of.a(it.next());
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(c.a(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        Iterator it2 = listC.iterator();
        while (it2.hasNext()) {
            AbstractC3574of.a(it2.next());
            sb.append("\n    ");
            sb.append((Object) null);
        }
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List c(String str) {
        AbstractC4492zt.h(str, "hostname");
        Set set = this.a;
        List listM = AbstractC1886cc.m();
        Iterator it = set.iterator();
        if (!it.hasNext()) {
            return listM;
        }
        AbstractC3574of.a(it.next());
        throw null;
    }

    public final AbstractC0927Ta d() {
        return this.b;
    }

    public final C0953Ua e(AbstractC0927Ta abstractC0927Ta) {
        AbstractC4492zt.h(abstractC0927Ta, "certificateChainCleaner");
        return AbstractC4492zt.d(this.b, abstractC0927Ta) ? this : new C0953Ua(this.a, abstractC0927Ta);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0953Ua) {
            C0953Ua c0953Ua = (C0953Ua) obj;
            if (AbstractC4492zt.d(c0953Ua.a, this.a) && AbstractC4492zt.d(c0953Ua.b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.a.hashCode()) * 41;
        AbstractC0927Ta abstractC0927Ta = this.b;
        return iHashCode + (abstractC0927Ta != null ? abstractC0927Ta.hashCode() : 0);
    }

    public /* synthetic */ C0953Ua(Set set, AbstractC0927Ta abstractC0927Ta, int i, AbstractC0419Di abstractC0419Di) {
        this(set, (i & 2) != 0 ? null : abstractC0927Ta);
    }
}
