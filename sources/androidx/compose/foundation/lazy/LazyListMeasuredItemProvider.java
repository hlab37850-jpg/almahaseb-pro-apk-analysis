package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyListMeasuredItemProvider {
    private final long childConstraints;
    private final LazyListItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    @ExperimentalFoundationApi
    public /* synthetic */ LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, AbstractC0419Di abstractC0419Di) {
        this(j, z, lazyListItemProvider, lazyLayoutMeasureScope);
    }

    public abstract LazyListMeasuredItem createItem(int i, Object obj, Object obj2, List<? extends Placeable> list);

    public final LazyListMeasuredItem getAndMeasure(int i) {
        return createItem(i, this.itemProvider.getKey(i), this.itemProvider.getContentType(i), this.measureScope.mo641measure0kLqBqw(i, this.childConstraints));
    }

    /* JADX INFO: renamed from: getChildConstraints-msEJaDk, reason: not valid java name */
    public final long m594getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }

    private LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope) {
        AbstractC4492zt.h(lazyListItemProvider, "itemProvider");
        AbstractC4492zt.h(lazyLayoutMeasureScope, "measureScope");
        this.itemProvider = lazyListItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m5128getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, !z ? Constraints.m5127getMaxHeightimpl(j) : Integer.MAX_VALUE, 5, null);
    }
}
