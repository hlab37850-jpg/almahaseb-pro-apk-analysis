package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$SliderImpl$onValueChangeState$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $onValueChange;
    final /* synthetic */ float $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$onValueChangeState$1$1(float f, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$value = f;
        this.$onValueChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        if (f == this.$value) {
            return;
        }
        this.$onValueChange.invoke(Float.valueOf(f));
    }
}
