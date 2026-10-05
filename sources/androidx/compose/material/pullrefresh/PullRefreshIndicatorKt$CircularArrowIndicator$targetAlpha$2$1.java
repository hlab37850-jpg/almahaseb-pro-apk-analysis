package androidx.compose.material.pullrefresh;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PullRefreshState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1(PullRefreshState pullRefreshState) {
        super(0);
        this.$state = pullRefreshState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.$state.getProgress() < 1.0f ? 0.3f : 1.0f);
    }
}
