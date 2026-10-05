package androidx.paging;

import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
public final class PageFetcher<Key, Value> {
    private final PagingConfig config;
    private final InterfaceC0939Tm flow;
    private final Key initialKey;
    private final InterfaceC3750qp pagingSourceFactory;
    private final ConflatedEventBus<Boolean> refreshEvents;
    private final ConflatedEventBus<FW> retryEvents;

    public static final class GenerationInfo<Key, Value> {
        private final InterfaceC1830bu job;
        private final PageFetcherSnapshot<Key, Value> snapshot;
        private final PagingState<Key, Value> state;

        public GenerationInfo(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, PagingState<Key, Value> pagingState, InterfaceC1830bu interfaceC1830bu) {
            AbstractC4492zt.h(pageFetcherSnapshot, "snapshot");
            AbstractC4492zt.h(interfaceC1830bu, "job");
            this.snapshot = pageFetcherSnapshot;
            this.state = pagingState;
            this.job = interfaceC1830bu;
        }

        public final InterfaceC1830bu getJob() {
            return this.job;
        }

        public final PageFetcherSnapshot<Key, Value> getSnapshot() {
            return this.snapshot;
        }

        public final PagingState<Key, Value> getState() {
            return this.state;
        }
    }

    public final class PagerHintReceiver<Key, Value> implements HintReceiver {
        private final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerHintReceiver(@VisibleForTesting PageFetcher pageFetcher, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot) {
            AbstractC4492zt.h(pageFetcherSnapshot, "pageFetcherSnapshot");
            this.this$0 = pageFetcher;
            this.pageFetcherSnapshot = pageFetcherSnapshot;
        }

        @Override // androidx.paging.HintReceiver
        public void accessHint(ViewportHint viewportHint) {
            AbstractC4492zt.h(viewportHint, "viewportHint");
            this.pageFetcherSnapshot.accessHint(viewportHint);
        }

        public final PageFetcherSnapshot<Key, Value> getPageFetcherSnapshot$paging_common() {
            return this.pageFetcherSnapshot;
        }
    }

    public final class PagerUiReceiver implements UiReceiver {
        private final ConflatedEventBus<FW> retryEventBus;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerUiReceiver(PageFetcher pageFetcher, ConflatedEventBus<FW> conflatedEventBus) {
            AbstractC4492zt.h(conflatedEventBus, "retryEventBus");
            this.this$0 = pageFetcher;
            this.retryEventBus = conflatedEventBus;
        }

