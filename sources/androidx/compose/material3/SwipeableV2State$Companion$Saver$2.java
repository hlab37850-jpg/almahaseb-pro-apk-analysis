package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2State$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ InterfaceC0526Fp $positionalThreshold;
    final /* synthetic */ float $velocityThreshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2State$Companion$Saver$2(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, float f) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmValueChange = interfaceC3750qp;
        this.$positionalThreshold = interfaceC0526Fp;
        this.$velocityThreshold = f;
    }

    @Override // defpackage.InterfaceC3750qp
    public final SwipeableV2State<T> invoke(T t) {
        AbstractC4492zt.h(t, "it");
        return new SwipeableV2State<>(t, this.$animationSpec, this.$confirmValueChange, this.$positionalThreshold, this.$velocityThreshold, null);
    }
}
