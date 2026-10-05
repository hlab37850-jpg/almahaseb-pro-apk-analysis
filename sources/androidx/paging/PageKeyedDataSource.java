package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.PageKeyedDataSource;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {
    private final boolean supportsPageDropping;

    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(List<? extends Value> list, Key key);
    }

    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(List<? extends Value> list, int i, int i2, Key key, Key key2);

        public abstract void onResult(List<? extends Value> list, Key key, Key key2);
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int i, boolean z) {
            this.requestedLoadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key, int i) {
            AbstractC4492zt.h(key, "key");
            this.key = key;
            this.requestedLoadSize = i;
        }
    }

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadCallback<Key, Value> continuationAsCallback(final InterfaceC4293xa interfaceC4293xa, final boolean z) {
        return new LoadCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource.continuationAsCallback.1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> list, Key key) {
                AbstractC4492zt.h(list, "data");
                InterfaceC4293xa interfaceC4293xa2 = interfaceC4293xa;
                KL.a aVar = KL.a;
                boolean z2 = z;
                interfaceC4293xa2.resumeWith(KL.a(new DataSource.BaseResult(list, z2 ? null : key, z2 ? key : null, 0, 0, 24, null)));
            }
        };
    }

    public static /* synthetic */ void getSupportsPageDropping$paging_common$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAfter(LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadAfter(loadParams, continuationAsCallback(c4374ya, true));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadBefore(LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadBefore(loadParams, continuationAsCallback(c4374ya, false));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadInitial(LoadInitialParams<Key> loadInitialParams, InterfaceC0793Of interfaceC0793Of) {
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadInitial(loadInitialParams, new LoadInitialCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$loadInitial$2$1
            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> list, int i, int i2, Key key, Key key2) {
                AbstractC4492zt.h(list, "data");
                InterfaceC4293xa interfaceC4293xa = c4374ya;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(new DataSource.BaseResult(list, key, key2, i, (i2 - list.size()) - i)));
            }

            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> list, Key key, Key key2) {
                AbstractC4492zt.h(list, "data");
                InterfaceC4293xa interfaceC4293xa = c4374ya;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(new DataSource.BaseResult(list, key, key2, 0, 0, 24, null)));
            }
        });
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List map$lambda$5(Function function, List list) {
        AbstractC4492zt.h(function, "$function");
        AbstractC4492zt.g(list, "list");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(function.apply(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List map$lambda$6(InterfaceC3750qp interfaceC3750qp, List list) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(list, "list");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(interfaceC3750qp.invoke(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List mapByPage$lambda$3(InterfaceC3750qp interfaceC3750qp, List list) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(list, "it");
        return (List) interfaceC3750qp.invoke(list);
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(Value value) {
        AbstractC4492zt.h(value, "item");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    @Override // androidx.paging.DataSource
    public boolean getSupportsPageDropping$paging_common() {
        return this.supportsPageDropping;
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Key> params, InterfaceC0793Of interfaceC0793Of) {
        if (params.getType$paging_common() == LoadType.REFRESH) {
            return loadInitial(new LoadInitialParams<>(params.getInitialLoadSize(), params.getPlaceholdersEnabled()), interfaceC0793Of);
        }
        if (params.getKey() == null) {
            return DataSource.BaseResult.Companion.empty$paging_common();
        }
        if (params.getType$paging_common() == LoadType.PREPEND) {
            return loadBefore(new LoadParams<>(params.getKey(), params.getPageSize()), interfaceC0793Of);
        }
        if (params.getType$paging_common() == LoadType.APPEND) {
            return loadAfter(new LoadParams<>(params.getKey(), params.getPageSize()), interfaceC0793Of);
        }
        throw new IllegalArgumentException("Unsupported type " + params.getType$paging_common());
    }

    public abstract void loadAfter(LoadParams<Key> loadParams, LoadCallback<Key, Value> loadCallback);

    public abstract void loadBefore(LoadParams<Key> loadParams, LoadCallback<Key, Value> loadCallback);

    public abstract void loadInitial(LoadInitialParams<Key> loadInitialParams, LoadInitialCallback<Key, Value> loadInitialCallback);

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        AbstractC4492zt.h(function, "function");
        return mapByPage((Function) new Function() { // from class: YF
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PageKeyedDataSource.map$lambda$5(function, (List) obj);
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        AbstractC4492zt.h(function, "function");
        return new WrapperPageKeyedDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage((Function) new Function() { // from class: aG
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PageKeyedDataSource.map$lambda$6(interfaceC3750qp, (List) obj);
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage((Function) new Function() { // from class: ZF
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PageKeyedDataSource.mapByPage$lambda$3(interfaceC3750qp, (List) obj);
            }
        });
    }
}
