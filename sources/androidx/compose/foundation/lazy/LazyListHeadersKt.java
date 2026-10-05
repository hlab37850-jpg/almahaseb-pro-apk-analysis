package androidx.compose.foundation.lazy;

import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListHeadersKt {
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, List<Integer> list2, int i, int i2, int i3) {
        AbstractC4492zt.h(list, "composedVisibleItems");
        AbstractC4492zt.h(lazyListMeasuredItemProvider, "itemProvider");
        AbstractC4492zt.h(list2, "headerIndexes");
        int index = ((LazyListMeasuredItem) AbstractC3240kc.b0(list)).getIndex();
        int size = list2.size();
        int i4 = 0;
        int iIntValue = -1;
        int iIntValue2 = -1;
        while (i4 < size && list2.get(i4).intValue() <= index) {
            iIntValue = list2.get(i4).intValue();
            i4++;
            iIntValue2 = ((i4 < 0 || i4 > AbstractC1886cc.o(list2)) ? -1 : list2.get(i4)).intValue();
        }
        int size2 = list.size();
        int offset = Integer.MIN_VALUE;
        int offset2 = Integer.MIN_VALUE;
        int i5 = -1;
        for (int i6 = 0; i6 < size2; i6++) {
            LazyListMeasuredItem lazyListMeasuredItem = list.get(i6);
            if (lazyListMeasuredItem.getIndex() == iIntValue) {
                offset = lazyListMeasuredItem.getOffset();
                i5 = i6;
            } else if (lazyListMeasuredItem.getIndex() == iIntValue2) {
                offset2 = lazyListMeasuredItem.getOffset();
            }
        }
        if (iIntValue == -1) {
            return null;
        }
        LazyListMeasuredItem andMeasure = lazyListMeasuredItemProvider.getAndMeasure(iIntValue);
        int iMax = offset != Integer.MIN_VALUE ? Math.max(-i, offset) : -i;
        if (offset2 != Integer.MIN_VALUE) {
            iMax = Math.min(iMax, offset2 - andMeasure.getSize());
        }
        andMeasure.position(iMax, i2, i3);
        if (i5 != -1) {
            list.set(i5, andMeasure);
        } else {
            list.add(0, andMeasure);
        }
        return andMeasure;
    }
}
