package androidx.paging;

import androidx.annotation.RestrictTo;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingSourceKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <Key> PagingSource.LoadParams<Key> toRefreshLoadParams(PagedList.Config config, Key key) {
        AbstractC4492zt.h(config, "<this>");
        return new PagingSource.LoadParams.Refresh(key, config.initialLoadSizeHint, config.enablePlaceholders);
    }
}
