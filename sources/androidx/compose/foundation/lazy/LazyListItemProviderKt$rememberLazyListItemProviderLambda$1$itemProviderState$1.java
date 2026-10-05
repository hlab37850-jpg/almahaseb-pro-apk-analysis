package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$itemProviderState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<LazyListIntervalContent> $intervalContentState;
    final /* synthetic */ LazyItemScopeImpl $scope;
    final /* synthetic */ LazyListState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$itemProviderState$1(State<LazyListIntervalContent> state, LazyListState lazyListState, LazyItemScopeImpl lazyItemScopeImpl) {
        super(0);
        this.$intervalContentState = state;
        this.$state = lazyListState;
        this.$scope = lazyItemScopeImpl;
    }

    @Override // defpackage.InterfaceC3588op
    public final LazyListItemProviderImpl invoke() {
        LazyListIntervalContent value = this.$intervalContentState.getValue();
        return new LazyListItemProviderImpl(this.$state, value, this.$scope, new NearestRangeKeyIndexMap(this.$state.getNearestRange$foundation_release(), value));
    }
}
