package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0604Ip;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    private final InterfaceC0604Ip arrangement;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, InterfaceC0604Ip interfaceC0604Ip, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, AbstractC0419Di abstractC0419Di) {
        this(layoutOrientation, interfaceC0604Ip, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData rowColumnParentData, int i, LayoutDirection layoutDirection, int i2) {
        CrossAxisAlignment crossAxisAlignment;
        if (rowColumnParentData == null || (crossAxisAlignment = rowColumnParentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = this.crossAxisAlignment;
        }
        int iCrossAxisSize = i - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(iCrossAxisSize, layoutDirection, placeable, i2);
    }

    private final int[] mainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(i), iArr, measureScope.getLayoutDirection(), measureScope, iArr2);
        return iArr2;
    }

    public final int crossAxisSize(Placeable placeable) {
        AbstractC4492zt.h(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    public final InterfaceC0604Ip getArrangement() {
        return this.arrangement;
    }

    /* JADX INFO: renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name */
    public final float m511getArrangementSpacingD9Ej5fM() {
        return this.arrangementSpacing;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable placeable) {
        AbstractC4492zt.h(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* JADX INFO: renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m512measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long j, int i, int i2) {
        int i3;
        int i4;
        int iG;
        int i5;
        int i6;
        AbstractC4492zt.h(measureScope, "measureScope");
        long jM454constructorimpl = OrientationIndependentConstraints.m454constructorimpl(j, this.orientation);
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(this.arrangementSpacing);
        int i7 = i2 - i;
        float f = 0.0f;
        int i8 = i;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        float f2 = 0.0f;
        int iMainAxisSize = 0;
        boolean z = false;
        while (true) {
            i3 = Integer.MAX_VALUE;
            if (i8 >= i2) {
                break;
            }
            Measurable measurable = this.measurables.get(i8);
            RowColumnParentData rowColumnParentData = this.rowColumnParentData[i8];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (weight > f) {
                f2 += weight;
                i11++;
                i8 = i8;
            } else {
                int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(jM454constructorimpl);
                Placeable placeableMo4159measureBRTryo0 = this.placeables[i8];
                if (placeableMo4159measureBRTryo0 == null) {
                    placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(OrientationIndependentConstraints.m467toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m456copyyUG9Ft0$default(jM454constructorimpl, 0, iM5128getMaxWidthimpl == Integer.MAX_VALUE ? Integer.MAX_VALUE : iM5128getMaxWidthimpl - iMainAxisSize, 0, 0, 8, null), this.orientation));
                }
                int iMin = Math.min(iMo327roundToPx0680j_4, (iM5128getMaxWidthimpl - iMainAxisSize) - mainAxisSize(placeableMo4159measureBRTryo0));
                iMainAxisSize += mainAxisSize(placeableMo4159measureBRTryo0) + iMin;
                int iMax = Math.max(i10, crossAxisSize(placeableMo4159measureBRTryo0));
                boolean z2 = z || RowColumnImplKt.isRelative(rowColumnParentData);
                this.placeables[i8] = placeableMo4159measureBRTryo0;
                i9 = iMin;
                i10 = iMax;
                z = z2;
            }
            i8++;
            f = 0.0f;
        }
        int i12 = i10;
        if (i11 == 0) {
            iMainAxisSize -= i9;
            i4 = i12;
            iG = 0;
        } else {
            int i13 = iMo327roundToPx0680j_4 * (i11 - 1);
            int iM5130getMinWidthimpl = (((f2 <= 0.0f || Constraints.m5128getMaxWidthimpl(jM454constructorimpl) == Integer.MAX_VALUE) ? Constraints.m5130getMinWidthimpl(jM454constructorimpl) : Constraints.m5128getMaxWidthimpl(jM454constructorimpl)) - iMainAxisSize) - i13;
            float f3 = f2 > 0.0f ? iM5130getMinWidthimpl / f2 : 0.0f;
            Iterator it = AbstractC3871sJ.s(i, i2).iterator();
            int iC = 0;
            while (it.hasNext()) {
                iC += AbstractC1210aB.c(RowColumnImplKt.getWeight(this.rowColumnParentData[((AbstractC0919Ss) it).nextInt()]) * f3);
            }
            int i14 = iM5130getMinWidthimpl - iC;
            int i15 = i;
            i4 = i12;
            int iMainAxisSize2 = 0;
            while (i15 < i2) {
                if (this.placeables[i15] == null) {
                    Measurable measurable2 = this.measurables.get(i15);
                    RowColumnParentData rowColumnParentData2 = this.rowColumnParentData[i15];
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (weight2 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    int iA = AbstractC1210aB.a(i14);
                    int i16 = i14 - iA;
                    int iMax2 = Math.max(0, AbstractC1210aB.c(weight2 * f3) + iA);
                    Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(OrientationIndependentConstraints.m467toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m452constructorimpl((!RowColumnImplKt.getFill(rowColumnParentData2) || iMax2 == i3) ? 0 : iMax2, iMax2, 0, Constraints.m5127getMaxHeightimpl(jM454constructorimpl)), this.orientation));
                    iMainAxisSize2 += mainAxisSize(placeableMo4159measureBRTryo1);
                    int iMax3 = Math.max(i4, crossAxisSize(placeableMo4159measureBRTryo1));
                    boolean z3 = z || RowColumnImplKt.isRelative(rowColumnParentData2);
                    this.placeables[i15] = placeableMo4159measureBRTryo1;
                    i14 = i16;
                    i4 = iMax3;
                    z = z3;
                }
                i15++;
                i3 = Integer.MAX_VALUE;
            }
            iG = AbstractC3871sJ.g(iMainAxisSize2 + i13, Constraints.m5128getMaxWidthimpl(jM454constructorimpl) - iMainAxisSize);
        }
        if (z) {
            int iMax4 = 0;
            int iMax5 = 0;
            for (int i17 = i; i17 < i2; i17++) {
                Placeable placeable = this.placeables[i17];
                AbstractC4492zt.e(placeable);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i17]);
                Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                    int iIntValue = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                    if (iIntValue == Integer.MIN_VALUE) {
                        iIntValue = 0;
                    }
                    iMax4 = Math.max(iMax4, iIntValue);
                    int iCrossAxisSize = crossAxisSize(placeable);
                    int iIntValue2 = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                    if (iIntValue2 == Integer.MIN_VALUE) {
                        iIntValue2 = crossAxisSize(placeable);
                    }
                    iMax5 = Math.max(iMax5, iCrossAxisSize - iIntValue2);
                }
            }
            int i18 = iMax5;
            i6 = iMax4;
            i5 = i18;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax6 = Math.max(iMainAxisSize + iG, Constraints.m5130getMinWidthimpl(jM454constructorimpl));
        int iMax7 = (Constraints.m5127getMaxHeightimpl(jM454constructorimpl) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) ? Math.max(i4, Math.max(Constraints.m5129getMinHeightimpl(jM454constructorimpl), i5 + i6)) : Constraints.m5127getMaxHeightimpl(jM454constructorimpl);
        int[] iArr = new int[i7];
        for (int i19 = 0; i19 < i7; i19++) {
            iArr[i19] = 0;
        }
        int[] iArr2 = new int[i7];
        for (int i20 = 0; i20 < i7; i20++) {
            Placeable placeable2 = this.placeables[i20 + i];
            AbstractC4492zt.e(placeable2);
            iArr2[i20] = mainAxisSize(placeable2);
        }
        return new RowColumnMeasureHelperResult(iMax7, iMax6, i, i2, i6, mainAxisPositions(iMax6, iArr2, iArr, measureScope));
    }

    public final void placeHelper(Placeable.PlacementScope placementScope, RowColumnMeasureHelperResult rowColumnMeasureHelperResult, int i, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(placementScope, "placeableScope");
        AbstractC4492zt.h(rowColumnMeasureHelperResult, "measureResult");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        int endIndex = rowColumnMeasureHelperResult.getEndIndex();
        for (int startIndex = rowColumnMeasureHelperResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            AbstractC4492zt.e(placeable);
            int[] mainAxisPositions = rowColumnMeasureHelperResult.getMainAxisPositions();
            Object parentData = this.measurables.get(startIndex).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, rowColumnMeasureHelperResult.getCrossAxisSize(), layoutDirection, rowColumnMeasureHelperResult.getBeforeCrossAxisAlignmentLine()) + i;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placementScope, placeable, mainAxisPositions[startIndex - rowColumnMeasureHelperResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.place$default(placementScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - rowColumnMeasureHelperResult.getStartIndex()], 0.0f, 4, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, InterfaceC0604Ip interfaceC0604Ip, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> list, Placeable[] placeableArr) {
        AbstractC4492zt.h(layoutOrientation, "orientation");
        AbstractC4492zt.h(interfaceC0604Ip, "arrangement");
        AbstractC4492zt.h(sizeMode, "crossAxisSize");
        AbstractC4492zt.h(crossAxisAlignment, "crossAxisAlignment");
        AbstractC4492zt.h(list, "measurables");
        AbstractC4492zt.h(placeableArr, "placeables");
        this.orientation = layoutOrientation;
        this.arrangement = interfaceC0604Ip;
        this.arrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = list;
        this.placeables = placeableArr;
        int size = list.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }
}
