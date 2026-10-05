package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$DpToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$DpToVector$2 INSTANCE = new VectorConvertersKt$DpToVector$2();

    public VectorConvertersKt$DpToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Dp.m5158boximpl(m139invokeu2uoSUM((AnimationVector1D) obj));
    }

    /* JADX INFO: renamed from: invoke-u2uoSUM, reason: not valid java name */
    public final float m139invokeu2uoSUM(AnimationVector1D animationVector1D) {
        AbstractC4492zt.h(animationVector1D, "it");
        return Dp.m5160constructorimpl(animationVector1D.getValue());
    }
}
