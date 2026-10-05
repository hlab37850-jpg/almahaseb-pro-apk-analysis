package androidx.paging.rxjava3;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.DataSource;
import androidx.paging.InitialPagedList;
import androidx.paging.PagedList;
import androidx.paging.rxjava3.RxPagedListBuilder;
import defpackage.AN;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC3258kn;
import defpackage.AbstractC4492zt;
import defpackage.C3343lq;
import defpackage.HM;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3296lE;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3624pE;
import defpackage.InterfaceC4212wa;
import defpackage.M6;
import defpackage.O8;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class RxPagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback<Value> boundaryCallback;
    private final PagedList.Config config;
    private final DataSource.Factory<Key, Value> dataSourceFactory;
    private AbstractC1040Xf fetchDispatcher;
    private AN fetchScheduler;
    private Key initialLoadKey;
    private AbstractC1040Xf notifyDispatcher;
    private AN notifyScheduler;
    private final InterfaceC3588op pagingSourceFactory;

    public static final class PagingObservableOnSubscribe<Key, Value> implements InterfaceC3624pE, InterfaceC4212wa {
        private final PagedList.BoundaryCallback<Value> boundaryCallback;
        private final InterfaceC3588op callback;
        private final PagedList.Config config;
        private PagedList<Value> currentData;
        private InterfaceC1830bu currentJob;
        private InterfaceC3296lE emitter;
        private final AbstractC1040Xf fetchDispatcher;
        private boolean firstSubscribe;
        private final AbstractC1040Xf notifyDispatcher;
        private final InterfaceC3588op pagingSourceFactory;
        private final Runnable refreshRetryCallback;

        public PagingObservableOnSubscribe(Key key, PagedList.Config config, PagedList.BoundaryCallback<Value> boundaryCallback, InterfaceC3588op interfaceC3588op, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2) {
            AbstractC4492zt.h(config, "config");
            AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
            AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
            AbstractC4492zt.h(abstractC1040Xf2, "fetchDispatcher");
            this.config = config;
            this.boundaryCallback = boundaryCallback;
            this.pagingSourceFactory = interfaceC3588op;
            this.notifyDispatcher = abstractC1040Xf;
            this.fetchDispatcher = abstractC1040Xf2;
            this.firstSubscribe = true;
            this.callback = new RxPagedListBuilder$PagingObservableOnSubscribe$callback$1(this);
            Runnable runnable = new Runnable() { // from class: GM
                @Override // java.lang.Runnable
                public final void run() {
                    RxPagedListBuilder.PagingObservableOnSubscribe.refreshRetryCallback$lambda$0(this.a);
                }
            };
            this.refreshRetryCallback = runnable;
            InitialPagedList initialPagedList = new InitialPagedList(C3343lq.a, abstractC1040Xf, abstractC1040Xf2, config, key);
            this.currentData = initialPagedList;
            initialPagedList.setRetryCallback(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void invalidate(boolean z) {
            InterfaceC1830bu interfaceC1830bu = this.currentJob;
            if (interfaceC1830bu == null || z) {
                if (interfaceC1830bu != null) {
                    InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                }
                this.currentJob = O8.d(C3343lq.a, this.fetchDispatcher, null, new RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1(this, null), 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onItemUpdate(PagedList<Value> pagedList, PagedList<Value> pagedList2) {
            pagedList.setRetryCallback(null);
            pagedList2.setRetryCallback(this.refreshRetryCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void refreshRetryCallback$lambda$0(PagingObservableOnSubscribe pagingObservableOnSubscribe) {
            AbstractC4492zt.h(pagingObservableOnSubscribe, "this$0");
            pagingObservableOnSubscribe.invalidate(true);
        }

        @Override // defpackage.InterfaceC4212wa
        public void cancel() {
            this.currentData.getPagingSource().unregisterInvalidatedCallback(this.callback);
        }

        @Override // defpackage.InterfaceC3624pE
        public void subscribe(InterfaceC3296lE interfaceC3296lE) {
            AbstractC4492zt.h(interfaceC3296lE, "emitter");
            this.emitter = interfaceC3296lE;
            interfaceC3296lE.c(this);
            if (this.firstSubscribe) {
                interfaceC3296lE.b(this.currentData);
                this.firstSubscribe = false;
            }
            invalidate(false);
        }
    }

    public RxPagedListBuilder(InterfaceC3588op interfaceC3588op, PagedList.Config config) {
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
        AbstractC4492zt.h(config, "config");
        this.pagingSourceFactory = interfaceC3588op;
        this.dataSourceFactory = null;
        this.config = config;
    }

    private static /* synthetic */ void getBoundaryCallback$annotations() {
    }

    private static /* synthetic */ void getConfig$annotations() {
    }

    public final AbstractC3258kn buildFlowable(M6 m6) {
        AbstractC4492zt.h(m6, "backpressureStrategy");
        AbstractC3258kn abstractC3258knN = buildObservable().n(m6);
        AbstractC4492zt.g(abstractC3258knN, "buildObservable().toFlowable(backpressureStrategy)");
        return abstractC3258knN;
    }

    public final AbstractC3132jE buildObservable() {
        AN scheduledExecutor = this.notifyScheduler;
        if (scheduledExecutor == null) {
            Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
            AbstractC4492zt.g(mainThreadExecutor, "getMainThreadExecutor()");
            scheduledExecutor = new ScheduledExecutor(mainThreadExecutor);
        }
        AbstractC1040Xf abstractC1040XfA = this.notifyDispatcher;
        if (abstractC1040XfA == null) {
            abstractC1040XfA = HM.a(scheduledExecutor);
        }
        AbstractC1040Xf abstractC1040Xf = abstractC1040XfA;
        AN scheduledExecutor2 = this.fetchScheduler;
        if (scheduledExecutor2 == null) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            AbstractC4492zt.g(iOThreadExecutor, "getIOThreadExecutor()");
            scheduledExecutor2 = new ScheduledExecutor(iOThreadExecutor);
        }
        AbstractC1040Xf abstractC1040XfA2 = this.fetchDispatcher;
        if (abstractC1040XfA2 == null) {
            abstractC1040XfA2 = HM.a(scheduledExecutor2);
        }
        AbstractC1040Xf abstractC1040Xf2 = abstractC1040XfA2;
        InterfaceC3588op interfaceC3588opAsPagingSourceFactory = this.pagingSourceFactory;
        if (interfaceC3588opAsPagingSourceFactory == null) {
            DataSource.Factory<Key, Value> factory = this.dataSourceFactory;
            interfaceC3588opAsPagingSourceFactory = factory != null ? factory.asPagingSourceFactory(abstractC1040Xf2) : null;
        }
        InterfaceC3588op interfaceC3588op = interfaceC3588opAsPagingSourceFactory;
        if (interfaceC3588op == null) {
            throw new IllegalStateException("RxPagedList cannot be built without a PagingSourceFactory or DataSource.Factory");
        }
        AbstractC3132jE abstractC3132jEM = AbstractC3132jE.c(new PagingObservableOnSubscribe(this.initialLoadKey, this.config, this.boundaryCallback, interfaceC3588op, abstractC1040Xf, abstractC1040Xf2)).e(scheduledExecutor).m(scheduledExecutor2);
        AbstractC4492zt.g(abstractC3132jEM, "create(\n                …bscribeOn(fetchScheduler)");
        return abstractC3132jEM;
    }

    public final RxPagedListBuilder<Key, Value> setBoundaryCallback(PagedList.BoundaryCallback<Value> boundaryCallback) {
        this.boundaryCallback = boundaryCallback;
        return this;
    }

    public final RxPagedListBuilder<Key, Value> setFetchScheduler(AN an) {
        AbstractC4492zt.h(an, "scheduler");
        this.fetchScheduler = an;
        this.fetchDispatcher = HM.a(an);
        return this;
    }

    public final RxPagedListBuilder<Key, Value> setInitialLoadKey(Key key) {
        this.initialLoadKey = key;
        return this;
    }

    public final RxPagedListBuilder<Key, Value> setNotifyScheduler(AN an) {
        AbstractC4492zt.h(an, "scheduler");
        this.notifyScheduler = an;
        this.notifyDispatcher = HM.a(an);
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RxPagedListBuilder(InterfaceC3588op interfaceC3588op, int i) {
        this(interfaceC3588op, new PagedList.Config.Builder().setPageSize(i).build());
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
    }

    public RxPagedListBuilder(DataSource.Factory<Key, Value> factory, PagedList.Config config) {
        AbstractC4492zt.h(factory, "dataSourceFactory");
        AbstractC4492zt.h(config, "config");
        this.pagingSourceFactory = null;
        this.dataSourceFactory = factory;
        this.config = config;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RxPagedListBuilder(DataSource.Factory<Key, Value> factory, int i) {
        this(factory, new PagedList.Config.Builder().setPageSize(i).build());
        AbstractC4492zt.h(factory, "dataSourceFactory");
    }
}
