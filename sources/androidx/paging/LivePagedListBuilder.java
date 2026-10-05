package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC1173Zl;
import defpackage.AbstractC4492zt;
import defpackage.C3343lq;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class LivePagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback<Value> boundaryCallback;
    private final PagedList.Config config;
    private InterfaceC2052dg coroutineScope;
    private final DataSource.Factory<Key, Value> dataSourceFactory;
    private AbstractC1040Xf fetchDispatcher;
    private Key initialLoadKey;
    private final InterfaceC3588op pagingSourceFactory;

    public LivePagedListBuilder(DataSource.Factory<Key, Value> factory, PagedList.Config config) {
        AbstractC4492zt.h(factory, "dataSourceFactory");
        AbstractC4492zt.h(config, "config");
        this.coroutineScope = C3343lq.a;
        Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
        AbstractC4492zt.g(iOThreadExecutor, "getIOThreadExecutor()");
        this.fetchDispatcher = AbstractC1173Zl.a(iOThreadExecutor);
        this.pagingSourceFactory = null;
        this.dataSourceFactory = factory;
        this.config = config;
    }

    private static /* synthetic */ void getBoundaryCallback$annotations() {
    }

    private static /* synthetic */ void getConfig$annotations() {
    }

    private static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public final LiveData<PagedList<Value>> build() {
        InterfaceC3588op interfaceC3588opAsPagingSourceFactory = this.pagingSourceFactory;
        if (interfaceC3588opAsPagingSourceFactory == null) {
            DataSource.Factory<Key, Value> factory = this.dataSourceFactory;
            interfaceC3588opAsPagingSourceFactory = factory != null ? factory.asPagingSourceFactory(this.fetchDispatcher) : null;
        }
        InterfaceC3588op interfaceC3588op = interfaceC3588opAsPagingSourceFactory;
        if (interfaceC3588op == null) {
            throw new IllegalStateException("LivePagedList cannot be built without a PagingSourceFactory or DataSource.Factory");
        }
        InterfaceC2052dg interfaceC2052dg = this.coroutineScope;
        Key key = this.initialLoadKey;
        PagedList.Config config = this.config;
        PagedList.BoundaryCallback<Value> boundaryCallback = this.boundaryCallback;
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        AbstractC4492zt.g(mainThreadExecutor, "getMainThreadExecutor()");
        return new LivePagedList(interfaceC2052dg, key, config, boundaryCallback, interfaceC3588op, AbstractC1173Zl.a(mainThreadExecutor), this.fetchDispatcher);
    }

    public final LivePagedListBuilder<Key, Value> setBoundaryCallback(PagedList.BoundaryCallback<Value> boundaryCallback) {
        this.boundaryCallback = boundaryCallback;
        return this;
    }

    public final LivePagedListBuilder<Key, Value> setCoroutineScope(InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        this.coroutineScope = interfaceC2052dg;
        return this;
    }

    public final LivePagedListBuilder<Key, Value> setFetchExecutor(Executor executor) {
        AbstractC4492zt.h(executor, "fetchExecutor");
        this.fetchDispatcher = AbstractC1173Zl.a(executor);
        return this;
    }

    public final LivePagedListBuilder<Key, Value> setInitialLoadKey(Key key) {
        this.initialLoadKey = key;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePagedListBuilder(DataSource.Factory<Key, Value> factory, int i) {
        this(factory, new PagedList.Config.Builder().setPageSize(i).build());
        AbstractC4492zt.h(factory, "dataSourceFactory");
    }

    public LivePagedListBuilder(InterfaceC3588op interfaceC3588op, PagedList.Config config) {
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
        AbstractC4492zt.h(config, "config");
        this.coroutineScope = C3343lq.a;
        Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
        AbstractC4492zt.g(iOThreadExecutor, "getIOThreadExecutor()");
        this.fetchDispatcher = AbstractC1173Zl.a(iOThreadExecutor);
        this.pagingSourceFactory = interfaceC3588op;
        this.dataSourceFactory = null;
        this.config = config;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePagedListBuilder(InterfaceC3588op interfaceC3588op, int i) {
        this(interfaceC3588op, new PagedList.Config.Builder().setPageSize(i).build());
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
    }
}
