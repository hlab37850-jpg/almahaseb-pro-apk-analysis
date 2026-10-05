package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Qs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0867Qs implements Callable, InterfaceC0624Jj {
    public static final FutureTask f = new FutureTask(AbstractC1177Zp.b, null);
    public final Runnable a;
    public final ExecutorService d;
    public Thread e;
    public final AtomicReference c = new AtomicReference();
    public final AtomicReference b = new AtomicReference();

    public CallableC0867Qs(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.e = Thread.currentThread();
        try {
            this.a.run();
            this.e = null;
            c(this.d.submit(this));
            return null;
        } catch (Throwable th) {
            this.e = null;
            FM.m(th);
            throw th;
        }
    }

    public void b(Future future) {
        Future future2;
        do {
            future2 = (Future) this.c.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!FC.a(this.c, future2, future));
    }

    public void c(Future future) {
        Future future2;
        do {
            future2 = (Future) this.b.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!FC.a(this.b, future2, future));
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        AtomicReference atomicReference = this.c;
        FutureTask futureTask = f;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.e != Thread.currentThread());
        }
        Future future2 = (Future) this.b.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.e != Thread.currentThread());
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return this.c.get() == f;
    }
}
