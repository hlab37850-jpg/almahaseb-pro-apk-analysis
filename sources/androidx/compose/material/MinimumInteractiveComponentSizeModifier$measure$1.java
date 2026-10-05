package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class MinimumInteractiveComponentSizeModifier$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $height;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinimumInteractiveComponentSizeModifier$measure$1(int i, Placeable placeable, int i2) {
        super(1);
        this.$width = i;
        this.$placeable = placeable;
        this.$height = i2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, AbstractC1210aB.c((this.$width - this.$placeable.getWidth()) / 2.0f), AbstractC1210aB.c((this.$height - this.$placeable.getHeight()) / 2.0f), 0.0f, 4, null);
    }
}
