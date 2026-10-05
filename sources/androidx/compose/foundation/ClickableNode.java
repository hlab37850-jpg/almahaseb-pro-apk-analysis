package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.semantics.Role;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class ClickableNode extends AbstractClickableNode {
    private final ClickablePointerInputNode clickablePointerInputNode;
    private final ClickableSemanticsNode clickableSemanticsNode;

    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, role, interfaceC3588op);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public ClickableSemanticsNode getClickableSemanticsNode() {
        return this.clickableSemanticsNode;
    }

    /* JADX INFO: renamed from: update-XHw0xAI, reason: not valid java name */
    public final void m209updateXHw0xAI(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        m152updateCommonXHw0xAI(mutableInteractionSource, z, str, role, interfaceC3588op);
        getClickableSemanticsNode().m212updateUMe6uN4(z, str, role, interfaceC3588op, null, null);
        getClickablePointerInputNode().update(z, mutableInteractionSource, interfaceC3588op);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        super(mutableInteractionSource, z, str, role, interfaceC3588op, null);
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.clickableSemanticsNode = (ClickableSemanticsNode) delegate(new ClickableSemanticsNode(z, str, role, interfaceC3588op, null, null, null));
        this.clickablePointerInputNode = (ClickablePointerInputNode) delegate(new ClickablePointerInputNode(z, mutableInteractionSource, interfaceC3588op, getInteractionData()));
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public ClickablePointerInputNode getClickablePointerInputNode() {
        return this.clickablePointerInputNode;
    }
}
