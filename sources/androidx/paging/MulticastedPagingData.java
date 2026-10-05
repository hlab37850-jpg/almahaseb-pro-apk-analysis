package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
final class MulticastedPagingData<T> {
    private final CachedPageEventFlow<T> accumulated;
    private final PagingData<T> parent;
    private final InterfaceC2052dg scope;
    private final ActiveFlowTracker tracker;

    /* JADX INFO: renamed from: androidx.paging.MulticastedPagingData$asPagingData$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.MulticastedPagingData$asPagingData$1", f = "CachedPagingData.kt", l = {51}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ MulticastedPagingData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MulticastedPagingData<T> multicastedPagingData, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = multicastedPagingData;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ActiveFlowTracker tracker = this.this$0.getTracker();
                if (tracker != null) {
                    ActiveFlowTracker.FlowType flowType = ActiveFlowTracker.FlowType.PAGE_EVENT_FLOW;
                    this.label = 1;
                    if (tracker.onStart(flowType, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.MulticastedPagingData$asPagingData$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.MulticastedPagingData$asPagingData$2", f = "CachedPagingData.kt", l = {53}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        int label;
        final /* synthetic */ MulticastedPagingData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MulticastedPagingData<T> multicastedPagingData, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.this$0 = multicastedPagingData;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, Throwable th, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, interfaceC0793Of).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ActiveFlowTracker tracker = this.this$0.getTracker();
                if (tracker != null) {
                    ActiveFlowTracker.FlowType flowType = ActiveFlowTracker.FlowType.PAGE_EVENT_FLOW;
                    this.label = 1;
                    if (tracker.onComplete(flowType, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.MulticastedPagingData$asPagingData$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ MulticastedPagingData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(MulticastedPagingData<T> multicastedPagingData) {
            super(0);
            this.this$0 = multicastedPagingData;
        }

        @Override // defpackage.InterfaceC3588op
        public final PageEvent.Insert<T> invoke() {
            return ((MulticastedPagingData) this.this$0).accumulated.getCachedEvent$paging_common();
        }
    }

    public MulticastedPagingData(InterfaceC2052dg interfaceC2052dg, PagingData<T> pagingData, ActiveFlowTracker activeFlowTracker) {
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC4492zt.h(pagingData, "parent");
        this.scope = interfaceC2052dg;
        this.parent = pagingData;
        this.tracker = activeFlowTracker;
        CachedPageEventFlow<T> cachedPageEventFlow = new CachedPageEventFlow<>(pagingData.getFlow$paging_common(), interfaceC2052dg);
        if (activeFlowTracker != null) {
            activeFlowTracker.onNewCachedEventFlow(cachedPageEventFlow);
        }
        this.accumulated = cachedPageEventFlow;
    }

    public final PagingData<T> asPagingData() {
        return new PagingData<>(AbstractC1047Xm.z(AbstractC1047Xm.B(this.accumulated.getDownstreamFlow(), new AnonymousClass1(this, null)), new AnonymousClass2(this, null)), this.parent.getUiReceiver$paging_common(), this.parent.getHintReceiver$paging_common(), new AnonymousClass3(this));
    }

    public final Object close(InterfaceC0793Of interfaceC0793Of) {
        this.accumulated.close();
        return FW.a;
    }

    public final PagingData<T> getParent() {
        return this.parent;
    }

    public final InterfaceC2052dg getScope() {
        return this.scope;
    }

    public final ActiveFlowTracker getTracker() {
        return this.tracker;
    }

    public /* synthetic */ MulticastedPagingData(InterfaceC2052dg interfaceC2052dg, PagingData pagingData, ActiveFlowTracker activeFlowTracker, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC2052dg, pagingData, (i & 4) != 0 ? null : activeFlowTracker);
    }
}
