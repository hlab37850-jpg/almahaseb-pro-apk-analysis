package androidx.compose.foundation.pager;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PagerState$scrollableState$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$scrollableState$1(PagerState pagerState) {
        super(1);
        this.this$0 = pagerState;
    }

    public final Float invoke(float f) {
        return Float.valueOf(-this.this$0.performScroll(-f));
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
