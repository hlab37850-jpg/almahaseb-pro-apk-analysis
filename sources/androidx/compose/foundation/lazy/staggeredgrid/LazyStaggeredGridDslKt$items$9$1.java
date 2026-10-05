package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridDslKt$items$9$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ T[] $items;
    final /* synthetic */ InterfaceC3750qp $span;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$items$9$1(InterfaceC3750qp interfaceC3750qp, T[] tArr) {
        super(1);
        this.$span = interfaceC3750qp;
        this.$items = tArr;
    }

    public final StaggeredGridItemSpan invoke(int i) {
        return (StaggeredGridItemSpan) this.$span.invoke(this.$items[i]);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
