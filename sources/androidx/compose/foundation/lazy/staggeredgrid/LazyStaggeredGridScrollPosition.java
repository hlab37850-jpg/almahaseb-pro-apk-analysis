package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.R5;
import defpackage.TQ;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyStaggeredGridScrollPosition implements SnapshotMutationPolicy<int[]> {
    private final InterfaceC0526Fp fillIndices;
    private boolean hadFirstNotEmptyLayout;
    private final MutableState indices$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableState offsets$delegate;

    public LazyStaggeredGridScrollPosition(int[] iArr, int[] iArr2, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(iArr, "initialIndices");
        AbstractC4492zt.h(iArr2, "initialOffsets");
        AbstractC4492zt.h(interfaceC0526Fp, "fillIndices");
        this.fillIndices = interfaceC0526Fp;
        this.indices$delegate = SnapshotStateKt.mutableStateOf(iArr, this);
        this.offsets$delegate = SnapshotStateKt.mutableStateOf(iArr2, this);
        Integer numB0 = R5.b0(iArr);
        this.nearestRangeState = new LazyLayoutNearestRangeState(numB0 != null ? numB0.intValue() : 0, 90, 200);
    }

    private final void setIndices(int[] iArr) {
        this.indices$delegate.setValue(iArr);
    }

    private final void setOffsets(int[] iArr) {
        this.offsets$delegate.setValue(iArr);
    }

    private final void update(int[] iArr, int[] iArr2) {
        setIndices(iArr);
        setOffsets(iArr2);
    }

    public final int[] getIndices() {
        return (int[]) this.indices$delegate.getValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int[] getOffsets() {
        return (int[]) this.offsets$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [int[], java.lang.Object] */
    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public /* synthetic */ int[] merge(int[] iArr, int[] iArr2, int[] iArr3) {
        return TQ.a(this, iArr, iArr2, iArr3);
    }

    public final void requestPosition(int i, int i2) {
        int[] iArr = (int[]) this.fillIndices.mo13invoke(Integer.valueOf(i), Integer.valueOf(getIndices().length));
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = i2;
        }
        update(iArr, iArr2);
        this.nearestRangeState.update(i);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateFromMeasureResult(LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        AbstractC4492zt.h(lazyStaggeredGridMeasureResult, "measureResult");
        int[] firstVisibleItemIndices = lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices();
        if (firstVisibleItemIndices.length == 0) {
            throw new NoSuchElementException();
        }
        int i = 0;
        int i2 = firstVisibleItemIndices[0];
        int iN = R5.N(firstVisibleItemIndices);
        if (iN != 0) {
            int i3 = i2 == -1 ? Integer.MAX_VALUE : i2;
            AbstractC0919Ss it = new C1001Vs(1, iN).iterator();
            while (it.hasNext()) {
                int i4 = firstVisibleItemIndices[it.nextInt()];
                int i5 = i4 == -1 ? Integer.MAX_VALUE : i4;
                if (i3 > i5) {
                    i2 = i4;
                    i3 = i5;
                }
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            i2 = 0;
        }
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureResult.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        while (true) {
            if (i >= size) {
                lazyStaggeredGridItemInfo = null;
                break;
            }
            lazyStaggeredGridItemInfo = visibleItemsInfo.get(i);
            if (lazyStaggeredGridItemInfo.getIndex() == i2) {
                break;
            } else {
                i++;
            }
        }
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo;
        this.lastKnownFirstItemKey = lazyStaggeredGridItemInfo2 != null ? lazyStaggeredGridItemInfo2.getKey() : null;
        this.nearestRangeState.update(i2);
        if (this.hadFirstNotEmptyLayout || lazyStaggeredGridMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    update(lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices(), lazyStaggeredGridMeasureResult.getFirstVisibleItemScrollOffsets());
                    FW fw = FW.a;
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
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

    @ExperimentalFoundationApi
    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr) {
        AbstractC4492zt.h(lazyLayoutItemProvider, "itemProvider");
        AbstractC4492zt.h(iArr, "indices");
        Object obj = this.lastKnownFirstItemKey;
        Integer numP = R5.P(iArr, 0);
        int iFindIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, obj, numP != null ? numP.intValue() : 0);
        if (R5.D(iArr, iFindIndexByKey)) {
            return iArr;
        }
        this.nearestRangeState.update(iFindIndexByKey);
        int[] iArr2 = (int[]) this.fillIndices.mo13invoke(Integer.valueOf(iFindIndexByKey), Integer.valueOf(iArr.length));
        setIndices(iArr2);
        return iArr2;
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(int[] iArr, int[] iArr2) {
        AbstractC4492zt.h(iArr, "a");
        AbstractC4492zt.h(iArr2, "b");
        return Arrays.equals(iArr, iArr2);
    }
}
