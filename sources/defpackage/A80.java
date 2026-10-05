package defpackage;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzji;

/* JADX INFO: loaded from: classes2.dex */
public final class A80 {
    public boolean a;
    public Transport b;

    public A80(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.b = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zzji.class, Encoding.of("proto"), new Transformer() { // from class: y80
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((zzji) obj).zzM();
                }
            });
        } catch (Throwable unused) {
            this.a = true;
        }
    }

    public final void a(zzji zzjiVar) {
        if (this.a) {
            zzc.zzn("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.b.send(Event.ofData(zzjiVar));
        } catch (Throwable unused) {
            zzc.zzn("BillingLogger", "logging failed.");
        }
    }
}
