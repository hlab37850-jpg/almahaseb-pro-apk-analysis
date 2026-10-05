package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridMeasuredItemProvider {
    private final int defaultMainAxisSpacing;
    private final LazyGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    @ExperimentalFoundationApi
    public LazyGridMeasuredItemProvider(LazyGridItemProvider lazyGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i) {
        AbstractC4492zt.h(lazyGridItemProvider, "itemProvider");
        AbstractC4492zt.h(lazyLayoutMeasureScope, "measureScope");
        this.itemProvider = lazyGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.defaultMainAxisSpacing = i;
    }

    /* JADX INFO: renamed from: getAndMeasure-3p2s80s$default, reason: not valid java name */
    public static /* synthetic */ LazyGridMeasuredItem m621getAndMeasure3p2s80s$default(LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i, int i2, long j, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-3p2s80s");
        }
        if ((i3 & 2) != 0) {
            i2 = lazyGridMeasuredItemProvider.defaultMainAxisSpacing;
        }
        return lazyGridMeasuredItemProvider.m622getAndMeasure3p2s80s(i, i2, j);
    }

    public abstract LazyGridMeasuredItem createItem(int i, Object obj, Object obj2, int i2, int i3, List<? extends Placeable> list);

    /* JADX INFO: renamed from: getAndMeasure-3p2s80s, reason: not valid java name */
    public final LazyGridMeasuredItem m622getAndMeasure3p2s80s(int i, int i2, long j) {
        int iM5129getMinHeightimpl;
        Object key = this.itemProvider.getKey(i);
        Object contentType = this.itemProvider.getContentType(i);
        List<Placeable> listMo641measure0kLqBqw = this.measureScope.mo641measure0kLqBqw(i, j);
        if (Constraints.m5126getHasFixedWidthimpl(j)) {
            iM5129getMinHeightimpl = Constraints.m5130getMinWidthimpl(j);
        } else {
            if (!Constraints.m5125getHasFixedHeightimpl(j)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            iM5129getMinHeightimpl = Constraints.m5129getMinHeightimpl(j);
        }
        return createItem(i, key, contentType, iM5129getMinHeightimpl, i2, listMo641measure0kLqBqw);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
