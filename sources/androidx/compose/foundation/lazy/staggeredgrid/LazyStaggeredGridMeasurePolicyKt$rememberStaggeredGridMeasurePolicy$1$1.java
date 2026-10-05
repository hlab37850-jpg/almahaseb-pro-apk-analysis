package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ InterfaceC3588op $itemProviderLambda;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ InterfaceC0526Fp $slots;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(Orientation orientation, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f) {
        super(2);
        this.$orientation = orientation;
        this.$slots = interfaceC0526Fp;
        this.$itemProviderLambda = interfaceC3588op;
        this.$state = lazyStaggeredGridState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$mainAxisSpacing = f;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m669invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m669invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        AbstractC4492zt.h(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m195checkScrollableContainerConstraintsK40F9xA(j, this.$orientation);
        LazyStaggeredGridSlots lazyStaggeredGridSlots = (LazyStaggeredGridSlots) this.$slots.mo13invoke(lazyLayoutMeasureScope, Constraints.m5116boximpl(j));
        boolean z = this.$orientation == Orientation.Vertical;
        LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider = (LazyStaggeredGridItemProvider) this.$itemProviderLambda.invoke();
        this.$state.setSlots$foundation_release(lazyStaggeredGridSlots);
        this.$state.setVertical$foundation_release(z);
        this.$state.setSpanProvider$foundation_release(lazyStaggeredGridItemProvider.getSpanProvider());
        int iMo327roundToPx0680j_4 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_5 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_6 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.$contentPadding, this.$orientation, lazyLayoutMeasureScope.getLayoutDirection()));
        int iM5127getMaxHeightimpl = ((z ? Constraints.m5127getMaxHeightimpl(j) : Constraints.m5128getMaxWidthimpl(j)) - iMo327roundToPx0680j_4) - iMo327roundToPx0680j_5;
        long jIntOffset = z ? IntOffsetKt.IntOffset(iMo327roundToPx0680j_6, iMo327roundToPx0680j_4) : IntOffsetKt.IntOffset(iMo327roundToPx0680j_4, iMo327roundToPx0680j_6);
        PaddingValues paddingValues = this.$contentPadding;
        int iMo327roundToPx0680j_7 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection())));
        PaddingValues paddingValues2 = this.$contentPadding;
        boolean z2 = z;
        LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultM667measureStaggeredGriddSVRQoE = LazyStaggeredGridMeasureKt.m667measureStaggeredGriddSVRQoE(lazyLayoutMeasureScope, this.$state, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, Constraints.m5119copyZbe2FdA$default(j, ConstraintsKt.m5142constrainWidthK40F9xA(j, iMo327roundToPx0680j_7), 0, ConstraintsKt.m5141constrainHeightK40F9xA(j, lazyLayoutMeasureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl(paddingValues2.mo438calculateTopPaddingD9Ej5fM() + paddingValues2.mo435calculateBottomPaddingD9Ej5fM()))), 0, 10, null), z2, this.$reverseLayout, jIntOffset, iM5127getMaxHeightimpl, lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$mainAxisSpacing), iMo327roundToPx0680j_4, iMo327roundToPx0680j_5);
        this.$state.applyMeasureResult$foundation_release(lazyStaggeredGridMeasureResultM667measureStaggeredGriddSVRQoE);
        return lazyStaggeredGridMeasureResultM667measureStaggeredGriddSVRQoE;
    }
}
