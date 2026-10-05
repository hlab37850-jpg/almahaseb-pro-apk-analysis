package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticStateKt {
    public static final LazyLayoutSemanticState LazyLayoutSemanticState(final PagerState pagerState, final boolean z) {
        AbstractC4492zt.h(pagerState, "state");
        return new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.pager.LazyLayoutSemanticStateKt.LazyLayoutSemanticState.1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public Object animateScrollBy(float f, InterfaceC0793Of interfaceC0793Of) {
                Object objAnimateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(pagerState, f, null, interfaceC0793Of, 2, null);
                return objAnimateScrollBy$default == AbstractC0378Bt.d() ? objAnimateScrollBy$default : FW.a;
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public CollectionInfo collectionInfo() {
                return z ? new CollectionInfo(-1, 1) : new CollectionInfo(1, -1);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public boolean getCanScrollForward() {
                return pagerState.getCanScrollForward();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public float getCurrentPosition() {
                return pagerState.getFirstVisiblePage$foundation_release() + (pagerState.getFirstVisiblePageOffset$foundation_release() / 100000.0f);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public Object scrollToItem(int i, InterfaceC0793Of interfaceC0793Of) {
                Object objScrollToPage$default = PagerState.scrollToPage$default(pagerState, i, 0.0f, interfaceC0793Of, 2, null);
                return objScrollToPage$default == AbstractC0378Bt.d() ? objScrollToPage$default : FW.a;
            }
        };
    }
}
