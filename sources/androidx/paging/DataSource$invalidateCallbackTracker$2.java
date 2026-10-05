package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class DataSource$invalidateCallbackTracker$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ DataSource<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataSource$invalidateCallbackTracker$2(DataSource<Key, Value> dataSource) {
        super(0);
        this.this$0 = dataSource;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.isInvalid());
    }
}
