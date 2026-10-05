package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    public /* synthetic */ FixedDpInsets(float f, float f2, float f3, float f4, AbstractC0419Di abstractC0419Di) {
        this(f, f2, f3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        return Dp.m5165equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && Dp.m5165equalsimpl0(this.topDp, fixedDpInsets.topDp) && Dp.m5165equalsimpl0(this.rightDp, fixedDpInsets.rightDp) && Dp.m5165equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        AbstractC4492zt.h(density, "density");
        return density.mo327roundToPx0680j_4(this.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return density.mo327roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return density.mo327roundToPx0680j_4(this.rightDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        AbstractC4492zt.h(density, "density");
        return density.mo327roundToPx0680j_4(this.topDp);
    }

    public int hashCode() {
        return (((((Dp.m5166hashCodeimpl(this.leftDp) * 31) + Dp.m5166hashCodeimpl(this.topDp)) * 31) + Dp.m5166hashCodeimpl(this.rightDp)) * 31) + Dp.m5166hashCodeimpl(this.bottomDp);
    }

    public String toString() {
        return "Insets(left=" + ((Object) Dp.m5171toStringimpl(this.leftDp)) + ", top=" + ((Object) Dp.m5171toStringimpl(this.topDp)) + ", right=" + ((Object) Dp.m5171toStringimpl(this.rightDp)) + ", bottom=" + ((Object) Dp.m5171toStringimpl(this.bottomDp)) + ')';
    }

    private FixedDpInsets(float f, float f2, float f3, float f4) {
        this.leftDp = f;
        this.topDp = f2;
        this.rightDp = f3;
        this.bottomDp = f4;
    }
}
