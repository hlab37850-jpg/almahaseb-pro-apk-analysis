package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridSpanProvider {
    private final IntervalList<LazyStaggeredGridInterval> intervals;

    public LazyStaggeredGridSpanProvider(IntervalList<LazyStaggeredGridInterval> intervalList) {
        AbstractC4492zt.h(intervalList, "intervals");
        this.intervals = intervalList;
    }

    public final IntervalList<LazyStaggeredGridInterval> getIntervals() {
        return this.intervals;
    }

    public final boolean isFullSpan(int i) {
        if (i < 0 || i >= this.intervals.getSize()) {
            return false;
        }
        IntervalList.Interval<LazyStaggeredGridInterval> interval = this.intervals.get(i);
        InterfaceC3750qp span = interval.getValue().getSpan();
        return span != null && span.invoke(Integer.valueOf(i - interval.getStartIndex())) == StaggeredGridItemSpan.Companion.getFullLine();
    }
}
