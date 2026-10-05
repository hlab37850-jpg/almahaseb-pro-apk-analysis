package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridDslKt$rememberRowHeightSums$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ GridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = gridCells;
        this.$verticalArrangement = vertical;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m612invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyGridSlots m612invoke0kLqBqw(Density density, long j) {
        AbstractC4492zt.h(density, "$this$$receiver");
        if (Constraints.m5127getMaxHeightimpl(j) == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
        }
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j) - density.mo327roundToPx0680j_4(Dp.m5160constructorimpl(this.$contentPadding.mo438calculateTopPaddingD9Ej5fM() + this.$contentPadding.mo435calculateBottomPaddingD9Ej5fM()));
        GridCells gridCells = this.$rows;
        Arrangement.Vertical vertical = this.$verticalArrangement;
        int[] iArrB0 = AbstractC3240kc.B0(gridCells.calculateCrossAxisCellSizes(density, iM5127getMaxHeightimpl, density.mo327roundToPx0680j_4(vertical.mo405getSpacingD9Ej5fM())));
        int[] iArr = new int[iArrB0.length];
        vertical.arrange(density, iM5127getMaxHeightimpl, iArrB0, iArr);
        return new LazyGridSlots(iArrB0, iArr);
    }
}
