package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import defpackage.AbstractC4492zt;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutNodeAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, null);
        AbstractC4492zt.h(alignmentLinesOwner, "alignmentLinesOwner");
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    /* JADX INFO: renamed from: calculatePositionInParent-R5De75A */
    public long mo4245calculatePositionInParentR5De75A(NodeCoordinator nodeCoordinator, long j) {
        AbstractC4492zt.h(nodeCoordinator, "$this$calculatePositionInParent");
        return nodeCoordinator.m4364toParentPositionMKHz9U(j);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        AbstractC4492zt.h(nodeCoordinator, "<this>");
        return nodeCoordinator.getMeasureResult$ui_release().getAlignmentLines();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        AbstractC4492zt.h(nodeCoordinator, "<this>");
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        return nodeCoordinator.get(alignmentLine);
    }
}
