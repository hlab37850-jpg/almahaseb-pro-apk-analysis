package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import defpackage.AD;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(ColorSchemeKt$LocalColorScheme$1.INSTANCE);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: applyTonalElevation-Hht5A8o, reason: not valid java name */
    public static final long m1447applyTonalElevationHht5A8o(ColorScheme colorScheme, long j, float f) {
        AbstractC4492zt.h(colorScheme, "$this$applyTonalElevation");
        return Color.m3033equalsimpl0(j, colorScheme.m1413getSurface0d7_KjU()) ? m1454surfaceColorAtElevation3ABfNKs(colorScheme, f) : j;
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1448contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        AbstractC4492zt.h(colorScheme, "$this$contentColorFor");
        if (Color.m3033equalsimpl0(j, colorScheme.m1408getPrimary0d7_KjU())) {
            return colorScheme.m1398getOnPrimary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1411getSecondary0d7_KjU())) {
            return colorScheme.m1400getOnSecondary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1416getTertiary0d7_KjU())) {
            return colorScheme.m1404getOnTertiary0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1389getBackground0d7_KjU())) {
            return colorScheme.m1395getOnBackground0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1390getError0d7_KjU())) {
            return colorScheme.m1396getOnError0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1413getSurface0d7_KjU())) {
            return colorScheme.m1402getOnSurface0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1415getSurfaceVariant0d7_KjU())) {
            return colorScheme.m1403getOnSurfaceVariant0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1409getPrimaryContainer0d7_KjU())) {
            return colorScheme.m1399getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1412getSecondaryContainer0d7_KjU())) {
            return colorScheme.m1401getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1417getTertiaryContainer0d7_KjU())) {
            return colorScheme.m1405getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m3033equalsimpl0(j, colorScheme.m1391getErrorContainer0d7_KjU())) {
            return colorScheme.m1397getOnErrorContainer0d7_KjU();
        }
        return Color.m3033equalsimpl0(j, colorScheme.m1394getInverseSurface0d7_KjU()) ? colorScheme.m1392getInverseOnSurface0d7_KjU() : Color.Companion.m3068getUnspecified0d7_KjU();
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1449contentColorForek8zF_U(long j, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long jM1448contentColorFor4WTKRHQ = m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (jM1448contentColorFor4WTKRHQ == Color.Companion.m3068getUnspecified0d7_KjU()) {
            jM1448contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM1448contentColorFor4WTKRHQ;
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1450darkColorSchemeG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1451darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM2126getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2126getPrimary0d7_KjU() : j;
        return m1450darkColorSchemeG1PFcw(jM2126getPrimary0d7_KjU, (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2116getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2127getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2117getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2111getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2129getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2118getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2130getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2119getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2134getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2122getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2135getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2123getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2107getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2113getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2131getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2120getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2133getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2121getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? jM2126getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2112getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2110getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2108getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2114getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2109getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2115getOnErrorContainer0d7_KjU() : j26, (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m2124getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m2125getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m2128getScrim0d7_KjU() : j29);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        AbstractC4492zt.h(colorScheme, "<this>");
        AbstractC4492zt.h(colorSchemeKeyTokens, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m1389getBackground0d7_KjU();
            case 2:
                return colorScheme.m1390getError0d7_KjU();
            case 3:
                return colorScheme.m1391getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m1392getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m1393getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m1394getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m1395getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m1396getOnError0d7_KjU();
            case 9:
                return colorScheme.m1397getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m1398getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m1399getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m1400getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m1401getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m1402getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m1403getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m1414getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m1404getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m1405getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m1406getOutline0d7_KjU();
            case 20:
                return colorScheme.m1407getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m1408getPrimary0d7_KjU();
            case 22:
                return colorScheme.m1409getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m1410getScrim0d7_KjU();
            case 24:
                return colorScheme.m1411getSecondary0d7_KjU();
            case 25:
                return colorScheme.m1412getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m1413getSurface0d7_KjU();
            case 27:
                return colorScheme.m1415getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m1416getTertiary0d7_KjU();
            case 29:
                return colorScheme.m1417getTertiaryContainer0d7_KjU();
            default:
                throw new AD();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1452lightColorSchemeG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1453lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM2155getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2155getPrimary0d7_KjU() : j;
        return m1452lightColorSchemeG1PFcw(jM2155getPrimary0d7_KjU, (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2145getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2156getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2146getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2140getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2158getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2147getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2159getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2148getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2163getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2151getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2164getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2152getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2136getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2142getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2160getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2149getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2162getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2150getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? jM2155getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2141getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2139getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2137getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2143getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2138getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2144getOnErrorContainer0d7_KjU() : j26, (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m2153getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m2154getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m2157getScrim0d7_KjU() : j29);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m1454surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        AbstractC4492zt.h(colorScheme, "$this$surfaceColorAtElevation");
        if (Dp.m5165equalsimpl0(f, Dp.m5160constructorimpl(0))) {
            return colorScheme.m1413getSurface0d7_KjU();
        }
        return ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(colorScheme.m1414getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m1413getSurface0d7_KjU());
    }

    @Composable
    @ReadOnlyComposable
    public static final long toColor(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        AbstractC4492zt.h(colorSchemeKeyTokens, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, i, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jFromToken;
    }

    public static final void updateColorSchemeFrom(ColorScheme colorScheme, ColorScheme colorScheme2) {
        AbstractC4492zt.h(colorScheme, "<this>");
        AbstractC4492zt.h(colorScheme2, "other");
        colorScheme.m1437setPrimary8_81llA$material3_release(colorScheme2.m1408getPrimary0d7_KjU());
        colorScheme.m1427setOnPrimary8_81llA$material3_release(colorScheme2.m1398getOnPrimary0d7_KjU());
        colorScheme.m1438setPrimaryContainer8_81llA$material3_release(colorScheme2.m1409getPrimaryContainer0d7_KjU());
        colorScheme.m1428setOnPrimaryContainer8_81llA$material3_release(colorScheme2.m1399getOnPrimaryContainer0d7_KjU());
        colorScheme.m1422setInversePrimary8_81llA$material3_release(colorScheme2.m1393getInversePrimary0d7_KjU());
        colorScheme.m1440setSecondary8_81llA$material3_release(colorScheme2.m1411getSecondary0d7_KjU());
        colorScheme.m1429setOnSecondary8_81llA$material3_release(colorScheme2.m1400getOnSecondary0d7_KjU());
        colorScheme.m1441setSecondaryContainer8_81llA$material3_release(colorScheme2.m1412getSecondaryContainer0d7_KjU());
        colorScheme.m1430setOnSecondaryContainer8_81llA$material3_release(colorScheme2.m1401getOnSecondaryContainer0d7_KjU());
        colorScheme.m1445setTertiary8_81llA$material3_release(colorScheme2.m1416getTertiary0d7_KjU());
        colorScheme.m1433setOnTertiary8_81llA$material3_release(colorScheme2.m1404getOnTertiary0d7_KjU());
        colorScheme.m1446setTertiaryContainer8_81llA$material3_release(colorScheme2.m1417getTertiaryContainer0d7_KjU());
        colorScheme.m1434setOnTertiaryContainer8_81llA$material3_release(colorScheme2.m1405getOnTertiaryContainer0d7_KjU());
        colorScheme.m1418setBackground8_81llA$material3_release(colorScheme2.m1389getBackground0d7_KjU());
        colorScheme.m1424setOnBackground8_81llA$material3_release(colorScheme2.m1395getOnBackground0d7_KjU());
        colorScheme.m1442setSurface8_81llA$material3_release(colorScheme2.m1413getSurface0d7_KjU());
        colorScheme.m1431setOnSurface8_81llA$material3_release(colorScheme2.m1402getOnSurface0d7_KjU());
        colorScheme.m1444setSurfaceVariant8_81llA$material3_release(colorScheme2.m1415getSurfaceVariant0d7_KjU());
        colorScheme.m1432setOnSurfaceVariant8_81llA$material3_release(colorScheme2.m1403getOnSurfaceVariant0d7_KjU());
        colorScheme.m1443setSurfaceTint8_81llA$material3_release(colorScheme2.m1414getSurfaceTint0d7_KjU());
        colorScheme.m1423setInverseSurface8_81llA$material3_release(colorScheme2.m1394getInverseSurface0d7_KjU());
        colorScheme.m1421setInverseOnSurface8_81llA$material3_release(colorScheme2.m1392getInverseOnSurface0d7_KjU());
        colorScheme.m1419setError8_81llA$material3_release(colorScheme2.m1390getError0d7_KjU());
        colorScheme.m1425setOnError8_81llA$material3_release(colorScheme2.m1396getOnError0d7_KjU());
        colorScheme.m1420setErrorContainer8_81llA$material3_release(colorScheme2.m1391getErrorContainer0d7_KjU());
        colorScheme.m1426setOnErrorContainer8_81llA$material3_release(colorScheme2.m1397getOnErrorContainer0d7_KjU());
        colorScheme.m1435setOutline8_81llA$material3_release(colorScheme2.m1406getOutline0d7_KjU());
        colorScheme.m1436setOutlineVariant8_81llA$material3_release(colorScheme2.m1407getOutlineVariant0d7_KjU());
        colorScheme.m1439setScrim8_81llA$material3_release(colorScheme2.m1410getScrim0d7_KjU());
    }
}
