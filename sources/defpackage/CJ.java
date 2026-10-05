package defpackage;

import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class CJ extends C0402Cr.c implements InterfaceC0931Te {
    public static final a t = new a(null);
    public final DJ c;
    public final C3550oM d;
    public Socket e;
    public Socket f;
    public C2311gr g;
    public EnumC4356yI h;
    public C0402Cr i;
    public L8 j;
    public K8 k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final List r;
    public long s;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class c extends AbstractC2233fv implements InterfaceC3588op {
        public final /* synthetic */ C0953Ua a;
        public final /* synthetic */ C2311gr b;
        public final /* synthetic */ C3846s2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C0953Ua c0953Ua, C2311gr c2311gr, C3846s2 c3846s2) {
            super(0);
            this.a = c0953Ua;
            this.b = c2311gr;
            this.c = c3846s2;
        }

        @Override // defpackage.InterfaceC3588op
        public final List invoke() {
            AbstractC0927Ta abstractC0927TaD = this.a.d();
            AbstractC4492zt.e(abstractC0927TaD);
            return abstractC0927TaD.a(this.b.d(), this.c.l().h());
        }
    }

    public static final class d extends AbstractC2233fv implements InterfaceC3588op {
        public d() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final List invoke() {
            C2311gr c2311gr = CJ.this.g;
            AbstractC4492zt.e(c2311gr);
            List<Certificate> listD = c2311gr.d();
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(listD, 10));
            for (Certificate certificate : listD) {
                AbstractC4492zt.f(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public static final class e extends GJ.d {
        public final /* synthetic */ C0799Ol d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(L8 l8, K8 k8, C0799Ol c0799Ol) {
            super(true, l8, k8);
            this.d = c0799Ol;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.d.a(-1L, true, true, null);
        }
    }

    public CJ(DJ dj, C3550oM c3550oM) {
        AbstractC4492zt.h(dj, "connectionPool");
        AbstractC4492zt.h(c3550oM, "route");
        this.c = dj;
        this.d = c3550oM;
        this.q = 1;
        this.r = new ArrayList();
        this.s = LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public C3550oM A() {
        return this.d;
    }

    public final boolean B(List list) {
        List<C3550oM> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (C3550oM c3550oM : list2) {
            Proxy.Type type = c3550oM.b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.d.b().type() == type2 && AbstractC4492zt.d(this.d.d(), c3550oM.d())) {
                return true;
            }
        }
        return false;
    }

    public final void C(long j) {
        this.s = j;
    }

    public final void D(boolean z) {
        this.l = z;
    }

    public Socket E() {
        Socket socket = this.f;
        AbstractC4492zt.e(socket);
        return socket;
    }

    public final void F(int i) throws SocketException {
        Socket socket = this.f;
        AbstractC4492zt.e(socket);
        L8 l8 = this.j;
        AbstractC4492zt.e(l8);
        K8 k8 = this.k;
        AbstractC4492zt.e(k8);
        socket.setSoTimeout(0);
        C0402Cr c0402CrA = new C0402Cr.a(true, ET.i).q(socket, this.d.a().l().h(), l8, k8).k(this).l(i).a();
        this.i = c0402CrA;
        this.q = C0402Cr.G.a().d();
        C0402Cr.m0(c0402CrA, false, null, 3, null);
    }

    public final boolean G(C0779Nr c0779Nr) {
        C2311gr c2311gr;
        if (AbstractC3724qX.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        C0779Nr c0779NrL = this.d.a().l();
        if (c0779Nr.m() != c0779NrL.m()) {
            return false;
        }
        if (AbstractC4492zt.d(c0779Nr.h(), c0779NrL.h())) {
            return true;
        }
        if (this.m || (c2311gr = this.g) == null) {
            return false;
        }
        AbstractC4492zt.e(c2311gr);
        return e(c0779Nr, c2311gr);
    }

    public final synchronized void H(BJ bj, IOException iOException) {
        try {
            AbstractC4492zt.h(bj, NotificationCompat.CATEGORY_CALL);
            if (iOException instanceof C2195fS) {
                if (((C2195fS) iOException).a == EnumC4069ul.REFUSED_STREAM) {
                    int i = this.p + 1;
                    this.p = i;
                    if (i > 1) {
                        this.l = true;
                        this.n++;
                    }
                } else if (((C2195fS) iOException).a != EnumC4069ul.CANCEL || !bj.s()) {
                    this.l = true;
                    this.n++;
                }
            } else if (!v() || (iOException instanceof C0987Ve)) {
                this.l = true;
                if (this.o == 0) {
                    if (iOException != null) {
                        g(bj.k(), this.d, iOException);
                    }
                    this.n++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.C0402Cr.c
    public synchronized void a(C0402Cr c0402Cr, SO so) {
        AbstractC4492zt.h(c0402Cr, "connection");
        AbstractC4492zt.h(so, "settings");
        this.q = so.d();
    }

    @Override // defpackage.C0402Cr.c
    public void b(C0528Fr c0528Fr) {
        AbstractC4492zt.h(c0528Fr, "stream");
        c0528Fr.d(EnumC4069ul.REFUSED_STREAM, null);
    }

    public final void d() {
        Socket socket = this.e;
        if (socket != null) {
            AbstractC3724qX.n(socket);
        }
    }

    public final boolean e(C0779Nr c0779Nr, C2311gr c2311gr) {
        List listD = c2311gr.d();
        if (listD.isEmpty()) {
            return false;
        }
        C4190wE c4190wE = C4190wE.a;
        String strH = c0779Nr.h();
        Object obj = listD.get(0);
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        return c4190wE.e(strH, (X509Certificate) obj);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0104  */
    /* JADX WARN: Code duplicated, block: B:50:0x010b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0136  */
    /* JADX WARN: Code duplicated, block: B:54:0x013c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0141  */
    /* JADX WARN: Code duplicated, block: B:72:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[LOOP:0: B:64:0x0094->B:74:?, LOOP_END, SYNTHETIC] */
    public final void f(int i, int i2, int i3, int i4, boolean z, InterfaceC2121ea interfaceC2121ea, AbstractC0396Cl abstractC0396Cl) throws Throwable {
        Socket socket;
        Socket socket2;
        AbstractC4492zt.h(interfaceC2121ea, NotificationCompat.CATEGORY_CALL);
        AbstractC4492zt.h(abstractC0396Cl, "eventListener");
        if (this.h != null) {
            throw new IllegalStateException("already connected");
        }
        List listB = this.d.a().b();
        C1039Xe c1039Xe = new C1039Xe(listB);
        if (this.d.a().k() == null) {
            if (!listB.contains(C1013We.k)) {
                throw new C3713qM(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strH = this.d.a().l().h();
            if (!EG.a.g().i(strH)) {
                throw new C3713qM(new UnknownServiceException("CLEARTEXT communication to " + strH + " not permitted by network security policy"));
            }
        } else if (this.d.a().f().contains(EnumC4356yI.H2_PRIOR_KNOWLEDGE)) {
            throw new C3713qM(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        C3713qM c3713qM = null;
        while (true) {
            try {
                if (this.d.c()) {
                    j(i, i2, i3, interfaceC2121ea, abstractC0396Cl);
                    if (this.e == null) {
                        break;
                    }
                } else {
                    try {
                        h(i, i2, interfaceC2121ea, abstractC0396Cl);
                    } catch (IOException e2) {
                        e = e2;
                        socket = this.f;
                        if (socket != null) {
                            AbstractC3724qX.n(socket);
                        }
                        socket2 = this.e;
                        if (socket2 != null) {
                            AbstractC3724qX.n(socket2);
                        }
                        this.f = null;
                        this.e = null;
                        this.j = null;
                        this.k = null;
                        this.g = null;
                        this.h = null;
                        this.i = null;
                        this.q = 1;
                        abstractC0396Cl.h(interfaceC2121ea, this.d.d(), this.d.b(), null, e);
                        if (c3713qM == null) {
                            c3713qM = new C3713qM(e);
                        } else {
                            c3713qM.a(e);
                        }
                        if (z) {
                            throw c3713qM;
                        }
                        if (c1039Xe.b(e)) {
                            throw c3713qM;
                        }
                    }
                }
                try {
                    m(c1039Xe, i4, interfaceC2121ea, abstractC0396Cl);
                    abstractC0396Cl.g(interfaceC2121ea, this.d.d(), this.d.b(), this.h);
                    break;
                } catch (IOException e3) {
                    e = e3;
                    socket = this.f;
                    if (socket != null) {
                        AbstractC3724qX.n(socket);
                    }
                    socket2 = this.e;
                    if (socket2 != null) {
                        AbstractC3724qX.n(socket2);
                    }
                    this.f = null;
                    this.e = null;
                    this.j = null;
                    this.k = null;
                    this.g = null;
                    this.h = null;
                    this.i = null;
                    this.q = 1;
                    abstractC0396Cl.h(interfaceC2121ea, this.d.d(), this.d.b(), null, e);
                    if (c3713qM == null) {
                        c3713qM = new C3713qM(e);
                    } else {
                        c3713qM.a(e);
                    }
                    if (z) {
                        throw c3713qM;
                    }
                    if (c1039Xe.b(e)) {
                        throw c3713qM;
                    }
                }
            } catch (IOException e4) {
                e = e4;
            }
        }
        if (this.d.c() && this.e == null) {
            throw new C3713qM(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.s = System.nanoTime();
    }

    public final void g(C4271xE c4271xE, C3550oM c3550oM, IOException iOException) {
        AbstractC4492zt.h(c4271xE, "client");
        AbstractC4492zt.h(c3550oM, "failedRoute");
        AbstractC4492zt.h(iOException, "failure");
        if (c3550oM.b().type() != Proxy.Type.DIRECT) {
            C3846s2 c3846s2A = c3550oM.a();
            c3846s2A.i().connectFailed(c3846s2A.l().r(), c3550oM.b().address(), iOException);
        }
        c4271xE.u().b(c3550oM);
    }

    public final void h(int i, int i2, InterfaceC2121ea interfaceC2121ea, AbstractC0396Cl abstractC0396Cl) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.d.b();
        C3846s2 c3846s2A = this.d.a();
        Proxy.Type type = proxyB.type();
        int i3 = type == null ? -1 : b.a[type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            socketCreateSocket = c3846s2A.j().createSocket();
            AbstractC4492zt.e(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.e = socketCreateSocket;
        abstractC0396Cl.i(interfaceC2121ea, this.d.d(), proxyB);
        socketCreateSocket.setSoTimeout(i2);
        try {
            EG.a.g().f(socketCreateSocket, this.d.d(), i);
            try {
                this.j = AbstractC4443zE.b(AbstractC4443zE.f(socketCreateSocket));
                this.k = AbstractC4443zE.a(AbstractC4443zE.d(socketCreateSocket));
            } catch (NullPointerException e2) {
                if (AbstractC4492zt.d(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.d.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void i(C1039Xe c1039Xe) throws Throwable {
        C3846s2 c3846s2A = this.d.a();
        SSLSocketFactory sSLSocketFactoryK = c3846s2A.k();
        SSLSocket sSLSocket = null;
        try {
            AbstractC4492zt.e(sSLSocketFactoryK);
            Socket socketCreateSocket = sSLSocketFactoryK.createSocket(this.e, c3846s2A.l().h(), c3846s2A.l().m(), true);
            AbstractC4492zt.f(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                C1013We c1013WeA = c1039Xe.a(sSLSocket2);
                if (c1013WeA.h()) {
                    EG.a.g().e(sSLSocket2, c3846s2A.l().h(), c3846s2A.f());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                C2311gr.a aVar = C2311gr.e;
                AbstractC4492zt.g(session, "sslSocketSession");
                C2311gr c2311grA = aVar.a(session);
                HostnameVerifier hostnameVerifierE = c3846s2A.e();
                AbstractC4492zt.e(hostnameVerifierE);
                if (hostnameVerifierE.verify(c3846s2A.l().h(), session)) {
                    C0953Ua c0953UaA = c3846s2A.a();
                    AbstractC4492zt.e(c0953UaA);
                    this.g = new C2311gr(c2311grA.e(), c2311grA.a(), c2311grA.c(), new c(c0953UaA, c2311grA, c3846s2A));
                    c0953UaA.b(c3846s2A.l().h(), new d());
                    String strG = c1013WeA.h() ? EG.a.g().g(sSLSocket2) : null;
                    this.f = sSLSocket2;
                    this.j = AbstractC4443zE.b(AbstractC4443zE.f(sSLSocket2));
                    this.k = AbstractC4443zE.a(AbstractC4443zE.d(sSLSocket2));
                    this.h = strG != null ? EnumC4356yI.b.a(strG) : EnumC4356yI.HTTP_1_1;
                    EG.a.g().b(sSLSocket2);
                    return;
                }
                List listD = c2311grA.d();
                if (listD.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + c3846s2A.l().h() + " not verified (no certificates)");
                }
                Object obj = listD.get(0);
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate x509Certificate = (X509Certificate) obj;
                throw new SSLPeerUnverifiedException(AbstractC3310lS.h("\n              |Hostname " + c3846s2A.l().h() + " not verified:\n              |    certificate: " + C0953Ua.c.a(x509Certificate) + "\n              |    DN: " + x509Certificate.getSubjectDN().getName() + "\n              |    subjectAltNames: " + C4190wE.a.a(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    EG.a.g().b(sSLSocket);
                }
                if (sSLSocket != null) {
                    AbstractC3724qX.n(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void j(int i, int i2, int i3, InterfaceC2121ea interfaceC2121ea, AbstractC0396Cl abstractC0396Cl) throws IOException {
        C3873sL c3873sLL = l();
        C0779Nr c0779NrI = c3873sLL.i();
        for (int i4 = 0; i4 < 21; i4++) {
            h(i, i2, interfaceC2121ea, abstractC0396Cl);
            c3873sLL = k(i2, i3, c3873sLL, c0779NrI);
            if (c3873sLL == null) {
                return;
            }
            Socket socket = this.e;
            if (socket != null) {
                AbstractC3724qX.n(socket);
            }
            this.e = null;
            this.k = null;
            this.j = null;
            abstractC0396Cl.g(interfaceC2121ea, this.d.d(), this.d.b(), null);
        }
    }

    public final C3873sL k(int i, int i2, C3873sL c3873sL, C0779Nr c0779Nr) throws IOException {
        String str = "CONNECT " + AbstractC3724qX.S(c0779Nr, true) + " HTTP/1.1";
        while (true) {
            L8 l8 = this.j;
            AbstractC4492zt.e(l8);
            K8 k8 = this.k;
            AbstractC4492zt.e(k8);
            C0350Ar c0350Ar = new C0350Ar(null, this, l8, k8);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            l8.b().g(i, timeUnit);
            k8.b().g(i2, timeUnit);
            c0350Ar.z(c3873sL.e(), str);
            c0350Ar.b();
            EL.a aVarC = c0350Ar.c(false);
            AbstractC4492zt.e(aVarC);
            EL elC = aVarC.r(c3873sL).c();
            c0350Ar.y(elC);
            int iR = elC.r();
            if (iR == 200) {
                if (l8.a().h() && k8.a().h()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iR != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + elC.r());
            }
            C3873sL c3873sLA = this.d.a().h().a(this.d, elC);
            if (c3873sLA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (AbstractC3880sS.q("close", EL.x(elC, HttpHeaders.CONNECTION, null, 2, null), true)) {
                return c3873sLA;
            }
            c3873sL = c3873sLA;
        }
    }

    public final C3873sL l() {
        C3873sL c3873sLB = new C3873sL.a().g(this.d.a().l()).e(HttpMethods.CONNECT, null).c(HttpHeaders.HOST, AbstractC3724qX.S(this.d.a().l(), true)).c("Proxy-Connection", HttpHeaders.KEEP_ALIVE).c(HttpHeaders.USER_AGENT, "okhttp/4.12.0").b();
        C3873sL c3873sLA = this.d.a().h().a(this.d, new EL.a().r(c3873sLB).p(EnumC4356yI.HTTP_1_1).g(407).m("Preemptive Authenticate").b(AbstractC3724qX.c).s(-1L).q(-1L).j(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").c());
        return c3873sLA == null ? c3873sLB : c3873sLA;
    }

    public final void m(C1039Xe c1039Xe, int i, InterfaceC2121ea interfaceC2121ea, AbstractC0396Cl abstractC0396Cl) throws Throwable {
        if (this.d.a().k() != null) {
            abstractC0396Cl.B(interfaceC2121ea);
            i(c1039Xe);
            abstractC0396Cl.A(interfaceC2121ea, this.g);
            if (this.h == EnumC4356yI.HTTP_2) {
                F(i);
                return;
            }
            return;
        }
        List listF = this.d.a().f();
        EnumC4356yI enumC4356yI = EnumC4356yI.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(enumC4356yI)) {
            this.f = this.e;
            this.h = EnumC4356yI.HTTP_1_1;
        } else {
            this.f = this.e;
            this.h = enumC4356yI;
            F(i);
        }
    }

    public final List n() {
        return this.r;
    }

    public final long o() {
        return this.s;
    }

    public final boolean p() {
        return this.l;
    }

    public final int q() {
        return this.n;
    }

    public C2311gr r() {
        return this.g;
    }

    public final synchronized void s() {
        this.o++;
    }

    public final boolean t(C3846s2 c3846s2, List list) {
        AbstractC4492zt.h(c3846s2, HTML.Tag.ADDRESS);
        if (AbstractC3724qX.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.r.size() >= this.q || this.l || !this.d.a().d(c3846s2)) {
            return false;
        }
        if (AbstractC4492zt.d(c3846s2.l().h(), A().a().l().h())) {
            return true;
        }
        if (this.i == null || list == null || !B(list) || c3846s2.e() != C4190wE.a || !G(c3846s2.l())) {
            return false;
        }
        try {
            C0953Ua c0953UaA = c3846s2.a();
            AbstractC4492zt.e(c0953UaA);
            String strH = c3846s2.l().h();
            C2311gr c2311grR = r();
            AbstractC4492zt.e(c2311grR);
            c0953UaA.a(strH, c2311grR.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public String toString() {
        Object objA;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.d.a().l().h());
        sb.append(':');
        sb.append(this.d.a().l().m());
        sb.append(", proxy=");
        sb.append(this.d.b());
        sb.append(" hostAddress=");
        sb.append(this.d.d());
        sb.append(" cipherSuite=");
        C2311gr c2311gr = this.g;
        if (c2311gr == null || (objA = c2311gr.a()) == null) {
            objA = "none";
        }
        sb.append(objA);
        sb.append(" protocol=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }

    public final boolean u(boolean z) {
        long j;
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.e;
        AbstractC4492zt.e(socket);
        Socket socket2 = this.f;
        AbstractC4492zt.e(socket2);
        L8 l8 = this.j;
        AbstractC4492zt.e(l8);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        C0402Cr c0402Cr = this.i;
        if (c0402Cr != null) {
            return c0402Cr.Y(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.s;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        return AbstractC3724qX.F(socket2, l8);
    }

    public final boolean v() {
        return this.i != null;
    }

    public final InterfaceC0825Pl w(C4271xE c4271xE, EJ ej) throws SocketException {
        AbstractC4492zt.h(c4271xE, "client");
        AbstractC4492zt.h(ej, "chain");
        Socket socket = this.f;
        AbstractC4492zt.e(socket);
        L8 l8 = this.j;
        AbstractC4492zt.e(l8);
        K8 k8 = this.k;
        AbstractC4492zt.e(k8);
        C0402Cr c0402Cr = this.i;
        if (c0402Cr != null) {
            return new C0428Dr(c4271xE, this, ej, c0402Cr);
        }
        socket.setSoTimeout(ej.k());
        JU juB = l8.b();
        long jH = ej.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        juB.g(jH, timeUnit);
        k8.b().g(ej.j(), timeUnit);
        return new C0350Ar(c4271xE, this, l8, k8);
    }

    public final GJ.d x(C0799Ol c0799Ol) throws SocketException {
        AbstractC4492zt.h(c0799Ol, "exchange");
        Socket socket = this.f;
        AbstractC4492zt.e(socket);
        L8 l8 = this.j;
        AbstractC4492zt.e(l8);
        K8 k8 = this.k;
        AbstractC4492zt.e(k8);
        socket.setSoTimeout(0);
        z();
        return new e(l8, k8, c0799Ol);
    }

    public final synchronized void y() {
        this.m = true;
    }

    public final synchronized void z() {
        this.l = true;
    }
}
