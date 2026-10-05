package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1 INSTANCE = new RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1();

    public RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final PagingState<Key, Value> invoke(AccessorState<Key, Value> accessorState) {
        AbstractC4492zt.h(accessorState, "it");
        return accessorState.getPendingRefresh();
    }
}
