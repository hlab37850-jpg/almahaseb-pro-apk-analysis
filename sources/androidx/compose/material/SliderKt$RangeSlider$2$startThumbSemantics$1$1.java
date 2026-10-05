package androidx.compose.material;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3790rJ;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSlider$2$startThumbSemantics$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $coercedEnd;
    final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$RangeSlider$2$startThumbSemantics$1$1(State<? extends InterfaceC3750qp> state, float f) {
        super(1);
        this.$onValueChangeState = state;
        this.$coercedEnd = f;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        this.$onValueChangeState.getValue().invoke(AbstractC3790rJ.b(f, this.$coercedEnd));
    }
}
