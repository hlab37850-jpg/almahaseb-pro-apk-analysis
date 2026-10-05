package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$DpOffsetToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$DpOffsetToVector$2 INSTANCE = new VectorConvertersKt$DpOffsetToVector$2();

    public VectorConvertersKt$DpOffsetToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return DpOffset.m5215boximpl(m137invokegVRvYmI((AnimationVector2D) obj));
    }

    /* JADX INFO: renamed from: invoke-gVRvYmI, reason: not valid java name */
    public final long m137invokegVRvYmI(AnimationVector2D animationVector2D) {
        AbstractC4492zt.h(animationVector2D, "it");
        return DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(animationVector2D.getV1()), Dp.m5160constructorimpl(animationVector2D.getV2()));
    }
}
