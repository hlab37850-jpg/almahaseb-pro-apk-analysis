package androidx.compose.foundation.pager;

import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class PagerState$targetPage$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$targetPage$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Integer invoke() {
        int iC;
        if (!this.this$0.isScrollInProgress()) {
            iC = this.this$0.getCurrentPage();
        } else if (this.this$0.getAnimationTargetPage() != -1) {
            iC = this.this$0.getAnimationTargetPage();
        } else if (this.this$0.getSnapRemainingScrollOffset$foundation_release() == 0.0f) {
            iC = Math.abs(this.this$0.getCurrentPageOffsetFraction()) >= Math.abs(this.this$0.getPositionThresholdFraction()) ? this.this$0.getCurrentPage() + ((int) Math.signum(this.this$0.getCurrentPageOffsetFraction())) : this.this$0.getCurrentPage();
        } else {
            iC = AbstractC1210aB.c(this.this$0.getSnapRemainingScrollOffset$foundation_release() / this.this$0.getPageAvailableSpace()) + this.this$0.getCurrentPage();
        }
        return Integer.valueOf(this.this$0.coerceInPageRange(iC));
    }
}
