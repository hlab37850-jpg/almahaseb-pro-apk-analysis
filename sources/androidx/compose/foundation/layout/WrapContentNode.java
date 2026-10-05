package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private InterfaceC0526Fp alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public WrapContentNode(Direction direction, boolean z, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(direction, CSS.Property.DIRECTION);
        AbstractC4492zt.h(interfaceC0526Fp, "alignmentCallback");
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = interfaceC0526Fp;
    }

    public final InterfaceC0526Fp getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int iM5130getMinWidthimpl = direction != direction2 ? 0 : Constraints.m5130getMinWidthimpl(j);
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(ConstraintsKt.Constraints(iM5130getMinWidthimpl, (this.direction == direction2 || !this.unbounded) ? Constraints.m5128getMaxWidthimpl(j) : Integer.MAX_VALUE, direction3 == direction4 ? Constraints.m5129getMinHeightimpl(j) : 0, (this.direction == direction4 || !this.unbounded) ? Constraints.m5127getMaxHeightimpl(j) : Integer.MAX_VALUE));
        int iL = AbstractC3871sJ.l(placeableMo4159measureBRTryo0.getWidth(), Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j));
        int iL2 = AbstractC3871sJ.l(placeableMo4159measureBRTryo0.getHeight(), Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j));
        return MeasureScope.CC.q(measureScope, iL, iL2, null, new WrapContentNode$measure$1(this, iL, placeableMo4159measureBRTryo0, iL2, measureScope), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final void setAlignmentCallback(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "<set-?>");
        this.alignmentCallback = interfaceC0526Fp;
    }

    public final void setDirection(Direction direction) {
        AbstractC4492zt.h(direction, "<set-?>");
        this.direction = direction;
    }

    public final void setUnbounded(boolean z) {
        this.unbounded = z;
    }
}
