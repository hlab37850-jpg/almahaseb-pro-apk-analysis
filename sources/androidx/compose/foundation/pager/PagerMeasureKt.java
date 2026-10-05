package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C0945Ts;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.R5;
import defpackage.Y4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8 = i7 + i6;
        int i9 = orientation == Orientation.Vertical ? i2 : i;
        boolean z2 = i3 < Math.min(i9, i4);
        if (z2 && i5 != 0) {
            throw new IllegalStateException("Check failed.");
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z2) {
            int size = list2.size();
            int i10 = i5;
            for (int i11 = 0; i11 < size; i11++) {
                MeasuredPage measuredPage = list2.get(i11);
                i10 -= i8;
                measuredPage.position(i10, i, i2);
                arrayList.add(measuredPage);
            }
            int size2 = list.size();
            int i12 = i5;
            for (int i13 = 0; i13 < size2; i13++) {
                MeasuredPage measuredPage2 = list.get(i13);
                measuredPage2.position(i12, i, i2);
                arrayList.add(measuredPage2);
                i12 += i8;
            }
            int size3 = list3.size();
            for (int i14 = 0; i14 < size3; i14++) {
                MeasuredPage measuredPage3 = list3.get(i14);
                measuredPage3.position(i12, i, i2);
                arrayList.add(measuredPage3);
                i12 += i8;
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i15 = 0; i15 < size4; i15++) {
                iArr[i15] = i7;
            }
            int[] iArr2 = new int[size4];
            for (int i16 = 0; i16 < size4; i16++) {
                iArr2[i16] = 0;
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM402spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m402spacedBy0680j_4(lazyLayoutMeasureScope.mo330toDpu2uoSUM(i7));
            if (orientation == Orientation.Vertical) {
                horizontalOrVerticalM402spacedBy0680j_4.arrange(density, i9, iArr, iArr2);
            } else {
                horizontalOrVerticalM402spacedBy0680j_4.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
            }
            C0945Ts c0945TsL = R5.L(iArr2);
            if (z) {
                c0945TsL = AbstractC3871sJ.q(c0945TsL);
            }
            int iB = c0945TsL.b();
            int iC = c0945TsL.c();
            int iD = c0945TsL.d();
            if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
                while (true) {
                    int size5 = iArr2[iB];
                    MeasuredPage measuredPage4 = list.get(calculatePagesOffsets$reverseAware(iB, z, size4));
                    if (z) {
                        size5 = (i9 - size5) - measuredPage4.getSize();
                    }
                    measuredPage4.position(size5, i, i2);
                    arrayList.add(measuredPage4);
                    if (iB == iC) {
                        break;
                    }
                    iB += iD;
                }
            }
        }
        return arrayList;
    }

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, InterfaceC3750qp interfaceC3750qp) {
        int iMin = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(interfaceC3750qp.invoke(Integer.valueOf(i4)));
                if (i4 == iMin) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iIntValue = list.get(i5).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(interfaceC3750qp.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? AbstractC1886cc.m() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, InterfaceC3750qp interfaceC3750qp) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(interfaceC3750qp.invoke(Integer.valueOf(i3)));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int iIntValue = list.get(i4).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(interfaceC3750qp.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? AbstractC1886cc.m() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m699getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo641measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    /* JADX INFO: renamed from: measurePager-ntgEbfI, reason: not valid java name */
    public static final PagerMeasureResult m700measurePagerntgEbfI(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, Orientation orientation, Alignment.Vertical vertical, Alignment.Horizontal horizontal, boolean z, long j2, int i8, int i9, List<Integer> list, InterfaceC0552Gp interfaceC0552Gp) {
        int i10;
        int i11;
        int i12;
        int i13;
        Y4 y4;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        MeasuredPage measuredPage;
        int i19;
        List<MeasuredPage> list2;
        MeasuredPage measuredPage2;
        Y4 y5;
        int i20;
        AbstractC4492zt.h(lazyLayoutMeasureScope, "$this$measurePager");
        AbstractC4492zt.h(pagerLazyLayoutItemProvider, "pagerItemProvider");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(list, "pinnedPages");
        AbstractC4492zt.h(interfaceC0552Gp, "layout");
        String str = "Failed requirement.";
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int iD = AbstractC3871sJ.d(i8 + i5, 0);
        if (i <= 0) {
            return new PagerMeasureResult(AbstractC1886cc.m(), 0, i8, i5, i4, orientation, -i3, i2 + i4, false, 0.0f, null, null, 0, false, (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(Constraints.m5130getMinWidthimpl(j)), Integer.valueOf(Constraints.m5129getMinHeightimpl(j)), PagerMeasureKt$measurePager$2.INSTANCE));
        }
        Orientation orientation2 = Orientation.Vertical;
        long jConstraints$default = ConstraintsKt.Constraints$default(0, orientation == orientation2 ? Constraints.m5128getMaxWidthimpl(j) : i8, 0, orientation != orientation2 ? Constraints.m5127getMaxHeightimpl(j) : i8, 5, null);
        int i21 = i6;
        if (i21 >= i) {
            i21 = i - 1;
            i10 = 0;
        } else {
            i10 = i7;
        }
        int iC = AbstractC1210aB.c(f);
        int i22 = i10 - iC;
        if (i21 != 0 || i22 >= 0) {
            i11 = iC;
        } else {
            i11 = iC + i22;
            i22 = 0;
        }
        Y4 y6 = new Y4();
        int i23 = -i3;
        int i24 = (i5 < 0 ? i5 : 0) + i23;
        int i25 = i22 + i24;
        int iMax = 0;
        while (i25 < 0 && i21 > 0) {
            int i26 = i21 - 1;
            int i27 = iD;
            Y4 y7 = y6;
            MeasuredPage measuredPageM699getAndMeasureSGf7dI0 = m699getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i26, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            y7.add(0, measuredPageM699getAndMeasureSGf7dI0);
            iMax = Math.max(iMax, measuredPageM699getAndMeasureSGf7dI0.getCrossAxisSize());
            i25 += i27;
            i24 = i24;
            y6 = y7;
            iD = i27;
            i21 = i26;
            str = str;
        }
        int i28 = i25;
        int i29 = iD;
        Y4 y8 = y6;
        String str2 = str;
        int i30 = i24;
        if (i28 < i30) {
            i11 += i28;
            i12 = i30;
        } else {
            i12 = i28;
        }
        int i31 = i12 - i30;
        Y4 y9 = y8;
        int i32 = i2;
        int i33 = i32 + i4;
        int iD2 = AbstractC3871sJ.d(i33, 0);
        int i34 = -i31;
        int size = y9.size();
        int i35 = i21;
        for (int i36 = 0; i36 < size; i36++) {
            i35++;
            i34 += i29;
        }
        int i37 = i;
        int i38 = i29;
        int i39 = i21;
        int i40 = i31;
        int i41 = i34;
        while (true) {
            if (i35 >= i37) {
                i32 = i2;
                break;
            }
            if (i41 >= iD2 && i41 > 0 && !y9.isEmpty()) {
                break;
            }
            int i42 = i38;
            int i43 = i39;
            int i44 = i35;
            int i45 = i37;
            Y4 y10 = y9;
            int i46 = iD2;
            int i47 = i33;
            int i48 = iMax;
            int i49 = i30;
            MeasuredPage measuredPageM699getAndMeasureSGf7dI1 = m699getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i35, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            i41 += i42;
            if (i41 > i49 || i44 == i45 - 1) {
                int iMax2 = Math.max(i48, measuredPageM699getAndMeasureSGf7dI1.getCrossAxisSize());
                y5 = y10;
                y5.add(measuredPageM699getAndMeasureSGf7dI1);
                i20 = i43;
                i48 = iMax2;
            } else {
                i20 = i44 + 1;
                i40 -= i42;
                y5 = y10;
            }
            i37 = i45;
            i38 = i42;
            i39 = i20;
            y9 = y5;
            iD2 = i46;
            i33 = i47;
            i35 = i44 + 1;
            i30 = i49;
            iMax = i48;
            i32 = i2;
        }
        if (i41 < i32) {
            int i50 = i32 - i41;
            int i51 = i41 + i50;
            int i52 = i39;
            int iMax3 = iMax;
            int i53 = i40 - i50;
            while (i53 < i3 && i52 > 0) {
                int i54 = i52 - 1;
                Y4 y11 = y9;
                MeasuredPage measuredPageM699getAndMeasureSGf7dI2 = m699getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i54, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                y11.add(0, measuredPageM699getAndMeasureSGf7dI2);
                iMax3 = Math.max(iMax3, measuredPageM699getAndMeasureSGf7dI2.getCrossAxisSize());
                i53 += i38;
                y9 = y11;
                i52 = i54;
                i35 = i35;
            }
            i13 = i35;
            int i55 = i53;
            i15 = iMax3;
            y4 = y9;
            int i56 = i11 + i50;
            if (i55 < 0) {
                int i57 = i51 + i55;
                i18 = i52;
                i14 = i57;
                i16 = i56 + i55;
                i17 = 0;
            } else {
                i14 = i51;
                i18 = i52;
                i16 = i56;
                i17 = i55;
            }
        } else {
            i13 = i35;
            y4 = y9;
            i14 = i41;
            i15 = iMax;
            i16 = i11;
            i17 = i40;
            i18 = i39;
        }
        float f2 = (AbstractC1210aB.a(AbstractC1210aB.c(f)) != AbstractC1210aB.a(i16) || Math.abs(AbstractC1210aB.c(f)) < Math.abs(i16)) ? f : i16;
        if (i17 < 0) {
            throw new IllegalArgumentException(str2);
        }
        int i58 = -i17;
        MeasuredPage measuredPage3 = (MeasuredPage) y4.first();
        if (i3 > 0 || i5 < 0) {
            int size2 = y4.size();
            int i59 = i17;
            int i60 = 0;
            while (i60 < size2 && i59 != 0 && i38 <= i59 && i60 != AbstractC1886cc.o(y4)) {
                i59 -= i38;
                i60++;
                measuredPage3 = (MeasuredPage) y4.get(i60);
            }
            measuredPage = measuredPage3;
            i19 = i59;
        } else {
            measuredPage = measuredPage3;
            i19 = i17;
        }
        int i61 = i15;
        int i62 = i14;
        List<MeasuredPage> listCreatePagesBeforeList = createPagesBeforeList(i18, i9, list, new PagerMeasureKt$measurePager$extraPagesBefore$1(lazyLayoutMeasureScope, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, z, i8));
        int size3 = listCreatePagesBeforeList.size();
        int iMax4 = i61;
        for (int i63 = 0; i63 < size3; i63++) {
            iMax4 = Math.max(iMax4, listCreatePagesBeforeList.get(i63).getCrossAxisSize());
        }
        MeasuredPage measuredPage4 = measuredPage;
        Y4 y12 = y4;
        List<MeasuredPage> listCreatePagesAfterList = createPagesAfterList(((MeasuredPage) y4.last()).getIndex(), i37, i9, list, new PagerMeasureKt$measurePager$extraPagesAfter$1(lazyLayoutMeasureScope, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, z, i8));
        int size4 = listCreatePagesAfterList.size();
        int iMax5 = iMax4;
        for (int i64 = 0; i64 < size4; i64++) {
            iMax5 = Math.max(iMax5, listCreatePagesAfterList.get(i64).getCrossAxisSize());
        }
        boolean z2 = AbstractC4492zt.d(measuredPage4, y12.first()) && listCreatePagesBeforeList.isEmpty() && listCreatePagesAfterList.isEmpty();
        Orientation orientation3 = Orientation.Vertical;
        int iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, orientation == orientation3 ? iMax5 : i62);
        if (orientation == orientation3) {
            iMax5 = i62;
        }
        int iM5141constrainHeightK40F9xA = ConstraintsKt.m5141constrainHeightK40F9xA(j, iMax5);
        int i65 = i13;
        List<MeasuredPage> listCalculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, y12, listCreatePagesBeforeList, listCreatePagesAfterList, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA, i62, i2, i58, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z2) {
            list2 = listCalculatePagesOffsets;
        } else {
            ArrayList arrayList = new ArrayList(listCalculatePagesOffsets.size());
            int size5 = listCalculatePagesOffsets.size();
            for (int i66 = 0; i66 < size5; i66++) {
                MeasuredPage measuredPage5 = listCalculatePagesOffsets.get(i66);
                MeasuredPage measuredPage6 = measuredPage5;
                if (measuredPage6.getIndex() >= ((MeasuredPage) y12.first()).getIndex() && measuredPage6.getIndex() <= ((MeasuredPage) y12.last()).getIndex()) {
                    arrayList.add(measuredPage5);
                }
            }
            list2 = arrayList;
        }
        int i67 = orientation == Orientation.Vertical ? iM5141constrainHeightK40F9xA : iM5142constrainWidthK40F9xA;
        if (list2.isEmpty()) {
            measuredPage2 = null;
        } else {
            MeasuredPage measuredPage7 = list2.get(0);
            MeasuredPage measuredPage8 = measuredPage7;
            float f3 = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(lazyLayoutMeasureScope, i67, i3, i4, i8, measuredPage8.getOffset(), measuredPage8.getIndex(), PagerStateKt.getSnapAlignmentStartToStart()));
            int iO = AbstractC1886cc.o(list2);
            if (1 <= iO) {
                MeasuredPage measuredPage9 = measuredPage7;
                int i68 = 1;
                float f4 = f3;
                while (true) {
                    MeasuredPage measuredPage10 = list2.get(i68);
                    MeasuredPage measuredPage11 = measuredPage10;
                    int i69 = i68;
                    float f5 = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(lazyLayoutMeasureScope, i67, i3, i4, i8, measuredPage11.getOffset(), measuredPage11.getIndex(), PagerStateKt.getSnapAlignmentStartToStart()));
                    if (Float.compare(f4, f5) < 0) {
                        f4 = f5;
                        measuredPage9 = measuredPage10;
                    }
                    if (i69 == iO) {
                        break;
                    }
                    i68 = i69 + 1;
                }
                measuredPage2 = measuredPage9;
            } else {
                measuredPage2 = measuredPage7;
            }
        }
        return new PagerMeasureResult(list2, i, i8, i5, i4, orientation, i23, i33, z, f2, measuredPage4, measuredPage2, i19, i65 < i37 || i62 > i2, (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(iM5142constrainWidthK40F9xA), Integer.valueOf(iM5141constrainHeightK40F9xA), new PagerMeasureKt$measurePager$6(listCalculatePagesOffsets)));
    }

    private static final void debugLog(InterfaceC3588op interfaceC3588op) {
    }
}
