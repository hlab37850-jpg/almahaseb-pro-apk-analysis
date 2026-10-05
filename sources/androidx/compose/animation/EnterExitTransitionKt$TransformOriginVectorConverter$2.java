package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$TransformOriginVectorConverter$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final EnterExitTransitionKt$TransformOriginVectorConverter$2 INSTANCE = new EnterExitTransitionKt$TransformOriginVectorConverter$2();

    public EnterExitTransitionKt$TransformOriginVectorConverter$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TransformOrigin.m3381boximpl(m51invokeLIALnN8((AnimationVector2D) obj));
    }

    /* JADX INFO: renamed from: invoke-LIALnN8, reason: not valid java name */
    public final long m51invokeLIALnN8(AnimationVector2D animationVector2D) {
        AbstractC4492zt.h(animationVector2D, "it");
        return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
    }
}
