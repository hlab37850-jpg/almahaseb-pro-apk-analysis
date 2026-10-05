package defpackage;

import androidx.compose.animation.core.AnimationKt;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: loaded from: classes3.dex */
public final class ET {
    public static final b h = new b(null);
    public static final ET i = new ET(new c(AbstractC3724qX.M(AbstractC3724qX.i + " TaskRunner", true)));
    public static final Logger j;
    public final a a;
    public int b;
    public boolean c;
    public long d;
    public final List e;
    public final List f;
    public final Runnable g;

    public interface a {
        void a(ET et);

        void b(ET et, long j);

        void execute(Runnable runnable);

        long nanoTime();
    }

    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Logger a() {
            return ET.j;
        }

        public b() {
        }
    }

    public static final class c implements a {
        public final ThreadPoolExecutor a;

        public c(ThreadFactory threadFactory) {
            AbstractC4492zt.h(threadFactory, "threadFactory");
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // ET.a
        public void a(ET et) {
            AbstractC4492zt.h(et, "taskRunner");
            et.notify();
        }

        @Override // ET.a
        public void b(ET et, long j) throws InterruptedException {
            AbstractC4492zt.h(et, "taskRunner");
            long j2 = j / AnimationKt.MillisToNanos;
            long j3 = j - (AnimationKt.MillisToNanos * j2);
            if (j2 > 0 || j > 0) {
                et.wait(j2, (int) j3);
            }
        }

        @Override // ET.a
        public void execute(Runnable runnable) {
            AbstractC4492zt.h(runnable, "runnable");
            this.a.execute(runnable);
        }

        @Override // ET.a
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4124vT abstractC4124vTD;
            long jNanoTime;
            while (true) {
                ET et = ET.this;
                synchronized (et) {
                    abstractC4124vTD = et.d();
                }
                if (abstractC4124vTD == null) {
                    return;
                }
                DT dtD = abstractC4124vTD.d();
                AbstractC4492zt.e(dtD);
                ET et2 = ET.this;
                boolean zIsLoggable = ET.h.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = dtD.h().g().nanoTime();
                    BT.c(abstractC4124vTD, dtD, "starting");
                } else {
                    jNanoTime = -1;
                }
                try {
                    et2.j(abstractC4124vTD);
                    try {
                        FW fw = FW.a;
                        if (zIsLoggable) {
                            BT.c(abstractC4124vTD, dtD, "finished run in " + BT.b(dtD.h().g().nanoTime() - jNanoTime));
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            BT.c(abstractC4124vTD, dtD, "failed a run in " + BT.b(dtD.h().g().nanoTime() - jNanoTime));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    et2.g().execute(this);
                    throw th2;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(ET.class.getName());
        AbstractC4492zt.g(logger, "getLogger(TaskRunner::class.java.name)");
        j = logger;
    }

    public ET(a aVar) {
        AbstractC4492zt.h(aVar, "backend");
        this.a = aVar;
        this.b = Constants.CP_MAC_ROMAN;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new d();
    }

    public final void c(AbstractC4124vT abstractC4124vT, long j2) {
        if (AbstractC3724qX.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        DT dtD = abstractC4124vT.d();
        AbstractC4492zt.e(dtD);
        if (dtD.c() != abstractC4124vT) {
            throw new IllegalStateException("Check failed.");
        }
        boolean zD = dtD.d();
        dtD.m(false);
        dtD.l(null);
        this.e.remove(dtD);
        if (j2 != -1 && !zD && !dtD.g()) {
            dtD.k(abstractC4124vT, j2, true);
        }
        if (dtD.e().isEmpty()) {
            return;
        }
        this.f.add(dtD);
    }

    public final AbstractC4124vT d() {
        boolean z;
        if (AbstractC3724qX.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.f.isEmpty()) {
            long jNanoTime = this.a.nanoTime();
            Iterator it = this.f.iterator();
            long jMin = LocationRequestCompat.PASSIVE_INTERVAL;
            AbstractC4124vT abstractC4124vT = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                AbstractC4124vT abstractC4124vT2 = (AbstractC4124vT) ((DT) it.next()).e().get(0);
                long jMax = Math.max(0L, abstractC4124vT2.c() - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (abstractC4124vT != null) {
                        z = true;
                        break;
                    }
                    abstractC4124vT = abstractC4124vT2;
                }
            }
            if (abstractC4124vT != null) {
                e(abstractC4124vT);
                if (z || (!this.c && !this.f.isEmpty())) {
                    this.a.execute(this.g);
                }
                return abstractC4124vT;
            }
            if (this.c) {
                if (jMin < this.d - jNanoTime) {
                    this.a.a(this);
                }
                return null;
            }
            this.c = true;
            this.d = jNanoTime + jMin;
            try {
                try {
                    this.a.b(this, jMin);
                } catch (InterruptedException unused) {
                    f();
                }
                this.c = false;
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
        return null;
    }

    public final void e(AbstractC4124vT abstractC4124vT) {
        if (AbstractC3724qX.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        abstractC4124vT.g(-1L);
        DT dtD = abstractC4124vT.d();
        AbstractC4492zt.e(dtD);
        dtD.e().remove(abstractC4124vT);
        this.f.remove(dtD);
        dtD.l(abstractC4124vT);
        this.e.add(dtD);
    }

    public final void f() {
        int size = this.e.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                ((DT) this.e.get(size)).b();
            }
        }
        for (int size2 = this.f.size() - 1; -1 < size2; size2--) {
            DT dt = (DT) this.f.get(size2);
            dt.b();
            if (dt.e().isEmpty()) {
                this.f.remove(size2);
            }
        }
    }

    public final a g() {
        return this.a;
    }

    public final void h(DT dt) {
        AbstractC4492zt.h(dt, "taskQueue");
        if (AbstractC3724qX.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (dt.c() == null) {
            if (dt.e().isEmpty()) {
                this.f.remove(dt);
            } else {
                AbstractC3724qX.c(this.f, dt);
            }
        }
        if (this.c) {
            this.a.a(this);
        } else {
            this.a.execute(this.g);
        }
    }

    public final DT i() {
        int i2;
        synchronized (this) {
            i2 = this.b;
            this.b = i2 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i2);
        return new DT(this, sb.toString());
    }

    public final void j(AbstractC4124vT abstractC4124vT) {
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(abstractC4124vT.b());
        try {
            long jF = abstractC4124vT.f();
            synchronized (this) {
                c(abstractC4124vT, jF);
                FW fw = FW.a;
            }
        } finally {
            synchronized (this) {
                c(abstractC4124vT, -1L);
                FW fw2 = FW.a;
                threadCurrentThread.setName(name);
            }
        }
    }
}
