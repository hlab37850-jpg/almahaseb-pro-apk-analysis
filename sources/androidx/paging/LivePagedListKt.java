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
public final class LivePagedListKt {
    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> factory, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, Executor executor) {
        AbstractC4492zt.h(factory, "<this>");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(executor, "fetchExecutor");
        return new LivePagedListBuilder(factory, config).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback).setFetchExecutor(executor).build();
    }

    public static /* synthetic */ LiveData toLiveData$default(DataSource.Factory factory, PagedList.Config config, Object obj, PagedList.BoundaryCallback boundaryCallback, Executor executor, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i & 8) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            AbstractC4492zt.g(executor, "getIOThreadExecutor()");
        }
        return toLiveData((DataSource.Factory<Object, Value>) factory, config, obj, boundaryCallback, executor);
    }

    public static /* synthetic */ LiveData toLiveData$default(DataSource.Factory factory, int i, Object obj, PagedList.BoundaryCallback boundaryCallback, Executor executor, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        if ((i2 & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i2 & 8) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            AbstractC4492zt.g(executor, "getIOThreadExecutor()");
        }
        return toLiveData((DataSource.Factory<Object, Value>) factory, i, obj, boundaryCallback, executor);
    }

    public static /* synthetic */ LiveData toLiveData$default(InterfaceC3588op interfaceC3588op, PagedList.Config config, Object obj, PagedList.BoundaryCallback boundaryCallback, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf, int i, Object obj2) {
        Object obj3 = (i & 2) != 0 ? null : obj;
        PagedList.BoundaryCallback boundaryCallback2 = (i & 4) != 0 ? null : boundaryCallback;
        if ((i & 8) != 0) {
            interfaceC2052dg = C3343lq.a;
        }
        InterfaceC2052dg interfaceC2052dg2 = interfaceC2052dg;
        if ((i & 16) != 0) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            AbstractC4492zt.g(iOThreadExecutor, "getIOThreadExecutor()");
            abstractC1040Xf = AbstractC1173Zl.a(iOThreadExecutor);
        }
        return toLiveData(interfaceC3588op, config, obj3, boundaryCallback2, interfaceC2052dg2, abstractC1040Xf);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> factory, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, Executor executor) {
        AbstractC4492zt.h(factory, "<this>");
        AbstractC4492zt.h(executor, "fetchExecutor");
        return new LivePagedListBuilder(factory, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null)).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback).setFetchExecutor(executor).build();
    }

    public static /* synthetic */ LiveData toLiveData$default(InterfaceC3588op interfaceC3588op, int i, Object obj, PagedList.BoundaryCallback boundaryCallback, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf, int i2, Object obj2) {
        Object obj3 = (i2 & 2) != 0 ? null : obj;
        PagedList.BoundaryCallback boundaryCallback2 = (i2 & 4) != 0 ? null : boundaryCallback;
        if ((i2 & 8) != 0) {
            interfaceC2052dg = C3343lq.a;
        }
        InterfaceC2052dg interfaceC2052dg2 = interfaceC2052dg;
        if ((i2 & 16) != 0) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            AbstractC4492zt.g(iOThreadExecutor, "getIOThreadExecutor()");
            abstractC1040Xf = AbstractC1173Zl.a(iOThreadExecutor);
        }
        return toLiveData(interfaceC3588op, i, obj3, boundaryCallback2, interfaceC2052dg2, abstractC1040Xf);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(InterfaceC3588op interfaceC3588op, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf) {
        AbstractC4492zt.h(interfaceC3588op, "<this>");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        AbstractC4492zt.h(abstractC1040Xf, "fetchDispatcher");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        AbstractC4492zt.g(mainThreadExecutor, "getMainThreadExecutor()");
        return new LivePagedList(interfaceC2052dg, key, config, boundaryCallback, interfaceC3588op, AbstractC1173Zl.a(mainThreadExecutor), abstractC1040Xf);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(InterfaceC3588op interfaceC3588op, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf) {
        AbstractC4492zt.h(interfaceC3588op, "<this>");
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        AbstractC4492zt.h(abstractC1040Xf, "fetchDispatcher");
        PagedList.Config configBuild = new PagedList.Config.Builder().setPageSize(i).build();
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        AbstractC4492zt.g(mainThreadExecutor, "getMainThreadExecutor()");
        return new LivePagedList(interfaceC2052dg, key, configBuild, boundaryCallback, interfaceC3588op, AbstractC1173Zl.a(mainThreadExecutor), abstractC1040Xf);
    }
}
