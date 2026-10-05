package androidx.paging;

/* JADX INFO: loaded from: classes2.dex */
public interface RemoteMediatorConnection<Key, Value> {
    void allowRefresh();

    void requestLoad(LoadType loadType, PagingState<Key, Value> pagingState);

    void requestRefreshIfAllowed(PagingState<Key, Value> pagingState);

    void retryFailed(PagingState<Key, Value> pagingState);
}
