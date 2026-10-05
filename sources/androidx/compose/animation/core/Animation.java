package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import defpackage.AbstractC2247g4;

/* JADX INFO: loaded from: classes.dex */
public interface Animation<T, V extends AnimationVector> {

    public static final class DefaultImpls {
        @Deprecated
        public static <T, V extends AnimationVector> boolean isFinishedFromNanos(Animation<T, V> animation, long j) {
            return AbstractC2247g4.a(animation, j);
        }
    }

    long getDurationNanos();

    T getTargetValue();

    TwoWayConverter<T, V> getTypeConverter();

    T getValueFromNanos(long j);

    V getVelocityVectorFromNanos(long j);

    boolean isFinishedFromNanos(long j);

    boolean isInfinite();
}
