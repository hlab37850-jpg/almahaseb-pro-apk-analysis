package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0604Ip;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RowColumnImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0552Gp MaxIntrinsicHeightMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxHeight() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0552Gp MaxIntrinsicWidthMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxWidth() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0552Gp MinIntrinsicHeightMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinHeight() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMinHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0552Gp MinIntrinsicWidthMeasureBlock(LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinWidth() : IntrinsicMeasureBlocks.INSTANCE.getVerticalMinWidth();
    }

    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getCrossAxisAlignment();
        }
        return null;
    }

    public static final boolean getFill(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getFill();
        }
        return true;
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable intrinsicMeasurable) {
        AbstractC4492zt.h(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getWeight();
        }
        return 0.0f;
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i, int i2) {
        int iMin = Math.min((list.size() - 1) * i2, i);
        int size = list.size();
        float f = 0.0f;
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i3);
            float weight = getWeight(getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable, Integer.MAX_VALUE)).intValue(), i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, ((Number) interfaceC0526Fp2.mo13invoke(intrinsicMeasurable, Integer.valueOf(iMin2))).intValue());
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int iC = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : AbstractC1210aB.c(Math.max(i - iMin, 0) / f);
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            IntrinsicMeasurable intrinsicMeasurable2 = list.get(i4);
            float weight2 = getWeight(getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, ((Number) interfaceC0526Fp2.mo13invoke(intrinsicMeasurable2, Integer.valueOf(iC != Integer.MAX_VALUE ? AbstractC1210aB.c(iC * weight2) : Integer.MAX_VALUE))).intValue());
            }
        }
        return iMax;
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
        int size = list.size();
        int iMax = 0;
        int i3 = 0;
        float f = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i4);
            float weight = getWeight(getRowColumnParentData(intrinsicMeasurable));
            int iIntValue = ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable, Integer.valueOf(i))).intValue();
            if (weight == 0.0f) {
                i3 += iIntValue;
            } else if (weight > 0.0f) {
                f += weight;
                iMax = Math.max(iMax, AbstractC1210aB.c(iIntValue / weight));
            }
        }
        return AbstractC1210aB.c(iMax * f) + i3 + ((list.size() - 1) * i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicSize(List<? extends IntrinsicMeasurable> list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i, int i2, LayoutOrientation layoutOrientation, LayoutOrientation layoutOrientation2) {
        return layoutOrientation == layoutOrientation2 ? intrinsicMainAxisSize(list, interfaceC0526Fp, i, i2) : intrinsicCrossAxisSize(list, interfaceC0526Fp2, interfaceC0526Fp, i, i2);
    }

    public static final boolean isRelative(RowColumnParentData rowColumnParentData) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment(rowColumnParentData);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    /* JADX INFO: renamed from: rowColumnMeasurePolicy-TDGSqEk, reason: not valid java name */
    public static final MeasurePolicy m510rowColumnMeasurePolicyTDGSqEk(final LayoutOrientation layoutOrientation, final InterfaceC0604Ip interfaceC0604Ip, final float f, final SizeMode sizeMode, final CrossAxisAlignment crossAxisAlignment) {
        AbstractC4492zt.h(layoutOrientation, "orientation");
        AbstractC4492zt.h(interfaceC0604Ip, "arrangement");
        AbstractC4492zt.h(sizeMode, "crossAxisSize");
        AbstractC4492zt.h(crossAxisAlignment, "crossAxisAlignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(layoutOrientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo327roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(layoutOrientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo327roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                int crossAxisSize;
                int mainAxisSize;
                AbstractC4492zt.h(measureScope, "$this$measure");
                AbstractC4492zt.h(list, "measurables");
                RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(layoutOrientation, interfaceC0604Ip, f, sizeMode, crossAxisAlignment, list, new Placeable[list.size()], null);
                RowColumnMeasureHelperResult rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y = rowColumnMeasurementHelper.m512measureWithoutPlacing_EkL_Y(measureScope, j, 0, list.size());
                if (layoutOrientation == LayoutOrientation.Horizontal) {
                    crossAxisSize = rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y.getMainAxisSize();
                    mainAxisSize = rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y.getCrossAxisSize();
                } else {
                    crossAxisSize = rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y.getCrossAxisSize();
                    mainAxisSize = rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y.getMainAxisSize();
                }
                return MeasureScope.CC.q(measureScope, crossAxisSize, mainAxisSize, null, new RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1(rowColumnMeasurementHelper, rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y, measureScope), 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(layoutOrientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo327roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(layoutOrientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo327roundToPx0680j_4(f)))).intValue();
            }
        };
    }
}
