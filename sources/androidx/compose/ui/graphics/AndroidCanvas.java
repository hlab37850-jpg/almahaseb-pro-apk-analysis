package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC0437Ea;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidCanvas implements Canvas {
    private android.graphics.Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    private final Rect srcRect = new Rect();
    private final Rect dstRect = new Rect();

    private final void drawLines(List<Offset> list, Paint paint, int i) {
        if (list.size() >= 2) {
            android.graphics.Paint paintAsFrameworkPaint = paint.asFrameworkPaint();
            int i2 = 0;
            while (i2 < list.size() - 1) {
                long jM2808unboximpl = list.get(i2).m2808unboximpl();
                long jM2808unboximpl2 = list.get(i2 + 1).m2808unboximpl();
                this.internalCanvas.drawLine(Offset.m2798getXimpl(jM2808unboximpl), Offset.m2799getYimpl(jM2808unboximpl), Offset.m2798getXimpl(jM2808unboximpl2), Offset.m2799getYimpl(jM2808unboximpl2), paintAsFrameworkPaint);
                i2 += i;
            }
        }
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            long jM2808unboximpl = list.get(i).m2808unboximpl();
            this.internalCanvas.drawPoint(Offset.m2798getXimpl(jM2808unboximpl), Offset.m2799getYimpl(jM2808unboximpl), paint.asFrameworkPaint());
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i) {
        if (fArr.length < 4 || fArr.length % 2 != 0) {
            return;
        }
        android.graphics.Paint paintAsFrameworkPaint = paint.asFrameworkPaint();
        int i2 = 0;
        while (i2 < fArr.length - 3) {
            this.internalCanvas.drawLine(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], paintAsFrameworkPaint);
            i2 += i * 2;
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i) {
        if (fArr.length % 2 == 0) {
            android.graphics.Paint paintAsFrameworkPaint = paint.asFrameworkPaint();
            int i2 = 0;
            while (i2 < fArr.length - 1) {
                this.internalCanvas.drawPoint(fArr[i2], fArr[i2 + 1], paintAsFrameworkPaint);
                i2 += i;
            }
        }
    }

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo2892clipPathmtrdDE(Path path, int i) {
        AbstractC4492zt.h(path, "path");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).getInternalPath(), m2903toRegionOp7u2Bmg(i));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo2893clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.internalCanvas.clipRect(f, f2, f3, f4, m2903toRegionOp7u2Bmg(i));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
    public /* synthetic */ void mo2894clipRectmtrdDE(androidx.compose.ui.geometry.Rect rect, int i) {
        AbstractC0437Ea.a(this, rect, i);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo2895concat58bKbWc(float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
        if (MatrixKt.m3261isIdentity58bKbWc(fArr)) {
            return;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.m2910setFromEL8BTi8(matrix, fArr);
        this.internalCanvas.concat(matrix);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawArc(androidx.compose.ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        AbstractC0437Ea.b(this, rect, f, f2, z, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawArcRad(androidx.compose.ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        AbstractC0437Ea.c(this, rect, f, f2, z, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo2896drawCircle9KIMszo(long j, float f, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), f, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo2897drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint) {
        AbstractC4492zt.h(imageBitmap, "image");
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo2898drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint) {
        AbstractC4492zt.h(imageBitmap, "image");
        AbstractC4492zt.h(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap bitmapAsAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        Rect rect = this.srcRect;
        rect.left = IntOffset.m5278getXimpl(j);
        rect.top = IntOffset.m5279getYimpl(j);
        rect.right = IntOffset.m5278getXimpl(j) + IntSize.m5320getWidthimpl(j2);
        rect.bottom = IntOffset.m5279getYimpl(j) + IntSize.m5319getHeightimpl(j2);
        FW fw = FW.a;
        Rect rect2 = this.dstRect;
        rect2.left = IntOffset.m5278getXimpl(j3);
        rect2.top = IntOffset.m5279getYimpl(j3);
        rect2.right = IntOffset.m5278getXimpl(j3) + IntSize.m5320getWidthimpl(j4);
        rect2.bottom = IntOffset.m5279getYimpl(j3) + IntSize.m5319getHeightimpl(j4);
        canvas.drawBitmap(bitmapAsAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo2899drawLineWko1d7g(long j, long j2, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawLine(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawOval(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        AbstractC0437Ea.d(this, rect, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void mo2900drawPointsO7TthRY(int i, List<Offset> list, Paint paint) {
        AbstractC4492zt.h(list, "points");
        AbstractC4492zt.h(paint, "paint");
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m3304equalsimpl0(i, companion.m3308getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.m3304equalsimpl0(i, companion.m3310getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.m3304equalsimpl0(i, companion.m3309getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void mo2901drawRawPointsO7TthRY(int i, float[] fArr, Paint paint) {
        AbstractC4492zt.h(fArr, "points");
        AbstractC4492zt.h(paint, "paint");
        if (fArr.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m3304equalsimpl0(i, companion.m3308getLinesr_lszbg())) {
            drawRawLines(fArr, paint, 2);
        } else if (PointMode.m3304equalsimpl0(i, companion.m3310getPolygonr_lszbg())) {
            drawRawLines(fArr, paint, 1);
        } else if (PointMode.m3304equalsimpl0(i, companion.m3309getPointsr_lszbg())) {
            drawRawPoints(fArr, paint, 2);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawRect(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        AbstractC0437Ea.e(this, rect, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void mo2902drawVerticesTPEHhCM(Vertices vertices, int i, Paint paint) {
        AbstractC4492zt.h(vertices, "vertices");
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m2946toAndroidVertexModeJOOmi9M(vertices.m3405getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float f) {
        this.internalCanvas.rotate(f);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        AbstractC4492zt.h(rect, "bounds");
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float f, float f2) {
        this.internalCanvas.scale(f, f2);
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        AbstractC4492zt.h(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float f, float f2) {
        this.internalCanvas.skew(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void skewRad(float f, float f2) {
        AbstractC0437Ea.f(this, f, f2);
    }

    /* JADX INFO: renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m2903toRegionOp7u2Bmg(int i) {
        return ClipOp.m3016equalsimpl0(i, ClipOp.Companion.m3020getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, z, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawOval(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        AbstractC4492zt.h(paint, "paint");
        this.internalCanvas.drawRect(f, f2, f3, f4, paint.asFrameworkPaint());
    }
}
