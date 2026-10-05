package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.platforminfo.UserAgentPublisher;
import defpackage.AbstractC4472zd0;
import defpackage.C3285l60;
import defpackage.C3694q60;
import defpackage.C4096v50;
import defpackage.Fg0;
import defpackage.InterfaceC4258x50;
import defpackage.R50;
import defpackage.RunnableC2334h60;
import defpackage.Sh0;
import defpackage.Y30;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstanceId {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static R50 zzb;

    @VisibleForTesting
    private static ScheduledExecutorService zzc;

    @VisibleForTesting
    private final Executor zzd;
    private final FirebaseApp zze;
    private final zzaq zzf;
    private final Sh0 zzg;
    private final C4096v50 zzh;
    private final C3694q60 zzi;
    private final FirebaseInstallationsApi zzj;
    private boolean zzk;
    private final a zzl;

    public class a {
        public boolean a;
        public final Subscriber b;
        public boolean c;
        public EventHandler d;
        public Boolean e;

        public a(Subscriber subscriber) {
            this.b = subscriber;
        }

        public final synchronized void a(boolean z) {
            try {
                c();
                EventHandler eventHandler = this.d;
                if (eventHandler != null) {
                    this.b.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                    this.d = null;
                }
                SharedPreferences.Editor editorEdit = FirebaseInstanceId.this.zze.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                editorEdit.putBoolean("auto_init", z);
                editorEdit.apply();
                if (z) {
                    FirebaseInstanceId.this.zzj();
                }
                this.e = Boolean.valueOf(z);
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized boolean b() {
            c();
            Boolean bool = this.e;
            if (bool != null) {
                return bool.booleanValue();
            }
            return this.a && FirebaseInstanceId.this.zze.isDataCollectionDefaultEnabled();
        }

        public final synchronized void c() {
            try {
                if (this.c) {
                    return;
                }
                this.a = e();
                Boolean boolD = d();
                this.e = boolD;
                if (boolD == null && this.a) {
                    EventHandler eventHandler = new EventHandler(this) { // from class: Lh0
                        public final FirebaseInstanceId.a a;

                        {
                            this.a = this;
                        }

                        @Override // com.google.firebase.events.EventHandler
                        public final void handle(Event event) {
                            FirebaseInstanceId.a aVar = this.a;
                            synchronized (aVar) {
                                try {
                                    if (aVar.b()) {
                                        FirebaseInstanceId.this.zzj();
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    };
                    this.d = eventHandler;
                    this.b.subscribe(DataCollectionDefaultChange.class, eventHandler);
                }
                this.c = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        public final Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public final boolean e() {
            try {
                String str = FirebaseMessaging.INSTANCE_ID_SCOPE;
                return true;
            } catch (ClassNotFoundException unused) {
                Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveInfoResolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                return (resolveInfoResolveService == null || resolveInfoResolveService.serviceInfo == null) ? false : true;
            }
        }
    }

    public FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new zzaq(firebaseApp.getApplicationContext()), AbstractC4472zd0.c(), AbstractC4472zd0.c(), subscriber, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    @NonNull
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static boolean zzd() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj() {
        if (zza(zzb()) || this.zzi.b()) {
            zzk();
        }
    }

    private final synchronized void zzk() {
        if (!this.zzk) {
            zza(0L);
        }
    }

    private final String zzl() {
        try {
            zzb.i(this.zze.getPersistenceKey());
            Task<String> id = this.zzj.getId();
            Preconditions.checkNotNull(id, "Task must not be null");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            id.addOnCompleteListener(Fg0.a, new OnCompleteListener(countDownLatch) { // from class: rh0
                public final CountDownLatch a;

                {
                    this.a = countDownLatch;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.a.countDown();
                }
            });
            countDownLatch.await(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
            if (id.isSuccessful()) {
                return id.getResult();
            }
            if (id.isCanceled()) {
                throw new CancellationException("Task is already canceled");
            }
            throw new IllegalStateException(id.getException());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        zza(this.zze);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zza(this.zzj.delete());
        zze();
    }

    @WorkerThread
    public void deleteToken(@NonNull String str, @NonNull String str2) throws IOException {
        zza(this.zze);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String strZzd = zzd(str2);
        zza(this.zzg.j(zzl(), str, strZzd));
        zzb.h("", str, strZzd);
    }

    public long getCreationTime() {
        return zzb.f(this.zze.getPersistenceKey());
    }

    @NonNull
    @WorkerThread
    public String getId() {
        zza(this.zze);
        zzj();
        return zzl();
    }

    @NonNull
    public Task<InstanceIdResult> getInstanceId() {
        return zza(zzaq.zza(this.zze), "*");
    }

    @Nullable
    @Deprecated
    public String getToken() {
        zza(this.zze);
        C3285l60 c3285l60Zzb = zzb();
        if (zza(c3285l60Zzb)) {
            zzk();
        }
        return C3285l60.b(c3285l60Zzb);
    }

    public final FirebaseApp zza() {
        return this.zze;
    }

    @Nullable
    public final C3285l60 zzb() {
        return zzb(zzaq.zza(this.zze), "*");
    }

    public final String zzc() {
        return getToken(zzaq.zza(this.zze), "*");
    }

    public final synchronized void zze() {
        zzb.g();
        if (this.zzl.b()) {
            zzk();
        }
    }

    public final boolean zzf() {
        return this.zzf.zza() != 0;
    }

    public final void zzg() {
        zzb.l("");
        zzk();
    }

    @VisibleForTesting
    public final boolean zzh() {
        return this.zzl.b();
    }

    public final /* synthetic */ void zzi() {
        if (this.zzl.b()) {
            zzj();
        }
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    @Nullable
    @VisibleForTesting
    private static C3285l60 zzb(String str, String str2) {
        return zzb.c("", str, str2);
    }

    public final synchronized void zza(boolean z) {
        this.zzk = z;
    }

    public final void zzc(String str) throws IOException {
        C3285l60 c3285l60Zzb = zzb();
        if (zza(c3285l60Zzb)) {
            throw new IOException("token not available");
        }
        zza(this.zzg.l(zzl(), c3285l60Zzb.a, str));
    }

    private static String zzd(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    public final void zzb(String str) throws IOException {
        C3285l60 c3285l60Zzb = zzb();
        if (!zza(c3285l60Zzb)) {
            zza(this.zzg.k(zzl(), c3285l60Zzb.a, str));
            return;
        }
        throw new IOException("token not available");
    }

    public final synchronized void zza(long j) {
        zza(new RunnableC2334h60(this, this.zzf, this.zzi, Math.min(Math.max(30L, j << 1), zza)), j);
        this.zzk = true;
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzaq zzaqVar, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.zzk = false;
        if (zzaq.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                try {
                    if (zzb == null) {
                        zzb = new R50(firebaseApp.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.zze = firebaseApp;
            this.zzf = zzaqVar;
            this.zzg = new Sh0(firebaseApp, zzaqVar, executor, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
            this.zzd = executor2;
            this.zzi = new C3694q60(zzb);
            this.zzl = new a(subscriber);
            this.zzh = new C4096v50(executor);
            this.zzj = firebaseInstallationsApi;
            executor2.execute(new Runnable(this) { // from class: eg0
                public final FirebaseInstanceId a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.zzi();
                }
            });
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    @Nullable
    @WorkerThread
    public String getToken(@NonNull String str, @NonNull String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) zza(zza(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    public static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            try {
                if (zzc == null) {
                    zzc = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
                }
                zzc.schedule(runnable, j, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final void zzb(boolean z) {
        this.zzl.a(z);
    }

    private static void zza(@NonNull FirebaseApp firebaseApp) {
        String projectId;
        if (TextUtils.isEmpty(firebaseApp.getOptions().getProjectId())) {
            projectId = firebaseApp.getOptions().getGcmSenderId();
        } else {
            projectId = firebaseApp.getOptions().getProjectId();
        }
        Preconditions.checkNotEmpty(projectId, "FirebaseApp should have a non-empty projectId.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "FirebaseApp should have a non-empty applicationId.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "FirebaseApp should have a non-empty apiKey.");
    }

    private final Task<InstanceIdResult> zza(final String str, String str2) {
        final String strZzd = zzd(str2);
        return Tasks.forResult(null).continueWithTask(this.zzd, new Continuation(this, str, strZzd) { // from class: eh0
            public final FirebaseInstanceId a;
            public final String b;
            public final String c;

            {
                this.a = this;
                this.b = str;
                this.c = strZzd;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.a.zza(this.b, this.c, task);
            }
        });
    }

    private final <T> T zza(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    zze();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e);
        }
    }

    public final synchronized Task<Void> zza(String str) {
        Task<Void> taskA;
        taskA = this.zzi.a(str);
        zzk();
        return taskA;
    }

    public final boolean zza(@Nullable C3285l60 c3285l60) {
        return c3285l60 == null || c3285l60.d(this.zzf.zzb());
    }

    public final /* synthetic */ Task zza(final String str, final String str2, Task task) {
        final String strZzl = zzl();
        C3285l60 c3285l60Zzb = zzb(str, str2);
        if (!zza(c3285l60Zzb)) {
            return Tasks.forResult(new Y30(strZzl, c3285l60Zzb.a));
        }
        return this.zzh.b(str, str2, new InterfaceC4258x50(this, strZzl, str, str2) { // from class: ih0
            public final FirebaseInstanceId a;
            public final String b;
            public final String c;
            public final String d;

            {
                this.a = this;
                this.b = strZzl;
                this.c = str;
                this.d = str2;
            }

            @Override // defpackage.InterfaceC4258x50
            public final Task zza() {
                return this.a.zza(this.b, this.c, this.d);
            }
        });
    }

    public final /* synthetic */ Task zza(final String str, final String str2, final String str3) {
        return this.zzg.b(str, str2, str3).onSuccessTask(this.zzd, new SuccessContinuation(this, str2, str3, str) { // from class: Ch0
            public final FirebaseInstanceId a;
            public final String b;
            public final String c;
            public final String d;

            {
                this.a = this;
                this.b = str2;
                this.c = str3;
                this.d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.a.zza(this.b, this.c, this.d, (String) obj);
            }
        });
    }

    public final /* synthetic */ Task zza(String str, String str2, String str3, String str4) {
        zzb.e("", str, str2, str4, this.zzf.zzb());
        return Tasks.forResult(new Y30(str3, str4));
    }
}
