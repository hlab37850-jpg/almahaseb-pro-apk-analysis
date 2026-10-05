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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m413findSizeToXhtMw(long j) {
        if (this.matchHeightConstraintsFirst) {
            long jM415tryMaxHeightJN0ABg$default = m415tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m5318equalsimpl0(jM415tryMaxHeightJN0ABg$default, companion.m5325getZeroYbymL2g())) {
                return jM415tryMaxHeightJN0ABg$default;
            }
            long jM417tryMaxWidthJN0ABg$default = m417tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5318equalsimpl0(jM417tryMaxWidthJN0ABg$default, companion.m5325getZeroYbymL2g())) {
                return jM417tryMaxWidthJN0ABg$default;
            }
            long jM419tryMinHeightJN0ABg$default = m419tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5318equalsimpl0(jM419tryMinHeightJN0ABg$default, companion.m5325getZeroYbymL2g())) {
                return jM419tryMinHeightJN0ABg$default;
            }
            long jM421tryMinWidthJN0ABg$default = m421tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5318equalsimpl0(jM421tryMinWidthJN0ABg$default, companion.m5325getZeroYbymL2g())) {
                return jM421tryMinWidthJN0ABg$default;
            }
            long jM414tryMaxHeightJN0ABg = m414tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM414tryMaxHeightJN0ABg, companion.m5325getZeroYbymL2g())) {
                return jM414tryMaxHeightJN0ABg;
            }
            long jM416tryMaxWidthJN0ABg = m416tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM416tryMaxWidthJN0ABg, companion.m5325getZeroYbymL2g())) {
                return jM416tryMaxWidthJN0ABg;
            }
            long jM418tryMinHeightJN0ABg = m418tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM418tryMinHeightJN0ABg, companion.m5325getZeroYbymL2g())) {
                return jM418tryMinHeightJN0ABg;
            }
            long jM420tryMinWidthJN0ABg = m420tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM420tryMinWidthJN0ABg, companion.m5325getZeroYbymL2g())) {
                return jM420tryMinWidthJN0ABg;
            }
        } else {
            long jM417tryMaxWidthJN0ABg$default2 = m417tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m5318equalsimpl0(jM417tryMaxWidthJN0ABg$default2, companion2.m5325getZeroYbymL2g())) {
                return jM417tryMaxWidthJN0ABg$default2;
            }
            long jM415tryMaxHeightJN0ABg$default2 = m415tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5318equalsimpl0(jM415tryMaxHeightJN0ABg$default2, companion2.m5325getZeroYbymL2g())) {
                return jM415tryMaxHeightJN0ABg$default2;
            }
            long jM421tryMinWidthJN0ABg$default2 = m421tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5318equalsimpl0(jM421tryMinWidthJN0ABg$default2, companion2.m5325getZeroYbymL2g())) {
                return jM421tryMinWidthJN0ABg$default2;
            }
            long jM419tryMinHeightJN0ABg$default2 = m419tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5318equalsimpl0(jM419tryMinHeightJN0ABg$default2, companion2.m5325getZeroYbymL2g())) {
                return jM419tryMinHeightJN0ABg$default2;
            }
            long jM416tryMaxWidthJN0ABg2 = m416tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM416tryMaxWidthJN0ABg2, companion2.m5325getZeroYbymL2g())) {
                return jM416tryMaxWidthJN0ABg2;
            }
            long jM414tryMaxHeightJN0ABg2 = m414tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM414tryMaxHeightJN0ABg2, companion2.m5325getZeroYbymL2g())) {
                return jM414tryMaxHeightJN0ABg2;
            }
            long jM420tryMinWidthJN0ABg2 = m420tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM420tryMinWidthJN0ABg2, companion2.m5325getZeroYbymL2g())) {
                return jM420tryMinWidthJN0ABg2;
            }
            long jM418tryMinHeightJN0ABg2 = m418tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5318equalsimpl0(jM418tryMinHeightJN0ABg2, companion2.m5325getZeroYbymL2g())) {
                return jM418tryMinHeightJN0ABg2;
            }
        }
        return IntSize.Companion.m5325getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m414tryMaxHeightJN0ABg(long j, boolean z) {
        int iC;
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        if (iM5127getMaxHeightimpl != Integer.MAX_VALUE && (iC = AbstractC1210aB.c(iM5127getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iC, iM5127getMaxHeightimpl);
            if (!z || ConstraintsKt.m5143isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m5325getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m415tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m414tryMaxHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m416tryMaxWidthJN0ABg(long j, boolean z) {
        int iC;
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        if (iM5128getMaxWidthimpl != Integer.MAX_VALUE && (iC = AbstractC1210aB.c(iM5128getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM5128getMaxWidthimpl, iC);
            if (!z || ConstraintsKt.m5143isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m5325getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m417tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m416tryMaxWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m418tryMinHeightJN0ABg(long j, boolean z) {
        int iM5129getMinHeightimpl = Constraints.m5129getMinHeightimpl(j);
        int iC = AbstractC1210aB.c(iM5129getMinHeightimpl * this.aspectRatio);
        if (iC > 0) {
            long jIntSize = IntSizeKt.IntSize(iC, iM5129getMinHeightimpl);
            if (!z || ConstraintsKt.m5143isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m5325getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m419tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m418tryMinHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m420tryMinWidthJN0ABg(long j, boolean z) {
        int iM5130getMinWidthimpl = Constraints.m5130getMinWidthimpl(j);
        int iC = AbstractC1210aB.c(iM5130getMinWidthimpl / this.aspectRatio);
        if (iC > 0) {
            long jIntSize = IntSizeKt.IntSize(iM5130getMinWidthimpl, iC);
            if (!z || ConstraintsKt.m5143isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m5325getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m421tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m420tryMinWidthJN0ABg(j, z);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? AbstractC1210aB.c(i / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? AbstractC1210aB.c(i * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        long jM413findSizeToXhtMw = m413findSizeToXhtMw(j);
        if (!IntSize.m5318equalsimpl0(jM413findSizeToXhtMw, IntSize.Companion.m5325getZeroYbymL2g())) {
            j = Constraints.Companion.m5136fixedJhjzzOo(IntSize.m5320getWidthimpl(jM413findSizeToXhtMw), IntSize.m5319getHeightimpl(jM413findSizeToXhtMw));
        }
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new AspectRatioNode$measure$1(placeableMo4159measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? AbstractC1210aB.c(i / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? AbstractC1210aB.c(i * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }
}
