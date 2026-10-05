package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetState$Companion$Saver$4 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetState$Companion$Saver$4(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final BottomSheetState invoke(BottomSheetValue bottomSheetValue) {
        AbstractC4492zt.h(bottomSheetValue, "it");
        return new BottomSheetState(bottomSheetValue, this.$animationSpec, this.$confirmStateChange);
    }
}
