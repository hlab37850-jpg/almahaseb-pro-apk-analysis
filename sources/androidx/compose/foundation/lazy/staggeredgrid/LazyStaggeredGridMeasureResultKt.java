package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridMeasureResultKt {
    public static final LazyStaggeredGridItemInfo findVisibleItem(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, int i) {
        AbstractC4492zt.h(lazyStaggeredGridLayoutInfo, "<this>");
        if (lazyStaggeredGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return null;
        }
        int index = ((LazyStaggeredGridItemInfo) AbstractC3240kc.b0(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo())).getIndex();
        if (i > ((LazyStaggeredGridItemInfo) AbstractC3240kc.k0(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo())).getIndex() || index > i) {
            return null;
        }
        return (LazyStaggeredGridItemInfo) AbstractC3240kc.e0(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo(), AbstractC1886cc.k(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo(), 0, 0, new LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1(i), 3, null));
    }
}
