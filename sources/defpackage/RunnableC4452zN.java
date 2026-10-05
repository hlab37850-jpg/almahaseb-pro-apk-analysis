package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: zN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4452zN extends AtomicReferenceArray implements Runnable, Callable, InterfaceC0624Jj {
    public static final Object b = new Object();
    public static final Object c = new Object();
    public static final Object d = new Object();
    public static final Object e = new Object();
    public final Runnable a;

    public RunnableC4452zN(Runnable runnable, InterfaceC0694Kj interfaceC0694Kj) {
        super(3);
        this.a = runnable;
        lazySet(0, interfaceC0694Kj);
    }

    public void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == e) {
                return;
            }
            if (obj == c) {
                future.cancel(false);
                return;
            } else if (obj == d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == e || obj5 == (obj3 = c) || obj5 == (obj4 = d)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 == null) {
                    break;
                }
                ((Future) obj5).cancel(z);
                break;
            }
        }
        do {
            obj = get(0);
            if (obj == e || obj == (obj2 = b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((InterfaceC0694Kj) obj).c(this);
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == b || obj == e;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.a.run();
            Object obj3 = get(0);
            if (obj3 != b && compareAndSet(0, obj3, e) && obj3 != null) {
                ((InterfaceC0694Kj) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == c || obj2 == d) {
                    break;
                }
            } while (!compareAndSet(1, obj2, e));
            lazySet(2, null);
        } catch (Throwable th) {
            try {
                FM.m(th);
                throw th;
            } catch (Throwable th2) {
                Object obj4 = get(0);
                if (obj4 != b && compareAndSet(0, obj4, e) && obj4 != null) {
                    ((InterfaceC0694Kj) obj4).c(this);
                }
                do {
                    obj = get(1);
                    if (obj == c || obj == d) {
                        break;
                    }
                } while (!compareAndSet(1, obj, e));
                lazySet(2, null);
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public String toString() {
        String str;
        Object obj = get(1);
        if (obj == e) {
            str = "Finished";
        } else if (obj == c) {
            str = "Disposed(Sync)";
        } else if (obj == d) {
            str = "Disposed(Async)";
        } else {
            Object obj2 = get(2);
            if (obj2 == null) {
                str = "Waiting";
            } else {
                str = "Running on " + obj2;
            }
        }
        return RunnableC4452zN.class.getSimpleName() + "[" + str + "]";
    }
}
