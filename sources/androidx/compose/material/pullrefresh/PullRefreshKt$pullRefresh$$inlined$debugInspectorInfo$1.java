package androidx.compose.material.pullrefresh;

import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ PullRefreshState $state$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$1(PullRefreshState pullRefreshState, boolean z) {
        super(1);
        this.$state$inlined = pullRefreshState;
        this.$enabled$inlined = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return FW.a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "$this$null");
        inspectorInfo.setName("pullRefresh");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
    }
}
