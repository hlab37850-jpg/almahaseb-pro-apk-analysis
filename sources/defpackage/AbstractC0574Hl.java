package defpackage;

import androidx.compose.animation.core.AnimationKt;
import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: Hl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0574Hl {
    public static final YS a = new YS("REMOVED_TASK");
    public static final YS b = new YS("CLOSED_EMPTY");

    public static final long c(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : AnimationKt.MillisToNanos * j;
    }
}
