package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$TimeInputImpl$hourValue$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ TimePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$TimeInputImpl$hourValue$2$1(TimePickerState timePickerState) {
        super(0);
        this.$state = timePickerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final MutableState<TextFieldValue> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(TimePickerKt.toLocalString(this.$state.getHourForDisplay$material3_release(), 2), 0L, (TextRange) null, 6, (AbstractC0419Di) null), null, 2, null);
    }
}
