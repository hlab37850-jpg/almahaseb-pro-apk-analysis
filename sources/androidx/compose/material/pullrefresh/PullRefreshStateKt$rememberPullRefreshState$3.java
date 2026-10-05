package androidx.compose.material.pullrefresh;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.LJ;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshStateKt$rememberPullRefreshState$3 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ boolean $refreshing;
    final /* synthetic */ LJ $refreshingOffsetPx;
    final /* synthetic */ PullRefreshState $state;
    final /* synthetic */ LJ $thresholdPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshStateKt$rememberPullRefreshState$3(PullRefreshState pullRefreshState, boolean z, LJ lj, LJ lj2) {
        super(0);
        this.$state = pullRefreshState;
        this.$refreshing = z;
        this.$thresholdPx = lj;
        this.$refreshingOffsetPx = lj2;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1308invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1308invoke() {
        this.$state.setRefreshing$material_release(this.$refreshing);
        this.$state.setThreshold$material_release(this.$thresholdPx.a);
        this.$state.setRefreshingOffset$material_release(this.$refreshingOffsetPx.a);
    }
}
