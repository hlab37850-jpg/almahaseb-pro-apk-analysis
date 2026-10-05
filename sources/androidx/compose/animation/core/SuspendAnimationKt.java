package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.OJ;
import java.util.concurrent.CancellationException;
import org.apache.poi.hssf.record.UnknownRecord;

/* JADX INFO: loaded from: classes.dex */
public final class SuspendAnimationKt {

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $block;
        final /* synthetic */ TwoWayConverter<T, V> $typeConverter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, TwoWayConverter<T, V> twoWayConverter) {
            super(1);
            this.$block = interfaceC0526Fp;
            this.$typeConverter = twoWayConverter;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<T, V> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animate");
            this.$block.mo13invoke(animationScope.getValue(), this.$typeConverter.getConvertFromVector().invoke(animationScope.getVelocityVector()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$4, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.SuspendAnimationKt", f = "SuspendAnimation.kt", l = {UnknownRecord.PHONETICPR_00EF, TIFFConstants.TIFFTAG_ROWSPERSTRIP}, m = "animate")
    public static final class AnonymousClass4<T, V extends AnimationVector> extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass4(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendAnimationKt.animate(null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        public final void invoke(AnimationScope animationScope) {
            AbstractC4492zt.h(animationScope, "$this$null");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ InterfaceC3750qp $block;
        final /* synthetic */ float $durationScale;
        final /* synthetic */ T $initialValue;

        /* JADX INFO: Incorrect field signature: TV; */
        final /* synthetic */ AnimationVector $initialVelocityVector;
        final /* synthetic */ OJ $lateInitScope;
        final /* synthetic */ AnimationState<T, V> $this_animate;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
            final /* synthetic */ AnimationState<T, V> $this_animate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AnimationState<T, V> animationState) {
                super(0);
                this.$this_animate = animationState;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m134invoke() {
                this.$this_animate.setRunning$animation_core_release(false);
            }

            @Override // defpackage.InterfaceC3588op
            public /* bridge */ /* synthetic */ Object invoke() {
                m134invoke();
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (LOJ;TT;Landroidx/compose/animation/core/Animation<TT;TV;>;TV;Landroidx/compose/animation/core/AnimationState<TT;TV;>;FLqp;)V */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(OJ oj, Object obj, Animation animation, AnimationVector animationVector, AnimationState animationState, float f, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$lateInitScope = oj;
            this.$initialValue = obj;
            this.$animation = animation;
            this.$initialVelocityVector = animationVector;
            this.$this_animate = animationState;
            this.$durationScale = f;
            this.$block = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            OJ oj = this.$lateInitScope;
            AnimationScope animationScope = new AnimationScope(this.$initialValue, this.$animation.getTypeConverter(), this.$initialVelocityVector, j, this.$animation.getTargetValue(), j, true, new AnonymousClass1(this.$this_animate));
            SuspendAnimationKt.doAnimationFrameWithScale(animationScope, j, this.$durationScale, this.$animation, this.$this_animate, this.$block);
            oj.a = animationScope;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AnimationState<T, V> $this_animate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(AnimationState<T, V> animationState) {
            super(0);
            this.$this_animate = animationState;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m135invoke() {
            this.$this_animate.setRunning$animation_core_release(false);
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m135invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$9, reason: invalid class name */
    public static final class AnonymousClass9 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ InterfaceC3750qp $block;
        final /* synthetic */ float $durationScale;
        final /* synthetic */ OJ $lateInitScope;
        final /* synthetic */ AnimationState<T, V> $this_animate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(OJ oj, float f, Animation<T, V> animation, AnimationState<T, V> animationState, InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$lateInitScope = oj;
            this.$durationScale = f;
            this.$animation = animation;
            this.$this_animate = animationState;
            this.$block = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            Object obj = this.$lateInitScope.a;
            AbstractC4492zt.e(obj);
            SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) obj, j, this.$durationScale, this.$animation, this.$this_animate, this.$block);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0526Fp interfaceC0526Fp) {
            super(1);
            this.$block = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope<Float, AnimationVector1D>) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animate");
            this.$block.mo13invoke(animationScope.getValue(), Float.valueOf(((AnimationVector1D) animationScope.getVelocityVector()).getValue()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4, reason: invalid class name and case insensitive filesystem */
    public static final class C12934 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12934 INSTANCE = new C12934();

        public C12934() {
            super(1);
        }

        public final void invoke(AnimationScope animationScope) {
            AbstractC4492zt.h(animationScope, "$this$null");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12942 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12942 INSTANCE = new C12942();

        public C12942() {
            super(1);
        }

        public final void invoke(AnimationScope animationScope) {
            AbstractC4492zt.h(animationScope, "$this$null");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12952 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12952(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$onFrame = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [R, java.lang.Object] */
        public final R invoke(long j) {
            return this.$onFrame.invoke(Long.valueOf(j));
        }
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec<Float> animationSpec, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimate = animate(VectorConvertersKt.getVectorConverter(C0774Nm.a), E8.b(f), E8.b(f2), E8.b(f3), animationSpec, interfaceC0526Fp, interfaceC0793Of);
        return objAnimate == AbstractC0378Bt.d() ? objAnimate : FW.a;
    }

    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        float f4 = (i & 4) != 0 ? 0.0f : f3;
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f, f2, f4, animationSpec, interfaceC0526Fp, interfaceC0793Of);
    }

    public static final Object animateDecay(float f, float f2, FloatDecayAnimationSpec floatDecayAnimationSpec, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimate$default = animate$default(AnimationStateKt.AnimationState$default(f, f2, 0L, 0L, false, 28, null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f, f2), 0L, new AnonymousClass2(interfaceC0526Fp), interfaceC0793Of, 2, null);
        return objAnimate$default == AbstractC0378Bt.d() ? objAnimate$default : FW.a;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            interfaceC3750qp = C12934.INSTANCE;
        }
        return animateDecay(animationState, decayAnimationSpec, z, interfaceC3750qp, interfaceC0793Of);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t, AnimationSpec<T> animationSpec, boolean z, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objAnimate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, interfaceC3750qp, interfaceC0793Of);
        return objAnimate == AbstractC0378Bt.d() ? objAnimate : FW.a;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 8) != 0) {
            interfaceC3750qp = C12942.INSTANCE;
        }
        return animateTo(animationState, obj, animationSpec2, z2, interfaceC3750qp, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return animation.isInfinite() ? InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(interfaceC3750qp, interfaceC0793Of) : MonotonicFrameClockKt.withFrameNanos(new C12952(interfaceC3750qp), interfaceC0793Of);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j, long j2, Animation<T, V> animation, AnimationState<T, V> animationState, InterfaceC3750qp interfaceC3750qp) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j2));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j2));
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        interfaceC3750qp.invoke(animationScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j, float f, Animation<T, V> animation, AnimationState<T, V> animationState, InterfaceC3750qp interfaceC3750qp) {
        doAnimationFrame(animationScope, j, f == 0.0f ? animation.getDurationNanos() : (long) ((j - animationScope.getStartTimeNanos()) / f), animation, animationState, interfaceC3750qp);
    }

    public static final float getDurationScale(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "<this>");
        MotionDurationScale motionDurationScale = (MotionDurationScale) interfaceC0988Vf.get(MotionDurationScale.Key);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scaleFactor >= 0.0f) {
            return scaleFactor;
        }
        throw new IllegalStateException("Check failed.");
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> animationState) {
        AbstractC4492zt.h(animationScope, "<this>");
        AbstractC4492zt.h(animationState, "state");
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean z, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objAnimate = animate(animationState, new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter<T, AnimationVector>) animationState.getTypeConverter(), (Object) animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, interfaceC3750qp, interfaceC0793Of);
        return objAnimate == AbstractC0378Bt.d() ? objAnimate : FW.a;
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            interfaceC3750qp = AnonymousClass5.INSTANCE;
        }
        return animate(animationState, animation, j2, interfaceC3750qp, interfaceC0793Of);
    }

    public static final <T, V extends AnimationVector> Object animate(TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3, AnimationSpec<T> animationSpec, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        AnimationVector animationVectorNewInstance;
        if (t3 == null || (animationVectorNewInstance = (AnimationVector) twoWayConverter.getConvertToVector().invoke(t3)) == null) {
            animationVectorNewInstance = AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(t));
        }
        Object objAnimate$default = animate$default(new AnimationState(twoWayConverter, t, animationVectorNewInstance, 0L, 0L, false, 56, null), new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, animationVectorNewInstance), 0L, new AnonymousClass3(interfaceC0526Fp, twoWayConverter), interfaceC0793Of, 2, null);
        return objAnimate$default == AbstractC0378Bt.d() ? objAnimate$default : FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public static final <T, V extends AnimationVector> Object animate(AnimationState<T, V> animationState, Animation<T, V> animation, long j, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass4 anonymousClass4;
        OJ oj;
        InterfaceC3750qp interfaceC3750qp2;
        AnimationState<T, V> animationState2;
        AnimationScope animationScope;
        AnimationScope animationScope2;
        AnonymousClass9 anonymousClass9;
        AnimationState<T, V> animationState3 = animationState;
        Animation<T, V> animation2 = animation;
        if (interfaceC0793Of instanceof AnonymousClass4) {
            anonymousClass4 = (AnonymousClass4) interfaceC0793Of;
            int i = anonymousClass4.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass4.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass4 = new AnonymousClass4(interfaceC0793Of);
            }
        } else {
            anonymousClass4 = new AnonymousClass4(interfaceC0793Of);
        }
        AnonymousClass4 anonymousClass5 = anonymousClass4;
        Object obj = anonymousClass5.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass5.label;
        if (i2 == 0) {
            LL.b(obj);
            T valueFromNanos = animation2.getValueFromNanos(0L);
            AnimationVector velocityVectorFromNanos = animation2.getVelocityVectorFromNanos(0L);
            OJ oj2 = new OJ();
            try {
                if (j == Long.MIN_VALUE) {
                    AnonymousClass6 anonymousClass6 = new AnonymousClass6(oj2, valueFromNanos, animation, velocityVectorFromNanos, animationState, getDurationScale(anonymousClass5.getContext()), interfaceC3750qp);
                    anonymousClass5.L$0 = animationState3;
                    anonymousClass5.L$1 = animation2;
                    interfaceC3750qp2 = interfaceC3750qp;
                    anonymousClass5.L$2 = interfaceC3750qp2;
                    anonymousClass5.L$3 = oj2;
                    anonymousClass5.label = 1;
                    if (callWithFrameNanos(animation2, anonymousClass6, anonymousClass5) == objD) {
                        return objD;
                    }
                } else {
                    interfaceC3750qp2 = interfaceC3750qp;
                    try {
                        AnimationScope animationScope3 = new AnimationScope(valueFromNanos, animation.getTypeConverter(), velocityVectorFromNanos, j, animation.getTargetValue(), j, true, new AnonymousClass7(animationState3));
                        oj2 = oj2;
                        doAnimationFrameWithScale(animationScope3, j, getDurationScale(anonymousClass5.getContext()), animation, animationState, interfaceC3750qp);
                        oj2.a = animationScope3;
                    } catch (CancellationException e) {
                        e = e;
                        oj2 = oj2;
                        oj = oj2;
                        animationScope = (AnimationScope) oj.a;
                        if (animationScope != null) {
                            animationScope.setRunning$animation_core_release(false);
                        }
                        animationScope2 = (AnimationScope) oj.a;
                        if (animationScope2 != null && animationScope2.getLastFrameTimeNanos() == animationState3.getLastFrameTimeNanos()) {
                            animationState3.setRunning$animation_core_release(false);
                        }
                        throw e;
                    }
                }
                animationState2 = animationState3;
                oj = oj2;
            } catch (CancellationException e2) {
                e = e2;
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            oj = (OJ) anonymousClass5.L$3;
            InterfaceC3750qp interfaceC3750qp3 = (InterfaceC3750qp) anonymousClass5.L$2;
            Animation<T, V> animation3 = (Animation) anonymousClass5.L$1;
            animationState2 = (AnimationState) anonymousClass5.L$0;
            try {
                LL.b(obj);
                interfaceC3750qp2 = interfaceC3750qp3;
                animation2 = animation3;
            } catch (CancellationException e3) {
                e = e3;
                animationState3 = animationState2;
                animationScope = (AnimationScope) oj.a;
                if (animationScope != null) {
                    animationScope.setRunning$animation_core_release(false);
                }
                animationScope2 = (AnimationScope) oj.a;
                if (animationScope2 != null) {
                    animationState3.setRunning$animation_core_release(false);
                }
                throw e;
            }
        }
        do {
            Object obj2 = oj.a;
            AbstractC4492zt.e(obj2);
            if (((AnimationScope) obj2).isRunning()) {
                anonymousClass9 = new AnonymousClass9(oj, getDurationScale(anonymousClass5.getContext()), animation2, animationState2, interfaceC3750qp2);
                anonymousClass5.L$0 = animationState2;
                anonymousClass5.L$1 = animation2;
                anonymousClass5.L$2 = interfaceC3750qp2;
                anonymousClass5.L$3 = oj;
                anonymousClass5.label = 2;
            } else {
                return FW.a;
            }
        } while (callWithFrameNanos(animation2, anonymousClass9, anonymousClass5) != objD);
        return objD;
    }
}
