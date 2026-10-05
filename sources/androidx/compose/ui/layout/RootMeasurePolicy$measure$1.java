package androidx.compose.ui.layout;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final RootMeasurePolicy$measure$1 INSTANCE = new RootMeasurePolicy$measure$1();

    public RootMeasurePolicy$measure$1() {
        super(1);
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }
}
