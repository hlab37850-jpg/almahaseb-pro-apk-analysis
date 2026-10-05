package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.TextInputSession;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDelegate$Companion$restartInput$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ EditProcessor $editProcessor;
    final /* synthetic */ InterfaceC3750qp $onValueChange;
    final /* synthetic */ OJ $session;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldDelegate$Companion$restartInput$1(EditProcessor editProcessor, InterfaceC3750qp interfaceC3750qp, OJ oj) {
        super(1);
        this.$editProcessor = editProcessor;
        this.$onValueChange = interfaceC3750qp;
        this.$session = oj;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends EditCommand>) obj);
        return FW.a;
    }

    public final void invoke(List<? extends EditCommand> list) {
        AbstractC4492zt.h(list, "it");
        TextFieldDelegate.Companion.onEditCommand$foundation_release(list, this.$editProcessor, this.$onValueChange, (TextInputSession) this.$session.a);
    }
}
