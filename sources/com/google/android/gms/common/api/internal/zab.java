package com.google.android.gms.common.api.internal;

import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.C3845s10;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zab extends ActivityLifecycleObserver {
    private final WeakReference zaa;

    @VisibleForTesting(otherwise = 2)
    public zab(C3845s10 c3845s10) {
        this.zaa = new WeakReference(c3845s10);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    @CanIgnoreReturnValue
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C3845s10 c3845s10 = (C3845s10) this.zaa.get();
        if (c3845s10 == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        c3845s10.c(runnable);
        return this;
    }
}
