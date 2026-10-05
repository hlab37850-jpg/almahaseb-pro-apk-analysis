package androidx.compose.animation.core;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$FloatToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$FloatToVector$1 INSTANCE = new VectorConvertersKt$FloatToVector$1();

    public VectorConvertersKt$FloatToVector$1() {
        super(1);
    }

    public final AnimationVector1D invoke(float f) {
        return new AnimationVector1D(f);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
