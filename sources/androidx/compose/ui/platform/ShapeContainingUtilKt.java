package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import defpackage.AD;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
    }

    public static final boolean isInOutline(Outline outline, float f, float f2, Path path, Path path2) {
        AbstractC4492zt.h(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f2);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f2, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f2, path, path2);
        }
        throw new AD();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f2, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f2, path, path2);
    }

    private static final boolean isInPath(Path path, float f, float f2, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        path2.addRect(rect);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo2932opN5in7k0(path, path2, PathOperation.Companion.m3296getIntersectb3I0S0c());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f, float f2) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f2 && f2 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f2, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f2 < roundRect.getTop() || f2 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect(roundRect);
            return isInPath(Path, f, f2, path, path2);
        }
        float fM2773getXimpl = CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float fM2774getYimpl = CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs());
        float fM2774getYimpl2 = CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs());
        float fM2773getXimpl2 = CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f < fM2773getXimpl && f2 < fM2774getYimpl) {
            return m4523isWithinEllipseVE1yxkc(f, f2, roundRect.m2848getTopLeftCornerRadiuskKHJgLs(), fM2773getXimpl, fM2774getYimpl);
        }
        if (f < fM2773getXimpl2 && f2 > bottom2) {
            return m4523isWithinEllipseVE1yxkc(f, f2, roundRect.m2846getBottomLeftCornerRadiuskKHJgLs(), fM2773getXimpl2, bottom2);
        }
        if (f > right && f2 < fM2774getYimpl2) {
            return m4523isWithinEllipseVE1yxkc(f, f2, roundRect.m2849getTopRightCornerRadiuskKHJgLs(), right, fM2774getYimpl2);
        }
        if (f <= right2 || f2 <= bottom) {
            return true;
        }
        return m4523isWithinEllipseVE1yxkc(f, f2, roundRect.m2847getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m4523isWithinEllipseVE1yxkc(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fM2773getXimpl = CornerRadius.m2773getXimpl(j);
        float fM2774getYimpl = CornerRadius.m2774getYimpl(j);
        return ((f5 * f5) / (fM2773getXimpl * fM2773getXimpl)) + ((f6 * f6) / (fM2774getYimpl * fM2774getYimpl)) <= 1.0f;
    }
}
