package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridSlots {
    private final int[] positions;
    private final int[] sizes;

    public LazyStaggeredGridSlots(int[] iArr, int[] iArr2) {
        AbstractC4492zt.h(iArr, "positions");
        AbstractC4492zt.h(iArr2, "sizes");
        this.positions = iArr;
        this.sizes = iArr2;
    }

    public final int[] getPositions() {
        return this.positions;
    }

    public final int[] getSizes() {
        return this.sizes;
    }
}
