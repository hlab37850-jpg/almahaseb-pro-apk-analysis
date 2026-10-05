package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ InterfaceC3750qp $positionalThreshold;
    final /* synthetic */ InterfaceC3588op $velocityThreshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$Companion$Saver$2(InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp2) {
        super(1);
        this.$positionalThreshold = interfaceC3750qp;
        this.$velocityThreshold = interfaceC3588op;
        this.$animationSpec = animationSpec;
        this.$confirmValueChange = interfaceC3750qp2;
    }

    @Override // defpackage.InterfaceC3750qp
    public final AnchoredDraggableState<T> invoke(T t) {
        AbstractC4492zt.h(t, "it");
        return new AnchoredDraggableState<>(t, this.$positionalThreshold, this.$velocityThreshold, this.$animationSpec, this.$confirmValueChange);
    }
}
