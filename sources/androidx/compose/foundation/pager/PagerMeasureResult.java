package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC4492zt;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final PageInfo closestPageToSnapPosition;
    private final float consumedScroll;
    private final MeasuredPage firstVisiblePage;
    private final int firstVisiblePageOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final int pagesCount;
    private final boolean reverseLayout;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<PageInfo> visiblePagesInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerMeasureResult(List<? extends PageInfo> list, int i, int i2, int i3, int i4, Orientation orientation, int i5, int i6, boolean z, float f, MeasuredPage measuredPage, PageInfo pageInfo, int i7, boolean z2, MeasureResult measureResult) {
        AbstractC4492zt.h(list, "visiblePagesInfo");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(measureResult, "measureResult");
        this.visiblePagesInfo = list;
        this.pagesCount = i;
        this.pageSize = i2;
        this.pageSpacing = i3;
        this.afterContentPadding = i4;
        this.orientation = orientation;
        this.viewportStartOffset = i5;
        this.viewportEndOffset = i6;
        this.reverseLayout = z;
        this.consumedScroll = f;
        this.firstVisiblePage = measuredPage;
        this.closestPageToSnapPosition = pageInfo;
        this.firstVisiblePageOffset = i7;
        this.canScrollForward = z2;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public PageInfo getClosestPageToSnapPosition() {
        return this.closestPageToSnapPosition;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageOffset() {
        return this.firstVisiblePageOffset;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPagesCount() {
        return this.pagesCount;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo697getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List<PageInfo> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }
}
