package defpackage;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: Cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0386Cb {
    public static final C0386Cb A;
    public static final C0386Cb A0;
    public static final C0386Cb B;
    public static final C0386Cb B0;
    public static final C0386Cb C;
    public static final C0386Cb C0;
    public static final C0386Cb D;
    public static final C0386Cb D0;
    public static final C0386Cb E;
    public static final C0386Cb E0;
    public static final C0386Cb F;
    public static final C0386Cb F0;
    public static final C0386Cb G;
    public static final C0386Cb G0;
    public static final C0386Cb H;
    public static final C0386Cb H0;
    public static final C0386Cb I;
    public static final C0386Cb I0;
    public static final C0386Cb J;
    public static final C0386Cb J0;
    public static final C0386Cb K;
    public static final C0386Cb K0;
    public static final C0386Cb L;
    public static final C0386Cb L0;
    public static final C0386Cb M;
    public static final C0386Cb M0;
    public static final C0386Cb N;
    public static final C0386Cb N0;
    public static final C0386Cb O;
    public static final C0386Cb O0;
    public static final C0386Cb P;
    public static final C0386Cb P0;
    public static final C0386Cb Q;
    public static final C0386Cb Q0;
    public static final C0386Cb R;
    public static final C0386Cb R0;
    public static final C0386Cb S;
    public static final C0386Cb S0;
    public static final C0386Cb T;
    public static final C0386Cb T0;
    public static final C0386Cb U;
    public static final C0386Cb U0;
    public static final C0386Cb V;
    public static final C0386Cb V0;
    public static final C0386Cb W;
    public static final C0386Cb W0;
    public static final C0386Cb X;
    public static final C0386Cb X0;
    public static final C0386Cb Y;
    public static final C0386Cb Y0;
    public static final C0386Cb Z;
    public static final C0386Cb Z0;
    public static final C0386Cb a0;
    public static final C0386Cb a1;
    public static final b b;
    public static final C0386Cb b0;
    public static final C0386Cb b1;
    public static final Comparator c;
    public static final C0386Cb c0;
    public static final C0386Cb c1;
    public static final Map d;
    public static final C0386Cb d0;
    public static final C0386Cb d1;
    public static final C0386Cb e;
    public static final C0386Cb e0;
    public static final C0386Cb e1;
    public static final C0386Cb f;
    public static final C0386Cb f0;
    public static final C0386Cb f1;
    public static final C0386Cb g;
    public static final C0386Cb g0;
    public static final C0386Cb g1;
    public static final C0386Cb h;
    public static final C0386Cb h0;
    public static final C0386Cb h1;
    public static final C0386Cb i;
    public static final C0386Cb i0;
    public static final C0386Cb i1;
    public static final C0386Cb j;
    public static final C0386Cb j0;
    public static final C0386Cb j1;
    public static final C0386Cb k;
    public static final C0386Cb k0;
    public static final C0386Cb k1;
    public static final C0386Cb l;
    public static final C0386Cb l0;
    public static final C0386Cb l1;
    public static final C0386Cb m;
    public static final C0386Cb m0;
    public static final C0386Cb m1;
    public static final C0386Cb n;
    public static final C0386Cb n0;
    public static final C0386Cb n1;
    public static final C0386Cb o;
    public static final C0386Cb o0;
    public static final C0386Cb o1;
    public static final C0386Cb p;
    public static final C0386Cb p0;
    public static final C0386Cb p1;
    public static final C0386Cb q;
    public static final C0386Cb q0;
    public static final C0386Cb q1;
    public static final C0386Cb r;
    public static final C0386Cb r0;
    public static final C0386Cb r1;
    public static final C0386Cb s;
    public static final C0386Cb s0;
    public static final C0386Cb s1;
    public static final C0386Cb t;
    public static final C0386Cb t0;
    public static final C0386Cb u;
    public static final C0386Cb u0;
    public static final C0386Cb v;
    public static final C0386Cb v0;
    public static final C0386Cb w;
    public static final C0386Cb w0;
    public static final C0386Cb x;
    public static final C0386Cb x0;
    public static final C0386Cb y;
    public static final C0386Cb y0;
    public static final C0386Cb z;
    public static final C0386Cb z0;
    public final String a;

    /* JADX INFO: renamed from: Cb$a */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            AbstractC4492zt.h(str, "a");
            AbstractC4492zt.h(str2, "b");
            int iMin = Math.min(str.length(), str2.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt != cCharAt2) {
                    return AbstractC4492zt.j(cCharAt, cCharAt2) < 0 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: Cb$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final synchronized C0386Cb b(String str) {
            C0386Cb c0386Cb;
            try {
                AbstractC4492zt.h(str, "javaName");
                c0386Cb = (C0386Cb) C0386Cb.d.get(str);
                if (c0386Cb == null) {
                    c0386Cb = (C0386Cb) C0386Cb.d.get(e(str));
                    if (c0386Cb == null) {
                        c0386Cb = new C0386Cb(str, null);
                    }
                    C0386Cb.d.put(str, c0386Cb);
                }
            } catch (Throwable th) {
                throw th;
            }
            return c0386Cb;
        }

        public final Comparator c() {
            return C0386Cb.c;
        }

        public final C0386Cb d(String str, int i) {
            C0386Cb c0386Cb = new C0386Cb(str, null);
            C0386Cb.d.put(str, c0386Cb);
            return c0386Cb;
        }

        public final String e(String str) {
            if (AbstractC3880sS.B(str, "TLS_", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SSL_");
                String strSubstring = str.substring(4);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                return sb.toString();
            }
            if (!AbstractC3880sS.B(str, "SSL_", false, 2, null)) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TLS_");
            String strSubstring2 = str.substring(4);
            AbstractC4492zt.g(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring2);
            return sb2.toString();
        }

        public b() {
        }
    }

    static {
        b bVar = new b(null);
        b = bVar;
        c = new a();
        d = new LinkedHashMap();
        e = bVar.d("SSL_RSA_WITH_NULL_MD5", 1);
        f = bVar.d("SSL_RSA_WITH_NULL_SHA", 2);
        g = bVar.d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        h = bVar.d("SSL_RSA_WITH_RC4_128_MD5", 4);
        i = bVar.d("SSL_RSA_WITH_RC4_128_SHA", 5);
        j = bVar.d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        k = bVar.d("SSL_RSA_WITH_DES_CBC_SHA", 9);
        l = bVar.d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m = bVar.d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        n = bVar.d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        o = bVar.d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        p = bVar.d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        q = bVar.d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        r = bVar.d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        s = bVar.d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        t = bVar.d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        u = bVar.d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        v = bVar.d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        w = bVar.d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        x = bVar.d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        y = bVar.d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        z = bVar.d("TLS_KRB5_WITH_RC4_128_SHA", 32);
        A = bVar.d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        B = bVar.d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        C = bVar.d("TLS_KRB5_WITH_RC4_128_MD5", 36);
        D = bVar.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        E = bVar.d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        F = bVar.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        G = bVar.d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        H = bVar.d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        I = bVar.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        J = bVar.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        K = bVar.d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        L = bVar.d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        M = bVar.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        N = bVar.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        O = bVar.d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        P = bVar.d("TLS_RSA_WITH_NULL_SHA256", 59);
        Q = bVar.d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        R = bVar.d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        S = bVar.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        T = bVar.d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        U = bVar.d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        V = bVar.d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        W = bVar.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        X = bVar.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        Y = bVar.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        Z = bVar.d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        a0 = bVar.d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b0 = bVar.d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", ShapeTypes.FLOW_CHART_PROCESS);
        c0 = bVar.d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS);
        d0 = bVar.d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", ShapeTypes.FLOW_CHART_INTERNAL_STORAGE);
        e0 = bVar.d("TLS_PSK_WITH_RC4_128_SHA", ShapeTypes.FLOW_CHART_MULTIDOCUMENT);
        f0 = bVar.d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", ShapeTypes.FLOW_CHART_TERMINATOR);
        g0 = bVar.d("TLS_PSK_WITH_AES_128_CBC_SHA", ShapeTypes.FLOW_CHART_PREPARATION);
        h0 = bVar.d("TLS_PSK_WITH_AES_256_CBC_SHA", ShapeTypes.FLOW_CHART_MANUAL_INPUT);
        i0 = bVar.d("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        j0 = bVar.d("TLS_RSA_WITH_AES_128_GCM_SHA256", ShapeTypes.FLOW_CHART_MAGNETIC_DRUM);
        k0 = bVar.d("TLS_RSA_WITH_AES_256_GCM_SHA384", ShapeTypes.FLOW_CHART_DISPLAY);
        l0 = bVar.d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", ShapeTypes.FLOW_CHART_DELAY);
        m0 = bVar.d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS);
        n0 = bVar.d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", ShapeTypes.ACTION_BUTTON_HOME);
        o0 = bVar.d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", ShapeTypes.ACTION_BUTTON_HELP);
        p0 = bVar.d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS);
        q0 = bVar.d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", ShapeTypes.ACTION_BUTTON_END);
        r0 = bVar.d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        s0 = bVar.d("TLS_FALLBACK_SCSV", 22016);
        t0 = bVar.d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        u0 = bVar.d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        v0 = bVar.d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        w0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        x0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        y0 = bVar.d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        z0 = bVar.d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        A0 = bVar.d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        B0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        C0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        D0 = bVar.d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        E0 = bVar.d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        F0 = bVar.d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        G0 = bVar.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        H0 = bVar.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        I0 = bVar.d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        J0 = bVar.d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        K0 = bVar.d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        L0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        M0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        N0 = bVar.d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        O0 = bVar.d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        P0 = bVar.d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        Q0 = bVar.d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        R0 = bVar.d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        S0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        T0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        U0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        V0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        W0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        X0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        Y0 = bVar.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        Z0 = bVar.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        a1 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        b1 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        c1 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        d1 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        e1 = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f1 = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        g1 = bVar.d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        h1 = bVar.d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        i1 = bVar.d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        j1 = bVar.d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        k1 = bVar.d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        l1 = bVar.d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        m1 = bVar.d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        n1 = bVar.d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        o1 = bVar.d("TLS_AES_128_GCM_SHA256", 4865);
        p1 = bVar.d("TLS_AES_256_GCM_SHA384", 4866);
        q1 = bVar.d("TLS_CHACHA20_POLY1305_SHA256", 4867);
        r1 = bVar.d("TLS_AES_128_CCM_SHA256", 4868);
        s1 = bVar.d("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public /* synthetic */ C0386Cb(String str, AbstractC0419Di abstractC0419Di) {
        this(str);
    }

    public final String c() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    public C0386Cb(String str) {
        this.a = str;
    }
}
