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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, AbstractC0419Di abstractC0419Di) {
        this(f, f2, f3, f4, z);
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m540getTargetConstraintsOenEA2s(Density density) {
        int iD;
        int iD2;
        float f = this.maxWidth;
        Dp.Companion companion = Dp.Companion;
        int i = 0;
        int iD3 = !Dp.m5165equalsimpl0(f, companion.m5180getUnspecifiedD9Ej5fM()) ? AbstractC3871sJ.d(density.mo327roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int iD4 = !Dp.m5165equalsimpl0(this.maxHeight, companion.m5180getUnspecifiedD9Ej5fM()) ? AbstractC3871sJ.d(density.mo327roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (Dp.m5165equalsimpl0(this.minWidth, companion.m5180getUnspecifiedD9Ej5fM()) || (iD = AbstractC3871sJ.d(AbstractC3871sJ.g(density.mo327roundToPx0680j_4(this.minWidth), iD3), 0)) == Integer.MAX_VALUE) {
            iD = 0;
        }
        if (!Dp.m5165equalsimpl0(this.minHeight, companion.m5180getUnspecifiedD9Ej5fM()) && (iD2 = AbstractC3871sJ.d(AbstractC3871sJ.g(density.mo327roundToPx0680j_4(this.minHeight), iD4), 0)) != Integer.MAX_VALUE) {
            i = iD2;
        }
        return ConstraintsKt.Constraints(iD, iD3, i, iD4);
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m541getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m542getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m543getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m544getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        long jM540getTargetConstraintsOenEA2s = m540getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5125getHasFixedHeightimpl(jM540getTargetConstraintsOenEA2s) ? Constraints.m5127getMaxHeightimpl(jM540getTargetConstraintsOenEA2s) : ConstraintsKt.m5141constrainHeightK40F9xA(jM540getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        long jM540getTargetConstraintsOenEA2s = m540getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5126getHasFixedWidthimpl(jM540getTargetConstraintsOenEA2s) ? Constraints.m5128getMaxWidthimpl(jM540getTargetConstraintsOenEA2s) : ConstraintsKt.m5142constrainWidthK40F9xA(jM540getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jConstraints;
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        long jM540getTargetConstraintsOenEA2s = m540getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m5140constrainN9IONVI(j, jM540getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            jConstraints = ConstraintsKt.Constraints(!Dp.m5165equalsimpl0(f, companion.m5180getUnspecifiedD9Ej5fM()) ? Constraints.m5130getMinWidthimpl(jM540getTargetConstraintsOenEA2s) : AbstractC3871sJ.g(Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(jM540getTargetConstraintsOenEA2s)), !Dp.m5165equalsimpl0(this.maxWidth, companion.m5180getUnspecifiedD9Ej5fM()) ? Constraints.m5128getMaxWidthimpl(jM540getTargetConstraintsOenEA2s) : AbstractC3871sJ.d(Constraints.m5128getMaxWidthimpl(j), Constraints.m5130getMinWidthimpl(jM540getTargetConstraintsOenEA2s)), !Dp.m5165equalsimpl0(this.minHeight, companion.m5180getUnspecifiedD9Ej5fM()) ? Constraints.m5129getMinHeightimpl(jM540getTargetConstraintsOenEA2s) : AbstractC3871sJ.g(Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(jM540getTargetConstraintsOenEA2s)), !Dp.m5165equalsimpl0(this.maxHeight, companion.m5180getUnspecifiedD9Ej5fM()) ? Constraints.m5127getMaxHeightimpl(jM540getTargetConstraintsOenEA2s) : AbstractC3871sJ.d(Constraints.m5127getMaxHeightimpl(j), Constraints.m5129getMinHeightimpl(jM540getTargetConstraintsOenEA2s)));
        }
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(jConstraints);
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new SizeNode$measure$1(placeableMo4159measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        long jM540getTargetConstraintsOenEA2s = m540getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5125getHasFixedHeightimpl(jM540getTargetConstraintsOenEA2s) ? Constraints.m5127getMaxHeightimpl(jM540getTargetConstraintsOenEA2s) : ConstraintsKt.m5141constrainHeightK40F9xA(jM540getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        long jM540getTargetConstraintsOenEA2s = m540getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5126getHasFixedWidthimpl(jM540getTargetConstraintsOenEA2s) ? Constraints.m5128getMaxWidthimpl(jM540getTargetConstraintsOenEA2s) : ConstraintsKt.m5142constrainWidthK40F9xA(jM540getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m545setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m546setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m547setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m548setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f4, z, null);
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }
}
