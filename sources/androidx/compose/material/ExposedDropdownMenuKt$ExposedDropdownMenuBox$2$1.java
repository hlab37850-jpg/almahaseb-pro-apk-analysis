package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ InterfaceC3750qp $onExpandedChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(InterfaceC3750qp interfaceC3750qp, boolean z) {
        super(0);
        this.$onExpandedChange = interfaceC3750qp;
        this.$expanded = z;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1119invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1119invoke() {
        this.$onExpandedChange.invoke(Boolean.valueOf(!this.$expanded));
    }
}
