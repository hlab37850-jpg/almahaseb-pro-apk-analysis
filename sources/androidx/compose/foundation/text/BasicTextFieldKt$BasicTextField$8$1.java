package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BasicTextFieldKt$BasicTextField$8$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $onValueChange;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$8$1(TextFieldValue textFieldValue, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$value = textFieldValue;
        this.$onValueChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return FW.a;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, "it");
        if (AbstractC4492zt.d(this.$value, textFieldValue)) {
            return;
        }
        this.$onValueChange.invoke(textFieldValue);
    }
}
