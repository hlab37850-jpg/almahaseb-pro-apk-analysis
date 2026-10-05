package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC3240kc;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.LL;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableState$animateTo$2 implements InterfaceC0995Vm {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    public SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0082  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:48:0x0120  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.util.Map, java.util.Map<java.lang.Float, ? extends T>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    @Override // defpackage.InterfaceC0995Vm
    public final Object emit(Map<Float, ? extends T> map, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        SwipeableState$animateTo$2$emit$1 swipeableState$animateTo$2$emit$1;
        SwipeableState$animateTo$2 swipeableState$animateTo$2;
        float fFloatValue;
        LinkedHashMap linkedHashMap;
        Object objC0;
        ?? r7;
        float fFloatValue2;
        LinkedHashMap linkedHashMap2;
        Object objC1;
        if (interfaceC0793Of instanceof SwipeableState$animateTo$2$emit$1) {
            swipeableState$animateTo$2$emit$1 = (SwipeableState$animateTo$2$emit$1) interfaceC0793Of;
            int i = swipeableState$animateTo$2$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                swipeableState$animateTo$2$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, interfaceC0793Of);
            }
        } else {
            swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, interfaceC0793Of);
        }
        Object obj = swipeableState$animateTo$2$emit$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = swipeableState$animateTo$2$emit$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) swipeableState$animateTo$2$emit$1.L$1;
            swipeableState$animateTo$2 = (SwipeableState$animateTo$2) swipeableState$animateTo$2$emit$1.L$0;
            try {
                LL.b(obj);
                r7 = map;
                fFloatValue2 = ((Number) swipeableState$animateTo$2.this$0.absoluteOffset.getValue()).floatValue();
                linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : r7.entrySet()) {
                    if (Math.abs(((Number) entry.getKey()).floatValue() - fFloatValue2) < 0.5f) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                objC1 = AbstractC3240kc.c0(linkedHashMap2.values());
                if (objC1 == null) {
                    objC1 = swipeableState$animateTo$2.this$0.getCurrentValue();
                }
                swipeableState$animateTo$2.this$0.setCurrentValue(objC1);
                return FW.a;
            } catch (Throwable th) {
                th = th;
                fFloatValue = ((Number) swipeableState$animateTo$2.this$0.absoluteOffset.getValue()).floatValue();
                linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry2 : map.entrySet()) {
                    if (Math.abs(((Number) entry2.getKey()).floatValue() - fFloatValue) < 0.5f) {
                        linkedHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
                objC0 = AbstractC3240kc.c0(linkedHashMap.values());
                if (objC0 == null) {
                    objC0 = swipeableState$animateTo$2.this$0.getCurrentValue();
                }
                swipeableState$animateTo$2.this$0.setCurrentValue(objC0);
                throw th;
            }
        }
        LL.b(obj);
        try {
            Float offset = SwipeableKt.getOffset(map, this.$targetValue);
            if (offset == null) {
                throw new IllegalArgumentException("The target value must have an associated anchor.");
            }
            SwipeableState swipeableState = this.this$0;
            float fFloatValue3 = offset.floatValue();
            AnimationSpec<Float> animationSpec = this.$anim;
            swipeableState$animateTo$2$emit$1.L$0 = this;
            swipeableState$animateTo$2$emit$1.L$1 = map;
            swipeableState$animateTo$2$emit$1.label = 1;
            if (swipeableState.animateInternalToOffset(fFloatValue3, animationSpec, swipeableState$animateTo$2$emit$1) == objD) {
                return objD;
            }
            swipeableState$animateTo$2 = this;
            r7 = map;
            fFloatValue2 = ((Number) swipeableState$animateTo$2.this$0.absoluteOffset.getValue()).floatValue();
            linkedHashMap2 = new LinkedHashMap();
            while (r7.hasNext()) {
                if (Math.abs(((Number) entry.getKey()).floatValue() - fFloatValue2) < 0.5f) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            objC1 = AbstractC3240kc.c0(linkedHashMap2.values());
            if (objC1 == null) {
                objC1 = swipeableState$animateTo$2.this$0.getCurrentValue();
            }
            swipeableState$animateTo$2.this$0.setCurrentValue(objC1);
            return FW.a;
        } catch (Throwable th2) {
            th = th2;
            swipeableState$animateTo$2 = this;
            fFloatValue = ((Number) swipeableState$animateTo$2.this$0.absoluteOffset.getValue()).floatValue();
            linkedHashMap = new LinkedHashMap();
            while (r7.hasNext()) {
                if (Math.abs(((Number) entry2.getKey()).floatValue() - fFloatValue) < 0.5f) {
                    linkedHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            objC0 = AbstractC3240kc.c0(linkedHashMap.values());
            if (objC0 == null) {
                objC0 = swipeableState$animateTo$2.this$0.getCurrentValue();
            }
            swipeableState$animateTo$2.this$0.setCurrentValue(objC0);
            throw th;
        }
    }
}
