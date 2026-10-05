package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.EX;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatAnimationSpec(Animations animations) {
        AbstractC4492zt.h(animations, "anims");
        this.anims = animations;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V v, V v2, V v3) {
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        Iterator it = AbstractC3871sJ.s(0, v.getSize$animation_core_release()).iterator();
        long jMax = 0;
        while (it.hasNext()) {
            int iNextInt = ((AbstractC0919Ss) it).nextInt();
            jMax = Math.max(jMax, this.anims.get(iNextInt).getDurationNanos(v.get$animation_core_release(iNextInt), v2.get$animation_core_release(iNextInt), v3.get$animation_core_release(iNextInt)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getEndVelocity(V v, V v2, V v3) {
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        if (this.endVelocityVector == null) {
            this.endVelocityVector = (V) AnimationVectorsKt.newInstance(v3);
        }
        V v4 = this.endVelocityVector;
        if (v4 == null) {
            AbstractC4492zt.x("endVelocityVector");
            v4 = null;
        }
        int size$animation_core_release = v4.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v5 = this.endVelocityVector;
            if (v5 == null) {
                AbstractC4492zt.x("endVelocityVector");
                v5 = null;
            }
            v5.set$animation_core_release(i, this.anims.get(i).getEndVelocity(v.get$animation_core_release(i), v2.get$animation_core_release(i), v3.get$animation_core_release(i)));
        }
        V v6 = this.endVelocityVector;
        if (v6 != null) {
            return v6;
        }
        AbstractC4492zt.x("endVelocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long j, V v, V v2, V v3) {
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v4 = this.valueVector;
        if (v4 == null) {
            AbstractC4492zt.x("valueVector");
            v4 = null;
        }
        int size$animation_core_release = v4.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v5 = this.valueVector;
            if (v5 == null) {
                AbstractC4492zt.x("valueVector");
                v5 = null;
            }
            v5.set$animation_core_release(i, this.anims.get(i).getValueFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i), v3.get$animation_core_release(i)));
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
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v3);
        }
        V v4 = this.velocityVector;
        if (v4 == null) {
            AbstractC4492zt.x("velocityVector");
            v4 = null;
        }
        int size$animation_core_release = v4.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v5 = this.velocityVector;
            if (v5 == null) {
                AbstractC4492zt.x("velocityVector");
                v5 = null;
            }
            v5.set$animation_core_release(i, this.anims.get(i).getVelocityFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i), v3.get$animation_core_release(i)));
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VectorizedFloatAnimationSpec(final FloatAnimationSpec floatAnimationSpec) {
        this(new Animations() { // from class: androidx.compose.animation.core.VectorizedFloatAnimationSpec.1
            @Override // androidx.compose.animation.core.Animations
            public FloatAnimationSpec get(int i) {
                return floatAnimationSpec;
            }
        });
        AbstractC4492zt.h(floatAnimationSpec, "anim");
    }
}
