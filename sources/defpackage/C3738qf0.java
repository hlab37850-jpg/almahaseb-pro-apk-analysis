package defpackage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: qf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3738qf0 implements Bh0 {
    public final Executor a;
    public final Object b = new Object();
    public OnCompleteListener c;

    public C3738qf0(Executor executor, OnCompleteListener onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new Le0(this, task));
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
