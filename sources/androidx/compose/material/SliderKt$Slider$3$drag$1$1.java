package androidx.compose.material;

import androidx.compose.runtime.State;
import defpackage.AbstractC0378Bt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material.SliderKt$Slider$3$drag$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
public final class SliderKt$Slider$3$drag$1$1 extends XS implements InterfaceC0552Gp {
    final /* synthetic */ State<InterfaceC3750qp> $gestureEndAction;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$Slider$3$drag$1$1(State<? extends InterfaceC3750qp> state, InterfaceC0793Of interfaceC0793Of) {
        super(3, interfaceC0793Of);
        this.$gestureEndAction = state;
    }

    public final Object invoke(InterfaceC2052dg interfaceC2052dg, float f, InterfaceC0793Of interfaceC0793Of) {
        SliderKt$Slider$3$drag$1$1 sliderKt$Slider$3$drag$1$1 = new SliderKt$Slider$3$drag$1$1(this.$gestureEndAction, interfaceC0793Of);
        sliderKt$Slider$3$drag$1$1.F$0 = f;
        return sliderKt$Slider$3$drag$1$1.invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0378Bt.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(obj);
        this.$gestureEndAction.getValue().invoke(E8.b(this.F$0));
        return FW.a;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((InterfaceC2052dg) obj, ((Number) obj2).floatValue(), (InterfaceC0793Of) obj3);
    }
}
