package com.google.android.gms.internal.auth;

import defpackage.D90;
import defpackage.G90;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdh implements Serializable {
    public static zzdh zzc() {
        return D90.a;
    }

    public static zzdh zzd(Object obj) {
        return new G90(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}
