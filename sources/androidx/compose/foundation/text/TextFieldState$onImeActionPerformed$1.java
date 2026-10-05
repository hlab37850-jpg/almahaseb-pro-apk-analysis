package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldState$onImeActionPerformed$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TextFieldState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldState$onImeActionPerformed$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m839invokeKlQnJC8(((ImeAction) obj).m4853unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
    public final void m839invokeKlQnJC8(int i) {
        this.this$0.keyboardActionRunner.m766runActionKlQnJC8(i);
    }
}
