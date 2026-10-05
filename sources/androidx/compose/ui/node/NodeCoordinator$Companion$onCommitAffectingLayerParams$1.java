package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class NodeCoordinator$Companion$onCommitAffectingLayerParams$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final NodeCoordinator$Companion$onCommitAffectingLayerParams$1 INSTANCE = new NodeCoordinator$Companion$onCommitAffectingLayerParams$1();

    public NodeCoordinator$Companion$onCommitAffectingLayerParams$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NodeCoordinator) obj);
        return FW.a;
    }

    public final void invoke(NodeCoordinator nodeCoordinator) {
        AbstractC4492zt.h(nodeCoordinator, "coordinator");
        if (nodeCoordinator.isValidOwnerScope()) {
            LayerPositionalProperties layerPositionalProperties = nodeCoordinator.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                return;
            }
            NodeCoordinator.tmpLayerPositionalProperties.copyFrom(layerPositionalProperties);
            NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
            if (NodeCoordinator.tmpLayerPositionalProperties.hasSameValuesAs(layerPositionalProperties)) {
                return;
            }
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
            if (layoutDelegate$ui_release.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                if (layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            }
            Owner owner$ui_release = layoutNode.getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.requestOnPositionedCallback(layoutNode);
            }
        }
    }
}
