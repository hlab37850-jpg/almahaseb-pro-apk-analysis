package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: vD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4108vD extends AN.c implements InterfaceC0624Jj {
    public final ScheduledExecutorService a;
    public volatile boolean b;

    public C4108vD(ThreadFactory threadFactory) {
        this.a = FN.a(threadFactory);
    }

    @Override // AN.c
    public InterfaceC0624Jj b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // AN.c
    public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b ? EnumC1255al.INSTANCE : e(runnable, j, timeUnit, null);
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.shutdownNow();
    }

    public RunnableC4452zN e(Runnable runnable, long j, TimeUnit timeUnit, InterfaceC0694Kj interfaceC0694Kj) {
        RunnableC4452zN runnableC4452zN = new RunnableC4452zN(FM.o(runnable), interfaceC0694Kj);
        if (interfaceC0694Kj != null && !interfaceC0694Kj.a(runnableC4452zN)) {
            return runnableC4452zN;
        }
        try {
            runnableC4452zN.a(j <= 0 ? this.a.submit((Callable) runnableC4452zN) : this.a.schedule((Callable) runnableC4452zN, j, timeUnit));
        } catch (RejectedExecutionException e) {
            if (interfaceC0694Kj != null) {
                interfaceC0694Kj.b(runnableC4452zN);
            }
            FM.m(e);
        }
        return runnableC4452zN;
    }

    public InterfaceC0624Jj f(Runnable runnable, long j, TimeUnit timeUnit) {
        CallableC4280xN callableC4280xN = new CallableC4280xN(FM.o(runnable), true);
        try {
            callableC4280xN.b(j <= 0 ? this.a.submit(callableC4280xN) : this.a.schedule(callableC4280xN, j, timeUnit));
            return callableC4280xN;
        } catch (RejectedExecutionException e) {
            FM.m(e);
            return EnumC1255al.INSTANCE;
        }
    }

    public InterfaceC0624Jj g(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable runnableO = FM.o(runnable);
        if (j2 <= 0) {
            CallableC0867Qs callableC0867Qs = new CallableC0867Qs(runnableO, this.a);
            try {
                callableC0867Qs.b(j <= 0 ? this.a.submit(callableC0867Qs) : this.a.schedule(callableC0867Qs, j, timeUnit));
                return callableC0867Qs;
            } catch (RejectedExecutionException e) {
                FM.m(e);
                return EnumC1255al.INSTANCE;
            }
        }
        RunnableC4199wN runnableC4199wN = new RunnableC4199wN(runnableO, true);
        try {
            runnableC4199wN.b(this.a.scheduleAtFixedRate(runnableC4199wN, j, j2, timeUnit));
            return runnableC4199wN;
        } catch (RejectedExecutionException e2) {
            FM.m(e2);
            return EnumC1255al.INSTANCE;
        }
    }

    public void h() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.shutdown();
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return this.b;
    }
}
