package defpackage;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: renamed from: gr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2311gr {
    public static final a e = new a(null);
    public final OU a;
    public final C0386Cb b;
    public final List c;
    public final InterfaceC3430mv d;

    /* JADX INFO: renamed from: gr$a */
    public static final class a {

        /* JADX INFO: renamed from: gr$a$a, reason: collision with other inner class name */
        public static final class C0285a extends AbstractC2233fv implements InterfaceC3588op {
            public final /* synthetic */ List a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0285a(List list) {
                super(0);
                this.a = list;
            }

            @Override // defpackage.InterfaceC3588op
            public final List invoke() {
                return this.a;
            }
        }

        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C2311gr a(SSLSession sSLSession) throws IOException {
            List listM;
            AbstractC4492zt.h(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (AbstractC4492zt.d(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : AbstractC4492zt.d(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            C0386Cb c0386CbB = C0386Cb.b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if (AbstractC4492zt.d("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            OU ouA = OU.b.a(protocol);
            try {
                listM = b(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listM = AbstractC1886cc.m();
            }
            return new C2311gr(ouA, c0386CbB, b(sSLSession.getLocalCertificates()), new C0285a(listM));
        }

        public final List b(Certificate[] certificateArr) {
            return certificateArr != null ? AbstractC3724qX.w(Arrays.copyOf(certificateArr, certificateArr.length)) : AbstractC1886cc.m();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: gr$b */
    public static final class b extends AbstractC2233fv implements InterfaceC3588op {
        public final /* synthetic */ InterfaceC3588op a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.a = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3588op
        public final List invoke() {
            try {
                return (List) this.a.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return AbstractC1886cc.m();
            }
        }
    }

    public C2311gr(OU ou, C0386Cb c0386Cb, List list, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(ou, "tlsVersion");
        AbstractC4492zt.h(c0386Cb, "cipherSuite");
        AbstractC4492zt.h(list, "localCertificates");
        AbstractC4492zt.h(interfaceC3588op, "peerCertificatesFn");
        this.a = ou;
        this.b = c0386Cb;
        this.c = list;
        this.d = AbstractC3756qv.a(new b(interfaceC3588op));
    }

    public final C0386Cb a() {
        return this.b;
    }

    public final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        AbstractC4492zt.g(type, "type");
        return type;
    }

    public final List c() {
        return this.c;
    }

    public final List d() {
        return (List) this.d.getValue();
    }

    public final OU e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2311gr) {
            C2311gr c2311gr = (C2311gr) obj;
            if (c2311gr.a == this.a && AbstractC4492zt.d(c2311gr.b, this.b) && AbstractC4492zt.d(c2311gr.d(), d()) && AbstractC4492zt.d(c2311gr.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((MetaDo.META_OFFSETWINDOWORG + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + d().hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        List listD = d();
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.a);
        sb.append(" cipherSuite=");
        sb.append(this.b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List list = this.c;
        ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
