package androidx.compose.animation.core;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$IntToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$IntToVector$2 INSTANCE = new VectorConvertersKt$IntToVector$2();

    public VectorConvertersKt$IntToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Integer invoke(AnimationVector1D animationVector1D) {
        AbstractC4492zt.h(animationVector1D, "it");
        return Integer.valueOf((int) animationVector1D.getValue());
    }
}
