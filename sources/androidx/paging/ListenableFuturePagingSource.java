package androidx.paging;

import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC1183Zv;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ListenableFuturePagingSource<Key, Value> extends PagingSource<Key, Value> {
    public static /* synthetic */ <Key, Value> Object load$suspendImpl(ListenableFuturePagingSource<Key, Value> listenableFuturePagingSource, PagingSource.LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC1183Zv.b(listenableFuturePagingSource.loadFuture(loadParams), interfaceC0793Of);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        return load$suspendImpl(this, loadParams, interfaceC0793Of);
    }

    public abstract ListenableFuture<PagingSource.LoadResult<Key, Value>> loadFuture(PagingSource.LoadParams<Key> loadParams);
}
