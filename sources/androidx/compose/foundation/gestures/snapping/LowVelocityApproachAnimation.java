package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class LowVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    private final Density density;
    private final SnapLayoutInfoProvider layoutInfoProvider;
    private final AnimationSpec<Float> lowVelocityAnimationSpec;

    public LowVelocityApproachAnimation(AnimationSpec<Float> animationSpec, SnapLayoutInfoProvider snapLayoutInfoProvider, Density density) {
        AbstractC4492zt.h(animationSpec, "lowVelocityAnimationSpec");
        AbstractC4492zt.h(snapLayoutInfoProvider, "layoutInfoProvider");
        AbstractC4492zt.h(density, "density");
        this.lowVelocityAnimationSpec = animationSpec;
        this.layoutInfoProvider = snapLayoutInfoProvider;
        this.density = density;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return approachAnimation(scrollScope, f.floatValue(), f2.floatValue(), interfaceC3750qp, interfaceC0793Of);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objAnimateSnap = SnapFlingBehaviorKt.animateSnap(scrollScope, (Math.abs(f) + this.layoutInfoProvider.calculateSnapStepSize(this.density)) * Math.signum(f2), f, AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null), this.lowVelocityAnimationSpec, interfaceC3750qp, interfaceC0793Of);
        return objAnimateSnap == AbstractC0378Bt.d() ? objAnimateSnap : (AnimationResult) objAnimateSnap;
    }
}
