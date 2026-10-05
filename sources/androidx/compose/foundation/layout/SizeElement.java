package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class SizeElement extends ModifierNodeElement<SizeNode> {
    private final boolean enforceIncoming;
    private final InterfaceC3750qp inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(f, f2, f3, f4, z, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return Dp.m5165equalsimpl0(this.minWidth, sizeElement.minWidth) && Dp.m5165equalsimpl0(this.minHeight, sizeElement.minHeight) && Dp.m5165equalsimpl0(this.maxWidth, sizeElement.maxWidth) && Dp.m5165equalsimpl0(this.maxHeight, sizeElement.maxHeight) && this.enforceIncoming == sizeElement.enforceIncoming;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((((((Dp.m5166hashCodeimpl(this.minWidth) * 31) + Dp.m5166hashCodeimpl(this.minHeight)) * 31) + Dp.m5166hashCodeimpl(this.maxWidth)) * 31) + Dp.m5166hashCodeimpl(this.maxHeight)) * 31) + AbstractC0564Hb.a(this.enforceIncoming);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        this.inspectorInfo.invoke(inspectorInfo);
    }

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f4, z, interfaceC3750qp, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SizeNode sizeNode) {
        AbstractC4492zt.h(sizeNode, "node");
        sizeNode.m548setMinWidth0680j_4(this.minWidth);
        sizeNode.m547setMinHeight0680j_4(this.minHeight);
        sizeNode.m546setMaxWidth0680j_4(this.maxWidth);
        sizeNode.m545setMaxHeight0680j_4(this.maxHeight);
        sizeNode.setEnforceIncoming(this.enforceIncoming);
    }

    private SizeElement(float f, float f2, float f3, float f4, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
        this.inspectorInfo = interfaceC3750qp;
    }
}
