package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSliderImpl$gestureEndAction$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3588op $onValueChangeFinished;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSliderImpl$gestureEndAction$1$1(InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$onValueChangeFinished = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return FW.a;
    }

    public final void invoke(boolean z) {
        InterfaceC3588op interfaceC3588op = this.$onValueChangeFinished;
        if (interfaceC3588op != null) {
            interfaceC3588op.invoke();
        }
    }
}
