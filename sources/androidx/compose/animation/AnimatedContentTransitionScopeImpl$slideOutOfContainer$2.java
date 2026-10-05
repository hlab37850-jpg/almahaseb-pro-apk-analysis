package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl$slideOutOfContainer$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $targetOffset;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedContentTransitionScopeImpl$slideOutOfContainer$2(AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.this$0 = animatedContentTransitionScopeImpl;
        this.$targetOffset = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Integer invoke(int i) {
        State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
        long jM5324unboximpl = state != null ? ((IntSize) state.getValue()).m5324unboximpl() : IntSize.Companion.m5325getZeroYbymL2g();
        return (Integer) this.$targetOffset.invoke(Integer.valueOf((-IntOffset.m5278getXimpl(this.this$0.m35calculateOffsetemnUabE(IntSizeKt.IntSize(i, i), jM5324unboximpl))) + IntSize.m5320getWidthimpl(jM5324unboximpl)));
    }
}
