package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BlurKt$blur$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ boolean $clip;
    final /* synthetic */ Shape $edgeTreatment;
    final /* synthetic */ float $radiusX;
    final /* synthetic */ float $radiusY;
    final /* synthetic */ int $tileMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurKt$blur$1(float f, float f2, int i, Shape shape, boolean z) {
        super(1);
        this.$radiusX = f;
        this.$radiusY = f2;
        this.$tileMode = i;
        this.$edgeTreatment = shape;
        this.$clip = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return FW.a;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        AbstractC4492zt.h(graphicsLayerScope, "$this$graphicsLayer");
        float fMo333toPx0680j_4 = graphicsLayerScope.mo333toPx0680j_4(this.$radiusX);
        float fMo333toPx0680j_5 = graphicsLayerScope.mo333toPx0680j_4(this.$radiusY);
        graphicsLayerScope.setRenderEffect((fMo333toPx0680j_4 <= 0.0f || fMo333toPx0680j_5 <= 0.0f) ? null : RenderEffectKt.m3311BlurEffect3YTHUZs(fMo333toPx0680j_4, fMo333toPx0680j_5, this.$tileMode));
        Shape rectangleShape = this.$edgeTreatment;
        if (rectangleShape == null) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        }
        graphicsLayerScope.setShape(rectangleShape);
        graphicsLayerScope.setClip(this.$clip);
    }
}
