package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class ClickableSemanticsElement extends ModifierNodeElement<ClickableSemanticsNode> {
    private final boolean enabled;
    private final InterfaceC3588op onClick;
    private final String onClickLabel;
    private final InterfaceC3588op onLongClick;
    private final String onLongClickLabel;
    private final Role role;

    public /* synthetic */ ClickableSemanticsElement(boolean z, Role role, String str, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, AbstractC0419Di abstractC0419Di) {
        this(z, role, str, interfaceC3588op, str2, interfaceC3588op2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClickableSemanticsElement)) {
            return false;
        }
        ClickableSemanticsElement clickableSemanticsElement = (ClickableSemanticsElement) obj;
        return this.enabled == clickableSemanticsElement.enabled && AbstractC4492zt.d(this.role, clickableSemanticsElement.role) && AbstractC4492zt.d(this.onLongClickLabel, clickableSemanticsElement.onLongClickLabel) && AbstractC4492zt.d(this.onLongClick, clickableSemanticsElement.onLongClick) && AbstractC4492zt.d(this.onClickLabel, clickableSemanticsElement.onClickLabel) && AbstractC4492zt.d(this.onClick, clickableSemanticsElement.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iA = AbstractC0564Hb.a(this.enabled) * 31;
        Role role = this.role;
        int iHashCode = (iA + (role != null ? role.hashCode() : 0)) * 31;
        String str = this.onLongClickLabel;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        InterfaceC3588op interfaceC3588op = this.onLongClick;
        int iHashCode3 = (iHashCode2 + (interfaceC3588op != null ? interfaceC3588op.hashCode() : 0)) * 31;
        String str2 = this.onClickLabel;
        return ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.onClick.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
    }

    private ClickableSemanticsElement(boolean z, Role role, String str, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(interfaceC3588op2, "onClick");
        this.enabled = z;
        this.role = role;
        this.onLongClickLabel = str;
        this.onLongClick = interfaceC3588op;
        this.onClickLabel = str2;
        this.onClick = interfaceC3588op2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ClickableSemanticsNode create() {
        return new ClickableSemanticsNode(this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ClickableSemanticsNode clickableSemanticsNode) {
        AbstractC4492zt.h(clickableSemanticsNode, "node");
        clickableSemanticsNode.m212updateUMe6uN4(this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick);
    }
}
