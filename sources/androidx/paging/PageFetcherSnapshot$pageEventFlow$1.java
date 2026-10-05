package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC2287gb;
import defpackage.C0876Rb;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.GC;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", l = {645, ShapeTypes.ACTION_BUTTON_BEGINNING, 657}, m = "invokeSuspend")
public final class PageFetcherSnapshot$pageEventFlow$1 extends XS implements InterfaceC0526Fp {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2", f = "PageFetcherSnapshot.kt", l = {91}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements InterfaceC0995Vm {
            final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;

            public AnonymousClass1(SimpleProducerScope<PageEvent<Value>> simpleProducerScope) {
                this.$$this$cancelableChannelFlow = simpleProducerScope;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
            public final Object emit(PageEvent<Value> pageEvent, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1;
                if (interfaceC0793Of instanceof PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) {
                    pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 = (PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) interfaceC0793Of;
                    int i = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 = new PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1(this, interfaceC0793Of);
                    }
                } else {
                    pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 = new PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1(this, interfaceC0793Of);
                }
                Object obj = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.result;
                Object objD = AbstractC0378Bt.d();
                int i2 = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label;
                try {
                    if (i2 == 0) {
                        LL.b(obj);
                        InterfaceC4038uO interfaceC4038uO = this.$$this$cancelableChannelFlow;
                        pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label = 1;
                        if (interfaceC4038uO.send(pageEvent, pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) == objD) {
                            return objD;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                } catch (C0876Rb unused) {
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, SimpleProducerScope<PageEvent<Value>> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
            this.$$this$cancelableChannelFlow = simpleProducerScope;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, this.$$this$cancelableChannelFlow, interfaceC0793Of);
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
            if (i == 0) {
                LL.b(obj);
                InterfaceC0939Tm interfaceC0939TmI = AbstractC1047Xm.i(((PageFetcherSnapshot) this.this$0).pageEventCh);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$cancelableChannelFlow);
                this.label = 1;
                if (interfaceC0939TmI.collect(anonymousClass1, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3", f = "PageFetcherSnapshot.kt", l = {105}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC1009Wa $retryChannel;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC1009Wa interfaceC1009Wa, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
            this.$retryChannel = interfaceC1009Wa;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass3(this.this$0, this.$retryChannel, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass3) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC0939Tm interfaceC0939Tm = ((PageFetcherSnapshot) this.this$0).retryFlow;
                final InterfaceC1009Wa interfaceC1009Wa = this.$retryChannel;
                InterfaceC0995Vm interfaceC0995Vm = new InterfaceC0995Vm() { // from class: androidx.paging.PageFetcherSnapshot.pageEventFlow.1.3.1
                    @Override // defpackage.InterfaceC0995Vm
                    public final Object emit(FW fw, InterfaceC0793Of interfaceC0793Of) {
                        interfaceC1009Wa.mo0trySendJP2dKIU(fw);
                        return FW.a;
                    }
                };
                this.label = 1;
                if (interfaceC0939Tm.collect(interfaceC0995Vm, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4", f = "PageFetcherSnapshot.kt", l = {110}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC1009Wa $retryChannel;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements InterfaceC0995Vm {
            final /* synthetic */ InterfaceC2052dg $$this$launch;
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoadType.values().length];
                    try {
                        iArr[LoadType.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public AnonymousClass1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC2052dg interfaceC2052dg) {
                this.this$0 = pageFetcherSnapshot;
                this.$$this$launch = interfaceC2052dg;
            }

            /* JADX WARN: Code duplicated, block: B:104:0x0378  */
            /* JADX WARN: Code duplicated, block: B:107:0x0386  */
            /* JADX WARN: Code duplicated, block: B:108:0x038a  */
            /* JADX WARN: Code duplicated, block: B:110:0x03ac A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:111:0x03ad  */
            /* JADX WARN: Code duplicated, block: B:116:0x03de A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:117:0x03df  */
            /* JADX WARN: Code duplicated, block: B:120:0x03e7  */
            /* JADX WARN: Code duplicated, block: B:122:0x0403 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:126:0x0419  */
            /* JADX WARN: Code duplicated, block: B:134:0x042a A[PHI: r1 r4 r15
              0x042a: PHI (r1v53 androidx.paging.LoadStates) = (r1v28 androidx.paging.LoadStates), (r1v60 androidx.paging.LoadStates) binds: [B:89:0x0323, B:127:0x041c] A[DONT_GENERATE, DONT_INLINE]
              0x042a: PHI (r4v52 dg) = (r4v26 dg), (r4v55 dg) binds: [B:89:0x0323, B:127:0x041c] A[DONT_GENERATE, DONT_INLINE]
              0x042a: PHI (r15v51 androidx.paging.PageFetcherSnapshot) = (r15v28 androidx.paging.PageFetcherSnapshot), (r15v52 androidx.paging.PageFetcherSnapshot) binds: [B:89:0x0323, B:127:0x041c] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:136:0x0434  */
            /* JADX WARN: Code duplicated, block: B:138:0x0438  */
            /* JADX WARN: Code duplicated, block: B:140:0x0454 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:141:0x0455  */
            /* JADX WARN: Code duplicated, block: B:144:0x0471 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:145:0x0472  */
            /* JADX WARN: Code duplicated, block: B:150:0x0481  */
            /* JADX WARN: Code duplicated, block: B:153:0x048e  */
            /* JADX WARN: Code duplicated, block: B:154:0x0492  */
            /* JADX WARN: Code duplicated, block: B:156:0x04b2 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:157:0x04b3  */
            /* JADX WARN: Code duplicated, block: B:162:0x04e4 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:163:0x04e5  */
            /* JADX WARN: Code duplicated, block: B:166:0x04ea  */
            /* JADX WARN: Code duplicated, block: B:168:0x0504 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:169:0x0505  */
            /* JADX WARN: Code duplicated, block: B:173:0x051d  */
            /* JADX WARN: Code duplicated, block: B:55:0x0259  */
            /* JADX WARN: Code duplicated, block: B:58:0x026c  */
            /* JADX WARN: Code duplicated, block: B:61:0x027a  */
            /* JADX WARN: Code duplicated, block: B:62:0x027e  */
            /* JADX WARN: Code duplicated, block: B:64:0x029f A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:65:0x02a0  */
            /* JADX WARN: Code duplicated, block: B:70:0x02d0 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:71:0x02d1  */
            /* JADX WARN: Code duplicated, block: B:74:0x02d9  */
            /* JADX WARN: Code duplicated, block: B:76:0x02f4 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code duplicated, block: B:80:0x030a  */
            /* JADX WARN: Code duplicated, block: B:88:0x031b A[PHI: r1 r4 r15
              0x031b: PHI (r1v28 androidx.paging.LoadStates) = (r1v7 androidx.paging.LoadStates), (r1v31 androidx.paging.LoadStates) binds: [B:57:0x026a, B:81:0x030d] A[DONT_GENERATE, DONT_INLINE]
              0x031b: PHI (r4v26 dg) = (r4v6 dg), (r4v29 dg) binds: [B:57:0x026a, B:81:0x030d] A[DONT_GENERATE, DONT_INLINE]
              0x031b: PHI (r15v28 androidx.paging.PageFetcherSnapshot) = (r15v9 androidx.paging.PageFetcherSnapshot), (r15v29 androidx.paging.PageFetcherSnapshot) binds: [B:57:0x026a, B:81:0x030d] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:90:0x0325  */
            /* JADX WARN: Code duplicated, block: B:92:0x0329  */
            /* JADX WARN: Code duplicated, block: B:94:0x0346 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:95:0x0347  */
            /* JADX WARN: Code duplicated, block: B:98:0x0367 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:99:0x0368  */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [GC] */
            /* JADX WARN: Type inference failed for: r1v14, types: [GC] */
            /* JADX WARN: Type inference failed for: r1v2, types: [GC] */
            /* JADX WARN: Type inference failed for: r1v3, types: [GC] */
            /* JADX WARN: Type inference failed for: r1v39, types: [GC] */
            /* JADX WARN: Type inference failed for: r1v68, types: [GC] */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r1v92 */
            /* JADX WARN: Type inference failed for: r1v93 */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(FW fw, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1;
                PageFetcherSnapshotState.Holder holder;
                PageFetcherSnapshot pageFetcherSnapshot;
                GC gc;
                AnonymousClass1<T> anonymousClass1;
                LoadStates loadStates;
                PagingState pagingState;
                RemoteMediatorConnection remoteMediatorConnection;
                PageFetcherSnapshot pageFetcherSnapshot2;
                InterfaceC2052dg interfaceC2052dg;
                LoadType loadType;
                LoadStates loadStates2;
                InterfaceC2052dg interfaceC2052dg2;
                LoadType loadType2;
                PageFetcherSnapshot pageFetcherSnapshot3;
                InterfaceC2052dg interfaceC2052dg3;
                PageFetcherSnapshot pageFetcherSnapshot4;
                LoadStates loadStates3;
                PageFetcherSnapshotState.Holder holder2;
                GC gc2;
                PageFetcherSnapshot pageFetcherSnapshot5;
                LoadType loadType3;
                PageFetcherSnapshot pageFetcherSnapshot6;
                ViewportHint viewportHint;
                LoadType loadType4;
                PageFetcherSnapshot pageFetcherSnapshot7;
                LoadType loadType5;
                InterfaceC2052dg interfaceC2052dg4;
                LoadStates loadStates4;
                PageFetcherSnapshotState.Holder holder3;
                GC gc3;
                LoadType loadType6;
                LoadStates loadStates5;
                InterfaceC2052dg interfaceC2052dg5;
                LoadType loadType7;
                PageFetcherSnapshot pageFetcherSnapshot8;
                PageFetcherSnapshotState.Holder holder4;
                GC gc4;
                LoadStates loadStates6;
                GC gc5;
                InterfaceC2052dg interfaceC2052dg6;
                PageFetcherSnapshotState.Holder holder5;
                LoadState loadState;
                PageFetcherSnapshotState pageFetcherSnapshotState;
                InterfaceC2052dg interfaceC2052dg7;
                PageFetcherSnapshot pageFetcherSnapshot9;
                PageFetcherSnapshotState.Holder holder6;
                GC gc6;
                PageFetcherSnapshot pageFetcherSnapshot10;
                LoadType loadType8;
                PageFetcherSnapshot pageFetcherSnapshot11;
                ViewportHint viewportHint2;
                LoadType loadType9;
                PageFetcherSnapshot pageFetcherSnapshot12;
                LoadType loadType10;
                InterfaceC2052dg interfaceC2052dg8;
                LoadStates loadStates7;
                PageFetcherSnapshotState.Holder holder7;
                GC gc7;
                LoadType loadType11;
                PageFetcherSnapshot pageFetcherSnapshot13;
                InterfaceC2052dg interfaceC2052dg9;
                LoadType loadType12;
                PageFetcherSnapshotState.Holder holder8;
                GC gc8;
                PageFetcherSnapshotState.Holder holder9;
                GC gc9;
                InterfaceC2052dg interfaceC2052dg10;
                LoadState loadState2;
                PageFetcherSnapshotState pageFetcherSnapshotState2;
                InterfaceC2052dg interfaceC2052dg11;
                PageFetcherSnapshot pageFetcherSnapshot14;
                PageFetcherSnapshotState.Holder holder10;
                GC gc10;
                PageFetcherSnapshot pageFetcherSnapshot15;
                LoadType loadType13;
                LoadType loadType14;
                GC gc11;
                PageFetcherSnapshot pageFetcherSnapshot16;
                ViewportHint viewportHint3;
                LoadType loadType15;
                InterfaceC2052dg interfaceC2052dg12;
                PageFetcherSnapshotState.Holder holder11;
                GC gc12;
                PageFetcherSnapshot pageFetcherSnapshot17;
                GC gc13;
                PageFetcherSnapshotState.Holder holder12;
                LoadState loadState3;
                if (interfaceC0793Of instanceof PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) {
                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 = (PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) interfaceC0793Of;
                    int i = pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 = new PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1(this, interfaceC0793Of);
                    }
                } else {
                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 = new PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1(this, interfaceC0793Of);
                }
                Object obj = pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.result;
                Object objD = AbstractC0378Bt.d();
                ?? r1 = pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label;
                try {
                    try {
                        try {
                            switch (r1) {
                                case 0:
                                    LL.b(obj);
                                    holder = this.this$0.stateHolder;
                                    pageFetcherSnapshot = this.this$0;
                                    gc = holder.lock;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = this;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = holder;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = pageFetcherSnapshot;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 1;
                                    if (gc.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    anonymousClass1 = this;
                                    try {
                                        PageFetcherSnapshotState pageFetcherSnapshotState3 = holder.state;
                                        C2020dG c2020dGA = HV.a(pageFetcherSnapshotState3.getSourceLoadStates$paging_common().snapshot(), pageFetcherSnapshotState3.currentPagingState$paging_common(pageFetcherSnapshot.hintHandler.getLastAccessHint()));
                                        gc.b(null);
                                        loadStates = (LoadStates) c2020dGA.a();
                                        pagingState = (PagingState) c2020dGA.b();
                                        remoteMediatorConnection = anonymousClass1.this$0.getRemoteMediatorConnection();
                                        if (remoteMediatorConnection != null) {
                                            remoteMediatorConnection.retryFailed(pagingState);
                                            FW fw2 = FW.a;
                                        }
                                        pageFetcherSnapshot2 = anonymousClass1.this$0;
                                        interfaceC2052dg = anonymousClass1.$$this$launch;
                                        loadType = LoadType.REFRESH;
                                        if (loadStates.getRefresh() instanceof LoadState.Error) {
                                            loadType6 = LoadType.PREPEND;
                                            if (loadStates.getPrepend() instanceof LoadState.Error) {
                                                if (loadType6 != LoadType.REFRESH) {
                                                    holder4 = pageFetcherSnapshot2.stateHolder;
                                                    gc4 = holder4.lock;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                                    if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                        return objD;
                                                    }
                                                    loadStates6 = loadStates;
                                                    gc5 = gc4;
                                                    interfaceC2052dg6 = interfaceC2052dg;
                                                    holder5 = holder4;
                                                    pageFetcherSnapshotState = holder5.state;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                                    if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                        return objD;
                                                    }
                                                    loadType7 = loadType6;
                                                    interfaceC2052dg7 = interfaceC2052dg6;
                                                    pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                                    r1 = gc5;
                                                    FW fw3 = FW.a;
                                                    r1.b(null);
                                                    interfaceC2052dg5 = interfaceC2052dg7;
                                                    pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                                    loadStates5 = loadStates6;
                                                } else {
                                                    loadStates5 = loadStates;
                                                    interfaceC2052dg5 = interfaceC2052dg;
                                                    loadType7 = loadType6;
                                                    pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                                }
                                                if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                                    pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                    viewportHint2 = null;
                                                    loadType9 = loadType7;
                                                } else {
                                                    holder6 = pageFetcherSnapshot8.stateHolder;
                                                    gc6 = holder6.lock;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                                    if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                        return objD;
                                                    }
                                                    pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                                    loadType8 = loadType7;
                                                    viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                                    gc6.b(null);
                                                    pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                    loadType9 = loadType7;
                                                    loadType7 = loadType8;
                                                    pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                                }
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                                if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                                loadType10 = loadType7;
                                                interfaceC2052dg8 = interfaceC2052dg5;
                                                loadStates7 = loadStates5;
                                                if (loadType10 == LoadType.REFRESH) {
                                                    holder7 = pageFetcherSnapshot12.stateHolder;
                                                    gc7 = holder7.lock;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                                    if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                        return objD;
                                                    }
                                                    loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                    gc7.b(null);
                                                    if (!(loadState2 instanceof LoadState.Error)) {
                                                        pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                                    }
                                                }
                                                interfaceC2052dg = interfaceC2052dg8;
                                                pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                                loadStates = loadStates7;
                                            }
                                            return FW.a;
                                        }
                                        loadStates2 = loadStates;
                                        interfaceC2052dg2 = interfaceC2052dg;
                                        loadType2 = loadType;
                                        pageFetcherSnapshot3 = pageFetcherSnapshot2;
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                            pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                            viewportHint = null;
                                            loadType4 = loadType2;
                                        } else {
                                            holder2 = pageFetcherSnapshot3.stateHolder;
                                            gc2 = holder2.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 4;
                                            if (gc2.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                            loadType3 = loadType2;
                                            try {
                                                viewportHint = holder2.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                                gc2.b(null);
                                                pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                                loadType4 = loadType2;
                                                loadType2 = loadType3;
                                                pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                            } catch (Throwable th) {
                                                gc2.b(null);
                                                throw th;
                                            }
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                        if (pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot7 = pageFetcherSnapshot3;
                                        loadType5 = loadType2;
                                        interfaceC2052dg4 = interfaceC2052dg2;
                                        loadStates4 = loadStates2;
                                        if (loadType5 == LoadType.REFRESH) {
                                            holder3 = pageFetcherSnapshot7.stateHolder;
                                            gc3 = holder3.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                            if (gc3.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            try {
                                                loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc3.b(null);
                                                if (!(loadState instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                                }
                                            } catch (Throwable th2) {
                                                gc3.b(null);
                                                throw th2;
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg4;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                        loadStates = loadStates4;
                                        loadType6 = LoadType.PREPEND;
                                        if (loadStates.getPrepend() instanceof LoadState.Error) {
                                            if (loadType6 != LoadType.REFRESH) {
                                                holder4 = pageFetcherSnapshot2.stateHolder;
                                                gc4 = holder4.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                                if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadStates6 = loadStates;
                                                gc5 = gc4;
                                                interfaceC2052dg6 = interfaceC2052dg;
                                                holder5 = holder4;
                                                pageFetcherSnapshotState = holder5.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType7 = loadType6;
                                                interfaceC2052dg7 = interfaceC2052dg6;
                                                pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                                r1 = gc5;
                                                FW fw4 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg5 = interfaceC2052dg7;
                                                pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                                loadStates5 = loadStates6;
                                            } else {
                                                loadStates5 = loadStates;
                                                interfaceC2052dg5 = interfaceC2052dg;
                                                loadType7 = loadType6;
                                                pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                                pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                viewportHint2 = null;
                                                loadType9 = loadType7;
                                            } else {
                                                holder6 = pageFetcherSnapshot8.stateHolder;
                                                gc6 = holder6.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                                if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                                loadType8 = loadType7;
                                                try {
                                                    viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                                    gc6.b(null);
                                                    pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                    loadType9 = loadType7;
                                                    loadType7 = loadType8;
                                                    pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                                } catch (Throwable th3) {
                                                    gc6.b(null);
                                                    throw th3;
                                                }
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                            if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                            loadType10 = loadType7;
                                            interfaceC2052dg8 = interfaceC2052dg5;
                                            loadStates7 = loadStates5;
                                            if (loadType10 == LoadType.REFRESH) {
                                                holder7 = pageFetcherSnapshot12.stateHolder;
                                                gc7 = holder7.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                                if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                try {
                                                    loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                    gc7.b(null);
                                                    if (!(loadState2 instanceof LoadState.Error)) {
                                                        pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                                    }
                                                } catch (Throwable th4) {
                                                    gc7.b(null);
                                                    throw th4;
                                                }
                                            }
                                            interfaceC2052dg = interfaceC2052dg8;
                                            pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                            loadStates = loadStates7;
                                        }
                                        return FW.a;
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg13 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg13;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw5 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                try {
                                                    viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                    gc11.b(null);
                                                    loadType15 = loadType13;
                                                    loadType12 = loadType14;
                                                    pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                    pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                                } catch (Throwable th5) {
                                                    gc11.b(null);
                                                    throw th5;
                                                }
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                try {
                                                    loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                    gc13.b(null);
                                                    if (!(loadState3 instanceof LoadState.Error)) {
                                                        pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                    }
                                                } catch (Throwable th6) {
                                                    gc13.b(null);
                                                    throw th6;
                                                }
                                            }
                                        }
                                        return FW.a;
                                    } catch (Throwable th7) {
                                        gc.b(null);
                                        throw th7;
                                    }
                                case 1:
                                    gc = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    pageFetcherSnapshot = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    holder = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    anonymousClass1 = (AnonymousClass1) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    PageFetcherSnapshotState pageFetcherSnapshotState4 = holder.state;
                                    C2020dG c2020dGA2 = HV.a(pageFetcherSnapshotState4.getSourceLoadStates$paging_common().snapshot(), pageFetcherSnapshotState4.currentPagingState$paging_common(pageFetcherSnapshot.hintHandler.getLastAccessHint()));
                                    gc.b(null);
                                    loadStates = (LoadStates) c2020dGA2.a();
                                    pagingState = (PagingState) c2020dGA2.b();
                                    remoteMediatorConnection = anonymousClass1.this$0.getRemoteMediatorConnection();
                                    if (remoteMediatorConnection != null) {
                                        remoteMediatorConnection.retryFailed(pagingState);
                                        FW fw6 = FW.a;
                                    }
                                    pageFetcherSnapshot2 = anonymousClass1.this$0;
                                    interfaceC2052dg = anonymousClass1.$$this$launch;
                                    loadType = LoadType.REFRESH;
                                    if (loadStates.getRefresh() instanceof LoadState.Error) {
                                        loadType6 = LoadType.PREPEND;
                                        if (loadStates.getPrepend() instanceof LoadState.Error) {
                                            if (loadType6 != LoadType.REFRESH) {
                                                holder4 = pageFetcherSnapshot2.stateHolder;
                                                gc4 = holder4.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                                if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadStates6 = loadStates;
                                                gc5 = gc4;
                                                interfaceC2052dg6 = interfaceC2052dg;
                                                holder5 = holder4;
                                                pageFetcherSnapshotState = holder5.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType7 = loadType6;
                                                interfaceC2052dg7 = interfaceC2052dg6;
                                                pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                                r1 = gc5;
                                                FW fw7 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg5 = interfaceC2052dg7;
                                                pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                                loadStates5 = loadStates6;
                                            } else {
                                                loadStates5 = loadStates;
                                                interfaceC2052dg5 = interfaceC2052dg;
                                                loadType7 = loadType6;
                                                pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                                pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                viewportHint2 = null;
                                                loadType9 = loadType7;
                                            } else {
                                                holder6 = pageFetcherSnapshot8.stateHolder;
                                                gc6 = holder6.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                                if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                                loadType8 = loadType7;
                                                viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                                gc6.b(null);
                                                pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                loadType9 = loadType7;
                                                loadType7 = loadType8;
                                                pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                            if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                            loadType10 = loadType7;
                                            interfaceC2052dg8 = interfaceC2052dg5;
                                            loadStates7 = loadStates5;
                                            if (loadType10 == LoadType.REFRESH) {
                                                holder7 = pageFetcherSnapshot12.stateHolder;
                                                gc7 = holder7.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                                if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc7.b(null);
                                                if (!(loadState2 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                                }
                                            }
                                            interfaceC2052dg = interfaceC2052dg8;
                                            pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                            loadStates = loadStates7;
                                        }
                                        return FW.a;
                                    }
                                    loadStates2 = loadStates;
                                    interfaceC2052dg2 = interfaceC2052dg;
                                    loadType2 = loadType;
                                    pageFetcherSnapshot3 = pageFetcherSnapshot2;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                        pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                        viewportHint = null;
                                        loadType4 = loadType2;
                                    } else {
                                        holder2 = pageFetcherSnapshot3.stateHolder;
                                        gc2 = holder2.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 4;
                                        if (gc2.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                        loadType3 = loadType2;
                                        viewportHint = holder2.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                        gc2.b(null);
                                        pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                        loadType4 = loadType2;
                                        loadType2 = loadType3;
                                        pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                    if (pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot7 = pageFetcherSnapshot3;
                                    loadType5 = loadType2;
                                    interfaceC2052dg4 = interfaceC2052dg2;
                                    loadStates4 = loadStates2;
                                    if (loadType5 == LoadType.REFRESH) {
                                        holder3 = pageFetcherSnapshot7.stateHolder;
                                        gc3 = holder3.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                        if (gc3.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc3.b(null);
                                        if (!(loadState instanceof LoadState.Error)) {
                                            pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg4;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                    loadStates = loadStates4;
                                    loadType6 = LoadType.PREPEND;
                                    if (loadStates.getPrepend() instanceof LoadState.Error) {
                                        if (loadType6 != LoadType.REFRESH) {
                                            holder4 = pageFetcherSnapshot2.stateHolder;
                                            gc4 = holder4.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                            if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadStates6 = loadStates;
                                            gc5 = gc4;
                                            interfaceC2052dg6 = interfaceC2052dg;
                                            holder5 = holder4;
                                            pageFetcherSnapshotState = holder5.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType7 = loadType6;
                                            interfaceC2052dg7 = interfaceC2052dg6;
                                            pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                            r1 = gc5;
                                            FW fw8 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg5 = interfaceC2052dg7;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                        } else {
                                            loadStates5 = loadStates;
                                            interfaceC2052dg5 = interfaceC2052dg;
                                            loadType7 = loadType6;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            viewportHint2 = null;
                                            loadType9 = loadType7;
                                        } else {
                                            holder6 = pageFetcherSnapshot8.stateHolder;
                                            gc6 = holder6.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                            if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                            loadType8 = loadType7;
                                            viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            gc6.b(null);
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                        if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                        loadType10 = loadType7;
                                        interfaceC2052dg8 = interfaceC2052dg5;
                                        loadStates7 = loadStates5;
                                        if (loadType10 == LoadType.REFRESH) {
                                            holder7 = pageFetcherSnapshot12.stateHolder;
                                            gc7 = holder7.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                            if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc7.b(null);
                                            if (!(loadState2 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg8;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                        loadStates = loadStates7;
                                    }
                                    return FW.a;
                                    loadType11 = LoadType.APPEND;
                                    if (loadStates.getAppend() instanceof LoadState.Error) {
                                        if (loadType11 != LoadType.REFRESH) {
                                            holder8 = pageFetcherSnapshot2.stateHolder;
                                            gc8 = holder8.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                            if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            InterfaceC2052dg interfaceC2052dg14 = interfaceC2052dg;
                                            holder9 = holder8;
                                            gc9 = gc8;
                                            interfaceC2052dg10 = interfaceC2052dg14;
                                            pageFetcherSnapshotState2 = holder9.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType12 = loadType11;
                                            interfaceC2052dg11 = interfaceC2052dg10;
                                            pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                            r1 = gc9;
                                            FW fw9 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg9 = interfaceC2052dg11;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                        } else {
                                            pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                            interfaceC2052dg9 = interfaceC2052dg;
                                            loadType12 = loadType11;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            viewportHint3 = null;
                                            loadType15 = loadType12;
                                        } else {
                                            holder10 = pageFetcherSnapshot13.stateHolder;
                                            gc10 = holder10.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                            if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                            loadType13 = loadType12;
                                            loadType14 = loadType13;
                                            gc11 = gc10;
                                            viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                            gc11.b(null);
                                            loadType15 = loadType13;
                                            loadType12 = loadType14;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                        if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        interfaceC2052dg12 = interfaceC2052dg9;
                                        if (loadType12 == LoadType.REFRESH) {
                                            holder11 = pageFetcherSnapshot13.stateHolder;
                                            gc12 = holder11.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                            if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                            gc13 = gc12;
                                            holder12 = holder11;
                                            loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc13.b(null);
                                            if (!(loadState3 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 2:
                                    GC gc14 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                    PageFetcherSnapshotState.Holder holder13 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    LoadType loadType16 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    InterfaceC2052dg interfaceC2052dg15 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    PageFetcherSnapshot pageFetcherSnapshot18 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    LoadStates loadStates8 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    PageFetcherSnapshotState pageFetcherSnapshotState5 = holder13.state;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates8;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot18;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg15;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType16;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc14;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 3;
                                    if (pageFetcherSnapshot18.setLoading(pageFetcherSnapshotState5, loadType16, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    loadType2 = loadType16;
                                    interfaceC2052dg3 = interfaceC2052dg15;
                                    pageFetcherSnapshot4 = pageFetcherSnapshot18;
                                    loadStates3 = loadStates8;
                                    r1 = gc14;
                                    FW fw10 = FW.a;
                                    r1.b(null);
                                    interfaceC2052dg2 = interfaceC2052dg3;
                                    pageFetcherSnapshot3 = pageFetcherSnapshot4;
                                    loadStates2 = loadStates3;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                        pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                        viewportHint = null;
                                        loadType4 = loadType2;
                                    } else {
                                        holder2 = pageFetcherSnapshot3.stateHolder;
                                        gc2 = holder2.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 4;
                                        if (gc2.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                        loadType3 = loadType2;
                                        viewportHint = holder2.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                        gc2.b(null);
                                        pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                        loadType4 = loadType2;
                                        loadType2 = loadType3;
                                        pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                    if (pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot7 = pageFetcherSnapshot3;
                                    loadType5 = loadType2;
                                    interfaceC2052dg4 = interfaceC2052dg2;
                                    loadStates4 = loadStates2;
                                    if (loadType5 == LoadType.REFRESH) {
                                        holder3 = pageFetcherSnapshot7.stateHolder;
                                        gc3 = holder3.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                        if (gc3.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc3.b(null);
                                        if (!(loadState instanceof LoadState.Error)) {
                                            pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg4;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                    loadStates = loadStates4;
                                    loadType6 = LoadType.PREPEND;
                                    if (loadStates.getPrepend() instanceof LoadState.Error) {
                                        if (loadType6 != LoadType.REFRESH) {
                                            holder4 = pageFetcherSnapshot2.stateHolder;
                                            gc4 = holder4.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                            if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadStates6 = loadStates;
                                            gc5 = gc4;
                                            interfaceC2052dg6 = interfaceC2052dg;
                                            holder5 = holder4;
                                            pageFetcherSnapshotState = holder5.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType7 = loadType6;
                                            interfaceC2052dg7 = interfaceC2052dg6;
                                            pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                            r1 = gc5;
                                            FW fw11 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg5 = interfaceC2052dg7;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                        } else {
                                            loadStates5 = loadStates;
                                            interfaceC2052dg5 = interfaceC2052dg;
                                            loadType7 = loadType6;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            viewportHint2 = null;
                                            loadType9 = loadType7;
                                        } else {
                                            holder6 = pageFetcherSnapshot8.stateHolder;
                                            gc6 = holder6.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                            if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                            loadType8 = loadType7;
                                            viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            gc6.b(null);
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                        if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                        loadType10 = loadType7;
                                        interfaceC2052dg8 = interfaceC2052dg5;
                                        loadStates7 = loadStates5;
                                        if (loadType10 == LoadType.REFRESH) {
                                            holder7 = pageFetcherSnapshot12.stateHolder;
                                            gc7 = holder7.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                            if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc7.b(null);
                                            if (!(loadState2 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg8;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                        loadStates = loadStates7;
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg16 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg16;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw12 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    } else {
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg17 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg17;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw13 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 3:
                                    GC gc15 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    loadType2 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg3 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    pageFetcherSnapshot4 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    loadStates3 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    r1 = gc15;
                                    FW fw14 = FW.a;
                                    r1.b(null);
                                    interfaceC2052dg2 = interfaceC2052dg3;
                                    pageFetcherSnapshot3 = pageFetcherSnapshot4;
                                    loadStates2 = loadStates3;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                        pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                        viewportHint = null;
                                        loadType4 = loadType2;
                                    } else {
                                        holder2 = pageFetcherSnapshot3.stateHolder;
                                        gc2 = holder2.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType2;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 4;
                                        if (gc2.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                        loadType3 = loadType2;
                                        viewportHint = holder2.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                        gc2.b(null);
                                        pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                        loadType4 = loadType2;
                                        loadType2 = loadType3;
                                        pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                    if (pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot7 = pageFetcherSnapshot3;
                                    loadType5 = loadType2;
                                    interfaceC2052dg4 = interfaceC2052dg2;
                                    loadStates4 = loadStates2;
                                    if (loadType5 == LoadType.REFRESH) {
                                        holder3 = pageFetcherSnapshot7.stateHolder;
                                        gc3 = holder3.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                        if (gc3.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc3.b(null);
                                        if (!(loadState instanceof LoadState.Error)) {
                                            pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg4;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                    loadStates = loadStates4;
                                    loadType6 = LoadType.PREPEND;
                                    if (loadStates.getPrepend() instanceof LoadState.Error) {
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg18 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg18;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw15 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    } else {
                                        if (loadType6 != LoadType.REFRESH) {
                                            holder4 = pageFetcherSnapshot2.stateHolder;
                                            gc4 = holder4.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                            if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadStates6 = loadStates;
                                            gc5 = gc4;
                                            interfaceC2052dg6 = interfaceC2052dg;
                                            holder5 = holder4;
                                            pageFetcherSnapshotState = holder5.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType7 = loadType6;
                                            interfaceC2052dg7 = interfaceC2052dg6;
                                            pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                            r1 = gc5;
                                            FW fw16 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg5 = interfaceC2052dg7;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                        } else {
                                            loadStates5 = loadStates;
                                            interfaceC2052dg5 = interfaceC2052dg;
                                            loadType7 = loadType6;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            viewportHint2 = null;
                                            loadType9 = loadType7;
                                        } else {
                                            holder6 = pageFetcherSnapshot8.stateHolder;
                                            gc6 = holder6.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                            if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                            loadType8 = loadType7;
                                            viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            gc6.b(null);
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                        if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                        loadType10 = loadType7;
                                        interfaceC2052dg8 = interfaceC2052dg5;
                                        loadStates7 = loadStates5;
                                        if (loadType10 == LoadType.REFRESH) {
                                            holder7 = pageFetcherSnapshot12.stateHolder;
                                            gc7 = holder7.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                            if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc7.b(null);
                                            if (!(loadState2 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg8;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                        loadStates = loadStates7;
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg19 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg19;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw17 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 4:
                                    pageFetcherSnapshot3 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7;
                                    loadType2 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6;
                                    gc2 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                    holder2 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    loadType3 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg2 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    pageFetcherSnapshot5 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    loadStates2 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    viewportHint = holder2.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                    gc2.b(null);
                                    pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                    loadType4 = loadType2;
                                    loadType2 = loadType3;
                                    pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                    if (pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot7 = pageFetcherSnapshot3;
                                    loadType5 = loadType2;
                                    interfaceC2052dg4 = interfaceC2052dg2;
                                    loadStates4 = loadStates2;
                                    if (loadType5 == LoadType.REFRESH) {
                                        holder3 = pageFetcherSnapshot7.stateHolder;
                                        gc3 = holder3.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                        if (gc3.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc3.b(null);
                                        if (!(loadState instanceof LoadState.Error)) {
                                            pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg4;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                    loadStates = loadStates4;
                                    loadType6 = LoadType.PREPEND;
                                    if (loadStates.getPrepend() instanceof LoadState.Error) {
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg110 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg110;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw18 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    } else {
                                        if (loadType6 != LoadType.REFRESH) {
                                            holder4 = pageFetcherSnapshot2.stateHolder;
                                            gc4 = holder4.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                            if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadStates6 = loadStates;
                                            gc5 = gc4;
                                            interfaceC2052dg6 = interfaceC2052dg;
                                            holder5 = holder4;
                                            pageFetcherSnapshotState = holder5.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType7 = loadType6;
                                            interfaceC2052dg7 = interfaceC2052dg6;
                                            pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                            r1 = gc5;
                                            FW fw19 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg5 = interfaceC2052dg7;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                        } else {
                                            loadStates5 = loadStates;
                                            interfaceC2052dg5 = interfaceC2052dg;
                                            loadType7 = loadType6;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            viewportHint2 = null;
                                            loadType9 = loadType7;
                                        } else {
                                            holder6 = pageFetcherSnapshot8.stateHolder;
                                            gc6 = holder6.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                            if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                            loadType8 = loadType7;
                                            viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            gc6.b(null);
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                        if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                        loadType10 = loadType7;
                                        interfaceC2052dg8 = interfaceC2052dg5;
                                        loadStates7 = loadStates5;
                                        if (loadType10 == LoadType.REFRESH) {
                                            holder7 = pageFetcherSnapshot12.stateHolder;
                                            gc7 = holder7.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                            if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc7.b(null);
                                            if (!(loadState2 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg8;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                        loadStates = loadStates7;
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg111 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg111;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw110 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 5:
                                    loadType5 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    InterfaceC2052dg interfaceC2052dg20 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    PageFetcherSnapshot pageFetcherSnapshot19 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    LoadStates loadStates9 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    loadStates4 = loadStates9;
                                    pageFetcherSnapshot7 = pageFetcherSnapshot19;
                                    interfaceC2052dg4 = interfaceC2052dg20;
                                    if (loadType5 == LoadType.REFRESH) {
                                        holder3 = pageFetcherSnapshot7.stateHolder;
                                        gc3 = holder3.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg4;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc3;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                        if (gc3.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc3.b(null);
                                        if (!(loadState instanceof LoadState.Error)) {
                                            pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg4;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                    loadStates = loadStates4;
                                    loadType6 = LoadType.PREPEND;
                                    if (loadStates.getPrepend() instanceof LoadState.Error) {
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg112 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg112;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw111 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    } else {
                                        if (loadType6 != LoadType.REFRESH) {
                                            holder4 = pageFetcherSnapshot2.stateHolder;
                                            gc4 = holder4.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                            if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadStates6 = loadStates;
                                            gc5 = gc4;
                                            interfaceC2052dg6 = interfaceC2052dg;
                                            holder5 = holder4;
                                            pageFetcherSnapshotState = holder5.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType7 = loadType6;
                                            interfaceC2052dg7 = interfaceC2052dg6;
                                            pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                            r1 = gc5;
                                            FW fw112 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg5 = interfaceC2052dg7;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                        } else {
                                            loadStates5 = loadStates;
                                            interfaceC2052dg5 = interfaceC2052dg;
                                            loadType7 = loadType6;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            viewportHint2 = null;
                                            loadType9 = loadType7;
                                        } else {
                                            holder6 = pageFetcherSnapshot8.stateHolder;
                                            gc6 = holder6.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                            if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                            loadType8 = loadType7;
                                            viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            gc6.b(null);
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                        if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                        loadType10 = loadType7;
                                        interfaceC2052dg8 = interfaceC2052dg5;
                                        loadStates7 = loadStates5;
                                        if (loadType10 == LoadType.REFRESH) {
                                            holder7 = pageFetcherSnapshot12.stateHolder;
                                            gc7 = holder7.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                            if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc7.b(null);
                                            if (!(loadState2 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg8;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                        loadStates = loadStates7;
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg113 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg113;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw113 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 6:
                                    gc3 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    holder3 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg4 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    pageFetcherSnapshot7 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    loadStates4 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    loadState = holder3.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                    gc3.b(null);
                                    if (!(loadState instanceof LoadState.Error)) {
                                        pageFetcherSnapshot7.startConsumingHints(interfaceC2052dg4);
                                    }
                                    interfaceC2052dg = interfaceC2052dg4;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                    loadStates = loadStates4;
                                    loadType6 = LoadType.PREPEND;
                                    if (loadStates.getPrepend() instanceof LoadState.Error) {
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg114 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg114;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw114 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    } else {
                                        if (loadType6 != LoadType.REFRESH) {
                                            holder4 = pageFetcherSnapshot2.stateHolder;
                                            gc4 = holder4.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc4;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                            if (gc4.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadStates6 = loadStates;
                                            gc5 = gc4;
                                            interfaceC2052dg6 = interfaceC2052dg;
                                            holder5 = holder4;
                                            pageFetcherSnapshotState = holder5.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType7 = loadType6;
                                            interfaceC2052dg7 = interfaceC2052dg6;
                                            pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                            r1 = gc5;
                                            FW fw115 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg5 = interfaceC2052dg7;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                        } else {
                                            loadStates5 = loadStates;
                                            interfaceC2052dg5 = interfaceC2052dg;
                                            loadType7 = loadType6;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            viewportHint2 = null;
                                            loadType9 = loadType7;
                                        } else {
                                            holder6 = pageFetcherSnapshot8.stateHolder;
                                            gc6 = holder6.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                            if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                            loadType8 = loadType7;
                                            viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            gc6.b(null);
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                        if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                        loadType10 = loadType7;
                                        interfaceC2052dg8 = interfaceC2052dg5;
                                        loadStates7 = loadStates5;
                                        if (loadType10 == LoadType.REFRESH) {
                                            holder7 = pageFetcherSnapshot12.stateHolder;
                                            gc7 = holder7.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                            if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc7.b(null);
                                            if (!(loadState2 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                            }
                                        }
                                        interfaceC2052dg = interfaceC2052dg8;
                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                        loadStates = loadStates7;
                                        loadType11 = LoadType.APPEND;
                                        if (loadStates.getAppend() instanceof LoadState.Error) {
                                            if (loadType11 != LoadType.REFRESH) {
                                                holder8 = pageFetcherSnapshot2.stateHolder;
                                                gc8 = holder8.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                InterfaceC2052dg interfaceC2052dg115 = interfaceC2052dg;
                                                holder9 = holder8;
                                                gc9 = gc8;
                                                interfaceC2052dg10 = interfaceC2052dg115;
                                                pageFetcherSnapshotState2 = holder9.state;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                loadType12 = loadType11;
                                                interfaceC2052dg11 = interfaceC2052dg10;
                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                r1 = gc9;
                                                FW fw116 = FW.a;
                                                r1.b(null);
                                                interfaceC2052dg9 = interfaceC2052dg11;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            } else {
                                                pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                interfaceC2052dg9 = interfaceC2052dg;
                                                loadType12 = loadType11;
                                            }
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                viewportHint3 = null;
                                                loadType15 = loadType12;
                                            } else {
                                                holder10 = pageFetcherSnapshot13.stateHolder;
                                                gc10 = holder10.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                loadType13 = loadType12;
                                                loadType14 = loadType13;
                                                gc11 = gc10;
                                                viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                                gc11.b(null);
                                                loadType15 = loadType13;
                                                loadType12 = loadType14;
                                                pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            }
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            interfaceC2052dg12 = interfaceC2052dg9;
                                            if (loadType12 == LoadType.REFRESH) {
                                                holder11 = pageFetcherSnapshot13.stateHolder;
                                                gc12 = holder11.lock;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                    return objD;
                                                }
                                                pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                gc13 = gc12;
                                                holder12 = holder11;
                                                loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                gc13.b(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                                }
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 7:
                                    GC gc16 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                    holder5 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    loadType6 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg6 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    PageFetcherSnapshot pageFetcherSnapshot20 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    LoadStates loadStates10 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    pageFetcherSnapshot2 = pageFetcherSnapshot20;
                                    loadStates6 = loadStates10;
                                    gc5 = gc16;
                                    pageFetcherSnapshotState = holder5.state;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg6;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                    if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    loadType7 = loadType6;
                                    interfaceC2052dg7 = interfaceC2052dg6;
                                    pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                    r1 = gc5;
                                    FW fw117 = FW.a;
                                    r1.b(null);
                                    interfaceC2052dg5 = interfaceC2052dg7;
                                    pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                    loadStates5 = loadStates6;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                        pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                        viewportHint2 = null;
                                        loadType9 = loadType7;
                                    } else {
                                        holder6 = pageFetcherSnapshot8.stateHolder;
                                        gc6 = holder6.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                        if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                        loadType8 = loadType7;
                                        viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                        gc6.b(null);
                                        pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                        loadType9 = loadType7;
                                        loadType7 = loadType8;
                                        pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                    if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                    loadType10 = loadType7;
                                    interfaceC2052dg8 = interfaceC2052dg5;
                                    loadStates7 = loadStates5;
                                    if (loadType10 == LoadType.REFRESH) {
                                        holder7 = pageFetcherSnapshot12.stateHolder;
                                        gc7 = holder7.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                        if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc7.b(null);
                                        if (!(loadState2 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg8;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                    loadStates = loadStates7;
                                    loadType11 = LoadType.APPEND;
                                    if (loadStates.getAppend() instanceof LoadState.Error) {
                                        if (loadType11 != LoadType.REFRESH) {
                                            holder8 = pageFetcherSnapshot2.stateHolder;
                                            gc8 = holder8.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                            if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            InterfaceC2052dg interfaceC2052dg116 = interfaceC2052dg;
                                            holder9 = holder8;
                                            gc9 = gc8;
                                            interfaceC2052dg10 = interfaceC2052dg116;
                                            pageFetcherSnapshotState2 = holder9.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType12 = loadType11;
                                            interfaceC2052dg11 = interfaceC2052dg10;
                                            pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                            r1 = gc9;
                                            FW fw118 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg9 = interfaceC2052dg11;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                        } else {
                                            pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                            interfaceC2052dg9 = interfaceC2052dg;
                                            loadType12 = loadType11;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            viewportHint3 = null;
                                            loadType15 = loadType12;
                                        } else {
                                            holder10 = pageFetcherSnapshot13.stateHolder;
                                            gc10 = holder10.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                            if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                            loadType13 = loadType12;
                                            loadType14 = loadType13;
                                            gc11 = gc10;
                                            viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                            gc11.b(null);
                                            loadType15 = loadType13;
                                            loadType12 = loadType14;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                        if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        interfaceC2052dg12 = interfaceC2052dg9;
                                        if (loadType12 == LoadType.REFRESH) {
                                            holder11 = pageFetcherSnapshot13.stateHolder;
                                            gc12 = holder11.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                            if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                            gc13 = gc12;
                                            holder12 = holder11;
                                            loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc13.b(null);
                                            if (!(loadState3 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 8:
                                    GC gc17 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    loadType7 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg7 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    pageFetcherSnapshot9 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    loadStates6 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    r1 = gc17;
                                    FW fw119 = FW.a;
                                    r1.b(null);
                                    interfaceC2052dg5 = interfaceC2052dg7;
                                    pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                    loadStates5 = loadStates6;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                        pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                        viewportHint2 = null;
                                        loadType9 = loadType7;
                                    } else {
                                        holder6 = pageFetcherSnapshot8.stateHolder;
                                        gc6 = holder6.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = gc6;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                        if (gc6.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                        loadType8 = loadType7;
                                        viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                        gc6.b(null);
                                        pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                        loadType9 = loadType7;
                                        loadType7 = loadType8;
                                        pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                    if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                    loadType10 = loadType7;
                                    interfaceC2052dg8 = interfaceC2052dg5;
                                    loadStates7 = loadStates5;
                                    if (loadType10 == LoadType.REFRESH) {
                                        holder7 = pageFetcherSnapshot12.stateHolder;
                                        gc7 = holder7.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                        if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc7.b(null);
                                        if (!(loadState2 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg8;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                    loadStates = loadStates7;
                                    loadType11 = LoadType.APPEND;
                                    if (loadStates.getAppend() instanceof LoadState.Error) {
                                        if (loadType11 != LoadType.REFRESH) {
                                            holder8 = pageFetcherSnapshot2.stateHolder;
                                            gc8 = holder8.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                            if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            InterfaceC2052dg interfaceC2052dg117 = interfaceC2052dg;
                                            holder9 = holder8;
                                            gc9 = gc8;
                                            interfaceC2052dg10 = interfaceC2052dg117;
                                            pageFetcherSnapshotState2 = holder9.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType12 = loadType11;
                                            interfaceC2052dg11 = interfaceC2052dg10;
                                            pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                            r1 = gc9;
                                            FW fw1110 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg9 = interfaceC2052dg11;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                        } else {
                                            pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                            interfaceC2052dg9 = interfaceC2052dg;
                                            loadType12 = loadType11;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            viewportHint3 = null;
                                            loadType15 = loadType12;
                                        } else {
                                            holder10 = pageFetcherSnapshot13.stateHolder;
                                            gc10 = holder10.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                            if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                            loadType13 = loadType12;
                                            loadType14 = loadType13;
                                            gc11 = gc10;
                                            viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                            gc11.b(null);
                                            loadType15 = loadType13;
                                            loadType12 = loadType14;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                        if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        interfaceC2052dg12 = interfaceC2052dg9;
                                        if (loadType12 == LoadType.REFRESH) {
                                            holder11 = pageFetcherSnapshot13.stateHolder;
                                            gc12 = holder11.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                            if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                            gc13 = gc12;
                                            holder12 = holder11;
                                            loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc13.b(null);
                                            if (!(loadState3 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 9:
                                    pageFetcherSnapshot8 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7;
                                    loadType7 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6;
                                    gc6 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                    holder6 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    loadType8 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg5 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    pageFetcherSnapshot10 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    loadStates5 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    viewportHint2 = holder6.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                    gc6.b(null);
                                    pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                    loadType9 = loadType7;
                                    loadType7 = loadType8;
                                    pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg5;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                    if (pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                    loadType10 = loadType7;
                                    interfaceC2052dg8 = interfaceC2052dg5;
                                    loadStates7 = loadStates5;
                                    if (loadType10 == LoadType.REFRESH) {
                                        holder7 = pageFetcherSnapshot12.stateHolder;
                                        gc7 = holder7.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                        if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc7.b(null);
                                        if (!(loadState2 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg8;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                    loadStates = loadStates7;
                                    loadType11 = LoadType.APPEND;
                                    if (loadStates.getAppend() instanceof LoadState.Error) {
                                        if (loadType11 != LoadType.REFRESH) {
                                            holder8 = pageFetcherSnapshot2.stateHolder;
                                            gc8 = holder8.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                            if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            InterfaceC2052dg interfaceC2052dg118 = interfaceC2052dg;
                                            holder9 = holder8;
                                            gc9 = gc8;
                                            interfaceC2052dg10 = interfaceC2052dg118;
                                            pageFetcherSnapshotState2 = holder9.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType12 = loadType11;
                                            interfaceC2052dg11 = interfaceC2052dg10;
                                            pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                            r1 = gc9;
                                            FW fw1111 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg9 = interfaceC2052dg11;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                        } else {
                                            pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                            interfaceC2052dg9 = interfaceC2052dg;
                                            loadType12 = loadType11;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            viewportHint3 = null;
                                            loadType15 = loadType12;
                                        } else {
                                            holder10 = pageFetcherSnapshot13.stateHolder;
                                            gc10 = holder10.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                            if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                            loadType13 = loadType12;
                                            loadType14 = loadType13;
                                            gc11 = gc10;
                                            viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                            gc11.b(null);
                                            loadType15 = loadType13;
                                            loadType12 = loadType14;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                        if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        interfaceC2052dg12 = interfaceC2052dg9;
                                        if (loadType12 == LoadType.REFRESH) {
                                            holder11 = pageFetcherSnapshot13.stateHolder;
                                            gc12 = holder11.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                            if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                            gc13 = gc12;
                                            holder12 = holder11;
                                            loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc13.b(null);
                                            if (!(loadState3 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 10:
                                    loadType10 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    InterfaceC2052dg interfaceC2052dg21 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    PageFetcherSnapshot pageFetcherSnapshot21 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    LoadStates loadStates11 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    loadStates7 = loadStates11;
                                    pageFetcherSnapshot12 = pageFetcherSnapshot21;
                                    interfaceC2052dg8 = interfaceC2052dg21;
                                    if (loadType10 == LoadType.REFRESH) {
                                        holder7 = pageFetcherSnapshot12.stateHolder;
                                        gc7 = holder7.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = interfaceC2052dg8;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc7;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                        if (gc7.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc7.b(null);
                                        if (!(loadState2 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                        }
                                    }
                                    interfaceC2052dg = interfaceC2052dg8;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                    loadStates = loadStates7;
                                    loadType11 = LoadType.APPEND;
                                    if (loadStates.getAppend() instanceof LoadState.Error) {
                                        if (loadType11 != LoadType.REFRESH) {
                                            holder8 = pageFetcherSnapshot2.stateHolder;
                                            gc8 = holder8.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                            if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            InterfaceC2052dg interfaceC2052dg119 = interfaceC2052dg;
                                            holder9 = holder8;
                                            gc9 = gc8;
                                            interfaceC2052dg10 = interfaceC2052dg119;
                                            pageFetcherSnapshotState2 = holder9.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType12 = loadType11;
                                            interfaceC2052dg11 = interfaceC2052dg10;
                                            pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                            r1 = gc9;
                                            FW fw1112 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg9 = interfaceC2052dg11;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                        } else {
                                            pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                            interfaceC2052dg9 = interfaceC2052dg;
                                            loadType12 = loadType11;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            viewportHint3 = null;
                                            loadType15 = loadType12;
                                        } else {
                                            holder10 = pageFetcherSnapshot13.stateHolder;
                                            gc10 = holder10.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                            if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                            loadType13 = loadType12;
                                            loadType14 = loadType13;
                                            gc11 = gc10;
                                            viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                            gc11.b(null);
                                            loadType15 = loadType13;
                                            loadType12 = loadType14;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                        if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        interfaceC2052dg12 = interfaceC2052dg9;
                                        if (loadType12 == LoadType.REFRESH) {
                                            holder11 = pageFetcherSnapshot13.stateHolder;
                                            gc12 = holder11.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                            if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                            gc13 = gc12;
                                            holder12 = holder11;
                                            loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc13.b(null);
                                            if (!(loadState3 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 11:
                                    gc7 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    holder7 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    interfaceC2052dg8 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    pageFetcherSnapshot12 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    loadStates7 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    loadState2 = holder7.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                    gc7.b(null);
                                    if (!(loadState2 instanceof LoadState.Error)) {
                                        pageFetcherSnapshot12.startConsumingHints(interfaceC2052dg8);
                                    }
                                    interfaceC2052dg = interfaceC2052dg8;
                                    pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                    loadStates = loadStates7;
                                    loadType11 = LoadType.APPEND;
                                    if (loadStates.getAppend() instanceof LoadState.Error) {
                                        if (loadType11 != LoadType.REFRESH) {
                                            holder8 = pageFetcherSnapshot2.stateHolder;
                                            gc8 = holder8.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                            if (gc8.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            InterfaceC2052dg interfaceC2052dg1110 = interfaceC2052dg;
                                            holder9 = holder8;
                                            gc9 = gc8;
                                            interfaceC2052dg10 = interfaceC2052dg1110;
                                            pageFetcherSnapshotState2 = holder9.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            loadType12 = loadType11;
                                            interfaceC2052dg11 = interfaceC2052dg10;
                                            pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                            r1 = gc9;
                                            FW fw1113 = FW.a;
                                            r1.b(null);
                                            interfaceC2052dg9 = interfaceC2052dg11;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                        } else {
                                            pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                            interfaceC2052dg9 = interfaceC2052dg;
                                            loadType12 = loadType11;
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            viewportHint3 = null;
                                            loadType15 = loadType12;
                                        } else {
                                            holder10 = pageFetcherSnapshot13.stateHolder;
                                            gc10 = holder10.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                            if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                            loadType13 = loadType12;
                                            loadType14 = loadType13;
                                            gc11 = gc10;
                                            viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                            gc11.b(null);
                                            loadType15 = loadType13;
                                            loadType12 = loadType14;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                        }
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                        if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        interfaceC2052dg12 = interfaceC2052dg9;
                                        if (loadType12 == LoadType.REFRESH) {
                                            holder11 = pageFetcherSnapshot13.stateHolder;
                                            gc12 = holder11.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                            if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                                return objD;
                                            }
                                            pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                            gc13 = gc12;
                                            holder12 = holder11;
                                            loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            gc13.b(null);
                                            if (!(loadState3 instanceof LoadState.Error)) {
                                                pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                            }
                                        }
                                    }
                                    return FW.a;
                                case 12:
                                    GC gc18 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    holder9 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    loadType11 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    interfaceC2052dg10 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    PageFetcherSnapshot pageFetcherSnapshot22 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    pageFetcherSnapshot2 = pageFetcherSnapshot22;
                                    gc9 = gc18;
                                    pageFetcherSnapshotState2 = holder9.state;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg10;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc9;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                    if (pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    loadType12 = loadType11;
                                    interfaceC2052dg11 = interfaceC2052dg10;
                                    pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                    r1 = gc9;
                                    FW fw1114 = FW.a;
                                    r1.b(null);
                                    interfaceC2052dg9 = interfaceC2052dg11;
                                    pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                        pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                        viewportHint3 = null;
                                        loadType15 = loadType12;
                                    } else {
                                        holder10 = pageFetcherSnapshot13.stateHolder;
                                        gc10 = holder10.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                        if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                        loadType13 = loadType12;
                                        loadType14 = loadType13;
                                        gc11 = gc10;
                                        viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                        gc11.b(null);
                                        loadType15 = loadType13;
                                        loadType12 = loadType14;
                                        pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                    if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    interfaceC2052dg12 = interfaceC2052dg9;
                                    if (loadType12 == LoadType.REFRESH) {
                                        holder11 = pageFetcherSnapshot13.stateHolder;
                                        gc12 = holder11.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                        if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                        gc13 = gc12;
                                        holder12 = holder11;
                                        loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc13.b(null);
                                        if (!(loadState3 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                        }
                                    }
                                    return FW.a;
                                case 13:
                                    GC gc19 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    loadType12 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    interfaceC2052dg11 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    pageFetcherSnapshot14 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    r1 = gc19;
                                    FW fw1115 = FW.a;
                                    r1.b(null);
                                    interfaceC2052dg9 = interfaceC2052dg11;
                                    pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                    if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                        pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                        viewportHint3 = null;
                                        loadType15 = loadType12;
                                    } else {
                                        holder10 = pageFetcherSnapshot13.stateHolder;
                                        gc10 = holder10.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = gc10;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                        if (gc10.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                        loadType13 = loadType12;
                                        loadType14 = loadType13;
                                        gc11 = gc10;
                                        viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                        gc11.b(null);
                                        loadType15 = loadType13;
                                        loadType12 = loadType14;
                                        pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                    }
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                    if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    interfaceC2052dg12 = interfaceC2052dg9;
                                    if (loadType12 == LoadType.REFRESH) {
                                        holder11 = pageFetcherSnapshot13.stateHolder;
                                        gc12 = holder11.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                        if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                        gc13 = gc12;
                                        holder12 = holder11;
                                        loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc13.b(null);
                                        if (!(loadState3 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                        }
                                    }
                                    return FW.a;
                                case 14:
                                    pageFetcherSnapshot13 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6;
                                    loadType13 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                    gc11 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                    holder10 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    loadType14 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    interfaceC2052dg9 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    pageFetcherSnapshot15 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    viewportHint3 = holder10.state.getFailedHintsByLoadType$paging_common().get(loadType14);
                                    gc11.b(null);
                                    loadType15 = loadType13;
                                    loadType12 = loadType14;
                                    pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                    pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg9;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                    if (pageFetcherSnapshot16.retryLoadError(loadType15, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                        return objD;
                                    }
                                    interfaceC2052dg12 = interfaceC2052dg9;
                                    if (loadType12 == LoadType.REFRESH) {
                                        holder11 = pageFetcherSnapshot13.stateHolder;
                                        gc12 = holder11.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                        if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                        gc13 = gc12;
                                        holder12 = holder11;
                                        loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc13.b(null);
                                        if (!(loadState3 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                        }
                                    }
                                    return FW.a;
                                case 15:
                                    LoadType loadType17 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    interfaceC2052dg12 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    PageFetcherSnapshot pageFetcherSnapshot23 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    loadType12 = loadType17;
                                    pageFetcherSnapshot13 = pageFetcherSnapshot23;
                                    if (loadType12 == LoadType.REFRESH) {
                                        holder11 = pageFetcherSnapshot13.stateHolder;
                                        gc12 = holder11.lock;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = interfaceC2052dg12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder11;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = gc12;
                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                        if (gc12.c(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) == objD) {
                                            return objD;
                                        }
                                        pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                        gc13 = gc12;
                                        holder12 = holder11;
                                        loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                        gc13.b(null);
                                        if (!(loadState3 instanceof LoadState.Error)) {
                                            pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                        }
                                    }
                                    return FW.a;
                                case 16:
                                    gc13 = (GC) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                    holder12 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                    interfaceC2052dg12 = (InterfaceC2052dg) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                    pageFetcherSnapshot17 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                    LL.b(obj);
                                    loadState3 = holder12.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                    gc13.b(null);
                                    if (!(loadState3 instanceof LoadState.Error)) {
                                        pageFetcherSnapshot17.startConsumingHints(interfaceC2052dg12);
                                    }
                                    return FW.a;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } catch (Throwable th8) {
                            r1.b(null);
                            throw th8;
                        }
                    } catch (Throwable th9) {
                        r1.b(null);
                        throw th9;
                    }
                } catch (Throwable th10) {
                    r1.b(null);
                    throw th10;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC1009Wa interfaceC1009Wa, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$retryChannel = interfaceC1009Wa;
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$retryChannel, this.this$0, interfaceC0793Of);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass4) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                InterfaceC0939Tm interfaceC0939TmI = AbstractC1047Xm.i(this.$retryChannel);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, interfaceC2052dg);
                this.label = 1;
                if (interfaceC0939TmI.collect(anonymousClass1, this) == objD) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.this$0, interfaceC0793Of);
        pageFetcherSnapshot$pageEventFlow$1.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:38:0x010d  */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        SimpleProducerScope simpleProducerScope;
        RemoteMediatorConnection remoteMediatorConnection;
        PagingState pagingState;
        PageFetcherSnapshotState.Holder holder;
        GC gc;
        SimpleProducerScope simpleProducerScope2;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        PageFetcherSnapshotState.Holder holder2;
        GC gc2;
        SimpleProducerScope simpleProducerScope3;
        GC gc3;
        LoadState loadState;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    gc = (GC) this.L$3;
                    holder = (PageFetcherSnapshotState.Holder) this.L$2;
                    remoteMediatorConnection = (RemoteMediatorConnection) this.L$1;
                    simpleProducerScope2 = (SimpleProducerScope) this.L$0;
                    LL.b(obj);
                } else if (i == 2) {
                    SimpleProducerScope simpleProducerScope4 = (SimpleProducerScope) this.L$0;
                    LL.b(obj);
                    simpleProducerScope = simpleProducerScope4;
                    holder2 = ((PageFetcherSnapshot) this.this$0).stateHolder;
                    gc2 = holder2.lock;
                    this.L$0 = simpleProducerScope;
                    this.L$1 = holder2;
                    this.L$2 = gc2;
                    this.label = 3;
                    if (gc2.c(null, this) == objD) {
                        return objD;
                    }
                    simpleProducerScope3 = simpleProducerScope;
                    gc3 = gc2;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    gc3 = (GC) this.L$2;
                    holder2 = (PageFetcherSnapshotState.Holder) this.L$1;
                    simpleProducerScope3 = (SimpleProducerScope) this.L$0;
                    LL.b(obj);
                }
                try {
                    loadState = holder2.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                    gc3.b(null);
                    if (!(loadState instanceof LoadState.Error)) {
                        this.this$0.startConsumingHints(simpleProducerScope3);
                    }
                    return FW.a;
                } catch (Throwable th) {
                    gc3.b(null);
                    throw th;
                }
            }
            LL.b(obj);
            simpleProducerScope = (SimpleProducerScope) this.L$0;
            if (!((PageFetcherSnapshot) this.this$0).pageEventChCollected.compareAndSet(false, true)) {
                throw new IllegalStateException("Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?");
            }
            O8.d(simpleProducerScope, null, null, new AnonymousClass2(this.this$0, simpleProducerScope, null), 3, null);
            InterfaceC1009Wa interfaceC1009WaB = AbstractC2287gb.b(0, null, null, 6, null);
            O8.d(simpleProducerScope, null, null, new AnonymousClass3(this.this$0, interfaceC1009WaB, null), 3, null);
            O8.d(simpleProducerScope, null, null, new AnonymousClass4(interfaceC1009WaB, this.this$0, null), 3, null);
            remoteMediatorConnection = this.this$0.getRemoteMediatorConnection();
            if (remoteMediatorConnection != null) {
                PageFetcherSnapshot<Key, Value> pageFetcherSnapshot2 = this.this$0;
                pagingState = ((PageFetcherSnapshot) pageFetcherSnapshot2).previousPagingState;
                if (pagingState == null) {
                    PageFetcherSnapshotState.Holder holder3 = ((PageFetcherSnapshot) pageFetcherSnapshot2).stateHolder;
                    GC gc4 = holder3.lock;
                    this.L$0 = simpleProducerScope;
                    this.L$1 = remoteMediatorConnection;
                    this.L$2 = holder3;
                    this.L$3 = gc4;
                    this.label = 1;
                    if (gc4.c(null, this) == objD) {
                        return objD;
                    }
                    holder = holder3;
                    gc = gc4;
                    simpleProducerScope2 = simpleProducerScope;
                }
                remoteMediatorConnection.requestRefreshIfAllowed(pagingState);
            }
            pageFetcherSnapshot = this.this$0;
            this.L$0 = simpleProducerScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (pageFetcherSnapshot.doInitialLoad(this) == objD) {
                return objD;
            }
            holder2 = ((PageFetcherSnapshot) this.this$0).stateHolder;
            gc2 = holder2.lock;
            this.L$0 = simpleProducerScope;
            this.L$1 = holder2;
            this.L$2 = gc2;
            this.label = 3;
            if (gc2.c(null, this) == objD) {
                return objD;
            }
            simpleProducerScope3 = simpleProducerScope;
            gc3 = gc2;
            loadState = holder2.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
            gc3.b(null);
            if (!(loadState instanceof LoadState.Error)) {
                this.this$0.startConsumingHints(simpleProducerScope3);
            }
            return FW.a;
            PagingState pagingStateCurrentPagingState$paging_common = holder.state.currentPagingState$paging_common(null);
            gc.b(null);
            SimpleProducerScope simpleProducerScope5 = simpleProducerScope2;
            pagingState = pagingStateCurrentPagingState$paging_common;
            simpleProducerScope = simpleProducerScope5;
            remoteMediatorConnection.requestRefreshIfAllowed(pagingState);
            pageFetcherSnapshot = this.this$0;
            this.L$0 = simpleProducerScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (pageFetcherSnapshot.doInitialLoad(this) == objD) {
                return objD;
            }
            holder2 = ((PageFetcherSnapshot) this.this$0).stateHolder;
            gc2 = holder2.lock;
            this.L$0 = simpleProducerScope;
            this.L$1 = holder2;
            this.L$2 = gc2;
            this.label = 3;
            if (gc2.c(null, this) == objD) {
                return objD;
            }
            simpleProducerScope3 = simpleProducerScope;
            gc3 = gc2;
            loadState = holder2.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
            gc3.b(null);
            if (!(loadState instanceof LoadState.Error)) {
                this.this$0.startConsumingHints(simpleProducerScope3);
            }
            return FW.a;
        } catch (Throwable th2) {
            gc.b(null);
            throw th2;
        }
    }
}
