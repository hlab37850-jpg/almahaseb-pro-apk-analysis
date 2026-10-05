package defpackage;

import androidx.core.app.NotificationCompat;
import com.itextpdf.tool.xml.html.HTML;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class DJ {
    public static final a f = new a(null);
    public final int a;
    public final long b;
    public final DT c;
    public final b d;
    public final ConcurrentLinkedQueue e;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends AbstractC4124vT {
        public b(String str) {
            super(str, false, 2, null);
        }

        @Override // defpackage.AbstractC4124vT
        public long f() {
            return DJ.this.b(System.nanoTime());
        }
    }

    public DJ(ET et, int i, long j, TimeUnit timeUnit) {
        AbstractC4492zt.h(et, "taskRunner");
        AbstractC4492zt.h(timeUnit, "timeUnit");
        this.a = i;
        this.b = timeUnit.toNanos(j);
        this.c = et.i();
        this.d = new b(AbstractC3724qX.i + " ConnectionPool");
        this.e = new ConcurrentLinkedQueue();
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0033 A[SYNTHETIC] */
    public final boolean a(C3846s2 c3846s2, BJ bj, List list, boolean z) {
        AbstractC4492zt.h(c3846s2, HTML.Tag.ADDRESS);
        AbstractC4492zt.h(bj, NotificationCompat.CATEGORY_CALL);
        for (CJ cj : this.e) {
            AbstractC4492zt.g(cj, "connection");
            synchronized (cj) {
                if (z) {
                    try {
                        if (cj.v()) {
                            if (cj.t(c3846s2, list)) {
                                bj.d(cj);
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (cj.t(c3846s2, list)) {
                    bj.d(cj);
                    return true;
                }
                FW fw = FW.a;
            }
        }
        return false;
    }

    public final long b(long j) {
        int i = 0;
        long j2 = Long.MIN_VALUE;
        CJ cj = null;
        int i2 = 0;
        for (CJ cj2 : this.e) {
            AbstractC4492zt.g(cj2, "connection");
            synchronized (cj2) {
                if (d(cj2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long jO = j - cj2.o();
                    if (jO > j2) {
                        cj = cj2;
                        j2 = jO;
                    }
                    FW fw = FW.a;
                }
            }
        }
        long j3 = this.b;
        if (j2 < j3 && i <= this.a) {
            if (i > 0) {
                return j3 - j2;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        AbstractC4492zt.e(cj);
        synchronized (cj) {
            if (!cj.n().isEmpty()) {
                return 0L;
            }
            if (cj.o() + j2 != j) {
                return 0L;
            }
            cj.D(true);
            this.e.remove(cj);
            AbstractC3724qX.n(cj.E());
            if (this.e.isEmpty()) {
                this.c.a();
            }
            return 0L;
        }
    }

    public final boolean c(CJ cj) {
        AbstractC4492zt.h(cj, "connection");
        if (AbstractC3724qX.h && !Thread.holdsLock(cj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + cj);
        }
        if (!cj.p() && this.a != 0) {
            DT.j(this.c, this.d, 0L, 2, null);
            return false;
        }
        cj.D(true);
        this.e.remove(cj);
        if (this.e.isEmpty()) {
            this.c.a();
        }
        return true;
    }

    public final int d(CJ cj, long j) {
        if (AbstractC3724qX.h && !Thread.holdsLock(cj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + cj);
        }
        List listN = cj.n();
        int i = 0;
        while (i < listN.size()) {
            Reference reference = (Reference) listN.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                AbstractC4492zt.f(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                EG.a.g().l("A connection to " + cj.A().a().l() + " was leaked. Did you forget to close a response body?", ((BJ.b) reference).a());
                listN.remove(i);
                cj.D(true);
                if (listN.isEmpty()) {
                    cj.C(j - this.b);
                    return 0;
                }
            }
        }
        return listN.size();
    }

    public final void e(CJ cj) {
        AbstractC4492zt.h(cj, "connection");
        if (!AbstractC3724qX.h || Thread.holdsLock(cj)) {
            this.e.add(cj);
            DT.j(this.c, this.d, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + cj);
    }
}
