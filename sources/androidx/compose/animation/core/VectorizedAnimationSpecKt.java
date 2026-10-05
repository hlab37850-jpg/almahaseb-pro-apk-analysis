package androidx.compose.animation.core;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VectorizedAnimationSpecKt {
    private static final int InfiniteIterations = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec<?> vectorizedDurationBasedAnimationSpec, long j) {
        return AbstractC3871sJ.n(j - ((long) vectorizedDurationBasedAnimationSpec.getDelayMillis()), 0L, vectorizedDurationBasedAnimationSpec.getDurationMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V extends AnimationVector> Animations createSpringAnimations(V v, float f, float f2) {
        return v != null ? new Animations(v, f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.1
            private final List<FloatSpringSpec> anims;

            /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
            {
                C1001Vs c1001VsS = AbstractC3871sJ.s(0, v.getSize$animation_core_release());
                ArrayList arrayList = new ArrayList(AbstractC2044dc.x(c1001VsS, 10));
                Iterator it = c1001VsS.iterator();
                while (it.hasNext()) {
                    arrayList.add(new FloatSpringSpec(f, f2, v.get$animation_core_release(((AbstractC0919Ss) it).nextInt())));
                }
                this.anims = arrayList;
            }

            @Override // androidx.compose.animation.core.Animations
            public FloatSpringSpec get(int i) {
                return this.anims.get(i);
            }
        } : new Animations(f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.2
            private final FloatSpringSpec anim;

            {
                this.anim = new FloatSpringSpec(f, f2, 0.0f, 4, null);
            }

            @Override // androidx.compose.animation.core.Animations
            public FloatSpringSpec get(int i) {
                return this.anim;
            }
        };
    }

    public static final <V extends AnimationVector> long getDurationMillis(VectorizedAnimationSpec<V> vectorizedAnimationSpec, V v, V v2, V v3) {
        AbstractC4492zt.h(vectorizedAnimationSpec, "<this>");
        AbstractC4492zt.h(v, "initialValue");
        AbstractC4492zt.h(v2, "targetValue");
        AbstractC4492zt.h(v3, "initialVelocity");
        return vectorizedAnimationSpec.getDurationNanos(v, v2, v3) / AnimationKt.MillisToNanos;
    }

    public static final <V extends AnimationVector> V getValueFromMillis(VectorizedAnimationSpec<V> vectorizedAnimationSpec, long j, V v, V v2, V v3) {
        AbstractC4492zt.h(vectorizedAnimationSpec, "<this>");
        AbstractC4492zt.h(v, HTML.Attribute.START);
        AbstractC4492zt.h(v2, "end");
        AbstractC4492zt.h(v3, "startVelocity");
        return (V) vectorizedAnimationSpec.getValueFromNanos(j * AnimationKt.MillisToNanos, v, v2, v3);
    }
}
