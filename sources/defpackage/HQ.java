package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class HQ extends AN {
    public static final IM c;
    public static final ScheduledExecutorService d;
    public final ThreadFactory a;
    public final AtomicReference b;

    public static final class a extends AN.c {
        public final ScheduledExecutorService a;
        public final C0415De b = new C0415De();
        public volatile boolean c;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.c) {
                return EnumC1255al.INSTANCE;
            }
            RunnableC4452zN runnableC4452zN = new RunnableC4452zN(FM.o(runnable), this.b);
            this.b.a(runnableC4452zN);
            try {
                runnableC4452zN.a(j <= 0 ? this.a.submit((Callable) runnableC4452zN) : this.a.schedule((Callable) runnableC4452zN, j, timeUnit));
                return runnableC4452zN;
            } catch (RejectedExecutionException e) {
                dispose();
                FM.m(e);
                return EnumC1255al.INSTANCE;
            }
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.c;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        d = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        c = new IM("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public HQ() {
        this(c);
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return FN.a(threadFactory);
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new a((ScheduledExecutorService) this.b.get());
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        CallableC4280xN callableC4280xN = new CallableC4280xN(FM.o(runnable), true);
        try {
            callableC4280xN.b(j <= 0 ? ((ScheduledExecutorService) this.b.get()).submit(callableC4280xN) : ((ScheduledExecutorService) this.b.get()).schedule(callableC4280xN, j, timeUnit));
            return callableC4280xN;
        } catch (RejectedExecutionException e) {
            FM.m(e);
            return EnumC1255al.INSTANCE;
        }
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable runnableO = FM.o(runnable);
        if (j2 > 0) {
            RunnableC4199wN runnableC4199wN = new RunnableC4199wN(runnableO, true);
            try {
                runnableC4199wN.b(((ScheduledExecutorService) this.b.get()).scheduleAtFixedRate(runnableC4199wN, j, j2, timeUnit));
                return runnableC4199wN;
            } catch (RejectedExecutionException e) {
                FM.m(e);
                return EnumC1255al.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.b.get();
        CallableC0867Qs callableC0867Qs = new CallableC0867Qs(runnableO, scheduledExecutorService);
        try {
            callableC0867Qs.b(j <= 0 ? scheduledExecutorService.submit(callableC0867Qs) : scheduledExecutorService.schedule(callableC0867Qs, j, timeUnit));
            return callableC0867Qs;
        } catch (RejectedExecutionException e2) {
            FM.m(e2);
            return EnumC1255al.INSTANCE;
        }
    }

    @Override // defpackage.AN
    public void shutdown() {
        AtomicReference atomicReference = this.b;
        ScheduledExecutorService scheduledExecutorService = d;
        ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService) atomicReference.getAndSet(scheduledExecutorService);
        if (scheduledExecutorService2 != scheduledExecutorService) {
            scheduledExecutorService2.shutdownNow();
        }
    }

    @Override // defpackage.AN
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorServiceA = null;
        do {
            scheduledExecutorService = (ScheduledExecutorService) this.b.get();
            if (scheduledExecutorService != d) {
                if (scheduledExecutorServiceA != null) {
                    scheduledExecutorServiceA.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorServiceA == null) {
                scheduledExecutorServiceA = a(this.a);
            }
        } while (!FC.a(this.b, scheduledExecutorService, scheduledExecutorServiceA));
    }

    public HQ(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.b = atomicReference;
        this.a = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }
}
