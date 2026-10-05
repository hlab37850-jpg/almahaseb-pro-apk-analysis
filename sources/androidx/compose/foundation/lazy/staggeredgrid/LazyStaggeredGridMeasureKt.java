package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import defpackage.R5;
import defpackage.Y4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    @ExperimentalFoundationApi
    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        int size = pinnedItems.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            int iIntValue = pinnedItems.get(i).intValue();
            if (((Boolean) interfaceC3750qp2.invoke(Integer.valueOf(iIntValue))).booleanValue()) {
                long jM663getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(iIntValue, jM663getSpanRangelOCCd4c);
                interfaceC3750qp.invoke(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ);
                arrayList.add(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ);
            }
        }
        return arrayList == null ? AbstractC1886cc.m() : arrayList;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Y4[] y4Arr, int[] iArr, int i) {
        int size = 0;
        for (Y4 y4 : y4Arr) {
            size += y4.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (Y4 y5 : y4Arr) {
                if (!y5.isEmpty()) {
                    int length = y4Arr.length;
                    int i2 = -1;
                    int i3 = Integer.MAX_VALUE;
                    for (int i4 = 0; i4 < length; i4++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) y4Arr[i4].f();
                        int index = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : Integer.MAX_VALUE;
                        if (i3 > index) {
                            i2 = i4;
                            i3 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) y4Arr[i2].removeFirst();
                    if (lazyStaggeredGridMeasuredItem2.getLane() == i2) {
                        long jM676constructorimpl = SpanRange.m676constructorimpl(lazyStaggeredGridMeasuredItem2.getLane(), lazyStaggeredGridMeasuredItem2.getSpan());
                        int iM666maxInRangejy6DScQ = m666maxInRangejy6DScQ(iArr, jM676constructorimpl);
                        int i5 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i2];
                        if (lazyStaggeredGridMeasuredItem2.getPlaceablesCount() != 0) {
                            lazyStaggeredGridMeasuredItem2.position(iM666maxInRangejy6DScQ, i5, i);
                            arrayList.add(lazyStaggeredGridMeasuredItem2);
                            int i6 = (int) (jM676constructorimpl & 4294967295L);
                            for (int i7 = (int) (jM676constructorimpl >> 32); i7 < i6; i7++) {
                                iArr[i7] = lazyStaggeredGridMeasuredItem2.getSizeWithSpacings() + iM666maxInRangejy6DScQ;
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final String debugRender(Y4[] y4Arr) {
        return "";
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m665forEachnIS5qE8(long j, InterfaceC3750qp interfaceC3750qp) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            interfaceC3750qp.invoke(Integer.valueOf(i2));
        }
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final <T> int indexOfMinBy(T[] tArr, InterfaceC3750qp interfaceC3750qp) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int iIntValue = ((Number) interfaceC3750qp.invoke(tArr[i3])).intValue();
            if (i2 > iIntValue) {
                i = i3;
                i2 = iIntValue;
            }
        }
        return i;
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        AbstractC4492zt.h(iArr, "<this>");
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m666maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:327:0x06b5  */
    @ExperimentalFoundationApi
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        int iR;
        int i2;
        int i3;
        int[] iArr3;
        int[] iArr4;
        int i4;
        int[] iArr5;
        boolean z2;
        boolean z3;
        boolean z4;
        List<Integer> list;
        int i5;
        boolean z5;
        boolean z6;
        int i6;
        int[] gaps;
        int i7;
        LazyLayoutMeasureScope lazyLayoutMeasureScope;
        String str;
        int[] iArr6;
        int[] iArr7;
        lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext;
        int i8 = i;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext.getLaneCount() == 0) {
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.CC.q(measureScope, Constraints.m5130getMinWidthimpl(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk()), Constraints.m5129getMinHeightimpl(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk()), null, LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE, 4, null), false, false, lazyStaggeredGridMeasureContext.isVertical(), itemCount, AbstractC1886cc.m(), IntSizeKt.IntSize(Constraints.m5130getMinWidthimpl(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk()), Constraints.m5129getMinHeightimpl(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk())), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), null);
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        String str2 = "copyOf(this, size)";
        AbstractC4492zt.g(iArrCopyOf, "copyOf(this, size)");
        int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        AbstractC4492zt.g(iArrCopyOf2, "copyOf(this, size)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext, iArrCopyOf, itemCount);
        offsetBy(iArrCopyOf2, -i8);
        int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
        Y4[] y4Arr = new Y4[laneCount];
        for (int i9 = 0; i9 < laneCount; i9++) {
            y4Arr[i9] = new Y4(16);
        }
        offsetBy(iArrCopyOf2, -lazyStaggeredGridMeasureContext.getBeforeContentPadding());
        while (true) {
            if (!measure$lambda$38$hasSpaceBeforeFirst(iArrCopyOf, iArrCopyOf2, lazyStaggeredGridMeasureContext)) {
                iR = -1;
                break;
            }
            iR = indexOfMaxValue(iArrCopyOf);
            int i10 = iArrCopyOf[iR];
            int length = iArrCopyOf2.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (iArrCopyOf[i11] != iArrCopyOf[iR]) {
                    int i12 = iArrCopyOf2[i11];
                    int i13 = iArrCopyOf2[iR];
                    if (i12 < i13) {
                        iArrCopyOf2[i11] = i13;
                    }
                }
            }
            int iFindPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i10, iR);
            if (iFindPreviousItemIndex < 0) {
                break;
            }
            long jM663getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iFindPreviousItemIndex, iR);
            int i14 = (int) (4294967295L & jM663getSpanRangelOCCd4c);
            int i15 = itemCount;
            int i16 = (int) (jM663getSpanRangelOCCd4c >> 32);
            int i17 = i14 - i16;
            lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iFindPreviousItemIndex, i17 != 1 ? -2 : i16);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(iFindPreviousItemIndex, jM663getSpanRangelOCCd4c);
            int iM666maxInRangejy6DScQ = m666maxInRangejy6DScQ(iArrCopyOf2, jM663getSpanRangelOCCd4c);
            int[] gaps2 = i17 != 1 ? lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iFindPreviousItemIndex) : null;
            while (i16 < i14) {
                iArrCopyOf[i16] = iFindPreviousItemIndex;
                iArrCopyOf2[i16] = lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ.getSizeWithSpacings() + iM666maxInRangejy6DScQ + (gaps2 == null ? 0 : gaps2[i16]);
                i16++;
            }
            itemCount = i15;
        }
        int i18 = -lazyStaggeredGridMeasureContext.getBeforeContentPadding();
        int i19 = iArrCopyOf2[0];
        if (i19 < i18) {
            i8 += i19;
            offsetBy(iArrCopyOf2, i18 - i19);
        }
        offsetBy(iArrCopyOf2, lazyStaggeredGridMeasureContext.getBeforeContentPadding());
        int i20 = -1;
        if (iR == -1) {
            iR = R5.R(iArrCopyOf, 0);
        }
        if (iR != -1 && measure$lambda$38$misalignedStart(iArrCopyOf, lazyStaggeredGridMeasureContext, iArrCopyOf2, iR) && z) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int length2 = iArrCopyOf.length;
            int[] iArr8 = new int[length2];
            int i21 = 0;
            while (i21 < length2) {
                iArr8[i21] = i20;
                i21++;
                i20 = -1;
            }
            int length3 = iArrCopyOf2.length;
            int[] iArr9 = new int[length3];
            for (int i22 = 0; i22 < length3; i22++) {
                iArr9[i22] = iArrCopyOf2[iR];
            }
            return measure(lazyStaggeredGridMeasureContext, i8, iArr8, iArr9, false);
        }
        int[] iArrCopyOf3 = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length);
        AbstractC4492zt.g(iArrCopyOf3, "copyOf(this, size)");
        int length4 = iArrCopyOf2.length;
        int[] iArr10 = new int[length4];
        for (int i23 = 0; i23 < length4; i23++) {
            iArr10[i23] = -iArrCopyOf2[i23];
        }
        int iD = AbstractC3871sJ.d(lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), 0);
        int iIndexOfMinValue$default = indexOfMinValue$default(iArrCopyOf3, 0, 1, null);
        int laneCount2 = 0;
        while (iIndexOfMinValue$default != -1 && laneCount2 < lazyStaggeredGridMeasureContext.getLaneCount()) {
            int i24 = iArrCopyOf3[iIndexOfMinValue$default];
            int iIndexOfMinValue = indexOfMinValue(iArrCopyOf3, i24);
            int i25 = laneCount2 + 1;
            if (i24 >= 0) {
                lazyLayoutMeasureScope = measureScope;
                str = str2;
                long jM663getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), i24, iIndexOfMinValue$default);
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(i24, jM663getSpanRangelOCCd4c2);
                i7 = i8;
                int i26 = (int) (jM663getSpanRangelOCCd4c2 & 4294967295L);
                iArr6 = iArrCopyOf;
                iArr7 = iArrCopyOf2;
                int i27 = (int) (jM663getSpanRangelOCCd4c2 >> 32);
                int i28 = i26 - i27;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i24, i28 != 1 ? -2 : i27);
                int iM666maxInRangejy6DScQ2 = m666maxInRangejy6DScQ(iArr10, jM663getSpanRangelOCCd4c2) + lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ2.getSizeWithSpacings();
                for (int i29 = i27; i29 < i26; i29++) {
                    iArr10[i29] = iM666maxInRangejy6DScQ2;
                    iArrCopyOf3[i29] = i24;
                    y4Arr[i29].addLast(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ2);
                }
                if (iArr10[i27] <= lazyStaggeredGridMeasureContext.getMainAxisSpacing() + i18) {
                    lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ2.setVisible(false);
                }
                if (i28 != 1) {
                    laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
                }
                iIndexOfMinValue$default = iIndexOfMinValue;
                measureScope = lazyLayoutMeasureScope;
                str2 = str;
                i8 = i7;
                iArrCopyOf = iArr6;
                iArrCopyOf2 = iArr7;
            } else {
                i7 = i8;
                lazyLayoutMeasureScope = measureScope;
                str = str2;
                iArr6 = iArrCopyOf;
                iArr7 = iArrCopyOf2;
            }
            laneCount2 = i25;
            iIndexOfMinValue$default = iIndexOfMinValue;
            measureScope = lazyLayoutMeasureScope;
            str2 = str;
            i8 = i7;
            iArrCopyOf = iArr6;
            iArrCopyOf2 = iArr7;
        }
        int i30 = i8;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = measureScope;
        String str3 = str2;
        int[] iArr11 = iArrCopyOf;
        int[] iArr12 = iArrCopyOf2;
        loop9: while (true) {
            int i31 = 0;
            while (true) {
                if (i31 >= length4) {
                    for (int i32 = 0; i32 < laneCount; i32++) {
                        if (!y4Arr[i32].isEmpty()) {
                            i2 = itemCount;
                            i3 = 1;
                            break loop9;
                        }
                    }
                    break;
                }
                int i33 = iArr10[i31];
                if (i33 < iD || i33 <= 0) {
                    break;
                }
                i31++;
            }
            i3 = 1;
            int iIndexOfMinValue$default2 = indexOfMinValue$default(iArr10, 0, 1, null);
            int iA0 = R5.a0(iArrCopyOf3) + 1;
            i2 = itemCount;
            if (iA0 >= i2) {
                break;
            }
            int i34 = length4;
            int i35 = i18;
            String str4 = str3;
            int i36 = i30;
            int[] iArr13 = iArr11;
            int[] iArr14 = iArr12;
            int[] iArr15 = iArr10;
            int i37 = iD;
            long jM663getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iA0, iIndexOfMinValue$default2);
            int i38 = (int) (jM663getSpanRangelOCCd4c3 & 4294967295L);
            int i39 = (int) (jM663getSpanRangelOCCd4c3 >> 32);
            int i40 = i38 - i39;
            lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iA0, i40 != 1 ? -2 : i39);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(iA0, jM663getSpanRangelOCCd4c3);
            int iM666maxInRangejy6DScQ3 = m666maxInRangejy6DScQ(iArr15, jM663getSpanRangelOCCd4c3);
            if (i40 != 1) {
                gaps = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iA0);
                if (gaps == null) {
                    gaps = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                gaps = null;
            }
            int i41 = i39;
            while (i41 < i38) {
                if (gaps != null) {
                    gaps[i41] = iM666maxInRangejy6DScQ3 - iArr15[i41];
                }
                iArrCopyOf3[i41] = iA0;
                iArr15[i41] = iM666maxInRangejy6DScQ3 + lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ3.getSizeWithSpacings();
                y4Arr[i41].addLast(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ3);
                i41++;
                iArr13 = iArr13;
            }
            int[] iArr16 = iArr13;
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(iA0, gaps);
            if (iArr15[i39] <= i35 + lazyStaggeredGridMeasureContext.getMainAxisSpacing()) {
                lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ3.setVisible(false);
            }
            iArr10 = iArr15;
            iArr12 = iArr14;
            str3 = str4;
            length4 = i34;
            i18 = i35;
            itemCount = i2;
            iD = i37;
            iArr11 = iArr16;
            i30 = i36;
        }
        int i42 = 0;
        while (i42 < laneCount) {
            Y4 y4 = y4Arr[i42];
            while (y4.size() > i3 && !((LazyStaggeredGridMeasuredItem) y4.first()).isVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) y4.removeFirst();
                int[] gaps3 = lazyStaggeredGridMeasuredItem.getSpan() != i3 ? lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr12[i42] = iArr12[i42] - (lazyStaggeredGridMeasuredItem.getSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i42]));
                i3 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) y4.f();
            iArr11[i42] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i42++;
            i3 = 1;
        }
        for (int i43 : iArrCopyOf3) {
            if (i43 == i2 - 1) {
                offsetBy(iArr10, -lazyStaggeredGridMeasureContext.getMainAxisSpacing());
                break;
            }
        }
        int i44 = 0;
        while (true) {
            if (i44 >= length4) {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() - iArr10[indexOfMaxValue(iArr10)];
                iArr3 = iArr12;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr10, mainAxisAvailableSize);
                boolean z7 = false;
                loop25: while (true) {
                    int length5 = iArr3.length;
                    int i45 = 0;
                    while (true) {
                        if (i45 >= length5) {
                            lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext;
                            iArr4 = iArr11;
                            break loop25;
                        }
                        if (iArr3[i45] < lazyStaggeredGridMeasureContext.getBeforeContentPadding()) {
                            break;
                        }
                        i45++;
                        i30 = i30;
                        iArr11 = iArr11;
                    }
                    int iIndexOfMinValue$default3 = indexOfMinValue$default(iArr3, 0, 1, null);
                    if (iIndexOfMinValue$default3 != indexOfMaxValue(iArr11)) {
                        z7 = true;
                    }
                    int i46 = iArr11[iIndexOfMinValue$default3];
                    if (i46 == -1) {
                        i46 = i2;
                    }
                    int iFindPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i46, iIndexOfMinValue$default3);
                    if (iFindPreviousItemIndex2 < 0) {
                        iArr4 = iArr11;
                        if ((!z7 && !measure$lambda$38$misalignedStart(iArr4, lazyStaggeredGridMeasureContext, iArr3, iIndexOfMinValue$default3)) || !z) {
                            break;
                        }
                        lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                        int length6 = iArr4.length;
                        int[] iArr17 = new int[length6];
                        for (int i47 = 0; i47 < length6; i47++) {
                            iArr17[i47] = -1;
                        }
                        int length7 = iArr3.length;
                        int[] iArr18 = new int[length7];
                        for (int i48 = 0; i48 < length7; i48++) {
                            iArr18[i48] = iArr3[iIndexOfMinValue$default3];
                        }
                        return measure(lazyStaggeredGridMeasureContext, i30, iArr17, iArr18, false);
                    }
                    boolean z8 = z7;
                    int i49 = i30;
                    int[] iArr19 = iArr11;
                    int i50 = iD;
                    int i51 = i18;
                    long jM663getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iFindPreviousItemIndex2, iIndexOfMinValue$default3);
                    int[] iArr20 = iArrCopyOf3;
                    int i52 = (int) (jM663getSpanRangelOCCd4c4 & 4294967295L);
                    int i53 = length4;
                    int[] iArr21 = iArr10;
                    int i54 = (int) (jM663getSpanRangelOCCd4c4 >> 32);
                    int i55 = i52 - i54;
                    lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iFindPreviousItemIndex2, i55 != 1 ? -2 : i54);
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(iFindPreviousItemIndex2, jM663getSpanRangelOCCd4c4);
                    int iM666maxInRangejy6DScQ4 = m666maxInRangejy6DScQ(iArr3, jM663getSpanRangelOCCd4c4);
                    int[] gaps4 = i55 != 1 ? lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iFindPreviousItemIndex2) : null;
                    boolean z9 = z8;
                    for (int i56 = i54; i56 < i52; i56++) {
                        if (iArr3[i56] != iM666maxInRangejy6DScQ4) {
                            z9 = true;
                        }
                        y4Arr[i56].addFirst(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ4);
                        iArr19[i56] = iFindPreviousItemIndex2;
                        iArr3[i56] = iM666maxInRangejy6DScQ4 + lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ4.getSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i56]);
                    }
                    iD = i50;
                    z7 = z9;
                    iArrCopyOf3 = iArr20;
                    i18 = i51;
                    length4 = i53;
                    iArr10 = iArr21;
                    i30 = i49;
                    iArr11 = iArr19;
                }
                if (!z7 || !z) {
                    i4 = mainAxisAvailableSize + i30;
                    int i57 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                    if (i57 >= 0) {
                        iArr5 = iArr10;
                        break;
                    }
                    i4 += i57;
                    iArr5 = iArr10;
                    offsetBy(iArr5, i57);
                    offsetBy(iArr3, -i57);
                    break;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                return measure(lazyStaggeredGridMeasureContext, i30, iArr4, iArr3, false);
            }
            if (iArr10[i44] >= lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext;
                iArrCopyOf3 = iArrCopyOf3;
                iArr5 = iArr10;
                iD = iD;
                i18 = i18;
                i4 = i30;
                iArr4 = iArr11;
                iArr3 = iArr12;
                length4 = length4;
                break;
            }
            i44++;
        }
        float scrollToBeConsumed$foundation_release = (AbstractC1210aB.a(AbstractC1210aB.c(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) != AbstractC1210aB.a(i4) || Math.abs(AbstractC1210aB.c(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) < Math.abs(i4)) ? lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release() : i4;
        int[] iArrCopyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        AbstractC4492zt.g(iArrCopyOf4, str3);
        int length8 = iArrCopyOf4.length;
        for (int i58 = 0; i58 < length8; i58++) {
            iArrCopyOf4[i58] = -iArrCopyOf4[i58];
        }
        if (lazyStaggeredGridMeasureContext.getBeforeContentPadding() > lazyStaggeredGridMeasureContext.getMainAxisSpacing()) {
            for (int i59 = 0; i59 < laneCount; i59++) {
                Y4 y5 = y4Arr[i59];
                int size = y5.size();
                int i60 = 0;
                while (i60 < size) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) y5.get(i60);
                    int[] gaps5 = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int sizeWithSpacings = lazyStaggeredGridMeasuredItem3.getSizeWithSpacings() + (gaps5 == null ? 0 : gaps5[i59]);
                    if (i60 == AbstractC1886cc.o(y5) || (i6 = iArr3[i59]) == 0 || i6 < sizeWithSpacings) {
                        break;
                    }
                    iArr3[i59] = i6 - sizeWithSpacings;
                    i60++;
                    iArr4[i59] = ((LazyStaggeredGridMeasuredItem) y5.get(i60)).getIndex();
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext.getBeforeContentPadding() + lazyStaggeredGridMeasureContext.getAfterContentPadding();
        int iM5128getMaxWidthimpl = lazyStaggeredGridMeasureContext.isVertical() ? Constraints.m5128getMaxWidthimpl(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk()) : ConstraintsKt.m5142constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk(), R5.a0(iArr5) + beforeContentPadding);
        int iM5141constrainHeightK40F9xA = lazyStaggeredGridMeasureContext.isVertical() ? ConstraintsKt.m5141constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk(), R5.a0(iArr5) + beforeContentPadding) : Constraints.m5127getMaxHeightimpl(lazyStaggeredGridMeasureContext.m660getConstraintsmsEJaDk());
        int iMin = (Math.min(lazyStaggeredGridMeasureContext.isVertical() ? iM5141constrainHeightK40F9xA : iM5128getMaxWidthimpl, lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext.getBeforeContentPadding()) + lazyStaggeredGridMeasureContext.getAfterContentPadding();
        int i61 = iArrCopyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        int size2 = pinnedItems.size();
        int sizeWithSpacings2 = i61;
        List listM = null;
        int i62 = 0;
        while (i62 < size2) {
            List<Integer> list2 = pinnedItems;
            int iIntValue = pinnedItems.get(i62).intValue();
            int i63 = size2;
            int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(iIntValue);
            int[] iArr22 = iArr5;
            if (lane == -2 || lane == -1) {
                int length9 = iArr4.length;
                int i64 = 0;
                while (true) {
                    if (i64 < length9) {
                        int i65 = length9;
                        if (iArr4[i64] > iIntValue) {
                            i64++;
                            length9 = i65;
                        }
                    }
                }
            } else {
                z6 = iArr4[lane] > iIntValue;
            }
            if (z6) {
                long jM663getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                if (listM == null) {
                    listM = new ArrayList();
                }
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(iIntValue, jM663getSpanRangelOCCd4c5);
                sizeWithSpacings2 -= lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ5.getSizeWithSpacings();
                lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ5.position(sizeWithSpacings2, 0, iMin);
                listM.add(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ5);
            }
            i62++;
            pinnedItems = list2;
            size2 = i63;
            iM5141constrainHeightK40F9xA = iM5141constrainHeightK40F9xA;
            iArr5 = iArr22;
            iArr4 = iArr4;
        }
        int[] iArr23 = iArr5;
        int[] iArr24 = iArr4;
        int i66 = iM5141constrainHeightK40F9xA;
        if (listM == null) {
            listM = AbstractC1886cc.m();
        }
        List<LazyStaggeredGridMeasuredItem> listCalculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext, y4Arr, iArrCopyOf4, iMin);
        int sizeWithSpacings3 = iArrCopyOf4[0];
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext.getPinnedItems();
        int size3 = pinnedItems2.size();
        List listM2 = null;
        int i67 = 0;
        while (i67 < size3) {
            int iIntValue2 = pinnedItems2.get(i67).intValue();
            if (iIntValue2 < i2) {
                int lane2 = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(iIntValue2);
                if (lane2 == -2 || lane2 == -1) {
                    iArrCopyOf3 = iArrCopyOf3;
                    int length10 = iArrCopyOf3.length;
                    list = pinnedItems2;
                    int i68 = 0;
                    while (true) {
                        if (i68 < length10) {
                            i5 = size3;
                            if (iArrCopyOf3[i68] < iIntValue2) {
                                i68++;
                                size3 = i5;
                            } else {
                                z5 = false;
                            }
                        } else {
                            i5 = size3;
                        }
                    }
                } else {
                    if (iArrCopyOf3[lane2] < iIntValue2) {
                        list = pinnedItems2;
                        i5 = size3;
                        iArrCopyOf3 = iArrCopyOf3;
                    }
                    list = pinnedItems2;
                    i5 = size3;
                    iArrCopyOf3 = iArrCopyOf3;
                    z5 = false;
                }
                z5 = true;
            } else {
                list = pinnedItems2;
                i5 = size3;
                iArrCopyOf3 = iArrCopyOf3;
                z5 = false;
            }
            if (z5) {
                long jM663getSpanRangelOCCd4c6 = lazyStaggeredGridMeasureContext.m663getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                if (listM2 == null) {
                    listM2 = new ArrayList();
                }
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m671getAndMeasurejy6DScQ(iIntValue2, jM663getSpanRangelOCCd4c6);
                lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ6.position(sizeWithSpacings3, 0, iMin);
                sizeWithSpacings3 += lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ6.getSizeWithSpacings();
                listM2.add(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ6);
            }
            i67++;
            pinnedItems2 = list;
            size3 = i5;
            i2 = i2;
        }
        int i69 = i2;
        if (listM2 == null) {
            listM2 = AbstractC1886cc.m();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listM);
        arrayList.addAll(listCalculateVisibleItems);
        arrayList.addAll(listM2);
        lazyStaggeredGridMeasureContext.getState().getPlacementAnimator$foundation_release().onMeasured((int) scrollToBeConsumed$foundation_release, iM5128getMaxWidthimpl, i66, arrayList, lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.isVertical(), lazyStaggeredGridMeasureContext.getLaneCount());
        boolean z10 = iArr24[0] != 0 || iArr3[0] > 0;
        int i70 = length4;
        int i71 = 0;
        while (true) {
            if (i71 >= i70) {
                z2 = false;
                break;
            }
            if (iArr23[i71] > lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                z2 = true;
                break;
            }
            i71++;
        }
        if (z2) {
            z3 = true;
        } else {
            int[] iArr25 = iArrCopyOf3;
            int length11 = iArr25.length;
            int i72 = 0;
            while (true) {
                if (i72 >= length11) {
                    z4 = true;
                    break;
                }
                if (!(iArr25[i72] < i69 + (-1))) {
                    z4 = false;
                    break;
                }
                i72++;
            }
            if (z4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return new LazyStaggeredGridMeasureResult(iArr24, iArr3, scrollToBeConsumed$foundation_release, MeasureScope.CC.q(lazyLayoutMeasureScope2, iM5128getMaxWidthimpl, i66, null, new LazyStaggeredGridMeasureKt$measure$1$29(arrayList, lazyStaggeredGridMeasureContext), 4, null), z3, z10, lazyStaggeredGridMeasureContext.isVertical(), i69, listCalculateVisibleItems, IntSizeKt.IntSize(iM5128getMaxWidthimpl, i66), i18, iD, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), null);
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    @ExperimentalFoundationApi
    /* JADX INFO: renamed from: measureStaggeredGrid-dSVRQoE, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m667measureStaggeredGriddSVRQoE(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4) {
        ?? r12;
        int i5;
        int iM666maxInRangejy6DScQ;
        int i6;
        AbstractC4492zt.h(lazyLayoutMeasureScope, "$this$measureStaggeredGrid");
        AbstractC4492zt.h(lazyStaggeredGridState, "state");
        AbstractC4492zt.h(list, "pinnedItems");
        AbstractC4492zt.h(lazyStaggeredGridItemProvider, "itemProvider");
        AbstractC4492zt.h(lazyStaggeredGridSlots, "resolvedSlots");
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, null);
        OJ oj = new OJ();
        OJ oj2 = new OJ();
        Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices());
                int[] offsets = lazyStaggeredGridState.getScrollPosition$foundation_release().getOffsets();
                if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                    r12 = 1;
                } else {
                    lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                    int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
                    int[] iArr = new int[laneCount];
                    int i7 = 0;
                    while (i7 < laneCount) {
                        if (i7 < iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release.length && (iM666maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release[i7]) != -1) {
                            i5 = 1;
                        } else if (i7 == 0) {
                            iM666maxInRangejy6DScQ = 0;
                            i5 = 1;
                        } else {
                            i5 = 1;
                            iM666maxInRangejy6DScQ = m666maxInRangejy6DScQ(iArr, SpanRange.m676constructorimpl(0, i7)) + 1;
                        }
                        iArr[i7] = iM666maxInRangejy6DScQ;
                        lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i7], i7);
                        i7 += i5;
                    }
                    r12 = 1;
                    iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
                }
                oj.a = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release;
                if (offsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
                    int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
                    int[] iArr2 = new int[laneCount2];
                    int i8 = 0;
                    while (i8 < laneCount2) {
                        if (i8 < offsets.length) {
                            i6 = offsets[i8];
                        } else {
                            i6 = i8 == 0 ? 0 : iArr2[i8 - 1];
                        }
                        iArr2[i8] = i6;
                        i8 += r12;
                    }
                    offsets = iArr2;
                }
                oj2.a = offsets;
                FW fw = FW.a;
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                snapshotCreateNonObservableSnapshot.dispose();
                return measure(lazyStaggeredGridMeasureContext, AbstractC1210aB.c(lazyStaggeredGridState.getScrollToBeConsumed$foundation_release()), (int[]) oj.a, (int[]) oj2.a, r12);
            } catch (Throwable th) {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            snapshotCreateNonObservableSnapshot.dispose();
            throw th2;
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    private static final int[] transform(int[] iArr, InterfaceC3750qp interfaceC3750qp) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) interfaceC3750qp.invoke(Integer.valueOf(iArr[i]))).intValue();
        }
        return iArr;
    }

    @ExperimentalFoundationApi
    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, InterfaceC3750qp interfaceC3750qp) {
        return (T) interfaceC3750qp.invoke(lazyLayoutMeasureScope);
    }

    private static final void debugLog(InterfaceC3588op interfaceC3588op) {
    }
}
