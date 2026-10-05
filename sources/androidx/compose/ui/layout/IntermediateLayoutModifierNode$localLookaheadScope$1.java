package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class IntermediateLayoutModifierNode$localLookaheadScope$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ IntermediateLayoutModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntermediateLayoutModifierNode$localLookaheadScope$1(IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        super(0);
        this.this$0 = intermediateLayoutModifierNode;
    }

    @Override // defpackage.InterfaceC3588op
    public final LayoutCoordinates invoke() {
        NodeCoordinator coordinator$ui_release = this.this$0.getCoordinator$ui_release();
        AbstractC4492zt.e(coordinator$ui_release);
        return coordinator$ui_release;
    }
}
