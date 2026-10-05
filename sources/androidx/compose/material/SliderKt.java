package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2304gk;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.C1172Zk;
import defpackage.C2020dG;
import defpackage.E8;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.JL;
import defpackage.KJ;
import defpackage.LJ;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbRadius = Dp.m5160constructorimpl(10);
    private static final float ThumbRippleRadius = Dp.m5160constructorimpl(24);
    private static final float ThumbDefaultElevation = Dp.m5160constructorimpl(1);
    private static final float ThumbPressedElevation = Dp.m5160constructorimpl(6);
    private static final float TrackHeight = Dp.m5160constructorimpl(4);

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$CorrectValueSideEffect$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC3750qp $scaleToOffset;
        final /* synthetic */ InterfaceC0789Ob $trackRange;
        final /* synthetic */ float $value;
        final /* synthetic */ InterfaceC0789Ob $valueRange;
        final /* synthetic */ MutableState<Float> $valueState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp, InterfaceC0789Ob interfaceC0789Ob, InterfaceC0789Ob interfaceC0789Ob2, MutableState<Float> mutableState, float f, int i) {
            super(2);
            this.$scaleToOffset = interfaceC3750qp;
            this.$valueRange = interfaceC0789Ob;
            this.$trackRange = interfaceC0789Ob2;
            this.$valueState = mutableState;
            this.$value = f;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SliderKt.CorrectValueSideEffect(this.$scaleToOffset, this.$valueRange, this.$trackRange, this.$valueState, this.$value, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14352 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ InterfaceC0789Ob $value;
        final /* synthetic */ InterfaceC0789Ob $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$2, reason: invalid class name and collision with other inner class name */
        public /* synthetic */ class C00822 extends C0916Sp implements InterfaceC3750qp {
            final /* synthetic */ LJ $maxPx;
            final /* synthetic */ LJ $minPx;
            final /* synthetic */ InterfaceC0789Ob $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00822(InterfaceC0789Ob interfaceC0789Ob, LJ lj, LJ lj2) {
                super(1, AbstractC4492zt.a.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = interfaceC0789Ob;
                this.$minPx = lj;
                this.$maxPx = lj2;
            }

            public final Float invoke(float f) {
                return Float.valueOf(C14352.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$3, reason: invalid class name */
        public /* synthetic */ class AnonymousClass3 extends C0916Sp implements InterfaceC3750qp {
            final /* synthetic */ LJ $maxPx;
            final /* synthetic */ LJ $minPx;
            final /* synthetic */ InterfaceC0789Ob $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(InterfaceC0789Ob interfaceC0789Ob, LJ lj, LJ lj2) {
                super(1, AbstractC4492zt.a.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = interfaceC0789Ob;
                this.$minPx = lj;
                this.$maxPx = lj2;
            }

            public final Float invoke(float f) {
                return Float.valueOf(C14352.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14352(InterfaceC0789Ob interfaceC0789Ob, InterfaceC0789Ob interfaceC0789Ob2, int i, State<? extends InterfaceC3750qp> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i2, InterfaceC3588op interfaceC3588op, List<Float> list, SliderColors sliderColors) {
            super(3);
            this.$valueRange = interfaceC0789Ob;
            this.$value = interfaceC0789Ob2;
            this.$$dirty = i;
            this.$onValueChangeState = state;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$enabled = z;
            this.$steps = i2;
            this.$onValueChangeFinished = interfaceC3588op;
            this.$tickFractions = list;
            this.$colors = sliderColors;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(InterfaceC0789Ob interfaceC0789Ob, LJ lj, LJ lj2, float f) {
            return SliderKt.scale(((Number) interfaceC0789Ob.getStart()).floatValue(), ((Number) interfaceC0789Ob.getEndInclusive()).floatValue(), f, lj.a, lj2.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC0789Ob invoke$scaleToUserValue(LJ lj, LJ lj2, InterfaceC0789Ob interfaceC0789Ob, InterfaceC0789Ob interfaceC0789Ob2) {
            return SliderKt.scale(lj.a, lj2.a, interfaceC0789Ob2, ((Number) interfaceC0789Ob.getStart()).floatValue(), ((Number) interfaceC0789Ob.getEndInclusive()).floatValue());
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
            AbstractC4492zt.h(boxWithConstraintsScope, "$this$BoxWithConstraints");
            if ((((i & 14) == 0 ? (composer.changed(boxWithConstraintsScope) ? 4 : 2) | i : i) & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652589923, i, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:314)");
            }
            boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(boxWithConstraintsScope.mo423getConstraintsmsEJaDk());
            LJ lj = new LJ();
            LJ lj2 = new LJ();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            lj.a = fM5128getMaxWidthimpl - density.mo333toPx0680j_4(SliderKt.getThumbRadius());
            lj2.a = density.mo333toPx0680j_4(SliderKt.getThumbRadius());
            InterfaceC0789Ob interfaceC0789Ob = this.$value;
            InterfaceC0789Ob interfaceC0789Ob2 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(interfaceC0789Ob2, lj2, lj, ((Number) interfaceC0789Ob.getStart()).floatValue()));
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
            InterfaceC0789Ob interfaceC0789Ob3 = this.$value;
            InterfaceC0789Ob interfaceC0789Ob4 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(interfaceC0789Ob4, lj2, lj, ((Number) interfaceC0789Ob3.getEndInclusive()).floatValue()));
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue2;
            SliderKt.CorrectValueSideEffect(new C00822(this.$valueRange, lj2, lj), this.$valueRange, AbstractC3790rJ.b(lj2.a, lj.a), mutableFloatState, ((Number) this.$value.getStart()).floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
            SliderKt.CorrectValueSideEffect(new AnonymousClass3(this.$valueRange, lj2, lj), this.$valueRange, AbstractC3790rJ.b(lj2.a, lj.a), mutableFloatState2, ((Number) this.$value.getEndInclusive()).floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
            composer.endReplaceableGroup();
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new SliderKt$RangeSlider$2$gestureEndAction$1(mutableFloatState, mutableFloatState2, this.$tickFractions, lj2, lj, this.$onValueChangeFinished, coroutineScope, this.$onValueChangeState, this.$valueRange), composer, 0);
            Object obj = this.$valueRange;
            Object objValueOf = Float.valueOf(lj2.a);
            Object objValueOf2 = Float.valueOf(lj.a);
            InterfaceC0789Ob interfaceC0789Ob5 = this.$value;
            State<InterfaceC3750qp> state = this.$onValueChangeState;
            Object[] objArr = {mutableFloatState, mutableFloatState2, obj, objValueOf, objValueOf2, interfaceC0789Ob5, state};
            InterfaceC0789Ob interfaceC0789Ob6 = this.$valueRange;
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i2 = 0; i2 < 7; i2++) {
                zChanged |= composer.changed(objArr[i2]);
            }
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new SliderKt$RangeSlider$2$onDrag$1$1(mutableFloatState, mutableFloatState2, interfaceC0789Ob5, lj2, lj, state, interfaceC0789Ob6);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(objRememberedValue4, composer, 0);
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier modifierRangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier(companion2, this.$startInteractionSource, this.$endInteractionSource, mutableFloatState, mutableFloatState2, this.$enabled, z, fM5128getMaxWidthimpl, this.$valueRange, stateRememberUpdatedState, stateRememberUpdatedState2);
            float fK = AbstractC3871sJ.k(((Number) this.$value.getStart()).floatValue(), ((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$value.getEndInclusive()).floatValue());
            float fK2 = AbstractC3871sJ.k(((Number) this.$value.getEndInclusive()).floatValue(), ((Number) this.$value.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue());
            float fCalcFraction = SliderKt.calcFraction(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), fK);
            float fCalcFraction2 = SliderKt.calcFraction(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), fK2);
            int iFloor = (int) Math.floor(this.$steps * fCalcFraction2);
            int iFloor2 = (int) Math.floor(this.$steps * (1.0f - fCalcFraction));
            boolean z2 = this.$enabled;
            Object obj2 = this.$onValueChangeState;
            Object objValueOf3 = Float.valueOf(fK2);
            State<InterfaceC3750qp> state2 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(obj2) | composer.changed(objValueOf3);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new SliderKt$RangeSlider$2$startThumbSemantics$1$1(state2, fK2);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics = SliderKt.sliderSemantics(companion2, fK, z2, (InterfaceC3750qp) objRememberedValue5, this.$onValueChangeFinished, AbstractC3790rJ.b(((Number) this.$valueRange.getStart()).floatValue(), fK2), iFloor);
            boolean z3 = this.$enabled;
            Object obj3 = this.$onValueChangeState;
            Object objValueOf4 = Float.valueOf(fK);
            State<InterfaceC3750qp> state3 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged3 = composer.changed(obj3) | composer.changed(objValueOf4);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new SliderKt$RangeSlider$2$endThumbSemantics$1$1(state3, fK);
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics2 = SliderKt.sliderSemantics(companion2, fK2, z3, (InterfaceC3750qp) objRememberedValue6, this.$onValueChangeFinished, AbstractC3790rJ.b(fK, ((Number) this.$valueRange.getEndInclusive()).floatValue()), iFloor2);
            boolean z4 = this.$enabled;
            List<Float> list = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f = lj.a - lj2.a;
            MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
            MutableInteractionSource mutableInteractionSource2 = this.$endInteractionSource;
            int i3 = this.$$dirty;
            SliderKt.RangeSliderImpl(z4, fCalcFraction, fCalcFraction2, list, sliderColors, f, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, modifierSliderSemantics2, composer, ((i3 >> 9) & 14) | 14159872 | ((i3 >> 9) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onValueChange;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ int $steps;
        final /* synthetic */ InterfaceC0789Ob $value;
        final /* synthetic */ InterfaceC0789Ob $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0789Ob interfaceC0789Ob, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z, InterfaceC0789Ob interfaceC0789Ob2, int i, InterfaceC3588op interfaceC3588op, SliderColors sliderColors, int i2, int i3) {
            super(2);
            this.$value = interfaceC0789Ob;
            this.$onValueChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$valueRange = interfaceC0789Ob2;
            this.$steps = i;
            this.$onValueChangeFinished = interfaceC3588op;
            this.$colors = sliderColors;
            this.$$changed = i2;
            this.$$default = i3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SliderKt.RangeSlider(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$valueRange, this.$steps, this.$onValueChangeFinished, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSliderImpl$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14362 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Modifier $endThumbSemantics;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ float $positionFractionEnd;
        final /* synthetic */ float $positionFractionStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ Modifier $startThumbSemantics;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14362(boolean z, float f, float f2, List<Float> list, SliderColors sliderColors, float f3, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i, int i2) {
            super(2);
            this.$enabled = z;
            this.$positionFractionStart = f;
            this.$positionFractionEnd = f2;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$width = f3;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$modifier = modifier;
            this.$startThumbSemantics = modifier2;
            this.$endThumbSemantics = modifier3;
            this.$$changed = i;
            this.$$changed1 = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SliderKt.RangeSliderImpl(this.$enabled, this.$positionFractionStart, this.$positionFractionEnd, this.$tickFractions, this.$colors, this.$width, this.$startInteractionSource, this.$endInteractionSource, this.$modifier, this.$startThumbSemantics, this.$endThumbSemantics, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14373 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $value;
        final /* synthetic */ InterfaceC0789Ob $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
        public /* synthetic */ class AnonymousClass2 extends C0916Sp implements InterfaceC3750qp {
            final /* synthetic */ LJ $maxPx;
            final /* synthetic */ LJ $minPx;
            final /* synthetic */ InterfaceC0789Ob $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(InterfaceC0789Ob interfaceC0789Ob, LJ lj, LJ lj2) {
                super(1, AbstractC4492zt.a.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = interfaceC0789Ob;
                this.$minPx = lj;
                this.$maxPx = lj2;
            }

            public final Float invoke(float f) {
                return Float.valueOf(C14373.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14373(InterfaceC0789Ob interfaceC0789Ob, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends InterfaceC3750qp> state, InterfaceC3588op interfaceC3588op) {
            super(3);
            this.$valueRange = interfaceC0789Ob;
            this.$$dirty = i;
            this.$value = f;
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$onValueChangeState = state;
            this.$onValueChangeFinished = interfaceC3588op;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(InterfaceC0789Ob interfaceC0789Ob, LJ lj, LJ lj2, float f) {
            return SliderKt.scale(((Number) interfaceC0789Ob.getStart()).floatValue(), ((Number) interfaceC0789Ob.getEndInclusive()).floatValue(), f, lj.a, lj2.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToUserValue(LJ lj, LJ lj2, InterfaceC0789Ob interfaceC0789Ob, float f) {
            return SliderKt.scale(lj.a, lj2.a, f, ((Number) interfaceC0789Ob.getStart()).floatValue(), ((Number) interfaceC0789Ob.getEndInclusive()).floatValue());
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
            int i2;
            AbstractC4492zt.h(boxWithConstraintsScope, "$this$BoxWithConstraints");
            if ((i & 14) == 0) {
                i2 = (composer.changed(boxWithConstraintsScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085116814, i, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:175)");
            }
            boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(boxWithConstraintsScope.mo423getConstraintsmsEJaDk());
            LJ lj = new LJ();
            LJ lj2 = new LJ();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            lj.a = Math.max(fM5128getMaxWidthimpl - density.mo333toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
            lj2.a = Math.min(density.mo333toPx0680j_4(SliderKt.getThumbRadius()), lj.a);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            float f = this.$value;
            InterfaceC0789Ob interfaceC0789Ob = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(interfaceC0789Ob, lj2, lj, f));
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue3;
            Object objValueOf = Float.valueOf(lj2.a);
            Object objValueOf2 = Float.valueOf(lj.a);
            InterfaceC0789Ob interfaceC0789Ob2 = this.$valueRange;
            State<InterfaceC3750qp> state = this.$onValueChangeState;
            composer.startReplaceableGroup(1618982084);
            boolean zChanged = composer.changed(objValueOf) | composer.changed(objValueOf2) | composer.changed(interfaceC0789Ob2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == companion.getEmpty()) {
                Object sliderDraggableState = new SliderDraggableState(new SliderKt$Slider$3$draggableState$1$1(mutableFloatState, mutableFloatState2, lj2, lj, state, interfaceC0789Ob2));
                composer.updateRememberedValue(sliderDraggableState);
                objRememberedValue4 = sliderDraggableState;
            }
            composer.endReplaceableGroup();
            SliderDraggableState sliderDraggableState2 = (SliderDraggableState) objRememberedValue4;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$valueRange, lj2, lj);
            InterfaceC0789Ob interfaceC0789Ob3 = this.$valueRange;
            InterfaceC0789Ob interfaceC0789ObB = AbstractC3790rJ.b(lj2.a, lj.a);
            float f2 = this.$value;
            int i3 = this.$$dirty;
            SliderKt.CorrectValueSideEffect(anonymousClass2, interfaceC0789Ob3, interfaceC0789ObB, mutableFloatState, f2, composer, ((i3 >> 9) & 112) | 3072 | ((i3 << 12) & 57344));
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new SliderKt$Slider$3$gestureEndAction$1(mutableFloatState, this.$tickFractions, lj2, lj, coroutineScope, sliderDraggableState2, this.$onValueChangeFinished), composer, 0);
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier modifierSliderTapModifier = SliderKt.sliderTapModifier(companion2, sliderDraggableState2, this.$interactionSource, fM5128getMaxWidthimpl, z, mutableFloatState, stateRememberUpdatedState, mutableFloatState2, this.$enabled);
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = sliderDraggableState2.isDragging();
            boolean z2 = this.$enabled;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(stateRememberUpdatedState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new SliderKt$Slider$3$drag$1$1(stateRememberUpdatedState, null);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierDraggable = DraggableKt.draggable(companion2, sliderDraggableState2, orientation, (188 & 4) != 0 ? true : z2, (188 & 8) != 0 ? null : mutableInteractionSource, (188 & 16) != 0 ? false : zIsDragging, (188 & 32) != 0 ? new DraggableKt.C13201(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : (InterfaceC0552Gp) objRememberedValue5, (188 & 128) != 0 ? false : z);
            float fCalcFraction = SliderKt.calcFraction(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), AbstractC3871sJ.k(this.$value, ((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue()));
            boolean z3 = this.$enabled;
            List<Float> list = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f3 = lj.a - lj2.a;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            Modifier modifierThen = modifierSliderTapModifier.then(modifierDraggable);
            int i4 = this.$$dirty;
            SliderKt.SliderImpl(z3, fCalcFraction, list, sliderColors, f3, mutableInteractionSource2, modifierThen, composer, ((i4 >> 9) & 14) | 512 | ((i4 >> 15) & 7168) | ((i4 >> 6) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onValueChange;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ int $steps;
        final /* synthetic */ float $value;
        final /* synthetic */ InterfaceC0789Ob $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(float f, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z, InterfaceC0789Ob interfaceC0789Ob, int i, InterfaceC3588op interfaceC3588op, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, int i2, int i3) {
            super(2);
            this.$value = f;
            this.$onValueChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$valueRange = interfaceC0789Ob;
            this.$steps = i;
            this.$onValueChangeFinished = interfaceC3588op;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = sliderColors;
            this.$$changed = i2;
            this.$$default = i3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SliderKt.Slider(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$valueRange, this.$steps, this.$onValueChangeFinished, this.$interactionSource, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$SliderImpl$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14382 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ float $positionFraction;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14382(boolean z, float f, List<Float> list, SliderColors sliderColors, float f2, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i) {
            super(2);
            this.$enabled = z;
            this.$positionFraction = f;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$width = f2;
            this.$interactionSource = mutableInteractionSource;
            this.$modifier = modifier;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SliderKt.SliderImpl(this.$enabled, this.$positionFraction, this.$tickFractions, this.$colors, this.$width, this.$interactionSource, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Track$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ State<Color> $activeTickColor;
        final /* synthetic */ State<Color> $activeTrackColor;
        final /* synthetic */ State<Color> $inactiveTickColor;
        final /* synthetic */ State<Color> $inactiveTrackColor;
        final /* synthetic */ float $positionFractionEnd;
        final /* synthetic */ float $positionFractionStart;
        final /* synthetic */ float $thumbPx;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $trackStrokeWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, State<Color> state, float f2, float f3, float f4, State<Color> state2, List<Float> list, State<Color> state3, State<Color> state4) {
            super(1);
            this.$thumbPx = f;
            this.$inactiveTrackColor = state;
            this.$trackStrokeWidth = f2;
            this.$positionFractionEnd = f3;
            this.$positionFractionStart = f4;
            this.$activeTrackColor = state2;
            this.$tickFractions = list;
            this.$inactiveTickColor = state3;
            this.$activeTickColor = state4;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return FW.a;
        }

        public final void invoke(DrawScope drawScope) {
            AbstractC4492zt.h(drawScope, "$this$Canvas");
            boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
            long jOffset = OffsetKt.Offset(this.$thumbPx, Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0()));
            long jOffset2 = OffsetKt.Offset(Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc()) - this.$thumbPx, Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0()));
            long j = z ? jOffset2 : jOffset;
            long j2 = z ? jOffset : jOffset2;
            long jM3042unboximpl = this.$inactiveTrackColor.getValue().m3042unboximpl();
            float f = this.$trackStrokeWidth;
            StrokeCap.Companion companion = StrokeCap.Companion;
            long j3 = j2;
            long j4 = j;
            AbstractC3255kk.C(drawScope, jM3042unboximpl, j, j2, f, companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            AbstractC3255kk.C(drawScope, this.$activeTrackColor.getValue().m3042unboximpl(), OffsetKt.Offset(Offset.m2798getXimpl(j4) + ((Offset.m2798getXimpl(j3) - Offset.m2798getXimpl(j4)) * this.$positionFractionStart), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0())), OffsetKt.Offset(Offset.m2798getXimpl(j4) + ((Offset.m2798getXimpl(j3) - Offset.m2798getXimpl(j4)) * this.$positionFractionEnd), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0())), this.$trackStrokeWidth, companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            List<Float> list = this.$tickFractions;
            float f2 = this.$positionFractionEnd;
            float f3 = this.$positionFractionStart;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                float fFloatValue = ((Number) obj).floatValue();
                Boolean boolValueOf = Boolean.valueOf(fFloatValue > f2 || fFloatValue < f3);
                Object arrayList = linkedHashMap.get(boolValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(boolValueOf, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            State<Color> state = this.$inactiveTickColor;
            State<Color> state2 = this.$activeTickColor;
            float f4 = this.$trackStrokeWidth;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                List list2 = (List) entry.getValue();
                ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Offset.m2787boximpl(OffsetKt.Offset(Offset.m2798getXimpl(OffsetKt.m2821lerpWko1d7g(j4, j3, ((Number) it.next()).floatValue())), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0()))));
                }
                long j5 = j4;
                long j6 = j3;
                AbstractC3255kk.H(drawScope, arrayList2, PointMode.Companion.m3309getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m3042unboximpl(), f4, StrokeCap.Companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                f4 = f4;
                j4 = j5;
                j3 = j6;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Track$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14392 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ float $positionFractionEnd;
        final /* synthetic */ float $positionFractionStart;
        final /* synthetic */ float $thumbPx;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $trackStrokeWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14392(Modifier modifier, SliderColors sliderColors, boolean z, float f, float f2, List<Float> list, float f3, float f4, int i) {
            super(2);
            this.$modifier = modifier;
            this.$colors = sliderColors;
            this.$enabled = z;
            this.$positionFractionStart = f;
            this.$positionFractionEnd = f2;
            this.$tickFractions = list;
            this.$thumbPx = f3;
            this.$trackStrokeWidth = f4;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SliderKt.Track(this.$modifier, this.$colors, this.$enabled, this.$positionFractionStart, this.$positionFractionEnd, this.$tickFractions, this.$thumbPx, this.$trackStrokeWidth, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", l = {955}, m = "invokeSuspend")
    public static final class C14402 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ DragScope $$this$drag;
            final /* synthetic */ LJ $latestValue;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(DragScope dragScope, LJ lj) {
                super(1);
                this.$$this$drag = dragScope;
                this.$latestValue = lj;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Animatable<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(Animatable<Float, AnimationVector1D> animatable) {
                AbstractC4492zt.h(animatable, "$this$animateTo");
                this.$$this$drag.dragBy(animatable.getValue().floatValue() - this.$latestValue.a);
                this.$latestValue.a = animatable.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14402(float f, float f2, float f3, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C14402 c14402 = new C14402(this.$current, this.$target, this.$velocity, interfaceC0793Of);
            c14402.L$0 = obj;
            return c14402;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(DragScope dragScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C14402) create(dragScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                DragScope dragScope = (DragScope) this.L$0;
                LJ lj = new LJ();
                float f = this.$current;
                lj.a = f;
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(f, 0.0f, 2, null);
                Float fB = E8.b(this.$target);
                TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                Float fB2 = E8.b(this.$velocity);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(dragScope, lj);
                this.label = 1;
                if (animatableAnimatable$default.animateTo(fB, tweenSpec, fB2, anonymousClass1, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", l = {983}, m = "invokeSuspend")
    public static final class C14411 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ State<InterfaceC0526Fp> $onDrag;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", l = {984}, m = "invokeSuspend")
        public static final class C00841 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ State<InterfaceC0526Fp> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", l = {985, 995, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW}, m = "invokeSuspend")
            public static final class C00851 extends JL implements InterfaceC0526Fp {
                final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
                final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<InterfaceC0526Fp> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", l = {1031}, m = "invokeSuspend")
                public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ KJ $draggingStart;
                    final /* synthetic */ DragInteraction $finishInteraction;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass2(RangeSliderLogic rangeSliderLogic, KJ kj, DragInteraction dragInteraction, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$draggingStart = kj;
                        this.$finishInteraction = dragInteraction;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objD = AbstractC0378Bt.d();
                        int i = this.label;
                        if (i == 0) {
                            LL.b(obj);
                            MutableInteractionSource mutableInteractionSourceActiveInteraction = this.$rangeSliderLogic.activeInteraction(this.$draggingStart.a);
                            DragInteraction dragInteraction = this.$finishInteraction;
                            this.label = 1;
                            if (mutableInteractionSourceActiveInteraction.emit(dragInteraction, this) == objD) {
                                return objD;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                        }
                        return FW.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C00851(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, InterfaceC2052dg interfaceC2052dg, State<? extends InterfaceC3750qp> state2, State<Float> state3, State<? extends InterfaceC0526Fp> state4, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = interfaceC2052dg;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    C00851 c00851 = new C00851(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, interfaceC0793Of);
                    c00851.L$0 = obj;
                    return c00851;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00851) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
                /* JADX WARN: Code duplicated, block: B:53:0x017a A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:56:0x0183 A[Catch: CancellationException -> 0x0189, TryCatch #1 {CancellationException -> 0x0189, blocks: (B:54:0x017b, B:56:0x0183, B:58:0x018b, B:51:0x015b), top: B:66:0x015b }] */
                /* JADX WARN: Code duplicated, block: B:58:0x018b A[Catch: CancellationException -> 0x0189, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x0189, blocks: (B:54:0x017b, B:56:0x0183, B:58:0x018b, B:51:0x015b), top: B:66:0x015b }] */
                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objAwaitFirstDown$default;
                    AwaitPointerEventScope awaitPointerEventScope;
                    LJ lj;
                    Object objM1202awaitSlop8vUncbI;
                    DragInteraction.Start start;
                    KJ kj;
                    AwaitPointerEventScope awaitPointerEventScope2;
                    PointerInputChange pointerInputChange;
                    C2020dG c2020dG;
                    DragInteraction.Start start2;
                    Object objM284horizontalDragjO51t88;
                    State<Float> state;
                    boolean z;
                    float fM1090pointerSlopE8SPZFQ;
                    DragInteraction cancel;
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope3;
                        this.label = 1;
                        objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                        if (objAwaitFirstDown$default == objD) {
                            return objD;
                        }
                        awaitPointerEventScope = awaitPointerEventScope3;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                kj = (KJ) this.L$1;
                                start2 = (DragInteraction.Start) this.L$0;
                                try {
                                    LL.b(obj);
                                    start = start2;
                                    objM284horizontalDragjO51t88 = obj;
                                    if (((Boolean) objM284horizontalDragjO51t88).booleanValue()) {
                                        cancel = new DragInteraction.Stop(start);
                                    } else {
                                        cancel = new DragInteraction.Cancel(start);
                                    }
                                } catch (CancellationException unused) {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                                this.$gestureEndAction.getValue().invoke(E8.a(kj.a));
                                O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, kj, cancel, null), 3, null);
                                return FW.a;
                            }
                            kj = (KJ) this.L$4;
                            lj = (LJ) this.L$3;
                            DragInteraction.Start start3 = (DragInteraction.Start) this.L$2;
                            PointerInputChange pointerInputChange2 = (PointerInputChange) this.L$1;
                            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                            LL.b(obj);
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            pointerInputChange = pointerInputChange2;
                            start = start3;
                            objM1202awaitSlop8vUncbI = obj;
                            c2020dG = (C2020dG) objM1202awaitSlop8vUncbI;
                            if (c2020dG != null) {
                                state = this.$rawOffsetEnd;
                                State<Float> state2 = this.$rawOffsetStart;
                                z = this.$isRtl;
                                fM1090pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m1090pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), pointerInputChange.m4057getTypeT8wyACA());
                                if (Math.abs(state.getValue().floatValue() - lj.a) < fM1090pointerSlopE8SPZFQ && Math.abs(state2.getValue().floatValue() - lj.a) < fM1090pointerSlopE8SPZFQ) {
                                    float fFloatValue = ((Number) c2020dG.e()).floatValue();
                                    kj.a = z ? fFloatValue < 0.0f : fFloatValue >= 0.0f;
                                    lj.a += Offset.m2798getXimpl(PointerEventKt.positionChange((PointerInputChange) c2020dG.c()));
                                }
                            }
                            this.$rangeSliderLogic.captureThumb(kj.a, lj.a, start, this.$$this$coroutineScope);
                            try {
                                long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
                                SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1 sliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1 = new SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1(this.$onDrag, kj, this.$isRtl);
                                this.L$0 = start;
                                this.L$1 = kj;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 3;
                                objM284horizontalDragjO51t88 = DragGestureDetectorKt.m284horizontalDragjO51t88(awaitPointerEventScope2, jM4053getIdJ3iCeTQ, sliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1, this);
                                if (objM284horizontalDragjO51t88 == objD) {
                                    return objD;
                                }
                                if (((Boolean) objM284horizontalDragjO51t88).booleanValue()) {
                                    cancel = new DragInteraction.Stop(start);
                                } else {
                                    cancel = new DragInteraction.Cancel(start);
                                }
                            } catch (CancellationException unused2) {
                                start2 = start;
                                cancel = new DragInteraction.Cancel(start2);
                            }
                            this.$gestureEndAction.getValue().invoke(E8.a(kj.a));
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, kj, cancel, null), 3, null);
                            return FW.a;
                        }
                        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        awaitPointerEventScope = awaitPointerEventScope5;
                        objAwaitFirstDown$default = obj;
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) objAwaitFirstDown$default;
                    DragInteraction.Start start4 = new DragInteraction.Start();
                    lj = new LJ();
                    float fM2798getXimpl = this.$isRtl ? this.$maxPx - Offset.m2798getXimpl(pointerInputChange3.m4054getPositionF1C5BW0()) : Offset.m2798getXimpl(pointerInputChange3.m4054getPositionF1C5BW0());
                    lj.a = fM2798getXimpl;
                    int iCompareOffsets = this.$rangeSliderLogic.compareOffsets(fM2798getXimpl);
                    KJ kj2 = new KJ();
                    kj2.a = iCompareOffsets == 0 ? this.$rawOffsetStart.getValue().floatValue() > lj.a : iCompareOffsets < 0;
                    long jM4053getIdJ3iCeTQ2 = pointerInputChange3.m4053getIdJ3iCeTQ();
                    int iM4057getTypeT8wyACA = pointerInputChange3.m4057getTypeT8wyACA();
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = pointerInputChange3;
                    this.L$2 = start4;
                    this.L$3 = lj;
                    this.L$4 = kj2;
                    this.label = 2;
                    objM1202awaitSlop8vUncbI = SliderKt.m1202awaitSlop8vUncbI(awaitPointerEventScope, jM4053getIdJ3iCeTQ2, iM4057getTypeT8wyACA, this);
                    if (objM1202awaitSlop8vUncbI == objD) {
                        return objD;
                    }
                    start = start4;
                    kj = kj2;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerInputChange = pointerInputChange3;
                    c2020dG = (C2020dG) objM1202awaitSlop8vUncbI;
                    if (c2020dG != null) {
                        state = this.$rawOffsetEnd;
                        State<Float> state3 = this.$rawOffsetStart;
                        z = this.$isRtl;
                        fM1090pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m1090pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), pointerInputChange.m4057getTypeT8wyACA());
                        if (Math.abs(state.getValue().floatValue() - lj.a) < fM1090pointerSlopE8SPZFQ) {
                            float fFloatValue2 = ((Number) c2020dG.e()).floatValue();
                            kj.a = z ? fFloatValue2 < 0.0f : fFloatValue2 >= 0.0f;
                            lj.a += Offset.m2798getXimpl(PointerEventKt.positionChange((PointerInputChange) c2020dG.c()));
                        }
                    }
                    this.$rangeSliderLogic.captureThumb(kj.a, lj.a, start, this.$$this$coroutineScope);
                    long jM4053getIdJ3iCeTQ3 = pointerInputChange.m4053getIdJ3iCeTQ();
                    SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1 sliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$2 = new SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1(this.$onDrag, kj, this.$isRtl);
                    this.L$0 = start;
                    this.L$1 = kj;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 3;
                    objM284horizontalDragjO51t88 = DragGestureDetectorKt.m284horizontalDragjO51t88(awaitPointerEventScope2, jM4053getIdJ3iCeTQ3, sliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$2, this);
                    if (objM284horizontalDragjO51t88 == objD) {
                        return objD;
                    }
                    if (((Boolean) objM284horizontalDragjO51t88).booleanValue()) {
                        cancel = new DragInteraction.Stop(start);
                    } else {
                        cancel = new DragInteraction.Cancel(start);
                    }
                    this.$gestureEndAction.getValue().invoke(E8.a(kj.a));
                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, kj, cancel, null), 3, null);
                    return FW.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00841(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends InterfaceC3750qp> state2, State<Float> state3, State<? extends InterfaceC0526Fp> state4, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$$this$pointerInput = pointerInputScope;
                this.$isRtl = z;
                this.$maxPx = f;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C00841 c00841 = new C00841(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, interfaceC0793Of);
                c00841.L$0 = obj;
                return c00841;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C00841) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C00851 c00851 = new C00851(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, interfaceC2052dg, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c00851, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14411(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends InterfaceC0526Fp> state3, boolean z, float f, State<? extends InterfaceC3750qp> state4, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$rawOffsetStart = state;
            this.$rawOffsetEnd = state2;
            this.$onDrag = state3;
            this.$isRtl = z;
            this.$maxPx = f;
            this.$gestureEndAction = state4;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C14411 c14411 = new C14411(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, interfaceC0793Of);
            c14411.L$0 = obj;
            return c14411;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C14411) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                C00841 c00841 = new C00841((PointerInputScope) this.L$0, this.$isRtl, this.$maxPx, new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag), this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                this.label = 1;
                if (AbstractC2133eg.d(c00841, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderSemantics$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14421 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $coerced;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC3750qp $onValueChange;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ int $steps;
        final /* synthetic */ InterfaceC0789Ob $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderSemantics$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00861 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ float $coerced;
            final /* synthetic */ InterfaceC3750qp $onValueChange;
            final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
            final /* synthetic */ int $steps;
            final /* synthetic */ InterfaceC0789Ob $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00861(InterfaceC0789Ob interfaceC0789Ob, int i, float f, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
                super(1);
                this.$valueRange = interfaceC0789Ob;
                this.$steps = i;
                this.$coerced = f;
                this.$onValueChange = interfaceC3750qp;
                this.$onValueChangeFinished = interfaceC3588op;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }

            public final Boolean invoke(float f) {
                int i;
                float fK = AbstractC3871sJ.k(f, ((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue());
                int i2 = this.$steps;
                boolean z = false;
                if (i2 > 0 && (i = i2 + 1) >= 0) {
                    float fAbs = fK;
                    float f2 = fAbs;
                    int i3 = 0;
                    while (true) {
                        float fLerp = MathHelpersKt.lerp(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), i3 / (this.$steps + 1));
                        float f3 = fLerp - fK;
                        if (Math.abs(f3) <= fAbs) {
                            fAbs = Math.abs(f3);
                            f2 = fLerp;
                        }
                        if (i3 == i) {
                            break;
                        }
                        i3++;
                    }
                    fK = f2;
                }
                if (fK != this.$coerced) {
                    this.$onValueChange.invoke(Float.valueOf(fK));
                    InterfaceC3588op interfaceC3588op = this.$onValueChangeFinished;
                    if (interfaceC3588op != null) {
                        interfaceC3588op.invoke();
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14421(boolean z, InterfaceC0789Ob interfaceC0789Ob, int i, float f, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
            super(1);
            this.$enabled = z;
            this.$valueRange = interfaceC0789Ob;
            this.$steps = i;
            this.$coerced = f;
            this.$onValueChange = interfaceC3750qp;
            this.$onValueChangeFinished = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            if (!this.$enabled) {
                SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
            }
            SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new C00861(this.$valueRange, this.$steps, this.$coerced, this.$onValueChange, this.$onValueChangeFinished), 1, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14432 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ DraggableState $draggableState;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ MutableState<Float> $pressOffset;
        final /* synthetic */ State<Float> $rawOffset;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", l = {910}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ DraggableState $draggableState;
            final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ MutableState<Float> $pressOffset;
            final /* synthetic */ State<Float> $rawOffset;
            final /* synthetic */ InterfaceC2052dg $scope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", l = {915}, m = "invokeSuspend")
            public static final class C00871 extends XS implements InterfaceC0552Gp {
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                /* synthetic */ long J$0;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00871(boolean z, float f, MutableState<Float> mutableState, State<Float> state, InterfaceC0793Of interfaceC0793Of) {
                    super(3, interfaceC0793Of);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                }

                @Override // defpackage.InterfaceC0552Gp
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m1204invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
                }

                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m1204invoked4ec7I(PressGestureScope pressGestureScope, long j, InterfaceC0793Of interfaceC0793Of) {
                    C00871 c00871 = new C00871(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, interfaceC0793Of);
                    c00871.L$0 = pressGestureScope;
                    c00871.J$0 = j;
                    return c00871.invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    try {
                        if (i == 0) {
                            LL.b(obj);
                            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                            long j = this.J$0;
                            this.$pressOffset.setValue(E8.b((this.$isRtl ? this.$maxPx - Offset.m2798getXimpl(j) : Offset.m2798getXimpl(j)) - this.$rawOffset.getValue().floatValue()));
                            this.label = 1;
                            if (pressGestureScope.awaitRelease(this) == objD) {
                                return objD;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                        }
                    } catch (GestureCancellationException unused) {
                        this.$pressOffset.setValue(E8.b(0.0f));
                    }
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2, reason: invalid class name and collision with other inner class name */
            public static final class C00882 extends AbstractC2233fv implements InterfaceC3750qp {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
                final /* synthetic */ InterfaceC2052dg $scope;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1", f = "Slider.kt", l = {922}, m = "invokeSuspend")
                public static final class C00891 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ DraggableState $draggableState;
                    final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
                    int label;

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                    @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
                    public static final class C00901 extends XS implements InterfaceC0526Fp {
                        private /* synthetic */ Object L$0;
                        int label;

                        public C00901(InterfaceC0793Of interfaceC0793Of) {
                            super(2, interfaceC0793Of);
                        }

                        @Override // defpackage.AbstractC2171f7
                        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                            C00901 c00901 = new C00901(interfaceC0793Of);
                            c00901.L$0 = obj;
                            return c00901;
                        }

                        @Override // defpackage.InterfaceC0526Fp
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Object mo13invoke(DragScope dragScope, InterfaceC0793Of interfaceC0793Of) {
                            return ((C00901) create(dragScope, interfaceC0793Of)).invokeSuspend(FW.a);
                        }

                        @Override // defpackage.AbstractC2171f7
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            AbstractC0378Bt.d();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                            ((DragScope) this.L$0).dragBy(0.0f);
                            return FW.a;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C00891(DraggableState draggableState, State<? extends InterfaceC3750qp> state, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$draggableState = draggableState;
                        this.$gestureEndAction = state;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new C00891(this.$draggableState, this.$gestureEndAction, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((C00891) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objD = AbstractC0378Bt.d();
                        int i = this.label;
                        if (i == 0) {
                            LL.b(obj);
                            DraggableState draggableState = this.$draggableState;
                            MutatePriority mutatePriority = MutatePriority.UserInput;
                            C00901 c00901 = new C00901(null);
                            this.label = 1;
                            if (draggableState.drag(mutatePriority, c00901, this) == objD) {
                                return objD;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                        }
                        this.$gestureEndAction.getValue().invoke(E8.b(0.0f));
                        return FW.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C00882(InterfaceC2052dg interfaceC2052dg, DraggableState draggableState, State<? extends InterfaceC3750qp> state) {
                    super(1);
                    this.$scope = interfaceC2052dg;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state;
                }

                @Override // defpackage.InterfaceC3750qp
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1205invokek4lQ0M(((Offset) obj).m2808unboximpl());
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m1205invokek4lQ0M(long j) {
                    O8.d(this.$scope, null, null, new C00891(this.$draggableState, this.$gestureEndAction, null), 3, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(boolean z, float f, MutableState<Float> mutableState, State<Float> state, InterfaceC2052dg interfaceC2052dg, DraggableState draggableState, State<? extends InterfaceC3750qp> state2, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$isRtl = z;
                this.$maxPx = f;
                this.$pressOffset = mutableState;
                this.$rawOffset = state;
                this.$scope = interfaceC2052dg;
                this.$draggableState = draggableState;
                this.$gestureEndAction = state2;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, interfaceC0793Of);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    C00871 c00871 = new C00871(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                    C00882 c00882 = new C00882(this.$scope, this.$draggableState, this.$gestureEndAction);
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c00871, c00882, this, 3, null) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14432(boolean z, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f, boolean z2, MutableState<Float> mutableState, State<Float> state, State<? extends InterfaceC3750qp> state2) {
            super(3);
            this.$enabled = z;
            this.$draggableState = draggableState;
            this.$interactionSource = mutableInteractionSource;
            this.$maxPx = f;
            this.$isRtl = z2;
            this.$pressOffset = mutableState;
            this.$rawOffset = state;
            this.$gestureEndAction = state2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(1945228890);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1945228890, i, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:905)");
            }
            if (this.$enabled) {
                composer.startReplaceableGroup(773894976);
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composer.endReplaceableGroup();
                modifier = SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{this.$draggableState, this.$interactionSource, Float.valueOf(this.$maxPx), Boolean.valueOf(this.$isRtl)}, (InterfaceC0526Fp) new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, coroutineScope, this.$draggableState, this.$gestureEndAction, null));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifier;
        }
    }

    static {
        float fM5160constructorimpl = Dp.m5160constructorimpl(48);
        SliderHeight = fM5160constructorimpl;
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(144);
        SliderMinWidth = fM5160constructorimpl2;
        DefaultSliderConstraints = SizeKt.m520heightInVpY3zN4$default(SizeKt.m539widthInVpY3zN4$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 2, null), 0.0f, fM5160constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void CorrectValueSideEffect(InterfaceC3750qp interfaceC3750qp, InterfaceC0789Ob interfaceC0789Ob, InterfaceC0789Ob interfaceC0789Ob2, MutableState<Float> mutableState, float f, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-743965752);
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(interfaceC0789Ob) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(interfaceC0789Ob2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((i2 & 46811) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, i, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:832)");
            }
            Object[] objArr = {interfaceC0789Ob, interfaceC3750qp, Float.valueOf(f), mutableState, interfaceC0789Ob2};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i3 = 0; i3 < 5; i3++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i3]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SliderKt$CorrectValueSideEffect$1$1(interfaceC0789Ob, interfaceC3750qp, f, mutableState, interfaceC0789Ob2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3750qp, interfaceC0789Ob, interfaceC0789Ob2, mutableState, f, i));
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0158 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x015a  */
    /* JADX WARN: Code duplicated, block: B:110:0x015f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0164  */
    /* JADX WARN: Code duplicated, block: B:115:0x0170  */
    /* JADX WARN: Code duplicated, block: B:117:0x0174  */
    /* JADX WARN: Code duplicated, block: B:118:0x0176  */
    /* JADX WARN: Code duplicated, block: B:121:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:128:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:131:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:136:0x020e  */
    /* JADX WARN: Code duplicated, block: B:138:0x0214  */
    /* JADX WARN: Code duplicated, block: B:141:0x027d  */
    /* JADX WARN: Code duplicated, block: B:146:0x0293  */
    /* JADX WARN: Code duplicated, block: B:148:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x0102  */
    /* JADX WARN: Code duplicated, block: B:94:0x0119  */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    public static final void RangeSlider(InterfaceC0789Ob interfaceC0789Ob, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z, InterfaceC0789Ob interfaceC0789Ob2, int i, InterfaceC3588op interfaceC3588op, SliderColors sliderColors, Composer composer, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        InterfaceC0789Ob interfaceC0789ObB;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        SliderColors sliderColorsM1198colorsq0g_0yA;
        InterfaceC3588op interfaceC3588op2;
        InterfaceC3588op interfaceC3588op3;
        SliderColors sliderColors2;
        Modifier modifier3;
        boolean z3;
        InterfaceC0789Ob interfaceC0789Ob3;
        int i12;
        int i13;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableInteractionSource mutableInteractionSource;
        Object objRememberedValue2;
        MutableInteractionSource mutableInteractionSource2;
        boolean zChanged;
        Object objRememberedValue3;
        Composer composer2;
        Modifier modifier4;
        boolean z4;
        InterfaceC0789Ob interfaceC0789Ob4;
        int i14;
        InterfaceC3588op interfaceC3588op4;
        SliderColors sliderColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0789Ob, "value");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556183027);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(interfaceC0789Ob) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i15 = i3 & 4;
        if (i15 == 0) {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((57344 & i2) == 0) {
                    if ((i3 & 16) == 0) {
                        interfaceC0789ObB = interfaceC0789Ob2;
                        int i16 = composerStartRestartGroup.changed(interfaceC0789ObB) ? 16384 : 8192;
                        i4 |= i16;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    i4 |= i16;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((458752 & i2) == 0) {
                        i8 = i;
                        if (composerStartRestartGroup.changed(i8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 64;
                    if (i10 != 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                    if ((i2 & 29360128) == 0) {
                        if ((i3 & 128) == 0) {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            int i17 = composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA) ? 8388608 : 4194304;
                            i4 |= i17;
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                        }
                        i4 |= i17;
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                    }
                    if ((i4 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                                interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            }
                            if (i7 != 0) {
                                i8 = 0;
                            }
                            if (i10 != 0) {
                                interfaceC3588op2 = null;
                            } else {
                                interfaceC3588op2 = interfaceC3588op;
                            }
                            if ((i3 & 128) != 0) {
                                sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                                i4 &= -29360129;
                            }
                            interfaceC3588op3 = interfaceC3588op2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 128) != 0) {
                                interfaceC3588op3 = interfaceC3588op;
                                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                                modifier3 = modifier2;
                                z3 = z2;
                                interfaceC0789Ob3 = interfaceC0789ObB;
                                i12 = i8;
                                i13 = (-29360129) & i4;
                            } else {
                                interfaceC3588op3 = interfaceC3588op;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                            if (i12 >= 0) {
                                throw new IllegalArgumentException("steps should be >= 0");
                            }
                            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                            Integer numValueOf = Integer.valueOf(i12);
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(numValueOf);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = stepsToTickFractions(i12);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                            float f = ThumbRadius;
                            composer2 = composerStartRestartGroup;
                            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, Dp.m5160constructorimpl(4 * f), Dp.m5160constructorimpl(f * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z4 = z3;
                            interfaceC0789Ob4 = interfaceC0789Ob3;
                            i14 = i12;
                            interfaceC3588op4 = interfaceC3588op3;
                            sliderColors3 = sliderColors2;
                        }
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                        if (i12 >= 0) {
                            throw new IllegalArgumentException("steps should be >= 0");
                        }
                        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                        Integer numValueOf2 = Integer.valueOf(i12);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(numValueOf2);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = stepsToTickFractions(i12);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = stepsToTickFractions(i12);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                        float f2 = ThumbRadius;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize2, Dp.m5160constructorimpl(4 * f2), Dp.m5160constructorimpl(f2 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState2, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z4 = z3;
                        interfaceC0789Ob4 = interfaceC0789Ob3;
                        i14 = i12;
                        interfaceC3588op4 = interfaceC3588op3;
                        sliderColors3 = sliderColors2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z4 = z2;
                        i14 = i8;
                        composer2 = composerStartRestartGroup;
                        interfaceC3588op4 = interfaceC3588op;
                        InterfaceC0789Ob interfaceC0789Ob5 = interfaceC0789ObB;
                        sliderColors3 = sliderColorsM1198colorsq0g_0yA;
                        modifier4 = modifier2;
                        interfaceC0789Ob4 = interfaceC0789Ob5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i8 = i;
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                if ((i2 & 29360128) == 0) {
                    if ((i3 & 128) == 0) {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                        }
                        i4 |= i17;
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                    }
                    i4 |= i17;
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                }
                if ((i4 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf3 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumInteractiveComponentSize3 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    float f3 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize3, Dp.m5160constructorimpl(4 * f3), Dp.m5160constructorimpl(f3 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState3, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    interfaceC0789Ob4 = interfaceC0789Ob3;
                    i14 = i12;
                    interfaceC3588op4 = interfaceC3588op3;
                    sliderColors3 = sliderColors2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf4 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumInteractiveComponentSize4 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    float f4 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize4, Dp.m5160constructorimpl(4 * f4), Dp.m5160constructorimpl(f4 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState4, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    interfaceC0789Ob4 = interfaceC0789Ob3;
                    i14 = i12;
                    interfaceC3588op4 = interfaceC3588op3;
                    sliderColors3 = sliderColors2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
            }
            i4 |= 3072;
            z2 = z;
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    interfaceC0789ObB = interfaceC0789Ob2;
                    if (composerStartRestartGroup.changed(interfaceC0789ObB)) {
                    }
                    i4 |= i16;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                i4 |= i16;
            } else {
                interfaceC0789ObB = interfaceC0789Ob2;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                if ((i2 & 29360128) == 0) {
                    if ((i3 & 128) == 0) {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                        }
                        i4 |= i17;
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                    }
                    i4 |= i17;
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                }
                if ((i4 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf5 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf5);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumInteractiveComponentSize5 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    float f5 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize5, Dp.m5160constructorimpl(4 * f5), Dp.m5160constructorimpl(f5 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState5, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    interfaceC0789Ob4 = interfaceC0789Ob3;
                    i14 = i12;
                    interfaceC3588op4 = interfaceC3588op3;
                    sliderColors3 = sliderColors2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState6 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf6 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumInteractiveComponentSize6 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    float f6 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize6, Dp.m5160constructorimpl(4 * f6), Dp.m5160constructorimpl(f6 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState6, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    interfaceC0789Ob4 = interfaceC0789Ob3;
                    i14 = i12;
                    interfaceC3588op4 = interfaceC3588op3;
                    sliderColors3 = sliderColors2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            if ((i2 & 29360128) == 0) {
                if ((i3 & 128) == 0) {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                    }
                    i4 |= i17;
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                }
                i4 |= i17;
            } else {
                sliderColorsM1198colorsq0g_0yA = sliderColors;
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState7 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf7 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumInteractiveComponentSize7 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                float f7 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize7, Dp.m5160constructorimpl(4 * f7), Dp.m5160constructorimpl(f7 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState7, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                interfaceC0789Ob4 = interfaceC0789Ob3;
                i14 = i12;
                interfaceC3588op4 = interfaceC3588op3;
                sliderColors3 = sliderColors2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState8 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf8 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf8);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumInteractiveComponentSize8 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                float f8 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize8, Dp.m5160constructorimpl(4 * f8), Dp.m5160constructorimpl(f8 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState8, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                interfaceC0789Ob4 = interfaceC0789Ob3;
                i14 = i12;
                interfaceC3588op4 = interfaceC3588op3;
                sliderColors3 = sliderColors2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    interfaceC0789ObB = interfaceC0789Ob2;
                    if (composerStartRestartGroup.changed(interfaceC0789ObB)) {
                    }
                    i4 |= i16;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                i4 |= i16;
            } else {
                interfaceC0789ObB = interfaceC0789Ob2;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                if ((i2 & 29360128) == 0) {
                    if ((i3 & 128) == 0) {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                        }
                        i4 |= i17;
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                    }
                    i4 |= i17;
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                }
                if ((i4 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState9 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf9 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf9);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumInteractiveComponentSize9 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    float f9 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize9, Dp.m5160constructorimpl(4 * f9), Dp.m5160constructorimpl(f9 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState9, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    interfaceC0789Ob4 = interfaceC0789Ob3;
                    i14 = i12;
                    interfaceC3588op4 = interfaceC3588op3;
                    sliderColors3 = sliderColors2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if ((i3 & 128) != 0) {
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i4 &= -29360129;
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState10 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf10 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumInteractiveComponentSize10 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    float f10 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize10, Dp.m5160constructorimpl(4 * f10), Dp.m5160constructorimpl(f10 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState10, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    interfaceC0789Ob4 = interfaceC0789Ob3;
                    i14 = i12;
                    interfaceC3588op4 = interfaceC3588op3;
                    sliderColors3 = sliderColors2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            if ((i2 & 29360128) == 0) {
                if ((i3 & 128) == 0) {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                    }
                    i4 |= i17;
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                }
                i4 |= i17;
            } else {
                sliderColorsM1198colorsq0g_0yA = sliderColors;
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState11 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf11 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf11);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumInteractiveComponentSize11 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                float f11 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize11, Dp.m5160constructorimpl(4 * f11), Dp.m5160constructorimpl(f11 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState11, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                interfaceC0789Ob4 = interfaceC0789Ob3;
                i14 = i12;
                interfaceC3588op4 = interfaceC3588op3;
                sliderColors3 = sliderColors2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState12 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf12 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf12);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumInteractiveComponentSize12 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                float f12 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize12, Dp.m5160constructorimpl(4 * f12), Dp.m5160constructorimpl(f12 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState12, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                interfaceC0789Ob4 = interfaceC0789Ob3;
                i14 = i12;
                interfaceC3588op4 = interfaceC3588op3;
                sliderColors3 = sliderColors2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
        }
        i4 |= 3072;
        z2 = z;
        if ((57344 & i2) == 0) {
            if ((i3 & 16) == 0) {
                interfaceC0789ObB = interfaceC0789Ob2;
                if (composerStartRestartGroup.changed(interfaceC0789ObB)) {
                }
                i4 |= i16;
            } else {
                interfaceC0789ObB = interfaceC0789Ob2;
            }
            i4 |= i16;
        } else {
            interfaceC0789ObB = interfaceC0789Ob2;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                i8 = i;
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i4 |= i9;
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            if ((i2 & 29360128) == 0) {
                if ((i3 & 128) == 0) {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                    }
                    i4 |= i17;
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                }
                i4 |= i17;
            } else {
                sliderColorsM1198colorsq0g_0yA = sliderColors;
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState13 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf13 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf13);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumInteractiveComponentSize13 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                float f13 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize13, Dp.m5160constructorimpl(4 * f13), Dp.m5160constructorimpl(f13 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState13, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                interfaceC0789Ob4 = interfaceC0789Ob3;
                i14 = i12;
                interfaceC3588op4 = interfaceC3588op3;
                sliderColors3 = sliderColors2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if ((i3 & 128) != 0) {
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i4 &= -29360129;
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    modifier3 = modifier2;
                    z3 = z2;
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState14 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf14 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf14);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumInteractiveComponentSize14 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                float f14 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize14, Dp.m5160constructorimpl(4 * f14), Dp.m5160constructorimpl(f14 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState14, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                interfaceC0789Ob4 = interfaceC0789Ob3;
                i14 = i12;
                interfaceC3588op4 = interfaceC3588op3;
                sliderColors3 = sliderColors2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i8 = i;
        i10 = i3 & 64;
        if (i10 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i4 |= i11;
        }
        if ((i2 & 29360128) == 0) {
            if ((i3 & 128) == 0) {
                sliderColorsM1198colorsq0g_0yA = sliderColors;
                if (composerStartRestartGroup.changed(sliderColorsM1198colorsq0g_0yA)) {
                }
                i4 |= i17;
            } else {
                sliderColorsM1198colorsq0g_0yA = sliderColors;
            }
            i4 |= i17;
        } else {
            sliderColorsM1198colorsq0g_0yA = sliderColors;
        }
        if ((i4 & 23967451) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if ((i3 & 128) != 0) {
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i4 &= -29360129;
                }
                interfaceC3588op3 = interfaceC3588op2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                modifier3 = modifier2;
                z3 = z2;
                interfaceC0789Ob3 = interfaceC0789ObB;
                i12 = i8;
                i13 = i4;
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if ((i3 & 128) != 0) {
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i4 &= -29360129;
                }
                interfaceC3588op3 = interfaceC3588op2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                modifier3 = modifier2;
                z3 = z2;
                interfaceC0789Ob3 = interfaceC0789ObB;
                i12 = i8;
                i13 = i4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
            if (i12 >= 0) {
                throw new IllegalArgumentException("steps should be >= 0");
            }
            State stateRememberUpdatedState15 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
            Integer numValueOf15 = Integer.valueOf(i12);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(numValueOf15);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierMinimumInteractiveComponentSize15 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
            float f15 = ThumbRadius;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize15, Dp.m5160constructorimpl(4 * f15), Dp.m5160constructorimpl(f15 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState15, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z4 = z3;
            interfaceC0789Ob4 = interfaceC0789Ob3;
            i14 = i12;
            interfaceC3588op4 = interfaceC3588op3;
            sliderColors3 = sliderColors2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if ((i3 & 128) != 0) {
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i4 &= -29360129;
                }
                interfaceC3588op3 = interfaceC3588op2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                modifier3 = modifier2;
                z3 = z2;
                interfaceC0789Ob3 = interfaceC0789ObB;
                i12 = i8;
                i13 = i4;
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if ((i3 & 128) != 0) {
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i4 &= -29360129;
                }
                interfaceC3588op3 = interfaceC3588op2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                modifier3 = modifier2;
                z3 = z2;
                interfaceC0789Ob3 = interfaceC0789ObB;
                i12 = i8;
                i13 = i4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556183027, i13, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
            if (i12 >= 0) {
                throw new IllegalArgumentException("steps should be >= 0");
            }
            State stateRememberUpdatedState16 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i13 >> 3) & 14);
            Integer numValueOf16 = Integer.valueOf(i12);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(numValueOf16);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierMinimumInteractiveComponentSize16 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
            float f16 = ThumbRadius;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize16, Dp.m5160constructorimpl(4 * f16), Dp.m5160constructorimpl(f16 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C14352(interfaceC0789Ob3, interfaceC0789Ob, i13, stateRememberUpdatedState16, mutableInteractionSource, mutableInteractionSource2, z3, i12, interfaceC3588op3, (List) objRememberedValue3, sliderColors2)), composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z4 = z3;
            interfaceC0789Ob4 = interfaceC0789Ob3;
            i14 = i12;
            interfaceC3588op4 = interfaceC3588op3;
            sliderColors3 = sliderColors2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0789Ob, interfaceC3750qp, modifier4, z4, interfaceC0789Ob4, i14, interfaceC3588op4, sliderColors3, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RangeSliderImpl(boolean z, float f, float f2, List<Float> list, SliderColors sliderColors, float f3, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, Composer composer, int i, int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-278895713);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278895713, i, i2, "androidx.compose.material.RangeSliderImpl (Slider.kt:616)");
        }
        Strings.Companion companion = Strings.Companion;
        String strM1225getString4foXLRw = Strings_androidKt.m1225getString4foXLRw(companion.m1224getSliderRangeStartUdPEhr4(), composerStartRestartGroup, 6);
        String strM1225getString4foXLRw2 = Strings_androidKt.m1225getString4foXLRw(companion.m1223getSliderRangeEndUdPEhr4(), composerStartRestartGroup, 6);
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion2 = Alignment.Companion;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion3.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierThen);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float fMo333toPx0680j_4 = density.mo333toPx0680j_4(TrackHeight);
        float f4 = ThumbRadius;
        float fMo333toPx0680j_5 = density.mo333toPx0680j_4(f4);
        float fMo329toDpu2uoSUM = density.mo329toDpu2uoSUM(f3);
        float fM5160constructorimpl = Dp.m5160constructorimpl(f4 * 2);
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(fMo329toDpu2uoSUM * f);
        float fM5160constructorimpl3 = Dp.m5160constructorimpl(fMo329toDpu2uoSUM * f2);
        Modifier.Companion companion4 = Modifier.Companion;
        int i3 = i >> 9;
        int i4 = i << 6;
        Track(SizeKt.fillMaxSize$default(boxScopeInstance.align(companion4, companion2.getCenterStart()), 0.0f, 1, null), sliderColors, z, f, f2, list, fMo333toPx0680j_5, fMo333toPx0680j_4, composerStartRestartGroup, (i3 & 112) | 262144 | (i4 & 896) | (i4 & 7168) | (i4 & 57344));
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(strM1225getString4foXLRw);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SliderKt$RangeSliderImpl$1$2$1(strM1225getString4foXLRw);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        int i5 = i & 57344;
        int i6 = (i << 15) & 458752;
        m1199SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (InterfaceC3750qp) objRememberedValue), true, mutableInteractionSource).then(modifier2), fM5160constructorimpl2, mutableInteractionSource, sliderColors, z, fM5160constructorimpl, composerStartRestartGroup, 1572870 | (i3 & 7168) | i5 | i6);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged2 = composerStartRestartGroup.changed(strM1225getString4foXLRw2);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new SliderKt$RangeSliderImpl$1$3$1(strM1225getString4foXLRw2);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        m1199SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (InterfaceC3750qp) objRememberedValue2), true, mutableInteractionSource2).then(modifier3), fM5160constructorimpl3, mutableInteractionSource2, sliderColors, z, fM5160constructorimpl, composerStartRestartGroup, 1572870 | ((i >> 12) & 7168) | i5 | i6);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14362(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:104:0x0137  */
    /* JADX WARN: Code duplicated, block: B:106:0x0145  */
    /* JADX WARN: Code duplicated, block: B:116:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x0175  */
    /* JADX WARN: Code duplicated, block: B:119:0x017a  */
    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0189  */
    /* JADX WARN: Code duplicated, block: B:125:0x018c  */
    /* JADX WARN: Code duplicated, block: B:126:0x018e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0192  */
    /* JADX WARN: Code duplicated, block: B:129:0x0194  */
    /* JADX WARN: Code duplicated, block: B:131:0x0198  */
    /* JADX WARN: Code duplicated, block: B:133:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:138:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:146:0x0215  */
    /* JADX WARN: Code duplicated, block: B:148:0x021d  */
    /* JADX WARN: Code duplicated, block: B:151:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:156:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:158:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x0115  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Slider(float f, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z, InterfaceC0789Ob interfaceC0789Ob, int i, InterfaceC3588op interfaceC3588op, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, Composer composer, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        InterfaceC0789Ob interfaceC0789Ob2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        InterfaceC0789Ob interfaceC0789ObB;
        int i14;
        InterfaceC3588op interfaceC3588op2;
        MutableInteractionSource mutableInteractionSource2;
        SliderColors sliderColorsM1198colorsq0g_0yA;
        int i15;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        InterfaceC0789Ob interfaceC0789Ob3;
        Modifier modifier3;
        InterfaceC3588op interfaceC3588op3;
        MutableInteractionSource mutableInteractionSource3;
        SliderColors sliderColors2;
        boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1962335196);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i16 = i3 & 4;
        if (i16 == 0) {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((57344 & i2) == 0) {
                    if ((i3 & 16) == 0) {
                        interfaceC0789Ob2 = interfaceC0789Ob;
                        int i17 = composerStartRestartGroup.changed(interfaceC0789Ob2) ? 16384 : 8192;
                        i4 |= i17;
                    } else {
                        interfaceC0789Ob2 = interfaceC0789Ob;
                    }
                    i4 |= i17;
                } else {
                    interfaceC0789Ob2 = interfaceC0789Ob;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((458752 & i2) == 0) {
                        i8 = i;
                        if (composerStartRestartGroup.changed(i8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 64;
                    if (i10 != 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                    i12 = i3 & 128;
                    if (i12 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i4 |= i13;
                    }
                    if ((i2 & 234881024) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                    }
                    if ((i4 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                interfaceC0789ObB = interfaceC0789Ob2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i;
                            }
                            if (i10 != 0) {
                                interfaceC3588op2 = null;
                            } else {
                                interfaceC3588op2 = interfaceC3588op;
                            }
                            if (i12 != 0) {
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
                            if ((i3 & 256) != 0) {
                                i15 = (-234881025) & i4;
                                sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            } else {
                                sliderColorsM1198colorsq0g_0yA = sliderColors;
                                i15 = i4;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 256) != 0) {
                                i14 = i;
                                interfaceC3588op2 = interfaceC3588op;
                                sliderColorsM1198colorsq0g_0yA = sliderColors;
                                i15 = i4 & (-234881025);
                                interfaceC0789ObB = interfaceC0789Ob2;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                i14 = i;
                                interfaceC3588op2 = interfaceC3588op;
                                mutableInteractionSource2 = mutableInteractionSource;
                                sliderColorsM1198colorsq0g_0yA = sliderColors;
                                i15 = i4;
                                interfaceC0789ObB = interfaceC0789Ob2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                        }
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0");
                        }
                        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(numValueOf);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list = (List) objRememberedValue2;
                        Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                        float f2 = ThumbRadius;
                        float f3 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, Dp.m5160constructorimpl(f2 * f3), Dp.m5160constructorimpl(f2 * f3), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0789Ob3 = interfaceC0789ObB;
                        modifier3 = modifier2;
                        interfaceC3588op3 = interfaceC3588op2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        boolean z4 = z2;
                        sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                        z3 = z4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z3 = z2;
                        interfaceC0789Ob3 = interfaceC0789Ob2;
                        i14 = i8;
                        interfaceC3588op3 = interfaceC3588op;
                        sliderColors2 = sliderColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i8 = i;
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                    }
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf2 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list2 = (List) objRememberedValue2;
                    Modifier modifierMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f4 = ThumbRadius;
                    float f5 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize2, Dp.m5160constructorimpl(f4 * f5), Dp.m5160constructorimpl(f4 * f5), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list2, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState2, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    modifier3 = modifier2;
                    interfaceC3588op3 = interfaceC3588op2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    boolean z5 = z2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    z3 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                    }
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf3 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf3);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list3 = (List) objRememberedValue2;
                    Modifier modifierMinimumInteractiveComponentSize3 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f6 = ThumbRadius;
                    float f7 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize3, Dp.m5160constructorimpl(f6 * f7), Dp.m5160constructorimpl(f6 * f7), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list3, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState3, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    modifier3 = modifier2;
                    interfaceC3588op3 = interfaceC3588op2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    boolean z6 = z2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    z3 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
            }
            i4 |= 3072;
            z2 = z;
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    interfaceC0789Ob2 = interfaceC0789Ob;
                    if (composerStartRestartGroup.changed(interfaceC0789Ob2)) {
                    }
                    i4 |= i17;
                } else {
                    interfaceC0789Ob2 = interfaceC0789Ob;
                }
                i4 |= i17;
            } else {
                interfaceC0789Ob2 = interfaceC0789Ob;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                    }
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf4 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf4);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list4 = (List) objRememberedValue2;
                    Modifier modifierMinimumInteractiveComponentSize4 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f8 = ThumbRadius;
                    float f9 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize4, Dp.m5160constructorimpl(f8 * f9), Dp.m5160constructorimpl(f8 * f9), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list4, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState4, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    modifier3 = modifier2;
                    interfaceC3588op3 = interfaceC3588op2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    boolean z7 = z2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    z3 = z7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                    }
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf5 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf5);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list5 = (List) objRememberedValue2;
                    Modifier modifierMinimumInteractiveComponentSize5 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f10 = ThumbRadius;
                    float f11 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize5, Dp.m5160constructorimpl(f10 * f11), Dp.m5160constructorimpl(f10 * f11), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list5, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState5, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    modifier3 = modifier2;
                    interfaceC3588op3 = interfaceC3588op2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    boolean z8 = z2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    z3 = z8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                }
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState6 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf6 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf6);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list6 = (List) objRememberedValue2;
                Modifier modifierMinimumInteractiveComponentSize6 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f12 = ThumbRadius;
                float f13 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize6, Dp.m5160constructorimpl(f12 * f13), Dp.m5160constructorimpl(f12 * f13), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list6, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState6, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0789Ob3 = interfaceC0789ObB;
                modifier3 = modifier2;
                interfaceC3588op3 = interfaceC3588op2;
                mutableInteractionSource3 = mutableInteractionSource2;
                boolean z9 = z2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                z3 = z9;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                }
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState7 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf7 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf7);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list7 = (List) objRememberedValue2;
                Modifier modifierMinimumInteractiveComponentSize7 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f14 = ThumbRadius;
                float f15 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize7, Dp.m5160constructorimpl(f14 * f15), Dp.m5160constructorimpl(f14 * f15), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list7, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState7, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0789Ob3 = interfaceC0789ObB;
                modifier3 = modifier2;
                interfaceC3588op3 = interfaceC3588op2;
                mutableInteractionSource3 = mutableInteractionSource2;
                boolean z10 = z2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                z3 = z10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    interfaceC0789Ob2 = interfaceC0789Ob;
                    if (composerStartRestartGroup.changed(interfaceC0789Ob2)) {
                    }
                    i4 |= i17;
                } else {
                    interfaceC0789Ob2 = interfaceC0789Ob;
                }
                i4 |= i17;
            } else {
                interfaceC0789Ob2 = interfaceC0789Ob;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                    }
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState8 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf8 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf8);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list8 = (List) objRememberedValue2;
                    Modifier modifierMinimumInteractiveComponentSize8 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f16 = ThumbRadius;
                    float f17 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize8, Dp.m5160constructorimpl(f16 * f17), Dp.m5160constructorimpl(f16 * f17), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list8, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState8, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    modifier3 = modifier2;
                    interfaceC3588op3 = interfaceC3588op2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    boolean z11 = z2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    z3 = z11;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            interfaceC0789ObB = interfaceC0789Ob2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i;
                        }
                        if (i10 != 0) {
                            interfaceC3588op2 = null;
                        } else {
                            interfaceC3588op2 = interfaceC3588op;
                        }
                        if (i12 != 0) {
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
                        if ((i3 & 256) != 0) {
                            i15 = (-234881025) & i4;
                            sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        } else {
                            sliderColorsM1198colorsq0g_0yA = sliderColors;
                            i15 = i4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                    }
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                    State stateRememberUpdatedState9 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf9 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(numValueOf9);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list9 = (List) objRememberedValue2;
                    Modifier modifierMinimumInteractiveComponentSize9 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f18 = ThumbRadius;
                    float f19 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize9, Dp.m5160constructorimpl(f18 * f19), Dp.m5160constructorimpl(f18 * f19), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list9, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState9, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0789Ob3 = interfaceC0789ObB;
                    modifier3 = modifier2;
                    interfaceC3588op3 = interfaceC3588op2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    boolean z12 = z2;
                    sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                    z3 = z12;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                }
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState10 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf10 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf10);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list10 = (List) objRememberedValue2;
                Modifier modifierMinimumInteractiveComponentSize10 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f110 = ThumbRadius;
                float f111 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize10, Dp.m5160constructorimpl(f110 * f111), Dp.m5160constructorimpl(f110 * f111), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list10, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState10, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0789Ob3 = interfaceC0789ObB;
                modifier3 = modifier2;
                interfaceC3588op3 = interfaceC3588op2;
                mutableInteractionSource3 = mutableInteractionSource2;
                boolean z13 = z2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                z3 = z13;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                }
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState11 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf11 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf11);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list11 = (List) objRememberedValue2;
                Modifier modifierMinimumInteractiveComponentSize11 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f112 = ThumbRadius;
                float f113 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize11, Dp.m5160constructorimpl(f112 * f113), Dp.m5160constructorimpl(f112 * f113), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list11, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState11, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0789Ob3 = interfaceC0789ObB;
                modifier3 = modifier2;
                interfaceC3588op3 = interfaceC3588op2;
                mutableInteractionSource3 = mutableInteractionSource2;
                boolean z14 = z2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                z3 = z14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
        }
        i4 |= 3072;
        z2 = z;
        if ((57344 & i2) == 0) {
            if ((i3 & 16) == 0) {
                interfaceC0789Ob2 = interfaceC0789Ob;
                if (composerStartRestartGroup.changed(interfaceC0789Ob2)) {
                }
                i4 |= i17;
            } else {
                interfaceC0789Ob2 = interfaceC0789Ob;
            }
            i4 |= i17;
        } else {
            interfaceC0789Ob2 = interfaceC0789Ob;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                i8 = i;
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i4 |= i9;
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                }
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState12 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf12 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf12);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list12 = (List) objRememberedValue2;
                Modifier modifierMinimumInteractiveComponentSize12 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f114 = ThumbRadius;
                float f115 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize12, Dp.m5160constructorimpl(f114 * f115), Dp.m5160constructorimpl(f114 * f115), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list12, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState12, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0789Ob3 = interfaceC0789ObB;
                modifier3 = modifier2;
                interfaceC3588op3 = interfaceC3588op2;
                mutableInteractionSource3 = mutableInteractionSource2;
                boolean z15 = z2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                z3 = z15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        interfaceC0789ObB = interfaceC0789Ob2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i;
                    }
                    if (i10 != 0) {
                        interfaceC3588op2 = null;
                    } else {
                        interfaceC3588op2 = interfaceC3588op;
                    }
                    if (i12 != 0) {
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
                    if ((i3 & 256) != 0) {
                        i15 = (-234881025) & i4;
                        sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    } else {
                        sliderColorsM1198colorsq0g_0yA = sliderColors;
                        i15 = i4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
                }
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0");
                }
                State stateRememberUpdatedState13 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf13 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(numValueOf13);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list13 = (List) objRememberedValue2;
                Modifier modifierMinimumInteractiveComponentSize13 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f116 = ThumbRadius;
                float f117 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize13, Dp.m5160constructorimpl(f116 * f117), Dp.m5160constructorimpl(f116 * f117), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list13, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState13, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0789Ob3 = interfaceC0789ObB;
                modifier3 = modifier2;
                interfaceC3588op3 = interfaceC3588op2;
                mutableInteractionSource3 = mutableInteractionSource2;
                boolean z16 = z2;
                sliderColors2 = sliderColorsM1198colorsq0g_0yA;
                z3 = z16;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i8 = i;
        i10 = i3 & 64;
        if (i10 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3588op)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i4 |= i11;
        }
        i12 = i3 & 128;
        if (i12 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i4 |= i13;
        }
        if ((i2 & 234881024) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
        }
        if ((i4 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if (i12 != 0) {
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
                if ((i3 & 256) != 0) {
                    i15 = (-234881025) & i4;
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    i15 = i4;
                }
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if (i12 != 0) {
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
                if ((i3 & 256) != 0) {
                    i15 = (-234881025) & i4;
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    i15 = i4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
            }
            if (i14 < 0) {
                throw new IllegalArgumentException("steps should be >= 0");
            }
            State stateRememberUpdatedState14 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
            Integer numValueOf14 = Integer.valueOf(i14);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(numValueOf14);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            List list14 = (List) objRememberedValue2;
            Modifier modifierMinimumInteractiveComponentSize14 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
            float f118 = ThumbRadius;
            float f119 = 2;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize14, Dp.m5160constructorimpl(f118 * f119), Dp.m5160constructorimpl(f118 * f119), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list14, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState14, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0789Ob3 = interfaceC0789ObB;
            modifier3 = modifier2;
            interfaceC3588op3 = interfaceC3588op2;
            mutableInteractionSource3 = mutableInteractionSource2;
            boolean z17 = z2;
            sliderColors2 = sliderColorsM1198colorsq0g_0yA;
            z3 = z17;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if (i12 != 0) {
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
                if ((i3 & 256) != 0) {
                    i15 = (-234881025) & i4;
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    i15 = i4;
                }
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    interfaceC0789ObB = AbstractC3790rJ.b(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    interfaceC0789ObB = interfaceC0789Ob2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i;
                }
                if (i10 != 0) {
                    interfaceC3588op2 = null;
                } else {
                    interfaceC3588op2 = interfaceC3588op;
                }
                if (i12 != 0) {
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
                if ((i3 & 256) != 0) {
                    i15 = (-234881025) & i4;
                    sliderColorsM1198colorsq0g_0yA = SliderDefaults.INSTANCE.m1198colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                } else {
                    sliderColorsM1198colorsq0g_0yA = sliderColors;
                    i15 = i4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962335196, i15, -1, "androidx.compose.material.Slider (Slider.kt:145)");
            }
            if (i14 < 0) {
                throw new IllegalArgumentException("steps should be >= 0");
            }
            State stateRememberUpdatedState15 = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, (i15 >> 3) & 14);
            Integer numValueOf15 = Integer.valueOf(i14);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(numValueOf15);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            List list15 = (List) objRememberedValue2;
            Modifier modifierMinimumInteractiveComponentSize15 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
            float f1110 = ThumbRadius;
            float f1111 = 2;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m528requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize15, Dp.m5160constructorimpl(f1110 * f1111), Dp.m5160constructorimpl(f1110 * f1111), 0.0f, 0.0f, 12, null), f, z2, interfaceC3750qp, interfaceC3588op2, interfaceC0789ObB, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C14373(interfaceC0789ObB, i15, f, mutableInteractionSource2, z2, list15, sliderColorsM1198colorsq0g_0yA, stateRememberUpdatedState15, interfaceC3588op2)), composerStartRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0789Ob3 = interfaceC0789ObB;
            modifier3 = modifier2;
            interfaceC3588op3 = interfaceC3588op2;
            mutableInteractionSource3 = mutableInteractionSource2;
            boolean z18 = z2;
            sliderColors2 = sliderColorsM1198colorsq0g_0yA;
            z3 = z18;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(f, interfaceC3750qp, modifier3, z3, interfaceC0789Ob3, i14, interfaceC3588op3, mutableInteractionSource3, sliderColors2, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SliderImpl(boolean z, float f, List<Float> list, SliderColors sliderColors, float f2, MutableInteractionSource mutableInteractionSource, Modifier modifier, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1679682785);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1679682785, i, -1, "androidx.compose.material.SliderImpl (Slider.kt:579)");
        }
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierThen);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float fMo333toPx0680j_4 = density.mo333toPx0680j_4(TrackHeight);
        float f3 = ThumbRadius;
        float fMo333toPx0680j_5 = density.mo333toPx0680j_4(f3);
        float fMo329toDpu2uoSUM = density.mo329toDpu2uoSUM(f2);
        float fM5160constructorimpl = Dp.m5160constructorimpl(f3 * 2);
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(fMo329toDpu2uoSUM * f);
        Modifier.Companion companion2 = Modifier.Companion;
        int i2 = i >> 6;
        Track(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), sliderColors, z, 0.0f, f, list, fMo333toPx0680j_5, fMo333toPx0680j_4, composerStartRestartGroup, (i2 & 112) | 265222 | ((i << 6) & 896) | ((i << 9) & 57344));
        m1199SliderThumbPcYyNuk(boxScopeInstance, companion2, fM5160constructorimpl2, mutableInteractionSource, sliderColors, z, fM5160constructorimpl, composerStartRestartGroup, (i2 & 7168) | 1572918 | ((i << 3) & 57344) | ((i << 15) & 458752));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14382(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m1199SliderThumbPcYyNuk(BoxScope boxScope, Modifier modifier, float f, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z, float f2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(428907178);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        int i3 = i2;
        if ((2995931 & i3) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(428907178, i3, -1, "androidx.compose.material.SliderThumb (Slider.kt:684)");
            }
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, f, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion = Alignment.Companion;
            Modifier modifierAlign = boxScope.align(modifierM489paddingqDBjuR0$default, companion.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierAlign);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.Companion;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i4 = i3 >> 9;
            int i5 = i4 & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i5 | 64);
            SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m534sizeVpY3zN4(modifier, f2, f2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), z ? !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation : Dp.m5160constructorimpl(0), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), sliderColors.thumbColor(z, composerStartRestartGroup, ((i3 >> 15) & 14) | (i4 & 112)).getValue().m3042unboximpl(), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new SliderKt$SliderThumb$2(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Track(Modifier modifier, SliderColors sliderColors, boolean z, float f, float f2, List<Float> list, float f3, float f4, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1833126050);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1833126050, i, -1, "androidx.compose.material.Track (Slider.kt:730)");
        }
        int i2 = ((i >> 6) & 14) | 48 | ((i << 3) & 896);
        CanvasKt.Canvas(modifier, new AnonymousClass1(f3, sliderColors.trackColor(z, false, composerStartRestartGroup, i2), f4, f2, f, sliderColors.trackColor(z, true, composerStartRestartGroup, i2), list, sliderColors.tickColor(z, false, composerStartRestartGroup, i2), sliderColors.tickColor(z, true, composerStartRestartGroup, i2)), composerStartRestartGroup, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14392(modifier, sliderColors, z, f, f2, list, f3, f4, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f2, float f3, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2304gk.a(draggableState, null, new C14402(f, f2, f3, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    public static final Object m1202awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        LJ lj;
        if (interfaceC0793Of instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) interfaceC0793Of;
            int i2 = sliderKt$awaitSlop$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label = i2 - Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(interfaceC0793Of);
            }
        } else {
            sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(interfaceC0793Of);
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$2 = sliderKt$awaitSlop$1;
        Object obj = sliderKt$awaitSlop$2.result;
        Object objD = AbstractC0378Bt.d();
        int i3 = sliderKt$awaitSlop$2.label;
        if (i3 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            SliderKt$awaitSlop$postPointerSlop$1 sliderKt$awaitSlop$postPointerSlop$1 = new SliderKt$awaitSlop$postPointerSlop$1(lj2);
            sliderKt$awaitSlop$2.L$0 = lj2;
            sliderKt$awaitSlop$2.label = 1;
            Object objM1087awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m1087awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, sliderKt$awaitSlop$postPointerSlop$1, sliderKt$awaitSlop$2);
            if (objM1087awaitHorizontalPointerSlopOrCancellationgDDlDlE == objD) {
                return objD;
            }
            obj = objM1087awaitHorizontalPointerSlopOrCancellationgDDlDlE;
            lj = lj2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lj = (LJ) sliderKt$awaitSlop$2.L$0;
            LL.b(obj);
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
            return HV.a(pointerInputChange, E8.b(lj.a));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return AbstractC3871sJ.k(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z, boolean z2, float f, InterfaceC0789Ob interfaceC0789Ob, State<? extends InterfaceC3750qp> state3, State<? extends InterfaceC0526Fp> state4) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), interfaceC0789Ob}, (InterfaceC0526Fp) new C14411(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z2, f, state3, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier modifier, float f, boolean z, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC0789Ob interfaceC0789Ob, int i) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new C14421(z, interfaceC0789Ob, i, AbstractC3871sJ.k(f, ((Number) interfaceC0789Ob.getStart()).floatValue(), ((Number) interfaceC0789Ob.getEndInclusive()).floatValue()), interfaceC3750qp, interfaceC3588op), 1, null), f, interfaceC0789Ob, i);
    }

    public static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC0789Ob interfaceC0789Ob, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            interfaceC3588op = null;
        }
        InterfaceC3588op interfaceC3588op2 = interfaceC3588op;
        if ((i2 & 16) != 0) {
            interfaceC0789Ob = AbstractC3790rJ.b(0.0f, 1.0f);
        }
        return sliderSemantics(modifier, f, z, interfaceC3750qp, interfaceC3588op2, interfaceC0789Ob, (i2 & 32) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier modifier, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f, boolean z, State<Float> state, State<? extends InterfaceC3750qp> state2, MutableState<Float> mutableState, boolean z2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(draggableState, mutableInteractionSource, f, z, state, state2, mutableState, z2) : InspectableValueKt.getNoInspectorInfo(), new C14432(z2, draggableState, mutableInteractionSource, f, z, mutableState, state, state2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f, List<Float> list, float f2, float f3) {
        Object obj;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(MathHelpersKt.lerp(f2, f3, ((Number) next).floatValue()) - f);
                do {
                    Object next2 = it.next();
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f2, f3, ((Number) next2).floatValue()) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Float f4 = (Float) obj;
        return f4 != null ? MathHelpersKt.lerp(f2, f3, f4.floatValue()) : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Float> stepsToTickFractions(int i) {
        if (i == 0) {
            return AbstractC1886cc.m();
        }
        int i2 = i + 2;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(i3 / (i + 1)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0789Ob scale(float f, float f2, InterfaceC0789Ob interfaceC0789Ob, float f3, float f4) {
        return AbstractC3790rJ.b(scale(f, f2, ((Number) interfaceC0789Ob.getStart()).floatValue(), f3, f4), scale(f, f2, ((Number) interfaceC0789Ob.getEndInclusive()).floatValue(), f3, f4));
    }
}
