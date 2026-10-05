package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DatePickerContent$1$3$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DatePickerContent$1$3$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$yearPickerVisible$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1506invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1506invoke() {
        MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        DatePickerKt.DatePickerContent$lambda$6(mutableState, !DatePickerKt.DatePickerContent$lambda$5(mutableState));
    }
}