        @Override // androidx.paging.UiReceiver
        public void refresh() {
            this.this$0.refresh();
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
            this.retryEventBus.send(FW.a);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcher", f = "PageFetcher.kt", l = {210}, m = "generateNewPagingSource")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageFetcher<Key, Value> pageFetcher, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = pageFetcher;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.generateNewPagingSource(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$3, reason: invalid class name */
    public /* synthetic */ class AnonymousClass3 extends C0916Sp implements InterfaceC3588op {
        public AnonymousClass3(Object obj) {
            super(0, obj, PageFetcher.class, "invalidate", "invalidate()V", 0);
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5432invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5432invoke() {
            ((PageFetcher) this.receiver).invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$4, reason: invalid class name */
    public /* synthetic */ class AnonymousClass4 extends C0916Sp implements InterfaceC3588op {
        public AnonymousClass4(Object obj) {
            super(0, obj, PageFetcher.class, "invalidate", "invalidate()V", 0);
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5433invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5433invoke() {
            ((PageFetcher) this.receiver).invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcher$injectRemoteEvents$1", f = "PageFetcher.kt", l = {203}, m = "invokeSuspend")
    public static final class C17011 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $accessor;
        final /* synthetic */ MutableLoadStateCollection $sourceStates;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> $this_injectRemoteEvents;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17011(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, MutableLoadStateCollection mutableLoadStateCollection, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$accessor = remoteMediatorAccessor;
            this.$this_injectRemoteEvents = pageFetcherSnapshot;
            this.$sourceStates = mutableLoadStateCollection;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C17011 c17011 = new C17011(this.$accessor, this.$this_injectRemoteEvents, this.$sourceStates, interfaceC0793Of);
            c17011.L$0 = obj;
            return c17011;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C17011) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                final SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
                InterfaceC0939Tm interfaceC0939TmSimpleChannelFlow = SimpleChannelFlowKt.simpleChannelFlow(new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.$accessor.getState(), this.$this_injectRemoteEvents.getPageEventFlow(), null, this.$sourceStates));
                InterfaceC0995Vm interfaceC0995Vm = new InterfaceC0995Vm() { // from class: androidx.paging.PageFetcher.injectRemoteEvents.1.2
                    @Override // defpackage.InterfaceC0995Vm
                    public final Object emit(PageEvent<Value> pageEvent, InterfaceC0793Of interfaceC0793Of) {
                        Object objSend = simpleProducerScope.send(pageEvent, interfaceC0793Of);
                        return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
                    }
                };
                this.label = 1;
                if (interfaceC0939TmSimpleChannelFlow.collect(interfaceC0995Vm, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    public PageFetcher(InterfaceC3750qp interfaceC3750qp, Key key, PagingConfig pagingConfig, RemoteMediator<Key, Value> remoteMediator) {
        AbstractC4492zt.h(interfaceC3750qp, "pagingSourceFactory");
        AbstractC4492zt.h(pagingConfig, "config");
        this.pagingSourceFactory = interfaceC3750qp;
        this.initialKey = key;
        this.config = pagingConfig;
        this.refreshEvents = new ConflatedEventBus<>(null, 1, null);
        this.retryEvents = new ConflatedEventBus<>(null, 1, null);
        this.flow = SimpleChannelFlowKt.simpleChannelFlow(new PageFetcher$flow$1(remoteMediator, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object generateNewPagingSource(PagingSource<Key, Value> pagingSource, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        PageFetcher<Key, Value> pageFetcher;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
        }
        Object objInvoke = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(objInvoke);
            InterfaceC3750qp interfaceC3750qp = this.pagingSourceFactory;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = pagingSource;
            anonymousClass1.label = 1;
            objInvoke = interfaceC3750qp.invoke(anonymousClass1);
            if (objInvoke == objD) {
                return objD;
            }
            pageFetcher = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pagingSource = (PagingSource) anonymousClass1.L$1;
            pageFetcher = (PageFetcher) anonymousClass1.L$0;
            LL.b(objInvoke);
        }
        PagingSource<Key, Value> pagingSource2 = (PagingSource) objInvoke;
        if (pagingSource2 instanceof LegacyPagingSource) {
            ((LegacyPagingSource) pagingSource2).setPageSize(pageFetcher.config.pageSize);
        }
        if (pagingSource2 == pagingSource) {
            throw new IllegalStateException("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.");
        }
        pagingSource2.registerInvalidatedCallback(new AnonymousClass3(pageFetcher));
        if (pagingSource != null) {
            pagingSource.unregisterInvalidatedCallback(new AnonymousClass4(pageFetcher));
        }
        if (pagingSource != null) {
            pagingSource.invalidate();
        }
        Logger logger = LoggerKt.getLOGGER();
        if (logger != null && logger.isLoggable(3)) {
            logger.log(3, "Generated new PagingSource " + pagingSource2, null);
        }
        return pagingSource2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC0939Tm injectRemoteEvents(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC1830bu interfaceC1830bu, RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor) {
        return remoteMediatorAccessor == null ? pageFetcherSnapshot.getPageEventFlow() : CancelableChannelFlowKt.cancelableChannelFlow(interfaceC1830bu, new C17011(remoteMediatorAccessor, pageFetcherSnapshot, new MutableLoadStateCollection(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidate() {
        this.refreshEvents.send(Boolean.FALSE);
    }

    public final InterfaceC0939Tm getFlow() {
        return this.flow;
    }

    public final void refresh() {
        this.refreshEvents.send(Boolean.TRUE);
    }

    public /* synthetic */ PageFetcher(InterfaceC3750qp interfaceC3750qp, Object obj, PagingConfig pagingConfig, RemoteMediator remoteMediator, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC3750qp, obj, pagingConfig, (i & 8) != 0 ? null : remoteMediator);
    }
}
