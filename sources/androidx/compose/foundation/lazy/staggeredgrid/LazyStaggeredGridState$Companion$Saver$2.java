package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final LazyStaggeredGridState$Companion$Saver$2 INSTANCE = new LazyStaggeredGridState$Companion$Saver$2();

    public LazyStaggeredGridState$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final LazyStaggeredGridState invoke(List<int[]> list) {
        AbstractC4492zt.h(list, "it");
        return new LazyStaggeredGridState(list.get(0), list.get(1), null);
    }
}
