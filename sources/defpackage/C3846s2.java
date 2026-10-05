package defpackage;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: renamed from: s2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3846s2 {
    public final InterfaceC0910Sj a;
    public final SocketFactory b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final C0953Ua e;
    public final InterfaceC2087e6 f;
    public final Proxy g;
    public final ProxySelector h;
    public final C0779Nr i;
    public final List j;
    public final List k;

    public C3846s2(String str, int i, InterfaceC0910Sj interfaceC0910Sj, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C0953Ua c0953Ua, InterfaceC2087e6 interfaceC2087e6, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        AbstractC4492zt.h(str, "uriHost");
        AbstractC4492zt.h(interfaceC0910Sj, "dns");
        AbstractC4492zt.h(socketFactory, "socketFactory");
        AbstractC4492zt.h(interfaceC2087e6, "proxyAuthenticator");
        AbstractC4492zt.h(list, "protocols");
        AbstractC4492zt.h(list2, "connectionSpecs");
        AbstractC4492zt.h(proxySelector, "proxySelector");
        this.a = interfaceC0910Sj;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = c0953Ua;
        this.f = interfaceC2087e6;
        this.g = proxy;
        this.h = proxySelector;
        this.i = new C0779Nr.a().o(sSLSocketFactory != null ? "https" : "http").e(str).k(i).a();
        this.j = AbstractC3724qX.U(list);
        this.k = AbstractC3724qX.U(list2);
    }

    public final C0953Ua a() {
        return this.e;
    }

    public final List b() {
        return this.k;
    }

    public final InterfaceC0910Sj c() {
        return this.a;
    }

    public final boolean d(C3846s2 c3846s2) {
        AbstractC4492zt.h(c3846s2, "that");
        return AbstractC4492zt.d(this.a, c3846s2.a) && AbstractC4492zt.d(this.f, c3846s2.f) && AbstractC4492zt.d(this.j, c3846s2.j) && AbstractC4492zt.d(this.k, c3846s2.k) && AbstractC4492zt.d(this.h, c3846s2.h) && AbstractC4492zt.d(this.g, c3846s2.g) && AbstractC4492zt.d(this.c, c3846s2.c) && AbstractC4492zt.d(this.d, c3846s2.d) && AbstractC4492zt.d(this.e, c3846s2.e) && this.i.m() == c3846s2.i.m();
    }

    public final HostnameVerifier e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3846s2) {
            C3846s2 c3846s2 = (C3846s2) obj;
            if (AbstractC4492zt.d(this.i, c3846s2.i) && d(c3846s2)) {
                return true;
            }
        }
        return false;
    }

    public final List f() {
        return this.j;
    }

    public final Proxy g() {
        return this.g;
    }

    public final InterfaceC2087e6 h() {
        return this.f;
    }

    public int hashCode() {
        return ((((((((((((((((((MetaDo.META_OFFSETWINDOWORG + this.i.hashCode()) * 31) + this.a.hashCode()) * 31) + this.f.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.h.hashCode()) * 31) + Objects.hashCode(this.g)) * 31) + Objects.hashCode(this.c)) * 31) + Objects.hashCode(this.d)) * 31) + Objects.hashCode(this.e);
    }

    public final ProxySelector i() {
        return this.h;
    }

    public final SocketFactory j() {
        return this.b;
    }

    public final SSLSocketFactory k() {
        return this.c;
    }

    public final C0779Nr l() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.i.h());
        sb2.append(':');
        sb2.append(this.i.m());
        sb2.append(", ");
        if (this.g != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.g;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.h;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append('}');
        return sb2.toString();
    }
}
