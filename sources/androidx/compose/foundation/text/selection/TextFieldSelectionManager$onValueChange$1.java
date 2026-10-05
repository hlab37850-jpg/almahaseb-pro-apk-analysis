package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$onValueChange$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final TextFieldSelectionManager$onValueChange$1 INSTANCE = new TextFieldSelectionManager$onValueChange$1();

    public TextFieldSelectionManager$onValueChange$1() {
        super(1);
    }

    public final void invoke(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, "it");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return FW.a;
    }
}
