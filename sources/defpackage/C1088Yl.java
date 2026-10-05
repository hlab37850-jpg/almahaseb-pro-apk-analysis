package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Yl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1088Yl extends AN {
    public final boolean a;
    public final boolean b;
    public final Executor c;

    /* JADX INFO: renamed from: Yl$a */
    public final class a implements Runnable {
        public final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.a;
            bVar.b.a(C1088Yl.this.scheduleDirect(bVar));
        }
    }

    /* JADX INFO: renamed from: Yl$b */
    public static final class b extends AtomicReference implements Runnable, InterfaceC0624Jj {
        public final GO a;
        public final GO b;

        public b(Runnable runnable) {
            super(runnable);
            this.a = new GO();
            this.b = new GO();
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (getAndSet(null) != null) {
                this.a.dispose();
                this.b.dispose();
            }
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    try {
                        runnable.run();
                        lazySet(null);
                        this.a.lazySet(EnumC0771Nj.DISPOSED);
                        GO go = this.b;
                    } finally {
                        lazySet(null);
                        this.a.lazySet(EnumC0771Nj.DISPOSED);
                        this.b.lazySet(EnumC0771Nj.DISPOSED);
                    }
                } catch (Throwable th) {
                    FM.m(th);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: Yl$c */
    public static final class c extends AN.c implements Runnable {
        public final boolean a;
        public final boolean b;
        public final Executor c;
        public volatile boolean e;
        public final AtomicInteger f = new AtomicInteger();
        public final C0415De g = new C0415De();
        public final C3212kC d = new C3212kC();

        /* JADX INFO: renamed from: Yl$c$a */
        public static final class a extends AtomicBoolean implements Runnable, InterfaceC0624Jj {
            public final Runnable a;

            public a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // defpackage.InterfaceC0624Jj
            public void dispose() {
                lazySet(true);
            }

            @Override // defpackage.InterfaceC0624Jj
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.a.run();
                    lazySet(true);
                } catch (Throwable th) {
                    try {
                        FM.m(th);
                        throw th;
                    } catch (Throwable th2) {
                        lazySet(true);
                        throw th2;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: Yl$c$b */
        public static final class b extends AtomicInteger implements Runnable, InterfaceC0624Jj {
            public final Runnable a;
            public final InterfaceC0694Kj b;
            public volatile Thread c;

            public b(Runnable runnable, InterfaceC0694Kj interfaceC0694Kj) {
                this.a = runnable;
                this.b = interfaceC0694Kj;
            }

            public void a() {
                InterfaceC0694Kj interfaceC0694Kj = this.b;
                if (interfaceC0694Kj != null) {
                    interfaceC0694Kj.c(this);
                }
            }

            @Override // defpackage.InterfaceC0624Jj
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.c;
                        if (thread != null) {
                            thread.interrupt();
                            this.c = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            @Override // defpackage.InterfaceC0624Jj
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.c = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.c = null;
                        return;
                    }
                    try {
                        this.a.run();
                        this.c = null;
                        if (compareAndSet(1, 2)) {
                            a();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th) {
                        try {
                            FM.m(th);
                            throw th;
                        } catch (Throwable th2) {
                            this.c = null;
                            if (compareAndSet(1, 2)) {
                                a();
                            } else {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            }
                            throw th2;
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: Yl$c$c, reason: collision with other inner class name */
        public final class RunnableC0026c implements Runnable {
            public final GO a;
            public final Runnable b;

            public RunnableC0026c(GO go, Runnable runnable) {
                this.a = go;
                this.b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.a(c.this.b(this.b));
            }
        }

        public c(Executor executor, boolean z, boolean z2) {
            this.c = executor;
            this.a = z;
            this.b = z2;
        }

        @Override // AN.c
        public InterfaceC0624Jj b(Runnable runnable) {
            InterfaceC0624Jj aVar;
            if (this.e) {
                return EnumC1255al.INSTANCE;
            }
            Runnable runnableO = FM.o(runnable);
            if (this.a) {
                aVar = new b(runnableO, this.g);
                this.g.a(aVar);
            } else {
                aVar = new a(runnableO);
            }
            this.d.offer(aVar);
            if (this.f.getAndIncrement() == 0) {
                try {
                    this.c.execute(this);
                } catch (RejectedExecutionException e) {
                    this.e = true;
                    this.d.clear();
                    FM.m(e);
                    return EnumC1255al.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return b(runnable);
            }
            if (this.e) {
                return EnumC1255al.INSTANCE;
            }
            GO go = new GO();
            GO go2 = new GO(go);
            RunnableC4452zN runnableC4452zN = new RunnableC4452zN(new RunnableC0026c(go2, FM.o(runnable)), this.g);
            this.g.a(runnableC4452zN);
            Executor executor = this.c;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    runnableC4452zN.a(((ScheduledExecutorService) executor).schedule((Callable) runnableC4452zN, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.e = true;
                    FM.m(e);
                    return EnumC1255al.INSTANCE;
                }
            } else {
                runnableC4452zN.a(new FutureC0823Pj(d.a.scheduleDirect(runnableC4452zN, j, timeUnit)));
            }
            go.a(runnableC4452zN);
            return go2;
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.g.dispose();
            if (this.f.getAndIncrement() == 0) {
                this.d.clear();
            }
        }

        public void e() {
            C3212kC c3212kC = this.d;
            int iAddAndGet = 1;
            while (!this.e) {
                while (true) {
                    Runnable runnable = (Runnable) c3212kC.poll();
                    if (runnable == null) {
                        break;
                    }
                    runnable.run();
                    if (this.e) {
                        c3212kC.clear();
                        return;
                    }
                }
                if (this.e) {
                    c3212kC.clear();
                    return;
                } else {
                    iAddAndGet = this.f.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            c3212kC.clear();
        }

        public void f() {
            C3212kC c3212kC = this.d;
            if (this.e) {
                c3212kC.clear();
                return;
            }
            ((Runnable) c3212kC.poll()).run();
            if (this.e) {
                c3212kC.clear();
            } else if (this.f.decrementAndGet() != 0) {
                this.c.execute(this);
            }
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                f();
            } else {
                e();
            }
        }
    }

    /* JADX INFO: renamed from: Yl$d */
    public static final class d {
        public static final AN a = IN.d();
    }

    public C1088Yl(Executor executor, boolean z, boolean z2) {
        this.c = executor;
        this.a = z;
        this.b = z2;
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new c(this.c, this.a, this.b);
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable) {
        Runnable runnableO = FM.o(runnable);
        try {
            if (this.c instanceof ExecutorService) {
                CallableC4280xN callableC4280xN = new CallableC4280xN(runnableO, this.a);
                callableC4280xN.b(((ExecutorService) this.c).submit(callableC4280xN));
                return callableC4280xN;
            }
            if (this.a) {
                c.b bVar = new c.b(runnableO, null);
                this.c.execute(bVar);
                return bVar;
            }
            c.a aVar = new c.a(runnableO);
            this.c.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e) {
            FM.m(e);
            return EnumC1255al.INSTANCE;
        }
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.c instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
        }
        try {
            RunnableC4199wN runnableC4199wN = new RunnableC4199wN(FM.o(runnable), this.a);
            runnableC4199wN.b(((ScheduledExecutorService) this.c).scheduleAtFixedRate(runnableC4199wN, j, j2, timeUnit));
            return runnableC4199wN;
        } catch (RejectedExecutionException e) {
            FM.m(e);
            return EnumC1255al.INSTANCE;
        }
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable runnableO = FM.o(runnable);
        if (this.c instanceof ScheduledExecutorService) {
            try {
                CallableC4280xN callableC4280xN = new CallableC4280xN(runnableO, this.a);
                callableC4280xN.b(((ScheduledExecutorService) this.c).schedule(callableC4280xN, j, timeUnit));
                return callableC4280xN;
            } catch (RejectedExecutionException e) {
                FM.m(e);
                return EnumC1255al.INSTANCE;
            }
        }
        b bVar = new b(runnableO);
        bVar.a.a(d.a.scheduleDirect(new a(bVar), j, timeUnit));
        return bVar;
    }
}
