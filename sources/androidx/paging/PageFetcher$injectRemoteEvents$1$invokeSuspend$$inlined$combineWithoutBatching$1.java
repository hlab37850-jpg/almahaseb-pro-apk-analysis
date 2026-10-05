package androidx.paging;

import defpackage.AD;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3511nu;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1243ae;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import defpackage.ZZ;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1", f = "PageFetcher.kt", l = {ShapeTypes.ACTION_BUTTON_HOME}, m = "invokeSuspend")
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC0939Tm $otherFlow;
    final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
    final /* synthetic */ InterfaceC0939Tm $this_combineWithoutBatching;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1", f = "PageFetcher.kt", l = {ShapeTypes.FLOW_CHART_MANUAL_OPERATION}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0578Hp {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SimpleProducerScope simpleProducerScope, InterfaceC0793Of interfaceC0793Of, MutableLoadStateCollection mutableLoadStateCollection) {
            super(4, interfaceC0793Of);
            this.$sourceStates$inlined = mutableLoadStateCollection;
            this.$$this$simpleChannelFlow = simpleProducerScope;
        }

        public final Object invoke(LoadStates loadStates, PageEvent<Value> pageEvent, CombineSource combineSource, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$simpleChannelFlow, interfaceC0793Of, this.$sourceStates$inlined);
            anonymousClass1.L$0 = loadStates;
            anonymousClass1.L$1 = pageEvent;
            anonymousClass1.L$2 = combineSource;
            return anonymousClass1.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                Object obj2 = this.L$0;
                Object obj3 = this.L$1;
                CombineSource combineSource = (CombineSource) this.L$2;
                InterfaceC4038uO interfaceC4038uO = this.$$this$simpleChannelFlow;
                Object loadStateUpdate = (PageEvent) obj3;
                LoadStates loadStates = (LoadStates) obj2;
                if (combineSource == CombineSource.RECEIVER) {
                    loadStateUpdate = new PageEvent.LoadStateUpdate(this.$sourceStates$inlined.snapshot(), loadStates);
                } else if (loadStateUpdate instanceof PageEvent.Insert) {
                    PageEvent.Insert insert = (PageEvent.Insert) loadStateUpdate;
                    this.$sourceStates$inlined.set(insert.getSourceLoadStates());
                    loadStateUpdate = PageEvent.Insert.copy$default(insert, null, null, 0, 0, insert.getSourceLoadStates(), loadStates, 15, null);
                } else if (loadStateUpdate instanceof PageEvent.Drop) {
                    this.$sourceStates$inlined.set(((PageEvent.Drop) loadStateUpdate).getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
                } else {
                    if (!(loadStateUpdate instanceof PageEvent.LoadStateUpdate)) {
                        if (loadStateUpdate instanceof PageEvent.StaticList) {
                            throw new IllegalStateException("Paging generated an event to display a static list that\n originated from a paginated source. If you see this\n exception, it is most likely a bug in the library.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106");
                        }
                        throw new AD();
                    }
                    PageEvent.LoadStateUpdate loadStateUpdate2 = (PageEvent.LoadStateUpdate) loadStateUpdate;
                    this.$sourceStates$inlined.set(loadStateUpdate2.getSource());
                    loadStateUpdate = new PageEvent.LoadStateUpdate(loadStateUpdate2.getSource(), loadStates);
                }
                this.label = 1;
                if (interfaceC4038uO.send(loadStateUpdate, this) == objD) {
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

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((LoadStates) obj, obj2, (CombineSource) obj3, (InterfaceC0793Of) obj4);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", l = {148}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ InterfaceC0939Tm $flow;
        final /* synthetic */ AtomicInteger $incompleteFlows;
        final /* synthetic */ int $index;
        final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements InterfaceC0995Vm {
            final /* synthetic */ int $index;
            final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;

            /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01541 extends AbstractC0819Pf {
                int label;
                /* synthetic */ Object result;

                public C01541(InterfaceC0793Of interfaceC0793Of) {
                    super(interfaceC0793Of);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return AnonymousClass1.this.emit(null, this);
                }
            }

            public AnonymousClass1(UnbatchedFlowCombiner unbatchedFlowCombiner, int i) {
                this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
                this.$index = i;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                C01541 c01541;
                if (interfaceC0793Of instanceof C01541) {
                    c01541 = (C01541) interfaceC0793Of;
                    int i = c01541.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c01541.label = i - Integer.MIN_VALUE;
                    } else {
                        c01541 = new C01541(interfaceC0793Of);
                    }
                } else {
                    c01541 = new C01541(interfaceC0793Of);
                }
                Object obj2 = c01541.result;
                Object objD = AbstractC0378Bt.d();
                int i2 = c01541.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        LL.b(obj2);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj2);
                    }
                    return FW.a;
                }
                LL.b(obj2);
                UnbatchedFlowCombiner unbatchedFlowCombiner = this.$unbatchedFlowCombiner;
                int i3 = this.$index;
                c01541.label = 1;
                if (unbatchedFlowCombiner.onNext(i3, obj, c01541) == objD) {
                    return objD;
                }
                c01541.label = 2;
                if (ZZ.a(c01541) == objD) {
                    return objD;
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0939Tm interfaceC0939Tm, AtomicInteger atomicInteger, SimpleProducerScope simpleProducerScope, UnbatchedFlowCombiner unbatchedFlowCombiner, int i, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$flow = interfaceC0939Tm;
            this.$incompleteFlows = atomicInteger;
            this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
            this.$index = i;
            this.$$this$simpleChannelFlow = simpleProducerScope;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i == 0) {
                    LL.b(obj);
                    InterfaceC0939Tm interfaceC0939Tm = this.$flow;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$unbatchedFlowCombiner, this.$index);
                    this.label = 1;
                    if (interfaceC0939Tm.collect(anonymousClass1, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                if (this.$incompleteFlows.decrementAndGet() == 0) {
                    InterfaceC4038uO.a.a(this.$$this$simpleChannelFlow, null, 1, null);
                }
                return FW.a;
            } catch (Throwable th) {
                if (this.$incompleteFlows.decrementAndGet() == 0) {
                    InterfaceC4038uO.a.a(this.$$this$simpleChannelFlow, null, 1, null);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC1243ae $parentJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC1243ae interfaceC1243ae) {
            super(0);
            this.$parentJob = interfaceC1243ae;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5434invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5434invoke() {
            InterfaceC1830bu.a.a(this.$parentJob, null, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0939Tm interfaceC0939Tm2, InterfaceC0793Of interfaceC0793Of, MutableLoadStateCollection mutableLoadStateCollection) {
        super(2, interfaceC0793Of);
        this.$this_combineWithoutBatching = interfaceC0939Tm;
        this.$otherFlow = interfaceC0939Tm2;
        this.$sourceStates$inlined = mutableLoadStateCollection;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 = new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.$this_combineWithoutBatching, this.$otherFlow, interfaceC0793Of, this.$sourceStates$inlined);
        pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.L$0 = obj;
        return pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
        return ((PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = 0;
        Object objD = AbstractC0378Bt.d();
        int i2 = this.label;
        if (i2 == 0) {
            LL.b(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new AnonymousClass1(simpleProducerScope, null, this.$sourceStates$inlined));
            InterfaceC1243ae interfaceC1243aeB = AbstractC3511nu.b(null, 1, null);
            InterfaceC0939Tm[] interfaceC0939TmArr = {this.$this_combineWithoutBatching, this.$otherFlow};
            int i3 = 0;
            while (i < 2) {
                O8.d(simpleProducerScope, interfaceC1243aeB, null, new AnonymousClass2(interfaceC0939TmArr[i], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i3, null), 2, null);
                i++;
                i3++;
                interfaceC0939TmArr = interfaceC0939TmArr;
            }
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(interfaceC1243aeB);
            this.label = 1;
            if (simpleProducerScope.awaitClose(anonymousClass3, this) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return FW.a;
    }
}
