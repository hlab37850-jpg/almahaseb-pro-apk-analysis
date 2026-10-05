package androidx.paging;

import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncPagingDataDiffer<T> {
    private static final Companion Companion = new Companion(null);
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final AsyncPagingDataDiffer$differBase$1 differBase;
    private final DifferCallback differCallback;
    private boolean inGetItem;
    private final InterfaceC0939Tm loadStateFlow;
    private final InterfaceC0988Vf mainDispatcher;
    private final InterfaceC0939Tm onPagesUpdatedFlow;
    private final AtomicInteger submitDataId;
    private final ListUpdateCallback updateCallback;
    private final InterfaceC0988Vf workerDispatcher;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.paging.AsyncPagingDataDiffer$submitData$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.AsyncPagingDataDiffer$submitData$2", f = "AsyncPagingDataDiffer.kt", l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ int $id;
        final /* synthetic */ PagingData<T> $pagingData;
        int label;
        final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AsyncPagingDataDiffer<T> asyncPagingDataDiffer, int i, PagingData<T> pagingData, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = asyncPagingDataDiffer;
            this.$id = i;
            this.$pagingData = pagingData;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, this.$id, this.$pagingData, interfaceC0793Of);
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
                if (((AsyncPagingDataDiffer) this.this$0).submitDataId.get() == this.$id) {
                    AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = ((AsyncPagingDataDiffer) this.this$0).differBase;
                    PagingData<T> pagingData = this.$pagingData;
                    this.label = 1;
                    if (asyncPagingDataDiffer$differBase$1.collectFrom(pagingData, this) == objD) {
                        return objD;
                    }
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

    static {
        Logger logger = LoggerKt.getLOGGER();
        if (logger == null) {
            logger = new Logger() { // from class: androidx.paging.AsyncPagingDataDiffer.Companion.1
                @Override // androidx.paging.Logger
                public boolean isLoggable(int i) {
                    return Log.isLoggable(LoggerKt.LOG_TAG, i);
                }

                @Override // androidx.paging.Logger
                public void log(int i, String str, Throwable th) {
                    AbstractC4492zt.h(str, "message");
                    if (i == 2) {
                        Log.v(LoggerKt.LOG_TAG, str, th);
                        return;
                    }
                    if (i == 3) {
                        Log.d(LoggerKt.LOG_TAG, str, th);
                        return;
                    }
                    throw new IllegalArgumentException("debug level " + i + " is requested but Paging only supports default logging for level 2 (DEBUG) or level 3 (VERBOSE)");
                }
            };
        }
        LoggerKt.setLOGGER(logger);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> itemCallback, ListUpdateCallback listUpdateCallback) {
        this(itemCallback, listUpdateCallback, (InterfaceC0988Vf) null, (InterfaceC0988Vf) null, 12, (AbstractC0419Di) null);
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(listUpdateCallback, "updateCallback");
    }

    public static /* synthetic */ void getDifferCallback$paging_runtime_release$annotations() {
    }

    public static /* synthetic */ void getInGetItem$paging_runtime_release$annotations() {
    }

    public final void addLoadStateListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differBase.addLoadStateListener(interfaceC3750qp);
    }

    public final void addOnPagesUpdatedListener(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differBase.addOnPagesUpdatedListener(interfaceC3588op);
    }

    public final DifferCallback getDifferCallback$paging_runtime_release() {
        return this.differCallback;
    }

    public final boolean getInGetItem$paging_runtime_release() {
        return this.inGetItem;
    }

    @MainThread
    public final T getItem(@IntRange(from = 0) int i) {
        try {
            this.inGetItem = true;
            return this.differBase.get(i);
        } finally {
            this.inGetItem = false;
        }
    }

    public final int getItemCount() {
        return this.differBase.getSize();
    }

    public final InterfaceC0939Tm getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final InterfaceC0939Tm getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    @MainThread
    public final T peek(@IntRange(from = 0) int i) {
        return this.differBase.peek(i);
    }

    public final void refresh() {
        this.differBase.refresh();
    }

    public final void removeLoadStateListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differBase.removeLoadStateListener(interfaceC3750qp);
    }

    public final void removeOnPagesUpdatedListener(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differBase.removeOnPagesUpdatedListener(interfaceC3588op);
    }

    public final void retry() {
        this.differBase.retry();
    }

    public final void setInGetItem$paging_runtime_release(boolean z) {
        this.inGetItem = z;
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differBase.snapshot();
    }

    public final Object submitData(PagingData<T> pagingData, InterfaceC0793Of interfaceC0793Of) {
        this.submitDataId.incrementAndGet();
        Object objCollectFrom = this.differBase.collectFrom(pagingData, interfaceC0793Of);
        return objCollectFrom == AbstractC0378Bt.d() ? objCollectFrom : FW.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> itemCallback, ListUpdateCallback listUpdateCallback, InterfaceC0988Vf interfaceC0988Vf) {
        this(itemCallback, listUpdateCallback, interfaceC0988Vf, (InterfaceC0988Vf) null, 8, (AbstractC0419Di) null);
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(listUpdateCallback, "updateCallback");
        AbstractC4492zt.h(interfaceC0988Vf, "mainDispatcher");
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> itemCallback, ListUpdateCallback listUpdateCallback, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2) {
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(listUpdateCallback, "updateCallback");
        AbstractC4492zt.h(interfaceC0988Vf, "mainDispatcher");
        AbstractC4492zt.h(interfaceC0988Vf2, "workerDispatcher");
        this.diffCallback = itemCallback;
        this.updateCallback = listUpdateCallback;
        this.mainDispatcher = interfaceC0988Vf;
        this.workerDispatcher = interfaceC0988Vf2;
        DifferCallback differCallback = new DifferCallback(this) { // from class: androidx.paging.AsyncPagingDataDiffer$differCallback$1
            final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.DifferCallback
            public void onChanged(int i, int i2) {
                if (i2 > 0) {
                    ((AsyncPagingDataDiffer) this.this$0).updateCallback.onChanged(i, i2, null);
                }
            }

            @Override // androidx.paging.DifferCallback
            public void onInserted(int i, int i2) {
                if (i2 > 0) {
                    ((AsyncPagingDataDiffer) this.this$0).updateCallback.onInserted(i, i2);
                }
            }

            @Override // androidx.paging.DifferCallback
            public void onRemoved(int i, int i2) {
                if (i2 > 0) {
                    ((AsyncPagingDataDiffer) this.this$0).updateCallback.onRemoved(i, i2);
                }
            }
        };
        this.differCallback = differCallback;
        AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = new AsyncPagingDataDiffer$differBase$1(this, differCallback, interfaceC0988Vf);
        this.differBase = asyncPagingDataDiffer$differBase$1;
        this.submitDataId = new AtomicInteger(0);
        this.loadStateFlow = AbstractC1047Xm.p(asyncPagingDataDiffer$differBase$1.getLoadStateFlow());
        this.onPagesUpdatedFlow = asyncPagingDataDiffer$differBase$1.getOnPagesUpdatedFlow();
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        AbstractC4492zt.h(lifecycle, "lifecycle");
        AbstractC4492zt.h(pagingData, "pagingData");
        O8.d(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AnonymousClass2(this, this.submitDataId.incrementAndGet(), pagingData, null), 3, null);
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2, int i, AbstractC0419Di abstractC0419Di) {
        this(itemCallback, listUpdateCallback, (i & 4) != 0 ? C0368Bj.c() : interfaceC0988Vf, (i & 8) != 0 ? C0368Bj.a() : interfaceC0988Vf2);
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, AbstractC1040Xf abstractC1040Xf, int i, AbstractC0419Di abstractC0419Di) {
        this(itemCallback, listUpdateCallback, (i & 4) != 0 ? C0368Bj.c() : abstractC1040Xf);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, AbstractC1040Xf abstractC1040Xf) {
        this(itemCallback, listUpdateCallback, (InterfaceC0988Vf) abstractC1040Xf, (InterfaceC0988Vf) C0368Bj.a());
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(listUpdateCallback, "updateCallback");
        AbstractC4492zt.h(abstractC1040Xf, "mainDispatcher");
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2, int i, AbstractC0419Di abstractC0419Di) {
        this(itemCallback, listUpdateCallback, (i & 4) != 0 ? C0368Bj.c() : abstractC1040Xf, (i & 8) != 0 ? C0368Bj.a() : abstractC1040Xf2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2) {
        this(itemCallback, listUpdateCallback, (InterfaceC0988Vf) abstractC1040Xf, (InterfaceC0988Vf) abstractC1040Xf2);
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(listUpdateCallback, "updateCallback");
        AbstractC4492zt.h(abstractC1040Xf, "mainDispatcher");
        AbstractC4492zt.h(abstractC1040Xf2, "workerDispatcher");
    }
}
