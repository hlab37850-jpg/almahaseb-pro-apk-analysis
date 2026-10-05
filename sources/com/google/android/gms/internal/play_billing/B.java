package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC3209k90;
import defpackage.Jc0;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class B implements zzcz {
    public final WeakReference a;
    public final zzo b = new A(this);

    public B(zzp zzpVar) {
        this.a = new WeakReference(zzpVar);
    }

    public final boolean a(Object obj) {
        return this.b.zzd(obj);
    }

    public final boolean b(Throwable th) {
        Jc0 jc0 = new Jc0(th);
        AbstractC3209k90 abstractC3209k90 = zzo.zzb;
        zzo zzoVar = this.b;
        if (!abstractC3209k90.d(zzoVar, null, jc0)) {
            return false;
        }
        zzo.zzc(zzoVar);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzp zzpVar = (zzp) this.a.get();
        boolean zCancel = this.b.cancel(z);
        if (!zCancel || zzpVar == null) {
            return zCancel;
        }
        zzpVar.zza();
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b.zzc instanceof p;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.isDone();
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        this.b.zzb(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.b.get(j, timeUnit);
    }
}
