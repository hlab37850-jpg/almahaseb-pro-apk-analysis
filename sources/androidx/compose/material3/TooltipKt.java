package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight;
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine;
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float RichTooltipMaxWidth;
    private static final float TextBottomPadding;
    private static final float TooltipAnchorPadding;
    public static final long TooltipDuration = 1500;
    public static final int TooltipFadeInDuration = 150;
    private static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth = Dp.m5160constructorimpl(40);
    private static final float PlainTooltipMaxWidth = Dp.m5160constructorimpl(200);

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$RichTooltipBox$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $action;
        final /* synthetic */ RichTooltipColors $colors;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ InterfaceC0526Fp $title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(RichTooltipColors richTooltipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i) {
            super(2);
            this.$colors = richTooltipColors;
            this.$text = interfaceC0526Fp;
            this.$title = interfaceC0526Fp2;
            this.$action = interfaceC0526Fp3;
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
                ComposerKt.traceEventStart(1423372873, i, -1, "androidx.compose.material3.RichTooltipBox.<anonymous> (Tooltip.kt:167)");
            }
            RichTooltipColors richTooltipColors = this.$colors;
            InterfaceC0526Fp interfaceC0526Fp = this.$text;
            InterfaceC0526Fp interfaceC0526Fp2 = this.$title;
            InterfaceC0526Fp interfaceC0526Fp3 = this.$action;
            int i2 = this.$$dirty;
            TooltipKt.RichTooltipImpl(richTooltipColors, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, composer, ((i2 >> 18) & 14) | ((i2 << 3) & 112) | ((i2 >> 3) & 896) | ((i2 >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$RichTooltipBox$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $action;
        final /* synthetic */ RichTooltipColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ InterfaceC0526Fp $title;
        final /* synthetic */ RichTooltipState $tooltipState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, RichTooltipState richTooltipState, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, RichTooltipColors richTooltipColors, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$text = interfaceC0526Fp;
            this.$modifier = modifier;
            this.$tooltipState = richTooltipState;
            this.$title = interfaceC0526Fp2;
            this.$action = interfaceC0526Fp3;
            this.$shape = shape;
            this.$colors = richTooltipColors;
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
            TooltipKt.RichTooltipBox(this.$text, this.$modifier, this.$tooltipState, this.$title, this.$action, this.$shape, this.$colors, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$RichTooltipImpl$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $action;
        final /* synthetic */ RichTooltipColors $colors;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ InterfaceC0526Fp $title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RichTooltipColors richTooltipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i) {
            super(2);
            this.$colors = richTooltipColors;
            this.$text = interfaceC0526Fp;
            this.$title = interfaceC0526Fp2;
            this.$action = interfaceC0526Fp3;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TooltipKt.RichTooltipImpl(this.$colors, this.$text, this.$title, this.$action, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$animateTooltip$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16052 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Transition<Boolean> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16052(Transition<Boolean> transition) {
            super(3);
            this.$transition = transition;
        }

        private static final float invoke$lambda$1(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$3(State<Float> state) {
            return state.getValue().floatValue();
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-1498516085);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498516085, i, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:699)");
            }
            Transition<Boolean> transition = this.$transition;
            TooltipKt$animateTooltip$2$scale$2 tooltipKt$animateTooltip$2$scale$2 = TooltipKt$animateTooltip$2$scale$2.INSTANCE;
            composer.startReplaceableGroup(-1338768149);
            C0774Nm c0774Nm = C0774Nm.a;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(c0774Nm);
            composer.startReplaceableGroup(-142660079);
            boolean zBooleanValue = transition.getCurrentState().booleanValue();
            composer.startReplaceableGroup(-1553362193);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:717)");
            }
            float f = zBooleanValue ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            Float fValueOf = Float.valueOf(f);
            boolean zBooleanValue2 = transition.getTargetState().booleanValue();
            composer.startReplaceableGroup(-1553362193);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:717)");
            }
            float f2 = zBooleanValue2 ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) tooltipKt$animateTooltip$2$scale$2.invoke((Object) transition.getSegment(), (Object) composer, (Object) 0), vectorConverter, "tooltip transition: scaling", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Transition<Boolean> transition2 = this.$transition;
            TooltipKt$animateTooltip$2$alpha$2 tooltipKt$animateTooltip$2$alpha$2 = TooltipKt$animateTooltip$2$alpha$2.INSTANCE;
            composer.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(c0774Nm);
            composer.startReplaceableGroup(-142660079);
            boolean zBooleanValue3 = transition2.getCurrentState().booleanValue();
            composer.startReplaceableGroup(2073045083);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:736)");
            }
            float f3 = zBooleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            Float fValueOf2 = Float.valueOf(f3);
            boolean zBooleanValue4 = transition2.getTargetState().booleanValue();
            composer.startReplaceableGroup(2073045083);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:736)");
            }
            float f4 = zBooleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) tooltipKt$animateTooltip$2$alpha$2.invoke((Object) transition2.getSegment(), (Object) composer, (Object) 0), vectorConverter2, "tooltip transition: alpha", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Modifier modifierM3188graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m3188graphicsLayerAp8cVGQ$default(modifier, invoke$lambda$1(stateCreateTransitionAnimation), invoke$lambda$1(stateCreateTransitionAnimation), invoke$lambda$3(stateCreateTransitionAnimation2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierM3188graphicsLayerAp8cVGQ$default;
        }
    }

    static {
        float f = 4;
        TooltipAnchorPadding = Dp.m5160constructorimpl(f);
        float f2 = 24;
        TooltipMinHeight = Dp.m5160constructorimpl(f2);
        float fM5160constructorimpl = Dp.m5160constructorimpl(f);
        PlainTooltipVerticalPadding = fM5160constructorimpl;
        float f3 = 8;
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(f3);
        PlainTooltipHorizontalPadding = fM5160constructorimpl2;
        PlainTooltipContentPadding = PaddingKt.m479PaddingValuesYgX7TsA(fM5160constructorimpl2, fM5160constructorimpl);
        RichTooltipMaxWidth = Dp.m5160constructorimpl(TIFFConstants.TIFFTAG_COLORMAP);
        float f4 = 16;
        RichTooltipHorizontalPadding = Dp.m5160constructorimpl(f4);
        HeightToSubheadFirstLine = Dp.m5160constructorimpl(28);
        HeightFromSubheadToTextFirstLine = Dp.m5160constructorimpl(f2);
        TextBottomPadding = Dp.m5160constructorimpl(f4);
        ActionLabelMinHeight = Dp.m5160constructorimpl(36);
        ActionLabelBottomPadding = Dp.m5160constructorimpl(f3);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0129  */
    /* JADX WARN: Code duplicated, block: B:102:0x012e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0140  */
    /* JADX WARN: Code duplicated, block: B:108:0x0152  */
    /* JADX WARN: Code duplicated, block: B:111:0x015f  */
    /* JADX WARN: Code duplicated, block: B:114:0x016c  */
    /* JADX WARN: Code duplicated, block: B:117:0x017c  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:123:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:128:0x0211  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0103  */
    /* JADX WARN: Code duplicated, block: B:99:0x0127 A[DONT_INVERT] */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: PlainTooltipBox-nBX6wN0, reason: not valid java name */
    public static final void m2045PlainTooltipBoxnBX6wN0(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, PlainTooltipState plainTooltipState, Shape shape, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        PlainTooltipState plainTooltipState2;
        int i5;
        Shape plainTooltipContainerShape;
        long plainTooltipContainerColor;
        long plainTooltipContentColor;
        int i6;
        Object objRememberedValue;
        int iMo327roundToPx0680j_4;
        Object objRememberedValue2;
        Modifier modifier3;
        PlainTooltipState plainTooltipState3;
        Shape shape2;
        long j3;
        long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "tooltip");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-531325137);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    plainTooltipState2 = plainTooltipState;
                    if (composerStartRestartGroup.changed(plainTooltipState2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        plainTooltipContainerShape = shape;
                        int i8 = composerStartRestartGroup.changed(plainTooltipContainerShape) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        plainTooltipContainerShape = shape;
                    }
                    i3 |= i8;
                } else {
                    plainTooltipContainerShape = shape;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        plainTooltipContainerColor = j;
                        int i9 = composerStartRestartGroup.changed(plainTooltipContainerColor) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        plainTooltipContainerColor = j;
                    }
                    i3 |= i9;
                } else {
                    plainTooltipContainerColor = j;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        plainTooltipContentColor = j2;
                        int i10 = composerStartRestartGroup.changed(plainTooltipContentColor) ? 131072 : 65536;
                        i3 |= i10;
                    } else {
                        plainTooltipContentColor = j2;
                    }
                    i3 |= i10;
                } else {
                    plainTooltipContentColor = j2;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i6 = 1048576;
                        } else {
                            i6 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new PlainTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            }
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
                        }
                        Modifier modifier4 = modifier2;
                        PlainTooltipState plainTooltipState4 = plainTooltipState2;
                        Shape shape3 = plainTooltipContainerShape;
                        long j5 = plainTooltipContainerColor;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        PlainTooltipPositionProvider plainTooltipPositionProvider = (PlainTooltipPositionProvider) objRememberedValue2;
                        float fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        float f = PlainTooltipMaxWidth;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                        int i11 = i3 << 3;
                        int i12 = (i11 & 896) | 14155830 | (i3 & 7168);
                        int i13 = i3 << 6;
                        long j6 = plainTooltipContentColor;
                        m2047TooltipBoxXDn_Kpo(composableLambda, plainTooltipPositionProvider, modifier4, shape3, plainTooltipState4, j5, fM5160constructorimpl, f, interfaceC0552Gp, composerStartRestartGroup, (i11 & 458752) | i12 | (57344 & i13) | (i13 & 234881024));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        plainTooltipState3 = plainTooltipState4;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        plainTooltipState3 = plainTooltipState2;
                        shape2 = plainTooltipContainerShape;
                        j3 = plainTooltipContainerColor;
                        j4 = plainTooltipContentColor;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
                }
                i6 = 1572864;
                i3 |= i6;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    }
                    Modifier modifier5 = modifier2;
                    PlainTooltipState plainTooltipState5 = plainTooltipState2;
                    Shape shape4 = plainTooltipContainerShape;
                    long j7 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    PlainTooltipPositionProvider plainTooltipPositionProvider2 = (PlainTooltipPositionProvider) objRememberedValue2;
                    float fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    float f2 = PlainTooltipMaxWidth;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                    int i14 = i3 << 3;
                    int i15 = (i14 & 896) | 14155830 | (i3 & 7168);
                    int i16 = i3 << 6;
                    long j8 = plainTooltipContentColor;
                    m2047TooltipBoxXDn_Kpo(composableLambda2, plainTooltipPositionProvider2, modifier5, shape4, plainTooltipState5, j7, fM5160constructorimpl2, f2, interfaceC0552Gp, composerStartRestartGroup, (i14 & 458752) | i15 | (57344 & i16) | (i16 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    plainTooltipState3 = plainTooltipState5;
                    shape2 = shape4;
                    j3 = j7;
                    j4 = j8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    }
                    Modifier modifier6 = modifier2;
                    PlainTooltipState plainTooltipState6 = plainTooltipState2;
                    Shape shape5 = plainTooltipContainerShape;
                    long j9 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    PlainTooltipPositionProvider plainTooltipPositionProvider3 = (PlainTooltipPositionProvider) objRememberedValue2;
                    float fM5160constructorimpl3 = Dp.m5160constructorimpl(0);
                    float f3 = PlainTooltipMaxWidth;
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                    int i17 = i3 << 3;
                    int i18 = (i17 & 896) | 14155830 | (i3 & 7168);
                    int i19 = i3 << 6;
                    long j10 = plainTooltipContentColor;
                    m2047TooltipBoxXDn_Kpo(composableLambda3, plainTooltipPositionProvider3, modifier6, shape5, plainTooltipState6, j9, fM5160constructorimpl3, f3, interfaceC0552Gp, composerStartRestartGroup, (i17 & 458752) | i18 | (57344 & i19) | (i19 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    plainTooltipState3 = plainTooltipState6;
                    shape2 = shape5;
                    j3 = j9;
                    j4 = j10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            plainTooltipState2 = plainTooltipState;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    plainTooltipContainerShape = shape;
                    if (composerStartRestartGroup.changed(plainTooltipContainerShape)) {
                    }
                    i3 |= i8;
                } else {
                    plainTooltipContainerShape = shape;
                }
                i3 |= i8;
            } else {
                plainTooltipContainerShape = shape;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    plainTooltipContainerColor = j;
                    if (composerStartRestartGroup.changed(plainTooltipContainerColor)) {
                    }
                    i3 |= i9;
                } else {
                    plainTooltipContainerColor = j;
                }
                i3 |= i9;
            } else {
                plainTooltipContainerColor = j;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    plainTooltipContentColor = j2;
                    if (composerStartRestartGroup.changed(plainTooltipContentColor)) {
                    }
                    i3 |= i10;
                } else {
                    plainTooltipContentColor = j2;
                }
                i3 |= i10;
            } else {
                plainTooltipContentColor = j2;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    }
                    Modifier modifier7 = modifier2;
                    PlainTooltipState plainTooltipState7 = plainTooltipState2;
                    Shape shape6 = plainTooltipContainerShape;
                    long j11 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    PlainTooltipPositionProvider plainTooltipPositionProvider4 = (PlainTooltipPositionProvider) objRememberedValue2;
                    float fM5160constructorimpl4 = Dp.m5160constructorimpl(0);
                    float f4 = PlainTooltipMaxWidth;
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                    int i110 = i3 << 3;
                    int i111 = (i110 & 896) | 14155830 | (i3 & 7168);
                    int i112 = i3 << 6;
                    long j12 = plainTooltipContentColor;
                    m2047TooltipBoxXDn_Kpo(composableLambda4, plainTooltipPositionProvider4, modifier7, shape6, plainTooltipState7, j11, fM5160constructorimpl4, f4, interfaceC0552Gp, composerStartRestartGroup, (i110 & 458752) | i111 | (57344 & i112) | (i112 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    plainTooltipState3 = plainTooltipState7;
                    shape2 = shape6;
                    j3 = j11;
                    j4 = j12;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    }
                    Modifier modifier8 = modifier2;
                    PlainTooltipState plainTooltipState8 = plainTooltipState2;
                    Shape shape7 = plainTooltipContainerShape;
                    long j13 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    PlainTooltipPositionProvider plainTooltipPositionProvider5 = (PlainTooltipPositionProvider) objRememberedValue2;
                    float fM5160constructorimpl5 = Dp.m5160constructorimpl(0);
                    float f5 = PlainTooltipMaxWidth;
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                    int i113 = i3 << 3;
                    int i114 = (i113 & 896) | 14155830 | (i3 & 7168);
                    int i115 = i3 << 6;
                    long j14 = plainTooltipContentColor;
                    m2047TooltipBoxXDn_Kpo(composableLambda5, plainTooltipPositionProvider5, modifier8, shape7, plainTooltipState8, j13, fM5160constructorimpl5, f5, interfaceC0552Gp, composerStartRestartGroup, (i113 & 458752) | i114 | (57344 & i115) | (i115 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier8;
                    plainTooltipState3 = plainTooltipState8;
                    shape2 = shape7;
                    j3 = j13;
                    j4 = j14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
            }
            i6 = 1572864;
            i3 |= i6;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                }
                Modifier modifier9 = modifier2;
                PlainTooltipState plainTooltipState9 = plainTooltipState2;
                Shape shape8 = plainTooltipContainerShape;
                long j15 = plainTooltipContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                PlainTooltipPositionProvider plainTooltipPositionProvider6 = (PlainTooltipPositionProvider) objRememberedValue2;
                float fM5160constructorimpl6 = Dp.m5160constructorimpl(0);
                float f6 = PlainTooltipMaxWidth;
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                int i116 = i3 << 3;
                int i117 = (i116 & 896) | 14155830 | (i3 & 7168);
                int i118 = i3 << 6;
                long j16 = plainTooltipContentColor;
                m2047TooltipBoxXDn_Kpo(composableLambda6, plainTooltipPositionProvider6, modifier9, shape8, plainTooltipState9, j15, fM5160constructorimpl6, f6, interfaceC0552Gp, composerStartRestartGroup, (i116 & 458752) | i117 | (57344 & i118) | (i118 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier9;
                plainTooltipState3 = plainTooltipState9;
                shape2 = shape8;
                j3 = j15;
                j4 = j16;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                }
                Modifier modifier10 = modifier2;
                PlainTooltipState plainTooltipState10 = plainTooltipState2;
                Shape shape9 = plainTooltipContainerShape;
                long j17 = plainTooltipContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                PlainTooltipPositionProvider plainTooltipPositionProvider7 = (PlainTooltipPositionProvider) objRememberedValue2;
                float fM5160constructorimpl7 = Dp.m5160constructorimpl(0);
                float f7 = PlainTooltipMaxWidth;
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                int i119 = i3 << 3;
                int i1110 = (i119 & 896) | 14155830 | (i3 & 7168);
                int i1111 = i3 << 6;
                long j18 = plainTooltipContentColor;
                m2047TooltipBoxXDn_Kpo(composableLambda7, plainTooltipPositionProvider7, modifier10, shape9, plainTooltipState10, j17, fM5160constructorimpl7, f7, interfaceC0552Gp, composerStartRestartGroup, (i119 & 458752) | i1110 | (57344 & i1111) | (i1111 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                plainTooltipState3 = plainTooltipState10;
                shape2 = shape9;
                j3 = j17;
                j4 = j18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                plainTooltipState2 = plainTooltipState;
                if (composerStartRestartGroup.changed(plainTooltipState2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    plainTooltipContainerShape = shape;
                    if (composerStartRestartGroup.changed(plainTooltipContainerShape)) {
                    }
                    i3 |= i8;
                } else {
                    plainTooltipContainerShape = shape;
                }
                i3 |= i8;
            } else {
                plainTooltipContainerShape = shape;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    plainTooltipContainerColor = j;
                    if (composerStartRestartGroup.changed(plainTooltipContainerColor)) {
                    }
                    i3 |= i9;
                } else {
                    plainTooltipContainerColor = j;
                }
                i3 |= i9;
            } else {
                plainTooltipContainerColor = j;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    plainTooltipContentColor = j2;
                    if (composerStartRestartGroup.changed(plainTooltipContentColor)) {
                    }
                    i3 |= i10;
                } else {
                    plainTooltipContentColor = j2;
                }
                i3 |= i10;
            } else {
                plainTooltipContentColor = j2;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    }
                    Modifier modifier11 = modifier2;
                    PlainTooltipState plainTooltipState11 = plainTooltipState2;
                    Shape shape10 = plainTooltipContainerShape;
                    long j19 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    PlainTooltipPositionProvider plainTooltipPositionProvider8 = (PlainTooltipPositionProvider) objRememberedValue2;
                    float fM5160constructorimpl8 = Dp.m5160constructorimpl(0);
                    float f8 = PlainTooltipMaxWidth;
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                    int i1112 = i3 << 3;
                    int i1113 = (i1112 & 896) | 14155830 | (i3 & 7168);
                    int i1114 = i3 << 6;
                    long j110 = plainTooltipContentColor;
                    m2047TooltipBoxXDn_Kpo(composableLambda8, plainTooltipPositionProvider8, modifier11, shape10, plainTooltipState11, j19, fM5160constructorimpl8, f8, interfaceC0552Gp, composerStartRestartGroup, (i1112 & 458752) | i1113 | (57344 & i1114) | (i1114 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11;
                    plainTooltipState3 = plainTooltipState11;
                    shape2 = shape10;
                    j3 = j19;
                    j4 = j110;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new PlainTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                    }
                    Modifier modifier12 = modifier2;
                    PlainTooltipState plainTooltipState12 = plainTooltipState2;
                    Shape shape11 = plainTooltipContainerShape;
                    long j111 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    PlainTooltipPositionProvider plainTooltipPositionProvider9 = (PlainTooltipPositionProvider) objRememberedValue2;
                    float fM5160constructorimpl9 = Dp.m5160constructorimpl(0);
                    float f9 = PlainTooltipMaxWidth;
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                    int i1115 = i3 << 3;
                    int i1116 = (i1115 & 896) | 14155830 | (i3 & 7168);
                    int i1117 = i3 << 6;
                    long j112 = plainTooltipContentColor;
                    m2047TooltipBoxXDn_Kpo(composableLambda9, plainTooltipPositionProvider9, modifier12, shape11, plainTooltipState12, j111, fM5160constructorimpl9, f9, interfaceC0552Gp, composerStartRestartGroup, (i1115 & 458752) | i1116 | (57344 & i1117) | (i1117 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier12;
                    plainTooltipState3 = plainTooltipState12;
                    shape2 = shape11;
                    j3 = j111;
                    j4 = j112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
            }
            i6 = 1572864;
            i3 |= i6;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                }
                Modifier modifier13 = modifier2;
                PlainTooltipState plainTooltipState13 = plainTooltipState2;
                Shape shape12 = plainTooltipContainerShape;
                long j113 = plainTooltipContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                PlainTooltipPositionProvider plainTooltipPositionProvider10 = (PlainTooltipPositionProvider) objRememberedValue2;
                float fM5160constructorimpl10 = Dp.m5160constructorimpl(0);
                float f10 = PlainTooltipMaxWidth;
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                int i1118 = i3 << 3;
                int i1119 = (i1118 & 896) | 14155830 | (i3 & 7168);
                int i11110 = i3 << 6;
                long j114 = plainTooltipContentColor;
                m2047TooltipBoxXDn_Kpo(composableLambda10, plainTooltipPositionProvider10, modifier13, shape12, plainTooltipState13, j113, fM5160constructorimpl10, f10, interfaceC0552Gp, composerStartRestartGroup, (i1118 & 458752) | i1119 | (57344 & i11110) | (i11110 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier13;
                plainTooltipState3 = plainTooltipState13;
                shape2 = shape12;
                j3 = j113;
                j4 = j114;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                }
                Modifier modifier14 = modifier2;
                PlainTooltipState plainTooltipState14 = plainTooltipState2;
                Shape shape13 = plainTooltipContainerShape;
                long j115 = plainTooltipContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                PlainTooltipPositionProvider plainTooltipPositionProvider11 = (PlainTooltipPositionProvider) objRememberedValue2;
                float fM5160constructorimpl11 = Dp.m5160constructorimpl(0);
                float f11 = PlainTooltipMaxWidth;
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                int i11111 = i3 << 3;
                int i11112 = (i11111 & 896) | 14155830 | (i3 & 7168);
                int i11113 = i3 << 6;
                long j116 = plainTooltipContentColor;
                m2047TooltipBoxXDn_Kpo(composableLambda11, plainTooltipPositionProvider11, modifier14, shape13, plainTooltipState14, j115, fM5160constructorimpl11, f11, interfaceC0552Gp, composerStartRestartGroup, (i11111 & 458752) | i11112 | (57344 & i11113) | (i11113 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier14;
                plainTooltipState3 = plainTooltipState14;
                shape2 = shape13;
                j3 = j115;
                j4 = j116;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        plainTooltipState2 = plainTooltipState;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                plainTooltipContainerShape = shape;
                if (composerStartRestartGroup.changed(plainTooltipContainerShape)) {
                }
                i3 |= i8;
            } else {
                plainTooltipContainerShape = shape;
            }
            i3 |= i8;
        } else {
            plainTooltipContainerShape = shape;
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                plainTooltipContainerColor = j;
                if (composerStartRestartGroup.changed(plainTooltipContainerColor)) {
                }
                i3 |= i9;
            } else {
                plainTooltipContainerColor = j;
            }
            i3 |= i9;
        } else {
            plainTooltipContainerColor = j;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                plainTooltipContentColor = j2;
                if (composerStartRestartGroup.changed(plainTooltipContentColor)) {
                }
                i3 |= i10;
            } else {
                plainTooltipContentColor = j2;
            }
            i3 |= i10;
        } else {
            plainTooltipContentColor = j2;
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                }
                Modifier modifier15 = modifier2;
                PlainTooltipState plainTooltipState15 = plainTooltipState2;
                Shape shape14 = plainTooltipContainerShape;
                long j117 = plainTooltipContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                PlainTooltipPositionProvider plainTooltipPositionProvider12 = (PlainTooltipPositionProvider) objRememberedValue2;
                float fM5160constructorimpl12 = Dp.m5160constructorimpl(0);
                float f12 = PlainTooltipMaxWidth;
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                int i11114 = i3 << 3;
                int i11115 = (i11114 & 896) | 14155830 | (i3 & 7168);
                int i11116 = i3 << 6;
                long j118 = plainTooltipContentColor;
                m2047TooltipBoxXDn_Kpo(composableLambda12, plainTooltipPositionProvider12, modifier15, shape14, plainTooltipState15, j117, fM5160constructorimpl12, f12, interfaceC0552Gp, composerStartRestartGroup, (i11114 & 458752) | i11115 | (57344 & i11116) | (i11116 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier15;
                plainTooltipState3 = plainTooltipState15;
                shape2 = shape14;
                j3 = j117;
                j4 = j118;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new PlainTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                }
                Modifier modifier16 = modifier2;
                PlainTooltipState plainTooltipState16 = plainTooltipState2;
                Shape shape15 = plainTooltipContainerShape;
                long j119 = plainTooltipContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                PlainTooltipPositionProvider plainTooltipPositionProvider13 = (PlainTooltipPositionProvider) objRememberedValue2;
                float fM5160constructorimpl13 = Dp.m5160constructorimpl(0);
                float f13 = PlainTooltipMaxWidth;
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
                int i11117 = i3 << 3;
                int i11118 = (i11117 & 896) | 14155830 | (i3 & 7168);
                int i11119 = i3 << 6;
                long j1110 = plainTooltipContentColor;
                m2047TooltipBoxXDn_Kpo(composableLambda13, plainTooltipPositionProvider13, modifier16, shape15, plainTooltipState16, j119, fM5160constructorimpl13, f13, interfaceC0552Gp, composerStartRestartGroup, (i11117 & 458752) | i11118 | (57344 & i11119) | (i11119 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier16;
                plainTooltipState3 = plainTooltipState16;
                shape2 = shape15;
                j3 = j119;
                j4 = j1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
        }
        i6 = 1572864;
        i3 |= i6;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new PlainTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new PlainTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
            }
            Modifier modifier17 = modifier2;
            PlainTooltipState plainTooltipState17 = plainTooltipState2;
            Shape shape16 = plainTooltipContainerShape;
            long j1111 = plainTooltipContainerColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
            }
            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            PlainTooltipPositionProvider plainTooltipPositionProvider14 = (PlainTooltipPositionProvider) objRememberedValue2;
            float fM5160constructorimpl14 = Dp.m5160constructorimpl(0);
            float f14 = PlainTooltipMaxWidth;
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
            int i111110 = i3 << 3;
            int i111111 = (i111110 & 896) | 14155830 | (i3 & 7168);
            int i111112 = i3 << 6;
            long j1112 = plainTooltipContentColor;
            m2047TooltipBoxXDn_Kpo(composableLambda14, plainTooltipPositionProvider14, modifier17, shape16, plainTooltipState17, j1111, fM5160constructorimpl14, f14, interfaceC0552Gp, composerStartRestartGroup, (i111110 & 458752) | i111111 | (57344 & i111112) | (i111112 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier17;
            plainTooltipState3 = plainTooltipState17;
            shape2 = shape16;
            j3 = j1111;
            j4 = j1112;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new PlainTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new PlainTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    plainTooltipState2 = (PlainTooltipState) objRememberedValue;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
            }
            Modifier modifier18 = modifier2;
            PlainTooltipState plainTooltipState18 = plainTooltipState2;
            Shape shape17 = plainTooltipContainerShape;
            long j1113 = plainTooltipContainerColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-531325137, i3, -1, "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)");
            }
            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new PlainTooltipPositionProvider(iMo327roundToPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            PlainTooltipPositionProvider plainTooltipPositionProvider15 = (PlainTooltipPositionProvider) objRememberedValue2;
            float fM5160constructorimpl15 = Dp.m5160constructorimpl(0);
            float f15 = PlainTooltipMaxWidth;
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -785135750, true, new TooltipKt$PlainTooltipBox$2(plainTooltipContentColor, interfaceC0526Fp, i3));
            int i111113 = i3 << 3;
            int i111114 = (i111113 & 896) | 14155830 | (i3 & 7168);
            int i111115 = i3 << 6;
            long j1114 = plainTooltipContentColor;
            m2047TooltipBoxXDn_Kpo(composableLambda15, plainTooltipPositionProvider15, modifier18, shape17, plainTooltipState18, j1113, fM5160constructorimpl15, f15, interfaceC0552Gp, composerStartRestartGroup, (i111113 & 458752) | i111114 | (57344 & i111115) | (i111115 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier18;
            plainTooltipState3 = plainTooltipState18;
            shape2 = shape17;
            j3 = j1113;
            j4 = j1114;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipBox$3(interfaceC0526Fp, modifier3, plainTooltipState3, shape2, j3, j4, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: PlainTooltipImpl-Iv8Zu3U, reason: not valid java name */
    public static final void m2046PlainTooltipImplIv8Zu3U(long j, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(893340370);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(893340370, i2, -1, "androidx.compose.material3.PlainTooltipImpl (Tooltip.kt:280)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.Companion, PlainTooltipContentPadding);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierPadding);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j)), TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), PlainTooltipTokens.INSTANCE.getSupportingTextFont()))}, interfaceC0526Fp, composerStartRestartGroup, (i2 & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$PlainTooltipImpl$2(j, interfaceC0526Fp, i));
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0135 A[PHI: r3 r5 r7 r9 r11 r12
      0x0135: PHI (r3v30 int) = (r3v21 int), (r3v31 int), (r3v32 int) binds: [B:122:0x017c, B:102:0x0131, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r5v18 androidx.compose.ui.Modifier) = (r5v3 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier) binds: [B:122:0x017c, B:102:0x0131, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r7v12 androidx.compose.material3.RichTooltipState) = 
      (r7v3 androidx.compose.material3.RichTooltipState)
      (r7v2 androidx.compose.material3.RichTooltipState)
      (r7v2 androidx.compose.material3.RichTooltipState)
     binds: [B:122:0x017c, B:102:0x0131, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r9v7 Fp) = (r9v3 Fp), (r9v2 Fp), (r9v2 Fp) binds: [B:122:0x017c, B:102:0x0131, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r11v8 androidx.compose.ui.graphics.Shape) = 
      (r11v3 androidx.compose.ui.graphics.Shape)
      (r11v2 androidx.compose.ui.graphics.Shape)
      (r11v2 androidx.compose.ui.graphics.Shape)
     binds: [B:122:0x017c, B:102:0x0131, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r12v8 Fp) = (r12v3 Fp), (r12v2 Fp), (r12v2 Fp) binds: [B:122:0x017c, B:102:0x0131, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:106:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0141  */
    /* JADX WARN: Code duplicated, block: B:109:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x0158  */
    /* JADX WARN: Code duplicated, block: B:115:0x0169  */
    /* JADX WARN: Code duplicated, block: B:117:0x016c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0171  */
    /* JADX WARN: Code duplicated, block: B:123:0x017e  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:129:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:132:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:137:0x025b  */
    /* JADX WARN: Code duplicated, block: B:142:0x0270  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x011f  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void RichTooltipBox(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, RichTooltipState richTooltipState, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, RichTooltipColors richTooltipColors, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        RichTooltipState richTooltipState2;
        int i5;
        int i6;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i7;
        int i8;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i9;
        Shape richTooltipContainerShape;
        int i10;
        RichTooltipColors richTooltipColorsM2044richTooltipColorsro_MJ88;
        Object objRememberedValue;
        InterfaceC0526Fp interfaceC0526Fp6;
        RichTooltipState richTooltipState3;
        int iMo327roundToPx0680j_4;
        Object objRememberedValue2;
        Composer.Companion companion;
        boolean zChanged;
        Object objRememberedValue3;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp7;
        Shape shape2;
        RichTooltipColors richTooltipColors2;
        InterfaceC0526Fp interfaceC0526Fp8;
        RichTooltipState richTooltipState4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        AbstractC4492zt.h(interfaceC0526Fp, "text");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(180959998);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    richTooltipState2 = richTooltipState;
                    if (composerStartRestartGroup.changed(richTooltipState2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 57344) == 0) {
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i & 458752) == 0) {
                            richTooltipContainerShape = shape;
                            if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(richTooltipContainerShape)) {
                                i12 = 65536;
                            } else {
                                i12 = 131072;
                            }
                            i3 |= i12;
                        } else {
                            richTooltipContainerShape = shape;
                        }
                        if ((i & 3670016) != 0) {
                            if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(richTooltipColors)) {
                                i11 = 524288;
                            } else {
                                i11 = 1048576;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 128) != 0) {
                            if ((29360128 & i) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                    i10 = 8388608;
                                } else {
                                    i10 = 4194304;
                                }
                            }
                            if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i13 != 0) {
                                        modifier2 = Modifier.Companion;
                                    }
                                    if (i4 != 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                                            objRememberedValue = new RichTooltipState();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                                    }
                                    if (i6 != 0) {
                                        interfaceC0526Fp4 = null;
                                    }
                                    if (i8 != 0) {
                                        interfaceC0526Fp5 = null;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    }
                                    Modifier modifier4 = modifier2;
                                    InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526Fp4;
                                    Shape shape3 = richTooltipContainerShape;
                                    interfaceC0526Fp6 = interfaceC0526Fp5;
                                    richTooltipState3 = richTooltipState2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                                    }
                                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    companion = Composer.Companion;
                                    if (objRememberedValue2 == companion.getEmpty()) {
                                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    RichTooltipPositionProvider richTooltipPositionProvider = (RichTooltipPositionProvider) objRememberedValue2;
                                    int i14 = i3 >> 6;
                                    composerStartRestartGroup.startReplaceableGroup(511388516);
                                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                                    int i15 = i3 << 3;
                                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp9, interfaceC0526Fp6, i3)), richTooltipPositionProvider, modifier4, shape3, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i15 & 234881024) | ((i3 << 6) & 57344) | (i14 & 7168) | (i15 & 896) | 14155830);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    interfaceC0526Fp7 = interfaceC0526Fp9;
                                    shape2 = shape3;
                                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                                    interfaceC0526Fp8 = interfaceC0526Fp6;
                                    richTooltipState4 = richTooltipState3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                }
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                Modifier modifier5 = modifier2;
                                InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526Fp4;
                                Shape shape4 = richTooltipContainerShape;
                                interfaceC0526Fp6 = interfaceC0526Fp5;
                                richTooltipState3 = richTooltipState2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                                }
                                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                companion = Composer.Companion;
                                if (objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                RichTooltipPositionProvider richTooltipPositionProvider2 = (RichTooltipPositionProvider) objRememberedValue2;
                                int i16 = i3 >> 6;
                                composerStartRestartGroup.startReplaceableGroup(511388516);
                                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged) {
                                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                                int i17 = i3 << 3;
                                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp10, interfaceC0526Fp6, i3)), richTooltipPositionProvider2, modifier5, shape4, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i17 & 234881024) | ((i3 << 6) & 57344) | (i16 & 7168) | (i17 & 896) | 14155830);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier5;
                                interfaceC0526Fp7 = interfaceC0526Fp10;
                                shape2 = shape4;
                                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                                interfaceC0526Fp8 = interfaceC0526Fp6;
                                richTooltipState4 = richTooltipState3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                richTooltipState4 = richTooltipState2;
                                interfaceC0526Fp7 = interfaceC0526Fp4;
                                shape2 = richTooltipContainerShape;
                                interfaceC0526Fp8 = interfaceC0526Fp5;
                                richTooltipColors2 = richTooltipColors;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                        }
                        i10 = 12582912;
                        i3 |= i10;
                        if ((23967451 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier6 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526Fp4;
                            Shape shape5 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider3 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i18 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i19 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11, interfaceC0526Fp6, i3)), richTooltipPositionProvider3, modifier6, shape5, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i19 & 234881024) | ((i3 << 6) & 57344) | (i18 & 7168) | (i19 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier6;
                            interfaceC0526Fp7 = interfaceC0526Fp11;
                            shape2 = shape5;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier7 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526Fp4;
                            Shape shape6 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider4 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i110 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i111 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp12, interfaceC0526Fp6, i3)), richTooltipPositionProvider4, modifier7, shape6, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111 & 234881024) | ((i3 << 6) & 57344) | (i110 & 7168) | (i111 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier7;
                            interfaceC0526Fp7 = interfaceC0526Fp12;
                            shape2 = shape6;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 24576;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if ((i & 458752) == 0) {
                        richTooltipContainerShape = shape;
                        if ((i2 & 32) == 0) {
                            i12 = 65536;
                        } else {
                            i12 = 65536;
                        }
                        i3 |= i12;
                    } else {
                        richTooltipContainerShape = shape;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 128) != 0) {
                        if ((29360128 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 8388608;
                            } else {
                                i10 = 4194304;
                            }
                        }
                        if ((23967451 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier8 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp4;
                            Shape shape7 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider5 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i112 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i113 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp13, interfaceC0526Fp6, i3)), richTooltipPositionProvider5, modifier8, shape7, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i113 & 234881024) | ((i3 << 6) & 57344) | (i112 & 7168) | (i113 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier8;
                            interfaceC0526Fp7 = interfaceC0526Fp13;
                            shape2 = shape7;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier9 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp4;
                            Shape shape8 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider6 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i114 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i115 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp14, interfaceC0526Fp6, i3)), richTooltipPositionProvider6, modifier9, shape8, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i115 & 234881024) | ((i3 << 6) & 57344) | (i114 & 7168) | (i115 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier9;
                            interfaceC0526Fp7 = interfaceC0526Fp14;
                            shape2 = shape8;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                    }
                    i10 = 12582912;
                    i3 |= i10;
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier10 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp4;
                        Shape shape9 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider7 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i116 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i117 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp15, interfaceC0526Fp6, i3)), richTooltipPositionProvider7, modifier10, shape9, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i117 & 234881024) | ((i3 << 6) & 57344) | (i116 & 7168) | (i117 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier10;
                        interfaceC0526Fp7 = interfaceC0526Fp15;
                        shape2 = shape9;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier11 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp4;
                        Shape shape10 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider8 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i118 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i119 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp16, interfaceC0526Fp6, i3)), richTooltipPositionProvider8, modifier11, shape10, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i119 & 234881024) | ((i3 << 6) & 57344) | (i118 & 7168) | (i119 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11;
                        interfaceC0526Fp7 = interfaceC0526Fp16;
                        shape2 = shape10;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i3 |= 3072;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & 458752) == 0) {
                        richTooltipContainerShape = shape;
                        if ((i2 & 32) == 0) {
                            i12 = 65536;
                        } else {
                            i12 = 65536;
                        }
                        i3 |= i12;
                    } else {
                        richTooltipContainerShape = shape;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 128) != 0) {
                        if ((29360128 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 8388608;
                            } else {
                                i10 = 4194304;
                            }
                        }
                        if ((23967451 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier12 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp4;
                            Shape shape11 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider9 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i1110 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i1111 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp17, interfaceC0526Fp6, i3)), richTooltipPositionProvider9, modifier12, shape11, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111 & 234881024) | ((i3 << 6) & 57344) | (i1110 & 7168) | (i1111 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier12;
                            interfaceC0526Fp7 = interfaceC0526Fp17;
                            shape2 = shape11;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier13 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp4;
                            Shape shape12 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider10 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i1112 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i1113 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp18, interfaceC0526Fp6, i3)), richTooltipPositionProvider10, modifier13, shape12, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1113 & 234881024) | ((i3 << 6) & 57344) | (i1112 & 7168) | (i1113 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier13;
                            interfaceC0526Fp7 = interfaceC0526Fp18;
                            shape2 = shape12;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                    }
                    i10 = 12582912;
                    i3 |= i10;
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier14 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp4;
                        Shape shape13 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider11 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1114 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1115 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp19, interfaceC0526Fp6, i3)), richTooltipPositionProvider11, modifier14, shape13, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1115 & 234881024) | ((i3 << 6) & 57344) | (i1114 & 7168) | (i1115 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier14;
                        interfaceC0526Fp7 = interfaceC0526Fp19;
                        shape2 = shape13;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier15 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp4;
                        Shape shape14 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider12 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1116 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1117 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp110, interfaceC0526Fp6, i3)), richTooltipPositionProvider12, modifier15, shape14, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1117 & 234881024) | ((i3 << 6) & 57344) | (i1116 & 7168) | (i1117 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier15;
                        interfaceC0526Fp7 = interfaceC0526Fp110;
                        shape2 = shape14;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if ((i & 458752) == 0) {
                    richTooltipContainerShape = shape;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    richTooltipContainerShape = shape;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier16 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp4;
                        Shape shape15 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider13 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1118 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1119 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111, interfaceC0526Fp6, i3)), richTooltipPositionProvider13, modifier16, shape15, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1119 & 234881024) | ((i3 << 6) & 57344) | (i1118 & 7168) | (i1119 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier16;
                        interfaceC0526Fp7 = interfaceC0526Fp111;
                        shape2 = shape15;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier17 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp4;
                        Shape shape16 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider14 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i11110 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i11111 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp112, interfaceC0526Fp6, i3)), richTooltipPositionProvider14, modifier17, shape16, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111 & 234881024) | ((i3 << 6) & 57344) | (i11110 & 7168) | (i11111 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier17;
                        interfaceC0526Fp7 = interfaceC0526Fp112;
                        shape2 = shape16;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i10 = 12582912;
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier18 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp4;
                    Shape shape17 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider15 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11112 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11113 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp113, interfaceC0526Fp6, i3)), richTooltipPositionProvider15, modifier18, shape17, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11113 & 234881024) | ((i3 << 6) & 57344) | (i11112 & 7168) | (i11113 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier18;
                    interfaceC0526Fp7 = interfaceC0526Fp113;
                    shape2 = shape17;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier19 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp4;
                    Shape shape18 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider16 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11114 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11115 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp114, interfaceC0526Fp6, i3)), richTooltipPositionProvider16, modifier19, shape18, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11115 & 234881024) | ((i3 << 6) & 57344) | (i11114 & 7168) | (i11115 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier19;
                    interfaceC0526Fp7 = interfaceC0526Fp114;
                    shape2 = shape18;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            richTooltipState2 = richTooltipState;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & 458752) == 0) {
                        richTooltipContainerShape = shape;
                        if ((i2 & 32) == 0) {
                            i12 = 65536;
                        } else {
                            i12 = 65536;
                        }
                        i3 |= i12;
                    } else {
                        richTooltipContainerShape = shape;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 128) != 0) {
                        if ((29360128 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 8388608;
                            } else {
                                i10 = 4194304;
                            }
                        }
                        if ((23967451 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier110 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp4;
                            Shape shape19 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider17 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i11116 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i11117 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp115, interfaceC0526Fp6, i3)), richTooltipPositionProvider17, modifier110, shape19, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11117 & 234881024) | ((i3 << 6) & 57344) | (i11116 & 7168) | (i11117 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier110;
                            interfaceC0526Fp7 = interfaceC0526Fp115;
                            shape2 = shape19;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier111 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp116 = interfaceC0526Fp4;
                            Shape shape110 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider18 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i11118 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i11119 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp116, interfaceC0526Fp6, i3)), richTooltipPositionProvider18, modifier111, shape110, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11119 & 234881024) | ((i3 << 6) & 57344) | (i11118 & 7168) | (i11119 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier111;
                            interfaceC0526Fp7 = interfaceC0526Fp116;
                            shape2 = shape110;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                    }
                    i10 = 12582912;
                    i3 |= i10;
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier112 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp117 = interfaceC0526Fp4;
                        Shape shape111 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider19 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111110 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp117, interfaceC0526Fp6, i3)), richTooltipPositionProvider19, modifier112, shape111, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111 & 234881024) | ((i3 << 6) & 57344) | (i111110 & 7168) | (i111111 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier112;
                        interfaceC0526Fp7 = interfaceC0526Fp117;
                        shape2 = shape111;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier113 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp118 = interfaceC0526Fp4;
                        Shape shape112 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider110 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111112 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111113 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp118, interfaceC0526Fp6, i3)), richTooltipPositionProvider110, modifier113, shape112, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111113 & 234881024) | ((i3 << 6) & 57344) | (i111112 & 7168) | (i111113 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier113;
                        interfaceC0526Fp7 = interfaceC0526Fp118;
                        shape2 = shape112;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if ((i & 458752) == 0) {
                    richTooltipContainerShape = shape;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    richTooltipContainerShape = shape;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier114 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp119 = interfaceC0526Fp4;
                        Shape shape113 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider111 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111114 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111115 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp119, interfaceC0526Fp6, i3)), richTooltipPositionProvider111, modifier114, shape113, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111115 & 234881024) | ((i3 << 6) & 57344) | (i111114 & 7168) | (i111115 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier114;
                        interfaceC0526Fp7 = interfaceC0526Fp119;
                        shape2 = shape113;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier115 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp1110 = interfaceC0526Fp4;
                        Shape shape114 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider112 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111116 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111117 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1110, interfaceC0526Fp6, i3)), richTooltipPositionProvider112, modifier115, shape114, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111117 & 234881024) | ((i3 << 6) & 57344) | (i111116 & 7168) | (i111117 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier115;
                        interfaceC0526Fp7 = interfaceC0526Fp1110;
                        shape2 = shape114;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i10 = 12582912;
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier116 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1111 = interfaceC0526Fp4;
                    Shape shape115 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider113 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i111118 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i111119 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111, interfaceC0526Fp6, i3)), richTooltipPositionProvider113, modifier116, shape115, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111119 & 234881024) | ((i3 << 6) & 57344) | (i111118 & 7168) | (i111119 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier116;
                    interfaceC0526Fp7 = interfaceC0526Fp1111;
                    shape2 = shape115;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier117 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1112 = interfaceC0526Fp4;
                    Shape shape116 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider114 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111110 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1112, interfaceC0526Fp6, i3)), richTooltipPositionProvider114, modifier117, shape116, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111 & 234881024) | ((i3 << 6) & 57344) | (i1111110 & 7168) | (i1111111 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier117;
                    interfaceC0526Fp7 = interfaceC0526Fp1112;
                    shape2 = shape116;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & 458752) == 0) {
                    richTooltipContainerShape = shape;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    richTooltipContainerShape = shape;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier118 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp1113 = interfaceC0526Fp4;
                        Shape shape117 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider115 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1111112 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1111113 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1113, interfaceC0526Fp6, i3)), richTooltipPositionProvider115, modifier118, shape117, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111113 & 234881024) | ((i3 << 6) & 57344) | (i1111112 & 7168) | (i1111113 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier118;
                        interfaceC0526Fp7 = interfaceC0526Fp1113;
                        shape2 = shape117;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier119 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp1114 = interfaceC0526Fp4;
                        Shape shape118 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider116 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1111114 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1111115 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1114, interfaceC0526Fp6, i3)), richTooltipPositionProvider116, modifier119, shape118, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111115 & 234881024) | ((i3 << 6) & 57344) | (i1111114 & 7168) | (i1111115 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier119;
                        interfaceC0526Fp7 = interfaceC0526Fp1114;
                        shape2 = shape118;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i10 = 12582912;
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier1110 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1115 = interfaceC0526Fp4;
                    Shape shape119 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider117 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111116 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111117 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1115, interfaceC0526Fp6, i3)), richTooltipPositionProvider117, modifier1110, shape119, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111117 & 234881024) | ((i3 << 6) & 57344) | (i1111116 & 7168) | (i1111117 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1110;
                    interfaceC0526Fp7 = interfaceC0526Fp1115;
                    shape2 = shape119;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier1111 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1116 = interfaceC0526Fp4;
                    Shape shape1110 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider118 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111118 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111119 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1116, interfaceC0526Fp6, i3)), richTooltipPositionProvider118, modifier1111, shape1110, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111119 & 234881024) | ((i3 << 6) & 57344) | (i1111118 & 7168) | (i1111119 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111;
                    interfaceC0526Fp7 = interfaceC0526Fp1116;
                    shape2 = shape1110;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((i & 458752) == 0) {
                richTooltipContainerShape = shape;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                richTooltipContainerShape = shape;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier1112 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1117 = interfaceC0526Fp4;
                    Shape shape1111 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider119 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11111110 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11111111 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1117, interfaceC0526Fp6, i3)), richTooltipPositionProvider119, modifier1112, shape1111, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111 & 234881024) | ((i3 << 6) & 57344) | (i11111110 & 7168) | (i11111111 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1112;
                    interfaceC0526Fp7 = interfaceC0526Fp1117;
                    shape2 = shape1111;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier1113 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1118 = interfaceC0526Fp4;
                    Shape shape1112 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider1110 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11111112 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11111113 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1118, interfaceC0526Fp6, i3)), richTooltipPositionProvider1110, modifier1113, shape1112, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111113 & 234881024) | ((i3 << 6) & 57344) | (i11111112 & 7168) | (i11111113 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1113;
                    interfaceC0526Fp7 = interfaceC0526Fp1118;
                    shape2 = shape1112;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i10 = 12582912;
            i3 |= i10;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier1114 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp1119 = interfaceC0526Fp4;
                Shape shape1113 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider1111 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111114 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111115 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1119, interfaceC0526Fp6, i3)), richTooltipPositionProvider1111, modifier1114, shape1113, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111115 & 234881024) | ((i3 << 6) & 57344) | (i11111114 & 7168) | (i11111115 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1114;
                interfaceC0526Fp7 = interfaceC0526Fp1119;
                shape2 = shape1113;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier1115 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp11110 = interfaceC0526Fp4;
                Shape shape1114 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider1112 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111116 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111117 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11110, interfaceC0526Fp6, i3)), richTooltipPositionProvider1112, modifier1115, shape1114, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111117 & 234881024) | ((i3 << 6) & 57344) | (i11111116 & 7168) | (i11111117 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1115;
                interfaceC0526Fp7 = interfaceC0526Fp11110;
                shape2 = shape1114;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                richTooltipState2 = richTooltipState;
                if (composerStartRestartGroup.changed(richTooltipState2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & 458752) == 0) {
                        richTooltipContainerShape = shape;
                        if ((i2 & 32) == 0) {
                            i12 = 65536;
                        } else {
                            i12 = 65536;
                        }
                        i3 |= i12;
                    } else {
                        richTooltipContainerShape = shape;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 128) != 0) {
                        if ((29360128 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 8388608;
                            } else {
                                i10 = 4194304;
                            }
                        }
                        if ((23967451 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier1116 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp11111 = interfaceC0526Fp4;
                            Shape shape1115 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider1113 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i11111118 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i11111119 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11111, interfaceC0526Fp6, i3)), richTooltipPositionProvider1113, modifier1116, shape1115, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111119 & 234881024) | ((i3 << 6) & 57344) | (i11111118 & 7168) | (i11111119 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier1116;
                            interfaceC0526Fp7 = interfaceC0526Fp11111;
                            shape2 = shape1115;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            } else {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new RichTooltipState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                if (i8 != 0) {
                                    interfaceC0526Fp5 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                                }
                            }
                            Modifier modifier1117 = modifier2;
                            InterfaceC0526Fp interfaceC0526Fp11112 = interfaceC0526Fp4;
                            Shape shape1116 = richTooltipContainerShape;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            richTooltipState3 = richTooltipState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                            }
                            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            RichTooltipPositionProvider richTooltipPositionProvider1114 = (RichTooltipPositionProvider) objRememberedValue2;
                            int i111111110 = i3 >> 6;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                            int i111111111 = i3 << 3;
                            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11112, interfaceC0526Fp6, i3)), richTooltipPositionProvider1114, modifier1117, shape1116, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111 & 234881024) | ((i3 << 6) & 57344) | (i111111110 & 7168) | (i111111111 & 896) | 14155830);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier1117;
                            interfaceC0526Fp7 = interfaceC0526Fp11112;
                            shape2 = shape1116;
                            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            richTooltipState4 = richTooltipState3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                    }
                    i10 = 12582912;
                    i3 |= i10;
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier1118 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp11113 = interfaceC0526Fp4;
                        Shape shape1117 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider1115 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111111112 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111113 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11113, interfaceC0526Fp6, i3)), richTooltipPositionProvider1115, modifier1118, shape1117, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111113 & 234881024) | ((i3 << 6) & 57344) | (i111111112 & 7168) | (i111111113 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1118;
                        interfaceC0526Fp7 = interfaceC0526Fp11113;
                        shape2 = shape1117;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier1119 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp11114 = interfaceC0526Fp4;
                        Shape shape1118 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider1116 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111111114 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111115 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11114, interfaceC0526Fp6, i3)), richTooltipPositionProvider1116, modifier1119, shape1118, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111115 & 234881024) | ((i3 << 6) & 57344) | (i111111114 & 7168) | (i111111115 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1119;
                        interfaceC0526Fp7 = interfaceC0526Fp11114;
                        shape2 = shape1118;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if ((i & 458752) == 0) {
                    richTooltipContainerShape = shape;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    richTooltipContainerShape = shape;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier11110 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp11115 = interfaceC0526Fp4;
                        Shape shape1119 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider1117 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111111116 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111117 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11115, interfaceC0526Fp6, i3)), richTooltipPositionProvider1117, modifier11110, shape1119, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111117 & 234881024) | ((i3 << 6) & 57344) | (i111111116 & 7168) | (i111111117 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11110;
                        interfaceC0526Fp7 = interfaceC0526Fp11115;
                        shape2 = shape1119;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier11111 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp11116 = interfaceC0526Fp4;
                        Shape shape11110 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider1118 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111111118 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111119 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11116, interfaceC0526Fp6, i3)), richTooltipPositionProvider1118, modifier11111, shape11110, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111119 & 234881024) | ((i3 << 6) & 57344) | (i111111118 & 7168) | (i111111119 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11111;
                        interfaceC0526Fp7 = interfaceC0526Fp11116;
                        shape2 = shape11110;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i10 = 12582912;
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier11112 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp11117 = interfaceC0526Fp4;
                    Shape shape11111 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider1119 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111111110 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111111 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11117, interfaceC0526Fp6, i3)), richTooltipPositionProvider1119, modifier11112, shape11111, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111111 & 234881024) | ((i3 << 6) & 57344) | (i1111111110 & 7168) | (i1111111111 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11112;
                    interfaceC0526Fp7 = interfaceC0526Fp11117;
                    shape2 = shape11111;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier11113 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp11118 = interfaceC0526Fp4;
                    Shape shape11112 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider11110 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111111112 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111113 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11118, interfaceC0526Fp6, i3)), richTooltipPositionProvider11110, modifier11113, shape11112, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111113 & 234881024) | ((i3 << 6) & 57344) | (i1111111112 & 7168) | (i1111111113 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11113;
                    interfaceC0526Fp7 = interfaceC0526Fp11118;
                    shape2 = shape11112;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & 458752) == 0) {
                    richTooltipContainerShape = shape;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    richTooltipContainerShape = shape;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier11114 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp11119 = interfaceC0526Fp4;
                        Shape shape11113 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider11111 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1111111114 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1111111115 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11119, interfaceC0526Fp6, i3)), richTooltipPositionProvider11111, modifier11114, shape11113, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111115 & 234881024) | ((i3 << 6) & 57344) | (i1111111114 & 7168) | (i1111111115 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11114;
                        interfaceC0526Fp7 = interfaceC0526Fp11119;
                        shape2 = shape11113;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier11115 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp111110 = interfaceC0526Fp4;
                        Shape shape11114 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider11112 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i1111111116 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i1111111117 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111110, interfaceC0526Fp6, i3)), richTooltipPositionProvider11112, modifier11115, shape11114, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111117 & 234881024) | ((i3 << 6) & 57344) | (i1111111116 & 7168) | (i1111111117 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11115;
                        interfaceC0526Fp7 = interfaceC0526Fp111110;
                        shape2 = shape11114;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i10 = 12582912;
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier11116 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp111111 = interfaceC0526Fp4;
                    Shape shape11115 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider11113 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111111118 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111119 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111111, interfaceC0526Fp6, i3)), richTooltipPositionProvider11113, modifier11116, shape11115, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111119 & 234881024) | ((i3 << 6) & 57344) | (i1111111118 & 7168) | (i1111111119 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11116;
                    interfaceC0526Fp7 = interfaceC0526Fp111111;
                    shape2 = shape11115;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier11117 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp111112 = interfaceC0526Fp4;
                    Shape shape11116 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider11114 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11111111110 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11111111111 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111112, interfaceC0526Fp6, i3)), richTooltipPositionProvider11114, modifier11117, shape11116, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111111 & 234881024) | ((i3 << 6) & 57344) | (i11111111110 & 7168) | (i11111111111 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11117;
                    interfaceC0526Fp7 = interfaceC0526Fp111112;
                    shape2 = shape11116;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((i & 458752) == 0) {
                richTooltipContainerShape = shape;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                richTooltipContainerShape = shape;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier11118 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp111113 = interfaceC0526Fp4;
                    Shape shape11117 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider11115 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11111111112 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11111111113 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111113, interfaceC0526Fp6, i3)), richTooltipPositionProvider11115, modifier11118, shape11117, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111113 & 234881024) | ((i3 << 6) & 57344) | (i11111111112 & 7168) | (i11111111113 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11118;
                    interfaceC0526Fp7 = interfaceC0526Fp111113;
                    shape2 = shape11117;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier11119 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp111114 = interfaceC0526Fp4;
                    Shape shape11118 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider11116 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i11111111114 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i11111111115 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111114, interfaceC0526Fp6, i3)), richTooltipPositionProvider11116, modifier11119, shape11118, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111115 & 234881024) | ((i3 << 6) & 57344) | (i11111111114 & 7168) | (i11111111115 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11119;
                    interfaceC0526Fp7 = interfaceC0526Fp111114;
                    shape2 = shape11118;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i10 = 12582912;
            i3 |= i10;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier111110 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp111115 = interfaceC0526Fp4;
                Shape shape11119 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider11117 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111111116 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111111117 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111115, interfaceC0526Fp6, i3)), richTooltipPositionProvider11117, modifier111110, shape11119, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111117 & 234881024) | ((i3 << 6) & 57344) | (i11111111116 & 7168) | (i11111111117 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111110;
                interfaceC0526Fp7 = interfaceC0526Fp111115;
                shape2 = shape11119;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier111111 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp111116 = interfaceC0526Fp4;
                Shape shape111110 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider11118 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111111118 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111111119 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111116, interfaceC0526Fp6, i3)), richTooltipPositionProvider11118, modifier111111, shape111110, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111119 & 234881024) | ((i3 << 6) & 57344) | (i11111111118 & 7168) | (i11111111119 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111111;
                interfaceC0526Fp7 = interfaceC0526Fp111116;
                shape2 = shape111110;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        richTooltipState2 = richTooltipState;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp4 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & 458752) == 0) {
                    richTooltipContainerShape = shape;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    richTooltipContainerShape = shape;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier111112 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp111117 = interfaceC0526Fp4;
                        Shape shape111111 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider11119 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111111111110 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111111111 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111117, interfaceC0526Fp6, i3)), richTooltipPositionProvider11119, modifier111112, shape111111, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111111 & 234881024) | ((i3 << 6) & 57344) | (i111111111110 & 7168) | (i111111111111 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111112;
                        interfaceC0526Fp7 = interfaceC0526Fp111117;
                        shape2 = shape111111;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new RichTooltipState();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                richTooltipState2 = (RichTooltipState) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            } else {
                                richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                            }
                        }
                        Modifier modifier111113 = modifier2;
                        InterfaceC0526Fp interfaceC0526Fp111118 = interfaceC0526Fp4;
                        Shape shape111112 = richTooltipContainerShape;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        richTooltipState3 = richTooltipState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                        }
                        iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        RichTooltipPositionProvider richTooltipPositionProvider111110 = (RichTooltipPositionProvider) objRememberedValue2;
                        int i111111111112 = i3 >> 6;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                        int i111111111113 = i3 << 3;
                        m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111118, interfaceC0526Fp6, i3)), richTooltipPositionProvider111110, modifier111113, shape111112, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111113 & 234881024) | ((i3 << 6) & 57344) | (i111111111112 & 7168) | (i111111111113 & 896) | 14155830);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111113;
                        interfaceC0526Fp7 = interfaceC0526Fp111118;
                        shape2 = shape111112;
                        richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        richTooltipState4 = richTooltipState3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
                }
                i10 = 12582912;
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier111114 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp111119 = interfaceC0526Fp4;
                    Shape shape111113 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider111111 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i111111111114 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i111111111115 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp111119, interfaceC0526Fp6, i3)), richTooltipPositionProvider111111, modifier111114, shape111113, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111115 & 234881024) | ((i3 << 6) & 57344) | (i111111111114 & 7168) | (i111111111115 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111114;
                    interfaceC0526Fp7 = interfaceC0526Fp111119;
                    shape2 = shape111113;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier111115 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1111110 = interfaceC0526Fp4;
                    Shape shape111114 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider111112 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i111111111116 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i111111111117 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111110, interfaceC0526Fp6, i3)), richTooltipPositionProvider111112, modifier111115, shape111114, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111117 & 234881024) | ((i3 << 6) & 57344) | (i111111111116 & 7168) | (i111111111117 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111115;
                    interfaceC0526Fp7 = interfaceC0526Fp1111110;
                    shape2 = shape111114;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((i & 458752) == 0) {
                richTooltipContainerShape = shape;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                richTooltipContainerShape = shape;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier111116 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1111111 = interfaceC0526Fp4;
                    Shape shape111115 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider111113 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i111111111118 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i111111111119 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111111, interfaceC0526Fp6, i3)), richTooltipPositionProvider111113, modifier111116, shape111115, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111119 & 234881024) | ((i3 << 6) & 57344) | (i111111111118 & 7168) | (i111111111119 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111116;
                    interfaceC0526Fp7 = interfaceC0526Fp1111111;
                    shape2 = shape111115;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier111117 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1111112 = interfaceC0526Fp4;
                    Shape shape111116 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider111114 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111111111110 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111111111 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111112, interfaceC0526Fp6, i3)), richTooltipPositionProvider111114, modifier111117, shape111116, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111111111 & 234881024) | ((i3 << 6) & 57344) | (i1111111111110 & 7168) | (i1111111111111 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111117;
                    interfaceC0526Fp7 = interfaceC0526Fp1111112;
                    shape2 = shape111116;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i10 = 12582912;
            i3 |= i10;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier111118 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp1111113 = interfaceC0526Fp4;
                Shape shape111117 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider111115 = (RichTooltipPositionProvider) objRememberedValue2;
                int i1111111111112 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i1111111111113 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111113, interfaceC0526Fp6, i3)), richTooltipPositionProvider111115, modifier111118, shape111117, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111111113 & 234881024) | ((i3 << 6) & 57344) | (i1111111111112 & 7168) | (i1111111111113 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111118;
                interfaceC0526Fp7 = interfaceC0526Fp1111113;
                shape2 = shape111117;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier111119 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp1111114 = interfaceC0526Fp4;
                Shape shape111118 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider111116 = (RichTooltipPositionProvider) objRememberedValue2;
                int i1111111111114 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i1111111111115 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111114, interfaceC0526Fp6, i3)), richTooltipPositionProvider111116, modifier111119, shape111118, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111111115 & 234881024) | ((i3 << 6) & 57344) | (i1111111111114 & 7168) | (i1111111111115 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111119;
                interfaceC0526Fp7 = interfaceC0526Fp1111114;
                shape2 = shape111118;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        interfaceC0526Fp4 = interfaceC0526Fp2;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 57344) == 0) {
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i & 458752) == 0) {
                richTooltipContainerShape = shape;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                richTooltipContainerShape = shape;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier1111110 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1111115 = interfaceC0526Fp4;
                    Shape shape111119 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider111117 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111111111116 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111111117 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111115, interfaceC0526Fp6, i3)), richTooltipPositionProvider111117, modifier1111110, shape111119, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111111117 & 234881024) | ((i3 << 6) & 57344) | (i1111111111116 & 7168) | (i1111111111117 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111110;
                    interfaceC0526Fp7 = interfaceC0526Fp1111115;
                    shape2 = shape111119;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new RichTooltipState();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            richTooltipState2 = (RichTooltipState) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        } else {
                            richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                        }
                    }
                    Modifier modifier1111111 = modifier2;
                    InterfaceC0526Fp interfaceC0526Fp1111116 = interfaceC0526Fp4;
                    Shape shape1111110 = richTooltipContainerShape;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    richTooltipState3 = richTooltipState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                    }
                    iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    RichTooltipPositionProvider richTooltipPositionProvider111118 = (RichTooltipPositionProvider) objRememberedValue2;
                    int i1111111111118 = i3 >> 6;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                    int i1111111111119 = i3 << 3;
                    m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111116, interfaceC0526Fp6, i3)), richTooltipPositionProvider111118, modifier1111111, shape1111110, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i1111111111119 & 234881024) | ((i3 << 6) & 57344) | (i1111111111118 & 7168) | (i1111111111119 & 896) | 14155830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111111;
                    interfaceC0526Fp7 = interfaceC0526Fp1111116;
                    shape2 = shape1111110;
                    richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    richTooltipState4 = richTooltipState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
            }
            i10 = 12582912;
            i3 |= i10;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier1111112 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp1111117 = interfaceC0526Fp4;
                Shape shape1111111 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider111119 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111111111110 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111111111111 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111117, interfaceC0526Fp6, i3)), richTooltipPositionProvider111119, modifier1111112, shape1111111, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111111111 & 234881024) | ((i3 << 6) & 57344) | (i11111111111110 & 7168) | (i11111111111111 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111112;
                interfaceC0526Fp7 = interfaceC0526Fp1111117;
                shape2 = shape1111111;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier1111113 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp1111118 = interfaceC0526Fp4;
                Shape shape1111112 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider1111110 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111111111112 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111111111113 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111118, interfaceC0526Fp6, i3)), richTooltipPositionProvider1111110, modifier1111113, shape1111112, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111111113 & 234881024) | ((i3 << 6) & 57344) | (i11111111111112 & 7168) | (i11111111111113 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111113;
                interfaceC0526Fp7 = interfaceC0526Fp1111118;
                shape2 = shape1111112;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        interfaceC0526Fp5 = interfaceC0526Fp3;
        if ((i & 458752) == 0) {
            richTooltipContainerShape = shape;
            if ((i2 & 32) == 0) {
                i12 = 65536;
            } else {
                i12 = 65536;
            }
            i3 |= i12;
        } else {
            richTooltipContainerShape = shape;
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier1111114 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp1111119 = interfaceC0526Fp4;
                Shape shape1111113 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider1111111 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111111111114 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111111111115 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp1111119, interfaceC0526Fp6, i3)), richTooltipPositionProvider1111111, modifier1111114, shape1111113, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111111115 & 234881024) | ((i3 << 6) & 57344) | (i11111111111114 & 7168) | (i11111111111115 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111114;
                interfaceC0526Fp7 = interfaceC0526Fp1111119;
                shape2 = shape1111113;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new RichTooltipState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        richTooltipState2 = (RichTooltipState) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    } else {
                        richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                    }
                }
                Modifier modifier1111115 = modifier2;
                InterfaceC0526Fp interfaceC0526Fp11111110 = interfaceC0526Fp4;
                Shape shape1111114 = richTooltipContainerShape;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                richTooltipState3 = richTooltipState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
                }
                iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                RichTooltipPositionProvider richTooltipPositionProvider1111112 = (RichTooltipPositionProvider) objRememberedValue2;
                int i11111111111116 = i3 >> 6;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
                int i11111111111117 = i3 << 3;
                m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11111110, interfaceC0526Fp6, i3)), richTooltipPositionProvider1111112, modifier1111115, shape1111114, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111111117 & 234881024) | ((i3 << 6) & 57344) | (i11111111111116 & 7168) | (i11111111111117 & 896) | 14155830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111115;
                interfaceC0526Fp7 = interfaceC0526Fp11111110;
                shape2 = shape1111114;
                richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                richTooltipState4 = richTooltipState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
        }
        i10 = 12582912;
        i3 |= i10;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new RichTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i8 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new RichTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i8 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                }
            }
            Modifier modifier1111116 = modifier2;
            InterfaceC0526Fp interfaceC0526Fp11111111 = interfaceC0526Fp4;
            Shape shape1111115 = richTooltipContainerShape;
            interfaceC0526Fp6 = interfaceC0526Fp5;
            richTooltipState3 = richTooltipState2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
            }
            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            RichTooltipPositionProvider richTooltipPositionProvider1111113 = (RichTooltipPositionProvider) objRememberedValue2;
            int i11111111111118 = i3 >> 6;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
            int i11111111111119 = i3 << 3;
            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11111111, interfaceC0526Fp6, i3)), richTooltipPositionProvider1111113, modifier1111116, shape1111115, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i11111111111119 & 234881024) | ((i3 << 6) & 57344) | (i11111111111118 & 7168) | (i11111111111119 & 896) | 14155830);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier1111116;
            interfaceC0526Fp7 = interfaceC0526Fp11111111;
            shape2 = shape1111115;
            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            richTooltipState4 = richTooltipState3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new RichTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i8 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new RichTooltipState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    richTooltipState2 = (RichTooltipState) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i8 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = TooltipDefaults.INSTANCE.m2044richTooltipColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                } else {
                    richTooltipColorsM2044richTooltipColorsro_MJ88 = richTooltipColors;
                }
            }
            Modifier modifier1111117 = modifier2;
            InterfaceC0526Fp interfaceC0526Fp11111112 = interfaceC0526Fp4;
            Shape shape1111116 = richTooltipContainerShape;
            interfaceC0526Fp6 = interfaceC0526Fp5;
            richTooltipState3 = richTooltipState2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(180959998, i3, -1, "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)");
            }
            iMo327roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo327roundToPx0680j_4(TooltipAnchorPadding);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new RichTooltipPositionProvider(iMo327roundToPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            RichTooltipPositionProvider richTooltipPositionProvider1111114 = (RichTooltipPositionProvider) objRememberedValue2;
            int i111111111111110 = i3 >> 6;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(richTooltipState3) | composerStartRestartGroup.changed(interfaceC0526Fp6);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new TooltipKt$RichTooltipBox$2$1(richTooltipState3, interfaceC0526Fp6);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 0);
            int i111111111111111 = i3 << 3;
            m2047TooltipBoxXDn_Kpo(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1423372873, true, new AnonymousClass3(richTooltipColorsM2044richTooltipColorsro_MJ88, interfaceC0526Fp, interfaceC0526Fp11111112, interfaceC0526Fp6, i3)), richTooltipPositionProvider1111114, modifier1111117, shape1111116, richTooltipState3, richTooltipColorsM2044richTooltipColorsro_MJ88.m1722getContainerColor0d7_KjU(), RichTooltipTokens.INSTANCE.m2489getContainerElevationD9Ej5fM(), RichTooltipMaxWidth, interfaceC0552Gp, composerStartRestartGroup, (i111111111111111 & 234881024) | ((i3 << 6) & 57344) | (i111111111111110 & 7168) | (i111111111111111 & 896) | 14155830);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier1111117;
            interfaceC0526Fp7 = interfaceC0526Fp11111112;
            shape2 = shape1111116;
            richTooltipColors2 = richTooltipColorsM2044richTooltipColorsro_MJ88;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            richTooltipState4 = richTooltipState3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, modifier3, richTooltipState4, interfaceC0526Fp7, interfaceC0526Fp8, shape2, richTooltipColors2, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void RichTooltipImpl(RichTooltipColors richTooltipColors, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-878950288);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(richTooltipColors) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-878950288, i2, -1, "androidx.compose.material3.RichTooltipImpl (Tooltip.kt:296)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(composerStartRestartGroup, 6);
            RichTooltipTokens richTooltipTokens = RichTooltipTokens.INSTANCE;
            TextStyle textStyleFromToken = TypographyKt.fromToken(typography, richTooltipTokens.getActionLabelTextFont());
            TextStyle textStyleFromToken2 = TypographyKt.fromToken(materialTheme.getTypography(composerStartRestartGroup, 6), richTooltipTokens.getSubheadFont());
            TextStyle textStyleFromToken3 = TypographyKt.fromToken(materialTheme.getTypography(composerStartRestartGroup, 6), richTooltipTokens.getSupportingTextFont());
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(companion, RichTooltipHorizontalPadding, 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM487paddingVpY3zN4$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(51873568);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierM374paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m374paddingFromBaselineVpY3zN4$default(companion, HeightToSubheadFirstLine, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor2 = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM374paddingFromBaselineVpY3zN4$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(richTooltipColors.m1724getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(textStyleFromToken2)}, interfaceC0526Fp2, composerStartRestartGroup, 8);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                FW fw = FW.a;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierTextVerticalPadding = textVerticalPadding(companion, interfaceC0526Fp2 != null, interfaceC0526Fp3 != null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor3 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierTextVerticalPadding);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(richTooltipColors.m1723getContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(textStyleFromToken3)}, interfaceC0526Fp, composerStartRestartGroup, (i2 & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(75391440);
            if (interfaceC0526Fp3 != null) {
                Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(SizeKt.m523requiredHeightInVpY3zN4$default(companion, ActionLabelMinHeight, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, ActionLabelBottomPadding, 7, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor4 = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion3.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(richTooltipColors.m1721getActionContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(textStyleFromToken)}, interfaceC0526Fp3, composerStartRestartGroup, 8);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                FW fw2 = FW.a;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(richTooltipColors, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TooltipBox-XDn_Kpo, reason: not valid java name */
    public static final void m2047TooltipBoxXDn_Kpo(InterfaceC0526Fp interfaceC0526Fp, PopupPositionProvider popupPositionProvider, Modifier modifier, Shape shape, final TooltipState tooltipState, long j, float f, float f2, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1415647894);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(popupPositionProvider) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(tooltipState) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415647894, i2, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:188)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Strings.Companion companion2 = Strings.Companion;
            final String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion2.m1839getTooltipLongPressLabeladMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new TooltipBoxScope() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1
                    @Override // androidx.compose.material3.TooltipBoxScope
                    public Modifier tooltipAnchor(Modifier modifier2) {
                        AbstractC4492zt.h(modifier2, "<this>");
                        TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$onLongPress$1 tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$onLongPress$1 = new TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$onLongPress$1(coroutineScope, tooltipState);
                        return SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput(modifier2, tooltipState, new TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$onLongPress$1, null)), true, new TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$2(strM1841getStringNWtq28, tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$onLongPress$1));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$1 = (TooltipKt$TooltipBox$scope$1$1) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion3 = Modifier.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion4.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion4.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion4.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(tooltipState.isVisible()), "Tooltip transition", composerStartRestartGroup, 48, 0);
            composerStartRestartGroup.startReplaceableGroup(-1995827526);
            if (((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue() || ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue()) {
                TooltipPopup_androidKt.TooltipPopup(popupPositionProvider, new TooltipKt$TooltipBox$1$1(tooltipState, coroutineScope), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -442150991, true, new TooltipKt$TooltipBox$1$2(modifier, f2, transitionUpdateTransition, Strings_androidKt.m1841getStringNWtq28(companion2.m1840getTooltipPaneDescriptionadMyvUU(), composerStartRestartGroup, 6), shape, j, f, interfaceC0526Fp, i2)), composerStartRestartGroup, ((i2 >> 3) & 14) | 384);
            }
            composerStartRestartGroup.endReplaceableGroup();
            interfaceC0552Gp.invoke(tooltipKt$TooltipBox$scope$1$1, composerStartRestartGroup, Integer.valueOf(((i2 >> 21) & 112) | 6));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TooltipKt$TooltipBox$2(interfaceC0526Fp, popupPositionProvider, modifier, shape, tooltipState, j, f, f2, interfaceC0552Gp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier animateTooltip(Modifier modifier, Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1(transition) : InspectableValueKt.getNoInspectorInfo(), new C16052(transition));
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    private static final Modifier textVerticalPadding(Modifier modifier, boolean z, boolean z2) {
        return (z || z2) ? PaddingKt.m489paddingqDBjuR0$default(AlignmentLineKt.m374paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null) : PaddingKt.m487paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, null);
    }
}
