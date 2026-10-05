package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float fM5160constructorimpl = Dp.m5160constructorimpl(16);
        ButtonHorizontalPadding = fM5160constructorimpl;
        float f = 8;
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(f);
        ButtonVerticalPadding = fM5160constructorimpl2;
        PaddingValues paddingValuesM481PaddingValuesa9UjIt4 = PaddingKt.m481PaddingValuesa9UjIt4(fM5160constructorimpl, fM5160constructorimpl2, fM5160constructorimpl, fM5160constructorimpl2);
        ContentPadding = paddingValuesM481PaddingValuesa9UjIt4;
        MinWidth = Dp.m5160constructorimpl(64);
        MinHeight = Dp.m5160constructorimpl(36);
        IconSize = Dp.m5160constructorimpl(18);
        IconSpacing = Dp.m5160constructorimpl(f);
        OutlinedBorderSize = Dp.m5160constructorimpl(1);
        float fM5160constructorimpl3 = Dp.m5160constructorimpl(f);
        TextButtonHorizontalPadding = fM5160constructorimpl3;
        TextButtonContentPadding = PaddingKt.m481PaddingValuesa9UjIt4(fM5160constructorimpl3, paddingValuesM481PaddingValuesa9UjIt4.mo438calculateTopPaddingD9Ej5fM(), fM5160constructorimpl3, paddingValuesM481PaddingValuesa9UjIt4.mo435calculateBottomPaddingD9Ej5fM());
    }

    private ButtonDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1015buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM3077compositeOverOWjLjI;
        composer.startReplaceableGroup(1870371134);
        long jM1051getPrimary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j;
        long jM1069contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM3077compositeOverOWjLjI = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(materialTheme.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI = j3;
        }
        long jM3031copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:405)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM1051getPrimary0d7_KjU, jM1069contentColorForek8zF_U, jM3077compositeOverOWjLjI, jM3031copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    /* JADX INFO: renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1016elevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-737170518);
        float fM5160constructorimpl = (i2 & 1) != 0 ? Dp.m5160constructorimpl(2) : f;
        float fM5160constructorimpl2 = (i2 & 2) != 0 ? Dp.m5160constructorimpl(8) : f2;
        float fM5160constructorimpl3 = (i2 & 4) != 0 ? Dp.m5160constructorimpl(0) : f3;
        float fM5160constructorimpl4 = (i2 & 8) != 0 ? Dp.m5160constructorimpl(4) : f4;
        float fM5160constructorimpl5 = (i2 & 16) != 0 ? Dp.m5160constructorimpl(4) : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:371)");
        }
        Object[] objArr = {Dp.m5158boximpl(fM5160constructorimpl), Dp.m5158boximpl(fM5160constructorimpl2), Dp.m5158boximpl(fM5160constructorimpl3), Dp.m5158boximpl(fM5160constructorimpl4), Dp.m5158boximpl(fM5160constructorimpl5)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 5; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultButtonElevation(fM5160constructorimpl, fM5160constructorimpl2, fM5160constructorimpl3, fM5160constructorimpl4, fM5160constructorimpl5, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultButtonElevation defaultButtonElevation = (DefaultButtonElevation) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonElevation;
    }

    @Composable
    /* JADX INFO: renamed from: elevation-yajeYGU, reason: not valid java name */
    public final /* synthetic */ ButtonElevation m1017elevationyajeYGU(float f, float f2, float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1428576874);
        float fM5160constructorimpl = (i2 & 1) != 0 ? Dp.m5160constructorimpl(2) : f;
        float fM5160constructorimpl2 = (i2 & 2) != 0 ? Dp.m5160constructorimpl(8) : f2;
        float fM5160constructorimpl3 = (i2 & 4) != 0 ? Dp.m5160constructorimpl(0) : f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428576874, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:345)");
        }
        float f4 = 4;
        ButtonElevation buttonElevationM1016elevationR_JCAzs = m1016elevationR_JCAzs(fM5160constructorimpl, fM5160constructorimpl2, fM5160constructorimpl3, Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4), composer, (i & 14) | 27648 | (i & 112) | (i & 896) | ((i << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevationM1016elevationR_JCAzs;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1018getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m1019getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1020getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1021getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-2091313033);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2091313033, i, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:476)");
        }
        BorderStroke borderStrokeM194BorderStrokecXLIe8U = BorderStrokeKt.m194BorderStrokecXLIe8U(OutlinedBorderSize, Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStrokeM194BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1022getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Composable
    /* JADX INFO: renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m1023outlinedButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2124406093);
        long jM1055getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU() : j;
        long jM1051getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j2;
        long jM3031copywmQWz5c$default = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, i, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:428)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM1055getSurface0d7_KjU, jM1051getPrimary0d7_KjU, jM1055getSurface0d7_KjU, jM3031copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    /* JADX INFO: renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m1024textButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(182742216);
        long jM3067getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j;
        long jM1051getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j2;
        long jM3031copywmQWz5c$default = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:449)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM3067getTransparent0d7_KjU, jM1051getPrimary0d7_KjU, jM3067getTransparent0d7_KjU, jM3031copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
