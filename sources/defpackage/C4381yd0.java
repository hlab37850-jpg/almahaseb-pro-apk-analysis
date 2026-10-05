package defpackage;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: yd0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4381yd0 implements Bh0 {
    public final Executor a;
    public final Object b = new Object();
    public OnCanceledListener c;

    public C4381yd0(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = executor;
        this.c = onCanceledListener;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        if (task.isCanceled()) {
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        return;
                    }
                    this.a.execute(new Ac0(this));
                } catch (Throwable th) {
                    throw th;
                }
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
