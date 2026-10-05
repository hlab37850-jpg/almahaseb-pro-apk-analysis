package defpackage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: dg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2053dg0 implements Bh0 {
    public final Executor a;
    public final Object b = new Object();
    public OnFailureListener c;

    public C2053dg0(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new If0(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.Bh0
    public final void zzc() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
