package androidx.compose.foundation.lazy.layout;

import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List<Integer> calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider lazyLayoutItemProvider, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo) {
        AbstractC4492zt.h(lazyLayoutItemProvider, "<this>");
        AbstractC4492zt.h(lazyLayoutPinnedItemList, "pinnedItemList");
        AbstractC4492zt.h(lazyLayoutBeyondBoundsInfo, "beyondBoundsInfo");
        if (!lazyLayoutBeyondBoundsInfo.hasIntervals() && lazyLayoutPinnedItemList.isEmpty()) {
            return AbstractC1886cc.m();
        }
        ArrayList arrayList = new ArrayList();
        C1001Vs c1001Vs = lazyLayoutBeyondBoundsInfo.hasIntervals() ? new C1001Vs(lazyLayoutBeyondBoundsInfo.getStart(), Math.min(lazyLayoutBeyondBoundsInfo.getEnd(), lazyLayoutItemProvider.getItemCount() - 1)) : C1001Vs.e.a();
        int size = lazyLayoutPinnedItemList.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutPinnedItemList.PinnedItem pinnedItem = lazyLayoutPinnedItemList.get(i);
            int iFindIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, pinnedItem.getKey(), pinnedItem.getIndex());
            int iB = c1001Vs.b();
            if ((iFindIndexByKey > c1001Vs.c() || iB > iFindIndexByKey) && iFindIndexByKey >= 0 && iFindIndexByKey < lazyLayoutItemProvider.getItemCount()) {
                arrayList.add(Integer.valueOf(iFindIndexByKey));
            }
        }
        int iB2 = c1001Vs.b();
        int iC = c1001Vs.c();
        if (iB2 <= iC) {
            while (true) {
                arrayList.add(Integer.valueOf(iB2));
                if (iB2 == iC) {
                    break;
                }
                iB2++;
            }
        }
        return arrayList;
    }
}
