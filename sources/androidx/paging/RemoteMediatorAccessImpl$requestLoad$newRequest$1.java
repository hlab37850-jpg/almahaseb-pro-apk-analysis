package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteMediatorAccessImpl$requestLoad$newRequest$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ LoadType $loadType;
    final /* synthetic */ PagingState<Key, Value> $pagingState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$requestLoad$newRequest$1(LoadType loadType, PagingState<Key, Value> pagingState) {
        super(1);
        this.$loadType = loadType;
        this.$pagingState = pagingState;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(AccessorState<Key, Value> accessorState) {
        AbstractC4492zt.h(accessorState, "it");
        return Boolean.valueOf(accessorState.add(this.$loadType, this.$pagingState));
    }
}
