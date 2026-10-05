package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC4492zt;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LookaheadAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookaheadAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, null);
        AbstractC4492zt.h(alignmentLinesOwner, "alignmentLinesOwner");
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    /* JADX INFO: renamed from: calculatePositionInParent-R5De75A */
    public long mo4245calculatePositionInParentR5De75A(NodeCoordinator nodeCoordinator, long j) {
        AbstractC4492zt.h(nodeCoordinator, "$this$calculatePositionInParent");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        AbstractC4492zt.e(lookaheadDelegate);
        long jMo4321getPositionnOccac = lookaheadDelegate.mo4321getPositionnOccac();
        return Offset.m2803plusMKHz9U(OffsetKt.Offset(IntOffset.m5278getXimpl(jMo4321getPositionnOccac), IntOffset.m5279getYimpl(jMo4321getPositionnOccac)), j);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        AbstractC4492zt.h(nodeCoordinator, "<this>");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        AbstractC4492zt.e(lookaheadDelegate);
        return lookaheadDelegate.getMeasureResult$ui_release().getAlignmentLines();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        AbstractC4492zt.h(nodeCoordinator, "<this>");
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        AbstractC4492zt.e(lookaheadDelegate);
        return lookaheadDelegate.get(alignmentLine);
    }
}
