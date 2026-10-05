package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import defpackage.AbstractC3787rG;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface Path {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX INFO: renamed from: combine-xh6zSI8, reason: not valid java name */
        public final Path m3275combinexh6zSI8(int i, Path path, Path path2) {
            AbstractC4492zt.h(path, "path1");
            AbstractC4492zt.h(path2, "path2");
            Path Path = AndroidPath_androidKt.Path();
            if (Path.mo2932opN5in7k0(path, path2, i)) {
                return Path;
            }
            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }

    public static final class DefaultImpls {
        @Deprecated
        public static void arcToRad(Path path, Rect rect, float f, float f2, boolean z) {
            AbstractC4492zt.h(rect, "rect");
            AbstractC3787rG.a(path, rect, f, f2, z);
        }

        @Deprecated
        public static void rewind(Path path) {
            AbstractC3787rG.b(path);
        }

        @Deprecated
        /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
        public static void m3277transform58bKbWc(Path path, float[] fArr) {
            AbstractC4492zt.h(fArr, "matrix");
            AbstractC3787rG.c(path, fArr);
        }
    }

    void addArc(Rect rect, float f, float f2);

    void addArcRad(Rect rect, float f, float f2);

    void addOval(Rect rect);

    /* JADX INFO: renamed from: addPath-Uv8p0NA */
    void mo2930addPathUv8p0NA(Path path, long j);

    void addRect(Rect rect);

    void addRoundRect(RoundRect roundRect);

    void arcTo(Rect rect, float f, float f2, boolean z);

    void arcToRad(Rect rect, float f, float f2, boolean z);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    Rect getBounds();

    /* JADX INFO: renamed from: getFillType-Rg-k1Os */
    int mo2931getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    /* JADX INFO: renamed from: op-N5in7k0 */
    boolean mo2932opN5in7k0(Path path, Path path2, int i);

    void quadraticBezierTo(float f, float f2, float f3, float f4);

    void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    void relativeLineTo(float f, float f2);

    void relativeMoveTo(float f, float f2);

    void relativeQuadraticBezierTo(float f, float f2, float f3, float f4);

    void reset();

    void rewind();

    /* JADX INFO: renamed from: setFillType-oQ8Xj4U */
    void mo2933setFillTypeoQ8Xj4U(int i);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo2934transform58bKbWc(float[] fArr);

    /* JADX INFO: renamed from: translate-k-4lQ0M */
    void mo2935translatek4lQ0M(long j);
}
