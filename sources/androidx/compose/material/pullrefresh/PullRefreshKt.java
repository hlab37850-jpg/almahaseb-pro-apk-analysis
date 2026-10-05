package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshKt {
    @ExperimentalMaterialApi
    public static final Modifier pullRefresh(Modifier modifier, PullRefreshState pullRefreshState, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(pullRefreshState, "state");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$1(pullRefreshState, z) : InspectableValueKt.getNoInspectorInfo(), pullRefresh(Modifier.Companion, new PullRefreshKt$pullRefresh$2$1(pullRefreshState), new PullRefreshKt$pullRefresh$2$2(pullRefreshState), z));
    }

    public static /* synthetic */ Modifier pullRefresh$default(Modifier modifier, PullRefreshState pullRefreshState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return pullRefresh(modifier, pullRefreshState, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object pullRefresh$lambda$1$onRelease(PullRefreshState pullRefreshState, float f, InterfaceC0793Of interfaceC0793Of) {
        return E8.b(pullRefreshState.onRelease$material_release(f));
    }

    public static /* synthetic */ Modifier pullRefresh$default(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pullRefresh(modifier, interfaceC3750qp, interfaceC0526Fp, z);
    }

    @ExperimentalMaterialApi
    public static final Modifier pullRefresh(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onPull");
        AbstractC4492zt.h(interfaceC0526Fp, "onRelease");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$2(interfaceC3750qp, interfaceC0526Fp, z) : InspectableValueKt.getNoInspectorInfo(), NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, new PullRefreshNestedScrollConnection(interfaceC3750qp, interfaceC0526Fp, z), null, 2, null));
    }
}
