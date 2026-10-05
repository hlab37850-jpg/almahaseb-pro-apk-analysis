package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SwipeableDefaults {
    public static final int $stable = 0;
    public static final float StandardResistanceFactor = 10.0f;
    public static final float StiffResistanceFactor = 20.0f;
    public static final SwipeableDefaults INSTANCE = new SwipeableDefaults();
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec<>(0.0f, 0.0f, null, 7, null);
    private static final float VelocityThreshold = Dp.m5160constructorimpl(125);

    private SwipeableDefaults() {
    }

    public static /* synthetic */ ResistanceConfig resistanceConfig$default(SwipeableDefaults swipeableDefaults, Set set, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 10.0f;
        }
        if ((i & 4) != 0) {
            f2 = 10.0f;
        }
        return swipeableDefaults.resistanceConfig(set, f, f2);
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM, reason: not valid java name */
    public final float m1236getVelocityThresholdD9Ej5fM() {
        return VelocityThreshold;
    }

    public final ResistanceConfig resistanceConfig(Set<Float> set, float f, float f2) {
        AbstractC4492zt.h(set, "anchors");
        if (set.size() <= 1) {
            return null;
        }
        Set<Float> set2 = set;
        Float fM0 = AbstractC3240kc.m0(set2);
        AbstractC4492zt.e(fM0);
        float fFloatValue = fM0.floatValue();
        Float fO0 = AbstractC3240kc.o0(set2);
        AbstractC4492zt.e(fO0);
        return new ResistanceConfig(fFloatValue - fO0.floatValue(), f, f2);
    }
}
