package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import com.itextpdf.text.pdf.Barcode128;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: cg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorC1894cg implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    public final int a;
    public final int b;
    public final long c;
    volatile /* synthetic */ long controlState;
    public final String d;
    public final C3261kq e;
    public final C3261kq f;
    public final C4359yL g;
    private volatile /* synthetic */ long parkedWorkersStack;
    public static final a h = new a(null);
    public static final YS l = new YS("NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(ExecutorC1894cg.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(ExecutorC1894cg.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(ExecutorC1894cg.class, "_isTerminated");

    /* JADX INFO: renamed from: cg$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: cg$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    /* JADX INFO: renamed from: cg$d */
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public ExecutorC1894cg(int i2, int i3, long j2, String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.e = new C3261kq();
        this.f = new C3261kq();
        this.parkedWorkersStack = 0L;
        this.g = new C4359yL(i2 + 1);
        this.controlState = ((long) i2) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ boolean J(ExecutorC1894cg executorC1894cg, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = executorC1894cg.controlState;
        }
        return executorC1894cg.I(j2);
    }

    public static /* synthetic */ void t(ExecutorC1894cg executorC1894cg, Runnable runnable, InterfaceC4286xT interfaceC4286xT, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC4286xT = FT.f;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        executorC1894cg.r(runnable, interfaceC4286xT, z);
    }

    public final void A(AbstractRunnableC4205wT abstractRunnableC4205wT) {
        try {
            abstractRunnableC4205wT.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                AbstractC3761r0.a();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    public final void C(long j2) throws InterruptedException {
        int i2;
        AbstractRunnableC4205wT abstractRunnableC4205wTF;
        if (k.compareAndSet(this, 0, 1)) {
            c cVarI = i();
            synchronized (this.g) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    Object objB = this.g.b(i3);
                    AbstractC4492zt.e(objB);
                    c cVar = (c) objB;
                    if (cVar != cVarI) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j2);
                        }
                        cVar.a.g(this.f);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.f.b();
            this.e.b();
            while (true) {
                if (cVarI == null) {
                    abstractRunnableC4205wTF = (AbstractRunnableC4205wT) this.e.d();
                    if (abstractRunnableC4205wTF == null && (abstractRunnableC4205wTF = (AbstractRunnableC4205wT) this.f.d()) == null) {
                        break;
                    }
                } else {
                    abstractRunnableC4205wTF = cVarI.f(true);
                    if (abstractRunnableC4205wTF == null) {
                        abstractRunnableC4205wTF = (AbstractRunnableC4205wT) this.e.d();
                        if (abstractRunnableC4205wTF == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                A(abstractRunnableC4205wTF);
            }
            if (cVarI != null) {
                cVarI.s(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void F(boolean z) {
        long jAddAndGet = j.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (z || K() || I(jAddAndGet)) {
            return;
        }
        K();
    }

    public final void G() {
        if (K() || J(this, 0L, 1, null)) {
            return;
        }
        K();
    }

    public final AbstractRunnableC4205wT H(c cVar, AbstractRunnableC4205wT abstractRunnableC4205wT, boolean z) {
        if (cVar == null || cVar.b == d.TERMINATED) {
            return abstractRunnableC4205wT;
        }
        if (abstractRunnableC4205wT.b.b() == 0 && cVar.b == d.BLOCKING) {
            return abstractRunnableC4205wT;
        }
        cVar.f = true;
        return cVar.a.a(abstractRunnableC4205wT, z);
    }

    public final boolean I(long j2) {
        if (AbstractC3871sJ.d(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.a) {
            int iD = d();
            if (iD == 1 && this.a > 1) {
                d();
            }
            if (iD > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean K() {
        c cVarV;
        do {
            cVarV = v();
            if (cVarV == null) {
                return false;
            }
        } while (!c.h.compareAndSet(cVarV, -1, 0));
        LockSupport.unpark(cVarV);
        return true;
    }

    public final boolean c(AbstractRunnableC4205wT abstractRunnableC4205wT) {
        return abstractRunnableC4205wT.b.b() == 1 ? this.f.a(abstractRunnableC4205wT) : this.e.a(abstractRunnableC4205wT);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        C(WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public final int d() {
        synchronized (this.g) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int iD = AbstractC3871sJ.d(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iD >= this.a) {
                return 0;
            }
            if (i2 >= this.b) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 <= 0 || this.g.b(i3) != null) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            c cVar = new c(this, i3);
            this.g.c(i3, cVar);
            if (i3 != ((int) (2097151 & j.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            cVar.start();
            return iD + 1;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        t(this, runnable, null, false, 6, null);
    }

    public final AbstractRunnableC4205wT g(Runnable runnable, InterfaceC4286xT interfaceC4286xT) {
        long jA = FT.e.a();
        if (!(runnable instanceof AbstractRunnableC4205wT)) {
            return new AT(runnable, jA, interfaceC4286xT);
        }
        AbstractRunnableC4205wT abstractRunnableC4205wT = (AbstractRunnableC4205wT) runnable;
        abstractRunnableC4205wT.a = jA;
        abstractRunnableC4205wT.b = interfaceC4286xT;
        return abstractRunnableC4205wT;
    }

    public final c i() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !AbstractC4492zt.d(ExecutorC1894cg.this, this)) {
            return null;
        }
        return cVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void r(Runnable runnable, InterfaceC4286xT interfaceC4286xT, boolean z) {
        AbstractC3761r0.a();
        AbstractRunnableC4205wT abstractRunnableC4205wTG = g(runnable, interfaceC4286xT);
        c cVarI = i();
        AbstractRunnableC4205wT abstractRunnableC4205wTH = H(cVarI, abstractRunnableC4205wTG, z);
        if (abstractRunnableC4205wTH != null && !c(abstractRunnableC4205wTH)) {
            throw new RejectedExecutionException(this.d + " was terminated");
        }
        boolean z2 = z && cVarI != null;
        if (abstractRunnableC4205wTG.b.b() != 0) {
            F(z2);
        } else {
            if (z2) {
                return;
            }
            G();
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.g.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            c cVar = (c) this.g.b(i7);
            if (cVar != null) {
                int iF = cVar.a.f();
                int i8 = b.a[cVar.b.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iF);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append(Barcode128.CODE_AB_TO_C);
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i5++;
                    if (iF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iF);
                        sb3.append(Barcode128.CODE_AC_TO_B);
                        arrayList.add(sb3.toString());
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.d + '@' + AbstractC3498ni.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final int u(c cVar) {
        Object objH = cVar.h();
        while (objH != l) {
            if (objH == null) {
                return 0;
            }
            c cVar2 = (c) objH;
            int iG = cVar2.g();
            if (iG != 0) {
                return iG;
            }
            objH = cVar2.h();
        }
        return -1;
    }

    public final c v() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            c cVar = (c) this.g.b((int) (2097151 & j2));
            if (cVar == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            int iU = u(cVar);
            if (iU >= 0 && i.compareAndSet(this, j2, ((long) iU) | j3)) {
                cVar.p(l);
                return cVar;
            }
        }
    }

    public final boolean x(c cVar) {
        long j2;
        long j3;
        int iG;
        if (cVar.h() != l) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            iG = cVar.g();
            cVar.p(this.g.b((int) (2097151 & j2)));
        } while (!i.compareAndSet(this, j2, j3 | ((long) iG)));
        return true;
    }

    public final void z(c cVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iU = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (iU == i2) {
                iU = i3 == 0 ? u(cVar) : i3;
            }
            if (iU >= 0 && i.compareAndSet(this, j2, j3 | ((long) iU))) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: cg$c */
    public final class c extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        public final KZ a;
        public d b;
        public long c;
        public long d;
        public int e;
        public boolean f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.a = new KZ();
            this.b = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = ExecutorC1894cg.l;
            this.e = AbstractC3465nJ.a.b();
        }

        public final void b(int i) {
            if (i == 0) {
                return;
            }
            ExecutorC1894cg.j.addAndGet(ExecutorC1894cg.this, -2097152L);
            if (this.b != d.TERMINATED) {
                this.b = d.DORMANT;
            }
        }

        public final void c(int i) {
            if (i != 0 && s(d.BLOCKING)) {
                ExecutorC1894cg.this.G();
            }
        }

        public final void d(AbstractRunnableC4205wT abstractRunnableC4205wT) {
            int iB = abstractRunnableC4205wT.b.b();
            i(iB);
            c(iB);
            ExecutorC1894cg.this.A(abstractRunnableC4205wT);
            b(iB);
        }

        public final AbstractRunnableC4205wT e(boolean z) {
            AbstractRunnableC4205wT abstractRunnableC4205wTM;
            AbstractRunnableC4205wT abstractRunnableC4205wTM2;
            if (z) {
                boolean z2 = k(ExecutorC1894cg.this.a * 2) == 0;
                if (z2 && (abstractRunnableC4205wTM2 = m()) != null) {
                    return abstractRunnableC4205wTM2;
                }
                AbstractRunnableC4205wT abstractRunnableC4205wTH = this.a.h();
                if (abstractRunnableC4205wTH != null) {
                    return abstractRunnableC4205wTH;
                }
                if (!z2 && (abstractRunnableC4205wTM = m()) != null) {
                    return abstractRunnableC4205wTM;
                }
            } else {
                AbstractRunnableC4205wT abstractRunnableC4205wTM3 = m();
                if (abstractRunnableC4205wTM3 != null) {
                    return abstractRunnableC4205wTM3;
                }
            }
            return t(false);
        }

        public final AbstractRunnableC4205wT f(boolean z) {
            AbstractRunnableC4205wT abstractRunnableC4205wTH;
            if (q()) {
                return e(z);
            }
            if (!z || (abstractRunnableC4205wTH = this.a.h()) == null) {
                abstractRunnableC4205wTH = (AbstractRunnableC4205wT) ExecutorC1894cg.this.f.d();
            }
            return abstractRunnableC4205wTH == null ? t(true) : abstractRunnableC4205wTH;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final void i(int i) {
            this.c = 0L;
            if (this.b == d.PARKING) {
                this.b = d.BLOCKING;
            }
        }

        public final boolean j() {
            return this.nextParkedWorker != ExecutorC1894cg.l;
        }

        public final int k(int i) {
            int i2 = this.e;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.e = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final void l() {
            if (this.c == 0) {
                this.c = System.nanoTime() + ExecutorC1894cg.this.c;
            }
            LockSupport.parkNanos(ExecutorC1894cg.this.c);
            if (System.nanoTime() - this.c >= 0) {
                this.c = 0L;
                u();
            }
        }

        public final AbstractRunnableC4205wT m() {
            if (k(2) == 0) {
                AbstractRunnableC4205wT abstractRunnableC4205wT = (AbstractRunnableC4205wT) ExecutorC1894cg.this.e.d();
                return abstractRunnableC4205wT != null ? abstractRunnableC4205wT : (AbstractRunnableC4205wT) ExecutorC1894cg.this.f.d();
            }
            AbstractRunnableC4205wT abstractRunnableC4205wT2 = (AbstractRunnableC4205wT) ExecutorC1894cg.this.f.d();
            return abstractRunnableC4205wT2 != null ? abstractRunnableC4205wT2 : (AbstractRunnableC4205wT) ExecutorC1894cg.this.e.d();
        }

        public final void n() {
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    if (ExecutorC1894cg.this.isTerminated() || this.b == d.TERMINATED) {
                        break loop0;
                    }
                    AbstractRunnableC4205wT abstractRunnableC4205wTF = f(this.f);
                    if (abstractRunnableC4205wTF != null) {
                        this.d = 0L;
                        d(abstractRunnableC4205wTF);
                        break;
                    }
                    this.f = false;
                    if (this.d == 0) {
                        r();
                    } else {
                        if (z) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.d);
                            this.d = 0L;
                            break;
                        }
                        z = true;
                    }
                }
            }
            s(d.TERMINATED);
        }

        public final void o(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExecutorC1894cg.this.d);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            long j;
            if (this.b == d.CPU_ACQUIRED) {
                return true;
            }
            ExecutorC1894cg executorC1894cg = ExecutorC1894cg.this;
            do {
                j = executorC1894cg.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!ExecutorC1894cg.j.compareAndSet(executorC1894cg, j, j - 4398046511104L));
            this.b = d.CPU_ACQUIRED;
            return true;
        }

        public final void r() {
            if (!j()) {
                ExecutorC1894cg.this.x(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !ExecutorC1894cg.this.isTerminated() && this.b != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.b;
            boolean z = dVar2 == d.CPU_ACQUIRED;
            if (z) {
                ExecutorC1894cg.j.addAndGet(ExecutorC1894cg.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.b = dVar;
            }
            return z;
        }

        public final AbstractRunnableC4205wT t(boolean z) {
            int i = (int) (ExecutorC1894cg.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iK = k(i);
            ExecutorC1894cg executorC1894cg = ExecutorC1894cg.this;
            long jMin = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                iK++;
                if (iK > i) {
                    iK = 1;
                }
                c cVar = (c) executorC1894cg.g.b(iK);
                if (cVar != null && cVar != this) {
                    long jK = z ? this.a.k(cVar.a) : this.a.l(cVar.a);
                    if (jK == -1) {
                        return this.a.h();
                    }
                    if (jK > 0) {
                        jMin = Math.min(jMin, jK);
                    }
                }
            }
            if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
                jMin = 0;
            }
            this.d = jMin;
            return null;
        }

        public final void u() {
            ExecutorC1894cg executorC1894cg = ExecutorC1894cg.this;
            synchronized (executorC1894cg.g) {
                try {
                    if (executorC1894cg.isTerminated()) {
                        return;
                    }
                    if (((int) (executorC1894cg.controlState & 2097151)) <= executorC1894cg.a) {
                        return;
                    }
                    if (h.compareAndSet(this, -1, 1)) {
                        int i = this.indexInArray;
                        o(0);
                        executorC1894cg.z(this, i, 0);
                        int andDecrement = (int) (ExecutorC1894cg.j.getAndDecrement(executorC1894cg) & 2097151);
                        if (andDecrement != i) {
                            Object objB = executorC1894cg.g.b(andDecrement);
                            AbstractC4492zt.e(objB);
                            c cVar = (c) objB;
                            executorC1894cg.g.c(i, cVar);
                            cVar.o(i);
                            executorC1894cg.z(cVar, andDecrement, i);
                        }
                        executorC1894cg.g.c(andDecrement, null);
                        FW fw = FW.a;
                        this.b = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(ExecutorC1894cg executorC1894cg, int i) {
            this();
            o(i);
        }
    }
}
