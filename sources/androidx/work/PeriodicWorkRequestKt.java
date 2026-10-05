package androidx.work;

import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit) {
        AbstractC4492zt.h(timeUnit, "repeatIntervalTimeUnit");
        AbstractC4492zt.m(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, timeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        AbstractC4492zt.h(duration, "repeatInterval");
        AbstractC4492zt.m(4, "W");
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, duration);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        AbstractC4492zt.h(timeUnit, "repeatIntervalTimeUnit");
        AbstractC4492zt.h(timeUnit2, "flexTimeIntervalUnit");
        AbstractC4492zt.m(4, "W");
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, j, timeUnit, j2, timeUnit2);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        AbstractC4492zt.h(duration, "repeatInterval");
        AbstractC4492zt.h(duration2, "flexTimeInterval");
        AbstractC4492zt.m(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, duration, duration2);
    }
}
