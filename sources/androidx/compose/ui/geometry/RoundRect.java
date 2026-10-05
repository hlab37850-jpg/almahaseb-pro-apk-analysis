package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class RoundRect {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final RoundRect Zero = RoundRectKt.m2852RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m2783getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ void getZero$annotations() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, AbstractC0419Di abstractC0419Di) {
        this(f, f2, f3, f4, j, j2, j3, j4);
    }

    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    private final float minRadius(float f, float f2, float f3, float f4) {
        float f5 = f2 + f3;
        return (f5 <= f4 || f5 == 0.0f) ? f : Math.min(f, f4 / f5);
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float fMinRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m2774getYimpl(this.bottomLeftCornerRadius), CornerRadius.m2774getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m2773getXimpl(this.topLeftCornerRadius), CornerRadius.m2773getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m2774getYimpl(this.topRightCornerRadius), CornerRadius.m2774getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m2773getXimpl(this.bottomRightCornerRadius), CornerRadius.m2773getXimpl(this.bottomLeftCornerRadius), getWidth());
        RoundRect roundRect2 = new RoundRect(this.left * fMinRadius, this.top * fMinRadius, this.right * fMinRadius, this.bottom * fMinRadius, CornerRadiusKt.CornerRadius(CornerRadius.m2773getXimpl(this.topLeftCornerRadius) * fMinRadius, CornerRadius.m2774getYimpl(this.topLeftCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2773getXimpl(this.topRightCornerRadius) * fMinRadius, CornerRadius.m2774getYimpl(this.topRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2773getXimpl(this.bottomRightCornerRadius) * fMinRadius, CornerRadius.m2774getYimpl(this.bottomRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2773getXimpl(this.bottomLeftCornerRadius) * fMinRadius, CornerRadius.m2774getYimpl(this.bottomLeftCornerRadius) * fMinRadius), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component5-kKHJgLs, reason: not valid java name */
    public final long m2840component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: component6-kKHJgLs, reason: not valid java name */
    public final long m2841component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: component7-kKHJgLs, reason: not valid java name */
    public final long m2842component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: component8-kKHJgLs, reason: not valid java name */
    public final long m2843component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m2844containsk4lQ0M(long j) {
        float fM2798getXimpl;
        float fM2799getYimpl;
        float fM2773getXimpl;
        float fM2774getYimpl;
        if (Offset.m2798getXimpl(j) < this.left || Offset.m2798getXimpl(j) >= this.right || Offset.m2799getYimpl(j) < this.top || Offset.m2799getYimpl(j) >= this.bottom) {
            return false;
        }
        RoundRect roundRectScaledRadiiRect = scaledRadiiRect();
        if (Offset.m2798getXimpl(j) < this.left + CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius) && Offset.m2799getYimpl(j) < this.top + CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius)) {
            fM2798getXimpl = (Offset.m2798getXimpl(j) - this.left) - CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM2799getYimpl = (Offset.m2799getYimpl(j) - this.top) - CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM2773getXimpl = CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM2774getYimpl = CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m2798getXimpl(j) > this.right - CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.topRightCornerRadius) && Offset.m2799getYimpl(j) < this.top + CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.topRightCornerRadius)) {
            fM2798getXimpl = (Offset.m2798getXimpl(j) - this.right) + CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM2799getYimpl = (Offset.m2799getYimpl(j) - this.top) - CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM2773getXimpl = CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM2774getYimpl = CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m2798getXimpl(j) > this.right - CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius) && Offset.m2799getYimpl(j) > this.bottom - CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius)) {
            fM2798getXimpl = (Offset.m2798getXimpl(j) - this.right) + CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM2799getYimpl = (Offset.m2799getYimpl(j) - this.bottom) + CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM2773getXimpl = CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM2774getYimpl = CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
        } else {
            if (Offset.m2798getXimpl(j) >= this.left + CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius) || Offset.m2799getYimpl(j) <= this.bottom - CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius)) {
                return true;
            }
            fM2798getXimpl = (Offset.m2798getXimpl(j) - this.left) - CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM2799getYimpl = (Offset.m2799getYimpl(j) - this.bottom) + CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM2773getXimpl = CornerRadius.m2773getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM2774getYimpl = CornerRadius.m2774getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
        }
        float f = fM2798getXimpl / fM2773getXimpl;
        float f2 = fM2799getYimpl / fM2774getYimpl;
        return (f * f) + (f2 * f2) <= 1.0f;
    }

    /* JADX INFO: renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m2845copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        return new RoundRect(f, f2, f3, f4, j, j2, j3, j4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m2772equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m2772equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m2772equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m2772equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2846getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2847getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2848getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2849getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.m2775hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m2775hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m2775hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m2775hashCodeimpl(this.bottomLeftCornerRadius);
    }

    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m2772equalsimpl0(j, j2) || !CornerRadius.m2772equalsimpl0(j2, j3) || !CornerRadius.m2772equalsimpl0(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m2779toStringimpl(j)) + ", topRight=" + ((Object) CornerRadius.m2779toStringimpl(j2)) + ", bottomRight=" + ((Object) CornerRadius.m2779toStringimpl(j3)) + ", bottomLeft=" + ((Object) CornerRadius.m2779toStringimpl(j4)) + ')';
        }
        if (CornerRadius.m2773getXimpl(j) == CornerRadius.m2774getYimpl(j)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2773getXimpl(j), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2773getXimpl(j), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2774getYimpl(j), 1) + ')';
    }

    private RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, AbstractC0419Di abstractC0419Di) {
        this(f, f2, f3, f4, (i & 16) != 0 ? CornerRadius.Companion.m2783getZerokKHJgLs() : j, (i & 32) != 0 ? CornerRadius.Companion.m2783getZerokKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.Companion.m2783getZerokKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.Companion.m2783getZerokKHJgLs() : j4, null);
    }
}
