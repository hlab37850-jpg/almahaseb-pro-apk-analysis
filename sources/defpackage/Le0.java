package defpackage;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public final class Le0 implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ C3738qf0 b;

    public Le0(C3738qf0 c3738qf0, Task task) {
        this.b = c3738qf0;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                C3738qf0 c3738qf0 = this.b;
                if (c3738qf0.c != null) {
                    c3738qf0.c.onComplete(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
