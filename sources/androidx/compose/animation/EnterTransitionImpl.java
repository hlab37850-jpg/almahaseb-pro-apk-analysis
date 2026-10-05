package androidx.compose.animation;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
final class EnterTransitionImpl extends EnterTransition {
    private final TransitionData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterTransitionImpl(TransitionData transitionData) {
        super(null);
        AbstractC4492zt.h(transitionData, "data");
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.EnterTransition
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
