package defpackage;

import com.android.billingclient.api.a;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzp;
import java.util.Objects;

/* JADX INFO: renamed from: r60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3774r60 implements N7 {
    public final /* synthetic */ zzp a;
    public final /* synthetic */ M7 b;

    public C3774r60(M7 m7, zzp zzpVar) {
        this.a = zzpVar;
        Objects.requireNonNull(m7);
        this.b = m7;
    }

    @Override // defpackage.N7
    public final void a(final a aVar) {
        zzc.zzm("BillingClient", "Reconnection finished with result: " + aVar.c());
        try {
            this.a.zzb(aVar);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        M7 m7 = this.b;
        if (m7.G != null) {
            m7.L(new Runnable() { // from class: m60
                @Override // java.lang.Runnable
                public final void run() {
                    C3774r60 c3774r60 = this.a;
                    try {
                        c3774r60.b.G.a(aVar);
                    } catch (Throwable th2) {
                        zzc.zzo("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }

    @Override // defpackage.N7
    public final void b() {
        zzc.zzm("BillingClient", "Reconnection attempt failed.");
        try {
            this.a.zzb(b.j);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        M7 m7 = this.b;
        if (m7.G != null) {
            m7.L(new Runnable() { // from class: i60
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.a.b.G.b();
                    } catch (Throwable th2) {
                        zzc.zzo("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }
}
