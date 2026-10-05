package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
public final class PagerDefaults {
    public static final int $stable = 0;
    public static final PagerDefaults INSTANCE = new PagerDefaults();

    private PagerDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: flingBehavior-PfoAEA0, reason: not valid java name */
    public final SnapFlingBehavior m692flingBehaviorPfoAEA0(PagerState pagerState, PagerSnapDistance pagerSnapDistance, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec2, float f, float f2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(pagerState, "state");
        composer.startReplaceableGroup(-705378306);
        PagerSnapDistance pagerSnapDistanceAtMost = (i2 & 2) != 0 ? PagerSnapDistance.Companion.atMost(1) : pagerSnapDistance;
        AnimationSpec<Float> animationSpecTween$default = (i2 & 4) != 0 ? AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, null) : animationSpec;
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i2 & 8) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        AnimationSpec<Float> animationSpecSpring$default = (i2 & 16) != 0 ? AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null) : animationSpec2;
        float minFlingVelocityDp = (i2 & 32) != 0 ? SnapFlingBehaviorKt.getMinFlingVelocityDp() : f;
        float f3 = (i2 & 64) != 0 ? 0.5f : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-705378306, i, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:522)");
        }
        if (0.0f > f3 || f3 > 1.0f) {
            throw new IllegalArgumentException(("snapPositionalThreshold should be a number between 0 and 1. You've specified " + f3).toString());
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {pagerState, animationSpecTween$default, decayAnimationSpecRememberSplineBasedDecay, animationSpecSpring$default, pagerSnapDistanceAtMost, density};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 6; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SnapFlingBehavior(PagerKt.SnapLayoutInfoProvider(pagerState, pagerSnapDistanceAtMost, decayAnimationSpecRememberSplineBasedDecay, f3), animationSpecTween$default, decayAnimationSpecRememberSplineBasedDecay, animationSpecSpring$default, density, minFlingVelocityDp, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    public final NestedScrollConnection pageNestedScrollConnection(Orientation orientation) {
        AbstractC4492zt.h(orientation, "orientation");
        return orientation == Orientation.Horizontal ? PagerKt.ConsumeHorizontalFlingNestedScrollConnection : PagerKt.ConsumeVerticalFlingNestedScrollConnection;
    }
}
