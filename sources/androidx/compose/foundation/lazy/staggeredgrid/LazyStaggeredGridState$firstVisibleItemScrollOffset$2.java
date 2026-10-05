package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridState$firstVisibleItemScrollOffset$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ LazyStaggeredGridState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridState$firstVisibleItemScrollOffset$2(LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.this$0 = lazyStaggeredGridState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Integer invoke() {
        int[] offsets = this.this$0.getScrollPosition$foundation_release().getOffsets();
        LazyStaggeredGridState lazyStaggeredGridState = this.this$0;
        int firstVisibleItemIndex = lazyStaggeredGridState.getFirstVisibleItemIndex();
        int[] indices = lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices();
        int length = offsets.length;
        int iMin = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (indices[i] == firstVisibleItemIndex) {
                iMin = Math.min(iMin, offsets[i]);
            }
        }
        return Integer.valueOf(iMin != Integer.MAX_VALUE ? iMin : 0);
    }
}
