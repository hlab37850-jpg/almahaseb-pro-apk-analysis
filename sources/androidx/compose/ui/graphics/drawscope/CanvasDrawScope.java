package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AD;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    private Paint fillPaint;
    private Paint strokePaint;
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1
        private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Canvas getCanvas() {
            return this.this$0.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo3475getSizeNHjbRc() {
            return this.this$0.getDrawParams().m3473getSizeNHjbRc();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo3476setSizeuvyYCjk(long j) {
            this.this$0.getDrawParams().m3474setSizeuvyYCjk(j);
        }
    };

    public static final class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, AbstractC0419Di abstractC0419Di) {
            this(density, layoutDirection, canvas, j);
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m3470copyUg5Nnss$default(DrawParams drawParams, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection2 = layoutDirection;
            if ((i & 4) != 0) {
                canvas = drawParams.canvas;
            }
            Canvas canvas2 = canvas;
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            return drawParams.m3472copyUg5Nnss(density, layoutDirection2, canvas2, j);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name */
        public final long m3471component4NHjbRc() {
            return this.size;
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m3472copyUg5Nnss(Density density, LayoutDirection layoutDirection, Canvas canvas, long j) {
            AbstractC4492zt.h(density, "density");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
            return new DrawParams(density, layoutDirection, canvas, j, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return AbstractC4492zt.d(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && AbstractC4492zt.d(this.canvas, drawParams.canvas) && Size.m2863equalsimpl0(this.size, drawParams.size);
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m3473getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m2868hashCodeimpl(this.size);
        }

        public final void setCanvas(Canvas canvas) {
            AbstractC4492zt.h(canvas, "<set-?>");
            this.canvas = canvas;
        }

        public final void setDensity(Density density) {
            AbstractC4492zt.h(density, "<set-?>");
            this.density = density;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection) {
            AbstractC4492zt.h(layoutDirection, "<set-?>");
            this.layoutDirection = layoutDirection;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m3474setSizeuvyYCjk(long j) {
            this.size = j;
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m2871toStringimpl(this.size)) + ')';
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j) {
            AbstractC4492zt.h(density, "density");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, AbstractC0419Di abstractC0419Di) {
            this((i & 1) != 0 ? CanvasDrawScopeKt.DefaultDensity : density, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 4) != 0 ? new EmptyCanvas() : canvas, (i & 8) != 0 ? Size.Companion.m2876getZeroNHjbRc() : j, null);
        }
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m3439configurePaint2qPWKa0(long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        long jM3447modulate5vOe2sY = m3447modulate5vOe2sY(j, f);
        if (!Color.m3033equalsimpl0(paintSelectPaint.mo2913getColor0d7_KjU(), jM3447modulate5vOe2sY)) {
            paintSelectPaint.mo2919setColor8_81llA(jM3447modulate5vOe2sY);
        }
        if (paintSelectPaint.getShader() != null) {
            paintSelectPaint.setShader(null);
        }
        if (!AbstractC4492zt.d(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2951equalsimpl0(paintSelectPaint.mo2912getBlendMode0nO6VwU(), i)) {
            paintSelectPaint.mo2918setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m3122equalsimpl0(paintSelectPaint.mo2914getFilterQualityfv9h1I(), i2)) {
            paintSelectPaint.mo2920setFilterQualityvDHp3xo(i2);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static /* synthetic */ Paint m3440configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m3439configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m3500getDefaultFilterQualityfv9h1I() : i2);
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m3441configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo2985applyToPq9zytI(mo3469getSizeNHjbRc(), paintSelectPaint, f);
        } else if (paintSelectPaint.getAlpha() != f) {
            paintSelectPaint.setAlpha(f);
        }
        if (!AbstractC4492zt.d(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2951equalsimpl0(paintSelectPaint.mo2912getBlendMode0nO6VwU(), i)) {
            paintSelectPaint.mo2918setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m3122equalsimpl0(paintSelectPaint.mo2914getFilterQualityfv9h1I(), i2)) {
            paintSelectPaint.mo2920setFilterQualityvDHp3xo(i2);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    public static /* synthetic */ Paint m3442configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = DrawScope.Companion.m3500getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m3441configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, i2);
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m3443configureStrokePaintQ_0CZUI(long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        long jM3447modulate5vOe2sY = m3447modulate5vOe2sY(j, f3);
        if (!Color.m3033equalsimpl0(paintObtainStrokePaint.mo2913getColor0d7_KjU(), jM3447modulate5vOe2sY)) {
            paintObtainStrokePaint.mo2919setColor8_81llA(jM3447modulate5vOe2sY);
        }
        if (paintObtainStrokePaint.getShader() != null) {
            paintObtainStrokePaint.setShader(null);
        }
        if (!AbstractC4492zt.d(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2951equalsimpl0(paintObtainStrokePaint.mo2912getBlendMode0nO6VwU(), i3)) {
            paintObtainStrokePaint.mo2918setBlendModes9anfk8(i3);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != f) {
            paintObtainStrokePaint.setStrokeWidth(f);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != f2) {
            paintObtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m3352equalsimpl0(paintObtainStrokePaint.mo2915getStrokeCapKaPHkGw(), i)) {
            paintObtainStrokePaint.mo2921setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m3362equalsimpl0(paintObtainStrokePaint.mo2916getStrokeJoinLxFBmk8(), i2)) {
            paintObtainStrokePaint.mo2922setStrokeJoinWw9F2mQ(i2);
        }
        if (!AbstractC4492zt.d(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m3122equalsimpl0(paintObtainStrokePaint.mo2914getFilterQualityfv9h1I(), i4)) {
            paintObtainStrokePaint.mo2920setFilterQualityvDHp3xo(i4);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    public static /* synthetic */ Paint m3444configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m3443configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m3500getDefaultFilterQualityfv9h1I() : i4);
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m3445configureStrokePaintho4zsrM(Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo2985applyToPq9zytI(mo3469getSizeNHjbRc(), paintObtainStrokePaint, f3);
        } else if (paintObtainStrokePaint.getAlpha() != f3) {
            paintObtainStrokePaint.setAlpha(f3);
        }
        if (!AbstractC4492zt.d(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2951equalsimpl0(paintObtainStrokePaint.mo2912getBlendMode0nO6VwU(), i3)) {
            paintObtainStrokePaint.mo2918setBlendModes9anfk8(i3);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != f) {
            paintObtainStrokePaint.setStrokeWidth(f);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != f2) {
            paintObtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m3352equalsimpl0(paintObtainStrokePaint.mo2915getStrokeCapKaPHkGw(), i)) {
            paintObtainStrokePaint.mo2921setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m3362equalsimpl0(paintObtainStrokePaint.mo2916getStrokeJoinLxFBmk8(), i2)) {
            paintObtainStrokePaint.mo2922setStrokeJoinWw9F2mQ(i2);
        }
        if (!AbstractC4492zt.d(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m3122equalsimpl0(paintObtainStrokePaint.mo2914getFilterQualityfv9h1I(), i4)) {
            paintObtainStrokePaint.mo2920setFilterQualityvDHp3xo(i4);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    public static /* synthetic */ Paint m3446configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m3445configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m3500getDefaultFilterQualityfv9h1I() : i4);
    }

    public static /* synthetic */ void getDrawParams$annotations() {
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m3447modulate5vOe2sY(long j, float f) {
        return f == 1.0f ? j : Color.m3031copywmQWz5c$default(j, Color.m3034getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo2923setStylek9PVt8s(PaintingStyle.Companion.m3273getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo2923setStylek9PVt8s(PaintingStyle.Companion.m3274getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (AbstractC4492zt.d(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new AD();
        }
        Paint paintObtainStrokePaint = obtainStrokePaint();
        Stroke stroke = (Stroke) drawStyle;
        if (paintObtainStrokePaint.getStrokeWidth() != stroke.getWidth()) {
            paintObtainStrokePaint.setStrokeWidth(stroke.getWidth());
        }
        if (!StrokeCap.m3352equalsimpl0(paintObtainStrokePaint.mo2915getStrokeCapKaPHkGw(), stroke.m3556getCapKaPHkGw())) {
            paintObtainStrokePaint.mo2921setStrokeCapBeK7IIE(stroke.m3556getCapKaPHkGw());
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
            paintObtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
        }
        if (!StrokeJoin.m3362equalsimpl0(paintObtainStrokePaint.mo2916getStrokeJoinLxFBmk8(), stroke.m3557getJoinLxFBmk8())) {
            paintObtainStrokePaint.mo2922setStrokeJoinWw9F2mQ(stroke.m3557getJoinLxFBmk8());
        }
        if (!AbstractC4492zt.d(paintObtainStrokePaint.getPathEffect(), stroke.getPathEffect())) {
            paintObtainStrokePaint.setPathEffect(stroke.getPathEffect());
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m3448drawyzxVdVo(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawParams drawParams = getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM3471component4NHjbRc = drawParams.m3471component4NHjbRc();
        DrawParams drawParams2 = getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m3474setSizeuvyYCjk(j);
        canvas.save();
        interfaceC3750qp.invoke(this);
        canvas.restore();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m3474setSizeuvyYCjk(jM3471component4NHjbRc);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo3449drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j) + Size.m2867getWidthimpl(j2), Offset.m2799getYimpl(j) + Size.m2864getHeightimpl(j2), f, f2, z, m3442configurePaintswdJneE$default(this, brush, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo3450drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2), Offset.m2798getXimpl(j2) + Size.m2867getWidthimpl(j3), Offset.m2799getYimpl(j2) + Size.m2864getHeightimpl(j3), f, f2, z, m3440configurePaint2qPWKa0$default(this, j, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo3451drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().mo2896drawCircle9KIMszo(j, f, m3442configurePaintswdJneE$default(this, brush, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo3452drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().mo2896drawCircle9KIMszo(j2, f, m3440configurePaint2qPWKa0$default(this, j, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo3453drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(imageBitmap, "image");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().mo2898drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m3442configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo3454drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        AbstractC4492zt.h(imageBitmap, "image");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().mo2898drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m3441configurePaintswdJneE(null, drawStyle, f, colorFilter, i, i2));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo3455drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(imageBitmap, "image");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().mo2897drawImaged4ec7I(imageBitmap, j, m3442configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo3456drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        AbstractC4492zt.h(brush, "brush");
        this.drawParams.getCanvas().mo2899drawLineWko1d7g(j, j2, m3446configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i, StrokeJoin.Companion.m3367getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo3457drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().mo2899drawLineWko1d7g(j2, j3, m3444configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i, StrokeJoin.Companion.m3367getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo3458drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j) + Size.m2867getWidthimpl(j2), Offset.m2799getYimpl(j) + Size.m2864getHeightimpl(j2), m3442configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo3459drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2), Offset.m2798getXimpl(j2) + Size.m2867getWidthimpl(j3), Offset.m2799getYimpl(j2) + Size.m2864getHeightimpl(j3), m3440configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo3460drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawPath(path, m3442configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo3461drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawPath(path, m3440configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo3462drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        AbstractC4492zt.h(list, "points");
        this.drawParams.getCanvas().mo2900drawPointsO7TthRY(i, list, m3444configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i2, StrokeJoin.Companion.m3367getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo3463drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        AbstractC4492zt.h(list, "points");
        AbstractC4492zt.h(brush, "brush");
        this.drawParams.getCanvas().mo2900drawPointsO7TthRY(i, list, m3446configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i2, StrokeJoin.Companion.m3367getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo3464drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j) + Size.m2867getWidthimpl(j2), Offset.m2799getYimpl(j) + Size.m2864getHeightimpl(j2), m3442configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo3465drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2), Offset.m2798getXimpl(j2) + Size.m2867getWidthimpl(j3), Offset.m2799getYimpl(j2) + Size.m2864getHeightimpl(j3), m3440configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo3466drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j) + Size.m2867getWidthimpl(j2), Offset.m2799getYimpl(j) + Size.m2864getHeightimpl(j2), CornerRadius.m2773getXimpl(j3), CornerRadius.m2774getYimpl(j3), m3442configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo3467drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        AbstractC4492zt.h(drawStyle, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2), Offset.m2798getXimpl(j2) + Size.m2867getWidthimpl(j3), Offset.m2799getYimpl(j2) + Size.m2864getHeightimpl(j3), CornerRadius.m2773getXimpl(j4), CornerRadius.m2774getYimpl(j4), m3440configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public /* synthetic */ long mo3468getCenterF1C5BW0() {
        return AbstractC3255kk.b(this);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public /* synthetic */ long mo3469getSizeNHjbRc() {
        return AbstractC3255kk.c(this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo326roundToPxR2X_6o(long j) {
        return AbstractC1819bj.a(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo327roundToPx0680j_4(float f) {
        return AbstractC1819bj.b(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo328toDpGaN1DYA(long j) {
        return AbstractC1819bj.c(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo329toDpu2uoSUM(float f) {
        return AbstractC1819bj.d(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo331toDpSizekrfVVM(long j) {
        return AbstractC1819bj.f(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo332toPxR2X_6o(long j) {
        return AbstractC1819bj.g(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo333toPx0680j_4(float f) {
        return AbstractC1819bj.h(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return AbstractC1819bj.i(this, dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo334toSizeXkaWNTQ(long j) {
        return AbstractC1819bj.j(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo335toSp0xMU5do(float f) {
        return AbstractC1819bj.k(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo336toSpkPz2Gy4(float f) {
        return AbstractC1819bj.l(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo330toDpu2uoSUM(int i) {
        return AbstractC1819bj.e(this, i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo337toSpkPz2Gy4(int i) {
        return AbstractC1819bj.m(this, i);
    }
}
