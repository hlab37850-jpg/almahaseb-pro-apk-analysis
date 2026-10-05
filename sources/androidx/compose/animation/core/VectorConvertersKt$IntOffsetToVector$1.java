package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt$IntOffsetToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final VectorConvertersKt$IntOffsetToVector$1 INSTANCE = new VectorConvertersKt$IntOffsetToVector$1();

    public VectorConvertersKt$IntOffsetToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m140invokegyyYBs(((IntOffset) obj).m5287unboximpl());
    }

    /* JADX INFO: renamed from: invoke--gyyYBs, reason: not valid java name */
    public final AnimationVector2D m140invokegyyYBs(long j) {
        return new AnimationVector2D(IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j));
    }
}
