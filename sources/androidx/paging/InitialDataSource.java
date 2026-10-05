package androidx.paging;

import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class InitialDataSource<K, V> extends PageKeyedDataSource<K, V> {
    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(PageKeyedDataSource.LoadParams<K> loadParams, PageKeyedDataSource.LoadCallback<K, V> loadCallback) {
        AbstractC4492zt.h(loadParams, "params");
        AbstractC4492zt.h(loadCallback, "callback");
        loadCallback.onResult(AbstractC1886cc.m(), null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(PageKeyedDataSource.LoadParams<K> loadParams, PageKeyedDataSource.LoadCallback<K, V> loadCallback) {
        AbstractC4492zt.h(loadParams, "params");
        AbstractC4492zt.h(loadCallback, "callback");
        loadCallback.onResult(AbstractC1886cc.m(), null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(PageKeyedDataSource.LoadInitialParams<K> loadInitialParams, PageKeyedDataSource.LoadInitialCallback<K, V> loadInitialCallback) {
        AbstractC4492zt.h(loadInitialParams, "params");
        AbstractC4492zt.h(loadInitialCallback, "callback");
        loadInitialCallback.onResult(AbstractC1886cc.m(), 0, 0, null, null);
    }
}
