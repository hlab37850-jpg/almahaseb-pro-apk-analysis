package androidx.compose.foundation.lazy.grid;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $itemIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1(int i) {
        super(1);
        this.$itemIndex = i;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Integer invoke(LazyGridSpanLayoutProvider.Bucket bucket) {
        AbstractC4492zt.h(bucket, "it");
        return Integer.valueOf(bucket.getFirstItemIndex() - this.$itemIndex);
    }
}
