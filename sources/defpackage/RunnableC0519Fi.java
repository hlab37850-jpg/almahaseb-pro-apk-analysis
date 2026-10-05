package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: Fi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0519Fi extends AbstractC0448El implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final RunnableC0519Fi f;
    public static final long g;

    static {
        Long l;
        RunnableC0519Fi runnableC0519Fi = new RunnableC0519Fi();
        f = runnableC0519Fi;
        AbstractC0422Dl.M(runnableC0519Fi, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        g = timeUnit.toNanos(l.longValue());
    }

    @Override // defpackage.AbstractC0522Fl
    public Thread S() {
        Thread thread = _thread;
        return thread == null ? j0() : thread;
    }

    @Override // defpackage.AbstractC0522Fl
    public void T(long j, AbstractC0448El.c cVar) {
        n0();
    }

    @Override // defpackage.AbstractC0448El
    public void Y(Runnable runnable) {
        if (k0()) {
            n0();
        }
        super.Y(runnable);
    }

    @Override // defpackage.AbstractC0448El, defpackage.InterfaceC1017Wi
    public InterfaceC0745Mj d(long j, Runnable runnable, InterfaceC0988Vf interfaceC0988Vf) {
        return f0(j, runnable);
    }

    public final synchronized void i0() {
        if (l0()) {
            debugStatus = 3;
            c0();
            notifyAll();
        }
    }

    public final synchronized Thread j0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean k0() {
        return debugStatus == 4;
    }

    public final boolean l0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean m0() {
        if (l0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void n0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zA0;
        C4459zU.a.d(this);
        AbstractC3761r0.a();
        try {
            if (!m0()) {
                if (zA0) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jP = P();
                if (jP == LocationRequestCompat.PASSIVE_INTERVAL) {
                    AbstractC3761r0.a();
                    long jNanoTime = System.nanoTime();
                    if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                        j = g + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        if (zA0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    jP = AbstractC3871sJ.h(jP, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jP > 0) {
                    if (l0()) {
                        if (zA0) {
                            return;
                        } else {
                            return;
                        }
                    } else {
                        AbstractC3761r0.a();
                        LockSupport.parkNanos(this, jP);
                    }
                }
            }
        } finally {
            _thread = null;
            i0();
            AbstractC3761r0.a();
            if (!a0()) {
                S();
            }
        }
    }

    @Override // defpackage.AbstractC0448El, defpackage.AbstractC0422Dl
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
