package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$TimeInputImpl$1$1$5$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MutableState<TextFieldValue> mutableState) {
            super(1);
            this.$minuteValue$delegate = mutableState;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextFieldValue) obj);
            return FW.a;
        }

        public final void invoke(TextFieldValue textFieldValue) {
            AbstractC4492zt.h(textFieldValue, "it");
            this.$minuteValue$delegate.setValue(textFieldValue);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$TimeInputImpl$1$1$5$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$minuteValue$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return FW.a;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, "newValue");
        TimePickerKt.m1953timeInputOnChangegIWD5Rc(Selection.Companion.m1751getMinuteJiIwxys(), this.$state, textFieldValue, TimePickerKt.TimeInputImpl$lambda$8(this.$minuteValue$delegate), 59, new AnonymousClass1(this.$minuteValue$delegate));
    }
}
