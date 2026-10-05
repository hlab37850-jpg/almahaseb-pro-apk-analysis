package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import defpackage.AbstractC3247kf0;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class CallbackExecutor {
    private CallbackExecutor() {
    }

    @NonNull
    @KeepForSdk
    public static ExecutorService executorService() {
        return AbstractC3247kf0.a;
    }
}
