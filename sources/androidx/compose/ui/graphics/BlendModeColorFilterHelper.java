package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC3124j8;
import defpackage.AbstractC3206k8;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class BlendModeColorFilterHelper {
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final BlendModeColorFilter m2984BlendModeColorFilterxETnrds(long j, int i) {
        AbstractC3206k8.a();
        return AbstractC3124j8.a(ColorKt.m3086toArgb8_81llA(j), AndroidBlendMode_androidKt.m2890toAndroidBlendModes9anfk8(i));
    }
}
