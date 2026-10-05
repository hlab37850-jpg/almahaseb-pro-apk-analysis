package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CutCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        AbstractC4492zt.h(cornerSize, "topStart");
        AbstractC4492zt.h(cornerSize2, "topEnd");
        AbstractC4492zt.h(cornerSize3, "bottomEnd");
        AbstractC4492zt.h(cornerSize4, "bottomStart");
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo720createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        if (f + f2 + f4 + f3 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m2888toRectuvyYCjk(j));
        }
        Path Path = AndroidPath_androidKt.Path();
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        float f5 = layoutDirection == layoutDirection2 ? f : f2;
        Path.moveTo(0.0f, f5);
        Path.lineTo(f5, 0.0f);
        if (layoutDirection == layoutDirection2) {
            f = f2;
        }
        Path.lineTo(Size.m2867getWidthimpl(j) - f, 0.0f);
        Path.lineTo(Size.m2867getWidthimpl(j), f);
        float f6 = layoutDirection == layoutDirection2 ? f3 : f4;
        Path.lineTo(Size.m2867getWidthimpl(j), Size.m2864getHeightimpl(j) - f6);
        Path.lineTo(Size.m2867getWidthimpl(j) - f6, Size.m2864getHeightimpl(j));
        if (layoutDirection == layoutDirection2) {
            f3 = f4;
        }
        Path.lineTo(f3, Size.m2864getHeightimpl(j));
        Path.lineTo(0.0f, Size.m2864getHeightimpl(j) - f3);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CutCornerShape)) {
            return false;
        }
        CutCornerShape cutCornerShape = (CutCornerShape) obj;
        return AbstractC4492zt.d(getTopStart(), cutCornerShape.getTopStart()) && AbstractC4492zt.d(getTopEnd(), cutCornerShape.getTopEnd()) && AbstractC4492zt.d(getBottomEnd(), cutCornerShape.getBottomEnd()) && AbstractC4492zt.d(getBottomStart(), cutCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public String toString() {
        return "CutCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public CutCornerShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        AbstractC4492zt.h(cornerSize, "topStart");
        AbstractC4492zt.h(cornerSize2, "topEnd");
        AbstractC4492zt.h(cornerSize3, "bottomEnd");
        AbstractC4492zt.h(cornerSize4, "bottomStart");
        return new CutCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
