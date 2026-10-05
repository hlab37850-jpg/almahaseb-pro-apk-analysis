package defpackage;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.itextpdf.tool.xml.html.HTML;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: renamed from: oM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3550oM {
    public final C3846s2 a;
    public final Proxy b;
    public final InetSocketAddress c;

    public C3550oM(C3846s2 c3846s2, Proxy proxy, InetSocketAddress inetSocketAddress) {
        AbstractC4492zt.h(c3846s2, HTML.Tag.ADDRESS);
        AbstractC4492zt.h(proxy, "proxy");
        AbstractC4492zt.h(inetSocketAddress, "socketAddress");
        this.a = c3846s2;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final C3846s2 a() {
        return this.a;
    }

    public final Proxy b() {
        return this.b;
    }

    public final boolean c() {
        return this.a.k() != null && this.b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3550oM) {
            C3550oM c3550oM = (C3550oM) obj;
            if (AbstractC4492zt.d(c3550oM.a, this.a) && AbstractC4492zt.d(c3550oM.b, this.b) && AbstractC4492zt.d(c3550oM.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((MetaDo.META_OFFSETWINDOWORG + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + '}';
    }
}
