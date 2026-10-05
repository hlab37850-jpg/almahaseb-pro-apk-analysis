package androidx.compose.material;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC3871sJ;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSlider$2$onDrag$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ LJ $maxPx;
    final /* synthetic */ LJ $minPx;
    final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
    final /* synthetic */ MutableFloatState $rawOffsetEnd;
    final /* synthetic */ MutableFloatState $rawOffsetStart;
    final /* synthetic */ InterfaceC0789Ob $value;
    final /* synthetic */ InterfaceC0789Ob $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$RangeSlider$2$onDrag$1$1(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, InterfaceC0789Ob interfaceC0789Ob, LJ lj, LJ lj2, State<? extends InterfaceC3750qp> state, InterfaceC0789Ob interfaceC0789Ob2) {
        super(2);
        this.$rawOffsetStart = mutableFloatState;
        this.$rawOffsetEnd = mutableFloatState2;
        this.$value = interfaceC0789Ob;
        this.$minPx = lj;
        this.$maxPx = lj2;
        this.$onValueChangeState = state;
        this.$valueRange = interfaceC0789Ob2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
        return FW.a;
    }

    public final void invoke(boolean z, float f) {
        InterfaceC0789Ob interfaceC0789ObB;
        if (z) {
            MutableFloatState mutableFloatState = this.$rawOffsetStart;
            mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + f);
            this.$rawOffsetEnd.setFloatValue(SliderKt.C14352.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, ((Number) this.$value.getEndInclusive()).floatValue()));
            float floatValue = this.$rawOffsetEnd.getFloatValue();
            interfaceC0789ObB = AbstractC3790rJ.b(AbstractC3871sJ.k(this.$rawOffsetStart.getFloatValue(), this.$minPx.a, floatValue), floatValue);
        } else {
            MutableFloatState mutableFloatState2 = this.$rawOffsetEnd;
            mutableFloatState2.setFloatValue(mutableFloatState2.getFloatValue() + f);
            this.$rawOffsetStart.setFloatValue(SliderKt.C14352.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, ((Number) this.$value.getStart()).floatValue()));
            float floatValue2 = this.$rawOffsetStart.getFloatValue();
            interfaceC0789ObB = AbstractC3790rJ.b(floatValue2, AbstractC3871sJ.k(this.$rawOffsetEnd.getFloatValue(), floatValue2, this.$maxPx.a));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt.C14352.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, interfaceC0789ObB));
    }
}
