package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticStateKt {
    public static final LazyLayoutSemanticState LazyLayoutSemanticState(final LazyListState lazyListState, final boolean z) {
        AbstractC4492zt.h(lazyListState, "state");
        return new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt.LazyLayoutSemanticState.1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public Object animateScrollBy(float f, InterfaceC0793Of interfaceC0793Of) {
                Object objAnimateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(lazyListState, f, null, interfaceC0793Of, 2, null);
                return objAnimateScrollBy$default == AbstractC0378Bt.d() ? objAnimateScrollBy$default : FW.a;
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public CollectionInfo collectionInfo() {
                return z ? new CollectionInfo(-1, 1) : new CollectionInfo(1, -1);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public boolean getCanScrollForward() {
                return lazyListState.getCanScrollForward();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public float getCurrentPosition() {
                return lazyListState.getFirstVisibleItemIndex() + (lazyListState.getFirstVisibleItemScrollOffset() / 100000.0f);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public Object scrollToItem(int i, InterfaceC0793Of interfaceC0793Of) {
                Object objScrollToItem$default = LazyListState.scrollToItem$default(lazyListState, i, 0, interfaceC0793Of, 2, null);
                return objScrollToItem$default == AbstractC0378Bt.d() ? objScrollToItem$default : FW.a;
            }
        };
    }
}
