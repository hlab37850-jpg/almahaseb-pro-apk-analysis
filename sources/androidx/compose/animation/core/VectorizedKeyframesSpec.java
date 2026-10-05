package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.CX;
import defpackage.DX;
import defpackage.EX;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final Map<Integer, C2020dG> keyframes;
    private V valueVector;
    private V velocityVector;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorizedKeyframesSpec(Map<Integer, ? extends C2020dG> map, int i, int i2) {
        AbstractC4492zt.h(map, "keyframes");
        this.keyframes = map;
        this.durationMillis = i;
        this.delayMillis = i2;
    }

    private final void init(V v) {
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return DX.a(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return CX.a(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long j, V v, V v2, V v3) {
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(Integer.valueOf(iClampPlayTime))) {
            return (V) ((C2020dG) AbstractC4243wx.h(this.keyframes, Integer.valueOf(iClampPlayTime))).c();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return v2;
        }
        if (iClampPlayTime <= 0) {
            return v;
        }
        int durationMillis = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i = 0;
        AnimationVector animationVector = v;
        int i2 = 0;
        for (Map.Entry<Integer, C2020dG> entry : this.keyframes.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            C2020dG value = entry.getValue();
            if (iClampPlayTime > iIntValue && iIntValue >= i2) {
                animationVector = (AnimationVector) value.c();
                linearEasing = (Easing) value.e();
                i2 = iIntValue;
            } else if (iClampPlayTime < iIntValue && iIntValue <= durationMillis) {
                v2 = (V) value.c();
                durationMillis = iIntValue;
            }
        }
        float fTransform = linearEasing.transform((iClampPlayTime - i2) / (durationMillis - i2));
        init(v);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        while (true) {
            V v4 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v5 = this.valueVector;
            if (v5 == null) {
                AbstractC4492zt.x("valueVector");
            } else {
                v4 = v5;
            }
            v4.set$animation_core_release(i, VectorConvertersKt.lerp(animationVector.get$animation_core_release(i), v2.get$animation_core_release(i), fTransform));
            i++;
        }
        V v6 = this.valueVector;
        if (v6 != null) {
            return v6;
        }
        AbstractC4492zt.x("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        long jClampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (jClampPlayTime <= 0) {
            return v3;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime - 1, v, v2, v3);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime, v, v2, v3);
        init(v);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        int i = 0;
        while (true) {
            V v4 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v5 = this.velocityVector;
            if (v5 == null) {
                AbstractC4492zt.x("velocityVector");
            } else {
                v4 = v5;
            }
            v4.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v6 = this.velocityVector;
        if (v6 != null) {
            return v6;
        }
        AbstractC4492zt.x("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return EX.a(this);
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, AbstractC0419Di abstractC0419Di) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }
}
