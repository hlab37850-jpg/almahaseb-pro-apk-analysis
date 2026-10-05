package defpackage;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Cr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0402Cr implements Closeable {
    public static final b G = new b(null);
    public static final SO H;
    public long A;
    public long B;
    public final Socket C;
    public final C0554Gr D;
    public final d E;
    public final Set F;
    public final boolean a;
    public final c b;
    public final Map c;
    public final String d;
    public int e;
    public int f;
    public boolean g;
    public final ET h;
    public final DT i;
    public final DT j;
    public final DT k;
    public final GI l;
    public long n;
    public long p;
    public long q;
    public long t;
    public long u;
    public long v;
    public final SO w;
    public SO x;
    public long y;
    public long z;

    /* JADX INFO: renamed from: Cr$a */
    public static final class a {
        public boolean a;
        public final ET b;
        public Socket c;
        public String d;
        public L8 e;
        public K8 f;
        public c g;
        public GI h;
        public int i;

        public a(boolean z, ET et) {
            AbstractC4492zt.h(et, "taskRunner");
            this.a = z;
            this.b = et;
            this.g = c.b;
            this.h = GI.b;
        }

        public final C0402Cr a() {
            return new C0402Cr(this);
        }

        public final boolean b() {
            return this.a;
        }

        public final String c() {
            String str = this.d;
            if (str != null) {
                return str;
            }
            AbstractC4492zt.x("connectionName");
            return null;
        }

        public final c d() {
            return this.g;
        }

        public final int e() {
            return this.i;
        }

        public final GI f() {
            return this.h;
        }

        public final K8 g() {
            K8 k8 = this.f;
            if (k8 != null) {
                return k8;
            }
            AbstractC4492zt.x("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.c;
            if (socket != null) {
                return socket;
            }
            AbstractC4492zt.x("socket");
            return null;
        }

        public final L8 i() {
            L8 l8 = this.e;
            if (l8 != null) {
                return l8;
            }
            AbstractC4492zt.x(DublinCoreProperties.SOURCE);
            return null;
        }

        public final ET j() {
            return this.b;
        }

        public final a k(c cVar) {
            AbstractC4492zt.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.g = cVar;
            return this;
        }

        public final a l(int i) {
            this.i = i;
            return this;
        }

        public final void m(String str) {
            AbstractC4492zt.h(str, "<set-?>");
            this.d = str;
        }

        public final void n(K8 k8) {
            AbstractC4492zt.h(k8, "<set-?>");
            this.f = k8;
        }

        public final void o(Socket socket) {
            AbstractC4492zt.h(socket, "<set-?>");
            this.c = socket;
        }

        public final void p(L8 l8) {
            AbstractC4492zt.h(l8, "<set-?>");
            this.e = l8;
        }

        public final a q(Socket socket, String str, L8 l8, K8 k8) {
            String str2;
            AbstractC4492zt.h(socket, "socket");
            AbstractC4492zt.h(str, "peerName");
            AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
            AbstractC4492zt.h(k8, "sink");
            o(socket);
            if (this.a) {
                str2 = AbstractC3724qX.i + ' ' + str;
            } else {
                str2 = "MockWebServer " + str;
            }
            m(str2);
            p(l8);
            n(k8);
            return this;
        }
    }

    /* JADX INFO: renamed from: Cr$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final SO a() {
            return C0402Cr.H;
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: Cr$c */
    public static abstract class c {
        public static final b a = new b(null);
        public static final c b = new a();

        /* JADX INFO: renamed from: Cr$c$a */
        public static final class a extends c {
            @Override // defpackage.C0402Cr.c
            public void b(C0528Fr c0528Fr) {
                AbstractC4492zt.h(c0528Fr, "stream");
                c0528Fr.d(EnumC4069ul.REFUSED_STREAM, null);
            }
        }

        /* JADX INFO: renamed from: Cr$c$b */
        public static final class b {
            public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public b() {
            }
        }

        public void a(C0402Cr c0402Cr, SO so) {
            AbstractC4492zt.h(c0402Cr, "connection");
            AbstractC4492zt.h(so, "settings");
        }

        public abstract void b(C0528Fr c0528Fr);
    }

    /* JADX INFO: renamed from: Cr$e */
    public static final class e extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ int f;
        public final /* synthetic */ H8 g;
        public final /* synthetic */ int h;
        public final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z, C0402Cr c0402Cr, int i, H8 h8, int i2, boolean z2) {
            super(str, z);
            this.e = c0402Cr;
            this.f = i;
            this.g = h8;
            this.h = i2;
            this.i = z2;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            try {
                boolean zD = this.e.l.d(this.f, this.g, this.h, this.i);
                if (zD) {
                    this.e.X().A(this.f, EnumC4069ul.CANCEL);
                }
                if (!zD && !this.i) {
                    return -1L;
                }
                synchronized (this.e) {
                    this.e.F.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: Cr$f */
    public static final class f extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ int f;
        public final /* synthetic */ List g;
        public final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z, C0402Cr c0402Cr, int i, List list, boolean z2) {
            super(str, z);
            this.e = c0402Cr;
            this.f = i;
            this.g = list;
            this.h = z2;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            boolean zC = this.e.l.c(this.f, this.g, this.h);
            if (zC) {
                try {
                    this.e.X().A(this.f, EnumC4069ul.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zC && !this.h) {
                return -1L;
            }
            synchronized (this.e) {
                this.e.F.remove(Integer.valueOf(this.f));
            }
            return -1L;
        }
    }

    /* JADX INFO: renamed from: Cr$g */
    public static final class g extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ int f;
        public final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z, C0402Cr c0402Cr, int i, List list) {
            super(str, z);
            this.e = c0402Cr;
            this.f = i;
            this.g = list;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            if (!this.e.l.b(this.f, this.g)) {
                return -1L;
            }
            try {
                this.e.X().A(this.f, EnumC4069ul.CANCEL);
                synchronized (this.e) {
                    this.e.F.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: Cr$h */
    public static final class h extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ int f;
        public final /* synthetic */ EnumC4069ul g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, C0402Cr c0402Cr, int i, EnumC4069ul enumC4069ul) {
            super(str, z);
            this.e = c0402Cr;
            this.f = i;
            this.g = enumC4069ul;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            this.e.l.a(this.f, this.g);
            synchronized (this.e) {
                this.e.F.remove(Integer.valueOf(this.f));
                FW fw = FW.a;
            }
            return -1L;
        }
    }

    /* JADX INFO: renamed from: Cr$i */
    public static final class i extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z, C0402Cr c0402Cr) {
            super(str, z);
            this.e = c0402Cr;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            this.e.q0(false, 2, 0);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: Cr$j */
    public static final class j extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, C0402Cr c0402Cr, long j) {
            super(str, false, 2, null);
            this.e = c0402Cr;
            this.f = j;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            boolean z;
            synchronized (this.e) {
                if (this.e.p < this.e.n) {
                    z = true;
                } else {
                    this.e.n++;
                    z = false;
                }
            }
            if (z) {
                this.e.M(null);
                return -1L;
            }
            this.e.q0(false, 1, 0);
            return this.f;
        }
    }

    /* JADX INFO: renamed from: Cr$k */
    public static final class k extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ int f;
        public final /* synthetic */ EnumC4069ul g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z, C0402Cr c0402Cr, int i, EnumC4069ul enumC4069ul) {
            super(str, z);
            this.e = c0402Cr;
            this.f = i;
            this.g = enumC4069ul;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            try {
                this.e.r0(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.M(e);
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: Cr$l */
    public static final class l extends AbstractC4124vT {
        public final /* synthetic */ C0402Cr e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z, C0402Cr c0402Cr, int i, long j) {
            super(str, z);
            this.e = c0402Cr;
            this.f = i;
            this.g = j;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            try {
                this.e.X().F(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.M(e);
                return -1L;
            }
        }
    }

    static {
        SO so = new SO();
        so.h(7, 65535);
        so.h(5, 16384);
        H = so;
    }

    public C0402Cr(a aVar) {
        AbstractC4492zt.h(aVar, "builder");
        boolean zB = aVar.b();
        this.a = zB;
        this.b = aVar.d();
        this.c = new LinkedHashMap();
        String strC = aVar.c();
        this.d = strC;
        this.f = aVar.b() ? 3 : 2;
        ET etJ = aVar.j();
        this.h = etJ;
        DT dtI = etJ.i();
        this.i = dtI;
        this.j = etJ.i();
        this.k = etJ.i();
        this.l = aVar.f();
        SO so = new SO();
        if (aVar.b()) {
            so.h(7, 16777216);
        }
        this.w = so;
        SO so2 = H;
        this.x = so2;
        this.B = so2.c();
        this.C = aVar.h();
        this.D = new C0554Gr(aVar.g(), zB);
        this.E = new d(this, new C0454Er(aVar.i(), zB));
        this.F = new LinkedHashSet();
        if (aVar.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(aVar.e());
            dtI.i(new j(strC + " ping", this, nanos), nanos);
        }
    }

    public static /* synthetic */ void m0(C0402Cr c0402Cr, boolean z, ET et, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            et = ET.i;
        }
        c0402Cr.l0(z, et);
    }

    public final void L(EnumC4069ul enumC4069ul, EnumC4069ul enumC4069ul2, IOException iOException) {
        int i2;
        Object[] array;
        AbstractC4492zt.h(enumC4069ul, "connectionCode");
        AbstractC4492zt.h(enumC4069ul2, "streamCode");
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            k0(enumC4069ul);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.c.isEmpty()) {
                    array = null;
                } else {
                    array = this.c.values().toArray(new C0528Fr[0]);
                    this.c.clear();
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        C0528Fr[] c0528FrArr = (C0528Fr[]) array;
        if (c0528FrArr != null) {
            for (C0528Fr c0528Fr : c0528FrArr) {
                try {
                    c0528Fr.d(enumC4069ul2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.D.close();
        } catch (IOException unused3) {
        }
        try {
            this.C.close();
        } catch (IOException unused4) {
        }
        this.i.n();
        this.j.n();
        this.k.n();
    }

    public final void M(IOException iOException) {
        EnumC4069ul enumC4069ul = EnumC4069ul.PROTOCOL_ERROR;
        L(enumC4069ul, enumC4069ul, iOException);
    }

    public final boolean N() {
        return this.a;
    }

    public final String O() {
        return this.d;
    }

    public final int P() {
        return this.e;
    }

    public final c Q() {
        return this.b;
    }

    public final int R() {
        return this.f;
    }

    public final SO S() {
        return this.w;
    }

    public final SO T() {
        return this.x;
    }

    public final synchronized C0528Fr U(int i2) {
        return (C0528Fr) this.c.get(Integer.valueOf(i2));
    }

    public final Map V() {
        return this.c;
    }

    public final long W() {
        return this.B;
    }

    public final C0554Gr X() {
        return this.D;
    }

    public final synchronized boolean Y(long j2) {
        if (this.g) {
            return false;
        }
        return this.t >= this.q || j2 < this.v;
    }

    public final C0528Fr Z(int i2, List list, boolean z) {
        int i3;
        C0528Fr c0528Fr;
        boolean z2 = true;
        boolean z3 = !z;
        synchronized (this.D) {
            try {
                synchronized (this) {
                    try {
                        if (this.f > 1073741823) {
                            k0(EnumC4069ul.REFUSED_STREAM);
                        }
                        if (this.g) {
                            throw new C0987Ve();
                        }
                        i3 = this.f;
                        this.f = i3 + 2;
                        c0528Fr = new C0528Fr(i3, this, z3, false, null);
                        if (z && this.A < this.B && c0528Fr.r() < c0528Fr.q()) {
                            z2 = false;
                        }
                        if (c0528Fr.u()) {
                            this.c.put(Integer.valueOf(i3), c0528Fr);
                        }
                        FW fw = FW.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i2 == 0) {
                    this.D.u(z3, i3, list);
                } else {
                    if (this.a) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.D.z(i2, i3, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z2) {
            this.D.flush();
        }
        return c0528Fr;
    }

    public final C0528Fr a0(List list, boolean z) {
        AbstractC4492zt.h(list, "requestHeaders");
        return Z(0, list, z);
    }

    public final void b0(int i2, L8 l8, int i3, boolean z) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        H8 h8 = new H8();
        long j2 = i3;
        l8.D(j2);
        l8.y(h8, j2);
        this.j.i(new e(this.d + '[' + i2 + "] onData", true, this, i2, h8, i3, z), 0L);
    }

    public final void c0(int i2, List list, boolean z) {
        AbstractC4492zt.h(list, "requestHeaders");
        this.j.i(new f(this.d + '[' + i2 + "] onHeaders", true, this, i2, list, z), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        L(EnumC4069ul.NO_ERROR, EnumC4069ul.CANCEL, null);
    }

    public final void d0(int i2, List list) {
        AbstractC4492zt.h(list, "requestHeaders");
        synchronized (this) {
            if (this.F.contains(Integer.valueOf(i2))) {
                s0(i2, EnumC4069ul.PROTOCOL_ERROR);
                return;
            }
            this.F.add(Integer.valueOf(i2));
            this.j.i(new g(this.d + '[' + i2 + "] onRequest", true, this, i2, list), 0L);
        }
    }

    public final void e0(int i2, EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "errorCode");
        this.j.i(new h(this.d + '[' + i2 + "] onReset", true, this, i2, enumC4069ul), 0L);
    }

    public final boolean f0(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final void flush() {
        this.D.flush();
    }

    public final synchronized C0528Fr g0(int i2) {
        C0528Fr c0528Fr;
        c0528Fr = (C0528Fr) this.c.remove(Integer.valueOf(i2));
        AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return c0528Fr;
    }

    public final void h0() {
        synchronized (this) {
            long j2 = this.t;
            long j3 = this.q;
            if (j2 < j3) {
                return;
            }
            this.q = j3 + 1;
            this.v = System.nanoTime() + ((long) 1000000000);
            FW fw = FW.a;
            this.i.i(new i(this.d + " ping", true, this), 0L);
        }
    }

    public final void i0(int i2) {
        this.e = i2;
    }

    public final void j0(SO so) {
        AbstractC4492zt.h(so, "<set-?>");
        this.x = so;
    }

    public final void k0(EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "statusCode");
        synchronized (this.D) {
            MJ mj = new MJ();
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                int i2 = this.e;
                mj.a = i2;
                FW fw = FW.a;
                this.D.t(i2, enumC4069ul, AbstractC3724qX.a);
            }
        }
    }

    public final void l0(boolean z, ET et) {
        AbstractC4492zt.h(et, "taskRunner");
        if (z) {
            this.D.d();
            this.D.C(this.w);
            int iC = this.w.c();
            if (iC != 65535) {
                this.D.F(0, iC - 65535);
            }
        }
        et.i().i(new CT(this.d, true, this.E), 0L);
    }

    public final synchronized void n0(long j2) {
        long j3 = this.y + j2;
        this.y = j3;
        long j4 = j3 - this.z;
        if (j4 >= this.w.c() / 2) {
            t0(0, j4);
            this.z += j4;
        }
    }

    public final void o0(int i2, boolean z, H8 h8, long j2) {
        long j3;
        long j4;
        int iMin;
        long j5;
        if (j2 == 0) {
            this.D.g(z, i2, h8, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j3 = this.A;
                            j4 = this.B;
                            if (j3 >= j4) {
                                if (!this.c.containsKey(Integer.valueOf(i2))) {
                                    throw new IOException("stream closed");
                                }
                                AbstractC4492zt.f(this, "null cannot be cast to non-null type java.lang.Object");
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    throw th;
                }
                iMin = Math.min((int) Math.min(j2, j4 - j3), this.D.v());
                j5 = iMin;
                this.A += j5;
                FW fw = FW.a;
            }
            j2 -= j5;
            this.D.g(z && j2 == 0, i2, h8, iMin);
        }
    }

    public final void p0(int i2, boolean z, List list) {
        AbstractC4492zt.h(list, "alternating");
        this.D.u(z, i2, list);
    }

    public final void q0(boolean z, int i2, int i3) {
        try {
            this.D.x(z, i2, i3);
        } catch (IOException e2) {
            M(e2);
        }
    }

    public final void r0(int i2, EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "statusCode");
        this.D.A(i2, enumC4069ul);
    }

    public final void s0(int i2, EnumC4069ul enumC4069ul) {
        AbstractC4492zt.h(enumC4069ul, "errorCode");
        this.i.i(new k(this.d + '[' + i2 + "] writeSynReset", true, this, i2, enumC4069ul), 0L);
    }

    public final void t0(int i2, long j2) {
        this.i.i(new l(this.d + '[' + i2 + "] windowUpdate", true, this, i2, j2), 0L);
    }

    /* JADX INFO: renamed from: Cr$d */
    public final class d implements C0454Er.c, InterfaceC3588op {
        public final C0454Er a;
        public final /* synthetic */ C0402Cr b;

        /* JADX INFO: renamed from: Cr$d$a */
        public static final class a extends AbstractC4124vT {
            public final /* synthetic */ C0402Cr e;
            public final /* synthetic */ OJ f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z, C0402Cr c0402Cr, OJ oj) {
                super(str, z);
                this.e = c0402Cr;
                this.f = oj;
            }

            @Override // defpackage.AbstractC4124vT
            public long f() {
                this.e.Q().a(this.e, (SO) this.f.a);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: Cr$d$b */
        public static final class b extends AbstractC4124vT {
            public final /* synthetic */ C0402Cr e;
            public final /* synthetic */ C0528Fr f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z, C0402Cr c0402Cr, C0528Fr c0528Fr) {
                super(str, z);
                this.e = c0402Cr;
                this.f = c0528Fr;
            }

            @Override // defpackage.AbstractC4124vT
            public long f() {
                try {
                    this.e.Q().b(this.f);
                    return -1L;
                } catch (IOException e) {
                    EG.a.g().j("Http2Connection.Listener failure for " + this.e.O(), 4, e);
                    try {
                        this.f.d(EnumC4069ul.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: Cr$d$c */
        public static final class c extends AbstractC4124vT {
            public final /* synthetic */ C0402Cr e;
            public final /* synthetic */ int f;
            public final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z, C0402Cr c0402Cr, int i, int i2) {
                super(str, z);
                this.e = c0402Cr;
                this.f = i;
                this.g = i2;
            }

            @Override // defpackage.AbstractC4124vT
            public long f() {
                this.e.q0(true, this.f, this.g);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: Cr$d$d, reason: collision with other inner class name */
        public static final class C0002d extends AbstractC4124vT {
            public final /* synthetic */ d e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ SO g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0002d(String str, boolean z, d dVar, boolean z2, SO so) {
                super(str, z);
                this.e = dVar;
                this.f = z2;
                this.g = so;
            }

            @Override // defpackage.AbstractC4124vT
            public long f() {
                this.e.k(this.f, this.g);
                return -1L;
            }
        }

        public d(C0402Cr c0402Cr, C0454Er c0454Er) {
            AbstractC4492zt.h(c0454Er, "reader");
            this.b = c0402Cr;
            this.a = c0454Er;
        }

        @Override // defpackage.C0454Er.c
        public void a(int i, EnumC4069ul enumC4069ul, W8 w8) {
            int i2;
            Object[] array;
            AbstractC4492zt.h(enumC4069ul, "errorCode");
            AbstractC4492zt.h(w8, "debugData");
            w8.u();
            C0402Cr c0402Cr = this.b;
            synchronized (c0402Cr) {
                array = c0402Cr.V().values().toArray(new C0528Fr[0]);
                c0402Cr.g = true;
                FW fw = FW.a;
            }
            for (C0528Fr c0528Fr : (C0528Fr[]) array) {
                if (c0528Fr.j() > i && c0528Fr.t()) {
                    c0528Fr.y(EnumC4069ul.REFUSED_STREAM);
                    this.b.g0(c0528Fr.j());
                }
            }
        }

        @Override // defpackage.C0454Er.c
        public void c(int i, EnumC4069ul enumC4069ul) {
            AbstractC4492zt.h(enumC4069ul, "errorCode");
            if (this.b.f0(i)) {
                this.b.e0(i, enumC4069ul);
                return;
            }
            C0528Fr c0528FrG0 = this.b.g0(i);
            if (c0528FrG0 != null) {
                c0528FrG0.y(enumC4069ul);
            }
        }

        @Override // defpackage.C0454Er.c
        public void d(boolean z, int i, int i2, List list) {
            AbstractC4492zt.h(list, "headerBlock");
            if (this.b.f0(i)) {
                this.b.c0(i, list, z);
                return;
            }
            C0402Cr c0402Cr = this.b;
            synchronized (c0402Cr) {
                C0528Fr c0528FrU = c0402Cr.U(i);
                if (c0528FrU != null) {
                    FW fw = FW.a;
                    c0528FrU.x(AbstractC3724qX.P(list), z);
                    return;
                }
                if (c0402Cr.g) {
                    return;
                }
                if (i <= c0402Cr.P()) {
                    return;
                }
                if (i % 2 == c0402Cr.R() % 2) {
                    return;
                }
                C0528Fr c0528Fr = new C0528Fr(i, c0402Cr, false, z, AbstractC3724qX.P(list));
                c0402Cr.i0(i);
                c0402Cr.V().put(Integer.valueOf(i), c0528Fr);
                c0402Cr.h.i().i(new b(c0402Cr.O() + '[' + i + "] onStream", true, c0402Cr, c0528Fr), 0L);
            }
        }

        @Override // defpackage.C0454Er.c
        public void e(boolean z, int i, L8 l8, int i2) {
            AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
            if (this.b.f0(i)) {
                this.b.b0(i, l8, i2, z);
                return;
            }
            C0528Fr c0528FrU = this.b.U(i);
            if (c0528FrU == null) {
                this.b.s0(i, EnumC4069ul.PROTOCOL_ERROR);
                long j = i2;
                this.b.n0(j);
                l8.skip(j);
                return;
            }
            c0528FrU.w(l8, i2);
            if (z) {
                c0528FrU.x(AbstractC3724qX.b, true);
            }
        }

        @Override // defpackage.C0454Er.c
        public void f(int i, long j) {
            if (i == 0) {
                C0402Cr c0402Cr = this.b;
                synchronized (c0402Cr) {
                    c0402Cr.B = c0402Cr.W() + j;
                    AbstractC4492zt.f(c0402Cr, "null cannot be cast to non-null type java.lang.Object");
                    c0402Cr.notifyAll();
                    FW fw = FW.a;
                }
                return;
            }
            C0528Fr c0528FrU = this.b.U(i);
            if (c0528FrU != null) {
                synchronized (c0528FrU) {
                    c0528FrU.a(j);
                    FW fw2 = FW.a;
                }
            }
        }

        @Override // defpackage.C0454Er.c
        public void g(boolean z, int i, int i2) {
            if (!z) {
                this.b.i.i(new c(this.b.O() + " ping", true, this.b, i, i2), 0L);
                return;
            }
            C0402Cr c0402Cr = this.b;
            synchronized (c0402Cr) {
                try {
                    if (i == 1) {
                        c0402Cr.p++;
                    } else if (i != 2) {
                        if (i == 3) {
                            c0402Cr.u++;
                            AbstractC4492zt.f(c0402Cr, "null cannot be cast to non-null type java.lang.Object");
                            c0402Cr.notifyAll();
                        }
                        FW fw = FW.a;
                    } else {
                        c0402Cr.t++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // defpackage.C0454Er.c
        public void i(boolean z, SO so) {
            AbstractC4492zt.h(so, "settings");
            this.b.i.i(new C0002d(this.b.O() + " applyAndAckSettings", true, this, z, so), 0L);
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            l();
            return FW.a;
        }

        @Override // defpackage.C0454Er.c
        public void j(int i, int i2, List list) {
            AbstractC4492zt.h(list, "requestHeaders");
            this.b.d0(i2, list);
        }

        public final void k(boolean z, SO so) {
            long jC;
            int i;
            C0528Fr[] c0528FrArr;
            AbstractC4492zt.h(so, "settings");
            OJ oj = new OJ();
            C0554Gr c0554GrX = this.b.X();
            C0402Cr c0402Cr = this.b;
            synchronized (c0554GrX) {
                synchronized (c0402Cr) {
                    try {
                        SO soT = c0402Cr.T();
                        if (!z) {
                            SO so2 = new SO();
                            so2.g(soT);
                            so2.g(so);
                            so = so2;
                        }
                        oj.a = so;
                        jC = ((long) so.c()) - ((long) soT.c());
                        c0528FrArr = (jC == 0 || c0402Cr.V().isEmpty()) ? null : (C0528Fr[]) c0402Cr.V().values().toArray(new C0528Fr[0]);
                        c0402Cr.j0((SO) oj.a);
                        c0402Cr.k.i(new a(c0402Cr.O() + " onSettings", true, c0402Cr, oj), 0L);
                        FW fw = FW.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    c0402Cr.X().c((SO) oj.a);
                } catch (IOException e) {
                    c0402Cr.M(e);
                }
                FW fw2 = FW.a;
            }
            if (c0528FrArr != null) {
                for (C0528Fr c0528Fr : c0528FrArr) {
                    synchronized (c0528Fr) {
                        c0528Fr.a(jC);
                        FW fw3 = FW.a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [ul] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [Er, java.io.Closeable] */
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
        public void l() throws Throwable {
            EnumC4069ul enumC4069ul;
            EnumC4069ul enumC4069ul2 = EnumC4069ul.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.a.g(this);
                    while (this.a.d(false, this)) {
                    }
                    EnumC4069ul enumC4069ul3 = EnumC4069ul.NO_ERROR;
                    try {
                        this.b.L(enumC4069ul3, EnumC4069ul.CANCEL, null);
                        enumC4069ul = enumC4069ul3;
                    } catch (IOException e2) {
                        e = e2;
                        EnumC4069ul enumC4069ul4 = EnumC4069ul.PROTOCOL_ERROR;
                        C0402Cr c0402Cr = this.b;
                        c0402Cr.L(enumC4069ul4, enumC4069ul4, e);
                        enumC4069ul = c0402Cr;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.b.L(enumC4069ul, enumC4069ul2, e);
                    AbstractC3724qX.m(this.a);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                enumC4069ul = enumC4069ul2;
                this.b.L(enumC4069ul, enumC4069ul2, e);
                AbstractC3724qX.m(this.a);
                throw th;
            }
            enumC4069ul2 = this.a;
            AbstractC3724qX.m(enumC4069ul2);
        }

        @Override // defpackage.C0454Er.c
        public void b() {
        }

        @Override // defpackage.C0454Er.c
        public void h(int i, int i2, int i3, boolean z) {
        }
    }
}
