package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class J extends AtomicReference implements InterfaceC0624Jj {
    public static final FutureTask d;
    public static final FutureTask e;
    public final Runnable a;
    public final boolean b;
    public Thread c;

    static {
        Runnable runnable = AbstractC1177Zp.b;
        d = new FutureTask(runnable, null);
        e = new FutureTask(runnable, null);
    }

    public J(Runnable runnable, boolean z) {
        this.a = runnable;
        this.b = z;
    }

    public final void a(Future future) {
        if (this.c == Thread.currentThread()) {
            future.cancel(false);
        } else {
            future.cancel(this.b);
        }
    }

    public final void b(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == d) {
                return;
            }
            if (future2 == e) {
                a(future);
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // defpackage.InterfaceC0624Jj
    public final void dispose() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == d || future == (futureTask = e) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        a(future);
    }

    @Override // defpackage.InterfaceC0624Jj
    public final boolean isDisposed() {
        Future future = (Future) get();
        return future == d || future == e;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        String str;
        Future future = (Future) get();
        if (future == d) {
            str = "Finished";
        } else if (future == e) {
            str = "Disposed";
        } else if (this.c != null) {
            str = "Running on " + this.c;
        } else {
            str = "Waiting";
        }
        return getClass().getSimpleName() + "[" + str + "]";
    }
}
