package defpackage;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;

/* JADX INFO: renamed from: Ea, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0437Ea {
    public static void a(Canvas canvas, Rect rect, int i) {
        AbstractC4492zt.h(rect, "rect");
        canvas.mo2893clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), i);
    }

    public static void b(Canvas canvas, Rect rect, float f, float f2, boolean z, Paint paint) {
        AbstractC4492zt.h(rect, "rect");
        AbstractC4492zt.h(paint, "paint");
        canvas.drawArc(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2, z, paint);
    }

    public static void c(Canvas canvas, Rect rect, float f, float f2, boolean z, Paint paint) {
        AbstractC4492zt.h(rect, "rect");
        AbstractC4492zt.h(paint, "paint");
        canvas.drawArc(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2), z, paint);
    }

    public static void d(Canvas canvas, Rect rect, Paint paint) {
        AbstractC4492zt.h(rect, "rect");
        AbstractC4492zt.h(paint, "paint");
        canvas.drawOval(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    public static void e(Canvas canvas, Rect rect, Paint paint) {
        AbstractC4492zt.h(rect, "rect");
        AbstractC4492zt.h(paint, "paint");
        canvas.drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    public static void f(Canvas canvas, float f, float f2) {
        canvas.skew(DegreesKt.degrees(f), DegreesKt.degrees(f2));
    }

    public static /* synthetic */ void m(Canvas canvas, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        canvas.mo2892clipPathmtrdDE(path, i);
    }

    public static /* synthetic */ void n(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        canvas.mo2893clipRectN_I0leg(f, f2, f3, f4, i);
    }

    public static /* synthetic */ void o(Canvas canvas, Rect rect, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        canvas.mo2894clipRectmtrdDE(rect, i);
    }

    public static /* synthetic */ void p(Canvas canvas, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
        }
        long jM5288getZeronOccac = (i & 2) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j;
        long jIntSize = (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        canvas.mo2898drawImageRectHPBpro0(imageBitmap, jM5288getZeronOccac, jIntSize, (i & 8) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j3, (i & 16) != 0 ? jIntSize : j4, paint);
    }

    public static /* synthetic */ void q(Canvas canvas, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
        }
        if ((i & 2) != 0) {
            f2 = f;
        }
        canvas.scale(f, f2);
    }
}
