package androidx.compose.ui.graphics;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidColorFilter_androidKt {
    /* JADX INFO: renamed from: actualColorMatrixColorFilter-jHG-Opc, reason: not valid java name */
    public static final ColorFilter m2904actualColorMatrixColorFilterjHGOpc(float[] fArr) {
        AbstractC4492zt.h(fArr, "colorMatrix");
        return new ColorFilter(new ColorMatrixColorFilter(fArr));
    }

    /* JADX INFO: renamed from: actualLightingColorFilter--OWjLjI, reason: not valid java name */
    public static final ColorFilter m2905actualLightingColorFilterOWjLjI(long j, long j2) {
        return new ColorFilter(new LightingColorFilter(ColorKt.m3086toArgb8_81llA(j), ColorKt.m3086toArgb8_81llA(j2)));
    }

    /* JADX INFO: renamed from: actualTintColorFilter-xETnrds, reason: not valid java name */
    public static final ColorFilter m2906actualTintColorFilterxETnrds(long j, int i) {
        return new ColorFilter(Build.VERSION.SDK_INT >= 29 ? BlendModeColorFilterHelper.INSTANCE.m2984BlendModeColorFilterxETnrds(j, i) : new PorterDuffColorFilter(ColorKt.m3086toArgb8_81llA(j), AndroidBlendMode_androidKt.m2891toPorterDuffModes9anfk8(i)));
    }

    public static final android.graphics.ColorFilter asAndroidColorFilter(ColorFilter colorFilter) {
        AbstractC4492zt.h(colorFilter, "<this>");
        return colorFilter.getNativeColorFilter$ui_graphics_release();
    }

    public static final ColorFilter asComposeColorFilter(android.graphics.ColorFilter colorFilter) {
        AbstractC4492zt.h(colorFilter, "<this>");
        return new ColorFilter(colorFilter);
    }
}
