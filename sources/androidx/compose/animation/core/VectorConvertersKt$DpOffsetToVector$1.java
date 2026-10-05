package androidx.compose.animation.core;

import androidx.compose.ui.unit.DpOffset;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$DpOffsetToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$DpOffsetToVector$1 INSTANCE = new VectorConvertersKt$DpOffsetToVector$1();

    public VectorConvertersKt$DpOffsetToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m136invokejoFl9I(((DpOffset) obj).m5229unboximpl());
    }

    /* JADX INFO: renamed from: invoke-jo-Fl9I, reason: not valid java name */
    public final AnimationVector2D m136invokejoFl9I(long j) {
        return new AnimationVector2D(DpOffset.m5221getXD9Ej5fM(j), DpOffset.m5223getYD9Ej5fM(j));
    }
}
