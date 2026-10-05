package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.Rh0;
import defpackage.ui0;

/* JADX INFO: loaded from: classes2.dex */
public class TaskCompletionSource<TResult> {
    private final ui0 zza = new ui0();

    public TaskCompletionSource() {
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.zza;
    }

    public void setException(@NonNull Exception exc) {
        this.zza.a(exc);
    }

    public void setResult(@Nullable TResult tresult) {
        this.zza.b(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.zza.d(exc);
    }

    public boolean trySetResult(@Nullable TResult tresult) {
        return this.zza.e(tresult);
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new Rh0(this));
    }
}
