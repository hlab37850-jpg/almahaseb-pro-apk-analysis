package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$PeriodToggleImpl$2$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ TimePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$PeriodToggleImpl$2$1$1(TimePickerState timePickerState) {
        super(0);
        this.$state = timePickerState;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1954invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1954invoke() {
        this.$state.setAfternoonToggle$material3_release(false);
    }
}
