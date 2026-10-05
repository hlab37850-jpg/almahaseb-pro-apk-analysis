package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class HighVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    private final DecayAnimationSpec<Float> decayAnimationSpec;

    public HighVelocityApproachAnimation(DecayAnimationSpec<Float> decayAnimationSpec) {
        AbstractC4492zt.h(decayAnimationSpec, "decayAnimationSpec");
        this.decayAnimationSpec = decayAnimationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return approachAnimation(scrollScope, f.floatValue(), f2.floatValue(), interfaceC3750qp, interfaceC0793Of);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objAnimateDecay = SnapFlingBehaviorKt.animateDecay(scrollScope, f, AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null), this.decayAnimationSpec, interfaceC3750qp, interfaceC0793Of);
        return objAnimateDecay == AbstractC0378Bt.d() ? objAnimateDecay : (AnimationResult) objAnimateDecay;
    }
}
