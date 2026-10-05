package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class CardKt {

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$Card$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$content = interfaceC0552Gp;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(664103990, i, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:91)");
            }
            InterfaceC0552Gp interfaceC0552Gp = this.$content;
            int i2 = (this.$$dirty >> 6) & 7168;
            composer.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            interfaceC0552Gp.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 6) & 112) | 6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$Card$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ CardColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ CardElevation $elevation;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$shape = shape;
            this.$colors = cardColors;
            this.$elevation = cardElevation;
            this.$border = borderStroke;
            this.$content = interfaceC0552Gp;
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
            CardKt.Card(this.$modifier, this.$shape, this.$colors, this.$elevation, this.$border, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$Card$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$content = interfaceC0552Gp;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(776921067, i, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:153)");
            }
            InterfaceC0552Gp interfaceC0552Gp = this.$content;
            int i2 = (this.$$dirty >> 15) & 7168;
            composer.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            interfaceC0552Gp.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 6) & 112) | 6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$Card$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ CardColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ CardElevation $elevation;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$shape = shape;
            this.$colors = cardColors;
            this.$elevation = cardElevation;
            this.$border = borderStroke;
            this.$interactionSource = mutableInteractionSource;
            this.$content = interfaceC0552Gp;
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
            CardKt.Card(this.$onClick, this.$modifier, this.$enabled, this.$shape, this.$colors, this.$elevation, this.$border, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$ElevatedCard$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14761 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ CardColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ CardElevation $elevation;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14761(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$shape = shape;
            this.$colors = cardColors;
            this.$elevation = cardElevation;
            this.$content = interfaceC0552Gp;
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
            CardKt.ElevatedCard(this.$modifier, this.$shape, this.$colors, this.$elevation, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$ElevatedCard$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ CardColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ CardElevation $elevation;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$shape = shape;
            this.$colors = cardColors;
            this.$elevation = cardElevation;
            this.$interactionSource = mutableInteractionSource;
            this.$content = interfaceC0552Gp;
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
            CardKt.ElevatedCard(this.$onClick, this.$modifier, this.$enabled, this.$shape, this.$colors, this.$elevation, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$OutlinedCard$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14771 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ CardColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ CardElevation $elevation;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14771(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$shape = shape;
            this.$colors = cardColors;
            this.$elevation = cardElevation;
            this.$border = borderStroke;
            this.$content = interfaceC0552Gp;
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
            CardKt.OutlinedCard(this.$modifier, this.$shape, this.$colors, this.$elevation, this.$border, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CardKt$OutlinedCard$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14783 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ CardColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ CardElevation $elevation;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14783(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$shape = shape;
            this.$colors = cardColors;
            this.$elevation = cardElevation;
            this.$border = borderStroke;
            this.$interactionSource = mutableInteractionSource;
            this.$content = interfaceC0552Gp;
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
            CardKt.OutlinedCard(this.$onClick, this.$modifier, this.$enabled, this.$shape, this.$colors, this.$elevation, this.$border, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013d  */
    /* JADX WARN: Code duplicated, block: B:101:0x0152  */
    /* JADX WARN: Code duplicated, block: B:103:0x0157  */
    /* JADX WARN: Code duplicated, block: B:105:0x015f  */
    /* JADX WARN: Code duplicated, block: B:108:0x016b  */
    /* JADX WARN: Code duplicated, block: B:111:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:116:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0101  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0109  */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:95:0x0117  */
    /* JADX WARN: Code duplicated, block: B:97:0x0137  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Card(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColorsM1368cardColorsro_MJ88;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        int i4;
        Modifier modifier3;
        Shape shape3;
        int i5;
        CardColors cardColors2;
        int i6;
        CardElevation cardElevationM1369cardElevationaqJV_2Y;
        BorderStroke borderStroke3;
        int i7;
        CardElevation cardElevation3;
        CardElevation cardElevation4;
        BorderStroke borderStroke4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1179621553);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i9 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                cardColorsM1368cardColorsro_MJ88 = cardColors;
                int i10 = composerStartRestartGroup.changed(cardColorsM1368cardColorsro_MJ88) ? 256 : 128;
                i3 |= i10;
            } else {
                cardColorsM1368cardColorsro_MJ88 = cardColors;
            }
            i3 |= i10;
        } else {
            cardColorsM1368cardColorsro_MJ88 = cardColors;
        }
        if ((i & 7168) == 0) {
            cardElevation2 = cardElevation;
            i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(cardElevation2)) ? 2048 : 1024;
        } else {
            cardElevation2 = cardElevation;
        }
        int i11 = i2 & 16;
        if (i11 != 0) {
            i3 |= 24576;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((57344 & i) == 0) {
                i3 |= composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) == 0) {
            if ((458752 & i) == 0) {
                i4 = composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 131072 : 65536;
            }
            if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -897;
                    }
                    i5 = i3;
                    cardColors2 = cardColorsM1368cardColorsro_MJ88;
                    if ((i2 & 8) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i6 = i5 & (-7169);
                    } else {
                        i6 = i5;
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i11 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    CardElevation cardElevation5 = cardElevationM1369cardElevationaqJV_2Y;
                    i7 = i6;
                    cardElevation3 = cardElevation5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    modifier3 = modifier2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    cardElevation3 = cardElevation2;
                    CardColors cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    i7 = i3;
                    cardColors2 = cardColors3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1179621553, i7, -1, "androidx.compose.material3.Card (Card.kt:75)");
                }
                int i12 = i7 >> 3;
                int i13 = (i12 & 112) | 6;
                int i14 = (i12 & 896) | 54;
                CardColors cardColors4 = cardColors2;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape3, cardColors2.containerColor$material3_release(true, composerStartRestartGroup, i13).getValue().m3042unboximpl(), cardColors2.contentColor$material3_release(true, composerStartRestartGroup, i13).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(true, null, composerStartRestartGroup, i14).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(true, null, composerStartRestartGroup, i14).getValue().m5174unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 664103990, true, new AnonymousClass1(interfaceC0552Gp, i7)), composerStartRestartGroup, 12582912 | (i7 & 14) | (i7 & 112) | ((i7 << 6) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardElevation4 = cardElevation3;
                borderStroke4 = borderStroke3;
                cardColorsM1368cardColorsro_MJ88 = cardColors4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                borderStroke4 = borderStroke2;
                cardElevation4 = cardElevation2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier3, shape3, cardColorsM1368cardColorsro_MJ88, cardElevation4, borderStroke4, interfaceC0552Gp, i, i2));
        }
        i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i4;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                }
                i5 = i3;
                cardColors2 = cardColorsM1368cardColorsro_MJ88;
                if ((i2 & 8) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i6 = i5 & (-7169);
                } else {
                    i6 = i5;
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation;
                }
                if (i11 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                CardElevation cardElevation6 = cardElevationM1369cardElevationaqJV_2Y;
                i7 = i6;
                cardElevation3 = cardElevation6;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                }
                i5 = i3;
                cardColors2 = cardColorsM1368cardColorsro_MJ88;
                if ((i2 & 8) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i6 = i5 & (-7169);
                } else {
                    i6 = i5;
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation;
                }
                if (i11 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                CardElevation cardElevation7 = cardElevationM1369cardElevationaqJV_2Y;
                i7 = i6;
                cardElevation3 = cardElevation7;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179621553, i7, -1, "androidx.compose.material3.Card (Card.kt:75)");
            }
            int i15 = i7 >> 3;
            int i16 = (i15 & 112) | 6;
            int i17 = (i15 & 896) | 54;
            CardColors cardColors5 = cardColors2;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape3, cardColors2.containerColor$material3_release(true, composerStartRestartGroup, i16).getValue().m3042unboximpl(), cardColors2.contentColor$material3_release(true, composerStartRestartGroup, i16).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(true, null, composerStartRestartGroup, i17).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(true, null, composerStartRestartGroup, i17).getValue().m5174unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 664103990, true, new AnonymousClass1(interfaceC0552Gp, i7)), composerStartRestartGroup, 12582912 | (i7 & 14) | (i7 & 112) | ((i7 << 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cardElevation4 = cardElevation3;
            borderStroke4 = borderStroke3;
            cardColorsM1368cardColorsro_MJ88 = cardColors5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                }
                i5 = i3;
                cardColors2 = cardColorsM1368cardColorsro_MJ88;
                if ((i2 & 8) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i6 = i5 & (-7169);
                } else {
                    i6 = i5;
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation;
                }
                if (i11 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                CardElevation cardElevation8 = cardElevationM1369cardElevationaqJV_2Y;
                i7 = i6;
                cardElevation3 = cardElevation8;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                }
                i5 = i3;
                cardColors2 = cardColorsM1368cardColorsro_MJ88;
                if ((i2 & 8) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i6 = i5 & (-7169);
                } else {
                    i6 = i5;
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation;
                }
                if (i11 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                CardElevation cardElevation9 = cardElevationM1369cardElevationaqJV_2Y;
                i7 = i6;
                cardElevation3 = cardElevation9;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179621553, i7, -1, "androidx.compose.material3.Card (Card.kt:75)");
            }
            int i18 = i7 >> 3;
            int i19 = (i18 & 112) | 6;
            int i110 = (i18 & 896) | 54;
            CardColors cardColors6 = cardColors2;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape3, cardColors2.containerColor$material3_release(true, composerStartRestartGroup, i19).getValue().m3042unboximpl(), cardColors2.contentColor$material3_release(true, composerStartRestartGroup, i19).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(true, null, composerStartRestartGroup, i110).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(true, null, composerStartRestartGroup, i110).getValue().m5174unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 664103990, true, new AnonymousClass1(interfaceC0552Gp, i7)), composerStartRestartGroup, 12582912 | (i7 & 14) | (i7 & 112) | ((i7 << 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cardElevation4 = cardElevation3;
            borderStroke4 = borderStroke3;
            cardColorsM1368cardColorsro_MJ88 = cardColors6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier3, shape3, cardColorsM1368cardColorsro_MJ88, cardElevation4, borderStroke4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:95:0x0139  */
    /* JADX WARN: Code duplicated, block: B:98:0x0168  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        Shape elevatedShape;
        CardColors cardColorsM1370elevatedCardColorsro_MJ88;
        Modifier modifier3;
        Shape shape3;
        CardColors cardColors3;
        CardElevation cardElevationM1371elevatedCardElevationaqJV_2Y;
        Modifier modifier4;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation3;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(895940201);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i5 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i5;
            } else {
                shape2 = shape;
            }
            i3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i6 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i6;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i6;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                int i7 = composerStartRestartGroup.changed(cardElevation2) ? 2048 : 1024;
                i3 |= i7;
            } else {
                cardElevation2 = cardElevation;
            }
            i3 |= i7;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 16384 : 8192;
        }
        if ((46811 & i3) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            shape4 = shape2;
            cardColors4 = cardColors2;
            cardElevation3 = cardElevation2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i4 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                } else {
                    cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    modifier3 = modifier5;
                    shape3 = elevatedShape;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                } else {
                    modifier3 = modifier5;
                    shape3 = elevatedShape;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895940201, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:183)");
                }
                Card(modifier3, shape3, cardColors3, cardElevationM1371elevatedCardElevationaqJV_2Y, null, interfaceC0552Gp, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevationM1371elevatedCardElevationaqJV_2Y;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
            }
            cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895940201, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:183)");
            }
            Card(modifier3, shape3, cardColors3, cardElevationM1371elevatedCardElevationaqJV_2Y, null, interfaceC0552Gp, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape4 = shape3;
            cardColors4 = cardColors3;
            cardElevation3 = cardElevationM1371elevatedCardElevationaqJV_2Y;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14761(modifier4, shape4, cardColors4, cardElevation3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0136  */
    /* JADX WARN: Code duplicated, block: B:105:0x013b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0152  */
    /* JADX WARN: Code duplicated, block: B:109:0x0157  */
    /* JADX WARN: Code duplicated, block: B:110:0x0169  */
    /* JADX WARN: Code duplicated, block: B:113:0x0177  */
    /* JADX WARN: Code duplicated, block: B:116:0x0199  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:92:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0110  */
    /* JADX WARN: Code duplicated, block: B:98:0x011a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        int i4;
        Modifier modifier3;
        Shape outlinedShape;
        CardColors cardColorsM1372outlinedCardColorsro_MJ88;
        CardElevation cardElevationM1373outlinedCardElevationaqJV_2Y;
        Modifier modifier4;
        Shape shape3;
        CardColors cardColors3;
        CardElevation cardElevation3;
        BorderStroke borderStrokeOutlinedCardBorder;
        Modifier modifier5;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation4;
        BorderStroke borderStroke3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(740336179);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i6 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i6;
            } else {
                shape2 = shape;
            }
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i7 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i7;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i7;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                int i8 = composerStartRestartGroup.changed(cardElevation2) ? 2048 : 1024;
                i3 |= i8;
            } else {
                cardElevation2 = cardElevation;
            }
            i3 |= i8;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                borderStroke2 = borderStroke;
                int i9 = composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                i3 |= i9;
            } else {
                borderStroke2 = borderStroke;
            }
            i3 |= i9;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i2 & 32) == 0) {
            if ((458752 & i) == 0) {
                i4 = composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 131072 : 65536;
            }
            if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -897;
                    } else {
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 8) != 0) {
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -7169;
                    } else {
                        cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        modifier4 = modifier3;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, 48, 1);
                    } else {
                        modifier4 = modifier3;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(740336179, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:277)");
                    }
                    Card(modifier4, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    shape4 = shape3;
                    cardColors4 = cardColors3;
                    cardElevation4 = cardElevation3;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    modifier4 = modifier2;
                    shape3 = shape2;
                    cardColors3 = cardColors2;
                    cardElevation3 = cardElevation2;
                }
                borderStrokeOutlinedCardBorder = borderStroke2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(740336179, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:277)");
                }
                Card(modifier4, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                shape4 = shape3;
                cardColors4 = cardColors3;
                cardElevation4 = cardElevation3;
                borderStroke3 = borderStrokeOutlinedCardBorder;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                shape4 = shape2;
                cardColors4 = cardColors2;
                cardElevation4 = cardElevation2;
                borderStroke3 = borderStroke2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14771(modifier5, shape4, cardColors4, cardElevation4, borderStroke3, interfaceC0552Gp, i, i2));
        }
        i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i4;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                } else {
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, 48, 1);
                } else {
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = borderStroke2;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                } else {
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, 48, 1);
                } else {
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = borderStroke2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(740336179, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:277)");
            }
            Card(modifier4, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            shape4 = shape3;
            cardColors4 = cardColors3;
            cardElevation4 = cardElevation3;
            borderStroke3 = borderStrokeOutlinedCardBorder;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                } else {
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, 48, 1);
                } else {
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = borderStroke2;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -897;
                } else {
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, 48, 1);
                } else {
                    modifier4 = modifier3;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    borderStrokeOutlinedCardBorder = borderStroke2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(740336179, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:277)");
            }
            Card(modifier4, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            shape4 = shape3;
            cardColors4 = cardColors3;
            cardElevation4 = cardElevation3;
            borderStroke3 = borderStrokeOutlinedCardBorder;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14771(modifier5, shape4, cardColors4, cardElevation4, borderStroke3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0149 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:111:0x014e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0151  */
    /* JADX WARN: Code duplicated, block: B:114:0x0155  */
    /* JADX WARN: Code duplicated, block: B:117:0x015b  */
    /* JADX WARN: Code duplicated, block: B:118:0x0167  */
    /* JADX WARN: Code duplicated, block: B:121:0x016d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0187  */
    /* JADX WARN: Code duplicated, block: B:125:0x018f  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01de  */
    /* JADX WARN: Code duplicated, block: B:139:0x0225  */
    /* JADX WARN: Code duplicated, block: B:144:0x023b  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:90:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:94:0x0113  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ElevatedCard(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevationM1371elevatedCardElevationaqJV_2Y;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        Modifier modifier3;
        boolean z3;
        Shape elevatedShape;
        int i9;
        CardColors cardColorsM1370elevatedCardColorsro_MJ88;
        MutableInteractionSource mutableInteractionSource3;
        CardElevation cardElevation2;
        CardColors cardColors3;
        Modifier modifier4;
        Object objRememberedValue;
        Modifier modifier5;
        CardColors cardColors4;
        CardElevation cardElevation3;
        MutableInteractionSource mutableInteractionSource4;
        boolean z4;
        Shape shape3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1850977784);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i12 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i12;
                } else {
                    cardColors2 = cardColors;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                        int i13 = composerStartRestartGroup.changed(cardElevationM1371elevatedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i3 |= i13;
                    } else {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                    }
                    i3 |= i13;
                } else {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((3670016 & i) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                if ((i2 & 128) != 0) {
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                    }
                    if ((23967451 & i3) != 4793490 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier5 = modifier2;
                        z4 = z2;
                        shape3 = shape2;
                        cardColors4 = cardColors2;
                        cardElevation3 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                            } else {
                                elevatedShape = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                i9 = i3 & (-57345);
                                cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                i9 = i3;
                                cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                            }
                            if ((i2 & 32) != 0) {
                                cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                i3 = i9 & (-458753);
                            } else {
                                i3 = i9;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                            cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                            modifier4 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier4 = modifier2;
                            z3 = z2;
                            elevatedShape = shape2;
                            cardColors3 = cardColors2;
                            cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                        }
                        int i14 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                        int i15 = i3 << 3;
                        Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i14 | (i15 & 29360128) | (i15 & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        cardColors4 = cardColors3;
                        cardElevation3 = cardElevation2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z4 = z3;
                        shape3 = elevatedShape;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
                }
                i8 = 12582912;
                i3 |= i8;
                if ((23967451 & i3) != 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                    }
                    int i16 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                    int i17 = i3 << 3;
                    Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i16 | (i17 & 29360128) | (i17 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z4 = z3;
                    shape3 = elevatedShape;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                    }
                    int i18 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                    int i19 = i3 << 3;
                    Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i18 | (i19 & 29360128) | (i19 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z4 = z3;
                    shape3 = elevatedShape;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i12;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i12;
            } else {
                cardColors2 = cardColors;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM1371elevatedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i13;
                } else {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i13;
            } else {
                cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 128) != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                }
                if ((23967451 & i3) != 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                    }
                    int i110 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                    int i111 = i3 << 3;
                    Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i110 | (i111 & 29360128) | (i111 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z4 = z3;
                    shape3 = elevatedShape;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                    }
                    int i112 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                    int i113 = i3 << 3;
                    Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i112 | (i113 & 29360128) | (i113 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z4 = z3;
                    shape3 = elevatedShape;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
            }
            i8 = 12582912;
            i3 |= i8;
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                }
                int i114 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                int i115 = i3 << 3;
                Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i114 | (i115 & 29360128) | (i115 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                mutableInteractionSource4 = mutableInteractionSource3;
                z4 = z3;
                shape3 = elevatedShape;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                }
                int i116 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                int i117 = i3 << 3;
                Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i116 | (i117 & 29360128) | (i117 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                mutableInteractionSource4 = mutableInteractionSource3;
                z4 = z3;
                shape3 = elevatedShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i12;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i12;
            } else {
                cardColors2 = cardColors;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM1371elevatedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i13;
                } else {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i13;
            } else {
                cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 128) != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                }
                if ((23967451 & i3) != 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                    }
                    int i118 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                    int i119 = i3 << 3;
                    Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i118 | (i119 & 29360128) | (i119 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z4 = z3;
                    shape3 = elevatedShape;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        } else {
                            elevatedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 = i9 & (-458753);
                        } else {
                            i3 = i9;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                    }
                    int i1110 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                    int i1111 = i3 << 3;
                    Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i1110 | (i1111 & 29360128) | (i1111 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z4 = z3;
                    shape3 = elevatedShape;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
            }
            i8 = 12582912;
            i3 |= i8;
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                }
                int i1112 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                int i1113 = i3 << 3;
                Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i1112 | (i1113 & 29360128) | (i1113 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                mutableInteractionSource4 = mutableInteractionSource3;
                z4 = z3;
                shape3 = elevatedShape;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                }
                int i1114 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                int i1115 = i3 << 3;
                Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i1114 | (i1115 & 29360128) | (i1115 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                mutableInteractionSource4 = mutableInteractionSource3;
                z4 = z3;
                shape3 = elevatedShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            i3 |= i11;
        } else {
            shape2 = shape;
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                cardColors2 = cardColors;
                if (composerStartRestartGroup.changed(cardColors2)) {
                }
                i3 |= i12;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i12;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
                if (composerStartRestartGroup.changed(cardElevationM1371elevatedCardElevationaqJV_2Y)) {
                }
                i3 |= i13;
            } else {
                cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i13;
        } else {
            cardElevationM1371elevatedCardElevationaqJV_2Y = cardElevation;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        if ((i2 & 128) != 0) {
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
            }
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                }
                int i1116 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                int i1117 = i3 << 3;
                Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i1116 | (i1117 & 29360128) | (i1117 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                mutableInteractionSource4 = mutableInteractionSource3;
                z4 = z3;
                shape3 = elevatedShape;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 = i9 & (-458753);
                    } else {
                        i3 = i9;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
                }
                int i1118 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
                int i1119 = i3 << 3;
                Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i1118 | (i1119 & 29360128) | (i1119 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                mutableInteractionSource4 = mutableInteractionSource3;
                z4 = z3;
                shape3 = elevatedShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
        }
        i8 = 12582912;
        i3 |= i8;
        if ((23967451 & i3) != 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 = i9 & (-458753);
                } else {
                    i3 = i9;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                modifier4 = modifier3;
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 = i9 & (-458753);
                } else {
                    i3 = i9;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                modifier4 = modifier3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
            }
            int i11110 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
            int i11111 = i3 << 3;
            Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i11110 | (i11111 & 29360128) | (i11111 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            cardColors4 = cardColors3;
            cardElevation3 = cardElevation2;
            mutableInteractionSource4 = mutableInteractionSource3;
            z4 = z3;
            shape3 = elevatedShape;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 = i9 & (-458753);
                } else {
                    i3 = i9;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                modifier4 = modifier3;
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1370elevatedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1370elevatedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1370elevatedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1371elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1371elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 = i9 & (-458753);
                } else {
                    i3 = i9;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1371elevatedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1370elevatedCardColorsro_MJ88;
                modifier4 = modifier3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:230)");
            }
            int i11112 = (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752);
            int i11113 = i3 << 3;
            Card(interfaceC3588op, modifier4, z3, elevatedShape, cardColors3, cardElevation2, null, mutableInteractionSource3, interfaceC0552Gp, composerStartRestartGroup, i11112 | (i11113 & 29360128) | (i11113 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            cardColors4 = cardColors3;
            cardElevation3 = cardElevation2;
            mutableInteractionSource4 = mutableInteractionSource3;
            z4 = z3;
            shape3 = elevatedShape;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier5, z4, shape3, cardColors4, cardElevation3, mutableInteractionSource4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0118  */
    /* JADX WARN: Code duplicated, block: B:104:0x012f  */
    /* JADX WARN: Code duplicated, block: B:106:0x013f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x0172  */
    /* JADX WARN: Code duplicated, block: B:124:0x0175  */
    /* JADX WARN: Code duplicated, block: B:126:0x0179  */
    /* JADX WARN: Code duplicated, block: B:129:0x017f  */
    /* JADX WARN: Code duplicated, block: B:130:0x018b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0191  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01db  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:146:0x0207  */
    /* JADX WARN: Code duplicated, block: B:149:0x0222  */
    /* JADX WARN: Code duplicated, block: B:152:0x0230  */
    /* JADX WARN: Code duplicated, block: B:155:0x0260  */
    /* JADX WARN: Code duplicated, block: B:160:0x0278  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0103  */
    /* JADX WARN: Code duplicated, block: B:96:0x0109  */
    /* JADX WARN: Code duplicated, block: B:97:0x010c  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void OutlinedCard(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevationM1373outlinedCardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        Modifier modifier2;
        Shape outlinedShape;
        int i9;
        CardColors cardColorsM1372outlinedCardColorsro_MJ88;
        boolean z3;
        BorderStroke borderStrokeOutlinedCardBorder;
        MutableInteractionSource mutableInteractionSource2;
        CardElevation cardElevation2;
        CardColors cardColors3;
        Modifier modifier3;
        boolean z4;
        Object objRememberedValue;
        Modifier modifier4;
        boolean z5;
        CardColors cardColors4;
        CardElevation cardElevation3;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-727137250);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i12 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i13 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i13;
                } else {
                    cardColors2 = cardColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                        int i14 = composerStartRestartGroup.changed(cardElevationM1373outlinedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i3 |= i14;
                    } else {
                        cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                    }
                    i3 |= i14;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                }
                if ((3670016 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 524288;
                    } else {
                        i10 = 1048576;
                    }
                    i3 |= i10;
                } else {
                    borderStroke2 = borderStroke;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 67108864;
                        } else {
                            i8 = 33554432;
                        }
                    }
                    if ((191739611 & i3) != 38347922 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        z5 = z2;
                        shape3 = shape2;
                        cardColors4 = cardColors2;
                        cardElevation3 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                            } else {
                                outlinedShape = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                i9 = i3 & (-57345);
                                cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                i9 = i3;
                                cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                            }
                            if ((i2 & 32) != 0) {
                                i9 &= -458753;
                                cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            }
                            if ((i2 & 64) != 0) {
                                borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                                i9 &= -3670017;
                            } else {
                                borderStrokeOutlinedCardBorder = borderStroke;
                            }
                            if (i6 != 0) {
                                z3 = z2;
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    z3 = z2;
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                z3 = z2;
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                z3 = z2;
                                z3 = z2;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                            cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                            i3 = i9;
                            modifier3 = modifier2;
                            z4 = z3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            modifier3 = modifier;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z4 = z2;
                            outlinedShape = shape2;
                            cardColors3 = cardColors2;
                            cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                            borderStrokeOutlinedCardBorder = borderStroke2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                        }
                        Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z5 = z4;
                        cardColors4 = cardColors3;
                        cardElevation3 = cardElevation2;
                        borderStroke3 = borderStrokeOutlinedCardBorder;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = outlinedShape;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i8 = 100663296;
                i3 |= i8;
                if ((191739611 & i3) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                    }
                    Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = outlinedShape;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                    }
                    Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = outlinedShape;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i13;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i13;
            } else {
                cardColors2 = cardColors;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM1373outlinedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i14;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i14;
            } else {
                cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
            }
            if ((3670016 & i) == 0) {
                borderStroke2 = borderStroke;
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            } else {
                borderStroke2 = borderStroke;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                }
                if ((191739611 & i3) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                    }
                    Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = outlinedShape;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                    }
                    Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = outlinedShape;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i8 = 100663296;
            i3 |= i8;
            if ((191739611 & i3) != 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                }
                Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                borderStroke3 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = outlinedShape;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                }
                Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                borderStroke3 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = outlinedShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i13;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i13;
            } else {
                cardColors2 = cardColors;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM1373outlinedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i14;
                } else {
                    cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i14;
            } else {
                cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
            }
            if ((3670016 & i) == 0) {
                borderStroke2 = borderStroke;
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            } else {
                borderStroke2 = borderStroke;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                }
                if ((191739611 & i3) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                    }
                    Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = outlinedShape;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        } else {
                            outlinedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i3 & (-57345);
                            cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            i9 = i3;
                            cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                            i9 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            z3 = z2;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                z3 = z2;
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            z3 = z2;
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            z3 = z2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                        cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                        i3 = i9;
                        modifier3 = modifier2;
                        z4 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                    }
                    Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    cardColors4 = cardColors3;
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = outlinedShape;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i8 = 100663296;
            i3 |= i8;
            if ((191739611 & i3) != 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                }
                Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                borderStroke3 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = outlinedShape;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                }
                Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                borderStroke3 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = outlinedShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            i3 |= i12;
        } else {
            shape2 = shape;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                cardColors2 = cardColors;
                if (composerStartRestartGroup.changed(cardColors2)) {
                }
                i3 |= i13;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i13;
        } else {
            cardColors2 = cardColors;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
                if (composerStartRestartGroup.changed(cardElevationM1373outlinedCardElevationaqJV_2Y)) {
                }
                i3 |= i14;
            } else {
                cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i14;
        } else {
            cardElevationM1373outlinedCardElevationaqJV_2Y = cardElevation;
        }
        if ((3670016 & i) == 0) {
            borderStroke2 = borderStroke;
            if ((i2 & 64) == 0) {
                i10 = 524288;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        } else {
            borderStroke2 = borderStroke;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((i2 & 256) != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
            }
            if ((191739611 & i3) != 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                }
                Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                borderStroke3 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = outlinedShape;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i3 & (-57345);
                        cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        i9 = i3;
                        cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                        i9 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        z3 = z2;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            z3 = z2;
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        z3 = z2;
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z3 = z2;
                        z3 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                    cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                    i3 = i9;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
                }
                Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                cardColors4 = cardColors3;
                cardElevation3 = cardElevation2;
                borderStroke3 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = outlinedShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i8 = 100663296;
        i3 |= i8;
        if ((191739611 & i3) != 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    i9 &= -458753;
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                }
                if ((i2 & 64) != 0) {
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                    i9 &= -3670017;
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                if (i6 != 0) {
                    z3 = z2;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        z3 = z2;
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    z3 = z2;
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z3 = z2;
                    z3 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                i3 = i9;
                modifier3 = modifier2;
                z4 = z3;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    i9 &= -458753;
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                }
                if ((i2 & 64) != 0) {
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                    i9 &= -3670017;
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                if (i6 != 0) {
                    z3 = z2;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        z3 = z2;
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    z3 = z2;
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z3 = z2;
                    z3 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                i3 = i9;
                modifier3 = modifier2;
                z4 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
            }
            Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z5 = z4;
            cardColors4 = cardColors3;
            cardElevation3 = cardElevation2;
            borderStroke3 = borderStrokeOutlinedCardBorder;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape3 = outlinedShape;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    i9 &= -458753;
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                }
                if ((i2 & 64) != 0) {
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                    i9 &= -3670017;
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                if (i6 != 0) {
                    z3 = z2;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        z3 = z2;
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    z3 = z2;
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z3 = z2;
                    z3 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                i3 = i9;
                modifier3 = modifier2;
                z4 = z3;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    i9 = i3 & (-57345);
                    cardColorsM1372outlinedCardColorsro_MJ88 = CardDefaults.INSTANCE.m1372outlinedCardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    i9 = i3;
                    cardColorsM1372outlinedCardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    i9 &= -458753;
                    cardElevationM1373outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m1373outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                }
                if ((i2 & 64) != 0) {
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z3, composerStartRestartGroup, ((i9 >> 6) & 14) | 48, 0);
                    i9 &= -3670017;
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                if (i6 != 0) {
                    z3 = z2;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        z3 = z2;
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    z3 = z2;
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z3 = z2;
                    z3 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                cardElevation2 = cardElevationM1373outlinedCardElevationaqJV_2Y;
                cardColors3 = cardColorsM1372outlinedCardColorsro_MJ88;
                i3 = i9;
                modifier3 = modifier2;
                z4 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:326)");
            }
            Card(interfaceC3588op, modifier3, z4, outlinedShape, cardColors3, cardElevation2, borderStrokeOutlinedCardBorder, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 268435454, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z5 = z4;
            cardColors4 = cardColors3;
            cardElevation3 = cardElevation2;
            borderStroke3 = borderStrokeOutlinedCardBorder;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape3 = outlinedShape;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14783(interfaceC3588op, modifier4, z5, shape3, cardColors4, cardElevation3, borderStroke3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0133  */
    /* JADX WARN: Code duplicated, block: B:106:0x0141  */
    /* JADX WARN: Code duplicated, block: B:120:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x016f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0172  */
    /* JADX WARN: Code duplicated, block: B:124:0x0176  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0185  */
    /* JADX WARN: Code duplicated, block: B:131:0x018b  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:139:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:145:0x0205  */
    /* JADX WARN: Code duplicated, block: B:148:0x021a  */
    /* JADX WARN: Code duplicated, block: B:151:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:156:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:90:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:92:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x0107  */
    /* JADX WARN: Code duplicated, block: B:96:0x010d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0110  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Card(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier modifier2;
        Shape shape3;
        CardColors cardColorsM1368cardColorsro_MJ88;
        CardElevation cardElevationM1369cardElevationaqJV_2Y;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        int i11;
        Shape shape4;
        BorderStroke borderStroke4;
        CardColors cardColors3;
        boolean z3;
        CardElevation cardElevation3;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier4;
        Shape shape5;
        BorderStroke borderStroke5;
        CardColors cardColors4;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        CardElevation cardElevation4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-2024281376);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i13 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i14 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i14;
                } else {
                    cardColors2 = cardColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevation2 = cardElevation;
                        int i15 = composerStartRestartGroup.changed(cardElevation2) ? 131072 : 65536;
                        i3 |= i15;
                    } else {
                        cardElevation2 = cardElevation;
                    }
                    i3 |= i15;
                } else {
                    cardElevation2 = cardElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((3670016 & i) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) != 38347922 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        z4 = z2;
                        shape5 = shape2;
                        cardColors4 = cardColors2;
                        cardElevation4 = cardElevation2;
                        borderStroke5 = borderStroke2;
                        modifier4 = modifier;
                        mutableInteractionSource3 = mutableInteractionSource;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier3 = modifier;
                            borderStroke4 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                            shape4 = shape2;
                            cardColors3 = cardColors2;
                            cardElevation3 = cardElevation2;
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -57345;
                            } else {
                                cardColorsM1368cardColorsro_MJ88 = cardColors2;
                            }
                            if ((i2 & 32) != 0) {
                                cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                i3 &= -458753;
                            } else {
                                cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                            }
                            if (i6 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                modifier3 = modifier2;
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                cardColors3 = cardColorsM1368cardColorsro_MJ88;
                                cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                i11 = i3;
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                cardColors3 = cardColorsM1368cardColorsro_MJ88;
                                z3 = z2;
                                cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                            }
                            int i16 = (i11 >> 6) & 14;
                            int i17 = i11 >> 9;
                            int i18 = i16 | (i17 & 112);
                            int i19 = i16 | ((i11 >> 18) & 112) | (i17 & 896);
                            CardColors cardColors5 = cardColors3;
                            boolean z5 = z3;
                            int i20 = i11;
                            int i21 = i20 & 8190;
                            int i22 = i20 << 6;
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            CardElevation cardElevation5 = cardElevation3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z5, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i18).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i18).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i19).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i19).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i21 | (i22 & 234881024) | (i22 & 1879048192), 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            shape5 = shape4;
                            borderStroke5 = borderStroke4;
                            cardColors4 = cardColors5;
                            z4 = z5;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            cardElevation4 = cardElevation5;
                        }
                        i11 = i3;
                        z3 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                        }
                        int i110 = (i11 >> 6) & 14;
                        int i111 = i11 >> 9;
                        int i112 = i110 | (i111 & 112);
                        int i113 = i110 | ((i11 >> 18) & 112) | (i111 & 896);
                        CardColors cardColors6 = cardColors3;
                        boolean z6 = z3;
                        int i23 = i11;
                        int i24 = i23 & 8190;
                        int i25 = i23 << 6;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                        CardElevation cardElevation6 = cardElevation3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z6, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i112).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i112).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i113).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i113).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i24 | (i25 & 234881024) | (i25 & 1879048192), 6, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        shape5 = shape4;
                        borderStroke5 = borderStroke4;
                        cardColors4 = cardColors6;
                        z4 = z6;
                        mutableInteractionSource3 = mutableInteractionSource5;
                        cardElevation4 = cardElevation6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                    }
                    int i114 = (i11 >> 6) & 14;
                    int i115 = i11 >> 9;
                    int i116 = i114 | (i115 & 112);
                    int i117 = i114 | ((i11 >> 18) & 112) | (i115 & 896);
                    CardColors cardColors7 = cardColors3;
                    boolean z7 = z3;
                    int i26 = i11;
                    int i27 = i26 & 8190;
                    int i28 = i26 << 6;
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                    CardElevation cardElevation7 = cardElevation3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z7, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i116).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i116).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i117).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i117).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i27 | (i28 & 234881024) | (i28 & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke5 = borderStroke4;
                    cardColors4 = cardColors7;
                    z4 = z7;
                    mutableInteractionSource3 = mutableInteractionSource6;
                    cardElevation4 = cardElevation7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                    }
                    int i118 = (i11 >> 6) & 14;
                    int i119 = i11 >> 9;
                    int i1110 = i118 | (i119 & 112);
                    int i1111 = i118 | ((i11 >> 18) & 112) | (i119 & 896);
                    CardColors cardColors8 = cardColors3;
                    boolean z8 = z3;
                    int i29 = i11;
                    int i210 = i29 & 8190;
                    int i211 = i29 << 6;
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                    CardElevation cardElevation8 = cardElevation3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z8, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i1110).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i1110).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1111).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1111).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i210 | (i211 & 234881024) | (i211 & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke5 = borderStroke4;
                    cardColors4 = cardColors8;
                    z4 = z8;
                    mutableInteractionSource3 = mutableInteractionSource7;
                    cardElevation4 = cardElevation8;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i14;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i14;
            } else {
                cardColors2 = cardColors;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevation2 = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevation2)) {
                    }
                    i3 |= i15;
                } else {
                    cardElevation2 = cardElevation;
                }
                i3 |= i15;
            } else {
                cardElevation2 = cardElevation;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                    }
                    int i1112 = (i11 >> 6) & 14;
                    int i1113 = i11 >> 9;
                    int i1114 = i1112 | (i1113 & 112);
                    int i1115 = i1112 | ((i11 >> 18) & 112) | (i1113 & 896);
                    CardColors cardColors9 = cardColors3;
                    boolean z9 = z3;
                    int i212 = i11;
                    int i213 = i212 & 8190;
                    int i214 = i212 << 6;
                    MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                    CardElevation cardElevation9 = cardElevation3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z9, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i1114).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i1114).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1115).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1115).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource8, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i213 | (i214 & 234881024) | (i214 & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke5 = borderStroke4;
                    cardColors4 = cardColors9;
                    z4 = z9;
                    mutableInteractionSource3 = mutableInteractionSource8;
                    cardElevation4 = cardElevation9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                    }
                    int i1116 = (i11 >> 6) & 14;
                    int i1117 = i11 >> 9;
                    int i1118 = i1116 | (i1117 & 112);
                    int i1119 = i1116 | ((i11 >> 18) & 112) | (i1117 & 896);
                    CardColors cardColors10 = cardColors3;
                    boolean z10 = z3;
                    int i215 = i11;
                    int i216 = i215 & 8190;
                    int i217 = i215 << 6;
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                    CardElevation cardElevation10 = cardElevation3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z10, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i1118).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i1118).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1119).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1119).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource9, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i216 | (i217 & 234881024) | (i217 & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke5 = borderStroke4;
                    cardColors4 = cardColors10;
                    z4 = z10;
                    mutableInteractionSource3 = mutableInteractionSource9;
                    cardElevation4 = cardElevation10;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) != 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                }
                int i11110 = (i11 >> 6) & 14;
                int i11111 = i11 >> 9;
                int i11112 = i11110 | (i11111 & 112);
                int i11113 = i11110 | ((i11 >> 18) & 112) | (i11111 & 896);
                CardColors cardColors11 = cardColors3;
                boolean z11 = z3;
                int i218 = i11;
                int i219 = i218 & 8190;
                int i2110 = i218 << 6;
                MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                CardElevation cardElevation11 = cardElevation3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z11, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i11112).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i11112).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11113).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11113).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource10, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i219 | (i2110 & 234881024) | (i2110 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                cardColors4 = cardColors11;
                z4 = z11;
                mutableInteractionSource3 = mutableInteractionSource10;
                cardElevation4 = cardElevation11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                }
                int i11114 = (i11 >> 6) & 14;
                int i11115 = i11 >> 9;
                int i11116 = i11114 | (i11115 & 112);
                int i11117 = i11114 | ((i11 >> 18) & 112) | (i11115 & 896);
                CardColors cardColors12 = cardColors3;
                boolean z12 = z3;
                int i2111 = i11;
                int i2112 = i2111 & 8190;
                int i2113 = i2111 << 6;
                MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                CardElevation cardElevation12 = cardElevation3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z12, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i11116).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i11116).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11117).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11117).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource11, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i2112 | (i2113 & 234881024) | (i2113 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                cardColors4 = cardColors12;
                z4 = z12;
                mutableInteractionSource3 = mutableInteractionSource11;
                cardElevation4 = cardElevation12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i14;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i14;
            } else {
                cardColors2 = cardColors;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevation2 = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevation2)) {
                    }
                    i3 |= i15;
                } else {
                    cardElevation2 = cardElevation;
                }
                i3 |= i15;
            } else {
                cardElevation2 = cardElevation;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) != 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                    }
                    int i11118 = (i11 >> 6) & 14;
                    int i11119 = i11 >> 9;
                    int i111110 = i11118 | (i11119 & 112);
                    int i111111 = i11118 | ((i11 >> 18) & 112) | (i11119 & 896);
                    CardColors cardColors13 = cardColors3;
                    boolean z13 = z3;
                    int i2114 = i11;
                    int i2115 = i2114 & 8190;
                    int i2116 = i2114 << 6;
                    MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
                    CardElevation cardElevation13 = cardElevation3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z13, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i111110).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i111110).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i111111).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i111111).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource12, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i2115 | (i2116 & 234881024) | (i2116 & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke5 = borderStroke4;
                    cardColors4 = cardColors13;
                    z4 = z13;
                    mutableInteractionSource3 = mutableInteractionSource12;
                    cardElevation4 = cardElevation13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -57345;
                        } else {
                            cardColorsM1368cardColorsro_MJ88 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i3 &= -458753;
                        } else {
                            cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                        }
                        if (i6 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            i11 = i3;
                            z3 = z2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            i11 = i3;
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            cardColors3 = cardColorsM1368cardColorsro_MJ88;
                            z3 = z2;
                            cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                    }
                    int i111112 = (i11 >> 6) & 14;
                    int i111113 = i11 >> 9;
                    int i111114 = i111112 | (i111113 & 112);
                    int i111115 = i111112 | ((i11 >> 18) & 112) | (i111113 & 896);
                    CardColors cardColors14 = cardColors3;
                    boolean z14 = z3;
                    int i2117 = i11;
                    int i2118 = i2117 & 8190;
                    int i2119 = i2117 << 6;
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource2;
                    CardElevation cardElevation14 = cardElevation3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z14, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i111114).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i111114).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i111115).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i111115).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource13, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i2118 | (i2119 & 234881024) | (i2119 & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape5 = shape4;
                    borderStroke5 = borderStroke4;
                    cardColors4 = cardColors14;
                    z4 = z14;
                    mutableInteractionSource3 = mutableInteractionSource13;
                    cardElevation4 = cardElevation14;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) != 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                }
                int i111116 = (i11 >> 6) & 14;
                int i111117 = i11 >> 9;
                int i111118 = i111116 | (i111117 & 112);
                int i111119 = i111116 | ((i11 >> 18) & 112) | (i111117 & 896);
                CardColors cardColors15 = cardColors3;
                boolean z15 = z3;
                int i21110 = i11;
                int i21111 = i21110 & 8190;
                int i21112 = i21110 << 6;
                MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource2;
                CardElevation cardElevation15 = cardElevation3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z15, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i111118).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i111118).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i111119).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i111119).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource14, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i21111 | (i21112 & 234881024) | (i21112 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                cardColors4 = cardColors15;
                z4 = z15;
                mutableInteractionSource3 = mutableInteractionSource14;
                cardElevation4 = cardElevation15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                }
                int i1111110 = (i11 >> 6) & 14;
                int i1111111 = i11 >> 9;
                int i1111112 = i1111110 | (i1111111 & 112);
                int i1111113 = i1111110 | ((i11 >> 18) & 112) | (i1111111 & 896);
                CardColors cardColors16 = cardColors3;
                boolean z16 = z3;
                int i21113 = i11;
                int i21114 = i21113 & 8190;
                int i21115 = i21113 << 6;
                MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource2;
                CardElevation cardElevation16 = cardElevation3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z16, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i1111112).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i1111112).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1111113).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1111113).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource15, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i21114 | (i21115 & 234881024) | (i21115 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                cardColors4 = cardColors16;
                z4 = z16;
                mutableInteractionSource3 = mutableInteractionSource15;
                cardElevation4 = cardElevation16;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                cardColors2 = cardColors;
                if (composerStartRestartGroup.changed(cardColors2)) {
                }
                i3 |= i14;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i14;
        } else {
            cardColors2 = cardColors;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                cardElevation2 = cardElevation;
                if (composerStartRestartGroup.changed(cardElevation2)) {
                }
                i3 |= i15;
            } else {
                cardElevation2 = cardElevation;
            }
            i3 |= i15;
        } else {
            cardElevation2 = cardElevation;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i2 & 256) != 0) {
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
            }
            if ((191739611 & i3) != 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                }
                int i1111114 = (i11 >> 6) & 14;
                int i1111115 = i11 >> 9;
                int i1111116 = i1111114 | (i1111115 & 112);
                int i1111117 = i1111114 | ((i11 >> 18) & 112) | (i1111115 & 896);
                CardColors cardColors17 = cardColors3;
                boolean z17 = z3;
                int i21116 = i11;
                int i21117 = i21116 & 8190;
                int i21118 = i21116 << 6;
                MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource2;
                CardElevation cardElevation17 = cardElevation3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z17, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i1111116).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i1111116).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1111117).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i1111117).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource16, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i21117 | (i21118 & 234881024) | (i21118 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                cardColors4 = cardColors17;
                z4 = z17;
                mutableInteractionSource3 = mutableInteractionSource16;
                cardElevation4 = cardElevation17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -57345;
                    } else {
                        cardColorsM1368cardColorsro_MJ88 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -458753;
                    } else {
                        cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                    }
                    if (i6 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        i11 = i3;
                        z3 = z2;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        i11 = i3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        cardColors3 = cardColorsM1368cardColorsro_MJ88;
                        z3 = z2;
                        cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
                }
                int i1111118 = (i11 >> 6) & 14;
                int i1111119 = i11 >> 9;
                int i11111110 = i1111118 | (i1111119 & 112);
                int i11111111 = i1111118 | ((i11 >> 18) & 112) | (i1111119 & 896);
                CardColors cardColors18 = cardColors3;
                boolean z18 = z3;
                int i21119 = i11;
                int i211110 = i21119 & 8190;
                int i211111 = i21119 << 6;
                MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource2;
                CardElevation cardElevation18 = cardElevation3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z18, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i11111110).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i11111110).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11111111).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11111111).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource17, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i211110 | (i211111 & 234881024) | (i211111 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                cardColors4 = cardColors18;
                z4 = z18;
                mutableInteractionSource3 = mutableInteractionSource17;
                cardElevation4 = cardElevation18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i10 = 100663296;
        i3 |= i10;
        if ((191739611 & i3) != 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -57345;
                } else {
                    cardColorsM1368cardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -458753;
                } else {
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                }
                if (i6 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    i11 = i3;
                    z3 = z2;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    i11 = i3;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    z3 = z2;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -57345;
                } else {
                    cardColorsM1368cardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -458753;
                } else {
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                }
                if (i6 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    i11 = i3;
                    z3 = z2;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    i11 = i3;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    z3 = z2;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
            }
            int i11111112 = (i11 >> 6) & 14;
            int i11111113 = i11 >> 9;
            int i11111114 = i11111112 | (i11111113 & 112);
            int i11111115 = i11111112 | ((i11 >> 18) & 112) | (i11111113 & 896);
            CardColors cardColors19 = cardColors3;
            boolean z19 = z3;
            int i211112 = i11;
            int i211113 = i211112 & 8190;
            int i211114 = i211112 << 6;
            MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource2;
            CardElevation cardElevation19 = cardElevation3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z19, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i11111114).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i11111114).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11111115).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11111115).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource18, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i211113 | (i211114 & 234881024) | (i211114 & 1879048192), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape5 = shape4;
            borderStroke5 = borderStroke4;
            cardColors4 = cardColors19;
            z4 = z19;
            mutableInteractionSource3 = mutableInteractionSource18;
            cardElevation4 = cardElevation19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -57345;
                } else {
                    cardColorsM1368cardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -458753;
                } else {
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                }
                if (i6 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    i11 = i3;
                    z3 = z2;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    i11 = i3;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    z3 = z2;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    cardColorsM1368cardColorsro_MJ88 = CardDefaults.INSTANCE.m1368cardColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -57345;
                } else {
                    cardColorsM1368cardColorsro_MJ88 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM1369cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1369cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -458753;
                } else {
                    cardElevationM1369cardElevationaqJV_2Y = cardElevation2;
                }
                if (i6 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    i11 = i3;
                    z3 = z2;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    i11 = i3;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    cardColors3 = cardColorsM1368cardColorsro_MJ88;
                    z3 = z2;
                    cardElevation3 = cardElevationM1369cardElevationaqJV_2Y;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2024281376, i11, -1, "androidx.compose.material3.Card (Card.kt:131)");
            }
            int i11111116 = (i11 >> 6) & 14;
            int i11111117 = i11 >> 9;
            int i11111118 = i11111116 | (i11111117 & 112);
            int i11111119 = i11111116 | ((i11 >> 18) & 112) | (i11111117 & 896);
            CardColors cardColors110 = cardColors3;
            boolean z110 = z3;
            int i211115 = i11;
            int i211116 = i211115 & 8190;
            int i211117 = i211115 << 6;
            MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource2;
            CardElevation cardElevation110 = cardElevation3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, modifier3, z110, shape4, cardColors3.containerColor$material3_release(z3, composerStartRestartGroup, i11111118).getValue().m3042unboximpl(), cardColors3.contentColor$material3_release(z3, composerStartRestartGroup, i11111118).getValue().m3042unboximpl(), cardElevation3.tonalElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11111119).getValue().m5174unboximpl(), cardElevation3.shadowElevation$material3_release(z3, mutableInteractionSource2, composerStartRestartGroup, i11111119).getValue().m5174unboximpl(), borderStroke4, mutableInteractionSource19, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 776921067, true, new AnonymousClass4(interfaceC0552Gp, i11)), composer2, i211116 | (i211117 & 234881024) | (i211117 & 1879048192), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape5 = shape4;
            borderStroke5 = borderStroke4;
            cardColors4 = cardColors110;
            z4 = z110;
            mutableInteractionSource3 = mutableInteractionSource19;
            cardElevation4 = cardElevation110;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(interfaceC3588op, modifier4, z4, shape5, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource3, interfaceC0552Gp, i, i2));
    }
}
