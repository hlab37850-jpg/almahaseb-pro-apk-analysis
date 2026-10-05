package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class BorderCache {
    private Path borderPath;
    private Canvas canvas;
    private CanvasDrawScope canvasDrawScope;
    private ImageBitmap imageBitmap;

    public BorderCache() {
        this(null, null, null, null, 15, null);
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache borderCache, ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap = borderCache.imageBitmap;
        }
        if ((i & 2) != 0) {
            canvas = borderCache.canvas;
        }
        if ((i & 4) != 0) {
            canvasDrawScope = borderCache.canvasDrawScope;
        }
        if ((i & 8) != 0) {
            path = borderCache.borderPath;
        }
        return borderCache.copy(imageBitmap, canvas, canvasDrawScope, path);
    }

    public final BorderCache copy(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path) {
        return new BorderCache(imageBitmap, canvas, canvasDrawScope, path);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    /* JADX WARN: Code duplicated, block: B:28:0x009b  */
    /* JADX INFO: renamed from: drawBorderCache-EMwLDEs, reason: not valid java name */
    public final ImageBitmap m175drawBorderCacheEMwLDEs(CacheDrawScope cacheDrawScope, long j, int i, InterfaceC3750qp interfaceC3750qp) {
        CanvasDrawScope canvasDrawScope;
        AbstractC4492zt.h(cacheDrawScope, "$this$drawBorderCache");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        ImageBitmap imageBitmapM3234ImageBitmapx__hDU$default = this.imageBitmap;
        Canvas Canvas = this.canvas;
        ImageBitmapConfig imageBitmapConfigM3221boximpl = imageBitmapM3234ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m3221boximpl(imageBitmapM3234ImageBitmapx__hDU$default.mo2907getConfig_sVssgQ()) : null;
        boolean z = false;
        if (!(imageBitmapConfigM3221boximpl == null ? false : ImageBitmapConfig.m3224equalsimpl0(imageBitmapConfigM3221boximpl.m3227unboximpl(), ImageBitmapConfig.Companion.m3229getArgb8888_sVssgQ()))) {
            if (ImageBitmapConfig.m3223equalsimpl(i, imageBitmapM3234ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m3221boximpl(imageBitmapM3234ImageBitmapx__hDU$default.mo2907getConfig_sVssgQ()) : null)) {
            }
            if (imageBitmapM3234ImageBitmapx__hDU$default != null || Canvas == null || Size.m2867getWidthimpl(cacheDrawScope.m2701getSizeNHjbRc()) > imageBitmapM3234ImageBitmapx__hDU$default.getWidth() || Size.m2864getHeightimpl(cacheDrawScope.m2701getSizeNHjbRc()) > imageBitmapM3234ImageBitmapx__hDU$default.getHeight() || !z) {
                imageBitmapM3234ImageBitmapx__hDU$default = ImageBitmapKt.m3234ImageBitmapx__hDU$default(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j), i, false, null, 24, null);
                this.imageBitmap = imageBitmapM3234ImageBitmapx__hDU$default;
                Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(imageBitmapM3234ImageBitmapx__hDU$default);
                this.canvas = Canvas;
            }
            canvasDrawScope = this.canvasDrawScope;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                this.canvasDrawScope = canvasDrawScope;
            }
            long jM5330toSizeozmzZPI = IntSizeKt.m5330toSizeozmzZPI(j);
            LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
            Density densityComponent1 = drawParams.component1();
            LayoutDirection layoutDirectionComponent2 = drawParams.component2();
            Canvas canvasComponent3 = drawParams.component3();
            long jM3471component4NHjbRc = drawParams.m3471component4NHjbRc();
            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
            drawParams2.setDensity(cacheDrawScope);
            drawParams2.setLayoutDirection(layoutDirection);
            drawParams2.setCanvas(Canvas);
            drawParams2.m3474setSizeuvyYCjk(jM5330toSizeozmzZPI);
            Canvas.save();
            AbstractC3255kk.K(canvasDrawScope, Color.Companion.m3058getBlack0d7_KjU(), 0L, jM5330toSizeozmzZPI, 0.0f, null, null, BlendMode.Companion.m2955getClear0nO6VwU(), 58, null);
            interfaceC3750qp.invoke(canvasDrawScope);
            Canvas.restore();
            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
            drawParams3.setDensity(densityComponent1);
            drawParams3.setLayoutDirection(layoutDirectionComponent2);
            drawParams3.setCanvas(canvasComponent3);
            drawParams3.m3474setSizeuvyYCjk(jM3471component4NHjbRc);
            imageBitmapM3234ImageBitmapx__hDU$default.prepareToDraw();
            return imageBitmapM3234ImageBitmapx__hDU$default;
        }
        z = true;
        if (imageBitmapM3234ImageBitmapx__hDU$default != null) {
            imageBitmapM3234ImageBitmapx__hDU$default = ImageBitmapKt.m3234ImageBitmapx__hDU$default(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j), i, false, null, 24, null);
            this.imageBitmap = imageBitmapM3234ImageBitmapx__hDU$default;
            Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(imageBitmapM3234ImageBitmapx__hDU$default);
            this.canvas = Canvas;
        } else {
            imageBitmapM3234ImageBitmapx__hDU$default = ImageBitmapKt.m3234ImageBitmapx__hDU$default(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j), i, false, null, 24, null);
            this.imageBitmap = imageBitmapM3234ImageBitmapx__hDU$default;
            Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(imageBitmapM3234ImageBitmapx__hDU$default);
            this.canvas = Canvas;
        }
        canvasDrawScope = this.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            this.canvasDrawScope = canvasDrawScope;
        }
        long jM5330toSizeozmzZPI2 = IntSizeKt.m5330toSizeozmzZPI(j);
        LayoutDirection layoutDirection2 = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope.getDrawParams();
        Density densityComponent2 = drawParams4.component1();
        LayoutDirection layoutDirectionComponent3 = drawParams4.component2();
        Canvas canvasComponent4 = drawParams4.component3();
        long jM3471component4NHjbRc2 = drawParams4.m3471component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams5 = canvasDrawScope.getDrawParams();
        drawParams5.setDensity(cacheDrawScope);
        drawParams5.setLayoutDirection(layoutDirection2);
        drawParams5.setCanvas(Canvas);
        drawParams5.m3474setSizeuvyYCjk(jM5330toSizeozmzZPI2);
        Canvas.save();
        AbstractC3255kk.K(canvasDrawScope, Color.Companion.m3058getBlack0d7_KjU(), 0L, jM5330toSizeozmzZPI2, 0.0f, null, null, BlendMode.Companion.m2955getClear0nO6VwU(), 58, null);
        interfaceC3750qp.invoke(canvasDrawScope);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams6 = canvasDrawScope.getDrawParams();
        drawParams6.setDensity(densityComponent2);
        drawParams6.setLayoutDirection(layoutDirectionComponent3);
        drawParams6.setCanvas(canvasComponent4);
        drawParams6.m3474setSizeuvyYCjk(jM3471component4NHjbRc2);
        imageBitmapM3234ImageBitmapx__hDU$default.prepareToDraw();
        return imageBitmapM3234ImageBitmapx__hDU$default;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        return AbstractC4492zt.d(this.imageBitmap, borderCache.imageBitmap) && AbstractC4492zt.d(this.canvas, borderCache.canvas) && AbstractC4492zt.d(this.canvasDrawScope, borderCache.canvasDrawScope) && AbstractC4492zt.d(this.borderPath, borderCache.borderPath);
    }

    public int hashCode() {
        ImageBitmap imageBitmap = this.imageBitmap;
        int iHashCode = (imageBitmap == null ? 0 : imageBitmap.hashCode()) * 31;
        Canvas canvas = this.canvas;
        int iHashCode2 = (iHashCode + (canvas == null ? 0 : canvas.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        int iHashCode3 = (iHashCode2 + (canvasDrawScope == null ? 0 : canvasDrawScope.hashCode())) * 31;
        Path path = this.borderPath;
        return iHashCode3 + (path != null ? path.hashCode() : 0);
    }

    public final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path Path = AndroidPath_androidKt.Path();
        this.borderPath = Path;
        return Path;
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path) {
        this.imageBitmap = imageBitmap;
        this.canvas = canvas;
        this.canvasDrawScope = canvasDrawScope;
        this.borderPath = path;
    }

    public /* synthetic */ BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : imageBitmap, (i & 2) != 0 ? null : canvas, (i & 4) != 0 ? null : canvasDrawScope, (i & 8) != 0 ? null : path);
    }
}
