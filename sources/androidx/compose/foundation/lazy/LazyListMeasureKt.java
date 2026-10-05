package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C0945Ts;
import defpackage.InterfaceC0552Gp;
import defpackage.R5;
import defpackage.Y4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasureKt {
    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.");
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z3) {
            int size = list2.size();
            int sizeWithSpacings = i5;
            for (int i7 = 0; i7 < size; i7++) {
                LazyListMeasuredItem lazyListMeasuredItem = list2.get(i7);
                sizeWithSpacings -= lazyListMeasuredItem.getSizeWithSpacings();
                lazyListMeasuredItem.position(sizeWithSpacings, i, i2);
                arrayList.add(lazyListMeasuredItem);
            }
            int size2 = list.size();
            int sizeWithSpacings2 = i5;
            for (int i8 = 0; i8 < size2; i8++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i8);
                lazyListMeasuredItem2.position(sizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem2);
                sizeWithSpacings2 += lazyListMeasuredItem2.getSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int i9 = 0; i9 < size3; i9++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i9);
                lazyListMeasuredItem3.position(sizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                sizeWithSpacings2 += lazyListMeasuredItem3.getSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i10 = 0; i10 < size4; i10++) {
                iArr[i10] = list.get(calculateItemsOffsets$reverseAware(i10, z2, size4)).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i11 = 0; i11 < size4; i11++) {
                iArr2[i11] = 0;
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
                    int size5 = iArr2[iB];
                    LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(iB, z2, size4));
                    if (z2) {
                        size5 = (i6 - size5) - lazyListMeasuredItem4.getSize();
                    }
                    lazyListMeasuredItem4.position(size5, i, i2);
                    arrayList.add(lazyListMeasuredItem4);
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

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2) {
        int iMin = Math.min(((LazyListMeasuredItem) AbstractC3240kc.k0(list)).getIndex() + i2, i - 1);
        int index = ((LazyListMeasuredItem) AbstractC3240kc.k0(list)).getIndex() + 1;
        ArrayList arrayList = null;
        if (index <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(index));
                if (index == iMin) {
                    break;
                }
                index++;
            }
        }
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iIntValue = list2.get(i3).intValue();
            if (iIntValue > iMin) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(iIntValue));
            }
        }
        return arrayList == null ? AbstractC1886cc.m() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(i3));
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
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(iIntValue));
            }
        }
        return arrayList == null ? AbstractC1886cc.m() : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0297  */
    /* JADX WARN: Code duplicated, block: B:103:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:109:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:112:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:113:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:115:0x02da  */
    /* JADX WARN: Code duplicated, block: B:124:0x030c  */
    /* JADX WARN: Code duplicated, block: B:126:0x0310  */
    /* JADX WARN: Code duplicated, block: B:129:0x0329  */
    /* JADX WARN: Code duplicated, block: B:149:0x01e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x01e9 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:65:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:70:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x01fc A[LOOP:4: B:81:0x01fa->B:82:0x01fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x0218 A[LOOP:5: B:84:0x0216->B:85:0x0218, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x0244  */
    /* JADX WARN: Code duplicated, block: B:95:0x0248  */
    /* JADX WARN: Code duplicated, block: B:96:0x024a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0251  */
    /* JADX INFO: renamed from: measureLazyList-CD5nmq0, reason: not valid java name */
    public static final LazyListMeasureResult m590measureLazyListCD5nmq0(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, List<Integer> list, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i8, List<Integer> list2, InterfaceC0552Gp interfaceC0552Gp) {
        int i9;
        int i10;
        int sizeWithSpacings;
        int i11;
        int i12;
        int i13;
        float f2;
        LazyListMeasuredItem lazyListMeasuredItem;
        int size;
        int i14;
        int i15;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int i16;
        int sizeWithSpacings2;
        List<LazyListMeasuredItem> listCreateItemsBeforeList;
        int size2;
        int iMax;
        int i17;
        List<LazyListMeasuredItem> listCreateItemsAfterList;
        int size3;
        int i18;
        boolean z3;
        int i19;
        int iM5142constrainWidthK40F9xA;
        int iM5141constrainHeightK40F9xA;
        int i20;
        List<LazyListMeasuredItem> listCalculateItemsOffsets;
        LazyListMeasuredItem lazyListMeasuredItemFindOrComposeLazyListHeader;
        boolean z4;
        int size4;
        int i21;
        List<LazyListMeasuredItem> list3;
        LazyListMeasuredItem lazyListMeasuredItem3;
        Orientation orientation;
        int i22;
        AbstractC4492zt.h(lazyListMeasuredItemProvider, "measuredItemProvider");
        AbstractC4492zt.h(list, "headerIndexes");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(lazyListItemPlacementAnimator, "placementAnimator");
        AbstractC4492zt.h(list2, "pinnedItems");
        AbstractC4492zt.h(interfaceC0552Gp, "layout");
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i <= 0) {
            return new LazyListMeasureResult(null, 0, false, 0.0f, (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(Constraints.m5130getMinWidthimpl(j)), Integer.valueOf(Constraints.m5129getMinHeightimpl(j)), LazyListMeasureKt$measureLazyList$1.INSTANCE), AbstractC1886cc.m(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int i23 = i6;
        if (i23 >= i) {
            i23 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int iC = AbstractC1210aB.c(f);
        int i24 = i9 - iC;
        if (i23 == 0 && i24 < 0) {
            iC += i24;
            i24 = 0;
        }
        Y4 y4 = new Y4();
        int i25 = -i3;
        int i26 = i25 + (i5 < 0 ? i5 : 0);
        int sizeWithSpacings3 = i24 + i26;
        int iMax2 = 0;
        while (sizeWithSpacings3 < 0 && i23 > 0) {
            int i27 = i23 - 1;
            LazyListMeasuredItem andMeasure = lazyListMeasuredItemProvider.getAndMeasure(i27);
            y4.add(0, andMeasure);
            iMax2 = Math.max(iMax2, andMeasure.getCrossAxisSize());
            sizeWithSpacings3 += andMeasure.getSizeWithSpacings();
            i23 = i27;
        }
        if (sizeWithSpacings3 < i26) {
            iC += sizeWithSpacings3;
            sizeWithSpacings3 = i26;
        }
        int i28 = sizeWithSpacings3 - i26;
        int i29 = i2 + i4;
        int i30 = iMax2;
        int i31 = i23;
        int iD = AbstractC3871sJ.d(i29, 0);
        int sizeWithSpacings4 = -i28;
        int size5 = y4.size();
        int i32 = i31;
        for (int i33 = 0; i33 < size5; i33++) {
            i32++;
            sizeWithSpacings4 += ((LazyListMeasuredItem) y4.get(i33)).getSizeWithSpacings();
        }
        int sizeWithSpacings5 = i28;
        int iMax3 = i30;
        int i34 = i32;
        int i35 = i31;
        int sizeWithSpacings6 = sizeWithSpacings4;
        while (i34 < i && (sizeWithSpacings6 < iD || sizeWithSpacings6 <= 0 || y4.isEmpty())) {
            int i36 = iD;
            LazyListMeasuredItem andMeasure2 = lazyListMeasuredItemProvider.getAndMeasure(i34);
            sizeWithSpacings6 += andMeasure2.getSizeWithSpacings();
            if (sizeWithSpacings6 <= i26) {
                i22 = i26;
                if (i34 != i - 1) {
                    sizeWithSpacings5 -= andMeasure2.getSizeWithSpacings();
                    i35 = i34 + 1;
                }
                i34++;
                iD = i36;
                i26 = i22;
            } else {
                i22 = i26;
            }
            int iMax4 = Math.max(iMax3, andMeasure2.getCrossAxisSize());
            y4.add(andMeasure2);
            iMax3 = iMax4;
            i34++;
            iD = i36;
            i26 = i22;
        }
        if (sizeWithSpacings6 < i2) {
            int i37 = i2 - sizeWithSpacings6;
            sizeWithSpacings6 += i37;
            sizeWithSpacings = sizeWithSpacings5 - i37;
            while (sizeWithSpacings < i3 && i35 > 0) {
                int i38 = i35 - 1;
                int i39 = i34;
                LazyListMeasuredItem andMeasure3 = lazyListMeasuredItemProvider.getAndMeasure(i38);
                y4.add(0, andMeasure3);
                iMax3 = Math.max(iMax3, andMeasure3.getCrossAxisSize());
                sizeWithSpacings += andMeasure3.getSizeWithSpacings();
                i35 = i38;
                i34 = i39;
            }
            i10 = i34;
            iC += i37;
            if (sizeWithSpacings < 0) {
                i11 = sizeWithSpacings6 + sizeWithSpacings;
                i12 = iC + sizeWithSpacings;
                i13 = i35;
                sizeWithSpacings = 0;
            }
            if (AbstractC1210aB.a(AbstractC1210aB.c(f)) == AbstractC1210aB.a(i12) || Math.abs(AbstractC1210aB.c(f)) < Math.abs(i12)) {
                f2 = f;
            } else {
                f2 = i12;
            }
            if (sizeWithSpacings >= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int i40 = -sizeWithSpacings;
            lazyListMeasuredItem = (LazyListMeasuredItem) y4.first();
            if (i3 <= 0 || i5 < 0) {
                size = y4.size();
                i14 = sizeWithSpacings;
                i15 = 0;
                while (true) {
                    if (i15 < size) {
                        sizeWithSpacings2 = ((LazyListMeasuredItem) y4.get(i15)).getSizeWithSpacings();
                        if (i14 == 0 && sizeWithSpacings2 <= i14) {
                            if (i15 == AbstractC1886cc.o(y4)) {
                                break;
                            }
                            i14 -= sizeWithSpacings2;
                            i15++;
                            lazyListMeasuredItem = (LazyListMeasuredItem) y4.get(i15);
                        }
                    }
                    break;
                }
                lazyListMeasuredItem2 = lazyListMeasuredItem;
                i16 = i14;
            } else {
                lazyListMeasuredItem2 = lazyListMeasuredItem;
                i16 = sizeWithSpacings;
            }
            listCreateItemsBeforeList = createItemsBeforeList(i13, lazyListMeasuredItemProvider, i8, list2);
            size2 = listCreateItemsBeforeList.size();
            iMax = iMax3;
            for (i17 = 0; i17 < size2; i17++) {
                iMax = Math.max(iMax, listCreateItemsBeforeList.get(i17).getCrossAxisSize());
            }
            listCreateItemsAfterList = createItemsAfterList(y4, lazyListMeasuredItemProvider, i, i8, list2);
            size3 = listCreateItemsAfterList.size();
            for (i18 = 0; i18 < size3; i18++) {
                iMax = Math.max(iMax, listCreateItemsAfterList.get(i18).getCrossAxisSize());
            }
            if (!AbstractC4492zt.d(lazyListMeasuredItem2, y4.first()) && listCreateItemsBeforeList.isEmpty() && listCreateItemsAfterList.isEmpty()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z) {
                i19 = iMax;
            } else {
                i19 = i11;
            }
            iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, i19);
            if (z) {
                iMax = i11;
            }
            iM5141constrainHeightK40F9xA = ConstraintsKt.m5141constrainHeightK40F9xA(j, iMax);
            i20 = i10;
            listCalculateItemsOffsets = calculateItemsOffsets(y4, listCreateItemsBeforeList, listCreateItemsAfterList, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA, i11, i2, i40, z, vertical, horizontal, z2, density);
            float f3 = f2;
            LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem2;
            lazyListItemPlacementAnimator.onMeasured((int) f2, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA, listCalculateItemsOffsets, lazyListMeasuredItemProvider, z);
            if (list.isEmpty()) {
                lazyListMeasuredItemFindOrComposeLazyListHeader = null;
            } else {
                lazyListMeasuredItemFindOrComposeLazyListHeader = LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, lazyListMeasuredItemProvider, list, i3, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA);
            }
            if (i20 >= i || i11 > i2) {
                z4 = true;
            } else {
                z4 = false;
            }
            MeasureResult measureResult = (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(iM5142constrainWidthK40F9xA), Integer.valueOf(iM5141constrainHeightK40F9xA), new LazyListMeasureKt$measureLazyList$5(listCalculateItemsOffsets, lazyListMeasuredItemFindOrComposeLazyListHeader));
            if (z3) {
                list3 = listCalculateItemsOffsets;
            } else {
                ArrayList arrayList = new ArrayList(listCalculateItemsOffsets.size());
                size4 = listCalculateItemsOffsets.size();
                for (i21 = 0; i21 < size4; i21++) {
                    LazyListMeasuredItem lazyListMeasuredItem5 = listCalculateItemsOffsets.get(i21);
                    lazyListMeasuredItem3 = lazyListMeasuredItem5;
                    if ((lazyListMeasuredItem3.getIndex() < ((LazyListMeasuredItem) y4.first()).getIndex() && lazyListMeasuredItem3.getIndex() <= ((LazyListMeasuredItem) y4.last()).getIndex()) || lazyListMeasuredItem3 == lazyListMeasuredItemFindOrComposeLazyListHeader) {
                        arrayList.add(lazyListMeasuredItem5);
                    }
                }
                list3 = arrayList;
            }
            if (z) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            return new LazyListMeasureResult(lazyListMeasuredItem4, i16, z4, f3, measureResult, list3, i25, i29, i, z2, orientation, i4, i5);
        }
        i10 = i34;
        sizeWithSpacings = sizeWithSpacings5;
        i11 = sizeWithSpacings6;
        i12 = iC;
        i13 = i35;
        if (AbstractC1210aB.a(AbstractC1210aB.c(f)) == AbstractC1210aB.a(i12)) {
            f2 = f;
        } else {
            f2 = f;
        }
        if (sizeWithSpacings >= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i41 = -sizeWithSpacings;
        lazyListMeasuredItem = (LazyListMeasuredItem) y4.first();
        if (i3 <= 0) {
            size = y4.size();
            i14 = sizeWithSpacings;
            i15 = 0;
            while (true) {
                if (i15 < size) {
                    sizeWithSpacings2 = ((LazyListMeasuredItem) y4.get(i15)).getSizeWithSpacings();
                    if (i14 == 0) {
                    }
                }
                break;
                i14 -= sizeWithSpacings2;
                i15++;
                lazyListMeasuredItem = (LazyListMeasuredItem) y4.get(i15);
            }
            lazyListMeasuredItem2 = lazyListMeasuredItem;
            i16 = i14;
        } else {
            size = y4.size();
            i14 = sizeWithSpacings;
            i15 = 0;
            while (true) {
                if (i15 < size) {
                    sizeWithSpacings2 = ((LazyListMeasuredItem) y4.get(i15)).getSizeWithSpacings();
                    if (i14 == 0) {
                    }
                }
                break;
                i14 -= sizeWithSpacings2;
                i15++;
                lazyListMeasuredItem = (LazyListMeasuredItem) y4.get(i15);
            }
            lazyListMeasuredItem2 = lazyListMeasuredItem;
            i16 = i14;
        }
        listCreateItemsBeforeList = createItemsBeforeList(i13, lazyListMeasuredItemProvider, i8, list2);
        size2 = listCreateItemsBeforeList.size();
        iMax = iMax3;
        while (i17 < size2) {
            iMax = Math.max(iMax, listCreateItemsBeforeList.get(i17).getCrossAxisSize());
        }
        listCreateItemsAfterList = createItemsAfterList(y4, lazyListMeasuredItemProvider, i, i8, list2);
        size3 = listCreateItemsAfterList.size();
        while (i18 < size3) {
            iMax = Math.max(iMax, listCreateItemsAfterList.get(i18).getCrossAxisSize());
        }
        if (!AbstractC4492zt.d(lazyListMeasuredItem2, y4.first())) {
            z3 = false;
        } else {
            z3 = false;
        }
        if (z) {
            i19 = iMax;
        } else {
            i19 = i11;
        }
        iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, i19);
        if (z) {
            iMax = i11;
        }
        iM5141constrainHeightK40F9xA = ConstraintsKt.m5141constrainHeightK40F9xA(j, iMax);
        i20 = i10;
        listCalculateItemsOffsets = calculateItemsOffsets(y4, listCreateItemsBeforeList, listCreateItemsAfterList, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA, i11, i2, i41, z, vertical, horizontal, z2, density);
        float f4 = f2;
        LazyListMeasuredItem lazyListMeasuredItem6 = lazyListMeasuredItem2;
        lazyListItemPlacementAnimator.onMeasured((int) f2, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA, listCalculateItemsOffsets, lazyListMeasuredItemProvider, z);
        if (list.isEmpty()) {
            lazyListMeasuredItemFindOrComposeLazyListHeader = LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, lazyListMeasuredItemProvider, list, i3, iM5142constrainWidthK40F9xA, iM5141constrainHeightK40F9xA);
        } else {
            lazyListMeasuredItemFindOrComposeLazyListHeader = null;
        }
        if (i20 >= i) {
            z4 = true;
        } else {
            z4 = true;
        }
        MeasureResult measureResult2 = (MeasureResult) interfaceC0552Gp.invoke(Integer.valueOf(iM5142constrainWidthK40F9xA), Integer.valueOf(iM5141constrainHeightK40F9xA), new LazyListMeasureKt$measureLazyList$5(listCalculateItemsOffsets, lazyListMeasuredItemFindOrComposeLazyListHeader));
        if (z3) {
            list3 = listCalculateItemsOffsets;
        } else {
            ArrayList arrayList2 = new ArrayList(listCalculateItemsOffsets.size());
            size4 = listCalculateItemsOffsets.size();
            while (i21 < size4) {
                LazyListMeasuredItem lazyListMeasuredItem7 = listCalculateItemsOffsets.get(i21);
                lazyListMeasuredItem3 = lazyListMeasuredItem7;
                if (lazyListMeasuredItem3.getIndex() < ((LazyListMeasuredItem) y4.first()).getIndex()) {
                }
            }
            list3 = arrayList2;
        }
        if (z) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        return new LazyListMeasureResult(lazyListMeasuredItem6, i16, z4, f4, measureResult2, list3, i25, i29, i, z2, orientation, i4, i5);
    }
}
