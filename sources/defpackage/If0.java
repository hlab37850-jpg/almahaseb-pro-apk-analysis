package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public final class If0 implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ C2053dg0 b;

    public If0(C2053dg0 c2053dg0, Task task) {
        this.b = c2053dg0;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                C2053dg0 c2053dg0 = this.b;
                if (c2053dg0.c != null) {
                    c2053dg0.c.onFailure((Exception) Preconditions.checkNotNull(this.a.getException()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
