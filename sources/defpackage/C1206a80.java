package defpackage;

import androidx.core.util.Consumer;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcs;
import com.google.android.gms.internal.play_billing.zzie;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: a80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1206a80 implements zzcs {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ C3453n80 c;
    public final /* synthetic */ int d;

    public C1206a80(C3453n80 c3453n80, int i, Consumer consumer, Runnable runnable) {
        this.d = i;
        this.a = consumer;
        this.b = runnable;
        Objects.requireNonNull(c3453n80);
        this.c = c3453n80;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    public final void zza(Throwable th) {
        if (th instanceof TimeoutException) {
            this.c.G0(zzie.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, b.F);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            this.c.G0(zzie.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, b.F);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.b.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        C3453n80 c3453n80 = this.c;
        if (!C3453n80.D0(iIntValue)) {
            this.b.run();
        } else {
            this.a.accept(c3453n80.E0(this.d, num.intValue()));
        }
    }
}
