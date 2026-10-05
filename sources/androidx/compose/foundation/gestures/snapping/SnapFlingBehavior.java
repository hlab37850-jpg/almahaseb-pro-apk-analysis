package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.M8;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
public final class SnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final Density density;
    private final DecayAnimationSpec<Float> highVelocityAnimationSpec;
    private final AnimationSpec<Float> lowVelocityAnimationSpec;
    private MotionDurationScale motionScaleDuration;
    private final float shortSnapVelocityThreshold;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;
    private final float velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {ShapeTypes.PLUS}, m = "fling")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.fling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {ShapeTypes.MATH_DIVIDE, 191}, m = "longSnap")
    public static final class C13391 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13391(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.longSnap(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onAnimationStep;
        final /* synthetic */ LJ $remainingScrollOffset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(LJ lj, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$remainingScrollOffset = lj;
            this.$onAnimationStep = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).floatValue());
            return FW.a;
        }

        public final void invoke(float f) {
            LJ lj = this.$remainingScrollOffset;
            float f2 = lj.a - f;
            lj.a = f2;
            this.$onAnimationStep.invoke(Float.valueOf(f2));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onAnimationStep;
        final /* synthetic */ LJ $remainingScrollOffset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(LJ lj, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$remainingScrollOffset = lj;
            this.$onAnimationStep = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).floatValue());
            return FW.a;
        }

        public final void invoke(float f) {
            LJ lj = this.$remainingScrollOffset;
            float f2 = lj.a - f;
            lj.a = f2;
            this.$onAnimationStep.invoke(Float.valueOf(f2));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        public final void invoke(float f) {
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).floatValue());
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {117}, m = "performFling")
    public static final class C13403 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;

        public C13403(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.performFling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$shortSnap$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13413 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onRemainingScrollOffsetUpdate;
        final /* synthetic */ LJ $remainingScrollOffset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13413(LJ lj, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$remainingScrollOffset = lj;
            this.$onRemainingScrollOffsetUpdate = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).floatValue());
            return FW.a;
        }

        public final void invoke(float f) {
            LJ lj = this.$remainingScrollOffset;
            float f2 = lj.a - f;
            lj.a = f2;
            this.$onRemainingScrollOffsetUpdate.invoke(Float.valueOf(f2));
        }
    }

    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec2, Density density, float f, AbstractC0419Di abstractC0419Di) {
        this(snapLayoutInfoProvider, animationSpec, decayAnimationSpec, animationSpec2, density, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fling(ScrollScope scrollScope, float f, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Object objG = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(objG);
            MotionDurationScale motionDurationScale = this.motionScaleDuration;
            SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(f, this, scrollScope, interfaceC3750qp, null);
            anonymousClass1.L$0 = interfaceC3750qp;
            anonymousClass1.label = 1;
            objG = M8.g(motionDurationScale, snapFlingBehavior$fling$result$1, anonymousClass1);
            if (objG == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC3750qp = (InterfaceC3750qp) anonymousClass1.L$0;
            LL.b(objG);
        }
        AnimationResult animationResult = (AnimationResult) objG;
        interfaceC3750qp.invoke(E8.b(0.0f));
        return animationResult;
    }

    private final boolean isDecayApproachPossible(float f, float f2) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.highVelocityAnimationSpec, 0.0f, f2)) >= Math.abs(f) + this.snapLayoutInfoProvider.calculateSnapStepSize(this.density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object longSnap(ScrollScope scrollScope, float f, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13391 c13391;
        SnapFlingBehavior snapFlingBehavior;
        InterfaceC3750qp interfaceC3750qp2;
        LJ lj;
        ScrollScope scrollScope2;
        if (interfaceC0793Of instanceof C13391) {
            c13391 = (C13391) interfaceC0793Of;
            int i = c13391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13391.label = i - Integer.MIN_VALUE;
            } else {
                c13391 = new C13391(interfaceC0793Of);
            }
        } else {
            c13391 = new C13391(interfaceC0793Of);
        }
        C13391 c13392 = c13391;
        Object objRunApproach = c13392.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13392.label;
        if (i2 != 0) {
            if (i2 == 1) {
                lj = (LJ) c13392.L$3;
                interfaceC3750qp2 = (InterfaceC3750qp) c13392.L$2;
                ScrollScope scrollScope3 = (ScrollScope) c13392.L$1;
                snapFlingBehavior = (SnapFlingBehavior) c13392.L$0;
                LL.b(objRunApproach);
                scrollScope2 = scrollScope3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(objRunApproach);
            }
        }
        LL.b(objRunApproach);
        float fAbs = Math.abs(this.snapLayoutInfoProvider.calculateApproachOffset(this.density, f)) * Math.signum(f);
        LJ lj2 = new LJ();
        lj2.a = fAbs;
        interfaceC3750qp.invoke(E8.b(fAbs));
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(lj2, interfaceC3750qp);
        c13392.L$0 = this;
        c13392.L$1 = scrollScope;
        c13392.L$2 = interfaceC3750qp;
        c13392.L$3 = lj2;
        c13392.label = 1;
        objRunApproach = runApproach(scrollScope, fAbs, f, anonymousClass3, c13392);
        if (objRunApproach == objD) {
            return objD;
        }
        snapFlingBehavior = this;
        interfaceC3750qp2 = interfaceC3750qp;
        lj = lj2;
        scrollScope2 = scrollScope;
        AnimationResult animationResult = (AnimationResult) objRunApproach;
        float fFloatValue = ((Number) animationResult.component1()).floatValue();
        AnimationState animationStateComponent2 = animationResult.component2();
        lj.a = fFloatValue;
        AnimationState animationStateCopy$default = AnimationStateKt.copy$default(animationStateComponent2, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        AnimationSpec<Float> animationSpec = snapFlingBehavior.snapAnimationSpec;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(lj, interfaceC3750qp2);
        c13392.L$0 = null;
        c13392.L$1 = null;
        c13392.L$2 = null;
        c13392.L$3 = null;
        c13392.label = 2;
        objRunApproach = SnapFlingBehaviorKt.animateSnap(scrollScope2, fFloatValue, fFloatValue, animationStateCopy$default, animationSpec, anonymousClass5, c13392);
        return objRunApproach == objD ? objD : objRunApproach;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runApproach(ScrollScope scrollScope, float f, float f2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return SnapFlingBehaviorKt.approach(scrollScope, f, f2, isDecayApproachPossible(f, f2) ? new HighVelocityApproachAnimation(this.highVelocityAnimationSpec) : new LowVelocityApproachAnimation(this.lowVelocityAnimationSpec, this.snapLayoutInfoProvider, this.density), this.snapLayoutInfoProvider, this.density, interfaceC3750qp, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object shortSnap(ScrollScope scrollScope, float f, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        float fCalculateSnappingOffset = this.snapLayoutInfoProvider.calculateSnappingOffset(this.density, 0.0f);
        LJ lj = new LJ();
        lj.a = fCalculateSnappingOffset;
        return SnapFlingBehaviorKt.animateSnap(scrollScope, fCalculateSnappingOffset, fCalculateSnappingOffset, AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null), this.snapAnimationSpec, new C13413(lj, interfaceC3750qp), interfaceC0793Of);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
        return AbstractC4492zt.d(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && AbstractC4492zt.d(snapFlingBehavior.highVelocityAnimationSpec, this.highVelocityAnimationSpec) && AbstractC4492zt.d(snapFlingBehavior.lowVelocityAnimationSpec, this.lowVelocityAnimationSpec) && AbstractC4492zt.d(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider) && AbstractC4492zt.d(snapFlingBehavior.density, this.density) && Dp.m5165equalsimpl0(snapFlingBehavior.shortSnapVelocityThreshold, this.shortSnapVelocityThreshold);
    }

    public final MotionDurationScale getMotionScaleDuration$foundation_release() {
        return this.motionScaleDuration;
    }

    public int hashCode() {
        return (((((((((this.snapAnimationSpec.hashCode() * 31) + this.highVelocityAnimationSpec.hashCode()) * 31) + this.lowVelocityAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode()) * 31) + this.density.hashCode()) * 31) + Dp.m5166hashCodeimpl(this.shortSnapVelocityThreshold);
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, InterfaceC0793Of interfaceC0793Of) {
        return performFling(scrollScope, f, AnonymousClass2.INSTANCE, interfaceC0793Of);
    }

    public final void setMotionScaleDuration$foundation_release(MotionDurationScale motionDurationScale) {
        AbstractC4492zt.h(motionDurationScale, "<set-?>");
        this.motionScaleDuration = motionDurationScale;
    }

    private SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec2, Density density, float f) {
        AbstractC4492zt.h(snapLayoutInfoProvider, "snapLayoutInfoProvider");
        AbstractC4492zt.h(animationSpec, "lowVelocityAnimationSpec");
        AbstractC4492zt.h(decayAnimationSpec, "highVelocityAnimationSpec");
        AbstractC4492zt.h(animationSpec2, "snapAnimationSpec");
        AbstractC4492zt.h(density, "density");
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.lowVelocityAnimationSpec = animationSpec;
        this.highVelocityAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec2;
        this.density = density;
        this.shortSnapVelocityThreshold = f;
        this.velocityThreshold = density.mo333toPx0680j_4(f);
        this.motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object performFling(ScrollScope scrollScope, float f, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13403 c13403;
        if (interfaceC0793Of instanceof C13403) {
            c13403 = (C13403) interfaceC0793Of;
            int i = c13403.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13403.label = i - Integer.MIN_VALUE;
            } else {
                c13403 = new C13403(interfaceC0793Of);
            }
        } else {
            c13403 = new C13403(interfaceC0793Of);
        }
        Object objFling = c13403.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13403.label;
        if (i2 == 0) {
            LL.b(objFling);
            c13403.label = 1;
            objFling = fling(scrollScope, f, interfaceC3750qp, c13403);
            if (objFling == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objFling);
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        return E8.b(((Number) animationResult.component1()).floatValue() != 0.0f ? ((Number) animationResult.component2().getVelocity()).floatValue() : 0.0f);
    }

    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec2, Density density, float f, int i, AbstractC0419Di abstractC0419Di) {
        this(snapLayoutInfoProvider, animationSpec, decayAnimationSpec, animationSpec2, density, (i & 32) != 0 ? SnapFlingBehaviorKt.getMinFlingVelocityDp() : f, null);
    }
}
