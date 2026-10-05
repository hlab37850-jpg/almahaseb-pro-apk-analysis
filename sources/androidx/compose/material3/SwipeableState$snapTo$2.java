package androidx.compose.material3;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.LL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableState$snapTo$2 implements InterfaceC0995Vm {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    public SwipeableState$snapTo$2(T t, SwipeableState<T> swipeableState) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.InterfaceC0995Vm
    public final Object emit(Map<Float, ? extends T> map, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$1;
        SwipeableState$snapTo$2 swipeableState$snapTo$2;
        if (interfaceC0793Of instanceof SwipeableState$snapTo$2$emit$1) {
            swipeableState$snapTo$2$emit$1 = (SwipeableState$snapTo$2$emit$1) interfaceC0793Of;
            int i = swipeableState$snapTo$2$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                swipeableState$snapTo$2$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, interfaceC0793Of);
            }
        } else {
            swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, interfaceC0793Of);
        }
        Object obj = swipeableState$snapTo$2$emit$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = swipeableState$snapTo$2$emit$1.label;
        if (i2 == 0) {
            LL.b(obj);
            Float offset = SwipeableKt.getOffset(map, this.$targetValue);
            if (offset == null) {
                throw new IllegalArgumentException("The target value must have an associated anchor.");
            }
            SwipeableState<T> swipeableState = this.this$0;
            float fFloatValue = offset.floatValue();
            swipeableState$snapTo$2$emit$1.L$0 = this;
            swipeableState$snapTo$2$emit$1.label = 1;
            if (swipeableState.snapInternalToOffset(fFloatValue, swipeableState$snapTo$2$emit$1) == objD) {
                return objD;
            }
            swipeableState$snapTo$2 = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            swipeableState$snapTo$2 = (SwipeableState$snapTo$2) swipeableState$snapTo$2$emit$1.L$0;
            LL.b(obj);
        }
        swipeableState$snapTo$2.this$0.setCurrentValue(swipeableState$snapTo$2.$targetValue);
        return FW.a;
    }
}
