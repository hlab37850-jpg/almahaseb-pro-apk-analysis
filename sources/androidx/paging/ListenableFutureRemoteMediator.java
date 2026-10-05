package androidx.paging;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC1183Zv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalPagingApi
public abstract class ListenableFutureRemoteMediator<Key, Value> extends RemoteMediator<Key, Value> {
    @Override // androidx.paging.RemoteMediator
    public final Object initialize(InterfaceC0793Of interfaceC0793Of) {
        return AbstractC1183Zv.b(initializeFuture(), interfaceC0793Of);
    }

    public ListenableFuture<RemoteMediator.InitializeAction> initializeFuture() {
        ListenableFuture<RemoteMediator.InitializeAction> listenableFutureImmediateFuture = Futures.immediateFuture(RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH);
        AbstractC4492zt.g(listenableFutureImmediateFuture, "immediateFuture(LAUNCH_INITIAL_REFRESH)");
        return listenableFutureImmediateFuture;
    }

    @Override // androidx.paging.RemoteMediator
    public final Object load(LoadType loadType, PagingState<Key, Value> pagingState, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC1183Zv.b(loadFuture(loadType, pagingState), interfaceC0793Of);
    }

    public abstract ListenableFuture<RemoteMediator.MediatorResult> loadFuture(LoadType loadType, PagingState<Key, Value> pagingState);
}
