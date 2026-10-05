package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2 INSTANCE = new SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2();

    public SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m2787boximpl(m904invoketuRUvjQ((AnimationVector2D) obj));
    }

    /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
    public final long m904invoketuRUvjQ(AnimationVector2D animationVector2D) {
        AbstractC4492zt.h(animationVector2D, "it");
        return OffsetKt.Offset(animationVector2D.getV1(), animationVector2D.getV2());
    }
}
