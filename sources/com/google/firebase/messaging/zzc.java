package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzbe;
import com.google.firebase.iid.zzbf;
import com.google.firebase.iid.zzbg;
import com.google.firebase.messaging.zzc;
import defpackage.Ad0;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class zzc extends Service {

    @VisibleForTesting
    private final ExecutorService zza;
    private Binder zzb;
    private final Object zzc;
    private int zzd;
    private int zze;

    public zzc() {
        com.google.android.gms.internal.firebase_messaging.zzb zzbVarZza = com.google.android.gms.internal.firebase_messaging.zza.zza();
        String simpleName = getClass().getSimpleName();
        this.zza = zzbVarZza.zza(new NamedThreadFactory(simpleName.length() != 0 ? "Firebase-".concat(simpleName) : new String("Firebase-")), zzf.zzb);
        this.zzc = new Object();
        this.zze = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final Task<Void> zzd(final Intent intent) {
        if (zzb(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.execute(new Runnable(this, intent, taskCompletionSource) { // from class: Ba0
            public final zzc a;
            public final Intent b;
            public final TaskCompletionSource c;

            {
                this.a = this;
                this.b = intent;
                this.c = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzc zzcVar = this.a;
                Intent intent2 = this.b;
                TaskCompletionSource taskCompletionSource2 = this.c;
                try {
                    zzcVar.zzc(intent2);
                } finally {
                    taskCompletionSource2.setResult(null);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    private final void zzf(Intent intent) {
        if (intent != null) {
            zzbf.zza(intent);
        }
        synchronized (this.zzc) {
            try {
                int i = this.zze - 1;
                this.zze = i;
                if (i == 0) {
                    stopSelfResult(this.zzd);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.zzb == null) {
                this.zzb = new zzbe(new zzbg(this) { // from class: Db0
                    public final zzc a;

                    {
                        this.a = this;
                    }

                    @Override // com.google.firebase.iid.zzbg
                    public final Task zza(Intent intent2) {
                        return this.a.zzd(intent2);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzb;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.zza.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.zzc) {
            this.zzd = i2;
            this.zze++;
        }
        Intent intentZza = zza(intent);
        if (intentZza == null) {
            zzf(intent);
            return 2;
        }
        Task<Void> taskZzd = zzd(intentZza);
        if (taskZzd.isComplete()) {
            zzf(intent);
            return 2;
        }
        taskZzd.addOnCompleteListener(Ad0.a, new OnCompleteListener(this, intent) { // from class: Cc0
            public final zzc a;
            public final Intent b;

            {
                this.a = this;
                this.b = intent;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.a.zza(this.b, task);
            }
        });
        return 3;
    }

    public Intent zza(Intent intent) {
        return intent;
    }

    public boolean zzb(Intent intent) {
        return false;
    }

    public abstract void zzc(Intent intent);

    public final /* synthetic */ void zza(Intent intent, Task task) {
        zzf(intent);
    }
}
