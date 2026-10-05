package androidx.compose.foundation.lazy.grid;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSlots {
    private final int[] positions;
    private final int[] sizes;

    public LazyGridSlots(int[] iArr, int[] iArr2) {
        AbstractC4492zt.h(iArr, "sizes");
        AbstractC4492zt.h(iArr2, "positions");
        this.sizes = iArr;
        this.positions = iArr2;
    }

    public final int[] getPositions() {
        return this.positions;
    }

    public final int[] getSizes() {
        return this.sizes;
    }
}
