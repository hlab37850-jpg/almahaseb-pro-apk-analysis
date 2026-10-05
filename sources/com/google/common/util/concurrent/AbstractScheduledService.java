package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate = new e(this, null);

    public static abstract class CustomScheduler extends Scheduler {

        public static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long j, TimeUnit timeUnit) {
                this.delay = j;
                this.unit = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        public final class a implements Callable {
            public final Runnable a;
            public final ScheduledExecutorService b;
            public final AbstractService c;
            public final ReentrantLock d = new ReentrantLock();
            public b e;

            public a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.a = runnable;
                this.b = scheduledExecutorService;
                this.c = abstractService;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                this.a.run();
                c();
                return null;
            }

            public final c b(Schedule schedule) {
                b bVar = this.e;
                if (bVar == null) {
                    b bVar2 = new b(this.d, d(schedule));
                    this.e = bVar2;
                    return bVar2;
                }
                if (!bVar.b.isCancelled()) {
                    this.e.b = d(schedule);
                }
                return this.e;
            }

            public c c() {
                c dVar;
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    this.d.lock();
                    try {
                        dVar = b(nextSchedule);
                        this.d.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            dVar = new d(Futures.immediateCancelledFuture());
                            this.d.unlock();
                        } catch (Throwable th2) {
                            this.d.unlock();
                            throw th2;
                        }
                    }
                    if (th != null) {
                        this.c.notifyFailed(th);
                    }
                    return dVar;
                } catch (Throwable th3) {
                    this.c.notifyFailed(th3);
                    return new d(Futures.immediateCancelledFuture());
                }
            }

            public final ScheduledFuture d(Schedule schedule) {
                return this.b.schedule(this, schedule.delay, schedule.unit);
            }
        }

        public static final class b implements c {
            public final ReentrantLock a;
            public Future b;

            public b(ReentrantLock reentrantLock, Future future) {
                this.a = reentrantLock;
                this.b = future;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.c
            public void cancel(boolean z) {
                this.a.lock();
                try {
                    this.b.cancel(z);
                } finally {
                    this.a.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.c
            public boolean isCancelled() {
                this.a.lock();
                try {
                    return this.b.isCancelled();
                } finally {
                    this.a.unlock();
                }
            }
        }

        public CustomScheduler() {
            super(null);
        }

        public abstract Schedule getNextSchedule();

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final c schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new a(abstractService, scheduledExecutorService, runnable).c();
        }
    }

    public static abstract class Scheduler {

        public class a extends Scheduler {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, long j2, TimeUnit timeUnit) {
                super(null);
                this.a = j;
                this.b = j2;
                this.c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public c schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return new d(scheduledExecutorService.scheduleWithFixedDelay(runnable, this.a, this.b, this.c));
            }
        }

        public class b extends Scheduler {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, long j2, TimeUnit timeUnit) {
                super(null);
                this.a = j;
                this.b = j2;
                this.c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public c schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return new d(scheduledExecutorService.scheduleAtFixedRate(runnable, this.a, this.b, this.c));
            }
        }

        public /* synthetic */ Scheduler(a aVar) {
            this();
        }

        public static Scheduler newFixedDelaySchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "delay must be > 0, found %s", j2);
            return new a(j, j2, timeUnit);
        }

        public static Scheduler newFixedRateSchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "period must be > 0, found %s", j2);
            return new b(j, j2, timeUnit);
        }

        public abstract c schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        private Scheduler() {
        }
    }

    public class a extends Service.Listener {
        public final /* synthetic */ ScheduledExecutorService a;

        public a(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            this.a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            this.a.shutdown();
        }
    }

    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
        }
    }

    public interface c {
        void cancel(boolean z);

        boolean isCancelled();
    }

    public static final class d implements c {
        public final Future a;

        public d(Future future) {
            this.a = future;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.c
        public void cancel(boolean z) {
            this.a.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.c
        public boolean isCancelled() {
            return this.a.isCancelled();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        addListener(new a(this, scheduledExecutorServiceNewSingleThreadScheduledExecutor), MoreExecutors.directExecutor());
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void runOneIteration();

    public abstract Scheduler scheduler();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() {
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        String strServiceName = serviceName();
        String strValueOf = String.valueOf(state());
        StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 3 + strValueOf.length());
        sb.append(strServiceName);
        sb.append(" [");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j, timeUnit);
    }

    public final class e extends AbstractService {
        public volatile c a;
        public volatile ScheduledExecutorService b;
        public final ReentrantLock c;
        public final Runnable d;

        public class a implements Supplier {
            public a() {
            }

            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                String strServiceName = AbstractScheduledService.this.serviceName();
                String strValueOf = String.valueOf(e.this.state());
                StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 1 + strValueOf.length());
                sb.append(strServiceName);
                sb.append(" ");
                sb.append(strValueOf);
                return sb.toString();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.c.lock();
                try {
                    AbstractScheduledService.this.startUp();
                    e eVar = e.this;
                    eVar.a = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, e.this.b, e.this.d);
                    e.this.notifyStarted();
                } catch (Throwable th) {
                    try {
                        e.this.notifyFailed(th);
                        if (e.this.a != null) {
                            e.this.a.cancel(false);
                        }
                    } finally {
                        e.this.c.unlock();
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.c.lock();
                    try {
                        if (e.this.state() != Service.State.STOPPING) {
                            e.this.c.unlock();
                            return;
                        }
                        AbstractScheduledService.this.shutDown();
                        e.this.c.unlock();
                        e.this.notifyStopped();
                    } catch (Throwable th) {
                        e.this.c.unlock();
                        throw th;
                    }
                } catch (Throwable th2) {
                    e.this.notifyFailed(th2);
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.c.lock();
                try {
                    c cVar = e.this.a;
                    Objects.requireNonNull(cVar);
                    if (cVar.isCancelled()) {
                        e.this.c.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                } catch (Throwable th) {
                    try {
                        try {
                            AbstractScheduledService.this.shutDown();
                        } catch (Exception e) {
                            AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                        }
                        e.this.notifyFailed(th);
                        c cVar2 = e.this.a;
                        Objects.requireNonNull(cVar2);
                        cVar2.cancel(false);
                    } finally {
                        e.this.c.unlock();
                    }
                }
            }
        }

        public e() {
            this.c = new ReentrantLock();
            this.d = new d();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            this.b = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new a());
            this.b.execute(new b());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            Objects.requireNonNull(this.a);
            Objects.requireNonNull(this.b);
            this.a.cancel(false);
            this.b.execute(new c());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }

        public /* synthetic */ e(AbstractScheduledService abstractScheduledService, a aVar) {
            this();
        }
    }
}
