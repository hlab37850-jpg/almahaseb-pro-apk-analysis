package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class OffsetPxElement extends ModifierNodeElement<OffsetPxNode> {
    private final InterfaceC3750qp inspectorInfo;
    private final InterfaceC3750qp offset;
    private final boolean rtlAware;

    public OffsetPxElement(InterfaceC3750qp interfaceC3750qp, boolean z, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(interfaceC3750qp, TypedValues.CycleType.S_WAVE_OFFSET);
        AbstractC4492zt.h(interfaceC3750qp2, "inspectorInfo");
        this.offset = interfaceC3750qp;
        this.rtlAware = z;
        this.inspectorInfo = interfaceC3750qp2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetPxElement offsetPxElement = obj instanceof OffsetPxElement ? (OffsetPxElement) obj : null;
        return offsetPxElement != null && AbstractC4492zt.d(this.offset, offsetPxElement.offset) && this.rtlAware == offsetPxElement.rtlAware;
    }

    public final InterfaceC3750qp getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final InterfaceC3750qp getOffset() {
        return this.offset;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (this.offset.hashCode() * 31) + AbstractC0564Hb.a(this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        this.inspectorInfo.invoke(inspectorInfo);
    }

    public String toString() {
        return "OffsetPxModifier(offset=" + this.offset + ", rtlAware=" + this.rtlAware + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OffsetPxNode create() {
        return new OffsetPxNode(this.offset, this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(OffsetPxNode offsetPxNode) {
        AbstractC4492zt.h(offsetPxNode, "node");
        offsetPxNode.setOffset(this.offset);
        offsetPxNode.setRtlAware(this.rtlAware);
    }
}
