package defpackage;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class DX {
    public static long a(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AbstractC4492zt.h(animationVector, "initialValue");
        AbstractC4492zt.h(animationVector2, "targetValue");
        AbstractC4492zt.h(animationVector3, "initialVelocity");
        return ((long) (vectorizedDurationBasedAnimationSpec.getDelayMillis() + vectorizedDurationBasedAnimationSpec.getDurationMillis())) * AnimationKt.MillisToNanos;
    }
}
