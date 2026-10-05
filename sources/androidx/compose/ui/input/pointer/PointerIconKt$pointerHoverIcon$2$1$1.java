package androidx.compose.ui.input.pointer;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$2$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PointerIcon $icon;
    final /* synthetic */ InterfaceC3750qp $onSetIcon;
    final /* synthetic */ boolean $overrideDescendants;
    final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$2$1$1(PointerIconModifierLocal pointerIconModifierLocal, PointerIcon pointerIcon, boolean z, InterfaceC3750qp interfaceC3750qp) {
        super(0);
        this.$pointerIconModifierLocal = pointerIconModifierLocal;
        this.$icon = pointerIcon;
        this.$overrideDescendants = z;
        this.$onSetIcon = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m4033invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4033invoke() {
        this.$pointerIconModifierLocal.updateValues(this.$icon, this.$overrideDescendants, this.$onSetIcon);
    }
}
