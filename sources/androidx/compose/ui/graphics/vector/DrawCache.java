package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DrawCache {
    private Canvas cachedCanvas;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.Companion.m5325getZeroYbymL2g();
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    private final void clear(DrawScope drawScope) {
        AbstractC3255kk.K(drawScope, Color.Companion.m3058getBlack0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m2955getClear0nO6VwU(), 62, null);
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f, colorFilter);
    }

    public static /* synthetic */ void getMCachedImage$annotations() {
    }

    /* JADX INFO: renamed from: drawCachedImage-CJJAR-o, reason: not valid java name */
    public final void m3569drawCachedImageCJJARo(long j, Density density, LayoutDirection layoutDirection, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap imageBitmapM3234ImageBitmapx__hDU$default = this.mCachedImage;
        Canvas Canvas = this.cachedCanvas;
        if (imageBitmapM3234ImageBitmapx__hDU$default == null || Canvas == null || IntSize.m5320getWidthimpl(j) > imageBitmapM3234ImageBitmapx__hDU$default.getWidth() || IntSize.m5319getHeightimpl(j) > imageBitmapM3234ImageBitmapx__hDU$default.getHeight()) {
            imageBitmapM3234ImageBitmapx__hDU$default = ImageBitmapKt.m3234ImageBitmapx__hDU$default(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j), 0, false, null, 28, null);
            Canvas = CanvasKt.Canvas(imageBitmapM3234ImageBitmapx__hDU$default);
            this.mCachedImage = imageBitmapM3234ImageBitmapx__hDU$default;
            this.cachedCanvas = Canvas;
        }
        this.size = j;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long jM5330toSizeozmzZPI = IntSizeKt.m5330toSizeozmzZPI(j);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM3471component4NHjbRc = drawParams.m3471component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(Canvas);
        drawParams2.m3474setSizeuvyYCjk(jM5330toSizeozmzZPI);
        Canvas.save();
        clear(canvasDrawScope);
        interfaceC3750qp.invoke(canvasDrawScope);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m3474setSizeuvyYCjk(jM3471component4NHjbRc);
        imageBitmapM3234ImageBitmapx__hDU$default.prepareToDraw();
    }

    public final void drawInto(DrawScope drawScope, float f, ColorFilter colorFilter) {
        AbstractC4492zt.h(drawScope, TypedValues.AttributesType.S_TARGET);
        ImageBitmap imageBitmap = this.mCachedImage;
        if (imageBitmap == null) {
            throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        AbstractC3255kk.z(drawScope, imageBitmap, 0L, this.size, 0L, 0L, f, null, colorFilter, 0, 0, 858, null);
    }

    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }
}
