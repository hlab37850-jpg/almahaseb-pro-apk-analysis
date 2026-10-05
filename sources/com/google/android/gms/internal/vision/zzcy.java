package com.google.android.gms.internal.vision;

import defpackage.C4438z90;
import defpackage.O80;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcy<T> implements Serializable {
    public static <T> zzcy<T> zza(T t) {
        return new C4438z90(zzde.zza(t));
    }

    public static <T> zzcy<T> zzc() {
        return O80.a;
    }

    public abstract boolean zza();

    public abstract T zzb();
}
