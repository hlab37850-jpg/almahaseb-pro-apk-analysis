package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.PN;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyStaggeredGridAnimateScrollScope implements LazyAnimateScrollScope {
    private final LazyStaggeredGridState state;

    public LazyStaggeredGridAnimateScrollScope(LazyStaggeredGridState lazyStaggeredGridState) {
        AbstractC4492zt.h(lazyStaggeredGridState, "state");
        this.state = lazyStaggeredGridState;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public float expectedDistanceTo(int i, int i2) {
        LazyStaggeredGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int iM5319getHeightimpl = 0;
        for (int i3 = 0; i3 < size; i3++) {
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = visibleItemsInfo.get(i3);
            iM5319getHeightimpl += this.state.isVertical$foundation_release() ? IntSize.m5319getHeightimpl(lazyStaggeredGridItemInfo.mo658getSizeYbymL2g()) : IntSize.m5320getWidthimpl(lazyStaggeredGridItemInfo.mo658getSizeYbymL2g());
        }
        int size2 = (iM5319getHeightimpl / visibleItemsInfo.size()) + layoutInfo.getMainAxisItemSpacing();
        int laneCount$foundation_release = (i / this.state.getLaneCount$foundation_release()) - (getFirstVisibleItemIndex() / this.state.getLaneCount$foundation_release());
        int iMin = Math.min(Math.abs(i2), size2);
        if (i2 < 0) {
            iMin *= -1;
        }
        return ((size2 * laneCount$foundation_release) + iMin) - getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public Density getDensity() {
        return this.state.getDensity$foundation_release();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getLastVisibleItemIndex() {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) AbstractC3240kc.l0(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyStaggeredGridItemInfo != null) {
            return lazyStaggeredGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getNumOfItemsForTeleport() {
        return this.state.getLaneCount$foundation_release() * 100;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public Integer getTargetItemOffset(int i) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfoFindVisibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem(this.state.getLayoutInfo(), i);
        if (lazyStaggeredGridItemInfoFindVisibleItem == null) {
            return null;
        }
        long jMo657getOffsetnOccac = lazyStaggeredGridItemInfoFindVisibleItem.mo657getOffsetnOccac();
        return Integer.valueOf(this.state.isVertical$foundation_release() ? IntOffset.m5279getYimpl(jMo657getOffsetnOccac) : IntOffset.m5278getXimpl(jMo657getOffsetnOccac));
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public Object scroll(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objE = PN.e(this.state, null, interfaceC0526Fp, interfaceC0793Of, 1, null);
        return objE == AbstractC0378Bt.d() ? objE : FW.a;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public void snapToItem(ScrollScope scrollScope, int i, int i2) {
        AbstractC4492zt.h(scrollScope, "<this>");
        this.state.snapToItemInternal$foundation_release(scrollScope, i, i2);
    }
}
