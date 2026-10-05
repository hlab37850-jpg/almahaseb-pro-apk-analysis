package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.ActivityOptionsCompat;
import defpackage.FW;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ActivityResultLauncherHolder<I> {
    public static final int $stable = 8;
    private ActivityResultLauncher<I> launcher;

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
        FW fw;
        ActivityResultLauncher<I> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(i, activityOptionsCompat);
            fw = FW.a;
        } else {
            fw = null;
        }
        if (fw == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
    }

    public final void setLauncher(ActivityResultLauncher<I> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public final void unregister() {
        FW fw;
        ActivityResultLauncher<I> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            fw = FW.a;
        } else {
            fw = null;
        }
        if (fw == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
    }
}
