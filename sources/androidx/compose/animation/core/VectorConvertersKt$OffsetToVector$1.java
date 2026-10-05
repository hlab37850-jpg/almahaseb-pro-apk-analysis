package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$OffsetToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$OffsetToVector$1 INSTANCE = new VectorConvertersKt$OffsetToVector$1();

    public VectorConvertersKt$OffsetToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m144invokek4lQ0M(((Offset) obj).m2808unboximpl());
    }

    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final AnimationVector2D m144invokek4lQ0M(long j) {
        return new AnimationVector2D(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
    }
}
