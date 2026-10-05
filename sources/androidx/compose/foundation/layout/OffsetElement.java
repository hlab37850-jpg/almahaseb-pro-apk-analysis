package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class OffsetElement extends ModifierNodeElement<OffsetNode> {
    private final InterfaceC3750qp inspectorInfo;
    private final boolean rtlAware;
    private final float x;
    private final float y;

    public /* synthetic */ OffsetElement(float f, float f2, boolean z, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(f, f2, z, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetElement offsetElement = obj instanceof OffsetElement ? (OffsetElement) obj : null;
        return offsetElement != null && Dp.m5165equalsimpl0(this.x, offsetElement.x) && Dp.m5165equalsimpl0(this.y, offsetElement.y) && this.rtlAware == offsetElement.rtlAware;
    }

    public final InterfaceC3750qp getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m441getXD9Ej5fM() {
        return this.x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m442getYD9Ej5fM() {
        return this.y;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((Dp.m5166hashCodeimpl(this.x) * 31) + Dp.m5166hashCodeimpl(this.y)) * 31) + AbstractC0564Hb.a(this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        this.inspectorInfo.invoke(inspectorInfo);
    }

    public String toString() {
        return "OffsetModifierElement(x=" + ((Object) Dp.m5171toStringimpl(this.x)) + ", y=" + ((Object) Dp.m5171toStringimpl(this.y)) + ", rtlAware=" + this.rtlAware + ')';
    }

    private OffsetElement(float f, float f2, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        this.x = f;
        this.y = f2;
        this.rtlAware = z;
        this.inspectorInfo = interfaceC3750qp;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OffsetNode create() {
        return new OffsetNode(this.x, this.y, this.rtlAware, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(OffsetNode offsetNode) {
        AbstractC4492zt.h(offsetNode, "node");
        offsetNode.m449setX0680j_4(this.x);
        offsetNode.m450setY0680j_4(this.y);
        offsetNode.setRtlAware(this.rtlAware);
    }
}
