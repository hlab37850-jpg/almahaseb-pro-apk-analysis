package defpackage;

import android.content.Context;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowInfoTrackerDecorator;

/* JADX INFO: renamed from: pY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC3644pY {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.Companion;
    }

    public static WindowInfoTracker a(Context context) {
        return WindowInfoTracker.Companion.getOrCreate(context);
    }

    public static void b(WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    public static void c() {
        WindowInfoTracker.Companion.reset();
    }
}
