package com.google.android.gms.internal.auth;

import defpackage.L90;
import defpackage.O90;
import defpackage.R90;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdn {
    public static zzdj zza(zzdj zzdjVar) {
        if ((zzdjVar instanceof O90) || (zzdjVar instanceof L90)) {
            return zzdjVar;
        }
        return zzdjVar instanceof Serializable ? new L90(zzdjVar) : new O90(zzdjVar);
    }

    public static zzdj zzb(Object obj) {
        return new R90(obj);
    }
}
