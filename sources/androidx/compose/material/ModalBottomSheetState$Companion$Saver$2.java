package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ Density $density;
    final /* synthetic */ boolean $skipHalfExpanded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState$Companion$Saver$2(Density density, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z) {
        super(1);
        this.$density = density;
        this.$animationSpec = animationSpec;
        this.$confirmValueChange = interfaceC3750qp;
        this.$skipHalfExpanded = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public final ModalBottomSheetState invoke(ModalBottomSheetValue modalBottomSheetValue) {
        AbstractC4492zt.h(modalBottomSheetValue, "it");
        return ModalBottomSheetKt.ModalBottomSheetState(modalBottomSheetValue, this.$density, this.$animationSpec, this.$confirmValueChange, this.$skipHalfExpanded);
    }
}
