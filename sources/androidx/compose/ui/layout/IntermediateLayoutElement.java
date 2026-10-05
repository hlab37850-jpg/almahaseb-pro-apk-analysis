package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
final class IntermediateLayoutElement extends ModifierNodeElement<IntermediateLayoutModifierNode> {
    private final InterfaceC0552Gp measure;

    public IntermediateLayoutElement(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "measure");
        this.measure = interfaceC0552Gp;
    }

    public static /* synthetic */ IntermediateLayoutElement copy$default(IntermediateLayoutElement intermediateLayoutElement, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0552Gp = intermediateLayoutElement.measure;
        }
        return intermediateLayoutElement.copy(interfaceC0552Gp);
    }

    public final InterfaceC0552Gp component1() {
        return this.measure;
    }

    public final IntermediateLayoutElement copy(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "measure");
        return new IntermediateLayoutElement(interfaceC0552Gp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IntermediateLayoutElement) && AbstractC4492zt.d(this.measure, ((IntermediateLayoutElement) obj).measure);
    }

    public final InterfaceC0552Gp getMeasure() {
        return this.measure;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.measure.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("intermediateLayout");
        inspectorInfo.getProperties().set("measure", this.measure);
    }

    public String toString() {
        return "IntermediateLayoutElement(measure=" + this.measure + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public IntermediateLayoutModifierNode create() {
        return new IntermediateLayoutModifierNode(this.measure);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        AbstractC4492zt.h(intermediateLayoutModifierNode, "node");
        intermediateLayoutModifierNode.setMeasureBlock$ui_release(this.measure);
    }
}
