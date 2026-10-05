package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$DpToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$DpToVector$1 INSTANCE = new VectorConvertersKt$DpToVector$1();

    public VectorConvertersKt$DpToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m138invoke0680j_4(((Dp) obj).m5174unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0680j_4, reason: not valid java name */
    public final AnimationVector1D m138invoke0680j_4(float f) {
        return new AnimationVector1D(f);
    }
}
