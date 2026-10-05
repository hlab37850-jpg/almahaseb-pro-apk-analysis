package androidx.paging;

import androidx.annotation.RestrictTo;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3511nu;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1243ae;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.O8;
import defpackage.OJ;
import defpackage.XS;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class FlowExtKt {
    private static final Object NULL = new Object();

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2", f = "FlowExt.kt", l = {ShapeTypes.ACTION_BUTTON_HOME}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0939Tm $otherFlow;
        final /* synthetic */ InterfaceC0939Tm $this_combineWithoutBatching;
        final /* synthetic */ InterfaceC0578Hp $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01482 extends AbstractC2233fv implements InterfaceC3588op {
            final /* synthetic */ InterfaceC1243ae $parentJob;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01482(InterfaceC1243ae interfaceC1243ae) {
                super(0);
                this.$parentJob = interfaceC1243ae;
            }

            @Override // defpackage.InterfaceC3588op
            public /* bridge */ /* synthetic */ Object invoke() {
                m5428invoke();
                return FW.a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m5428invoke() {
                InterfaceC1830bu.a.a(this.$parentJob, null, 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0939Tm interfaceC0939Tm2, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_combineWithoutBatching = interfaceC0939Tm;
            this.$otherFlow = interfaceC0939Tm2;
            this.$transform = interfaceC0578Hp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_combineWithoutBatching, this.$otherFlow, this.$transform, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(SimpleProducerScope<R> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
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
                UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.$transform, null));
                InterfaceC1243ae interfaceC1243aeB = AbstractC3511nu.b(null, 1, null);
                InterfaceC0939Tm[] interfaceC0939TmArr = {this.$this_combineWithoutBatching, this.$otherFlow};
                int i3 = 0;
                while (i < 2) {
                    O8.d(simpleProducerScope, interfaceC1243aeB, null, new FlowExtKt$combineWithoutBatching$2$1$1(interfaceC0939TmArr[i], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i3, null), 2, null);
                    i++;
                    i3++;
                    interfaceC0939TmArr = interfaceC0939TmArr;
                }
                C01482 c01482 = new C01482(interfaceC1243aeB);
                this.label = 1;
                if (simpleProducerScope.awaitClose(c01482, this) == objD) {
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

        public final Object invokeSuspend$$forInline(Object obj) {
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.$transform, null));
            InterfaceC1243ae interfaceC1243aeB = AbstractC3511nu.b(null, 1, null);
            InterfaceC0939Tm[] interfaceC0939TmArr = {this.$this_combineWithoutBatching, this.$otherFlow};
            int i = 0;
            int i2 = 0;
            while (i2 < 2) {
                int i3 = i + 1;
                O8.d(simpleProducerScope, interfaceC1243aeB, null, new FlowExtKt$combineWithoutBatching$2$1$1(interfaceC0939TmArr[i2], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, Integer.valueOf(i).intValue(), null), 2, null);
                FW fw = FW.a;
                i2++;
                i = i3;
            }
            C01482 c01482 = new C01482(interfaceC1243aeB);
            AbstractC0703Ks.c(0);
            simpleProducerScope.awaitClose(c01482, this);
            AbstractC0703Ks.c(1);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleFlatMapLatest$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$simpleFlatMapLatest$1", f = "FlowExt.kt", l = {99, 99}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC0526Fp $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$transform = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, T t, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, interfaceC0793Of);
            anonymousClass1.L$0 = interfaceC0995Vm;
            anonymousClass1.L$1 = t;
            return anonymousClass1.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC0995Vm interfaceC0995Vm;
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
            Object obj2 = this.L$1;
            InterfaceC0526Fp interfaceC0526Fp = this.$transform;
            this.L$0 = interfaceC0995Vm;
            this.label = 1;
            obj = interfaceC0526Fp.mo13invoke(obj2, this);
            if (obj == objD) {
                return objD;
            }
            this.L$0 = null;
            this.label = 2;
            if (AbstractC1047Xm.m(interfaceC0995Vm, (InterfaceC0939Tm) obj, this) == objD) {
                return objD;
            }
            return FW.a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            InterfaceC0995Vm interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
            InterfaceC0939Tm interfaceC0939Tm = (InterfaceC0939Tm) this.$transform.mo13invoke(this.L$1, this);
            AbstractC0703Ks.c(0);
            AbstractC1047Xm.m(interfaceC0995Vm, interfaceC0939Tm, this);
            AbstractC0703Ks.c(1);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleMapLatest$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$simpleMapLatest$1", f = "FlowExt.kt", l = {106, 106}, m = "invokeSuspend")
    public static final class C16961 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC0526Fp $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16961(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$transform = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, T t, InterfaceC0793Of interfaceC0793Of) {
            C16961 c16961 = new C16961(this.$transform, interfaceC0793Of);
            c16961.L$0 = interfaceC0995Vm;
            c16961.L$1 = t;
            return c16961.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC0995Vm interfaceC0995Vm;
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
            Object obj2 = this.L$1;
            InterfaceC0526Fp interfaceC0526Fp = this.$transform;
            this.L$0 = interfaceC0995Vm;
            this.label = 1;
            obj = interfaceC0526Fp.mo13invoke(obj2, this);
            if (obj == objD) {
                return objD;
            }
            this.L$0 = null;
            this.label = 2;
            if (interfaceC0995Vm.emit(obj, this) == objD) {
                return objD;
            }
            return FW.a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            InterfaceC0995Vm interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
            Object objMo13invoke = this.$transform.mo13invoke(this.L$1, this);
            AbstractC0703Ks.c(0);
            interfaceC0995Vm.emit(objMo13invoke, this);
            AbstractC0703Ks.c(1);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", l = {69}, m = "invokeSuspend")
    public static final class C16971 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0552Gp $operation;
        final /* synthetic */ InterfaceC0939Tm $this_simpleRunningReduce;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01491<T> implements InterfaceC0995Vm {
            final /* synthetic */ InterfaceC0995Vm $$this$flow;
            final /* synthetic */ OJ $accumulator;
            final /* synthetic */ InterfaceC0552Gp $operation;

            public C01491(OJ oj, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0995Vm interfaceC0995Vm) {
                this.$accumulator = oj;
                this.$operation = interfaceC0552Gp;
                this.$$this$flow = interfaceC0995Vm;
            }

            /* JADX WARN: Code duplicated, block: B:26:0x007e A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(T t, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                FlowExtKt$simpleRunningReduce$1$1$emit$1 flowExtKt$simpleRunningReduce$1$1$emit$1;
                OJ oj;
                C01491<T> c01491;
                OJ oj2;
                InterfaceC0995Vm interfaceC0995Vm;
                Object obj;
                if (interfaceC0793Of instanceof FlowExtKt$simpleRunningReduce$1$1$emit$1) {
                    flowExtKt$simpleRunningReduce$1$1$emit$1 = (FlowExtKt$simpleRunningReduce$1$1$emit$1) interfaceC0793Of;
                    int i = flowExtKt$simpleRunningReduce$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        flowExtKt$simpleRunningReduce$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        flowExtKt$simpleRunningReduce$1$1$emit$1 = new FlowExtKt$simpleRunningReduce$1$1$emit$1(this, interfaceC0793Of);
                    }
                } else {
                    flowExtKt$simpleRunningReduce$1$1$emit$1 = new FlowExtKt$simpleRunningReduce$1$1$emit$1(this, interfaceC0793Of);
                }
                Object obj2 = flowExtKt$simpleRunningReduce$1$1$emit$1.result;
                Object objD = AbstractC0378Bt.d();
                int i2 = flowExtKt$simpleRunningReduce$1$1$emit$1.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        oj2 = (OJ) flowExtKt$simpleRunningReduce$1$1$emit$1.L$1;
                        c01491 = (C01491) flowExtKt$simpleRunningReduce$1$1$emit$1.L$0;
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
                oj = this.$accumulator;
                if (oj.a == FlowExtKt.NULL) {
                    c01491 = this;
                } else {
                    InterfaceC0552Gp interfaceC0552Gp = this.$operation;
                    Object obj3 = this.$accumulator.a;
                    flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = this;
                    flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = oj;
                    flowExtKt$simpleRunningReduce$1$1$emit$1.label = 1;
                    Object objInvoke = interfaceC0552Gp.invoke(obj3, t, flowExtKt$simpleRunningReduce$1$1$emit$1);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    c01491 = this;
                    obj2 = objInvoke;
                    oj2 = oj;
                }
                oj.a = t;
                interfaceC0995Vm = c01491.$$this$flow;
                obj = c01491.$accumulator.a;
                flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = null;
                flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = null;
                flowExtKt$simpleRunningReduce$1$1$emit$1.label = 2;
                if (interfaceC0995Vm.emit(obj, flowExtKt$simpleRunningReduce$1$1$emit$1) == objD) {
                    return objD;
                }
                return FW.a;
                Object obj4 = obj2;
                oj = oj2;
                t = (T) obj4;
                oj.a = t;
                interfaceC0995Vm = c01491.$$this$flow;
                obj = c01491.$accumulator.a;
                flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = null;
                flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = null;
                flowExtKt$simpleRunningReduce$1$1$emit$1.label = 2;
                if (interfaceC0995Vm.emit(obj, flowExtKt$simpleRunningReduce$1$1$emit$1) == objD) {
                    return objD;
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16971(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_simpleRunningReduce = interfaceC0939Tm;
            this.$operation = interfaceC0552Gp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16971 c16971 = new C16971(this.$this_simpleRunningReduce, this.$operation, interfaceC0793Of);
            c16971.L$0 = obj;
            return c16971;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((C16971) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC0995Vm interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
                OJ oj = new OJ();
                oj.a = FlowExtKt.NULL;
                InterfaceC0939Tm interfaceC0939Tm = this.$this_simpleRunningReduce;
                C01491 c01491 = new C01491(oj, this.$operation, interfaceC0995Vm);
                this.label = 1;
                if (interfaceC0939Tm.collect(c01491, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleScan$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", l = {55, 56}, m = "invokeSuspend")
    public static final class C16981 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ R $initial;
        final /* synthetic */ InterfaceC0552Gp $operation;
        final /* synthetic */ InterfaceC0939Tm $this_simpleScan;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleScan$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01501<T> implements InterfaceC0995Vm {
            final /* synthetic */ InterfaceC0995Vm $$this$flow;
            final /* synthetic */ OJ $accumulator;
            final /* synthetic */ InterfaceC0552Gp $operation;

            public C01501(OJ oj, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0995Vm interfaceC0995Vm) {
                this.$accumulator = oj;
                this.$operation = interfaceC0552Gp;
                this.$$this$flow = interfaceC0995Vm;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(T t, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                FlowExtKt$simpleScan$1$1$emit$1 flowExtKt$simpleScan$1$1$emit$1;
                C01501<T> c01501;
                OJ oj;
                if (interfaceC0793Of instanceof FlowExtKt$simpleScan$1$1$emit$1) {
                    flowExtKt$simpleScan$1$1$emit$1 = (FlowExtKt$simpleScan$1$1$emit$1) interfaceC0793Of;
                    int i = flowExtKt$simpleScan$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        flowExtKt$simpleScan$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        flowExtKt$simpleScan$1$1$emit$1 = new FlowExtKt$simpleScan$1$1$emit$1(this, interfaceC0793Of);
                    }
                } else {
                    flowExtKt$simpleScan$1$1$emit$1 = new FlowExtKt$simpleScan$1$1$emit$1(this, interfaceC0793Of);
                }
                Object obj = flowExtKt$simpleScan$1$1$emit$1.result;
                Object objD = AbstractC0378Bt.d();
                int i2 = flowExtKt$simpleScan$1$1$emit$1.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        oj = (OJ) flowExtKt$simpleScan$1$1$emit$1.L$1;
                        c01501 = (C01501) flowExtKt$simpleScan$1$1$emit$1.L$0;
                        LL.b(obj);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    return FW.a;
                }
                LL.b(obj);
                OJ oj2 = this.$accumulator;
                InterfaceC0552Gp interfaceC0552Gp = this.$operation;
                Object obj2 = oj2.a;
                flowExtKt$simpleScan$1$1$emit$1.L$0 = this;
                flowExtKt$simpleScan$1$1$emit$1.L$1 = oj2;
                flowExtKt$simpleScan$1$1$emit$1.label = 1;
                Object objInvoke = interfaceC0552Gp.invoke(obj2, t, flowExtKt$simpleScan$1$1$emit$1);
                if (objInvoke == objD) {
                    return objD;
                }
                c01501 = this;
                obj = objInvoke;
                oj = oj2;
                oj.a = obj;
                InterfaceC0995Vm interfaceC0995Vm = c01501.$$this$flow;
                Object obj3 = c01501.$accumulator.a;
                flowExtKt$simpleScan$1$1$emit$1.L$0 = null;
                flowExtKt$simpleScan$1$1$emit$1.L$1 = null;
                flowExtKt$simpleScan$1$1$emit$1.label = 2;
                if (interfaceC0995Vm.emit(obj3, flowExtKt$simpleScan$1$1$emit$1) == objD) {
                    return objD;
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16981(R r, InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$initial = r;
            this.$this_simpleScan = interfaceC0939Tm;
            this.$operation = interfaceC0552Gp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16981 c16981 = new C16981(this.$initial, this.$this_simpleScan, this.$operation, interfaceC0793Of);
            c16981.L$0 = obj;
            return c16981;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((C16981) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            OJ oj;
            InterfaceC0995Vm interfaceC0995Vm;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    oj = (OJ) this.L$1;
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
            InterfaceC0995Vm interfaceC0995Vm2 = (InterfaceC0995Vm) this.L$0;
            oj = new OJ();
            Object obj2 = this.$initial;
            oj.a = obj2;
            this.L$0 = interfaceC0995Vm2;
            this.L$1 = oj;
            this.label = 1;
            if (interfaceC0995Vm2.emit(obj2, this) == objD) {
                return objD;
            }
            interfaceC0995Vm = interfaceC0995Vm2;
            InterfaceC0939Tm interfaceC0939Tm = this.$this_simpleScan;
            C01501 c01501 = new C01501(oj, this.$operation, interfaceC0995Vm);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (interfaceC0939Tm.collect(c01501, this) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1", f = "FlowExt.kt", l = {89}, m = "invokeSuspend")
    public static final class C16991 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0939Tm $this_simpleTransformLatest;
        final /* synthetic */ InterfaceC0552Gp $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
        public static final class C01511 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ ChannelFlowCollector<R> $collector;
            final /* synthetic */ InterfaceC0552Gp $transform;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01511(InterfaceC0552Gp interfaceC0552Gp, ChannelFlowCollector<R> channelFlowCollector, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$transform = interfaceC0552Gp;
                this.$collector = channelFlowCollector;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C01511 c01511 = new C01511(this.$transform, this.$collector, interfaceC0793Of);
                c01511.L$0 = obj;
                return c01511;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(T t, InterfaceC0793Of interfaceC0793Of) {
                return ((C01511) create(t, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    Object obj2 = this.L$0;
                    InterfaceC0552Gp interfaceC0552Gp = this.$transform;
                    Object obj3 = this.$collector;
                    this.label = 1;
                    if (interfaceC0552Gp.invoke(obj3, obj2, this) == objD) {
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
        public C16991(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_simpleTransformLatest = interfaceC0939Tm;
            this.$transform = interfaceC0552Gp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16991 c16991 = new C16991(this.$this_simpleTransformLatest, this.$transform, interfaceC0793Of);
            c16991.L$0 = obj;
            return c16991;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(SimpleProducerScope<R> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C16991) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
                InterfaceC0939Tm interfaceC0939Tm = this.$this_simpleTransformLatest;
                C01511 c01511 = new C01511(this.$transform, new ChannelFlowCollector(simpleProducerScope), null);
                this.label = 1;
                if (AbstractC1047Xm.g(interfaceC0939Tm, c01511, this) == objD) {
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

    public static final <T1, T2, R> Object combineWithoutBatching(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0939Tm interfaceC0939Tm2, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0793Of interfaceC0793Of) {
        return SimpleChannelFlowKt.simpleChannelFlow(new AnonymousClass2(interfaceC0939Tm, interfaceC0939Tm2, interfaceC0578Hp, null));
    }

    public static final <T, R> InterfaceC0939Tm simpleFlatMapLatest(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "transform");
        return simpleTransformLatest(interfaceC0939Tm, new AnonymousClass1(interfaceC0526Fp, null));
    }

    public static final <T, R> InterfaceC0939Tm simpleMapLatest(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "transform");
        return simpleTransformLatest(interfaceC0939Tm, new C16961(interfaceC0526Fp, null));
    }

    public static final <T> InterfaceC0939Tm simpleRunningReduce(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.OPERATION);
        return AbstractC1047Xm.s(new C16971(interfaceC0939Tm, interfaceC0552Gp, null));
    }

    public static final <T, R> InterfaceC0939Tm simpleScan(InterfaceC0939Tm interfaceC0939Tm, R r, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.OPERATION);
        return AbstractC1047Xm.s(new C16981(r, interfaceC0939Tm, interfaceC0552Gp, null));
    }

    public static final <T, R> InterfaceC0939Tm simpleTransformLatest(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp, "transform");
        return SimpleChannelFlowKt.simpleChannelFlow(new C16991(interfaceC0939Tm, interfaceC0552Gp, null));
    }
}
