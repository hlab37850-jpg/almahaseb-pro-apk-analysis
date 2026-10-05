package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class DT {
    public final ET a;
    public final String b;
    public boolean c;
    public AbstractC4124vT d;
    public final List e;
    public boolean f;

    public DT(ET et, String str) {
        AbstractC4492zt.h(et, "taskRunner");
        AbstractC4492zt.h(str, "name");
        this.a = et;
        this.b = str;
        this.e = new ArrayList();
    }

    public static /* synthetic */ void j(DT dt, AbstractC4124vT abstractC4124vT, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        dt.i(abstractC4124vT, j);
    }

    public final void a() {
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.a) {
            try {
                if (b()) {
                    this.a.h(this);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        AbstractC4124vT abstractC4124vT = this.d;
        if (abstractC4124vT != null) {
            AbstractC4492zt.e(abstractC4124vT);
            if (abstractC4124vT.a()) {
                this.f = true;
            }
        }
        boolean z = false;
        for (int size = this.e.size() - 1; -1 < size; size--) {
            if (((AbstractC4124vT) this.e.get(size)).a()) {
                AbstractC4124vT abstractC4124vT2 = (AbstractC4124vT) this.e.get(size);
                if (ET.h.a().isLoggable(Level.FINE)) {
                    BT.c(abstractC4124vT2, this, "canceled");
                }
                this.e.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final AbstractC4124vT c() {
        return this.d;
    }

    public final boolean d() {
        return this.f;
    }

    public final List e() {
        return this.e;
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public final ET h() {
        return this.a;
    }

    public final void i(AbstractC4124vT abstractC4124vT, long j) {
        AbstractC4492zt.h(abstractC4124vT, "task");
        synchronized (this.a) {
            if (!this.c) {
                if (k(abstractC4124vT, j, false)) {
                    this.a.h(this);
                }
                FW fw = FW.a;
            } else if (abstractC4124vT.a()) {
                if (ET.h.a().isLoggable(Level.FINE)) {
                    BT.c(abstractC4124vT, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (ET.h.a().isLoggable(Level.FINE)) {
                    BT.c(abstractC4124vT, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean k(AbstractC4124vT abstractC4124vT, long j, boolean z) {
        String str;
        AbstractC4492zt.h(abstractC4124vT, "task");
        abstractC4124vT.e(this);
        long jNanoTime = this.a.g().nanoTime();
        long j2 = jNanoTime + j;
        int iIndexOf = this.e.indexOf(abstractC4124vT);
        if (iIndexOf != -1) {
            if (abstractC4124vT.c() <= j2) {
                if (ET.h.a().isLoggable(Level.FINE)) {
                    BT.c(abstractC4124vT, this, "already scheduled");
                }
                return false;
            }
            this.e.remove(iIndexOf);
        }
        abstractC4124vT.g(j2);
        if (ET.h.a().isLoggable(Level.FINE)) {
            if (z) {
                str = "run again after " + BT.b(j2 - jNanoTime);
            } else {
                str = "scheduled after " + BT.b(j2 - jNanoTime);
            }
            BT.c(abstractC4124vT, this, str);
        }
        Iterator it = this.e.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((AbstractC4124vT) it.next()).c() - jNanoTime > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.e.size();
        }
        this.e.add(size, abstractC4124vT);
        return size == 0;
    }

    public final void l(AbstractC4124vT abstractC4124vT) {
        this.d = abstractC4124vT;
    }

    public final void m(boolean z) {
        this.f = z;
    }

    public final void n() {
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.a) {
            try {
                this.c = true;
                if (b()) {
                    this.a.h(this);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return this.b;
    }
}
