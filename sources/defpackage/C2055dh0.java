package defpackage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: dh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2055dh0 implements Bh0 {
    public final Executor a;
    public final Object b = new Object();
    public OnSuccessListener c;

    public C2055dh0(Executor executor, OnSuccessListener onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        return;
                    }
                    this.a.execute(new Eg0(this, task));
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
