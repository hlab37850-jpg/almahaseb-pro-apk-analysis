package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3173jk;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class BackgroundNode extends Modifier.Node implements DrawModifierNode {
    private float alpha;
    private Brush brush;
    private long color;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private Size lastSize;
    private Shape shape;

    public /* synthetic */ BackgroundNode(long j, Brush brush, float f, Shape shape, AbstractC0419Di abstractC0419Di) {
        this(j, brush, f, shape);
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline outlineMo216createOutlinePq9zytI;
        if (Size.m2862equalsimpl(contentDrawScope.mo3469getSizeNHjbRc(), this.lastSize) && contentDrawScope.getLayoutDirection() == this.lastLayoutDirection && AbstractC4492zt.d(this.lastShape, this.shape)) {
            outlineMo216createOutlinePq9zytI = this.lastOutline;
            AbstractC4492zt.e(outlineMo216createOutlinePq9zytI);
        } else {
            outlineMo216createOutlinePq9zytI = this.shape.mo216createOutlinePq9zytI(contentDrawScope.mo3469getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        if (!Color.m3033equalsimpl0(this.color, Color.Companion.m3068getUnspecified0d7_KjU())) {
            OutlineKt.m3264drawOutlinewDX37Ww(contentDrawScope, outlineMo216createOutlinePq9zytI, this.color, (60 & 4) != 0 ? 1.0f : 0.0f, (60 & 8) != 0 ? Fill.INSTANCE : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : 0);
        }
        Brush brush = this.brush;
        if (brush != null) {
            OutlineKt.m3263drawOutlinehn5TExg$default(contentDrawScope, outlineMo216createOutlinePq9zytI, brush, this.alpha, null, null, 0, 56, null);
        }
        this.lastOutline = outlineMo216createOutlinePq9zytI;
        this.lastSize = Size.m2855boximpl(contentDrawScope.mo3469getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        this.lastShape = this.shape;
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        if (!Color.m3033equalsimpl0(this.color, Color.Companion.m3068getUnspecified0d7_KjU())) {
            AbstractC3255kk.K(contentDrawScope, this.color, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        Brush brush = this.brush;
        if (brush != null) {
            AbstractC3255kk.J(contentDrawScope, brush, 0L, 0L, this.alpha, null, null, 0, 118, null);
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "<this>");
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m168getColor0d7_KjU() {
        return this.color;
    }

    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        AbstractC3173jk.a(this);
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setBrush(Brush brush) {
        this.brush = brush;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m169setColor8_81llA(long j) {
        this.color = j;
    }

    public final void setShape(Shape shape) {
        AbstractC4492zt.h(shape, "<set-?>");
        this.shape = shape;
    }

    private BackgroundNode(long j, Brush brush, float f, Shape shape) {
        AbstractC4492zt.h(shape, "shape");
        this.color = j;
        this.brush = brush;
        this.alpha = f;
        this.shape = shape;
    }
}
