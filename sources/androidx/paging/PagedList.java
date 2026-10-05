package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC1173Zl;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.C3343lq;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;
import defpackage.N8;
import defpackage.O8;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PagedList<T> extends AbstractList<T> {
    public static final Companion Companion = new Companion(null);
    private final List<WeakReference<Callback>> callbacks;
    private final Config config;
    private final InterfaceC2052dg coroutineScope;
    private final List<WeakReference<InterfaceC0526Fp>> loadStateListeners;
    private final AbstractC1040Xf notifyDispatcher;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private final PagingSource<?, T> pagingSource;
    private Runnable refreshRetryCallback;
    private final int requiredRemainder;
    private final PagedStorage<T> storage;

    @MainThread
    public static abstract class BoundaryCallback<T> {
        public void onItemAtEndLoaded(T t) {
            AbstractC4492zt.h(t, "itemAtEnd");
        }

        public void onItemAtFrontLoaded(T t) {
            AbstractC4492zt.h(t, "itemAtFront");
        }

        public void onZeroItemsLoaded() {
        }
    }

    public static abstract class Callback {
        public abstract void onChanged(int i, int i2);

        public abstract void onInserted(int i, int i2);

        public abstract void onRemoved(int i, int i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <K, T> PagedList<T> create(PagingSource<K, T> pagingSource, PagingSource.LoadResult.Page<K, T> page, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2, BoundaryCallback<T> boundaryCallback, Config config, K k) {
            AbstractC4492zt.h(pagingSource, "pagingSource");
            AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
            AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
            AbstractC4492zt.h(abstractC1040Xf2, "fetchDispatcher");
            AbstractC4492zt.h(config, "config");
            return new ContiguousPagedList(pagingSource, interfaceC2052dg, abstractC1040Xf, abstractC1040Xf2, boundaryCallback, config, page == null ? (PagingSource.LoadResult.Page) N8.b(null, new PagedList$Companion$create$resolvedInitialPage$1(pagingSource, new PagingSource.LoadParams.Refresh(k, config.initialLoadSizeHint, config.enablePlaceholders), null), 1, null) : page, k);
        }

        public final void dispatchNaiveUpdatesSinceSnapshot$paging_common(int i, int i2, Callback callback) {
            AbstractC4492zt.h(callback, "callback");
            if (i2 < i) {
                if (i2 > 0) {
                    callback.onChanged(0, i2);
                }
                int i3 = i - i2;
                if (i3 > 0) {
                    callback.onInserted(i2, i3);
                    return;
                }
                return;
            }
            if (i > 0) {
                callback.onChanged(0, i);
            }
            int i4 = i2 - i;
            if (i4 != 0) {
                callback.onRemoved(i, i4);
            }
        }

        private Companion() {
        }
    }

    public static final class Config {
        public static final Companion Companion = new Companion(null);
        public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
        public final boolean enablePlaceholders;
        public final int initialLoadSizeHint;
        public final int maxSize;
        public final int pageSize;
        public final int prefetchDistance;

        public static final class Builder {
            public static final Companion Companion = new Companion(null);
            public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
            private int pageSize = -1;
            private int prefetchDistance = -1;
            private int initialLoadSizeHint = -1;
            private boolean enablePlaceholders = true;
            private int maxSize = Integer.MAX_VALUE;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                    this();
                }

                private Companion() {
                }
            }

            public final Config build() {
                if (this.prefetchDistance < 0) {
                    this.prefetchDistance = this.pageSize;
                }
                if (this.initialLoadSizeHint < 0) {
                    this.initialLoadSizeHint = this.pageSize * 3;
                }
                if (!this.enablePlaceholders && this.prefetchDistance == 0) {
                    throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
                }
                int i = this.maxSize;
                if (i == Integer.MAX_VALUE || i >= this.pageSize + (this.prefetchDistance * 2)) {
                    return new Config(this.pageSize, this.prefetchDistance, this.enablePlaceholders, this.initialLoadSizeHint, this.maxSize);
                }
                throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + this.pageSize + ", prefetchDist=" + this.prefetchDistance + ", maxSize=" + this.maxSize);
            }

            public final Builder setEnablePlaceholders(boolean z) {
                this.enablePlaceholders = z;
                return this;
            }

            public final Builder setInitialLoadSizeHint(@IntRange(from = 1) int i) {
                this.initialLoadSizeHint = i;
                return this;
            }

            public final Builder setMaxSize(@IntRange(from = 2) int i) {
                this.maxSize = i;
                return this;
            }

            public final Builder setPageSize(@IntRange(from = 1) int i) {
                if (i < 1) {
                    throw new IllegalArgumentException("Page size must be a positive number");
                }
                this.pageSize = i;
                return this;
            }

            public final Builder setPrefetchDistance(@IntRange(from = 0) int i) {
                this.prefetchDistance = i;
                return this;
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
            }

            private Companion() {
            }
        }

        public Config(int i, int i2, boolean z, int i3, int i4) {
            this.pageSize = i;
            this.prefetchDistance = i2;
            this.enablePlaceholders = z;
            this.initialLoadSizeHint = i3;
            this.maxSize = i4;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class LoadStateManager {
        private LoadState endState;
        private LoadState refreshState;
        private LoadState startState;

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LoadType.values().length];
                try {
                    iArr[LoadType.REFRESH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LoadType.PREPEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LoadType.APPEND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public LoadStateManager() {
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
            this.refreshState = companion.getIncomplete$paging_common();
            this.startState = companion.getIncomplete$paging_common();
            this.endState = companion.getIncomplete$paging_common();
        }

        public final void dispatchCurrentLoadState(InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, "callback");
            interfaceC0526Fp.mo13invoke(LoadType.REFRESH, this.refreshState);
            interfaceC0526Fp.mo13invoke(LoadType.PREPEND, this.startState);
            interfaceC0526Fp.mo13invoke(LoadType.APPEND, this.endState);
        }

        public final LoadState getEndState() {
            return this.endState;
        }

        public final LoadState getRefreshState() {
            return this.refreshState;
        }

        public final LoadState getStartState() {
            return this.startState;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract void onStateChanged(LoadType loadType, LoadState loadState);

        public final void setEndState(LoadState loadState) {
            AbstractC4492zt.h(loadState, "<set-?>");
            this.endState = loadState;
        }

        public final void setRefreshState(LoadState loadState) {
            AbstractC4492zt.h(loadState, "<set-?>");
            this.refreshState = loadState;
        }

        public final void setStartState(LoadState loadState) {
            AbstractC4492zt.h(loadState, "<set-?>");
            this.startState = loadState;
        }

        public final void setState(LoadType loadType, LoadState loadState) {
            AbstractC4492zt.h(loadType, "type");
            AbstractC4492zt.h(loadState, "state");
            int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (AbstractC4492zt.d(this.endState, loadState)) {
                            return;
                        } else {
                            this.endState = loadState;
                        }
                    }
                } else if (AbstractC4492zt.d(this.startState, loadState)) {
                    return;
                } else {
                    this.startState = loadState;
                }
            } else if (AbstractC4492zt.d(this.refreshState, loadState)) {
                return;
            } else {
                this.refreshState = loadState;
            }
            onStateChanged(loadType, loadState);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$addWeakCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(WeakReference<Callback> weakReference) {
            AbstractC4492zt.h(weakReference, "it");
            return Boolean.valueOf(weakReference.get() == null);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$addWeakLoadStateListener$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17081 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C17081 INSTANCE = new C17081();

        public C17081() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(WeakReference<InterfaceC0526Fp> weakReference) {
            AbstractC4492zt.h(weakReference, "it");
            return Boolean.valueOf(weakReference.get() == null);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$removeWeakCallback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17091 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Callback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17091(Callback callback) {
            super(1);
            this.$callback = callback;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(WeakReference<Callback> weakReference) {
            AbstractC4492zt.h(weakReference, "it");
            return Boolean.valueOf(weakReference.get() == null || weakReference.get() == this.$callback);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$removeWeakLoadStateListener$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17101 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17101(InterfaceC0526Fp interfaceC0526Fp) {
            super(1);
            this.$listener = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(WeakReference<InterfaceC0526Fp> weakReference) {
            AbstractC4492zt.h(weakReference, "it");
            return Boolean.valueOf(weakReference.get() == null || weakReference.get() == this.$listener);
        }
    }

    public PagedList(PagingSource<?, T> pagingSource, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf, PagedStorage<T> pagedStorage, Config config) {
        AbstractC4492zt.h(pagingSource, "pagingSource");
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
        AbstractC4492zt.h(pagedStorage, "storage");
        AbstractC4492zt.h(config, "config");
        this.pagingSource = pagingSource;
        this.coroutineScope = interfaceC2052dg;
        this.notifyDispatcher = abstractC1040Xf;
        this.storage = pagedStorage;
        this.config = config;
        this.requiredRemainder = (config.prefetchDistance * 2) + config.pageSize;
        this.callbacks = new ArrayList();
        this.loadStateListeners = new ArrayList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <K, T> PagedList<T> create(PagingSource<K, T> pagingSource, PagingSource.LoadResult.Page<K, T> page, InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2, BoundaryCallback<T> boundaryCallback, Config config, K k) {
        return Companion.create(pagingSource, page, interfaceC2052dg, abstractC1040Xf, abstractC1040Xf2, boundaryCallback, config, k);
    }

    public static /* synthetic */ void getDataSource$annotations() {
    }

    public final void addWeakCallback(List<? extends T> list, Callback callback) {
        AbstractC4492zt.h(callback, "callback");
        if (list != null && list != this) {
            Companion.dispatchNaiveUpdatesSinceSnapshot$paging_common(size(), list.size(), callback);
        }
        addWeakCallback(callback);
    }

    public final void addWeakLoadStateListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AbstractC2371hc.M(this.loadStateListeners, C17081.INSTANCE);
        this.loadStateListeners.add(new WeakReference<>(interfaceC0526Fp));
        dispatchCurrentLoadState(interfaceC0526Fp);
    }

    public abstract void detach();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract void dispatchCurrentLoadState(InterfaceC0526Fp interfaceC0526Fp);

    public final void dispatchStateChangeAsync$paging_common(LoadType loadType, LoadState loadState) {
        AbstractC4492zt.h(loadType, "type");
        AbstractC4492zt.h(loadState, "state");
        O8.d(this.coroutineScope, this.notifyDispatcher, null, new PagedList$dispatchStateChangeAsync$1(this, loadType, loadState, null), 2, null);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.storage.get(i);
    }

    public final Config getConfig() {
        return this.config;
    }

    public final InterfaceC2052dg getCoroutineScope$paging_common() {
        return this.coroutineScope;
    }

    public final DataSource<?, T> getDataSource() {
        PagingSource<?, T> pagingSource = getPagingSource();
        if (pagingSource instanceof LegacyPagingSource) {
            DataSource<?, T> dataSource$paging_common = ((LegacyPagingSource) pagingSource).getDataSource$paging_common();
            AbstractC4492zt.f(dataSource$paging_common, "null cannot be cast to non-null type androidx.paging.DataSource<*, T of androidx.paging.PagedList>");
            return dataSource$paging_common;
        }
        throw new IllegalStateException("Attempt to access dataSource on a PagedList that was instantiated with a " + pagingSource.getClass().getSimpleName() + " instead of a DataSource");
    }

    public abstract Object getLastKey();

    public final int getLoadedCount() {
        return this.storage.getStorageCount();
    }

    public final AbstractC1040Xf getNotifyDispatcher$paging_common() {
        return this.notifyDispatcher;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NullPaddedList<T> getNullPaddedList() {
        return this.storage;
    }

    public PagingSource<?, T> getPagingSource() {
        return this.pagingSource;
    }

    public final int getPositionOffset() {
        return this.storage.getPositionOffset();
    }

    public final Runnable getRefreshRetryCallback$paging_common() {
        return this.refreshRetryCallback;
    }

    public final int getRequiredRemainder$paging_common() {
        return this.requiredRemainder;
    }

    public int getSize() {
        return this.storage.size();
    }

    public final PagedStorage<T> getStorage$paging_common() {
        return this.storage;
    }

    public abstract boolean isDetached();

    public boolean isImmutable() {
        return isDetached();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int lastLoad() {
        return this.storage.getLastLoadAroundIndex();
    }

    public final void loadAround(int i) {
        if (i >= 0 && i < size()) {
            this.storage.setLastLoadAroundIndex(i);
            loadAroundInternal(i);
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract void loadAroundInternal(int i);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyChanged(int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Iterator<T> it = AbstractC3240kc.r0(this.callbacks).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.onChanged(i, i2);
            }
        }
    }

    public final void notifyInserted$paging_common(int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Iterator<T> it = AbstractC3240kc.r0(this.callbacks).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.onInserted(i, i2);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyRemoved(int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Iterator<T> it = AbstractC3240kc.r0(this.callbacks).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.onRemoved(i, i2);
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i) {
        return (T) removeAt(i);
    }

    public /* bridge */ Object removeAt(int i) {
        return super.remove(i);
    }

    public final void removeWeakCallback(Callback callback) {
        AbstractC4492zt.h(callback, "callback");
        AbstractC2371hc.M(this.callbacks, new C17091(callback));
    }

    public final void removeWeakLoadStateListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AbstractC2371hc.M(this.loadStateListeners, new C17101(interfaceC0526Fp));
    }

    public void retry() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInitialLoadState(LoadType loadType, LoadState loadState) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(loadState, "loadState");
    }

    public final void setRefreshRetryCallback$paging_common(Runnable runnable) {
        this.refreshRetryCallback = runnable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setRetryCallback(Runnable runnable) {
        this.refreshRetryCallback = runnable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public final List<T> snapshot() {
        return isImmutable() ? this : new SnapshotPagedList(this);
    }

    public final void addWeakCallback(Callback callback) {
        AbstractC4492zt.h(callback, "callback");
        AbstractC2371hc.M(this.callbacks, AnonymousClass1.INSTANCE);
        this.callbacks.add(new WeakReference<>(callback));
    }

    public static final class Builder<Key, Value> {
        private BoundaryCallback<Value> boundaryCallback;
        private final Config config;
        private InterfaceC2052dg coroutineScope;
        private DataSource<Key, Value> dataSource;
        private AbstractC1040Xf fetchDispatcher;
        private Key initialKey;
        private final PagingSource.LoadResult.Page<Key, Value> initialPage;
        private AbstractC1040Xf notifyDispatcher;
        private final PagingSource<Key, Value> pagingSource;

        public Builder(DataSource<Key, Value> dataSource, Config config) {
            AbstractC4492zt.h(dataSource, "dataSource");
            AbstractC4492zt.h(config, "config");
            this.coroutineScope = C3343lq.a;
            this.pagingSource = null;
            this.dataSource = dataSource;
            this.initialPage = null;
            this.config = config;
        }

        private static /* synthetic */ void getCoroutineScope$annotations() {
        }

        public final PagedList<Value> build() {
            PagingSource<Key, Value> legacyPagingSource;
            AbstractC1040Xf abstractC1040XfB = this.fetchDispatcher;
            if (abstractC1040XfB == null) {
                abstractC1040XfB = C0368Bj.b();
            }
            AbstractC1040Xf abstractC1040Xf = abstractC1040XfB;
            PagingSource<Key, Value> pagingSource = this.pagingSource;
            if (pagingSource == null) {
                DataSource<Key, Value> dataSource = this.dataSource;
                legacyPagingSource = dataSource != null ? new LegacyPagingSource(abstractC1040Xf, dataSource) : null;
            } else {
                legacyPagingSource = pagingSource;
            }
            if (legacyPagingSource instanceof LegacyPagingSource) {
                ((LegacyPagingSource) legacyPagingSource).setPageSize(this.config.pageSize);
            }
            if (legacyPagingSource == null) {
                throw new IllegalStateException("PagedList cannot be built without a PagingSource or DataSource");
            }
            Companion companion = PagedList.Companion;
            PagingSource.LoadResult.Page<Key, Value> page = this.initialPage;
            InterfaceC2052dg interfaceC2052dg = this.coroutineScope;
            AbstractC1040Xf abstractC1040XfI = this.notifyDispatcher;
            if (abstractC1040XfI == null) {
                abstractC1040XfI = C0368Bj.c().I();
            }
            return companion.create(legacyPagingSource, page, interfaceC2052dg, abstractC1040XfI, abstractC1040Xf, this.boundaryCallback, this.config, this.initialKey);
        }

        public final Builder<Key, Value> setBoundaryCallback(BoundaryCallback<Value> boundaryCallback) {
            this.boundaryCallback = boundaryCallback;
            return this;
        }

        public final Builder<Key, Value> setCoroutineScope(InterfaceC2052dg interfaceC2052dg) {
            AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
            this.coroutineScope = interfaceC2052dg;
            return this;
        }

        public final Builder<Key, Value> setFetchDispatcher(AbstractC1040Xf abstractC1040Xf) {
            AbstractC4492zt.h(abstractC1040Xf, "fetchDispatcher");
            this.fetchDispatcher = abstractC1040Xf;
            return this;
        }

        public final Builder<Key, Value> setFetchExecutor(Executor executor) {
            AbstractC4492zt.h(executor, "fetchExecutor");
            this.fetchDispatcher = AbstractC1173Zl.a(executor);
            return this;
        }

        public final Builder<Key, Value> setInitialKey(Key key) {
            this.initialKey = key;
            return this;
        }

        public final Builder<Key, Value> setNotifyDispatcher(AbstractC1040Xf abstractC1040Xf) {
            AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
            this.notifyDispatcher = abstractC1040Xf;
            return this;
        }

        public final Builder<Key, Value> setNotifyExecutor(Executor executor) {
            AbstractC4492zt.h(executor, "notifyExecutor");
            this.notifyDispatcher = AbstractC1173Zl.a(executor);
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(DataSource<Key, Value> dataSource, int i) {
            this(dataSource, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null));
            AbstractC4492zt.h(dataSource, "dataSource");
        }

        public Builder(PagingSource<Key, Value> pagingSource, PagingSource.LoadResult.Page<Key, Value> page, Config config) {
            AbstractC4492zt.h(pagingSource, "pagingSource");
            AbstractC4492zt.h(page, "initialPage");
            AbstractC4492zt.h(config, "config");
            this.coroutineScope = C3343lq.a;
            this.pagingSource = pagingSource;
            this.dataSource = null;
            this.initialPage = page;
            this.config = config;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PagingSource<Key, Value> pagingSource, PagingSource.LoadResult.Page<Key, Value> page, int i) {
            this(pagingSource, page, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null));
            AbstractC4492zt.h(pagingSource, "pagingSource");
            AbstractC4492zt.h(page, "initialPage");
        }
    }
}
