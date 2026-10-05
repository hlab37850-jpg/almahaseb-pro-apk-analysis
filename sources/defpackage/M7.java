package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import com.android.billingclient.api.ProxyBillingActivity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.a;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzaz;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzbl;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzby;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcu;
import com.google.android.gms.internal.play_billing.zzcz;
import com.google.android.gms.internal.play_billing.zzdj;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class M7 extends K7 {
    public boolean A;
    public boolean B;
    public boolean C;
    public C4111vG D;
    public boolean E;
    public boolean F;
    public volatile N7 G;
    public ExecutorService H;
    public final Long I;
    public zzbl J;
    public final Object a;
    public volatile int b;
    public final String c;
    public final String d;
    public final Handler e;
    public volatile Th0 f;
    public Context g;
    public InterfaceC3940t80 h;
    public volatile zzam i;
    public volatile C60 j;
    public boolean k;
    public boolean l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public M7(String str, Context context, InterfaceC3940t80 interfaceC3940t80, ExecutorService executorService, K7.a aVar) {
        this.a = new Object();
        this.b = 0;
        this.e = new Handler(Looper.getMainLooper());
        this.m = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.I = lValueOf;
        this.J = zzaz.zza();
        this.c = "8.0.0";
        String strZ = Z();
        this.d = strZ;
        this.g = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs("8.0.0");
        if (strZ != null) {
            zziqVarZzc.zzt(strZ);
        }
        zziqVarZzc.zzq(this.g.getPackageName());
        zziqVarZzc.zzn(lValueOf.longValue());
        zziqVarZzc.zzr(aVar.f);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.h = new C4183w80(this.g, (zzis) zziqVarZzc.zze());
        this.g.getPackageName();
        this.E = aVar.f;
    }

    public static final String E(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i != 1) {
            return i != 2 ? "CLOSED" : "CONNECTED";
        }
        return "CONNECTING";
    }

    public static /* bridge */ /* synthetic */ void H(M7 m7, int i) {
        m7.m = i;
        m7.C = i >= 26;
        m7.B = i >= 24;
        m7.A = i >= 23;
        m7.z = i >= 22;
        m7.y = i >= 21;
        m7.x = i >= 20;
        m7.w = i >= 19;
        m7.v = i >= 18;
        m7.u = i >= 17;
        m7.t = i >= 16;
        m7.s = i >= 15;
        m7.r = i >= 14;
        m7.q = i >= 12;
        m7.p = i >= 9;
        m7.o = i >= 8;
        m7.n = i >= 6;
    }

    public static /* bridge */ /* synthetic */ void J(M7 m7, int i) {
        if (i != 0) {
            m7.y(0);
            return;
        }
        synchronized (m7.a) {
            try {
                if (m7.b == 3) {
                    return;
                }
                m7.y(2);
                Th0 th0 = m7.f != null ? m7.f : null;
                if (th0 != null) {
                    th0.f(m7.y);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean N(M7 m7) {
        boolean z;
        synchronized (m7.a) {
            z = true;
            if (m7.b != 1) {
                z = false;
            }
        }
        return z;
    }

    public static String Z() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Future i(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: Q40
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void j(M7 m7, EI ei) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        a aVar = b.k;
        m7.d0(zzieVar, 9, aVar);
        ei.a(aVar, zzbt.zzk());
    }

    public static /* synthetic */ void k(M7 m7, W1 w1) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        a aVar = b.k;
        m7.d0(zzieVar, 3, aVar);
        w1.a(aVar);
    }

    public static /* synthetic */ void l(M7 m7, InterfaceC2267gI interfaceC2267gI) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        a aVar = b.k;
        m7.d0(zzieVar, 7, aVar);
        interfaceC2267gI.a(aVar, new ZI(zzbt.zzk(), zzbt.zzk()));
    }

    public static /* synthetic */ void m(M7 m7, a aVar) {
        if (m7.f.d() != null) {
            m7.f.d().a(aVar, null);
        } else {
            zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    public static /* bridge */ /* synthetic */ a r0(Exception exc) {
        return exc instanceof DeadObjectException ? b.j : b.h;
    }

    public static /* synthetic */ Object w0(M7 m7, int i, zzp zzpVar) {
        m7.z(new C3774r60(m7, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object x0(M7 m7, InterfaceC2267gI interfaceC2267gI, YI yi) {
        if (!m7.C(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            a aVar = b.j;
            m7.d0(zzieVar, 7, aVar);
            interfaceC2267gI.a(aVar, new ZI(zzbt.zzk(), zzbt.zzk()));
            return null;
        }
        if (m7.u) {
            C2254g70 c2254g70M0 = m7.m0(yi);
            interfaceC2267gI.a(b.a(c2254g70M0.a(), c2254g70M0.b()), new ZI(c2254g70M0.c(), c2254g70M0.d()));
            return null;
        }
        zzc.zzn("BillingClient", "Querying product details is not supported.");
        zzie zzieVar2 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
        a aVar2 = b.r;
        m7.d0(zzieVar2, 7, aVar2);
        interfaceC2267gI.a(aVar2, new ZI(zzbt.zzk(), zzbt.zzk()));
        return null;
    }

    public static /* synthetic */ Object y0(M7 m7, W1 w1, V1 v1) {
        m7.X(w1, v1);
        return null;
    }

    public final void A() {
        synchronized (this.a) {
            if (this.j != null) {
                try {
                    this.g.unbindService(this.j);
                    this.i = null;
                    this.j = null;
                } catch (Throwable th) {
                    try {
                        zzc.zzo("BillingClient", "There was an exception while unbinding service!", th);
                        this.i = null;
                        this.j = null;
                    } catch (Throwable th2) {
                        this.i = null;
                        this.j = null;
                        throw th2;
                    }
                }
            }
        }
    }

    public final boolean B(long j) {
        try {
            a aVar = (a) W(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (aVar.c() == 0) {
                zzc.zzm("BillingClient", "Reconnection succeeded with result: " + aVar.c());
            } else {
                zzc.zzn("BillingClient", "Reconnection failed with result: " + aVar.c());
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
        }
        return D();
    }

    public final boolean C(long j) {
        zzbi zzbiVarZzb = zzbi.zzb(this.J);
        long jZza = 30000;
        for (int i = 1; i <= 3; i++) {
            try {
                long jMax = Math.max(0L, jZza);
                if (jMax <= 0) {
                    zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                    return D();
                }
                a aVar = (a) W(i).get(jMax, TimeUnit.MILLISECONDS);
                if (aVar.c() == 0) {
                    zzc.zzm("BillingClient", "Reconnection succeeded with result: " + aVar.c());
                    return D();
                }
                zzc.zzn("BillingClient", "Reconnection failed with result: " + aVar.c());
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jZza = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS - zzbiVarZzb.zza(timeUnit);
                long jPow = ((long) Math.pow(2.0d, i - 1)) * 1000;
                if (jZza < jPow) {
                    zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                    return D();
                }
                if (i < 3 && jPow > 0) {
                    try {
                        Thread.sleep(jPow);
                        jZza = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS - zzbiVarZzb.zza(timeUnit);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e);
                    }
                }
            } catch (Exception e2) {
                if (e2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                zzc.zzo("BillingClient", "Error during reconnection attempt: ", e2);
            }
        }
        zzc.zzn("BillingClient", "Max retries reached.");
        return D();
    }

    public final boolean D() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.b == 2 && this.i != null && this.j != null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void L(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.e.post(runnable);
        }
    }

    public final /* synthetic */ Bundle Q(int i, String str, String str2, O7 o7, Bundle bundle) {
        zzam zzamVar;
        try {
            synchronized (this.a) {
                zzamVar = this.i;
            }
            return zzamVar == null ? zzc.zzd(b.j, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzg(i, this.g.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return zzc.zze(b.j, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, AbstractC3778r80.a(e));
        } catch (Exception e2) {
            return zzc.zze(b.h, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, AbstractC3778r80.a(e2));
        }
    }

    public final /* synthetic */ Bundle R(String str, String str2) {
        zzam zzamVar;
        try {
            synchronized (this.a) {
                zzamVar = this.i;
            }
            return zzamVar == null ? zzc.zzd(b.j, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzf(3, this.g.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return zzc.zze(b.j, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, AbstractC3778r80.a(e));
        } catch (Exception e2) {
            return zzc.zze(b.h, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, AbstractC3778r80.a(e2));
        }
    }

    public final Handler S() {
        return Looper.myLooper() == null ? this.e : new Handler(Looper.myLooper());
    }

    public final C2254g70 T(a aVar, zzie zzieVar, String str, Exception exc) {
        zzc.zzo("BillingClient", str, exc);
        f0(zzieVar, 7, aVar, AbstractC3778r80.a(exc));
        return new C2254g70(aVar.c(), aVar.a(), new ArrayList(), new ArrayList());
    }

    public final a U(int i) {
        zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzhz zzhzVarZzc = zzib.zzc();
        zzhzVarZzc.zzo(6);
        zzjt zzjtVarZzc = zzjv.zzc();
        zzjtVarZzc.zzn(true);
        zzjtVarZzc.zza(i > 0);
        zzjtVarZzc.zzl(i);
        zzhzVarZzc.zzn(zzjtVarZzc);
        w((zzib) zzhzVarZzc.zze());
        return b.i;
    }

    public final a V() {
        a aVar;
        int[] iArr = {0, 3};
        synchronized (this.a) {
            for (int i = 0; i < 2; i++) {
                if (this.b == iArr[i]) {
                    aVar = b.j;
                }
            }
            aVar = b.h;
        }
        return aVar;
    }

    public final zzcz W(final int i) {
        if (this.E && !D()) {
            return zzu.zza(new zzr() { // from class: hi0
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(zzp zzpVar) {
                    return M7.w0(this.a, i, zzpVar);
                }
            });
        }
        zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
        return zzcu.zza(b.i);
    }

    public final /* synthetic */ Object X(W1 w1, V1 v1) {
        zzam zzamVar;
        try {
            if (!C(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                a aVar = b.j;
                d0(zzieVar, 3, aVar);
                w1.a(aVar);
            } else if (TextUtils.isEmpty(v1.a())) {
                zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                zzie zzieVar2 = zzie.EMPTY_PURCHASE_TOKEN;
                a aVar2 = b.g;
                d0(zzieVar2, 3, aVar2);
                w1.a(aVar2);
            } else if (this.p) {
                synchronized (this.a) {
                    zzamVar = this.i;
                }
                if (zzamVar != null) {
                    String packageName = this.g.getPackageName();
                    String strA = v1.a();
                    String str = this.c;
                    String str2 = this.d;
                    long jLongValue = this.I.longValue();
                    int i = zzc.zza;
                    Bundle bundle = new Bundle();
                    zzc.zzc(bundle, str, str2, jLongValue);
                    Bundle bundleZzd = zzamVar.zzd(9, packageName, strA, bundle);
                    w1.a(b.a(zzc.zzb(bundleZzd, "BillingClient"), zzc.zzj(bundleZzd, "BillingClient")));
                    return null;
                }
                t(w1, b.j, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzie zzieVar3 = zzie.API_VERSION_NOT_V9;
                a aVar3 = b.a;
                d0(zzieVar3, 3, aVar3);
                w1.a(aVar3);
            }
            return null;
        } catch (DeadObjectException e) {
            t(w1, b.j, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            t(w1, b.h, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    public final String Y(YI yi) {
        if (TextUtils.isEmpty(null)) {
            return this.g.getPackageName();
        }
        return null;
    }

    @Override // defpackage.K7
    public void a(final V1 v1, final W1 w1) {
        if (i(new Callable() { // from class: T30
            @Override // java.util.concurrent.Callable
            public final Object call() {
                M7.y0(this.a, w1, v1);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: Z30
            @Override // java.lang.Runnable
            public final void run() {
                M7.k(this.a, w1);
            }
        }, S(), h()) == null) {
            a aVarV = V();
            d0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, aVarV);
            w1.a(aVarV);
        }
    }

    @Override // defpackage.K7
    public a b(Activity activity, final O7 o7) {
        boolean zD;
        Future futureI;
        zzie zzieVarZzb;
        String string;
        Object obj;
        boolean z;
        boolean z2;
        final int i;
        long jNextLong = new Random().nextLong();
        if (this.f == null || this.f.d() == null) {
            zzie zzieVar = zzie.MISSING_LISTENER;
            a aVar = b.E;
            e0(zzieVar, 2, aVar, jNextLong);
            return aVar;
        }
        if (!B(3000L)) {
            zzie zzieVar2 = zzie.SERVICE_CONNECTION_NOT_READY;
            a aVar2 = b.j;
            e0(zzieVar2, 2, aVar2, jNextLong);
            s0(aVar2);
            return aVar2;
        }
        synchronized (this.a) {
            try {
                zD = this.j != null ? this.j.d() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayListK = o7.k();
        List listL = o7.l();
        String str = null;
        AbstractC3574of.a(zzby.zza(arrayListK, null));
        O7.b bVar = (O7.b) zzby.zza(listL, null);
        final String strC = bVar.b().c();
        final String strD = bVar.b().d();
        if (strD.equals("subs") && !this.k) {
            zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
            zzie zzieVar3 = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
            a aVar3 = b.l;
            g0(zzieVar3, 2, aVar3, jNextLong, zD);
            s0(aVar3);
            return aVar3;
        }
        if (o7.u() && !this.n) {
            zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzie zzieVar4 = zzie.EXTRA_PARAMS_NOT_SUPPORTED;
            a aVar4 = b.f;
            g0(zzieVar4, 2, aVar4, jNextLong, zD);
            s0(aVar4);
            return aVar4;
        }
        if (arrayListK.size() > 1 && !this.t) {
            zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
            zzie zzieVar5 = zzie.MULTI_ITEM_NOT_SUPPORTED;
            a aVar5 = b.p;
            g0(zzieVar5, 2, aVar5, jNextLong, zD);
            s0(aVar5);
            return aVar5;
        }
        if (!listL.isEmpty() && !this.u) {
            zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzie zzieVar6 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
            a aVar6 = b.r;
            g0(zzieVar6, 2, aVar6, jNextLong, zD);
            s0(aVar6);
            return aVar6;
        }
        a aVarE = o7.e();
        if (aVarE != b.i) {
            g0(zzie.INVALID_BILLING_FLOW_PARAMS, 2, aVarE, jNextLong, zD);
            s0(aVarE);
            return aVarE;
        }
        if (this.n) {
            boolean z3 = this.p;
            boolean z4 = this.w;
            boolean zA = this.D.a();
            boolean zB = this.D.b();
            boolean z5 = this.F;
            String str2 = this.c;
            String str3 = this.d;
            long jLongValue = this.I.longValue();
            this.g.getPackageName();
            int i2 = zzc.zza;
            final Bundle bundle = new Bundle();
            zzc.zzc(bundle, str2, str3, jLongValue);
            bundle.putLong("billingClientTransactionId", jNextLong);
            if (o7.c() != 0) {
                bundle.putInt("prorationMode", o7.c());
            }
            if (!TextUtils.isEmpty(o7.f())) {
                bundle.putString("accountId", o7.f());
            }
            if (!TextUtils.isEmpty(o7.g())) {
                bundle.putString("obfuscatedProfileId", o7.g());
            }
            if (o7.t()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(o7.i())) {
                bundle.putString("oldSkuPurchaseToken", o7.i());
            }
            o7.h();
            if (!TextUtils.isEmpty(null)) {
                o7.h();
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(o7.j())) {
                bundle.putString("originalExternalTransactionId", o7.j());
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("paymentsPurchaseParams", null);
            }
            if (z3 && zA) {
                z = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z = true;
            }
            if (z4 && zB) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z);
            }
            if (z5) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            o7.d();
            o7.b();
            ArrayList arrayList = new ArrayList();
            for (O7.b bVar2 : o7.l()) {
            }
            if (!arrayList.isEmpty()) {
                zzdj zzdjVarZza = zzdk.zza();
                zzdjVarZza.zza(arrayList);
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdk) zzdjVarZza.zze()).zzM());
            }
            if (arrayListK.isEmpty()) {
                ArrayList<String> arrayList2 = new ArrayList<>(listL.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(listL.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                for (int i3 = 0; i3 < listL.size(); i3++) {
                    O7.b bVar3 = (O7.b) listL.get(i3);
                    C2185fI c2185fIB = bVar3.b();
                    if (!c2185fIB.g().isEmpty()) {
                        arrayList4.add(c2185fIB.g());
                    }
                    arrayList5.add(bVar3.c());
                    String strH = c2185fIB.h();
                    if (c2185fIB.i() != null && !c2185fIB.i().isEmpty()) {
                        for (C2185fI.b bVar4 : c2185fIB.i()) {
                            if (!TextUtils.isEmpty(bVar4.c())) {
                                strH = bVar4.c();
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strH)) {
                        arrayList6.add(strH);
                    }
                    if (i3 > 0) {
                        arrayList2.add(((O7.b) listL.get(i3)).b().c());
                        arrayList3.add(((O7.b) listL.get(i3)).b().d());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                if (!arrayList7.isEmpty()) {
                    bundle.putIntegerArrayList("autoPayBalanceThresholdList", arrayList7);
                }
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                }
            } else {
                ArrayList<String> arrayList8 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it = arrayListK.iterator();
                if (it.hasNext()) {
                    AbstractC3574of.a(it.next());
                    throw null;
                }
                if (!arrayList8.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList8);
                }
                if (arrayListK.size() > 1) {
                    ArrayList<String> arrayList9 = new ArrayList<>(arrayListK.size() - 1);
                    ArrayList<String> arrayList10 = new ArrayList<>(arrayListK.size() - 1);
                    if (1 < arrayListK.size()) {
                        AbstractC3574of.a(arrayListK.get(1));
                        throw null;
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList9);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList10);
                }
            }
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.r) {
                zzie zzieVar7 = zzie.OFFER_ID_TOKEN_NOT_SUPPORTED;
                a aVar7 = b.q;
                g0(zzieVar7, 2, aVar7, jNextLong, zD);
                s0(aVar7);
                return aVar7;
            }
            if (bVar == null || TextUtils.isEmpty(bVar.b().f())) {
                z2 = false;
            } else {
                bundle.putString("skuPackageName", bVar.b().f());
                z2 = true;
            }
            str = null;
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountName", null);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzc.zzn("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                bundle.putString("proxyPackage", stringExtra);
                try {
                    bundle.putString("proxyPackageVersion", this.g.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused) {
                    bundle.putString("proxyPackageVersion", "package not found");
                }
            }
            if (this.u && !listL.isEmpty()) {
                i = 17;
            } else if (this.s && z2) {
                i = 15;
            } else {
                i = this.p ? 9 : 6;
            }
            futureI = i(new Callable() { // from class: wi0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.Q(i, strC, strD, o7, bundle);
                }
            }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, this.e, h());
        } else {
            futureI = i(new Callable() { // from class: Ci0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.R(strC, strD);
                }
            }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, this.e, h());
        }
        try {
            if (futureI == null) {
                zzie zzieVar8 = zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                a aVar8 = b.c;
                g0(zzieVar8, 2, aVar8, jNextLong, zD);
                s0(aVar8);
                return aVar8;
            }
            Bundle bundle2 = (Bundle) futureI.get(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
            int iZzb = zzc.zzb(bundle2, "BillingClient");
            String strZzj = zzc.zzj(bundle2, "BillingClient");
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                intent2.putExtra("billingClientTransactionId", jNextLong);
                intent2.putExtra("wasServiceAutoReconnected", zD);
                activity.startActivity(intent2);
                return b.i;
            }
            zzc.zzn("BillingClient", "Unable to buy item, Error response code: " + iZzb);
            a aVarA = b.a(iZzb, strZzj);
            try {
                if (bundle2 == null || (obj = bundle2.get("LOG_REASON")) == null) {
                    zzieVarZzb = zzie.REASON_UNSPECIFIED;
                } else if (obj instanceof Integer) {
                    zzieVarZzb = zzie.zzb(((Integer) obj).intValue());
                } else {
                    zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                    zzieVarZzb = zzie.REASON_UNSPECIFIED;
                }
            } catch (Throwable th2) {
                zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th2.getMessage())));
                zzieVarZzb = zzie.REASON_UNSPECIFIED;
            }
            if (zzieVarZzb == zzie.REASON_UNSPECIFIED) {
                zzieVarZzb = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            }
            zzie zzieVar9 = zzieVarZzb;
            if (bundle2 == null) {
                string = str;
            } else {
                try {
                    string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th3) {
                    zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th3.getMessage())));
                    string = str;
                }
            }
            h0(zzieVar9, 2, aVarA, string, jNextLong, zD);
            s0(aVarA);
            return aVarA;
        } catch (CancellationException e) {
            e = e;
            zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
            zzie zzieVar10 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
            a aVar9 = b.k;
            h0(zzieVar10, 2, aVar9, AbstractC3778r80.a(e), jNextLong, zD);
            s0(aVar9);
            return aVar9;
        } catch (TimeoutException e2) {
            e = e2;
            zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
            zzie zzieVar11 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
            a aVar10 = b.k;
            h0(zzieVar11, 2, aVar10, AbstractC3778r80.a(e), jNextLong, zD);
            s0(aVar10);
            return aVar10;
        } catch (Exception e3) {
            zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e3);
            zzie zzieVar12 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
            a aVar11 = b.j;
            h0(zzieVar12, 2, aVar11, AbstractC3778r80.a(e3), jNextLong, zD);
            s0(aVar11);
            return aVar11;
        }
    }

    public final S80 b0(int i, a aVar, zzie zzieVar, String str, Exception exc) {
        f0(zzieVar, 9, aVar, AbstractC3778r80.a(exc));
        zzc.zzo("BillingClient", str, exc);
        return new S80(aVar, null);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0183  */
    /* JADX WARN: Code duplicated, block: B:66:0x019d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:82:0x021b A[LOOP:0: B:94:0x004e->B:82:0x021b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0213 A[SYNTHETIC] */
    public final S80 c0(String str, boolean z, int i) {
        zzam zzamVar;
        int i2;
        Bundle bundleZzi;
        a aVarA;
        zzie zzieVar;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<String> stringArrayList3;
        int i3;
        boolean z2;
        Purchase purchase;
        char c = 0;
        zzc.zzm("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z3 = this.p;
        boolean z4 = this.w;
        boolean zA = this.D.a();
        boolean zB = this.D.b();
        long jLongValue = this.I.longValue();
        Bundle bundle = new Bundle();
        zzc.zzc(bundle, this.c, this.d, jLongValue);
        int i4 = 1;
        if (z3 && zA) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z4 && zB) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        String string = null;
        while (true) {
            try {
                synchronized (this.a) {
                    zzamVar = this.i;
                }
                if (zzamVar == null) {
                    return b0(9, b.j, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (this.p) {
                    if (this.C) {
                        i2 = 26;
                    } else if (this.B) {
                        i2 = 24;
                    } else {
                        i2 = this.w ? 19 : 9;
                    }
                    bundleZzi = zzamVar.zzi(i2, this.g.getPackageName(), str, string, bundle);
                } else {
                    bundleZzi = zzamVar.zzh(3, this.g.getPackageName(), str, string);
                }
                a aVar = b.h;
                if (bundleZzi == null) {
                    Object[] objArr = new Object[i4];
                    objArr[c] = "getPurchase()";
                    zzc.zzn("BillingClient", String.format("%s got null owned items list", objArr));
                    zzieVar = zzie.NULL_OWNED_ITEMS_LIST;
                } else {
                    int iZzb = zzc.zzb(bundleZzi, "BillingClient");
                    String strZzj = zzc.zzj(bundleZzi, "BillingClient");
                    a.C0167a c0167aD = a.d();
                    c0167aD.d(iZzb);
                    c0167aD.b(strZzj);
                    aVarA = c0167aD.a();
                    if (iZzb != 0) {
                        Integer numValueOf = Integer.valueOf(iZzb);
                        Object[] objArr2 = new Object[2];
                        objArr2[c] = "getPurchase()";
                        objArr2[i4] = numValueOf;
                        zzc.zzn("BillingClient", String.format("%s failed. Response code: %s", objArr2));
                        zzieVar = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (bundleZzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzi.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList4 = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList5 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList6 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList4 == null) {
                            Object[] objArr3 = new Object[i4];
                            objArr3[c] = "getPurchase()";
                            zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", objArr3));
                            zzieVar = zzie.NULL_SKUS_LIST;
                        } else if (stringArrayList5 == null) {
                            Object[] objArr4 = new Object[i4];
                            objArr4[c] = "getPurchase()";
                            zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null purchases list.", objArr4));
                            zzieVar = zzie.NULL_PURCHASES_LIST;
                        } else if (stringArrayList6 == null) {
                            Object[] objArr5 = new Object[i4];
                            objArr5[c] = "getPurchase()";
                            zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null signatures list.", objArr5));
                            zzieVar = zzie.NULL_SIGNATURES_LIST;
                        } else {
                            aVarA = b.i;
                            zzieVar = zzie.REASON_UNSPECIFIED;
                        }
                    } else {
                        Object[] objArr6 = new Object[i4];
                        objArr6[c] = "getPurchase()";
                        zzc.zzn("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", objArr6));
                        zzieVar = zzie.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (aVarA != b.i) {
                        return b0(9, aVarA, zzieVar, "Purchase bundle invalid", null);
                    }
                    stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    z2 = false;
                    for (i3 = 0; i3 < stringArrayList2.size(); i3++) {
                        String str2 = stringArrayList2.get(i3);
                        String str3 = stringArrayList3.get(i3);
                        zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i3))));
                        try {
                            purchase = new Purchase(str2, str3);
                            if (TextUtils.isEmpty(purchase.c())) {
                                zzc.zzn("BillingClient", "BUG: empty/null token!");
                                z2 = true;
                            }
                            arrayList.add(purchase);
                        } catch (JSONException e) {
                            return b0(9, b.h, zzie.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    if (z2) {
                        d0(zzie.EMPTY_PURCHASE_TOKEN, 9, aVar);
                    }
                    string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                    zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                    if (TextUtils.isEmpty(string)) {
                        return new S80(b.i, arrayList);
                    }
                    c = 0;
                    i4 = 1;
                }
                aVarA = aVar;
                if (aVarA != b.i) {
                    return b0(9, aVarA, zzieVar, "Purchase bundle invalid", null);
                }
                stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                z2 = false;
                while (i3 < stringArrayList2.size()) {
                    String str4 = stringArrayList2.get(i3);
                    String str5 = stringArrayList3.get(i3);
                    zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i3))));
                    purchase = new Purchase(str4, str5);
                    if (TextUtils.isEmpty(purchase.c())) {
                        zzc.zzn("BillingClient", "BUG: empty/null token!");
                        z2 = true;
                    }
                    arrayList.add(purchase);
                }
                if (z2) {
                    d0(zzie.EMPTY_PURCHASE_TOKEN, 9, aVar);
                }
                string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new S80(b.i, arrayList);
                }
                c = 0;
                i4 = 1;
            } catch (DeadObjectException e2) {
                return b0(9, b.j, zzie.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return b0(9, b.h, zzie.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e3);
            }
        }
    }

    @Override // defpackage.K7
    public void d(final YI yi, final InterfaceC2267gI interfaceC2267gI) {
        if (i(new Callable() { // from class: W40
            @Override // java.util.concurrent.Callable
            public final Object call() {
                M7.x0(this.a, interfaceC2267gI, yi);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: i50
            @Override // java.lang.Runnable
            public final void run() {
                M7.l(this.a, interfaceC2267gI);
            }
        }, S(), h()) == null) {
            a aVarV = V();
            d0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, aVarV);
            interfaceC2267gI.a(aVarV, new ZI(zzbt.zzk(), zzbt.zzk()));
        }
    }

    public final void d0(zzie zzieVar, int i, a aVar) {
        try {
            int i2 = AbstractC3778r80.a;
            u(AbstractC3778r80.b(zzieVar, i, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    @Override // defpackage.K7
    public final void e(C1218aJ c1218aJ, final EI ei) {
        if (i(new J50(this, ei, c1218aJ.b(), false), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: w50
            @Override // java.lang.Runnable
            public final void run() {
                M7.j(this.a, ei);
            }
        }, S(), h()) == null) {
            a aVarV = V();
            d0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, aVarV);
            ei.a(aVarV, zzbt.zzk());
        }
    }

    public final void e0(zzie zzieVar, int i, a aVar, long j) {
        try {
            int i2 = AbstractC3778r80.a;
            try {
                this.h.j(AbstractC3778r80.b(zzieVar, 2, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.m, j);
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    @Override // defpackage.K7
    public void f(N7 n7) {
        z(n7, 0);
    }

    public final void f0(zzie zzieVar, int i, a aVar, String str) {
        try {
            int i2 = AbstractC3778r80.a;
            u(AbstractC3778r80.b(zzieVar, i, aVar, str, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void g(Context context, FI fi, C4111vG c4111vG, InterfaceC2170f60 interfaceC2170f60, String str, InterfaceC3940t80 interfaceC3940t80, K7.a aVar) {
        this.g = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(str);
        String str2 = this.d;
        if (str2 != null) {
            zziqVarZzc.zzt(str2);
        }
        zziqVarZzc.zzq(this.g.getPackageName());
        zziqVarZzc.zzn(this.I.longValue());
        zziqVarZzc.zzr(aVar.f);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (interfaceC3940t80 != null) {
            this.h = interfaceC3940t80;
        } else {
            this.h = new C4183w80(this.g, (zzis) zziqVarZzc.zze());
        }
        if (fi == null) {
            zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f = new Th0(this.g, fi, null, interfaceC2170f60, null, this.h);
        this.D = c4111vG;
        this.F = interfaceC2170f60 != null;
        this.g.getPackageName();
        this.E = aVar.f;
    }

    public final void g0(zzie zzieVar, int i, a aVar, long j, boolean z) {
        try {
            int i2 = AbstractC3778r80.a;
            v(AbstractC3778r80.b(zzieVar, 2, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final synchronized ExecutorService h() {
        try {
            if (this.H == null) {
                this.H = Executors.newFixedThreadPool(zzc.zza, new D50(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.H;
    }

    public final void h0(zzie zzieVar, int i, a aVar, String str, long j, boolean z) {
        try {
            int i2 = AbstractC3778r80.a;
            v(AbstractC3778r80.b(zzieVar, 2, aVar, str, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final C2254g70 m0(YI yi) {
        zzam zzamVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strC = yi.c();
        zzbt zzbtVarB = yi.b();
        int size = zzbtVarB.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<YI.b> arrayList3 = new ArrayList(zzbtVarB.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((YI.b) arrayList3.get(i3)).b());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.c;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.a) {
                    zzamVar = this.i;
                }
                if (zzamVar == null) {
                    return T(b.j, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z = this.w && this.D.b();
                Y(yi);
                Y(yi);
                Y(yi);
                Y(yi);
                Bundle bundleZzj = zzamVar.zzj(true != this.x ? 17 : 20, this.g.getPackageName(), strC, bundle, zzc.zzf(str, this.d, arrayList3, null, null, zza.zza(z, true, false, true, false, true), this.I.longValue()));
                if (bundleZzj == null) {
                    return T(b.B, zzie.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = zzc.zzb(bundleZzj, "BillingClient");
                    String strZzj = zzc.zzj(bundleZzj, "BillingClient");
                    if (iZzb == 0) {
                        return T(b.a(6, strZzj), zzie.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return T(b.a(iZzb, strZzj), zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return T(b.B, zzie.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    try {
                        C2185fI c2185fI = new C2185fI(stringArrayList.get(i4));
                        zzc.zzm("BillingClient", "Got product details: ".concat(c2185fI.toString()));
                        arrayList5.add(c2185fI);
                    } catch (JSONException e) {
                        return T(b.a(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (YI.b bVar : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new BW(new JSONObject().put("productId", bVar.b()).put("type", bVar.c()).put("statusCode", 0).toString()));
                                    break;
                                }
                                C2185fI c2185fI2 = (C2185fI) it.next();
                                if (bVar.b().equals(c2185fI2.c()) && bVar.c().equals(c2185fI2.d())) {
                                    break;
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            BW bw = new BW(it2.next());
                            zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(bw.toString()));
                            arrayList6.add(bw);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i = i2;
                } catch (JSONException e2) {
                    return T(b.a(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                }
            } catch (DeadObjectException e3) {
                return T(b.j, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return T(b.h, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new C2254g70(0, "", arrayList, arrayList2);
    }

    public final InterfaceC3940t80 p0() {
        return this.h;
    }

    public final a s0(final a aVar) {
        if (Thread.interrupted()) {
            return aVar;
        }
        this.e.post(new Runnable() { // from class: h40
            @Override // java.lang.Runnable
            public final void run() {
                M7.m(this.a, aVar);
            }
        });
        return aVar;
    }

    public final void t(W1 w1, a aVar, zzie zzieVar, Exception exc) {
        zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        f0(zzieVar, 3, aVar, AbstractC3778r80.a(exc));
        w1.a(aVar);
    }

    public final void u(zzhx zzhxVar) {
        try {
            this.h.k(zzhxVar, this.m);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void v(zzhx zzhxVar, long j, boolean z) {
        try {
            this.h.a(zzhxVar, this.m, j, z);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void w(zzib zzibVar) {
        try {
            this.h.d(zzibVar, this.m);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void x(zzie zzieVar, a aVar, int i) {
        try {
            int i2 = AbstractC3778r80.a;
            zzhv zzhvVar = (zzhv) AbstractC3778r80.b(zzieVar, 6, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzm();
            zzjt zzjtVarZzc = zzjv.zzc();
            zzjtVarZzc.zza(i > 0);
            zzjtVarZzc.zzl(i);
            zzhvVar.zzo(zzjtVarZzc);
            u((zzhx) zzhvVar.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void y(int i) {
        synchronized (this.a) {
            try {
                if (this.b == 3) {
                    return;
                }
                zzc.zzm("BillingClient", "Setting clientState from " + E(this.b) + " to " + E(i));
                this.b = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(N7 n7, int i) {
        zzie zzieVar;
        a aVarU;
        a aVar;
        synchronized (this.a) {
            try {
                if (D()) {
                    aVarU = U(i);
                } else {
                    if (this.b == 1) {
                        zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                        zzie zzieVar2 = zzie.BILLING_CLIENT_CONNECTING;
                        aVar = b.d;
                        x(zzieVar2, aVar, i);
                    } else if (this.b == 3) {
                        zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        zzie zzieVar3 = zzie.BILLING_CLIENT_CLOSED;
                        aVar = b.j;
                        x(zzieVar3, aVar, i);
                    } else {
                        y(1);
                        if (i == 0) {
                            this.G = n7;
                            i = 0;
                        }
                        A();
                        zzc.zzm("BillingClient", "Starting in-app billing setup.");
                        this.j = new C60(this, n7, i, null);
                        this.j.c();
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.g.getPackageManager().queryIntentServices(intent, 0);
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                    zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.c);
                                    synchronized (this.a) {
                                        try {
                                            if (this.b == 2) {
                                                aVarU = U(i);
                                            } else if (this.b != 1) {
                                                zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                zzie zzieVar4 = zzie.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                                aVar = b.j;
                                                x(zzieVar4, aVar, i);
                                            } else {
                                                C60 c60 = this.j;
                                                if ((i <= 0 || Build.VERSION.SDK_INT < 29) ? this.g.bindService(intent2, c60, 1) : this.g.bindService(intent2, 1, h(), c60)) {
                                                    zzc.zzm("BillingClient", "Service was bonded successfully.");
                                                    aVarU = null;
                                                } else {
                                                    zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                                                    zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                                }
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            }
                        }
                        y(0);
                        zzc.zzm("BillingClient", "Billing service unavailable on device.");
                        a aVar2 = b.b;
                        x(zzieVar, aVar2, i);
                        aVarU = aVar2;
                    }
                    aVarU = aVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (aVarU != null) {
            n7.a(aVarU);
        }
    }

    public M7(String str, C4111vG c4111vG, Context context, C80 c80, InterfaceC3940t80 interfaceC3940t80, ExecutorService executorService, K7.a aVar) {
        this.a = new Object();
        this.b = 0;
        this.e = new Handler(Looper.getMainLooper());
        this.m = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.I = lValueOf;
        this.J = zzaz.zza();
        this.c = "8.0.0";
        String strZ = Z();
        this.d = strZ;
        this.g = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs("8.0.0");
        if (strZ != null) {
            zziqVarZzc.zzt(strZ);
        }
        zziqVarZzc.zzq(this.g.getPackageName());
        zziqVarZzc.zzn(lValueOf.longValue());
        zziqVarZzc.zzr(aVar.f);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.h = new C4183w80(this.g, (zzis) zziqVarZzc.zze());
        zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f = new Th0(this.g, null, null, null, null, this.h);
        this.D = c4111vG;
        this.g.getPackageName();
        this.E = aVar.f;
    }

    public M7(String str, C4111vG c4111vG, Context context, FI fi, InterfaceC2170f60 interfaceC2170f60, InterfaceC3940t80 interfaceC3940t80, ExecutorService executorService, K7.a aVar) {
        this.a = new Object();
        this.b = 0;
        this.e = new Handler(Looper.getMainLooper());
        this.m = 0;
        this.I = Long.valueOf(new Random().nextLong());
        this.J = zzaz.zza();
        this.c = "8.0.0";
        this.d = Z();
        g(context, fi, c4111vG, null, "8.0.0", null, aVar);
    }
}
