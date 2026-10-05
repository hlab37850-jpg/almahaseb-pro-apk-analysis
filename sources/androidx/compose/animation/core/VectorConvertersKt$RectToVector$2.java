package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$RectToVector$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$RectToVector$2 INSTANCE = new VectorConvertersKt$RectToVector$2();

    public VectorConvertersKt$RectToVector$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Rect invoke(AnimationVector4D animationVector4D) {
        AbstractC4492zt.h(animationVector4D, "it");
        return new Rect(animationVector4D.getV1(), animationVector4D.getV2(), animationVector4D.getV3(), animationVector4D.getV4());
    }
}
