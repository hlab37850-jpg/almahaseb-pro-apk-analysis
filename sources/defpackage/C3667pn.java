package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3667pn extends N {
    public final int c;
    public final boolean d;
    public final boolean e;
    public final Y1 f;

    /* JADX INFO: renamed from: pn$a */
    public static final class a extends AbstractC3856s7 implements InterfaceC4071un {
        public final NS a;
        public final InterfaceC4202wQ b;
        public final boolean c;
        public final Y1 d;
        public PS e;
        public volatile boolean f;
        public volatile boolean g;
        public Throwable h;
        public final AtomicLong i = new AtomicLong();
        public boolean j;

        public a(NS ns, int i, boolean z, boolean z2, Y1 y1) {
            this.a = ns;
            this.d = y1;
            this.c = z2;
            this.b = z ? new C3637pR(i) : new C3555oR(i);
        }

        @Override // defpackage.InterfaceC4071un
        public void a(PS ps) {
            if (RS.i(this.e, ps)) {
                this.e = ps;
                this.a.a(this);
                ps.l(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        @Override // defpackage.NS
        public void b(Object obj) {
            if (this.b.offer(obj)) {
                if (this.j) {
                    this.a.b(null);
                    return;
                } else {
                    f();
                    return;
                }
            }
            this.e.cancel();
            VB vb = new VB("Buffer is full");
            try {
                this.d.run();
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                vb.initCause(th);
            }
            onError(vb);
        }

        @Override // defpackage.PS
        public void cancel() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e.cancel();
            if (this.j || getAndIncrement() != 0) {
                return;
            }
            this.b.clear();
        }

        @Override // defpackage.InterfaceC4283xQ
        public void clear() {
            this.b.clear();
        }

        public boolean e(boolean z, boolean z2, NS ns) {
            if (this.f) {
                this.b.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.c) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.h;
                if (th != null) {
                    ns.onError(th);
                } else {
                    ns.onComplete();
                }
                return true;
            }
            Throwable th2 = this.h;
            if (th2 != null) {
                this.b.clear();
                ns.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            ns.onComplete();
            return true;
        }

        public void f() {
            if (getAndIncrement() == 0) {
                InterfaceC4202wQ interfaceC4202wQ = this.b;
                NS ns = this.a;
                int iAddAndGet = 1;
                while (!e(this.g, interfaceC4202wQ.isEmpty(), ns)) {
                    long j = this.i.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.g;
                        Object objPoll = interfaceC4202wQ.poll();
                        boolean z2 = objPoll == null;
                        if (e(z, z2, ns)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        ns.b(objPoll);
                        j2++;
                    }
                    if (j2 == j && e(this.g, interfaceC4202wQ.isEmpty(), ns)) {
                        return;
                    }
                    if (j2 != 0 && j != LocationRequestCompat.PASSIVE_INTERVAL) {
                        this.i.addAndGet(-j2);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC4283xQ
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        @Override // defpackage.PS
        public void l(long j) {
            if (this.j || !RS.h(j)) {
                return;
            }
            L6.a(this.i, j);
            f();
        }

        @Override // defpackage.NS
        public void onComplete() {
            this.g = true;
            if (this.j) {
                this.a.onComplete();
            } else {
                f();
            }
        }

        @Override // defpackage.NS
        public void onError(Throwable th) {
            this.h = th;
            this.g = true;
            if (this.j) {
                this.a.onError(th);
            } else {
                f();
            }
        }

        @Override // defpackage.InterfaceC4283xQ
        public Object poll() {
            return this.b.poll();
        }
    }

    public C3667pn(AbstractC3258kn abstractC3258kn, int i, boolean z, boolean z2, Y1 y1) {
        super(abstractC3258kn);
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = y1;
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        this.b.m(new a(ns, this.c, this.d, this.e, this.f));
    }
}
