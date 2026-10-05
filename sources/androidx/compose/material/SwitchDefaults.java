package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m1239colorsSQMK_m0(long j, long j2, float f, long j3, long j4, float f2, long j5, long j6, long j7, long j8, Composer composer, int i, int i2, int i3) {
        long jM3077compositeOverOWjLjI;
        long jM3077compositeOverOWjLjI2;
        int i4;
        long jM3077compositeOverOWjLjI3;
        long jM3077compositeOverOWjLjI4;
        composer.startReplaceableGroup(-1032127534);
        long jM1054getSecondaryVariant0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1054getSecondaryVariant0d7_KjU() : j;
        long j9 = (i3 & 2) != 0 ? jM1054getSecondaryVariant0d7_KjU : j2;
        float f3 = (i3 & 4) != 0 ? 0.54f : f;
        long jM1055getSurface0d7_KjU = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU() : j3;
        long jM1050getOnSurface0d7_KjU = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU() : j4;
        float f4 = (i3 & 32) != 0 ? 0.38f : f2;
        if ((i3 & 64) != 0) {
            jM3077compositeOverOWjLjI = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(jM1054getSecondaryVariant0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI = j5;
        }
        if ((i3 & 128) != 0) {
            jM3077compositeOverOWjLjI2 = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(j9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI2 = j6;
        }
        if ((i3 & 256) != 0) {
            i4 = 6;
            jM3077compositeOverOWjLjI3 = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(jM1055getSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            i4 = 6;
            jM3077compositeOverOWjLjI3 = j7;
        }
        if ((i3 & 512) != 0) {
            jM3077compositeOverOWjLjI4 = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(jM1050getOnSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, i4), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI4 = j8;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1032127534, i, i2, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:320)");
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(jM1054getSecondaryVariant0d7_KjU, Color.m3031copywmQWz5c$default(j9, f3, 0.0f, 0.0f, 0.0f, 14, null), jM1055getSurface0d7_KjU, Color.m3031copywmQWz5c$default(jM1050getOnSurface0d7_KjU, f4, 0.0f, 0.0f, 0.0f, 14, null), jM3077compositeOverOWjLjI, Color.m3031copywmQWz5c$default(jM3077compositeOverOWjLjI2, f3, 0.0f, 0.0f, 0.0f, 14, null), jM3077compositeOverOWjLjI3, Color.m3031copywmQWz5c$default(jM3077compositeOverOWjLjI4, f4, 0.0f, 0.0f, 0.0f, 14, null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
