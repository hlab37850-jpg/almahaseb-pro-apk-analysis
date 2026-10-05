package androidx.compose.ui.text.input;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EditProcessor$generateBatchErrorMessage$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ EditCommand $failedCommand;
    final /* synthetic */ EditProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProcessor$generateBatchErrorMessage$1$1(EditCommand editCommand, EditProcessor editProcessor) {
        super(1);
        this.$failedCommand = editCommand;
        this.this$0 = editProcessor;
    }

    @Override // defpackage.InterfaceC3750qp
    public final CharSequence invoke(EditCommand editCommand) {
        AbstractC4492zt.h(editCommand, "it");
        return (this.$failedCommand == editCommand ? " > " : "   ") + this.this$0.toStringForLog(editCommand);
    }
}
