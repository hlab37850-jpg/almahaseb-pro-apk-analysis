package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridDslKt$itemsIndexed$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<T> $items;
    final /* synthetic */ InterfaceC0526Fp $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$itemsIndexed$2$1(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
        super(1);
        this.$key = interfaceC0526Fp;
        this.$items = list;
    }

    public final Object invoke(int i) {
        return this.$key.mo13invoke(Integer.valueOf(i), this.$items.get(i));
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
