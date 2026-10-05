package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomDrawerState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;
    final /* synthetic */ Density $density;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomDrawerState$Companion$Saver$2(Density density, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$density = density;
        this.$confirmStateChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final BottomDrawerState invoke(BottomDrawerValue bottomDrawerValue) {
        AbstractC4492zt.h(bottomDrawerValue, "it");
        return DrawerKt.BottomDrawerState(bottomDrawerValue, this.$density, this.$confirmStateChange);
    }
}
