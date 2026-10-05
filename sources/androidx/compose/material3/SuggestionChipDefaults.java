package androidx.compose.material3;

import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SuggestionChipDefaults {
    public static final int $stable = 0;
    private static final float Height;
    public static final SuggestionChipDefaults INSTANCE = new SuggestionChipDefaults();
    private static final float IconSize;

    static {
        SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.INSTANCE;
        Height = suggestionChipTokens.m2516getContainerHeightD9Ej5fM();
        IconSize = suggestionChipTokens.m2525getLeadingIconSizeD9Ej5fM();
    }

    private SuggestionChipDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: elevatedSuggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1843elevatedSuggestionChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1269423125);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getElevatedContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM1403getOnSurfaceVariant0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1403getOnSurfaceVariant0d7_KjU() : j3;
        long jM3031copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM3031copywmQWz5c$default2 = (i2 & 16) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM3031copywmQWz5c$default3 = (i2 & 32) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1402getOnSurface0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1269423125, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1243)");
        }
        Color.Companion companion = Color.Companion;
        ChipColors chipColors = new ChipColors(color, color2, jM1403getOnSurfaceVariant0d7_KjU, companion.m3068getUnspecified0d7_KjU(), jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default3, companion.m3068getUnspecified0d7_KjU(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    /* JADX INFO: renamed from: elevatedSuggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m1844elevatedSuggestionChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1118088467);
        float fM2518getElevatedContainerElevationD9Ej5fM = (i2 & 1) != 0 ? SuggestionChipTokens.INSTANCE.m2518getElevatedContainerElevationD9Ej5fM() : f;
        float fM2522getElevatedPressedContainerElevationD9Ej5fM = (i2 & 2) != 0 ? SuggestionChipTokens.INSTANCE.m2522getElevatedPressedContainerElevationD9Ej5fM() : f2;
        float fM2520getElevatedFocusContainerElevationD9Ej5fM = (i2 & 4) != 0 ? SuggestionChipTokens.INSTANCE.m2520getElevatedFocusContainerElevationD9Ej5fM() : f3;
        float fM2521getElevatedHoverContainerElevationD9Ej5fM = (i2 & 8) != 0 ? SuggestionChipTokens.INSTANCE.m2521getElevatedHoverContainerElevationD9Ej5fM() : f4;
        float fM2517getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m2517getDraggedContainerElevationD9Ej5fM() : f5;
        float fM2519getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? SuggestionChipTokens.INSTANCE.m2519getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1118088467, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1280)");
        }
        ChipElevation chipElevation = new ChipElevation(fM2518getElevatedContainerElevationD9Ej5fM, fM2522getElevatedPressedContainerElevationD9Ej5fM, fM2520getElevatedFocusContainerElevationD9Ej5fM, fM2521getElevatedHoverContainerElevationD9Ej5fM, fM2517getDraggedContainerElevationD9Ej5fM, fM2519getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m1845getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1846getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(641188183);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(641188183, i, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1297)");
        }
        Shape shape = ShapesKt.toShape(SuggestionChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    /* JADX INFO: renamed from: suggestionChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m1847suggestionChipBorderd_3_b6Q(long j, long j2, float f, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(439283919);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM3031copywmQWz5c$default = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM2524getFlatOutlineWidthD9Ej5fM = (i2 & 4) != 0 ? SuggestionChipTokens.INSTANCE.m2524getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(439283919, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1220)");
        }
        ChipBorder chipBorder = new ChipBorder(color, jM3031copywmQWz5c$default, fM2524getFlatOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    @Composable
    /* JADX INFO: renamed from: suggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1848suggestionChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1882647883);
        long jM3067getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j;
        long color = (i2 & 2) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j3;
        long jM3067getTransparent0d7_KjU2 = (i2 & 8) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j4;
        long jM3031copywmQWz5c$default = (i2 & 16) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM3031copywmQWz5c$default2 = (i2 & 32) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1882647883, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1163)");
        }
        Color.Companion companion = Color.Companion;
        ChipColors chipColors = new ChipColors(jM3067getTransparent0d7_KjU, color, color2, companion.m3068getUnspecified0d7_KjU(), jM3067getTransparent0d7_KjU2, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, companion.m3068getUnspecified0d7_KjU(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    /* JADX INFO: renamed from: suggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m1849suggestionChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1929994057);
        float fM2523getFlatContainerElevationD9Ej5fM = (i2 & 1) != 0 ? SuggestionChipTokens.INSTANCE.m2523getFlatContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? fM2523getFlatContainerElevationD9Ej5fM : f2;
        float f8 = (i2 & 4) != 0 ? fM2523getFlatContainerElevationD9Ej5fM : f3;
        float f9 = (i2 & 8) != 0 ? fM2523getFlatContainerElevationD9Ej5fM : f4;
        float fM2517getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m2517getDraggedContainerElevationD9Ej5fM() : f5;
        float f10 = (i2 & 32) != 0 ? fM2523getFlatContainerElevationD9Ej5fM : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929994057, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1196)");
        }
        ChipElevation chipElevation = new ChipElevation(fM2523getFlatContainerElevationD9Ej5fM, f7, f8, f9, fM2517getDraggedContainerElevationD9Ej5fM, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }
}
