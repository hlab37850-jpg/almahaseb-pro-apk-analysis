package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FocusEventNode extends Modifier.Node implements FocusEventModifierNode {
    private InterfaceC3750qp onFocusEvent;

    public FocusEventNode(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onFocusEvent");
        this.onFocusEvent = interfaceC3750qp;
    }

    public final InterfaceC3750qp getOnFocusEvent() {
        return this.onFocusEvent;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(FocusState focusState) {
        AbstractC4492zt.h(focusState, "focusState");
        this.onFocusEvent.invoke(focusState);
    }

    public final void setOnFocusEvent(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "<set-?>");
        this.onFocusEvent = interfaceC3750qp;
    }
}
