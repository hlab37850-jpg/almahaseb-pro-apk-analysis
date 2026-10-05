package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActionScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$TimeInputImpl$1$1$6$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TimePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$TimeInputImpl$1$1$6$1(TimePickerState timePickerState) {
        super(1);
        this.$state = timePickerState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return FW.a;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        AbstractC4492zt.h(keyboardActionScope, "$this$$receiver");
        this.$state.m1977setSelectioniHAOin8$material3_release(Selection.Companion.m1751getMinuteJiIwxys());
    }
}
