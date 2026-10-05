package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FocusPropertiesElement extends ModifierNodeElement<FocusPropertiesNode> {
    private final InterfaceC3750qp scope;

    public FocusPropertiesElement(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "scope");
        this.scope = interfaceC3750qp;
    }

    public static /* synthetic */ FocusPropertiesElement copy$default(FocusPropertiesElement focusPropertiesElement, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = focusPropertiesElement.scope;
        }
        return focusPropertiesElement.copy(interfaceC3750qp);
    }

    public final InterfaceC3750qp component1() {
        return this.scope;
    }

    public final FocusPropertiesElement copy(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "scope");
        return new FocusPropertiesElement(interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusPropertiesElement) && AbstractC4492zt.d(this.scope, ((FocusPropertiesElement) obj).scope);
    }

    public final InterfaceC3750qp getScope() {
        return this.scope;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.scope.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("focusProperties");
        inspectorInfo.getProperties().set("scope", this.scope);
    }

    public String toString() {
        return "FocusPropertiesElement(scope=" + this.scope + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public FocusPropertiesNode create() {
        return new FocusPropertiesNode(this.scope);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(FocusPropertiesNode focusPropertiesNode) {
        AbstractC4492zt.h(focusPropertiesNode, "node");
        focusPropertiesNode.setFocusPropertiesScope(this.scope);
    }
}
