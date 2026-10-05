package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.paging.PositionalDataSource;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
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
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {
    public static final Companion Companion = new Companion(null);
    private final boolean isContiguous;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final int computeInitialLoadPosition(LoadInitialParams loadInitialParams, int i) {
            AbstractC4492zt.h(loadInitialParams, "params");
            int i2 = loadInitialParams.requestedStartPosition;
            int i3 = loadInitialParams.requestedLoadSize;
            int i4 = loadInitialParams.pageSize;
            return Math.max(0, Math.min(((((i - i3) + i4) - 1) / i4) * i4, (i2 / i4) * i4));
        }

        public final int computeInitialLoadSize(LoadInitialParams loadInitialParams, int i, int i2) {
            AbstractC4492zt.h(loadInitialParams, "params");
            return Math.min(i2 - i, loadInitialParams.requestedLoadSize);
        }

        private Companion() {
        }
    }

    public static abstract class LoadInitialCallback<T> {
        public abstract void onResult(List<? extends T> list, int i);

        public abstract void onResult(List<? extends T> list, int i, int i2);
    }

    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int i, int i2, int i3, boolean z) {
            this.requestedStartPosition = i;
            this.requestedLoadSize = i2;
            this.pageSize = i3;
            this.placeholdersEnabled = z;
            if (i < 0) {
                throw new IllegalStateException(("invalid start position: " + i).toString());
            }
            if (i2 < 0) {
                throw new IllegalStateException(("invalid load size: " + i2).toString());
            }
            if (i3 >= 0) {
                return;
            }
            throw new IllegalStateException(("invalid page size: " + i3).toString());
        }
    }

    public static abstract class LoadRangeCallback<T> {
        public abstract void onResult(List<? extends T> list);
    }

    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int i, int i2) {
            this.startPosition = i;
            this.loadSize = i2;
        }
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    public static final int computeInitialLoadPosition(LoadInitialParams loadInitialParams, int i) {
        return Companion.computeInitialLoadPosition(loadInitialParams, i);
    }

    public static final int computeInitialLoadSize(LoadInitialParams loadInitialParams, int i, int i2) {
        return Companion.computeInitialLoadSize(loadInitialParams, i, i2);
    }

    public static /* synthetic */ void isContiguous$paging_common$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadRange(final LoadRangeParams loadRangeParams, InterfaceC0793Of interfaceC0793Of) {
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadRange(loadRangeParams, new LoadRangeCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadRange$2$1
            @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
            public void onResult(List<? extends T> list) {
                AbstractC4492zt.h(list, "data");
                int i = loadRangeParams.startPosition;
                Integer numValueOf = i == 0 ? null : Integer.valueOf(i);
                if (this.isInvalid()) {
                    InterfaceC4293xa interfaceC4293xa = c4374ya;
                    KL.a aVar = KL.a;
                    interfaceC4293xa.resumeWith(KL.a(DataSource.BaseResult.Companion.empty$paging_common()));
                } else {
                    InterfaceC4293xa interfaceC4293xa2 = c4374ya;
                    KL.a aVar2 = KL.a;
                    interfaceC4293xa2.resumeWith(KL.a(new DataSource.BaseResult(list, numValueOf, Integer.valueOf(loadRangeParams.startPosition + list.size()), 0, 0, 24, null)));
                }
            }
        });
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List map$lambda$4(Function function, List list) {
        AbstractC4492zt.h(function, "$function");
        AbstractC4492zt.g(list, "list");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(function.apply(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List map$lambda$5(InterfaceC3750qp interfaceC3750qp, List list) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(list, "list");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(interfaceC3750qp.invoke(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List mapByPage$lambda$2(InterfaceC3750qp interfaceC3750qp, List list) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(list, "it");
        return (List) interfaceC3750qp.invoke(list);
    }

    @Override // androidx.paging.DataSource
    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Integer> params, InterfaceC0793Of interfaceC0793Of) {
        if (params.getType$paging_common() != LoadType.REFRESH) {
            Integer key = params.getKey();
            AbstractC4492zt.e(key);
            int iIntValue = key.intValue();
            int pageSize = params.getPageSize();
            if (params.getType$paging_common() == LoadType.PREPEND) {
                pageSize = Math.min(pageSize, iIntValue);
                iIntValue -= pageSize;
            }
            return loadRange(new LoadRangeParams(iIntValue, pageSize), interfaceC0793Of);
        }
        int initialLoadSize = params.getInitialLoadSize();
        int iMax = 0;
        if (params.getKey() != null) {
            int iIntValue2 = params.getKey().intValue();
            if (params.getPlaceholdersEnabled()) {
                initialLoadSize = Math.max(initialLoadSize / params.getPageSize(), 2) * params.getPageSize();
                iMax = Math.max(0, ((iIntValue2 - (initialLoadSize / 2)) / params.getPageSize()) * params.getPageSize());
            } else {
                iMax = Math.max(0, iIntValue2 - (initialLoadSize / 2));
            }
        }
        return loadInitial$paging_common(new LoadInitialParams(iMax, initialLoadSize, params.getPageSize(), params.getPlaceholdersEnabled()), interfaceC0793Of);
    }

    @WorkerThread
    public abstract void loadInitial(LoadInitialParams loadInitialParams, LoadInitialCallback<T> loadInitialCallback);

    @VisibleForTesting
    public final Object loadInitial$paging_common(final LoadInitialParams loadInitialParams, InterfaceC0793Of interfaceC0793Of) {
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadInitial(loadInitialParams, new LoadInitialCallback<T>(this) { // from class: androidx.paging.PositionalDataSource$loadInitial$2$1
            final /* synthetic */ PositionalDataSource<T> this$0;

            {
                this.this$0 = this;
            }

            private final void resume(PositionalDataSource.LoadInitialParams loadInitialParams2, DataSource.BaseResult<T> baseResult) {
                if (loadInitialParams2.placeholdersEnabled) {
                    baseResult.validateForInitialTiling$paging_common(loadInitialParams2.pageSize);
                }
                c4374ya.resumeWith(KL.a(baseResult));
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends T> list, int i, int i2) {
                AbstractC4492zt.h(list, "data");
                if (!this.this$0.isInvalid()) {
                    int size = list.size() + i;
                    resume(loadInitialParams, new DataSource.BaseResult<>(list, i == 0 ? null : Integer.valueOf(i), size == i2 ? null : Integer.valueOf(size), i, (i2 - list.size()) - i));
                } else {
                    InterfaceC4293xa interfaceC4293xa = c4374ya;
                    KL.a aVar = KL.a;
                    interfaceC4293xa.resumeWith(KL.a(DataSource.BaseResult.Companion.empty$paging_common()));
                }
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends T> list, int i) {
                AbstractC4492zt.h(list, "data");
                if (this.this$0.isInvalid()) {
                    InterfaceC4293xa interfaceC4293xa = c4374ya;
                    KL.a aVar = KL.a;
                    interfaceC4293xa.resumeWith(KL.a(DataSource.BaseResult.Companion.empty$paging_common()));
                    return;
                }
                resume(loadInitialParams, new DataSource.BaseResult<>(list, i == 0 ? null : Integer.valueOf(i), Integer.valueOf(list.size() + i), i, Integer.MIN_VALUE));
            }
        });
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    @WorkerThread
    public abstract void loadRange(LoadRangeParams loadRangeParams, LoadRangeCallback<T> loadRangeCallback);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.DataSource
    public final Integer getKeyInternal$paging_common(T t) {
        AbstractC4492zt.h(t, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(final Function<T, V> function) {
        AbstractC4492zt.h(function, "function");
        return mapByPage((Function) new Function() { // from class: XG
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PositionalDataSource.map$lambda$4(function, (List) obj);
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(Function<List<T>, List<V>> function) {
        AbstractC4492zt.h(function, "function");
        return new WrapperPositionalDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage((Function) new Function() { // from class: YG
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PositionalDataSource.map$lambda$5(interfaceC3750qp, (List) obj);
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage((Function) new Function() { // from class: WG
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PositionalDataSource.mapByPage$lambda$2(interfaceC3750qp, (List) obj);
            }
        });
    }
}
