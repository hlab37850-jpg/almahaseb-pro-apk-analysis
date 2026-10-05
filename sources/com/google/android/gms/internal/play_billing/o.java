package com.google.android.gms.internal.play_billing;

import defpackage.D80;
import defpackage.RunnableC3942t90;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends n {
    public zzcz a;
    public ScheduledFuture b;

    public o(zzcz zzczVar) {
        this.a = zzczVar;
    }

    public static zzcz c(zzcz zzczVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        o oVar = new o(zzczVar);
        RunnableC3942t90 runnableC3942t90 = new RunnableC3942t90(oVar);
        oVar.b = scheduledExecutorService.schedule(runnableC3942t90, 28500L, timeUnit);
        zzczVar.zzb(runnableC3942t90, D80.INSTANCE);
        return oVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final String zzd() {
        zzcz zzczVar = this.a;
        ScheduledFuture scheduledFuture = this.b;
        if (zzczVar == null) {
            return null;
        }
        String str = "inputFuture=[" + zzczVar.toString() + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final void zzg() {
        zzcz zzczVar = this.a;
        if ((this.valueField instanceof c) & (zzczVar != null)) {
            Object obj = this.valueField;
            zzczVar.cancel((obj instanceof c) && ((c) obj).a);
        }
        ScheduledFuture scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a = null;
        this.b = null;
    }
}
