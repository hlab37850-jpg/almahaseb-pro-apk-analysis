package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.C0893Rs;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateDp$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final SpringSpec<Dp> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-575880366);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-575880366, i, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:964)");
            }
            SpringSpec<Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m5158boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateFloat$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12961 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C12961 INSTANCE = new C12961();

        public C12961() {
            super(3);
        }

        @Composable
        public final SpringSpec<Float> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-522164544);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-522164544, i, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:935)");
            }
            SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateInt$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12971 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C12971 INSTANCE = new C12971();

        public C12971() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final SpringSpec<Integer> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-785273069);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-785273069, i, -1, "androidx.compose.animation.core.animateInt.<anonymous> (Transition.kt:1088)");
            }
            SpringSpec<Integer> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateIntOffset$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12981 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C12981 INSTANCE = new C12981();

        public C12981() {
            super(3);
        }

        @Composable
        public final SpringSpec<IntOffset> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-1953479610);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953479610, i, -1, "androidx.compose.animation.core.animateIntOffset.<anonymous> (Transition.kt:1059)");
            }
            SpringSpec<IntOffset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5269boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateIntSize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12991 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C12991 INSTANCE = new C12991();

        public C12991() {
            super(3);
        }

        @Composable
        public final SpringSpec<IntSize> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(967893300);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(967893300, i, -1, "androidx.compose.animation.core.animateIntSize.<anonymous> (Transition.kt:1120)");
            }
            SpringSpec<IntSize> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m5312boximpl(IntSizeKt.IntSize(1, 1)), 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateOffset$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13001 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C13001 INSTANCE = new C13001();

        public C13001() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final SpringSpec<Offset> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(1623385561);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623385561, i, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:995)");
            }
            SpringSpec<Offset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m2787boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateRect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13011 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C13011 INSTANCE = new C13011();

        public C13011() {
            super(3);
        }

        @Composable
        public final SpringSpec<Rect> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(691336298);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(691336298, i, -1, "androidx.compose.animation.core.animateRect.<anonymous> (Transition.kt:1150)");
            }
            SpringSpec<Rect> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateSize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13021 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C13021 INSTANCE = new C13021();

        public C13021() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final SpringSpec<Size> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-1607152761);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1607152761, i, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:1026)");
            }
            SpringSpec<Size> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m2855boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateValue$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13031 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C13031 INSTANCE = new C13031();

        public C13031() {
            super(3);
        }

        @Composable
        public final SpringSpec<T> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-895531546);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-895531546, i, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:852)");
            }
            SpringSpec<T> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13041 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Transition<S>.DeferredAnimation<T, V> $lazyAnim;
        final /* synthetic */ Transition<S> $this_createDeferredAnimation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13041(Transition<S> transition, Transition<S>.DeferredAnimation<T, V> deferredAnimation) {
            super(1);
            this.$this_createDeferredAnimation = transition;
            this.$lazyAnim = deferredAnimation;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            final Transition<S> transition = this.$this_createDeferredAnimation;
            final Transition<S>.DeferredAnimation<T, V> deferredAnimation = this.$lazyAnim;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    transition.removeAnimation$animation_core_release(deferredAnimation);
                }
            };
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Dp> animateDp(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(184732935);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = AnonymousClass1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Dp> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Float> animateFloat(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(-1338768149);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C12961.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(C0774Nm.a);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Float> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Integer> animateInt(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(1318902782);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C12971.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(C0893Rs.a);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Integer> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<IntOffset> animateIntOffset(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(776131825);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C12981.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<IntOffset> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<IntSize> animateIntSize(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(-2104123233);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C12991.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<IntSize> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Offset> animateOffset(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(2078477582);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C13001.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Offset> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Rect> animateRect(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(1496278239);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C13011.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Rect> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Size> animateSize(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(-802210820);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = C13021.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Size> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(twoWayConverter, "typeConverter");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(-142660079);
        if ((i2 & 2) != 0) {
            interfaceC0552Gp = C13031.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i3 = (i >> 9) & 112;
        State<T> stateCreateTransitionAnimation = createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i3)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i3)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i >> 3) & 112)), twoWayConverter, str, composer, (i & 14) | (57344 & (i << 9)) | ((i << 6) & 458752));
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @ExperimentalTransitionApi
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <S, T> Transition<T> createChildTransition(Transition<S> transition, String str, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp, "transformToChildState");
        composer.startReplaceableGroup(1215497572);
        if ((i2 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i3 = i & 14;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        if (transition.isSeeking()) {
            objRememberedValue = transition.getCurrentState();
        }
        int i4 = (i >> 3) & 112;
        Transition<T> transitionCreateChildTransitionInternal = createChildTransitionInternal(transition, interfaceC0552Gp.invoke(objRememberedValue, composer, Integer.valueOf(i4)), interfaceC0552Gp.invoke(transition.getTargetState(), composer, Integer.valueOf(i4)), str2, composer, i3 | ((i << 6) & 7168));
        composer.endReplaceableGroup();
        return transitionCreateChildTransitionInternal;
    }

    @Composable
    public static final <S, T> Transition<T> createChildTransitionInternal(Transition<S> transition, T t, T t2, String str, Composer composer, int i) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(str, "childLabel");
        composer.startReplaceableGroup(-198307638);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:794)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition(new MutableTransitionState(t), transition.getLabel() + " > " + str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition2 = (Transition) objRememberedValue;
        composer.startReplaceableGroup(511388516);
        boolean zChanged2 = composer.changed(transition) | composer.changed(transition2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new TransitionKt$createChildTransitionInternal$1$1(transition, transition2);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition2, (InterfaceC3750qp) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t2, composer, ((i >> 3) & 8) | ((i >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition2;
    }

    @Composable
    @InternalAnimationApi
    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(twoWayConverter, "typeConverter");
        composer.startReplaceableGroup(-1714122528);
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:749)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition.DeferredAnimation(transition, twoWayConverter, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        EffectsKt.DisposableEffect(deferredAnimation, new C13041(transition, deferredAnimation), composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return deferredAnimation;
    }

    @Composable
    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(Transition<S> transition, T t, T t2, FiniteAnimationSpec<T> finiteAnimationSpec, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(twoWayConverter, "typeConverter");
        AbstractC4492zt.h(str, HTML.Tag.LABEL);
        composer.startReplaceableGroup(-304821198);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:866)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition.TransitionAnimationState(transition, t, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t2), twoWayConverter, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) objRememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState.updateInitialAndTargetValue$animation_core_release(t, t2, finiteAnimationSpec);
        } else {
            transitionAnimationState.updateTargetValue$animation_core_release(t2, finiteAnimationSpec);
        }
        composer.startReplaceableGroup(511388516);
        boolean zChanged2 = composer.changed(transition) | composer.changed(transitionAnimationState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new TransitionKt$createTransitionAnimation$1$1(transition, transitionAnimationState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transitionAnimationState, (InterfaceC3750qp) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transitionAnimationState;
    }

    @Composable
    public static final <T> Transition<T> updateTransition(T t, String str, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2029166765);
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:67)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new Transition(t, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(t, composer, (i & 8) | 48 | (i & 14));
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new TransitionKt$updateTransition$1$1(transition);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (InterfaceC3750qp) objRememberedValue2, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition;
    }

    @Composable
    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> mutableTransitionState, String str, Composer composer, int i, int i2) {
        AbstractC4492zt.h(mutableTransitionState, "transitionState");
        composer.startReplaceableGroup(882913843);
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:150)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(mutableTransitionState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition((MutableTransitionState) mutableTransitionState, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(mutableTransitionState.getTargetState(), composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new TransitionKt$updateTransition$2$1(transition);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (InterfaceC3750qp) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition;
    }
}
