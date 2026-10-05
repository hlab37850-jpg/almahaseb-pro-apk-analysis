package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSnapLayoutInfoProviderKt {
    @ExperimentalFoundationApi
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final LazyGridState lazyGridState, final SnapPositionInLayout snapPositionInLayout) {
        AbstractC4492zt.h(lazyGridState, "lazyGridState");
        AbstractC4492zt.h(snapPositionInLayout, "positionInLayout");
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1
            private final LazyGridLayoutInfo getLayoutInfo() {
                return lazyGridState.getLayoutInfo();
            }

            /* JADX WARN: Code duplicated, block: B:11:0x003c  */
            private final List<LazyGridItemInfo> getSingleAxisItems() {
                List<LazyGridItemInfo> visibleItemsInfo = lazyGridState.getLayoutInfo().getVisibleItemsInfo();
                LazyGridState lazyGridState2 = lazyGridState;
                ArrayList arrayList = new ArrayList(visibleItemsInfo.size());
                int size = visibleItemsInfo.size();
                for (int i = 0; i < size; i++) {
                    LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
                    LazyGridItemInfo lazyGridItemInfo2 = lazyGridItemInfo;
                    if (lazyGridState2.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
                        if (lazyGridItemInfo2.getRow() == 0) {
                            arrayList.add(lazyGridItemInfo);
                        }
                    } else if (lazyGridItemInfo2.getColumn() == 0) {
                        arrayList.add(lazyGridItemInfo);
                    }
                }
                return arrayList;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(Density density, float f) {
                AbstractC4492zt.h(density, "<this>");
                float fC = AbstractC3871sJ.c(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay(density), 0.0f, f)) - calculateSnapStepSize(density), 0.0f);
                return fC == 0.0f ? fC : fC * Math.signum(f);
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapStepSize(Density density) {
                int iM5320getWidthimpl;
                AbstractC4492zt.h(density, "<this>");
                if (getSingleAxisItems().isEmpty()) {
                    return 0.0f;
                }
                int i = 0;
                if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
                    List<LazyGridItemInfo> singleAxisItems = getSingleAxisItems();
                    int size = singleAxisItems.size();
                    iM5320getWidthimpl = 0;
                    while (i < size) {
                        iM5320getWidthimpl += IntSize.m5319getHeightimpl(singleAxisItems.get(i).mo616getSizeYbymL2g());
                        i++;
                    }
                } else {
                    List<LazyGridItemInfo> singleAxisItems2 = getSingleAxisItems();
                    int size2 = singleAxisItems2.size();
                    iM5320getWidthimpl = 0;
                    while (i < size2) {
                        iM5320getWidthimpl += IntSize.m5320getWidthimpl(singleAxisItems2.get(i).mo616getSizeYbymL2g());
                        i++;
                    }
                }
                return iM5320getWidthimpl / getSingleAxisItems().size();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnappingOffset(Density density, float f) {
                AbstractC4492zt.h(density, "<this>");
                List<LazyGridItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
                SnapPositionInLayout snapPositionInLayout2 = snapPositionInLayout;
                int size = visibleItemsInfo.size();
                float f2 = Float.NEGATIVE_INFINITY;
                float f3 = Float.POSITIVE_INFINITY;
                for (int i = 0; i < size; i++) {
                    LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(density, LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), lazyGridItemInfo.getIndex(), snapPositionInLayout2);
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f2) {
                        f2 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f3) {
                        f3 = fCalculateDistanceToDesiredSnapPosition;
                    }
                }
                return SnapFlingBehaviorKt.calculateFinalOffset(f, f2, f3);
            }
        };
    }

    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState lazyGridState, SnapPositionInLayout snapPositionInLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            snapPositionInLayout = SnapPositionInLayout.Companion.getCenterToCenter();
        }
        return SnapLayoutInfoProvider(lazyGridState, snapPositionInLayout);
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        AbstractC4492zt.h(lazyGridLayoutInfo, "<this>");
        return lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m5319getHeightimpl(lazyGridLayoutInfo.mo597getViewportSizeYbymL2g()) : IntSize.m5320getWidthimpl(lazyGridLayoutInfo.mo597getViewportSizeYbymL2g());
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        AbstractC4492zt.h(lazyGridItemInfo, "<this>");
        AbstractC4492zt.h(orientation, "orientation");
        return orientation == Orientation.Vertical ? IntOffset.m5279getYimpl(lazyGridItemInfo.mo615getOffsetnOccac()) : IntOffset.m5278getXimpl(lazyGridItemInfo.mo615getOffsetnOccac());
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        AbstractC4492zt.h(lazyGridItemInfo, "<this>");
        AbstractC4492zt.h(orientation, "orientation");
        return orientation == Orientation.Vertical ? IntSize.m5319getHeightimpl(lazyGridItemInfo.mo616getSizeYbymL2g()) : IntSize.m5320getWidthimpl(lazyGridItemInfo.mo616getSizeYbymL2g());
    }
}
