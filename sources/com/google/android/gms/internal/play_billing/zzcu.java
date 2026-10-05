package com.google.android.gms.internal.play_billing;

import defpackage.I80;
import defpackage.R80;
import defpackage.T80;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcu extends R80 {
    public static zzcz zza(Object obj) {
        return new T80(obj);
    }

    public static zzcz zzb(zzcz zzczVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzczVar.isDone() ? zzczVar : o.c(zzczVar, 28500L, timeUnit, scheduledExecutorService);
    }

    public static void zzc(zzcz zzczVar, zzcs zzcsVar, Executor executor) {
        zzczVar.zzb(new I80(zzczVar, zzcsVar), executor);
    }
}
