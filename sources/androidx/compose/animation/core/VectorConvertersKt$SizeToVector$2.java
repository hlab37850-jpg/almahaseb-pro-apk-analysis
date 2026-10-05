package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$SizeToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$SizeToVector$2 INSTANCE = new VectorConvertersKt$SizeToVector$2();

    public VectorConvertersKt$SizeToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Size.m2855boximpl(m147invoke7Ah8Wj8((AnimationVector2D) obj));
    }

    /* JADX INFO: renamed from: invoke-7Ah8Wj8, reason: not valid java name */
    public final long m147invoke7Ah8Wj8(AnimationVector2D animationVector2D) {
        AbstractC4492zt.h(animationVector2D, "it");
        return SizeKt.Size(animationVector2D.getV1(), animationVector2D.getV2());
    }
}
