package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridDslKt$rememberRowSlots$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ StaggeredGridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$rememberRowSlots$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = staggeredGridCells;
        this.$verticalArrangement = vertical;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m656invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyStaggeredGridSlots m656invoke0kLqBqw(Density density, long j) {
        AbstractC4492zt.h(density, "$this$$receiver");
        if (Constraints.m5127getMaxHeightimpl(j) == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.");
        }
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j) - density.mo327roundToPx0680j_4(Dp.m5160constructorimpl(this.$contentPadding.mo438calculateTopPaddingD9Ej5fM() + this.$contentPadding.mo435calculateBottomPaddingD9Ej5fM()));
        StaggeredGridCells staggeredGridCells = this.$rows;
        Arrangement.Vertical vertical = this.$verticalArrangement;
        int[] iArrCalculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, iM5127getMaxHeightimpl, density.mo327roundToPx0680j_4(vertical.mo405getSpacingD9Ej5fM()));
        int[] iArr = new int[iArrCalculateCrossAxisCellSizes.length];
        vertical.arrange(density, iM5127getMaxHeightimpl, iArrCalculateCrossAxisCellSizes, iArr);
        return new LazyStaggeredGridSlots(iArr, iArrCalculateCrossAxisCellSizes);
    }
}
