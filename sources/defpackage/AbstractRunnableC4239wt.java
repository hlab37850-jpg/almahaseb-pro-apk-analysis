package defpackage;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: wt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRunnableC4239wt extends AtomicReference implements Runnable {
    public static final Runnable a;
    public static final Runnable b;

    /* JADX INFO: renamed from: wt$b */
    public static final class b extends AbstractOwnableSynchronizer implements Runnable {
        public final AbstractRunnableC4239wt a;

        public final void b(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        public String toString() {
            return this.a.toString();
        }

        public b(AbstractRunnableC4239wt abstractRunnableC4239wt) {
            this.a = abstractRunnableC4239wt;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        a = new c();
        b = new c();
    }

    public abstract void a(Throwable th);

    public abstract void b(Object obj);

    public final void c() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            b bVar = new b();
            bVar.b(Thread.currentThread());
            if (compareAndSet(runnable, bVar)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) getAndSet(a)) == b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    public abstract boolean e();

    public abstract Object f();

    public abstract String h();

    public final void i(Thread thread) {
        Runnable runnable = (Runnable) get();
        b bVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = runnable instanceof b;
            if (!z2 && runnable != b) {
                break;
            }
            if (z2) {
                bVar = (b) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(bVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objF = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zE = e();
            if (!zE) {
                try {
                    objF = f();
                } catch (Throwable th) {
                    if (!compareAndSet(threadCurrentThread, a)) {
                        i(threadCurrentThread);
                    }
                    if (zE) {
                        return;
                    }
                    a(th);
                    return;
                }
            }
            if (!compareAndSet(threadCurrentThread, a)) {
                i(threadCurrentThread);
            }
            if (zE) {
                return;
            }
            b(XD.a(objF));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String string;
        Runnable runnable = (Runnable) get();
        if (runnable == a) {
            string = "running=[DONE]";
        } else if (runnable instanceof b) {
            string = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            string = sb.toString();
        } else {
            string = "running=[NOT STARTED YET]";
        }
        String strH = h();
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 2 + String.valueOf(strH).length());
        sb2.append(string);
        sb2.append(", ");
        sb2.append(strH);
        return sb2.toString();
    }

    /* JADX INFO: renamed from: wt$c */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
