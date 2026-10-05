package com.google.android.gms.internal.play_billing;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class zzu {
    @NonNull
    public static zzcz zza(@NonNull zzr zzrVar) {
        zzp zzpVar = new zzp();
        B b = new B(zzpVar);
        zzpVar.zzb = b;
        zzpVar.zza = zzrVar.getClass();
        try {
            zzpVar.zza = zzrVar.zza(zzpVar);
        } catch (Exception e) {
            b.b(e);
        }
        return b;
    }
}
