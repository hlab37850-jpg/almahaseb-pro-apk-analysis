package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import defpackage.AbstractC4492zt;
import defpackage.CX;

/* JADX INFO: loaded from: classes.dex */
public interface VectorizedAnimationSpec<V extends AnimationVector> {

    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(VectorizedAnimationSpec<V> vectorizedAnimationSpec, V v, V v2, V v3) {
            AbstractC4492zt.h(v, "initialValue");
            AbstractC4492zt.h(v2, "targetValue");
            AbstractC4492zt.h(v3, "initialVelocity");
            return (V) CX.a(vectorizedAnimationSpec, v, v2, v3);
        }
    }

    long getDurationNanos(V v, V v2, V v3);

    V getEndVelocity(V v, V v2, V v3);

    V getValueFromNanos(long j, V v, V v2, V v3);

    V getVelocityFromNanos(long j, V v, V v2, V v3);

    boolean isInfinite();
}
