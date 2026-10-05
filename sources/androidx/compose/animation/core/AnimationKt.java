package androidx.compose.animation.core;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimationKt {
    public static final long MillisToNanos = 1000000;

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimationKt$createAnimation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Incorrect return type in method signature: (TV;)TV; */
        @Override // defpackage.InterfaceC3750qp
        public final AnimationVector invoke(AnimationVector animationVector) {
            AbstractC4492zt.h(animationVector, "it");
            return animationVector;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimationKt$createAnimation$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX WARN: Incorrect return type in method signature: (TV;)TV; */
        @Override // defpackage.InterfaceC3750qp
        public final AnimationVector invoke(AnimationVector animationVector) {
            AbstractC4492zt.h(animationVector, "it");
            return animationVector;
        }
    }

    public static final DecayAnimation<Float, AnimationVector1D> DecayAnimation(FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f2) {
        AbstractC4492zt.h(floatDecayAnimationSpec, "animationSpec");
        return new DecayAnimation<>((DecayAnimationSpec<Float>) DecayAnimationSpecKt.generateDecayAnimationSpec(floatDecayAnimationSpec), VectorConvertersKt.getVectorConverter(C0774Nm.a), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f2));
    }

    public static /* synthetic */ DecayAnimation DecayAnimation$default(FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return DecayAnimation(floatDecayAnimationSpec, f, f2);
    }

    public static final <T, V extends AnimationVector> TargetBasedAnimation<T, V> TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3) {
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(twoWayConverter, "typeConverter");
        return new TargetBasedAnimation<>(animationSpec, twoWayConverter, t, t2, (AnimationVector) twoWayConverter.getConvertToVector().invoke(t3));
    }

    public static final <V extends AnimationVector> TargetBasedAnimation<V, V> createAnimation(VectorizedAnimationSpec<V> vectorizedAnimationSpec, V v, V v2, V v3) {
        AbstractC4492zt.h(vectorizedAnimationSpec, "<this>");
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        return new TargetBasedAnimation<>(vectorizedAnimationSpec, (TwoWayConverter<V, V>) VectorConvertersKt.TwoWayConverter(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE), v, v2, v3);
    }

    public static final long getDurationMillis(Animation<?, ?> animation) {
        AbstractC4492zt.h(animation, "<this>");
        return animation.getDurationNanos() / MillisToNanos;
    }

    public static final <T, V extends AnimationVector> T getVelocityFromNanos(Animation<T, V> animation, long j) {
        AbstractC4492zt.h(animation, "<this>");
        return (T) animation.getTypeConverter().getConvertFromVector().invoke(animation.getVelocityVectorFromNanos(j));
    }
}
