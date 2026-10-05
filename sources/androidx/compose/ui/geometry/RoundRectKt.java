package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m2850RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        AbstractC4492zt.h(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m2852RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m2773getXimpl(j), CornerRadius.m2774getYimpl(j));
    }

    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m2853RoundRectsniSvfs(Rect rect, long j) {
        AbstractC4492zt.h(rect, "rect");
        return RoundRect(rect, CornerRadius.m2773getXimpl(j), CornerRadius.m2774getYimpl(j));
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()), CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) && ((double) roundRect.getWidth()) <= ((double) CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs())) * 2.0d && ((double) roundRect.getHeight()) <= ((double) CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs())) * 2.0d;
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        float left = roundRect.getLeft();
        if (!Float.isInfinite(left) && !Float.isNaN(left)) {
            float top = roundRect.getTop();
            if (!Float.isInfinite(top) && !Float.isNaN(top)) {
                float right = roundRect.getRight();
                if (!Float.isInfinite(right) && !Float.isNaN(right)) {
                    float bottom = roundRect.getBottom();
                    if (!Float.isInfinite(bottom) && !Float.isNaN(bottom)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isRect(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return (CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == 0.0f) && (CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) == 0.0f) && ((CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) && (CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) == 0.0f));
    }

    public static final boolean isSimple(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "<this>");
        return CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs());
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f) {
        AbstractC4492zt.h(roundRect, HTML.Attribute.START);
        AbstractC4492zt.h(roundRect2, "stop");
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m2784lerp3Ry4LBc(roundRect.m2848getTopLeftCornerRadiuskKHJgLs(), roundRect2.m2848getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2784lerp3Ry4LBc(roundRect.m2849getTopRightCornerRadiuskKHJgLs(), roundRect2.m2849getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2784lerp3Ry4LBc(roundRect.m2847getBottomRightCornerRadiuskKHJgLs(), roundRect2.m2847getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2784lerp3Ry4LBc(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m2846getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m2854translateUv8p0NA(RoundRect roundRect, long j) {
        AbstractC4492zt.h(roundRect, "$this$translate");
        return new RoundRect(roundRect.getLeft() + Offset.m2798getXimpl(j), roundRect.getTop() + Offset.m2799getYimpl(j), roundRect.getRight() + Offset.m2798getXimpl(j), roundRect.getBottom() + Offset.m2799getYimpl(j), roundRect.m2848getTopLeftCornerRadiuskKHJgLs(), roundRect.m2849getTopRightCornerRadiuskKHJgLs(), roundRect.m2847getBottomRightCornerRadiuskKHJgLs(), roundRect.m2846getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final RoundRect RoundRect(Rect rect, float f, float f2) {
        AbstractC4492zt.h(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }
}
