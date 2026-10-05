package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.XS;
import defpackage.ZZ;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", l = {148}, m = "invokeSuspend")
public final class FlowExtKt$combineWithoutBatching$2$1$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ SimpleProducerScope<R> $$this$simpleChannelFlow;
    final /* synthetic */ InterfaceC0939Tm $flow;
    final /* synthetic */ AtomicInteger $incompleteFlows;
    final /* synthetic */ int $index;
    final /* synthetic */ UnbatchedFlowCombiner<T1, T2> $unbatchedFlowCombiner;
    int label;

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements InterfaceC0995Vm {
        final /* synthetic */ int $index;
        final /* synthetic */ UnbatchedFlowCombiner<T1, T2> $unbatchedFlowCombiner;

        public AnonymousClass1(UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, int i) {
            this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
            this.$index = i;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1 flowExtKt$combineWithoutBatching$2$1$1$1$emit$1;
            if (interfaceC0793Of instanceof FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1) {
                flowExtKt$combineWithoutBatching$2$1$1$1$emit$1 = (FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1) interfaceC0793Of;
                int i = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowExtKt$combineWithoutBatching$2$1$1$1$emit$1 = new FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1(this, interfaceC0793Of);
                }
            } else {
                flowExtKt$combineWithoutBatching$2$1$1$1$emit$1 = new FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1(this, interfaceC0793Of);
            }
            Object obj2 = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label;
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
            UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner = this.$unbatchedFlowCombiner;
            int i3 = this.$index;
            flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label = 1;
            if (unbatchedFlowCombiner.onNext(i3, obj, flowExtKt$combineWithoutBatching$2$1$1$1$emit$1) == objD) {
                return objD;
            }
            flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label = 2;
            if (ZZ.a(flowExtKt$combineWithoutBatching$2$1$1$1$emit$1) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2$1$1(InterfaceC0939Tm interfaceC0939Tm, AtomicInteger atomicInteger, SimpleProducerScope<R> simpleProducerScope, UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, int i, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$flow = interfaceC0939Tm;
        this.$incompleteFlows = atomicInteger;
        this.$$this$simpleChannelFlow = simpleProducerScope;
        this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
        this.$index = i;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new FlowExtKt$combineWithoutBatching$2$1$1(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((FlowExtKt$combineWithoutBatching$2$1$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
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
