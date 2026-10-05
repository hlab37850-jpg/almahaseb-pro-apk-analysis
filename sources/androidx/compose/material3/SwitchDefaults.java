package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m5160constructorimpl(16);

    private SwitchDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m1871colorsV1nXRL4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(1937926421);
        long color = (i3 & 1) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6) : j;
        long color2 = (i3 & 2) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6) : j2;
        long jM3067getTransparent0d7_KjU = (i3 & 4) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j3;
        long color3 = (i3 & 8) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j4;
        long color4 = (i3 & 16) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6) : j5;
        long color5 = (i3 & 32) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6) : j6;
        long color6 = (i3 & 64) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6) : j7;
        long color7 = (i3 & 128) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j8;
        long jM3077compositeOverOWjLjI = (i3 & 256) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j9;
        long jM3077compositeOverOWjLjI2 = (i3 & 512) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j10;
        long jM3067getTransparent0d7_KjU2 = (i3 & 1024) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j11;
        long jM3077compositeOverOWjLjI3 = (i3 & 2048) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j12;
        long jM3077compositeOverOWjLjI4 = (i3 & 4096) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j13;
        long jM3077compositeOverOWjLjI5 = (i3 & 8192) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j14;
        long jM3077compositeOverOWjLjI6 = (i3 & 16384) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j15;
        long jM3077compositeOverOWjLjI7 = (i3 & 32768) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i, i2, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:283)");
        }
        SwitchColors switchColors = new SwitchColors(color, color2, jM3067getTransparent0d7_KjU, color3, color4, color5, color6, color7, jM3077compositeOverOWjLjI, jM3077compositeOverOWjLjI2, jM3067getTransparent0d7_KjU2, jM3077compositeOverOWjLjI3, jM3077compositeOverOWjLjI4, jM3077compositeOverOWjLjI5, jM3077compositeOverOWjLjI6, jM3077compositeOverOWjLjI7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return switchColors;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1872getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
