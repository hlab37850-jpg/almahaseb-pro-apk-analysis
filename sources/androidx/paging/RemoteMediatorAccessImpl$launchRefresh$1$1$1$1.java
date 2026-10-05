package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteMediatorAccessImpl$launchRefresh$1$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ RemoteMediator.MediatorResult $loadResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(RemoteMediator.MediatorResult mediatorResult) {
        super(1);
        this.$loadResult = mediatorResult;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(AccessorState<Key, Value> accessorState) {
        AbstractC4492zt.h(accessorState, "it");
        LoadType loadType = LoadType.REFRESH;
        accessorState.clearPendingRequest(loadType);
        if (((RemoteMediator.MediatorResult.Success) this.$loadResult).endOfPaginationReached()) {
            AccessorState.BlockState blockState = AccessorState.BlockState.COMPLETED;
            accessorState.setBlockState(loadType, blockState);
            accessorState.setBlockState(LoadType.PREPEND, blockState);
            accessorState.setBlockState(LoadType.APPEND, blockState);
            accessorState.clearPendingRequests();
        } else {
            LoadType loadType2 = LoadType.PREPEND;
            AccessorState.BlockState blockState2 = AccessorState.BlockState.UNBLOCKED;
            accessorState.setBlockState(loadType2, blockState2);
            accessorState.setBlockState(LoadType.APPEND, blockState2);
        }
        accessorState.setError(LoadType.PREPEND, null);
        accessorState.setError(LoadType.APPEND, null);
        return Boolean.valueOf(accessorState.getPendingBoundary() != null);
    }
}
