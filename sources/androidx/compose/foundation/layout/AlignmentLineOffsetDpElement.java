package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class AlignmentLineOffsetDpElement extends ModifierNodeElement<AlignmentLineOffsetDpNode> {
    private final float after;
    private final AlignmentLine alignmentLine;
    private final float before;
    private final InterfaceC3750qp inspectorInfo;

    public /* synthetic */ AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f, float f2, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(alignmentLine, f, f2, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AlignmentLineOffsetDpElement alignmentLineOffsetDpElement = obj instanceof AlignmentLineOffsetDpElement ? (AlignmentLineOffsetDpElement) obj : null;
        return alignmentLineOffsetDpElement != null && AbstractC4492zt.d(this.alignmentLine, alignmentLineOffsetDpElement.alignmentLine) && Dp.m5165equalsimpl0(this.before, alignmentLineOffsetDpElement.before) && Dp.m5165equalsimpl0(this.after, alignmentLineOffsetDpElement.after);
    }

    /* JADX INFO: renamed from: getAfter-D9Ej5fM, reason: not valid java name */
    public final float m377getAfterD9Ej5fM() {
        return this.after;
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* JADX INFO: renamed from: getBefore-D9Ej5fM, reason: not valid java name */
    public final float m378getBeforeD9Ej5fM() {
        return this.before;
    }

    public final InterfaceC3750qp getInspectorInfo() {
        return this.inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((this.alignmentLine.hashCode() * 31) + Dp.m5166hashCodeimpl(this.before)) * 31) + Dp.m5166hashCodeimpl(this.after);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        this.inspectorInfo.invoke(inspectorInfo);
    }

    private AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f, float f2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        this.alignmentLine = alignmentLine;
        this.before = f;
        this.after = f2;
        this.inspectorInfo = interfaceC3750qp;
        if ((f < 0.0f && !Dp.m5165equalsimpl0(f, Dp.Companion.m5180getUnspecifiedD9Ej5fM())) || (f2 < 0.0f && !Dp.m5165equalsimpl0(f2, Dp.Companion.m5180getUnspecifiedD9Ej5fM()))) {
            throw new IllegalArgumentException("Padding from alignment line must be a non-negative number");
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public AlignmentLineOffsetDpNode create() {
        return new AlignmentLineOffsetDpNode(this.alignmentLine, this.before, this.after, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(AlignmentLineOffsetDpNode alignmentLineOffsetDpNode) {
        AbstractC4492zt.h(alignmentLineOffsetDpNode, "node");
        alignmentLineOffsetDpNode.setAlignmentLine(this.alignmentLine);
        alignmentLineOffsetDpNode.m382setBefore0680j_4(this.before);
        alignmentLineOffsetDpNode.m381setAfter0680j_4(this.after);
    }
}
