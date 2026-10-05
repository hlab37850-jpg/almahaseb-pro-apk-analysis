package androidx.paging;

import defpackage.AbstractC1040Xf;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class DataSource$Factory$asPagingSourceFactory$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AbstractC1040Xf $fetchDispatcher;
    final /* synthetic */ DataSource.Factory<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataSource$Factory$asPagingSourceFactory$1(AbstractC1040Xf abstractC1040Xf, DataSource.Factory<Key, Value> factory) {
        super(0);
        this.$fetchDispatcher = abstractC1040Xf;
        this.this$0 = factory;
    }

    @Override // defpackage.InterfaceC3588op
    public final PagingSource<Key, Value> invoke() {
        return new LegacyPagingSource(this.$fetchDispatcher, this.this$0.create());
    }
}
