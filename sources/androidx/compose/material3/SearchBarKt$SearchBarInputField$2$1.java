package androidx.compose.material3;

import androidx.compose.ui.focus.FocusState;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBarInputField$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $onActiveChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBarInputField$2$1(InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$onActiveChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return FW.a;
    }

    public final void invoke(FocusState focusState) {
        AbstractC4492zt.h(focusState, "it");
        if (focusState.isFocused()) {
            this.$onActiveChange.invoke(Boolean.TRUE);
        }
    }
}
