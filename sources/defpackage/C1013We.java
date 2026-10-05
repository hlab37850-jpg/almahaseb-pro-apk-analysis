package defpackage;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: We, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1013We {
    public static final b e = new b(null);
    public static final C0386Cb[] f;
    public static final C0386Cb[] g;
    public static final C1013We h;
    public static final C1013We i;
    public static final C1013We j;
    public static final C1013We k;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    /* JADX INFO: renamed from: We$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public b() {
        }
    }

    static {
        C0386Cb c0386Cb = C0386Cb.o1;
        C0386Cb c0386Cb2 = C0386Cb.p1;
        C0386Cb c0386Cb3 = C0386Cb.q1;
        C0386Cb c0386Cb4 = C0386Cb.a1;
        C0386Cb c0386Cb5 = C0386Cb.e1;
        C0386Cb c0386Cb6 = C0386Cb.b1;
        C0386Cb c0386Cb7 = C0386Cb.f1;
        C0386Cb c0386Cb8 = C0386Cb.l1;
        C0386Cb c0386Cb9 = C0386Cb.k1;
        C0386Cb[] c0386CbArr = {c0386Cb, c0386Cb2, c0386Cb3, c0386Cb4, c0386Cb5, c0386Cb6, c0386Cb7, c0386Cb8, c0386Cb9};
        f = c0386CbArr;
        C0386Cb[] c0386CbArr2 = {c0386Cb, c0386Cb2, c0386Cb3, c0386Cb4, c0386Cb5, c0386Cb6, c0386Cb7, c0386Cb8, c0386Cb9, C0386Cb.L0, C0386Cb.M0, C0386Cb.j0, C0386Cb.k0, C0386Cb.H, C0386Cb.L, C0386Cb.l};
        g = c0386CbArr2;
        a aVarB = new a(true).b((C0386Cb[]) Arrays.copyOf(c0386CbArr, c0386CbArr.length));
        OU ou = OU.TLS_1_3;
        OU ou2 = OU.TLS_1_2;
        h = aVarB.e(ou, ou2).d(true).a();
        i = new a(true).b((C0386Cb[]) Arrays.copyOf(c0386CbArr2, c0386CbArr2.length)).e(ou, ou2).d(true).a();
        j = new a(true).b((C0386Cb[]) Arrays.copyOf(c0386CbArr2, c0386CbArr2.length)).e(ou, ou2, OU.TLS_1_1, OU.TLS_1_0).d(true).a();
        k = new a(false).a();
    }

    public C1013We(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.a = z;
        this.b = z2;
        this.c = strArr;
        this.d = strArr2;
    }

    public final void c(SSLSocket sSLSocket, boolean z) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        C1013We c1013WeG = g(sSLSocket, z);
        if (c1013WeG.i() != null) {
            sSLSocket.setEnabledProtocols(c1013WeG.d);
        }
        if (c1013WeG.d() != null) {
            sSLSocket.setEnabledCipherSuites(c1013WeG.c);
        }
    }

    public final List d() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C0386Cb.b.b(str));
        }
        return AbstractC3240kc.C0(arrayList);
    }

    public final boolean e(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "socket");
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !AbstractC3724qX.u(strArr, sSLSocket.getEnabledProtocols(), AbstractC0956Ud.f())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || AbstractC3724qX.u(strArr2, sSLSocket.getEnabledCipherSuites(), C0386Cb.b.c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1013We)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.a;
        C1013We c1013We = (C1013We) obj;
        if (z != c1013We.a) {
            return false;
        }
        return !z || (Arrays.equals(this.c, c1013We.c) && Arrays.equals(this.d, c1013We.d) && this.b == c1013We.b);
    }

    public final boolean f() {
        return this.a;
    }

    public final C1013We g(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.c != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            AbstractC4492zt.g(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = AbstractC3724qX.E(enabledCipherSuites2, this.c, C0386Cb.b.c());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.d != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            AbstractC4492zt.g(enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = AbstractC3724qX.E(enabledProtocols2, this.d, AbstractC0956Ud.f());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        AbstractC4492zt.g(supportedCipherSuites, "supportedCipherSuites");
        int iX = AbstractC3724qX.x(supportedCipherSuites, "TLS_FALLBACK_SCSV", C0386Cb.b.c());
        if (z && iX != -1) {
            AbstractC4492zt.g(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iX];
            AbstractC4492zt.g(str, "supportedCipherSuites[indexOfFallbackScsv]");
            enabledCipherSuites = AbstractC3724qX.o(enabledCipherSuites, str);
        }
        a aVar = new a(this);
        AbstractC4492zt.g(enabledCipherSuites, "cipherSuitesIntersection");
        a aVarC = aVar.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        AbstractC4492zt.g(enabledProtocols, "tlsVersionsIntersection");
        return aVarC.f((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).a();
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        if (!this.a) {
            return 17;
        }
        String[] strArr = this.c;
        int iHashCode = (MetaDo.META_OFFSETWINDOWORG + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.b ? 1 : 0);
    }

    public final List i() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(OU.b.a(str));
        }
        return AbstractC3240kc.C0(arrayList);
    }

    public String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ')';
    }

    /* JADX INFO: renamed from: We$a */
    public static final class a {
        public boolean a;
        public String[] b;
        public String[] c;
        public boolean d;

        public a(boolean z) {
            this.a = z;
        }

        public final C1013We a() {
            return new C1013We(this.a, this.d, this.b, this.c);
        }

        public final a b(C0386Cb... c0386CbArr) {
            AbstractC4492zt.h(c0386CbArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(c0386CbArr.length);
            for (C0386Cb c0386Cb : c0386CbArr) {
                arrayList.add(c0386Cb.c());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return c((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a c(String... strArr) {
            AbstractC4492zt.h(strArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        public final a d(boolean z) {
            if (!this.a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public final a e(OU... ouArr) {
            AbstractC4492zt.h(ouArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(ouArr.length);
            for (OU ou : ouArr) {
                arrayList.add(ou.b());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return f((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a f(String... strArr) {
            AbstractC4492zt.h(strArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[]) strArr.clone();
            return this;
        }

        public a(C1013We c1013We) {
            AbstractC4492zt.h(c1013We, "connectionSpec");
            this.a = c1013We.f();
            this.b = c1013We.c;
            this.c = c1013We.d;
            this.d = c1013We.h();
        }
    }
}
