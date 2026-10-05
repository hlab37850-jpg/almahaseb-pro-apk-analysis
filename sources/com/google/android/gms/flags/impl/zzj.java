package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.flags.zze;
import defpackage.Gf0;

/* JADX INFO: loaded from: classes2.dex */
public final class zzj {
    private static SharedPreferences zzw;

    public static SharedPreferences zza(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            try {
                if (zzw == null) {
                    zzw = (SharedPreferences) zze.zza(new Gf0(context));
                }
                sharedPreferences = zzw;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }
}
