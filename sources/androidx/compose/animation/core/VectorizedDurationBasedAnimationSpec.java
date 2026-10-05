package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import defpackage.AbstractC4492zt;
import defpackage.CX;
import defpackage.DX;
import defpackage.EX;

/* JADX INFO: loaded from: classes.dex */
public interface VectorizedDurationBasedAnimationSpec<V extends AnimationVector> extends VectorizedFiniteAnimationSpec<V> {

    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> long getDurationNanos(VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, V v, V v2, V v3) {
            AbstractC4492zt.h(v, "initialValue");
            AbstractC4492zt.h(v2, "targetValue");
            AbstractC4492zt.h(v3, "initialVelocity");
            return DX.a(vectorizedDurationBasedAnimationSpec, v, v2, v3);
        }

        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, V v, V v2, V v3) {
            AbstractC4492zt.h(v, "initialValue");
            AbstractC4492zt.h(v2, "targetValue");
            AbstractC4492zt.h(v3, "initialVelocity");
            return (V) CX.a(vectorizedDurationBasedAnimationSpec, v, v2, v3);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec) {
            return EX.a(vectorizedDurationBasedAnimationSpec);
        }
    }

    int getDelayMillis();

    int getDurationMillis();

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    long getDurationNanos(V v, V v2, V v3);
}
