package androidx.compose.foundation.lazy;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final LazyListState$Companion$Saver$1 INSTANCE = new LazyListState$Companion$Saver$1();

    public LazyListState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<Integer> mo13invoke(SaverScope saverScope, LazyListState lazyListState) {
        AbstractC4492zt.h(saverScope, "$this$listSaver");
        AbstractC4492zt.h(lazyListState, "it");
        return AbstractC1886cc.p(Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset()));
    }
}
