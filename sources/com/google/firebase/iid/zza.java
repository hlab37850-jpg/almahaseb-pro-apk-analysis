package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zza;
import com.google.firebase.iid.zzaz;
import defpackage.Aa0;
import defpackage.AbstractC4472zd0;
import defpackage.InterfaceC2088e60;
import defpackage.Mb0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zza implements InterfaceC2088e60 {
    private static final Object zza = new Object();
    private static zzbj zzb;
    private final Context zzc;
    private final ExecutorService zzd;

    public zza(Context context, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = executorService;
    }

    private static Task<Integer> zzb(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        return zza(context, "com.google.firebase.MESSAGING_EVENT").zza(intent).continueWith(AbstractC4472zd0.b(), Mb0.a);
    }

    @Override // defpackage.InterfaceC2088e60
    public final Task<Integer> zza(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = this.zzc;
        return (!(PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? Tasks.call(this.zzd, new Callable(context, intent) { // from class: c90
            public final Context a;
            public final Intent b;

            {
                this.a = context;
                this.b = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(zzaz.zza().zza(this.a, this.b));
            }
        }).continueWithTask(this.zzd, new Continuation(context, intent) { // from class: O70
            public final Context a;
            public final Intent b;

            {
                this.a = context;
                this.b = intent;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zza.zza(this.a, this.b, task);
            }
        }) : zzb(context, intent);
    }

    public static final /* synthetic */ Integer zzb(Task task) {
        return 403;
    }

    private static zzbj zza(Context context, String str) {
        zzbj zzbjVar;
        synchronized (zza) {
            try {
                if (zzb == null) {
                    zzb = new zzbj(context, str);
                }
                zzbjVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbjVar;
    }

    public static final /* synthetic */ Integer zza(Task task) {
        return -1;
    }

    public static final /* synthetic */ Task zza(Context context, Intent intent, Task task) {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? zzb(context, intent).continueWith(AbstractC4472zd0.b(), Aa0.a) : task;
    }
}
