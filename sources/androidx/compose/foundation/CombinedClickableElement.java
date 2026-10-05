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
final class CombinedClickableElement extends ModifierNodeElement<CombinedClickableNode> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final InterfaceC3588op onClick;
    private final String onClickLabel;
    private final InterfaceC3588op onDoubleClick;
    private final InterfaceC3588op onLongClick;
    private final String onLongClickLabel;
    private final Role role;

    public /* synthetic */ CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, role, interfaceC3588op, str2, interfaceC3588op2, interfaceC3588op3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(CombinedClickableElement.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.foundation.CombinedClickableElement");
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return AbstractC4492zt.d(this.interactionSource, combinedClickableElement.interactionSource) && this.enabled == combinedClickableElement.enabled && AbstractC4492zt.d(this.onClickLabel, combinedClickableElement.onClickLabel) && AbstractC4492zt.d(this.role, combinedClickableElement.role) && AbstractC4492zt.d(this.onClick, combinedClickableElement.onClick) && AbstractC4492zt.d(this.onLongClickLabel, combinedClickableElement.onLongClickLabel) && AbstractC4492zt.d(this.onLongClick, combinedClickableElement.onLongClick) && AbstractC4492zt.d(this.onDoubleClick, combinedClickableElement.onDoubleClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((this.interactionSource.hashCode() * 31) + AbstractC0564Hb.a(this.enabled)) * 31;
        String str = this.onClickLabel;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Role role = this.role;
        int iM4547hashCodeimpl = (((iHashCode2 + (role != null ? Role.m4547hashCodeimpl(role.m4549unboximpl()) : 0)) * 31) + this.onClick.hashCode()) * 31;
        String str2 = this.onLongClickLabel;
        int iHashCode3 = (iM4547hashCodeimpl + (str2 != null ? str2.hashCode() : 0)) * 31;
        InterfaceC3588op interfaceC3588op = this.onLongClick;
        int iHashCode4 = (iHashCode3 + (interfaceC3588op != null ? interfaceC3588op.hashCode() : 0)) * 31;
        InterfaceC3588op interfaceC3588op2 = this.onDoubleClick;
        return iHashCode4 + (interfaceC3588op2 != null ? interfaceC3588op2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
    }

    public /* synthetic */ CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, int i, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, (i & 8) != 0 ? null : role, interfaceC3588op, str2, interfaceC3588op2, interfaceC3588op3, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public CombinedClickableNode create() {
        return new CombinedClickableNode(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(CombinedClickableNode combinedClickableNode) {
        AbstractC4492zt.h(combinedClickableNode, "node");
        combinedClickableNode.m217updatecJG_KMw(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick);
    }

    private CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.interactionSource = mutableInteractionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = interfaceC3588op;
        this.onLongClickLabel = str2;
        this.onLongClick = interfaceC3588op2;
        this.onDoubleClick = interfaceC3588op3;
    }
}
