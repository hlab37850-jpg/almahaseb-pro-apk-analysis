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
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public FillNode(Direction direction, float f) {
        AbstractC4492zt.h(direction, CSS.Property.DIRECTION);
        this.direction = direction;
        this.fraction = f;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final float getFraction() {
        return this.fraction;
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
        int iM5130getMinWidthimpl;
        int iM5128getMaxWidthimpl;
        int iM5127getMaxHeightimpl;
        int iL;
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        if (!Constraints.m5124getHasBoundedWidthimpl(j) || this.direction == Direction.Vertical) {
            iM5130getMinWidthimpl = Constraints.m5130getMinWidthimpl(j);
            iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        } else {
            iM5130getMinWidthimpl = AbstractC3871sJ.l(AbstractC1210aB.c(Constraints.m5128getMaxWidthimpl(j) * this.fraction), Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j));
            iM5128getMaxWidthimpl = iM5130getMinWidthimpl;
        }
        if (!Constraints.m5123getHasBoundedHeightimpl(j) || this.direction == Direction.Horizontal) {
            int iM5129getMinHeightimpl = Constraints.m5129getMinHeightimpl(j);
            iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
            iL = iM5129getMinHeightimpl;
        } else {
            iL = AbstractC3871sJ.l(AbstractC1210aB.c(Constraints.m5127getMaxHeightimpl(j) * this.fraction), Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j));
            iM5127getMaxHeightimpl = iL;
        }
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(ConstraintsKt.Constraints(iM5130getMinWidthimpl, iM5128getMaxWidthimpl, iL, iM5127getMaxHeightimpl));
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new FillNode$measure$1(placeableMo4159measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final void setDirection(Direction direction) {
        AbstractC4492zt.h(direction, "<set-?>");
        this.direction = direction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }
}
