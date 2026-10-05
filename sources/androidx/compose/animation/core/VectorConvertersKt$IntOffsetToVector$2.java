package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$IntOffsetToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$IntOffsetToVector$2 INSTANCE = new VectorConvertersKt$IntOffsetToVector$2();

    public VectorConvertersKt$IntOffsetToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5269boximpl(m141invokeBjo55l4((AnimationVector2D) obj));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m141invokeBjo55l4(AnimationVector2D animationVector2D) {
        AbstractC4492zt.h(animationVector2D, "it");
        return IntOffsetKt.IntOffset(AbstractC1210aB.c(animationVector2D.getV1()), AbstractC1210aB.c(animationVector2D.getV2()));
    }
}
