package androidx.compose.material;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3750qp $dismissThresholds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(InterfaceC3750qp interfaceC3750qp) {
        super(2);
        this.$dismissThresholds = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ThresholdConfig mo13invoke(DismissValue dismissValue, DismissValue dismissValue2) {
        AbstractC4492zt.h(dismissValue, TypedValues.TransitionType.S_FROM);
        AbstractC4492zt.h(dismissValue2, TypedValues.TransitionType.S_TO);
        InterfaceC3750qp interfaceC3750qp = this.$dismissThresholds;
        DismissDirection dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
        AbstractC4492zt.e(dismissDirection);
        return (ThresholdConfig) interfaceC3750qp.invoke(dismissDirection);
    }
}
