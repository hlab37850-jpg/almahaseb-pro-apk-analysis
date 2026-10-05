package defpackage;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class CX {
    public static AnimationVector a(VectorizedAnimationSpec vectorizedAnimationSpec, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AbstractC4492zt.h(animationVector, "initialValue");
        AbstractC4492zt.h(animationVector2, "targetValue");
        AbstractC4492zt.h(animationVector3, "initialVelocity");
        return vectorizedAnimationSpec.getVelocityFromNanos(vectorizedAnimationSpec.getDurationNanos(animationVector, animationVector2, animationVector3), animationVector, animationVector2, animationVector3);
    }
}
