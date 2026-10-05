package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DrawerKt$BottomDrawer$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Density $density;
    final /* synthetic */ BottomDrawerState $drawerState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$1(BottomDrawerState bottomDrawerState, Density density) {
        super(0);
        this.$drawerState = bottomDrawerState;
        this.$density = density;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1098invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1098invoke() {
        this.$drawerState.setDensity$material_release(this.$density);
    }
}
