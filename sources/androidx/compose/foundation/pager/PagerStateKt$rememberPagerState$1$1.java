package androidx.compose.foundation.pager;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class PagerStateKt$rememberPagerState$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ int $initialPage;
    final /* synthetic */ float $initialPageOffsetFraction;
    final /* synthetic */ InterfaceC3588op $pageCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerStateKt$rememberPagerState$1$1(int i, float f, InterfaceC3588op interfaceC3588op) {
        super(0);
        this.$initialPage = i;
        this.$initialPageOffsetFraction = f;
        this.$pageCount = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3588op
    public final PagerStateImpl invoke() {
        return new PagerStateImpl(this.$initialPage, this.$initialPageOffsetFraction, this.$pageCount);
    }
}
