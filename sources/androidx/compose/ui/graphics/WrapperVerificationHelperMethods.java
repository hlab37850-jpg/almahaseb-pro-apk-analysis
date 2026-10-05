package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class WrapperVerificationHelperMethods {
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    private WrapperVerificationHelperMethods() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: setBlendMode-GB0RdKg, reason: not valid java name */
    public final void m3406setBlendModeGB0RdKg(android.graphics.Paint paint, int i) {
        AbstractC4492zt.h(paint, "paint");
        paint.setBlendMode(AndroidBlendMode_androidKt.m2890toAndroidBlendModes9anfk8(i));
    }
}
