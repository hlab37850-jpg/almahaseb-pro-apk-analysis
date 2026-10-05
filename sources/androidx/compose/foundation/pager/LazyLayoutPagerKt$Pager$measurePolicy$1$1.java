package androidx.compose.foundation.pager;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPagerKt$Pager$measurePolicy$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PagerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutPagerKt$Pager$measurePolicy$1$1(PagerState pagerState) {
        super(0);
        this.$state = pagerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Integer invoke() {
        return Integer.valueOf(this.$state.getPageCount());
    }
}
