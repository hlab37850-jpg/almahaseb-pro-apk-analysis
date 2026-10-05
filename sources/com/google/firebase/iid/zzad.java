package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import defpackage.C1200a50;
import defpackage.C2005d50;
import defpackage.ServiceConnectionC4337y40;
import defpackage.Y40;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzad {
    private static zzad zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private ServiceConnectionC4337y40 zzd = new ServiceConnectionC4337y40(this);
    private int zze = 1;

    @VisibleForTesting
    private zzad(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzad zza(Context context) {
        try {
            if (zza == null) {
                zza = new zzad(context, com.google.android.gms.internal.firebase_messaging.zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zzb));
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza(new C2005d50(zza(), 1, bundle));
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza(new C1200a50(zza(), 2, bundle));
    }

    private final synchronized <T> Task<T> zza(Y40 y40) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(y40);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
                sb.append("Queueing ");
                sb.append(strValueOf);
                Log.d("MessengerIpcClient", sb.toString());
            }
            if (!this.zzd.e(y40)) {
                ServiceConnectionC4337y40 serviceConnectionC4337y40 = new ServiceConnectionC4337y40(this);
                this.zzd = serviceConnectionC4337y40;
                serviceConnectionC4337y40.e(y40);
            }
        } catch (Throwable th) {
            throw th;
        }
        return y40.b.getTask();
    }

    private final synchronized int zza() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }
}
