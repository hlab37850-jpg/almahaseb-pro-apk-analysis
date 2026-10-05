package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BasicTextFieldKt$BasicTextField$4$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<String> $lastTextValue$delegate;
    final /* synthetic */ InterfaceC3750qp $onValueChange;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$4$1(InterfaceC3750qp interfaceC3750qp, MutableState<TextFieldValue> mutableState, MutableState<String> mutableState2) {
        super(1);
        this.$onValueChange = interfaceC3750qp;
        this.$textFieldValueState$delegate = mutableState;
        this.$lastTextValue$delegate = mutableState2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return FW.a;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, "newTextFieldValueState");
        this.$textFieldValueState$delegate.setValue(textFieldValue);
        boolean zD = AbstractC4492zt.d(BasicTextFieldKt.BasicTextField$lambda$6(this.$lastTextValue$delegate), textFieldValue.getText());
        this.$lastTextValue$delegate.setValue(textFieldValue.getText());
        if (zD) {
            return;
        }
        this.$onValueChange.invoke(textFieldValue.getText());
    }
}
