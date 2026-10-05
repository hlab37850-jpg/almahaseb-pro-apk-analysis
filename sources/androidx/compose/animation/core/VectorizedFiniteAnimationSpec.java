package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import defpackage.AbstractC4492zt;
import defpackage.CX;
import defpackage.EX;

/* JADX INFO: loaded from: classes.dex */
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {

    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec, V v, V v2, V v3) {
            AbstractC4492zt.h(v, "initialValue");
            AbstractC4492zt.h(v2, "targetValue");
            AbstractC4492zt.h(v3, "initialVelocity");
            return (V) CX.a(vectorizedFiniteAnimationSpec, v, v2, v3);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec) {
            return EX.a(vectorizedFiniteAnimationSpec);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    boolean isInfinite();
}
