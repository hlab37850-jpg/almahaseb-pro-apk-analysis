package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class PaddingValuesInsets implements WindowInsets {
    private final PaddingValues paddingValues;

    public PaddingValuesInsets(PaddingValues paddingValues) {
        AbstractC4492zt.h(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaddingValuesInsets) {
            return AbstractC4492zt.d(((PaddingValuesInsets) obj).paddingValues, this.paddingValues);
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        AbstractC4492zt.h(density, "density");
        return density.mo327roundToPx0680j_4(this.paddingValues.mo435calculateBottomPaddingD9Ej5fM());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return density.mo327roundToPx0680j_4(this.paddingValues.mo436calculateLeftPaddingu2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return density.mo327roundToPx0680j_4(this.paddingValues.mo437calculateRightPaddingu2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        AbstractC4492zt.h(density, "density");
        return density.mo327roundToPx0680j_4(this.paddingValues.mo438calculateTopPaddingD9Ej5fM());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return "PaddingValues(" + ((Object) Dp.m5171toStringimpl(this.paddingValues.mo436calculateLeftPaddingu2uoSUM(layoutDirection))) + ", " + ((Object) Dp.m5171toStringimpl(this.paddingValues.mo438calculateTopPaddingD9Ej5fM())) + ", " + ((Object) Dp.m5171toStringimpl(this.paddingValues.mo437calculateRightPaddingu2uoSUM(layoutDirection))) + ", " + ((Object) Dp.m5171toStringimpl(this.paddingValues.mo435calculateBottomPaddingD9Ej5fM())) + ')';
    }
}
