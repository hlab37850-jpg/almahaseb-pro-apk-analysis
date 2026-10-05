package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: Jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0626Jl extends Thread {
    public static C0626Jl c;
    public static ExecutorService d;
    public static final Logger a = Logger.getLogger(C0626Jl.class.getName());
    public static final ThreadFactory b = new a();
    public static int e = 0;

    /* JADX INFO: renamed from: Jl$a */
    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            C0626Jl unused = C0626Jl.c = new C0626Jl(runnable, null);
            C0626Jl.c.setName("EventThread");
            C0626Jl.c.setDaemon(Thread.currentThread().isDaemon());
            return C0626Jl.c;
        }
    }

    /* JADX INFO: renamed from: Jl$b */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
                synchronized (C0626Jl.class) {
                    try {
                        C0626Jl.e();
                        if (C0626Jl.e == 0) {
                            C0626Jl.d.shutdown();
                            ExecutorService unused = C0626Jl.d = null;
                            C0626Jl unused2 = C0626Jl.c = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                try {
                    C0626Jl.a.log(Level.SEVERE, "Task threw exception", th2);
                    throw th2;
                } catch (Throwable th3) {
                    synchronized (C0626Jl.class) {
                        try {
                            C0626Jl.e();
                            if (C0626Jl.e == 0) {
                                C0626Jl.d.shutdown();
                                ExecutorService unused3 = C0626Jl.d = null;
                                C0626Jl unused4 = C0626Jl.c = null;
                            }
                            throw th3;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            }
        }
    }

    public /* synthetic */ C0626Jl(Runnable runnable, a aVar) {
        this(runnable);
    }

    public static /* synthetic */ int e() {
        int i = e;
        e = i - 1;
        return i;
    }

    public static void h(Runnable runnable) {
        if (i()) {
            runnable.run();
        } else {
            j(runnable);
        }
    }

    public static boolean i() {
        return Thread.currentThread() == c;
    }

    public static void j(Runnable runnable) {
        ExecutorService executorService;
        synchronized (C0626Jl.class) {
            try {
                e++;
                if (d == null) {
                    d = Executors.newSingleThreadExecutor(b);
                }
                executorService = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        executorService.execute(new b(runnable));
    }

    public C0626Jl(Runnable runnable) {
        super(runnable);
    }
}
