package androidx.compose.material3;

import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AssistChipDefaults {
    public static final int $stable = 0;
    private static final float Height;
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float IconSize;

    static {
        AssistChipTokens assistChipTokens = AssistChipTokens.INSTANCE;
        Height = assistChipTokens.m2071getContainerHeightD9Ej5fM();
        IconSize = assistChipTokens.m2080getIconSizeD9Ej5fM();
    }

    private AssistChipDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: assistChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m1337assistChipBorderd_3_b6Q(long j, long j2, float f, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(382372847);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM3031copywmQWz5c$default = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM2079getFlatOutlineWidthD9Ej5fM = (i2 & 4) != 0 ? AssistChipTokens.INSTANCE.m2079getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:703)");
        }
        ChipBorder chipBorder = new ChipBorder(color, jM3031copywmQWz5c$default, fM2079getFlatOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    @Composable
    /* JADX INFO: renamed from: assistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m1338assistChipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-391745725);
        long jM3067getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j;
        long color = (i2 & 2) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer, 6) : j3;
        long j9 = (i2 & 8) != 0 ? color2 : j4;
        long jM3067getTransparent0d7_KjU2 = (i2 & 16) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j5;
        long jM3031copywmQWz5c$default = (i2 & 32) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM3031copywmQWz5c$default2 = (i2 & 64) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long j10 = (i2 & 128) != 0 ? jM3031copywmQWz5c$default2 : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:643)");
        }
        ChipColors chipColors = new ChipColors(jM3067getTransparent0d7_KjU, color, color2, j9, jM3067getTransparent0d7_KjU2, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, j10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    /* JADX INFO: renamed from: assistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m1339assistChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(245366099);
        float fM2078getFlatContainerElevationD9Ej5fM = (i2 & 1) != 0 ? AssistChipTokens.INSTANCE.m2078getFlatContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? fM2078getFlatContainerElevationD9Ej5fM : f2;
        float f8 = (i2 & 4) != 0 ? fM2078getFlatContainerElevationD9Ej5fM : f3;
        float f9 = (i2 & 8) != 0 ? fM2078getFlatContainerElevationD9Ej5fM : f4;
        float fM2072getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m2072getDraggedContainerElevationD9Ej5fM() : f5;
        float f10 = (i2 & 32) != 0 ? fM2078getFlatContainerElevationD9Ej5fM : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:679)");
        }
        ChipElevation chipElevation = new ChipElevation(fM2078getFlatContainerElevationD9Ej5fM, f7, f8, f9, fM2072getDraggedContainerElevationD9Ej5fM, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    @Composable
    /* JADX INFO: renamed from: elevatedAssistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m1340elevatedAssistChipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-535762675);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long color3 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer, 6) : j3;
        long j9 = (i2 & 8) != 0 ? color3 : j4;
        long jM3031copywmQWz5c$default = (i2 & 16) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM3031copywmQWz5c$default2 = (i2 & 32) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM3031copywmQWz5c$default3 = (i2 & 64) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long j10 = (i2 & 128) != 0 ? jM3031copywmQWz5c$default3 : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:728)");
        }
        ChipColors chipColors = new ChipColors(color, color2, color3, j9, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default3, j10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    /* JADX INFO: renamed from: elevatedAssistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m1341elevatedAssistChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1457698077);
        float fM2073getElevatedContainerElevationD9Ej5fM = (i2 & 1) != 0 ? AssistChipTokens.INSTANCE.m2073getElevatedContainerElevationD9Ej5fM() : f;
        float fM2077getElevatedPressedContainerElevationD9Ej5fM = (i2 & 2) != 0 ? AssistChipTokens.INSTANCE.m2077getElevatedPressedContainerElevationD9Ej5fM() : f2;
        float fM2075getElevatedFocusContainerElevationD9Ej5fM = (i2 & 4) != 0 ? AssistChipTokens.INSTANCE.m2075getElevatedFocusContainerElevationD9Ej5fM() : f3;
        float fM2076getElevatedHoverContainerElevationD9Ej5fM = (i2 & 8) != 0 ? AssistChipTokens.INSTANCE.m2076getElevatedHoverContainerElevationD9Ej5fM() : f4;
        float fM2072getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m2072getDraggedContainerElevationD9Ej5fM() : f5;
        float fM2074getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? AssistChipTokens.INSTANCE.m2074getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:765)");
        }
        ChipElevation chipElevation = new ChipElevation(fM2073getElevatedContainerElevationD9Ej5fM, fM2077getElevatedPressedContainerElevationD9Ej5fM, fM2075getElevatedFocusContainerElevationD9Ej5fM, fM2076getElevatedHoverContainerElevationD9Ej5fM, fM2072getDraggedContainerElevationD9Ej5fM, fM2074getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m1342getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1343getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(1988153916);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, i, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:782)");
        }
        Shape shape = ShapesKt.toShape(AssistChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
