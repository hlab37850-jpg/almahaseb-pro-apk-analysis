package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.Q5;
import defpackage.Y4;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridLaneInfo {
    public static final Companion Companion = new Companion(null);
    public static final int FullSpan = -2;
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;
    private int[] lanes = new int[16];
    private final Y4 spannedItems = new Y4();

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public static final class SpannedItem {
        private int[] gaps;
        private final int index;

        public SpannedItem(int i, int[] iArr) {
            AbstractC4492zt.h(iArr, "gaps");
            this.index = i;
            this.gaps = iArr;
        }

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] iArr) {
            AbstractC4492zt.h(iArr, "<set-?>");
            this.gaps = iArr;
        }
    }

    private final void ensureCapacity(int i, int i2) {
        if (i > 131072) {
            throw new IllegalArgumentException(("Requested item capacity " + i + " is larger than max supported: 131072!").toString());
        }
        int[] iArr = this.lanes;
        if (iArr.length < i) {
            int length = iArr.length;
            while (length < i) {
                length *= 2;
            }
            this.lanes = Q5.l(this.lanes, new int[length], i2, 0, 0, 12, null);
        }
    }

    public static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyStaggeredGridLaneInfo.ensureCapacity(i, i2);
    }

    public final boolean assignedToLane(int i, int i2) {
        int lane = getLane(i);
        return lane == i2 || lane == -1 || lane == -2;
    }

    public final void ensureValidIndex(int i) {
        int i2 = this.anchor;
        int i3 = i - i2;
        if (i3 < 0 || i3 >= 131072) {
            int iMax = Math.max(i - (this.lanes.length / 2), 0);
            this.anchor = iMax;
            int i4 = iMax - i2;
            if (i4 >= 0) {
                int[] iArr = this.lanes;
                if (i4 < iArr.length) {
                    Q5.g(iArr, iArr, 0, i4, iArr.length);
                }
                int[] iArr2 = this.lanes;
                Q5.q(iArr2, 0, Math.max(0, iArr2.length - i4), this.lanes.length);
            } else {
                int i5 = -i4;
                int[] iArr3 = this.lanes;
                if (iArr3.length + i5 < 131072) {
                    ensureCapacity(iArr3.length + i5 + 1, i5);
                } else {
                    if (i5 < iArr3.length) {
                        Q5.g(iArr3, iArr3, i5, 0, iArr3.length - i5);
                    }
                    int[] iArr4 = this.lanes;
                    Q5.q(iArr4, 0, 0, Math.min(iArr4.length, i5));
                }
            }
        } else {
            ensureCapacity$default(this, i3 + 1, 0, 2, null);
        }
        while (!this.spannedItems.isEmpty() && ((SpannedItem) this.spannedItems.first()).getIndex() < lowerBound()) {
            this.spannedItems.removeFirst();
        }
        while (!this.spannedItems.isEmpty() && ((SpannedItem) this.spannedItems.last()).getIndex() > upperBound()) {
            this.spannedItems.removeLast();
        }
    }

    public final int findNextItemIndex(int i, int i2) {
        int iUpperBound = upperBound();
        for (int i3 = i + 1; i3 < iUpperBound; i3++) {
            if (assignedToLane(i3, i2)) {
                return i3;
            }
        }
        return upperBound();
    }

    public final int findPreviousItemIndex(int i, int i2) {
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!assignedToLane(i, i2));
        return i;
    }

    public final int[] getGaps(int i) {
        Y4 y4 = this.spannedItems;
        SpannedItem spannedItem = (SpannedItem) AbstractC3240kc.e0(this.spannedItems, AbstractC1886cc.i(y4, 0, y4.size(), new LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1(Integer.valueOf(i))));
        if (spannedItem != null) {
            return spannedItem.getGaps();
        }
        return null;
    }

    public final int getLane(int i) {
        if (i < lowerBound() || i >= upperBound()) {
            return -1;
        }
        return this.lanes[i - this.anchor] - 1;
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void reset() {
        Q5.t(this.lanes, 0, 0, 0, 6, null);
        this.spannedItems.clear();
    }

    public final void setGaps(int i, int[] iArr) {
        Y4 y4 = this.spannedItems;
        int i2 = AbstractC1886cc.i(y4, 0, y4.size(), new LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1(Integer.valueOf(i)));
        if (i2 < 0) {
            if (iArr == null) {
                return;
            }
            this.spannedItems.add(-(i2 + 1), new SpannedItem(i, iArr));
            return;
        }
        if (iArr == null) {
            this.spannedItems.remove(i2);
        } else {
            ((SpannedItem) this.spannedItems.get(i2)).setGaps(iArr);
        }
    }

    public final void setLane(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative lanes are not supported");
        }
        ensureValidIndex(i);
        this.lanes[i - this.anchor] = i2 + 1;
    }

    public final int upperBound() {
        return this.anchor + this.lanes.length;
    }
}
