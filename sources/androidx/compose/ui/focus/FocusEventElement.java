package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FocusEventElement extends ModifierNodeElement<FocusEventNode> {
    private final InterfaceC3750qp onFocusEvent;

    public FocusEventElement(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onFocusEvent");
        this.onFocusEvent = interfaceC3750qp;
    }

    public static /* synthetic */ FocusEventElement copy$default(FocusEventElement focusEventElement, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = focusEventElement.onFocusEvent;
        }
        return focusEventElement.copy(interfaceC3750qp);
    }

    public final InterfaceC3750qp component1() {
        return this.onFocusEvent;
    }

    public final FocusEventElement copy(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onFocusEvent");
        return new FocusEventElement(interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusEventElement) && AbstractC4492zt.d(this.onFocusEvent, ((FocusEventElement) obj).onFocusEvent);
    }

    public final InterfaceC3750qp getOnFocusEvent() {
        return this.onFocusEvent;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onFocusEvent.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("onFocusEvent");
        inspectorInfo.getProperties().set("onFocusEvent", this.onFocusEvent);
    }

    public String toString() {
        return "FocusEventElement(onFocusEvent=" + this.onFocusEvent + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public FocusEventNode create() {
        return new FocusEventNode(this.onFocusEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(FocusEventNode focusEventNode) {
        AbstractC4492zt.h(focusEventNode, "node");
        focusEventNode.setOnFocusEvent(this.onFocusEvent);
    }
}
