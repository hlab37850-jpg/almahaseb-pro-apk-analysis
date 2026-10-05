package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import defpackage.AbstractC0378Bt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.TimePickerState$update$2", f = "TimePicker.kt", l = {571, 573}, m = "invokeSuspend")
public final class TimePickerState$update$2 extends XS implements InterfaceC3750qp {
    final /* synthetic */ boolean $fromTap;
    final /* synthetic */ float $value;
    int label;
    final /* synthetic */ TimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerState$update$2(TimePickerState timePickerState, float f, boolean z, InterfaceC0793Of interfaceC0793Of) {
        super(1, interfaceC0793Of);
        this.this$0 = timePickerState;
        this.$value = f;
        this.$fromTap = z;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
        return new TimePickerState$update$2(this.this$0, this.$value, this.$fromTap, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
        return ((TimePickerState$update$2) create(interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            if (Selection.m1746equalsimpl0(this.this$0.m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1750getHourJiIwxys())) {
                TimePickerState timePickerState = this.this$0;
                timePickerState.setHourAngle$material3_release((timePickerState.toHour(this.$value) % 12) * 0.5235988f);
            } else if (this.$fromTap) {
                TimePickerState timePickerState2 = this.this$0;
                timePickerState2.setMinuteAngle$material3_release((timePickerState2.toMinute(this.$value) - (this.this$0.toMinute(this.$value) % 5)) * 0.10471976f);
            } else {
                TimePickerState timePickerState3 = this.this$0;
                timePickerState3.setMinuteAngle$material3_release(timePickerState3.toMinute(this.$value) * 0.10471976f);
            }
            if (this.$fromTap) {
                Animatable<Float, AnimationVector1D> currentAngle$material3_release = this.this$0.getCurrentAngle$material3_release();
                Float fB = E8.b(this.this$0.getMinuteAngle$material3_release());
                this.label = 1;
                if (currentAngle$material3_release.snapTo(fB, this) == objD) {
                    return objD;
                }
            } else {
                Animatable<Float, AnimationVector1D> currentAngle$material3_release2 = this.this$0.getCurrentAngle$material3_release();
                Float fB2 = E8.b(this.this$0.offsetHour(this.$value));
                this.label = 2;
                if (currentAngle$material3_release2.snapTo(fB2, this) == objD) {
                    return objD;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return FW.a;
    }
}
