package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AbsoluteRoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsoluteRoundedCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        AbstractC4492zt.h(cornerSize, "topLeft");
        AbstractC4492zt.h(cornerSize2, "topRight");
        AbstractC4492zt.h(cornerSize3, "bottomRight");
        AbstractC4492zt.h(cornerSize4, "bottomLeft");
    }

    /* JADX INFO: renamed from: toRadius-Bz7bX_o, reason: not valid java name */
    private final long m724toRadiusBz7bX_o(float f) {
        return CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo720createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return ((f + f2) + f3) + f4 == 0.0f ? new Outline.Rectangle(SizeKt.m2888toRectuvyYCjk(j)) : new Outline.Rounded(RoundRectKt.m2850RoundRectZAM2FJo(SizeKt.m2888toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f2, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f3, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f4, 0.0f, 2, null)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteRoundedCornerShape)) {
            return false;
        }
        AbsoluteRoundedCornerShape absoluteRoundedCornerShape = (AbsoluteRoundedCornerShape) obj;
        return AbstractC4492zt.d(getTopStart(), absoluteRoundedCornerShape.getTopStart()) && AbstractC4492zt.d(getTopEnd(), absoluteRoundedCornerShape.getTopEnd()) && AbstractC4492zt.d(getBottomEnd(), absoluteRoundedCornerShape.getBottomEnd()) && AbstractC4492zt.d(getBottomStart(), absoluteRoundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public String toString() {
        return "AbsoluteRoundedCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public AbsoluteRoundedCornerShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        AbstractC4492zt.h(cornerSize, "topStart");
        AbstractC4492zt.h(cornerSize2, "topEnd");
        AbstractC4492zt.h(cornerSize3, "bottomEnd");
        AbstractC4492zt.h(cornerSize4, "bottomStart");
        return new AbsoluteRoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
