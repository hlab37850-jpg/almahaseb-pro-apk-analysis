package androidx.compose.foundation.text.selection;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$showSelectionToolbar$copy$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$showSelectionToolbar$copy$1(TextFieldSelectionManager textFieldSelectionManager) {
        super(0);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m958invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m958invoke() {
        TextFieldSelectionManager.copy$foundation_release$default(this.this$0, false, 1, null);
        this.this$0.hideSelectionToolbar$foundation_release();
    }
}
