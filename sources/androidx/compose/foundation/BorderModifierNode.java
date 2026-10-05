package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;

/* JADX INFO: loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Brush $brush;
        final /* synthetic */ Outline.Generic $outline;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Outline.Generic generic, Brush brush) {
            super(1);
            this.$outline = generic;
            this.$brush = brush;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ContentDrawScope) obj);
            return FW.a;
        }

        public final void invoke(ContentDrawScope contentDrawScope) {
            AbstractC4492zt.h(contentDrawScope, "$this$onDrawWithContent");
            contentDrawScope.drawContent();
            AbstractC3255kk.F(contentDrawScope, this.$outline.getPath(), this.$brush, 0.0f, null, null, 0, 60, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ OJ $cacheImageBitmap;
        final /* synthetic */ ColorFilter $colorFilter;
        final /* synthetic */ Rect $pathBounds;
        final /* synthetic */ long $pathBoundsSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Rect rect, OJ oj, long j, ColorFilter colorFilter) {
            super(1);
            this.$pathBounds = rect;
            this.$cacheImageBitmap = oj;
            this.$pathBoundsSize = j;
            this.$colorFilter = colorFilter;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ContentDrawScope) obj);
            return FW.a;
        }

        public final void invoke(ContentDrawScope contentDrawScope) {
            AbstractC4492zt.h(contentDrawScope, "$this$onDrawWithContent");
            contentDrawScope.drawContent();
            float left = this.$pathBounds.getLeft();
            float top = this.$pathBounds.getTop();
            OJ oj = this.$cacheImageBitmap;
            long j = this.$pathBoundsSize;
            ColorFilter colorFilter = this.$colorFilter;
            contentDrawScope.getDrawContext().getTransform().translate(left, top);
            AbstractC3255kk.z(contentDrawScope, (ImageBitmap) oj.a, 0L, j, 0L, 0L, 0.0f, null, colorFilter, 0, 0, 890, null);
            contentDrawScope.getDrawContext().getTransform().translate(-left, -top);
        }
    }

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, AbstractC0419Di abstractC0419Di) {
        this(f, brush, shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00da  */
    public final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, Brush brush, Outline.Generic generic, boolean z, float f) {
        int iM3229getArgb8888_sVssgQ;
        ColorFilter colorFilterM3073tintxETnrds$default;
        boolean z2;
        ImageBitmap imageBitmap;
        Canvas canvas;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new AnonymousClass1(generic, brush));
        }
        if (brush instanceof SolidColor) {
            iM3229getArgb8888_sVssgQ = ImageBitmapConfig.Companion.m3228getAlpha8_sVssgQ();
            colorFilterM3073tintxETnrds$default = ColorFilter.Companion.m3073tintxETnrds$default(ColorFilter.Companion, ((SolidColor) brush).m3338getValue0d7_KjU(), 0, 2, null);
        } else {
            iM3229getArgb8888_sVssgQ = ImageBitmapConfig.Companion.m3229getArgb8888_sVssgQ();
            colorFilterM3073tintxETnrds$default = null;
        }
        Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        AbstractC4492zt.e(borderCache);
        Path pathObtainPath = borderCache.obtainPath();
        pathObtainPath.reset();
        pathObtainPath.addRect(bounds);
        pathObtainPath.mo2932opN5in7k0(pathObtainPath, generic.getPath(), PathOperation.Companion.m3295getDifferenceb3I0S0c());
        OJ oj = new OJ();
        long jIntSize = IntSizeKt.IntSize((int) Math.ceil(bounds.getWidth()), (int) Math.ceil(bounds.getHeight()));
        BorderCache borderCache2 = this.borderCache;
        AbstractC4492zt.e(borderCache2);
        ImageBitmap imageBitmap2 = borderCache2.imageBitmap;
        Canvas canvas2 = borderCache2.canvas;
        ImageBitmapConfig imageBitmapConfigM3221boximpl = imageBitmap2 != null ? ImageBitmapConfig.m3221boximpl(imageBitmap2.mo2907getConfig_sVssgQ()) : null;
        if (!(imageBitmapConfigM3221boximpl == null ? false : ImageBitmapConfig.m3224equalsimpl0(imageBitmapConfigM3221boximpl.m3227unboximpl(), ImageBitmapConfig.Companion.m3229getArgb8888_sVssgQ()))) {
            z2 = ImageBitmapConfig.m3223equalsimpl(iM3229getArgb8888_sVssgQ, imageBitmap2 != null ? ImageBitmapConfig.m3221boximpl(imageBitmap2.mo2907getConfig_sVssgQ()) : null);
        }
        if (imageBitmap2 == null || canvas2 == null || Size.m2867getWidthimpl(cacheDrawScope.m2701getSizeNHjbRc()) > imageBitmap2.getWidth() || Size.m2864getHeightimpl(cacheDrawScope.m2701getSizeNHjbRc()) > imageBitmap2.getHeight() || !z2) {
            ImageBitmap imageBitmapM3234ImageBitmapx__hDU$default = ImageBitmapKt.m3234ImageBitmapx__hDU$default(IntSize.m5320getWidthimpl(jIntSize), IntSize.m5319getHeightimpl(jIntSize), iM3229getArgb8888_sVssgQ, false, null, 24, null);
            borderCache2.imageBitmap = imageBitmapM3234ImageBitmapx__hDU$default;
            Canvas Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(imageBitmapM3234ImageBitmapx__hDU$default);
            borderCache2.canvas = Canvas;
            imageBitmap = imageBitmapM3234ImageBitmapx__hDU$default;
            canvas = Canvas;
        } else {
            imageBitmap = imageBitmap2;
            canvas = canvas2;
        }
        CanvasDrawScope canvasDrawScope = borderCache2.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            borderCache2.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        long jM5330toSizeozmzZPI = IntSizeKt.m5330toSizeozmzZPI(jIntSize);
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM3471component4NHjbRc = drawParams.m3471component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m3474setSizeuvyYCjk(jM5330toSizeozmzZPI);
        canvas.save();
        long jM3058getBlack0d7_KjU = Color.Companion.m3058getBlack0d7_KjU();
        BlendMode.Companion companion = BlendMode.Companion;
        AbstractC3255kk.K(canvasDrawScope2, jM3058getBlack0d7_KjU, 0L, jM5330toSizeozmzZPI, 0.0f, null, null, companion.m2955getClear0nO6VwU(), 58, null);
        float f2 = -bounds.getLeft();
        float f3 = -bounds.getTop();
        canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
        AbstractC3255kk.F(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        float f4 = 1;
        float fM2867getWidthimpl = (Size.m2867getWidthimpl(canvasDrawScope2.mo3469getSizeNHjbRc()) + f4) / Size.m2867getWidthimpl(canvasDrawScope2.mo3469getSizeNHjbRc());
        float fM2864getHeightimpl = (Size.m2864getHeightimpl(canvasDrawScope2.mo3469getSizeNHjbRc()) + f4) / Size.m2864getHeightimpl(canvasDrawScope2.mo3469getSizeNHjbRc());
        long jMo3468getCenterF1C5BW0 = canvasDrawScope2.mo3468getCenterF1C5BW0();
        DrawContext drawContext = canvasDrawScope2.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3482scale0AR0LA0(fM2867getWidthimpl, fM2864getHeightimpl, jMo3468getCenterF1C5BW0);
        AbstractC3255kk.F(canvasDrawScope2, pathObtainPath, brush, 0.0f, null, null, companion.m2955getClear0nO6VwU(), 28, null);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
        canvasDrawScope2.getDrawContext().getTransform().translate(-f2, -f3);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m3474setSizeuvyYCjk(jM3471component4NHjbRc);
        imageBitmap.prepareToDraw();
        oj.a = imageBitmap;
        return cacheDrawScope.onDrawWithContent(new AnonymousClass3(bounds, oj, jIntSize, colorFilterM3073tintxETnrds$default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m184drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, Brush brush, Outline.Rounded rounded, long j, long j2, boolean z, float f) {
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            return cacheDrawScope.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$1(z, brush, rounded.getRoundRect().m2848getTopLeftCornerRadiuskKHJgLs(), f / 2, f, j, j2, new Stroke(f, 0.0f, 0, 0, null, 30, null)));
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        AbstractC4492zt.e(borderCache);
        return cacheDrawScope.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$2(BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z), brush));
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m185getWidthD9Ej5fM() {
        return this.width;
    }

    public final void setBrush(Brush brush) {
        AbstractC4492zt.h(brush, "value");
        if (AbstractC4492zt.d(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setShape(Shape shape) {
        AbstractC4492zt.h(shape, "value");
        if (AbstractC4492zt.d(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX INFO: renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m186setWidth0680j_4(float f) {
        if (Dp.m5165equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        AbstractC4492zt.h(brush, "brushParameter");
        AbstractC4492zt.h(shape, "shapeParameter");
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new BorderModifierNode$drawWithCacheModifierNode$1(this)));
    }
}
