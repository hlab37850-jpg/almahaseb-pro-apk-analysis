package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PagerScrollPosition {
    private final MutableIntState currentPage$delegate;
    private final MutableIntState firstVisiblePage$delegate;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownFirstPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    /* JADX WARN: Illegal instructions before constructor call */
    public PagerScrollPosition() {
        int i = 0;
        this(i, i, 3, null);
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setIntValue(i);
    }

    private final void update(int i, int i2) {
        if (i >= 0.0f) {
            setFirstVisiblePage(i);
            this.nearestRangeState.update(i);
            setScrollOffset(i2);
        } else {
            throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
        }
    }

    public final int getCurrentPage() {
        return this.currentPage$delegate.getIntValue();
    }

    public final int getFirstVisiblePage() {
        return this.firstVisiblePage$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final void requestPosition(int i, int i2) {
        update(i, i2);
        this.lastKnownFirstPageKey = null;
    }

    public final void setCurrentPage(int i) {
        this.currentPage$delegate.setIntValue(i);
    }

    public final void setFirstVisiblePage(int i) {
        this.firstVisiblePage$delegate.setIntValue(i);
    }

    public final void updateFromMeasureResult(PagerMeasureResult pagerMeasureResult) {
        AbstractC4492zt.h(pagerMeasureResult, "measureResult");
        MeasuredPage firstVisiblePage = pagerMeasureResult.getFirstVisiblePage();
        this.lastKnownFirstPageKey = firstVisiblePage != null ? firstVisiblePage.getKey() : null;
        if (this.hadFirstNotEmptyLayout || pagerMeasureResult.getPagesCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisiblePageOffset = pagerMeasureResult.getFirstVisiblePageOffset();
            if (firstVisiblePageOffset < 0.0f) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisiblePageOffset + ')').toString());
            }
            MeasuredPage firstVisiblePage2 = pagerMeasureResult.getFirstVisiblePage();
            update(firstVisiblePage2 != null ? firstVisiblePage2.getIndex() : 0, firstVisiblePageOffset);
            PageInfo closestPageToSnapPosition = pagerMeasureResult.getClosestPageToSnapPosition();
            if (closestPageToSnapPosition != null) {
                setCurrentPage(closestPageToSnapPosition.getIndex());
            }
        }
    }

    public PagerScrollPosition(int i, int i2) {
        this.firstVisiblePage$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.currentPage$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(i2);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }

    public /* synthetic */ PagerScrollPosition(int i, int i2, int i3, AbstractC0419Di abstractC0419Di) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
