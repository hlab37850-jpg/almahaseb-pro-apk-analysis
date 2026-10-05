package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class BatteryNotLowTrackerKt {
    public static final float BATTERY_LOW_THRESHOLD = 0.15f;
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("BatteryNotLowTracker");
        AbstractC4492zt.g(strTagWithPrefix, "tagWithPrefix(\"BatteryNotLowTracker\")");
        TAG = strTagWithPrefix;
    }
}
