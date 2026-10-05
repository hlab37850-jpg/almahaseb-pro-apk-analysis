package androidx.compose.material3;

import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnchorChangeHandler $anchorChangeHandler$inlined;
    final /* synthetic */ InterfaceC0526Fp $calculateAnchor$inlined;
    final /* synthetic */ Set $possibleValues$inlined;
    final /* synthetic */ SwipeableV2State $state$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1(SwipeableV2State swipeableV2State, Set set, AnchorChangeHandler anchorChangeHandler, InterfaceC0526Fp interfaceC0526Fp) {
        super(1);
        this.$state$inlined = swipeableV2State;
        this.$possibleValues$inlined = set;
        this.$anchorChangeHandler$inlined = anchorChangeHandler;
        this.$calculateAnchor$inlined = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return FW.a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "$this$null");
        inspectorInfo.setName("swipeAnchors");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
        inspectorInfo.getProperties().set("possibleValues", this.$possibleValues$inlined);
        inspectorInfo.getProperties().set("anchorChangeHandler", this.$anchorChangeHandler$inlined);
        inspectorInfo.getProperties().set("calculateAnchor", this.$calculateAnchor$inlined);
    }
}
