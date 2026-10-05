package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBar$3$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ State<Dp> $topPadding;

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarKt$SearchBar$3$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $animatedTopPadding;
        final /* synthetic */ Placeable $placeable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Placeable placeable, int i) {
            super(1);
            this.$placeable = placeable;
            this.$animatedTopPadding = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "$this$layout");
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeable, 0, this.$animatedTopPadding, 0.0f, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBar$3$1(State<Dp> state, State<Float> state2) {
        super(3);
        this.$topPadding = state;
        this.$animationProgress = state2;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m1739invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
    public final MeasureResult m1739invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$layout");
        AbstractC4492zt.h(measurable, "measurable");
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(DpKt.m5203lerpMdfbLM(this.$topPadding.getValue().m5174unboximpl(), Dp.m5160constructorimpl(0), this.$animationProgress.getValue().floatValue()));
        int iG = AbstractC3871sJ.g(Math.max(Constraints.m5130getMinWidthimpl(j), measureScope.mo327roundToPx0680j_4(SearchBarKt.getSearchBarMinWidth())), Math.min(Constraints.m5128getMaxWidthimpl(j), measureScope.mo327roundToPx0680j_4(SearchBarKt.SearchBarMaxWidth)));
        int iG2 = AbstractC3871sJ.g(Math.max(Constraints.m5129getMinHeightimpl(j), measureScope.mo327roundToPx0680j_4(SearchBarDefaults.INSTANCE.m1733getInputFieldHeightD9Ej5fM())), Constraints.m5127getMaxHeightimpl(j));
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        int iLerp = MathHelpersKt.lerp(iG, iM5128getMaxWidthimpl, this.$animationProgress.getValue().floatValue());
        int iLerp2 = MathHelpersKt.lerp(iG2, iM5127getMaxHeightimpl, this.$animationProgress.getValue().floatValue()) + iMo327roundToPx0680j_4;
        return MeasureScope.CC.q(measureScope, iLerp, iLerp2, null, new AnonymousClass1(measurable.mo4159measureBRTryo0(ConstraintsKt.m5145offsetNN6EwU$default(Constraints.Companion.m5136fixedJhjzzOo(iLerp, iLerp2), 0, -iMo327roundToPx0680j_4, 1, null)), iMo327roundToPx0680j_4), 4, null);
    }
}
