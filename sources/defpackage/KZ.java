package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class KZ {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(KZ.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(KZ.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(KZ.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(KZ.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ AbstractRunnableC4205wT b(KZ kz, AbstractRunnableC4205wT abstractRunnableC4205wT, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return kz.a(abstractRunnableC4205wT, z);
    }

    public final AbstractRunnableC4205wT a(AbstractRunnableC4205wT abstractRunnableC4205wT, boolean z) {
        if (z) {
            return c(abstractRunnableC4205wT);
        }
        AbstractRunnableC4205wT abstractRunnableC4205wT2 = (AbstractRunnableC4205wT) b.getAndSet(this, abstractRunnableC4205wT);
        if (abstractRunnableC4205wT2 == null) {
            return null;
        }
        return c(abstractRunnableC4205wT2);
    }

    public final AbstractRunnableC4205wT c(AbstractRunnableC4205wT abstractRunnableC4205wT) {
        if (abstractRunnableC4205wT.b.b() == 1) {
            e.incrementAndGet(this);
        }
        if (e() == 127) {
            return abstractRunnableC4205wT;
        }
        int i = this.producerIndex & ShapeTypes.VERTICAL_SCROLL;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, abstractRunnableC4205wT);
        c.incrementAndGet(this);
        return null;
    }

    public final void d(AbstractRunnableC4205wT abstractRunnableC4205wT) {
        if (abstractRunnableC4205wT == null || abstractRunnableC4205wT.b.b() != 1) {
            return;
        }
        e.decrementAndGet(this);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(C3261kq c3261kq) {
        AbstractRunnableC4205wT abstractRunnableC4205wT = (AbstractRunnableC4205wT) b.getAndSet(this, null);
        if (abstractRunnableC4205wT != null) {
            c3261kq.a(abstractRunnableC4205wT);
        }
        while (j(c3261kq)) {
        }
    }

    public final AbstractRunnableC4205wT h() {
        AbstractRunnableC4205wT abstractRunnableC4205wT = (AbstractRunnableC4205wT) b.getAndSet(this, null);
        return abstractRunnableC4205wT == null ? i() : abstractRunnableC4205wT;
    }

    public final AbstractRunnableC4205wT i() {
        AbstractRunnableC4205wT abstractRunnableC4205wT;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & ShapeTypes.VERTICAL_SCROLL;
            if (d.compareAndSet(this, i, i + 1) && (abstractRunnableC4205wT = (AbstractRunnableC4205wT) this.a.getAndSet(i2, null)) != null) {
                d(abstractRunnableC4205wT);
                return abstractRunnableC4205wT;
            }
        }
    }

    public final boolean j(C3261kq c3261kq) {
        AbstractRunnableC4205wT abstractRunnableC4205wTI = i();
        if (abstractRunnableC4205wTI == null) {
            return false;
        }
        c3261kq.a(abstractRunnableC4205wTI);
        return true;
    }

    public final long k(KZ kz) {
        int i = kz.producerIndex;
        AtomicReferenceArray atomicReferenceArray = kz.a;
        for (int i2 = kz.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & ShapeTypes.VERTICAL_SCROLL;
            if (kz.blockingTasksInBuffer == 0) {
                break;
            }
            AbstractRunnableC4205wT abstractRunnableC4205wT = (AbstractRunnableC4205wT) atomicReferenceArray.get(i3);
            if (abstractRunnableC4205wT != null && abstractRunnableC4205wT.b.b() == 1 && CS.a(atomicReferenceArray, i3, abstractRunnableC4205wT, null)) {
                e.decrementAndGet(kz);
                b(this, abstractRunnableC4205wT, false, 2, null);
                return -1L;
            }
        }
        return m(kz, true);
    }

    public final long l(KZ kz) {
        AbstractRunnableC4205wT abstractRunnableC4205wTI = kz.i();
        if (abstractRunnableC4205wTI == null) {
            return m(kz, false);
        }
        b(this, abstractRunnableC4205wTI, false, 2, null);
        return -1L;
    }

    public final long m(KZ kz, boolean z) {
        AbstractRunnableC4205wT abstractRunnableC4205wT;
        do {
            abstractRunnableC4205wT = (AbstractRunnableC4205wT) kz.lastScheduledTask;
            if (abstractRunnableC4205wT == null) {
                return -2L;
            }
            if (z && abstractRunnableC4205wT.b.b() != 1) {
                return -2L;
            }
            long jA = FT.e.a() - abstractRunnableC4205wT.a;
            long j = FT.a;
            if (jA < j) {
                return j - jA;
            }
        } while (!AbstractC2403i0.a(b, kz, abstractRunnableC4205wT, null));
        b(this, abstractRunnableC4205wT, false, 2, null);
        return -1L;
    }
}
