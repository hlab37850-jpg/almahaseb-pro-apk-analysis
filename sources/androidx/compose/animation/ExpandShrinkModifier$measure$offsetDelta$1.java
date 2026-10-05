package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandShrinkModifier$measure$offsetDelta$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ExpandShrinkModifier$measure$offsetDelta$1 INSTANCE = new ExpandShrinkModifier$measure$offsetDelta$1();

    public ExpandShrinkModifier$measure$offsetDelta$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
        AbstractC4492zt.h(segment, "$this$animate");
        return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
    }
}
