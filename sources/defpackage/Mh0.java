package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.android.billingclient.api.a;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Mh0 extends BroadcastReceiver {
    public boolean a;
    public final boolean b;
    public final /* synthetic */ Th0 c;

    public Mh0(Th0 th0, boolean z) {
        Objects.requireNonNull(th0);
        this.c = th0;
        this.b = z;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, IntentFilter intentFilter, String str) {
        try {
            if (this.a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(Bundle bundle, a aVar, int i, zzil zzilVar, long j, boolean z) {
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                this.c.c.g(zzhx.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzeu.zza()), j, z);
            } else {
                this.c.c.g(AbstractC3778r80.b(zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i, aVar, null, zzilVar), j, z);
            }
        } catch (Throwable unused) {
            zzc.zzn("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        byte b;
        zzil zzilVar;
        int i;
        a aVarZzh;
        int iIntValue;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1484087650) {
            if (iHashCode != -337612916) {
                if (iHashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            zzilVar = zzil.PURCHASES_UPDATED_ACTION;
        } else if (b != 1) {
            zzilVar = b != 2 ? zzil.BROADCAST_ACTION_UNSPECIFIED : zzil.ALTERNATIVE_BILLING_ACTION;
        } else {
            zzilVar = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
        }
        zzil zzilVar2 = zzilVar;
        zzil zzilVar3 = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
        if (zzilVar2.equals(zzilVar3) || zzilVar2.equals(zzil.ALTERNATIVE_BILLING_ACTION)) {
            i = 2;
        } else {
            i = zzilVar2.equals(zzil.PURCHASES_UPDATED_ACTION) ? 32 : 1;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            zzc.zzn("BillingBroadcastManager", "Bundle is null.");
            Th0 th0 = this.c;
            InterfaceC3940t80 interfaceC3940t80 = th0.c;
            zzie zzieVar = zzie.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            a aVar = b.h;
            interfaceC3940t80.b(AbstractC3778r80.b(zzieVar, i, aVar, null, zzilVar2));
            if (th0.b != null) {
                th0.b.a(aVar, null);
                return;
            }
            return;
        }
        if (i == 2) {
            int i2 = zzc.zza;
            a.C0167a c0167aD = a.d();
            c0167aD.d(zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                zzc.zzn("BillingBroadcastManager", "Unexpected null bundle received!");
            } else {
                Object obj = extras2.get("SUB_RESPONSE_CODE");
                if (obj == null) {
                    zzc.zzm("BillingBroadcastManager", "getLaunchBillingFlowSubResponseCodeFromBundle() got null response code, assuming OK");
                } else {
                    if (obj instanceof Integer) {
                        iIntValue = ((Integer) obj).intValue();
                    } else {
                        zzc.zzn("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(obj.getClass().getName()));
                    }
                    c0167aD.c(iIntValue);
                    c0167aD.b(zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                    aVarZzh = c0167aD.a();
                }
            }
            iIntValue = 0;
            c0167aD.c(iIntValue);
            c0167aD.b(zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
            aVarZzh = c0167aD.a();
        } else {
            aVarZzh = zzc.zzh(intent, "BillingBroadcastManager");
        }
        long j = extras.getLong("billingClientTransactionId", 0L);
        boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
        if (zzilVar2.equals(zzil.PURCHASES_UPDATED_ACTION) || zzilVar2.equals(zzilVar3)) {
            List listZzl = zzc.zzl(extras);
            if (aVarZzh.c() == 0) {
                this.c.c.f(AbstractC3778r80.c(i, zzilVar2), j, z);
            } else {
                c(extras, aVarZzh, i, zzilVar2, j, z);
            }
            this.c.b.a(aVarZzh, listZzl);
            return;
        }
        if (zzilVar2.equals(zzil.ALTERNATIVE_BILLING_ACTION)) {
            if (aVarZzh.c() != 0) {
                c(extras, aVarZzh, i, zzilVar2, j, z);
                this.c.b.a(aVarZzh, zzbt.zzk());
                return;
            }
            Th0 th1 = this.c;
            Th0.a(th1);
            Th0.e(th1);
            zzc.zzn("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            Th0 th2 = this.c;
            InterfaceC3940t80 interfaceC3940t81 = th2.c;
            zzie zzieVar2 = zzie.MISSING_USER_CHOICE_BILLING_LISTENER;
            a aVar2 = b.h;
            interfaceC3940t81.g(AbstractC3778r80.b(zzieVar2, i, aVar2, null, zzilVar2), j, z);
            th2.b.a(aVar2, zzbt.zzk());
        }
    }
}
