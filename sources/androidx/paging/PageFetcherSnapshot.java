package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2287gb;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3511nu;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.GC;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC1243ae;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.poi.hssf.record.UnknownRecord;

/* JADX INFO: loaded from: classes2.dex */
public final class PageFetcherSnapshot<Key, Value> {
    private final PagingConfig config;
    private final HintHandler hintHandler;
    private final Key initialKey;
    private final InterfaceC3588op jumpCallback;
    private final InterfaceC1009Wa pageEventCh;
    private final AtomicBoolean pageEventChCollected;
    private final InterfaceC1243ae pageEventChannelFlowJob;
    private final InterfaceC0939Tm pageEventFlow;
    private final PagingSource<Key, Value> pagingSource;
    private final PagingState<Key, Value> previousPagingState;
    private final RemoteMediatorConnection<Key, Value> remoteMediatorConnection;
    private final InterfaceC0939Tm retryFlow;
    private final PageFetcherSnapshotState.Holder<Key, Value> stateHolder;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5435invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5435invoke();
            return FW.a;
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

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ LoadType $loadType;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(LoadType loadType, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$loadType = loadType;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(GenerationalViewportHint generationalViewportHint, GenerationalViewportHint generationalViewportHint2, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$loadType, interfaceC0793Of);
            anonymousClass3.L$0 = generationalViewportHint;
            anonymousClass3.L$1 = generationalViewportHint2;
            return anonymousClass3.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) this.L$0;
            GenerationalViewportHint generationalViewportHint2 = (GenerationalViewportHint) this.L$1;
            return PageFetcherSnapshotKt.shouldPrioritizeOver(generationalViewportHint2, generationalViewportHint, this.$loadType) ? generationalViewportHint2 : generationalViewportHint;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$currentPagingState$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {645}, m = "currentPagingState")
    public static final class C17021 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17021(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.currentPagingState(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$doInitialLoad$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {645, TIFFConstants.TIFFTAG_PLANARCONFIG, TIFFConstants.TIFFTAG_GRAYRESPONSEUNIT, 667, 689, TIFFConstants.TIFFTAG_BADFAXLINES, 711, 733, 354}, m = "doInitialLoad")
    public static final class C17031 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17031(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doInitialLoad(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$doLoad$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {646, 658, 415, TypedValues.CycleType.TYPE_WAVE_OFFSET, 680, 722, 472, 744, 495, 521, 756}, m = "doLoad")
    public static final class C17041 extends AbstractC0819Pf {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17041(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doLoad(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1", f = "PageFetcherSnapshot.kt", l = {220}, m = "invokeSuspend")
    public static final class C17051 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17051(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C17051(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C17051) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC0939Tm interfaceC0939TmY = AbstractC1047Xm.y(((PageFetcherSnapshot) this.this$0).hintHandler.hintFor(LoadType.APPEND), ((PageFetcherSnapshot) this.this$0).hintHandler.hintFor(LoadType.PREPEND));
                PageFetcherSnapshot$startConsumingHints$1$jumpHint$1 pageFetcherSnapshot$startConsumingHints$1$jumpHint$1 = new PageFetcherSnapshot$startConsumingHints$1$jumpHint$1(this.this$0, null);
                this.label = 1;
                obj = AbstractC1047Xm.r(interfaceC0939TmY, pageFetcherSnapshot$startConsumingHints$1$jumpHint$1, this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            ViewportHint viewportHint = (ViewportHint) obj;
            if (viewportHint != null) {
                PageFetcherSnapshot<Key, Value> pageFetcherSnapshot = this.this$0;
                Logger logger = LoggerKt.getLOGGER();
                if (logger != null && logger.isLoggable(3)) {
                    logger.log(3, "Jump triggered on PagingSource " + pageFetcherSnapshot.getPagingSource$paging_common() + " by " + viewportHint, null);
                }
                ((PageFetcherSnapshot) this.this$0).jumpCallback.invoke();
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$2", f = "PageFetcherSnapshot.kt", l = {645, UnknownRecord.BITMAP_00E9}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
            PageFetcherSnapshotState.Holder holder;
            GC gc;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                        gc = (GC) this.L$1;
                        holder = (PageFetcherSnapshotState.Holder) this.L$0;
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
                pageFetcherSnapshot = this.this$0;
                holder = ((PageFetcherSnapshot) pageFetcherSnapshot).stateHolder;
                GC gc2 = holder.lock;
                this.L$0 = holder;
                this.L$1 = gc2;
                this.L$2 = pageFetcherSnapshot;
                this.label = 1;
                if (gc2.c(null, this) == objD) {
                    return objD;
                }
                gc = gc2;
                InterfaceC0939Tm interfaceC0939TmConsumePrependGenerationIdAsFlow = holder.state.consumePrependGenerationIdAsFlow();
                gc.b(null);
                LoadType loadType = LoadType.PREPEND;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (pageFetcherSnapshot.collectAsGenerationalViewportHints(interfaceC0939TmConsumePrependGenerationIdAsFlow, loadType, this) == objD) {
                    return objD;
                }
                return FW.a;
            } catch (Throwable th) {
                gc.b(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$3, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$3", f = "PageFetcherSnapshot.kt", l = {645, Jpeg.M_APPE}, m = "invokeSuspend")
    public static final class C17063 extends XS implements InterfaceC0526Fp {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17063(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C17063(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C17063) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
            PageFetcherSnapshotState.Holder holder;
            GC gc;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                        gc = (GC) this.L$1;
                        holder = (PageFetcherSnapshotState.Holder) this.L$0;
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
                pageFetcherSnapshot = this.this$0;
                holder = ((PageFetcherSnapshot) pageFetcherSnapshot).stateHolder;
                GC gc2 = holder.lock;
                this.L$0 = holder;
                this.L$1 = gc2;
                this.L$2 = pageFetcherSnapshot;
                this.label = 1;
                if (gc2.c(null, this) == objD) {
                    return objD;
                }
                gc = gc2;
                InterfaceC0939Tm interfaceC0939TmConsumeAppendGenerationIdAsFlow = holder.state.consumeAppendGenerationIdAsFlow();
                gc.b(null);
                LoadType loadType = LoadType.APPEND;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (pageFetcherSnapshot.collectAsGenerationalViewportHints(interfaceC0939TmConsumeAppendGenerationIdAsFlow, loadType, this) == objD) {
                    return objD;
                }
                return FW.a;
            } catch (Throwable th) {
                gc.b(null);
                throw th;
            }
        }
    }

    public PageFetcherSnapshot(Key key, PagingSource<Key, Value> pagingSource, PagingConfig pagingConfig, InterfaceC0939Tm interfaceC0939Tm, RemoteMediatorConnection<Key, Value> remoteMediatorConnection, PagingState<Key, Value> pagingState, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(pagingSource, "pagingSource");
        AbstractC4492zt.h(pagingConfig, "config");
        AbstractC4492zt.h(interfaceC0939Tm, "retryFlow");
        AbstractC4492zt.h(interfaceC3588op, "jumpCallback");
        this.initialKey = key;
        this.pagingSource = pagingSource;
        this.config = pagingConfig;
        this.retryFlow = interfaceC0939Tm;
        this.remoteMediatorConnection = remoteMediatorConnection;
        this.previousPagingState = pagingState;
        this.jumpCallback = interfaceC3588op;
        if (pagingConfig.jumpThreshold != Integer.MIN_VALUE && !pagingSource.getJumpingSupported()) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.");
        }
        this.hintHandler = new HintHandler();
        this.pageEventChCollected = new AtomicBoolean(false);
        this.pageEventCh = AbstractC2287gb.b(-2, null, null, 6, null);
        this.stateHolder = new PageFetcherSnapshotState.Holder<>(pagingConfig);
        InterfaceC1243ae interfaceC1243aeB = AbstractC3511nu.b(null, 1, null);
        this.pageEventChannelFlowJob = interfaceC1243aeB;
        this.pageEventFlow = AbstractC1047Xm.B(CancelableChannelFlowKt.cancelableChannelFlow(interfaceC1243aeB, new PageFetcherSnapshot$pageEventFlow$1(this, null)), new PageFetcherSnapshot$pageEventFlow$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectAsGenerationalViewportHints(InterfaceC0939Tm interfaceC0939Tm, final LoadType loadType, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = AbstractC1047Xm.h(FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(interfaceC0939Tm, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, this, loadType)), new AnonymousClass3(loadType, null))).collect(new InterfaceC0995Vm(this) { // from class: androidx.paging.PageFetcherSnapshot.collectAsGenerationalViewportHints.4
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            {
                this.this$0 = this;
            }

            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(GenerationalViewportHint generationalViewportHint, InterfaceC0793Of interfaceC0793Of2) throws Throwable {
                Object objDoLoad = this.this$0.doLoad(loadType, generationalViewportHint, interfaceC0793Of2);
                return objDoLoad == AbstractC0378Bt.d() ? objDoLoad : FW.a;
            }
        }, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:103:0x0274  */
    /* JADX WARN: Code duplicated, block: B:106:0x0281  */
    /* JADX WARN: Code duplicated, block: B:112:0x0293  */
    /* JADX WARN: Code duplicated, block: B:114:0x0297  */
    /* JADX WARN: Code duplicated, block: B:116:0x029d  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:126:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:134:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:136:0x0302  */
    /* JADX WARN: Code duplicated, block: B:138:0x0308  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:44:0x0112  */
    /* JADX WARN: Code duplicated, block: B:49:0x0146 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0147  */
    /* JADX WARN: Code duplicated, block: B:53:0x014e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0166  */
    /* JADX WARN: Code duplicated, block: B:59:0x018d A[Catch: all -> 0x019b, TryCatch #3 {all -> 0x019b, blocks: (B:57:0x0169, B:59:0x018d, B:62:0x019e, B:64:0x01a7), top: B:152:0x0169 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01a7 A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #3 {all -> 0x019b, blocks: (B:57:0x0169, B:59:0x018d, B:62:0x019e, B:64:0x01a7), top: B:152:0x0169 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:78:0x0209 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x020a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:84:0x0216  */
    /* JADX WARN: Code duplicated, block: B:86:0x021c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0232  */
    /* JADX WARN: Code duplicated, block: B:94:0x023b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0258 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:99:0x0259  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [GC] */
    /* JADX WARN: Type inference failed for: r4v2, types: [GC] */
    /* JADX WARN: Type inference failed for: r4v35, types: [GC] */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v8, types: [GC] */
    public final Object doInitialLoad(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17031 c17031;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        GC gc;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState;
        LoadType loadType;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot2;
        Logger logger;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot3;
        PagingSource.LoadResult<Key, Value> loadResult;
        Logger logger2;
        Logger logger3;
        PageFetcherSnapshotState.Holder<Key, Value> holder2;
        GC gc2;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot4;
        GC gc3;
        PagingSource.LoadResult<Key, Value> loadResult2;
        PageFetcherSnapshotState.Holder<Key, Value> holder3;
        GC gc4;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot5;
        GC gc5;
        PagingSource.LoadResult<Key, Value> loadResult3;
        PageFetcherSnapshotState pageFetcherSnapshotState2;
        LoadType loadType2;
        boolean zInsert;
        LoadState.NotLoading.Companion companion;
        Logger logger4;
        PagingSource.LoadResult<Key, Value> loadResult4;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot6;
        Logger logger5;
        PageFetcherSnapshotState.Holder<Key, Value> holder4;
        GC gc6;
        GC gc7;
        PagingSource.LoadResult<Key, Value> loadResult5;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot7;
        InterfaceC1009Wa interfaceC1009Wa;
        PageEvent<Value> pageEvent$paging_common;
        PagingSource.LoadResult.Page page;
        PageFetcherSnapshotState.Holder<Key, Value> holder5;
        GC gc8;
        GC gc9;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot8;
        PagingState<Key, Value> pagingStateCurrentPagingState$paging_common;
        PagingSource.LoadResult.Page page2;
        GC gc10;
        PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState3;
        LoadState.Error error;
        LoadType loadType3;
        if (interfaceC0793Of instanceof C17031) {
            c17031 = (C17031) interfaceC0793Of;
            int i = c17031.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17031.label = i - Integer.MIN_VALUE;
            } else {
                c17031 = new C17031(this, interfaceC0793Of);
            }
        } else {
            c17031 = new C17031(this, interfaceC0793Of);
        }
        Object objLoad = c17031.result;
        Object objD = AbstractC0378Bt.d();
        ?? r4 = c17031.label;
        try {
            try {
                switch (r4) {
                    case 0:
                        LL.b(objLoad);
                        holder = this.stateHolder;
                        GC gc11 = ((PageFetcherSnapshotState.Holder) holder).lock;
                        c17031.L$0 = this;
                        c17031.L$1 = holder;
                        c17031.L$2 = gc11;
                        c17031.label = 1;
                        if (gc11.c(null, c17031) == objD) {
                            return objD;
                        }
                        gc = gc11;
                        pageFetcherSnapshot = this;
                        pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
                        loadType = LoadType.REFRESH;
                        c17031.L$0 = pageFetcherSnapshot;
                        c17031.L$1 = gc;
                        c17031.L$2 = null;
                        c17031.label = 2;
                        if (pageFetcherSnapshot.setLoading(pageFetcherSnapshotState, loadType, c17031) == objD) {
                            return objD;
                        }
                        pageFetcherSnapshot2 = pageFetcherSnapshot;
                        r4 = gc;
                        FW fw = FW.a;
                        r4.b(null);
                        PagingSource.LoadParams<Key> loadParams = pageFetcherSnapshot2.loadParams(LoadType.REFRESH, pageFetcherSnapshot2.initialKey);
                        logger = LoggerKt.getLOGGER();
                        if (logger != null && logger.isLoggable(3)) {
                            logger.log(3, "Start REFRESH with loadKey " + pageFetcherSnapshot2.initialKey + " on " + pageFetcherSnapshot2.pagingSource, null);
                        }
                        PagingSource<Key, Value> pagingSource = pageFetcherSnapshot2.pagingSource;
                        c17031.L$0 = pageFetcherSnapshot2;
                        c17031.L$1 = null;
                        c17031.label = 3;
                        objLoad = pagingSource.load(loadParams, c17031);
                        if (objLoad == objD) {
                            return objD;
                        }
                        pageFetcherSnapshot3 = pageFetcherSnapshot2;
                        loadResult = (PagingSource.LoadResult) objLoad;
                        if (loadResult instanceof PagingSource.LoadResult.Page) {
                            holder3 = pageFetcherSnapshot3.stateHolder;
                            gc4 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                            c17031.L$0 = pageFetcherSnapshot3;
                            c17031.L$1 = loadResult;
                            c17031.L$2 = holder3;
                            c17031.L$3 = gc4;
                            c17031.label = 4;
                            if (gc4.c(null, c17031) == objD) {
                                return objD;
                            }
                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                            gc5 = gc4;
                            loadResult3 = loadResult;
                            try {
                                pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder3).state;
                                loadType2 = LoadType.REFRESH;
                                zInsert = pageFetcherSnapshotState2.insert(0, loadType2, (PagingSource.LoadResult.Page) loadResult3);
                                MutableLoadStateCollection sourceLoadStates$paging_common = pageFetcherSnapshotState2.getSourceLoadStates$paging_common();
                                companion = LoadState.NotLoading.Companion;
                                sourceLoadStates$paging_common.set(loadType2, companion.getIncomplete$paging_common());
                                if (((PagingSource.LoadResult.Page) loadResult3).getPrevKey() == null) {
                                    pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.PREPEND, companion.getComplete$paging_common());
                                }
                                if (((PagingSource.LoadResult.Page) loadResult3).getNextKey() == null) {
                                    pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.APPEND, companion.getComplete$paging_common());
                                }
                                gc5.b(null);
                                if (zInsert) {
                                    logger5 = LoggerKt.getLOGGER();
                                    if (logger5 != null && logger5.isLoggable(3)) {
                                        logger5.log(3, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, loadResult3), null);
                                    }
                                    holder4 = pageFetcherSnapshot5.stateHolder;
                                    gc6 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                    c17031.L$0 = pageFetcherSnapshot5;
                                    c17031.L$1 = loadResult3;
                                    c17031.L$2 = holder4;
                                    c17031.L$3 = gc6;
                                    c17031.label = 5;
                                    if (gc6.c(null, c17031) == objD) {
                                        return objD;
                                    }
                                    gc7 = gc6;
                                    loadResult5 = loadResult3;
                                    pageFetcherSnapshot7 = pageFetcherSnapshot5;
                                    PageFetcherSnapshotState pageFetcherSnapshotState4 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                    interfaceC1009Wa = pageFetcherSnapshot7.pageEventCh;
                                    pageEvent$paging_common = pageFetcherSnapshotState4.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult5, LoadType.REFRESH);
                                    c17031.L$0 = pageFetcherSnapshot7;
                                    c17031.L$1 = loadResult5;
                                    c17031.L$2 = gc7;
                                    c17031.L$3 = null;
                                    c17031.label = 6;
                                    if (interfaceC1009Wa.send(pageEvent$paging_common, c17031) == objD) {
                                        return objD;
                                    }
                                    loadResult4 = loadResult5;
                                    pageFetcherSnapshot6 = pageFetcherSnapshot7;
                                    r4 = gc7;
                                    FW fw2 = FW.a;
                                    r4.b(null);
                                } else {
                                    logger4 = LoggerKt.getLOGGER();
                                    if (logger4 != null && logger4.isLoggable(2)) {
                                        logger4.log(2, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, null), null);
                                    }
                                    loadResult4 = loadResult3;
                                    pageFetcherSnapshot6 = pageFetcherSnapshot5;
                                }
                                if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                                    page = (PagingSource.LoadResult.Page) loadResult4;
                                    if (page.getPrevKey() != null || page.getNextKey() == null) {
                                        holder5 = pageFetcherSnapshot6.stateHolder;
                                        gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                        c17031.L$0 = pageFetcherSnapshot6;
                                        c17031.L$1 = loadResult4;
                                        c17031.L$2 = holder5;
                                        c17031.L$3 = gc8;
                                        c17031.label = 7;
                                        if (gc8.c(null, c17031) == objD) {
                                            return objD;
                                        }
                                        gc9 = gc8;
                                        pageFetcherSnapshot8 = pageFetcherSnapshot6;
                                        try {
                                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                                            gc9.b(null);
                                            page2 = (PagingSource.LoadResult.Page) loadResult4;
                                            if (page2.getPrevKey() == null) {
                                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                            }
                                            if (page2.getNextKey() == null) {
                                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                            }
                                        } catch (Throwable th) {
                                            gc9.b(null);
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                gc5.b(null);
                                throw th2;
                            }
                            break;
                        } else {
                            if (loadResult instanceof PagingSource.LoadResult.Error) {
                                logger3 = LoggerKt.getLOGGER();
                                if (logger3 != null && logger3.isLoggable(2)) {
                                    logger3.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                holder2 = pageFetcherSnapshot3.stateHolder;
                                gc2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                c17031.L$0 = pageFetcherSnapshot3;
                                c17031.L$1 = loadResult;
                                c17031.L$2 = holder2;
                                c17031.L$3 = gc2;
                                c17031.label = 8;
                                if (gc2.c(null, c17031) == objD) {
                                    return objD;
                                }
                                pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                gc3 = gc2;
                                loadResult2 = loadResult;
                                try {
                                    pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                    error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                                    loadType3 = LoadType.REFRESH;
                                    c17031.L$0 = gc3;
                                    c17031.L$1 = null;
                                    c17031.L$2 = null;
                                    c17031.L$3 = null;
                                    c17031.label = 9;
                                    if (pageFetcherSnapshot4.setError(pageFetcherSnapshotState3, loadType3, error, c17031) == objD) {
                                        return objD;
                                    }
                                    gc10 = gc3;
                                    FW fw3 = FW.a;
                                    gc10.b(null);
                                    return FW.a;
                                } catch (Throwable th3) {
                                    th = th3;
                                    gc10 = gc3;
                                    gc10.b(null);
                                    throw th;
                                }
                            }
                            if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                                logger2 = LoggerKt.getLOGGER();
                                if (logger2 != null && logger2.isLoggable(2)) {
                                    logger2.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                pageFetcherSnapshot3.onInvalidLoad();
                            }
                        }
                        return FW.a;
                    case 1:
                        GC gc12 = (GC) c17031.L$2;
                        holder = (PageFetcherSnapshotState.Holder) c17031.L$1;
                        pageFetcherSnapshot = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        gc = gc12;
                        pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
                        loadType = LoadType.REFRESH;
                        c17031.L$0 = pageFetcherSnapshot;
                        c17031.L$1 = gc;
                        c17031.L$2 = null;
                        c17031.label = 2;
                        if (pageFetcherSnapshot.setLoading(pageFetcherSnapshotState, loadType, c17031) == objD) {
                            return objD;
                        }
                        pageFetcherSnapshot2 = pageFetcherSnapshot;
                        r4 = gc;
                        FW fw4 = FW.a;
                        r4.b(null);
                        PagingSource.LoadParams<Key> loadParams2 = pageFetcherSnapshot2.loadParams(LoadType.REFRESH, pageFetcherSnapshot2.initialKey);
                        logger = LoggerKt.getLOGGER();
                        if (logger != null) {
                            logger.log(3, "Start REFRESH with loadKey " + pageFetcherSnapshot2.initialKey + " on " + pageFetcherSnapshot2.pagingSource, null);
                        }
                        PagingSource<Key, Value> pagingSource2 = pageFetcherSnapshot2.pagingSource;
                        c17031.L$0 = pageFetcherSnapshot2;
                        c17031.L$1 = null;
                        c17031.label = 3;
                        objLoad = pagingSource2.load(loadParams2, c17031);
                        if (objLoad == objD) {
                            return objD;
                        }
                        pageFetcherSnapshot3 = pageFetcherSnapshot2;
                        loadResult = (PagingSource.LoadResult) objLoad;
                        if (loadResult instanceof PagingSource.LoadResult.Page) {
                            holder3 = pageFetcherSnapshot3.stateHolder;
                            gc4 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                            c17031.L$0 = pageFetcherSnapshot3;
                            c17031.L$1 = loadResult;
                            c17031.L$2 = holder3;
                            c17031.L$3 = gc4;
                            c17031.label = 4;
                            if (gc4.c(null, c17031) == objD) {
                                return objD;
                            }
                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                            gc5 = gc4;
                            loadResult3 = loadResult;
                            pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder3).state;
                            loadType2 = LoadType.REFRESH;
                            zInsert = pageFetcherSnapshotState2.insert(0, loadType2, (PagingSource.LoadResult.Page) loadResult3);
                            MutableLoadStateCollection sourceLoadStates$paging_common2 = pageFetcherSnapshotState2.getSourceLoadStates$paging_common();
                            companion = LoadState.NotLoading.Companion;
                            sourceLoadStates$paging_common2.set(loadType2, companion.getIncomplete$paging_common());
                            if (((PagingSource.LoadResult.Page) loadResult3).getPrevKey() == null) {
                                pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.PREPEND, companion.getComplete$paging_common());
                            }
                            if (((PagingSource.LoadResult.Page) loadResult3).getNextKey() == null) {
                                pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.APPEND, companion.getComplete$paging_common());
                            }
                            gc5.b(null);
                            if (zInsert) {
                                logger5 = LoggerKt.getLOGGER();
                                if (logger5 != null) {
                                    logger5.log(3, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, loadResult3), null);
                                }
                                holder4 = pageFetcherSnapshot5.stateHolder;
                                gc6 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                c17031.L$0 = pageFetcherSnapshot5;
                                c17031.L$1 = loadResult3;
                                c17031.L$2 = holder4;
                                c17031.L$3 = gc6;
                                c17031.label = 5;
                                if (gc6.c(null, c17031) == objD) {
                                    return objD;
                                }
                                gc7 = gc6;
                                loadResult5 = loadResult3;
                                pageFetcherSnapshot7 = pageFetcherSnapshot5;
                                PageFetcherSnapshotState pageFetcherSnapshotState5 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                interfaceC1009Wa = pageFetcherSnapshot7.pageEventCh;
                                pageEvent$paging_common = pageFetcherSnapshotState5.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult5, LoadType.REFRESH);
                                c17031.L$0 = pageFetcherSnapshot7;
                                c17031.L$1 = loadResult5;
                                c17031.L$2 = gc7;
                                c17031.L$3 = null;
                                c17031.label = 6;
                                if (interfaceC1009Wa.send(pageEvent$paging_common, c17031) == objD) {
                                    return objD;
                                }
                                loadResult4 = loadResult5;
                                pageFetcherSnapshot6 = pageFetcherSnapshot7;
                                r4 = gc7;
                                FW fw5 = FW.a;
                                r4.b(null);
                            } else {
                                logger4 = LoggerKt.getLOGGER();
                                if (logger4 != null) {
                                    logger4.log(2, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, null), null);
                                }
                                loadResult4 = loadResult3;
                                pageFetcherSnapshot6 = pageFetcherSnapshot5;
                            }
                            if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                                page = (PagingSource.LoadResult.Page) loadResult4;
                                if (page.getPrevKey() != null) {
                                }
                                holder5 = pageFetcherSnapshot6.stateHolder;
                                gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                c17031.L$0 = pageFetcherSnapshot6;
                                c17031.L$1 = loadResult4;
                                c17031.L$2 = holder5;
                                c17031.L$3 = gc8;
                                c17031.label = 7;
                                if (gc8.c(null, c17031) == objD) {
                                    return objD;
                                }
                                gc9 = gc8;
                                pageFetcherSnapshot8 = pageFetcherSnapshot6;
                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                                gc9.b(null);
                                page2 = (PagingSource.LoadResult.Page) loadResult4;
                                if (page2.getPrevKey() == null) {
                                    pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                }
                                if (page2.getNextKey() == null) {
                                    pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                }
                            }
                            break;
                        } else {
                            if (loadResult instanceof PagingSource.LoadResult.Error) {
                                logger3 = LoggerKt.getLOGGER();
                                if (logger3 != null) {
                                    logger3.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                holder2 = pageFetcherSnapshot3.stateHolder;
                                gc2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                c17031.L$0 = pageFetcherSnapshot3;
                                c17031.L$1 = loadResult;
                                c17031.L$2 = holder2;
                                c17031.L$3 = gc2;
                                c17031.label = 8;
                                if (gc2.c(null, c17031) == objD) {
                                    return objD;
                                }
                                pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                gc3 = gc2;
                                loadResult2 = loadResult;
                                pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                                loadType3 = LoadType.REFRESH;
                                c17031.L$0 = gc3;
                                c17031.L$1 = null;
                                c17031.L$2 = null;
                                c17031.L$3 = null;
                                c17031.label = 9;
                                if (pageFetcherSnapshot4.setError(pageFetcherSnapshotState3, loadType3, error, c17031) == objD) {
                                    return objD;
                                }
                                gc10 = gc3;
                                FW fw6 = FW.a;
                                gc10.b(null);
                                return FW.a;
                            }
                            if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                                logger2 = LoggerKt.getLOGGER();
                                if (logger2 != null) {
                                    logger2.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                pageFetcherSnapshot3.onInvalidLoad();
                            }
                        }
                        return FW.a;
                    case 2:
                        GC gc13 = (GC) c17031.L$1;
                        pageFetcherSnapshot2 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        r4 = gc13;
                        FW fw7 = FW.a;
                        r4.b(null);
                        PagingSource.LoadParams<Key> loadParams3 = pageFetcherSnapshot2.loadParams(LoadType.REFRESH, pageFetcherSnapshot2.initialKey);
                        logger = LoggerKt.getLOGGER();
                        if (logger != null) {
                            logger.log(3, "Start REFRESH with loadKey " + pageFetcherSnapshot2.initialKey + " on " + pageFetcherSnapshot2.pagingSource, null);
                        }
                        PagingSource<Key, Value> pagingSource3 = pageFetcherSnapshot2.pagingSource;
                        c17031.L$0 = pageFetcherSnapshot2;
                        c17031.L$1 = null;
                        c17031.label = 3;
                        objLoad = pagingSource3.load(loadParams3, c17031);
                        if (objLoad == objD) {
                            return objD;
                        }
                        pageFetcherSnapshot3 = pageFetcherSnapshot2;
                        loadResult = (PagingSource.LoadResult) objLoad;
                        if (loadResult instanceof PagingSource.LoadResult.Page) {
                            holder3 = pageFetcherSnapshot3.stateHolder;
                            gc4 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                            c17031.L$0 = pageFetcherSnapshot3;
                            c17031.L$1 = loadResult;
                            c17031.L$2 = holder3;
                            c17031.L$3 = gc4;
                            c17031.label = 4;
                            if (gc4.c(null, c17031) == objD) {
                                return objD;
                            }
                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                            gc5 = gc4;
                            loadResult3 = loadResult;
                            pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder3).state;
                            loadType2 = LoadType.REFRESH;
                            zInsert = pageFetcherSnapshotState2.insert(0, loadType2, (PagingSource.LoadResult.Page) loadResult3);
                            MutableLoadStateCollection sourceLoadStates$paging_common3 = pageFetcherSnapshotState2.getSourceLoadStates$paging_common();
                            companion = LoadState.NotLoading.Companion;
                            sourceLoadStates$paging_common3.set(loadType2, companion.getIncomplete$paging_common());
                            if (((PagingSource.LoadResult.Page) loadResult3).getPrevKey() == null) {
                                pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.PREPEND, companion.getComplete$paging_common());
                            }
                            if (((PagingSource.LoadResult.Page) loadResult3).getNextKey() == null) {
                                pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.APPEND, companion.getComplete$paging_common());
                            }
                            gc5.b(null);
                            if (zInsert) {
                                logger5 = LoggerKt.getLOGGER();
                                if (logger5 != null) {
                                    logger5.log(3, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, loadResult3), null);
                                }
                                holder4 = pageFetcherSnapshot5.stateHolder;
                                gc6 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                c17031.L$0 = pageFetcherSnapshot5;
                                c17031.L$1 = loadResult3;
                                c17031.L$2 = holder4;
                                c17031.L$3 = gc6;
                                c17031.label = 5;
                                if (gc6.c(null, c17031) == objD) {
                                    return objD;
                                }
                                gc7 = gc6;
                                loadResult5 = loadResult3;
                                pageFetcherSnapshot7 = pageFetcherSnapshot5;
                                PageFetcherSnapshotState pageFetcherSnapshotState6 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                interfaceC1009Wa = pageFetcherSnapshot7.pageEventCh;
                                pageEvent$paging_common = pageFetcherSnapshotState6.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult5, LoadType.REFRESH);
                                c17031.L$0 = pageFetcherSnapshot7;
                                c17031.L$1 = loadResult5;
                                c17031.L$2 = gc7;
                                c17031.L$3 = null;
                                c17031.label = 6;
                                if (interfaceC1009Wa.send(pageEvent$paging_common, c17031) == objD) {
                                    return objD;
                                }
                                loadResult4 = loadResult5;
                                pageFetcherSnapshot6 = pageFetcherSnapshot7;
                                r4 = gc7;
                                FW fw8 = FW.a;
                                r4.b(null);
                            } else {
                                logger4 = LoggerKt.getLOGGER();
                                if (logger4 != null) {
                                    logger4.log(2, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, null), null);
                                }
                                loadResult4 = loadResult3;
                                pageFetcherSnapshot6 = pageFetcherSnapshot5;
                            }
                            if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                                page = (PagingSource.LoadResult.Page) loadResult4;
                                if (page.getPrevKey() != null) {
                                }
                                holder5 = pageFetcherSnapshot6.stateHolder;
                                gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                c17031.L$0 = pageFetcherSnapshot6;
                                c17031.L$1 = loadResult4;
                                c17031.L$2 = holder5;
                                c17031.L$3 = gc8;
                                c17031.label = 7;
                                if (gc8.c(null, c17031) == objD) {
                                    return objD;
                                }
                                gc9 = gc8;
                                pageFetcherSnapshot8 = pageFetcherSnapshot6;
                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                                gc9.b(null);
                                page2 = (PagingSource.LoadResult.Page) loadResult4;
                                if (page2.getPrevKey() == null) {
                                    pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                }
                                if (page2.getNextKey() == null) {
                                    pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                }
                            }
                            break;
                        } else {
                            if (loadResult instanceof PagingSource.LoadResult.Error) {
                                logger3 = LoggerKt.getLOGGER();
                                if (logger3 != null) {
                                    logger3.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                holder2 = pageFetcherSnapshot3.stateHolder;
                                gc2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                c17031.L$0 = pageFetcherSnapshot3;
                                c17031.L$1 = loadResult;
                                c17031.L$2 = holder2;
                                c17031.L$3 = gc2;
                                c17031.label = 8;
                                if (gc2.c(null, c17031) == objD) {
                                    return objD;
                                }
                                pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                gc3 = gc2;
                                loadResult2 = loadResult;
                                pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                                loadType3 = LoadType.REFRESH;
                                c17031.L$0 = gc3;
                                c17031.L$1 = null;
                                c17031.L$2 = null;
                                c17031.L$3 = null;
                                c17031.label = 9;
                                if (pageFetcherSnapshot4.setError(pageFetcherSnapshotState3, loadType3, error, c17031) == objD) {
                                    return objD;
                                }
                                gc10 = gc3;
                                FW fw9 = FW.a;
                                gc10.b(null);
                                return FW.a;
                            }
                            if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                                logger2 = LoggerKt.getLOGGER();
                                if (logger2 != null) {
                                    logger2.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                pageFetcherSnapshot3.onInvalidLoad();
                            }
                        }
                        return FW.a;
                    case 3:
                        pageFetcherSnapshot3 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        loadResult = (PagingSource.LoadResult) objLoad;
                        if (loadResult instanceof PagingSource.LoadResult.Page) {
                            holder3 = pageFetcherSnapshot3.stateHolder;
                            gc4 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                            c17031.L$0 = pageFetcherSnapshot3;
                            c17031.L$1 = loadResult;
                            c17031.L$2 = holder3;
                            c17031.L$3 = gc4;
                            c17031.label = 4;
                            if (gc4.c(null, c17031) == objD) {
                                return objD;
                            }
                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                            gc5 = gc4;
                            loadResult3 = loadResult;
                            pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder3).state;
                            loadType2 = LoadType.REFRESH;
                            zInsert = pageFetcherSnapshotState2.insert(0, loadType2, (PagingSource.LoadResult.Page) loadResult3);
                            MutableLoadStateCollection sourceLoadStates$paging_common4 = pageFetcherSnapshotState2.getSourceLoadStates$paging_common();
                            companion = LoadState.NotLoading.Companion;
                            sourceLoadStates$paging_common4.set(loadType2, companion.getIncomplete$paging_common());
                            if (((PagingSource.LoadResult.Page) loadResult3).getPrevKey() == null) {
                                pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.PREPEND, companion.getComplete$paging_common());
                            }
                            if (((PagingSource.LoadResult.Page) loadResult3).getNextKey() == null) {
                                pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.APPEND, companion.getComplete$paging_common());
                            }
                            gc5.b(null);
                            if (zInsert) {
                                logger5 = LoggerKt.getLOGGER();
                                if (logger5 != null) {
                                    logger5.log(3, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, loadResult3), null);
                                }
                                holder4 = pageFetcherSnapshot5.stateHolder;
                                gc6 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                c17031.L$0 = pageFetcherSnapshot5;
                                c17031.L$1 = loadResult3;
                                c17031.L$2 = holder4;
                                c17031.L$3 = gc6;
                                c17031.label = 5;
                                if (gc6.c(null, c17031) == objD) {
                                    return objD;
                                }
                                gc7 = gc6;
                                loadResult5 = loadResult3;
                                pageFetcherSnapshot7 = pageFetcherSnapshot5;
                                PageFetcherSnapshotState pageFetcherSnapshotState7 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                interfaceC1009Wa = pageFetcherSnapshot7.pageEventCh;
                                pageEvent$paging_common = pageFetcherSnapshotState7.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult5, LoadType.REFRESH);
                                c17031.L$0 = pageFetcherSnapshot7;
                                c17031.L$1 = loadResult5;
                                c17031.L$2 = gc7;
                                c17031.L$3 = null;
                                c17031.label = 6;
                                if (interfaceC1009Wa.send(pageEvent$paging_common, c17031) == objD) {
                                    return objD;
                                }
                                loadResult4 = loadResult5;
                                pageFetcherSnapshot6 = pageFetcherSnapshot7;
                                r4 = gc7;
                                FW fw10 = FW.a;
                                r4.b(null);
                            } else {
                                logger4 = LoggerKt.getLOGGER();
                                if (logger4 != null) {
                                    logger4.log(2, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, null), null);
                                }
                                loadResult4 = loadResult3;
                                pageFetcherSnapshot6 = pageFetcherSnapshot5;
                            }
                            if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                                page = (PagingSource.LoadResult.Page) loadResult4;
                                if (page.getPrevKey() != null) {
                                }
                                holder5 = pageFetcherSnapshot6.stateHolder;
                                gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                c17031.L$0 = pageFetcherSnapshot6;
                                c17031.L$1 = loadResult4;
                                c17031.L$2 = holder5;
                                c17031.L$3 = gc8;
                                c17031.label = 7;
                                if (gc8.c(null, c17031) == objD) {
                                    return objD;
                                }
                                gc9 = gc8;
                                pageFetcherSnapshot8 = pageFetcherSnapshot6;
                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                                gc9.b(null);
                                page2 = (PagingSource.LoadResult.Page) loadResult4;
                                if (page2.getPrevKey() == null) {
                                    pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                }
                                if (page2.getNextKey() == null) {
                                    pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                }
                            }
                            break;
                        } else {
                            if (loadResult instanceof PagingSource.LoadResult.Error) {
                                logger3 = LoggerKt.getLOGGER();
                                if (logger3 != null) {
                                    logger3.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                holder2 = pageFetcherSnapshot3.stateHolder;
                                gc2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                c17031.L$0 = pageFetcherSnapshot3;
                                c17031.L$1 = loadResult;
                                c17031.L$2 = holder2;
                                c17031.L$3 = gc2;
                                c17031.label = 8;
                                if (gc2.c(null, c17031) == objD) {
                                    return objD;
                                }
                                pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                gc3 = gc2;
                                loadResult2 = loadResult;
                                pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                                loadType3 = LoadType.REFRESH;
                                c17031.L$0 = gc3;
                                c17031.L$1 = null;
                                c17031.L$2 = null;
                                c17031.L$3 = null;
                                c17031.label = 9;
                                if (pageFetcherSnapshot4.setError(pageFetcherSnapshotState3, loadType3, error, c17031) == objD) {
                                    return objD;
                                }
                                gc10 = gc3;
                                FW fw11 = FW.a;
                                gc10.b(null);
                                return FW.a;
                            }
                            if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                                logger2 = LoggerKt.getLOGGER();
                                if (logger2 != null) {
                                    logger2.log(2, pageFetcherSnapshot3.loadResultLog(LoadType.REFRESH, pageFetcherSnapshot3.initialKey, loadResult), null);
                                }
                                pageFetcherSnapshot3.onInvalidLoad();
                            }
                        }
                        return FW.a;
                    case 4:
                        gc5 = (GC) c17031.L$3;
                        holder3 = (PageFetcherSnapshotState.Holder) c17031.L$2;
                        loadResult3 = (PagingSource.LoadResult) c17031.L$1;
                        pageFetcherSnapshot5 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder3).state;
                        loadType2 = LoadType.REFRESH;
                        zInsert = pageFetcherSnapshotState2.insert(0, loadType2, (PagingSource.LoadResult.Page) loadResult3);
                        MutableLoadStateCollection sourceLoadStates$paging_common5 = pageFetcherSnapshotState2.getSourceLoadStates$paging_common();
                        companion = LoadState.NotLoading.Companion;
                        sourceLoadStates$paging_common5.set(loadType2, companion.getIncomplete$paging_common());
                        if (((PagingSource.LoadResult.Page) loadResult3).getPrevKey() == null) {
                            pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.PREPEND, companion.getComplete$paging_common());
                        }
                        if (((PagingSource.LoadResult.Page) loadResult3).getNextKey() == null) {
                            pageFetcherSnapshotState2.getSourceLoadStates$paging_common().set(LoadType.APPEND, companion.getComplete$paging_common());
                            break;
                        }
                        gc5.b(null);
                        if (zInsert) {
                            logger5 = LoggerKt.getLOGGER();
                            if (logger5 != null) {
                                logger5.log(3, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, loadResult3), null);
                            }
                            holder4 = pageFetcherSnapshot5.stateHolder;
                            gc6 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                            c17031.L$0 = pageFetcherSnapshot5;
                            c17031.L$1 = loadResult3;
                            c17031.L$2 = holder4;
                            c17031.L$3 = gc6;
                            c17031.label = 5;
                            if (gc6.c(null, c17031) == objD) {
                                return objD;
                            }
                            gc7 = gc6;
                            loadResult5 = loadResult3;
                            pageFetcherSnapshot7 = pageFetcherSnapshot5;
                            PageFetcherSnapshotState pageFetcherSnapshotState8 = ((PageFetcherSnapshotState.Holder) holder4).state;
                            interfaceC1009Wa = pageFetcherSnapshot7.pageEventCh;
                            pageEvent$paging_common = pageFetcherSnapshotState8.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult5, LoadType.REFRESH);
                            c17031.L$0 = pageFetcherSnapshot7;
                            c17031.L$1 = loadResult5;
                            c17031.L$2 = gc7;
                            c17031.L$3 = null;
                            c17031.label = 6;
                            if (interfaceC1009Wa.send(pageEvent$paging_common, c17031) == objD) {
                                return objD;
                            }
                            loadResult4 = loadResult5;
                            pageFetcherSnapshot6 = pageFetcherSnapshot7;
                            r4 = gc7;
                            FW fw12 = FW.a;
                            r4.b(null);
                        } else {
                            logger4 = LoggerKt.getLOGGER();
                            if (logger4 != null) {
                                logger4.log(2, pageFetcherSnapshot5.loadResultLog(loadType2, pageFetcherSnapshot5.initialKey, null), null);
                            }
                            loadResult4 = loadResult3;
                            pageFetcherSnapshot6 = pageFetcherSnapshot5;
                        }
                        if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                            page = (PagingSource.LoadResult.Page) loadResult4;
                            if (page.getPrevKey() != null) {
                            }
                            holder5 = pageFetcherSnapshot6.stateHolder;
                            gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                            c17031.L$0 = pageFetcherSnapshot6;
                            c17031.L$1 = loadResult4;
                            c17031.L$2 = holder5;
                            c17031.L$3 = gc8;
                            c17031.label = 7;
                            if (gc8.c(null, c17031) == objD) {
                                return objD;
                            }
                            gc9 = gc8;
                            pageFetcherSnapshot8 = pageFetcherSnapshot6;
                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                            gc9.b(null);
                            page2 = (PagingSource.LoadResult.Page) loadResult4;
                            if (page2.getPrevKey() == null) {
                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                            }
                            if (page2.getNextKey() == null) {
                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                            }
                            break;
                        }
                        return FW.a;
                    case 5:
                        GC gc14 = (GC) c17031.L$3;
                        holder4 = (PageFetcherSnapshotState.Holder) c17031.L$2;
                        loadResult5 = (PagingSource.LoadResult) c17031.L$1;
                        pageFetcherSnapshot7 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        gc7 = gc14;
                        PageFetcherSnapshotState pageFetcherSnapshotState9 = ((PageFetcherSnapshotState.Holder) holder4).state;
                        interfaceC1009Wa = pageFetcherSnapshot7.pageEventCh;
                        pageEvent$paging_common = pageFetcherSnapshotState9.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult5, LoadType.REFRESH);
                        c17031.L$0 = pageFetcherSnapshot7;
                        c17031.L$1 = loadResult5;
                        c17031.L$2 = gc7;
                        c17031.L$3 = null;
                        c17031.label = 6;
                        if (interfaceC1009Wa.send(pageEvent$paging_common, c17031) == objD) {
                            return objD;
                        }
                        loadResult4 = loadResult5;
                        pageFetcherSnapshot6 = pageFetcherSnapshot7;
                        r4 = gc7;
                        FW fw13 = FW.a;
                        r4.b(null);
                        if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                            page = (PagingSource.LoadResult.Page) loadResult4;
                            if (page.getPrevKey() != null) {
                            }
                            holder5 = pageFetcherSnapshot6.stateHolder;
                            gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                            c17031.L$0 = pageFetcherSnapshot6;
                            c17031.L$1 = loadResult4;
                            c17031.L$2 = holder5;
                            c17031.L$3 = gc8;
                            c17031.label = 7;
                            if (gc8.c(null, c17031) == objD) {
                                return objD;
                            }
                            gc9 = gc8;
                            pageFetcherSnapshot8 = pageFetcherSnapshot6;
                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                            gc9.b(null);
                            page2 = (PagingSource.LoadResult.Page) loadResult4;
                            if (page2.getPrevKey() == null) {
                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                            }
                            if (page2.getNextKey() == null) {
                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                            }
                            break;
                        }
                        return FW.a;
                    case 6:
                        GC gc15 = (GC) c17031.L$2;
                        loadResult4 = (PagingSource.LoadResult) c17031.L$1;
                        pageFetcherSnapshot6 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        r4 = gc15;
                        FW fw14 = FW.a;
                        r4.b(null);
                        if (pageFetcherSnapshot6.remoteMediatorConnection != null) {
                            page = (PagingSource.LoadResult.Page) loadResult4;
                            if (page.getPrevKey() != null) {
                            }
                            holder5 = pageFetcherSnapshot6.stateHolder;
                            gc8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                            c17031.L$0 = pageFetcherSnapshot6;
                            c17031.L$1 = loadResult4;
                            c17031.L$2 = holder5;
                            c17031.L$3 = gc8;
                            c17031.label = 7;
                            if (gc8.c(null, c17031) == objD) {
                                return objD;
                            }
                            gc9 = gc8;
                            pageFetcherSnapshot8 = pageFetcherSnapshot6;
                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                            gc9.b(null);
                            page2 = (PagingSource.LoadResult.Page) loadResult4;
                            if (page2.getPrevKey() == null) {
                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                            }
                            if (page2.getNextKey() == null) {
                                pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                            }
                            break;
                        }
                        return FW.a;
                    case 7:
                        gc9 = (GC) c17031.L$3;
                        holder5 = (PageFetcherSnapshotState.Holder) c17031.L$2;
                        loadResult4 = (PagingSource.LoadResult) c17031.L$1;
                        pageFetcherSnapshot8 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(pageFetcherSnapshot8.hintHandler.getLastAccessHint());
                        gc9.b(null);
                        page2 = (PagingSource.LoadResult.Page) loadResult4;
                        if (page2.getPrevKey() == null) {
                            pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                        }
                        if (page2.getNextKey() == null) {
                            pageFetcherSnapshot8.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                        }
                        return FW.a;
                    case 8:
                        gc3 = (GC) c17031.L$3;
                        holder2 = (PageFetcherSnapshotState.Holder) c17031.L$2;
                        loadResult2 = (PagingSource.LoadResult) c17031.L$1;
                        pageFetcherSnapshot4 = (PageFetcherSnapshot) c17031.L$0;
                        LL.b(objLoad);
                        pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                        error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                        loadType3 = LoadType.REFRESH;
                        c17031.L$0 = gc3;
                        c17031.L$1 = null;
                        c17031.L$2 = null;
                        c17031.L$3 = null;
                        c17031.label = 9;
                        if (pageFetcherSnapshot4.setError(pageFetcherSnapshotState3, loadType3, error, c17031) == objD) {
                            return objD;
                        }
                        gc10 = gc3;
                        FW fw15 = FW.a;
                        gc10.b(null);
                        return FW.a;
                    case 9:
                        gc10 = (GC) c17031.L$0;
                        try {
                            LL.b(objLoad);
                            FW fw16 = FW.a;
                            gc10.b(null);
                            return FW.a;
                        } catch (Throwable th4) {
                            th = th4;
                            gc10.b(null);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th5) {
                r4.b(null);
                throw th5;
            }
        } catch (Throwable th6) {
            r4.b(null);
            throw th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:102:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:103:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:105:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:108:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:119:0x0457 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0458  */
    /* JADX WARN: Code duplicated, block: B:124:0x046f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0475  */
    /* JADX WARN: Code duplicated, block: B:129:0x0488  */
    /* JADX WARN: Code duplicated, block: B:131:0x048f  */
    /* JADX WARN: Code duplicated, block: B:136:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:140:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:151:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:153:0x04db  */
    /* JADX WARN: Code duplicated, block: B:155:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:160:0x0510 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:161:0x0511  */
    /* JADX WARN: Code duplicated, block: B:164:0x0539 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:165:0x053a  */
    /* JADX WARN: Code duplicated, block: B:173:0x0559  */
    /* JADX WARN: Code duplicated, block: B:175:0x055e  */
    /* JADX WARN: Code duplicated, block: B:177:0x0564  */
    /* JADX WARN: Code duplicated, block: B:184:0x0586  */
    /* JADX WARN: Code duplicated, block: B:185:0x0589  */
    /* JADX WARN: Code duplicated, block: B:188:0x05b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:189:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:192:0x05d1 A[Catch: all -> 0x060c, TRY_LEAVE, TryCatch #7 {all -> 0x060c, blocks: (B:190:0x05c3, B:192:0x05d1), top: B:270:0x05c3 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x05f7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:195:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:202:0x062a A[Catch: all -> 0x0096, TryCatch #4 {all -> 0x0096, blocks: (B:196:0x0602, B:200:0x0613, B:202:0x062a, B:204:0x0636, B:206:0x063e, B:208:0x064b, B:207:0x0645, B:209:0x064e, B:213:0x067f, B:14:0x0087, B:19:0x00c2), top: B:265:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x063e A[Catch: all -> 0x0096, TryCatch #4 {all -> 0x0096, blocks: (B:196:0x0602, B:200:0x0613, B:202:0x062a, B:204:0x0636, B:206:0x063e, B:208:0x064b, B:207:0x0645, B:209:0x064e, B:213:0x067f, B:14:0x0087, B:19:0x00c2), top: B:265:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0645 A[Catch: all -> 0x0096, TryCatch #4 {all -> 0x0096, blocks: (B:196:0x0602, B:200:0x0613, B:202:0x062a, B:204:0x0636, B:206:0x063e, B:208:0x064b, B:207:0x0645, B:209:0x064e, B:213:0x067f, B:14:0x0087, B:19:0x00c2), top: B:265:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x0678 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:212:0x0679  */
    /* JADX WARN: Code duplicated, block: B:216:0x0689  */
    /* JADX WARN: Code duplicated, block: B:219:0x0694  */
    /* JADX WARN: Code duplicated, block: B:222:0x0699  */
    /* JADX WARN: Code duplicated, block: B:225:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:228:0x06a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:244:0x0708  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:87:0x035d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0367  */
    /* JADX WARN: Code duplicated, block: B:94:0x03b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:98:0x03c6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v50, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v52, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r14v10, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v19, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r3v35, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [GC] */
    /* JADX WARN: Type inference failed for: r6v37, types: [GC] */
    /* JADX WARN: Type inference failed for: r6v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v62 */
    /* JADX WARN: Type inference failed for: r6v63 */
    /* JADX WARN: Type inference failed for: r6v64 */
    /* JADX WARN: Type inference failed for: r6v65 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v43, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r9v54, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v58, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v61 */
    /* JADX WARN: Type inference failed for: r9v66 */
    /* JADX WARN: Type inference failed for: r9v67 */
    /* JADX WARN: Type inference failed for: r9v68 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:233:0x06d4 -> B:263:0x06d9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object doLoad(androidx.paging.LoadType r19, androidx.paging.GenerationalViewportHint r20, defpackage.InterfaceC0793Of r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.doLoad(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, Of):java.lang.Object");
    }

    private final PagingSource.LoadParams<Key> loadParams(LoadType loadType, Key key) {
        return PagingSource.LoadParams.Companion.create(loadType, key, loadType == LoadType.REFRESH ? this.config.initialLoadSize : this.config.pageSize, this.config.enablePlaceholders);
    }

    private final String loadResultLog(LoadType loadType, Key key, PagingSource.LoadResult<Key, Value> loadResult) {
        if (loadResult == null) {
            return "End " + loadType + " with loadkey " + key + ". Load CANCELLED.";
        }
        return "End " + loadType + " with loadKey " + key + ". Returned " + loadResult;
    }

    private final Key nextLoadKeyOrNull(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, int i, int i2) {
        if (i == pageFetcherSnapshotState.generationId$paging_common(loadType) && !(pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(loadType) instanceof LoadState.Error) && i2 < this.config.prefetchDistance) {
            return loadType == LoadType.PREPEND ? (Key) ((PagingSource.LoadResult.Page) AbstractC3240kc.b0(pageFetcherSnapshotState.getPages$paging_common())).getPrevKey() : (Key) ((PagingSource.LoadResult.Page) AbstractC3240kc.k0(pageFetcherSnapshotState.getPages$paging_common())).getNextKey();
        }
        return null;
    }

    private final void onInvalidLoad() {
        close();
        this.pagingSource.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object retryLoadError(LoadType loadType, ViewportHint viewportHint, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
            Object objDoInitialLoad = doInitialLoad(interfaceC0793Of);
            return objDoInitialLoad == AbstractC0378Bt.d() ? objDoInitialLoad : FW.a;
        }
        if (viewportHint == null) {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint");
        }
        this.hintHandler.forceSetHint(loadType, viewportHint);
        return FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setError(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, LoadState.Error error, InterfaceC0793Of interfaceC0793Of) {
        if (AbstractC4492zt.d(pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(loadType), error)) {
            return FW.a;
        }
        pageFetcherSnapshotState.getSourceLoadStates$paging_common().set(loadType, error);
        Object objSend = this.pageEventCh.send(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.getSourceLoadStates$paging_common().snapshot(), null), interfaceC0793Of);
        return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setLoading(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, InterfaceC0793Of interfaceC0793Of) {
        LoadState loadState = pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(loadType);
        LoadState.Loading loading = LoadState.Loading.INSTANCE;
        if (AbstractC4492zt.d(loadState, loading)) {
            return FW.a;
        }
        pageFetcherSnapshotState.getSourceLoadStates$paging_common().set(loadType, loading);
        Object objSend = this.pageEventCh.send(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.getSourceLoadStates$paging_common().snapshot(), null), interfaceC0793Of);
        return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConsumingHints(InterfaceC2052dg interfaceC2052dg) {
        if (this.config.jumpThreshold != Integer.MIN_VALUE) {
            O8.d(interfaceC2052dg, null, null, new C17051(this, null), 3, null);
        }
        O8.d(interfaceC2052dg, null, null, new AnonymousClass2(this, null), 3, null);
        O8.d(interfaceC2052dg, null, null, new C17063(this, null), 3, null);
    }

    public final void accessHint(ViewportHint viewportHint) {
        AbstractC4492zt.h(viewportHint, "viewportHint");
        this.hintHandler.processHint(viewportHint);
    }

    public final void close() {
        InterfaceC1830bu.a.a(this.pageEventChannelFlowJob, null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object currentPagingState(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17021 c17021;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        GC gc;
        if (interfaceC0793Of instanceof C17021) {
            c17021 = (C17021) interfaceC0793Of;
            int i = c17021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17021.label = i - Integer.MIN_VALUE;
            } else {
                c17021 = new C17021(this, interfaceC0793Of);
            }
        } else {
            c17021 = new C17021(this, interfaceC0793Of);
        }
        Object obj = c17021.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c17021.label;
        if (i2 == 0) {
            LL.b(obj);
            holder = this.stateHolder;
            GC gc2 = ((PageFetcherSnapshotState.Holder) holder).lock;
            c17021.L$0 = this;
            c17021.L$1 = holder;
            c17021.L$2 = gc2;
            c17021.label = 1;
            if (gc2.c(null, c17021) == objD) {
                return objD;
            }
            pageFetcherSnapshot = this;
            gc = gc2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gc = (GC) c17021.L$2;
            holder = (PageFetcherSnapshotState.Holder) c17021.L$1;
            pageFetcherSnapshot = (PageFetcherSnapshot) c17021.L$0;
            LL.b(obj);
        }
        try {
            return ((PageFetcherSnapshotState.Holder) holder).state.currentPagingState$paging_common(pageFetcherSnapshot.hintHandler.getLastAccessHint());
        } finally {
            gc.b(null);
        }
    }

    public final Key getInitialKey$paging_common() {
        return this.initialKey;
    }

    public final InterfaceC0939Tm getPageEventFlow() {
        return this.pageEventFlow;
    }

    public final PagingSource<Key, Value> getPagingSource$paging_common() {
        return this.pagingSource;
    }

    public final RemoteMediatorConnection<Key, Value> getRemoteMediatorConnection() {
        return this.remoteMediatorConnection;
    }

    public /* synthetic */ PageFetcherSnapshot(Object obj, PagingSource pagingSource, PagingConfig pagingConfig, InterfaceC0939Tm interfaceC0939Tm, RemoteMediatorConnection remoteMediatorConnection, PagingState pagingState, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, pagingSource, pagingConfig, interfaceC0939Tm, (i & 16) != 0 ? null : remoteMediatorConnection, (i & 32) != 0 ? null : pagingState, (i & 64) != 0 ? AnonymousClass1.INSTANCE : interfaceC3588op);
    }
}
