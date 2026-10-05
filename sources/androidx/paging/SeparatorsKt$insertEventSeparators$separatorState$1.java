package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.SeparatorsKt$insertEventSeparators$separatorState$1", f = "Separators.kt", l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR}, m = "invokeSuspend")
public final class SeparatorsKt$insertEventSeparators$separatorState$1 extends XS implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0552Gp $generator;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeparatorsKt$insertEventSeparators$separatorState$1(InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
        super(3, interfaceC0793Of);
        this.$generator = interfaceC0552Gp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public final Object invoke(T t, T t2, InterfaceC0793Of interfaceC0793Of) {
        SeparatorsKt$insertEventSeparators$separatorState$1 separatorsKt$insertEventSeparators$separatorState$1 = new SeparatorsKt$insertEventSeparators$separatorState$1(this.$generator, interfaceC0793Of);
        separatorsKt$insertEventSeparators$separatorState$1.L$0 = t;
        separatorsKt$insertEventSeparators$separatorState$1.L$1 = t2;
        return separatorsKt$insertEventSeparators$separatorState$1.invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            InterfaceC0552Gp interfaceC0552Gp = this.$generator;
            this.L$0 = null;
            this.label = 1;
            obj = interfaceC0552Gp.invoke(obj2, obj3, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return obj;
    }
}
