package androidx.paging;

import defpackage.AbstractC4492zt;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class PagedListKt {
    public static final /* synthetic */ PagedList PagedList(DataSource dataSource, PagedList.Config config, Executor executor, Executor executor2, PagedList.BoundaryCallback boundaryCallback, Object obj) {
        AbstractC4492zt.h(dataSource, "dataSource");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(executor, "notifyExecutor");
        AbstractC4492zt.h(executor2, "fetchExecutor");
        return new PagedList.Builder(dataSource, config).setNotifyExecutor(executor).setFetchExecutor(executor2).setBoundaryCallback(boundaryCallback).setInitialKey(obj).build();
    }
}
