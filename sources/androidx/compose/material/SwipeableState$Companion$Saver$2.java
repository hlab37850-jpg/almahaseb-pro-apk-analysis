package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$Companion$Saver$2(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final SwipeableState<T> invoke(T t) {
        AbstractC4492zt.h(t, "it");
        return new SwipeableState<>(t, this.$animationSpec, this.$confirmStateChange);
    }
}
