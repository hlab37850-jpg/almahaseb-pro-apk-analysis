package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: El, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0448El extends AbstractC0522Fl implements InterfaceC1017Wi {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(AbstractC0448El.class, Object.class, "_queue");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(AbstractC0448El.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* JADX INFO: renamed from: El$a */
    public final class a extends c {
        public final InterfaceC4293xa c;

        public a(long j, InterfaceC4293xa interfaceC4293xa) {
            super(j);
            this.c = interfaceC4293xa;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.h(AbstractC0448El.this, FW.a);
        }

        @Override // defpackage.AbstractC0448El.c
        public String toString() {
            return super.toString() + this.c;
        }
    }

    /* JADX INFO: renamed from: El$b */
    public static final class b extends c {
        public final Runnable c;

        public b(long j, Runnable runnable) {
            super(j);
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }

        @Override // defpackage.AbstractC0448El.c
        public String toString() {
            return super.toString() + this.c;
        }
    }

    /* JADX INFO: renamed from: El$c */
    public static abstract class c implements Runnable, Comparable, InterfaceC0745Mj, BU {
        private volatile Object _heap;
        public long a;
        public int b = -1;

        public c(long j) {
            this.a = j;
        }

        @Override // defpackage.BU
        public AU a() {
            Object obj = this._heap;
            if (obj instanceof AU) {
                return (AU) obj;
            }
            return null;
        }

        @Override // defpackage.BU
        public void c(AU au) {
            if (this._heap == AbstractC0574Hl.a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = au;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j = this.a - cVar.a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // defpackage.InterfaceC0745Mj
        public final synchronized void dispose() {
            try {
                Object obj = this._heap;
                if (obj == AbstractC0574Hl.a) {
                    return;
                }
                d dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null) {
                    dVar.g(this);
                }
                this._heap = AbstractC0574Hl.a;
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized int e(long j, d dVar, AbstractC0448El abstractC0448El) {
            if (this._heap == AbstractC0574Hl.a) {
                return 2;
            }
            synchronized (dVar) {
                try {
                    c cVar = (c) dVar.b();
                    if (abstractC0448El.z()) {
                        return 1;
                    }
                    if (cVar == null) {
                        dVar.b = j;
                    } else {
                        long j2 = cVar.a;
                        if (j2 - j < 0) {
                            j = j2;
                        }
                        if (j - dVar.b > 0) {
                            dVar.b = j;
                        }
                    }
                    long j3 = this.a;
                    long j4 = dVar.b;
                    if (j3 - j4 < 0) {
                        this.a = j4;
                    }
                    dVar.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean f(long j) {
            return j - this.a >= 0;
        }

        @Override // defpackage.BU
        public int getIndex() {
            return this.b;
        }

        @Override // defpackage.BU
        public void setIndex(int i) {
            this.b = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    /* JADX INFO: renamed from: El$d */
    public static final class d extends AU {
        public long b;

        public d(long j) {
            this.b = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean z() {
        return this._isCompleted;
    }

    @Override // defpackage.AbstractC0422Dl
    public long K() {
        c cVar;
        if (super.K() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof C0585Hw)) {
                if (obj == AbstractC0574Hl.b) {
                    return LocationRequestCompat.PASSIVE_INTERVAL;
                }
                return 0L;
            }
            if (!((C0585Hw) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long j = cVar.a;
        AbstractC3761r0.a();
        return AbstractC3871sJ.e(j - System.nanoTime(), 0L);
    }

    @Override // defpackage.AbstractC0422Dl
    public long P() {
        BU buH;
        if (Q()) {
            return 0L;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            AbstractC3761r0.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    try {
                        BU buB = dVar.b();
                        buH = null;
                        if (buB != null) {
                            c cVar = (c) buB;
                            buH = cVar.f(jNanoTime) ? Z(cVar) : false ? dVar.h(0) : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((c) buH) != null);
        }
        Runnable runnableX = X();
        if (runnableX == null) {
            return K();
        }
        runnableX.run();
        return 0L;
    }

    public final void W() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (AbstractC2403i0.a(d, this, null, AbstractC0574Hl.b)) {
                    return;
                }
            } else if (obj instanceof C0585Hw) {
                ((C0585Hw) obj).d();
                return;
            } else {
                if (obj == AbstractC0574Hl.b) {
                    return;
                }
                C0585Hw c0585Hw = new C0585Hw(8, true);
                c0585Hw.a((Runnable) obj);
                if (AbstractC2403i0.a(d, this, obj, c0585Hw)) {
                    return;
                }
            }
        }
    }

    public final Runnable X() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof C0585Hw) {
                C0585Hw c0585Hw = (C0585Hw) obj;
                Object objJ = c0585Hw.j();
                if (objJ != C0585Hw.h) {
                    return (Runnable) objJ;
                }
                AbstractC2403i0.a(d, this, obj, c0585Hw.i());
            } else {
                if (obj == AbstractC0574Hl.b) {
                    return null;
                }
                if (AbstractC2403i0.a(d, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void Y(Runnable runnable) {
        if (Z(runnable)) {
            U();
        } else {
            RunnableC0519Fi.f.Y(runnable);
        }
    }

    public final boolean Z(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (z()) {
                return false;
            }
            if (obj == null) {
                if (AbstractC2403i0.a(d, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C0585Hw) {
                C0585Hw c0585Hw = (C0585Hw) obj;
                int iA = c0585Hw.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    AbstractC2403i0.a(d, this, obj, c0585Hw.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == AbstractC0574Hl.b) {
                    return false;
                }
                C0585Hw c0585Hw2 = new C0585Hw(8, true);
                c0585Hw2.a((Runnable) obj);
                c0585Hw2.a(runnable);
                if (AbstractC2403i0.a(d, this, obj, c0585Hw2)) {
                    return true;
                }
            }
        }
    }

    public boolean a0() {
        if (!O()) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof C0585Hw) {
                return ((C0585Hw) obj).g();
            }
            if (obj != AbstractC0574Hl.b) {
                return false;
            }
        }
        return true;
    }

    public final void b0() {
        c cVar;
        AbstractC3761r0.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null || (cVar = (c) dVar.i()) == null) {
                return;
            } else {
                T(jNanoTime, cVar);
            }
        }
    }

    public final void c0() {
        this._queue = null;
        this._delayed = null;
    }

    @Override // defpackage.InterfaceC1017Wi
    public InterfaceC0745Mj d(long j, Runnable runnable, InterfaceC0988Vf interfaceC0988Vf) {
        return InterfaceC1017Wi.a.a(this, j, runnable, interfaceC0988Vf);
    }

    public final void d0(long j, c cVar) {
        int iE0 = e0(j, cVar);
        if (iE0 == 0) {
            if (h0(cVar)) {
                U();
            }
        } else if (iE0 == 1) {
            T(j, cVar);
        } else if (iE0 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    @Override // defpackage.AbstractC1040Xf
    public final void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        Y(runnable);
    }

    public final int e0(long j, c cVar) {
        if (z()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            AbstractC2403i0.a(e, this, null, new d(j));
            Object obj = this._delayed;
            AbstractC4492zt.e(obj);
            dVar = (d) obj;
        }
        return cVar.e(j, dVar, this);
    }

    public final InterfaceC0745Mj f0(long j, Runnable runnable) {
        long jC = AbstractC0574Hl.c(j);
        if (jC >= 4611686018427387903L) {
            return DD.a;
        }
        AbstractC3761r0.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        d0(jNanoTime, bVar);
        return bVar;
    }

    @Override // defpackage.InterfaceC1017Wi
    public void g(long j, InterfaceC4293xa interfaceC4293xa) {
        long jC = AbstractC0574Hl.c(j);
        if (jC < 4611686018427387903L) {
            AbstractC3761r0.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, interfaceC4293xa);
            d0(jNanoTime, aVar);
            AbstractC0333Aa.a(interfaceC4293xa, aVar);
        }
    }

    public final void g0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    public final boolean h0(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar != null ? (c) dVar.e() : null) == cVar;
    }

    @Override // defpackage.AbstractC0422Dl
    public void shutdown() {
        C4459zU.a.c();
        g0(true);
        W();
        while (P() <= 0) {
        }
        b0();
    }
}
