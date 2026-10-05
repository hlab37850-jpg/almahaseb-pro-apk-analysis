package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridDslKt$itemsIndexed$9$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ T[] $items;
    final /* synthetic */ InterfaceC0526Fp $span;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$itemsIndexed$9$1(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
        super(1);
        this.$span = interfaceC0526Fp;
        this.$items = tArr;
    }

    public final StaggeredGridItemSpan invoke(int i) {
        return (StaggeredGridItemSpan) this.$span.mo13invoke(Integer.valueOf(i), this.$items[i]);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
