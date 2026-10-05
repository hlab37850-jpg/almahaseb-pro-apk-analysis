package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialThemeKt {
    private static final RippleAlpha DefaultRippleAlpha = new RippleAlpha(0.16f, 0.12f, 0.08f, 0.12f);
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    /* JADX INFO: renamed from: androidx.compose.material3.MaterialThemeKt$MaterialTheme$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Typography $typography;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Typography typography, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$typography = typography;
            this.$content = interfaceC0526Fp;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1066563262, i, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
            }
            TextKt.ProvideTextStyle(this.$typography.getBodyLarge(), this.$content, composer, (this.$$dirty >> 6) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.MaterialThemeKt$MaterialTheme$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ ColorScheme $colorScheme;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Shapes $shapes;
        final /* synthetic */ Typography $typography;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ColorScheme colorScheme, Shapes shapes, Typography typography, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$colorScheme = colorScheme;
            this.$shapes = shapes;
            this.$typography = typography;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            MaterialThemeKt.MaterialTheme(this.$colorScheme, this.$shapes, this.$typography, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        ColorScheme colorScheme2;
        int i3;
        Shapes shapes2;
        Typography typography2;
        Typography typography3;
        Shapes shapes3;
        ColorScheme colorScheme3;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-2127166334);
        if ((i & 14) == 0) {
            if ((i2 & 1) == 0) {
                colorScheme2 = colorScheme;
                int i4 = composerStartRestartGroup.changed(colorScheme2) ? 4 : 2;
                i3 = i4 | i;
            } else {
                colorScheme2 = colorScheme;
            }
            i3 = i4 | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shapes2 = shapes;
                int i5 = composerStartRestartGroup.changed(shapes2) ? 32 : 16;
                i3 |= i5;
            } else {
                shapes2 = shapes;
            }
            i3 |= i5;
        } else {
            shapes2 = shapes;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                typography2 = typography;
                int i6 = composerStartRestartGroup.changed(typography2) ? 256 : 128;
                i3 |= i6;
            } else {
                typography2 = typography;
            }
            i3 |= i6;
        } else {
            typography2 = typography;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            colorScheme3 = colorScheme2;
            shapes3 = shapes2;
            typography3 = typography2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            ColorScheme colorScheme4 = colorScheme2;
            Shapes shapes4 = shapes2;
            Typography typography4 = typography2;
            int i7 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2127166334, i7, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:57)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = colorScheme4.m1388copyG1PFcw((536870911 & 1) != 0 ? colorScheme4.m1408getPrimary0d7_KjU() : 0L, (536870911 & 2) != 0 ? colorScheme4.m1398getOnPrimary0d7_KjU() : 0L, (536870911 & 4) != 0 ? colorScheme4.m1409getPrimaryContainer0d7_KjU() : 0L, (536870911 & 8) != 0 ? colorScheme4.m1399getOnPrimaryContainer0d7_KjU() : 0L, (536870911 & 16) != 0 ? colorScheme4.m1393getInversePrimary0d7_KjU() : 0L, (536870911 & 32) != 0 ? colorScheme4.m1411getSecondary0d7_KjU() : 0L, (536870911 & 64) != 0 ? colorScheme4.m1400getOnSecondary0d7_KjU() : 0L, (536870911 & 128) != 0 ? colorScheme4.m1412getSecondaryContainer0d7_KjU() : 0L, (536870911 & 256) != 0 ? colorScheme4.m1401getOnSecondaryContainer0d7_KjU() : 0L, (536870911 & 512) != 0 ? colorScheme4.m1416getTertiary0d7_KjU() : 0L, (536870911 & 1024) != 0 ? colorScheme4.m1404getOnTertiary0d7_KjU() : 0L, (536870911 & 2048) != 0 ? colorScheme4.m1417getTertiaryContainer0d7_KjU() : 0L, (536870911 & 4096) != 0 ? colorScheme4.m1405getOnTertiaryContainer0d7_KjU() : 0L, (536870911 & 8192) != 0 ? colorScheme4.m1389getBackground0d7_KjU() : 0L, (536870911 & 16384) != 0 ? colorScheme4.m1395getOnBackground0d7_KjU() : 0L, (536870911 & 32768) != 0 ? colorScheme4.m1413getSurface0d7_KjU() : 0L, (536870911 & 65536) != 0 ? colorScheme4.m1402getOnSurface0d7_KjU() : 0L, (536870911 & 131072) != 0 ? colorScheme4.m1415getSurfaceVariant0d7_KjU() : 0L, (536870911 & 262144) != 0 ? colorScheme4.m1403getOnSurfaceVariant0d7_KjU() : 0L, (536870911 & 524288) != 0 ? colorScheme4.m1414getSurfaceTint0d7_KjU() : 0L, (536870911 & 1048576) != 0 ? colorScheme4.m1394getInverseSurface0d7_KjU() : 0L, (536870911 & 2097152) != 0 ? colorScheme4.m1392getInverseOnSurface0d7_KjU() : 0L, (536870911 & 4194304) != 0 ? colorScheme4.m1390getError0d7_KjU() : 0L, (536870911 & 8388608) != 0 ? colorScheme4.m1396getOnError0d7_KjU() : 0L, (536870911 & 16777216) != 0 ? colorScheme4.m1391getErrorContainer0d7_KjU() : 0L, (536870911 & 33554432) != 0 ? colorScheme4.m1397getOnErrorContainer0d7_KjU() : 0L, (536870911 & 67108864) != 0 ? colorScheme4.m1406getOutline0d7_KjU() : 0L, (536870911 & 134217728) != 0 ? colorScheme4.m1407getOutlineVariant0d7_KjU() : 0L, (536870911 & 268435456) != 0 ? colorScheme4.m1410getScrim0d7_KjU() : 0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ColorScheme colorScheme5 = (ColorScheme) objRememberedValue;
            ColorSchemeKt.updateColorSchemeFrom(colorScheme5, colorScheme4);
            typography3 = typography4;
            shapes3 = shapes4;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme5), IndicationKt.getLocalIndication().provides(RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes3), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme5, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography3)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1066563262, true, new AnonymousClass1(typography3, interfaceC0526Fp, i7)), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorScheme3 = colorScheme4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(colorScheme3, shapes3, typography3, interfaceC0526Fp, i, i2));
    }

    @Composable
    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        AbstractC4492zt.h(colorScheme, "colorScheme");
        composer.startReplaceableGroup(1866455512);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:132)");
        }
        long jM1408getPrimary0d7_KjU = colorScheme.m1408getPrimary0d7_KjU();
        Color colorM3022boximpl = Color.m3022boximpl(jM1408getPrimary0d7_KjU);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorM3022boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TextSelectionColors(jM1408getPrimary0d7_KjU, Color.m3031copywmQWz5c$default(jM1408getPrimary0d7_KjU, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
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
