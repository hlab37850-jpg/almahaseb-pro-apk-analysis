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
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, AbstractC0419Di abstractC0419Di) {
        this(f, f2);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m551getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m552getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return AbstractC3871sJ.d(intrinsicMeasurable.maxIntrinsicHeight(i), !Dp.m5165equalsimpl0(this.minHeight, Dp.Companion.m5180getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo327roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return AbstractC3871sJ.d(intrinsicMeasurable.maxIntrinsicWidth(i), !Dp.m5165equalsimpl0(this.minWidth, Dp.Companion.m5180getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo327roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        float f = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(ConstraintsKt.Constraints((Dp.m5165equalsimpl0(f, companion.m5180getUnspecifiedD9Ej5fM()) || Constraints.m5130getMinWidthimpl(j) != 0) ? Constraints.m5130getMinWidthimpl(j) : AbstractC3871sJ.d(AbstractC3871sJ.g(measureScope.mo327roundToPx0680j_4(this.minWidth), Constraints.m5128getMaxWidthimpl(j)), 0), Constraints.m5128getMaxWidthimpl(j), (Dp.m5165equalsimpl0(this.minHeight, companion.m5180getUnspecifiedD9Ej5fM()) || Constraints.m5129getMinHeightimpl(j) != 0) ? Constraints.m5129getMinHeightimpl(j) : AbstractC3871sJ.d(AbstractC3871sJ.g(measureScope.mo327roundToPx0680j_4(this.minHeight), Constraints.m5127getMaxHeightimpl(j)), 0), Constraints.m5127getMaxHeightimpl(j)));
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new UnspecifiedConstraintsNode$measure$1(placeableMo4159measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return AbstractC3871sJ.d(intrinsicMeasurable.minIntrinsicHeight(i), !Dp.m5165equalsimpl0(this.minHeight, Dp.Companion.m5180getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo327roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return AbstractC3871sJ.d(intrinsicMeasurable.minIntrinsicWidth(i), !Dp.m5165equalsimpl0(this.minWidth, Dp.Companion.m5180getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo327roundToPx0680j_4(this.minWidth) : 0);
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m553setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m554setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f2, null);
    }

    private UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }
}
