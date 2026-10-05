package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalAnimationApi
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    private final MutableState<IntSize> targetSize;
    private Transition<EnterExitState> transition;

    public AnimatedVisibilityScopeImpl(Transition<EnterExitState> transition) {
        AbstractC4492zt.h(transition, "transition");
        this.transition = transition;
        this.targetSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m5312boximpl(IntSize.Companion.m5325getZeroYbymL2g()), null, 2, null);
    }

    @Override // androidx.compose.animation.AnimatedVisibilityScope
    public /* synthetic */ Modifier animateEnterExit(Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str) {
        return AnimatedVisibilityScope.CC.a(this, modifier, enterTransition, exitTransition, str);
    }

    public final MutableState<IntSize> getTargetSize$animation_release() {
        return this.targetSize;
    }

    @Override // androidx.compose.animation.AnimatedVisibilityScope
    public Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public void setTransition(Transition<EnterExitState> transition) {
        AbstractC4492zt.h(transition, "<set-?>");
        this.transition = transition;
    }
}
