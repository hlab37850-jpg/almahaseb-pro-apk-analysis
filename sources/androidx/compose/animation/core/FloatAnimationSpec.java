package androidx.compose.animation.core;

import defpackage.AbstractC0748Mm;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface FloatAnimationSpec extends AnimationSpec<Float> {

    public static final class DefaultImpls {
        @Deprecated
        public static float getEndVelocity(FloatAnimationSpec floatAnimationSpec, float f, float f2, float f3) {
            return AbstractC0748Mm.a(floatAnimationSpec, f, f2, f3);
        }

        @Deprecated
        public static <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(FloatAnimationSpec floatAnimationSpec, TwoWayConverter<Float, V> twoWayConverter) {
            AbstractC4492zt.h(twoWayConverter, "converter");
            return AbstractC0748Mm.c(floatAnimationSpec, twoWayConverter);
        }
    }

    long getDurationNanos(float f, float f2, float f3);

    float getEndVelocity(float f, float f2, float f3);

    float getValueFromNanos(long j, float f, float f2, float f3);

    float getVelocityFromNanos(long j, float f, float f2, float f3);

    @Override // androidx.compose.animation.core.AnimationSpec
    /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter);

    @Override // androidx.compose.animation.core.AnimationSpec
    <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(TwoWayConverter<Float, V> twoWayConverter);
}
