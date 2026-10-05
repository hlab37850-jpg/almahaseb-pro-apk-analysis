package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $contentPlaceable;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ Placeable $sheetPlaceable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(Placeable placeable, Placeable placeable2, DrawerState drawerState) {
        super(1);
        this.$contentPlaceable = placeable;
        this.$sheetPlaceable = placeable2;
        this.$drawerState = drawerState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$contentPlaceable, this.$sheetPlaceable.getWidth() + AbstractC1210aB.c(this.$drawerState.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$sheetPlaceable, AbstractC1210aB.c(this.$drawerState.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
    }
}
