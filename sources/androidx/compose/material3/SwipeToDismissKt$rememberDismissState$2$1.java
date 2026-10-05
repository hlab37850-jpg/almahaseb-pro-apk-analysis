package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissKt$rememberDismissState$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ DismissValue $initialValue;
    final /* synthetic */ InterfaceC0526Fp $positionalThreshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$rememberDismissState$2$1(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
        super(0);
        this.$initialValue = dismissValue;
        this.$confirmValueChange = interfaceC3750qp;
        this.$positionalThreshold = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC3588op
    public final DismissState invoke() {
        return new DismissState(this.$initialValue, this.$confirmValueChange, this.$positionalThreshold);
    }
}
