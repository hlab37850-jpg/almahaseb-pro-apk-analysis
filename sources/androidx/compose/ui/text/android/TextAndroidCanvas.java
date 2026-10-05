package androidx.compose.ui.text.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import androidx.annotation.RequiresApi;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class TextAndroidCanvas extends Canvas {
    private Canvas nativeCanvas;

    @Override // android.graphics.Canvas
    @RequiresApi(26)
    public boolean clipOutPath(Path path) {
        AbstractC4492zt.h(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutPath(path);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(26)
    public boolean clipOutRect(RectF rectF) {
        AbstractC4492zt.h(rectF, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(rectF);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path, Region.Op op) {
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipPath(path, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF, Region.Op op) {
        AbstractC4492zt.h(rectF, "rect");
        AbstractC4492zt.h(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rectF, op);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.concat(matrix);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void disableZ() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.disableZ();
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int i, int i2, int i3, int i4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawARGB(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF rectF, float f, float f2, boolean z, Paint paint) {
        AbstractC4492zt.h(rectF, "oval");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawArc(rectF, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        AbstractC4492zt.h(bitmap, "bitmap");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, Paint paint) {
        AbstractC4492zt.h(bitmap, "bitmap");
        AbstractC4492zt.h(fArr, "verts");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmapMesh(bitmap, i, i2, fArr, i3, iArr, i4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f, float f2, float f3, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawCircle(f, f2, f3, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawDoubleRoundRect(RectF rectF, float f, float f2, RectF rectF2, float f3, float f4, Paint paint) {
        AbstractC4492zt.h(rectF, "outer");
        AbstractC4492zt.h(rectF2, "inner");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawDoubleRoundRect(rectF, f, f2, rectF2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(31)
    public void drawGlyphs(int[] iArr, int i, float[] fArr, int i2, int i3, Font font, Paint paint) {
        AbstractC4492zt.h(iArr, "glyphIds");
        AbstractC4492zt.h(fArr, "positions");
        AbstractC4492zt.h(font, "font");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawGlyphs(iArr, i, fArr, i2, i3, font, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawLine(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, int i, int i2, Paint paint) {
        AbstractC4492zt.h(fArr, "pts");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawLines(fArr, i, i2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF rectF, Paint paint) {
        AbstractC4492zt.h(rectF, "oval");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawOval(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPaint(paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(31)
    public void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        AbstractC4492zt.h(ninePatch, "patch");
        AbstractC4492zt.h(rect, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPatch(ninePatch, rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPath(path, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        AbstractC4492zt.h(picture, "picture");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f, float f2, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoint(f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoints(fArr, i, i2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPosText(char[] cArr, int i, int i2, float[] fArr, Paint paint) {
        AbstractC4492zt.h(cArr, "text");
        AbstractC4492zt.h(fArr, "pos");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPosText(cArr, i, i2, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int i, int i2, int i3) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRGB(i, i2, i3);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rectF, Paint paint) {
        AbstractC4492zt.h(rectF, "rect");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(rectF, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawRenderNode(RenderNode renderNode) {
        AbstractC4492zt.h(renderNode, "renderNode");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRenderNode(renderNode);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rectF, float f, float f2, Paint paint) {
        AbstractC4492zt.h(rectF, "rect");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRoundRect(rectF, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] cArr, int i, int i2, float f, float f2, Paint paint) {
        AbstractC4492zt.h(cArr, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(cArr, i, i2, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] cArr, int i, int i2, Path path, float f, float f2, Paint paint) {
        AbstractC4492zt.h(cArr, "text");
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextOnPath(cArr, i, i2, path, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(23)
    public void drawTextRun(char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        AbstractC4492zt.h(cArr, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextRun(cArr, i, i2, i3, i4, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode vertexMode, int i, float[] fArr, int i2, float[] fArr2, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, Paint paint) {
        AbstractC4492zt.h(vertexMode, "mode");
        AbstractC4492zt.h(fArr, "verts");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawVertices(vertexMode, i, fArr, i2, fArr2, i3, iArr, i4, sArr, i5, i6, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void enableZ() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.enableZ();
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect rect) {
        AbstractC4492zt.h(rect, "bounds");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        boolean clipBounds = canvas.getClipBounds(rect);
        if (clipBounds) {
            rect.set(0, 0, rect.width(), Integer.MAX_VALUE);
        }
        return clipBounds;
    }

    @Override // android.graphics.Canvas
    public int getDensity() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getDensity();
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getHeight();
    }

    @Override // android.graphics.Canvas
    public void getMatrix(Matrix matrix) {
        AbstractC4492zt.h(matrix, "ctm");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.getMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getSaveCount();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.getWidth();
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.isOpaque();
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        AbstractC4492zt.h(rectF, "rect");
        AbstractC4492zt.h(edgeType, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(rectF, edgeType);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.restore();
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.restoreToCount(i);
    }

    @Override // android.graphics.Canvas
    public void rotate(float f) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.rotate(f);
    }

    @Override // android.graphics.Canvas
    public int save() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.save();
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint, int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(rectF, paint, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i, int i2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(rectF, i, i2);
    }

    @Override // android.graphics.Canvas
    public void scale(float f, float f2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.scale(f, f2);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.setBitmap(bitmap);
    }

    public final void setCanvas(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        this.nativeCanvas = canvas;
    }

    @Override // android.graphics.Canvas
    public void setDensity(int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.setDensity(i);
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter drawFilter) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.setMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public void skew(float f, float f2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.skew(f, f2);
    }

    @Override // android.graphics.Canvas
    public void translate(float f, float f2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.translate(f, f2);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(26)
    public boolean clipOutRect(Rect rect) {
        AbstractC4492zt.h(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        AbstractC4492zt.h(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipPath(path);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect, Region.Op op) {
        AbstractC4492zt.h(rect, "rect");
        AbstractC4492zt.h(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawArc(f, f2, f3, f4, f5, f6, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        AbstractC4492zt.h(bitmap, "bitmap");
        AbstractC4492zt.h(rectF, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, rect, rectF, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawColor(long j) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(j);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawDoubleRoundRect(RectF rectF, float[] fArr, RectF rectF2, float[] fArr2, Paint paint) {
        AbstractC4492zt.h(rectF, "outer");
        AbstractC4492zt.h(fArr, "outerRadii");
        AbstractC4492zt.h(rectF2, "inner");
        AbstractC4492zt.h(fArr2, "innerRadii");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawDoubleRoundRect(rectF, fArr, rectF2, fArr2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, Paint paint) {
        AbstractC4492zt.h(fArr, "pts");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawLines(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawOval(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(31)
    public void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        AbstractC4492zt.h(ninePatch, "patch");
        AbstractC4492zt.h(rectF, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPatch(ninePatch, rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF rectF) {
        AbstractC4492zt.h(picture, "picture");
        AbstractC4492zt.h(rectF, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture, rectF);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, Paint paint) {
        AbstractC4492zt.h(fArr, "pts");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoints(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPosText(String str, float[] fArr, Paint paint) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(fArr, "pos");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPosText(str, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect rect, Paint paint) {
        AbstractC4492zt.h(rect, "r");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, float f, float f2, Paint paint) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(str, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String str, Path path, float f, float f2, Paint paint) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextOnPath(str, path, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(23)
    public void drawTextRun(CharSequence charSequence, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextRun(charSequence, i, i2, i3, i4, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(30)
    public boolean quickReject(RectF rectF) {
        AbstractC4492zt.h(rectF, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(rectF);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(rectF, i);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(26)
    public boolean clipOutRect(float f, float f2, float f3, float f4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF) {
        AbstractC4492zt.h(rectF, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rectF);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        AbstractC4492zt.h(bitmap, "bitmap");
        AbstractC4492zt.h(rect2, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, rect, rect2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i, PorterDuff.Mode mode) {
        AbstractC4492zt.h(mode, "mode");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i, mode);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect rect) {
        AbstractC4492zt.h(picture, "picture");
        AbstractC4492zt.h(rect, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture, rect);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, int i, int i2, float f, float f2, Paint paint) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(str, i, i2, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawTextRun(MeasuredText measuredText, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        AbstractC4492zt.h(measuredText, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextRun(measuredText, i, i2, i3, i4, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(edgeType, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(path, edgeType);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(f, f2, f3, f4, paint, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i, int i2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(f, f2, f3, f4, i, i2);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(26)
    public boolean clipOutRect(int i, int i2, int i3, int i4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        AbstractC4492zt.h(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rect);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, Paint paint) {
        AbstractC4492zt.h(iArr, "colors");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(iArr, i, i2, f, f2, i3, i4, z, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawColor(int i, BlendMode blendMode) {
        AbstractC4492zt.h(blendMode, "mode");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i, blendMode);
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(charSequence, i, i2, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(30)
    public boolean quickReject(Path path) {
        AbstractC4492zt.h(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(path);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(f, f2, f3, f4, i);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        AbstractC4492zt.h(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(f, f2, f3, f4, op);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        AbstractC4492zt.h(iArr, "colors");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(iArr, i, i2, i3, i4, i5, i6, z, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(29)
    public void drawColor(long j, BlendMode blendMode) {
        AbstractC4492zt.h(blendMode, "mode");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(j, blendMode);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f, float f2, float f3, float f4, Canvas.EdgeType edgeType) {
        AbstractC4492zt.h(edgeType, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(f, f2, f3, f4, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        AbstractC4492zt.h(bitmap, "bitmap");
        AbstractC4492zt.h(matrix, "matrix");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    @Override // android.graphics.Canvas
    @RequiresApi(30)
    public boolean quickReject(float f, float f2, float f3, float f4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int i, int i2, int i3, int i4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            AbstractC4492zt.x("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(i, i2, i3, i4);
    }
}
