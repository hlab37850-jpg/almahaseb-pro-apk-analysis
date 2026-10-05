package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
public final class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp = Dp.m5160constructorimpl(400);
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", l = {362}, m = "animateDecay")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehaviorKt.animateDecay(null, 0.0f, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onAnimationStep;
        final /* synthetic */ LJ $previousValue;
        final /* synthetic */ float $targetOffset;
        final /* synthetic */ ScrollScope $this_animateDecay;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, LJ lj, ScrollScope scrollScope, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$targetOffset = f;
            this.$previousValue = lj;
            this.$this_animateDecay = scrollScope;
            this.$onAnimationStep = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope<Float, AnimationVector1D>) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animateDecay");
            if (Math.abs(animationScope.getValue().floatValue()) < Math.abs(this.$targetOffset)) {
                SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, this.$this_animateDecay, this.$onAnimationStep, animationScope.getValue().floatValue() - this.$previousValue.a);
                this.$previousValue.a = animationScope.getValue().floatValue();
                return;
            }
            float fCoerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), this.$targetOffset);
            SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, this.$this_animateDecay, this.$onAnimationStep, fCoerceToTarget - this.$previousValue.a);
            animationScope.cancelAnimation();
            this.$previousValue.a = fCoerceToTarget;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", l = {407}, m = "animateSnap")
    public static final class C13421 extends AbstractC0819Pf {
        float F$0;
        float F$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13421(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehaviorKt.animateSnap(null, 0.0f, 0.0f, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13432 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $cancelOffset;
        final /* synthetic */ LJ $consumedUpToNow;
        final /* synthetic */ InterfaceC3750qp $onAnimationStep;
        final /* synthetic */ ScrollScope $this_animateSnap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13432(float f, LJ lj, ScrollScope scrollScope, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$cancelOffset = f;
            this.$consumedUpToNow = lj;
            this.$this_animateSnap = scrollScope;
            this.$onAnimationStep = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope<Float, AnimationVector1D>) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animateTo");
            float fCoerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), this.$cancelOffset);
            float f = fCoerceToTarget - this.$consumedUpToNow.a;
            float fScrollBy = this.$this_animateSnap.scrollBy(f);
            this.$onAnimationStep.invoke(Float.valueOf(fScrollBy));
            if (Math.abs(f - fScrollBy) > 0.5f || fCoerceToTarget != animationScope.getValue().floatValue()) {
                animationScope.cancelAnimation();
            }
            this.$consumedUpToNow.a += fScrollBy;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", l = {312}, m = "approach")
    public static final class C13441 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13441(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehaviorKt.approach(null, 0.0f, 0.0f, null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object animateDecay(ScrollScope scrollScope, float f, AnimationState<Float, AnimationVector1D> animationState, DecayAnimationSpec<Float> decayAnimationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        LJ lj;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            boolean z = animationState.getVelocity().floatValue() == 0.0f;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(f, lj2, scrollScope, interfaceC3750qp);
            anonymousClass1.L$0 = animationState;
            anonymousClass1.L$1 = lj2;
            anonymousClass1.F$0 = f;
            anonymousClass1.label = 1;
            if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z, anonymousClass2, anonymousClass1) == objD) {
                return objD;
            }
            lj = lj2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = anonymousClass1.F$0;
            lj = (LJ) anonymousClass1.L$1;
            animationState = (AnimationState) anonymousClass1.L$0;
            LL.b(obj);
        }
        return new AnimationResult(E8.b(f - lj.a), animationState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, InterfaceC3750qp interfaceC3750qp, float f) {
        float fScrollBy = scrollScope.scrollBy(f);
        interfaceC3750qp.invoke(Float.valueOf(fScrollBy));
        if (Math.abs(f - fScrollBy) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public static final Object animateSnap(ScrollScope scrollScope, float f, float f2, AnimationState<Float, AnimationVector1D> animationState, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13421 c13421;
        float f3;
        LJ lj;
        float f4;
        AnimationState<Float, AnimationVector1D> animationState2;
        if (interfaceC0793Of instanceof C13421) {
            c13421 = (C13421) interfaceC0793Of;
            int i = c13421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13421.label = i - Integer.MIN_VALUE;
            } else {
                c13421 = new C13421(interfaceC0793Of);
            }
        } else {
            c13421 = new C13421(interfaceC0793Of);
        }
        C13421 c13422 = c13421;
        Object obj = c13422.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13422.label;
        if (i2 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            float fFloatValue = animationState.getVelocity().floatValue();
            Float fB = E8.b(f);
            boolean z = animationState.getVelocity().floatValue() == 0.0f;
            C13432 c13432 = new C13432(f2, lj2, scrollScope, interfaceC3750qp);
            c13422.L$0 = animationState;
            c13422.L$1 = lj2;
            f3 = f;
            c13422.F$0 = f3;
            c13422.F$1 = fFloatValue;
            c13422.label = 1;
            if (SuspendAnimationKt.animateTo(animationState, fB, animationSpec, !z, c13432, c13422) == objD) {
                return objD;
            }
            lj = lj2;
            f4 = fFloatValue;
            animationState2 = animationState;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f4 = c13422.F$1;
            float f5 = c13422.F$0;
            lj = (LJ) c13422.L$1;
            AnimationState<Float, AnimationVector1D> animationState3 = (AnimationState) c13422.L$0;
            LL.b(obj);
            f3 = f5;
            animationState2 = animationState3;
        }
        return new AnimationResult(E8.b(f3 - lj.a), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, coerceToTarget(animationState2.getVelocity().floatValue(), f4), 0L, 0L, false, 29, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object approach(ScrollScope scrollScope, float f, float f2, ApproachAnimation<Float, AnimationVector1D> approachAnimation, SnapLayoutInfoProvider snapLayoutInfoProvider, Density density, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13441 c13441;
        if (interfaceC0793Of instanceof C13441) {
            c13441 = (C13441) interfaceC0793Of;
            int i = c13441.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13441.label = i - Integer.MIN_VALUE;
            } else {
                c13441 = new C13441(interfaceC0793Of);
            }
        } else {
            c13441 = new C13441(interfaceC0793Of);
        }
        C13441 c13442 = c13441;
        Object objApproachAnimation = c13442.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13442.label;
        if (i2 == 0) {
            LL.b(objApproachAnimation);
            Float fB = E8.b(f);
            Float fB2 = E8.b(f2);
            c13442.L$0 = snapLayoutInfoProvider;
            c13442.L$1 = density;
            c13442.label = 1;
            objApproachAnimation = approachAnimation.approachAnimation(scrollScope, fB, fB2, interfaceC3750qp, c13442);
            if (objApproachAnimation == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            density = (Density) c13442.L$1;
            snapLayoutInfoProvider = (SnapLayoutInfoProvider) c13442.L$0;
            LL.b(objApproachAnimation);
        }
        AnimationState animationStateComponent2 = ((AnimationResult) objApproachAnimation).component2();
        return new AnimationResult(E8.b(snapLayoutInfoProvider.calculateSnappingOffset(density, ((Number) animationStateComponent2.getVelocity()).floatValue())), animationStateComponent2);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public static final float calculateFinalOffset(float f, float f2, float f3) {
        float fSignum = Math.signum(f);
        if (fSignum == 0.0f) {
            if (Math.abs(f3) <= Math.abs(f2)) {
                f2 = f3;
            }
        } else if (fSignum == 1.0f) {
            f2 = f3;
        } else if (fSignum != -1.0f) {
            f2 = 0.0f;
        }
        if (calculateFinalOffset$isValidDistance(f2)) {
            return f2;
        }
        return 0.0f;
    }

    private static final boolean calculateFinalOffset$isValidDistance(float f) {
        return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? AbstractC3871sJ.f(f, f2) : AbstractC3871sJ.c(f, f2);
    }

    private static final <T extends Comparable<? super T>> T component1(InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(interfaceC0789Ob, "<this>");
        return (T) interfaceC0789Ob.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(interfaceC0789Ob, "<this>");
        return (T) interfaceC0789Ob.getEndInclusive();
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }

    @Composable
    @ExperimentalFoundationApi
    public static final SnapFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, Composer composer, int i) {
        AbstractC4492zt.h(snapLayoutInfoProvider, "snapLayoutInfoProvider");
        composer.startReplaceableGroup(-473984552);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-473984552, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:270)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        DecayAnimationSpec decayAnimationSpecRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(snapLayoutInfoProvider) | composer.changed(decayAnimationSpecRememberSplineBasedDecay) | composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            Object snapFlingBehavior = new SnapFlingBehavior(snapLayoutInfoProvider, AnimationSpecKt.tween$default(0, 0, EasingKt.getLinearEasing(), 3, null), decayAnimationSpecRememberSplineBasedDecay, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), density, 0.0f, 32, null);
            composer.updateRememberedValue(snapFlingBehavior);
            objRememberedValue = snapFlingBehavior;
        }
        composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior2 = (SnapFlingBehavior) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapFlingBehavior2;
    }

    private static final void debugLog(InterfaceC3588op interfaceC3588op) {
    }
}
