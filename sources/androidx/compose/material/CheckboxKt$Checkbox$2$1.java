package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CheckboxKt$Checkbox$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ boolean $checked;
    final /* synthetic */ InterfaceC3750qp $onCheckedChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckboxKt$Checkbox$2$1(InterfaceC3750qp interfaceC3750qp, boolean z) {
        super(0);
        this.$onCheckedChange = interfaceC3750qp;
        this.$checked = z;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1033invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1033invoke() {
        this.$onCheckedChange.invoke(Boolean.valueOf(!this.$checked));
    }
}
