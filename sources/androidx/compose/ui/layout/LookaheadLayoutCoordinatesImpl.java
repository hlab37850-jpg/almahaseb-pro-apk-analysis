package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate) {
        AbstractC4492zt.h(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    private final long m4181getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        LayoutCoordinates coordinates = rootLookaheadDelegate.getCoordinates();
        Offset.Companion companion = Offset.Companion;
        return Offset.m2802minusMKHz9U(mo4167localPositionOfR5De75A(coordinates, companion.m2814getZeroF1C5BW0()), getCoordinator().mo4167localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), companion.m2814getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        return this.lookaheadDelegate.get(alignmentLine);
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo4166getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        AbstractC4492zt.h(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo4167localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        AbstractC4492zt.h(layoutCoordinates, "sourceCoordinates");
        if (!(layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl)) {
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            return Offset.m2803plusMKHz9U(mo4167localPositionOfR5De75A(rootLookaheadDelegate.getLookaheadLayoutCoordinates(), j), rootLookaheadDelegate.getCoordinator().getCoordinates().mo4167localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m2814getZeroF1C5BW0()));
        }
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinatesImpl) layoutCoordinates).lookaheadDelegate;
        lookaheadDelegate.getCoordinator().onCoordinatesUsed$ui_release();
        LookaheadDelegate lookaheadDelegate2 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            long jM4324positionInBjo55l4$ui_release = lookaheadDelegate.m4324positionInBjo55l4$ui_release(lookaheadDelegate2);
            long jIntOffset = IntOffsetKt.IntOffset(AbstractC1210aB.c(Offset.m2798getXimpl(j)), AbstractC1210aB.c(Offset.m2799getYimpl(j)));
            long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM4324positionInBjo55l4$ui_release) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM4324positionInBjo55l4$ui_release) + IntOffset.m5279getYimpl(jIntOffset));
            long jM4324positionInBjo55l4$ui_release2 = this.lookaheadDelegate.m4324positionInBjo55l4$ui_release(lookaheadDelegate2);
            long jIntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset2) - IntOffset.m5278getXimpl(jM4324positionInBjo55l4$ui_release2), IntOffset.m5279getYimpl(jIntOffset2) - IntOffset.m5279getYimpl(jM4324positionInBjo55l4$ui_release2));
            return OffsetKt.Offset(IntOffset.m5278getXimpl(jIntOffset3), IntOffset.m5279getYimpl(jIntOffset3));
        }
        LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
        long jM4324positionInBjo55l4$ui_release3 = lookaheadDelegate.m4324positionInBjo55l4$ui_release(rootLookaheadDelegate2);
        long jMo4321getPositionnOccac = rootLookaheadDelegate2.mo4321getPositionnOccac();
        long jIntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM4324positionInBjo55l4$ui_release3) + IntOffset.m5278getXimpl(jMo4321getPositionnOccac), IntOffset.m5279getYimpl(jM4324positionInBjo55l4$ui_release3) + IntOffset.m5279getYimpl(jMo4321getPositionnOccac));
        long jIntOffset5 = IntOffsetKt.IntOffset(AbstractC1210aB.c(Offset.m2798getXimpl(j)), AbstractC1210aB.c(Offset.m2799getYimpl(j)));
        long jIntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset4) + IntOffset.m5278getXimpl(jIntOffset5), IntOffset.m5279getYimpl(jIntOffset4) + IntOffset.m5279getYimpl(jIntOffset5));
        LookaheadDelegate lookaheadDelegate3 = this.lookaheadDelegate;
        long jM4324positionInBjo55l4$ui_release4 = lookaheadDelegate3.m4324positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3));
        long jMo4321getPositionnOccac2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3).mo4321getPositionnOccac();
        long jIntOffset7 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM4324positionInBjo55l4$ui_release4) + IntOffset.m5278getXimpl(jMo4321getPositionnOccac2), IntOffset.m5279getYimpl(jM4324positionInBjo55l4$ui_release4) + IntOffset.m5279getYimpl(jMo4321getPositionnOccac2));
        long jIntOffset8 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset6) - IntOffset.m5278getXimpl(jIntOffset7), IntOffset.m5279getYimpl(jIntOffset6) - IntOffset.m5279getYimpl(jIntOffset7));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        AbstractC4492zt.e(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = rootLookaheadDelegate2.getCoordinator().getWrappedBy$ui_release();
        AbstractC4492zt.e(wrappedBy$ui_release2);
        return wrappedBy$ui_release.mo4167localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset(IntOffset.m5278getXimpl(jIntOffset8), IntOffset.m5279getYimpl(jIntOffset8)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo4168localToRootMKHz9U(long j) {
        return getCoordinator().mo4168localToRootMKHz9U(Offset.m2803plusMKHz9U(j, m4181getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo4169localToWindowMKHz9U(long j) {
        return getCoordinator().mo4169localToWindowMKHz9U(Offset.m2803plusMKHz9U(j, m4181getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo4170transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        AbstractC4492zt.h(layoutCoordinates, "sourceCoordinates");
        AbstractC4492zt.h(fArr, "matrix");
        getCoordinator().mo4170transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo4171windowToLocalMKHz9U(long j) {
        return Offset.m2803plusMKHz9U(getCoordinator().mo4171windowToLocalMKHz9U(j), m4181getLookaheadOffsetF1C5BW0());
    }
}
