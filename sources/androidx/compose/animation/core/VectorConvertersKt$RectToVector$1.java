package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$RectToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$RectToVector$1 INSTANCE = new VectorConvertersKt$RectToVector$1();

    public VectorConvertersKt$RectToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final AnimationVector4D invoke(Rect rect) {
        AbstractC4492zt.h(rect, "it");
        return new AnimationVector4D(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }
}
