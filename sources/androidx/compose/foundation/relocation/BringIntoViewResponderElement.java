package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
final class BringIntoViewResponderElement extends ModifierNodeElement<BringIntoViewResponderNode> {
    private final BringIntoViewResponder responder;

    public BringIntoViewResponderElement(BringIntoViewResponder bringIntoViewResponder) {
        AbstractC4492zt.h(bringIntoViewResponder, "responder");
        this.responder = bringIntoViewResponder;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BringIntoViewResponderElement) && AbstractC4492zt.d(this.responder, ((BringIntoViewResponderElement) obj).responder));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.responder.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("bringIntoViewResponder");
        inspectorInfo.getProperties().set("responder", this.responder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public BringIntoViewResponderNode create() {
        return new BringIntoViewResponderNode(this.responder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(BringIntoViewResponderNode bringIntoViewResponderNode) {
        AbstractC4492zt.h(bringIntoViewResponderNode, "node");
        bringIntoViewResponderNode.setResponder(this.responder);
    }
}
