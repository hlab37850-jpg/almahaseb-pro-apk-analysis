package androidx.compose.material;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.FW;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$Slider$3$draggableState$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ LJ $maxPx;
    final /* synthetic */ LJ $minPx;
    final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
    final /* synthetic */ MutableFloatState $pressOffset;
    final /* synthetic */ MutableFloatState $rawOffset;
    final /* synthetic */ InterfaceC0789Ob $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$Slider$3$draggableState$1$1(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, LJ lj, LJ lj2, State<? extends InterfaceC3750qp> state, InterfaceC0789Ob interfaceC0789Ob) {
        super(1);
        this.$rawOffset = mutableFloatState;
        this.$pressOffset = mutableFloatState2;
        this.$minPx = lj;
        this.$maxPx = lj2;
        this.$onValueChangeState = state;
        this.$valueRange = interfaceC0789Ob;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        MutableFloatState mutableFloatState = this.$rawOffset;
        mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + f + this.$pressOffset.getFloatValue());
        this.$pressOffset.setFloatValue(0.0f);
        this.$onValueChangeState.getValue().invoke(Float.valueOf(SliderKt.C14373.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, AbstractC3871sJ.k(this.$rawOffset.getFloatValue(), this.$minPx.a, this.$maxPx.a))));
    }
}
