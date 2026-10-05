package androidx.compose.animation.core;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$FloatToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$FloatToVector$2 INSTANCE = new VectorConvertersKt$FloatToVector$2();

    public VectorConvertersKt$FloatToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Float invoke(AnimationVector1D animationVector1D) {
        AbstractC4492zt.h(animationVector1D, "it");
        return Float.valueOf(animationVector1D.getValue());
    }
}
