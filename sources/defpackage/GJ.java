package defpackage;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class GJ implements InterfaceC2447iY, C3398mY.a {
    public final C3873sL a;
    public final AbstractC3234kY b;
    public final Random c;
    public final long d;
    public C3152jY e;
    public long f;
    public final String g;
    public InterfaceC2121ea h;
    public AbstractC4124vT i;
    public C3398mY j;
    public C3480nY k;
    public DT l;
    public String m;
    public d n;
    public final ArrayDeque o;
    public final ArrayDeque p;
    public long q;
    public boolean r;
    public int s;
    public String t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public static final b z = new b(null);
    public static final List A = AbstractC1805bc.e(EnumC4356yI.HTTP_1_1);

    public static final class a {
        public final int a;
        public final W8 b;
        public final long c;

        public a(int i, W8 w8, long j) {
            this.a = i;
            this.b = w8;
            this.c = j;
        }

        public final long a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final W8 c() {
            return this.b;
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public b() {
        }
    }

    public static final class c {
        public final int a;
        public final W8 b;

        public c(int i, W8 w8) {
            AbstractC4492zt.h(w8, "data");
            this.a = i;
            this.b = w8;
        }

        public final W8 a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }
    }

    public static abstract class d implements Closeable {
        public final boolean a;
        public final L8 b;
        public final K8 c;

        public d(boolean z, L8 l8, K8 k8) {
            AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
            AbstractC4492zt.h(k8, "sink");
            this.a = z;
            this.b = l8;
            this.c = k8;
        }

        public final boolean c() {
            return this.a;
        }

        public final K8 d() {
            return this.c;
        }

        public final L8 g() {
            return this.b;
        }
    }

    public final class e extends AbstractC4124vT {
        public e() {
            super(GJ.this.m + " writer", false, 2, null);
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            try {
                return GJ.this.x() ? 0L : -1L;
            } catch (IOException e) {
                GJ.this.q(e, null);
                return -1L;
            }
        }
    }

    public static final class f implements InterfaceC3318la {
        public final /* synthetic */ C3873sL b;

        public f(C3873sL c3873sL) {
            this.b = c3873sL;
        }

        @Override // defpackage.InterfaceC3318la
        public void a(InterfaceC2121ea interfaceC2121ea, EL el) {
            AbstractC4492zt.h(interfaceC2121ea, NotificationCompat.CATEGORY_CALL);
            AbstractC4492zt.h(el, "response");
            C0799Ol c0799OlT = el.t();
            try {
                GJ.this.n(el, c0799OlT);
                AbstractC4492zt.e(c0799OlT);
                d dVarN = c0799OlT.n();
                C3152jY c3152jYA = C3152jY.g.a(el.z());
                GJ.this.e = c3152jYA;
                if (!GJ.this.t(c3152jYA)) {
                    GJ gj = GJ.this;
                    synchronized (gj) {
                        gj.p.clear();
                        gj.d(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    GJ.this.s(AbstractC3724qX.i + " WebSocket " + this.b.i().o(), dVarN);
                    GJ.this.r().f(GJ.this, el);
                    GJ.this.u();
                } catch (Exception e) {
                    GJ.this.q(e, null);
                }
            } catch (IOException e2) {
                GJ.this.q(e2, el);
                AbstractC3724qX.m(el);
                if (c0799OlT != null) {
                    c0799OlT.v();
                }
            }
        }

        @Override // defpackage.InterfaceC3318la
        public void b(InterfaceC2121ea interfaceC2121ea, IOException iOException) {
            AbstractC4492zt.h(interfaceC2121ea, NotificationCompat.CATEGORY_CALL);
            AbstractC4492zt.h(iOException, "e");
            GJ.this.q(iOException, null);
        }
    }

    public static final class g extends AbstractC4124vT {
        public final /* synthetic */ GJ e;
        public final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, GJ gj, long j) {
            super(str, false, 2, null);
            this.e = gj;
            this.f = j;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            this.e.y();
            return this.f;
        }
    }

    public static final class h extends AbstractC4124vT {
        public final /* synthetic */ GJ e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, GJ gj) {
            super(str, z);
            this.e = gj;
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            this.e.m();
            return -1L;
        }
    }

    public GJ(ET et, C3873sL c3873sL, AbstractC3234kY abstractC3234kY, Random random, long j, C3152jY c3152jY, long j2) {
        AbstractC4492zt.h(et, "taskRunner");
        AbstractC4492zt.h(c3873sL, "originalRequest");
        AbstractC4492zt.h(abstractC3234kY, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AbstractC4492zt.h(random, "random");
        this.a = c3873sL;
        this.b = abstractC3234kY;
        this.c = random;
        this.d = j;
        this.e = c3152jY;
        this.f = j2;
        this.l = et.i();
        this.o = new ArrayDeque();
        this.p = new ArrayDeque();
        this.s = -1;
        if (!AbstractC4492zt.d(HttpMethods.GET, c3873sL.g())) {
            throw new IllegalArgumentException(("Request must be GET: " + c3873sL.g()).toString());
        }
        W8.a aVar = W8.d;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        FW fw = FW.a;
        this.g = W8.a.f(aVar, bArr, 0, 0, 3, null).a();
    }

    @Override // defpackage.InterfaceC2447iY
    public boolean a(String str) {
        AbstractC4492zt.h(str, "text");
        return w(W8.d.c(str), 1);
    }

    @Override // defpackage.C3398mY.a
    public synchronized void b(W8 w8) {
        AbstractC4492zt.h(w8, "payload");
        this.x++;
        this.y = false;
    }

    @Override // defpackage.C3398mY.a
    public void c(String str) {
        AbstractC4492zt.h(str, "text");
        this.b.e(this, str);
    }

    @Override // defpackage.InterfaceC2447iY
    public boolean d(int i, String str) {
        return o(i, str, 60000L);
    }

    @Override // defpackage.C3398mY.a
    public synchronized void e(W8 w8) {
        try {
            AbstractC4492zt.h(w8, "payload");
            if (!this.u && (!this.r || !this.p.isEmpty())) {
                this.o.add(w8);
                v();
                this.w++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.InterfaceC2447iY
    public boolean f(W8 w8) {
        AbstractC4492zt.h(w8, "bytes");
        return w(w8, 2);
    }

    @Override // defpackage.C3398mY.a
    public void g(int i, String str) {
        d dVar;
        C3398mY c3398mY;
        C3480nY c3480nY;
        AbstractC4492zt.h(str, "reason");
        if (i == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            try {
                if (this.s != -1) {
                    throw new IllegalStateException("already closed");
                }
                this.s = i;
                this.t = str;
                dVar = null;
                if (this.r && this.p.isEmpty()) {
                    d dVar2 = this.n;
                    this.n = null;
                    c3398mY = this.j;
                    this.j = null;
                    c3480nY = this.k;
                    this.k = null;
                    this.l.n();
                    dVar = dVar2;
                } else {
                    c3398mY = null;
                    c3480nY = null;
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            this.b.b(this, i, str);
            if (dVar != null) {
                this.b.a(this, i, str);
            }
        } finally {
            if (dVar != null) {
                AbstractC3724qX.m(dVar);
            }
            if (c3398mY != null) {
                AbstractC3724qX.m(c3398mY);
            }
            if (c3480nY != null) {
                AbstractC3724qX.m(c3480nY);
            }
        }
    }

    @Override // defpackage.C3398mY.a
    public void h(W8 w8) {
        AbstractC4492zt.h(w8, "bytes");
        this.b.d(this, w8);
    }

    public void m() {
        InterfaceC2121ea interfaceC2121ea = this.h;
        AbstractC4492zt.e(interfaceC2121ea);
        interfaceC2121ea.cancel();
    }

    public final void n(EL el, C0799Ol c0799Ol) throws ProtocolException {
        AbstractC4492zt.h(el, "response");
        if (el.r() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + el.r() + ' ' + el.C() + '\'');
        }
        String strX = EL.x(el, HttpHeaders.CONNECTION, null, 2, null);
        if (!AbstractC3880sS.q(HttpHeaders.UPGRADE, strX, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strX + '\'');
        }
        String strX2 = EL.x(el, HttpHeaders.UPGRADE, null, 2, null);
        if (!AbstractC3880sS.q("websocket", strX2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strX2 + '\'');
        }
        String strX3 = EL.x(el, HttpHeaders.SEC_WEBSOCKET_ACCEPT, null, 2, null);
        String strA = W8.d.c(this.g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").s().a();
        if (AbstractC4492zt.d(strA, strX3)) {
            if (c0799Ol == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + strX3 + '\'');
    }

    public final synchronized boolean o(int i, String str, long j) {
        W8 w8C;
        try {
            C3316lY.a.c(i);
            if (str != null) {
                w8C = W8.d.c(str);
                if (w8C.u() > 123) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            } else {
                w8C = null;
            }
            if (!this.u && !this.r) {
                this.r = true;
                this.p.add(new a(i, w8C, j));
                v();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void p(C4271xE c4271xE) {
        AbstractC4492zt.h(c4271xE, "client");
        if (this.a.d(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            q(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        C4271xE c4271xEA = c4271xE.z().b(AbstractC0396Cl.b).G(A).a();
        C3873sL c3873sLB = this.a.h().c(HttpHeaders.UPGRADE, "websocket").c(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).c(HttpHeaders.SEC_WEBSOCKET_KEY, this.g).c(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").c(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").b();
        BJ bj = new BJ(c4271xEA, c3873sLB, true);
        this.h = bj;
        AbstractC4492zt.e(bj);
        bj.c(new f(c3873sLB));
    }

    public final void q(Exception exc, EL el) {
        AbstractC4492zt.h(exc, "e");
        synchronized (this) {
            if (this.u) {
                return;
            }
            this.u = true;
            d dVar = this.n;
            this.n = null;
            C3398mY c3398mY = this.j;
            this.j = null;
            C3480nY c3480nY = this.k;
            this.k = null;
            this.l.n();
            FW fw = FW.a;
            try {
                this.b.c(this, exc, el);
            } finally {
                if (dVar != null) {
                    AbstractC3724qX.m(dVar);
                }
                if (c3398mY != null) {
                    AbstractC3724qX.m(c3398mY);
                }
                if (c3480nY != null) {
                    AbstractC3724qX.m(c3480nY);
                }
            }
        }
    }

    public final AbstractC3234kY r() {
        return this.b;
    }

    public final void s(String str, d dVar) {
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(dVar, "streams");
        C3152jY c3152jY = this.e;
        AbstractC4492zt.e(c3152jY);
        synchronized (this) {
            try {
                this.m = str;
                this.n = dVar;
                this.k = new C3480nY(dVar.c(), dVar.d(), this.c, c3152jY.a, c3152jY.a(dVar.c()), this.f);
                this.i = new e();
                long j = this.d;
                if (j != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    this.l.i(new g(str + " ping", this, nanos), nanos);
                }
                if (!this.p.isEmpty()) {
                    v();
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.j = new C3398mY(dVar.c(), dVar.g(), this, c3152jY.a, c3152jY.a(!dVar.c()));
    }

    public final boolean t(C3152jY c3152jY) {
        if (!c3152jY.f && c3152jY.b == null) {
            return c3152jY.d == null || new C1001Vs(8, 15).g(c3152jY.d.intValue());
        }
        return false;
    }

    public final void u() {
        while (this.s == -1) {
            C3398mY c3398mY = this.j;
            AbstractC4492zt.e(c3398mY);
            c3398mY.c();
        }
    }

    public final void v() {
        if (!AbstractC3724qX.h || Thread.holdsLock(this)) {
            AbstractC4124vT abstractC4124vT = this.i;
            if (abstractC4124vT != null) {
                DT.j(this.l, abstractC4124vT, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final synchronized boolean w(W8 w8, int i) {
        if (!this.u && !this.r) {
            if (this.q + ((long) w8.u()) > 16777216) {
                d(1001, null);
                return false;
            }
            this.q += (long) w8.u();
            this.p.add(new c(i, w8));
            v();
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007e A[Catch: all -> 0x0087, TRY_ENTER, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0089 A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008d A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b1 A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5 A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:54:0x00df A[Catch: all -> 0x0087, TRY_ENTER, TryCatch #0 {all -> 0x0087, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x008d, B:35:0x009d, B:37:0x00ac, B:40:0x00af, B:41:0x00b0, B:42:0x00b1, B:44:0x00b5, B:46:0x00c7, B:54:0x00df, B:55:0x00e4, B:36:0x009e), top: B:65:0x007c, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean x() {
        d dVar;
        String str;
        C3398mY c3398mY;
        C3480nY c3480nY;
        int i;
        c cVar;
        synchronized (this) {
            try {
                if (this.u) {
                    return false;
                }
                C3480nY c3480nY2 = this.k;
                Object objPoll = this.o.poll();
                Object obj = null;
                try {
                    if (objPoll == null) {
                        Object objPoll2 = this.p.poll();
                        if (objPoll2 instanceof a) {
                            i = this.s;
                            str = this.t;
                            if (i != -1) {
                                dVar = this.n;
                                this.n = null;
                                c3398mY = this.j;
                                this.j = null;
                                c3480nY = this.k;
                                this.k = null;
                                this.l.n();
                            } else {
                                long jA = ((a) objPoll2).a();
                                this.l.i(new h(this.m + " cancel", true, this), TimeUnit.MILLISECONDS.toNanos(jA));
                                dVar = null;
                                c3398mY = null;
                                c3480nY = null;
                            }
                            obj = objPoll2;
                        } else {
                            if (objPoll2 == null) {
                                return false;
                            }
                            dVar = null;
                            str = null;
                            c3398mY = null;
                            c3480nY = null;
                            obj = objPoll2;
                        }
                        FW fw = FW.a;
                        if (objPoll != null) {
                            AbstractC4492zt.e(c3480nY2);
                            c3480nY2.r((W8) objPoll);
                        } else if (obj instanceof c) {
                            cVar = (c) obj;
                            AbstractC4492zt.e(c3480nY2);
                            c3480nY2.g(cVar.b(), cVar.a());
                            synchronized (this) {
                                this.q -= (long) cVar.a().u();
                            }
                        } else {
                            if (obj instanceof a) {
                                throw new AssertionError();
                            }
                            a aVar = (a) obj;
                            AbstractC4492zt.e(c3480nY2);
                            c3480nY2.c(aVar.b(), aVar.c());
                            if (dVar != null) {
                                AbstractC3234kY abstractC3234kY = this.b;
                                AbstractC4492zt.e(str);
                                abstractC3234kY.a(this, i, str);
                            }
                        }
                        if (dVar != null) {
                            AbstractC3724qX.m(dVar);
                        }
                        if (c3398mY != null) {
                            AbstractC3724qX.m(c3398mY);
                        }
                        if (c3480nY != null) {
                            AbstractC3724qX.m(c3480nY);
                        }
                        return true;
                    }
                    dVar = null;
                    str = null;
                    c3398mY = null;
                    c3480nY = null;
                    if (objPoll != null) {
                        AbstractC4492zt.e(c3480nY2);
                        c3480nY2.r((W8) objPoll);
                    } else if (obj instanceof c) {
                        cVar = (c) obj;
                        AbstractC4492zt.e(c3480nY2);
                        c3480nY2.g(cVar.b(), cVar.a());
                        synchronized (this) {
                            this.q -= (long) cVar.a().u();
                        }
                    } else {
                        if (obj instanceof a) {
                            throw new AssertionError();
                        }
                        a aVar2 = (a) obj;
                        AbstractC4492zt.e(c3480nY2);
                        c3480nY2.c(aVar2.b(), aVar2.c());
                        if (dVar != null) {
                            AbstractC3234kY abstractC3234kY2 = this.b;
                            AbstractC4492zt.e(str);
                            abstractC3234kY2.a(this, i, str);
                        }
                    }
                    if (dVar != null) {
                        AbstractC3724qX.m(dVar);
                    }
                    if (c3398mY != null) {
                        AbstractC3724qX.m(c3398mY);
                    }
                    if (c3480nY != null) {
                        AbstractC3724qX.m(c3480nY);
                    }
                    return true;
                } catch (Throwable th) {
                    if (dVar != null) {
                        AbstractC3724qX.m(dVar);
                    }
                    if (c3398mY != null) {
                        AbstractC3724qX.m(c3398mY);
                    }
                    if (c3480nY != null) {
                        AbstractC3724qX.m(c3480nY);
                    }
                    throw th;
                }
                i = -1;
                FW fw2 = FW.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void y() {
        synchronized (this) {
            try {
                if (this.u) {
                    return;
                }
                C3480nY c3480nY = this.k;
                if (c3480nY == null) {
                    return;
                }
                int i = this.y ? this.v : -1;
                this.v++;
                this.y = true;
                FW fw = FW.a;
                if (i == -1) {
                    try {
                        c3480nY.i(W8.e);
                        return;
                    } catch (IOException e2) {
                        q(e2, null);
                        return;
                    }
                }
                q(new SocketTimeoutException("sent ping but didn't receive pong within " + this.d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
