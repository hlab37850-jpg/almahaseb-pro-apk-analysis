package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionContainerKt$SelectionContainer$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<Selection> $selection$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$SelectionContainer$1$1(MutableState<Selection> mutableState) {
        super(1);
        this.$selection$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Selection) obj);
        return FW.a;
    }

    public final void invoke(Selection selection) {
        this.$selection$delegate.setValue(selection);
    }
}
