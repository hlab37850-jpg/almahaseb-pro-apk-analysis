package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DismissState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ InterfaceC0526Fp $positionalThreshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissState$Companion$Saver$2(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
        super(1);
        this.$confirmValueChange = interfaceC3750qp;
        this.$positionalThreshold = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DismissState invoke(DismissValue dismissValue) {
        AbstractC4492zt.h(dismissValue, "it");
        return new DismissState(dismissValue, this.$confirmValueChange, this.$positionalThreshold);
    }
}
