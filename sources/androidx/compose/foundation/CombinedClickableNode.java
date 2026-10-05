package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.semantics.Role;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class CombinedClickableNode extends AbstractClickableNode {
    private final CombinedClickablePointerInputNode clickablePointerInputNode;
    private final ClickableSemanticsNode clickableSemanticsNode;
    private InterfaceC3588op onLongClick;

    public /* synthetic */ CombinedClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, role, interfaceC3588op, str2, interfaceC3588op2, interfaceC3588op3);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public ClickableSemanticsNode getClickableSemanticsNode() {
        return this.clickableSemanticsNode;
    }

    /* JADX INFO: renamed from: update-cJG_KMw, reason: not valid java name */
    public final void m217updatecJG_KMw(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        if ((this.onLongClick == null) != (interfaceC3588op2 == null)) {
            disposeInteractionSource();
        }
        this.onLongClick = interfaceC3588op2;
        m152updateCommonXHw0xAI(mutableInteractionSource, z, str, role, interfaceC3588op);
        getClickableSemanticsNode().m212updateUMe6uN4(z, str, role, interfaceC3588op, str2, interfaceC3588op2);
        getClickablePointerInputNode().update(z, mutableInteractionSource, interfaceC3588op, interfaceC3588op2, interfaceC3588op3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private CombinedClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        super(mutableInteractionSource, z, str, role, interfaceC3588op, null);
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.onLongClick = interfaceC3588op2;
        this.clickableSemanticsNode = (ClickableSemanticsNode) delegate(new ClickableSemanticsNode(z, str, role, interfaceC3588op, str2, interfaceC3588op2, null));
        this.clickablePointerInputNode = (CombinedClickablePointerInputNode) delegate(new CombinedClickablePointerInputNode(z, mutableInteractionSource, interfaceC3588op, getInteractionData(), this.onLongClick, interfaceC3588op3));
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public CombinedClickablePointerInputNode getClickablePointerInputNode() {
        return this.clickablePointerInputNode;
    }
}
