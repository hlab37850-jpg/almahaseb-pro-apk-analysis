package defpackage;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Xj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1044Xj {
    public static C1044Xj c = new C1044Xj();
    public static ExecutorC3350lx d = new ExecutorC3350lx();
    public final ThreadPoolExecutor a;
    public final BlockingQueue b;

    public C1044Xj() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.b = linkedBlockingQueue;
        this.a = new ThreadPoolExecutor(5, 5, 50L, TimeUnit.MILLISECONDS, linkedBlockingQueue);
    }

    public static C1044Xj a() {
        return c;
    }

    public ExecutorC3350lx b() {
        Log.d("main_thread_run=", this.a.getActiveCount() + ":" + this.a.getTaskCount() + ":" + this.a.getCompletedTaskCount());
        return d;
    }

    public void c(Runnable runnable) {
        this.a.execute(runnable);
        Log.d("thread_run=", Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + ":" + this.a.getActiveCount() + ":" + this.a.getTaskCount() + ":" + this.a.getCompletedTaskCount());
    }
}
