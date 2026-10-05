package androidx.window.layout;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class ActivityCompatHelperApi24 {
    public static final ActivityCompatHelperApi24 INSTANCE = new ActivityCompatHelperApi24();

    private ActivityCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(Activity activity) {
        AbstractC4492zt.h(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}
