package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S>.SizeModifier this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1(AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, AnimatedContentTransitionScopeImpl<S>.SizeModifier sizeModifier) {
        super(1);
        this.this$0 = animatedContentTransitionScopeImpl;
        this.this$1 = sizeModifier;
    }

    @Override // defpackage.InterfaceC3750qp
    public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<S> segment) {
        FiniteAnimationSpec<IntSize> finiteAnimationSpecMo79createAnimationSpecTemP2vQ;
        AbstractC4492zt.h(segment, "$this$animate");
        State state = (State) this.this$0.getTargetSizeMap$animation_release().get(segment.getInitialState());
        long jM5324unboximpl = state != null ? ((IntSize) state.getValue()).m5324unboximpl() : IntSize.Companion.m5325getZeroYbymL2g();
        State state2 = (State) this.this$0.getTargetSizeMap$animation_release().get(segment.getTargetState());
        long jM5324unboximpl2 = state2 != null ? ((IntSize) state2.getValue()).m5324unboximpl() : IntSize.Companion.m5325getZeroYbymL2g();
        SizeTransform value = this.this$1.getSizeTransform().getValue();
        return (value == null || (finiteAnimationSpecMo79createAnimationSpecTemP2vQ = value.mo79createAnimationSpecTemP2vQ(jM5324unboximpl, jM5324unboximpl2)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : finiteAnimationSpecMo79createAnimationSpecTemP2vQ;
    }
}
