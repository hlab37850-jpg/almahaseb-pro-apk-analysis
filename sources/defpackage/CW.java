package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class CW extends AbstractC3990tn {
    public final C3637pR b;
    public final AtomicReference c;
    public final boolean d;
    public volatile boolean e;
    public Throwable f;
    public volatile boolean h;
    public boolean l;
    public final AtomicReference g = new AtomicReference();
    public final AtomicBoolean i = new AtomicBoolean();
    public final AbstractC3856s7 j = new a();
    public final AtomicLong k = new AtomicLong();

    public final class a extends AbstractC3856s7 {
        public a() {
        }

        @Override // defpackage.PS
        public void cancel() {
            if (CW.this.h) {
                return;
            }
            CW.this.h = true;
            CW.this.r();
            CW.this.g.lazySet(null);
            if (CW.this.j.getAndIncrement() == 0) {
                CW.this.g.lazySet(null);
                CW cw = CW.this;
                if (cw.l) {
                    return;
                }
                cw.b.clear();
            }
        }

        @Override // defpackage.InterfaceC4283xQ
        public void clear() {
            CW.this.b.clear();
        }

        @Override // defpackage.InterfaceC4283xQ
        public boolean isEmpty() {
            return CW.this.b.isEmpty();
        }

        @Override // defpackage.PS
        public void l(long j) {
            if (RS.h(j)) {
                L6.a(CW.this.k, j);
                CW.this.s();
            }
        }

        @Override // defpackage.InterfaceC4283xQ
        public Object poll() {
            return CW.this.b.poll();
        }
    }

    public CW(int i, Runnable runnable, boolean z) {
        this.b = new C3637pR(i);
        this.c = new AtomicReference(runnable);
        this.d = z;
    }

    public static CW q() {
        return new CW(AbstractC3258kn.d(), null, true);
    }

    @Override // defpackage.NS, defpackage.InterfaceC4071un
    public void a(PS ps) {
        if (this.e || this.h) {
            ps.cancel();
        } else {
            ps.l(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // defpackage.NS
    public void b(Object obj) {
        AbstractC0696Kl.c(obj, "onNext called with a null value.");
        if (this.e || this.h) {
            return;
        }
        this.b.offer(obj);
        s();
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        if (this.i.get() || !this.i.compareAndSet(false, true)) {
            EnumC2468il.a(new IllegalStateException("This processor allows only a single Subscriber"), ns);
            return;
        }
        ns.a(this.j);
        this.g.set(ns);
        if (this.h) {
            this.g.lazySet(null);
        } else {
            s();
        }
    }

    @Override // defpackage.NS
    public void onComplete() {
        if (this.e || this.h) {
            return;
        }
        this.e = true;
        r();
        s();
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        AbstractC0696Kl.c(th, "onError called with a null Throwable.");
        if (this.e || this.h) {
            FM.m(th);
            return;
        }
        this.f = th;
        this.e = true;
        r();
        s();
    }

    public boolean p(boolean z, boolean z2, boolean z3, NS ns, C3637pR c3637pR) {
        if (this.h) {
            c3637pR.clear();
            this.g.lazySet(null);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z && this.f != null) {
            c3637pR.clear();
            this.g.lazySet(null);
            ns.onError(this.f);
            return true;
        }
        if (!z3) {
            return false;
        }
        Throwable th = this.f;
        this.g.lazySet(null);
        if (th != null) {
            ns.onError(th);
        } else {
            ns.onComplete();
        }
        return true;
    }

    public void r() {
        Runnable runnable = (Runnable) this.c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void s() {
        if (this.j.getAndIncrement() != 0) {
            return;
        }
        NS ns = (NS) this.g.get();
        int iAddAndGet = 1;
        while (ns == null) {
            iAddAndGet = this.j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                ns = (NS) this.g.get();
            }
        }
        if (this.l) {
            t(ns);
        } else {
            u(ns);
        }
    }

    public void t(NS ns) {
        C3637pR c3637pR = this.b;
        boolean z = this.d;
        int iAddAndGet = 1;
        while (!this.h) {
            boolean z2 = this.e;
            if (!z && z2 && this.f != null) {
                c3637pR.clear();
                this.g.lazySet(null);
                ns.onError(this.f);
                return;
            }
            ns.b(null);
            if (z2) {
                this.g.lazySet(null);
                Throwable th = this.f;
                if (th != null) {
                    ns.onError(th);
                    return;
                } else {
                    ns.onComplete();
                    return;
                }
            }
            iAddAndGet = this.j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        this.g.lazySet(null);
    }

    public void u(NS ns) {
        long j;
        C3637pR c3637pR = this.b;
        boolean z = !this.d;
        int iAddAndGet = 1;
        do {
            long j2 = this.k.get();
            long j3 = 0;
            while (true) {
                if (j2 == j3) {
                    j = j3;
                    break;
                }
                boolean z2 = this.e;
                Object objPoll = c3637pR.poll();
                boolean z3 = objPoll == null;
                j = j3;
                if (p(z, z2, z3, ns, c3637pR)) {
                    return;
                }
                if (z3) {
                    break;
                }
                ns.b(objPoll);
                j3 = 1 + j;
            }
            if (j2 == j3 && p(z, this.e, c3637pR.isEmpty(), ns, c3637pR)) {
                return;
            }
            if (j != 0 && j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.k.addAndGet(-j);
            }
            iAddAndGet = this.j.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }
}
