package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.FrameMetricsAggregator;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ChipKt {
    private static final float LeadingIconEndSpacing;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    private static final float HorizontalPadding = Dp.m5160constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m5160constructorimpl(4);
    private static final float SelectedIconContainerSize = Dp.m5160constructorimpl(24);

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.m4564setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m4550getButtono7Vup1c());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ ChipColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ State<Color> $contentColor$delegate;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;

        /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ ChipColors $colors;
            final /* synthetic */ InterfaceC0552Gp $content;
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ InterfaceC0526Fp $leadingIcon;

            /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00711 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ ChipColors $colors;
                final /* synthetic */ InterfaceC0552Gp $content;
                final /* synthetic */ boolean $enabled;
                final /* synthetic */ InterfaceC0526Fp $leadingIcon;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00711(InterfaceC0526Fp interfaceC0526Fp, ChipColors chipColors, boolean z, int i, InterfaceC0552Gp interfaceC0552Gp) {
                    super(2);
                    this.$leadingIcon = interfaceC0526Fp;
                    this.$colors = chipColors;
                    this.$enabled = z;
                    this.$$dirty = i;
                    this.$content = interfaceC0552Gp;
                }

                private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                    return state.getValue().m3042unboximpl();
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
                        ComposerKt.traceEventStart(-1131213696, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                    }
                    Modifier.Companion companion = Modifier.Companion;
                    Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(SizeKt.m517defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m1037getMinHeightD9Ej5fM(), 1, null), this.$leadingIcon == null ? ChipKt.HorizontalPadding : Dp.m5160constructorimpl(0), 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    InterfaceC0526Fp interfaceC0526Fp = this.$leadingIcon;
                    ChipColors chipColors = this.$colors;
                    boolean z = this.$enabled;
                    int i2 = this.$$dirty;
                    InterfaceC0552Gp interfaceC0552Gp = this.$content;
                    composer.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
                    composer.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    InterfaceC3588op constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composer.startReplaceableGroup(2084788937);
                    if (interfaceC0526Fp != null) {
                        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer, 6);
                        State<Color> stateLeadingIconContentColor = chipColors.leadingIconContentColor(z, composer, ((i2 >> 6) & 14) | ((i2 >> 15) & 112));
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(invoke$lambda$1$lambda$0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(invoke$lambda$1$lambda$0(stateLeadingIconContentColor))))}, interfaceC0526Fp, composer, ((i2 >> 18) & 112) | 8);
                        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer, 6);
                    }
                    composer.endReplaceableGroup();
                    interfaceC0552Gp.invoke(rowScopeInstance, composer, Integer.valueOf(((i2 >> 21) & 112) | 6));
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, ChipColors chipColors, boolean z, int i, InterfaceC0552Gp interfaceC0552Gp) {
                super(2);
                this.$leadingIcon = interfaceC0526Fp;
                this.$colors = chipColors;
                this.$enabled = z;
                this.$$dirty = i;
                this.$content = interfaceC0552Gp;
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
                    ComposerKt.traceEventStart(667535631, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                }
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.composableLambda(composer, -1131213696, true, new C00711(this.$leadingIcon, this.$colors, this.$enabled, this.$$dirty, this.$content)), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(State<Color> state, InterfaceC0526Fp interfaceC0526Fp, ChipColors chipColors, boolean z, int i, InterfaceC0552Gp interfaceC0552Gp) {
            super(2);
            this.$contentColor$delegate = state;
            this.$leadingIcon = interfaceC0526Fp;
            this.$colors = chipColors;
            this.$enabled = z;
            this.$$dirty = i;
            this.$content = interfaceC0552Gp;
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
                ComposerKt.traceEventStart(139076687, i, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(ChipKt.Chip$lambda$1(this.$contentColor$delegate))))}, ComposableLambdaKt.composableLambda(composer, 667535631, true, new AnonymousClass1(this.$leadingIcon, this.$colors, this.$enabled, this.$$dirty, this.$content)), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ ChipColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
            this.$shape = shape;
            this.$border = borderStroke;
            this.$colors = chipColors;
            this.$leadingIcon = interfaceC0526Fp;
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
            ChipKt.Chip(this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$shape, this.$border, this.$colors, this.$leadingIcon, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14152 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14152 INSTANCE = new C14152();

        public C14152() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.m4564setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m4551getCheckboxo7Vup1c());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14163 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ SelectableChipColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ State<Color> $contentColor;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ InterfaceC0526Fp $selectedIcon;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;

        /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ int $$dirty1;
            final /* synthetic */ SelectableChipColors $colors;
            final /* synthetic */ InterfaceC0552Gp $content;
            final /* synthetic */ State<Color> $contentColor;
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ InterfaceC0526Fp $leadingIcon;
            final /* synthetic */ boolean $selected;
            final /* synthetic */ InterfaceC0526Fp $selectedIcon;
            final /* synthetic */ InterfaceC0526Fp $trailingIcon;

            /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00721 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ int $$dirty1;
                final /* synthetic */ SelectableChipColors $colors;
                final /* synthetic */ InterfaceC0552Gp $content;
                final /* synthetic */ State<Color> $contentColor;
                final /* synthetic */ boolean $enabled;
                final /* synthetic */ InterfaceC0526Fp $leadingIcon;
                final /* synthetic */ boolean $selected;
                final /* synthetic */ InterfaceC0526Fp $selectedIcon;
                final /* synthetic */ InterfaceC0526Fp $trailingIcon;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00721(InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0552Gp interfaceC0552Gp, int i, SelectableChipColors selectableChipColors, boolean z2, int i2, State<Color> state) {
                    super(2);
                    this.$leadingIcon = interfaceC0526Fp;
                    this.$selected = z;
                    this.$selectedIcon = interfaceC0526Fp2;
                    this.$trailingIcon = interfaceC0526Fp3;
                    this.$content = interfaceC0552Gp;
                    this.$$dirty1 = i;
                    this.$colors = selectableChipColors;
                    this.$enabled = z2;
                    this.$$dirty = i2;
                    this.$contentColor = state;
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
                    int i2;
                    Modifier modifierClip;
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1543702066, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:213)");
                    }
                    Modifier.Companion companion = Modifier.Companion;
                    Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(SizeKt.m517defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m1037getMinHeightD9Ej5fM(), 1, null), (this.$leadingIcon != null || (this.$selected && this.$selectedIcon != null)) ? Dp.m5160constructorimpl(0) : ChipKt.HorizontalPadding, 0.0f, this.$trailingIcon == null ? ChipKt.HorizontalPadding : Dp.m5160constructorimpl(0), 0.0f, 10, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Companion companion2 = Alignment.Companion;
                    Alignment.Vertical centerVertically = companion2.getCenterVertically();
                    InterfaceC0526Fp interfaceC0526Fp = this.$leadingIcon;
                    boolean z = this.$selected;
                    InterfaceC0526Fp interfaceC0526Fp2 = this.$selectedIcon;
                    InterfaceC0552Gp interfaceC0552Gp = this.$content;
                    int i3 = this.$$dirty1;
                    InterfaceC0526Fp interfaceC0526Fp3 = this.$trailingIcon;
                    SelectableChipColors selectableChipColors = this.$colors;
                    boolean z2 = this.$enabled;
                    int i4 = this.$$dirty;
                    State<Color> state = this.$contentColor;
                    composer.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
                    composer.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    InterfaceC3588op constructor = companion3.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    InterfaceC0526Fp setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composer.startReplaceableGroup(-1943412047);
                    if (interfaceC0526Fp != null || (z && interfaceC0526Fp2 != null)) {
                        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer, 6);
                        composer.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                        InterfaceC3588op constructor2 = companion3.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor2);
                        } else {
                            composer.useNode();
                        }
                        Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
                        Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        InterfaceC0526Fp setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer.startReplaceableGroup(649985685);
                        if (interfaceC0526Fp != null) {
                            State<Color> stateLeadingIconColor = selectableChipColors.leadingIconColor(z2, z, composer, ((i4 >> 9) & 14) | ((i4 << 3) & 112) | ((i4 >> 15) & 896));
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(stateLeadingIconColor.getValue().m3042unboximpl())))}, interfaceC0526Fp, composer, ((i4 >> 21) & 112) | 8);
                        }
                        composer.endReplaceableGroup();
                        composer.startReplaceableGroup(-1943411233);
                        if (z && interfaceC0526Fp2 != null) {
                            long jM3042unboximpl = state.getValue().m3042unboximpl();
                            composer.startReplaceableGroup(649986516);
                            if (interfaceC0526Fp != null) {
                                modifierClip = ClipKt.clip(BackgroundKt.m166backgroundbw27NRU(SizeKt.m524requiredSize3ABfNKs(companion, ChipKt.SelectedIconContainerSize), state.getValue().m3042unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                jM3042unboximpl = selectableChipColors.backgroundColor(z2, z, composer, ((i4 >> 9) & 14) | ((i4 << 3) & 112) | ((i4 >> 15) & 896)).getValue().m3042unboximpl();
                            } else {
                                modifierClip = companion;
                            }
                            composer.endReplaceableGroup();
                            Alignment center = companion2.getCenter();
                            composer.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
                            composer.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                            InterfaceC3588op constructor3 = companion3.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierClip);
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor3);
                            } else {
                                composer.useNode();
                            }
                            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer);
                            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                            InterfaceC0526Fp setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                            composer.startReplaceableGroup(2058660585);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM3042unboximpl))}, interfaceC0526Fp2, composer, ((i4 >> 24) & 112) | 8);
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                        }
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        i2 = 6;
                        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer, 6);
                    } else {
                        i2 = 6;
                    }
                    composer.endReplaceableGroup();
                    interfaceC0552Gp.invoke(rowScopeInstance, composer, Integer.valueOf((i3 & 112) | i2));
                    composer.startReplaceableGroup(-1181292829);
                    if (interfaceC0526Fp3 != null) {
                        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer, i2);
                        interfaceC0526Fp3.mo13invoke(composer, Integer.valueOf(i3 & 14));
                        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer, i2);
                    }
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0552Gp interfaceC0552Gp, int i, SelectableChipColors selectableChipColors, boolean z2, int i2, State<Color> state) {
                super(2);
                this.$leadingIcon = interfaceC0526Fp;
                this.$selected = z;
                this.$selectedIcon = interfaceC0526Fp2;
                this.$trailingIcon = interfaceC0526Fp3;
                this.$content = interfaceC0552Gp;
                this.$$dirty1 = i;
                this.$colors = selectableChipColors;
                this.$enabled = z2;
                this.$$dirty = i2;
                this.$contentColor = state;
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
                    ComposerKt.traceEventStart(1582291359, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:210)");
                }
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.composableLambda(composer, -1543702066, true, new C00721(this.$leadingIcon, this.$selected, this.$selectedIcon, this.$trailingIcon, this.$content, this.$$dirty1, this.$colors, this.$enabled, this.$$dirty, this.$contentColor)), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14163(State<Color> state, InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0552Gp interfaceC0552Gp, int i, SelectableChipColors selectableChipColors, boolean z2, int i2) {
            super(2);
            this.$contentColor = state;
            this.$leadingIcon = interfaceC0526Fp;
            this.$selected = z;
            this.$selectedIcon = interfaceC0526Fp2;
            this.$trailingIcon = interfaceC0526Fp3;
            this.$content = interfaceC0552Gp;
            this.$$dirty1 = i;
            this.$colors = selectableChipColors;
            this.$enabled = z2;
            this.$$dirty = i2;
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
                ComposerKt.traceEventStart(722126431, i, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:209)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(this.$contentColor.getValue().m3042unboximpl())))}, ComposableLambdaKt.composableLambda(composer, 1582291359, true, new AnonymousClass1(this.$leadingIcon, this.$selected, this.$selectedIcon, this.$trailingIcon, this.$content, this.$$dirty1, this.$colors, this.$enabled, this.$$dirty, this.$contentColor)), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$4, reason: invalid class name and case insensitive filesystem */
    public static final class C14174 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ SelectableChipColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ InterfaceC0526Fp $selectedIcon;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14174(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0552Gp interfaceC0552Gp, int i, int i2, int i3) {
            super(2);
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$interactionSource = mutableInteractionSource;
            this.$shape = shape;
            this.$border = borderStroke;
            this.$colors = selectableChipColors;
            this.$leadingIcon = interfaceC0526Fp;
            this.$selectedIcon = interfaceC0526Fp2;
            this.$trailingIcon = interfaceC0526Fp3;
            this.$content = interfaceC0552Gp;
            this.$$changed = i;
            this.$$changed1 = i2;
            this.$$default = i3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            ChipKt.FilterChip(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$shape, this.$border, this.$colors, this.$leadingIcon, this.$selectedIcon, this.$trailingIcon, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    static {
        float f = 8;
        LeadingIconEndSpacing = Dp.m5160constructorimpl(f);
        TrailingIconSpacing = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0136  */
    /* JADX WARN: Code duplicated, block: B:106:0x0141  */
    /* JADX WARN: Code duplicated, block: B:116:0x0169 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x016b  */
    /* JADX WARN: Code duplicated, block: B:118:0x016e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0172  */
    /* JADX WARN: Code duplicated, block: B:121:0x0174  */
    /* JADX WARN: Code duplicated, block: B:123:0x0178  */
    /* JADX WARN: Code duplicated, block: B:125:0x018a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0197  */
    /* JADX WARN: Code duplicated, block: B:130:0x019c  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:139:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:147:0x0299  */
    /* JADX WARN: Code duplicated, block: B:152:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:92:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x010e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0111  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void Chip(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Shape shape2;
        int i8;
        BorderStroke borderStroke2;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier2;
        boolean z2;
        MutableInteractionSource mutableInteractionSource3;
        Shape shapeCopy;
        ChipColors chipColorsM1034chipColors5tl4gsc;
        InterfaceC0526Fp interfaceC0526Fp2;
        Modifier modifier3;
        Object objRememberedValue;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        BorderStroke borderStroke3;
        InterfaceC0526Fp interfaceC0526Fp3;
        ChipColors chipColors2;
        boolean z3;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-368396408);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            int i15 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i3 |= i15;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((458752 & i) == 0) {
                            borderStroke2 = borderStroke;
                            if (composerStartRestartGroup.changed(borderStroke2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((i & 3670016) != 0) {
                            if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(chipColors)) {
                                i13 = 524288;
                            } else {
                                i13 = 1048576;
                            }
                            i3 |= i13;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 256) != 0) {
                            if ((i & 234881024) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                    i12 = 67108864;
                                } else {
                                    i12 = 33554432;
                                }
                            }
                            if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i14 != 0) {
                                        modifier2 = Modifier.Companion;
                                    } else {
                                        modifier2 = modifier;
                                    }
                                    if (i4 != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = z;
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
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    }
                                    if ((i2 & 16) != 0) {
                                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                        i3 &= -57345;
                                    } else {
                                        shapeCopy = shape2;
                                    }
                                    if (i8 != 0) {
                                        borderStroke2 = null;
                                    }
                                    if ((i2 & 64) != 0) {
                                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                        i3 &= -3670017;
                                    } else {
                                        chipColorsM1034chipColors5tl4gsc = chipColors;
                                    }
                                    if (i10 != 0) {
                                        interfaceC0526Fp2 = null;
                                    } else {
                                        interfaceC0526Fp2 = interfaceC0526Fp;
                                    }
                                    modifier3 = modifier2;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    z2 = z;
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shapeCopy = shape2;
                                    borderStroke2 = borderStroke2;
                                    modifier3 = modifier;
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                                }
                                int i16 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                                State<Color> stateContentColor = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i16);
                                ChipColors chipColors3 = chipColorsM1034chipColors5tl4gsc;
                                boolean z4 = z2;
                                Modifier modifier5 = modifier3;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i16).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource4 = mutableInteractionSource3;
                                shape3 = shapeCopy;
                                borderStroke3 = borderStroke2;
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                                chipColors2 = chipColors3;
                                z3 = z4;
                                modifier4 = modifier5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier4 = modifier;
                                z3 = z;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                shape3 = shape2;
                                borderStroke3 = borderStroke2;
                                composer2 = composerStartRestartGroup;
                                chipColors2 = chipColors;
                                interfaceC0526Fp3 = interfaceC0526Fp;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                        }
                        i12 = 100663296;
                        i3 |= i12;
                        if ((191739611 & i3) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i17 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor2 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i17);
                            ChipColors chipColors4 = chipColorsM1034chipColors5tl4gsc;
                            boolean z5 = z2;
                            Modifier modifier6 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i17).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor2, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors4;
                            z3 = z5;
                            modifier4 = modifier6;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i18 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor3 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i18);
                            ChipColors chipColors5 = chipColorsM1034chipColors5tl4gsc;
                            boolean z6 = z2;
                            Modifier modifier7 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i18).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor3), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor3, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors5;
                            z3 = z6;
                            modifier4 = modifier7;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    borderStroke2 = borderStroke;
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i13 = 524288;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i19 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor4 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i19);
                            ChipColors chipColors6 = chipColorsM1034chipColors5tl4gsc;
                            boolean z7 = z2;
                            Modifier modifier8 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i19).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor4), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor4, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors6;
                            z3 = z7;
                            modifier4 = modifier8;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor5 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i110);
                            ChipColors chipColors7 = chipColorsM1034chipColors5tl4gsc;
                            boolean z8 = z2;
                            Modifier modifier9 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i110).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor5), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor5, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors7;
                            z3 = z8;
                            modifier4 = modifier9;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                    }
                    i12 = 100663296;
                    i3 |= i12;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor6 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111);
                        ChipColors chipColors8 = chipColorsM1034chipColors5tl4gsc;
                        boolean z9 = z2;
                        Modifier modifier10 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor6, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors8;
                        z3 = z9;
                        modifier4 = modifier10;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor7 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i112);
                        ChipColors chipColors9 = chipColorsM1034chipColors5tl4gsc;
                        boolean z10 = z2;
                        Modifier modifier11 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor7), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor7, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors9;
                        z3 = z10;
                        modifier4 = modifier11;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i3 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((458752 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i13 = 524288;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor8 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i113);
                            ChipColors chipColors10 = chipColorsM1034chipColors5tl4gsc;
                            boolean z11 = z2;
                            Modifier modifier12 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i113).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor8), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor8, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors10;
                            z3 = z11;
                            modifier4 = modifier12;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor9 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i114);
                            ChipColors chipColors11 = chipColorsM1034chipColors5tl4gsc;
                            boolean z12 = z2;
                            Modifier modifier13 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i114).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor9), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor9, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors11;
                            z3 = z12;
                            modifier4 = modifier13;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                    }
                    i12 = 100663296;
                    i3 |= i12;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor10 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i115);
                        ChipColors chipColors12 = chipColorsM1034chipColors5tl4gsc;
                        boolean z13 = z2;
                        Modifier modifier14 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i115).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor10), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor10, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors12;
                        z3 = z13;
                        modifier4 = modifier14;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor11 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i116);
                        ChipColors chipColors13 = chipColorsM1034chipColors5tl4gsc;
                        boolean z14 = z2;
                        Modifier modifier15 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i116).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors13;
                        z3 = z14;
                        modifier4 = modifier15;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                borderStroke2 = borderStroke;
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor12 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i117);
                        ChipColors chipColors14 = chipColorsM1034chipColors5tl4gsc;
                        boolean z15 = z2;
                        Modifier modifier16 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i117).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor12), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor12, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors14;
                        z3 = z15;
                        modifier4 = modifier16;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor13 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i118);
                        ChipColors chipColors15 = chipColorsM1034chipColors5tl4gsc;
                        boolean z16 = z2;
                        Modifier modifier17 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i118).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor13), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor13, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors15;
                        z3 = z16;
                        modifier4 = modifier17;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i12 = 100663296;
                i3 |= i12;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i119 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor14 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i119);
                    ChipColors chipColors16 = chipColorsM1034chipColors5tl4gsc;
                    boolean z17 = z2;
                    Modifier modifier18 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i119).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor14), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor14, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors16;
                    z3 = z17;
                    modifier4 = modifier18;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor15 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1110);
                    ChipColors chipColors17 = chipColorsM1034chipColors5tl4gsc;
                    boolean z18 = z2;
                    Modifier modifier19 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1110).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor15), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor15, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors17;
                    z3 = z18;
                    modifier4 = modifier19;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((458752 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i13 = 524288;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i1111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor16 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111);
                            ChipColors chipColors18 = chipColorsM1034chipColors5tl4gsc;
                            boolean z19 = z2;
                            Modifier modifier110 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor16), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor16, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors18;
                            z3 = z19;
                            modifier4 = modifier110;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i1112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor17 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1112);
                            ChipColors chipColors19 = chipColorsM1034chipColors5tl4gsc;
                            boolean z110 = z2;
                            Modifier modifier111 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor17), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor17, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors19;
                            z3 = z110;
                            modifier4 = modifier111;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                    }
                    i12 = 100663296;
                    i3 |= i12;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor18 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1113);
                        ChipColors chipColors110 = chipColorsM1034chipColors5tl4gsc;
                        boolean z111 = z2;
                        Modifier modifier112 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1113).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor18), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor18, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors110;
                        z3 = z111;
                        modifier4 = modifier112;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor19 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1114);
                        ChipColors chipColors111 = chipColorsM1034chipColors5tl4gsc;
                        boolean z112 = z2;
                        Modifier modifier113 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1114).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor19), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor19, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors111;
                        z3 = z112;
                        modifier4 = modifier113;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                borderStroke2 = borderStroke;
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor110 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1115);
                        ChipColors chipColors112 = chipColorsM1034chipColors5tl4gsc;
                        boolean z113 = z2;
                        Modifier modifier114 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1115).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor110, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors112;
                        z3 = z113;
                        modifier4 = modifier114;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor111 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1116);
                        ChipColors chipColors113 = chipColorsM1034chipColors5tl4gsc;
                        boolean z114 = z2;
                        Modifier modifier115 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1116).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors113;
                        z3 = z114;
                        modifier4 = modifier115;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i12 = 100663296;
                i3 |= i12;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor112 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1117);
                    ChipColors chipColors114 = chipColorsM1034chipColors5tl4gsc;
                    boolean z115 = z2;
                    Modifier modifier116 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1117).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor112, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors114;
                    z3 = z115;
                    modifier4 = modifier116;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor113 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1118);
                    ChipColors chipColors115 = chipColorsM1034chipColors5tl4gsc;
                    boolean z116 = z2;
                    Modifier modifier117 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1118).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor113, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors115;
                    z3 = z116;
                    modifier4 = modifier117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((458752 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1119 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor114 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1119);
                        ChipColors chipColors116 = chipColorsM1034chipColors5tl4gsc;
                        boolean z117 = z2;
                        Modifier modifier118 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1119).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor114, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors116;
                        z3 = z117;
                        modifier4 = modifier118;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i11110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor115 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11110);
                        ChipColors chipColors117 = chipColorsM1034chipColors5tl4gsc;
                        boolean z118 = z2;
                        Modifier modifier119 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11110).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor115, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors117;
                        z3 = z118;
                        modifier4 = modifier119;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i12 = 100663296;
                i3 |= i12;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i11111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor116 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111);
                    ChipColors chipColors118 = chipColorsM1034chipColors5tl4gsc;
                    boolean z119 = z2;
                    Modifier modifier1110 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor116, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors118;
                    z3 = z119;
                    modifier4 = modifier1110;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i11112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor117 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11112);
                    ChipColors chipColors119 = chipColorsM1034chipColors5tl4gsc;
                    boolean z1110 = z2;
                    Modifier modifier1111 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor117, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors119;
                    z3 = z1110;
                    modifier4 = modifier1111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke2 = borderStroke;
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i11113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor118 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11113);
                    ChipColors chipColors1110 = chipColorsM1034chipColors5tl4gsc;
                    boolean z1111 = z2;
                    Modifier modifier1112 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11113).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor118, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors1110;
                    z3 = z1111;
                    modifier4 = modifier1112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i11114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor119 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11114);
                    ChipColors chipColors1111 = chipColorsM1034chipColors5tl4gsc;
                    boolean z1112 = z2;
                    Modifier modifier1113 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11114).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor119, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors1111;
                    z3 = z1112;
                    modifier4 = modifier1113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i12 = 100663296;
            i3 |= i12;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor1110 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11115);
                ChipColors chipColors1112 = chipColorsM1034chipColors5tl4gsc;
                boolean z1113 = z2;
                Modifier modifier1114 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11115).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1110, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors1112;
                z3 = z1113;
                modifier4 = modifier1114;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor1111 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11116);
                ChipColors chipColors1113 = chipColorsM1034chipColors5tl4gsc;
                boolean z1114 = z2;
                Modifier modifier1115 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11116).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1111, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors1113;
                z3 = z1114;
                modifier4 = modifier1115;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((458752 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i13 = 524288;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i11117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor1112 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11117);
                            ChipColors chipColors1114 = chipColorsM1034chipColors5tl4gsc;
                            boolean z1115 = z2;
                            Modifier modifier1116 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11117).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1112, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors1114;
                            z3 = z1115;
                            modifier4 = modifier1116;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    shapeCopy = shape2;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    chipColorsM1034chipColors5tl4gsc = chipColors;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp2 = null;
                                } else {
                                    interfaceC0526Fp2 = interfaceC0526Fp;
                                }
                                modifier3 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                            }
                            int i11118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            State<Color> stateContentColor1113 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11118);
                            ChipColors chipColors1115 = chipColorsM1034chipColors5tl4gsc;
                            boolean z1116 = z2;
                            Modifier modifier1117 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11118).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1113, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape3 = shapeCopy;
                            borderStroke3 = borderStroke2;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            chipColors2 = chipColors1115;
                            z3 = z1116;
                            modifier4 = modifier1117;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                    }
                    i12 = 100663296;
                    i3 |= i12;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i11119 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor1114 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11119);
                        ChipColors chipColors1116 = chipColorsM1034chipColors5tl4gsc;
                        boolean z1117 = z2;
                        Modifier modifier1118 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11119).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1114, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors1116;
                        z3 = z1117;
                        modifier4 = modifier1118;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i111110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor1115 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111110);
                        ChipColors chipColors1117 = chipColorsM1034chipColors5tl4gsc;
                        boolean z1118 = z2;
                        Modifier modifier1119 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111110).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1115, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors1117;
                        z3 = z1118;
                        modifier4 = modifier1119;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                borderStroke2 = borderStroke;
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i111111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor1116 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111111);
                        ChipColors chipColors1118 = chipColorsM1034chipColors5tl4gsc;
                        boolean z1119 = z2;
                        Modifier modifier11110 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111111).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1116, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors1118;
                        z3 = z1119;
                        modifier4 = modifier11110;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i111112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor1117 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111112);
                        ChipColors chipColors1119 = chipColorsM1034chipColors5tl4gsc;
                        boolean z11110 = z2;
                        Modifier modifier11111 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1117, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors1119;
                        z3 = z11110;
                        modifier4 = modifier11111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i12 = 100663296;
                i3 |= i12;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i111113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor1118 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111113);
                    ChipColors chipColors11110 = chipColorsM1034chipColors5tl4gsc;
                    boolean z11111 = z2;
                    Modifier modifier11112 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111113).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1118, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors11110;
                    z3 = z11111;
                    modifier4 = modifier11112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i111114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor1119 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111114);
                    ChipColors chipColors11111 = chipColorsM1034chipColors5tl4gsc;
                    boolean z11112 = z2;
                    Modifier modifier11113 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111114).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1119, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors11111;
                    z3 = z11112;
                    modifier4 = modifier11113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((458752 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i111115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor11110 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111115);
                        ChipColors chipColors11112 = chipColorsM1034chipColors5tl4gsc;
                        boolean z11113 = z2;
                        Modifier modifier11114 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111115).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11110, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors11112;
                        z3 = z11113;
                        modifier4 = modifier11114;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i111116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor11111 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111116);
                        ChipColors chipColors11113 = chipColorsM1034chipColors5tl4gsc;
                        boolean z11114 = z2;
                        Modifier modifier11115 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111116).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11111, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors11113;
                        z3 = z11114;
                        modifier4 = modifier11115;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i12 = 100663296;
                i3 |= i12;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i111117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor11112 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111117);
                    ChipColors chipColors11114 = chipColorsM1034chipColors5tl4gsc;
                    boolean z11115 = z2;
                    Modifier modifier11116 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111117).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11112, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors11114;
                    z3 = z11115;
                    modifier4 = modifier11116;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i111118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor11113 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111118);
                    ChipColors chipColors11115 = chipColorsM1034chipColors5tl4gsc;
                    boolean z11116 = z2;
                    Modifier modifier11117 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111118).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11113, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors11115;
                    z3 = z11116;
                    modifier4 = modifier11117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke2 = borderStroke;
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i111119 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor11114 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i111119);
                    ChipColors chipColors11116 = chipColorsM1034chipColors5tl4gsc;
                    boolean z11117 = z2;
                    Modifier modifier11118 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i111119).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11114, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors11116;
                    z3 = z11117;
                    modifier4 = modifier11118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1111110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor11115 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111110);
                    ChipColors chipColors11117 = chipColorsM1034chipColors5tl4gsc;
                    boolean z11118 = z2;
                    Modifier modifier11119 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111110).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11115, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors11117;
                    z3 = z11118;
                    modifier4 = modifier11119;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i12 = 100663296;
            i3 |= i12;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i1111111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor11116 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111111);
                ChipColors chipColors11118 = chipColorsM1034chipColors5tl4gsc;
                boolean z11119 = z2;
                Modifier modifier111110 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111111).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11116, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors11118;
                z3 = z11119;
                modifier4 = modifier111110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i1111112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor11117 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111112);
                ChipColors chipColors11119 = chipColorsM1034chipColors5tl4gsc;
                boolean z111110 = z2;
                Modifier modifier111111 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11117, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors11119;
                z3 = z111110;
                modifier4 = modifier111111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((458752 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1111113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor11118 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111113);
                        ChipColors chipColors111110 = chipColorsM1034chipColors5tl4gsc;
                        boolean z111111 = z2;
                        Modifier modifier111112 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111113).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11118, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors111110;
                        z3 = z111111;
                        modifier4 = modifier111112;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                shapeCopy = shape2;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                chipColorsM1034chipColors5tl4gsc = chipColors;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp2 = null;
                            } else {
                                interfaceC0526Fp2 = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                        }
                        int i1111114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        State<Color> stateContentColor11119 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111114);
                        ChipColors chipColors111111 = chipColorsM1034chipColors5tl4gsc;
                        boolean z111112 = z2;
                        Modifier modifier111113 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111114).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor11119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor11119, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shapeCopy;
                        borderStroke3 = borderStroke2;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        chipColors2 = chipColors111111;
                        z3 = z111112;
                        modifier4 = modifier111113;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
                }
                i12 = 100663296;
                i3 |= i12;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1111115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor111110 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111115);
                    ChipColors chipColors111112 = chipColorsM1034chipColors5tl4gsc;
                    boolean z111113 = z2;
                    Modifier modifier111114 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111115).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111110, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors111112;
                    z3 = z111113;
                    modifier4 = modifier111114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1111116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor111111 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111116);
                    ChipColors chipColors111113 = chipColorsM1034chipColors5tl4gsc;
                    boolean z111114 = z2;
                    Modifier modifier111115 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111116).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111111, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors111113;
                    z3 = z111114;
                    modifier4 = modifier111115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke2 = borderStroke;
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1111117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor111112 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111117);
                    ChipColors chipColors111114 = chipColorsM1034chipColors5tl4gsc;
                    boolean z111115 = z2;
                    Modifier modifier111116 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111117).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111112, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors111114;
                    z3 = z111115;
                    modifier4 = modifier111116;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i1111118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor111113 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111118);
                    ChipColors chipColors111115 = chipColorsM1034chipColors5tl4gsc;
                    boolean z111116 = z2;
                    Modifier modifier111117 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111118).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111113, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors111115;
                    z3 = z111116;
                    modifier4 = modifier111117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i12 = 100663296;
            i3 |= i12;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i1111119 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor111114 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i1111119);
                ChipColors chipColors111116 = chipColorsM1034chipColors5tl4gsc;
                boolean z111117 = z2;
                Modifier modifier111118 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i1111119).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111114, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors111116;
                z3 = z111117;
                modifier4 = modifier111118;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11111110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor111115 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111110);
                ChipColors chipColors111117 = chipColorsM1034chipColors5tl4gsc;
                boolean z111118 = z2;
                Modifier modifier111119 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111110).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111115, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors111117;
                z3 = z111118;
                modifier4 = modifier111119;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i3 |= i15;
        } else {
            shape2 = shape;
        }
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((458752 & i) == 0) {
                borderStroke2 = borderStroke;
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i11111111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor111116 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111111);
                    ChipColors chipColors111118 = chipColorsM1034chipColors5tl4gsc;
                    boolean z111119 = z2;
                    Modifier modifier1111110 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111111).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111116, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors111118;
                    z3 = z111119;
                    modifier4 = modifier1111110;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            shapeCopy = shape2;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        }
                        if ((i2 & 64) != 0) {
                            chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            chipColorsM1034chipColors5tl4gsc = chipColors;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp2 = null;
                        } else {
                            interfaceC0526Fp2 = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                    }
                    int i11111112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    State<Color> stateContentColor111117 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111112);
                    ChipColors chipColors111119 = chipColorsM1034chipColors5tl4gsc;
                    boolean z1111110 = z2;
                    Modifier modifier1111111 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111117, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    chipColors2 = chipColors111119;
                    z3 = z1111110;
                    modifier4 = modifier1111111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
            }
            i12 = 100663296;
            i3 |= i12;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11111113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor111118 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111113);
                ChipColors chipColors1111110 = chipColorsM1034chipColors5tl4gsc;
                boolean z1111111 = z2;
                Modifier modifier1111112 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111113).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111118, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors1111110;
                z3 = z1111111;
                modifier4 = modifier1111112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11111114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor111119 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111114);
                ChipColors chipColors1111111 = chipColorsM1034chipColors5tl4gsc;
                boolean z1111112 = z2;
                Modifier modifier1111113 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111114).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor111119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor111119, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors1111111;
                z3 = z1111112;
                modifier4 = modifier1111113;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        borderStroke2 = borderStroke;
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i13 = 524288;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i2 & 256) != 0) {
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11111115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor1111110 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111115);
                ChipColors chipColors1111112 = chipColorsM1034chipColors5tl4gsc;
                boolean z1111113 = z2;
                Modifier modifier1111114 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111115).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1111110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1111110, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors1111112;
                z3 = z1111113;
                modifier4 = modifier1111114;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        shapeCopy = shape2;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    }
                    if ((i2 & 64) != 0) {
                        chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        chipColorsM1034chipColors5tl4gsc = chipColors;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp2 = null;
                    } else {
                        interfaceC0526Fp2 = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                int i11111116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                State<Color> stateContentColor1111111 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111116);
                ChipColors chipColors1111113 = chipColorsM1034chipColors5tl4gsc;
                boolean z1111114 = z2;
                Modifier modifier1111115 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111116).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1111111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1111111, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp3 = interfaceC0526Fp2;
                chipColors2 = chipColors1111113;
                z3 = z1111114;
                modifier4 = modifier1111115;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
        }
        i12 = 100663296;
        i3 |= i12;
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -57345;
                } else {
                    shapeCopy = shape2;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                }
                if ((i2 & 64) != 0) {
                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    chipColorsM1034chipColors5tl4gsc = chipColors;
                }
                if (i10 != 0) {
                    interfaceC0526Fp2 = null;
                } else {
                    interfaceC0526Fp2 = interfaceC0526Fp;
                }
                modifier3 = modifier2;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -57345;
                } else {
                    shapeCopy = shape2;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                }
                if ((i2 & 64) != 0) {
                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    chipColorsM1034chipColors5tl4gsc = chipColors;
                }
                if (i10 != 0) {
                    interfaceC0526Fp2 = null;
                } else {
                    interfaceC0526Fp2 = interfaceC0526Fp;
                }
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
            }
            int i11111117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
            State<Color> stateContentColor1111112 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111117);
            ChipColors chipColors1111114 = chipColorsM1034chipColors5tl4gsc;
            boolean z1111115 = z2;
            Modifier modifier1111116 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111117).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1111112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1111112, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource4 = mutableInteractionSource3;
            shape3 = shapeCopy;
            borderStroke3 = borderStroke2;
            interfaceC0526Fp3 = interfaceC0526Fp2;
            chipColors2 = chipColors1111114;
            z3 = z1111115;
            modifier4 = modifier1111116;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -57345;
                } else {
                    shapeCopy = shape2;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                }
                if ((i2 & 64) != 0) {
                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    chipColorsM1034chipColors5tl4gsc = chipColors;
                }
                if (i10 != 0) {
                    interfaceC0526Fp2 = null;
                } else {
                    interfaceC0526Fp2 = interfaceC0526Fp;
                }
                modifier3 = modifier2;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -57345;
                } else {
                    shapeCopy = shape2;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                }
                if ((i2 & 64) != 0) {
                    chipColorsM1034chipColors5tl4gsc = ChipDefaults.INSTANCE.m1034chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    chipColorsM1034chipColors5tl4gsc = chipColors;
                }
                if (i10 != 0) {
                    interfaceC0526Fp2 = null;
                } else {
                    interfaceC0526Fp2 = interfaceC0526Fp;
                }
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:87)");
            }
            int i11111118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
            State<Color> stateContentColor1111113 = chipColorsM1034chipColors5tl4gsc.contentColor(z2, composerStartRestartGroup, i11111118);
            ChipColors chipColors1111115 = chipColorsM1034chipColors5tl4gsc;
            boolean z1111116 = z2;
            Modifier modifier1111117 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, 1, null), z2, shapeCopy, chipColorsM1034chipColors5tl4gsc.backgroundColor(z2, composerStartRestartGroup, i11111118).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(Chip$lambda$1(stateContentColor1111113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 139076687, true, new AnonymousClass3(stateContentColor1111113, interfaceC0526Fp2, chipColorsM1034chipColors5tl4gsc, z2, i3, interfaceC0552Gp)), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource4 = mutableInteractionSource3;
            shape3 = shapeCopy;
            borderStroke3 = borderStroke2;
            interfaceC0526Fp3 = interfaceC0526Fp2;
            chipColors2 = chipColors1111115;
            z3 = z1111116;
            modifier4 = modifier1111117;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z3, mutableInteractionSource4, shape3, borderStroke3, chipColors2, interfaceC0526Fp3, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Chip$lambda$1(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0134  */
    /* JADX WARN: Code duplicated, block: B:104:0x0137  */
    /* JADX WARN: Code duplicated, block: B:108:0x013f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0144  */
    /* JADX WARN: Code duplicated, block: B:111:0x014a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0150  */
    /* JADX WARN: Code duplicated, block: B:114:0x0153  */
    /* JADX WARN: Code duplicated, block: B:116:0x0158  */
    /* JADX WARN: Code duplicated, block: B:119:0x015e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0161  */
    /* JADX WARN: Code duplicated, block: B:122:0x0165  */
    /* JADX WARN: Code duplicated, block: B:124:0x016b  */
    /* JADX WARN: Code duplicated, block: B:125:0x016e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0173  */
    /* JADX WARN: Code duplicated, block: B:130:0x017f  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:149:0x01db  */
    /* JADX WARN: Code duplicated, block: B:150:0x01de  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:156:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:158:0x0204  */
    /* JADX WARN: Code duplicated, block: B:161:0x020a  */
    /* JADX WARN: Code duplicated, block: B:162:0x0222  */
    /* JADX WARN: Code duplicated, block: B:164:0x0226  */
    /* JADX WARN: Code duplicated, block: B:165:0x0228  */
    /* JADX WARN: Code duplicated, block: B:168:0x0230  */
    /* JADX WARN: Code duplicated, block: B:169:0x0254  */
    /* JADX WARN: Code duplicated, block: B:171:0x0258  */
    /* JADX WARN: Code duplicated, block: B:172:0x025a  */
    /* JADX WARN: Code duplicated, block: B:174:0x025e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0260  */
    /* JADX WARN: Code duplicated, block: B:177:0x0264  */
    /* JADX WARN: Code duplicated, block: B:179:0x0276  */
    /* JADX WARN: Code duplicated, block: B:182:0x028d  */
    /* JADX WARN: Code duplicated, block: B:185:0x0346  */
    /* JADX WARN: Code duplicated, block: B:190:0x0362  */
    /* JADX WARN: Code duplicated, block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:89:0x0106  */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0114  */
    /* JADX WARN: Code duplicated, block: B:94:0x0117  */
    /* JADX WARN: Code duplicated, block: B:98:0x0121  */
    /* JADX WARN: Code duplicated, block: B:99:0x0128  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void FilterChip(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource2;
        Shape shapeCopy;
        BorderStroke borderStroke2;
        SelectableChipColors selectableChipColorsM1035filterChipColorsJ08w3E;
        InterfaceC0526Fp interfaceC0526Fp4;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        Modifier modifier3;
        SelectableChipColors selectableChipColors2;
        int i20;
        Object objRememberedValue;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape2;
        BorderStroke borderStroke3;
        InterfaceC0526Fp interfaceC0526Fp7;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        SelectableChipColors selectableChipColors3;
        boolean z4;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i21;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1259208246);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        int i22 = i3 & 4;
        if (i22 == 0) {
            if ((i & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    i4 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & 458752) != 0) {
                    if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(shape)) {
                        i21 = 65536;
                    } else {
                        i21 = 131072;
                    }
                    i4 |= i21;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i & 29360128) != 0) {
                    i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(selectableChipColors)) ? 4194304 : 8388608;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i18 = i16 | 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i19 = 32;
                    } else {
                        i19 = 16;
                    }
                    i18 = i16 | i19;
                } else {
                    i18 = i16;
                }
                if ((i4 & 1533916891) != 306783378 && (i18 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    mutableInteractionSource3 = mutableInteractionSource;
                    shape2 = shape;
                    borderStroke3 = borderStroke;
                    selectableChipColors3 = selectableChipColors;
                    interfaceC0526Fp8 = interfaceC0526Fp2;
                    interfaceC0526Fp9 = interfaceC0526Fp3;
                    composer2 = composerStartRestartGroup;
                    z4 = z3;
                    interfaceC0526Fp7 = interfaceC0526Fp;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        Modifier modifier5 = modifier2;
                        if ((i3 & 128) != 0) {
                            selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                            i4 &= -29360129;
                        } else {
                            selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp5 = null;
                        } else {
                            interfaceC0526Fp5 = interfaceC0526Fp2;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp3;
                        }
                        modifier3 = modifier5;
                        selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                        i20 = i4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        modifier3 = modifier;
                        mutableInteractionSource2 = mutableInteractionSource;
                        shapeCopy = shape;
                        borderStroke2 = borderStroke;
                        selectableChipColors2 = selectableChipColors;
                        interfaceC0526Fp4 = interfaceC0526Fp;
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                        i20 = i4;
                        z3 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
                    }
                    int i23 = i20 << 3;
                    int i24 = ((i20 >> 9) & 14) | (i23 & 112) | ((i20 >> 15) & 896);
                    State<Color> stateContentColor = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i24);
                    int i25 = i20;
                    SelectableChipColors selectableChipColors4 = selectableChipColors2;
                    boolean z5 = z3;
                    Modifier modifier6 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z5, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i24).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors4, z5, i25)), composerStartRestartGroup, (i25 & 7294) | ((i25 >> 3) & 57344) | (i23 & 29360128) | ((i25 << 15) & 1879048192), 6, 256);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    borderStroke3 = borderStroke2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    interfaceC0526Fp8 = interfaceC0526Fp5;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    selectableChipColors3 = selectableChipColors4;
                    z4 = z5;
                    modifier4 = modifier6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14174(z, interfaceC3588op, modifier4, z4, mutableInteractionSource3, shape2, borderStroke3, selectableChipColors3, interfaceC0526Fp7, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0552Gp, i, i2, i3));
            }
            i4 |= 3072;
            z3 = z2;
            i7 = i3 & 16;
            if (i7 != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i21 = 65536;
                } else {
                    i21 = 65536;
                }
                i4 |= i21;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i & 29360128) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(selectableChipColors)) ? 4194304 : 8388608;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i3 & 2048) != 0) {
                i18 = i16 | 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i18 = i16 | i19;
            } else {
                i18 = i16;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier7 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier7;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier8 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier8;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
                }
                int i26 = i20 << 3;
                int i27 = ((i20 >> 9) & 14) | (i26 & 112) | ((i20 >> 15) & 896);
                State<Color> stateContentColor2 = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i27);
                int i28 = i20;
                SelectableChipColors selectableChipColors5 = selectableChipColors2;
                boolean z6 = z3;
                Modifier modifier9 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z6, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i27).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor2.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor2, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors5, z6, i28)), composerStartRestartGroup, (i28 & 7294) | ((i28 >> 3) & 57344) | (i26 & 29360128) | ((i28 << 15) & 1879048192), 6, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                interfaceC0526Fp8 = interfaceC0526Fp5;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                selectableChipColors3 = selectableChipColors5;
                z4 = z6;
                modifier4 = modifier9;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier10 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier10;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier11 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier11;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
                }
                int i29 = i20 << 3;
                int i210 = ((i20 >> 9) & 14) | (i29 & 112) | ((i20 >> 15) & 896);
                State<Color> stateContentColor3 = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i210);
                int i211 = i20;
                SelectableChipColors selectableChipColors6 = selectableChipColors2;
                boolean z7 = z3;
                Modifier modifier12 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z7, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i210).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor3.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor3, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors6, z7, i211)), composerStartRestartGroup, (i211 & 7294) | ((i211 >> 3) & 57344) | (i29 & 29360128) | ((i211 << 15) & 1879048192), 6, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                interfaceC0526Fp8 = interfaceC0526Fp5;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                selectableChipColors3 = selectableChipColors6;
                z4 = z7;
                modifier4 = modifier12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14174(z, interfaceC3588op, modifier4, z4, mutableInteractionSource3, shape2, borderStroke3, selectableChipColors3, interfaceC0526Fp7, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0552Gp, i, i2, i3));
        }
        i4 |= 384;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i21 = 65536;
                } else {
                    i21 = 65536;
                }
                i4 |= i21;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i & 29360128) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(selectableChipColors)) ? 4194304 : 8388608;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i3 & 2048) != 0) {
                i18 = i16 | 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i18 = i16 | i19;
            } else {
                i18 = i16;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier13 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier13;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier14 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier14;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
                }
                int i212 = i20 << 3;
                int i213 = ((i20 >> 9) & 14) | (i212 & 112) | ((i20 >> 15) & 896);
                State<Color> stateContentColor4 = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i213);
                int i214 = i20;
                SelectableChipColors selectableChipColors7 = selectableChipColors2;
                boolean z8 = z3;
                Modifier modifier15 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z8, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i213).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor4.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor4, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors7, z8, i214)), composerStartRestartGroup, (i214 & 7294) | ((i214 >> 3) & 57344) | (i212 & 29360128) | ((i214 << 15) & 1879048192), 6, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                interfaceC0526Fp8 = interfaceC0526Fp5;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                selectableChipColors3 = selectableChipColors7;
                z4 = z8;
                modifier4 = modifier15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier16 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier16;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    Modifier modifier17 = modifier2;
                    if ((i3 & 128) != 0) {
                        selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                        i4 &= -29360129;
                    } else {
                        selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    modifier3 = modifier17;
                    selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                    i20 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
                }
                int i215 = i20 << 3;
                int i216 = ((i20 >> 9) & 14) | (i215 & 112) | ((i20 >> 15) & 896);
                State<Color> stateContentColor5 = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i216);
                int i217 = i20;
                SelectableChipColors selectableChipColors8 = selectableChipColors2;
                boolean z9 = z3;
                Modifier modifier18 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z9, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i216).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor5.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor5, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors8, z9, i217)), composerStartRestartGroup, (i217 & 7294) | ((i217 >> 3) & 57344) | (i215 & 29360128) | ((i217 << 15) & 1879048192), 6, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                borderStroke3 = borderStroke2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                interfaceC0526Fp8 = interfaceC0526Fp5;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                selectableChipColors3 = selectableChipColors8;
                z4 = z9;
                modifier4 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14174(z, interfaceC3588op, modifier4, z4, mutableInteractionSource3, shape2, borderStroke3, selectableChipColors3, interfaceC0526Fp7, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0552Gp, i, i2, i3));
        }
        i4 |= 3072;
        z3 = z2;
        i7 = i3 & 16;
        if (i7 != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i4 |= i8;
        }
        if ((i & 458752) != 0) {
            if ((i3 & 32) == 0) {
                i21 = 65536;
            } else {
                i21 = 65536;
            }
            i4 |= i21;
        }
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i & 29360128) != 0) {
            i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(selectableChipColors)) ? 4194304 : 8388608;
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i4 |= i12;
        }
        i13 = i3 & 512;
        if (i13 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i14 = PropertyOptions.DELETE_EXISTING;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        i15 = i3 & 1024;
        if (i15 != 0) {
            i16 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i16 = i2 | i17;
        } else {
            i16 = i2;
        }
        if ((i3 & 2048) != 0) {
            i18 = i16 | 48;
        } else if ((i2 & 112) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i18 = i16 | i19;
        } else {
            i18 = i16;
        }
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i4 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                Modifier modifier19 = modifier2;
                if ((i3 & 128) != 0) {
                    selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    i4 &= -29360129;
                } else {
                    selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                }
                if (i11 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i15 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                modifier3 = modifier19;
                selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                i20 = i4;
            } else {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i4 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                Modifier modifier110 = modifier2;
                if ((i3 & 128) != 0) {
                    selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    i4 &= -29360129;
                } else {
                    selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                }
                if (i11 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i15 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                modifier3 = modifier110;
                selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                i20 = i4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
            }
            int i218 = i20 << 3;
            int i219 = ((i20 >> 9) & 14) | (i218 & 112) | ((i20 >> 15) & 896);
            State<Color> stateContentColor6 = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i219);
            int i2110 = i20;
            SelectableChipColors selectableChipColors9 = selectableChipColors2;
            boolean z10 = z3;
            Modifier modifier111 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z10, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i219).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor6.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor6, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors9, z10, i2110)), composerStartRestartGroup, (i2110 & 7294) | ((i2110 >> 3) & 57344) | (i218 & 29360128) | ((i2110 << 15) & 1879048192), 6, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            shape2 = shapeCopy;
            borderStroke3 = borderStroke2;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            interfaceC0526Fp8 = interfaceC0526Fp5;
            interfaceC0526Fp9 = interfaceC0526Fp6;
            selectableChipColors3 = selectableChipColors9;
            z4 = z10;
            modifier4 = modifier111;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i4 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                Modifier modifier112 = modifier2;
                if ((i3 & 128) != 0) {
                    selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    i4 &= -29360129;
                } else {
                    selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                }
                if (i11 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i15 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                modifier3 = modifier112;
                selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                i20 = i4;
            } else {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i4 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                Modifier modifier113 = modifier2;
                if ((i3 & 128) != 0) {
                    selectableChipColorsM1035filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m1035filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    i4 &= -29360129;
                } else {
                    selectableChipColorsM1035filterChipColorsJ08w3E = selectableChipColors;
                }
                if (i11 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i15 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                modifier3 = modifier113;
                selectableChipColors2 = selectableChipColorsM1035filterChipColorsJ08w3E;
                i20 = i4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1259208246, i20, i18, "androidx.compose.material.FilterChip (Chip.kt:183)");
            }
            int i2111 = i20 << 3;
            int i2112 = ((i20 >> 9) & 14) | (i2111 & 112) | ((i20 >> 15) & 896);
            State<Color> stateContentColor7 = selectableChipColors2.contentColor(z3, z, composerStartRestartGroup, i2112);
            int i2113 = i20;
            SelectableChipColors selectableChipColors10 = selectableChipColors2;
            boolean z11 = z3;
            Modifier modifier114 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1229SurfaceNy5ogXk(z, interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, C14152.INSTANCE, 1, null), z11, shapeCopy, selectableChipColors2.backgroundColor(z3, z, composerStartRestartGroup, i2112).getValue().m3042unboximpl(), Color.m3031copywmQWz5c$default(stateContentColor7.getValue().m3042unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 722126431, true, new C14163(stateContentColor7, interfaceC0526Fp4, z, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0552Gp, i18, selectableChipColors10, z11, i2113)), composerStartRestartGroup, (i2113 & 7294) | ((i2113 >> 3) & 57344) | (i2111 & 29360128) | ((i2113 << 15) & 1879048192), 6, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            shape2 = shapeCopy;
            borderStroke3 = borderStroke2;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            interfaceC0526Fp8 = interfaceC0526Fp5;
            interfaceC0526Fp9 = interfaceC0526Fp6;
            selectableChipColors3 = selectableChipColors10;
            z4 = z11;
            modifier4 = modifier114;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14174(z, interfaceC3588op, modifier4, z4, mutableInteractionSource3, shape2, borderStroke3, selectableChipColors3, interfaceC0526Fp7, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0552Gp, i, i2, i3));
    }
}
