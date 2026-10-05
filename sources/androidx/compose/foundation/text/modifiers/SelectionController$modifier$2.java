package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.TextLayoutResult;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionController$modifier$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SelectionController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionController$modifier$2(SelectionController selectionController) {
        super(0);
        this.this$0 = selectionController;
    }

    @Override // defpackage.InterfaceC3588op
    public final TextLayoutResult invoke() {
        return this.this$0.params.getTextLayoutResult();
    }
}
