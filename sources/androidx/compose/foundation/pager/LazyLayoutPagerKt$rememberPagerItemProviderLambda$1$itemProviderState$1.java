package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<PagerLayoutIntervalContent> $intervalContentState;
    final /* synthetic */ PagerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1(State<PagerLayoutIntervalContent> state, PagerState pagerState) {
        super(0);
        this.$intervalContentState = state;
        this.$state = pagerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final PagerLazyLayoutItemProvider invoke() {
        PagerLayoutIntervalContent value = this.$intervalContentState.getValue();
        return new PagerLazyLayoutItemProvider(this.$state, value, new NearestRangeKeyIndexMap(this.$state.getNearestRange$foundation_release(), value));
    }
}
