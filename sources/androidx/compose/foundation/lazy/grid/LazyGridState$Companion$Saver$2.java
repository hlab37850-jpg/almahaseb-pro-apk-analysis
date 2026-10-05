package androidx.compose.foundation.lazy.grid;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final LazyGridState$Companion$Saver$2 INSTANCE = new LazyGridState$Companion$Saver$2();

    public LazyGridState$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final LazyGridState invoke(List<Integer> list) {
        AbstractC4492zt.h(list, "it");
        return new LazyGridState(list.get(0).intValue(), list.get(1).intValue());
    }
}
