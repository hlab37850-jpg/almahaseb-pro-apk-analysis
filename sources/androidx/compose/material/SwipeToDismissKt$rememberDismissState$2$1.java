package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissKt$rememberDismissState$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;
    final /* synthetic */ DismissValue $initialValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$rememberDismissState$2$1(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp) {
        super(0);
        this.$initialValue = dismissValue;
        this.$confirmStateChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3588op
    public final DismissState invoke() {
        return new DismissState(this.$initialValue, this.$confirmStateChange);
    }
}
