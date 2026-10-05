package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomNavigationKt$placeIcon$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomNavigationKt$placeIcon$1(Placeable placeable, int i) {
        super(1);
        this.$iconPlaceable = placeable;
        this.$iconY = i;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$iconPlaceable, 0, this.$iconY, 0.0f, 4, null);
    }
}
