package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C0945Ts;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import defpackage.R5;
import defpackage.Y4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasureKt {
    @ExperimentalFoundationApi
    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            int iIntValue = list.get(i).intValue();
            if (((Boolean) interfaceC3750qp2.invoke(Integer.valueOf(iIntValue))).booleanValue()) {
                LazyGridMeasuredItem lazyGridMeasuredItemM621getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m621getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, iIntValue, 0, ((Constraints) interfaceC3750qp.invoke(Integer.valueOf(iIntValue))).m5134unboximpl(), 2, null);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyGridMeasuredItemM621getAndMeasure3p2s80s$default);
            }
        }
        return arrayList == null ? AbstractC1886cc.m() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.");
        }
        int size = list.size();
        int length = 0;
        for (int i7 = 0; i7 < size; i7++) {
            length += list.get(i7).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (!z3) {
            int size2 = list2.size();
            int i8 = i5;
            int i9 = 0;
            while (i9 < size2) {
                LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(i9);
                int mainAxisSizeWithSpacings = i8 - lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                lazyGridMeasuredItem.position(mainAxisSizeWithSpacings, 0, i, i2, (48 & 16) != 0 ? -1 : 0, (48 & 32) != 0 ? -1 : 0);
                arrayList.add(lazyGridMeasuredItem);
                i9++;
                i8 = mainAxisSizeWithSpacings;
            }
            int size3 = list.size();
            int mainAxisSizeWithSpacings2 = i5;
            for (int i10 = 0; i10 < size3; i10++) {
                LazyGridMeasuredLine lazyGridMeasuredLine = list.get(i10);
                AbstractC2371hc.E(arrayList, lazyGridMeasuredLine.position(mainAxisSizeWithSpacings2, i, i2));
                mainAxisSizeWithSpacings2 += lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            }
            int mainAxisSizeWithSpacings3 = mainAxisSizeWithSpacings2;
            int i11 = 0;
            for (int size4 = list3.size(); i11 < size4; size4 = size4) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i11);
                lazyGridMeasuredItem2.position(mainAxisSizeWithSpacings3, 0, i, i2, (48 & 16) != 0 ? -1 : 0, (48 & 32) != 0 ? -1 : 0);
                arrayList.add(lazyGridMeasuredItem2);
                mainAxisSizeWithSpacings3 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
                i11++;
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int size5 = list.size();
            int[] iArr = new int[size5];
            for (int i12 = 0; i12 < size5; i12++) {
                iArr[i12] = list.get(calculateItemsOffsets$reverseAware(i12, z2, size5)).getMainAxisSize();
            }
            int[] iArr2 = new int[size5];
            for (int i13 = 0; i13 < size5; i13++) {
                iArr2[i13] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            C0945Ts c0945TsL = R5.L(iArr2);
            if (z2) {
                c0945TsL = AbstractC3871sJ.q(c0945TsL);
            }
            int iB = c0945TsL.b();
            int iC = c0945TsL.c();
            int iD = c0945TsL.d();
            if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
                while (true) {
                    int mainAxisSize = iArr2[iB];
                    LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(calculateItemsOffsets$reverseAware(iB, z2, size5));
                    if (z2) {
                        mainAxisSize = (i6 - mainAxisSize) - lazyGridMeasuredLine2.getMainAxisSize();
                    }
                    AbstractC2371hc.E(arrayList, lazyGridMeasuredLine2.position(mainAxisSize, i, i2));
                    if (iB == iC) {
                        break;
                    }
                    iB += iD;
                }
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x029f  */
    /* JADX WARN: Code duplicated, block: B:104:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:111:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:114:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:116:0x02d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:121:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:122:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:124:0x0300  */
    /* JADX WARN: Code duplicated, block: B:125:0x0305  */
    /* JADX WARN: Code duplicated, block: B:131:0x0340  */
    /* JADX WARN: Code duplicated, block: B:137:0x0364  */
    /* JADX WARN: Code duplicated, block: B:139:0x0374  */
    /* JADX WARN: Code duplicated, block: B:141:0x0383 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x0390  */
    /* JADX WARN: Code duplicated, block: B:148:0x0394  */
    /* JADX WARN: Code duplicated, block: B:151:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:175:0x0388 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x02bd A[EDGE_INSN: B:177:0x02bd->B:110:0x02bd BREAK  A[LOOP:7: B:112:0x02c5->B:119:0x02dd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x02bd A[ADDED_TO_REGION, EDGE_INSN: B:178:0x02bd->B:110:0x02bd BREAK  A[LOOP:7: B:112:0x02c5->B:119:0x02dd], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x018c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0190  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:68:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:86:0x0222  */
    /* JADX WARN: Code duplicated, block: B:90:0x0256  */
    /* JADX WARN: Code duplicated, block: B:93:0x0263  */
    /* JADX INFO: renamed from: measureLazyGrid-ZRKPzZ8, reason: not valid java name */
    public static final LazyGridMeasureResult m618measureLazyGridZRKPzZ8(int i, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, List<Integer> list, InterfaceC0552Gp interfaceC0552Gp) {
        int i8;
        int i9;
        float f2;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int index;
        LazyGridMeasuredLine lazyGridMeasuredLine2;
        int index2;
        int size;
        List listM;
        float f3;
        List listM2;
        int i10;
        int i11;
        int i12;
        int i13;
        List list2;
        int size2;
        int i14;
        int i15;
        int size3;
        int i16;
        Y4 y4;
        int mainAxisSizeWithSpacings;
        int i17;
        int iM5142constrainWidthK40F9xA;
        int iM5127getMaxHeightimpl;
        List<LazyGridMeasuredItem> listCalculateItemsOffsets;
        boolean z3;
        int size4;
        int i18;
        List<LazyGridMeasuredItem> list3;
        int index3;
        int i19;
        Orientation orientation;
        int iIntValue;
        int i20;
        int iIntValue2;
        float f4;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem2;
        int i21;
        int i22;
        int i23;
        AbstractC4492zt.h(lazyGridMeasuredLineProvider, "measuredLineProvider");
        AbstractC4492zt.h(lazyGridMeasuredItemProvider, "measuredItemProvider");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(lazyGridItemPlacementAnimator, "placementAnimator");
        AbstractC4492zt.h(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        AbstractC4492zt.h(list, "pinnedItems");
        AbstractC4492zt.h(interfaceC0552Gp, "layout");
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(Constraints.m5130getMinWidthimpl(j)), Integer.valueOf(Constraints.m5129getMinHeightimpl(j)), LazyGridMeasureKt$measureLazyGrid$1.INSTANCE), AbstractC1886cc.m(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int iC = AbstractC1210aB.c(f);
        int i24 = i7 - iC;
        if (i6 == 0 && i24 < 0) {
            iC += i24;
            i24 = 0;
        }
        Y4 y5 = new Y4();
        int i25 = -i3;
        int i26 = i25 + (i5 < 0 ? i5 : 0);
        int i27 = i25;
        int mainAxisSizeWithSpacings2 = i24 + i26;
        int i28 = i6;
        while (mainAxisSizeWithSpacings2 < 0 && i28 > 0) {
            int i29 = i28 - 1;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i29);
            y5.add(0, andMeasure);
            mainAxisSizeWithSpacings2 += andMeasure.getMainAxisSizeWithSpacings();
            i28 = i29;
        }
        if (mainAxisSizeWithSpacings2 < i26) {
            iC += mainAxisSizeWithSpacings2;
            mainAxisSizeWithSpacings2 = i26;
        }
        int i30 = mainAxisSizeWithSpacings2 - i26;
        int i31 = i2 + i4;
        int i32 = i28;
        int iD = AbstractC3871sJ.d(i31, 0);
        int mainAxisSizeWithSpacings3 = -i30;
        int size5 = y5.size();
        int i33 = i32;
        for (int i34 = 0; i34 < size5; i34++) {
            i33++;
            mainAxisSizeWithSpacings3 += ((LazyGridMeasuredLine) y5.get(i34)).getMainAxisSizeWithSpacings();
        }
        int i35 = mainAxisSizeWithSpacings3;
        int mainAxisSizeWithSpacings4 = i30;
        int i36 = i31;
        int i37 = i33;
        while (i37 < i && (i35 < iD || i35 <= 0 || y5.isEmpty())) {
            int i38 = iD;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i37);
            if (andMeasure2.isEmpty()) {
                break;
            }
            int mainAxisSizeWithSpacings5 = i35 + andMeasure2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings5 <= i26) {
                i21 = i26;
                i22 = mainAxisSizeWithSpacings5;
                if (((LazyGridMeasuredItem) R5.W(andMeasure2.getItems())).getIndex() != i - 1) {
                    i23 = i37 + 1;
                    mainAxisSizeWithSpacings4 -= andMeasure2.getMainAxisSizeWithSpacings();
                }
                i37++;
                i32 = i23;
                iD = i38;
                i35 = i22;
                i26 = i21;
            } else {
                i21 = i26;
                i22 = mainAxisSizeWithSpacings5;
            }
            y5.add(andMeasure2);
            i23 = i32;
            i37++;
            i32 = i23;
            iD = i38;
            i35 = i22;
            i26 = i21;
        }
        if (i35 < i2) {
            int i39 = i2 - i35;
            mainAxisSizeWithSpacings4 -= i39;
            i35 += i39;
            while (true) {
                int i40 = i32;
                if (mainAxisSizeWithSpacings4 >= i3 || i40 <= 0) {
                    break;
                }
                int i41 = i40 - 1;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i41);
                i32 = i41;
                y5.add(0, andMeasure3);
                mainAxisSizeWithSpacings4 += andMeasure3.getMainAxisSizeWithSpacings();
            }
            iC += i39;
            if (mainAxisSizeWithSpacings4 < 0) {
                iC += mainAxisSizeWithSpacings4;
                i9 = i35 + mainAxisSizeWithSpacings4;
                i8 = 0;
            }
            if (AbstractC1210aB.a(AbstractC1210aB.c(f)) == AbstractC1210aB.a(iC) || Math.abs(AbstractC1210aB.c(f)) < Math.abs(iC)) {
                f2 = f;
            } else {
                f2 = iC;
            }
            if (i8 >= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int i42 = -i8;
            lazyGridMeasuredLine = (LazyGridMeasuredLine) y5.first();
            lazyGridMeasuredItem = (LazyGridMeasuredItem) R5.K(lazyGridMeasuredLine.getItems());
            if (lazyGridMeasuredItem != null) {
                index = lazyGridMeasuredItem.getIndex();
            } else {
                index = 0;
            }
            lazyGridMeasuredLine2 = (LazyGridMeasuredLine) y5.j();
            if (lazyGridMeasuredLine2 != null || (items = lazyGridMeasuredLine2.getItems()) == null || (lazyGridMeasuredItem2 = (LazyGridMeasuredItem) R5.Y(items)) == null) {
                index2 = 0;
            } else {
                index2 = lazyGridMeasuredItem2.getIndex();
            }
            size = list.size();
            listM = null;
            f3 = f2;
            listM2 = null;
            i10 = 0;
            while (i10 < size) {
                iIntValue2 = list.get(i10).intValue();
                if (iIntValue2 >= 0 || iIntValue2 >= index) {
                    f4 = f3;
                } else {
                    f4 = f3;
                    LazyGridMeasuredItem lazyGridMeasuredItemM621getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m621getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, iIntValue2, 0, lazyGridMeasuredLineProvider.m624itemConstraintsOenEA2s(iIntValue2), 2, null);
                    if (listM2 == null) {
                        listM2 = new ArrayList();
                    }
                    List list4 = listM2;
                    list4.add(lazyGridMeasuredItemM621getAndMeasure3p2s80s$default);
                    listM2 = list4;
                }
                i10++;
                size = size;
                i36 = i36;
                index2 = index2;
                index = index;
                i27 = i27;
                i9 = i9;
                f3 = f4;
            }
            float f5 = f3;
            i11 = index2;
            i12 = index;
            i13 = i9;
            int i43 = i27;
            int i44 = i36;
            if (listM2 == null) {
                listM2 = AbstractC1886cc.m();
            }
            list2 = listM2;
            size2 = list.size();
            i14 = 0;
            while (i14 < size2) {
                iIntValue = list.get(i14).intValue();
                i20 = i11;
                if (i20 + 1 > iIntValue && iIntValue < i) {
                    LazyGridMeasuredItem lazyGridMeasuredItemM621getAndMeasure3p2s80s$default2 = LazyGridMeasuredItemProvider.m621getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, iIntValue, 0, lazyGridMeasuredLineProvider.m624itemConstraintsOenEA2s(iIntValue), 2, null);
                    if (listM == null) {
                        listM = new ArrayList();
                    }
                    List list5 = listM;
                    list5.add(lazyGridMeasuredItemM621getAndMeasure3p2s80s$default2);
                    listM = list5;
                }
                i14++;
                size2 = size2;
                i11 = i20;
            }
            i15 = i11;
            if (listM == null) {
                listM = AbstractC1886cc.m();
            }
            List list6 = listM;
            if (i3 <= 0 || i5 < 0) {
                size3 = y5.size();
                i16 = 0;
                while (true) {
                    y4 = y5;
                    if (i16 >= size3) {
                        break;
                    }
                    mainAxisSizeWithSpacings = ((LazyGridMeasuredLine) y4.get(i16)).getMainAxisSizeWithSpacings();
                    if (i8 != 0 || mainAxisSizeWithSpacings > i8 || i16 == AbstractC1886cc.o(y4)) {
                        break;
                    }
                    i8 -= mainAxisSizeWithSpacings;
                    i16++;
                    lazyGridMeasuredLine = (LazyGridMeasuredLine) y4.get(i16);
                    y5 = y4;
                }
            } else {
                y4 = y5;
            }
            LazyGridMeasuredLine lazyGridMeasuredLine3 = lazyGridMeasuredLine;
            if (z) {
                iM5142constrainWidthK40F9xA = Constraints.m5128getMaxWidthimpl(j);
                i17 = i13;
            } else {
                i17 = i13;
                iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, i17);
            }
            if (z) {
                iM5127getMaxHeightimpl = ConstraintsKt.m5141constrainHeightK40F9xA(j, i17);
            } else {
                iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
            }
            int i45 = i17;
            listCalculateItemsOffsets = calculateItemsOffsets(y4, list2, list6, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl, i17, i2, i42, z, vertical, horizontal, z2, density);
            lazyGridItemPlacementAnimator.onMeasured((int) f5, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl, listCalculateItemsOffsets, lazyGridMeasuredItemProvider, lazyGridSpanLayoutProvider, z);
            if (i15 == i - 1 || i45 > i2) {
                z3 = true;
            } else {
                z3 = false;
            }
            MeasureResult measureResult = (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(iM5142constrainWidthK40F9xA), Integer.valueOf(iM5127getMaxHeightimpl), new LazyGridMeasureKt$measureLazyGrid$3(listCalculateItemsOffsets));
            if (list2.isEmpty() || !list6.isEmpty()) {
                ArrayList arrayList = new ArrayList(listCalculateItemsOffsets.size());
                size4 = listCalculateItemsOffsets.size();
                i18 = 0;
                while (i18 < size4) {
                    LazyGridMeasuredItem lazyGridMeasuredItem3 = listCalculateItemsOffsets.get(i18);
                    index3 = lazyGridMeasuredItem3.getIndex();
                    i19 = i12;
                    if (i19 > index3 && index3 <= i15) {
                        arrayList.add(lazyGridMeasuredItem3);
                    }
                    i18++;
                    i12 = i19;
                }
                list3 = arrayList;
            } else {
                list3 = listCalculateItemsOffsets;
            }
            if (z) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            return new LazyGridMeasureResult(lazyGridMeasuredLine3, i8, z3, f5, measureResult, list3, i43, i44, i, z2, orientation, i4, i5);
        }
        i8 = mainAxisSizeWithSpacings4;
        i9 = i35;
        if (AbstractC1210aB.a(AbstractC1210aB.c(f)) == AbstractC1210aB.a(iC)) {
            f2 = f;
        } else {
            f2 = f;
        }
        if (i8 >= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i46 = -i8;
        lazyGridMeasuredLine = (LazyGridMeasuredLine) y5.first();
        lazyGridMeasuredItem = (LazyGridMeasuredItem) R5.K(lazyGridMeasuredLine.getItems());
        if (lazyGridMeasuredItem != null) {
            index = lazyGridMeasuredItem.getIndex();
        } else {
            index = 0;
        }
        lazyGridMeasuredLine2 = (LazyGridMeasuredLine) y5.j();
        if (lazyGridMeasuredLine2 != null) {
            index2 = 0;
        } else {
            index2 = 0;
        }
        size = list.size();
        listM = null;
        f3 = f2;
        listM2 = null;
        i10 = 0;
        while (i10 < size) {
            iIntValue2 = list.get(i10).intValue();
            if (iIntValue2 >= 0) {
                f4 = f3;
            } else {
                f4 = f3;
            }
            i10++;
            size = size;
            i36 = i36;
            index2 = index2;
            index = index;
            i27 = i27;
            i9 = i9;
            f3 = f4;
        }
        float f6 = f3;
        i11 = index2;
        i12 = index;
        i13 = i9;
        int i47 = i27;
        int i48 = i36;
        if (listM2 == null) {
            listM2 = AbstractC1886cc.m();
        }
        list2 = listM2;
        size2 = list.size();
        i14 = 0;
        while (i14 < size2) {
            iIntValue = list.get(i14).intValue();
            i20 = i11;
            if (i20 + 1 > iIntValue) {
            }
            i14++;
            size2 = size2;
            i11 = i20;
        }
        i15 = i11;
        if (listM == null) {
            listM = AbstractC1886cc.m();
        }
        List list7 = listM;
        if (i3 <= 0) {
            size3 = y5.size();
            i16 = 0;
            while (true) {
                y4 = y5;
                if (i16 >= size3) {
                    break;
                    break;
                }
                mainAxisSizeWithSpacings = ((LazyGridMeasuredLine) y4.get(i16)).getMainAxisSizeWithSpacings();
                if (i8 != 0) {
                    break;
                }
                break;
                i8 -= mainAxisSizeWithSpacings;
                i16++;
                lazyGridMeasuredLine = (LazyGridMeasuredLine) y4.get(i16);
                y5 = y4;
            }
        } else {
            size3 = y5.size();
            i16 = 0;
            while (true) {
                y4 = y5;
                if (i16 >= size3) {
                    break;
                    break;
                }
                mainAxisSizeWithSpacings = ((LazyGridMeasuredLine) y4.get(i16)).getMainAxisSizeWithSpacings();
                if (i8 != 0) {
                    break;
                    break;
                }
                break;
                break;
                i8 -= mainAxisSizeWithSpacings;
                i16++;
                lazyGridMeasuredLine = (LazyGridMeasuredLine) y4.get(i16);
                y5 = y4;
            }
        }
        LazyGridMeasuredLine lazyGridMeasuredLine4 = lazyGridMeasuredLine;
        if (z) {
            iM5142constrainWidthK40F9xA = Constraints.m5128getMaxWidthimpl(j);
            i17 = i13;
        } else {
            i17 = i13;
            iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, i17);
        }
        if (z) {
            iM5127getMaxHeightimpl = ConstraintsKt.m5141constrainHeightK40F9xA(j, i17);
        } else {
            iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        }
        int i49 = i17;
        listCalculateItemsOffsets = calculateItemsOffsets(y4, list2, list7, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl, i17, i2, i46, z, vertical, horizontal, z2, density);
        lazyGridItemPlacementAnimator.onMeasured((int) f6, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl, listCalculateItemsOffsets, lazyGridMeasuredItemProvider, lazyGridSpanLayoutProvider, z);
        if (i15 == i - 1) {
            z3 = true;
        } else {
            z3 = true;
        }
        MeasureResult measureResult2 = (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(iM5142constrainWidthK40F9xA), Integer.valueOf(iM5127getMaxHeightimpl), new LazyGridMeasureKt$measureLazyGrid$3(listCalculateItemsOffsets));
        if (list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(listCalculateItemsOffsets.size());
            size4 = listCalculateItemsOffsets.size();
            i18 = 0;
            while (i18 < size4) {
                LazyGridMeasuredItem lazyGridMeasuredItem4 = listCalculateItemsOffsets.get(i18);
                index3 = lazyGridMeasuredItem4.getIndex();
                i19 = i12;
                if (i19 > index3) {
                }
                i18++;
                i12 = i19;
            }
            list3 = arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList(listCalculateItemsOffsets.size());
            size4 = listCalculateItemsOffsets.size();
            i18 = 0;
            while (i18 < size4) {
                LazyGridMeasuredItem lazyGridMeasuredItem5 = listCalculateItemsOffsets.get(i18);
                index3 = lazyGridMeasuredItem5.getIndex();
                i19 = i12;
                if (i19 > index3) {
                }
                i18++;
                i12 = i19;
            }
            list3 = arrayList3;
        }
        if (z) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine4, i8, z3, f6, measureResult2, list3, i47, i48, i, z2, orientation, i4, i5);
    }
}
