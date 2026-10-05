package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface StaggeredGridCells {

    @StabilityInferred(parameters = 0)
    public static final class Adaptive implements StaggeredGridCells {
        public static final int $stable = 0;
        private final float minSize;

        public /* synthetic */ Adaptive(float f, AbstractC0419Di abstractC0419Di) {
            this(f);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] calculateCrossAxisCellSizes(Density density, int i, int i2) {
            AbstractC4492zt.h(density, "<this>");
            return LazyStaggeredGridCellsKt.calculateCellsCrossAxisSizeImpl(i, Math.max((i + i2) / (density.mo327roundToPx0680j_4(this.minSize) + i2), 1), i2);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Adaptive) && Dp.m5165equalsimpl0(this.minSize, ((Adaptive) obj).minSize);
        }

        public int hashCode() {
            return Dp.m5166hashCodeimpl(this.minSize);
        }

        private Adaptive(float f) {
            this.minSize = f;
            if (Dp.m5159compareTo0680j_4(f, Dp.m5160constructorimpl(0)) <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class Fixed implements StaggeredGridCells {
        public static final int $stable = 0;
        private final int count;

        public Fixed(int i) {
            this.count = i;
            if (i <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] calculateCrossAxisCellSizes(Density density, int i, int i2) {
            AbstractC4492zt.h(density, "<this>");
            return LazyStaggeredGridCellsKt.calculateCellsCrossAxisSizeImpl(i, this.count, i2);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Fixed) && this.count == ((Fixed) obj).count;
        }

        public int hashCode() {
            return -this.count;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class FixedSize implements StaggeredGridCells {
        public static final int $stable = 0;
        private final float size;

        public /* synthetic */ FixedSize(float f, AbstractC0419Di abstractC0419Di) {
            this(f);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] calculateCrossAxisCellSizes(Density density, int i, int i2) {
            AbstractC4492zt.h(density, "<this>");
            int iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(this.size);
            int i3 = iMo327roundToPx0680j_4 + i2;
            int i4 = i2 + i;
            if (i3 >= i4) {
                return new int[]{i};
            }
            int i5 = i4 / i3;
            int[] iArr = new int[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                iArr[i6] = iMo327roundToPx0680j_4;
            }
            return iArr;
        }

        public boolean equals(Object obj) {
            return (obj instanceof FixedSize) && Dp.m5165equalsimpl0(this.size, ((FixedSize) obj).size);
        }

        public int hashCode() {
            return Dp.m5166hashCodeimpl(this.size);
        }

        private FixedSize(float f) {
            this.size = f;
        }
    }

    int[] calculateCrossAxisCellSizes(Density density, int i, int i2);
}
