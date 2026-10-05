package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC0437Ea;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface Canvas {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m3010clipRectmtrdDE(Canvas canvas, Rect rect, int i) {
            AbstractC4492zt.h(rect, "rect");
            AbstractC0437Ea.a(canvas, rect, i);
        }

        @Deprecated
        public static void drawArc(Canvas canvas, Rect rect, float f, float f2, boolean z, Paint paint) {
            AbstractC4492zt.h(rect, "rect");
            AbstractC4492zt.h(paint, "paint");
            AbstractC0437Ea.b(canvas, rect, f, f2, z, paint);
        }

        @Deprecated
        public static void drawArcRad(Canvas canvas, Rect rect, float f, float f2, boolean z, Paint paint) {
            AbstractC4492zt.h(rect, "rect");
            AbstractC4492zt.h(paint, "paint");
            AbstractC0437Ea.c(canvas, rect, f, f2, z, paint);
        }

        @Deprecated
        public static void drawOval(Canvas canvas, Rect rect, Paint paint) {
            AbstractC4492zt.h(rect, "rect");
            AbstractC4492zt.h(paint, "paint");
            AbstractC0437Ea.d(canvas, rect, paint);
        }

        @Deprecated
        public static void drawRect(Canvas canvas, Rect rect, Paint paint) {
            AbstractC4492zt.h(rect, "rect");
            AbstractC4492zt.h(paint, "paint");
            AbstractC0437Ea.e(canvas, rect, paint);
        }

        @Deprecated
        public static void skewRad(Canvas canvas, float f, float f2) {
            AbstractC0437Ea.f(canvas, f, f2);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo2892clipPathmtrdDE(Path path, int i);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo2893clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* JADX INFO: renamed from: clipRect-mtrdD-E */
    void mo2894clipRectmtrdDE(Rect rect, int i);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo2895concat58bKbWc(float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint);

    void drawArc(Rect rect, float f, float f2, boolean z, Paint paint);

    void drawArcRad(Rect rect, float f, float f2, boolean z, Paint paint);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo2896drawCircle9KIMszo(long j, float f, Paint paint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo2897drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo2898drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo2899drawLineWko1d7g(long j, long j2, Paint paint);

    void drawOval(float f, float f2, float f3, float f4, Paint paint);

    void drawOval(Rect rect, Paint paint);

    void drawPath(Path path, Paint paint);

    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    void mo2900drawPointsO7TthRY(int i, List<Offset> list, Paint paint);

    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    void mo2901drawRawPointsO7TthRY(int i, float[] fArr, Paint paint);

    void drawRect(float f, float f2, float f3, float f4, Paint paint);

    void drawRect(Rect rect, Paint paint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint);

    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    void mo2902drawVerticesTPEHhCM(Vertices vertices, int i, Paint paint);

    void enableZ();

    void restore();

    void rotate(float f);

    void save();

    void saveLayer(Rect rect, Paint paint);

    void scale(float f, float f2);

    void skew(float f, float f2);

    void skewRad(float f, float f2);

    void translate(float f, float f2);
}
