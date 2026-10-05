package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridDslKt$rememberColumnSlots$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ StaggeredGridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$rememberColumnSlots$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = staggeredGridCells;
        this.$horizontalArrangement = horizontal;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m655invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyStaggeredGridSlots m655invoke0kLqBqw(Density density, long j) {
        AbstractC4492zt.h(density, "$this$$receiver");
        if (Constraints.m5128getMaxWidthimpl(j) == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.");
        }
        PaddingValues paddingValues = this.$contentPadding;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j) - density.mo327roundToPx0680j_4(Dp.m5160constructorimpl(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) + PaddingKt.calculateEndPadding(this.$contentPadding, layoutDirection)));
        StaggeredGridCells staggeredGridCells = this.$columns;
        Arrangement.Horizontal horizontal = this.$horizontalArrangement;
        int[] iArrCalculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, iM5128getMaxWidthimpl, density.mo327roundToPx0680j_4(horizontal.mo405getSpacingD9Ej5fM()));
        int[] iArr = new int[iArrCalculateCrossAxisCellSizes.length];
        horizontal.arrange(density, iM5128getMaxWidthimpl, iArrCalculateCrossAxisCellSizes, layoutDirection, iArr);
        return new LazyStaggeredGridSlots(iArr, iArrCalculateCrossAxisCellSizes);
    }
}
