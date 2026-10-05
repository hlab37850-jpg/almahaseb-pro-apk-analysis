package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ InterfaceC3588op $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ InterfaceC3588op $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ long $containerConstraints;
        final /* synthetic */ LazyLayoutMeasureScope $this_null;
        final /* synthetic */ int $totalHorizontalPadding;
        final /* synthetic */ int $totalVerticalPadding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2) {
            super(3);
            this.$this_null = lazyLayoutMeasureScope;
            this.$containerConstraints = j;
            this.$totalHorizontalPadding = i;
            this.$totalVerticalPadding = i2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (InterfaceC3750qp) obj3);
        }

        public final MeasureResult invoke(int i, int i2, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "placement");
            return this.$this_null.layout(ConstraintsKt.m5142constrainWidthK40F9xA(this.$containerConstraints, i + this.$totalHorizontalPadding), ConstraintsKt.m5141constrainHeightK40F9xA(this.$containerConstraints, i2 + this.$totalVerticalPadding), AbstractC4243wx.g(), interfaceC3750qp);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(Orientation orientation, PaddingValues paddingValues, boolean z, PagerState pagerState, float f, PageSize pageSize, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i) {
        super(2);
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$state = pagerState;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = interfaceC3588op;
        this.$pageCount = interfaceC3588op2;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondBoundsPageCount = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m702invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final PagerMeasureResult m702invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        long jIntOffset;
        AbstractC4492zt.h(lazyLayoutMeasureScope, "$this$null");
        Orientation orientation = this.$orientation;
        Orientation orientation2 = Orientation.Vertical;
        boolean z = orientation == orientation2;
        CheckScrollableContainerConstraintsKt.m195checkScrollableContainerConstraintsK40F9xA(j, z ? orientation2 : Orientation.Horizontal);
        int iMo327roundToPx0680j_4 = z ? lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo436calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo327roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_5 = z ? lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo437calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo327roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_6 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo438calculateTopPaddingD9Ej5fM());
        int iMo327roundToPx0680j_7 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo435calculateBottomPaddingD9Ej5fM());
        int i2 = iMo327roundToPx0680j_6 + iMo327roundToPx0680j_7;
        int i3 = iMo327roundToPx0680j_4 + iMo327roundToPx0680j_5;
        int i4 = z ? i2 : i3;
        if (z && !this.$reverseLayout) {
            i = iMo327roundToPx0680j_6;
        } else if (z && this.$reverseLayout) {
            i = iMo327roundToPx0680j_7;
        } else {
            i = (z || this.$reverseLayout) ? iMo327roundToPx0680j_5 : iMo327roundToPx0680j_4;
        }
        int i5 = i4 - i;
        long jM5144offsetNN6EwU = ConstraintsKt.m5144offsetNN6EwU(j, -i3, -i2);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        int iMo327roundToPx0680j_8 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$pageSpacing);
        int iM5127getMaxHeightimpl = z ? Constraints.m5127getMaxHeightimpl(j) - i2 : Constraints.m5128getMaxWidthimpl(j) - i3;
        if (!this.$reverseLayout || iM5127getMaxHeightimpl > 0) {
            jIntOffset = IntOffsetKt.IntOffset(iMo327roundToPx0680j_4, iMo327roundToPx0680j_6);
        } else {
            if (!z) {
                iMo327roundToPx0680j_4 += iM5127getMaxHeightimpl;
            }
            if (z) {
                iMo327roundToPx0680j_6 += iM5127getMaxHeightimpl;
            }
            jIntOffset = IntOffsetKt.IntOffset(iMo327roundToPx0680j_4, iMo327roundToPx0680j_6);
        }
        long j2 = jIntOffset;
        int iCalculateMainAxisPageSize = this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, iM5127getMaxHeightimpl, iMo327roundToPx0680j_8);
        this.$state.m705setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, this.$orientation == orientation2 ? Constraints.m5128getMaxWidthimpl(jM5144offsetNN6EwU) : iCalculateMainAxisPageSize, 0, this.$orientation != orientation2 ? Constraints.m5127getMaxHeightimpl(jM5144offsetNN6EwU) : iCalculateMainAxisPageSize, 5, null));
        Snapshot.Companion companion = Snapshot.Companion;
        PagerState pagerState = this.$state;
        Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                int firstVisiblePage$foundation_release = pagerState.getFirstVisiblePage$foundation_release();
                int iC = AbstractC4492zt.d(pagerState.getLayoutInfo$foundation_release(), PagerStateKt.getEmptyLayoutInfo()) ? AbstractC1210aB.c(pagerState.getInitialPageOffsetFraction() * iCalculateMainAxisPageSize) : pagerState.getFirstVisiblePageOffset$foundation_release();
                FW fw = FW.a;
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                snapshotCreateNonObservableSnapshot.dispose();
                PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider = (PagerLazyLayoutItemProvider) this.$itemProviderLambda.invoke();
                PagerMeasureResult pagerMeasureResultM700measurePagerntgEbfI = PagerMeasureKt.m700measurePagerntgEbfI(lazyLayoutMeasureScope, ((Number) this.$pageCount.invoke()).intValue(), pagerLazyLayoutItemProvider, iM5127getMaxHeightimpl, i, i5, iMo327roundToPx0680j_8, firstVisiblePage$foundation_release, iC, this.$state.getScrollToBeConsumed$foundation_release(), jM5144offsetNN6EwU, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j2, iCalculateMainAxisPageSize, this.$beyondBoundsPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(pagerLazyLayoutItemProvider, this.$state.getPinnedPages$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), new AnonymousClass2(lazyLayoutMeasureScope, j, i3, i2));
                this.$state.applyMeasureResult$foundation_release(pagerMeasureResultM700measurePagerntgEbfI);
                return pagerMeasureResultM700measurePagerntgEbfI;
            } catch (Throwable th) {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            snapshotCreateNonObservableSnapshot.dispose();
            throw th2;
        }
    }
}
