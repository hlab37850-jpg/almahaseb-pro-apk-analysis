package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DrawerKt$ModalDrawer$1$2$3$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$1$2$3$1(float f, float f2, DrawerState drawerState) {
        super(0);
        this.$minValue = f;
        this.$maxValue = f2;
        this.$drawerState = drawerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(DrawerKt.calculateFraction(this.$minValue, this.$maxValue, this.$drawerState.requireOffset$material_release()));
    }
}
