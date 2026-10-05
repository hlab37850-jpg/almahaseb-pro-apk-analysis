package androidx.compose.ui.layout;

import androidx.compose.ui.node.ComposeUiNode;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutKt$Layout$$inlined$ReusableComposeNode$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3588op $factory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutKt$Layout$$inlined$ReusableComposeNode$1(InterfaceC3588op interfaceC3588op) {
        super(0);
        this.$factory = interfaceC3588op;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
    @Override // defpackage.InterfaceC3588op
    public final ComposeUiNode invoke() {
        return this.$factory.invoke();
    }
}
