package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1 INSTANCE = new AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1();

    /* JADX INFO: renamed from: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $extraSizePx;
        final /* synthetic */ Placeable $placeable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Placeable placeable, int i) {
            super(1);
            this.$placeable = placeable;
            this.$extraSizePx = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "$this$layout");
            Placeable placeable = this.$placeable;
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, ((-this.$extraSizePx) / 2) - ((placeable.getWidth() - this.$placeable.getMeasuredWidth()) / 2), ((-this.$extraSizePx) / 2) - ((this.$placeable.getHeight() - this.$placeable.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
        }
    }

    public AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1() {
        super(3);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m164invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
    public final MeasureResult m164invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$layout");
        AbstractC4492zt.h(measurable, "measurable");
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getMeasuredWidth() - iMo327roundToPx0680j_4, placeableMo4159measureBRTryo0.getMeasuredHeight() - iMo327roundToPx0680j_4, null, new AnonymousClass1(placeableMo4159measureBRTryo0, iMo327roundToPx0680j_4), 4, null);
    }
}
