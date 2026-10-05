package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: renamed from: xE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4271xE implements Cloneable, InterfaceC2121ea.a, InterfaceC2447iY.a {
    public static final b H = new b(null);
    public static final List I = AbstractC3724qX.w(EnumC4356yI.HTTP_2, EnumC4356yI.HTTP_1_1);
    public static final List J = AbstractC3724qX.w(C1013We.i, C1013We.k);
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final long F;
    public final C3632pM G;
    public final C0342Aj a;
    public final C0957Ue b;
    public final List c;
    public final List d;
    public final AbstractC0396Cl.c e;
    public final boolean f;
    public final InterfaceC2087e6 g;
    public final boolean h;
    public final boolean i;
    public final InterfaceC0932Tf j;
    public final InterfaceC0910Sj k;
    public final Proxy l;
    public final ProxySelector n;
    public final InterfaceC2087e6 p;
    public final SocketFactory q;
    public final SSLSocketFactory t;
    public final X509TrustManager u;
    public final List v;
    public final List w;
    public final HostnameVerifier x;
    public final C0953Ua y;
    public final AbstractC0927Ta z;

    /* JADX INFO: renamed from: xE$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final List a() {
            return C4271xE.J;
        }

        public final List b() {
            return C4271xE.I;
        }

        public b() {
        }
    }

    public C4271xE(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelectorY;
        AbstractC4492zt.h(aVar, "builder");
        this.a = aVar.l();
        this.b = aVar.i();
        this.c = AbstractC3724qX.U(aVar.r());
        this.d = AbstractC3724qX.U(aVar.t());
        this.e = aVar.n();
        this.f = aVar.A();
        this.g = aVar.c();
        this.h = aVar.o();
        this.i = aVar.p();
        this.j = aVar.k();
        aVar.d();
        this.k = aVar.m();
        this.l = aVar.w();
        if (aVar.w() != null) {
            proxySelectorY = UD.a;
        } else {
            proxySelectorY = aVar.y();
            proxySelectorY = proxySelectorY == null ? ProxySelector.getDefault() : proxySelectorY;
            if (proxySelectorY == null) {
                proxySelectorY = UD.a;
            }
        }
        this.n = proxySelectorY;
        this.p = aVar.x();
        this.q = aVar.C();
        List listJ = aVar.j();
        this.v = listJ;
        this.w = aVar.v();
        this.x = aVar.q();
        this.A = aVar.e();
        this.B = aVar.h();
        this.C = aVar.z();
        this.D = aVar.E();
        this.E = aVar.u();
        this.F = aVar.s();
        C3632pM c3632pMB = aVar.B();
        this.G = c3632pMB == null ? new C3632pM() : c3632pMB;
        List list = listJ;
        if ((list instanceof Collection) && list.isEmpty()) {
            this.t = null;
            this.z = null;
            this.u = null;
            this.y = C0953Ua.d;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((C1013We) it.next()).f()) {
                    if (aVar.D() != null) {
                        this.t = aVar.D();
                        AbstractC0927Ta abstractC0927TaF = aVar.f();
                        AbstractC4492zt.e(abstractC0927TaF);
                        this.z = abstractC0927TaF;
                        X509TrustManager x509TrustManagerF = aVar.F();
                        AbstractC4492zt.e(x509TrustManagerF);
                        this.u = x509TrustManagerF;
                        C0953Ua c0953UaG = aVar.g();
                        AbstractC4492zt.e(abstractC0927TaF);
                        this.y = c0953UaG.e(abstractC0927TaF);
                    } else {
                        EG.a aVar2 = EG.a;
                        X509TrustManager x509TrustManagerO = aVar2.g().o();
                        this.u = x509TrustManagerO;
                        EG egG = aVar2.g();
                        AbstractC4492zt.e(x509TrustManagerO);
                        this.t = egG.n(x509TrustManagerO);
                        AbstractC0927Ta.a aVar3 = AbstractC0927Ta.a;
                        AbstractC4492zt.e(x509TrustManagerO);
                        AbstractC0927Ta abstractC0927TaA = aVar3.a(x509TrustManagerO);
                        this.z = abstractC0927TaA;
                        C0953Ua c0953UaG2 = aVar.g();
                        AbstractC4492zt.e(abstractC0927TaA);
                        this.y = c0953UaG2.e(abstractC0927TaA);
                    }
                }
            }
            this.t = null;
            this.z = null;
            this.u = null;
            this.y = C0953Ua.d;
        }
        J();
    }

    public final int A() {
        return this.E;
    }

    public final List B() {
        return this.w;
    }

    public final Proxy C() {
        return this.l;
    }

    public final InterfaceC2087e6 D() {
        return this.p;
    }

    public final ProxySelector E() {
        return this.n;
    }

    public final int F() {
        return this.C;
    }

    public final boolean G() {
        return this.f;
    }

    public final SocketFactory H() {
        return this.q;
    }

    public final SSLSocketFactory I() {
        SSLSocketFactory sSLSocketFactory = this.t;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final void J() {
        List list = this.c;
        AbstractC4492zt.f(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.c).toString());
        }
        List list2 = this.d;
        AbstractC4492zt.f(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.d).toString());
        }
        List list3 = this.v;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                if (((C1013We) it.next()).f()) {
                    if (this.t == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.z == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.u == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.t != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.z != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.u != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!AbstractC4492zt.d(this.y, C0953Ua.d)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int K() {
        return this.D;
    }

    public final X509TrustManager L() {
        return this.u;
    }

    @Override // defpackage.InterfaceC2447iY.a
    public InterfaceC2447iY a(C3873sL c3873sL, AbstractC3234kY abstractC3234kY) {
        AbstractC4492zt.h(c3873sL, "request");
        AbstractC4492zt.h(abstractC3234kY, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        GJ gj = new GJ(ET.i, c3873sL, abstractC3234kY, new Random(), this.E, null, this.F);
        gj.p(this);
        return gj;
    }

    @Override // defpackage.InterfaceC2121ea.a
    public InterfaceC2121ea b(C3873sL c3873sL) {
        AbstractC4492zt.h(c3873sL, "request");
        return new BJ(this, c3873sL, false);
    }

    public Object clone() {
        return super.clone();
    }

    public final InterfaceC2087e6 g() {
        return this.g;
    }

    public final AbstractC3208k9 h() {
        return null;
    }

    public final int i() {
        return this.A;
    }

    public final AbstractC0927Ta j() {
        return this.z;
    }

    public final C0953Ua k() {
        return this.y;
    }

    public final int l() {
        return this.B;
    }

    public final C0957Ue m() {
        return this.b;
    }

    public final List n() {
        return this.v;
    }

    public final InterfaceC0932Tf o() {
        return this.j;
    }

    public final C0342Aj p() {
        return this.a;
    }

    public final InterfaceC0910Sj q() {
        return this.k;
    }

    public final AbstractC0396Cl.c r() {
        return this.e;
    }

    public final boolean s() {
        return this.h;
    }

    public final boolean t() {
        return this.i;
    }

    public final C3632pM u() {
        return this.G;
    }

    public final HostnameVerifier v() {
        return this.x;
    }

    public final List w() {
        return this.c;
    }

    public final long x() {
        return this.F;
    }

    public final List y() {
        return this.d;
    }

    public a z() {
        return new a(this);
    }

    /* JADX INFO: renamed from: xE$a */
    public static final class a {
        public int A;
        public long B;
        public C3632pM C;
        public C0342Aj a;
        public C0957Ue b;
        public final List c;
        public final List d;
        public AbstractC0396Cl.c e;
        public boolean f;
        public InterfaceC2087e6 g;
        public boolean h;
        public boolean i;
        public InterfaceC0932Tf j;
        public InterfaceC0910Sj k;
        public Proxy l;
        public ProxySelector m;
        public InterfaceC2087e6 n;
        public SocketFactory o;
        public SSLSocketFactory p;
        public X509TrustManager q;
        public List r;
        public List s;
        public HostnameVerifier t;
        public C0953Ua u;
        public AbstractC0927Ta v;
        public int w;
        public int x;
        public int y;
        public int z;

        public a() {
            this.a = new C0342Aj();
            this.b = new C0957Ue();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.e = AbstractC3724qX.g(AbstractC0396Cl.b);
            this.f = true;
            InterfaceC2087e6 interfaceC2087e6 = InterfaceC2087e6.b;
            this.g = interfaceC2087e6;
            this.h = true;
            this.i = true;
            this.j = InterfaceC0932Tf.b;
            this.k = InterfaceC0910Sj.b;
            this.n = interfaceC2087e6;
            SocketFactory socketFactory = SocketFactory.getDefault();
            AbstractC4492zt.g(socketFactory, "getDefault()");
            this.o = socketFactory;
            b bVar = C4271xE.H;
            this.r = bVar.a();
            this.s = bVar.b();
            this.t = C4190wE.a;
            this.u = C0953Ua.d;
            this.x = Constants.CP_MAC_ROMAN;
            this.y = Constants.CP_MAC_ROMAN;
            this.z = Constants.CP_MAC_ROMAN;
            this.B = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }

        public final boolean A() {
            return this.f;
        }

        public final C3632pM B() {
            return this.C;
        }

        public final SocketFactory C() {
            return this.o;
        }

        public final SSLSocketFactory D() {
            return this.p;
        }

        public final int E() {
            return this.z;
        }

        public final X509TrustManager F() {
            return this.q;
        }

        public final a G(List list) {
            AbstractC4492zt.h(list, "protocols");
            List listF0 = AbstractC3240kc.F0(list);
            EnumC4356yI enumC4356yI = EnumC4356yI.H2_PRIOR_KNOWLEDGE;
            if (!listF0.contains(enumC4356yI) && !listF0.contains(EnumC4356yI.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + listF0).toString());
            }
            if (listF0.contains(enumC4356yI) && listF0.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + listF0).toString());
            }
            if (listF0.contains(EnumC4356yI.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + listF0).toString());
            }
            AbstractC4492zt.f(listF0, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if (listF0.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            listF0.remove(EnumC4356yI.SPDY_3);
            if (!AbstractC4492zt.d(listF0, this.s)) {
                this.C = null;
            }
            List listUnmodifiableList = Collections.unmodifiableList(listF0);
            AbstractC4492zt.g(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
            this.s = listUnmodifiableList;
            return this;
        }

        public final a H(long j, TimeUnit timeUnit) {
            AbstractC4492zt.h(timeUnit, "unit");
            this.y = AbstractC3724qX.k("timeout", j, timeUnit);
            return this;
        }

        public final C4271xE a() {
            return new C4271xE(this);
        }

        public final a b(AbstractC0396Cl abstractC0396Cl) {
            AbstractC4492zt.h(abstractC0396Cl, "eventListener");
            this.e = AbstractC3724qX.g(abstractC0396Cl);
            return this;
        }

        public final InterfaceC2087e6 c() {
            return this.g;
        }

        public final AbstractC3208k9 d() {
            return null;
        }

        public final int e() {
            return this.w;
        }

        public final AbstractC0927Ta f() {
            return this.v;
        }

        public final C0953Ua g() {
            return this.u;
        }

        public final int h() {
            return this.x;
        }

        public final C0957Ue i() {
            return this.b;
        }

        public final List j() {
            return this.r;
        }

        public final InterfaceC0932Tf k() {
            return this.j;
        }

        public final C0342Aj l() {
            return this.a;
        }

        public final InterfaceC0910Sj m() {
            return this.k;
        }

        public final AbstractC0396Cl.c n() {
            return this.e;
        }

        public final boolean o() {
            return this.h;
        }

        public final boolean p() {
            return this.i;
        }

        public final HostnameVerifier q() {
            return this.t;
        }

        public final List r() {
            return this.c;
        }

        public final long s() {
            return this.B;
        }

        public final List t() {
            return this.d;
        }

        public final int u() {
            return this.A;
        }

        public final List v() {
            return this.s;
        }

        public final Proxy w() {
            return this.l;
        }

        public final InterfaceC2087e6 x() {
            return this.n;
        }

        public final ProxySelector y() {
            return this.m;
        }

        public final int z() {
            return this.y;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(C4271xE c4271xE) {
            this();
            AbstractC4492zt.h(c4271xE, "okHttpClient");
            this.a = c4271xE.p();
            this.b = c4271xE.m();
            AbstractC2371hc.D(this.c, c4271xE.w());
            AbstractC2371hc.D(this.d, c4271xE.y());
            this.e = c4271xE.r();
            this.f = c4271xE.G();
            this.g = c4271xE.g();
            this.h = c4271xE.s();
            this.i = c4271xE.t();
            this.j = c4271xE.o();
            c4271xE.h();
            this.k = c4271xE.q();
            this.l = c4271xE.C();
            this.m = c4271xE.E();
            this.n = c4271xE.D();
            this.o = c4271xE.H();
            this.p = c4271xE.t;
            this.q = c4271xE.L();
            this.r = c4271xE.n();
            this.s = c4271xE.B();
            this.t = c4271xE.v();
            this.u = c4271xE.k();
            this.v = c4271xE.j();
            this.w = c4271xE.i();
            this.x = c4271xE.l();
            this.y = c4271xE.F();
            this.z = c4271xE.K();
            this.A = c4271xE.A();
            this.B = c4271xE.x();
            this.C = c4271xE.u();
        }
    }
}
