package androidx.work.impl.utils;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;
import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class DurationApi26Impl {
    @DoNotInline
    public static final long toMillisCompat(Duration duration) {
        AbstractC4492zt.h(duration, "<this>");
        return duration.toMillis();
    }
}
