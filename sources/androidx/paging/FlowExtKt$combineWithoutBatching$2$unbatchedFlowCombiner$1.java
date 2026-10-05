package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.FW;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1", f = "FlowExt.kt", l = {ShapeTypes.FLOW_CHART_MANUAL_OPERATION, ShapeTypes.FLOW_CHART_MANUAL_OPERATION}, m = "invokeSuspend")
public final class FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 extends XS implements InterfaceC0578Hp {
    final /* synthetic */ SimpleProducerScope<R> $$this$simpleChannelFlow;
    final /* synthetic */ InterfaceC0578Hp $transform;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(SimpleProducerScope<R> simpleProducerScope, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0793Of interfaceC0793Of) {
        super(4, interfaceC0793Of);
        this.$$this$simpleChannelFlow = simpleProducerScope;
        this.$transform = interfaceC0578Hp;
    }

    @Override // defpackage.InterfaceC0578Hp
    public final Object invoke(T1 t1, T2 t2, CombineSource combineSource, InterfaceC0793Of interfaceC0793Of) {
        FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 = new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(this.$$this$simpleChannelFlow, this.$transform, interfaceC0793Of);
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.L$0 = t1;
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.L$1 = t2;
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.L$2 = combineSource;
        return flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        SimpleProducerScope simpleProducerScope;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                simpleProducerScope = (SimpleProducerScope) this.L$0;
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
        Object obj2 = this.L$0;
        Object obj3 = this.L$1;
        CombineSource combineSource = (CombineSource) this.L$2;
        SimpleProducerScope simpleProducerScope2 = this.$$this$simpleChannelFlow;
        InterfaceC0578Hp interfaceC0578Hp = this.$transform;
        this.L$0 = simpleProducerScope2;
        this.L$1 = null;
        this.label = 1;
        obj = interfaceC0578Hp.invoke(obj2, obj3, combineSource, this);
        if (obj == objD) {
            return objD;
        }
        simpleProducerScope = simpleProducerScope2;
        this.L$0 = null;
        this.label = 2;
        if (simpleProducerScope.send(obj, this) == objD) {
            return objD;
        }
        return FW.a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Object obj2 = this.L$0;
        Object obj3 = this.L$1;
        CombineSource combineSource = (CombineSource) this.L$2;
        InterfaceC4038uO interfaceC4038uO = this.$$this$simpleChannelFlow;
        Object objInvoke = this.$transform.invoke(obj2, obj3, combineSource, this);
        AbstractC0703Ks.c(0);
        interfaceC4038uO.send(objInvoke, this);
        AbstractC0703Ks.c(1);
        return FW.a;
    }
}
