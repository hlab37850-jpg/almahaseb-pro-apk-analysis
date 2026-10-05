package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public PaddingValuesModifier(PaddingValues paddingValues) {
        AbstractC4492zt.h(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
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
        float f = 0;
        if (Dp.m5159compareTo0680j_4(this.paddingValues.mo436calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m5160constructorimpl(f)) < 0 || Dp.m5159compareTo0680j_4(this.paddingValues.mo438calculateTopPaddingD9Ej5fM(), Dp.m5160constructorimpl(f)) < 0 || Dp.m5159compareTo0680j_4(this.paddingValues.mo437calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m5160constructorimpl(f)) < 0 || Dp.m5159compareTo0680j_4(this.paddingValues.mo435calculateBottomPaddingD9Ej5fM(), Dp.m5160constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("Padding must be non-negative");
        }
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo436calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo327roundToPx0680j_4(this.paddingValues.mo437calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_5 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo438calculateTopPaddingD9Ej5fM()) + measureScope.mo327roundToPx0680j_4(this.paddingValues.mo435calculateBottomPaddingD9Ej5fM());
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(ConstraintsKt.m5144offsetNN6EwU(j, -iMo327roundToPx0680j_4, -iMo327roundToPx0680j_5));
        return MeasureScope.CC.q(measureScope, ConstraintsKt.m5142constrainWidthK40F9xA(j, placeableMo4159measureBRTryo0.getWidth() + iMo327roundToPx0680j_4), ConstraintsKt.m5141constrainHeightK40F9xA(j, placeableMo4159measureBRTryo0.getHeight() + iMo327roundToPx0680j_5), null, new PaddingValuesModifier$measure$2(placeableMo4159measureBRTryo0, measureScope, this), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final void setPaddingValues(PaddingValues paddingValues) {
        AbstractC4492zt.h(paddingValues, "<set-?>");
        this.paddingValues = paddingValues;
    }
}
