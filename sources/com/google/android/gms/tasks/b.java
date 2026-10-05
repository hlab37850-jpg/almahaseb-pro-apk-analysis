package com.google.android.gms.tasks;

import defpackage.C3742qh0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ C3742qh0 b;

    public b(C3742qh0 c3742qh0, Task task) {
        this.b = c3742qh0;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task taskThen = this.b.b.then(this.a.getResult());
            if (taskThen == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            C3742qh0 c3742qh0 = this.b;
            Executor executor = TaskExecutors.zza;
            taskThen.addOnSuccessListener(executor, c3742qh0);
            taskThen.addOnFailureListener(executor, this.b);
            taskThen.addOnCanceledListener(executor, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.b.onFailure((Exception) e.getCause());
            } else {
                this.b.onFailure(e);
            }
        } catch (CancellationException unused) {
            this.b.onCanceled();
        } catch (Exception e2) {
            this.b.onFailure(e2);
        }
    }
}
