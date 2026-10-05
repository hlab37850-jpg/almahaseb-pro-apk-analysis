package androidx.paging;

import androidx.annotation.CheckResult;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC2110eP;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
public final class CachedPagingDataKt {

    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.CachedPagingDataKt$cachedIn$2", f = "CachedPagingData.kt", l = {104}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(MulticastedPagingData<T> multicastedPagingData, MulticastedPagingData<T> multicastedPagingData2, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC0793Of);
            anonymousClass2.L$0 = multicastedPagingData;
            anonymousClass2.L$1 = multicastedPagingData2;
            return anonymousClass2.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MulticastedPagingData multicastedPagingData = (MulticastedPagingData) this.L$0;
                LL.b(obj);
                return multicastedPagingData;
            }
            LL.b(obj);
            MulticastedPagingData multicastedPagingData2 = (MulticastedPagingData) this.L$0;
            MulticastedPagingData multicastedPagingData3 = (MulticastedPagingData) this.L$1;
            this.L$0 = multicastedPagingData3;
            this.label = 1;
            return multicastedPagingData2.close(this) == objD ? objD : multicastedPagingData3;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$4, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.CachedPagingDataKt$cachedIn$4", f = "CachedPagingData.kt", l = {109}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ ActiveFlowTracker $tracker;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ActiveFlowTracker activeFlowTracker, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$tracker = activeFlowTracker;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass4(this.$tracker, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass4) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ActiveFlowTracker activeFlowTracker = this.$tracker;
                if (activeFlowTracker != null) {
                    ActiveFlowTracker.FlowType flowType = ActiveFlowTracker.FlowType.PAGED_DATA_FLOW;
                    this.label = 1;
                    if (activeFlowTracker.onStart(flowType, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$5, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.CachedPagingDataKt$cachedIn$5", f = "CachedPagingData.kt", l = {111}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ ActiveFlowTracker $tracker;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(ActiveFlowTracker activeFlowTracker, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$tracker = activeFlowTracker;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, Throwable th, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass5(this.$tracker, interfaceC0793Of).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ActiveFlowTracker activeFlowTracker = this.$tracker;
                if (activeFlowTracker != null) {
                    ActiveFlowTracker.FlowType flowType = ActiveFlowTracker.FlowType.PAGED_DATA_FLOW;
                    this.label = 1;
                    if (activeFlowTracker.onComplete(flowType, this) == objD) {
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

    @CheckResult
    public static final <T> InterfaceC0939Tm cachedIn(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        return cachedIn(interfaceC0939Tm, interfaceC2052dg, null);
    }

    public static /* synthetic */ InterfaceC0939Tm cachedIn$default(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg, ActiveFlowTracker activeFlowTracker, int i, Object obj) {
        if ((i & 2) != 0) {
            activeFlowTracker = null;
        }
        return cachedIn(interfaceC0939Tm, interfaceC2052dg, activeFlowTracker);
    }

    public static final <T> InterfaceC0939Tm cachedIn(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg, ActiveFlowTracker activeFlowTracker) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        final InterfaceC0939Tm interfaceC0939TmSimpleRunningReduce = FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(interfaceC0939Tm, new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(null, interfaceC2052dg, activeFlowTracker)), new AnonymousClass2(null));
        return AbstractC1047Xm.D(AbstractC1047Xm.z(AbstractC1047Xm.B(new InterfaceC0939Tm() { // from class: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1

            /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2", f = "CachedPagingData.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC0819Pf {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
                        super(interfaceC0793Of);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // defpackage.InterfaceC0995Vm
                public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    if (interfaceC0793Of instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objD = AbstractC0378Bt.d();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        LL.b(obj2);
                        InterfaceC0995Vm interfaceC0995Vm = this.$this_unsafeFlow;
                        PagingData<T> pagingDataAsPagingData = ((MulticastedPagingData) obj).asPagingData();
                        anonymousClass1.label = 1;
                        if (interfaceC0995Vm.emit(pagingDataAsPagingData, anonymousClass1) == objD) {
                            return objD;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj2);
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = interfaceC0939TmSimpleRunningReduce.collect(new AnonymousClass2(interfaceC0995Vm), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, new AnonymousClass4(activeFlowTracker, null)), new AnonymousClass5(activeFlowTracker, null)), interfaceC2052dg, InterfaceC2110eP.a.d(), 1);
    }
}
