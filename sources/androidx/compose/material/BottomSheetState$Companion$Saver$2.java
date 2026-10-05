package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;
    final /* synthetic */ Density $density;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetState$Companion$Saver$2(Density density, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$density = density;
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final BottomSheetState invoke(BottomSheetValue bottomSheetValue) {
        AbstractC4492zt.h(bottomSheetValue, "it");
        return BottomSheetScaffoldKt.BottomSheetState(bottomSheetValue, this.$density, this.$animationSpec, this.$confirmStateChange);
    }
}
