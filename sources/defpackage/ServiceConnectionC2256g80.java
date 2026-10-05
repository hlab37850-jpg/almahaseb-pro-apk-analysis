package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzat;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.Objects;

/* JADX INFO: renamed from: g80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class ServiceConnectionC2256g80 implements ServiceConnection {
    public final /* synthetic */ C3453n80 a;

    public /* synthetic */ ServiceConnectionC2256g80(C3453n80 c3453n80, AbstractC3207k80 abstractC3207k80) {
        Objects.requireNonNull(c3453n80);
        this.a = c3453n80;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzc.zzm("BillingClientTesting", "Billing Override Service connected.");
        C3453n80 c3453n80 = this.a;
        c3453n80.M = zzat.zzc(iBinder);
        c3453n80.L = 2;
        c3453n80.H0(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzc.zzn("BillingClientTesting", "Billing Override Service disconnected.");
        C3453n80 c3453n80 = this.a;
        c3453n80.M = null;
        c3453n80.L = 0;
    }
}
