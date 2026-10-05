package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0748Mm;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final int duration;
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    private final long clampPlayTime(long j) {
        return AbstractC3871sJ.n(j - ((long) this.delay), 0L, this.duration);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float f, float f2, float f3) {
        return ((long) (this.delay + this.duration)) * AnimationKt.MillisToNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public /* synthetic */ float getEndVelocity(float f, float f2, float f3) {
        return AbstractC0748Mm.a(this, f, f2, f3);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long j, float f, float f2, float f3) {
        long jClampPlayTime = clampPlayTime(j / AnimationKt.MillisToNanos);
        int i = this.duration;
        return VectorConvertersKt.lerp(f, f2, this.easing.transform(AbstractC3871sJ.k(i == 0 ? 1.0f : jClampPlayTime / i, 0.0f, 1.0f)));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long jClampPlayTime = clampPlayTime(j / AnimationKt.MillisToNanos);
        if (jClampPlayTime < 0) {
            return 0.0f;
        }
        if (jClampPlayTime == 0) {
            return f3;
        }
        return (getValueFromNanos(jClampPlayTime * AnimationKt.MillisToNanos, f, f2, f3) - getValueFromNanos((jClampPlayTime - 1) * AnimationKt.MillisToNanos, f, f2, f3)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return vectorize(twoWayConverter);
    }

    public FloatTweenSpec(int i, int i2, Easing easing) {
        AbstractC4492zt.h(easing, "easing");
        this.duration = i;
        this.delay = i2;
        this.easing = easing;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return AbstractC0748Mm.c(this, twoWayConverter);
    }

    public /* synthetic */ FloatTweenSpec(int i, int i2, Easing easing, int i3, AbstractC0419Di abstractC0419Di) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
    }
}
