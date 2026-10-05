package androidx.paging;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AD;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.CR;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {
    public static final Companion Companion = new Companion(null);
    private static final int PRIORITY_APPEND_PREPEND = 1;
    private static final int PRIORITY_REFRESH = 2;
    private final AccessorStateHolder<Key, Value> accessorState;
    private final SingleRunner isolationRunner;
    private final RemoteMediator<Key, Value> remoteMediator;
    private final InterfaceC2052dg scope;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

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

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$allowRefresh$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AccessorState) obj);
            return FW.a;
        }

        public final void invoke(AccessorState<Key, Value> accessorState) {
            AbstractC4492zt.h(accessorState, "it");
            accessorState.setRefreshAllowed(true);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$initialize$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.RemoteMediatorAccessImpl", f = "RemoteMediatorAccessor.kt", l = {445}, m = "initialize")
    public static final class C17191 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17191(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = remoteMediatorAccessImpl;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.initialize(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", l = {386}, m = "invokeSuspend")
    public static final class C17201 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", l = {393}, m = "invokeSuspend")
        public static final class C01571 extends XS implements InterfaceC3750qp {
            Object L$0;
            int label;
            final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

            /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01581 extends AbstractC2233fv implements InterfaceC3750qp {
                public static final C01581 INSTANCE = new C01581();

                public C01581() {
                    super(1);
                }

                @Override // defpackage.InterfaceC3750qp
                public final C2020dG invoke(AccessorState<Key, Value> accessorState) {
                    AbstractC4492zt.h(accessorState, "it");
                    return accessorState.getPendingBoundary();
                }
            }

            /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
                final /* synthetic */ RemoteMediator.MediatorResult $loadResult;
                final /* synthetic */ LoadType $loadType;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(LoadType loadType, RemoteMediator.MediatorResult mediatorResult) {
                    super(1);
                    this.$loadType = loadType;
                    this.$loadResult = mediatorResult;
                }

                @Override // defpackage.InterfaceC3750qp
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AccessorState) obj);
                    return FW.a;
                }

                public final void invoke(AccessorState<Key, Value> accessorState) {
                    AbstractC4492zt.h(accessorState, "it");
                    accessorState.clearPendingRequest(this.$loadType);
                    if (((RemoteMediator.MediatorResult.Success) this.$loadResult).endOfPaginationReached()) {
                        accessorState.setBlockState(this.$loadType, AccessorState.BlockState.COMPLETED);
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
                final /* synthetic */ RemoteMediator.MediatorResult $loadResult;
                final /* synthetic */ LoadType $loadType;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(LoadType loadType, RemoteMediator.MediatorResult mediatorResult) {
                    super(1);
                    this.$loadType = loadType;
                    this.$loadResult = mediatorResult;
                }

                @Override // defpackage.InterfaceC3750qp
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AccessorState) obj);
                    return FW.a;
                }

                public final void invoke(AccessorState<Key, Value> accessorState) {
                    AbstractC4492zt.h(accessorState, "it");
                    accessorState.clearPendingRequest(this.$loadType);
                    accessorState.setError(this.$loadType, new LoadState.Error(((RemoteMediator.MediatorResult.Error) this.$loadResult).getThrowable()));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01571(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, InterfaceC0793Of interfaceC0793Of) {
                super(1, interfaceC0793Of);
                this.this$0 = remoteMediatorAccessImpl;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
                return new C01571(this.this$0, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC3750qp
            public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
                return ((C01571) create(interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x002e  */
            /* JADX WARN: Code duplicated, block: B:13:0x0031  */
            /* JADX WARN: Code duplicated, block: B:15:0x004d A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:18:0x0054  */
            /* JADX WARN: Code duplicated, block: B:19:0x0063  */
            /* JADX WARN: Code duplicated, block: B:21:0x0067  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004b -> B:16:0x004e). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:18:0x0054
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // defpackage.AbstractC2171f7
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r5.L$0
                    androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                    defpackage.LL.b(r6)
                    goto L4e
                L13:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1b:
                    defpackage.LL.b(r6)
                L1e:
                    androidx.paging.RemoteMediatorAccessImpl<Key, Value> r6 = r5.this$0
                    androidx.paging.AccessorStateHolder r6 = androidx.paging.RemoteMediatorAccessImpl.access$getAccessorState$p(r6)
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r1 = androidx.paging.RemoteMediatorAccessImpl.C17201.C01571.C01581.INSTANCE
                    java.lang.Object r6 = r6.use(r1)
                    dG r6 = (defpackage.C2020dG) r6
                    if (r6 != 0) goto L31
                    FW r6 = defpackage.FW.a
                    return r6
                L31:
                    java.lang.Object r1 = r6.a()
                    androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                    java.lang.Object r6 = r6.b()
                    androidx.paging.PagingState r6 = (androidx.paging.PagingState) r6
                    androidx.paging.RemoteMediatorAccessImpl<Key, Value> r3 = r5.this$0
                    androidx.paging.RemoteMediator r3 = androidx.paging.RemoteMediatorAccessImpl.access$getRemoteMediator$p(r3)
                    r5.L$0 = r1
                    r5.label = r2
                    java.lang.Object r6 = r3.load(r1, r6, r5)
                    if (r6 != r0) goto L4e
                    return r0
                L4e:
                    androidx.paging.RemoteMediator$MediatorResult r6 = (androidx.paging.RemoteMediator.MediatorResult) r6
                    boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Success
                    if (r3 == 0) goto L63
                    androidx.paging.RemoteMediatorAccessImpl<Key, Value> r3 = r5.this$0
                    androidx.paging.AccessorStateHolder r3 = androidx.paging.RemoteMediatorAccessImpl.access$getAccessorState$p(r3)
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2
                    r4.<init>(r1, r6)
                    r3.use(r4)
                    goto L1e
                L63:
                    boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Error
                    if (r3 == 0) goto L1e
                    androidx.paging.RemoteMediatorAccessImpl<Key, Value> r3 = r5.this$0
                    androidx.paging.AccessorStateHolder r3 = androidx.paging.RemoteMediatorAccessImpl.access$getAccessorState$p(r3)
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3
                    r4.<init>(r1, r6)
                    r3.use(r4)
                    goto L1e
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl.C17201.C01571.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17201(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = remoteMediatorAccessImpl;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C17201(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C17201) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                SingleRunner singleRunner = ((RemoteMediatorAccessImpl) this.this$0).isolationRunner;
                C01571 c01571 = new C01571(this.this$0, null);
                this.label = 1;
                if (singleRunner.runInIsolation(1, c01571, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1", f = "RemoteMediatorAccessor.kt", l = {314}, m = "invokeSuspend")
    public static final class C17211 extends XS implements InterfaceC0526Fp {
        Object L$0;
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1", f = "RemoteMediatorAccessor.kt", l = {TIFFConstants.TIFFTAG_HALFTONEHINTS}, m = "invokeSuspend")
        public static final class C01591 extends XS implements InterfaceC3750qp {
            final /* synthetic */ KJ $launchAppendPrepend;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01591(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, KJ kj, InterfaceC0793Of interfaceC0793Of) {
                super(1, interfaceC0793Of);
                this.this$0 = remoteMediatorAccessImpl;
                this.$launchAppendPrepend = kj;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
                return new C01591(this.this$0, this.$launchAppendPrepend, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC3750qp
            public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
                return ((C01591) create(interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl;
                KJ kj;
                boolean zBooleanValue;
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    PagingState<Key, Value> pagingState = (PagingState) ((RemoteMediatorAccessImpl) this.this$0).accessorState.use(RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1.INSTANCE);
                    if (pagingState != null) {
                        remoteMediatorAccessImpl = this.this$0;
                        KJ kj2 = this.$launchAppendPrepend;
                        RemoteMediator remoteMediator = ((RemoteMediatorAccessImpl) remoteMediatorAccessImpl).remoteMediator;
                        LoadType loadType = LoadType.REFRESH;
                        this.L$0 = remoteMediatorAccessImpl;
                        this.L$1 = kj2;
                        this.label = 1;
                        obj = remoteMediator.load(loadType, pagingState, this);
                        if (obj == objD) {
                            return objD;
                        }
                        kj = kj2;
                    }
                    return FW.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kj = (KJ) this.L$1;
                remoteMediatorAccessImpl = (RemoteMediatorAccessImpl) this.L$0;
                LL.b(obj);
                RemoteMediator.MediatorResult mediatorResult = (RemoteMediator.MediatorResult) obj;
                if (mediatorResult instanceof RemoteMediator.MediatorResult.Success) {
                    zBooleanValue = ((Boolean) ((RemoteMediatorAccessImpl) remoteMediatorAccessImpl).accessorState.use(new RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(mediatorResult))).booleanValue();
                } else {
                    if (!(mediatorResult instanceof RemoteMediator.MediatorResult.Error)) {
                        throw new AD();
                    }
                    zBooleanValue = ((Boolean) ((RemoteMediatorAccessImpl) remoteMediatorAccessImpl).accessorState.use(new RemoteMediatorAccessImpl$launchRefresh$1$1$1$2(mediatorResult))).booleanValue();
                }
                kj.a = zBooleanValue;
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17211(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = remoteMediatorAccessImpl;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C17211(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C17211) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            KJ kj;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                KJ kj2 = new KJ();
                SingleRunner singleRunner = ((RemoteMediatorAccessImpl) this.this$0).isolationRunner;
                C01591 c01591 = new C01591(this.this$0, kj2, null);
                this.L$0 = kj2;
                this.label = 1;
                if (singleRunner.runInIsolation(2, c01591, this) == objD) {
                    return objD;
                }
                kj = kj2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kj = (KJ) this.L$0;
                LL.b(obj);
            }
            if (kj.a) {
                this.this$0.launchBoundary();
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$requestRefreshIfAllowed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17221 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ PagingState<Key, Value> $pagingState;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17221(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, PagingState<Key, Value> pagingState) {
            super(1);
            this.this$0 = remoteMediatorAccessImpl;
            this.$pagingState = pagingState;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AccessorState) obj);
            return FW.a;
        }

        public final void invoke(AccessorState<Key, Value> accessorState) {
            AbstractC4492zt.h(accessorState, "it");
            if (accessorState.getRefreshAllowed()) {
                accessorState.setRefreshAllowed(false);
                RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl = this.this$0;
                remoteMediatorAccessImpl.requestLoad(((RemoteMediatorAccessImpl) remoteMediatorAccessImpl).accessorState, LoadType.REFRESH, this.$pagingState);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$retryFailed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17231 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ List<LoadType> $toBeStarted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17231(List<LoadType> list) {
            super(1);
            this.$toBeStarted = list;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AccessorState) obj);
            return FW.a;
        }

        public final void invoke(AccessorState<Key, Value> accessorState) {
            AbstractC4492zt.h(accessorState, "accessorState");
            LoadStates loadStatesComputeLoadStates = accessorState.computeLoadStates();
            boolean z = loadStatesComputeLoadStates.getRefresh() instanceof LoadState.Error;
            accessorState.clearErrors();
            if (z) {
                List<LoadType> list = this.$toBeStarted;
                LoadType loadType = LoadType.REFRESH;
                list.add(loadType);
                accessorState.setBlockState(loadType, AccessorState.BlockState.UNBLOCKED);
            }
            if (loadStatesComputeLoadStates.getAppend() instanceof LoadState.Error) {
                if (!z) {
                    this.$toBeStarted.add(LoadType.APPEND);
                }
                accessorState.clearPendingRequest(LoadType.APPEND);
            }
            if (loadStatesComputeLoadStates.getPrepend() instanceof LoadState.Error) {
                if (!z) {
                    this.$toBeStarted.add(LoadType.PREPEND);
                }
                accessorState.clearPendingRequest(LoadType.PREPEND);
            }
        }
    }

    public RemoteMediatorAccessImpl(InterfaceC2052dg interfaceC2052dg, RemoteMediator<Key, Value> remoteMediator) {
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC4492zt.h(remoteMediator, "remoteMediator");
        this.scope = interfaceC2052dg;
        this.remoteMediator = remoteMediator;
        this.accessorState = new AccessorStateHolder<>();
        this.isolationRunner = new SingleRunner(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBoundary() {
        O8.d(this.scope, null, null, new C17201(this, null), 3, null);
    }

    private final void launchRefresh() {
        O8.d(this.scope, null, null, new C17211(this, null), 3, null);
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void allowRefresh() {
        this.accessorState.use(AnonymousClass1.INSTANCE);
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    public CR getState() {
        return this.accessorState.getLoadStates();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.RemoteMediatorAccessor
    public Object initialize(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17191 c17191;
        RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl;
        if (interfaceC0793Of instanceof C17191) {
            c17191 = (C17191) interfaceC0793Of;
            int i = c17191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17191.label = i - Integer.MIN_VALUE;
            } else {
                c17191 = new C17191(this, interfaceC0793Of);
            }
        } else {
            c17191 = new C17191(this, interfaceC0793Of);
        }
        Object objInitialize = c17191.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c17191.label;
        if (i2 == 0) {
            LL.b(objInitialize);
            RemoteMediator<Key, Value> remoteMediator = this.remoteMediator;
            c17191.L$0 = this;
            c17191.label = 1;
            objInitialize = remoteMediator.initialize(c17191);
            if (objInitialize == objD) {
                return objD;
            }
            remoteMediatorAccessImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            remoteMediatorAccessImpl = (RemoteMediatorAccessImpl) c17191.L$0;
            LL.b(objInitialize);
        }
        if (((RemoteMediator.InitializeAction) objInitialize) == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
            remoteMediatorAccessImpl.accessorState.use(RemoteMediatorAccessImpl$initialize$2$1.INSTANCE);
        }
        return objInitialize;
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestLoad(LoadType loadType, PagingState<Key, Value> pagingState) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(pagingState, "pagingState");
        requestLoad(this.accessorState, loadType, pagingState);
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestRefreshIfAllowed(PagingState<Key, Value> pagingState) {
        AbstractC4492zt.h(pagingState, "pagingState");
        this.accessorState.use(new C17221(this, pagingState));
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void retryFailed(PagingState<Key, Value> pagingState) {
        AbstractC4492zt.h(pagingState, "pagingState");
        ArrayList arrayList = new ArrayList();
        this.accessorState.use(new C17231(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            requestLoad((LoadType) it.next(), pagingState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLoad(AccessorStateHolder<Key, Value> accessorStateHolder, LoadType loadType, PagingState<Key, Value> pagingState) {
        if (((Boolean) accessorStateHolder.use(new RemoteMediatorAccessImpl$requestLoad$newRequest$1(loadType, pagingState))).booleanValue()) {
            if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
                launchRefresh();
            } else {
                launchBoundary();
            }
        }
    }
}
