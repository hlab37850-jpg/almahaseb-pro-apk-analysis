package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.graphics.TransformOrigin;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$TransformOriginVectorConverter$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final EnterExitTransitionKt$TransformOriginVectorConverter$1 INSTANCE = new EnterExitTransitionKt$TransformOriginVectorConverter$1();

    public EnterExitTransitionKt$TransformOriginVectorConverter$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m50invoke__ExYCQ(((TransformOrigin) obj).m3393unboximpl());
    }

    /* JADX INFO: renamed from: invoke-__ExYCQ, reason: not valid java name */
    public final AnimationVector2D m50invoke__ExYCQ(long j) {
        return new AnimationVector2D(TransformOrigin.m3389getPivotFractionXimpl(j), TransformOrigin.m3390getPivotFractionYimpl(j));
    }
}
