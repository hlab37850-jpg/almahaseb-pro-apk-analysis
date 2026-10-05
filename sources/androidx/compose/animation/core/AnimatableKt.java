package androidx.compose.animation.core;

import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatableKt {
    public static final Animatable<Float, AnimationVector1D> Animatable(float f, float f2) {
        return new Animatable<>(Float.valueOf(f), VectorConvertersKt.getVectorConverter(C0774Nm.a), Float.valueOf(f2), null, 8, null);
    }

    public static /* synthetic */ Animatable Animatable$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.01f;
        }
        return Animatable(f, f2);
    }
}
