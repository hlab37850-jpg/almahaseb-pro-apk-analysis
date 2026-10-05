package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0437Ea;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class OutlineResolver {
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private androidx.compose.ui.graphics.Outline calculatedOutline;
    private Density density;
    private boolean isSupportedOutline;
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Shape shape;
    private long size;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(Density density) {
        AbstractC4492zt.h(density, "density");
        this.density = density;
        this.isSupportedOutline = true;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        Size.Companion companion = Size.Companion;
        this.size = companion.m2876getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m2814getZeroF1C5BW0();
        this.rectSize = companion.m2876getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    /* JADX INFO: renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m4520isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        return roundRect != null && RoundRectKt.isSimple(roundRect) && roundRect.getLeft() == Offset.m2798getXimpl(j) && roundRect.getTop() == Offset.m2799getYimpl(j) && roundRect.getRight() == Offset.m2798getXimpl(j) + Size.m2867getWidthimpl(j2) && roundRect.getBottom() == Offset.m2799getYimpl(j) + Size.m2864getHeightimpl(j2) && CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs()) == f;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m2814getZeroF1C5BW0();
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m2867getWidthimpl(j) <= 0.0f || Size.m2864getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.ui.graphics.Outline outlineMo216createOutlinePq9zytI = this.shape.mo216createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = outlineMo216createOutlinePq9zytI;
            if (outlineMo216createOutlinePq9zytI instanceof androidx.compose.ui.graphics.Outline.Rectangle) {
                updateCacheWithRect(((androidx.compose.ui.graphics.Outline.Rectangle) outlineMo216createOutlinePq9zytI).getRect());
            } else if (outlineMo216createOutlinePq9zytI instanceof androidx.compose.ui.graphics.Outline.Rounded) {
                updateCacheWithRoundRect(((androidx.compose.ui.graphics.Outline.Rounded) outlineMo216createOutlinePq9zytI).getRoundRect());
            } else if (outlineMo216createOutlinePq9zytI instanceof androidx.compose.ui.graphics.Outline.Generic) {
                updateCacheWithPath(((androidx.compose.ui.graphics.Outline.Generic) outlineMo216createOutlinePq9zytI).getPath());
            }
        }
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            Outline outline = this.cachedOutline;
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((AndroidPath) path).getInternalPath());
            this.usePathForClip = !this.cachedOutline.canClip();
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(AbstractC1210aB.c(rect.getLeft()), AbstractC1210aB.c(rect.getTop()), AbstractC1210aB.c(rect.getRight()), AbstractC1210aB.c(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float fM2773getXimpl = CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(AbstractC1210aB.c(roundRect.getLeft()), AbstractC1210aB.c(roundRect.getTop()), AbstractC1210aB.c(roundRect.getRight()), AbstractC1210aB.c(roundRect.getBottom()), fM2773getXimpl);
            this.roundedCornerRadius = fM2773getXimpl;
            return;
        }
        Path Path = this.cachedRrectPath;
        if (Path == null) {
            Path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = Path;
        }
        Path.reset();
        Path.addRoundRect(roundRect);
        updateCacheWithPath(Path);
    }

    public final void clipToOutline(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        Path clipPath = getClipPath();
        if (clipPath != null) {
            AbstractC0437Ea.m(canvas, clipPath, 0, 2, null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f <= 0.0f) {
            AbstractC0437Ea.n(canvas, Offset.m2798getXimpl(this.rectTopLeft), Offset.m2799getYimpl(this.rectTopLeft), Offset.m2798getXimpl(this.rectTopLeft) + Size.m2867getWidthimpl(this.rectSize), Offset.m2799getYimpl(this.rectTopLeft) + Size.m2864getHeightimpl(this.rectSize), 0, 16, null);
            return;
        }
        Path Path = this.tmpPath;
        RoundRect roundRect = this.tmpRoundRect;
        if (Path == null || !m4520isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
            RoundRect roundRectM2852RoundRectgG7oq9Y = RoundRectKt.m2852RoundRectgG7oq9Y(Offset.m2798getXimpl(this.rectTopLeft), Offset.m2799getYimpl(this.rectTopLeft), Offset.m2798getXimpl(this.rectTopLeft) + Size.m2867getWidthimpl(this.rectSize), Offset.m2799getYimpl(this.rectTopLeft) + Size.m2864getHeightimpl(this.rectSize), CornerRadiusKt.CornerRadius$default(this.roundedCornerRadius, 0.0f, 2, null));
            if (Path == null) {
                Path = AndroidPath_androidKt.Path();
            } else {
                Path.reset();
            }
            Path.addRoundRect(roundRectM2852RoundRectgG7oq9Y);
            this.tmpRoundRect = roundRectM2852RoundRectgG7oq9Y;
            this.tmpPath = Path;
        }
        AbstractC0437Ea.m(canvas, Path, 0, 2, null);
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final Outline getOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    /* JADX INFO: renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m4521isInOutlinek4lQ0M(long j) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final boolean update(Shape shape, float f, boolean z, float f2, LayoutDirection layoutDirection, Density density) {
        AbstractC4492zt.h(shape, "shape");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        this.cachedOutline.setAlpha(f);
        boolean zD = AbstractC4492zt.d(this.shape, shape);
        boolean z2 = !zD;
        if (!zD) {
            this.shape = shape;
            this.cacheIsDirty = true;
        }
        boolean z3 = z || f2 > 0.0f;
        if (this.outlineNeeded != z3) {
            this.outlineNeeded = z3;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            this.cacheIsDirty = true;
        }
        if (!AbstractC4492zt.d(this.density, density)) {
            this.density = density;
            this.cacheIsDirty = true;
        }
        return z2;
    }

    /* JADX INFO: renamed from: update-uvyYCjk, reason: not valid java name */
    public final void m4522updateuvyYCjk(long j) {
        if (Size.m2863equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        this.cacheIsDirty = true;
    }
}
