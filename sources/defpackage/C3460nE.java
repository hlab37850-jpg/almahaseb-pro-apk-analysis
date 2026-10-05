package defpackage;

/* JADX INFO: renamed from: nE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3460nE extends AbstractC2157f0 {
    public final AN b;
    public final boolean c;
    public final int d;

    /* JADX INFO: renamed from: nE$a */
    public static final class a extends AbstractC3775r7 implements InterfaceC3866sE, Runnable {
        public final InterfaceC3866sE a;
        public final AN.c b;
        public final boolean c;
        public final int d;
        public InterfaceC4283xQ e;
        public InterfaceC0624Jj f;
        public Throwable g;
        public volatile boolean h;
        public volatile boolean i;
        public int j;
        public boolean k;

        public a(InterfaceC3866sE interfaceC3866sE, AN.c cVar, boolean z, int i) {
            this.a = interfaceC3866sE;
            this.b = cVar;
            this.c = z;
            this.d = i;
        }

        @Override // defpackage.InterfaceC3866sE
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            if (EnumC0771Nj.i(this.f, interfaceC0624Jj)) {
                this.f = interfaceC0624Jj;
                if (interfaceC0624Jj instanceof InterfaceC1784bJ) {
                    InterfaceC1784bJ interfaceC1784bJ = (InterfaceC1784bJ) interfaceC0624Jj;
                    int iC = interfaceC1784bJ.c(7);
                    if (iC == 1) {
                        this.j = iC;
                        this.e = interfaceC1784bJ;
                        this.h = true;
                        this.a.a(this);
                        i();
                        return;
                    }
                    if (iC == 2) {
                        this.j = iC;
                        this.e = interfaceC1784bJ;
                        this.a.a(this);
                        return;
                    }
                }
                this.e = new C3637pR(this.d);
                this.a.a(this);
            }
        }

        @Override // defpackage.InterfaceC3866sE
        public void b(Object obj) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.offer(obj);
            }
            i();
        }

        @Override // defpackage.InterfaceC1865cJ
        public int c(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }

        @Override // defpackage.InterfaceC4283xQ
        public void clear() {
            this.e.clear();
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.dispose();
            this.b.dispose();
            if (this.k || getAndIncrement() != 0) {
                return;
            }
            this.e.clear();
        }

        public boolean e(boolean z, boolean z2, InterfaceC3866sE interfaceC3866sE) {
            if (this.i) {
                this.e.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.g;
            if (this.c) {
                if (!z2) {
                    return false;
                }
                this.i = true;
                if (th != null) {
                    interfaceC3866sE.onError(th);
                } else {
                    interfaceC3866sE.onComplete();
                }
                this.b.dispose();
                return true;
            }
            if (th != null) {
                this.i = true;
                this.e.clear();
                interfaceC3866sE.onError(th);
                this.b.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.i = true;
            interfaceC3866sE.onComplete();
            this.b.dispose();
            return true;
        }

        public void f() {
            int iAddAndGet = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (!this.c && z && th != null) {
                    this.i = true;
                    this.a.onError(this.g);
                    this.b.dispose();
                    return;
                }
                this.a.b(null);
                if (z) {
                    this.i = true;
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        this.a.onError(th2);
                    } else {
                        this.a.onComplete();
                    }
                    this.b.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void h() {
            InterfaceC4283xQ interfaceC4283xQ = this.e;
            InterfaceC3866sE interfaceC3866sE = this.a;
            int iAddAndGet = 1;
            while (!e(this.h, interfaceC4283xQ.isEmpty(), interfaceC3866sE)) {
                while (true) {
                    boolean z = this.h;
                    try {
                        Object objPoll = interfaceC4283xQ.poll();
                        boolean z2 = objPoll == null;
                        if (e(z, z2, interfaceC3866sE)) {
                            return;
                        }
                        if (z2) {
                            break;
                        } else {
                            interfaceC3866sE.b(objPoll);
                        }
                    } catch (Throwable th) {
                        AbstractC0722Ll.b(th);
                        this.i = true;
                        this.f.dispose();
                        interfaceC4283xQ.clear();
                        interfaceC3866sE.onError(th);
                        this.b.dispose();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void i() {
            if (getAndIncrement() == 0) {
                this.b.b(this);
            }
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.i;
        }

        @Override // defpackage.InterfaceC4283xQ
        public boolean isEmpty() {
            return this.e.isEmpty();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            i();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onError(Throwable th) {
            if (this.h) {
                FM.m(th);
                return;
            }
            this.g = th;
            this.h = true;
            i();
        }

        @Override // defpackage.InterfaceC4283xQ
        public Object poll() {
            return this.e.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                f();
            } else {
                h();
            }
        }
    }

    public C3460nE(InterfaceC3705qE interfaceC3705qE, AN an, boolean z, int i) {
        super(interfaceC3705qE);
        this.b = an;
        this.c = z;
        this.d = i;
    }

    @Override // defpackage.AbstractC3132jE
    public void l(InterfaceC3866sE interfaceC3866sE) {
        AN an = this.b;
        if (an instanceof C1877cV) {
            this.a.a(interfaceC3866sE);
        } else {
            this.a.a(new a(interfaceC3866sE, an.createWorker(), this.c, this.d));
        }
    }
}
