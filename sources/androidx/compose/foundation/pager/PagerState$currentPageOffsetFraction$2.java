package androidx.compose.foundation.pager;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PagerState$currentPageOffsetFraction$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$currentPageOffsetFraction$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        PageInfo pageInfo;
        List<PageInfo> visiblePagesInfo = this.this$0.getLayoutInfo$foundation_release().getVisiblePagesInfo();
        PagerState pagerState = this.this$0;
        int size = visiblePagesInfo.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                pageInfo = null;
                break;
            }
            pageInfo = visiblePagesInfo.get(i);
            if (pageInfo.getIndex() == pagerState.getCurrentPage()) {
                break;
            }
            i++;
        }
        PageInfo pageInfo2 = pageInfo;
        int offset = pageInfo2 != null ? pageInfo2.getOffset() : 0;
        float pageAvailableSpace = this.this$0.getPageAvailableSpace();
        return Float.valueOf(pageAvailableSpace == 0.0f ? this.this$0.getInitialPageOffsetFraction() : AbstractC3871sJ.k((-offset) / pageAvailableSpace, -0.5f, 0.5f));
    }
}
