package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC3511nu;
import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0348Ap;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0803Op;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.XS;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", l = {ShapeTypes.FLOW_CHART_INTERNAL_STORAGE}, m = "invokeSuspend")
public final class PageFetcher$flow$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ RemoteMediator<Key, Value> $remoteMediator;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PageFetcher<Key, Value> this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", l = {63, 63}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$remoteMediatorAccessor, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0043  */
        /* JADX WARN: Code duplicated, block: B:23:0x0052 A[RETURN] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC0995Vm interfaceC0995Vm;
            RemoteMediator.InitializeAction initializeAction;
            Boolean boolA;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
                    LL.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
            LL.b(obj);
            interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
            RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor = this.$remoteMediatorAccessor;
            if (remoteMediatorAccessor != 0) {
                this.L$0 = interfaceC0995Vm;
                this.label = 1;
                obj = remoteMediatorAccessor.initialize(this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                initializeAction = null;
            }
            boolA = E8.a(initializeAction == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH);
            this.L$0 = null;
            this.label = 2;
            if (interfaceC0995Vm.emit(boolA, this) == objD) {
                return objD;
            }
            return FW.a;
            initializeAction = (RemoteMediator.InitializeAction) obj;
            boolA = E8.a(initializeAction == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH);
            this.L$0 = null;
            this.label = 2;
            if (interfaceC0995Vm.emit(boolA, this) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", l = {73, 77}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        /* synthetic */ Object L$0;
        Object L$1;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2$1, reason: invalid class name */
        public /* synthetic */ class AnonymousClass1 extends C0916Sp implements InterfaceC3588op {
            public AnonymousClass1(Object obj) {
                super(0, obj, PageFetcher.class, "refresh", "refresh()V", 0);
            }

            @Override // defpackage.InterfaceC3588op
            public /* bridge */ /* synthetic */ Object invoke() {
                m5431invoke();
                return FW.a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m5431invoke() {
                ((PageFetcher) this.receiver).refresh();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, PageFetcher<Key, Value> pageFetcher, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
            this.this$0 = pageFetcher;
        }

        public final Object invoke(PageFetcher.GenerationInfo<Key, Value> generationInfo, boolean z, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteMediatorAccessor, this.this$0, interfaceC0793Of);
            anonymousClass2.L$0 = generationInfo;
            anonymousClass2.Z$0 = z;
            return anonymousClass2.invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x007c  */
        /* JADX WARN: Code duplicated, block: B:37:0x0081  */
        /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:52:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:58:0x00be  */
        /* JADX WARN: Code duplicated, block: B:60:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:64:0x00cf  */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            PageFetcher.GenerationInfo generationInfo;
            PageFetcherSnapshot snapshot;
            RemoteMediatorConnection remoteMediatorConnection;
            PagingSource pagingSource;
            PagingState state;
            PageFetcherSnapshot snapshot2;
            PagingSource pagingSource2;
            List pages;
            List list;
            PagingState state2;
            List pages2;
            Integer anchorPosition;
            Object refreshKey;
            Logger logger;
            InterfaceC1830bu job;
            PageFetcherSnapshot snapshot3;
            Integer anchorPosition2;
            PagingState state3;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                    LL.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pagingSource2 = (PagingSource) this.L$1;
                    generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                    LL.b(obj);
                }
                state = (PagingState) obj;
                pagingSource = pagingSource2;
                if (state != null) {
                    pages = state.getPages();
                } else {
                    pages = null;
                }
                list = pages;
                if ((list != null || list.isEmpty()) && generationInfo != null && (state2 = generationInfo.getState()) != null && (pages2 = state2.getPages()) != null && (!pages2.isEmpty())) {
                }
                if (state != null) {
                    anchorPosition = state.getAnchorPosition();
                } else {
                    anchorPosition = null;
                }
                if (anchorPosition == null) {
                    if (generationInfo != null || (state3 = generationInfo.getState()) == null) {
                        anchorPosition2 = null;
                    } else {
                        anchorPosition2 = state3.getAnchorPosition();
                    }
                    if (anchorPosition2 != null) {
                        state = generationInfo.getState();
                    }
                }
                if (state == null) {
                    refreshKey = ((PageFetcher) this.this$0).initialKey;
                } else {
                    refreshKey = pagingSource.getRefreshKey(state);
                    logger = LoggerKt.getLOGGER();
                    if (logger != null && logger.isLoggable(3)) {
                        logger.log(3, "Refresh key " + refreshKey + " returned from PagingSource " + pagingSource, null);
                    }
                }
                Object obj2 = refreshKey;
                if (generationInfo != null && (snapshot3 = generationInfo.getSnapshot()) != null) {
                    snapshot3.close();
                }
                if (generationInfo != null && (job = generationInfo.getJob()) != null) {
                    InterfaceC1830bu.a.a(job, null, 1, null);
                }
                return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(obj2, pagingSource, ((PageFetcher) this.this$0).config, ((PageFetcher) this.this$0).retryEvents.getFlow(), this.$remoteMediatorAccessor, state, new AnonymousClass1(this.this$0)), state, AbstractC3511nu.b(null, 1, null));
            }
            LL.b(obj);
            PageFetcher.GenerationInfo generationInfo2 = (PageFetcher.GenerationInfo) this.L$0;
            if (this.Z$0 && (remoteMediatorConnection = this.$remoteMediatorAccessor) != null) {
                remoteMediatorConnection.allowRefresh();
            }
            PageFetcher<Key, Value> pageFetcher = this.this$0;
            PagingSource pagingSource$paging_common = (generationInfo2 == null || (snapshot = generationInfo2.getSnapshot()) == null) ? null : snapshot.getPagingSource$paging_common();
            this.L$0 = generationInfo2;
            this.label = 1;
            Object objGenerateNewPagingSource = pageFetcher.generateNewPagingSource(pagingSource$paging_common, this);
            if (objGenerateNewPagingSource == objD) {
                return objD;
            }
            generationInfo = generationInfo2;
            obj = objGenerateNewPagingSource;
            PagingSource pagingSource3 = (PagingSource) obj;
            if (generationInfo == null || (snapshot2 = generationInfo.getSnapshot()) == null) {
                pagingSource = pagingSource3;
                state = null;
            } else {
                this.L$0 = generationInfo;
                this.L$1 = pagingSource3;
                this.label = 2;
                Object objCurrentPagingState = snapshot2.currentPagingState(this);
                if (objCurrentPagingState == objD) {
                    return objD;
                }
                pagingSource2 = pagingSource3;
                obj = objCurrentPagingState;
                state = (PagingState) obj;
                pagingSource = pagingSource2;
            }
            if (state != null) {
                pages = state.getPages();
            } else {
                pages = null;
            }
            list = pages;
            state = list != null ? generationInfo.getState() : generationInfo.getState();
            if (state != null) {
                anchorPosition = state.getAnchorPosition();
            } else {
                anchorPosition = null;
            }
            if (anchorPosition == null) {
                if (generationInfo != null) {
                    anchorPosition2 = null;
                } else {
                    anchorPosition2 = null;
                }
                if (anchorPosition2 != null) {
                    state = generationInfo.getState();
                }
            }
            if (state == null) {
                refreshKey = ((PageFetcher) this.this$0).initialKey;
            } else {
                refreshKey = pagingSource.getRefreshKey(state);
                logger = LoggerKt.getLOGGER();
                if (logger != null) {
                    logger.log(3, "Refresh key " + refreshKey + " returned from PagingSource " + pagingSource, null);
                }
            }
            Object obj3 = refreshKey;
            if (generationInfo != null) {
                snapshot3.close();
            }
            if (generationInfo != null) {
                InterfaceC1830bu.a.a(job, null, 1, null);
            }
            return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(obj3, pagingSource, ((PageFetcher) this.this$0).config, ((PageFetcher) this.this$0).retryEvents.getFlow(), this.$remoteMediatorAccessor, state, new AnonymousClass1(this.this$0)), state, AbstractC3511nu.b(null, 1, null));
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((PageFetcher.GenerationInfo) obj, ((Boolean) obj2).booleanValue(), (InterfaceC0793Of) obj3);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$4, reason: invalid class name */
    public /* synthetic */ class AnonymousClass4 implements InterfaceC0995Vm, InterfaceC0803Op {
        final /* synthetic */ SimpleProducerScope<PagingData<Value>> $tmp0;

        public AnonymousClass4(SimpleProducerScope<PagingData<Value>> simpleProducerScope) {
            this.$tmp0 = simpleProducerScope;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(PagingData<Value> pagingData, InterfaceC0793Of interfaceC0793Of) {
            Object objSend = this.$tmp0.send(pagingData, interfaceC0793Of);
            return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof InterfaceC0995Vm) && (obj instanceof InterfaceC0803Op)) {
                return AbstractC4492zt.d(getFunctionDelegate(), ((InterfaceC0803Op) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // defpackage.InterfaceC0803Op
        public final InterfaceC0348Ap getFunctionDelegate() {
            return new C0916Sp(2, this.$tmp0, SimpleProducerScope.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$flow$1(RemoteMediator<Key, Value> remoteMediator, PageFetcher<Key, Value> pageFetcher, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$remoteMediator = remoteMediator;
        this.this$0 = pageFetcher;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PageFetcher$flow$1 pageFetcher$flow$1 = new PageFetcher$flow$1(this.$remoteMediator, this.this$0, interfaceC0793Of);
        pageFetcher$flow$1.L$0 = obj;
        return pageFetcher$flow$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SimpleProducerScope<PagingData<Value>> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
        return ((PageFetcher$flow$1) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            RemoteMediator<Key, Value> remoteMediator = this.$remoteMediator;
            RemoteMediatorAccessor RemoteMediatorAccessor = remoteMediator != 0 ? RemoteMediatorAccessorKt.RemoteMediatorAccessor(simpleProducerScope, remoteMediator) : null;
            InterfaceC0939Tm interfaceC0939TmSimpleTransformLatest = FlowExtKt.simpleTransformLatest(AbstractC1047Xm.p(FlowExtKt.simpleScan(AbstractC1047Xm.B(((PageFetcher) this.this$0).refreshEvents.getFlow(), new AnonymousClass1(RemoteMediatorAccessor, null)), null, new AnonymousClass2(RemoteMediatorAccessor, this.this$0, null))), new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(null, this.this$0, RemoteMediatorAccessor));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(simpleProducerScope);
            this.label = 1;
            if (interfaceC0939TmSimpleTransformLatest.collect(anonymousClass4, this) == objD) {
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
