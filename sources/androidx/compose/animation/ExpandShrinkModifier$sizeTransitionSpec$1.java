package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandShrinkModifier$sizeTransitionSpec$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ ExpandShrinkModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandShrinkModifier$sizeTransitionSpec$1(ExpandShrinkModifier expandShrinkModifier) {
        super(1);
        this.this$0 = expandShrinkModifier;
    }

    @Override // defpackage.InterfaceC3750qp
    public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<EnterExitState> segment) {
        AbstractC4492zt.h(segment, "$this$null");
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        FiniteAnimationSpec<IntSize> animationSpec = null;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            ChangeSize value = this.this$0.getExpand().getValue();
            if (value != null) {
                animationSpec = value.getAnimationSpec();
            }
        } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
            ChangeSize value2 = this.this$0.getShrink().getValue();
            if (value2 != null) {
                animationSpec = value2.getAnimationSpec();
            }
        } else {
            animationSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
        }
        return animationSpec == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : animationSpec;
    }
}
