package com.google.android.gms.tasks;

import defpackage.Lb0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ Lb0 b;

    public a(Lb0 lb0, Task task) {
        this.b = lb0;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) this.b.b.then(this.a);
            if (task == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Lb0 lb0 = this.b;
            Executor executor = TaskExecutors.zza;
            task.addOnSuccessListener(executor, lb0);
            task.addOnFailureListener(executor, this.b);
            task.addOnCanceledListener(executor, this.b);
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
