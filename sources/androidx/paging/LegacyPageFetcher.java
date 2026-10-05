package androidx.paging;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyPageFetcher<K, V> {
    private final PagedList.Config config;
    private final AtomicBoolean detached;
    private final AbstractC1040Xf fetchDispatcher;
    private final KeyProvider<K> keyProvider;
    private PagedList.LoadStateManager loadStateManager;
    private final AbstractC1040Xf notifyDispatcher;
    private final PageConsumer<V> pageConsumer;
    private final InterfaceC2052dg pagedListScope;
    private final PagingSource<K, V> source;

    public interface KeyProvider<K> {
        K getNextKey();

        K getPrevKey();
    }

    public interface PageConsumer<V> {
        boolean onPageResult(LoadType loadType, PagingSource.LoadResult.Page<?, V> page);

        void onStateChanged(LoadType loadType, LoadState loadState);
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1", f = "LegacyPageFetcher.kt", l = {53}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ PagingSource.LoadParams<K> $params;
        final /* synthetic */ LoadType $type;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LegacyPageFetcher<K, V> this$0;

        /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1$1", f = "LegacyPageFetcher.kt", l = {}, m = "invokeSuspend")
        public static final class C01521 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ LoadType $type;
            final /* synthetic */ PagingSource.LoadResult<K, V> $value;
            int label;
            final /* synthetic */ LegacyPageFetcher<K, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01521(PagingSource.LoadResult<K, V> loadResult, LegacyPageFetcher<K, V> legacyPageFetcher, LoadType loadType, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$value = loadResult;
                this.this$0 = legacyPageFetcher;
                this.$type = loadType;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C01521(this.$value, this.this$0, this.$type, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01521) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0378Bt.d();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                PagingSource.LoadResult<K, V> loadResult = this.$value;
                if (loadResult instanceof PagingSource.LoadResult.Page) {
                    this.this$0.onLoadSuccess(this.$type, (PagingSource.LoadResult.Page) loadResult);
                } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                    this.this$0.onLoadError(this.$type, ((PagingSource.LoadResult.Error) loadResult).getThrowable());
                } else if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                    this.this$0.onLoadInvalid();
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LegacyPageFetcher<K, V> legacyPageFetcher, PagingSource.LoadParams<K> loadParams, LoadType loadType, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = legacyPageFetcher;
            this.$params = loadParams;
            this.$type = loadType;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$params, this.$type, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC2052dg interfaceC2052dg;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg2 = (InterfaceC2052dg) this.L$0;
                PagingSource<K, V> source = this.this$0.getSource();
                PagingSource.LoadParams<K> loadParams = this.$params;
                this.L$0 = interfaceC2052dg2;
                this.label = 1;
                Object objLoad = source.load(loadParams, this);
                if (objLoad == objD) {
                    return objD;
                }
                interfaceC2052dg = interfaceC2052dg2;
                obj = objLoad;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                LL.b(obj);
            }
            PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
            if (this.this$0.getSource().getInvalid()) {
                this.this$0.detach();
                return FW.a;
            }
            O8.d(interfaceC2052dg, ((LegacyPageFetcher) this.this$0).notifyDispatcher, null, new C01521(loadResult, this.this$0, this.$type, null), 2, null);
            return FW.a;
        }
    }

    public LegacyPageFetcher(InterfaceC2052dg interfaceC2052dg, PagedList.Config config, PagingSource<K, V> pagingSource, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2, PageConsumer<V> pageConsumer, KeyProvider<K> keyProvider) {
        AbstractC4492zt.h(interfaceC2052dg, "pagedListScope");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(pagingSource, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
        AbstractC4492zt.h(abstractC1040Xf2, "fetchDispatcher");
        AbstractC4492zt.h(pageConsumer, "pageConsumer");
        AbstractC4492zt.h(keyProvider, "keyProvider");
        this.pagedListScope = interfaceC2052dg;
        this.config = config;
        this.source = pagingSource;
        this.notifyDispatcher = abstractC1040Xf;
        this.fetchDispatcher = abstractC1040Xf2;
        this.pageConsumer = pageConsumer;
        this.keyProvider = keyProvider;
        this.detached = new AtomicBoolean(false);
        this.loadStateManager = new PagedList.LoadStateManager(this) { // from class: androidx.paging.LegacyPageFetcher$loadStateManager$1
            final /* synthetic */ LegacyPageFetcher<K, V> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType loadType, LoadState loadState) {
                AbstractC4492zt.h(loadType, "type");
                AbstractC4492zt.h(loadState, "state");
                this.this$0.getPageConsumer().onStateChanged(loadType, loadState);
            }
        };
    }

    public static /* synthetic */ void getLoadStateManager$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadError(LoadType loadType, Throwable th) {
        if (isDetached()) {
            return;
        }
        this.loadStateManager.setState(loadType, new LoadState.Error(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadInvalid() {
        this.source.invalidate();
        detach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadSuccess(LoadType loadType, PagingSource.LoadResult.Page<K, V> page) {
        if (isDetached()) {
            return;
        }
        if (!this.pageConsumer.onPageResult(loadType, page)) {
            this.loadStateManager.setState(loadType, page.getData().isEmpty() ? LoadState.NotLoading.Companion.getComplete$paging_common() : LoadState.NotLoading.Companion.getIncomplete$paging_common());
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            schedulePrepend();
        } else {
            if (i != 2) {
                throw new IllegalStateException("Can only fetch more during append/prepend");
            }
            scheduleAppend();
        }
    }

    private final void scheduleAppend() {
        K nextKey = this.keyProvider.getNextKey();
        if (nextKey == null) {
            onLoadSuccess(LoadType.APPEND, PagingSource.LoadResult.Page.Companion.empty$paging_common());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.loadStateManager;
        LoadType loadType = LoadType.APPEND;
        loadStateManager.setState(loadType, LoadState.Loading.INSTANCE);
        PagedList.Config config = this.config;
        scheduleLoad(loadType, new PagingSource.LoadParams.Append(nextKey, config.pageSize, config.enablePlaceholders));
    }

    private final void scheduleLoad(LoadType loadType, PagingSource.LoadParams<K> loadParams) {
        O8.d(this.pagedListScope, this.fetchDispatcher, null, new AnonymousClass1(this, loadParams, loadType, null), 2, null);
    }

    private final void schedulePrepend() {
        K prevKey = this.keyProvider.getPrevKey();
        if (prevKey == null) {
            onLoadSuccess(LoadType.PREPEND, PagingSource.LoadResult.Page.Companion.empty$paging_common());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.loadStateManager;
        LoadType loadType = LoadType.PREPEND;
        loadStateManager.setState(loadType, LoadState.Loading.INSTANCE);
        PagedList.Config config = this.config;
        scheduleLoad(loadType, new PagingSource.LoadParams.Prepend(prevKey, config.pageSize, config.enablePlaceholders));
    }

    public final void detach() {
        this.detached.set(true);
    }

    public final PagedList.Config getConfig() {
        return this.config;
    }

    public final PagedList.LoadStateManager getLoadStateManager() {
        return this.loadStateManager;
    }

    public final PageConsumer<V> getPageConsumer() {
        return this.pageConsumer;
    }

    public final PagingSource<K, V> getSource() {
        return this.source;
    }

    public final boolean isDetached() {
        return this.detached.get();
    }

    public final void retry() {
        if (this.loadStateManager.getStartState() instanceof LoadState.Error) {
            schedulePrepend();
        }
        if (this.loadStateManager.getEndState() instanceof LoadState.Error) {
            scheduleAppend();
        }
    }

    public final void setLoadStateManager(PagedList.LoadStateManager loadStateManager) {
        AbstractC4492zt.h(loadStateManager, "<set-?>");
        this.loadStateManager = loadStateManager;
    }

    public final void tryScheduleAppend() {
        LoadState endState = this.loadStateManager.getEndState();
        if (!(endState instanceof LoadState.NotLoading) || endState.getEndOfPaginationReached()) {
            return;
        }
        scheduleAppend();
    }

    public final void trySchedulePrepend() {
        LoadState startState = this.loadStateManager.getStartState();
        if (!(startState instanceof LoadState.NotLoading) || startState.getEndOfPaginationReached()) {
            return;
        }
        schedulePrepend();
    }
}
