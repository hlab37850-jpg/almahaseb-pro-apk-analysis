package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import defpackage.M60;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbj implements ServiceConnection {
    private final Context zza;
    private final Intent zzb;
    private final ScheduledExecutorService zzc;
    private final Queue<M60> zzd;

    @Nullable
    private zzbe zze;

    @GuardedBy("this")
    private boolean zzf;

    public zzbj(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @GuardedBy("this")
    private final void zzb() {
        while (!this.zzd.isEmpty()) {
            this.zzd.poll().b();
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(componentName);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
                sb.append("onServiceConnected: ");
                sb.append(strValueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            this.zzf = false;
            if (iBinder instanceof zzbe) {
                this.zze = (zzbe) iBinder;
                zza();
                return;
            }
            String strValueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(strValueOf2);
            Log.e("FirebaseInstanceId", sb2.toString());
            zzb();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(strValueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        zza();
    }

    public final synchronized Task<Void> zza(Intent intent) {
        final M60 m60;
        try {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
            }
            m60 = new M60(intent);
            ScheduledExecutorService scheduledExecutorService = this.zzc;
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable(m60) { // from class: V60
                public final M60 a;

                {
                    this.a = m60;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c();
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            m60.a().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener(scheduledFutureSchedule) { // from class: S60
                public final ScheduledFuture a;

                {
                    this.a = scheduledFutureSchedule;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.a.cancel(false);
                }
            });
            this.zzd.add(m60);
            zza();
        } catch (Throwable th) {
            throw th;
        }
        return m60.a();
    }

    @VisibleForTesting
    private zzbj(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzd = new ArrayDeque();
        this.zzf = false;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzb = new Intent(str).setPackage(applicationContext.getPackageName());
        this.zzc = scheduledExecutorService;
    }

    private final synchronized void zza() {
        try {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "flush queue called");
            }
            while (!this.zzd.isEmpty()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "found intent to be delivered");
                }
                zzbe zzbeVar = this.zze;
                if (zzbeVar != null && zzbeVar.isBinderAlive()) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
                    }
                    this.zze.zza(this.zzd.poll());
                } else {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        boolean z = !this.zzf;
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("binder is dead. start connection? ");
                        sb.append(z);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                    if (!this.zzf) {
                        this.zzf = true;
                        try {
                            if (ConnectionTracker.getInstance().bindService(this.zza, this.zzb, this, 65)) {
                                return;
                            } else {
                                Log.e("FirebaseInstanceId", "binding to the service failed");
                            }
                        } catch (SecurityException e) {
                            Log.e("FirebaseInstanceId", "Exception while binding the service", e);
                        }
                        this.zzf = false;
                        zzb();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
