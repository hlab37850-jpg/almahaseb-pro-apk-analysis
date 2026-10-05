package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    private InterfaceC3750qp focusPropertiesScope;

    public FocusPropertiesNode(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "focusPropertiesScope");
        this.focusPropertiesScope = interfaceC3750qp;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        AbstractC4492zt.h(focusProperties, "focusProperties");
        this.focusPropertiesScope.invoke(focusProperties);
    }

    public final InterfaceC3750qp getFocusPropertiesScope() {
        return this.focusPropertiesScope;
    }

    public final void setFocusPropertiesScope(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "<set-?>");
        this.focusPropertiesScope = interfaceC3750qp;
    }
}
