package defpackage;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public final class Eg0 implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ C2055dh0 b;

    public Eg0(C2055dh0 c2055dh0, Task task) {
        this.b = c2055dh0;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                C2055dh0 c2055dh0 = this.b;
                if (c2055dh0.c != null) {
                    c2055dh0.c.onSuccess(this.a.getResult());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
