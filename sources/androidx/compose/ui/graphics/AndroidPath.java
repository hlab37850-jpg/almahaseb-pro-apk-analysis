package androidx.compose.ui.graphics;

import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3787rG;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPath implements Path {
    private final android.graphics.Path internalPath;
    private final android.graphics.Matrix mMatrix;
    private final float[] radii;
    private final RectF rectF;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPath() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean _rectIsValid(Rect rect) {
        if (Float.isNaN(rect.getLeft())) {
            throw new IllegalStateException("Rect.left is NaN");
        }
        if (Float.isNaN(rect.getTop())) {
            throw new IllegalStateException("Rect.top is NaN");
        }
        if (Float.isNaN(rect.getRight())) {
            throw new IllegalStateException("Rect.right is NaN");
        }
        if (Float.isNaN(rect.getBottom())) {
            throw new IllegalStateException("Rect.bottom is NaN");
        }
        return true;
    }

    public static /* synthetic */ void isConvex$annotations() {
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArc(Rect rect, float f, float f2) {
        AbstractC4492zt.h(rect, "oval");
        if (!_rectIsValid(rect)) {
            throw new IllegalStateException("Check failed.");
        }
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.addArc(this.rectF, f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArcRad(Rect rect, float f, float f2) {
        AbstractC4492zt.h(rect, "oval");
        addArc(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect rect) {
        AbstractC4492zt.h(rect, "oval");
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.addOval(this.rectF, android.graphics.Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo2930addPathUv8p0NA(Path path, long j) {
        AbstractC4492zt.h(path, "path");
        android.graphics.Path path2 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect rect) {
        AbstractC4492zt.h(rect, "rect");
        if (!_rectIsValid(rect)) {
            throw new IllegalStateException("Check failed.");
        }
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.addRect(this.rectF, android.graphics.Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect roundRect) {
        AbstractC4492zt.h(roundRect, "roundRect");
        this.rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        this.radii[0] = CornerRadius.m2773getXimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs());
        this.radii[1] = CornerRadius.m2774getYimpl(roundRect.m2848getTopLeftCornerRadiuskKHJgLs());
        this.radii[2] = CornerRadius.m2773getXimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs());
        this.radii[3] = CornerRadius.m2774getYimpl(roundRect.m2849getTopRightCornerRadiuskKHJgLs());
        this.radii[4] = CornerRadius.m2773getXimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs());
        this.radii[5] = CornerRadius.m2774getYimpl(roundRect.m2847getBottomRightCornerRadiuskKHJgLs());
        this.radii[6] = CornerRadius.m2773getXimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs());
        this.radii[7] = CornerRadius.m2774getYimpl(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs());
        this.internalPath.addRoundRect(this.rectF, this.radii, android.graphics.Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void arcTo(Rect rect, float f, float f2, boolean z) {
        AbstractC4492zt.h(rect, "rect");
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.arcTo(this.rectF, f, f2, z);
    }

    @Override // androidx.compose.ui.graphics.Path
    public /* synthetic */ void arcToRad(Rect rect, float f, float f2, boolean z) {
        AbstractC3787rG.a(this, rect, f, f2, z);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.cubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public Rect getBounds() {
        this.internalPath.computeBounds(this.rectF, true);
        RectF rectF = this.rectF;
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo2931getFillTypeRgk1Os() {
        return this.internalPath.getFillType() == android.graphics.Path.FillType.EVEN_ODD ? PathFillType.Companion.m3286getEvenOddRgk1Os() : PathFillType.Companion.m3287getNonZeroRgk1Os();
    }

    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void lineTo(float f, float f2) {
        this.internalPath.lineTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void moveTo(float f, float f2) {
        this.internalPath.moveTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo2932opN5in7k0(Path path, Path path2, int i) {
        android.graphics.Path.Op op;
        AbstractC4492zt.h(path, "path1");
        AbstractC4492zt.h(path2, "path2");
        PathOperation.Companion companion = PathOperation.Companion;
        if (PathOperation.m3291equalsimpl0(i, companion.m3295getDifferenceb3I0S0c())) {
            op = android.graphics.Path.Op.DIFFERENCE;
        } else if (PathOperation.m3291equalsimpl0(i, companion.m3296getIntersectb3I0S0c())) {
            op = android.graphics.Path.Op.INTERSECT;
        } else if (PathOperation.m3291equalsimpl0(i, companion.m3297getReverseDifferenceb3I0S0c())) {
            op = android.graphics.Path.Op.REVERSE_DIFFERENCE;
        } else {
            op = PathOperation.m3291equalsimpl0(i, companion.m3298getUnionb3I0S0c()) ? android.graphics.Path.Op.UNION : android.graphics.Path.Op.XOR;
        }
        android.graphics.Path path3 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path internalPath = ((AndroidPath) path).getInternalPath();
        if (path2 instanceof AndroidPath) {
            return path3.op(internalPath, ((AndroidPath) path2).getInternalPath(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.quadTo(f, f2, f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.rCubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeLineTo(float f, float f2) {
        this.internalPath.rLineTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeMoveTo(float f, float f2) {
        this.internalPath.rMoveTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.rQuadTo(f, f2, f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void rewind() {
        this.internalPath.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo2933setFillTypeoQ8Xj4U(int i) {
        this.internalPath.setFillType(PathFillType.m3282equalsimpl0(i, PathFillType.Companion.m3286getEvenOddRgk1Os()) ? android.graphics.Path.FillType.EVEN_ODD : android.graphics.Path.FillType.WINDING);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    public void mo2934transform58bKbWc(float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
        AndroidMatrixConversions_androidKt.m2910setFromEL8BTi8(this.mMatrix, fArr);
        this.internalPath.transform(this.mMatrix);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo2935translatek4lQ0M(long j) {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
        this.internalPath.transform(this.mMatrix);
    }

    public AndroidPath(android.graphics.Path path) {
        AbstractC4492zt.h(path, "internalPath");
        this.internalPath = path;
        this.rectF = new RectF();
        this.radii = new float[8];
        this.mMatrix = new android.graphics.Matrix();
    }

    public /* synthetic */ AndroidPath(android.graphics.Path path, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? new android.graphics.Path() : path);
    }
}
