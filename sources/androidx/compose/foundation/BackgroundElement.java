package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class BackgroundElement extends ModifierNodeElement<BackgroundNode> {
    private final float alpha;
    private final Brush brush;
    private final long color;
    private final InterfaceC3750qp inspectorInfo;
    private final Shape shape;

    public /* synthetic */ BackgroundElement(long j, Brush brush, float f, Shape shape, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(j, brush, f, shape, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && Color.m3033equalsimpl0(this.color, backgroundElement.color) && AbstractC4492zt.d(this.brush, backgroundElement.brush) && this.alpha == backgroundElement.alpha && AbstractC4492zt.d(this.shape, backgroundElement.shape);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iM3039hashCodeimpl = Color.m3039hashCodeimpl(this.color) * 31;
        Brush brush = this.brush;
        return ((((iM3039hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.shape.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        this.inspectorInfo.invoke(inspectorInfo);
    }

    public /* synthetic */ BackgroundElement(long j, Brush brush, float f, Shape shape, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Color.Companion.m3068getUnspecified0d7_KjU() : j, (i & 2) != 0 ? null : brush, f, shape, interfaceC3750qp, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public BackgroundNode create() {
        return new BackgroundNode(this.color, this.brush, this.alpha, this.shape, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(BackgroundNode backgroundNode) {
        AbstractC4492zt.h(backgroundNode, "node");
        backgroundNode.m169setColor8_81llA(this.color);
        backgroundNode.setBrush(this.brush);
        backgroundNode.setAlpha(this.alpha);
        backgroundNode.setShape(this.shape);
    }

    private BackgroundElement(long j, Brush brush, float f, Shape shape, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(shape, "shape");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        this.color = j;
        this.brush = brush;
        this.alpha = f;
        this.shape = shape;
        this.inspectorInfo = interfaceC3750qp;
    }
}
