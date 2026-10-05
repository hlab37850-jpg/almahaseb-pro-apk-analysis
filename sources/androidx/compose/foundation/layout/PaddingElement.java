package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    private float bottom;
    private float end;
    private final InterfaceC3750qp inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingElement(float f, float f2, float f3, float f4, boolean z, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(f, f2, f3, f4, z, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && Dp.m5165equalsimpl0(this.start, paddingElement.start) && Dp.m5165equalsimpl0(this.top, paddingElement.top) && Dp.m5165equalsimpl0(this.end, paddingElement.end) && Dp.m5165equalsimpl0(this.bottom, paddingElement.bottom) && this.rtlAware == paddingElement.rtlAware;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m470getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m471getEndD9Ej5fM() {
        return this.end;
    }

    public final InterfaceC3750qp getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m472getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m473getTopD9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((((((Dp.m5166hashCodeimpl(this.start) * 31) + Dp.m5166hashCodeimpl(this.top)) * 31) + Dp.m5166hashCodeimpl(this.end)) * 31) + Dp.m5166hashCodeimpl(this.bottom)) * 31) + AbstractC0564Hb.a(this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        this.inspectorInfo.invoke(inspectorInfo);
    }

    /* JADX INFO: renamed from: setBottom-0680j_4, reason: not valid java name */
    public final void m474setBottom0680j_4(float f) {
        this.bottom = f;
    }

    /* JADX INFO: renamed from: setEnd-0680j_4, reason: not valid java name */
    public final void m475setEnd0680j_4(float f) {
        this.end = f;
    }

    public final void setRtlAware(boolean z) {
        this.rtlAware = z;
    }

    /* JADX INFO: renamed from: setStart-0680j_4, reason: not valid java name */
    public final void m476setStart0680j_4(float f) {
        this.start = f;
    }

    /* JADX INFO: renamed from: setTop-0680j_4, reason: not valid java name */
    public final void m477setTop0680j_4(float f) {
        this.top = f;
    }

    private PaddingElement(float f, float f2, float f3, float f4, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.rtlAware = z;
        this.inspectorInfo = interfaceC3750qp;
        if (f >= 0.0f || Dp.m5165equalsimpl0(f, Dp.Companion.m5180getUnspecifiedD9Ej5fM())) {
            float f5 = this.top;
            if (f5 >= 0.0f || Dp.m5165equalsimpl0(f5, Dp.Companion.m5180getUnspecifiedD9Ej5fM())) {
                float f6 = this.end;
                if (f6 >= 0.0f || Dp.m5165equalsimpl0(f6, Dp.Companion.m5180getUnspecifiedD9Ej5fM())) {
                    float f7 = this.bottom;
                    if (f7 >= 0.0f || Dp.m5165equalsimpl0(f7, Dp.Companion.m5180getUnspecifiedD9Ej5fM())) {
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Padding must be non-negative");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(PaddingNode paddingNode) {
        AbstractC4492zt.h(paddingNode, "node");
        paddingNode.m496setStart0680j_4(this.start);
        paddingNode.m497setTop0680j_4(this.top);
        paddingNode.m495setEnd0680j_4(this.end);
        paddingNode.m494setBottom0680j_4(this.bottom);
        paddingNode.setRtlAware(this.rtlAware);
    }

    public /* synthetic */ PaddingElement(float f, float f2, float f3, float f4, boolean z, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Dp.m5160constructorimpl(0) : f, (i & 2) != 0 ? Dp.m5160constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m5160constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m5160constructorimpl(0) : f4, z, interfaceC3750qp, null);
    }
}
