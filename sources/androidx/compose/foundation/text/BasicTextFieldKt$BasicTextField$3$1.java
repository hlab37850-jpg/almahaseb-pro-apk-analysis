package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BasicTextFieldKt$BasicTextField$3$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ TextFieldValue $textFieldValue;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$3$1(TextFieldValue textFieldValue, MutableState<TextFieldValue> mutableState) {
        super(0);
        this.$textFieldValue = textFieldValue;
        this.$textFieldValueState$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m741invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m741invoke() {
        if (TextRange.m4698equalsimpl0(this.$textFieldValue.m4922getSelectiond9O1mEE(), BasicTextFieldKt.BasicTextField$lambda$2(this.$textFieldValueState$delegate).m4922getSelectiond9O1mEE()) && AbstractC4492zt.d(this.$textFieldValue.m4921getCompositionMzsxiRA(), BasicTextFieldKt.BasicTextField$lambda$2(this.$textFieldValueState$delegate).m4921getCompositionMzsxiRA())) {
            return;
        }
        this.$textFieldValueState$delegate.setValue(this.$textFieldValue);
    }
}
