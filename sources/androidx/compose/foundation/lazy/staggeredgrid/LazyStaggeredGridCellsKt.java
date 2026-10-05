package androidx.compose.foundation.lazy.staggeredgrid;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridCellsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        int[] iArr = new int[i2];
        int i7 = 0;
        while (i7 < i2) {
            iArr[i7] = (i7 < i6 ? 1 : 0) + i5;
            i7++;
        }
        return iArr;
    }
}
