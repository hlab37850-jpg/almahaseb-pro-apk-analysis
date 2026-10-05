package defpackage;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public final class L70 implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ C3373m90 b;

    public L70(C3373m90 c3373m90, Task task) {
        this.b = c3373m90;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.isCanceled()) {
            this.b.c.c();
            return;
        }
        try {
            this.b.c.b(this.b.b.then(this.a));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.b.c.a((Exception) e.getCause());
            } else {
                this.b.c.a(e);
            }
        } catch (Exception e2) {
            this.b.c.a(e2);
        }
    }
}
