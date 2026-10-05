package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import defpackage.C1768b60;

/* JADX INFO: loaded from: classes2.dex */
public class CancellationTokenSource {
    private final C1768b60 zza = new C1768b60();

    public void cancel() {
        this.zza.a();
    }

    @NonNull
    public CancellationToken getToken() {
        return this.zza;
    }
}
