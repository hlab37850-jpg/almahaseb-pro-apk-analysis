package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import defpackage.AbstractC3102iv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class OnPlacedNode extends Modifier.Node implements LayoutAwareModifierNode {
    private InterfaceC3750qp callback;

    public OnPlacedNode(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "callback");
        this.callback = interfaceC3750qp;
    }

    public final InterfaceC3750qp getCallback() {
        return this.callback;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "coordinates");
        this.callback.invoke(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public /* synthetic */ void mo222onRemeasuredozmzZPI(long j) {
        AbstractC3102iv.b(this, j);
    }

    public final void setCallback(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "<set-?>");
        this.callback = interfaceC3750qp;
    }
}
