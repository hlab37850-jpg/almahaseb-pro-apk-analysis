package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final LazyStaggeredGridState$Companion$Saver$1 INSTANCE = new LazyStaggeredGridState$Companion$Saver$1();

    public LazyStaggeredGridState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<int[]> mo13invoke(SaverScope saverScope, LazyStaggeredGridState lazyStaggeredGridState) {
        AbstractC4492zt.h(saverScope, "$this$listSaver");
        AbstractC4492zt.h(lazyStaggeredGridState, "state");
        return AbstractC1886cc.p(lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices(), lazyStaggeredGridState.getScrollPosition$foundation_release().getOffsets());
    }
}
