package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class ClickableElement extends ModifierNodeElement<ClickableNode> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final InterfaceC3588op onClick;
    private final String onClickLabel;
    private final Role role;

    public /* synthetic */ ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, role, interfaceC3588op);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(ClickableElement.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.foundation.ClickableElement");
        ClickableElement clickableElement = (ClickableElement) obj;
        return AbstractC4492zt.d(this.interactionSource, clickableElement.interactionSource) && this.enabled == clickableElement.enabled && AbstractC4492zt.d(this.onClickLabel, clickableElement.onClickLabel) && AbstractC4492zt.d(this.role, clickableElement.role) && AbstractC4492zt.d(this.onClick, clickableElement.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((this.interactionSource.hashCode() * 31) + AbstractC0564Hb.a(this.enabled)) * 31;
        String str = this.onClickLabel;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Role role = this.role;
        return ((iHashCode2 + (role != null ? Role.m4547hashCodeimpl(role.m4549unboximpl()) : 0)) * 31) + this.onClick.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
    }

    public /* synthetic */ ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, (i & 8) != 0 ? null : role, interfaceC3588op, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ClickableNode create() {
        return new ClickableNode(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ClickableNode clickableNode) {
        AbstractC4492zt.h(clickableNode, "node");
        clickableNode.m209updateXHw0xAI(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    private ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.interactionSource = mutableInteractionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = interfaceC3588op;
    }
}
