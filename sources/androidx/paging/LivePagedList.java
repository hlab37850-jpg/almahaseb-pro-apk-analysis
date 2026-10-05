package androidx.paging;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedList;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.M8;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {
    private final PagedList.BoundaryCallback<Value> boundaryCallback;
    private final InterfaceC3588op callback;
    private final PagedList.Config config;
    private final InterfaceC2052dg coroutineScope;
    private PagedList<Value> currentData;
    private InterfaceC1830bu currentJob;
    private final AbstractC1040Xf fetchDispatcher;
    private final AbstractC1040Xf notifyDispatcher;
    private final InterfaceC3588op pagingSourceFactory;
    private final Runnable refreshRetryCallback;

    /* JADX INFO: renamed from: androidx.paging.LivePagedList$invalidate$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.LivePagedList$invalidate$1", f = "LivePagedList.kt", l = {82, 90}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LivePagedList<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.LivePagedList$invalidate$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.LivePagedList$invalidate$1$1", f = "LivePagedList.kt", l = {}, m = "invokeSuspend")
        public static final class C01531 extends XS implements InterfaceC0526Fp {
            int label;
            final /* synthetic */ LivePagedList<Key, Value> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01531(LivePagedList<Key, Value> livePagedList, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.this$0 = livePagedList;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C01531(this.this$0, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01531) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0378Bt.d();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                ((LivePagedList) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, LoadState.Loading.INSTANCE);
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LivePagedList<Key, Value> livePagedList, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = livePagedList;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:24:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:26:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:27:0x00da  */
        /* JADX WARN: Code duplicated, block: B:29:0x00de  */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            PagingSource pagingSource;
            Object obj2;
            PagingSource.LoadResult loadResult;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    pagingSource = (PagingSource) this.L$0;
                    LL.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj3 = this.L$1;
                    pagingSource = (PagingSource) this.L$0;
                    LL.b(obj);
                    obj2 = obj3;
                }
                loadResult = (PagingSource.LoadResult) obj;
                if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                    ((LivePagedList) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.NotLoading(false));
                    pagingSource.invalidate();
                } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                    ((LivePagedList) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
                } else if (loadResult instanceof PagingSource.LoadResult.Page) {
                    PagedList pagedListCreate = PagedList.Companion.create(pagingSource, (PagingSource.LoadResult.Page) loadResult, ((LivePagedList) this.this$0).coroutineScope, ((LivePagedList) this.this$0).notifyDispatcher, ((LivePagedList) this.this$0).fetchDispatcher, ((LivePagedList) this.this$0).boundaryCallback, ((LivePagedList) this.this$0).config, obj2);
                    LivePagedList<Key, Value> livePagedList = this.this$0;
                    livePagedList.onItemUpdate(((LivePagedList) livePagedList).currentData, pagedListCreate);
                    ((LivePagedList) this.this$0).currentData = pagedListCreate;
                    this.this$0.postValue(pagedListCreate);
                }
                return FW.a;
            }
            LL.b(obj);
            ((LivePagedList) this.this$0).currentData.getPagingSource().unregisterInvalidatedCallback(((LivePagedList) this.this$0).callback);
            PagingSource pagingSource2 = (PagingSource) ((LivePagedList) this.this$0).pagingSourceFactory.invoke();
            pagingSource2.registerInvalidatedCallback(((LivePagedList) this.this$0).callback);
            if (pagingSource2 instanceof LegacyPagingSource) {
                ((LegacyPagingSource) pagingSource2).setPageSize(((LivePagedList) this.this$0).config.pageSize);
            }
            AbstractC1040Xf abstractC1040Xf = ((LivePagedList) this.this$0).notifyDispatcher;
            C01531 c01531 = new C01531(this.this$0, null);
            this.L$0 = pagingSource2;
            this.label = 1;
            if (M8.g(abstractC1040Xf, c01531, this) == objD) {
                return objD;
            }
            pagingSource = pagingSource2;
            Object lastKey = ((LivePagedList) this.this$0).currentData.getLastKey();
            PagingSource.LoadParams<Key> refreshLoadParams = PagingSourceKt.toRefreshLoadParams(((LivePagedList) this.this$0).config, lastKey);
            this.L$0 = pagingSource;
            this.L$1 = lastKey;
            this.label = 2;
            Object objLoad = pagingSource.load(refreshLoadParams, this);
            if (objLoad == objD) {
                return objD;
            }
            obj2 = lastKey;
            obj = objLoad;
            loadResult = (PagingSource.LoadResult) obj;
            if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                ((LivePagedList) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.NotLoading(false));
                pagingSource.invalidate();
            } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                ((LivePagedList) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
            } else if (loadResult instanceof PagingSource.LoadResult.Page) {
                PagedList pagedListCreate2 = PagedList.Companion.create(pagingSource, (PagingSource.LoadResult.Page) loadResult, ((LivePagedList) this.this$0).coroutineScope, ((LivePagedList) this.this$0).notifyDispatcher, ((LivePagedList) this.this$0).fetchDispatcher, ((LivePagedList) this.this$0).boundaryCallback, ((LivePagedList) this.this$0).config, obj2);
                LivePagedList<Key, Value> livePagedList2 = this.this$0;
                livePagedList2.onItemUpdate(((LivePagedList) livePagedList2).currentData, pagedListCreate2);
                ((LivePagedList) this.this$0).currentData = pagedListCreate2;
                this.this$0.postValue(pagedListCreate2);
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePagedList(InterfaceC2052dg interfaceC2052dg, Key key, PagedList.Config config, PagedList.BoundaryCallback<Value> boundaryCallback, InterfaceC3588op interfaceC3588op, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2) {
        super(new InitialPagedList(interfaceC2052dg, abstractC1040Xf, abstractC1040Xf2, config, key));
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
        AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
        AbstractC4492zt.h(abstractC1040Xf2, "fetchDispatcher");
        this.coroutineScope = interfaceC2052dg;
        this.config = config;
        this.boundaryCallback = boundaryCallback;
        this.pagingSourceFactory = interfaceC3588op;
        this.notifyDispatcher = abstractC1040Xf;
        this.fetchDispatcher = abstractC1040Xf2;
        this.callback = new LivePagedList$callback$1(this);
        Runnable runnable = new Runnable() { // from class: dw
            @Override // java.lang.Runnable
            public final void run() {
                LivePagedList.refreshRetryCallback$lambda$0(this.a);
            }
        };
        this.refreshRetryCallback = runnable;
        PagedList<Value> value = getValue();
        AbstractC4492zt.e(value);
        PagedList<Value> pagedList = value;
        this.currentData = pagedList;
        pagedList.setRetryCallback(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidate(boolean z) {
        InterfaceC1830bu interfaceC1830bu = this.currentJob;
        if (interfaceC1830bu == null || z) {
            if (interfaceC1830bu != null) {
                InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
            }
            this.currentJob = O8.d(this.coroutineScope, this.fetchDispatcher, null, new AnonymousClass1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemUpdate(PagedList<Value> pagedList, PagedList<Value> pagedList2) {
        pagedList.setRetryCallback(null);
        pagedList2.setRetryCallback(this.refreshRetryCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRetryCallback$lambda$0(LivePagedList livePagedList) {
        AbstractC4492zt.h(livePagedList, "this$0");
        livePagedList.invalidate(true);
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        invalidate(false);
    }
}
