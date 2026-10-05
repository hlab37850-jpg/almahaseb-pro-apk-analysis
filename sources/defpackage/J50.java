package defpackage;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.android.billingclient.api.a;
import com.android.billingclient.api.b;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzie;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class J50 implements Callable {
    public final /* synthetic */ EI a;
    public final /* synthetic */ String b;
    public final /* synthetic */ M7 c;

    public J50(M7 m7, EI ei, String str, boolean z) {
        this.a = ei;
        this.b = str;
        Objects.requireNonNull(m7);
        this.c = m7;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        M7 m7 = this.c;
        if (!m7.C(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            a aVar = b.j;
            m7.d0(zzieVar, 9, aVar);
            this.a.a(aVar, zzbt.zzk());
            return null;
        }
        String str = this.b;
        if (TextUtils.isEmpty(str)) {
            zzc.zzn("BillingClient", "Please provide a valid product type.");
            zzie zzieVar2 = zzie.EMPTY_PRODUCT_TYPE;
            a aVar2 = b.e;
            m7.d0(zzieVar2, 9, aVar2);
            this.a.a(aVar2, zzbt.zzk());
            return null;
        }
        S80 s80C0 = m7.c0(str, false, 9);
        if (s80C0.b() != null) {
            this.a.a(s80C0.a(), s80C0.b());
            return null;
        }
        this.a.a(s80C0.a(), zzbt.zzk());
        return null;
    }
}
