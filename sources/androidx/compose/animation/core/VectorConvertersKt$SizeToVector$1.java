package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Size;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$SizeToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$SizeToVector$1 INSTANCE = new VectorConvertersKt$SizeToVector$1();

    public VectorConvertersKt$SizeToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m146invokeuvyYCjk(((Size) obj).m2872unboximpl());
    }

    /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
    public final AnimationVector2D m146invokeuvyYCjk(long j) {
        return new AnimationVector2D(Size.m2867getWidthimpl(j), Size.m2864getHeightimpl(j));
    }
}
