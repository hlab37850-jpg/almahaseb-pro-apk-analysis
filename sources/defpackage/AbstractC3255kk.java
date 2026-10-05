package defpackage;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;

/* JADX INFO: renamed from: kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3255kk {
    static {
        DrawScope.Companion companion = DrawScope.Companion;
    }

    public static /* synthetic */ void A(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo3455drawImagegbVJVH8(imageBitmap, (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void B(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo3456drawLine1RTmtNc(brush, j, j2, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.Companion.m3558getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i2);
    }

    public static /* synthetic */ void C(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo3457drawLineNGM6Ib0(j, j2, j3, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.Companion.m3558getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i2);
    }

    public static /* synthetic */ void D(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j;
        drawScope.mo3458drawOvalAsUm42w(brush, jM2814getZeroF1C5BW0, (i2 & 4) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void E(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j2;
        drawScope.mo3459drawOvalnJ9OG0(j, jM2814getZeroF1C5BW0, (i2 & 4) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void F(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        float f2 = (i2 & 4) != 0 ? 1.0f : f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo3460drawPathGBMwjPU(path, brush, f2, drawStyle2, colorFilter2, i);
    }

    public static /* synthetic */ void G(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        drawScope.mo3461drawPathLG529CI(path, j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void H(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo3462drawPointsF8ZwMP8(list, i, j, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.Companion.m3356getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i3);
    }

    public static /* synthetic */ void I(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo3463drawPointsGsft0Ws(list, i, brush, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.Companion.m3356getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i3);
    }

    public static /* synthetic */ void J(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j;
        drawScope.mo3464drawRectAsUm42w(brush, jM2814getZeroF1C5BW0, (i2 & 4) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void K(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j2;
        drawScope.mo3465drawRectnJ9OG0(j, jM2814getZeroF1C5BW0, (i2 & 4) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void L(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j;
        drawScope.mo3466drawRoundRectZuiqVtQ(brush, jM2814getZeroF1C5BW0, (i2 & 4) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? CornerRadius.Companion.m2783getZerokKHJgLs() : j3, (i2 & 16) != 0 ? 1.0f : f, (i2 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void M(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j2;
        drawScope.mo3467drawRoundRectuAw5IA(j, jM2814getZeroF1C5BW0, (i2 & 4) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? CornerRadius.Companion.m2783getZerokKHJgLs() : j4, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static void a(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        AbstractC4492zt.h(imageBitmap, "image");
        AbstractC4492zt.h(drawStyle, "style");
        z(drawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, 0, 512, null);
    }

    public static long b(DrawScope drawScope) {
        return SizeKt.m2877getCenteruvyYCjk(drawScope.getDrawContext().mo3475getSizeNHjbRc());
    }

    public static long c(DrawScope drawScope) {
        return drawScope.getDrawContext().mo3475getSizeNHjbRc();
    }

    public static long d(DrawScope drawScope, long j, long j2) {
        return SizeKt.Size(Size.m2867getWidthimpl(j) - Offset.m2798getXimpl(j2), Size.m2864getHeightimpl(j) - Offset.m2799getYimpl(j2));
    }

    public static /* synthetic */ void u(DrawScope drawScope, Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j;
        drawScope.mo3449drawArcillE91I(brush, f, f2, z, jM2814getZeroF1C5BW0, (i2 & 32) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j2, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void v(DrawScope drawScope, long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jM2814getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.Companion.m2814getZeroF1C5BW0() : j2;
        drawScope.mo3450drawArcyD3GUKo(j, f, f2, z, jM2814getZeroF1C5BW0, (i2 & 32) != 0 ? d(drawScope, drawScope.mo3469getSizeNHjbRc(), jM2814getZeroF1C5BW0) : j3, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void w(DrawScope drawScope, Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo3451drawCircleV9BoPsw(brush, (i2 & 2) != 0 ? Size.m2866getMinDimensionimpl(drawScope.mo3469getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo3468getCenterF1C5BW0() : j, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void x(DrawScope drawScope, long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        drawScope.mo3452drawCircleVaOC9Bg(j, (i2 & 2) != 0 ? Size.m2866getMinDimensionimpl(drawScope.mo3469getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo3468getCenterF1C5BW0() : j2, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void y(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long jM5288getZeronOccac = (i2 & 2) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j;
        long jIntSize = (i2 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo3453drawImage9jGpkUE(imageBitmap, jM5288getZeronOccac, jIntSize, (i2 & 8) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j3, (i2 & 16) != 0 ? jIntSize : j4, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 128) != 0 ? null : colorFilter, (i2 & 256) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i);
    }

    public static /* synthetic */ void z(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jM5288getZeronOccac = (i3 & 2) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j;
        long jIntSize = (i3 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo3454drawImageAZ2fEMs(imageBitmap, jM5288getZeronOccac, jIntSize, (i3 & 8) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j3, (i3 & 16) != 0 ? jIntSize : j4, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i, (i3 & 512) != 0 ? DrawScope.Companion.m3500getDefaultFilterQualityfv9h1I() : i2);
    }
}
