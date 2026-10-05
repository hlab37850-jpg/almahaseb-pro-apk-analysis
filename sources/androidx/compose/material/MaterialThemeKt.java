package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
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
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialThemeKt {

    /* JADX INFO: renamed from: androidx.compose.material.MaterialThemeKt$MaterialTheme$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Typography $typography;

        /* JADX INFO: renamed from: androidx.compose.material.MaterialThemeKt$MaterialTheme$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00791 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ InterfaceC0526Fp $content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00791(InterfaceC0526Fp interfaceC0526Fp, int i) {
                super(2);
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
                    ComposerKt.traceEventStart(181426554, i, -1, "androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)");
                }
                MaterialTheme_androidKt.PlatformMaterialTheme(this.$content, composer, (this.$$dirty >> 9) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

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
                ComposerKt.traceEventStart(-1740102967, i, -1, "androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
            }
            TextKt.ProvideTextStyle(this.$typography.getBody1(), ComposableLambdaKt.composableLambda(composer, 181426554, true, new C00791(this.$content, this.$$dirty)), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.MaterialThemeKt$MaterialTheme$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Colors $colors;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Shapes $shapes;
        final /* synthetic */ Typography $typography;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Colors colors, Typography typography, Shapes shapes, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$colors = colors;
            this.$typography = typography;
            this.$shapes = shapes;
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
            MaterialThemeKt.MaterialTheme(this.$colors, this.$typography, this.$shapes, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void MaterialTheme(Colors colors, Typography typography, Shapes shapes, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        Colors colors2;
        int i3;
        Typography typography2;
        Shapes shapes2;
        Shapes shapes3;
        Typography typography3;
        Colors colors3;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-891417079);
        if ((i & 14) == 0) {
            if ((i2 & 1) == 0) {
                colors2 = colors;
                int i4 = composerStartRestartGroup.changed(colors2) ? 4 : 2;
                i3 = i4 | i;
            } else {
                colors2 = colors;
            }
            i3 = i4 | i;
        } else {
            colors2 = colors;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                typography2 = typography;
                int i5 = composerStartRestartGroup.changed(typography2) ? 32 : 16;
                i3 |= i5;
            } else {
                typography2 = typography;
            }
            i3 |= i5;
        } else {
            typography2 = typography;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                int i6 = composerStartRestartGroup.changed(shapes2) ? 256 : 128;
                i3 |= i6;
            } else {
                shapes2 = shapes;
            }
            i3 |= i6;
        } else {
            shapes2 = shapes;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            colors3 = colors2;
            typography3 = typography2;
            shapes3 = shapes2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
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
            Colors colors4 = colors2;
            Typography typography4 = typography2;
            Shapes shapes4 = shapes2;
            int i7 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891417079, i7, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:58)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = colors4.m1043copypvPzIIM((8191 & 1) != 0 ? colors4.m1051getPrimary0d7_KjU() : 0L, (8191 & 2) != 0 ? colors4.m1052getPrimaryVariant0d7_KjU() : 0L, (8191 & 4) != 0 ? colors4.m1053getSecondary0d7_KjU() : 0L, (8191 & 8) != 0 ? colors4.m1054getSecondaryVariant0d7_KjU() : 0L, (8191 & 16) != 0 ? colors4.m1044getBackground0d7_KjU() : 0L, (8191 & 32) != 0 ? colors4.m1055getSurface0d7_KjU() : 0L, (8191 & 64) != 0 ? colors4.m1045getError0d7_KjU() : 0L, (8191 & 128) != 0 ? colors4.m1048getOnPrimary0d7_KjU() : 0L, (8191 & 256) != 0 ? colors4.m1049getOnSecondary0d7_KjU() : 0L, (8191 & 512) != 0 ? colors4.m1046getOnBackground0d7_KjU() : 0L, (8191 & 1024) != 0 ? colors4.m1050getOnSurface0d7_KjU() : 0L, (8191 & 2048) != 0 ? colors4.m1047getOnError0d7_KjU() : 0L, (8191 & 4096) != 0 ? colors4.isLight() : false);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Colors colors5 = (Colors) objRememberedValue;
            ColorsKt.updateColorsFrom(colors5, colors4);
            shapes3 = shapes4;
            typography3 = typography4;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(colors5), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes3), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(colors5, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography3)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1740102967, true, new AnonymousClass1(typography3, interfaceC0526Fp, i7)), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(colors3, typography3, shapes3, interfaceC0526Fp, i, i2));
    }
}
