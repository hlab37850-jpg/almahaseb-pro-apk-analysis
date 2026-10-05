package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DismissState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissState$Companion$Saver$2(InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$confirmStateChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DismissState invoke(DismissValue dismissValue) {
        AbstractC4492zt.h(dismissValue, "it");
        return new DismissState(dismissValue, this.$confirmStateChange);
    }
}
