package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultFlingBehavior implements FlingBehavior {
    private final DecayAnimationSpec<Float> flingDecay;
    private int lastAnimationCycleCount;
    private final MotionDurationScale motionDurationScale;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", l = {TypedValues.MotionType.TYPE_EASING}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $initialVelocity;
        final /* synthetic */ ScrollScope $this_performFling;
        Object L$0;
        int label;
        final /* synthetic */ DefaultFlingBehavior this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ LJ $lastValue;
            final /* synthetic */ ScrollScope $this_performFling;
            final /* synthetic */ LJ $velocityLeft;
            final /* synthetic */ DefaultFlingBehavior this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LJ lj, ScrollScope scrollScope, LJ lj2, DefaultFlingBehavior defaultFlingBehavior) {
                super(1);
                this.$lastValue = lj;
                this.$this_performFling = scrollScope;
                this.$velocityLeft = lj2;
                this.this$0 = defaultFlingBehavior;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                AbstractC4492zt.h(animationScope, "$this$animateDecay");
                float fFloatValue = animationScope.getValue().floatValue() - this.$lastValue.a;
                float fScrollBy = this.$this_performFling.scrollBy(fFloatValue);
                this.$lastValue.a = animationScope.getValue().floatValue();
                this.$velocityLeft.a = animationScope.getVelocity().floatValue();
                if (Math.abs(fFloatValue - fScrollBy) > 0.5f) {
                    animationScope.cancelAnimation();
                }
                DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                defaultFlingBehavior.setLastAnimationCycleCount(defaultFlingBehavior.getLastAnimationCycleCount() + 1);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$initialVelocity = f;
            this.this$0 = defaultFlingBehavior;
            this.$this_performFling = scrollScope;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$initialVelocity, this.this$0, this.$this_performFling, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            float f;
            LJ lj;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                if (Math.abs(this.$initialVelocity) > 1.0f) {
                    LJ lj2 = new LJ();
                    lj2.a = this.$initialVelocity;
                    LJ lj3 = new LJ();
                    AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(0.0f, this.$initialVelocity, 0L, 0L, false, 28, null);
                    DecayAnimationSpec decayAnimationSpec = this.this$0.flingDecay;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(lj3, this.$this_performFling, lj2, this.this$0);
                    this.L$0 = lj2;
                    this.label = 1;
                    if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default, decayAnimationSpec, false, anonymousClass1, this, 2, null) == objD) {
                        return objD;
                    }
                    lj = lj2;
                } else {
                    f = this.$initialVelocity;
                }
                return E8.b(f);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lj = (LJ) this.L$0;
            LL.b(obj);
            f = lj.a;
            return E8.b(f);
        }
    }

    public DefaultFlingBehavior(DecayAnimationSpec<Float> decayAnimationSpec, MotionDurationScale motionDurationScale) {
        AbstractC4492zt.h(decayAnimationSpec, "flingDecay");
        AbstractC4492zt.h(motionDurationScale, "motionDurationScale");
        this.flingDecay = decayAnimationSpec;
        this.motionDurationScale = motionDurationScale;
    }

    public final int getLastAnimationCycleCount() {
        return this.lastAnimationCycleCount;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, InterfaceC0793Of interfaceC0793Of) {
        this.lastAnimationCycleCount = 0;
        return M8.g(this.motionDurationScale, new AnonymousClass2(f, this, scrollScope, null), interfaceC0793Of);
    }

    public final void setLastAnimationCycleCount(int i) {
        this.lastAnimationCycleCount = i;
    }

    public /* synthetic */ DefaultFlingBehavior(DecayAnimationSpec decayAnimationSpec, MotionDurationScale motionDurationScale, int i, AbstractC0419Di abstractC0419Di) {
        this(decayAnimationSpec, (i & 2) != 0 ? ScrollableKt.getDefaultScrollMotionDurationScale() : motionDurationScale);
    }
}
