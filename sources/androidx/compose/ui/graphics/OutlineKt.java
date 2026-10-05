package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import defpackage.AD;
import defpackage.AbstractC3787rG;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class OutlineKt {
    public static final void addOutline(Path path, Outline outline) {
        AbstractC4492zt.h(path, "<this>");
        AbstractC4492zt.h(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            path.addRect(((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            path.addRoundRect(((Outline.Rounded) outline).getRoundRect());
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new AD();
            }
            AbstractC3787rG.g(path, ((Outline.Generic) outline).getPath(), 0L, 2, null);
        }
    }

    public static final void drawOutline(Canvas canvas, Outline outline, Paint paint) {
        AbstractC4492zt.h(canvas, "<this>");
        AbstractC4492zt.h(outline, "outline");
        AbstractC4492zt.h(paint, "paint");
        if (outline instanceof Outline.Rectangle) {
            canvas.drawRect(((Outline.Rectangle) outline).getRect(), paint);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new AD();
            }
            canvas.drawPath(((Outline.Generic) outline).getPath(), paint);
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                canvas.drawPath(roundRectPath$ui_graphics_release, paint);
            } else {
                canvas.drawRoundRect(rounded.getRoundRect().getLeft(), rounded.getRoundRect().getTop(), rounded.getRoundRect().getRight(), rounded.getRoundRect().getBottom(), CornerRadius.m2773getXimpl(rounded.getRoundRect().m2846getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2774getYimpl(rounded.getRoundRect().m2846getBottomLeftCornerRadiuskKHJgLs()), paint);
            }
        }
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg, reason: not valid java name */
    public static final void m3262drawOutlinehn5TExg(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path;
        AbstractC4492zt.h(drawScope, "$this$drawOutline");
        AbstractC4492zt.h(outline, "outline");
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(drawStyle, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo3464drawRectAsUm42w(brush, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawScope.mo3466drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), f, drawStyle, colorFilter, i);
                return;
            }
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new AD();
            }
            path = ((Outline.Generic) outline).getPath();
        }
        drawScope.mo3460drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m3263drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
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
        m3262drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, colorFilter2, i);
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww, reason: not valid java name */
    public static final void m3264drawOutlinewDX37Ww(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path;
        AbstractC4492zt.h(drawScope, "$this$drawOutline");
        AbstractC4492zt.h(outline, "outline");
        AbstractC4492zt.h(drawStyle, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo3465drawRectnJ9OG0(j, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawScope.mo3467drawRoundRectuAw5IA(j, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), drawStyle, f, colorFilter, i);
                return;
            }
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new AD();
            }
            path = ((Outline.Generic) outline).getPath();
        }
        drawScope.mo3461drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    private static final void drawOutlineHelper(DrawScope drawScope, Outline outline, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3) {
        if (outline instanceof Outline.Rectangle) {
            interfaceC0526Fp.mo13invoke(drawScope, ((Outline.Rectangle) outline).getRect());
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new AD();
            }
            interfaceC0526Fp3.mo13invoke(drawScope, ((Outline.Generic) outline).getPath());
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                interfaceC0526Fp3.mo13invoke(drawScope, roundRectPath$ui_graphics_release);
            } else {
                interfaceC0526Fp2.mo13invoke(drawScope, rounded.getRoundRect());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasSameCornerRadius(RoundRect roundRect) {
        return ((CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) > CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) > CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) > CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) ? 0 : -1)) == 0) && ((CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) > CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) > CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) > CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) ? 0 : -1)) == 0);
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }
}
