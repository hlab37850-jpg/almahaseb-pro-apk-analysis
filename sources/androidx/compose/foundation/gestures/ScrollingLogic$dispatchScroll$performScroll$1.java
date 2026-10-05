package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$dispatchScroll$performScroll$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $source;
    final /* synthetic */ ScrollScope $this_dispatchScroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$dispatchScroll$performScroll$1(ScrollingLogic scrollingLogic, int i, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$source = i;
        this.$this_dispatchScroll = scrollScope;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m2787boximpl(m355invokeMKHz9U(((Offset) obj).m2808unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
    public final long m355invokeMKHz9U(long j) {
        NestedScrollDispatcher value = this.this$0.getNestedScrollDispatcher().getValue();
        long jM3954dispatchPreScrollOzD1aCk = value.m3954dispatchPreScrollOzD1aCk(j, this.$source);
        long jM2802minusMKHz9U = Offset.m2802minusMKHz9U(j, jM3954dispatchPreScrollOzD1aCk);
        ScrollingLogic scrollingLogic = this.this$0;
        long jM348reverseIfNeededMKHz9U = scrollingLogic.m348reverseIfNeededMKHz9U(scrollingLogic.m353toOffsettuRUvjQ(this.$this_dispatchScroll.scrollBy(scrollingLogic.m352toFloatk4lQ0M(scrollingLogic.m348reverseIfNeededMKHz9U(jM2802minusMKHz9U)))));
        return Offset.m2803plusMKHz9U(Offset.m2803plusMKHz9U(jM3954dispatchPreScrollOzD1aCk, jM348reverseIfNeededMKHz9U), value.m3952dispatchPostScrollDzOQY0M(jM348reverseIfNeededMKHz9U, Offset.m2802minusMKHz9U(jM2802minusMKHz9U, jM348reverseIfNeededMKHz9U), this.$source));
    }
}
