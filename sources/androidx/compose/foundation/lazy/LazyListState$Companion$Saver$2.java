package androidx.compose.foundation.lazy;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final LazyListState$Companion$Saver$2 INSTANCE = new LazyListState$Companion$Saver$2();

    public LazyListState$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final LazyListState invoke(List<Integer> list) {
        AbstractC4492zt.h(list, "it");
        return new LazyListState(list.get(0).intValue(), list.get(1).intValue());
    }
}
