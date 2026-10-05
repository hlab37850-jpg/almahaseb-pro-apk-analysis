package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffold$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Density $density;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$1$1(BottomSheetScaffoldState bottomSheetScaffoldState, Density density) {
        super(0);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$density = density;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1012invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1012invoke() {
        this.$scaffoldState.getBottomSheetState().setDensity$material_release(this.$density);
    }
}
