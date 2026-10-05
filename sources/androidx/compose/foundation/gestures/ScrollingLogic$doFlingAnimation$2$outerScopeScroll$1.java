package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(ScrollingLogic scrollingLogic, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$$this$scroll = scrollScope;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m2787boximpl(m356invokeMKHz9U(((Offset) obj).m2808unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
    public final long m356invokeMKHz9U(long j) {
        ScrollingLogic scrollingLogic = this.this$0;
        return scrollingLogic.m348reverseIfNeededMKHz9U(scrollingLogic.m344dispatchScroll3eAAhYA(this.$$this$scroll, scrollingLogic.m348reverseIfNeededMKHz9U(j), NestedScrollSource.Companion.m3964getFlingWNlRxjI()));
    }
}
