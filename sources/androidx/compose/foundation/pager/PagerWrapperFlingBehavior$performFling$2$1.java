package androidx.compose.foundation.pager;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PagerWrapperFlingBehavior$performFling$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ PagerWrapperFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerWrapperFlingBehavior$performFling$2$1(PagerWrapperFlingBehavior pagerWrapperFlingBehavior) {
        super(1);
        this.this$0 = pagerWrapperFlingBehavior;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        this.this$0.getPagerState().setSnapRemainingScrollOffset$foundation_release(f);
    }
}
