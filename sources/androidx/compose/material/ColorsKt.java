package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(ColorsKt$LocalColors$1.INSTANCE);

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1068contentColorFor4WTKRHQ(Colors colors, long j) {
        AbstractC4492zt.h(colors, "$this$contentColorFor");
        if (Color.m3033equalsimpl0(j, colors.m1051getPrimary0d7_KjU())) {
            return colors.m1048getOnPrimary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colors.m1052getPrimaryVariant0d7_KjU())) {
            return colors.m1048getOnPrimary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colors.m1053getSecondary0d7_KjU())) {
            return colors.m1049getOnSecondary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colors.m1054getSecondaryVariant0d7_KjU())) {
            return colors.m1049getOnSecondary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colors.m1044getBackground0d7_KjU())) {
            return colors.m1046getOnBackground0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colors.m1055getSurface0d7_KjU())) {
            return colors.m1050getOnSurface0d7_KjU();
        }
        return Color.m3033equalsimpl0(j, colors.m1045getError0d7_KjU()) ? colors.m1047getOnError0d7_KjU() : Color.Companion.m3068getUnspecified0d7_KjU();
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1069contentColorForek8zF_U(long j, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:295)");
        }
        long jM1068contentColorFor4WTKRHQ = m1068contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (jM1068contentColorFor4WTKRHQ == Color.Companion.m3068getUnspecified0d7_KjU()) {
            jM1068contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM1068contentColorFor4WTKRHQ;
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m1070darkColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, false, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m1071darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        return m1070darkColors2qZNXz8(jColor, jColor2, jColor3, (i & 8) != 0 ? jColor3 : j4, (i & 16) != 0 ? ColorKt.Color(4279374354L) : j5, (i & 32) != 0 ? ColorKt.Color(4279374354L) : j6, (i & 64) != 0 ? ColorKt.Color(4291782265L) : j7, (i & 128) != 0 ? Color.Companion.m3058getBlack0d7_KjU() : j8, (i & 256) != 0 ? Color.Companion.m3058getBlack0d7_KjU() : j9, (i & 512) != 0 ? Color.Companion.m3069getWhite0d7_KjU() : j10, (i & 1024) != 0 ? Color.Companion.m3069getWhite0d7_KjU() : j11, (i & 2048) != 0 ? Color.Companion.m3058getBlack0d7_KjU() : j12);
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    public static final long getPrimarySurface(Colors colors) {
        AbstractC4492zt.h(colors, "<this>");
        return colors.isLight() ? colors.m1051getPrimary0d7_KjU() : colors.m1055getSurface0d7_KjU();
    }

    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m1072lightColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, null);
    }

    public static final void updateColorsFrom(Colors colors, Colors colors2) {
        AbstractC4492zt.h(colors, "<this>");
        AbstractC4492zt.h(colors2, "other");
        colors.m1063setPrimary8_81llA$material_release(colors2.m1051getPrimary0d7_KjU());
        colors.m1064setPrimaryVariant8_81llA$material_release(colors2.m1052getPrimaryVariant0d7_KjU());
        colors.m1065setSecondary8_81llA$material_release(colors2.m1053getSecondary0d7_KjU());
        colors.m1066setSecondaryVariant8_81llA$material_release(colors2.m1054getSecondaryVariant0d7_KjU());
        colors.m1056setBackground8_81llA$material_release(colors2.m1044getBackground0d7_KjU());
        colors.m1067setSurface8_81llA$material_release(colors2.m1055getSurface0d7_KjU());
        colors.m1057setError8_81llA$material_release(colors2.m1045getError0d7_KjU());
        colors.m1060setOnPrimary8_81llA$material_release(colors2.m1048getOnPrimary0d7_KjU());
        colors.m1061setOnSecondary8_81llA$material_release(colors2.m1049getOnSecondary0d7_KjU());
        colors.m1058setOnBackground8_81llA$material_release(colors2.m1046getOnBackground0d7_KjU());
        colors.m1062setOnSurface8_81llA$material_release(colors2.m1050getOnSurface0d7_KjU());
        colors.m1059setOnError8_81llA$material_release(colors2.m1047getOnError0d7_KjU());
        colors.setLight$material_release(colors2.isLight());
    }
}
