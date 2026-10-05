package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridDslKt$rememberColumnWidthSums$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ GridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = gridCells;
        this.$horizontalArrangement = horizontal;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m611invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyGridSlots m611invoke0kLqBqw(Density density, long j) {
        AbstractC4492zt.h(density, "$this$$receiver");
        if (Constraints.m5128getMaxWidthimpl(j) == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
        }
        PaddingValues paddingValues = this.$contentPadding;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j) - density.mo327roundToPx0680j_4(Dp.m5160constructorimpl(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) + PaddingKt.calculateEndPadding(this.$contentPadding, layoutDirection)));
        GridCells gridCells = this.$columns;
        Arrangement.Horizontal horizontal = this.$horizontalArrangement;
        int[] iArrB0 = AbstractC3240kc.B0(gridCells.calculateCrossAxisCellSizes(density, iM5128getMaxWidthimpl, density.mo327roundToPx0680j_4(horizontal.mo405getSpacingD9Ej5fM())));
        int[] iArr = new int[iArrB0.length];
        horizontal.arrange(density, iM5128getMaxWidthimpl, iArrB0, layoutDirection, iArr);
        return new LazyGridSlots(iArrB0, iArr);
    }
}
