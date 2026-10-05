package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3876sO;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class ClickableSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    private boolean enabled;
    private InterfaceC3588op onClick;
    private String onClickLabel;
    private InterfaceC3588op onLongClick;
    private String onLongClickLabel;
    private Role role;

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableSemanticsNode$applySemantics$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            ClickableSemanticsNode.this.onClick.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableSemanticsNode$applySemantics$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass2() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            InterfaceC3588op interfaceC3588op = ClickableSemanticsNode.this.onLongClick;
            if (interfaceC3588op != null) {
                interfaceC3588op.invoke();
            }
            return Boolean.TRUE;
        }
    }

    public /* synthetic */ ClickableSemanticsNode(boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2, AbstractC0419Di abstractC0419Di) {
        this(z, str, role, interfaceC3588op, str2, interfaceC3588op2);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "<this>");
        Role role = this.role;
        if (role != null) {
            AbstractC4492zt.e(role);
            SemanticsPropertiesKt.m4564setRolekuIjeqM(semanticsPropertyReceiver, role.m4549unboximpl());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new AnonymousClass1());
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new AnonymousClass2());
        }
        if (this.enabled) {
            return;
        }
        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return AbstractC3876sO.a(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    /* JADX INFO: renamed from: update-UMe6uN4, reason: not valid java name */
    public final void m212updateUMe6uN4(boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = interfaceC3588op;
        this.onLongClickLabel = str2;
        this.onLongClick = interfaceC3588op2;
    }

    private ClickableSemanticsNode(boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, String str2, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = interfaceC3588op;
        this.onLongClickLabel = str2;
        this.onLongClick = interfaceC3588op2;
    }
}
