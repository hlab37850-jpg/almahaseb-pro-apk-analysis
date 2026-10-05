package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkRequest;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import defpackage.AbstractC2332h50;
import defpackage.BinderC1847c50;
import defpackage.C3281l40;
import defpackage.InterfaceC1766b50;
import defpackage.O40;
import defpackage.R40;
import defpackage.X40;
import defpackage.ti0;

/* JADX INFO: loaded from: classes2.dex */
public class FusedLocationProviderClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    @NonNull
    public static final String KEY_MOCK_LOCATION = "mockLocation";

    @NonNull
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    @VisibleForTesting(otherwise = 3)
    public FusedLocationProviderClient(@NonNull Activity activity) {
        super(activity, LocationServices.API, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final Task<Void> zze(final com.google.android.gms.internal.location.zzba zzbaVar, final LocationCallback locationCallback, Looper looper, final InterfaceC1766b50 interfaceC1766b50, int i) {
        final ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(locationCallback, com.google.android.gms.internal.location.zzbj.zza(looper), LocationCallback.class.getSimpleName());
        final R40 r40 = new R40(this, listenerHolderCreateListenerHolder);
        return doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall(this, r40, locationCallback, interfaceC1766b50, zzbaVar, listenerHolderCreateListenerHolder) { // from class: q40
            public final FusedLocationProviderClient a;
            public final AbstractC2332h50 b;
            public final LocationCallback c;
            public final InterfaceC1766b50 d;
            public final zzba e;
            public final ListenerHolder f;

            {
                this.a = this;
                this.b = r40;
                this.c = locationCallback;
                this.d = interfaceC1766b50;
                this.e = zzbaVar;
                this.f = listenerHolderCreateListenerHolder;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.a.zzb(this.b, this.c, this.d, this.e, this.f, (zzaz) obj, (TaskCompletionSource) obj2);
            }
        }).unregister(r40).withHolder(listenerHolderCreateListenerHolder).setMethodKey(i).build());
    }

    @NonNull
    public Task<Void> flushLocations() {
        return doWrite(TaskApiCall.builder().run(ti0.a).setMethodKey(2422).build());
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Location> getCurrentLocation(int i, @NonNull final CancellationToken cancellationToken) {
        LocationRequest locationRequestCreate = LocationRequest.create();
        locationRequestCreate.setPriority(i);
        locationRequestCreate.setInterval(0L);
        locationRequestCreate.setFastestInterval(0L);
        locationRequestCreate.setExpirationDuration(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        final com.google.android.gms.internal.location.zzba zzbaVarZza = com.google.android.gms.internal.location.zzba.zza(null, locationRequestCreate);
        zzbaVarZza.zzd(true);
        zzbaVarZza.zzb(WorkRequest.MIN_BACKOFF_MILLIS);
        Task taskDoRead = doRead(TaskApiCall.builder().run(new RemoteCall(this, cancellationToken, zzbaVarZza) { // from class: W30
            public final FusedLocationProviderClient a;
            public final CancellationToken b;
            public final zzba c;

            {
                this.a = this;
                this.b = cancellationToken;
                this.c = zzbaVarZza;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.a.zzc(this.b, this.c, (zzaz) obj, (TaskCompletionSource) obj2);
            }
        }).setFeatures(zzu.zzd).setMethodKey(2415).build());
        if (cancellationToken == null) {
            return taskDoRead;
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        taskDoRead.continueWithTask(new Continuation(taskCompletionSource) { // from class: f40
            public final TaskCompletionSource a;

            {
                this.a = taskCompletionSource;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                TaskCompletionSource taskCompletionSource2 = this.a;
                if (task.isSuccessful()) {
                    taskCompletionSource2.trySetResult((Location) task.getResult());
                } else {
                    Exception exception = task.getException();
                    if (exception != null) {
                        taskCompletionSource2.setException(exception);
                    }
                }
                return taskCompletionSource2.getTask();
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Location> getLastLocation() {
        return doRead(TaskApiCall.builder().run(new RemoteCall(this) { // from class: mi0
            public final FusedLocationProviderClient a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.a.zzd((zzaz) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(2414).build());
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<LocationAvailability> getLocationAvailability() {
        return doRead(TaskApiCall.builder().run(C3281l40.a).setMethodKey(2416).build());
    }

    @NonNull
    public Task<Void> removeLocationUpdates(@NonNull final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(pendingIntent) { // from class: B40
            public final PendingIntent a;

            {
                this.a = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzaz) obj).zzG(this.a, new BinderC1847c50((TaskCompletionSource) obj2));
            }
        }).setMethodKey(2418).build());
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull final PendingIntent pendingIntent) {
        final com.google.android.gms.internal.location.zzba zzbaVarZza = com.google.android.gms.internal.location.zzba.zza(null, locationRequest);
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, zzbaVarZza, pendingIntent) { // from class: w40
            public final FusedLocationProviderClient a;
            public final zzba b;
            public final PendingIntent c;

            {
                this.a = this;
                this.b = zzbaVarZza;
                this.c = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.a.zza(this.b, this.c, (zzaz) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(2417).build());
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> setMockLocation(@NonNull final Location location) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(location) { // from class: K40
            public final Location a;

            {
                this.a = location;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzaz) obj).zzJ(this.a);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).setMethodKey(2421).build());
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> setMockMode(final boolean z) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(z) { // from class: G40
            public final boolean a;

            {
                this.a = z;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzaz) obj).zzI(this.a);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).setMethodKey(2420).build());
    }

    public final /* synthetic */ void zza(com.google.android.gms.internal.location.zzba zzbaVar, PendingIntent pendingIntent, com.google.android.gms.internal.location.zzaz zzazVar, TaskCompletionSource taskCompletionSource) {
        BinderC1847c50 binderC1847c50 = new BinderC1847c50(taskCompletionSource);
        zzbaVar.zzc(getContextAttributionTag());
        zzazVar.zzD(zzbaVar, pendingIntent, binderC1847c50);
    }

    public final /* synthetic */ void zzb(final AbstractC2332h50 abstractC2332h50, final LocationCallback locationCallback, final InterfaceC1766b50 interfaceC1766b50, com.google.android.gms.internal.location.zzba zzbaVar, ListenerHolder listenerHolder, com.google.android.gms.internal.location.zzaz zzazVar, TaskCompletionSource taskCompletionSource) {
        X40 x40 = new X40(taskCompletionSource, new InterfaceC1766b50(this, abstractC2332h50, locationCallback, interfaceC1766b50) { // from class: Ai0
            public final FusedLocationProviderClient a;
            public final AbstractC2332h50 b;
            public final LocationCallback c;
            public final InterfaceC1766b50 d;

            {
                this.a = this;
                this.b = abstractC2332h50;
                this.c = locationCallback;
                this.d = interfaceC1766b50;
            }

            @Override // defpackage.InterfaceC1766b50
            public final void zza() {
                FusedLocationProviderClient fusedLocationProviderClient = this.a;
                AbstractC2332h50 abstractC2332h51 = this.b;
                LocationCallback locationCallback2 = this.c;
                InterfaceC1766b50 interfaceC1766b51 = this.d;
                abstractC2332h51.b(false);
                fusedLocationProviderClient.removeLocationUpdates(locationCallback2);
                if (interfaceC1766b51 != null) {
                    interfaceC1766b51.zza();
                }
            }
        });
        zzbaVar.zzc(getContextAttributionTag());
        zzazVar.zzB(zzbaVar, listenerHolder, x40);
    }

    public final /* synthetic */ void zzc(CancellationToken cancellationToken, com.google.android.gms.internal.location.zzba zzbaVar, com.google.android.gms.internal.location.zzaz zzazVar, final TaskCompletionSource taskCompletionSource) {
        final O40 o40 = new O40(this, taskCompletionSource);
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener(this, o40) { // from class: Fi0
                public final FusedLocationProviderClient a;
                public final LocationCallback b;

                {
                    this.a = this;
                    this.b = o40;
                }

                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    this.a.removeLocationUpdates(this.b);
                }
            });
        }
        zze(zzbaVar, o40, Looper.getMainLooper(), new InterfaceC1766b50(taskCompletionSource) { // from class: Mi0
            public final TaskCompletionSource a;

            {
                this.a = taskCompletionSource;
            }

            @Override // defpackage.InterfaceC1766b50
            public final void zza() {
                this.a.trySetResult(null);
            }
        }, 2437).continueWithTask(new Continuation(taskCompletionSource) { // from class: Q30
            public final TaskCompletionSource a;

            {
                this.a = taskCompletionSource;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                TaskCompletionSource taskCompletionSource2 = this.a;
                if (!task.isSuccessful()) {
                    if (task.getException() != null) {
                        Exception exception = task.getException();
                        if (exception != null) {
                            taskCompletionSource2.setException(exception);
                        }
                    } else {
                        taskCompletionSource2.trySetResult(null);
                    }
                }
                return taskCompletionSource2.getTask();
            }
        });
    }

    public final /* synthetic */ void zzd(com.google.android.gms.internal.location.zzaz zzazVar, TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setResult(zzazVar.zzz(getContextAttributionTag()));
    }

    @VisibleForTesting(otherwise = 3)
    public FusedLocationProviderClient(@NonNull Context context) {
        super(context, LocationServices.API, Api.ApiOptions.NO_OPTIONS, new ApiExceptionMapper());
    }

    @NonNull
    public Task<Void> removeLocationUpdates(@NonNull LocationCallback locationCallback) {
        return TaskUtil.toVoidTaskThatFailsOnFalse(doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback, LocationCallback.class.getSimpleName())));
    }

    @NonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull LocationCallback locationCallback, @NonNull Looper looper) {
        return zze(com.google.android.gms.internal.location.zzba.zza(null, locationRequest), locationCallback, looper, null, 2436);
    }
}
