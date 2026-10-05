package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Wl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1020Wl extends AbstractC0994Vl implements InterfaceC1017Wi {
    public final Executor b;

    public C1020Wl(Executor executor) {
        this.b = executor;
        AbstractC0766Ne.a(H());
    }

    public final void G(InterfaceC0988Vf interfaceC0988Vf, RejectedExecutionException rejectedExecutionException) {
        AbstractC3347lu.c(interfaceC0988Vf, AbstractC0747Ml.a("The task was rejected", rejectedExecutionException));
    }

    public Executor H() {
        return this.b;
    }

    public final ScheduledFuture I(ScheduledExecutorService scheduledExecutorService, Runnable runnable, InterfaceC0988Vf interfaceC0988Vf, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            G(interfaceC0988Vf, e);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorH = H();
        ExecutorService executorService = executorH instanceof ExecutorService ? (ExecutorService) executorH : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // defpackage.InterfaceC1017Wi
    public InterfaceC0745Mj d(long j, Runnable runnable, InterfaceC0988Vf interfaceC0988Vf) {
        Executor executorH = H();
        ScheduledExecutorService scheduledExecutorService = executorH instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorH : null;
        ScheduledFuture scheduledFutureI = scheduledExecutorService != null ? I(scheduledExecutorService, runnable, interfaceC0988Vf, j) : null;
        return scheduledFutureI != null ? new C0720Lj(scheduledFutureI) : RunnableC0519Fi.f.d(j, runnable, interfaceC0988Vf);
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        try {
            Executor executorH = H();
            AbstractC3761r0.a();
            executorH.execute(runnable);
        } catch (RejectedExecutionException e) {
            AbstractC3761r0.a();
            G(interfaceC0988Vf, e);
            C0368Bj.b().dispatch(interfaceC0988Vf, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1020Wl) && ((C1020Wl) obj).H() == H();
    }

    @Override // defpackage.InterfaceC1017Wi
    public void g(long j, InterfaceC4293xa interfaceC4293xa) {
        Executor executorH = H();
        ScheduledExecutorService scheduledExecutorService = executorH instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorH : null;
        ScheduledFuture scheduledFutureI = scheduledExecutorService != null ? I(scheduledExecutorService, new OL(this, interfaceC4293xa), interfaceC4293xa.getContext(), j) : null;
        if (scheduledFutureI != null) {
            AbstractC3347lu.h(interfaceC4293xa, scheduledFutureI);
        } else {
            RunnableC0519Fi.f.g(j, interfaceC4293xa);
        }
    }

    public int hashCode() {
        return System.identityHashCode(H());
    }

    @Override // defpackage.AbstractC1040Xf
    public String toString() {
        return H().toString();
    }
}
