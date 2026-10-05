package androidx.paging.rxjava3;

import androidx.paging.LegacyPagingSource;
import androidx.paging.LoadState;
import androidx.paging.LoadType;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import androidx.paging.PagingSourceKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC4492zt;
import defpackage.C3343lq;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3296lE;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.rxjava3.RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1", f = "RxPagedListBuilder.kt", l = {406, 413}, m = "invokeSuspend")
public final class RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1 extends XS implements InterfaceC0526Fp {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> this$0;

    /* JADX INFO: renamed from: androidx.paging.rxjava3.RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.rxjava3.RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1$1", f = "RxPagedListBuilder.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> pagingObservableOnSubscribe, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pagingObservableOnSubscribe;
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

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, LoadState.Loading.INSTANCE);
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1(RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> pagingObservableOnSubscribe, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = pagingObservableOnSubscribe;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1(this.this$0, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:31:0x0119  */
    /* JADX WARN: Code duplicated, block: B:32:0x011f  */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        PagingSource pagingSource;
        Object obj2;
        PagingSource pagingSource2;
        PagingSource.LoadResult loadResult;
        InterfaceC3296lE interfaceC3296lE;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        InterfaceC3296lE interfaceC3296lE2 = null;
        if (i != 0) {
            if (i == 1) {
                pagingSource = (PagingSource) this.L$0;
                LL.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj3 = this.L$1;
                PagingSource pagingSource3 = (PagingSource) this.L$0;
                LL.b(obj);
                obj2 = obj3;
                pagingSource2 = pagingSource3;
            }
            loadResult = (PagingSource.LoadResult) obj;
            if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.NotLoading(false));
                pagingSource2.invalidate();
            } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
            } else if (loadResult instanceof PagingSource.LoadResult.Page) {
                PagedList pagedListCreate = PagedList.Companion.create(pagingSource2, (PagingSource.LoadResult.Page) loadResult, C3343lq.a, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).notifyDispatcher, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).fetchDispatcher, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).boundaryCallback, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).config, obj2);
                RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> pagingObservableOnSubscribe = this.this$0;
                pagingObservableOnSubscribe.onItemUpdate(((RxPagedListBuilder.PagingObservableOnSubscribe) pagingObservableOnSubscribe).currentData, pagedListCreate);
                ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData = pagedListCreate;
                interfaceC3296lE = ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).emitter;
                if (interfaceC3296lE == null) {
                    AbstractC4492zt.x("emitter");
                } else {
                    interfaceC3296lE2 = interfaceC3296lE;
                }
                interfaceC3296lE2.b(pagedListCreate);
            }
            return FW.a;
        }
        LL.b(obj);
        ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.getPagingSource().unregisterInvalidatedCallback(((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).callback);
        PagingSource pagingSource4 = (PagingSource) ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).pagingSourceFactory.invoke();
        pagingSource4.registerInvalidatedCallback(((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).callback);
        if (pagingSource4 instanceof LegacyPagingSource) {
            ((LegacyPagingSource) pagingSource4).setPageSize(((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).config.pageSize);
        }
        AbstractC1040Xf abstractC1040Xf = ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).notifyDispatcher;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.L$0 = pagingSource4;
        this.label = 1;
        if (M8.g(abstractC1040Xf, anonymousClass1, this) == objD) {
            return objD;
        }
        pagingSource = pagingSource4;
        Object lastKey = ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.getLastKey();
        PagingSource.LoadParams refreshLoadParams = PagingSourceKt.toRefreshLoadParams(((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).config, lastKey);
        this.L$0 = pagingSource;
        this.L$1 = lastKey;
        this.label = 2;
        Object objLoad = pagingSource.load(refreshLoadParams, this);
        if (objLoad == objD) {
            return objD;
        }
        obj2 = lastKey;
        pagingSource2 = pagingSource;
        obj = objLoad;
        loadResult = (PagingSource.LoadResult) obj;
        if (loadResult instanceof PagingSource.LoadResult.Invalid) {
            ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.NotLoading(false));
            pagingSource2.invalidate();
        } else if (loadResult instanceof PagingSource.LoadResult.Error) {
            ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
        } else if (loadResult instanceof PagingSource.LoadResult.Page) {
            PagedList pagedListCreate2 = PagedList.Companion.create(pagingSource2, (PagingSource.LoadResult.Page) loadResult, C3343lq.a, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).notifyDispatcher, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).fetchDispatcher, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).boundaryCallback, ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).config, obj2);
            RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> pagingObservableOnSubscribe2 = this.this$0;
            pagingObservableOnSubscribe2.onItemUpdate(((RxPagedListBuilder.PagingObservableOnSubscribe) pagingObservableOnSubscribe2).currentData, pagedListCreate2);
            ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).currentData = pagedListCreate2;
            interfaceC3296lE = ((RxPagedListBuilder.PagingObservableOnSubscribe) this.this$0).emitter;
            if (interfaceC3296lE == null) {
                AbstractC4492zt.x("emitter");
            } else {
                interfaceC3296lE2 = interfaceC3296lE;
            }
            interfaceC3296lE2.b(pagedListCreate2);
        }
        return FW.a;
    }
}
