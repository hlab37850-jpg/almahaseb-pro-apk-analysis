package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DrawerKt$ModalDrawer$1$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Density $density;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$1$1$1(DrawerState drawerState, Density density, float f, float f2) {
        super(0);
        this.$drawerState = drawerState;
        this.$density = density;
        this.$minValue = f;
        this.$maxValue = f2;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1103invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1103invoke() {
        this.$drawerState.setDensity$material_release(this.$density);
        AnchoredDraggableState.updateAnchors$material_release$default(this.$drawerState.getAnchoredDraggableState$material_release(), AbstractC4243wx.j(HV.a(DrawerValue.Closed, Float.valueOf(this.$minValue)), HV.a(DrawerValue.Open, Float.valueOf(this.$maxValue))), null, 2, null);
    }
}
