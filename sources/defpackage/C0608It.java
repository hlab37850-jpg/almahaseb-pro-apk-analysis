package defpackage;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: It, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0608It extends AN {
    public static final IM c;
    public static final IM d;
    public static final c g;
    public static boolean h;
    public static final a i;
    public final ThreadFactory a;
    public final AtomicReference b;
    public static final TimeUnit f = TimeUnit.SECONDS;
    public static final long e = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: renamed from: It$a */
    public static final class a implements Runnable {
        public final long a;
        public final ConcurrentLinkedQueue b;
        public final C0415De c;
        public final ScheduledExecutorService d;
        public final Future e;
        public final ThreadFactory f;

        public a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.a = nanos;
            this.b = new ConcurrentLinkedQueue();
            this.c = new C0415De();
            this.f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, C0608It.d);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.d = scheduledExecutorServiceNewScheduledThreadPool;
            this.e = scheduledFutureScheduleWithFixedDelay;
        }

        public static void a(ConcurrentLinkedQueue concurrentLinkedQueue, C0415De c0415De) {
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long jC = c();
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.i() > jC) {
                    return;
                }
                if (concurrentLinkedQueue.remove(cVar)) {
                    c0415De.b(cVar);
                }
            }
        }

        public static long c() {
            return System.nanoTime();
        }

        public c b() {
            if (this.c.isDisposed()) {
                return C0608It.g;
            }
            while (!this.b.isEmpty()) {
                c cVar = (c) this.b.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            c cVar2 = new c(this.f);
            this.c.a(cVar2);
            return cVar2;
        }

        public void d(c cVar) {
            cVar.j(c() + this.a);
            this.b.offer(cVar);
        }

        public void e() {
            this.c.dispose();
            Future future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: It$b */
    public static final class b extends AN.c implements Runnable {
        public final a b;
        public final c c;
        public final AtomicBoolean d = new AtomicBoolean();
        public final C0415De a = new C0415De();

        public b(a aVar) {
            this.b = aVar;
            this.c = aVar.b();
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.a.isDisposed() ? EnumC1255al.INSTANCE : this.c.e(runnable, j, timeUnit, this.a);
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.d.compareAndSet(false, true)) {
                this.a.dispose();
                if (C0608It.h) {
                    this.c.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.b.d(this.c);
                }
            }
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.d.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.d(this.c);
        }
    }

    /* JADX INFO: renamed from: It$c */
    public static final class c extends C4108vD {
        public long c;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.c = 0L;
        }

        public long i() {
            return this.c;
        }

        public void j(long j) {
            this.c = j;
        }
    }

    static {
        c cVar = new c(new IM("RxCachedThreadSchedulerShutdown"));
        g = cVar;
        cVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        IM im = new IM("RxCachedThreadScheduler", iMax);
        c = im;
        d = new IM("RxCachedWorkerPoolEvictor", iMax);
        h = Boolean.getBoolean("rx3.io-scheduled-release");
        a aVar = new a(0L, null, im);
        i = aVar;
        aVar.e();
    }

    public C0608It() {
        this(c);
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new b((a) this.b.get());
    }

    @Override // defpackage.AN
    public void shutdown() {
        AtomicReference atomicReference = this.b;
        a aVar = i;
        a aVar2 = (a) atomicReference.getAndSet(aVar);
        if (aVar2 != aVar) {
            aVar2.e();
        }
    }

    @Override // defpackage.AN
    public void start() {
        a aVar = new a(e, f, this.a);
        if (FC.a(this.b, i, aVar)) {
            return;
        }
        aVar.e();
    }

    public C0608It(ThreadFactory threadFactory) {
        this.a = threadFactory;
        this.b = new AtomicReference(i);
        start();
    }
}
