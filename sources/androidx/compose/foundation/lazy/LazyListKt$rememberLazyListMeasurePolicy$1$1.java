package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ InterfaceC3588op $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$2, reason: invalid class name */
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
    public LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyListState lazyListState, InterfaceC3588op interfaceC3588op, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyListState;
        this.$itemProviderLambda = interfaceC3588op;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m588invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyListMeasureResult m588invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        float fMo405getSpacingD9Ej5fM;
        long jIntOffset;
        AbstractC4492zt.h(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m195checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        int iMo327roundToPx0680j_4 = this.$isVertical ? lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo436calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo327roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_5 = this.$isVertical ? lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo437calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo327roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo327roundToPx0680j_6 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo438calculateTopPaddingD9Ej5fM());
        int iMo327roundToPx0680j_7 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(this.$contentPadding.mo435calculateBottomPaddingD9Ej5fM());
        int i2 = iMo327roundToPx0680j_6 + iMo327roundToPx0680j_7;
        int i3 = iMo327roundToPx0680j_4 + iMo327roundToPx0680j_5;
        boolean z = this.$isVertical;
        int i4 = z ? i2 : i3;
        if (z && !this.$reverseLayout) {
            i = iMo327roundToPx0680j_6;
        } else if (z && this.$reverseLayout) {
            i = iMo327roundToPx0680j_7;
        } else {
            i = (z || this.$reverseLayout) ? iMo327roundToPx0680j_5 : iMo327roundToPx0680j_4;
        }
        final int i5 = i4 - i;
        final long jM5144offsetNN6EwU = ConstraintsKt.m5144offsetNN6EwU(j, -i3, -i2);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        final LazyListItemProvider lazyListItemProvider = (LazyListItemProvider) this.$itemProviderLambda.invoke();
        lazyListItemProvider.getItemScope().setMaxSize(Constraints.m5128getMaxWidthimpl(jM5144offsetNN6EwU), Constraints.m5127getMaxHeightimpl(jM5144offsetNN6EwU));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            fMo405getSpacingD9Ej5fM = vertical.mo405getSpacingD9Ej5fM();
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            fMo405getSpacingD9Ej5fM = horizontal.mo405getSpacingD9Ej5fM();
        }
        final int iMo327roundToPx0680j_8 = lazyLayoutMeasureScope.mo327roundToPx0680j_4(fMo405getSpacingD9Ej5fM);
        final int itemCount = lazyListItemProvider.getItemCount();
        int iM5127getMaxHeightimpl = this.$isVertical ? Constraints.m5127getMaxHeightimpl(j) - i2 : Constraints.m5128getMaxWidthimpl(j) - i3;
        if (!this.$reverseLayout || iM5127getMaxHeightimpl > 0) {
            jIntOffset = IntOffsetKt.IntOffset(iMo327roundToPx0680j_4, iMo327roundToPx0680j_6);
        } else {
            boolean z2 = this.$isVertical;
            if (!z2) {
                iMo327roundToPx0680j_4 += iM5127getMaxHeightimpl;
            }
            if (z2) {
                iMo327roundToPx0680j_6 += iM5127getMaxHeightimpl;
            }
            jIntOffset = IntOffsetKt.IntOffset(iMo327roundToPx0680j_4, iMo327roundToPx0680j_6);
        }
        final long j2 = jIntOffset;
        final boolean z3 = this.$isVertical;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z4 = this.$reverseLayout;
        final int i6 = i;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(jM5144offsetNN6EwU, z3, lazyListItemProvider, lazyLayoutMeasureScope, itemCount, iMo327roundToPx0680j_8, horizontal2, vertical2, z4, i6, i5, j2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ int $itemsCount;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ int $spaceBetweenItems;
            final /* synthetic */ LazyLayoutMeasureScope $this_null;
            final /* synthetic */ Alignment.Vertical $verticalAlignment;
            final /* synthetic */ long $visualItemOffset;

            {
                this.$isVertical = z3;
                this.$this_null = lazyLayoutMeasureScope;
                this.$itemsCount = itemCount;
                this.$spaceBetweenItems = iMo327roundToPx0680j_8;
                this.$horizontalAlignment = horizontal2;
                this.$verticalAlignment = vertical2;
                this.$reverseLayout = z4;
                this.$beforeContentPadding = i6;
                this.$afterContentPadding = i5;
                this.$visualItemOffset = j2;
            }

            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
            public LazyListMeasuredItem createItem(int i7, Object obj, Object obj2, List<? extends Placeable> list) {
                AbstractC4492zt.h(obj, "key");
                AbstractC4492zt.h(list, "placeables");
                return new LazyListMeasuredItem(i7, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i7 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj, obj2, null);
            }
        };
        this.$state.m596setPremeasureConstraintsBRTryo0$foundation_release(lazyListMeasuredItemProvider.m594getChildConstraintsmsEJaDk());
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider, lazyListState.getFirstVisibleItemIndex());
                int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                FW fw = FW.a;
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                snapshotCreateNonObservableSnapshot.dispose();
                LazyListMeasureResult lazyListMeasureResultM590measureLazyListCD5nmq0 = LazyListMeasureKt.m590measureLazyListCD5nmq0(itemCount, lazyListMeasuredItemProvider, iM5127getMaxHeightimpl, i, i5, iMo327roundToPx0680j_8, iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), jM5144offsetNN6EwU, this.$isVertical, lazyListItemProvider.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getPlacementAnimator$foundation_release(), this.$beyondBoundsItemCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), new AnonymousClass2(lazyLayoutMeasureScope, j, i3, i2));
                this.$state.applyMeasureResult$foundation_release(lazyListMeasureResultM590measureLazyListCD5nmq0);
                return lazyListMeasureResultM590measureLazyListCD5nmq0;
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
