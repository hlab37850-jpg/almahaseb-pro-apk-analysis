package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC3871sJ;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSliderImpl$onDrag$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ MutableState<Float> $endThumbWidth$delegate;
    final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ MutableState<Float> $startThumbWidth$delegate;
    final /* synthetic */ float[] $tickFractions;
    final /* synthetic */ MutableState<Integer> $totalWidth$delegate;
    final /* synthetic */ InterfaceC0789Ob $value;
    final /* synthetic */ InterfaceC0789Ob $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$RangeSliderImpl$onDrag$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, InterfaceC0789Ob interfaceC0789Ob, float[] fArr, State<? extends InterfaceC3750qp> state, MutableState<Integer> mutableState3, MutableState<Float> mutableState4, MutableState<Float> mutableState5, InterfaceC0789Ob interfaceC0789Ob2) {
        super(2);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$value = interfaceC0789Ob;
        this.$tickFractions = fArr;
        this.$onValueChangeState = state;
        this.$totalWidth$delegate = mutableState3;
        this.$endThumbWidth$delegate = mutableState4;
        this.$startThumbWidth$delegate = mutableState5;
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
        float f2 = 2;
        float fMax = Math.max(SliderKt.RangeSliderImpl$lambda$31(this.$totalWidth$delegate) - (SliderKt.RangeSliderImpl$lambda$28(this.$endThumbWidth$delegate) / f2), 0.0f);
        float fMin = Math.min(SliderKt.RangeSliderImpl$lambda$25(this.$startThumbWidth$delegate) / f2, fMax);
        if (z) {
            MutableState<Float> mutableState = this.$rawOffsetStart;
            mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f));
            this.$rawOffsetEnd.setValue(Float.valueOf(SliderKt.RangeSliderImpl$scaleToOffset$34(this.$valueRange, fMin, fMax, ((Number) this.$value.getEndInclusive()).floatValue())));
            float fFloatValue = this.$rawOffsetEnd.getValue().floatValue();
            interfaceC0789ObB = AbstractC3790rJ.b(SliderKt.snapValueToTick(AbstractC3871sJ.k(this.$rawOffsetStart.getValue().floatValue(), fMin, fFloatValue), this.$tickFractions, fMin, fMax), fFloatValue);
        } else {
            MutableState<Float> mutableState2 = this.$rawOffsetEnd;
            mutableState2.setValue(Float.valueOf(mutableState2.getValue().floatValue() + f));
            this.$rawOffsetStart.setValue(Float.valueOf(SliderKt.RangeSliderImpl$scaleToOffset$34(this.$valueRange, fMin, fMax, ((Number) this.$value.getStart()).floatValue())));
            float fFloatValue2 = this.$rawOffsetStart.getValue().floatValue();
            interfaceC0789ObB = AbstractC3790rJ.b(fFloatValue2, SliderKt.snapValueToTick(AbstractC3871sJ.k(this.$rawOffsetEnd.getValue().floatValue(), fFloatValue2, fMax), this.$tickFractions, fMin, fMax));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt.RangeSliderImpl$scaleToUserValue$33(this.$valueRange, fMin, fMax, interfaceC0789ObB));
    }
}
