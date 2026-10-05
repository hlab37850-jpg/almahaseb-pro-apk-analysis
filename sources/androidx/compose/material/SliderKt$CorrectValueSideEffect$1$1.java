package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$CorrectValueSideEffect$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $scaleToOffset;
    final /* synthetic */ InterfaceC0789Ob $trackRange;
    final /* synthetic */ float $value;
    final /* synthetic */ InterfaceC0789Ob $valueRange;
    final /* synthetic */ MutableState<Float> $valueState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$CorrectValueSideEffect$1$1(InterfaceC0789Ob interfaceC0789Ob, InterfaceC3750qp interfaceC3750qp, float f, MutableState<Float> mutableState, InterfaceC0789Ob interfaceC0789Ob2) {
        super(0);
        this.$valueRange = interfaceC0789Ob;
        this.$scaleToOffset = interfaceC3750qp;
        this.$value = f;
        this.$valueState = mutableState;
        this.$trackRange = interfaceC0789Ob2;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1203invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1203invoke() {
        float fFloatValue = (((Number) this.$valueRange.getEndInclusive()).floatValue() - ((Number) this.$valueRange.getStart()).floatValue()) / 1000;
        float fFloatValue2 = ((Number) this.$scaleToOffset.invoke(Float.valueOf(this.$value))).floatValue();
        if (Math.abs(fFloatValue2 - this.$valueState.getValue().floatValue()) <= fFloatValue || !this.$trackRange.contains(this.$valueState.getValue())) {
            return;
        }
        this.$valueState.setValue(Float.valueOf(fFloatValue2));
    }
}
