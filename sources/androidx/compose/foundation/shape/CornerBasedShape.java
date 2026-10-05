package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public CornerBasedShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        AbstractC4492zt.h(cornerSize, "topStart");
        AbstractC4492zt.h(cornerSize2, "topEnd");
        AbstractC4492zt.h(cornerSize3, "bottomEnd");
        AbstractC4492zt.h(cornerSize4, "bottomStart");
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public final CornerBasedShape copy(CornerSize cornerSize) {
        AbstractC4492zt.h(cornerSize, "all");
        return copy(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    public abstract CornerBasedShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4);

    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo720createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection);

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo216createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        float fMo728toPxTmRCtEA = this.topStart.mo728toPxTmRCtEA(j, density);
        float fMo728toPxTmRCtEA2 = this.topEnd.mo728toPxTmRCtEA(j, density);
        float fMo728toPxTmRCtEA3 = this.bottomEnd.mo728toPxTmRCtEA(j, density);
        float fMo728toPxTmRCtEA4 = this.bottomStart.mo728toPxTmRCtEA(j, density);
        float fM2866getMinDimensionimpl = Size.m2866getMinDimensionimpl(j);
        float f = fMo728toPxTmRCtEA + fMo728toPxTmRCtEA4;
        if (f > fM2866getMinDimensionimpl) {
            float f2 = fM2866getMinDimensionimpl / f;
            fMo728toPxTmRCtEA *= f2;
            fMo728toPxTmRCtEA4 *= f2;
        }
        float f3 = fMo728toPxTmRCtEA4;
        float f4 = fMo728toPxTmRCtEA2 + fMo728toPxTmRCtEA3;
        if (f4 > fM2866getMinDimensionimpl) {
            float f5 = fM2866getMinDimensionimpl / f4;
            fMo728toPxTmRCtEA2 *= f5;
            fMo728toPxTmRCtEA3 *= f5;
        }
        if (fMo728toPxTmRCtEA >= 0.0f && fMo728toPxTmRCtEA2 >= 0.0f && fMo728toPxTmRCtEA3 >= 0.0f && f3 >= 0.0f) {
            return mo720createOutlineLjSzlW0(j, fMo728toPxTmRCtEA, fMo728toPxTmRCtEA2, fMo728toPxTmRCtEA3, f3, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fMo728toPxTmRCtEA + ", topEnd = " + fMo728toPxTmRCtEA2 + ", bottomEnd = " + fMo728toPxTmRCtEA3 + ", bottomStart = " + f3 + ")!").toString());
    }

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }
}
