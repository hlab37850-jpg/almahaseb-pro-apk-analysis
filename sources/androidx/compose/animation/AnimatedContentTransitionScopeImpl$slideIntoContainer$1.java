package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl$slideIntoContainer$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $initialOffset;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedContentTransitionScopeImpl$slideIntoContainer$1(InterfaceC3750qp interfaceC3750qp, AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl) {
        super(1);
        this.$initialOffset = interfaceC3750qp;
        this.this$0 = animatedContentTransitionScopeImpl;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Integer invoke(int i) {
        return (Integer) this.$initialOffset.invoke(Integer.valueOf(IntSize.m5320getWidthimpl(this.this$0.m36getCurrentSizeYbymL2g()) - IntOffset.m5278getXimpl(this.this$0.m35calculateOffsetemnUabE(IntSizeKt.IntSize(i, i), this.this$0.m36getCurrentSizeYbymL2g()))));
    }
}
