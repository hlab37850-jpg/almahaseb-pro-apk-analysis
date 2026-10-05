package com.google.android.gms.internal.play_billing;

import defpackage.C4389yh0;

/* JADX INFO: loaded from: classes2.dex */
public final class zzp {
    Object zza;
    B zzb;
    private zzv zzc = zzv.zze();
    private boolean zzd;

    public final void finalize() {
        zzv zzvVar;
        B b = this.zzb;
        if (b != null && !b.isDone()) {
            b.b(new C4389yh0("The completer object was garbage collected - this future would otherwise never complete. The tag was: ".concat(String.valueOf(this.zza))));
        }
        if (this.zzd || (zzvVar = this.zzc) == null) {
            return;
        }
        zzvVar.zzd(null);
    }

    public final void zza() {
        this.zza = null;
        this.zzb = null;
        this.zzc.zzd(null);
    }

    public final boolean zzb(Object obj) {
        this.zzd = true;
        B b = this.zzb;
        boolean z = b != null && b.a(obj);
        if (z) {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
        return z;
    }
}
