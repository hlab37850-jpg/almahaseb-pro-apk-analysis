package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ InterfaceC3588op $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ InterfaceC0526Fp $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 $measuredLineProvider;
        final /* synthetic */ LazyGridSpanLayoutProvider $spanLayoutProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1) {
            super(1);
            this.$spanLayoutProvider = lazyGridSpanLayoutProvider;
            this.$measuredLineProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final ArrayList<C2020dG> invoke(int i) {
            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.$spanLayoutProvider.getLineConfiguration(i);
            int firstItemIndex = lineConfiguration.getFirstItemIndex();
            ArrayList<C2020dG> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
            List<GridItemSpan> spans = lineConfiguration.getSpans();
            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = this.$measuredLineProvider;
            int size = spans.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iM602getCurrentLineSpanimpl = GridItemSpan.m602getCurrentLineSpanimpl(spans.get(i3).m605unboximpl());
                arrayList.add(HV.a(Integer.valueOf(firstItemIndex), Constraints.m5116boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m623childConstraintsJhjzzOo$foundation_release(i2, iM602getCurrentLineSpanimpl))));
                firstItemIndex++;
                i2 += iM602getCurrentLineSpanimpl;
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ long $containerConstraints;
        final /* synthetic */ LazyLayoutMeasureScope $this_null;
        final /* synthetic */ int $totalHorizontalPadding;
        final /* synthetic */ int $totalVerticalPadding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2) {
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
    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, LazyGridState lazyGridState, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = interfaceC3588op;
        this.$slots = interfaceC0526Fp;
        this.$state = lazyGridState;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m617invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX WARN: Type inference failed for: r32v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider] */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider] */
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyGridMeasureResult m617invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        float fMo405getSpacingD9Ej5fM;
        long jIntOffset;
        int firstVisibleItemScrollOffset;
        int lineIndexOfItem;
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
        long jM5144offsetNN6EwU = ConstraintsKt.m5144offsetNN6EwU(j, -i3, -i2);
        final LazyGridItemProvider lazyGridItemProvider = (LazyGridItemProvider) this.$itemProviderLambda.invoke();
        final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProvider.getSpanLayoutProvider();
        final LazyGridSlots lazyGridSlots = (LazyGridSlots) this.$slots.mo13invoke(lazyLayoutMeasureScope, Constraints.m5116boximpl(j));
        int length = lazyGridSlots.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$state.setSlotsPerLine$foundation_release(length);
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
        final int itemCount = lazyGridItemProvider.getItemCount();
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
        final boolean z4 = this.$reverseLayout;
        final int i6 = i;
        final ?? r32 = new LazyGridMeasuredItemProvider(lazyGridItemProvider, lazyLayoutMeasureScope, iMo327roundToPx0680j_8, z3, z4, i6, i5, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ LazyLayoutMeasureScope $this_null;
            final /* synthetic */ long $visualItemOffset;

            {
                this.$this_null = lazyLayoutMeasureScope;
                this.$isVertical = z3;
                this.$reverseLayout = z4;
                this.$beforeContentPadding = i6;
                this.$afterContentPadding = i5;
                this.$visualItemOffset = j2;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
            public LazyGridMeasuredItem createItem(int i7, Object obj, Object obj2, int i8, int i9, List<? extends Placeable> list) {
                AbstractC4492zt.h(obj, "key");
                AbstractC4492zt.h(list, "placeables");
                return new LazyGridMeasuredItem(i7, obj, this.$isVertical, i8, i9, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, null);
            }
        };
        final boolean z5 = this.$isVertical;
        ?? r9 = new LazyGridMeasuredLineProvider(z5, lazyGridSlots, itemCount, iMo327roundToPx0680j_8, r32, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ LazyGridSlots $resolvedSlots;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(z5, lazyGridSlots, itemCount, iMo327roundToPx0680j_8, r32, spanLayoutProvider);
                this.$isVertical = z5;
                this.$resolvedSlots = lazyGridSlots;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
            public LazyGridMeasuredLine createLine(int i7, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i8) {
                AbstractC4492zt.h(lazyGridMeasuredItemArr, "items");
                AbstractC4492zt.h(list, "spans");
                return new LazyGridMeasuredLine(i7, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i8);
            }
        };
        this.$state.setPrefetchInfoRetriever$foundation_release(new AnonymousClass1(spanLayoutProvider, r9));
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider, lazyGridState.getFirstVisibleItemIndex());
                if (iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release < itemCount || itemCount <= 0) {
                    int lineIndexOfItem2 = spanLayoutProvider.getLineIndexOfItem(iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                    firstVisibleItemScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                    lineIndexOfItem = lineIndexOfItem2;
                } else {
                    lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                    firstVisibleItemScrollOffset = 0;
                }
                FW fw = FW.a;
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                snapshotCreateNonObservableSnapshot.dispose();
                LazyGridMeasureResult lazyGridMeasureResultM618measureLazyGridZRKPzZ8 = LazyGridMeasureKt.m618measureLazyGridZRKPzZ8(itemCount, r9, r32, iM5127getMaxHeightimpl, i, i5, iMo327roundToPx0680j_8, lineIndexOfItem, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), jM5144offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getPlacementAnimator$foundation_release(), spanLayoutProvider, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), new AnonymousClass3(lazyLayoutMeasureScope, j, i3, i2));
                this.$state.applyMeasureResult$foundation_release(lazyGridMeasureResultM618measureLazyGridZRKPzZ8);
                return lazyGridMeasureResultM618measureLazyGridZRKPzZ8;
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
