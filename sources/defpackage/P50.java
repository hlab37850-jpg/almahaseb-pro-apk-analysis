package defpackage;

import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.internal.play_billing.zzbl;

/* JADX INFO: loaded from: classes2.dex */
public final class P50 extends zzbl {
    @Override // com.google.android.gms.internal.play_billing.zzbl
    public final long zza() {
        return SystemClock.elapsedRealtime() * AnimationKt.MillisToNanos;
    }
}
