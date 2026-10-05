package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;
import defpackage.K50;
import defpackage.P50;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaz {
    private static final zzbl zza;

    static {
        zzbl p50;
        try {
            SystemClock.elapsedRealtimeNanos();
            p50 = new K50();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            p50 = new P50();
        }
        zza = p50;
    }

    public static zzbl zza() {
        return zza;
    }
}
