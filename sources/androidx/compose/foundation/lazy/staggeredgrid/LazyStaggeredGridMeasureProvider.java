package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyStaggeredGridMeasureProvider {
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridSlots resolvedSlots;

    public LazyStaggeredGridMeasureProvider(boolean z, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridSlots lazyStaggeredGridSlots) {
        AbstractC4492zt.h(lazyStaggeredGridItemProvider, "itemProvider");
        AbstractC4492zt.h(lazyLayoutMeasureScope, "measureScope");
        AbstractC4492zt.h(lazyStaggeredGridSlots, "resolvedSlots");
        this.isVertical = z;
        this.itemProvider = lazyStaggeredGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.resolvedSlots = lazyStaggeredGridSlots;
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo, reason: not valid java name */
    private final long m670childConstraintsJhjzzOo(int i, int i2) {
        int i3;
        int length = this.resolvedSlots.getSizes().length;
        int iG = AbstractC3871sJ.g(i, length - 1);
        int iG2 = AbstractC3871sJ.g(i2, length - iG);
        if (iG2 == 1) {
            i3 = this.resolvedSlots.getSizes()[iG];
        } else {
            int i4 = this.resolvedSlots.getPositions()[iG];
            int i5 = (iG + iG2) - 1;
            i3 = (this.resolvedSlots.getPositions()[i5] + this.resolvedSlots.getSizes()[i5]) - i4;
        }
        return this.isVertical ? Constraints.Companion.m5138fixedWidthOenEA2s(i3) : Constraints.Companion.m5137fixedHeightOenEA2s(i3);
    }

    public abstract LazyStaggeredGridMeasuredItem createItem(int i, int i2, int i3, Object obj, Object obj2, List<? extends Placeable> list);

    /* JADX INFO: renamed from: getAndMeasure-jy6DScQ, reason: not valid java name */
    public final LazyStaggeredGridMeasuredItem m671getAndMeasurejy6DScQ(int i, long j) {
        int i2 = (int) (j >> 32);
        int i3 = ((int) (j & 4294967295L)) - i2;
        return createItem(i, i2, i3, this.itemProvider.getKey(i), this.itemProvider.getContentType(i), this.measureScope.mo641measure0kLqBqw(i, m670childConstraintsJhjzzOo(i2, i3)));
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
