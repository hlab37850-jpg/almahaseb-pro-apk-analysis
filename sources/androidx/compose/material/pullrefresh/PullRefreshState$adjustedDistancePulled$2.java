package androidx.compose.material.pullrefresh;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshState$adjustedDistancePulled$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PullRefreshState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshState$adjustedDistancePulled$2(PullRefreshState pullRefreshState) {
        super(0);
        this.this$0 = pullRefreshState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.this$0.getDistancePulled() * 0.5f);
    }
}
