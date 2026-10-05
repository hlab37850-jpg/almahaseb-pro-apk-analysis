package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.core.util.Consumer;
import com.android.billingclient.api.a;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zzau;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcu;
import com.google.android.gms.internal.play_billing.zzcz;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: n80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3453n80 extends M7 {
    public final Context K;
    public volatile int L;
    public volatile zzau M;
    public volatile ServiceConnectionC2256g80 N;
    public volatile ScheduledExecutorService O;

    public C3453n80(String str, Context context, InterfaceC3940t80 interfaceC3940t80, ExecutorService executorService, K7.a aVar) {
        super(null, context, null, null, aVar);
        this.L = 0;
        this.K = context;
    }

    public static final boolean D0(int i) {
        return i > 0;
    }

    public static /* synthetic */ Object S0(C3453n80 c3453n80, int i, zzp zzpVar) {
        String str;
        try {
            if (c3453n80.M == null) {
                throw null;
            }
            zzau zzauVar = c3453n80.M;
            String packageName = c3453n80.K.getPackageName();
            if (i == 2) {
                str = "LAUNCH_BILLING_FLOW";
            } else if (i == 3) {
                str = "ACKNOWLEDGE_PURCHASE";
            } else if (i == 4) {
                str = "CONSUME_ASYNC";
            } else if (i != 5) {
                str = i != 6 ? "QUERY_PRODUCT_DETAILS_ASYNC" : "START_CONNECTION";
            } else {
                str = "IS_FEATURE_SUPPORTED";
            }
            zzauVar.zza(packageName, str, new BinderC1853c80(zzpVar));
            return "billingOverrideService.getBillingOverride";
        } catch (Exception e) {
            c3453n80.G0(zzie.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, b.F);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e);
            zzpVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    public final synchronized void C0() {
        if (Q0()) {
            zzc.zzm("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            H0(26);
            return;
        }
        if (this.L == 1) {
            zzc.zzn("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.L == 3) {
            zzc.zzn("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            G0(zzie.BILLING_CLIENT_CLOSED, 26, b.a(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.L = 1;
        zzc.zzm("BillingClientTesting", "Starting Billing Override Service setup.");
        this.N = new ServiceConnectionC2256g80(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        Context context = this.K;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        zzie zzieVar = zzie.REASON_UNSPECIFIED;
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                    zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                    zzc.zzn("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    if (context.bindService(intent2, this.N, 1)) {
                        zzc.zzm("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    } else {
                        zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                        zzc.zzn("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                    }
                }
            }
        }
        this.L = 0;
        zzc.zzm("BillingClientTesting", "Billing Override Service unavailable on device.");
        G0(zzieVar, 26, b.a(2, "Billing Override Service unavailable on device."));
    }

    public final a E0(int i, int i2) {
        a aVarA = b.a(i2, "Billing override value was set by a license tester.");
        G0(zzie.LICENSE_TESTER_BILLING_OVERRIDE, i, aVarA);
        return aVarA;
    }

    public final zzcz F0(final int i) {
        if (Q0()) {
            return zzu.zza(new zzr() { // from class: B70
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(zzp zzpVar) {
                    return C3453n80.S0(this.a, i, zzpVar);
                }
            });
        }
        zzc.zzn("BillingClientTesting", "Billing Override Service is not ready.");
        G0(zzie.BILLING_OVERRIDE_SERVICE_CONNECTION_NOT_READY, 28, b.a(-1, "Billing Override Service connection is disconnected."));
        return zzcu.zza(0);
    }

    public final void G0(zzie zzieVar, int i, a aVar) {
        int i2 = AbstractC3778r80.a;
        zzhx zzhxVarB = AbstractC3778r80.b(zzieVar, i, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzhxVarB, "ApiFailure should not be null");
        p0().b(zzhxVarB);
    }

    public final void H0(int i) {
        int i2 = AbstractC3778r80.a;
        zzib zzibVarC = AbstractC3778r80.c(i, zzil.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzibVarC, "ApiSuccess should not be null");
        p0().h(zzibVarC);
    }

    public final void I0(int i, Consumer consumer, Runnable runnable) {
        zzcu.zzc(zzcu.zzb(F0(i), 28500L, TimeUnit.MILLISECONDS, W0()), new C1206a80(this, i, consumer, runnable), h());
    }

    public final synchronized boolean Q0() {
        return (this.L != 2 || this.M == null || this.N == null) ? false : true;
    }

    public final int V0(zzcz zzczVar) {
        try {
            return ((Integer) zzczVar.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e) {
            G0(zzie.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, b.F);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e);
            return 0;
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            G0(zzie.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, b.F);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e2);
            return 0;
        }
    }

    public final synchronized ScheduledExecutorService W0() {
        try {
            if (this.O == null) {
                this.O = Executors.newSingleThreadScheduledExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.O;
    }

    @Override // defpackage.M7, defpackage.K7
    public final void a(final V1 v1, final W1 w1) {
        Objects.requireNonNull(w1);
        I0(3, new Consumer() { // from class: D70
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                w1.a((a) obj);
            }
        }, new Runnable() { // from class: G70
            @Override // java.lang.Runnable
            public final void run() {
                super/*M7*/.a(v1, w1);
            }
        });
    }

    @Override // defpackage.M7, defpackage.K7
    public final a b(final Activity activity, final O7 o7) {
        Consumer consumer = new Consumer() { // from class: I70
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                super/*M7*/.s0((a) obj);
            }
        };
        Callable callable = new Callable() { // from class: K70
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return super/*M7*/.b(activity, o7);
            }
        };
        int iV0 = V0(F0(2));
        if (D0(iV0)) {
            a aVarE0 = E0(2, iV0);
            consumer.accept(aVarE0);
            return aVarE0;
        }
        try {
            return (a) callable.call();
        } catch (Exception e) {
            zzie zzieVar = zzie.BILLING_OVERRIDE_SERVICE_FALLBACK_ERROR;
            a aVar = b.h;
            G0(zzieVar, 2, aVar);
            zzc.zzo("BillingClientTesting", "An internal error occurred.", e);
            return aVar;
        }
    }

    @Override // defpackage.M7, defpackage.K7
    public final void d(final YI yi, final InterfaceC2267gI interfaceC2267gI) {
        I0(7, new Consumer() { // from class: r70
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ZI zi = new ZI(new ArrayList(), new ArrayList());
                interfaceC2267gI.a((a) obj, zi);
            }
        }, new Runnable() { // from class: v70
            @Override // java.lang.Runnable
            public final void run() {
                super/*M7*/.d(yi, interfaceC2267gI);
            }
        });
    }

    @Override // defpackage.M7, defpackage.K7
    public final void f(N7 n7) {
        C0();
        super.f(n7);
    }

    public C3453n80(String str, C4111vG c4111vG, Context context, C80 c80, InterfaceC3940t80 interfaceC3940t80, ExecutorService executorService, K7.a aVar) {
        super(null, c4111vG, context, null, null, null, aVar);
        this.L = 0;
        this.K = context;
    }

    public C3453n80(String str, C4111vG c4111vG, Context context, FI fi, InterfaceC2170f60 interfaceC2170f60, InterfaceC3940t80 interfaceC3940t80, ExecutorService executorService, K7.a aVar) {
        super(null, c4111vG, context, fi, null, null, null, aVar);
        this.L = 0;
        this.K = context;
    }
}
