package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$IntSizeToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$IntSizeToVector$1 INSTANCE = new VectorConvertersKt$IntSizeToVector$1();

    public VectorConvertersKt$IntSizeToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m142invokeozmzZPI(((IntSize) obj).m5324unboximpl());
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final AnimationVector2D m142invokeozmzZPI(long j) {
        return new AnimationVector2D(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j));
    }
}
