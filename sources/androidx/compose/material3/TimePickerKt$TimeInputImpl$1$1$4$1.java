package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$TimeInputImpl$1$1$4$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$TimeInputImpl$1$1$4$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$minuteValue$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m1957invokeZmokQxo(((KeyEvent) obj).m3928unboximpl());
    }

    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m1957invokeZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        boolean z = KeyEvent_androidKt.m3941getUtf16CodePointZmokQxo(keyEvent) == 0 && TextRange.m4705getStartimpl(TimePickerKt.TimeInputImpl$lambda$8(this.$minuteValue$delegate).m4922getSelectiond9O1mEE()) == 0;
        if (z) {
            this.$state.m1977setSelectioniHAOin8$material3_release(Selection.Companion.m1750getHourJiIwxys());
        }
        return Boolean.valueOf(z);
    }
}
