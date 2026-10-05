package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerState$selectorPos$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ boolean $is24Hour;
    final /* synthetic */ TimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerState$selectorPos$2(TimePickerState timePickerState, boolean z) {
        super(0);
        this.this$0 = timePickerState;
        this.$is24Hour = z;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        return DpOffset.m5215boximpl(m1978invokeRKDOV3M());
    }

    /* JADX INFO: renamed from: invoke-RKDOV3M, reason: not valid java name */
    public final long m1978invokeRKDOV3M() {
        boolean zIsInnerCircle$material3_release = this.this$0.isInnerCircle$material3_release();
        TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
        float f = 2;
        float fM5160constructorimpl = Dp.m5160constructorimpl(timePickerTokens.m2551getClockDialSelectorHandleContainerSizeD9Ej5fM() / f);
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(((this.$is24Hour && zIsInnerCircle$material3_release && Selection.m1746equalsimpl0(this.this$0.m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1750getHourJiIwxys())) ? TimePickerKt.InnerCircleRadius : TimePickerKt.OuterCircleSizeRadius) - fM5160constructorimpl) + fM5160constructorimpl);
        return DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(Dp.m5160constructorimpl(((float) Math.cos(this.this$0.getCurrentAngle$material3_release().getValue().floatValue())) * fM5160constructorimpl2) + Dp.m5160constructorimpl(timePickerTokens.m2549getClockDialContainerSizeD9Ej5fM() / f)), Dp.m5160constructorimpl(Dp.m5160constructorimpl(fM5160constructorimpl2 * ((float) Math.sin(this.this$0.getCurrentAngle$material3_release().getValue().floatValue()))) + Dp.m5160constructorimpl(timePickerTokens.m2549getClockDialContainerSizeD9Ej5fM() / f)));
    }
}
