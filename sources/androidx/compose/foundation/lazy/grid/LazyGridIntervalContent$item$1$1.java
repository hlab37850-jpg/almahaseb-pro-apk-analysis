package androidx.compose.foundation.lazy.grid;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridIntervalContent$item$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Object $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyGridIntervalContent$item$1$1(Object obj) {
        super(1);
        this.$key = obj;
    }

    public final Object invoke(int i) {
        return this.$key;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
