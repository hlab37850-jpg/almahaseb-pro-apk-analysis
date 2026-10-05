package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 INSTANCE = new SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1();

    public SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m903invokek4lQ0M(((Offset) obj).m2808unboximpl());
    }

    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final AnimationVector2D m903invokek4lQ0M(long j) {
        return OffsetKt.m2817isSpecifiedk4lQ0M(j) ? new AnimationVector2D(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j)) : SelectionMagnifierKt.UnspecifiedAnimationVector2D;
    }
}
