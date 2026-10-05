package androidx.compose.foundation.selection;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ToggleableKt$toggleable$4$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $onValueChange;
    final /* synthetic */ boolean $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleableKt$toggleable$4$1(InterfaceC3750qp interfaceC3750qp, boolean z) {
        super(0);
        this.$onValueChange = interfaceC3750qp;
        this.$value = z;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m719invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m719invoke() {
        this.$onValueChange.invoke(Boolean.valueOf(!this.$value));
    }
}
