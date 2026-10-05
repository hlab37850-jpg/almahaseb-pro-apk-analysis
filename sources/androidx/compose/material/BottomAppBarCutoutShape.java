package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
final class BottomAppBarCutoutShape implements Shape {
    private final Shape cutoutShape;
    private final FabPlacement fabPlacement;

    public BottomAppBarCutoutShape(Shape shape, FabPlacement fabPlacement) {
        AbstractC4492zt.h(shape, "cutoutShape");
        AbstractC4492zt.h(fabPlacement, "fabPlacement");
        this.cutoutShape = shape;
        this.fabPlacement = fabPlacement;
    }

    private final void addCutoutShape(Path path, LayoutDirection layoutDirection, Density density) {
        float fMo333toPx0680j_4 = density.mo333toPx0680j_4(AppBarKt.BottomAppBarCutoutOffset);
        float f = 2 * fMo333toPx0680j_4;
        long jSize = SizeKt.Size(this.fabPlacement.getWidth() + f, this.fabPlacement.getHeight() + f);
        float left = this.fabPlacement.getLeft() - fMo333toPx0680j_4;
        float fM2867getWidthimpl = left + Size.m2867getWidthimpl(jSize);
        float fM2864getHeightimpl = Size.m2864getHeightimpl(jSize) / 2.0f;
        OutlineKt.addOutline(path, this.cutoutShape.mo216createOutlinePq9zytI(jSize, layoutDirection, density));
        path.mo2935translatek4lQ0M(OffsetKt.Offset(left, -fM2864getHeightimpl));
        if (AbstractC4492zt.d(this.cutoutShape, RoundedCornerShapeKt.getCircleShape())) {
            addRoundedEdges(path, left, fM2867getWidthimpl, fM2864getHeightimpl, density.mo333toPx0680j_4(AppBarKt.BottomAppBarRoundedEdgeRadius), 0.0f);
        }
    }

    private final void addRoundedEdges(Path path, float f, float f2, float f3, float f4, float f5) {
        float f6 = -((float) Math.sqrt((f3 * f3) - (f5 * f5)));
        float f7 = f3 + f6;
        float f8 = f + f7;
        float f9 = f2 - f7;
        C2020dG c2020dGCalculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(f6 - 1.0f, f5, f3);
        float fFloatValue = ((Number) c2020dGCalculateRoundedEdgeIntercept.a()).floatValue() + f3;
        float fFloatValue2 = ((Number) c2020dGCalculateRoundedEdgeIntercept.b()).floatValue() - f5;
        path.moveTo(f8 - f4, 0.0f);
        path.quadraticBezierTo(f8 - 1.0f, 0.0f, f + fFloatValue, fFloatValue2);
        path.lineTo(f2 - fFloatValue, fFloatValue2);
        path.quadraticBezierTo(f9 + 1.0f, 0.0f, f4 + f9, 0.0f);
        path.close();
    }

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i & 2) != 0) {
            fabPlacement = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement);
    }

    public final Shape component1() {
        return this.cutoutShape;
    }

    public final FabPlacement component2() {
        return this.fabPlacement;
    }

    public final BottomAppBarCutoutShape copy(Shape shape, FabPlacement fabPlacement) {
        AbstractC4492zt.h(shape, "cutoutShape");
        AbstractC4492zt.h(fabPlacement, "fabPlacement");
        return new BottomAppBarCutoutShape(shape, fabPlacement);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo216createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        Path Path = AndroidPath_androidKt.Path();
        Path.addRect(new Rect(0.0f, 0.0f, Size.m2867getWidthimpl(j), Size.m2864getHeightimpl(j)));
        Path Path2 = AndroidPath_androidKt.Path();
        addCutoutShape(Path2, layoutDirection, density);
        Path2.mo2932opN5in7k0(Path, Path2, PathOperation.Companion.m3295getDifferenceb3I0S0c());
        return new Outline.Generic(Path2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) obj;
        return AbstractC4492zt.d(this.cutoutShape, bottomAppBarCutoutShape.cutoutShape) && AbstractC4492zt.d(this.fabPlacement, bottomAppBarCutoutShape.fabPlacement);
    }

    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }
}
