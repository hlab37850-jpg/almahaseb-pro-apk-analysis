package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;
import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(Duration duration) {
        AbstractC4492zt.h(duration, "timeout");
        return duration.toMillis();
    }
}
