package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m1145binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        float f = 0.2f;
        float f2 = 0.4f;
        float f3 = 0.4f;
        for (int i = 0; i < 7; i++) {
            float fM1147calculateContrastRationb2GgbA = (m1147calculateContrastRationb2GgbA(j, f2, j2, j3) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= fM1147calculateContrastRationb2GgbA && fM1147calculateContrastRationb2GgbA <= 0.01f) {
                break;
            }
            if (fM1147calculateContrastRationb2GgbA < 0.0f) {
                f3 = f2;
            } else {
                f = f2;
            }
            f2 = (f3 + f) / 2.0f;
        }
        return f2;
    }

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m1146calculateContrastRatioOWjLjI(long j, long j2) {
        float fM3084luminance8_81llA = ColorKt.m3084luminance8_81llA(j) + 0.05f;
        float fM3084luminance8_81llA2 = ColorKt.m3084luminance8_81llA(j2) + 0.05f;
        return Math.max(fM3084luminance8_81llA, fM3084luminance8_81llA2) / Math.min(fM3084luminance8_81llA, fM3084luminance8_81llA2);
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m1147calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long jM3077compositeOverOWjLjI = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m1146calculateContrastRatioOWjLjI(ColorKt.m3077compositeOverOWjLjI(j2, jM3077compositeOverOWjLjI), jM3077compositeOverOWjLjI);
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m1148calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        float fM1145binarySearchForAccessibleSelectionColorAlphaysEtTa8;
        float fM1147calculateContrastRationb2GgbA = m1147calculateContrastRationb2GgbA(j, 0.4f, j2, j3);
        float fM1147calculateContrastRationb2GgbA2 = m1147calculateContrastRationb2GgbA(j, 0.2f, j2, j3);
        if (fM1147calculateContrastRationb2GgbA >= DesiredContrastRatio) {
            fM1145binarySearchForAccessibleSelectionColorAlphaysEtTa8 = 0.4f;
        } else {
            fM1145binarySearchForAccessibleSelectionColorAlphaysEtTa8 = fM1147calculateContrastRationb2GgbA2 < DesiredContrastRatio ? 0.2f : m1145binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3);
        }
        return Color.m3031copywmQWz5c$default(j, fM1145binarySearchForAccessibleSelectionColorAlphaysEtTa8, 0.0f, 0.0f, 0.0f, 14, null);
    }

    @Composable
    public static final TextSelectionColors rememberTextSelectionColors(Colors colors, Composer composer, int i) {
        AbstractC4492zt.h(colors, "colors");
        composer.startReplaceableGroup(-721696685);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long jM1051getPrimary0d7_KjU = colors.m1051getPrimary0d7_KjU();
        long jM1044getBackground0d7_KjU = colors.m1044getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        long jM1068contentColorFor4WTKRHQ = ColorsKt.m1068contentColorFor4WTKRHQ(colors, jM1044getBackground0d7_KjU);
        if (jM1068contentColorFor4WTKRHQ == Color.Companion.m3068getUnspecified0d7_KjU()) {
            jM1068contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
        }
        long j = jM1068contentColorFor4WTKRHQ;
        composer.endReplaceableGroup();
        long jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color colorM3022boximpl = Color.m3022boximpl(jM1051getPrimary0d7_KjU);
        Color colorM3022boximpl2 = Color.m3022boximpl(jM1044getBackground0d7_KjU);
        Color colorM3022boximpl3 = Color.m3022boximpl(jM3031copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(colorM3022boximpl) | composer.changed(colorM3022boximpl2) | composer.changed(colorM3022boximpl3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TextSelectionColors(colors.m1051getPrimary0d7_KjU(), m1148calculateSelectionBackgroundColorysEtTa8(jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, jM1044getBackground0d7_KjU), null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors = (TextSelectionColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors;
    }
}
