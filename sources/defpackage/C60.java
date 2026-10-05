package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.android.billingclient.api.a;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zzal;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class C60 implements ServiceConnection {
    public final N7 a;
    public final zzbi b;
    public final zzbi c;
    public final int d;
    public final /* synthetic */ M7 e;

    public /* synthetic */ C60(M7 m7, N7 n7, int i, AbstractC3123j70 abstractC3123j70) {
        Objects.requireNonNull(m7);
        this.e = m7;
        this.b = zzbi.zzc(m7.J);
        this.c = zzbi.zzc(m7.J);
        this.a = n7;
        this.d = i;
    }

    public static /* synthetic */ Object a(C60 c60) {
        Bundle bundle;
        zzam zzamVar;
        zzie zzieVar;
        M7 m7 = c60.e;
        synchronized (m7.a) {
            try {
                if (m7.b != 3) {
                    boolean z = m7.b == 1;
                    if (TextUtils.isEmpty(null)) {
                        bundle = null;
                    } else {
                        bundle = new Bundle();
                        bundle.putString("accountName", null);
                        zzc.zzc(bundle, m7.c, m7.d, m7.I.longValue());
                    }
                    zzie zzieVar2 = zzie.REASON_UNSPECIFIED;
                    synchronized (m7.a) {
                        zzamVar = m7.i;
                    }
                    if (zzamVar == null) {
                        M7 m8 = c60.e;
                        m8.y(0);
                        int i = c60.d;
                        zzie zzieVar3 = zzie.SERVICE_RESET_TO_NULL;
                        a aVar = b.j;
                        m8.x(zzieVar3, aVar, i);
                        c60.g(aVar);
                    } else {
                        M7 m9 = c60.e;
                        String packageName = m9.g.getPackageName();
                        int i2 = 25;
                        int iZzw = 3;
                        while (true) {
                            if (i2 < 3) {
                                i2 = 0;
                                break;
                            }
                            if (bundle == null) {
                                try {
                                    iZzw = zzamVar.zzw(i2, packageName, "subs");
                                } catch (Exception e) {
                                    zzc.zzo("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                    if (e instanceof DeadObjectException) {
                                        zzieVar = zzie.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION;
                                    } else if (e instanceof RemoteException) {
                                        zzieVar = zzie.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION;
                                    } else {
                                        zzieVar = e instanceof SecurityException ? zzie.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzie.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
                                    }
                                    String strA = zzieVar.equals(zzie.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? AbstractC3778r80.a(e) : null;
                                    c60.e.y(0);
                                    c60.f(M7.r0(e), zzieVar, strA, z);
                                    c60.g(M7.r0(e));
                                }
                            } else {
                                iZzw = zzamVar.zzc(i2, packageName, "subs", bundle);
                            }
                            if (iZzw == 0) {
                                zzc.zzm("BillingClient", "highestLevelSupportedForSubs: " + i2);
                                break;
                            }
                            i2--;
                        }
                        m9.l = i2 >= 5;
                        m9.k = i2 >= 3;
                        if (i2 < 3) {
                            zzieVar2 = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
                            zzc.zzm("BillingClient", "In-app billing API does not support subscription on this device.");
                        }
                        for (int i3 = 25; i3 >= 3; i3--) {
                            iZzw = bundle == null ? zzamVar.zzw(i3, packageName, "inapp") : zzamVar.zzc(i3, packageName, "inapp", bundle);
                            if (iZzw == 0) {
                                m9.m = i3;
                                zzc.zzm("BillingClient", "mHighestLevelSupportedForInApp: " + m9.m);
                                break;
                            }
                        }
                        M7.H(m9, m9.m);
                        if (m9.m < 3) {
                            zzieVar2 = zzie.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                            zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
                        }
                        M7.J(m9, iZzw);
                        if (iZzw != 0) {
                            a aVar2 = b.b;
                            c60.f(aVar2, zzieVar2, null, z);
                            c60.g(aVar2);
                        } else {
                            try {
                                Long lE = c60.e(z);
                                if (z) {
                                    zzhz zzhzVarZzc = zzib.zzc();
                                    zzhzVarZzc.zzo(6);
                                    zzjt zzjtVarZzc = zzjv.zzc();
                                    int i4 = c60.d;
                                    zzjtVarZzc.zza(i4 > 0);
                                    zzjtVarZzc.zzl(i4);
                                    if (lE != null) {
                                        zzjtVarZzc.zzm(lE.longValue());
                                    }
                                    M7 m10 = c60.e;
                                    zzhzVarZzc.zzn(zzjtVarZzc);
                                    m10.w((zzib) zzhzVarZzc.zze());
                                } else {
                                    zzjm zzjmVarZzc = zzjo.zzc();
                                    zzic zzicVarZzc = zzig.zzc();
                                    zzicVarZzc.zzo(0);
                                    zzjmVarZzc.zza(zzicVarZzc);
                                    if (lE != null) {
                                        zzjmVarZzc.zzl(lE.longValue());
                                    }
                                    c60.e.h.e((zzjo) zzjmVarZzc.zze());
                                }
                            } catch (Throwable th) {
                                zzc.zzo("BillingClient", "Unable to log.", th);
                            }
                            c60.g(b.i);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return null;
    }

    public static /* synthetic */ void b(C60 c60) {
        M7 m7 = c60.e;
        m7.y(0);
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        a aVar = b.k;
        m7.x(zzieVar, aVar, c60.d);
        c60.g(aVar);
    }

    public final void c() {
        zzbi zzbiVar = this.b;
        zzbiVar.zzd();
        zzbiVar.zze();
    }

    public final boolean d() {
        return this.d > 0;
    }

    public final Long e(boolean z) {
        if (z) {
            zzbi zzbiVar = this.b;
            if (!zzbiVar.zzg()) {
                return null;
            }
            zzbiVar.zzf();
            return Long.valueOf(zzbiVar.zza(TimeUnit.MILLISECONDS));
        }
        zzbi zzbiVar2 = this.c;
        if (!zzbiVar2.zzg()) {
            return null;
        }
        zzbiVar2.zzf();
        return Long.valueOf(zzbiVar2.zza(TimeUnit.MILLISECONDS));
    }

    public final void f(a aVar, zzie zzieVar, String str, boolean z) {
        try {
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(aVar.c());
            zzicVarZzc.zzl(aVar.a());
            zzicVarZzc.zzn(zzieVar);
            if (str != null) {
                zzicVarZzc.zza(str);
            }
            Long lE = e(z);
            if (!z) {
                zzjm zzjmVarZzc = zzjo.zzc();
                zzjmVarZzc.zza(zzicVarZzc);
                if (lE != null) {
                    zzjmVarZzc.zzl(lE.longValue());
                }
                this.e.h.e((zzjo) zzjmVarZzc.zze());
                return;
            }
            zzjt zzjtVarZzc = zzjv.zzc();
            int i = this.d;
            zzjtVarZzc.zza(i > 0);
            zzjtVarZzc.zzl(i);
            if (lE != null) {
                zzjtVarZzc.zzm(lE.longValue());
            }
            M7 m7 = this.e;
            zzhv zzhvVarZzc = zzhx.zzc();
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(6);
            zzhvVarZzc.zzo(zzjtVarZzc);
            m7.u((zzhx) zzhvVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void g(a aVar) {
        M7 m7 = this.e;
        synchronized (m7.a) {
            try {
                if (m7.b == 3) {
                    return;
                }
                try {
                    this.a.a(aVar);
                } catch (Throwable th) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingSetupFinished.", th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        zzc.zzn("BillingClient", "Billing service died.");
        try {
            M7 m7 = this.e;
            if (M7.N(m7)) {
                InterfaceC3940t80 interfaceC3940t80 = m7.h;
                zzhv zzhvVarZzc = zzhx.zzc();
                zzhvVarZzc.zzp(6);
                zzic zzicVarZzc = zzig.zzc();
                zzicVarZzc.zzn(zzie.BINDING_DIED);
                zzhvVarZzc.zzl(zzicVarZzc);
                zzjt zzjtVarZzc = zzjv.zzc();
                int i = this.d;
                zzjtVarZzc.zza(i > 0);
                zzjtVarZzc.zzl(i);
                zzhvVarZzc.zzo(zzjtVarZzc);
                interfaceC3940t80.b((zzhx) zzhvVarZzc.zze());
            } else {
                m7.h.c(zzij.zzd());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        M7 m8 = this.e;
        synchronized (m8.a) {
            if (m8.b != 3 && m8.b != 0) {
                m8.y(0);
                m8.A();
                try {
                    this.a.b();
                } catch (Throwable th2) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzc.zzm("BillingClient", "Billing service connected.");
        M7 m7 = this.e;
        synchronized (m7.a) {
            try {
                if (m7.b == 3) {
                    return;
                }
                m7.i = zzal.zzs(iBinder);
                if (M7.i(new Callable() { // from class: w60
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        C60.a(this.a);
                        return null;
                    }
                }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: z60
                    @Override // java.lang.Runnable
                    public final void run() {
                        C60.b(this.a);
                    }
                }, m7.S(), m7.h()) == null) {
                    int i = this.d;
                    a aVarV = m7.V();
                    m7.x(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, aVarV, i);
                    g(aVarV);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzc.zzn("BillingClient", "Billing service disconnected.");
        try {
            M7 m7 = this.e;
            if (M7.N(m7)) {
                InterfaceC3940t80 interfaceC3940t80 = m7.h;
                zzhv zzhvVarZzc = zzhx.zzc();
                zzhvVarZzc.zzp(6);
                zzic zzicVarZzc = zzig.zzc();
                zzicVarZzc.zzn(zzie.SERVICE_DISCONNECTED);
                zzhvVarZzc.zzl(zzicVarZzc);
                zzjt zzjtVarZzc = zzjv.zzc();
                int i = this.d;
                zzjtVarZzc.zza(i > 0);
                zzjtVarZzc.zzl(i);
                zzhvVarZzc.zzo(zzjtVarZzc);
                interfaceC3940t80.b((zzhx) zzhvVarZzc.zze());
            } else {
                m7.h.i(zzjs.zzd());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        zzbi zzbiVar = this.c;
        zzbiVar.zzd();
        zzbiVar.zze();
        M7 m8 = this.e;
        synchronized (m8.a) {
            try {
                if (m8.b == 3) {
                    return;
                }
                m8.y(0);
                try {
                    this.a.b();
                } catch (Throwable th2) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
