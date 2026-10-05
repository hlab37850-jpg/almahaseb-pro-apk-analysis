package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC0919Ss;
import defpackage.AbstractC2233fv;
import defpackage.C1001Vs;
import defpackage.InterfaceC3588op;
import defpackage.R5;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridState$firstVisibleItemIndex$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ LazyStaggeredGridState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridState$firstVisibleItemIndex$2(LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.this$0 = lazyStaggeredGridState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Integer invoke() {
        Integer num;
        int[] indices = this.this$0.getScrollPosition$foundation_release().getIndices();
        if (indices.length == 0) {
            num = null;
        } else {
            int i = indices[0];
            if (i == -1) {
                i = 0;
            }
            Integer numValueOf = Integer.valueOf(i);
            AbstractC0919Ss it = new C1001Vs(1, R5.N(indices)).iterator();
            while (it.hasNext()) {
                int i2 = indices[it.nextInt()];
                if (i2 == -1) {
                    i2 = 0;
                }
                Integer numValueOf2 = Integer.valueOf(i2);
                if (numValueOf.compareTo(numValueOf2) > 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        }
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }
}
